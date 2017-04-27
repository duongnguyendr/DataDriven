package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorNotificationsSettingsPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorNotificationsSettingsService extends AbstractService {

    AuditorNotificationsSettingsPage auditorNotificationsSettingsPage;

/*
 * contructor
 */
    public AuditorNotificationsSettingsService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorNotificationsSettingsPage = new AuditorNotificationsSettingsPage(getLogger(), getDriver());

    }


    public void verifyFooter() {

        try {
            auditorNotificationsSettingsPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorNotificationsSettingsPage.verifyFooter();
            getLogger().info("verfify term of service link.");
            auditorNotificationsSettingsPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorNotificationsSettingsPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorNotificationsSettingsPage.verifyCookieNotice();
            auditorNotificationsSettingsPage.scrollPageUp();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }




    public void verifyAuditorNotificationSettingsPage() {

        try {
            getLogger().info("verify Auditor Notifications Settings page.");
            auditorNotificationsSettingsPage.verifyAuditorNotificationSettingsPage();
            NXGReports.addStep("verify Auditor Notifications Settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Auditor Notifications Settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }




}

