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
    public void verifyFilterDropDownList(){
        getLogger().info("Verify Filter DropDown List.");
        auditorTodoListPage.verifyFilterDropDownList();
    }
    public void verifyDefaultValueFilterDropDownList(){
        getLogger().info("Verify default value on Filter dropdown list.");
        auditorTodoListPage.verifyDefaultValueFilterDropDownList();
    }
    public void verifyHoverFilterDropDownList(){
        getLogger().info("Verify Border on Filter dropdown list.");
        auditorTodoListPage.verifyHoverFilterDropDownList();
    }
    public void verifySelectShowAllDropDownList(){
        getLogger().info("Select Show All on Filter dropdown list.");
        auditorTodoListPage.selectShowAllFilterDropDownList();
        getLogger().info("Verify Show All text on Filter dropdown list.");
        auditorTodoListPage.verifySelectShowAllFilterDropDownList();
    }
    public void verifySelectDueDateDropDownList(){
        getLogger().info("Select Due Date on Filter dropdown list.");
        auditorTodoListPage.selectDueDateFilterDropDownList();
        getLogger().info("Verify Due Date text on Filter dropdown list.");
        auditorTodoListPage.verifySelectDueDateFilterDropDownList();
    }
    public void selectAndVerifyFirstAssignFilterDropDownList(){
        auditorTodoListPage.selectAndVerifyFirstAssignFilterDropDownList();
    }
    public void verifySelectWithCommentsDropDownList(){
        getLogger().info("Select With Comments on Filter dropdown list.");
        auditorTodoListPage.selectWithCommentsFilterDropDownList();
        getLogger().info("Verify With Comments text on Filter dropdown list.");
        auditorTodoListPage.verifySelectWithCommentsFilterDropDownList();
    }
    public void verifySelectCompleteDropDownList(){
        getLogger().info("Select Complete on Filter dropdown list.");
        auditorTodoListPage.selectCompleteFilterDropDownList();
        getLogger().info("Verify Complete text on Filter dropdown list.");
        auditorTodoListPage.verifySelectCompleteFilterDropDownList();
    }
    public void verifySelectFlaggedForRequestDropDownList(){
        getLogger().info("Select Flagged For Request on Filter dropdown list.");
        auditorTodoListPage.selectFlaggedForRequestFilterDropDownList();
        getLogger().info("Verify Flagged For Request text on Filter dropdown list.");
        auditorTodoListPage.verifySelectFlaggedForRequestFilterDropDownList();
    }
    public void verifyUnableAddMoreOptionFilterDropDownList(){
        getLogger().info("verify Unable Add More Option Filter DropDownList");
        auditorTodoListPage.verifyUnableAddMoreOptionFilterDropDownList();
    }
    public void verifyClickAndDoNotSelectValue(){
        getLogger().info("verify verify Click And Do Not Select Value Filter DropDownList");
        auditorTodoListPage.verifyClickAndDoNotSelectValue();
    }
}



