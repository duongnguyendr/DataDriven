package com.auvenir.ui.pages.client;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by cuong.nguyen on 4/26/2017.
 */
public class ClientAccountSettingsPage extends AbstractPage {
    private static final int waitTime = 60;

    public ClientAccountSettingsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
    }

    @FindBy(xpath = "//div[contains(text(),'Account Settings')]")
    private WebElement accountSettingsHeaderEle;

    public void verifyAccountSettingsPage() {
        waitForVisibleElement(accountSettingsHeaderEle, "accountSettingsHeaderEle");

    }
}
