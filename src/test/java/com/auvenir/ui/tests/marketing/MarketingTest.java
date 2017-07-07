package com.auvenir.ui.tests.marketing;


import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 4/11/2017.
 * Update by minh.nguyen on 06/02/2017
 */
public class MarketingTest extends AbstractTest {
    private MarketingService marketingService = null;

    @Test(priority = 1, enabled = true, description = "Verify about page content.")
    public void verifyAboutPageContentTest() {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.goToAboutPage();
            marketingService.verifyAboutContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify about page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify about Careers page content.")
    public void verifyCareersPageContentTest() {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.goToAboutPage();
            marketingService.goToCareersPage();
            marketingService.verifyCareersContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about Careers page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify about Careers page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify about contact page content.")
    public void verifyContactPageContentTest() {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.goToContactPage();
            marketingService.verifyAboutContactPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about contact page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify about contact page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify about CookiesNotice page content.")
    public void verifyCookiesNoticePageContent() {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.goToCookiesNoticePage();
            marketingService.verifyCookiesNoticeContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about CookiesNotice page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify about CookiesNotice page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify about page content- Home.")
    public void verifyHomePageContent() {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.verifyHomeContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about page content - Home: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify about page content- Home: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify about Privacy Policy page content.")
    public void verifyPrivacyPolicyPageContent() {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.goToPrivacyPolicyPage();
            marketingService.verifyPrivacyPolicyContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about Privacy Policy page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify about Privacy Policy page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 7, enabled = true, description = "Verify about terms page content.")
    public void verifyTermsPageContent() {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.goToTermsOfService();
            marketingService.verifyTermsContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about terms page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify about terms page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    /**
     * Add new by huy.huynh on 29/06/2017.
     * R2.1 NewFeature
     */
    private String adminId, auditorId, clientId;
    private String adminPassword, auditorPassword, clientPassword;
    private String adminEmailPassword, auditorEmailPassword, clientEmailPassword;
    private GmailLoginService gmailLoginService;
    private AuditorEngagementService auditorEngagementService;
    private AdminService adminService;
    private ClientEngagementService clientEngagementService;

    @Test(priority = 8, enabled = true, description = "Verify reset admin password flow.")
    public void verifyAdminResetPassword() {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        adminId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Admin");
        adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        adminEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin Email Password");

        try {
            gmailLoginService.setPrefixProtocol("");
            gmailLoginService.deleteAllExistedEmail(adminId, adminEmailPassword);

            marketingService.goToBaseURL();
            //setBaseUrl("https://auvenir-qa-manual-frontend.com/");
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(adminId);
            marketingService.clickOnRequestResetLinkBTN();

            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail("", adminEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromResetLink();

            marketingService.verifyResetPasswordPageTitle();
            marketingService.fillUpAndConfirmPassword(adminPassword);
            adminService.verifyPageLoad();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset admin password flow.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset admin password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset admin password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }

    @Test(priority = 9, enabled = true, description = "Verify reset auditor password flow.")
    public void verifyAuditorResetPassword() {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        auditorEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Email Password");

        try {
            gmailLoginService.setPrefixProtocol("");
            gmailLoginService.deleteAllExistedEmail(auditorId, auditorEmailPassword);

            marketingService.goToBaseURL();
            //setBaseUrl("https://auvenir-qa-manual-frontend.com/");
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(auditorId);
            marketingService.clickOnRequestResetLinkBTN();

            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail("", auditorEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromResetLink();

            marketingService.verifyResetPasswordPageTitle();
            marketingService.fillUpAndConfirmPassword(auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset auditor password flow.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset auditor password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset auditor password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }

    @Test(priority = 10, enabled = true, description = "Verify reset client password flow.")
    public void verifyClientResetPassword() {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());

        clientId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Client");
        clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Email Password");

        try {
            gmailLoginService.setPrefixProtocol("");
            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);

            marketingService.goToBaseURL();
            //setBaseUrl("https://auvenir-qa-manual-frontend.com/");
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(clientId);
            marketingService.clickOnRequestResetLinkBTN();

            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail("", clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromResetLink();

            marketingService.verifyResetPasswordPageTitle();
            marketingService.fillUpAndConfirmPassword(clientPassword);
            clientEngagementService.verifyNavigatedToClientEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset client password flow.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset client password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset client password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }
    /*-----------end of huy.huynh on 29/06/2017.*/

    /*
    Vien Pham add @Test 11
     */
    @Test(priority = 11, enabled = true, description = "Verify Auditor Reset Password")
    public void verifyAuditorResetPwd() throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(),getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());

        final String auditorID = GenericService.getTestDataFromExcel("AuditorSignUpTest", "AUDITOR_USER_ID", "Valid Value");
        final String auditorEmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_PASSWORD", "Valid Value");
        final String auditorNewPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_PASSWORD", "Valid Value");
        try {
            gmailLoginService.deleteAllExistedEmail(auditorID, auditorEmailPwd);
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.selectForgotPwd();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(auditorID);
            marketingService.clickOnRequestResetLinkBTN();

            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail("", auditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            gmailLoginService.navigateToResetPwdPage();
            marketingService.verifyResetPasswordPageTitle();
            marketingService.inputNewResetPassword("vien","1");
            marketingService.verifyInvalidPwdWarning("1");
            marketingService.inputNewResetPassword("vien1234","1");
            marketingService.verifyInvalidPwdWarning("1");
            marketingService.inputNewResetPassword("vien@1234","1");
            marketingService.verifyInvalidPwdWarning("1");
            marketingService.inputNewResetPassword("Vien1234","1");
            marketingService.verifyInvalidPwdWarning("1");
            marketingService.inputNewResetPassword("Vien@1234","1");
            marketingService.verifyValidPwd("1");
            marketingService.inputNewResetPassword("123","2");
            marketingService.verifyInvalidPwdWarning("2");
            marketingService.inputNewResetPassword("Vien@1234","2");
            marketingService.verifyValidPwd("2");
            marketingService.selectSetPasswordBtn();
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Member ID: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Verify Member ID: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }catch (Exception er){
            getLogger().info(er);
            NXGReports.addStep("Verify Member ID: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw er;
        }
    }

}
