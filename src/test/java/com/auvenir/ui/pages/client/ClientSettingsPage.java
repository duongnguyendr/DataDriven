package com.auvenir.ui.pages.client;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

    //@FindBy(id="link-setting-notifications")
    @FindBy(xpath = "//div[@id='navSystem']//div[@id='link-setting-notifications']")
    private WebElement notificationsSettingsTabEle;



    public void navigateToAccountTab() {
        waitForPresentOfLocator(By.xpath("//div[@id='navSystem']//div[contains(text(),'Account')]"));
        accountSettingsTabEle.click();
    }

    public void navigatToIntegrationTab() {

        waitForPresentOfLocator(By.xpath("//div[@id='navSystem']//div[contains(text(),'Integrations')]"));
        integrationSettingsTabEle.click();

    }

    public void navigateToDevicesTab() {
       waitForPresentOfLocator(By.xpath("//div[@id='navSystem']//div[contains(text(),'Devices')]"));
        devicesSettingsTabEle.click();
    }

    public void navigateToNotificationsTab() {
        try {
            waitForClickableOfLocator(By.xpath("//div[@id='navSystem']//div[contains(text(),'Notifications')]"));
            notificationsSettingsTabEle.click();
        }catch (Exception e) {
            getLogger().info(e);
        }

    }
}
