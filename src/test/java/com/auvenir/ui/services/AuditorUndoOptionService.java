package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.AuditorUndoOptionPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 12/05/2017.
 * Scenarios : PLAT 2285 - Add undo option
 */
public class AuditorUndoOptionService extends AbstractService {
    AuditorUndoOptionPage auditorUndoOptionPage;
    AuditorCreateToDoPage auditorCreateToDoPage;

    public AuditorUndoOptionService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorUndoOptionPage = new AuditorUndoOptionPage(getLogger(), getDriver());
        auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
    }

    public void createToDoRecord() {
        //TODO move try catch to the execute Selenium API pages
        try {
            auditorCreateToDoPage.createToDoPage("toDoName1");
            auditorCreateToDoPage.createToDoPage("toDoName2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createToDoRecord(String name, String dueDate) {
        try {
            auditorCreateToDoPage.createToDoPage(name, dueDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chooseARowWithName(String name) {
        auditorCreateToDoPage.clickCheckBoxAtRowName(name);
    }

    public void selectOnBulkActions(String actionName) {
        auditorCreateToDoPage.clickBulkActions();
        if (actionName.equals("Mark as complete")) {
            auditorCreateToDoPage.chooseOptionMarkAsCompleteOnBulkActionsDropDownWithName();
            auditorCreateToDoPage.clickComfirmArchive();
        }
    }
}
