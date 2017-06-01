package com.auvenir.ui.tests;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.services.AuditorService;
import com.auvenir.ui.services.AuvenirService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.extentionLibraries.DBProperties;
import com.jayway.restassured.response.Response;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
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

    String adminId;
    String sData[] = null;
    String testCaseId = null;

    private void initVariable() {
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());

        adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
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
    public void adminLogin() throws Exception {
        try {
            initVariable();
            navigationPreconditions();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify admin is able to login.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "To verify auditor is created with status as pending in admin panel")
    public void auditorCreation() throws Exception {
        try {
            //precondition
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection(DBProperties.getDBname(), DBProperties.getUsersCollection()), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));

            initVariable();

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");

            GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "URL"));
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
        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection(DBProperties.getDBname(), DBProperties.getUsersCollection()), GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));

        initVariable();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");

        GeneralUtilities.loadURL(getDriver(), GenericService.getConfigValue(GenericService.sConfigFile, "URL"));
        auvenirService.verifyPageLoad();
        auvenirService.inputEmailAndJoin(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));
        auvenirService.actionWithApprovalDialog();

        navigationPreconditions();
        GeneralUtilities.scrollToFooter(getDriver());

        adminService.changeTheStatusAuditorToOnBoarding(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Onboarding");
        adminService.verifyAuditorStatusOnAdminUserTable(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), "Onboarding");
    }

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Auditor Onboarding Page")
    public void verifyAuditorOnboardingPage() throws Exception {
        AbstractService.sStatusCnt = 0;
        testCaseId = "auditor_Onboarding";
        sData = GenericService.toReadExcelData(testCaseId);
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
//            String onBoardingUrl;
//            getLogger().info("update status of auditor to onboarding .");
//            onBoardingUrl = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL") + GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID") + "/update?status=ONBOARDING";
//            Response response = given().keystore(GenericService.sDirPath + "/src/test/resources/auvenircom.jks", "changeit").get(onBoardingUrl);
////            Response response = given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames())).get(onBoardingUrl); // Allow all hostname without certificate
//            if (response.getStatusCode() == 200) {
//                getLogger().info("The Auditor is on boarding.");
//            } else {
//            }

            getLogger().info("Login with auditor role.");
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.verifyPersonalPage();
            auditorService.verifyInputPersonalInfomation(sData[1], sData[2]);
            auditorService.verifyFirmPage();
            auditorService.verifyInputFirmInformation(sData[3], sData[4], sData[5], sData[6] + ", " + sData[7], sData[8], sData[9], sData[10], sData[9], sData[11]);
//            auditorService.verifyInputAffliateField(sData[9]); Affiliate checkbox disabled.
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
}
