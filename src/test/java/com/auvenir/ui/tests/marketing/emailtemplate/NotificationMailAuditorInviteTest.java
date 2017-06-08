package com.auvenir.ui.tests.marketing.emailtemplate;

import com.auvenir.ui.services.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.signup.AuditorSignUpService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorInviteTest extends AbstractTest {

    AuditorSignUpService auditorSignUpService;
    AuditorEngagementService auditorEngagementService;
    AuditorNewEngagementService auditorNewEngagementService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;
    AuditorTodoListService auditorTodoListService;
    AuditorCreateToDoService auditorCreateToDoService;
    MarketingService marketingService;
    ClientService clientService;

    @Test(priority = 1, description = "Invite a client to Engagement")
    public void openAuvenir() {

    }

    /**
     * This test case duplicate with test case in MailAuditorInviteClientTest
     * Pending
     * Update by: Duong Nguyen
     */

    @Test(priority = 2, description = "Verify template of Notification Mail when SO is invited ")
    public void verifyNotificationMailAuditorInvite() {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        String engagementName = "Engagement";
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        try{
            String clientId = GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_GMAIL");
            marketingService.setPrefixProtocol("http://");
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithUserNamePassword("auvenirinfo@gmail.com", "Changeit@123");

            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, "", "Company Auvenir");
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorTodoListService.verifyTodoListPage();

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient("Titan client", clientId, "Leader");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify DB update field completed is true when archive mart as completed.",
                    LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify DB update field completed is true when archive mart as completed.",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
