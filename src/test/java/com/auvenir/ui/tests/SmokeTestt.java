package com.auvenir.ui.tests;

import com.auvenir.ui.services.*;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientSignUpService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.MarketingService;
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
    AuditorEditCategoryService auditorEditCategoryService;
    private GmailLoginService gmailLoginService;
    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;
    private EmailTemplateService emailTemplateService;
    private ClientSignUpService clientSignUpService;
    private ClientEngagementService clientEngagementService;
    private AuditorEngagementTeamService auditorEngagementTeamService;
    private ClientDetailsEngagementService clientDetailsEngagementService;
    MarketingService maketingService;
    private ContactsService contactsService;

    // personal information
    final String strFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Lead Name");
    //    String strEmail = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 2);
    //    String strEmail = "thuan.duong@titancorpvn.com";
    final String strRoleFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Role in Firm", "Valid Value");
    final String strPhone = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Auditor", "Valid Value");
    final String strReference = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Reference to Auvenir", "Valid Value");
    // firm information
    final String strName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Name", "Valid Value");
    final String strPreName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Previous Name", "Valid Value");
    final String strWebsite = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Website", "Valid Value");
    final String strStreetAddr = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Street Address", "Valid Value");
    final String strOffNum = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Suite / Office Number", "Valid Value");
    final String strZipCode = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Postal Code/ Zip Code", "Valid Value");
    final String strCity = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "City", "Valid Value");
    final String strState = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Province / State", "Valid Value");
    final String strMemberID = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D", "Valid Value");
    final String strNumEmp = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Number of Employee", "Valid Value");
    final String strPhoneFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Firm", "Valid Value");
    final String strAffName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Affiliated Firm's Name", "Valid Value");
    final String strPathLogo = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Path Logo", "Valid Value");
    /*
    security information
    final String strPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Password", "Valid Value");
    */

    /*
    final String fullNameCreate = "Test Login Auditor";
    final String fullNameCreate = "Minh Nguyen";
    final String emailCreate = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 1);
    final String emailCreate = "ff.minhtest@gmail.com";
    */
    final String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
    //    final String gmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Email Password");
