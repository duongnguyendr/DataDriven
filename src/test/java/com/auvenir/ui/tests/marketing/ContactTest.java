package com.auvenir.ui.tests.marketing;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.ContactService;
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
public class ContactTest extends AbstractTest {
    HomeService homeService;
    ContactService contactService;
    @Test(priority = 1,enabled = true,description = "Verify about contact page content.")
    public void verifyContactPageContentTest(){
        try {
            homeService = new HomeService(getLogger(), getDriver());
            contactService = new ContactService(getLogger(), getDriver());
            homeService.goToBaseURL();
            homeService.goToContactPage();
            contactService.verifyAboutContactPage();
        /*ContactPage contactPO = new ContactPage(getLogger(),getDriver());
        contactPO.verifyContentPage();*/
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify about contact page content: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Verify about contact page content: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
