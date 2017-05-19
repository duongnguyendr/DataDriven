package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

//import org.testng.log4testng.Logger;

public class AuditorContactsPage extends AbstractPage {


    private final static int waitTime = 60;

    public AuditorContactsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
    }

    @FindBy(xpath = "//span[contains(text(),'My Clients')]")
    private WebElement myClientsTextEle;


    public void verifyAuditorContactsPage() {
        waitForVisibleElement(myClientsTextEle, "myClientsTextEle");

    }


}