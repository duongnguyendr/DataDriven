package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.AuditorService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.jayway.restassured.response.Response;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.jayway.restassured.RestAssured.given;


/**
 * Created by duong.nguyen on 5/24/2017.
 */
public class AuditorTest extends AbstractTest{
    AdminLoginPage adminLoginPage = null;
    AuditorService auditorService;
    AuditorEngagementService auditorEngagementService;

    String testCaseId = null;
    String sData[] = null;
    DateFormat dateFormat = null;
    Date date = null;
    static String CurrentDate = null;

    @BeforeClass
    public void preCondition() {
        getLogger().info("Delete existed Auditor user.");
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        String sURL = null;
        try {

            sURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL") + GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID") + "/delete";
            getLogger().info("Call api to delete existed Audit user: " + sURL);
            //driver.get(sURL);
            Response response = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(sURL);
            if (response.getStatusCode() == 200) {
                getLogger().info("Existed auditor user has been deleted.");
                NXGReports.addStep("Auditor is deleted sucessfully", LogAs.PASSED, null);
            } else if (response.getStatusCode() == 404) {
                getLogger().info("the auditor is not existed in database.");
            } else {
            }

        } catch (Exception e) {

        }
    }

    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Auditor Login Page")
    public void verifyAuditorLoginPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
            auditorService.verifyBodyLoginPage();
            auditorService.verifyFooterLoginPage();
            auditorService.verifyEmailLoginForm();
            auditorService.verifyLoginWithEmail(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Auditor Onboarding Page")
    public void verifyAuditorOnboardingPage() throws Exception {
        testCaseId = "auditor_Onboarding";
        sData = GenericService.toReadExcelData(testCaseId);
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            String onBoardingUrl;
            getLogger().info("update status of auditor to onboarding.");
            onBoardingUrl = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL") + GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID") + "/update?status=ONBOARDING";
            Response response = given().keystore(GenericService.sDirPath + "/src/test/resources/auvenircom.jks", "changeit").get(onBoardingUrl);
//            Response response = given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames())).get(onBoardingUrl); // Allow all hostname without certificate
            if (response.getStatusCode() == 200) {
                getLogger().info("The Auditor is on boarding.");
            } else {
            }

            getLogger().info("Login with auditor role.");
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.verifyPersonalPage();
            auditorService.verifyInputPersonalInfomation(sData[1], sData[2]);
            auditorService.verifyFirmPage();
            auditorService.verifyInputFirmInformation(sData[3], sData[4], sData[5], sData[6] + ", " + sData[7], sData[8], sData[9], sData[10], sData[9], sData[11]);
//            auditorService.verifyInputAffliateField(sData[9]); Affiliate checkbox disabled.
            auditorService.verifyFooterPage();
            auditorService.verifySecurityOnBoardingPage();

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

    @Test(priority = 3, enabled = true, description = "To Verify the display of Elements in Auditor Engagement Page")
    public void verifyAuditorEngagementPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        try {
            dateFormat = new SimpleDateFormat("MM/d/yyyy");
            date = new Date();
            CurrentDate = dateFormat.format(date);

            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.verifyAdminLoginPage();
            auditorService.verifyChangeActiveStatus("AUDITOR",
                    GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), CurrentDate);
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.verifyheaderPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorService.verifyFooterPage();

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

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Auditor Dashboard Page")
    public void verifyAuditorDashboardPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorEngagementService.verifyAuditorPageHeaderContent();
            auditorEngagementService.clickNewEnagementButton();
            auditorService.verifyDisplayElementInAuditorDashBoardPage();

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

    @Test(priority = 5, enabled = true, description = "To Verify the display of Elements in Engagement Requests Page")
    public void verifyEngagementRequestsPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorEngagementService.clickNewEnagementButton();
            auditorService.clickRequestLink();
            auditorService.verifyDisplayElementInEngagementRequestPage();

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

    @Test(priority = 6, enabled = true, description = "To Verify the display of Elements in Engagement File Manager Page")
    public void verifyEngagementFilesPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorEngagementService.clickNewEnagementButton();
            auditorService.clickFilesLink();
            auditorService.verifyDisplayElementInEngagementFilesPage();

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

    @Test(priority = 7, enabled = true, description = "To Verify the display of Elements in Engagement Activity Page")
    public void verifyEngagementActivityPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorEngagementService.clickNewEnagementButton();
            auditorService.clickActivityLink();
            auditorService.verifyDisplayElementInEngagementActivityPage();

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

    @Test(priority = 8, enabled = true, description = "To Verify the display of Elements in Add New Client Page")
    public void verifyAddNewClientPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());

        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.clickClientsLink();
            auditorService.clickAddNewClientButton();
            auditorService.verifyDisplayElementInAddNewClientPage();

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

    @Test(priority = 9, enabled = true, description = "To Verify the display of Elements in Auditor Client Page")
    public void verifyAuditorClientPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.clickClientsLink();
            auditorService.auditorPageHeaderContent();
            auditorService.verifyDisplayElementInClientPage();

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

    @Test(priority = 10, enabled = true, description = "To Verify the display of Elements in Auditor Settings Account Page")
    public void auditorSettingsAccountPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            getLogger().info("Login with auditor user.");
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.clickClientsLink();
            auditorService.clickdropDownSetingLink();
            auditorService.auditorPageHeaderContent();
            auditorService.verifyDisplayElementInAuditorAccountSettingPage();
            auditorService.verifyDisplayElementInDeActivePage();

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

    @Test(priority = 11, enabled = true, description = "To Verify the display of Elements in Auditor Settings Notification Page")
    public void verifyAuditorSettingsNotificationPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.navigateToAuditorAccountSetting();
            auditorService.auditorPageHeaderContent();
            auditorService.verifyDisplayElementInAuditorNotificationSettingPage();

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

    @Test(priority = 12, enabled = true, description = "To Verify the display of Elements in Archive Page")
    public void verifyEngagementArchivePage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorEngagementService.clickNewEnagementButton();
            auditorService.verifyDisplayElementInArchivePage();

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

    @Test(priority = 13, enabled = true, description = "To Verify the display of Elements in Clients Page")
    public void verifyEngagementClientPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        try {
            auditorService.loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            auditorService.clickClientsLink();
            auditorService.auditorPageHeaderContent();
            auditorService.verifyDisplayElementInClientPage();

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
