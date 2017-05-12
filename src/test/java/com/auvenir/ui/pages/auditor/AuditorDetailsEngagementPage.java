package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 

/**
 * Created by cuong.nguyen on 5/8/2017.
 */


public class AuditorDetailsEngagementPage extends AbstractPage {



    public AuditorDetailsEngagementPage(Logger logger, WebDriver driver)
    {
        super(logger,driver);
    }
	@FindBy(id="engagementTodoLink")
	private WebElement eleToDoListLnk;

    @FindBy(id = "engagementDashboardLink")
    private WebElement dashBoardLinkEle;
    @FindBy(xpath = "//div[contains(text(),'Dashboard')]")
    private WebElement dashboardTextEle;

    public void verifyDetailsEngagementPage(String engagement01) {
        //we can not navigae engagement by name now, will improve letter, just check detail page is rendered.
        //waitForClickableOfElement(dashBoardLinkEle,"DashBoard Link");
        waitForVisibleElement(dashboardTextEle,"dashboard text");

    }

    public void navigateToTaskList() throws Exception { 
    		clickElement(eleToDoListLnk,"Todo List");
    }
    public void navigateToTodoListPage() throws Exception {
        waitForClickableOfElement(eleToDoListLnk,"Todo Link");
        clickElement(eleToDoListLnk,"Todo Link");
    }
}