//    final String auditorInvitedPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
//    final String strAdminEmail = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
    final String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");

    private String adminId, auditorId, clientId;
    private String adminPassword, auditorPassword, clientPassword;
    private String engagementName;
    private String clientEmailPassword;
    private String sData[];
    private String testCaseId;
    private SimpleDateFormat dateFormat;
    private String timeStamp;

    @Test(priority = 1, enabled = true, description = "To verify admin is able to login")
    public void verifyAdminLogin() {
        getLogger().info("Verify admin is able to login.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
        adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify admin is able to login.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    //Added Thuan Duong 15/06/2017
    @Test(priority = 2, enabled = true, description = "Verify Register and sign up successfully an Auditor User")
    public void verifySignUpAuditorUser() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        final String emailCreate = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        try {
            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            auditorSignUpService.deleteUserUsingApi(emailCreate);

            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, emailCreate, strRoleFirm, strPhone, strReference);
            auditorSignUpService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo);
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify Admin user can change status of Auditor User from Wait-List to On Boarding.")
    public void verifyAdminChangeStatusUserToOnBoarding() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        final String emailCreate = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        final String adminEmail = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
        final String gmailAuditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Email Password");
        try {
            gmailLoginService.deleteAllExistedEmail(emailCreate, gmailAuditorPassword);

            marketingService.loginWithUserRolesUsingUsernamePassword(adminEmail, strAdminPwd);
            adminService.changeTheStatusUser(emailCreate, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify Auditor user status: Active Auditor User and create a password.")
    public void verifyAuditorLoginGmailAndActiveUser() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        final String gmailAuditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Email Password");
        final String emailCreate = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        try {

            gmailLoginService.gmailLogin(emailCreate, gmailAuditorPassword);
            gmailLoginService.selectActiveEmaill();

            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();
            auditorSignUpService.createPassword(auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify Auditor User can log in with user and password. ")
    public void verifyLoginAuditorUser() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        final String emailCreate = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(emailCreate, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            marketingService.logout();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive tests case login and logout: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Test positive tests case login and logout: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    //Ended Thuan Duong 15/06/2017

    @Test(priority = 6, enabled = true, description = "Auditor create new Engagement (simple engagement)")
    public void verifyCreateSimpleEngagement() {
        getLogger().info("Auditor create new Engagement (simple engagement).");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, "", "Smoke Company");
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 7, enabled = true, description = "Verify that Auditor can invite a client")
    public void verifyAuditorInvitingTheClient() throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");

//        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
//        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
//        MongoDBService.removeEngagementObjectByName(MongoDBService.getCollection("engagements"), engagementName);
        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient(clientFullName, clientId, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
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

    @Test(priority = 8, enabled = true, description = "Verify that Admin change the status of the client to OnBoarding"/*, dependsOnMethods = {"verifyAuditorInvitingTheClient"}*/)
    public void verifyChangeTheStatusClientToOnBoarding() {
        getLogger().info("Verify change the status of the client to OnBoarding.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
        clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
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

    @Test(priority = 9, enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed"/*, dependsOnMethods = {"verifyChangeTheStatusClientToOnBoarding"}*/)
    public void verifyClientLogsInAndActive() throws Exception {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
        clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
        String clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");

        MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), clientId, "status", "ONBOARDING");

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.clickOnboardingInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm("0123456789");//10 number required
            clientSignUpService.fillUpBusinessForm("Titancorpvn");
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientAuvenirPassword);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 10, enabled = true, description = "Verify that client user is active successful and client log in system"/*, dependsOnMethods = {"verifyClientLogsInAndActive"}*/)
    public void verifyClientActiveAfterSignUpSuccess() {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
        clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Active");

            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPassword);
            clientEngagementService.verifyNavigatedToClientEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 11, enabled = true, description = "Verify that Auditor can create to-do pages")
    public void verifyAuditorCreateTodoPage() throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
            String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
            String todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyInputDataToDoNameTextBox(todoName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify create to-do pages.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify create to-do pages.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 12, enabled = true, description = "Verify that Audit Assignee box")
    public void verifyAuditAssignee() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
            String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
            String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
            String auditorAssign = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Lead Name");

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectAuditorAssigneeByName(toDoName, auditorAssign);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(toDoName, auditorAssign);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 19, enabled = true, description = "Verify to create new request on ToDo page")
    public void verifyAddNewRequestOnToDoPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
//        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String pathOfUploadLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        String pathOfDownloadLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Download Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "File Upload Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String pathFileUpload = GenericService.sDirPath + pathOfUploadLocation;
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
//            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.clickNewRequestImg();
            auditorCreateToDoService.clickAddRequestButton();
            getLogger().info("Verifying auditor create 1st request name.. ");
            auditorCreateToDoService.verifyCreateRequest("New_Request 01", "client request");
            getLogger().info("Verifying upload TXT file..");
            auditorCreateToDoService.uploadeCreateRequestNewFile(pathFileUpload, fileName);
//            getLogger().info("Verifying download TXT file..");
//            auditorCreateToDoService.downloadCreateRequestNewFile(GenericService.sDirPath + pathOfUploadLocation, GenericService.sDirPath + pathOfDownloadLocation, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor add new request", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor add new request", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 20, enabled = true, description = "Verify to create new request on ToDo page")
    public void verifyClientUploadOnRequest() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        String clientPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        marketingService = new MarketingService(getLogger(), getDriver());
        String pathOfUploadLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User2", "File Upload Name");
        String pathFileUpload = GenericService.sDirPath + pathOfUploadLocation;
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPwd);
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.clickNewRequestImg();
            auditorCreateToDoService.uploadCreateRequestNewFileClient(pathFileUpload, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the client upload file", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the client upload file", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 21, enabled = true, description = "Verify auditor can download.")
    public void verifyAuditorDownloadOnRequest() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        //String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        //String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        marketingService = new MarketingService(getLogger(), getDriver());
        String pathOfUploadLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User2", "File Upload Name");
        String pathOfDownloadLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Download Location");
        String pathFileUpload = GenericService.sDirPath + pathOfUploadLocation;
        String pathFileDownload = GenericService.sDirPath + pathOfDownloadLocation;
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.clickNewRequestImg();
            auditorCreateToDoService.downloadCreateRequestNewFile(pathFileUpload, pathFileDownload, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the auditor download file", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the auditor download file", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Added by Thuan.Duong on 14/06/2017
     */
    @Test(priority = 15, enabled = true, description = "Verify Auditor post new comment on a ToDo.")
    public void verifyAuditorPostComment() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Comment");

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            // Will uncomment when the code is updated with the new xpath and business.
//            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListComment = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListComment, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 30, enabled = true, description = "Verify engagement overview status, todo when complete todo by using marking as complete popup")
    public void verifyAuditorMarkAsComplete() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.clickLoginButton();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);

            //Work flow when click on close icon popup - Start
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Get engagement status and todo
            auditorEngagementService.getEngagementStatusAndToDoBefor(engagementName);
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Create new to do
            //auditorCreateToDoService.createNewToDoTask(toDoName);
            // Select to do follow to do name
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            // Click on close icon popup
            auditorCreateToDoService.clickOnCloseIconInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();
            // Verify engagement overview status after click on close icon popup
            auditorCreateToDoService.verifyEngagementOverViewStatusWhenClickOnCloseIconPopup();
            // Verify engagement overview todo after click on close icon popup
            auditorCreateToDoService.verifyEngagementOverViewToDoWhenClickOnCloseIconPopup();
            // Click on engagement link
            auditorCreateToDoService.clickOnEngagementLink();
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Verify engagement status
            auditorEngagementService.verifyEngagementStatusWhenClickOnCloseIconPopup(engagementName);
            // Verify engagement todo
            auditorEngagementService.verifyEngagementToDoWhenClickOnCloseIconPopup(engagementName);
            //Work flow when click on close icon popup - End

            //Work flow when click on cancel button - Start
            // Get engagement status and todo
            auditorEngagementService.getEngagementStatusAndToDoBefor(engagementName);
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Select to do follow to do name
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            // Click on cancel button in popup
            auditorCreateToDoService.clickOnCancelButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();
            // Verify engagement overview status after click on cancel button
            auditorCreateToDoService.verifyEngagementOverViewStatusWhenClickOnCancelButton();
            // Verify engagement overview todo after click on cancel button
            auditorCreateToDoService.verifyEngagementOverViewToDoWhenClickOnCancelButton();
            // Click on engagement link
            auditorCreateToDoService.clickOnEngagementLink();
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Verify engagement status
            auditorEngagementService.verifyEngagementStatusWhenClickOnCancelButtonPopup(engagementName);
            // Verify engagement todo
            auditorEngagementService.verifyEngagementToDoWhenClickOnCancelButtonPopup(engagementName);
            //Work flow when click on cancel button - End

            //Work flow when click on archive button - Start.
            // Get engagement status and todo
            auditorEngagementService.getEngagementStatusAndToDoBefor(engagementName);
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Select to do follow to do name
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            // Click on cancel button in popup
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();
            // Verify engagement overview status after click on archive button
            auditorCreateToDoService.verifyEngagementOverviewStatusWhenClickOnArchiveButton();
            // Verify engagement overview todo after click on archive button
            auditorCreateToDoService.verifyEngagementOverViewToDoWhenClickOnArchiveButton();
            // Click on engagement link
            auditorCreateToDoService.clickOnEngagementLink();
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Verify engagement status
            auditorEngagementService.verifyEngagementStatusWhenClickOnArchiveButtonPopup(engagementName);
            // Verify engagement todo
            auditorEngagementService.verifyEngagementToDoWhenClickOnArchiveButtonPopup(engagementName);
            //Work flow when click on cancel button - End

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify engagement overview status, todo when complete todo by using marking as complete popup", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify engagement overview status, todo when complete todo by using marking as complete popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 31, enabled = true, description = "Verify Client see Todo mark as complete")
    public void verifyClientSeeMarkAsComplete() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.clickLoginButton();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(clientId, clientPassword);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Verify engagement status complete
            auditorEngagementService.verifyEngagementStatusIsComplete(engagementName);
            // verify engagement ToDo complete
            //auditorEngagementService.verifyEngagementToDoIsComplete(engagementName);
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Verify engagement overview status complete
            auditorCreateToDoService.verifyEngagementOverviewStatusIsComplete();
            // Verify engagement overview ToDo complete
            auditorCreateToDoService.verifyEngagementOverviewToDoIsComplete();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client see Todo mark as complete", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Client see Todo mark as complete", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    /**
     * Added by Thuan.Duong on 16/06/2017
     */
    @Test(priority = 22, enabled = true, description = "Verify that Auditor can add new member.")
    public void verifyInviteNewMemberAuditor() throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String auditorInvitedUserEmail = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Invited Auditor");
        String fullNameMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
        String roleMember = "Partner";
        String auditorInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorEngagementTeamService.clickOnEngagementTeamMenu();
//            auditorEngagementTeamService.deleteAllMemberInEngagement();
            auditorEngagementTeamService.deleteMemberInEngagementByName(fullNameMember);

            auditorSignUpService.deleteUserUsingApi(auditorInvitedUserEmail);
            gmailLoginService.deleteAllExistedEmail(auditorInvitedUserEmail, auditorInvitedUserPwd);

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorEngagementTeamService.clickOnEngagementTeamMenu();
            auditorEngagementTeamService.clickOnInviteMember();
            auditorEngagementTeamService.inputInviteNewMemberInfo(fullNameMember, auditorInvitedUserEmail, roleMember);
            auditorEngagementTeamService.verifyAddNewInvitedMember(fullNameMember, roleMember);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(auditorInvitedUserPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.confirmInfomationNewAuditorUser(fullNameMember, auditorInvitedUserEmail, auditorInvitedUserPwd);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Business rule changed. The Engagement is selected after signup successfully.
//            auditorEngagementService.verifyAuditorEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Add New Member Auditor", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test script Failed: Verify Add New Member Auditor", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /*-----------end of Thuan.Duong on 19/06/2017.*/

    /**
     * Pending: Dependence on another test case
     */

    @Test(priority = 14, enabled = true, description = "Client verify engagement, assigned To-Do")
    public void verifyClientEngagementOverView() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        try {
            String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
            String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
            String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
            String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");

            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPassword);
            clientService.verifyClientHomePage();
            auditorEngagementService.verifyEngagementExisted(engagement);
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);
            clientService.verifyToDoTaskExist(toDoName, true);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Client verify engagement, assigned To-Do.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Client verify " +
                    "engagement, assigned To-Do.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 13, enabled = true, description = "Verify Client Assignee")
    public void verifyClientAssignee() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
            String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
            String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
            String clientAssign = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
//             String clientAssign = "Thuan Client";

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectClientAssigneeByName(toDoName, clientAssign);
            auditorCreateToDoService.verifyClientAssigneeSelected(toDoName, clientAssign);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Client can see Auditor's post comment.")
    public void verifyClientViewAuditorComment() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Comment");
        String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
//        String clientId = "thuanduong@mailinator.com";
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
//        String clientPassword = "Changeit@123";

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPassword);
            clientService.verifyClientHomePage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName, true);
            auditorCreateToDoService.verifyLastCommentOfUserDisplayed(commentContent, strFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client post comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify client post comment.")
    public void verifyClientPostComment() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Comment");
        String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
//        String clientId = "thuanduong@mailinator.com";
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
//        String clientPassword = "Changeit@123";

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPassword);
            clientService.verifyClientHomePage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName, true);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListComment = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListComment, commentContent);


            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client post comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify Auditor can see client's post comment.")
    public void verifyAuditorViewClientComment() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Comment");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
