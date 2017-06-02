package com.auvenir.ui.tests.marketing;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.HomeService;
import com.auvenir.ui.services.marketing.TermsService;
import com.auvenir.ui.tests.AbstractTest;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class TermsTest extends AbstractTest {
    HomeService homeService = null;
    TermsService termsService = null;

    @Test(priority = 1,enabled = true,description = "Verify about terms page content.")
    public void verifyTermsPageContent() {
        try {
            homeService = new HomeService(getLogger(), getDriver());
            termsService = new TermsService(getLogger(), getDriver());
            homeService.setPrefixProtocol("http://");
            homeService.goToBaseURL();
            homeService.goToTermsOfService();
            termsService.verifyTermsContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about terms page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify about terms page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }
}
