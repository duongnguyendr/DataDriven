package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorAcountSettingsPage;
import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorAccountSettingsService extends AbstractService {

    AuditorAcountSettingsPage auditorAccountSettingsPage;

/*
 * contructor
 */
    public AuditorAccountSettingsService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorAccountSettingsPage = new AuditorAcountSettingsPage(getLogger(), getDriver());

    }


    public void verifyFooter() {

        try {
            auditorAccountSettingsPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorAccountSettingsPage.verifyFooter();
            getLogger().info("verfify term of service link.");
            auditorAccountSettingsPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorAccountSettingsPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorAccountSettingsPage.verifyCookieNotice();
            auditorAccountSettingsPage.scrollPageUp();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }




    public void verifyAccountSettingsPage() {

        try {
            getLogger().info("verify Auditor Engagement page.");
            auditorAccountSettingsPage.verifyAccountSettingsPage();
            NXGReports.addStep("verify Auditor Account Settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Auditor Account Settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToNotificationsPage() {
        try {
            getLogger().info("navigate to Notifications tab.");
            auditorAccountSettingsPage.navigateToNotificationsPage();
            NXGReports.addStep("navigate to Notifications tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Notifications tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToDevicesPage() {
        try {
            getLogger().info("navigate to Devices tab.");
            auditorAccountSettingsPage.navigateToDevicesPage();
            NXGReports.addStep("navigate to Devices tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Devices tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }
}

