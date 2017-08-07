package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.auditor.engagement.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorNewEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorTeamPage;
import com.auvenir.ui.pages.auditor.todo.AuditorToDoPage;
import com.auvenir.ui.pages.auditor.todo.AuditorTodoListPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorService extends AbstractService {
    private AuditorNewEngagementPage auditorNewEngagementPage;
    private AuditorEngagementPage auditorEngagementPage;
    private AuditorToDoPage auditorToDoPage;
    private AuditorTodoListPage auditorTodoListPage;
    private AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    private AuditorTeamPage auditorTeamPage;

    public AdminAuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorNewEngagementPage = new AuditorNewEngagementPage(getLogger(), getDriver());
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        auditorToDoPage = new AuditorToDoPage(getLogger(), getDriver());
        auditorTodoListPage = new AuditorTodoListPage(getLogger(), getDriver());
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
        auditorTeamPage = new AuditorTeamPage(getLogger(), getDriver());
    }

    public void verifyCanCreateAnEngagement() {
        auditorEngagementPage.verifyCanCreateAnEngagement(true);
        auditorNewEngagementPage.verifyNewEngagementPage();
    }

    public void verifyAuditorAdminSeeListToDo(List<String> listToDoname) {
        auditorToDoPage.verifyPermissionSeeListToDoTask(listToDoname, true, true);
    }

    public void verifyAdminAuditorCanNotEditCategory(String todoName) {
        auditorToDoPage.verifyCategoryEditableCapability(todoName, false);
    }

    public void verifyAdminAuditorCannotMarkCompleteTodo(List<String> listTodo) {
        auditorToDoPage.verifyGroupPermissionCanMarkCompleted(listTodo, false);
    }

    public void verifyAdminAuditorCannotAssignAuditor(List<String> listTodo) {
        auditorToDoPage.verifyGroupPermissionCanAssignTodoToAuditor(listTodo, false, false);
    }

    public void verifyAdminAuditorCannotCreateTodo(List<String> listTodoName) {
        auditorToDoPage.verifyGroupPermissionCanCreateTodo(listTodoName, false);
    }

    public void verifyAdminAuditorCanNotChangeDueDate(String todoName) {
        auditorToDoPage.verifyDueDateEditableCapability(todoName, false);
    }

    public void verifyAdminAuditorCanNotDeleteRequest(String requestName) {
        auditorToDoPage.verifyRequestDeletionCapability(requestName, false);
    }

    public void clickCommentIconByTodoName(String todoName) {
        auditorToDoPage.clickCommentIconByTodoName(todoName, false);
    }

    public void verifyAdminAuditorCannotRemoveTodo(List<String> listTodo) {
        auditorToDoPage.verifyGroupPermissionCanRemoveTodo(listTodo, false);
    }

    public void verifyAdminAuditorCannotAssignClient(List<String> listTodo, String clientFullName) {
        auditorToDoPage.verifyGroupPermissionCanAssignTodoToClient(listTodo, clientFullName, false, false);
    }

    public void verifyAdminAuditorCanNotCommentOnTodoNotAssign(String todoName, String comment) {
        auditorToDoPage.verifyGroupPermissionCanAddComment(todoName, comment, false);
    }

    public void verifyCanSeeAllEngagementsWithinFirm(List<String> engagementListNames) {
        auditorEngagementPage.verifyCanSeeAllEngagementsWithinFirm(engagementListNames, "Admin Auditor");
    }

    public void verifyCantInviteClientIntoEngagement() {
        auditorDetailsEngagementPage.verifyCantInviteClientIntoEngagement(false);
    }

    public void verifyAdminAuditorCanNotChangeRequestName(String requequestName, String newRequestName) {
        auditorToDoPage.verifyEditRequestNameCapability(requequestName, newRequestName, false);
    }

    public void navigateToTeamTab() {
        auditorTeamPage.navigateToTeamTab();
    }

    public void verifyAdminAuditorCanNotRemoveClient(String clientFullName) {
        auditorTeamPage.verifyPermisionToSeeMemberList(clientFullName, false);
    }

    public void verifyAdminAuditorCanNotRemoveAuditor(String auditorFullName) {
        auditorTeamPage.verifyPermisionToSelectMemberCheckbox(auditorFullName, false);
    }

    public void verifyCanSeeAllToDosWithinEngagement(List<String> todoListNames, List<Boolean> todoListSeeable) {
        auditorToDoPage.verifyCanSeeAllToDosWithinEngagement(todoListNames, todoListSeeable, "Admin Auditor");
    }

    public void verifyAdminAuditorCanSeeAllFileWithinToDo(List<String> listFile) {
            auditorToDoPage.verifyCanSeeAllFileWithinToDo(listFile);
    }
}
