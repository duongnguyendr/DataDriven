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

    @Test(priority=1,enabled=true, description="Verify Auditor Todo List page.")
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
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement01","","");
            //will implement later, current we can not navigate engagment by name
            // auditorEngagementService.verifyCreatedEngagementRendered("engagement01");            
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyEmptyTodoList();
            auditorTodoListService.verifyTodoListPage();
           // verifyFooter error
            auditorEngagementService.verifyAuditorFooter();
            NXGReports.addStep("Verify Auditor Todo List page.", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify Auditor Todo List page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            System.out.println(e);
            throw e;
        }
    }

}




