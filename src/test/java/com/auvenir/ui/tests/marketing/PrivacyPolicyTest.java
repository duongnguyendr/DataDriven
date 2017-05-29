package com.auvenir.ui.tests.marketing;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.HomeService;
import com.auvenir.ui.services.marketing.PrivacyPolicyService;
import com.auvenir.ui.tests.AbstractTest;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class PrivacyPolicyTest extends AbstractTest {

    HomeService homeService = null;
    PrivacyPolicyService privacyPolicyService = null;

    @Test(priority = 1,enabled = true,description = "Verify about Privacy Policy page content.")
    public void verifyPrivacyPolicyPageContent(){
        try {
            homeService = new HomeService(getLogger(), getDriver());
            privacyPolicyService = new PrivacyPolicyService(getLogger(), getDriver());
            homeService.goToBaseURL();
            homeService.goToPrivacyPolicyPage();
            privacyPolicyService.verifyPrivacyPolicyContentPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about Privacy Policy page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        /*PrivacyPolicyPage privacyPolicyPO = new PrivacyPolicyPage(getLogger(),getDriver());
        privacyPolicyPO.verifyContentPage();*/
        }catch (Exception e) {
            NXGReports.addStep("Verify about Privacy Policy page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
