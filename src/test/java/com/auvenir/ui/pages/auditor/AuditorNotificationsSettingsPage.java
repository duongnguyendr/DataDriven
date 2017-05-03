package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class AuditorNotificationsSettingsPage extends AbstractPage {
    private final static int waitTime=60;
    public AuditorNotificationsSettingsPage(Logger logger, WebDriver driver){
        super(logger,driver);
       // PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
        
    }
    @FindBy(xpath = "//div[contains(text(),'Notifications Settings')]")
    private WebElement auditorNotificationsSettingsHeaderTextEle;


    public void verifyAuditorNotificationSettingsPage() {
        waitForVisibleElement(auditorNotificationsSettingsHeaderTextEle);


    }
}
