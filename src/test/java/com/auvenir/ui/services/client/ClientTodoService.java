package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.todo.ClientToDoPage;
import com.auvenir.ui.pages.common.TodoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by vien.pham on 7/21/2017.
 */
public class ClientTodoService extends AbstractService {
    /**
     * Updated by Minh.Nguyen on June 19, 2017
     *
     * @param logger
     * @param driver
     */

    TodoPage todoPage;
    ClientToDoPage clientToDoPage;

    public ClientTodoService(Logger logger, WebDriver driver) {
        super(logger, driver);
        //        todoPage = new ClientToDoPage(getLogger(), getDriver());
        clientToDoPage = new ClientToDoPage(getLogger(), getDriver());
    }


    public void clickCommentIconPerTaskName(String todoTaskName, boolean isClient) {
        clientToDoPage.clickCommentIconByTodoName(todoTaskName, isClient);
    }

    public void verifyLastCommentOfUserDisplayed(String commentContent, String userFullName) {
        clientToDoPage.verifyLastCommentOfUserDisplayed(commentContent, userFullName);
    }

    public void verifyClientSeeListTodos(List<String> listTodoNames) {
        clientToDoPage.verifyPermissionSeeListToDoTask(listTodoNames, true, true);
    }

    public void verifyInputAComment(String commentContent) {
        clientToDoPage.verifyInputAComment(commentContent);
    }

    public int getNumberOfListComment() {
        return clientToDoPage.getNumberOfListComment();
    }

    public void clickOnPostCommentButton() {
        clientToDoPage.clickOnPostCommentButton();
    }

    public void verifyNewCommentIsDisplayed(int numberListCommentBeforeAdding, String commentContent) {
        clientToDoPage.verifyNewCommentIsDisplayed(numberListCommentBeforeAdding, commentContent);
    }
}
