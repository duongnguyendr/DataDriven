package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.todo.AuditorToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by duong.nguyen on 7/17/2017.
 */
public class LeadAuditorService extends AbstractService {
    AuditorToDoPage auditorToDoPage;
    AuditorCreateToDoPage auditorCreateToDoPage;
    public LeadAuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
        auditorToDoPage =  new AuditorToDoPage(getLogger(),getDriver());
    }

    public void verifyLeadAuditorCanCreateTodo(List<String> listTodoName){
        auditorCreateToDoPage.verifyGroupPermissionCanCreateTodo(listTodoName, true);
    }

    public void verifyLeadAuditorCanRemoveTodo(List<String> listTodo){
        auditorCreateToDoPage.verifyGroupPermissionCanRemoveTodo(listTodo, true);
    }

    public void verifyLeadAuditorCanMarkTodoCompleted(List<String> listTodo){
        auditorCreateToDoPage.verifyGroupPermissionCanMarkCompleted(listTodo, true);
    }

    public void verifyLeadAuditorCannotAssignToGeneralClient(List<String> listTodo, String clientFullName){
        auditorCreateToDoPage.verifyGroupPermissionCanAssignTodoToClient(listTodo, clientFullName, false, true);
    }

    public void verifyLeadAuditorCanCommentOnTodoWithOutAssign(String todoName, String comment) {
        auditorCreateToDoPage.verifyGroupPermissionCanAddComment(todoName, comment, true);
    }

    public void verifyLeadAuditorCanChangeRequestName(String requestName, String newRequestName) {
        auditorToDoPage.verifyEditRequestNameCapability(requestName,newRequestName,true);
    }

    public void verifyLeadAuditorCanDeleteRequest(String requestName) {
        auditorToDoPage.verifyRequestDeletionCapability(requestName,true);
    }

    public void verifyLeadAuditorCanChangeDueDate(String todoName) {
        auditorToDoPage.verifyDueDateEditableCapability(todoName,true);
    }

    public void verifyLeadAuditorCanEditCategory(String todoName) {
        auditorToDoPage.verifyCategoryEditableCapability(todoName,true);
    }

    public void clickCommentIconByTodoName(String todoName) {
        auditorToDoPage.clickCommentIconByTodoName(todoName, true);
    }
}