//        String clientFullName = "Thuan Client";
        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName, false);
            auditorCreateToDoService.verifyLastCommentOfUserDisplayed(commentContent, clientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 23, enabled = true, description = "verify that Assign ToDo Bulk Action")
    public void verifyAssignToDoBulkAction() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String fullNameInvitedMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
        String auditorInvitedId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Invited Auditor");
        String auditorInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
        String fullNameInvitedClient = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
        String clientInvitedId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
//        String clientInvitedId = "thuan.duong@mailinator.com";
        String clientInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
//        String toDoName = "TestAssignToDoBulk01";

        try {

            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
//            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);

            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoName);


            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(fullNameInvitedMember);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(toDoName, fullNameInvitedMember);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(fullNameInvitedClient);
            auditorCreateToDoService.verifyClientAssigneeSelected(toDoName, fullNameInvitedClient);
            marketingService.logout();

            //Client verify To Do Assigned.
            marketingService.loginWithUserRolesUsingUsernamePassword(clientInvitedId, clientInvitedUserPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            clientService.verifyToDoTaskExist(toDoName, true);
            Thread.sleep(3000);
            marketingService.logout();

            //Auditor Member verify To Do Assigned.
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorInvitedId, auditorInvitedUserPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            clientService.verifyToDoTaskExist(toDoName, false);
            Thread.sleep(3000);
            marketingService.logout();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client post comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 24, enabled = true, description = "Verify Create And Delete ToDo.")
    public void verifyDeleteSingleAndMultipleToDo() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");

        engagementName = "Engagement For Test Delete ToDo";
        String toDoNameDeleteSingle = "TestDeleteSingle";
        String toDoNameDeleteMultiple01 = "TestNameDeleteMultiple01";
        String toDoNameDeleteMultiple02 = "TestNameDeleteMultiple02";
        String toDoNameDeleteMultiple03 = "TestNameDeleteMultiple03";

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoNameDeleteSingle);
            auditorCreateToDoService.createNewToDoTask(toDoNameDeleteMultiple01);
            auditorCreateToDoService.createNewToDoTask(toDoNameDeleteMultiple02);
            auditorCreateToDoService.createNewToDoTask(toDoNameDeleteMultiple03);

            auditorCreateToDoService.selectToDoTaskName(toDoNameDeleteSingle);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(toDoNameDeleteSingle);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyEmptyToDoList();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Create And Delete ToDo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Create And Delete ToDo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 25, enabled = true, description = "Verify download all attachment file form all ToDo.")
    public void verifyDownloadAttachmentFromAllToDo() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        /*String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");*/
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.clickLoginButton();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Move file manager tab
            auditorDetailsEngagementService.clickOnFileManagerLink();
            // Click on all file check box
            auditorDetailsEngagementService.clickOnAllFileCheckBox();
            // Click on down load icon
            auditorDetailsEngagementService.clickOnDownLoadIcon();
            // verify down load popup
            auditorDetailsEngagementService.verifyDownLoadPopup();
            // Click on down load button in popup
            auditorDetailsEngagementService.clickOnDownLoadButtonInPopup();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify download all attachment file form all ToDo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify download all attachment file form all ToDo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 26, enabled = true, description = "Verify check list team.")
    public void verifyCheckListTeam() throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String fullNameMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
        String roleMember = "Auditor";

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.clickLoginButton();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Click on team link
            auditorEngagementTeamService.clickOnEngagementTeamMenu();
            // Verify member is already exist in team list data
            auditorEngagementTeamService.verifyMemberIsShownInTeamList(fullNameMember, roleMember);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify check list team.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test script Failed: Verify check list team.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 27, enabled = true, description = "Verify check contact list.")
    public void verifyCheckContactList() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorService = new AuditorService(getLogger(), getDriver());
        contactsService = new ContactsService(getLogger(), getDriver());
        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
            String contactName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
            String emailContact = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorService.clickClientsLink();
            contactsService.verifyAuditorContactsPage();
            contactsService.verifyContactDisplayedInContactsPage(contactName, emailContact);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify check contact list.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test script Failed: Verify check contact list.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }

    }

    /*
    Vien.pham added
     */
    @Test(priority = 28, enabled = true, description = "Verify auditor attach file.")
    public void verifyAuditorAttachFile() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String pathOfAttachLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "File Attach Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickNewRequestImg();
            getLogger().info("Verifying auditor attach a TXT file..");
            auditorCreateToDoService.auditorAttachNewFile(GenericService.sDirPath + pathOfAttachLocation, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor attach file.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor attach file.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    /*
       Vien.pham added
        */
    @Test(priority = 29, enabled = true, description = "Verify client download attach file.")
    public void verifyClientDownloadAttachFile() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        String clientPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "File Attach Name");
        String pathOfDownloadLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Download Location");
        String pathOfUploadLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPwd);
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.clickNewRequestImg();
            auditorCreateToDoService.clientDownloadAttachFile(GenericService.sDirPath+pathOfUploadLocation,GenericService.sDirPath +pathOfDownloadLocation, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the client download attach file", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the client download attach file", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

}
