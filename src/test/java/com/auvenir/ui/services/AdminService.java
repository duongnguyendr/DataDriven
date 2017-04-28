package com.auvenir.ui.services;

import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 4/28/2017.
 * Refactor code and implement for PLAT 2273
 */
public class AdminService extends AbstractService{

    public AdminService(Logger logger, WebDriver driver){
        super(logger,driver);
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
    }
    AdminLoginPage adminLoginPage;


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
            NXGReports.addStep("verify Admin Login Page.", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception e) {
            NXGReports.addStep("verify Admin Login Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}

