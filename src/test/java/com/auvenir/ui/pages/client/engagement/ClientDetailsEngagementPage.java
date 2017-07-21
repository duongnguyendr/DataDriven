package com.auvenir.ui.pages.client.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.pages.common.DetailsEngagementPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by huy.huynh on 21/06/2017.
 */
public class  ClientDetailsEngagementPage extends DetailsEngagementPage {
    //@FindBy(xpath = "//div[@class='pageHeader-leftContainer']//input[@id='a-header-title']")
    @FindBy(xpath = "//div[@class='pageHeader-leftContainer']//span[@id='a-header-title']")
    private WebElement dashboardText;

    public ClientDetailsEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void verifyDetailsEngagementPage(String engagementName) {
        waitForVisibleElement(dashboardText, "Dashboard text");
        //        validateAttributeElement(dashboardTextEle, "value", engagementName);
        validateElementText(dashboardText, engagementName);
    }


}
