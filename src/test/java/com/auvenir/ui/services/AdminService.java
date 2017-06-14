package com.auvenir.ui.services;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.auvenir.utilities.MongoDBService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 4/28/2017.
 * Refactor code and implement for PLAT 2273
 */
public class AdminService extends AbstractService {
    AdminLoginPage adminLoginPage;
    AuvenirPage auvenirPage;

    public AdminService(Logger logger, WebDriver driver) {
        super(logger, driver);
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
    }

    public void navigateToSettingPage() {
        try {
            getLogger().info("navigate to Admin Setting page.");
            adminLoginPage.navigateToSettingsPage();
            NXGReports.addStep("Go to Setting page successfully.", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Unable to go to Setting page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyAdminLoginPage() {
        try {
            getLogger().info("verify Admin Login page.");
            adminLoginPage.verifyAdminLoginPage();
            NXGReports.addStep("verify Admin Login Page.", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("verify Admin Login Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Refactored by huy.huynh on 24/05/2017.
     * Restructure only
     */
    public void verifyPageLoad() {
        adminLoginPage.verifyAdminLoginPage();
    }

    public void verifyHeader() {
        getLogger().info("Verify Admin logged in header.");
        auvenirPage.verifyHeader();
        adminLoginPage.verifyAdminHeaderText();
    }

    public void verifyBody() {
        getLogger().info("Verify Admin logged in body.");
        adminLoginPage.verifyAdminDashBoard();
        adminLoginPage.verifyUserTable();
    }

    public void verifyFooter() {
        getLogger().info("Verify page footer.");
        auvenirPage.verifyFooter();
    }

    public void viewAndVerifyCredentials() {
        adminLoginPage.viewAndVerifyCredentials();
    }

    public void verifyDropMenuMessage() {
        adminLoginPage.verifyDropMenuMessage();
    }

    public void clickNewMessage() {
        adminLoginPage.clickNewMessage();
    }

    public void verifyNewMessagePopup() {
        adminLoginPage.verifyNewMessagePopup();
    }

    public void closeNewMessagePopup() {
        adminLoginPage.closeNewMessagePopup();
    }

    public void verifyDropMenuNotification() {
        adminLoginPage.verifyDropMenuNotification();
    }

    public void clickViewAllNotification() {
        adminLoginPage.clickViewAllNotification();
    }

    public void verifyBodyNotificationPage() {
        adminLoginPage.verifyBodyNotificationPage();
    }

    public void navigateToSettingAccountPage() {
        adminLoginPage.navigateToSettingAccountPage();
    }

    public void verifySettingAccountPage() {
        adminLoginPage.verifySettingAccountPage();
    }

    public void clickDeactiveLink() {
        adminLoginPage.clickDeactiveLink();
    }

    public void verifyDeactivePopup() {
        adminLoginPage.verifyDeactivePopup();
    }

    public void closeDeactivePopup() {
        adminLoginPage.closeDeactivePopup();
    }

    public void navigateToSettingDevicesPage() {
        adminLoginPage.navigateToSettingDevicesPage();
    }

    public void verifySettingDevicesPage() {
        adminLoginPage.verifySettingDevicesPage();
    }

    public void addAnotherDeviceLink() {
        adminLoginPage.addAnotherDeviceLink();
    }

    public void verifyAddAnotherPopup() {
        adminLoginPage.verifyAddAnotherPopup();
    }

    public void navigateToSettingDevicesDisconnect() {
        adminLoginPage.navigateToSettingDevicesDisconnect();
    }

    public void verifySettingDevicesDisconnectPopup() {
        adminLoginPage.verifySettingDevicesDisconnectPopup();
    }
    /*-----------end of huy.huynh on 24/05/2017.*/

    /**
     * Refactored by huy.huynh on 30/05/2017.
     * New for smoke test
     */
    public void verifyAuditorRowOnAdminUserTable(String userType, String userEmail, String createdDate, String userStatus) {
        adminLoginPage.verifyAuditorRowOnAdminUserTable(userType, userEmail, createdDate, userStatus);
    }

    public void verifyUserStatusOnAdminUserTable(String userEmail, String userStatus) {
        adminLoginPage.verifyAuditorStatusOnAdminUserTable(userEmail, userStatus);
    }

    public void changeTheStatusAuditorToOnBoarding(String userEmail, String chooseOption) {
        adminLoginPage.changeTheStatusAuditorToOnBoarding(userEmail, chooseOption);
    }
    /*-----------end of huy.huynh on 30/05/2017.*/

    public void clickClosePopupWarningBrowser() {
        adminLoginPage.clickClosePopupWarningBrowser();
    }

}

