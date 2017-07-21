package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.todo.ClientToDoPage;
import com.auvenir.ui.pages.common.TodoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
    public ClientTodoService(Logger logger, WebDriver driver) {
        super(logger, driver);
        todoPage = new ClientToDoPage(getLogger(),getDriver());
    }


    public void clickCommentIconPerTaskName(String todoTaskName, boolean isClient) {
        todoPage.clickCommentIconPerTaskName(todoTaskName,isClient);
    }

    public void verifyLastCommentOfUserDisplayed(String comment, String userFullName) {

    }
}
