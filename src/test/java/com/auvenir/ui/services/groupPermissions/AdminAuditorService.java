package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.auditor.engagement.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorNewEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorTeamPage;
import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.todo.AuditorTodoListPage;
import com.auvenir.ui.pages.groupPermissions.AdminAuditorPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorService extends AbstractService {
    private AdminAuditorPage adminAuditorPage;
    private AuditorNewEngagementPage auditorNewEngagementPage;
    private AuditorEngagementPage auditorEngagementPage;
    private AuditorCreateToDoPage auditorCreateToDoPage;
    private AuditorTodoListPage auditorTodoListPage = new AuditorTodoListPage(getLogger(), getDriver());
    private AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    private AuditorTeamPage auditorTeamPage;

    public AdminAuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        adminAuditorPage = new AdminAuditorPage(getLogger(), getDriver());
        auditorNewEngagementPage = new AuditorNewEngagementPage(getLogger(), getDriver());
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
        auditorTodoListPage = new AuditorTodoListPage(getLogger(), getDriver());
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
        auditorTeamPage = new AuditorTeamPage(getLogger(),getDriver());
    }

    public void verifyCanCreateAnEngagement() {
        auditorEngagementPage.verifyCanCreateAnEngagement(true);
        auditorNewEngagementPage.verifyNewEngagementPage();
    }

    public void verifyAuditorAdminSeeListToDo(List<String> listToDoname) {
        auditorCreateToDoPage.verifyPermissionSeeListToDoTask(listToDoname, true, true);
    }

    public void verifyAdminAuditorCanNotEditCategory(String todoName) {
        adminAuditorPage.verifyCategoryEditableCapability(todoName,false);
    }

    public void verifyAdminAuditorCannotMarkCompleteTodo(List<String> listTodo){
        auditorCreateToDoPage.verifyGroupPermissionCanMarkCompleted(listTodo, false);
    }

    public void verifyAdminAuditorCannotAssignAuditor(List<String> listTodo){
        auditorCreateToDoPage.verifyGroupPermissionCanAssignTodoToAuditor(listTodo, false);
    }

    public void verifyAdminAuditorCannotCreateTodo(List<String> listTodoName) {
        auditorCreateToDoPage.verifyGroupPermissionCanCreateTodo(listTodoName, false);
    }
    public void verifyAdminAuditorCanNotChangeDueDate(String todoName) {
        adminAuditorPage.verifyDueDateEditableCapability(todoName,false);
    }

    public void verifyAdminAuditorCanNotDeleteRequest(String requestName) {
        adminAuditorPage.verifyRequestDeletionCapability(requestName,false);
    }

    public void clickCommentIconByTodoName(String todoName,boolean editablePage) {
        adminAuditorPage.clickCommentIconByTodoName(todoName,editablePage);
    }

    public void verifyAdminAuditorCannotRemoveTodo(List<String> listTodo){
        auditorCreateToDoPage.verifyGroupPermissionCanRemoveTodo(listTodo, false);
    }

    public void verifyAdminAuditorCannotAssignClient(List<String> listTodo, String clientFullName){
        auditorCreateToDoPage.verifyGroupPermissionCanAssignTodoToClient(listTodo, clientFullName, false, false);
    }

    public void verifyAdminAuditorCanNotCommentOnTodoNotAssign(String todoName, String comment) {
        auditorCreateToDoPage.verifyGroupPermissionCanAddComment(todoName, comment, false);
    }
    public void verifyCanSeeAllEngagementsWithinFirm(List<String> engagementListNames) {
        auditorEngagementPage.verifyCanSeeAllEngagementsWithinFirm(engagementListNames, "Admin Auditor");
    }

    public void verifyCantInviteClientIntoEngagement() {
        auditorDetailsEngagementPage.verifyCantInviteClientIntoEngagement(false);
    }
    public void verifyAdminAuditorCanNotChangeRequestName(String requequestName,String newRequestName) {
        adminAuditorPage.verifyEditRequestNameCapability(requequestName,newRequestName,false);
    }

    public void navigateToTeamTab() {
       auditorTeamPage.navigateToTeamTab();
    }

    public void verifyAdminAuditorCanNotRemoveClient(String clientFullName) {
        auditorTeamPage.verifyPermisionToSeeMemberList(clientFullName,false);
    }

    public void verifyAdminAuditorCanNotRemoveAuditor(String auditorFullName) {
        auditorTeamPage.verifyPermisionToSeclectMemberCheckbox(auditorFullName,false);
    }
}
