package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AuditorDetailsEngagementService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.AuditorNewEngagementService;
import com.auvenir.ui.services.AuditorTodoListService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */



public class AuditorTodoListTest extends AbstractTest {
    AuditorEngagementService auditorEngagementService;
    AuditorNewEngagementService auditorNewEngagementService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;
    AuditorTodoListService auditorTodoListService;

    @Test(priority=1,enabled=true, description="Verify Footer in Auditor Engagements page.")
    public void verifyAuditorTodoListPage() throws Exception
    {
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try
        {

            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEngagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement01","","");
            auditorEngagementService.verifyCreatedEngagementRendered("engagement01");
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyEmptyTodoList();


            auditorEngagementService.verifyAuditorFooter();
            NXGReports.addStep("Verify Empty Todo List Page.", LogAs.PASSED, null);


        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify Empty Todo List Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}




