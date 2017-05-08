package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorNewEngagementPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */


public class AuditorNewEngagementService extends AbstractService {

    AuditorNewEngagementPage auditorNewEngagementPage;

    /*
     * contructor
     */
    public AuditorNewEngagementService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorNewEngagementPage = new AuditorNewEngagementPage(getLogger(), getDriver());

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


    public void verifyNewEngagementPage() {
        try {
            getLogger().info("navigate to client Settings page.");
            auditorNewEngagementPage.verifyNewEngagementPage();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void enterDataForNewEngagementPage(String engagement01, String s, String s1) {
        try {
            getLogger().info("navigate to client Settings page.");
            auditorNewEngagementPage.enterDataForNewEngagementPage("engagement01","", "");
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}


