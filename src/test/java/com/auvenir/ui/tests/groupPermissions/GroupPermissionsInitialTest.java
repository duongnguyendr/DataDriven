package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.dataprovider.groupPermissions.GroupPermissionsDataProvider;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.*;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

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



    //    @Test(priority = 1, enabled = true, description = "To verify admin is able to login", dataProvider = "verifyAdminLogin",
    //            dataProviderClass = SmokeDataProvider.class)
    //    public void verifyAdminLogin(, String adminPassword) {
    //        getLogger().info("Verify admin is able to login.");
    //        adminService = new AdminService(getLogger(), getDriver());
    //        auvenirService = new AuvenirService(getLogger(), getDriver());
    //        marketingService = new MarketingService(getLogger(), getDriver());
    //
    //        adminId = GenericService.sBrowserData + adminId;
    //
    //        try {
    //            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
    //            adminService.verifyPageLoad();
    //            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
    //            NXGReports.addStep("Verify admin is able to login.", LogAs.PASSED, null);
    //        } catch (Exception e) {
    //            NXGReports.addStep("Verify admin is able to login.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //            e.printStackTrace();
    //        }
    //    }

    @Test(priority = 2, enabled = true, description = "Verify Register and sign up successfully an Auditor User",
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
            auditorSignUpService
                    .registerFirmInfo(firmName, firmPreName, firmWebsite, streetAddress, officeNumber, zipCode, city, country, stateNumber, memberID,
                            numberEmployee, phoneFirm, affiliateFirmName, pathLogo);
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

    @Test(priority = 3, enabled = true, description = "Verify Admin user can change status of Auditor User from Wait-List to On Boarding.",
            dataProvider = "verifyAdminChangeStatusUserToOnBoarding", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminChangeStatusUserToOnBoarding(String adminAuditorID, String adminID, String adminAuditorGmailPwd,
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
            gmailLoginService.deleteAllExistedEmail(adminAuditorID, adminAuditorGmailPwd);

            marketingService.loginWithUserRolesUsingUsernamePassword(adminID, adminAuvenirPwd);
            adminService.changeTheStatusUser(adminAuditorID, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify Auditor user status: Active Auditor User and create a password.",
            dataProvider = "verifyAuditorLoginGmailAndActiveUser", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAuditorLoginGmailAndActiveUser(String adminAuditorID, String adminAuditorGmailPwd, String adminAuditorPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorID = GenericService.addBrowserPrefix(adminAuditorID);

        try {

            gmailLoginService.gmailLogin(adminAuditorID, adminAuditorGmailPwd);
            gmailLoginService.selectActiveEmaill();

            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();
            auditorSignUpService.createPassword(adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify Auditor User can log in with user and password. ",
            dataProvider = "verifyLoginAuditorUser", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLoginAuditorUser(String adminAuditorID, String adminAuditorPwd) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorID = GenericService.addBrowserPrefix(adminAuditorID);

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(adminAuditorID, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            marketingService.logout();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive tests case login and logout: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Test positive tests case login and logout: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 6, enabled = true, description = "Admin Auditor create new Engagement1",
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

            marketingService.loginWithUserRolesUsingUsernamePassword(adminAuditorID, adminAuditorPwd);
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

    @Test(priority = 7, enabled = true, description = "Verify that Admin Auditor can invite new member.",
            dataProvider = "verifyAdminAuditorInviteNewMemberAuditor", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorInviteNewMemberAuditor(String leadAuditorID, String leadAuditorPwd, String adminAuditorID, String adminAuditorPwd,
            String engagementName1, String leadAuditorFullName, String partnerRole, String leadAuditorGmailPwd) throws Exception {
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

            marketingService.loginWithUserRolesUsingUsernamePassword(adminAuditorID, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            auditorEngagementTeamService.deleteMemberInEngagementByName(leadAuditorFullName);

            auditorEngagementTeamService.clickInviteMember();
            auditorEngagementTeamService.inputInviteNewMemberInfo(leadAuditorFullName, leadAuditorID, partnerRole);
            auditorEngagementTeamService.verifyAddNewInvitedMember(leadAuditorFullName, partnerRole);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(leadAuditorGmailPwd);
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

    @Test(priority = 8, enabled = true, description = "Verify that Auditor can invite a client", dataProvider = "verifyAdminAuditorInvitingNewClient",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorInvitingNewClient(String adminID, String adminAuvenirPwd, String adminClientID, String adminClientEmailPwd,
            String adminAuditorID, String adminAuditorPwd, String engagementName1, String adminClientFullName, String roleClient,
            String onboardingStatus) throws Exception {
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
        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            gmailLoginService.deleteAllExistedEmail(adminClientID, adminClientEmailPwd);


            marketingService.loginWithUserRolesUsingUsernamePassword(adminAuditorID, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(adminClientFullName, adminClientID, roleClient);
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginWithUserRolesUsingUsernamePassword(adminID, adminAuvenirPwd);
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

    @Test(priority = 9, enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed",
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

    @Test(priority = 10, enabled = true, description = "Verify that client user is active successful and client log in system",
            dataProvider = "verifyClientActiveAfterSignUpSuccess", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyClientActiveAfterSignUpSuccess(String adminID, String adminAuvenirPwd, String adminClientID, String activeStatus,
            String adminClientPwd) {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());


        adminClientID = GenericService.addBrowserPrefix(adminClientID);
        adminID = GenericService.addBrowserPrefix(adminID);

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(adminID, adminAuvenirPwd);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(adminClientID, activeStatus);

            marketingService.loginWithUserRolesUsingUsernamePassword(adminClientID, adminClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 11, enabled = true, description = "Verify that lead auditor user create a engagement 2",
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
            marketingService.loginWithUserRolesUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
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

    @Test(priority = 12, enabled = true, description = "Verify that lead auditor user create a engagement 2",
            dataProvider = "verifyLeadAuditorInviteNewAuditorMember", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorInviteNewAuditorMember(String leadAuditorID, String leadAuditorPwd, String auditorID, String auditorGmailPwd,
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

            gmailLoginService.deleteAllExistedEmail(auditorID, auditorGmailPwd);

            marketingService.loginWithUserRolesUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            auditorEngagementTeamService.deleteMemberInEngagementByName(auditorFullName);

            auditorEngagementTeamService.clickInviteMember();
            auditorEngagementTeamService.inputInviteNewMemberInfo(auditorFullName, auditorID, partnerRole);
            auditorEngagementTeamService.verifyAddNewInvitedMember(auditorFullName, partnerRole);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(auditorGmailPwd);
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

    @Test(priority = 13, enabled = true, description = "Verify that Lead Auditor can invite a admin client",
            dataProvider = "verifyLeadAuditorInvitingAdminClient", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorInvitingAdminClient(String adminID, String leadAuditorID, String adminClientID, String adminClientEmailPwd,
            String leadAuditorPwd, String engagementName2, String adminClientFullName, String roleClient, String clientPhoneNumber,
            String parentStackHolder, String adminClientPwd) throws Exception {
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

        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            MongoDBService.removeClientAndIndicatedValueByEmail(adminClientID);

            gmailLoginService.deleteAllExistedEmail(adminClientID, adminClientEmailPwd);


            marketingService.loginWithUserRolesUsingUsernamePassword(leadAuditorID, leadAuditorPwd);
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


    @Test(priority = 15, enabled = true, description = "Verify Admin Client have permission to invite client via email."/*,
            dataProvider = "verifyPermissionAdminClientCanInviteClient", dataProviderClass = GroupPermissionsDataProvider.class*/)
    public void verifyPermissionAdminClientCanInviteClient() throws Exception {
        //        MongoDBService.removeClientAndIndicatedValueByEmail("auvenirclient01@gmail.com");
        //        MongoDBService.removeClientAndIndicatedValueByEmail("auvenirclient02@gmail.com");
        getLogger().info("Verify Admin Client have permission to invite client via email.");
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        String adminClientId = GenericService.addBrowserPrefix("auvenirclient01@gmail.com");
        String adminClientPassword = "Changeit@123";
        String invitedClient = "auvenirclient01@gmail.com";
        String invitedClientEmailPassword = "TESTPASSWORD";
        String adminId = "chr.auveniradm@gmail.com";
        String adminPassword = "Changeit@123";
        String engagementName = "Engagement Huy 01";
        String leadClientName = "Lead Client 01";
        String successMessage = "Your engagement invitation has been sent.";
        String onboardingStatus = "Onboarding";

        MongoDBService.removeClientAndIndicatedValueByEmail(invitedClient);
        try {
            gmailLoginService.deleteAllExistedEmail(invitedClient, invitedClientEmailPassword);

            marketingService.loginWithUserRolesUsingUsernamePassword(adminClientId, adminClientPassword);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.navigateToTeamTab();
            clientDetailsEngagementService.inviteNewMemberToTeam();
            clientService.fillInfoToInviteNewMember(leadClientName, invitedClient, "");
            clientService.verifyInviteClientSuccess(successMessage);

            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(invitedClient, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Invited Client have permission to seft-active via email."/*,
            dataProvider = "verifyPermissionAdminClientCanInviteClient", dataProviderClass = GroupPermissionsDataProvider.class*/)
    public void verifyPermissionClientCanActiveViaEmail() throws Exception {
        getLogger().info("Verify Invited Client have permission to seft-active via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        String invitedClient = "auvenirclient01@gmail.com";
        String invitedClientEmailPassword = "TESTPASSWORD";
        String phoneNumber = "0123456789";
        //String parentStackHolder = "titancorpvn";
        String clientAuvenirPassword = "Changeit@123";
        String engagementName = "Engagement Huy 01";

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(invitedClient, invitedClientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(phoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm("");
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientAuvenirPassword);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 17, enabled = true,
            description = "Verify Lead Client have permission to tranfer their Lead Permission to other Client on " + "team"/*,
            dataProvider = "verifyPermissionAdminClientCanInviteClient", dataProviderClass = GroupPermissionsDataProvider.class*/)
    public void verifyPermissionLeadPermissionCanBeTranfered() throws Exception {
        getLogger().info("Verify Admin Client have permission to invite client via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        String adminClientId = GenericService.addBrowserPrefix("auvenirclient01@gmail.com");
        String adminClientPassword = "Changeit@123";
        String engagementName = "Engagement Huy 01";
        String leadClientName = "Lead Client 01";
        String leadText = "Lead";
        String lead = "Lead";

        try {
            //gmailLoginService.deleteAllExistedEmail(invitedClient, invitedClientEmailPassword);

            marketingService.loginWithUserRolesUsingUsernamePassword(adminClientId, adminClientPassword);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.navigateToTeamTab();
            clientDetailsEngagementService.chooseLeadClientWithTeamMemberName(leadClientName, lead);
            clientDetailsEngagementService.verifyLeadSetByName(leadClientName, leadText);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    /**
     * Vien.Pham added to verify Lead Client on Todo.
     */
    @Test(priority = 25, enabled = true, description = "To verify Lead Client can remove Admin client")
    public void verifyLeadClientRemoveAdminClient() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        String leadClientID = GenericService.getTestDataFromExcel("GroupPermissionTest", "Lead Client", "Valid Value");
        String leadClientPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 1 Name", "Valid Value");

        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            clientEngagementTeamService.selectEngagementTeamMenu();
            clientEngagementTeamService.removeAdminClient("Admin Client");
            clientEngagementTeamService.verifyMessageFromRemovingAdminClient();
            clientEngagementTeamService.verifyRemoveAdminClient("Admin Client");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client remove Admin client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client remove Admin client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 26, enabled = true, description = "To verify Lead Client can invite a general client")
    public void verifyLeadClientInviteClient() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        String leadClientID = GenericService.getTestDataFromExcel("GroupPermissionTest", "Lead Client", "Valid Value");
        String leadClientPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
        String generalClient = GenericService.getTestDataFromExcel("GroupPermissionTest", "Client", "Valid Value");
        String generalClientEmailPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");
        String generalClientAuvenirPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 1 Name", "Valid Value");
        MongoDBService.removeClientAndIndicatedValueByEmail(generalClient);
        try {
            gmailLoginService.deleteAllExistedEmail(generalClient, generalClientEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            clientEngagementTeamService.selectEngagementTeamMenu();
            clientService.selectInviteNewMemberButton();
            clientService.fillInfoToInviteNewMember("Titan corporation", generalClient, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");
            gmailLoginService.gmailReLogin(generalClientEmailPassword);
            gmailLoginService.selectActiveEmaill();
            gmailLoginService.selectStartEngagementBtnToNavigateToAuvenirPage();
            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm("0123456789");
            clientSignUpService.fillUpBusinessForm("Titancorpvn");//updateStackerHolder
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(generalClientAuvenirPassword);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client invite a new general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client invite a new general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 27, enabled = true, description = "To verify Lead Client can assign todo task to general client")
    public void verifyLeadClientAssignTodoTaskToClient() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String leadClientID = GenericService.getTestDataFromExcel("GroupPermissionTest", "Lead Client", "Valid Value");
        String leadClientPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 1 Name", "Valid Value");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            clientService.selectClientAssigneeByName("vienpham", "Titan corporation");
            clientService.verifyClientAssigneeSelected("vienpham", "Titan corporation");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client assign task to general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client assign task to general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 28, enabled = true, description = "To verify general Client can view Todo task assigned ")
    public void verifyGeneralClientCanViewTodoTaskAssigned() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        String generalClient = GenericService.getTestDataFromExcel("GroupPermissionTest", "Client", "Valid Value");
        String generalClientAuvenirPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 1 Name", "Valid Value");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(generalClient, generalClientAuvenirPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            clientService.verifyToDoTaskExist("vienpham", true);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can view Todo task assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can view Todo task assigned: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 29, enabled = true, description = "To verify Lead Client can make a comment on todo assigned")
    public void verifyLeadClientMakeComment() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String leadClientID = GenericService.getTestDataFromExcel("GroupPermissionTest", "Lead Client", "Valid Value");
        String leadClientPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 1 Name", "Valid Value");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            auditorCreateToDoService.clickCommentIconPerTaskName("vienpham", true);//(todoName,isClient)
            auditorCreateToDoService.verifyInputAComment("comment 01");//commentContent
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, "comment 01");//(numberOfListCommentlist, commentContent)
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client assign task to general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client assign task to general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    /*@Test(priority = 30, enabled = true, description = "To verify general Client can view a comment made by lead client ")
    public void verifyGeneralClientCanViewComment() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(),getDriver());
        clientTodoService = new ClientTodoService(getLogger(),getDriver());
        String generalClient = GenericService.getTestDataFromExcel("GroupPermissionTest", "Client", "Valid Value");
        String generalClientAuvenirPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 1 Name", "Valid Value");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(generalClient, generalClientAuvenirPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            auditorCreateToDoService.clickCommentIconPerTaskName("vienpham", true);
            auditorCreateToDoService.verifyLastCommentOfUserDisplayed("comment 01", "Lead Client");

            clientTodoService.clickCommentIconPerTaskName("vienpham",true);
            clientTodoService.verifyLastCommentOfUserDisplayed("comment 01","Lead Clien");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client assign task to general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client assign task to general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }*/

    @Test(priority = 19, enabled = true, description = "Verify group permission Lead auditor create todo.")
    public void verifyLeadAuditorCreateTodoAndAssignClient() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String todo1 = "Todo 1";
        String todo2 = "Todo 2";
        String todo3 = "Todo 3";
        String clientAssign = "Duong Client";
        List<String> listTodo = new ArrayList<>();
        listTodo.add(todo1);
        listTodo.add(todo2);
        listTodo.add(todo3);
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
//            auditorCreateToDoService.createListToDoTask(listTodo);
            auditorCreateToDoService.createListTodoTaskWithCategoryName(listTodo, "Category 1");
            auditorCreateToDoService.checkToDoListIsExists(true, listTodo);
            for (String todo : listTodo) {
                auditorCreateToDoService.selectClientAssigneeByName(todo, clientAssign);
                auditorCreateToDoService.verifyClientAssigneeSelected(todo, clientAssign);
            }

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 21, enabled = true, description = "Verify group permission Lead auditor assign todo to general auditor.")
    public void verifyLeadAuditorAssignToGeneralAuditor() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String auditorAssign = "Auditor 007";
        String toDoName = "Todo 1";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectAuditorAssigneeByName(toDoName, auditorAssign);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(toDoName, auditorAssign);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor assign todo to general auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor assign todo to general auditor.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 25, enabled = true, description = "Verify group permission Lead auditor commenting.")
    public void verifyLeadAuditorCommenting() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String toDoName = "Todo 1";
        String commentContent = "Comment on Todo 1";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify group permission Lead auditor commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor commenting.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 26, enabled = true, description = "Verify group permission Lead auditor mark completed todo.")
    public void verifyLeadAuditorMarkCompleted() {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String toDoName = "Todo 2";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();

            auditorCreateToDoService.verifyTodoMarkCompleted(toDoName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor mark completed todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor mark completed todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 27, enabled = true, description = "Verify Lead auditor Assign ToDo Bulk Action.")
    public void verifyLeadAuditorAssignToDoBulkAction() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String auditorPwd = "Changeit@123";
        String engagementName = "Firm Auvenir Duong";
        String toDoName = "Todo 3";
        String fullNameInvitedMember = "Auditor 007";
        String fullNameInvitedClient = "Duong Client";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(fullNameInvitedMember);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(toDoName, fullNameInvitedMember);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(fullNameInvitedClient);
            auditorCreateToDoService.verifyClientAssigneeSelected(toDoName, fullNameInvitedClient);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead auditor Assign ToDo Bulk Action.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead auditor Assign ToDo Bulk Action.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 28, enabled = true, description = "Verify group permission Lead auditor delete todo.")
    public void verifyLeadAuditorDeleteTodo() {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String toDoName = "Todo 3";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.scrollUp(getDriver());
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(toDoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor delete todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission Lead auditor delete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 29, enabled = true, description = "Verify group permission Lead auditor download from all todo.")
    public void verifyLeadAuditorDownloadFromAllTodo() {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        try {
            auditorCreateToDoService.checkFileDownloadExisted(fileDownload);
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.clickToBulkDownloadAttachmentButton();
            auditorCreateToDoService.clickDownloadAllTodo();
            auditorCreateToDoService.verifyDownloadFileAllTodoSuccess(fileDownload);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor download from all todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission Lead auditor download from all todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 30, enabled = true, description = "Verify group permission General auditor create todo.")
    public void verifyGeneralAuditorCreateTodo() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String todo4 = "Todo 4";
        String todo5 = "Todo 5";
        String todo6 = "Todo 6";
        String clientAssign = "Duong Client";
        List<String> listTodo = new ArrayList<>();
        listTodo.add(todo4);
        listTodo.add(todo5);
        listTodo.add(todo6);
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorCreateToDoService.createListTodoTaskWithCategoryName(listTodo, "Category 1");
            auditorCreateToDoService.checkToDoListIsExists(true, listTodo);

            auditorCreateToDoService.selectClientAssigneeByName(todo4, clientAssign);
            auditorCreateToDoService.verifyClientAssigneeSelected(todo4, clientAssign);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 36, enabled = true, description = "Verify group permission General auditor commenting.")
    public void verifyGeneralAuditorCommenting() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String toDoName = "Todo 4";
        String commentContent = "Comment on Todo 4";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify group permission General auditor commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor commenting.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 37, enabled = true, description = "Verify group permission General auditor mark completed todo.")
    public void verifyGeneralAuditorMarkCompleted() throws Exception{
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String toDoName = "Todo 5";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();

            auditorCreateToDoService.verifyTodoMarkCompleted(toDoName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor mark completed todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor mark completed todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 38, enabled = true, description = "Verify group permission General auditor delete todo.")
    public void verifyGeneralAuditorDeleteTodo() {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String toDoName = "Todo 6";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.scrollUp(getDriver());
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(toDoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor delete todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission General auditor delete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 39, enabled = true, description = "Verify group permission General auditor download from all todo.")
    public void verifyGeneralAuditorDownloadFromAllTodo() {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Firm Auvenir Duong";
        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        try {
            auditorCreateToDoService.checkFileDownloadExisted(fileDownload);
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.clickToBulkDownloadAttachmentButton();
            auditorCreateToDoService.clickDownloadAllTodo();
            auditorCreateToDoService.verifyDownloadFileAllTodoSuccess(fileDownload);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor download from all todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission General auditor download from all todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
}
