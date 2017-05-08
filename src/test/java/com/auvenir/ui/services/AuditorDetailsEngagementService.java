package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */

public class AuditorDetailsEngagementService extends AbstractService {

    AuditorDetailsEngagementPage auditorDetailsEngagementPage;

    /*
     * contructor
     */
    public AuditorDetailsEngagementService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());

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


    public void verifyDetailsEngagementPage(String engagement01) {
        try {
            getLogger().info("navigate to client Settings page.");
            auditorDetailsEngagementPage.verifyDetailsEngagementPage("engagement01");
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToTodoListPage() {
        try {
            getLogger().info("navigate to client Settings page.");
            auditorDetailsEngagementPage.navigateToTodoListPage();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}


