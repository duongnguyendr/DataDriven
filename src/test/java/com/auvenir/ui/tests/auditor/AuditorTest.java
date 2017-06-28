package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by duong.nguyen on 5/24/2017.
 * Refactored by Minh Nguyen on June 26, 2017
 */
public class AuditorTest extends AbstractTest{
    AuditorService auditorService;
    AuditorEngagementService auditorEngagementService;
    AbstractService abstractService;

    String testCaseId = null;
    String sData[] = null;
    DateFormat dateFormat = null;
    Date date = null;
    static String CurrentDate = null;
    private MarketingService marketingService;
    String auditorId,auditorIdLogin , auditorPwd;

    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Auditor Login Page")
    public void verifyAuditorLoginPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            auditorService.goToBaseURL();
            auditorService.verifyBodyHomePage();
            auditorService.verifyFooterHomePage();
            auditorService.verifyEmailLoginForm();
            auditorService.verifyLoginWithEmail(auditorId);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify Auditor Login page");
            NXGReports.addStep("Verify Auditor Login page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Verify Auditor Login page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor Login page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "To verify the header of Auditor Engagement Page")
    public void verifyHeaderAuditorEngagementPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorService.verifyheaderPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorService.verifyFooterPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "To verify the header of Auditor Engagement Page");
            NXGReports.addStep("To verify the header of Auditor Engagement Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("To verify the header of Auditor Engagement Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("To verify the header of Auditor Engagement Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "To Verify the display of Elements in Auditor Engagement Dashboard Page")
    public void verifyAuditorEngagementDashboardPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.viewEngagementDetailsPage("engagement 01");
            auditorService.verifyDisplayElementInAuditorDashBoardPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify Auditor Engagement Dashboard page");
            NXGReports.addStep("Verify Auditor Engagement Dashboard page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Verify Auditor Engagement Dashboard page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor Engagement Dashboard page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Engagement Requests Page")
    public void verifyEngagementRequestsPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 5, enabled = true, description = "To Verify the display of Elements in Engagement File Manager Page")
    public void verifyEngagementFilesPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 6, enabled = true, description = "To Verify the display of Elements in Engagement Activity Page")
    public void verifyEngagementActivityPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 7, enabled = true, description = "To Verify the display of Elements in Add New Client Page")
    public void verifyAddNewClientPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 8, enabled = true, description = "To Verify the display of Elements in Auditor Client Page")
    public void verifyAuditorClientPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 9, enabled = true, description = "To Verify the display of Elements in Auditor Settings Account Page")
    public void auditorSettingsAccountPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            getLogger().info("Login with auditor user.");
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 10, enabled = true, description = "To Verify the display of Elements in Auditor Settings Notification Page")
    public void verifyAuditorSettingsNotificationPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 11, enabled = true, description = "To Verify the display of Elements in Archive Page")
    public void verifyEngagementArchivePage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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

    @Test(priority = 12, enabled = true, description = "To Verify the display of Elements in Clients Page")
    public void verifyEngagementClientPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        try {
            abstractService.loginWithUserRole(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
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
