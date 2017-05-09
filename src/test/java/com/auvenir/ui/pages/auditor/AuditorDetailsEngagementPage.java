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
	private WebElement eleToDoLnk;
	
	@FindBy(xpath="//tr[@id='empty-todo']//..//..//img")
	private WebElement eleImgEmtyToDo;
	
	@FindBy(xpath="//tr[@id='empty-todo']//..//..//div")
	private WebElement eleNotesEmtyToDo;

    public void verifyDetailsEngagementPage(String engagement01) {
    	//Updated later because I do not know which component to test
    }

    public void navigateToTodoListPage() throws Exception { 
    		waitForClickableOfElement(this.eleToDoLnk);
    		this.eleToDoLnk.click();
    }
}

