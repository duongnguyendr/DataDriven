package com.auvenir.ui.tests;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.SupportPage;
import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.CareerService;
import com.auvenir.ui.services.SupportService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by tan.pham on 5/29/2017.
 */
public class SupportRefactoryTest extends AbstractTest {
    private SupportService supportService;

    /*
     * @Description: To Verify the display of Elements in Support Page
     * @Author: Jeevaraj SP
     */
    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Support Page")
    public void verifySupportPage() throws Exception {
        supportService = new SupportService(getLogger(), getDriver());
        try {
            //Go to home auvenir page
            supportService.goToAuvenirHomePage();
            //Click on career link
            supportService.clickOnSupportLink();
            //Verify content of support page
            supportService.verifyContentSupportPage();
            //Verify footer of support page
            supportService.verifyFooterSupportPage();

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

    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Support Page")
    public void verifySupportPage1() throws Exception {
        supportService = new SupportService(getLogger(), getDriver());
        try {
            //Go to home auvenir page
            supportService.goToAuvenirHomePage();
            //Click on career link
            supportService.clickOnSupportLink();
            //Verify content of support page
            supportService.verifyContentSupportPage();
            //Verify footer of support page
            supportService.verifyFooterSupportPage();

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
