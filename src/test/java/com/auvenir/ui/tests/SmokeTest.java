package com.auvenir.ui.tests;

import com.auvenir.ui.services.*;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huy.huynh on 26/05/2017.
 * Refactor for SmokeTest(runable)
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
    private GmailLoginService gmailLoginService;
    private String adminId, auditorId, clientId;
    private String sData[];
    private String testCaseId;
    private SimpleDateFormat dateFormat;
    private String timeStamp;
    private AuditorCreateToDoService auditorCreateToDoService;


    @Test(priority = 1, enabled = true, description = "To verify admin is able to login")
    public void verifyAdminLogin() {
        getLogger().info("Verify admin is able to login.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Admin");
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

    @Test(priority = 2, enabled = true, description = "To verify auditor is created with status as Wait Listed in admin panel")
    public void verifyAuditorCreation() {
        getLogger().info("Verify auditor is created with status as Wait Listed in admin panel.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Admin");
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
            dateFormat = new SimpleDateFormat("MM/d/yyyy");
            //precondition
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), auditorId);
            auvenirService.goToAuvenirHomePage();
            auvenirService.inputEmailAndJoin(auditorId);
            auvenirService.actionWithApprovalDialog();
            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyAuditorRowOnAdminUserTable("AUDITOR", GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), dateFormat.format(new Date()), "Wait Listed");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor is created with status as pending in admin panel.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor is created with status as pending in admin panel.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 3, enabled = true, description = "Change the status of the Auditor to OnBoarding", dependsOnMethods = {"auditorCreation"})
    public void verifyChangeTheStatusAuditorToOnBoarding() {
        getLogger().info("Verify change the status of the Auditor to OnBoarding.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        try {
            //precondition setted by tc auditorCreation
//            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
//
//            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
//            auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
//            testCaseId = "auditor_Onboarding";
//            sData = GenericService.toReadExcelData(testCaseId);
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
//
//            GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
//            auvenirService.verifyPageLoad();
//            auvenirService.inputEmailAndJoin(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
//            auvenirService.actionWithApprovalDialog();
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
            adminService.loginWithUserRole(auditorId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.changeTheStatusAuditorToOnBoarding(auditorId, "Onboarding");
            adminService.verifyUserStatusOnAdminUserTable(auditorId, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor is created with status as pending in admin panel.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor is created with status as pending in admin panel.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Auditor Onboarding Page", dependsOnMethods = {"changeTheStatusAuditorToOnBoarding"})
    public void verifyAuditorOnboardingPage() {
        getLogger().info("Verify the display of Elements in Auditor Onboarding Page.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
            testCaseId = "auditor_Onboarding";
            sData = GenericService.toReadExcelData(testCaseId);
            //precondition setted by tc changeTheStatusAuditorToOnBoarding
//            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
//
//            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
//            auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
//            testCaseId = "auditor_Onboarding";
//            sData = GenericService.toReadExcelData(testCaseId);
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
//
//            GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
//            auvenirService.verifyPageLoad();
//            auvenirService.inputEmailAndJoin(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
//            auvenirService.actionWithApprovalDialog();
//
//            adminService.loginWithUserRole(adminId);
//            adminService.verifyPageLoad();
//            GeneralUtilities.scrollToFooter(getDriver());
//
//            adminService.changeTheStatusAuditorToOnBoarding(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), "Onboarding");
//            adminService.verifyUserStatusOnAdminUserTable(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), "Onboarding");
            adminService.loginWithUserRole(auditorId);
            auditorService.verifyPersonalPage();
            auditorService.verifyInputPersonalInfomation(sData[1], sData[2]);
            auditorService.verifyFirmPage();
            auditorService.verifyInputFirmInformation(sData[3], sData[4], sData[5], sData[6] + ", " + sData[7], sData[8], sData[9], sData[10], sData[9], sData[11]);
            auditorService.verifyFooterPage();
            auditorService.verifySecurityOnBoardingPageSimplelize("abcd1234");
            auditorService.verifyEpilogueOnBoardingPage(auditorId);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Auditor Onboarding Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Auditor Onboarding Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 5, enabled = true, description = "Check the status of the Auditor to Active", dependsOnMethods = {"verifyAuditorOnboardingPage"})
    public void verifyTheStatusAuditorToActive() {
        getLogger().info("Verify the status of the Auditor to Active.");
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
//            testCaseId = "auditor_Onboarding";
//            sData = GenericService.toReadExcelData(testCaseId);
//
//            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
//
//            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
//            auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
//            testCaseId = "auditor_Onboarding";
//            sData = GenericService.toReadExcelData(testCaseId);
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
//
//            GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
//            auvenirService.verifyPageLoad();
//            auvenirService.inputEmailAndJoin(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
//            auvenirService.actionWithApprovalDialog();
//            adminService.loginWithUserRole(adminId);
//            adminService.verifyPageLoad();
//            GeneralUtilities.scrollToFooter(getDriver());
//
//            adminService.changeTheStatusAuditorToOnBoarding(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), "Onboarding");
//            adminService.verifyUserStatusOnAdminUserTable(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), "Onboarding");
//
//            getLogger().info("Login with auditor role. ");
//            //auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
//            adminService.loginWithUserRole(auditorId);
//            auditorService.verifyPersonalPage();
//            auditorService.verifyInputPersonalInfomation(sData[1], sData[2]);
//            auditorService.verifyFirmPage();
//            auditorService.verifyInputFirmInformation(sData[3], sData[4], sData[5], sData[6] + ", " + sData[7], sData[8], sData[9], sData[10], sData[9], sData[11]);
//            auditorService.verifyFooterPage();
//            auditorService.verifySecurityOnBoardingPageSimplelize();
//            auditorService.verifyEpilogueOnBoardingPage();
            adminId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Admin");
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());

            adminService.verifyUserStatusOnAdminUserTable(auditorId, "Active");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the status of the Auditor to Active.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the status of the Auditor to Active.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 6, enabled = true, description = "Inviting a client")
    public void verifyInvitingTheClient() {
        getLogger().info("Verify inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        try {
            clientId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Client");
            adminId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Admin");
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
//            auditorEngagementService.verifyAuditorEngagementPage();
            //change business, enter engage detail after create
//            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
//            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient("Titan client", clientId, "Leader");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");
            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Pending");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 7, enabled = true, description = "Client logs in and OnBoarding page is displayed")
    public void verifyClientLogsInAndOnBoards() {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        try {
            adminId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Admin");
            gmailLoginService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_GMAIL"), GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_GMAIL_PASSWORD"));
            gmailLoginService.filterEmail();
            gmailLoginService.clickOnboardingInvitationLink();
            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_GMAIL"), "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 8, enabled = true, description = "Admin is able to delete the existing Auditor and Client")
    public void verifyAdminIsAbleToDeleteClientAndAuditor() {
        getLogger().info("Verify delete the existing Auditor and Client via API");
        adminService = new AdminService(getLogger(), getDriver());
        try {
            clientId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Client");
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
            adminService.deleteUserUsingApi(auditorId);
            //adminService.verifyAPIResponseSuccessCode(auditorMessageBack,"Auditor");
            adminService.deleteUserUsingApi(clientId);
            //adminService.verifyAPIResponseSuccessCode(clientMessageBack,"Client");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify delete the existing Auditor and Client via API.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify delete the existing Auditor and Client via API.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 9, enabled = true, description = "Verify Auditor post new comment")
    public void verifyToDoDetailsCommenting() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User2", "Auditor");
        String engagementName = "Engagement 01";
        String toDoName = "Task2299";
        String commentContent = "comment Task22991";

        try {
            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.navigateToDoListPage();

            // Will uncomment when the code is updated with the new xpath and business.
            auditorCreateToDoService.verifyAddNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickPostComment();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);
            auditorCreateToDoService.verifyBoxTitleComment();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
}
