package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorAccountSettingsService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorNotificationsSettingsService;
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

public class NotificationsSettingsTest extends AbstractTest {
    private AuditorNotificationsSettingsService auditorNotificationsSettingsService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorAccountSettingsService auditorAccountSettingsService;


    @Test(priority = 1, enabled = true, description = "Verify Footer in Auditor Notifications Settings page.")
    public void verifyFooterAuditorNotificationsSettingsPage() throws Exception {
        auditorNotificationsSettingsService = new AuditorNotificationsSettingsService(getLogger(), getDriver());
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            //logCurrentStepStart();
            auditorNotificationsSettingsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyAccountSettingsPage();
            auditorAccountSettingsService.navigateToNotificationsPage();
            auditorNotificationsSettingsService.verifyAuditorNotificationSettingsPage();
            auditorNotificationsSettingsService.verifyFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Footer in Auditor Notifications Settings page.", LogAs.PASSED, null);
            //logCurrentStepEnd();

        } catch (Exception e) {
            NXGReports.addStep("Verify Footer in Auditor Notifications Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


