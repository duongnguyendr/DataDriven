package com.auvenir.ui.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.auvenir.ui.pages.auditor.AuditorTodoListPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

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


    public void verifyTodoListPageColumnHeader() {
        try {
            getLogger().info("verify To Do List page.");
            auditorTodoListPage.verifyTodoListPageColumnHeader();
            NXGReports.addStep("verify To Do List page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify To Do List page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyEmptyTodoList()  {
        try {
            getLogger().info("verify empty to do List.");
            auditorTodoListPage.verifyEmptyTodoList();
            NXGReports.addStep("verify empty To Do List.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify empty To Do List.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyTodoListPage() {
        try {
            getLogger().info("verify todo List Page.");
            auditorTodoListPage.verifyTodoListPage();
            NXGReports.addStep("verify todo List Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("verify todo List Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}



