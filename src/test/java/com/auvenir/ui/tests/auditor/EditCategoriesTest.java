package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by vien.pham on 5/31/2017.
 */
public class EditCategoriesTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEditCategoryService auditorEditCategoryService;


    @Test(priority = 44, enabled = true, description = "Verify Remove function")
    public void verifyRemoveFunctionAtTodoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategory("vienpham", "cate2", "cate3");
            auditorCreateToDoService.navigateToEditNewCategory();
            getLogger().info("Verifying remove 1 item..");
            auditorEditCategoryService.removeItem(1);
            getLogger().info("Verifying remove multi items..");
            auditorEditCategoryService.removeItem(2);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Remove function.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Remove Function.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
