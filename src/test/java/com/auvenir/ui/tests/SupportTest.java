package com.auvenir.ui.tests;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.ui.pages.AuvenirPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.auvenir.ui.pages.SupportPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;


public class SupportTest extends AbstractRefactorService {
    public SupportTest(Logger logger, WebDriver driver) {
        super(logger, driver);
    }
    //Logger logger = Logger.getLogger(SupportTest.class);
    SupportPage supportPage = null;
    String AuditorLoginPageHandles = null;
    AuvenirPage auvenirPage = null;

    /*
     * @Description: To Verify the display of Elements in Support Page
     * @Author: Jeevaraj SP
     */
    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Support Page")
    public void verifySupportPage() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        supportPage = new SupportPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        try {
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_URL"));
            auvenirPage.getEleSupportLnk().click();
            GeneralUtilities.toValidate(supportPage.getEleAuvenirHeaderLogoImg(), "Auvenir Header Logo Image", "Displayed");
            GeneralUtilities.toValidate(supportPage.getEleHereToHelpTxt(), "Here to help Text", "Displayed");
            GeneralUtilities.toValidate(supportPage.getEleSupportTeamImg(), "Support Team Image", "Displayed");
            GeneralUtilities.toValidate(supportPage.getEleExperiencingProblemsTxt(), "Experiencing Problem Text", "Displayed");
            GeneralUtilities.toValidate(supportPage.getEleGiveUsACallTxt(), "Give us a call Text", "Displayed");
            GeneralUtilities.toValidate(supportPage.getElePhoneNumberTxt(), "Phone Number Text", "Displayed");
            GeneralUtilities.toValidate(supportPage.getEleEmailTxt(), "Email Text", "Displayed");
            GeneralUtilities.toValidate(supportPage.getEleSendMessageBtn(), "Send Message Button", "Enabled");

            auvenirPage.verifyFooter();
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
