package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.dataprovider.groupPermissions.GroupPermissionsDataProvider;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.*;
import com.auvenir.ui.services.groupPermissions.AdminAuditorService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huy.huynh on 19/07/2017.
 */
public class GroupPermissionsInitialTest extends AbstractTest {
    private AdminService adminService;
    private AuvenirService auvenirService;
    private AuditorService auditorService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorEngagementTeamService auditorEngagementTeamService;
    private GmailLoginService gmailLoginService;
    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;
    private EmailTemplateService emailTemplateService;
    private AuditorTodoListService auditorTodoListService;
    private ClientService clientService;
    private ClientEngagementTeamService clientEngagementTeamService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private ClientSignUpService clientSignUpService;
    private ClientDetailsEngagementService clientDetailsEngagementService;
    private ClientEngagementService clientEngagementService;
    private ClientTodoService clientTodoService;
    private AdminAuditorService adminAuditorService;

    @Test(priority = 1, enabled = true, description = "Verify Normal Admin is able to login", dataProvider = "verifySuperAdminLogin",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifySuperAdminLogin(String superAdminUser, String superAdminPwd) {
        getLogger().info("Verify admin is able to login.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        superAdminUser = GenericService.sBrowserData + superAdminUser;

        try {
            marketingService.loginUsingUsernamePassword(superAdminUser, superAdminPwd);
            adminService.verifyPageLoad();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Super Admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Super Admin is able to login.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }
    @Test(priority = 1, enabled = true, description = "Verify Normal Admin is able to login", dataProvider = "verifyAdminLogin",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminLogin(String adminId, String adminPwd) {
        getLogger().info("Verify admin is able to login.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminId = GenericService.sBrowserData + adminId;

        try {
            marketingService.loginUsingUsernamePassword(adminId, adminPwd);
            adminService.verifyPageLoad();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Normal Admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Normal Admin is able to login.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }
    @Test(priority = 1, enabled = true, description = "Verify Register and sign up successfully an Auditor User", testName = "if_1",
            dataProvider = "verifySignUpAuditorUser", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifySignUpAuditorUser(String adminAuditorID, String adminAuditorFullName, String firmName, String roleFirm, String phoneNumber,
            String referenceToAuvenir, String firmPreName, String firmWebsite, String streetAddress, String officeNumber, String zipCode, String city,
            String country, String stateNumber, String memberID, String numberEmployee, String phoneFirm, String affiliateFirmName,
            String pathLogo) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorID = GenericService.addBrowserPrefix(adminAuditorID);

        try {
            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            MongoDBService.removeAllActivitiesCollectionOfAUser(adminAuditorID);
            MongoDBService.removeAllFirmByName(firmName);
            MongoDBService.removeEngagementCreatedByLeadAuditor(adminAuditorID);

            auditorSignUpService.deleteUserUsingApi(adminAuditorID);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(adminAuditorFullName, adminAuditorID, roleFirm, phoneNumber, referenceToAuvenir);
            auditorSignUpService.registerFirmInfo(firmName, firmPreName, firmWebsite, streetAddress, officeNumber, zipCode, city, country,
                    stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName, pathLogo);
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Auditor SignUp from Marketing Page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Auditor SignUp from Marketing Page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify Admin user can change status of Auditor User from Wait-List to On Boarding.",
            testName = "if_2", dataProvider = "verifyAdminChangeStatusUserToOnBoarding", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminChangeStatusToOnBoarding(String adminAuditorID, String adminID, String adminAuditorEmailPwd,
            String adminAuvenirPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorID = GenericService.addBrowserPrefix(adminAuditorID);
        adminID = GenericService.addBrowserPrefix(adminID);

        try {
            gmailLoginService.deleteAllExistedEmail(adminAuditorID, adminAuditorEmailPwd);
            marketingService.loginUsingUsernamePassword(adminID, adminAuvenirPwd);
            adminService.changeTheStatusUser(adminAuditorID, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Admin user change status of Auditor to OnBoarding: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Admin user change status of Auditor to OnBoarding: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify Auditor user status: Active Auditor User and create a password.", testName = "if_3",
            dataProvider = "verifyAuditorLoginGMailAndActiveUser", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAuditorLoginGMailAndActiveUser(String adminAuditorID, String adminAuditorEmailPwd, String adminAuditorPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorID = GenericService.addBrowserPrefix(adminAuditorID);

        try {

            gmailLoginService.gmailLogin(adminAuditorID, adminAuditorEmailPwd);
            gmailLoginService.selectActiveEmaill();

            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();
            auditorSignUpService.createPassword(adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Admin Auditor be active: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Admin Auditor be active: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "Admin Auditor create new Engagement1", testName = "if_4",
            dataProvider = "verifyAdminAuditorCreateSimpleEngagement", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCreateSimpleEngagement(String adminAuditorID, String engagementName1, String companyName, String adminAuditorPwd) {
        getLogger().info("Admin Auditor create new Engagement1 (simple engagement).");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminAuditorID = GenericService.addBrowserPrefix(adminAuditorID);
        MongoDBService.removeEngagementCreatedByLeadAuditor(adminAuditorID, engagementName1);
        MongoDBService.removeAllBusinessByName(companyName);

        try {

            marketingService.loginUsingUsernamePassword(adminAuditorID, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName1, "", companyName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify that Admin Auditor can invite new member.", testName = "if_6, if_9",
            dataProvider = "verifyAdminAuditorInviteNewMemberAuditor", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorInviteNewMemberAuditor(String leadAuditorID, String leadAuditorPwd, String adminAuditorID, String adminAuditorPwd,
            String engagementName1, String leadAuditorFullName, String partnerRole, String leadAuditorEmailPwd) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        adminAuditorID = GenericService.addBrowserPrefix(adminAuditorID);
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);

        MongoDBService.removeAllActivitiesCollectionOfAUser(leadAuditorID);
        MongoDBService.removeEngagementCreatedByLeadAuditor(leadAuditorID);
        auditorSignUpService.deleteUserUsingApi(leadAuditorID);

        try {
            gmailLoginService.deleteAllExistedEmail(leadAuditorID, leadAuditorPwd);

            marketingService.loginUsingUsernamePassword(adminAuditorID, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            auditorEngagementTeamService.deleteMemberInEngagementByName(leadAuditorFullName);

            auditorEngagementTeamService.clickInviteMember();
            auditorEngagementTeamService.inputInviteNewMemberInfo(leadAuditorFullName, leadAuditorID, partnerRole);
            auditorEngagementTeamService.verifyAddNewInvitedMember(leadAuditorFullName, partnerRole);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(leadAuditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.confirmInfomationNewAuditorUser(leadAuditorFullName, leadAuditorID, leadAuditorPwd);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Add New Member Auditor", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test script Failed: Verify Add New Member Auditor", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /////// Test case verifyAdminAuditorInvitingNewClient, verifyClientLogsInAndActive, verifyClientActiveAfterSignUpSuccess will be uncomment to
    // run after the issue ( the System cannot add client member ) is fixed.

    @Test(priority = 8, enabled = true, description = "Verify that Auditor can invite a client", testName = "if_8",
            dataProvider = "verifyAdminAuditorInvitingNewClient", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorInvitingNewClient(String adminID, String adminAuvenirPwd, String adminClientID, String adminClientEmailPwd,
            String adminAuditorID, String adminAuditorPwd, String engagementName1, String adminClientFullName, String roleClient,
            String onboardingStatus, String leadClientID, String clientID) throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        adminAuditorID = GenericService.addBrowserPrefix(adminAuditorID);
        adminID = GenericService.addBrowserPrefix(adminID);
        adminClientID = GenericService.addBrowserPrefix(adminClientID);

        MongoDBService.removeClientAndIndicatedValueByEmail(adminClientID);
        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientID);
        MongoDBService.removeClientAndIndicatedValueByEmail(clientID);
        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            gmailLoginService.deleteAllExistedEmail(adminClientID, adminClientEmailPwd);


            marketingService.loginUsingUsernamePassword(adminAuditorID, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(adminClientFullName, adminClientID, roleClient);
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginUsingUsernamePassword(adminID, adminAuvenirPwd);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(adminClientID, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 9, enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed", testName = "if_8",
            dataProvider = "verifyClientLogsInAndActive", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyClientLogsInAndActive(String adminClientID, String adminClientEmailPwd, String clientPhoneNumber, String parentStackHolder,
            String adminClientPwd, String engagementName1) throws Exception {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        adminClientID = GenericService.addBrowserPrefix(adminClientID);

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(adminClientID, adminClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(adminClientPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 10, enabled = true, description = "Verify that lead auditor user create a engagement 2", testName = "if_10",
            dataProvider = "verifyLeadAuditorCreateNewEngagement", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCreateNewEngagement(String leadAuditorID, String leadAuditorPwd, String engagementName2, String companyName) {
        getLogger().info("Lead Auditor create new Engagement2.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);

        try {
            MongoDBService.removeEngagementCreatedByLeadAuditor(leadAuditorID, engagementName2);
            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName2, "", companyName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 11, enabled = true, description = "Verify that Lead Auditor can invite a admin client", testName = "if_11",
            dataProvider = "verifyLeadAuditorInvitingAdminClient", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorInvitingAdminClient(String adminID, String leadAuditorID, String adminClientID, String adminClientEmailPwd,
            String leadAuditorPwd, String engagementName2, String adminClientFullName, String roleClient, String clientPhoneNumber,
            String parentStackHolder, String adminClientPwd, String leadClientID, String clientID) throws Exception {
        getLogger().info("Verify Lead Auditor inviting a admin client.");
        // This test case should invite a admin client by add member client (a client is existed in the system)
        // But due to the issue that system cannot add a client member, this test case will invite new Admin client.
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        adminID = GenericService.addBrowserPrefix(adminID);
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);
        adminClientID = GenericService.addBrowserPrefix(adminClientID);
        leadClientID = GenericService.addBrowserPrefix(leadClientID);
        clientID = GenericService.addBrowserPrefix(clientID);

        //need precondition for save engagement name, and delete this engagement or client on acl

        MongoDBService.removeClientAndIndicatedValueByEmail(adminClientID);
        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientID);
        MongoDBService.removeClientAndIndicatedValueByEmail(clientID);

        try {
            gmailLoginService.deleteAllExistedEmail(adminClientID, adminClientEmailPwd);

            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(adminClientFullName, adminClientID, roleClient);
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            gmailLoginService.gmailReLogin(adminClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(adminClientPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
            throw e;
        }
    }

    @Test(priority = 12, enabled = true, description = "Verify that lead auditor user create a engagement 2", testName = "if_12, if_13",
            dataProvider = "verifyLeadAuditorInviteNewAuditorMember", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorInviteNewAuditorMember(String leadAuditorID, String leadAuditorPwd, String auditorID, String auditorEmailPwd,
            String auditorPwd, String engagementName2, String auditorFullName, String partnerRole) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);
        auditorID = GenericService.addBrowserPrefix(auditorID);

        try {
            MongoDBService.removeAllActivitiesCollectionOfAUser(auditorID);
            auditorSignUpService.deleteUserUsingApi(auditorID);

            gmailLoginService.deleteAllExistedEmail(auditorID, auditorEmailPwd);

            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            auditorEngagementTeamService.deleteMemberInEngagementByName(auditorFullName);

            auditorEngagementTeamService.clickInviteMember();
            auditorEngagementTeamService.inputInviteNewMemberInfo(auditorFullName, auditorID, partnerRole);
            auditorEngagementTeamService.verifyAddNewInvitedMember(auditorFullName, partnerRole);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(auditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.confirmInfomationNewAuditorUser(auditorFullName, auditorID, auditorPwd);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Add New Member Auditor", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test script Failed: Verify Add New Member Auditor", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    @Test(priority = 15, enabled = true, description = "Verify Admin Client have permission to invite client via email.", testName = "if_15",
            dataProvider = "verifyPermissionAdminClientCanInviteClient", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyPermissionAdminClientCanInviteClient(String adminClientID, String adminClientPwd, String leadClientID,
            String leadClientEmailPwd, String adminID, String adminAuvenirPwd, String engagementName2, String leadClientFullName,
            String successMessageInvitation, String onboardingStatus, String roleClient) throws Exception {

        getLogger().info("Verify Admin Client have permission to invite client via email.");
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        leadClientID = GenericService.addBrowserPrefix(leadClientID);
        adminClientID = GenericService.addBrowserPrefix(adminClientID);
        adminID = GenericService.addBrowserPrefix(adminID);

        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientID);
        try {
            gmailLoginService.deleteAllExistedEmail(leadClientID, leadClientEmailPwd);

            marketingService.loginUsingUsernamePassword(adminClientID, adminClientPwd);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.navigateToTeamTab();
            clientDetailsEngagementService.inviteNewMemberToTeam();
            clientService.fillInfoToInviteNewMember(leadClientFullName, leadClientID, roleClient);
            clientService.verifyInviteClientSuccess(successMessageInvitation);

            marketingService.loginUsingUsernamePassword(adminID, adminAuvenirPwd);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(leadClientID, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Invited Client have permission to seft-active via email.", testName = "if_16",
            dataProvider = "verifyPermissionClientCanActiveViaEmail", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyPermissionClientCanActiveViaEmail(String leadClientID, String leadClientEmailPwd, String clientPhoneNumber,
            String parentStackHolder, String leadClientPwd, String engagementName2) throws Exception {
        getLogger().info("Verify Invited Client have permission to seft-active via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        leadClientID = GenericService.addBrowserPrefix(leadClientID);

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(leadClientID, leadClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(leadClientPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify Lead Client have permission to tranfer their Lead Permission to other Client on team",
            testName = "if_17", dataProvider = "verifyPermissionLeadPermissionCanBeTranfered", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyPermissionLeadPermissionCanBeTranfered(String adminClientID, String adminClientPwd, String engagementName2,
            String leadClientFullName, String leadText) throws Exception {
        getLogger().info("Verify Admin Client have permission to invite client via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        adminClientID = GenericService.addBrowserPrefix(adminClientID);

        try {
            marketingService.loginUsingUsernamePassword(adminClientID, adminClientPwd);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.navigateToTeamTab();
            clientDetailsEngagementService.chooseLeadClientWithTeamMemberName(leadClientFullName);
            clientDetailsEngagementService.verifyLeadSetByName(leadClientFullName, leadText);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify group permission Lead auditor create todo.", testName = "if_18, if_19, if_20",
            dataProvider = "verifyLeadAuditorCreateTodoAndAssignClient", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCreateTodoAndAssignClient(String leadAuditorID, String leadAuditorPwd,
            String engagementName2, String todo1, String todo2, String todo3, String leadClientFullName, String categoryName) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);
//        leadAuditorID = "duongauvenir01@gmail.com";
//        engagementName2 = "Engagement HD";
//        leadClientFullName = "Client ABC";
        List<String> listTodo = new ArrayList<>();
        listTodo.add(todo1);
        listTodo.add(todo2);
        listTodo.add(todo3);
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorCreateToDoService.createListTodoTaskWithCategoryName(listTodo, categoryName);
            auditorCreateToDoService.verifyLeadAuditorSeeListToDoTask(true, listTodo);
            for (String todo : listTodo) {
                auditorCreateToDoService.selectClientAssigneeByName(todo, leadClientFullName);
                auditorCreateToDoService.verifyClientAssigneeSelected(todo, leadClientFullName);
            }

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 21, enabled = true, description = "Verify group permission Lead auditor assign todo to general auditor.", testName = "if_21",
            dataProvider = "verifyLeadAuditorAssignToGeneralAuditor", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorAssignToGeneralAuditor(String leadAuditorID, String leadAuditorPwd, String engagementName2,
            String todo1, String auditorFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);
//        String auditorId = "duongauvenir01@gmail.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String auditorAssign = "Auditor 007";
//        String toDoName = "Todo 1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectAuditorAssigneeByName(todo1, auditorFullName);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(todo1, auditorFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor assign todo to general auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor assign todo to general auditor.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 25, enabled = true, description = "Verify group permission Lead auditor commenting.", testName = "if_25",
            dataProvider = "verifyLeadAuditorCommenting", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCommenting(String leadAuditorID, String leadAuditorPwd, String engagementName2, String todo1,
            String leadClientFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);

//        String auditorId = "duongauvenir01@gmail.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String toDoName = "Todo 1";
//        String commentContent = "Comment on Todo 1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo1);
            auditorCreateToDoService.clickCommentIconPerTaskName(todo1);
            auditorCreateToDoService.verifyInputAComment(leadClientFullName);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, leadClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify group permission Lead auditor commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor commenting.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 26, enabled = true, description = "Verify group permission Lead auditor mark completed todo.", testName = "if_26",
            dataProvider = "verifyLeadAuditorMarkCompleted", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorMarkCompleted(String leadAuditorID, String leadAuditorPwd, String engagementName2, String todo2) {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);

//        String auditorId = "duongauvenir01@gmail.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String toDoName = "Todo 2";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo2);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();

            auditorCreateToDoService.verifyTodoMarkCompleted(todo2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor mark completed todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor mark completed todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 27, enabled = true, description = "Verify Lead auditor Assign ToDo Bulk Action.", testName = "if_27",
            dataProvider = "verifyLeadAuditorAssignToDoBulkAction", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorAssignToDoBulkAction(String leadAuditorID, String leadAuditorPwd, String engagementName2,
            String todo3, String auditorFullName, String leadClientFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);

//        String auditorId = "duongauvenir01@gmail.com";
//        String auditorPwd = "Changeit@123";
//        String engagementName = "Firm Auvenir Duong";
//        String toDoName = "Todo 3";
//        String fullNameInvitedMember = "Auditor 007";
//        String fullNameInvitedClient = "Duong Client";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo3);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(auditorFullName);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(todo3, auditorFullName);

            auditorCreateToDoService.selectToDoTaskName(todo3);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(leadClientFullName);
            auditorCreateToDoService.verifyClientAssigneeSelected(todo3, leadClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead auditor Assign ToDo Bulk Action.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead auditor Assign ToDo Bulk Action.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 28, enabled = true, description = "Verify group permission Lead auditor delete todo.", testName = "if_28",
            dataProvider = "verifyLeadAuditorDeleteTodo", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorDeleteTodo(String leadAuditorID, String leadAuditorPwd, String engagementName2, String todo3) throws Exception{
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);

//        String auditorId = "duongauvenir01@gmail.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String toDoName = "Todo 3";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo3);
            auditorCreateToDoService.scrollUp(getDriver());
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(todo3);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor delete todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission Lead auditor delete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 29, enabled = true, description = "Verify group permission Lead auditor download from all todo.", testName = "if_29",
            dataProvider = "verifyLeadAuditorDownloadFromAllTodo", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorDownloadFromAllTodo(String leadAuditorID, String leadAuditorPwd, String engagementName2, String pathDownload) throws Exception{
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorID = GenericService.addBrowserPrefix(leadAuditorID);
        String fileName = pathDownload + engagementName2 + ".zip";
//        String auditorId = "duongauvenir01@gmail.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        try {
            auditorCreateToDoService.checkFileDownloadExisted(fileName);
            marketingService.loginUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.clickToBulkDownloadAttachmentButton();
            auditorCreateToDoService.clickDownloadAllTodo();
            auditorCreateToDoService.verifyDownloadFileAllTodoSuccess(fileName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor download from all todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission Lead auditor download from all todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 30, enabled = true, description = "Verify group permission General auditor create todo.", testName = "if_30, if_31, if_33",
            dataProvider = "verifyGeneralAuditorCreateTodo", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorCreateTodo(String auditorID, String auditorPwd, String engagementName2,
            String todo4, String todo5, String todo6, String leadClientFullName, String categoryName) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorID = GenericService.addBrowserPrefix(auditorID);
//        String auditorId = "auditor007@mailinator.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String todo4 = "Todo 4";
//        String todo5 = "Todo 5";
//        String todo6 = "Todo 6";
//        String clientAssign = "Duong Client";
        List<String> listTodo = new ArrayList<>();
        listTodo.add(todo4);
        listTodo.add(todo5);
        listTodo.add(todo6);
        try {
            marketingService.loginUsingUsernamePassword(auditorID, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorCreateToDoService.createListTodoTaskWithCategoryName(listTodo, categoryName);
            auditorCreateToDoService.checkToDoListIsExists(true, listTodo);

            auditorCreateToDoService.selectClientAssigneeByName(todo4, leadClientFullName);
            auditorCreateToDoService.verifyClientAssigneeSelected(todo4, leadClientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 36, enabled = true, description = "Verify group permission General auditor commenting.", testName = "if_36",
            dataProvider = "verifyGeneralAuditorCommenting", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorCommenting(String auditorID, String auditorPwd, String engagementName2,
            String todo4, String generalAuditorCmt) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorID = GenericService.addBrowserPrefix(auditorID);

//        String auditorId = "auditor007@mailinator.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String toDoName = "Todo 4";
//        String commentContent = "Comment on Todo 4";
        try {
            marketingService.loginUsingUsernamePassword(auditorID, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo4);
            auditorCreateToDoService.clickCommentIconPerTaskName(todo4);
            auditorCreateToDoService.verifyInputAComment(generalAuditorCmt);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, generalAuditorCmt);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify group permission General auditor commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor commenting.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 37, enabled = true, description = "Verify group permission General auditor mark completed todo.", testName = "if_37",
            dataProvider = "verifyGeneralAuditorMarkCompleted", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorMarkCompleted(String auditorID, String auditorPwd, String engagementName2, String todo5) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorID = GenericService.addBrowserPrefix(auditorID);
//        String auditorId = "auditor007@mailinator.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String toDoName = "Todo 5";
        try {
            marketingService.loginUsingUsernamePassword(auditorID, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo5);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();

            auditorCreateToDoService.verifyTodoMarkCompleted(todo5);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor mark completed todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor mark completed todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 38, enabled = true, description = "Verify group permission General auditor delete todo.", testName = "if_38",
            dataProvider = "verifyGeneralAuditorDeleteTodo", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorDeleteTodo(String auditorID, String auditorPwd, String engagementName2, String todo5) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorID = GenericService.addBrowserPrefix(auditorID);
//        String auditorId = "auditor007@mailinator.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String toDoName = "Todo 6";
        try {
            marketingService.loginUsingUsernamePassword(auditorID, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo5);
            auditorCreateToDoService.scrollUp(getDriver());
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(todo5);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor delete todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission General auditor delete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 39, enabled = true, description = "Verify group permission General auditor download from all todo.", testName = "if_39",
            dataProvider = "verifyGeneralAuditorDownloadFromAllTodo", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorDownloadFromAllTodo(String auditorID, String auditorPwd, String engagementName2, String pathDownload) throws Exception{
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorID = GenericService.addBrowserPrefix(auditorID);
//        String auditorId = "auditor007@mailinator.com";
//        String password = "Changeit@123";
//        String engagement = "Firm Auvenir Duong";
//        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        String fileName = pathDownload + engagementName2 + ".zip";
        try {
            auditorCreateToDoService.checkFileDownloadExisted(fileName);
            marketingService.loginUsingUsernamePassword(auditorID, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.clickToBulkDownloadAttachmentButton();
            auditorCreateToDoService.clickDownloadAllTodo();
            auditorCreateToDoService.verifyDownloadFileAllTodoSuccess(fileName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor download from all todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission General auditor download from all todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Vien.Pham added to verify Lead Client on Todo.
     */

    @Test(priority = 40, enabled = true, description = "Verify Lead Client can see all to-dos", testName = "if_40")
    public void verifyLeadClientSeeToDo() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        String leadClientID = "chr.vienpham.client.lead@gmail.com";
        String leadClientPassword = "Changeit@123";
        String engagementName = "Vien_Engagement";
        String toDoListNames[] = {"vientodo1", "vientodo2", "vientodo3", "vientodo4"};
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientEngagementService.verifyDetailsEngagement(engagementName);
            clientTodoService.verifyClientSeeListTodos(Arrays.asList(toDoListNames));
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 41, enabled = true, description = "To verify Lead Client can remove Admin client", testName = "if_41",
            dataProvider = "verifyLeadClientRemoveAdminClient", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientRemoveAdminClient(String leadClientID, String leadClientPwd, String engagementName2, String adminClientFullName,
            String successMessageRemoveTeamMember) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        leadClientID = GenericService.addBrowserPrefix(leadClientID);
        //        String leadClientPassword = "Changeit@123";
        //        String engagementName = "Engagement GP02";
        //        String adminClientFullName = "Admin Client";
        //        String successMessageRemoveTeamMember = "Your team member has been removed.";
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientEngagementService.verifyDetailsEngagement(engagementName2);
            clientEngagementTeamService.selectEngagementTeamMenu();
            clientEngagementTeamService.removeAdminClient(adminClientFullName);
            clientEngagementTeamService.verifyMessageFromRemovingAdminClient(successMessageRemoveTeamMember);
            clientEngagementTeamService.verifyRemoveAdminClient(adminClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can remove Admin client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can remove Admin client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 42, enabled = true, description = "To verify Lead Client can invite a general client", testName = "if_42",
            dataProvider = "verifyLeadClientInviteClient", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientInviteClient(String leadClientID, String leadClientPwd, String clientID, String clientEmailPwd,
            String engagementName2, String clientFullName, String successMessageInvitation, String roleClient) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        leadClientID = GenericService.addBrowserPrefix(leadClientID);
        //        String leadClientPassword = "Changeit@123";
        clientID = GenericService.addBrowserPrefix(clientID);
        //        String generalClientEmailPassword = "Changeit@123";
        //        String engagementName = "Engagement GP02";
        //        String generalClientFullName = "General Client";
        //        String successMessage = "Your engagement invitation has been sent.";

        MongoDBService.removeClientAndIndicatedValueByEmail(clientID);
        try {
            gmailLoginService.deleteAllExistedEmail(clientID, clientEmailPwd);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientEngagementService.verifyDetailsEngagement(engagementName2);
            clientEngagementTeamService.selectEngagementTeamMenu();
            clientService.selectInviteNewMemberButton();
            clientService.fillInfoToInviteNewMember(clientFullName, clientID, roleClient);
            clientService.verifyInviteClientSuccess(successMessageInvitation);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can invite a new general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can invite a new general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 43, enabled = true, description = "Verify general Client can active from invited", testName = "if_43",
            dataProvider = "verifyGeneralClientActive", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralClientActive(String clientID, String clientEmailPwd, String clientPwd, String engagementName2, String phoneNumber,
            String parentStackHolder) {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientID = GenericService.addBrowserPrefix(clientID);
        //        String generalClientEmailPassword = "Changeit@123";
        //        String generalClientAuvenirPassword = "Changeit@123";
        //        String engagementName = "Vien_Engagement";
        //        String phoneNumber = "1234567890";
        //        String stackerHolder = "Titancorpvn";

        try {
            gmailLoginService.gmailLogin(clientID, clientEmailPwd);
            gmailLoginService.selectActiveEmaill();
            gmailLoginService.selectStartEngagementBtnToNavigateToAuvenirPage();
            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(phoneNumber);
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can invite a new general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can invite a new general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 44, enabled = true, description = "To verify Lead Client can assign todo task to general client", testName = "if_44, if_48")
    public void verifyLeadClientAssignTodoTaskToClient() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        String leadClientID = GenericService.addBrowserPrefix("vienpham.client.lead@gmail.com");
        String leadClientPassword = "Changeit@123";
        String engagementName = "Vien_Engagement";
        String todoName = "vientodo";
        String clientAssignee = "General Client";
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientEngagementService.verifyDetailsEngagement(engagementName);
            clientService.selectClientAssigneeByName(todoName, clientAssignee);
            clientService.verifyClientAssigneeSelected(todoName, clientAssignee);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can assign task to general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can assign task to general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 47, enabled = true, description = "Verify Lead Client can make a comment on todo assigned", testName = "if_47")
    public void verifyLeadClientMakeComment() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        String leadClientID = GenericService.addBrowserPrefix("vienpham.client.lead@gmail.com");
        String leadClientPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 01";
        String engagementName = "Vien_Engagement";

        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientEngagementService.verifyDetailsEngagement(engagementName);
            clientTodoService.clickCommentIconPerTaskName(todoName, true);
            clientTodoService.verifyInputAComment(commentContent);
            int numberOfListCommentList = clientTodoService.getNumberOfListComment();
            clientTodoService.clickOnPostCommentButton();
            clientTodoService.verifyNewCommentIsDisplayed(numberOfListCommentList, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Client can make a comment on todo assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Client can make a comment on todo assigned: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 48, enabled = true, description = "Verify general Client can view a comment made by lead client ", testName = "if_47")
    public void verifyGeneralClientCanViewComment() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        String generalClient = GenericService.addBrowserPrefix("auvenirclient2@gmail.com");
        String generalClientAuvenirPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 01";
        String engagementName = "Vien_Engagement";
        String leadClientFullName = "Lead Client";
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(generalClient, generalClientAuvenirPassword);
           /* auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);*/
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientEngagementService.verifyDetailsEngagement(engagementName);
            clientTodoService.clickCommentIconPerTaskName(todoName, true);
            clientTodoService.verifyLastCommentOfUserDisplayed(commentContent, leadClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can view a comment made by lead client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can view a comment made by lead client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 50, enabled = true, description = "To verify general Client can view Todo task assigned ", testName = "if_50")
    public void verifyGeneralClientCanViewTodoTaskAssigned() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        String generalClient = GenericService.addBrowserPrefix("auvenirclient2@gmail.com");
        String generalClientAuvenirPassword = "Changeit@123";
        String engagementName = "Vien_Engagement";
        String todoName = "vientodo";
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(generalClient, generalClientAuvenirPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientEngagementService.verifyDetailsEngagement(engagementName);
            clientService.verifyToDoTaskExist(todoName, true);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can view Todo task assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can view Todo task assigned: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 53, enabled = true, description = "Verify general Client can make a comment on todo assigned", testName = "if_53")
    public void verifyGeneralClientMakeComment() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        String generalClient = GenericService.addBrowserPrefix("auvenirclient2@gmail.com");
        String generalClientAuvenirPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 02";
        String engagementName = "Vien_Engagement";

        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(generalClient, generalClientAuvenirPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientEngagementService.verifyDetailsEngagement(engagementName);
            clientTodoService.clickCommentIconPerTaskName(todoName, true);
            clientTodoService.verifyInputAComment(commentContent);
            int numberOfListCommentList = clientTodoService.getNumberOfListComment();
            clientTodoService.clickOnPostCommentButton();
            clientTodoService.verifyNewCommentIsDisplayed(numberOfListCommentList, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can make a comment on todo assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can make a comment on todo assigned: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 54, enabled = true, description = "Verify Lead Client can view a comment made by general client ", testName = "if_53")
    public void verifyLeadClientCanViewComment() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        String leadClientID = GenericService.addBrowserPrefix("vienpham.client.lead@gmail.com");
        String leadClientPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 02";
        String engagementName = "Vien_Engagement";
        String generalClientFullName = "General Client";
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientEngagementService.verifyDetailsEngagement(engagementName);
            clientTodoService.clickCommentIconPerTaskName(todoName, true);
            clientTodoService.verifyLastCommentOfUserDisplayed(commentContent, generalClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Client can view a comment made by general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify lead Client can view a comment made by general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }
    /**
     * End of Vien Pham
     */
}
