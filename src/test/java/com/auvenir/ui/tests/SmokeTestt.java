package com.auvenir.ui.tests;

import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.auvenir.ui.pages.client.ClientOnBoardingPage;
import com.auvenir.ui.services.*;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.jayway.restassured.response.Response;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by huy.huynh on 26/05/2017.
 */
public class SmokeTestt extends AbstractTest {
    AdminService adminService;
    AuvenirService auvenirService;
    AuditorService auditorService;

    String adminId, auditorId;
    String sData[] = null;
    String testCaseId = null;

    private void initVariable() {
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());

        adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID");
        testCaseId = "auditor_Onboarding";
        sData = GenericService.toReadExcelData(testCaseId);
    }

    private void navigationPreconditions() {
        adminService.loginWithUserRole(adminId);
        adminService.verifyPageLoad();
    }

    public void preRequiste() {

        String sURL = null;

        try {
            getLogger().info("Delete existed user before create.");

            sURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                    + GenericService.getConfigValue(GenericService.sConfigFile, " ") + "/delete";
            getLogger().info("Call rest api:  " + sURL);

            Response response = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(sURL);
            if (response.getStatusCode() == 200) {
                getLogger().info("The Auditor has been delete.");
            } else if (response.getStatusCode() == 404) {
                getLogger().info("The auditor is not existed in database.");
            } else {
            }

            sURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                    + GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID") + "/delete";
            getLogger().info("Call rest api: " + sURL);
            Response response1 = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(sURL);
            if (response1.getStatusCode() == 200) {
                getLogger().info("The client has been deleted successful.");
                NXGReports.addStep("Auditor is deleted sucessfully.", LogAs.PASSED, null);
            } else if (response1.getStatusCode() == 404) {
                getLogger().info("the client is not existed in database.");
            } else {
            }
        } catch (Exception e) {
            System.out.println("Problem in launching driver");
            e.printStackTrace();
        }
    }

    @Test(priority = 1, enabled = true, description = "To verify admin is able to login")
    public void adminLogin() {
        try {
            initVariable();
            navigationPreconditions();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify admin is able to login.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 2, enabled = true, description = "To verify auditor is created with status as pending in admin panel")
    public void auditorCreation() throws Exception {
        try {
            //precondition
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));

            initVariable();

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");

            GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
            auvenirService.verifyPageLoad();
            auvenirService.inputEmailAndJoin(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));
            auvenirService.actionWithApprovalDialog();

            navigationPreconditions();

            GeneralUtilities.scrollToFooter(getDriver());
            adminService.verifyAuditorRowOnAdminUserTable("AUDITOR", GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), dateFormat.format(new Date()), "Wait Listed");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor is created with status as pending in admin panel.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor is created with status as pending in admin panel.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Change the status of the Auditor to OnBoarding")
    public void changeTheStatusAuditorToOnBoarding() throws Exception {
        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));

        initVariable();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");

        GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
        auvenirService.verifyPageLoad();
        auvenirService.inputEmailAndJoin(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));
        auvenirService.actionWithApprovalDialog();

        navigationPreconditions();
        GeneralUtilities.scrollToFooter(getDriver());

        adminService.changeTheStatusAuditorToOnBoarding(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Onboarding");
        adminService.verifyUserStatusOnAdminUserTable(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Onboarding");
    }

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Auditor Onboarding Page")
    public void verifyAuditorOnboardingPage() throws Exception {
        AbstractService.sStatusCnt = 0;
        testCaseId = "auditor_Onboarding";
        sData = GenericService.toReadExcelData(testCaseId);
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));

            initVariable();

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");

            GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
            auvenirService.verifyPageLoad();
            auvenirService.inputEmailAndJoin(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));
            auvenirService.actionWithApprovalDialog();
            navigationPreconditions();
            GeneralUtilities.scrollToFooter(getDriver());

            adminService.changeTheStatusAuditorToOnBoarding(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Onboarding");
            adminService.verifyUserStatusOnAdminUserTable(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Onboarding");

            getLogger().info("Login with auditor role.");
            //auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            adminService.loginWithUserRole(auditorId);
            auditorService.verifyPersonalPage();
            auditorService.verifyInputPersonalInfomation(sData[1], sData[2]);
            auditorService.verifyFirmPage();
            auditorService.verifyInputFirmInformation(sData[3], sData[4], sData[5], sData[6] + ", " + sData[7], sData[8], sData[9], sData[10], sData[9], sData[11]);
            auditorService.verifyFooterPage();
            auditorService.verifySecurityOnBoardingPageSimplelize();
            auditorService.verifyEpilogueOnBoardingPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "Check the status of the Auditor to Active")
    public void verifyTheStatusAuditorToActive() throws Exception {
        AbstractService.sStatusCnt = 0;
        testCaseId = "auditor_Onboarding";
        sData = GenericService.toReadExcelData(testCaseId);
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));

            initVariable();

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");

            GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
            auvenirService.verifyPageLoad();
            auvenirService.inputEmailAndJoin(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));
            auvenirService.actionWithApprovalDialog();
            navigationPreconditions();
            GeneralUtilities.scrollToFooter(getDriver());

            adminService.changeTheStatusAuditorToOnBoarding(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Onboarding");
            adminService.verifyUserStatusOnAdminUserTable(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Onboarding");

            getLogger().info("Login with auditor role. ");
            //auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            adminService.loginWithUserRole(auditorId);
            auditorService.verifyPersonalPage();
            auditorService.verifyInputPersonalInfomation(sData[1], sData[2]);
            auditorService.verifyFirmPage();
            auditorService.verifyInputFirmInformation(sData[3], sData[4], sData[5], sData[6] + ", " + sData[7], sData[8], sData[9], sData[10], sData[9], sData[11]);
            auditorService.verifyFooterPage();
            auditorService.verifySecurityOnBoardingPageSimplelize();
            auditorService.verifyEpilogueOnBoardingPage();

            navigationPreconditions();
            GeneralUtilities.scrollToFooter(getDriver());

            adminService.verifyUserStatusOnAdminUserTable(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Active");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    AuditorEngagementService auditorEngagementService;
    AuditorNewEngagementService auditorNewEngagementService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;
    AuditorTodoListService auditorTodoListService;
    ClientService clientService;

    String firstEngagementTitleOnWeb;
    String timeStamp;

    @Test(priority = 6, enabled = true, description = "Inviting a client")
    public void invitingTheClient() throws Exception {
        String clientUserId = GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_ID");
        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientUserId);

        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());

        //adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        String newClientData[] = GenericService.toReadExcelData("creating_NewClient_Data");


        auditorEngagementService.loginWithUserRole(auditorId);
        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.clickNewEnagementButton();
        auditorNewEngagementService.verifyNewEngagementPage();

        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
        auditorEngagementService.verifyAuditorEngagementPage();

        //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
        firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();

        auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
        auditorDetailsEngagementService.navigateToTodoListPage();

        auditorTodoListService.navigateToInviteClientPage();

        clientService.selectAddNewClient();
        clientService.inviteNewClient("Titan client", clientUserId, "Leader");
        clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

        adminService.loginWithUserRole("cuongnguyen@gmail.com");
        adminService.verifyPageLoad();
        GeneralUtilities.scrollToFooter(getDriver());

        adminService.verifyUserStatusOnAdminUserTable(clientUserId, "Pending");
    }

    ClientOnBoardingPage clientOnBoardingPage;
    AdminLoginPage adminLoginPage;
    GmailLoginService gmailLoginService;
    @Test(priority = 7, enabled = true, description = "Client logs in and OnBoarding page is displayed")
    public void clientLogsInAndOnBoards() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
        clientOnBoardingPage = new ClientOnBoardingPage(getLogger(), getDriver());
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        gmailLoginService=new GmailLoginService(getLogger(), getDriver());
        initVariable();

        getLogger().info("Client login and onboard.");
        GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
        System.out.println("aaagetDriver().findElement(By.xpath(\"\")) = " + getDriver().findElement(By.xpath("//*[@id='headingText']")).getText());
        gmailLoginService.signInGmail(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_GMAIL"),GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_GMAIL_PASSWORD"));
    }
}
