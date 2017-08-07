package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.client.todo.ClientToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class LeadClientService extends AbstractService {
    /**
     * Updated by Minh.Nguyen on June 19, 2017
     *
     * @param logger
     * @param driver
     */
    ClientToDoPage clientToDoPage;

    public LeadClientService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientToDoPage = new ClientToDoPage(getLogger(),getDriver());
    }


    public void clickCommentIconByTodoName(String todoName) {
        clientToDoPage.clickCommentIconByTodoName(todoName,false);
    }

    public void verifyLeadClientCanNotChangeRequestName(String requequestName, String newRequestName) {
        clientToDoPage.verifyEditRequestNameCapability(requequestName,newRequestName,false);
    }
}
