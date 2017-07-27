package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.auditor.engagement.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorNewEngagementPage;
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
    private AuditorTodoListPage auditorTodoListPage = new AuditorTodoListPage(getLogger(),getDriver());

    public AdminAuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        adminAuditorPage = new AdminAuditorPage(getLogger(), getDriver());
        auditorNewEngagementPage = new AuditorNewEngagementPage(getLogger(), getDriver());
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
    }

    public void verifyCanCreateAnEngagement() {
        auditorEngagementPage.verifyCanCreateAnEngagement(true);
        auditorNewEngagementPage.verifyNewEngagementPage();
    }

    public void verifyAuditorAdminSeeListToDo(List<String> listToDoname) {
        auditorCreateToDoPage.verifyPermissionSeeListToDoTask(listToDoname, true, true);
    }

    public void verifyAdminAuditorCanNotEditCategory(String todoName,Boolean editable) {
        adminAuditorPage.verifyCategoryEditableCapability(todoName,editable);
    }

    public void verifyAdminAuditorCannotMarkCompleteTodo(List<String> listTodo){
        auditorCreateToDoPage.verifyGroupPermissionCanMarkCompleted(listTodo, false);
    }

    public void verifyAdminAuditorCannotAssignAuditor(List<String> listTodo){
        auditorCreateToDoPage.verifyGroupPermissionCanAssignTodoToAuditor(listTodo, false);
    }

    public void verifyAdminAuditorCannotCreateTodo(String todoName) {
        auditorCreateToDoPage.verifyGroupPermissionCanCreateTodo(todoName, false);
    }
    public void verifyAdminAuditorCanNotChangeDueDate(String todoName,Boolean editable) {
        adminAuditorPage.verifyDueDateEditableCapability(todoName,editable);
    }

    public void verifyAdminAuditorCanNotDeleteRequest(String requestName, boolean deleteCapability) {
        adminAuditorPage.verifyRequestDeletionCapability(requestName,deleteCapability);
    }

    public void clickCommentIconByTodoName(String todoName, boolean editablePage) {
        adminAuditorPage.clickCommentIconByTodoName(todoName,editablePage);
    }

    public void verifyAdminAuditorCanNotChangeRequestName(String requequestName, boolean changeRequestNameCapability) {
        adminAuditorPage.verifyRequestNameChangeCapability(requequestName,changeRequestNameCapability);
    }
}
