package com.auvenir.ui.tests;

import com.auvenir.ui.dataprovider.SmokeDataProvider;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientSignUpService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by huy.huynh on 13/06/2017.
 * SmokeTest for R2
 */
public class SmokeTest extends AbstractTest {
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

    final String strFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Lead Name");
    private String timeStamp;

    @Test(priority = 1, enabled = true, description = "To verify admin is able to login", dataProvider = "verifyAdminLogin", dataProviderClass = SmokeDataProvider.class)
    public void verifyAdminLogin(String adminId, String adminPassword) {
        getLogger().info("Verify admin is able to login.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminId = GenericService.sBrowserData + adminId;

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

    @Test(priority = 2, enabled = true, description = "Verify Register and sign up successfully an Auditor User", dataProvider = "verifySignUpAuditorUser", dataProviderClass = SmokeDataProvider.class)
    public void verifySignUpAuditorUser(String emailCreate, String strFullName, String strRoleFirm, String strPhone, String strReference,
                                        String strName, String strPreName, String strWebsite, String strStreetAddress, String strOffNum,
                                        String strZipCode, String strCity, String strCountry, String strState, String strMemberID, String strNumEmp,
                                        String strPhoneFirm, String strAffName, String strPathLogo) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        emailCreate = GenericService.sBrowserData + emailCreate;
        try {
            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            // auditorSignUpService.deleteUserUsingApi(emailCreate);
            auditorSignUpService.deleteUserUsingApi(emailCreate);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, emailCreate, strRoleFirm, strPhone, strReference);
            auditorSignUpService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddress, strOffNum, strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo);
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

    @Test(priority = 3, enabled = true, description = "Verify Admin user can change status of Auditor User from Wait-List to On Boarding.", dataProvider = "verifyAdminChangeStatusUserToOnBoarding", dataProviderClass = SmokeDataProvider.class)
    public void verifyAdminChangeStatusUserToOnBoarding(String emailCreate, String adminEmail, String gmailAuditorPassword, String strAdminPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        emailCreate = GenericService.sBrowserData + emailCreate;
        adminEmail = GenericService.sBrowserData + adminEmail;

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

    @Test(priority = 4, enabled = true, description = "Verify Auditor user status: Active Auditor User and create a password.", dataProvider = "verifyAuditorLoginGmailAndActiveUser", dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorLoginGmailAndActiveUser(String gmailAuditorPassword, String emailCreate, String auditorPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        emailCreate = GenericService.sBrowserData + emailCreate;

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

    @Test(priority = 5, enabled = true, description = "Verify Auditor User can log in with user and password. ", dataProvider = "verifyLoginAuditorUser", dataProviderClass = SmokeDataProvider.class)
    public void verifyLoginAuditorUser(String emailCreate, String auditorPwd) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        emailCreate = GenericService.sBrowserData + emailCreate;

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

    @Test(priority = 6, enabled = true, description = "Auditor create new Engagement (simple engagement)", dataProvider = "verifyCreateSimpleEngagement", dataProviderClass = SmokeDataProvider.class)
    public void verifyCreateSimpleEngagement(String auditorId, String auditorPassword, String engagementName) {
        getLogger().info("Auditor create new Engagement (simple engagement).");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

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

    @Test(priority = 7, enabled = true, description = "Verify that Auditor can invite a client", dataProvider = "verifyAuditorInvitingTheClient", dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorInvitingTheClient(String clientId, String adminId, String auditorId,
                                               String adminPassword, String auditorPassword,
                                               String engagementName, String clientEmailPassword, String clientFullName,
                                               String userOnBoardingStatus, String roleClient) throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        clientId = GenericService.sBrowserData + clientId;
        adminId = GenericService.sBrowserData + adminId;
        auditorId = GenericService.sBrowserData + auditorId;

        try {

            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient(clientFullName, clientId, roleClient);
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, userOnBoardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 8, enabled = true, description = "Verify that Admin change the status of the client to OnBoarding", dataProvider = "verifyChangeTheStatusClientToOnBoarding", dataProviderClass = SmokeDataProvider.class)
    public void verifyChangeTheStatusClientToOnBoarding(String adminId, String clientId, String adminPassword, String chooseOptionValue) {
        getLogger().info("Verify change the status of the client to OnBoarding.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminId = GenericService.sBrowserData + adminId;
        clientId = GenericService.sBrowserData + clientId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.changeTheStatusUser(clientId, chooseOptionValue);
            adminService.verifyUserStatusOnAdminUserTable(clientId, chooseOptionValue);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify change the status of the client to OnBoarding.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify change the status of the client to OnBoarding.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 9, enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed", dataProvider = "verifyClientLogsInAndActive", dataProviderClass = SmokeDataProvider.class)
    public void verifyClientLogsInAndActive(String adminId, String clientId, String clientEmailPassword,
                                            String clientAuvenirPassword, String engagementName,
                                            String phoneNumber, String parentStackHolder) throws Exception {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        adminId = GenericService.sBrowserData + adminId;
        clientId = GenericService.sBrowserData + clientId;


        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(phoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
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

    @Test(priority = 10, enabled = true, description = "Verify that client user is active successful and client log in system", dataProvider = "verifyClientActiveAfterSignUpSuccess", dataProviderClass = SmokeDataProvider.class)
    public void verifyClientActiveAfterSignUpSuccess(String adminId, String clientId,
                                                     String adminPassword, String clientPassword,
                                                     String userActiveStatus) {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminId = GenericService.sBrowserData + adminId;
        clientId = GenericService.sBrowserData + clientId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, userActiveStatus);

            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPassword);
            clientEngagementService.verifyNavigatedToClientEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 11, enabled = true, description = "Verify that Auditor can create to-do pages", dataProvider = "verifyAuditorCreateTodoPage", dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorCreateTodoPage(String auditorId, String auditorPassword, String engagement, String todoName) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
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

    @Test(priority = 12, enabled = true, description = "Verify that Audit Assignee box", dataProvider = "verifyAuditAssignee", dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditAssignee(String auditorId, String auditorPassword, String engagement, String toDoName, String auditorAssign) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
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

    @Test(priority = 13, enabled = true, description = "Verify Client Assignee", dataProvider = "verifyClientAssignee", dataProviderClass = SmokeDataProvider.class)
    public void verifyClientAssignee(String auditorId, String auditorPassword, String engagement,
                                     String toDoName, String clientAssign) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
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

    @Test(priority = 14, enabled = true, description = "Client verify engagement, assigned To-Do", dataProvider = "verifyClientEngagementOverView", dataProviderClass = SmokeDataProvider.class)
    public void verifyClientEngagementOverView(String clientId, String clientPassword, String engagement, String toDoName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        clientId = GenericService.sBrowserData + clientId;
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPassword);
            clientService.verifyClientHomePage();
            auditorEngagementService.verifyEngagementExisted(engagement);
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);
            clientService.verifyToDoTaskExist(toDoName, true);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Client verify engagement, assigned To-Do.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Client verify engagement, assigned To-Do.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 15, enabled = true, description = "Verify Auditor post new comment on a ToDo.", dataProvider = "verifyAuditorPostComment", dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorPostComment(String auditorId, String auditorPwd, String engagementName,
                                         String toDoName, String commentContent) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            // Will uncomment when the code is updated with the new xpath and business.
            // auditorCreateToDoService.verifyAddNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Client can see Auditor's post comment.", dataProvider = "verifyClientViewAuditorComment", dataProviderClass = SmokeDataProvider.class)
    public void verifyClientViewAuditorComment(String clientId, String clientPassword,
                                               String engagementName, String toDoName, String commentContent, boolean isClient) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());

        clientId = GenericService.sBrowserData + clientId;

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPassword);
            clientService.verifyClientHomePage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName, isClient);
            auditorCreateToDoService.verifyLastCommentOfUserDisplayed(commentContent, strFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client post comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify client post comment.", dataProvider = "verifyClientPostComment", dataProviderClass = SmokeDataProvider.class)
    public void verifyClientPostComment(String clientId, String clientPassword,
                                        String engagementName, String toDoName, String commentContent, boolean isClient) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());

        clientId = GenericService.sBrowserData + clientId;

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPassword);
            clientService.verifyClientHomePage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName, isClient);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);


            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client post comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify Auditor can see client's post comment.", dataProvider = "verifyAuditorViewClientComment",dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorViewClientComment(String auditorId, String auditorPwd, String engagementName,
                                               String toDoName, String commentContent, String clientFullName, boolean isClient) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName, isClient);
            auditorCreateToDoService.verifyLastCommentOfUserDisplayed(commentContent, clientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 19, enabled = true, description = "Verify to create new request on ToDo page",dataProvider = "verifyAddNewRequestOnToDoPage",dataProviderClass = SmokeDataProvider.class)
    public void verifyAddNewRequestOnToDoPage(String auditorId, String auditorPwd, String engagementName, String pathOfUploadLocation, String fileName, String toDoName,
                                              String deadlineDate, String endDate, String startDate, String request01Value, String request02Value, String position01Value, String position02Value) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.createNewRequest("request 01", "1");
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.createNewRequest("request 02", "2");
            // temporary return Engagement to verify newRequest.
            auditorCreateToDoService.reselectEngagementName(engagementName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.uploadeNewFileByRequestName(pathOfUploadLocation, fileName, "request 01");
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor add new request", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor add new request", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Added by Vien.pham July, 2017
     */
    @Test(priority = 20, enabled = true, description = "Verify to client upload file as requested",dataProvider = "verifyClientUploadOnRequest",dataProviderClass = SmokeDataProvider.class)
    public void verifyClientUploadOnRequest(String clientId, String clientPwd, String engagementName, String pathOfUploadLocation, String fileName, String requestValue) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        clientId = GenericService.sBrowserData + clientId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPwd);
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.uploadeNewFileByRequestName(pathOfUploadLocation, fileName, "request 02");
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the client upload file", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the client upload file", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Added by Vien Pham on July 10, 2017
     */
    @Test(priority = 21, enabled = true, description = "Verify auditor can download.",dataProvider = "verifyAuditorDownloadOnRequest",dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorDownloadOnRequest(String auditorId, String auditorPwd,String engagementName,String pathOfUploadLocation,String fileName,String pathOfDownloadLocation) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.downloadRequestFile(pathOfUploadLocation, pathOfDownloadLocation, fileName, 1);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the auditor download file", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the auditor download file", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 22, enabled = true, description = "Verify that Auditor can add new member.", dataProvider = "verifyInviteNewMemberAuditor", dataProviderClass = SmokeDataProvider.class)
    public void verifyInviteNewMemberAuditor(
            String auditorId, String auditorPwd, String engagementName,
            String auditorInvitedUserEmail, String fullNameMember,
            String roleMember, String auditorInvitedUserPwd) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;
        auditorInvitedUserEmail = GenericService.sBrowserData + auditorInvitedUserEmail;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            // auditorEngagementTeamService.deleteAllMemberInEngagement();
            auditorEngagementTeamService.deleteMemberInEngagementByName(fullNameMember);

            // auditorSignUpService.deleteUserUsingApi(auditorInvitedUserEmail);
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
            // auditorEngagementService.verifyAuditorEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Add New Member Auditor", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test script Failed: Verify Add New Member Auditor", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 23, enabled = true, description = "verify that Assign ToDo Bulk Action", dataProvider = "verifyAssignToDoBulkAction", dataProviderClass = SmokeDataProvider.class)
    public void verifyAssignToDoBulkAction(String auditorId, String auditorPwd, String engagementName,
                                           String fullNameInvitedMember, String auditorInvitedId, String auditorInvitedUserPwd,
                                           String fullNameInvitedClient, String clientInvitedId,
                                           String clientInvitedUserPwd, String toDoName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;
        auditorInvitedId = GenericService.sBrowserData + auditorInvitedId;
        clientInvitedId = GenericService.sBrowserData + clientInvitedId;

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoName);


            int index = auditorCreateToDoService.selectToDoTaskName(toDoName);
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
            Thread.sleep(5000);
            marketingService.logout();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client post comment.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 24, enabled = true, description = "Verify Create And Delete ToDo.", dataProvider = "verifyDeleteSingleAndMultipleToDo", dataProviderClass = SmokeDataProvider.class)
    public void verifyDeleteSingleAndMultipleToDo(String auditorId, String auditorPwd,
                                                  String engagementNameT, String toDoNameDeleteSingle,
                                                  String toDoNameDeleteMultiple01, String toDoNameDeleteMultiple02, String toDoNameDeleteMultiple03) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementNameT);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementNameT);

            auditorCreateToDoService.createNewToDoTask(toDoNameDeleteSingle);
            auditorCreateToDoService.createNewToDoTask(toDoNameDeleteMultiple01);
            auditorCreateToDoService.createNewToDoTask(toDoNameDeleteMultiple02);
            auditorCreateToDoService.createNewToDoTask(toDoNameDeleteMultiple03);

            auditorCreateToDoService.scrollDown(getDriver());

            auditorCreateToDoService.selectToDoTaskName(toDoNameDeleteSingle);
            auditorCreateToDoService.scrollUp(getDriver());
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

    @Test(priority = 25, enabled = true, description = "Verify download all attachment file form all ToDo.", dataProvider = "verifyDownloadAttachmentFromAllToDo", dataProviderClass = SmokeDataProvider.class)
    public void verifyDownloadAttachmentFromAllToDo(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
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

            auditorDetailsEngagementService.closeBrowserAfterDownLoad();
            // verify down load popup
            // auditorDetailsEngagementService.verifyDownLoadPopup();
            // Click on down load button in popup
            // auditorDetailsEngagementService.clickOnDownLoadButtonInPopup();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify download all attachment file form all ToDo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify download all attachment file form all ToDo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 26, enabled = true, description = "Verify check list team.", dataProvider = "verifyCheckListTeam", dataProviderClass = SmokeDataProvider.class)
    public void verifyCheckListTeam(String auditorId, String auditorPwd,
                                    String engagementName, String fullNameMember, String roleMember) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Click on team link
            auditorEngagementTeamService.clickEngagementTeamMenu();
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

    @Test(priority = 27, enabled = true, description = "Verify check contact list.", dataProvider = "verifyCheckContactList", dataProviderClass = SmokeDataProvider.class)
    public void verifyCheckContactList(String auditorId, String auditorPassword, String contactName, String emailContact) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorService = new AuditorService(getLogger(), getDriver());
        contactsService = new ContactsService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {

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

    @Test(priority = 28, enabled = true, description = "Verify auditor attach file.", dataProvider = "verifyAuditorAttachFile", dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorAttachFile(String auditorId, String auditorPwd, String engagementName,
                                        String pathOfAttachLocation, String fileName, String toDoName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            getLogger().info("Verifying auditor attach a TXT file..");
            auditorCreateToDoService.auditorAttachNewFile(pathOfAttachLocation, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor attach file.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor attach file.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    @Test(priority = 29, enabled = true, description = "Verify client download attach file.", dataProvider = "verifyClientDownloadAttachFile", dataProviderClass = SmokeDataProvider.class)
    public void verifyClientDownloadAttachFile(String clientId, String clientPwd, String engagementName,
                                               String fileName, String pathOfDownloadLocation, String pathOfUploadLocation) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        clientId = GenericService.sBrowserData + clientId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(clientId, clientPwd);
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.clientDownloadAttachFile(pathOfUploadLocation, pathOfDownloadLocation, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the client download attach file", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the client download attach file", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 30, enabled = true, description = "Verify engagement overview status, todo when complete todo by using marking as complete popup", dataProvider = "verifyAuditorMarkAsComplete", dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorMarkAsComplete(String auditorId, String auditorPwd, String toDoName, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
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
            //auditorCreateToDoService.verifyAddNewToDoTask(toDoName);
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

    @Test(priority = 31, enabled = true, description = "Verify Client see Todo mark as complete", dataProvider = "verifyClientSeeMarkAsComplete", dataProviderClass = SmokeDataProvider.class)
    public void verifyClientSeeMarkAsComplete(String clientId, String clientPassword, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        clientId = GenericService.sBrowserData + clientId;

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
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
}
