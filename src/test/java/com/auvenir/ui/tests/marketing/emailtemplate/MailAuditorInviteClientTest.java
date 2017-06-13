package com.auvenir.ui.tests.marketing.emailtemplate;

import com.auvenir.ui.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.marketing.mailtemplate.*;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.emailtemplate.EmailTemplateService;
import com.auvenir.ui.services.marketing.signup.AuditorSignUpService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class MailAuditorInviteClientTest extends AbstractTest {

    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;
    private MailAuditorInviteClientPO mailAuditorInviteClientPO;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    private GmailLoginService gmailLoginService;
    private EmailTemplateService emailTemplateService;
    private AuditorTodoListService auditorTodoListService;
    private ClientService clientService;

    @Test(priority = 1, enabled = true, description = "Verify Auditor sign up and Active")
    public void verifyAuditorSignUp() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        String auditorID = GenericService.getTestDataFromExcel("LoginData", "Valid User3", "Auditor");
        String clientID = GenericService.getTestDataFromExcel("LoginData", "Valid User3", "Client");

        try {
            getLogger().info("Delete user and client email before..");
            auditorSignUpService.deleteUserUsingApi(auditorID);
            auditorSignUpService.deleteUserUsingApi( clientID);
            gmailLoginService.deleteAllExistedEmail(clientID, "Change@123");
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), auditorID);
            getLogger().info("Auditor sign up..");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser("Vien Pham",  auditorID,"Change@123");
            auditorSignUpService.updateUserActiveUsingAPI( auditorID);
            auditorSignUpService.updateUserActiveUsingMongoDB( auditorID);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor sign up and Active.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor sign up and Active.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify Auditor login and invite client..")
    public void verifyAuditorInviteClient() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        String auditorID = GenericService.getTestDataFromExcel("LoginData", "Valid User3", "Auditor");
        String clientID = GenericService.getTestDataFromExcel("LoginData", "Valid User3", "Client");
        try {
            auditorSignUpService.deleteUserUsingApi( clientID);
            getLogger().info("Auditor log in..");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithNewUserRole( auditorID, "Change@123");
            auditorEngagementService.createAndSelectNewEnagement("New World", "", "Company");
            auditorDetailsEngagementPage.verifyDetailsEngagementPage("New World");
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient("Titan client", clientID, "Leader");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor login and invite client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor login and invite client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify template of Invite Client")
    public void verifyClentInviteEmailTemplate() throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        String clientID = GenericService.getTestDataFromExcel("LoginData", "Valid User3", "Client");
        try {
            getLogger().info("Auditor open Email and verify it.. ");
            getLogger().info("Auditor login his email to verify Welcome email template");
            gmailLoginService.gmailLogin(clientID, "Change@123");
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyAuditorInviteClientEmail();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify template of Invite Client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify template of Invite Client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
/*


Vien.Pham refactor
 */


}
