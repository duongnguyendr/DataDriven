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

    public void verifyDetailsEngagementPage(String engagement01) {
    	//Updated later because I do not know which component to test
    }

    public void navigateToTaskList() throws Exception { 
    		clickElement(eleToDoListLnk);
    }
}

