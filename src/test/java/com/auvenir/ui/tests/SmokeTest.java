package com.auvenir.ui.tests;

import com.auvenir.ui.dataprovider.SmokeDataProvider;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.*;
import com.auvenir.ui.services.groupPermissions.AdminAuditorService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.MarketingService;
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

    @Test(/*priority = 1,*/ enabled = true, description = "Verify Normal Admin is able to login", alwaysRun = true,
            dataProvider = "verifySuperAdminLogin", dataProviderClass = SmokeDataProvider.class)
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
            NXGReports.addStep("SmokeTest: Verify Super Admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("SmokeTest: Verify Super Admin is able to login.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 2, */enabled = true, description = "Verify Normal Admin is able to login", dependsOnMethods = {"verifySuperAdminLogin"},
            alwaysRun = true, dataProvider = "verifyAdminLogin", dataProviderClass = SmokeDataProvider.class)
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
            NXGReports.addStep("SmokeTest: Verify Normal Admin is able to login:Passed", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("SmokeTest: Verify Normal Admin is able to login:Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 3, */enabled = true, description = "Verify Register and sign up successfully an Auditor User",
            dependsOnMethods = {"verifyAdminLogin"}, alwaysRun = true, dataProvider = "verifySignUpAuditorUser",
            dataProviderClass = SmokeDataProvider.class)
    public void verifySignUpAuditorUser(String adminAuditorEmail, String adminAuditorFullName, String firmName, String roleFirm, String phoneNumber,
            String referenceToAuvenir, String firmPreName, String firmWebsite, String streetAddress, String officeNumber, String zipCode, String city,
            String country, String stateNumber, String memberEmail, String numberEmployee, String phoneFirm, String affiliateFirmName,
            String pathLogo) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);

        try {
            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            MongoDBService.removeAllActivitiesCollectionOfAUser(adminAuditorEmail);
            MongoDBService.removeAllFirmByName(firmName);
            MongoDBService.removeEngagementCreatedByLeadAuditor(adminAuditorEmail);

            auditorSignUpService.deleteUserUsingApi(adminAuditorEmail);

            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            System.out.println("phoneNumber = " + phoneNumber);
            auditorSignUpService.registerAuditorPersonal(adminAuditorFullName, adminAuditorEmail, roleFirm, phoneNumber, referenceToAuvenir);
            auditorSignUpService
                    .registerFirmInfo(firmName, firmPreName, firmWebsite, streetAddress, officeNumber, zipCode, city, country, stateNumber,
                            memberEmail, numberEmployee, phoneFirm, affiliateFirmName, pathLogo);
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Admin auditor sign up from marketing page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("SmokeTest: Admin auditor sign up from marketing page: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 4, */enabled = true, description = "Verify Admin user can change status of Auditor User from Wait-List to On Boarding.",
            testName = "if_2", dependsOnMethods = {"verifySignUpAuditorUser"}, alwaysRun = true,
            dataProvider = "verifyAdminChangeStatusUserToOnBoarding", dataProviderClass = SmokeDataProvider.class)
    public void verifyAdminChangeStatusUserToOnBoarding(String adminAuditorEmail, String adminEmail, String adminAuditorEmailPwd,
            String adminAuvenirPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        adminEmail = GenericService.addBrowserPrefix(adminEmail);

        try {
            gmailLoginService.deleteAllExistedEmail(adminAuditorEmail, adminAuditorEmailPwd);
            marketingService.loginUsingUsernamePassword(adminEmail, adminAuvenirPwd);
            adminService.changeTheStatusUser(adminAuditorEmail, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Admin change status of admin Auditor to On-Boarding: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("SmokeTest: Admin change status of admin Auditor to On-Boarding: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 5, */enabled = true, description = "Verify Auditor user status: Active Auditor User and create a password.", testName = "if_3",
            dependsOnMethods = {"verifyAdminChangeStatusUserToOnBoarding"}, alwaysRun = true, dataProvider = "verifyAuditorLoginGmailAndActiveUser",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorLoginGmailAndActiveUser(String adminAuditorEmail, String adminAuditorEmailPwd, String adminAuditorAuvenirPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);

        try {
            gmailLoginService.gmailLogin(adminAuditorEmail, adminAuditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();
            auditorSignUpService.createPassword(adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Admin Auditor be active via Mail link: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("SmokeTest: Admin Auditor be active via Mail link: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 6, */enabled = true, description = "Admin Auditor create new Engagement1", testName = "if_4",
            dependsOnMethods = {"verifyAuditorLoginGmailAndActiveUser"}, alwaysRun = true, dataProvider = "verifyAdminAuditorCreateSimpleEngagement",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyAdminAuditorCreateSimpleEngagement(String adminAuditorEmail, String engagementName1, String companyName,
            String adminAuditorAuvenirPwd) {
        getLogger().info("Admin Auditor create new Engagement1 (simple engagement).");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        MongoDBService.removeEngagementCreatedByLeadAuditor(adminAuditorEmail, engagementName1);
        MongoDBService.removeAllBusinessByName(companyName);

        try {

            marketingService.loginUsingUsernamePassword(adminAuditorEmail, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName1, "", companyName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Auditor create new Engagement: Passed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("SmokeTest: Auditor create new Engagement: Failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 7,*/ enabled = true, description = "Verify that Admin Auditor can invite new member.", testName = "if_6, if_9",
            dependsOnMethods = {"verifyAdminAuditorCreateSimpleEngagement"}, alwaysRun = true,
            dataProvider = "verifyAdminAuditorInviteNewMemberAuditor", dataProviderClass = SmokeDataProvider.class)
    public void verifyAdminAuditorInviteNewMemberAuditor(String leadAuditorEmail, String leadAuditorAuvenirPwd, String adminAuditorEmail,
            String adminAuditorAuvenirPwd, String engagementName1, String leadAuditorFullName, String partnerRole,
            String leadAuditorEmailPwd) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        MongoDBService.removeAllActivitiesCollectionOfAUser(leadAuditorEmail);
        MongoDBService.removeEngagementCreatedByLeadAuditor(leadAuditorEmail);
        auditorSignUpService.deleteUserUsingApi(leadAuditorEmail);

        try {
            gmailLoginService.deleteAllExistedEmail(leadAuditorEmail, leadAuditorAuvenirPwd);

            marketingService.loginUsingUsernamePassword(adminAuditorEmail, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            auditorEngagementTeamService.deleteMemberInEngagementByName(leadAuditorFullName);

            auditorEngagementTeamService.clickInviteMember();
            auditorEngagementTeamService.inputInviteNewMemberInfo(leadAuditorFullName, leadAuditorEmail, partnerRole);
            auditorEngagementTeamService.verifyAddNewInvitedMember(leadAuditorFullName, partnerRole);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(leadAuditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.confirmInfomationNewAuditorUser(leadAuditorFullName, leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Verify Add New Member Auditor", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("SmokeTest: Test script Failed: Verify Add New Member Auditor", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /////// Test case verifyAdminAuditorInvitingNewClient, verifyClientLogsInAndActive, verifyClientActiveAfterSignUpSuccess will be uncomment to
    // run after the issue ( the System cannot add client member ) is fixed.

    @Test(/*priority = 8,*/ enabled = true, description = "Verify that Auditor can invite a client", testName = "if_8",
            dependsOnMethods = {"verifyAdminAuditorInviteNewMemberAuditor"}, alwaysRun = true, dataProvider = "verifyAdminAuditorInvitingNewClient",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyAdminAuditorInvitingNewClient(String adminEmail, String adminAuvenirPwd, String adminClientEmail, String adminClientEmailPwd,
            String adminAuditorEmail, String adminAuditorAuvenirPwd, String engagementName1, String adminClientFullName, String roleClient,
            String onboardingStatus, String leadClientEmail, String clientEmail) throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        adminEmail = GenericService.addBrowserPrefix(adminEmail);
        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);

        MongoDBService.removeClientAndIndicatedValueByEmail(adminClientEmail);
        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientEmail);
        MongoDBService.removeClientAndIndicatedValueByEmail(clientEmail);
        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            gmailLoginService.deleteAllExistedEmail(adminClientEmail, adminClientEmailPwd);


            marketingService.loginUsingUsernamePassword(adminAuditorEmail, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(adminClientFullName, adminClientEmail, roleClient);
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginUsingUsernamePassword(adminEmail, adminAuvenirPwd);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(adminClientEmail, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Verify Admin Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("SmokeTest: Verify Admin Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 9,*/ enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed", testName = "if_8",
            dependsOnMethods = {"verifyAdminAuditorInvitingNewClient"}, alwaysRun = true, dataProvider = "verifyClientLogsInAndActive",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyClientLogsInAndActive(String adminClientEmail, String adminClientEmailPwd, String clientPhoneNumber, String parentStackHolder,
            String adminClientAuvenirPwd, String engagementName1) throws Exception {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(adminClientEmail, adminClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(adminClientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Verify Admin client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("SmokeTest: Verify Admin client logs in and OnBoarding page is displayed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 10,*/ enabled = true, description = "Verify that lead auditor user create a engagement 2", testName = "if_10",
            dependsOnMethods = {"verifyClientLogsInAndActive"}, alwaysRun = true, dataProvider = "verifyLeadAuditorCreateNewEngagement",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorCreateNewEngagement(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String companyName) {
        getLogger().info("Lead Auditor create new Engagement2.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        try {
            MongoDBService.removeEngagementCreatedByLeadAuditor(leadAuditorEmail, engagementName2);
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName2, "", companyName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Auditor create new Engagament (simple engagement).", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("SmokeTest: Auditor create new Engagament (simple engagement).", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 11,*/ enabled = true, description = "Verify that Lead Auditor can invite a admin client", testName = "if_11",
            dependsOnMethods = {"verifyLeadAuditorCreateNewEngagement"}, alwaysRun = true, dataProvider = "verifyLeadAuditorInvitingAdminClient",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorInvitingAdminClient(String adminEmail, String leadAuditorEmail, String adminClientEmail, String adminClientEmailPwd,
            String leadAuditorAuvenirPwd, String engagementName2, String adminClientFullName, String roleClient, String clientPhoneNumber,
            String parentStackHolder, String adminClientAuvenirPwd, String leadClientEmail, String clientEmail) throws Exception {
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

        adminEmail = GenericService.addBrowserPrefix(adminEmail);
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        clientEmail = GenericService.addBrowserPrefix(clientEmail);

        //need precondition for save engagement name, and delete this engagement or client on acl

        MongoDBService.removeClientAndIndicatedValueByEmail(adminClientEmail);
        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientEmail);
        MongoDBService.removeClientAndIndicatedValueByEmail(clientEmail);

        try {
            gmailLoginService.deleteAllExistedEmail(adminClientEmail, adminClientEmailPwd);

            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(adminClientFullName, adminClientEmail, roleClient);
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            gmailLoginService.gmailReLogin(adminClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(adminClientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("SmokeTest: Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("SmokeTest: Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
            throw e;
        }
    }

    @Test(/*priority = 12,*/ enabled = true, description = "Verify that lead auditor user create a engagement 2", testName = "if_12, if_13",
            dependsOnMethods = {"verifyLeadAuditorInvitingAdminClient"}, alwaysRun = true, dataProvider = "verifyLeadAuditorInviteNewAuditorMember",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorInviteNewAuditorMember(String leadAuditorEmail, String leadAuditorAuvenirPwd, String auditorEmail,
            String auditorEmailPwd, String auditorAuvenirPwd, String engagementName2, String auditorFullName, String partnerRole) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);

        try {
            MongoDBService.removeAllActivitiesCollectionOfAUser(auditorEmail);
            auditorSignUpService.deleteUserUsingApi(auditorEmail);

            gmailLoginService.deleteAllExistedEmail(auditorEmail, auditorEmailPwd);

            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            auditorEngagementTeamService.deleteMemberInEngagementByName(auditorFullName);

            auditorEngagementTeamService.clickInviteMember();
            auditorEngagementTeamService.inputInviteNewMemberInfo(auditorFullName, auditorEmail, partnerRole);
            auditorEngagementTeamService.verifyAddNewInvitedMember(auditorFullName, partnerRole);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(auditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.confirmInfomationNewAuditorUser(auditorFullName, auditorEmail, auditorAuvenirPwd);
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


    @Test(/*priority = 15,*/ enabled = true, description = "Verify Admin Client have permission to invite client via email.", testName = "if_15",
            dependsOnMethods = {"verifyLeadAuditorInviteNewAuditorMember"}, alwaysRun = true,
            dataProvider = "verifyPermissionAdminClientCanInviteClient", dataProviderClass = SmokeDataProvider.class)
    public void verifyPermissionAdminClientCanInviteClient(String adminClientEmail, String adminClientAuvenirPwd, String leadClientEmail,
            String leadClientEmailPwd, String adminEmail, String adminAuvenirPwd, String engagementName2, String leadClientFullName,
            String successMessageInvitation, String onboardingStatus, String roleClient) throws Exception {

        getLogger().info("Verify Admin Client have permission to invite client via email.");
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);
        adminEmail = GenericService.addBrowserPrefix(adminEmail);

        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientEmail);
        try {
            gmailLoginService.deleteAllExistedEmail(leadClientEmail, leadClientEmailPwd);

            marketingService.loginUsingUsernamePassword(adminClientEmail, adminClientAuvenirPwd);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientDetailsEngagementService.navigateToTeamTab();
            clientDetailsEngagementService.inviteNewMemberToTeam();
            clientService.fillInfoToInviteNewMember(leadClientFullName, leadClientEmail, roleClient);
            clientService.verifyInviteClientSuccess(successMessageInvitation);

            marketingService.loginUsingUsernamePassword(adminEmail, adminAuvenirPwd);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(leadClientEmail, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 16,*/ enabled = true, description = "Verify Invited Client have permission to seft-active via email.", testName = "if_16",
            dependsOnMethods = {"verifyPermissionAdminClientCanInviteClient"}, alwaysRun = true,
            dataProvider = "verifyPermissionClientCanActiveViaEmail", dataProviderClass = SmokeDataProvider.class)
    public void verifyPermissionClientCanActiveViaEmail(String leadClientEmail, String leadClientEmailPwd, String clientPhoneNumber,
            String parentStackHolder, String leadClientAuvenirPwd, String engagementName2) throws Exception {
        getLogger().info("Verify Invited Client have permission to seft-active via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(leadClientEmail, leadClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(leadClientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 17,*/ enabled = true,
            description = "Verify Lead Client have permission to tranfer their Lead Permission to other Client on team", testName = "if_17",
            dependsOnMethods = {"verifyPermissionClientCanActiveViaEmail"}, alwaysRun = true,
            dataProvider = "verifyPermissionLeadPermissionCanBeTranfered", dataProviderClass = SmokeDataProvider.class)
    public void verifyPermissionLeadPermissionCanBeTranfered(String adminClientEmail, String adminClientAuvenirPwd, String engagementName2,
            String leadClientFullName, String leadText) throws Exception {
        getLogger().info("Verify Admin Client have permission to invite client via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);

        try {
            marketingService.loginUsingUsernamePassword(adminClientEmail, adminClientAuvenirPwd);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientEngagementService.verifyDetailsEngagement(engagementName2);
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

    @Test(/*priority = 18,*/ enabled = true, description = "Verify group permission Lead auditor create todo.", testName = "if_18, if_19, if_20",
            dependsOnMethods = {"verifyPermissionLeadPermissionCanBeTranfered"}, alwaysRun = true,
            dataProvider = "verifyLeadAuditorCreateTodoAndAssignClient", dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorCreateTodoAndAssignClient(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String todo1, String todo2, String todo3, String leadClientFullName, String categoryName) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        //        leadAuditorEmail = "duongauvenir01@gmail.com";
        //        engagementName2 = "Engagement HD";
        //        leadClientFullName = "Client ABC";
        List<String> listTodo = new ArrayList<>();
        listTodo.add(todo1);
        listTodo.add(todo2);
        listTodo.add(todo3);
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
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

    @Test(/*priority = 19,*/ enabled = true, description = "Verify group permission Lead auditor assign todo to general auditor.", testName = "if_21",
            dependsOnMethods = {"verifyLeadAuditorCreateTodoAndAssignClient"}, alwaysRun = true,
            dataProvider = "verifyLeadAuditorAssignToGeneralAuditor", dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorAssignToGeneralAuditor(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo1,
            String auditorFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        //        String auditorId = "duongauvenir01@gmail.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String auditorAssign = "Auditor 007";
        //        String toDoName = "To-do 1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
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

    @Test(/*priority = 20,*/ enabled = true, description = "Verify group permission Lead auditor commenting.", testName = "if_25",
            dependsOnMethods = {"verifyLeadAuditorAssignToGeneralAuditor"}, alwaysRun = true, dataProvider = "verifyLeadAuditorCommenting",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorCommenting(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo1,
            String leadClientFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        //        String auditorId = "duongauvenir01@gmail.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String toDoName = "To-do 1";
        //        String commentContent = "Comment on To--do 1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
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

    @Test(/*priority = 21,*/ enabled = true, description = "Verify group permission Lead auditor mark completed todo.", testName = "if_26",
            dependsOnMethods = {"verifyLeadAuditorCommenting"}, alwaysRun = true, dataProvider = "verifyLeadAuditorMarkCompleted",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorMarkCompleted(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo2) {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        //        String auditorId = "duongauvenir01@gmail.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String toDoName = "To-do 2";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
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

    @Test(/*priority = 22,*/ enabled = true, description = "Verify Lead auditor Assign ToDo Bulk Action.", testName = "if_27",
            dependsOnMethods = {"verifyLeadAuditorMarkCompleted"}, alwaysRun = true, dataProvider = "verifyLeadAuditorAssignToDoBulkAction",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorAssignToDoBulkAction(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo3,
            String auditorFullName, String leadClientFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        //        String auditorId = "duongauvenir01@gmail.com";
        //        String auditorAuvenirPwd = "Changeit@123";
        //        String engagementName = "Firm Auvenir Duong";
        //        String toDoName = "To-do 3";
        //        String fullNameInvitedMember = "Auditor 007";
        //        String fullNameInvitedClient = "Duong Client";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
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

    @Test(/*priority = 23,*/ enabled = true, description = "Verify group permission Lead auditor delete todo.", testName = "if_28",
            dependsOnMethods = {"verifyLeadAuditorAssignToDoBulkAction"}, alwaysRun = true, dataProvider = "verifyLeadAuditorDeleteTodo",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorDeleteTodo(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String todo3) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        //        String auditorId = "duongauvenir01@gmail.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String toDoName = "To-do 3";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
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

    @Test(/*priority = 24,*/ enabled = true, description = "Verify group permission Lead auditor download from all todo.", testName = "if_29",
            dependsOnMethods = {"verifyLeadAuditorDeleteTodo"}, alwaysRun = true, dataProvider = "verifyLeadAuditorDownloadFromAllTodo",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadAuditorDownloadFromAllTodo(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String pathDownload) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        String fileName = pathDownload + engagementName2 + ".zip";
        //        String auditorId = "duongauvenir01@gmail.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        try {
            auditorCreateToDoService.checkFileDownloadExisted(fileName);
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
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

    @Test(/*priority = 25,*/ enabled = true, description = "Verify group permission General auditor create todo.", testName = "if_30, if_31, if_33",
            dependsOnMethods = {"verifyLeadAuditorDownloadFromAllTodo"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorCreateTodo",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralAuditorCreateTodo(String auditorEmail, String auditorAuvenirPwd, String engagementName2, String todo4, String todo5,
            String todo6, String leadClientFullName, String categoryName) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);
        //        String auditorId = "auditor007@mailinator.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String todo4 = "To-do 4";
        //        String todo5 = "To-do 5";
        //        String todo6 = "To-do 6";
        //        String clientAssign = "Duong Client";
        List<String> listTodo = new ArrayList<>();
        listTodo.add(todo4);
        listTodo.add(todo5);
        listTodo.add(todo6);
        try {
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
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

    @Test(/*priority = 26,*/ enabled = true, description = "Verify group permission General auditor commenting.", testName = "if_36",
            dependsOnMethods = {"verifyGeneralAuditorCreateTodo"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorCommenting",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralAuditorCommenting(String auditorEmail, String auditorAuvenirPwd, String engagementName2, String todo4,
            String generalAuditorCmt) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);

        //        String auditorId = "auditor007@mailinator.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String toDoName = "To-do 4";
        //        String commentContent = "Comment on To-do 4";
        try {
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

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

    @Test(/*priority = 27,*/ enabled = true, description = "Verify group permission General auditor mark completed todo.", testName = "if_37",
            dependsOnMethods = {"verifyGeneralAuditorCommenting"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorMarkCompleted",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralAuditorMarkCompleted(String auditorEmail, String auditorAuvenirPwd, String engagementName2,
            String todo5) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);
        //        String auditorId = "auditor007@mailinator.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String toDoName = "To-do 5";
        try {
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

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

    @Test(/*priority = 28,*/ enabled = true, description = "Verify group permission General auditor delete todo.", testName = "if_38",
            dependsOnMethods = {"verifyGeneralAuditorMarkCompleted"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorDeleteTodo",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralAuditorDeleteTodo(String auditorEmail, String auditorAuvenirPwd, String engagementName2, String todo5) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);
        //        String auditorId = "auditor007@mailinator.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String toDoName = "To-do 6";
        try {
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

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

    @Test(/*priority = 29,*/ enabled = true, description = "Verify group permission General auditor download from all todo.", testName = "if_39",
            dependsOnMethods = {"verifyGeneralAuditorDeleteTodo"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorDownloadFromAllTodo",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralAuditorDownloadFromAllTodo(String auditorEmail, String auditorAuvenirPwd, String engagementName2,
            String pathDownload) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);
        //        String auditorId = "auditor007@mailinator.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        String fileName = pathDownload + engagementName2 + ".zip";
        try {
            auditorCreateToDoService.checkFileDownloadExisted(fileName);
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

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
     * Vien.Pham added to verify Lead Client on To-do.
     */

    @Test(/*priority = 30,*/ enabled = true, description = "Verify Lead Client can see all to-dos", testName = "if_40",
            dependsOnMethods = {"verifyGeneralAuditorDownloadFromAllTodo"}, alwaysRun = true, dataProvider = "verifyLeadClientSeeToDo",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadClientSeeToDo(String leadClientEmail, String leadClientAuvenirPwd, String engagementName2, String todo1, String todo2,
            String todo3, String todo4) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        String toDoListNames[] = {todo1, todo2, todo3, todo4};

        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientEngagementService.verifyDetailsEngagement(engagementName2);
            clientTodoService.verifyClientSeeListTodos(Arrays.asList(toDoListNames));
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 41,*/ enabled = true, description = "To verify Lead Client can remove Admin client", testName = "if_41",
            dependsOnMethods = {"verifyLeadClientSeeToDo"}, alwaysRun = true, dataProvider = "verifyLeadClientRemoveAdminClient",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadClientRemoveAdminClient(String leadClientEmail, String leadClientAuvenirPwd, String engagementName2,
            String adminClientFullName, String successMessageRemoveTeamMember) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        //        String leadClientPassword = "Changeit@123";
        //        String engagementName = "Engagement GP02";
        //        String adminClientFullName = "Admin Client";
        //        String successMessageRemoveTeamMember = "Your team member has been removed.";
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
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

    @Test(/*priority = 42,*/ enabled = true, description = "To verify Lead Client can invite a general client", testName = "if_42",
            dependsOnMethods = {"verifyLeadClientRemoveAdminClient"}, alwaysRun = true, dataProvider = "verifyLeadClientInviteClient",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadClientInviteClient(String leadClientEmail, String leadClientAuvenirPwd, String clientEmail, String clientEmailPwd,
            String engagementName2, String clientFullName, String successMessageInvitation, String roleClient) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        //        String leadClientPassword = "Changeit@123";
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        //        String generalClientEmailPassword = "Changeit@123";
        //        String engagementName = "Engagement GP02";
        //        String generalClientFullName = "General Client";
        //        String successMessage = "Your engagement invitation has been sent.";

        MongoDBService.removeClientAndIndicatedValueByEmail(clientEmail);
        try {
            gmailLoginService.deleteAllExistedEmail(clientEmail, clientEmailPwd);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientEngagementService.verifyDetailsEngagement(engagementName2);
            clientEngagementTeamService.selectEngagementTeamMenu();
            clientService.selectInviteNewMemberButton();
            clientService.fillInfoToInviteNewMember(clientFullName, clientEmail, roleClient);
            clientService.verifyInviteClientSuccess(successMessageInvitation);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can invite a new general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can invite a new general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 43,*/ enabled = true, description = "Verify general Client can active from invited", testName = "if_43",
            dependsOnMethods = {"verifyLeadClientInviteClient"}, alwaysRun = true, dataProvider = "verifyGeneralClientActive",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralClientActive(String clientEmail, String clientEmailPwd, String clientAuvenirPwd, String engagementName2,
            String phoneNumber, String parentStackHolder) {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        //        String generalClientEmailPassword = "Changeit@123";
        //        String generalClientAuvenirPassword = "Changeit@123";
        //        String engagementName = "Vien_Engagement";
        //        String phoneNumber = "1234567890";
        //        String stackerHolder = "Titancorpvn";
        try {
            gmailLoginService.gmailLogin(clientEmail, clientEmailPwd);
            gmailLoginService.selectActiveEmaill();
            gmailLoginService.selectStartEngagementBtnToNavigateToAuvenirPage();
            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(phoneNumber);
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can invite a new general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can invite a new general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 44,*/ enabled = true, description = "To verify Lead Client can assign todo task to general client", testName = "if_44, if_48",
            dependsOnMethods = {"verifyGeneralClientActive"}, alwaysRun = true, dataProvider = "verifyLeadClientAssignTodoTaskToClient",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadClientAssignTodoTaskToClient(String leadClientEmail, String leadClientAuvenirPwd, String engagementName2, String todo1,
            String clientFullName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());

        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientEngagementService.verifyDetailsEngagement(engagementName2);
            clientService.selectClientAssigneeByName(todo1, clientFullName);
            clientService.verifyClientAssigneeSelected(todo1, clientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can assign task to general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can assign task to general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 47,*/ enabled = true, description = "Verify Lead Client can make a comment on todo assigned", testName = "if_47",
            dependsOnMethods = {"verifyLeadClientAssignTodoTaskToClient"}, alwaysRun = true, dataProvider = "verifyLeadClientPostComment",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadClientMakeComment(String leadClientEmail, String leadClientPassword, String engagementName, String todoName,
            String commentContent) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
       /* String leadClientEmail = GenericService.addBrowserPrefix("vienpham.client.lead@gmail.com");
        String leadClientPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 01";
        String engagementName = "Vien_Engagement";*/
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientPassword);
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

    @Test(/*priority = 48,*/ enabled = true, description = "Verify general Client can view a comment made by lead client ", testName = "if_47",
            dependsOnMethods = {"verifyLeadClientMakeComment"}, alwaysRun = true, dataProvider = "verifyGeneralClientViewComment",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralClientCanViewComment(String generalClient, String generalClientAuvenirPassword, String engagementName, String todoName,
            String commentContent, String leadClientFullName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
       /* String generalClient = GenericService.addBrowserPrefix("auvenirclient2@gmail.com");
        String generalClientAuvenirPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 01";
        String engagementName = "Vien_Engagement";
        String leadClientFullName = "Lead Client";*/
        generalClient = GenericService.addBrowserPrefix(generalClient);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(generalClient, generalClientAuvenirPassword);
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

    @Test(/*priority = 50,*/ enabled = true, description = "To verify general Client can view Todo task assigned ", testName = "if_50",
            dependsOnMethods = {"verifyGeneralClientCanViewComment"}, alwaysRun = true, dataProvider = "verifyGeneralClientCanViewTodoTaskAssigned",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralClientCanViewTodoTaskAssigned(String clientEmail, String clientAuvenirPwd, String engagementName2, String todo1) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());

        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(clientEmail, clientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientEngagementService.verifyDetailsEngagement(engagementName2);
            clientService.verifyToDoTaskExist(todo1, true);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can view Todo task assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can view Todo task assigned: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 53,*/ enabled = true, description = "Verify general Client can make a comment on todo assigned", testName = "if_53",
            dependsOnMethods = {"verifyGeneralClientCanViewTodoTaskAssigned"}, alwaysRun = true, dataProvider = "verifyGeneralClientPostComment",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyGeneralClientMakeComment(String generalClient, String generalClientAuvenirPassword, String engagementName, String todoName,
            String commentContent) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        /*String generalClient = GenericService.addBrowserPrefix("auvenirclient2@gmail.com");
        String generalClientAuvenirPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 02";
        String engagementName = "Vien_Engagement";*/
        generalClient = GenericService.addBrowserPrefix(generalClient);
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

    @Test(/*priority = 54,*/ enabled = true, description = "Verify Lead Client can view a comment made by general client ", testName = "if_53",
            dependsOnMethods = {"verifyGeneralClientMakeComment"}, alwaysRun = true, dataProvider = "verifyLeadClientViewComment",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyLeadClientCanViewComment(String leadClientEmail, String leadClientPassword, String engagementName, String todoName,
            String commentContent, String generalClientFullName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
       /* String leadClientEmail = GenericService.addBrowserPrefix("vienpham.client.lead@gmail.com");
        String leadClientPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 02";
        String engagementName = "Vien_Engagement";
        String generalClientFullName = "General Client";*/
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientPassword);
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
}