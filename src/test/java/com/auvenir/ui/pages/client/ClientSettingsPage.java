package com.auvenir.ui.pages.client;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class ClientSettingsPage extends AbstractPage {
    private static final int waitTime = 60;
    public ClientSettingsPage(Logger logger, WebDriver driver){
        super(logger,driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
    }

    @FindBy(id ="link-setting-account")
    private WebElement accountSettingsTabEle;

    @FindBy(id="link-setting-integrations")
    private WebElement integrationSettingsTabEle;

    @FindBy(id="link-setting-device")
    private WebElement devicesSettingsTabEle;

    @FindBy(id="link-setting-notifications")
    private WebElement notificationsSettingsTabEle;



    public void navigateToAccountTab() {
        waitForVisibleElement(accountSettingsTabEle);
        accountSettingsTabEle.click();
    }

    public void navigatToIntegrationTab() {
        waitForVisibleElement(integrationSettingsTabEle);
        integrationSettingsTabEle.click();

    }

    public void navigateToDevicesTab() {
        waitForVisibleElement(devicesSettingsTabEle);
        devicesSettingsTabEle.click();
    }

    public void navigateToNotificationsTab() {
        waitForVisibleElement(notificationsSettingsTabEle);
        notificationsSettingsTabEle.click();
    }
}
