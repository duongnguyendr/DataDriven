package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.client.*;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorEngagementService extends AbstractService {

    AuditorEngagementPage auditorEngagementPage;

/*
 * contructor
 */
    public AuditorEngagementService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());

    }


    public void verifyAuditorFooter() {

        try {
            auditorEngagementPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorEngagementPage.verifyFooter();
            getLogger().info("verfify term of service link.");
            auditorEngagementPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorEngagementPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorEngagementPage.verifyCookieNotice();
            auditorEngagementPage.scrollPageUp();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }



    public void navigateToClientSettingsPage() {

        try {
            getLogger().info("navigate to client Settings page.");
            //auditorEngagementPage.navigateToClientSettingsPage();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyAuditorEngagementPage() {

        try {
            getLogger().info("verify Auditor Engagement page.");
            auditorEngagementPage.verifyAuditorEngagementPage();
            NXGReports.addStep("verify Auditor Engagement page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Auditor Engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void navigateToContactsTab() {
        try {
            getLogger().info("navigate to Contacts page.");
            auditorEngagementPage.navigateToContactsTab();
            NXGReports.addStep("navigate to Contacts page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void navigateToSettingsPage() {
        try {
            getLogger().info("navigate to Auditor Settings page.");
            auditorEngagementPage.navigateToSettingsPage();
            NXGReports.addStep("navigate Auditor Setting page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Auditor Settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void clickNewEngagementButton() {
        try {
            getLogger().info("Click New Engagement button.");
            auditorEngagementPage.clickNewEngagementButton();
            NXGReports.addStep("Click New Engagement button.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Click New Engagement button.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCreatedEngagementRendered(String engagement01) {
        try {
            getLogger().info("Click New Engagement button.");
            auditorEngagementPage.verifyCreatedEngagementRendered("engagement01");
            NXGReports.addStep("Click New Engagement button.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Click New Engagement button.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void viewEngagementDetailsPage(String engagement01) {

    }
}

