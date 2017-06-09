package com.auvenir.ui.tests.marketing.emailtemplate;

import com.auvenir.ui.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.marketing.mailtemplate.*;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.emailtemplate.EmailTemplateService;
import com.auvenir.ui.services.marketing.signup.AuditorSignUpService;
import com.auvenir.ui.tests.AbstractTest;
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
        marketingService = new MarketingService(getLogger(), getDriver());
        getLogger().info("Delete user before..");
        auditorSignUpService.deleteUserUsingApi("auvenirtestor@gmail.com");
        auditorSignUpService.deleteUserUsingApi("clientauvenir@gmail.com");
        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), "auvenirtestor@gmail.com");
        getLogger().info("Auditor sign up..");
        auditorSignUpService.setPrefixProtocol("http://");
        auditorSignUpService.goToBaseURL();
        auditorSignUpService.verifyRegisterNewAuditorUser("Vien Pham", "auvenirtestor@gmail.com", "Change@123");
        auditorSignUpService.updateUserActiveUsingAPI("auvenirtestor@gmail.com");
        auditorSignUpService.updateUserActiveUsingMongoDB("auvenirtestor@gmail.com");
    }

    @Test(priority = 2, enabled = true, description = "Verify Auditor login and invite client..")
    public void verifyAuditorInviteClient() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        try {
            getLogger().info("Auditor log in..");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithNewUserRole("auvenirtestor@gmail.com", "Change@123");
//            auditorEngagementService.viewEngagementDetailsPage("New World");
            auditorEngagementService.createAndSelectNewEnagement("New World","","Company");
            auditorDetailsEngagementPage.verifyDetailsEngagementPage("New World");
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
        clientService.inviteNewClient("Titan client", "clientauvenir@gmail.com", "Leader");
        clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");
        } catch (Exception e) {
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify template of Invite Client")
    public void verifyClentInviteEmailTemplate() throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        try {
            getLogger().info("Auditor open Email and verify it.. ");
            getLogger().info("Auditor login his email to verify Welcome email template");
            gmailLoginService.gmailLogin("clientauvenir@gmail.com", "Change@123");
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyActiveEmailTemplateContent();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify template of Invite Client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify template of Invite Client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


//
//
//    @Test(priority = 2, description = "Verify template of mail: Auditor Invite Client")
//    public void verifyMailAuditorInviteClient() {
//        mailAuditorInviteClientPO = new MailAuditorInviteClientPO(getDriver());
//        mailAuditorInviteClientPO.verifyPageContent();
//    }


}
