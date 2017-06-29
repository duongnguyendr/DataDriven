package com.auvenir.ui.tests;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.CareerService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CareerTest extends AbstractTest {
    private CareerService careerService;

    /*
     * @Description: To Verify the display of Elements in Career Page
     * @Author: Jeevaraj SP
     */
    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Career Page")
    public void verifyCareerPage() throws Exception {
        careerService = new CareerService(getLogger(), getDriver());
        try {
            //Go to home auvenir page
            careerService.goToAuvenirHomePage();
            //Click on career link
            careerService.clickOnCareerLink();
            // Switch to window
            careerService.switchToWindow();
            // Verify header career path page
            careerService.verifyHeaderCareerPathPage();
            // Verify coneten in career path page
            careerService.verifyContenCareerPathPage();
            // Verify footer of career path page
            careerService.verifyFooterCareerPathPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
            //	driver.switchTo().window(AbstractRefactorService.newWin).close();

        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
