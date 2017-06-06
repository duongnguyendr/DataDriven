package com.auvenir.ui.tests.admin;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.services.AuvenirService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Refactored by huy.huynh on 24/05/2017.
 * Restructure only
 */
public class AdminTest extends AbstractTest {
    AdminService adminService;
    AuvenirService auvenirService;

    String adminId;

    private void initVariable() {
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());
        adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

        adminService.loginWithUserRole(adminId);
        adminService.verifyPageLoad();
    }

    private void navigationPreconditions() {
        adminService.loginWithUserRole(adminId);
        adminService.verifyPageLoad();
    }

    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Admin Home Page")
    public void verifyAdminHomePage() {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            adminService.verifyHeader();
            adminService.verifyBody();

            adminService.scrollToFooter(getDriver());

            adminService.verifyFooter();
            adminService.viewAndVerifyCredentials();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Admin Home Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Admin Home Page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Messages screen")
    public void verifyMessagesContent() throws Exception {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            auvenirService.clickMessageBoxIcon();
            adminService.verifyDropMenuMessage();
            adminService.clickNewMessage();
            adminService.verifyNewMessagePopup();
            adminService.closeNewMessagePopup();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Messages screen.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Messages screen.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "To Verify the display of Elements in Notification screen")
    public void verifyAlertContent() throws Exception {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            auvenirService.clickNotiticationIcon();
            adminService.verifyDropMenuNotification();
            adminService.clickViewAllNotification();
            adminService.verifyBodyNotificationPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Notification screen.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Notification screen.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Admin Account Settings and Deactivate screen")
    public void verifyAdminSettingsAccContent() throws Exception {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            adminService.navigateToSettingAccountPage();
            adminService.verifySettingAccountPage();
            adminService.clickDeactiveLink();
            adminService.verifyDeactivePopup();
            adminService.closeDeactivePopup();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Admin Account Settings and Deactivate screen.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Admin Account Settings and Deactivate screen.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Registration screen")
    public void verifyAdminSettingsDevicesContentRegister() throws Exception {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            adminService.navigateToSettingDevicesPage();
            adminService.verifySettingDevicesPage();
            adminService.addAnotherDeviceLink();
            adminService.verifyAddAnotherPopup();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Registration screen.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Registration screen.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 6, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminSettingsDevicesContentDisconnect() throws Exception {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            adminService.navigateToSettingDevicesDisconnect();
            adminService.verifySettingDevicesDisconnectPopup();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Disconnect screen.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Disconnect screen.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 7, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminTOS() throws Exception {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            adminService.scrollToFooter(getDriver());
            auvenirService.clickTermsOfServiceLink();
            adminService.switchToWindow();
            auvenirService.verifyTermsOfServicePage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Disconnect screen.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Disconnect screen.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 8, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminPrivacyPage() throws Exception {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            auvenirService.scrollToFooter(getDriver());
            auvenirService.clickPrivacyStatementLink();
            auvenirService.switchToWindow();
            auvenirService.verifyPrivacyStatementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Disconnect screen.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Disconnect screen.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 9, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminCookieNoticePage() throws Exception {
        try {
            adminService = new AdminService(getLogger(), getDriver());
            auvenirService = new AuvenirService(getLogger(), getDriver());
            adminId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");

            adminService.loginWithUserRole(adminId);
            adminService.verifyPageLoad();

            auvenirService.scrollToFooter(getDriver());
            auvenirService.clickCookieNoticeLink();
            auvenirService.switchToWindow();
            auvenirService.verifyCookieNoticePage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Disconnect screen.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Admin Settings Devices Disconnect screen.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
