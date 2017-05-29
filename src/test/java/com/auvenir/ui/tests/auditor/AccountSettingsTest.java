package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.AuditorAccountSettingsService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AccountSettingsTest extends AbstractTest {
    private AuditorAccountSettingsService auditorAccountSettingsService;
    private AuditorEngagementService auditorEngagementService;


    @Test(priority = 1, enabled = true, description = "Verify Footer in Auditor Account Settings page.")
    public void verifyFooterAuditorAccountSettingsPage() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            //logCurrentStepStart();
            auditorAccountSettingsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyAccountSettingsPage();
            auditorAccountSettingsService.verifyFooter();
            NXGReports.addStep("Verify Footer in Auditor Account Settings page.", LogAs.PASSED, null);
            // logCurrentStepEnd();

        } catch (Exception e) {
            NXGReports.addStep("Verify Footer in Auditor Account Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


