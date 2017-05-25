package com.auvenir.ui.tests;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.ui.pages.CareerPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.auvenir.ui.pages.AuvenirPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;


public class CareerTest extends AbstractRefactorService {
    //Logger logger = Logger.getLogger(CareerTest.class);
    CareerPage careerPage = null;
    String auditorLoginPageHandles = null;
    AuvenirPage auvenirPage = null;

    /*
     * @Description: To Verify the display of Elements in Career Page
     * @Author: Jeevaraj SP
     */
    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Career Page")
    public void verifyCareerPage() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        careerPage = new CareerPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        try {
            getLogger().info("Log into home page.");
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_URL"));
            auditorLoginPageHandles = getDriver().getWindowHandle();
            getLogger().info("Switch to New page.");
            auvenirPage.getEleCareersLnk().click();

            switchToWindow();
            GeneralUtilities.toValidate(auvenirPage.getEleAuvenirImg(), "Auvenir Header Logo Image", "Displayed");
            GeneralUtilities.toValidate(careerPage.getEleWeAreGrowingTxt(), "We are Growing Text", "Displayed");
            GeneralUtilities.toValidate(careerPage.getEleCareersAtAuvenirTxt(), "Careers at Auvenir Text", "Displayed");
            //GeneralUtilities.toValidate(careerPage.getEleBusinessTxt(),"Business Text","Displayed");
            GeneralUtilities.toValidate(careerPage.getEleProductLeadLnk(), "Product text", "Displayed");
            //GeneralUtilities.toValidate(careerPage.getEleMarketingTxt(),"Marketing Text","Displayed");
            //GeneralUtilities.toValidate(careerPage.getEleSalesBizDevelopmentLnk(),"Sales/Biz Development link","Displayed");
            GeneralUtilities.toValidate(careerPage.getEleTechnologyTxt(), "Technology Text", "Displayed");
            GeneralUtilities.toValidate(careerPage.getEleDeveloperLnk(), "Developer Link", "Displayed");
            //GeneralUtilities.toValidate(careerPage.getEleSeniorDevOpsLnk(),"Senior Dev Ops Link","Displayed");
            auvenirPage.verifyFooter();
            getDriver().close();
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
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
