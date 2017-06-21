package com.auvenir.ui.tests.marketing;


import com.auvenir.ui.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
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
public class MailAccessTest extends AbstractTest {

    private MarketingService marketingService;
    private GmailLoginService gmailLoginService;
    private AdminService adminService;
    private AuditorSignUpService auditorSignUpService;
    private EmailTemplateService emailTemplateService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    private AuditorTodoListService auditorTodoListService;
    private ClientService clientService;
    private AuditorCreateToDoService auditorCreateToDoService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;
    AuditorNewEngagementService auditorNewEngagementService;


    //MailAccessTest
    @Test(priority = 1, enabled = true, description = "Verify Auditor sign up and Admin set status to On-boarding")
    public void verifyAdminGiveAuditorAccess() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        String auditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
        String strAdminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Admin");
        String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "PasswordAdmin");
        try {
            gmailLoginService.deleteAllExistedEmail(auditorID, password);
            auditorSignUpService.deleteUserUsingApi(auditorID);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), auditorID);
            getLogger().info("Auditor sign up..");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser("Auditor Test", auditorID, password);
            getLogger().info("Admin gives Auditor access..");
            marketingService.clickLoginButton();
            marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
            getLogger().info("Admin find auditor email and status to On boarding..");
//        adminService.verifyAuditorRowOnAdminUserTable("AUDITOR", "auvenirtestor@gmail.com", "06/7/2017", "Wait listed");
            adminService.changeTheStatusUser(auditorID, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor sign up and Admin set status to On-boarding.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor sign up and Admin set status to On-boarding.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify template of Active Email")
    public void verifyActiveEmailTemplate() throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        String auditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
        try {
            getLogger().info("Auditor open Email and verify it.. ");
            getLogger().info("Auditor login his email to verify Welcome email template");
            gmailLoginService.gmailLogin(auditorID, password);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyActiveEmailTemplateContent();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify template of Active Email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify template of Active Email.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /*
    Vien.Pham refactor
     */
    // MailAuditorInviteClientTest
    @Test(priority = 1, enabled = true, description = "Verify Auditor sign up and Active")
    public void verifyAuditorSignUp() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        String auditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
        String clientID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Client");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");

        try {
            getLogger().info("Delete user and client email before..");
            auditorSignUpService.deleteUserUsingApi(auditorID);
            auditorSignUpService.deleteUserUsingApi( clientID);
            gmailLoginService.deleteAllExistedEmail(clientID, password);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), auditorID);
            getLogger().info("Auditor sign up..");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser("Auditor Test",  auditorID, password);
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
        String auditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
        String clientID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Client");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
        try {
            auditorSignUpService.deleteUserUsingApi( clientID);
            getLogger().info("Auditor log in..");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithNewUserRole( auditorID, password);
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
        String clientID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Client");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
        try {
            getLogger().info("Auditor open Email and verify it.. ");
            getLogger().info("Auditor login his email to verify Welcome email template");
            gmailLoginService.gmailLogin(clientID, password);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyAuditorInviteClientEmail();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify template of Invite Client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify template of Invite Client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    //MailAuditorJoinTest
    /**
     *  Refactor by Duong Nguyen
     *  Date: 7/6/2017
     */
    @Test(priority = 1, description = "Open gmail to verify content mail")
    public void openGmailforAuditorRegister(){
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        try{
            String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
            String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
            auditorSignUpService.setPrefixProtocol(httpProtocol);
            auditorSignUpService.deleteUserUsingApi(auditorId);
            auditorSignUpService.deleteUserUsingMongoDB(auditorId);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser("Auditor Test", auditorId, password);
            gmailLoginService.verifyOpenGmailIndexRegisterAccount(auditorId, password);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify content mail.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify content mail.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, description = "Verify template mail : Auditor joins and is on Waitlist")
    public void verifyMailAuditorJoin(){
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        try{
            String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
            String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
            auditorSignUpService.setPrefixProtocol(httpProtocol);
            auditorSignUpService.deleteUserUsingApi(auditorId);
            auditorSignUpService.deleteUserUsingMongoDB(auditorId);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser("Auditor Test", auditorId, password);
            gmailLoginService.verifyOpenGmailIndexRegisterAccount(auditorId, password);
            emailTemplateService.verifyWaitListPageContent();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify template mail : Auditor joins and is on Waitlist.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify template mail : Auditor joins and is on Waitlist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    // NotificationMailAuditorInviteTest
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
        String engagementName = "Engagement-Test";
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        try{
            String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
            String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Client");
            String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");

            marketingService.setPrefixProtocol("http://");
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithUserNamePassword(auditorId, password);

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
