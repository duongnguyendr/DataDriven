package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by huy.huynh on 12/05/2017.
 * Scenarios : PLAT 2285 - Add undo option
 */
public class UndoOptionTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorUndoOptionService auditorUndoOptionService;

    String userId;
    String timeStamp;

    /**
     * (precondition)init value for variables
     * dependsOnMethods: setUp on AbstractTest
     */
    @BeforeMethod(dependsOnMethods = {"setUp"})
    public void initVariable() {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        auditorUndoOptionService = new AuditorUndoOptionService(getLogger(), getDriver());

        userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
    }

    /**
     * (precondition)flow to Needed-To-Test page
     * dependsOnMethods: initVariable
     * TODO: remove throws Exception when finished catching all exceptions on Page
     */
    @BeforeMethod(dependsOnMethods = {"initVariable"})
    public void navigationPreconditions() throws Exception {
        auditorEngagementService.loginWithUserRole(userId);
        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.clickNewEnagementButton();
        auditorNewEngagementService.verifyNewEngagementPage();
    }

    /**
     * (case)verify button Undo action exist
     */
    @Test(priority = 5, enabled = true, testName = "Verify GUI.", description = "undo_1", groups = "ui"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void uiVerifyButtonUndoExist() throws Exception {
        //TODO move to precondition later
        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");
        auditorDetailsEngagementService.navigateToTodoListPage();
        /* end of block should be on precondition, wait bug fix*/

        auditorUndoOptionService.uiVerifyButtonUndoExist();
    }

    /**
     * (case)verify button Undo action disable
     */
    @Test(priority = 7, enabled = true, testName = "Undo arrow.", description = "undo_3", groups = "ui"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void uiVerifyButtonUndoStatus() throws Exception {
        //TODO move to precondition later
        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");
        auditorDetailsEngagementService.navigateToTodoListPage();
        /* end of block should be on precondition, wait bug fix*/

        auditorUndoOptionService.uiVerifyButtonUndoDisable();

        auditorUndoOptionService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorUndoOptionService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Mark as complete");

        auditorUndoOptionService.uiVerifyButtonUndoEnable();
    }

    /**
     * (case)verify Undo action Complete a To-Do, verified change on database but UI
     */
    @Test(priority = 10, enabled = true, testName = "Undo successfully", description = "undo_4", groups = "workflow")
    public void verifyUndoActionWithCompleteCase() {
        //TODO move to precondition later
        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
        auditorEngagementService.verifyAuditorEngagementPage();

        //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
        String firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();

        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");
        auditorDetailsEngagementService.navigateToTodoListPage();
        /* end of block should be on precondition, wait bug fix*/

        auditorUndoOptionService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorUndoOptionService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorUndoOptionService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Mark as complete");
        auditorUndoOptionService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, "toDoName01" + timeStamp, "true");

        auditorUndoOptionService.undoAction();
        auditorUndoOptionService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, "toDoName01" + timeStamp, "false");

        NXGReports.addStep("Verify Undo action with complete case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Assign to a To-Do, verified change on UI but database
     */
    @Test(priority = 15, enabled = true, testName = "Undo successfully", description = "undo_5", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyUndoActionWithAssignToCase() throws Exception {
        //TODO move to precondition later
        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");

        auditorDetailsEngagementService.navigateToTodoListPage();
        /* end of block should be on precondition, wait bug fix*/

        auditorUndoOptionService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorUndoOptionService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorUndoOptionService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Assign to");
        auditorUndoOptionService.verifyAssigneeNameOnUI("toDoName01" + timeStamp, "client 01 so (client)");
        Thread.sleep(2000);
        auditorUndoOptionService.undoAction();
        auditorUndoOptionService.verifyAssigneeNameOnUI("toDoName01" + timeStamp, "Unassigned");

        NXGReports.addStep("Verify Undo action with complete case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Delete a To-Do, verified change on database but UI
     */
    @Test(priority = 20, enabled = true, testName = "Undo successfully", description = "undo_5", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyUndoActionWithDeleteCase() throws Exception {
        //TODO move to precondition later
        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

        auditorEngagementService.verifyAuditorEngagementPage();
        //TODO temporary code, remove later
        String firstEngagement = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
//        System.out.println("###################################a = " + a);
//        Thread.sleep(10000);
        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");

        auditorDetailsEngagementService.navigateToTodoListPage();
        /* end of block should be on precondition, wait bug fix*/

        auditorUndoOptionService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorUndoOptionService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorUndoOptionService.chooseAndActAToDoWithName("toDoName02" + timeStamp, "Delete");
        auditorUndoOptionService.verifyToDoDeleteStatusByName(firstEngagement, "toDoName02" + timeStamp, "INACTIVE");

        auditorUndoOptionService.undoAction();
        auditorUndoOptionService.verifyToDoDeleteStatusByName(firstEngagement, "toDoName02" + timeStamp, "ACTIVE");

        NXGReports.addStep("Verify Undo action with complete case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Download Attachments disable
     */
    @Test(priority = 40, enabled = true, testName = "Undo fail", description = "undo_1", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyDownloadAttachmentsDisable() throws Exception {
        //TODO move to precondition later
        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");
        auditorDetailsEngagementService.navigateToTodoListPage();
        /* end of block should be on precondition, wait bug fix*/

        auditorUndoOptionService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorUndoOptionService.verifyDownloadAttachmentsDisable("toDoName01" + timeStamp);
    }
}
