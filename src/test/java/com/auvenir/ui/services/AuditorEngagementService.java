package com.auvenir.ui.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

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

    public void clickNewEnagementButton() {
        try {
            getLogger().info("click Add New engagement button.");
            auditorEngagementPage.clickNewEnagementButton();
            NXGReports.addStep("click Add New engagement button.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("click Add New engagement button.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void viewEngagementDetailsPage(String engagementName) {
        try {
            getLogger().info("navigate to Engagement detail page.(Hard code)");
            auditorEngagementPage.viewEngagementDetailsPage(engagementName);
            NXGReports.addStep("navigate to Engagement detail page.(Hard code)", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Engagement detail page.(Hard code)", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void viewEngagementDetailsPage(String engagementTitle, String engagementName) {
        try {
            getLogger().info("navigate to Engagement detail page with name");
            auditorEngagementPage.enterEngagementDetailWithName(engagementTitle, engagementName);
            NXGReports.addStep("navigate to Engagement detail pagewith name", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Engagement detail pagewith name", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void viewEngagementDetailsPageWithName(String engagementTitle, String engagementName) {
        try {
            getLogger().info("navigate to Engagement detail page with name");
            auditorEngagementPage.viewEngagementDetailsPageWithName(engagementTitle);
            NXGReports.addStep("navigate to Engagement detail pagewith name", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Engagement detail pagewith name", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


}

