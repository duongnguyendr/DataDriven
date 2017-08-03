package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.groupPermissions.LeadAuditorPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by duong.nguyen on 7/17/2017.
 */
public class LeadAuditorService extends AbstractService {
    LeadAuditorPage leadAuditorPage;
    public LeadAuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        leadAuditorPage = new LeadAuditorPage(getLogger(), getDriver());
    }

    public void verifyLeadAuditorSeeAllFileRequest(int numberFileRequest){
        leadAuditorPage.verifyLeadAuditorSeeAllFileRequest(numberFileRequest);
    }

    public void openNewRequestByTodoName(String todoName){
        leadAuditorPage.clickOpenNewRequestByTodoName(todoName);
    }

    public void verifyFileRequestInTodo(String toDoName, String... fileRequest){
        leadAuditorPage.verifyFileRequestInTodo(toDoName, fileRequest);
    }
}
