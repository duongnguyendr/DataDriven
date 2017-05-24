package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AuditorCreateToDoService;
import com.auvenir.ui.services.AuditorEditCategoryService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by vien.pham on 5/22/2017.
 */
public class PLAT2326_230_VienOwner extends AbstractTest {

    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEditCategoryService auditorEditCategoryService;

    @Test(priority = 1, enabled = true, description = "Verify Todos Textbox")
    public void verifyTodosTextBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyTodosTextBox();
            NXGReports.addStep("Verify Todos Textbox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Todos Textbox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = false, description = "Verify Category Combo box")
    public void verifyCategoryComboBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.verifyCategoryComboBox();
            NXGReports.addStep("Verify Todos Textbox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Todos Textbox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}


