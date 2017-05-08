package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.AuditorNewEngagementService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by hai.nguyen on 5/8/2017.
 */

public class TodoListTest extends AbstractTest {
    AuditorEngagementService auditorEngagementService;
    AuditorNewEngagementService auditorNewEngagementService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;
    AuditorTodoListService auditorTodoListService;

    @Test(priority=1,enabled=true, description="Verify Footer in Auditor Engagements page.")
    public void verifyEmptyTodoListPage() throws Exception
    {
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        auditorDetailsEngagementService = new  AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        String getTokenUrl =   GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try
        {
            //logCurrentStepStart();
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagement("engagement01","");
            auditorEngagementService.verifyEngagementRendered("engagement01");
            auditorEngagementService.viewDetailsEngagement("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage();
            auditorDetailsEngagementService.clickTodoListTab();
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyHeader();








            NXGReports.addStep("Verify footer in Auditor Engagement page.", LogAs.PASSED, null);
            // logCurrentStepEnd();

        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify footer in Auditor Engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
