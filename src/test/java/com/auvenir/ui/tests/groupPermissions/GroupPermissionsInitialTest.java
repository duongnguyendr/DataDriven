package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huy.huynh on 19/07/2017.
 */
public class GroupPermissionsInitialTest extends AbstractTest {
    MarketingService marketingService;
    AuditorEngagementService auditorEngagementService;
    AuditorCreateToDoService auditorCreateToDoService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;
    AuditorTodoListService auditorTodoListService;

    @Test(priority = 19, enabled = true, description = "Verify group permission Lead auditor create todo.")
    public void verifyLeadAuditorCreateTodoAndAssignClient() throws  Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String todo1 = "Todo 1";
        String todo2 = "Todo 2";
        String todo3 = "Todo 3";
        String clientAssign = "Duong Client";
        List<String> listTodo = new ArrayList<>();
        listTodo.add(todo1);
        listTodo.add(todo2);
        listTodo.add(todo3);
        try{
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorCreateToDoService.createListToDoTask(listTodo);
            auditorCreateToDoService.checkToDoListIsExists(true, listTodo);
            for (String todo : listTodo){
                auditorCreateToDoService.selectClientAssigneeByName(todo, clientAssign);
                auditorCreateToDoService.verifyClientAssigneeSelected(todo, clientAssign);
            }

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor create todo.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify group permission Lead auditor create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 21, enabled = true, description = "Verify group permission Lead auditor assign todo to general auditor.")
    public void verifyLeadAuditorAssignToGeneralAuditor() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String auditorAssign = "Auditor 007";
        String toDoName = "Todo 1";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectAuditorAssigneeByName(toDoName, auditorAssign);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(toDoName, auditorAssign);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor assign todo to general auditor.", LogAs.PASSED, null);
        }catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor assign todo to general auditor.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 25, enabled = true, description = "Verify group permission Lead auditor commenting.")
    public void verifyLeadAuditorCommenting() throws  Exception{
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String toDoName = "Todo 1";
        String commentContent = "Comment on Todo 1";
        try{
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify group permission Lead auditor commenting.", LogAs.PASSED, null);
        }catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor commenting.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 26, enabled = true, description = "Verify group permission Lead auditor mark completed todo.")
    public void verifyLeadAuditorMarkCompleted(){
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String toDoName = "Todo 2";
        try{
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();

            auditorCreateToDoService.verifyTodoMarkCompleted(toDoName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor mark completed todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor mark completed todo.",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 27, enabled = true, description = "Verify Lead auditor Assign ToDo Bulk Action.")
    public void verifyLeadAuditorAssignToDoBulkAction() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String auditorPwd = "Changeit@123";
        String engagementName = "Engagement Dr";
        String toDoName = "Todo 3";
        String fullNameInvitedMember = "Auditor 007";
        String fullNameInvitedClient = "Duong Client";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(fullNameInvitedMember);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(toDoName, fullNameInvitedMember);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(fullNameInvitedClient);
            auditorCreateToDoService.verifyClientAssigneeSelected(toDoName, fullNameInvitedClient);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead auditor Assign ToDo Bulk Action.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead auditor Assign ToDo Bulk Action.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 28, enabled = true, description = "Verify group permission Lead auditor delete todo.")
    public void verifyLeadAuditorDeleteTodo(){
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String toDoName = "Todo 3";
        try{
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.scrollUp(getDriver());
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(toDoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor delete todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission Lead auditor delete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 29, enabled = true, description = "Verify group permission Lead auditor download from all todo.")
    public void verifyLeadAuditorDownloadFromAllTodo(){
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "duongauvenir01@gmail.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        try{
            auditorCreateToDoService.checkFileDownloadExisted(fileDownload);
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.clickToBulkDownloadAttachmentButton();
            auditorCreateToDoService.clickDownloadAllTodo();
            auditorCreateToDoService.verifyDownloadFileAllTodoSuccess(fileDownload);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor download from all todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission Lead auditor download from all todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 30, enabled = true, description = "Verify group permission General auditor create todo.")
    public void verifyGeneralAuditorCreateTodo() throws  Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String todo4 = "Todo 4";
        String todo5 = "Todo 5";
        String todo6 = "Todo 6";
        String clientAssign = "Duong Client";
        List<String> listTodo = new ArrayList<>();
        listTodo.add(todo4);
        listTodo.add(todo5);
        listTodo.add(todo6);
        try{
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
//            auditorCreateToDoService.createListToDoTask(listTodo);
            auditorCreateToDoService.createListTodoTaskWithCategoryName(listTodo, "Category 1");
            auditorCreateToDoService.checkToDoListIsExists(true, listTodo);

            auditorCreateToDoService.selectClientAssigneeByName(todo4, clientAssign);
            auditorCreateToDoService.verifyClientAssigneeSelected(todo4, clientAssign);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor create todo.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify group permission General auditor create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 36, enabled = true, description = "Verify group permission General auditor commenting.")
    public void verifyGeneralAuditorCommenting() throws  Exception{
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String toDoName = "Todo 4";
        String commentContent = "Comment on Todo 4";
        try{
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify group permission General auditor commenting.", LogAs.PASSED, null);
        }catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor commenting.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 37, enabled = true, description = "Verify group permission General auditor mark completed todo.")
    public void verifyGeneralAuditorMarkCompleted(){
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String toDoName = "Todo 5";
        try{
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();

            auditorCreateToDoService.verifyTodoMarkCompleted(toDoName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor mark completed todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor mark completed todo.",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 38, enabled = true, description = "Verify group permission General auditor delete todo.")
    public void verifyGeneralAuditorDeleteTodo(){
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String toDoName = "Todo 6";
        try{
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.scrollUp(getDriver());
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(toDoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor delete todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission General auditor delete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 39, enabled = true, description = "Verify group permission General auditor download from all todo.")
    public void verifyGeneralAuditorDownloadFromAllTodo(){
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = "auditor007@mailinator.com";
        String password = "Changeit@123";
        String engagement = "Engagement Dr";
        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        try{
            auditorCreateToDoService.checkFileDownloadExisted(fileDownload);
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagement);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagement);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.clickToBulkDownloadAttachmentButton();
            auditorCreateToDoService.clickDownloadAllTodo();
            auditorCreateToDoService.verifyDownloadFileAllTodoSuccess(fileDownload);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor download from all todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission General auditor download from all todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
}
