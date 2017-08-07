package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.auditor.todo.AuditorToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class GeneralAuditorService extends AbstractService {
    /**
     * Updated by Minh.Nguyen on June 19, 2017
     *
     * @param logger
     * @param driver
     */

    AuditorToDoPage auditorToDoPage;
    public GeneralAuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorToDoPage = new AuditorToDoPage(getLogger(),getDriver());
    }


    public void clickCommentIconByTodoName(String todoName) {
        auditorToDoPage.clickCommentIconByTodoName(todoName,true);
    }

    public void verifyAuditorCanChangeRequestNameBeAssigned(String oldRequestName, String newRequestName) {
        auditorToDoPage.verifyEditRequestNameCapability(oldRequestName,newRequestName,true);
    }
}
