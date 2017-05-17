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

    /**
     * create a record with name and date(of this month- implement choose month and year later)
     *
     * @param toDoName name of To-Do to create
     * @param dueDate  date of this month which chosen as dueDate
     */
    public void createToDoRecord(String toDoName, String dueDate) {
        auditorCreateToDoPage.createToDoPageWithNameAndDate(toDoName, dueDate);
    }

    /**
     * choose given name To-Do
     *
     * @param toDoName name of To-Do to choose
     */
    public void chooseARowWithName(String toDoName) {
        auditorCreateToDoPage.clickCheckBoxAtRowName(toDoName);
    }

    /**
     * choose an action as actionName
     *
     * @param actionName kind of action to choose(Mark as complete,Delete,Assign to...)
     */
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

    /**
     * choose given name To-Do and cho an action for it
     *
     * @param toDoName name of To-Do to choose
     * @param action   kind of action(Mark as complete,Delete,Assign to...)
     */
    public void chooseAndActAToDoWithName(String toDoName, String action) {
        chooseARowWithName(toDoName);
        selectOnBulkActions(action);
    }

    /**
     * verify complete status of a To-Do
     *
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status complete expected
     */
    public void verifyToDoComleteStatusByName(String engagementValue, String todoName, String status) {
        auditorCreateToDoPage.verifyToDoCompleteStatus("name", engagementValue, todoName, status);
    }

    /**
     * verify delete status of a To-Do
     *
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status complete expected
     */
    public void verifyToDoDeleteStatusByName(String engagementValue, String todoName, String status) {
        auditorCreateToDoPage.verifyToDoDeteteStatus("name", engagementValue, todoName, status);
    }

    /**
     * verify name of assignee appear on Client Assignee after assign
     *
     * @param todoName name of To-Do to check name
     * @param text     name of assignee
     */
    public void verifyAssigneeNameOnUI(String todoName, String text) {
        auditorCreateToDoPage.verifyAssigneeNameOnUI(todoName, text);
    }

    /**
     * verify name of assignee appear on Client Assignee after assign
     *
     * @param todoName name of To-Do to check status
     */
    public void verifyDownloadAttachmentsDisable(String todoName) {
        chooseARowWithName(todoName);
        auditorCreateToDoPage.clickBulkActions();
        auditorCreateToDoPage.verifyOptionDownloadAttachmentsOnBulkActionsDropDown();
    }

    /**
     * click button(icon) Undo
     */
    public void undoAction() {
        auditorCreateToDoPage.clickBtnUndo();
    }

    /**
     * verify button Undo exist
     */
    public void uiVerifyButtonUndoExist() {
        auditorDetailsEngagementPage.uiVerifyButtonUndoExist();
    }

    /**
     * verify button Undo disable
     */
    public void uiVerifyButtonUndoDisable() {
        auditorDetailsEngagementPage.uiVerifyButtonUndoDisable();
    }

    /**
     * verify button Undo enable
     */
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
