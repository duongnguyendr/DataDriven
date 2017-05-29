package com.auvenir.ui.tests.marketing;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.HomeService;
import com.auvenir.ui.tests.AbstractTest;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class HomePageTest extends AbstractTest {
    HomeService homeService = null;
    @Test(priority = 1,enabled = true,description = "Verify about page content- Home.")
    public void verifyHomePageContent(){
        try {
            homeService = new HomeService(getLogger(), getDriver());
            homeService.goToBaseURL();
            homeService.verifyHomeContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about page content - Home: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Verify about page content- Home: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    //@Test(priority = 2)
    //public void verifyPageContentTest(){
      //  basePage.verifyContentPage();
    //}
}
