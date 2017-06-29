package com.auvenir.ui.tests.marketing;


import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
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
            //marketingService.setPrefixProtocol("http://");
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

    @Test(priority = 8, enabled = true, description = "Verify reset password flow.")
    public void verifyResetPassword() {
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
            NXGReports.addStep("Finish: Verify reset password flow.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }
    /*-----------end of huy.huynh on 29/06/2017.*/
}
