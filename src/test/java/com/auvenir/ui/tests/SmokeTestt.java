package com.auvenir.ui.tests;

import com.auvenir.ui.services.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.emailtemplate.EmailTemplateService;
import com.auvenir.ui.services.marketing.signup.AuditorSignUpService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

/**
 * Created by huy.huynh on 13/06/2017.
 * SmokeTest for R2
 */
public class SmokeTestt extends AbstractTest {
    private AdminService adminService;
    private AuvenirService auvenirService;
    private AuditorService auditorService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private ClientService clientService;
    AuditorCreateToDoService auditorCreateToDoService;
    private GmailLoginService gmailLoginService;
    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;
    private EmailTemplateService emailTemplateService;
    private ClientSignUpService clientSignUpService;
    private ClientEngagementService clientEngagementService;

    private String adminId, auditorId, clientId;
    private String sData[];
    private String testCaseId;
    private SimpleDateFormat dateFormat;
    private String timeStamp;

    @Test(priority = 1, enabled = true, description = "To verify admin is able to login")
    public void verifyAdminLogin() {
        getLogger().info("Verify admin is able to login.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            adminId = adminId.replace("chr.", "");
            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify admin is able to login.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 6, enabled = true, description = "Auditor create new Engagament (simple engagement)")
    public void verifyCreateSimpleEngagement() {
        getLogger().info("Auditor create new Engagament (simple engagement).");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        try {
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
            //auditorId= auditorId.replace("chr.","");
            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();

            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement" + timeStamp);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 8, enabled = true, description = "Auditor inviting a client")
    public void verifyAuditorInvitingTheClient() {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        try {
            clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            adminId = adminId.replace("chr.", "");
            auditorId = auditorId.replace("chr.", "");
            clientId = clientId.replace("chr.", "");

            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
            //need precondition for save engagement name, and delete this engagement or client on acl
            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement" + timeStamp);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient("Titan client", clientId, "Leader");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");
            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Pending");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 9, enabled = true, description = "Admin change the status of the client to OnBoarding"/*, dependsOnMethods = {"verifyAuditorInvitingTheClient"}*/)
    public void verifyChangeTheStatusClientToOnBoarding() {
        getLogger().info("Verify change the status of the client to OnBoarding.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
            adminId = adminId.replace("chr.", "");
            clientId = clientId.replace("chr.", "");
            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.changeTheStatusUser(clientId, "Onboarding");
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify change the status of the client to OnBoarding.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify change the status of the client to OnBoarding.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 14, enabled = true, description = "Verify create to-do pages")
    public void verifyCreateTodoPage() throws  Exception{
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        try{
            String userId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User4", "Auditor");
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("Engagement");
            auditorCreateToDoService.createToDoPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify create, assign, request, delete to-do.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify create, assign, request, delete to-do.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 10, enabled = true, description = "Client logs in and OnBoarding page is displayed"/*, dependsOnMethods = {"verifyChangeTheStatusClientToOnBoarding"}*/)
    public void verifyClientLogsInAndActive() {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientEngagementService= new ClientEngagementService(getLogger(),getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
            adminId = adminId.replace("chr.", "");
            clientId = clientId.replace("chr.", "");
            String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
            System.out.println("clientEmailPassword = " + clientEmailPassword);
            MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), clientId, "status", "ONBOARDING");

            gmailLoginService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.clickOnboardingInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm("0123456789");
            clientSignUpService.fillUpBusinessForm("Titancorpvn");
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm("Testpassword1!");
            clientEngagementService.verifyNavigatedToClientEngagementPage();

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Active");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }
}
