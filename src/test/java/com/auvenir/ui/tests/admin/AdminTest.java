package com.auvenir.ui.tests.admin;

import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.services.AuvenirService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Refactored by huy.huynh on 24/05/2017.
 * Restructure only
 */
public class AdminTest extends AbstractTest {
    AdminService adminService;
    AuvenirService auvenirService;

    String adminId;
    String timeStamp;
    String firstEngagementTitleOnWeb;
    Actions actions;

    private void initVariable() {
        adminService = new AdminService(getLogger(), getDriver());
        auvenirService = new AuvenirService(getLogger(), getDriver());

        adminId = GenericService.getCongigValue(GenericService.sConfigFile, "ADMIN_ID");
        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        actions = new Actions(getDriver());
    }

    private void navigationPreconditions() {
        adminService.loginWithUserRole(adminId);
        adminService.verifyPageLoad();
    }

    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Admin Home Page")
    public void verifyAdminHomePage() {
        initVariable();
        navigationPreconditions();

        adminService.verifyHeader();
        adminService.verifyBody();

        getLogger().info("Scroll down to see page footer.");
        GeneralUtilities.scrollToFooter(getDriver());

        adminService.verifyFooter();
        adminService.viewAndVerifyCredentials();
    }

    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Messages screen")
    public void verifyMessagesContent() throws Exception {
        initVariable();
        navigationPreconditions();

        auvenirService.clickMessageBoxIcon();
        adminService.verifyDropMenuMessage();
        adminService.clickNewMessage();
        adminService.verifyNewMessagePopup();
        adminService.closeNewMessagePopup();
    }

    @Test(priority = 3, enabled = true, description = "To Verify the display of Elements in Notification screen")
    public void verifyAlertContent() throws Exception {
        initVariable();
        navigationPreconditions();

        auvenirService.clickNotiticationIcon();
        adminService.verifyDropMenuNotification();
        adminService.clickViewAllNotification();
        adminService.verifyBodyNotificationPage();
    }

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Admin Account Settings and Deactivate screen")
    public void verifyAdminSettingsAccContent() throws Exception {
        initVariable();
        navigationPreconditions();

        adminService.navigateToSettingAccountPage();
        adminService.verifySettingAccountPage();
        adminService.clickDeactiveLink();
        adminService.verifyDeactivePopup();
        adminService.closeDeactivePopup();
    }

    @Test(priority = 5, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Registration screen")
    public void verifyAdminSettingsDevicesContentRegister() throws Exception {
        initVariable();
        navigationPreconditions();

        adminService.navigateToSettingDevicesPage();
        adminService.verifySettingDevicesPage();
        adminService.addAnotherDeviceLink();
        adminService.verifyAddAnotherPopup();
    }

    @Test(priority = 6, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminSettingsDevicesContentDisconnect() throws Exception {
        initVariable();
        navigationPreconditions();

        adminService.navigateToSettingDevicesDisconnect();
        adminService.verifySettingDevicesDisconnectPopup();
    }

    @Test(priority = 7, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminTOS() throws Exception {
        initVariable();
        navigationPreconditions();

        GeneralUtilities.scrollToFooter(getDriver());
        auvenirService.clickTermsOfServiceLink();
        GeneralUtilities.switchToWindow(getLogger(), getDriver());
        auvenirService.verifyTermsOfServicePage();
    }

    @Test(priority = 8, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminPrivacyPage() throws Exception {
        initVariable();
        navigationPreconditions();

        GeneralUtilities.scrollToFooter(getDriver());
        auvenirService.clickPrivacyStatementLink();
        GeneralUtilities.switchToWindow(getLogger(), getDriver());
        auvenirService.verifyPrivacyStatementPage();
    }

    @Test(priority = 9, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminCookieNoticePage() throws Exception {
        initVariable();
        navigationPreconditions();

        GeneralUtilities.scrollToFooter(getDriver());
        auvenirService.clickCookieNoticeLink();
        GeneralUtilities.switchToWindow(getLogger(), getDriver());
        auvenirService.verifyCookieNoticePage();
    }
}
