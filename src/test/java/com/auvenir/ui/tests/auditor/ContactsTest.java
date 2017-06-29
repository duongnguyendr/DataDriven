package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.ContactsService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class ContactsTest extends AbstractTest {
    private ContactsService contactsService;
    private AuditorEngagementService auditorEngagementService;

    @Test(priority = 1, enabled = true, description = "Verify Footer in Auditor Contacts page.")
    public void verifyFooterAuditorContactsPage() throws Exception {
        contactsService = new ContactsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            //logCurrentStepStart();
            contactsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToContactsTab();
            contactsService.verifyAuditorContactsPage();
            contactsService.verifyAuditorFooter();
            NXGReports.addStep("Verify Footer in Auditor Contacts page: PASSED", LogAs.PASSED, null);
            // logCurrentStepEnd();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify footer in Auditor Contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}



