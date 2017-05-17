package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorUndoOptionPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 12/05/2017.
 * Scenarios : PLAT 2285 - Add undo option
 */
public class AuditorUndoOptionService extends AbstractService {
    AuditorUndoOptionPage auditorUndoOptionPage;
    AuditorCreateToDoPage auditorCreateToDoPage;
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;

    public AuditorUndoOptionService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorUndoOptionPage = new AuditorUndoOptionPage(getLogger(), getDriver());
        auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
    }

    public void createToDoRecord() {
        //TODO move try catch to the execute Selenium API pages
        try {
            auditorCreateToDoPage.createToDoPage("toDoName1");
            auditorCreateToDoPage.createToDoPage("toDoName2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createToDoRecord(String name, String dueDate) {
        try {
            auditorCreateToDoPage.createToDoPageWithNameAndDate(name, dueDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chooseARowWithName(String name) {
        auditorCreateToDoPage.clickCheckBoxAtRowName(name);
    }

    public void selectOnBulkActions(String actionName) {
        auditorCreateToDoPage.clickBulkActions();
        if (actionName.equals("Mark as complete")) {
            auditorCreateToDoPage.chooseOptionMarkAsCompleteOnBulkActionsDropDown();
            auditorCreateToDoPage.clickComfirmArchive();
        } else if (actionName.equals("Delete")) {
            auditorCreateToDoPage.chooseOptionDeleteOnBulkActionsDropDown();
            auditorCreateToDoPage.clickComfirmDelete();
        } else if (actionName.equals("Assign to")) {
            auditorCreateToDoPage.chooseOptionAssignToOnBulkActionsDropDown();
            auditorCreateToDoPage.chooseOptionAssignToAssigneeOnBulkActionsDropDownWithName("");
        }
    }

    //TODO group these functions
    public void completeAToDoWithName(String name) {
        chooseARowWithName(name);
        selectOnBulkActions("Mark as complete");
    }

    public void deleteAToDoWithName(String name) {
        chooseARowWithName(name);
        selectOnBulkActions("Delete");
    }

    public void assignAToDoWithName(String name) {
        chooseARowWithName(name);
        selectOnBulkActions("Assign to");
    }

    public void verifyToDoComleteStatus(String engagementName, String todoName, String status) {
        boolean result = auditorCreateToDoPage.verifyToDoCompleteStatus("name", engagementName, todoName, status);
        if (result) {
            System.out.println("+++++++++++++++++++++++++++++ result" + result);
        }
    }

    public void verifyToDoDeleteStatus(String engagementName, String todoName, String status) {
        boolean result = auditorCreateToDoPage.verifyToDoDeteteStatus("name", engagementName, todoName, status);
        if (result) {
            System.out.println("+++++++++++++++++++++++++++++ result" + result);
        }
    }

    public void verifyToDoAssignToUI(String todoName, String text) {
        if (auditorCreateToDoPage.getAssignToAtRowName(todoName).equals(text)) {
            System.out.println("+++++++++++++++++++++++++++++ result" + auditorCreateToDoPage.getAssignToAtRowName(todoName));
        }
    }

    public void verifyDownloadAttachmentsDisable(String name) {
        chooseARowWithName(name);
        auditorCreateToDoPage.clickBulkActions();
        auditorCreateToDoPage.verifyOptionDownloadAttachmentsOnBulkActionsDropDown();
    }

    public void undoAction() {
        auditorCreateToDoPage.clickBtnUndo();
    }

    public void uiVerifyButtonUndoExist() {
        auditorDetailsEngagementPage.uiVerifyButtonUndoExist();
    }

    public void uiVerifyButtonUndoDisable() {
        auditorDetailsEngagementPage.uiVerifyButtonUndoDisable();
    }

    public void uiVerifyButtonUndoEnable() {
        auditorDetailsEngagementPage.uiVerifyButtonUndoEnable();
    }

    public void navigateToEngagementDetailPage() {
        try {
            getLogger().info("navigate to Engagement Detail page.");
            auditorDetailsEngagementPage.navigateToTodoListPage();
            NXGReports.addStep("navigate to To Do list tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to To Do list tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
