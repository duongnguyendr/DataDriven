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

    @BeforeMethod(dependsOnMethods = {"initVariable"})
    public void navigationPreconditions() throws Exception {
        auditorEngagementService.loginWithUserRole(userId);
        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.clickNewEnagementButton();
        auditorNewEngagementService.verifyNewEngagementPage();
    }

    @Test(priority = 10, enabled = true, testName = "Undo successfully", description = "undo_4", groups = "workflow")
    public void verifyUndoActionWithCompleteCase() throws Exception {
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

        auditorUndoOptionService.completeAToDoWithName("toDoName01" + timeStamp);
        auditorUndoOptionService.verifyToDoComleteStatus(firstEngagement, "toDoName01" + timeStamp, "true");

        auditorUndoOptionService.undoAction();
        auditorUndoOptionService.verifyToDoComleteStatus(firstEngagement, "toDoName01" + timeStamp, "false");

        NXGReports.addStep("Verify Undo action with complete case", LogAs.PASSED, null);
    }

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

        auditorUndoOptionService.deleteAToDoWithName("toDoName02" + timeStamp);
        auditorUndoOptionService.verifyToDoDeleteStatus(firstEngagement, "toDoName02" + timeStamp, "INACTIVE");

        auditorUndoOptionService.undoAction();
        auditorUndoOptionService.verifyToDoDeleteStatus(firstEngagement, "toDoName02" + timeStamp, "ACTIVE");

        NXGReports.addStep("Verify Undo action with complete case", LogAs.PASSED, null);
    }

    @Test(priority = 30, enabled = true, testName = "Undo successfully", description = "undo_5", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyUndoActionWithAssignToCase() throws Exception {
        //TODO move to precondition later
        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");

        auditorDetailsEngagementService.navigateToTodoListPage();
        /* end of block should be on precondition, wait bug fix*/

        auditorUndoOptionService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorUndoOptionService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorUndoOptionService.assignAToDoWithName("toDoName01" + timeStamp);
        auditorUndoOptionService.verifyToDoAssignToUI("toDoName01" + timeStamp, "client 01 so (client)");
        Thread.sleep(2000);
        auditorUndoOptionService.undoAction();
        auditorUndoOptionService.verifyToDoAssignToUI("toDoName01" + timeStamp, "Unassigned");

        NXGReports.addStep("Verify Undo action with complete case", LogAs.PASSED, null);
    }

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

    @Test(priority = 7, enabled = true, testName = "Undo arrow.", description = "undo_3", groups = "ui"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void uiVerifyButtonUndoDisable() throws Exception {
        //TODO move to precondition later
        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");
        auditorDetailsEngagementService.navigateToTodoListPage();
        /* end of block should be on precondition, wait bug fix*/

        auditorUndoOptionService.uiVerifyButtonUndoDisable();

        auditorUndoOptionService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorUndoOptionService.completeAToDoWithName("toDoName01" + timeStamp);

        auditorUndoOptionService.uiVerifyButtonUndoEnable();
    }



    //@AfterMethod
    public void tearDownTodo() throws Exception {
        //TODO use tempory, delete later
        getDriver().findElement(By.xpath("//th/input[@type='checkbox']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[contains(text(),'Bulk Actions')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
    }
}
