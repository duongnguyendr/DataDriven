package com.auvenir.ui.tests;

import java.text.SimpleDateFormat;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.services.AuditorCreateToDoService;
import com.auvenir.ui.services.AuditorDetailsEngagementService;
import com.auvenir.ui.services.AuditorEditCategoryService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.AuditorEngagementTeamService;
import com.auvenir.ui.services.AuditorNewEngagementService;
import com.auvenir.ui.services.AuditorService;
import com.auvenir.ui.services.AuditorTodoListService;
import com.auvenir.ui.services.AuvenirService;
import com.auvenir.ui.services.ClientEngagementService;
import com.auvenir.ui.services.ClientService;
import com.auvenir.ui.services.ClientSignUpService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.emailtemplate.EmailTemplateService;
import com.auvenir.ui.services.marketing.signup.AuditorSignUpService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

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
    MarketingService maketingService;

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
        try {
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");

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
    @Test(priority = 2, enabled = true, description = "Verify Register and Active Auditor User")
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
//            auditorSignUpService.deleteUserUsingMongoDB(emailCreate);

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

    @Test(priority = 3, enabled = true, description = "Verify Register and Active Auditor User")
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
//
//            marketingService.goToBaseURL();
//            marketingService.clickLoginButton();
            marketingService.loginWithUserRolesUsingUsernamePassword (adminEmail, strAdminPwd);
            adminService.changeTheStatusUser(emailCreate, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify Register and Active Auditor User")
    public void verifyLoginGmailAndActiveUser() throws Exception {
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
            auditorSignUpService.createPassword(auditorPwd, "");
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 12, enabled = true, description = "Test positive tests case login and logout")
    public void verifyLoginAuditorUser() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        final String emailCreate = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        try {
//            marketingService.goToBaseURL();
//            marketingService.clickLoginButton();
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

    @Test(priority = 6, enabled = true, description = "Auditor create new Engagament (simple engagement)")
    public void verifyCreateSimpleEngagement() {
        getLogger().info("Auditor create new Engagament (simple engagement).");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService= new MarketingService(getLogger(), getDriver());
        try {
            auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
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
        marketingService = new MarketingService(getLogger(), getDriver());

        try {
            clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
            auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");

            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
            //need precondition for save engagement name, and delete this engagement or client on acl
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement" + timeStamp);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient("Titan client", clientId, "Leader");
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

    @Test(priority = 9, enabled = true, description = "Admin change the status of the client to OnBoarding"/*, dependsOnMethods = {"verifyAuditorInvitingTheClient"}*/)
    public void verifyChangeTheStatusClientToOnBoarding() {
        getLogger().info("Verify change the status of the client to OnBoarding.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        marketingService= new MarketingService(getLogger(), getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
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

    @Test(priority = 10, enabled = true, description = "Client logs in and OnBoarding page is displayed"/*, dependsOnMethods = {"verifyChangeTheStatusClientToOnBoarding"}*/)
    public void verifyClientLogsInAndActive() {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        marketingService= new MarketingService(getLogger(), getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
            String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
            String clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");

            System.out.println("clientEmailPassword = " + clientEmailPassword);
            MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), clientId, "status", "ONBOARDING");

            gmailLoginService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.clickOnboardingInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm("0123456789");//10 number required
            clientSignUpService.fillUpBusinessForm("Titancorpvn");
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientAuvenirPassword);
            clientEngagementService.verifyNavigatedToClientEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 11, enabled = true, description = "Active successful and client log in system"/*, dependsOnMethods = {"verifyClientLogsInAndActive"}*/)
    public void verifyClientActiveAfterSignUpSuccess() {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        marketingService= new MarketingService(getLogger(), getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Admin");
            clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Active");

            clientEngagementService.loginWithUserRole(clientId);
            clientEngagementService.verifyNavigatedToClientEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 14, enabled = true, description = "Verify create to-do pages")
    public void verifyCreateTodoPage() throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());

        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("Engagement");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyInputDataToDoNameTextBox("Todo-01");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify create to-do pages.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify create to-do pages.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 15, enabled = true, description = "Verify create category")
    public void verifyCreateCategory() throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        Random random = new Random();
        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("Engagement");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createCategories("Category" + random.nextInt(100));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify create to-do pages.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify create to-do pages.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify Auditor select due date for To-Do")
    public void verifyDuedateTime() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        boolean isNewToDoPage = false;
        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            auditorCreateToDoService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("Engagement144");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("Engagement144");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            getLogger().info("Verifying unable to send text into Duedate box..");
            auditorCreateToDoService.verifyUnableToInputDuedate("12/4/2017");
            getLogger().info("Choosing date in table due-date..");
            auditorCreateToDoService.chooseDateItemInDatePicker(isNewToDoPage);
            getLogger().info("Verifying format is mm/dd/yyy..");
            auditorCreateToDoService.checkFormatDueDate();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor select due date for To-Do.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor select due date for To-Do.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify Audit Assignee box")
    public void verifyAuditAssignee() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            auditorCreateToDoService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("Engagement11");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("Engagement11");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            // Remove verify default auditor Assignee because if exist auditor assignee, default is not Unassigned
//            auditorCreateToDoService.verifyAuditAssigneeBox();
            auditorCreateToDoService.verifyAuditAssigneeIsSelectedCorrectly();
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
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
//        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User3", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String pathOfUploadLocation = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "File Upload Name");
        try {
            auditorCreateToDoService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
//            auditorCreateToDoService.deleteAllExistedTodoItems();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyAddNewRequestButton();
//            auditorCreateToDoService.verifyRequestNameTextbox();
            getLogger().info("Verifying create new request name.. ");
            auditorCreateToDoService.verifyCreateRequest("New_Request 01");
            getLogger().info("Verifying update new request name.. ");
            auditorCreateToDoService.verifyUpdateRequest("New_Request 02");
//            auditorCreateToDoService.verifyDeleteRequest();
//            auditorCreateToDoService.verifyCopyRequest();
            getLogger().info("Verifying upload TXT file..");
            auditorCreateToDoService.uploadeCreateRequestNewFile(GenericService.sDirPath + pathOfUploadLocation, fileName);
//            auditorCreateToDoService.downloadCreateRequestNewFile(GenericService.sDirPath + "\\src\\test\\resources\\upload\\", "C:\\Users\\vien.pham\\Downloads\\", "TXT_helloAuvenir.txt");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify new Category popup", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify new Category popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Added by Thuan.Duong on 14/06/2017
     */
    @Test(priority = 22, enabled = true, description = "Verify Auditor post new comment")
    public void verifyToDoDetailsCommenting() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDoName");
        String commentContent = "comment TestComment01";

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword (auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            // Will uncomment when the code is updated with the new xpath and business.
            auditorCreateToDoService.verifyAddNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickPostComment();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 23, enabled = true, description = "Verify mark as complete")
    public void verifyMarkAsComplete() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDoName");
//        String toDoName = "TestMarkComplete01";
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
//            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.verifyAddNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.verifyClickCloseMarkPopup();

            auditorCreateToDoService.verifyAddNewToDoTask(toDoName);
            int index = auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickArchiveTaskButton();
            auditorCreateToDoService.verifyMarkCompleteArchive(index);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify new Category popup", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify new Category popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
    /*-----------end of Thuan.Duong on 14/06/2017.*/

    /**
     * Added by Thuan.Duong on 16/06/2017
     */
    @Test(priority = 13, enabled = true, description = "Verify mark as complete", groups = "Add Auditor Member")
    public void verifyAddNewMemberAuditor() throws Exception {
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
        String auditorInvitedUserEmail = GenericService.getTestDataFromExcel ("SmokeTest", "Valid User", "Invited Auditor");
        String fullNameMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
        String roleMember = "Auditor";
        String auditorInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorEngagementTeamService.clickEngagementTeamMenu();
//            auditorEngagementTeamService.deleteAllMemberInEngagement();
            auditorEngagementTeamService.deleteMemberInEngagementByName(fullNameMember);

            auditorSignUpService.deleteUserUsingApi(auditorInvitedUserEmail);
            gmailLoginService.deleteAllExistedEmail(auditorInvitedUserEmail, auditorInvitedUserPwd);

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            auditorEngagementTeamService.clickInviteMember();
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
     *
     * Pending: Dependence on another test case
     */
    @Test(priority = 28, enabled = true, description = "Client verify engagement, assigned To-Do , file uploaded by auditor, auditor's comment")
    public void verifyClientEngagementOveview() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        try {
            String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
            String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");

            auditorSignUpService.deleteUserUsingApi(clientId);
            auditorCreateToDoService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("Engagement144");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("Engagement144");
            // Invite client
            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient("Titan client", clientId, "Leader");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Client verify engagement, assigned To-Do , file uploaded by auditor, auditor's comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Client verify engagement, assigned To-Do , file uploaded by auditor, auditor's comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Client Assignee")
    public void verifyClientAssigneeComboBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        try {
            String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
            auditorCreateToDoService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("ClientB");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("ClientB");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyClientAssigneeComboBox();
            auditorCreateToDoService.verifyClientAssigneeIsSelectedCorrectly();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    
    @Test(priority = 28, enabled = true, description = "Verify client post comment.")
    public void verifyClientPostComment() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        String commentContent = "Comment";
        try {
//        	String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        	String clientId = "drleo407@gmail.com";
            auditorCreateToDoService.loginWithUserRole(clientId);
            clientService.verifyClientHomePage();
            auditorEngagementService.navigateToFirstEngagement();
            auditorCreateToDoService.verifyAddNewRequestPopUp();
            auditorCreateToDoService.verifyInputMultiComment(commentContent, 10);
            auditorCreateToDoService.verifyCommentSuccessFul(commentContent, 10);
            
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client post comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 24, enabled = true, description = "Verify client post comment.")
    public void verifyAssignToDoBulkAction() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
//        String auditorInvitedUserEmail = GenericService.getTestDataFromExcel ("SmokeTest", "Valid User", "Invited Auditor");
        String fullNameInvitedMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
//        String roleMember = "Auditor";
//        strFullName
        String auditorInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
//        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDoName");
        String toDoName = "TestAssignToDoBulk01";
//        String commentContent = "Comment";
        try {
//            String clientId = "drleo407@gmail.com";
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.verifyAddNewToDoTask(toDoName);
            int index = auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(fullNameInvitedMember);

            index = auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(strFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client post comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
