package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AuditorActivityPage extends AbstractPage {

	private int waitTime=60;
	public AuditorActivityPage(Logger logger,WebDriver driver)
	{
		super(logger,driver);
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
	}
	
	@FindBy(xpath="//h4[text()='Activity Feed']")
	private WebElement eleActivityFeedTxt;
	public WebElement getEleActivityFeedTxt(){
		return eleActivityFeedTxt;
	}
	
}
