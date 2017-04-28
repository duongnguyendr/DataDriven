package com.auvenir.ui.tests.admin;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.ui.services.AdminAccountSettingsService;
import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Doai.tran on 4/27/2017.
 * Implement for PLAT - 2273
 */
public class AdminSettingsTest extends AbstractTest {
    AdminAccountSettingsService adminAccountSettingsService;
    AdminService adminService;
    @Test(  priority = 1,enabled = true, description = "Verify GUI admin setting page.")
    public void verifyUIAdminSetting() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(),getDriver());
        this.adminAccountSettingsService = new AdminAccountSettingsService(this.getLogger(), this.getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID");
        String getTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL");
        try {
            adminService.loginWithUserRole(userId, getTokenUrl, checkTokenUrl);
            adminService.verifyAdminLoginPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyHeaderAdminSettingPage();
            adminAccountSettingsService.verifyBodyAdminSettingPage();
            adminAccountSettingsService.verifyFooterAdminSettingPage();
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Some Elements on Admin Setting page not displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2,enabled = true,description = "Update new information on Admin Setting Page.")
    public void updateNewInfoAdminSetting() throws Exception {
        adminService = new AdminService(this.getLogger(), this.getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(this.getLogger(), this.getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID");
        String getTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL");
        adminService.loginWithUserRole(userId, getTokenUrl, checkTokenUrl);


        try {
            adminService.verifyAdminLoginPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.inputFullNameAdminSettingPage("ADMIN TEST");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("0906973152");
            adminAccountSettingsService.verifyEmailTextBoxVisible();
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Some Elements on Admin Setting page not displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
