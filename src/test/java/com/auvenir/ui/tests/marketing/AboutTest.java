package com.auvenir.ui.tests.marketing;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.AboutService;
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
public class AboutTest extends AbstractTest {
    HomeService homeService = null;
    AboutService aboutService = null;

    @Test(priority = 1,enabled = true,description = "Verify about page content.")
    public void verifyAboutPageContentTest(){
        try {
            homeService = new HomeService(getLogger(), getDriver());
            aboutService = new AboutService(getLogger(), getDriver());
            homeService.setPrefixProtocol("http://");
            homeService.goToBaseURL();
            homeService.goToAboutPage();
            aboutService.verifyAboutContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Verify about page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }
}
