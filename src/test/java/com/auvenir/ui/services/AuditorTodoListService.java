package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorNewEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorTodoListPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */



public class AuditorTodoListService extends AbstractService {

    AuditorTodoListPage auditorTodoListPage;

    /*
     * contructor
     */
    public AuditorTodoListService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorTodoListPage = new AuditorTodoListPage(getLogger(), getDriver());

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


    public void verifyTodoListPage() {
        try {
            getLogger().info("navigate to client Settings page.");
            auditorTodoListPage.verifyTodoListPage();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyEmptyTodoList() {
        try {
            getLogger().info("navigate to client Settings page.");
            auditorTodoListPage.verifyEmptyTodoList();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}



