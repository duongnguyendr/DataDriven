package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.AuditorAccountSettingsService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 * Edited by Doai.Tran - PLAT 2273
 */

public class AuditorSettingsTest extends AbstractTest {
    private AuditorAccountSettingsService auditorAccountSettingsService;
    private AuditorEngagementService auditorEngagementService;


    @Test(priority = 1, enabled = true, description = "Verify Footer in Auditor Account Settings page.")
    public void verifyFooterAuditorAccountSettingsPage() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorAccountSettingsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyAccountSettingsPage();
            auditorAccountSettingsService.verifyFooter();
            NXGReports.addStep("Verify Footer in Auditor Account Settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Footer in Auditor Account Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify GUI auditor setting page.")
    public void verifyUIAuditorSetting() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorAccountSettingsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyBody();
            auditorAccountSettingsService.verifyFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI auditor setting page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify All UI Audit Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Test First and Last name on Auditor Setting Page.")
    public void InputValueFullName() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorAccountSettingsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            getLogger().info("Input any value on FullName TextBox.");
            auditorAccountSettingsService.inputFullName("Doai Test");
            auditorAccountSettingsService.sendTabkeyFullNametxt();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test First and Last name on Auditor Setting Page: Passed", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Test First and Last name on Auditor Setting Page: PASSED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


