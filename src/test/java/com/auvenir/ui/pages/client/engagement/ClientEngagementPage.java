package com.auvenir.ui.pages.client.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by huy.huynh on 15/06/2017.
 */
public class ClientEngagementPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='allClientEngagement']//span[@id='c-header-title']")
    private WebElement titleAllEngagement;

    public ClientEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void verifyNavigatedToClientEngagementPage() {
        waitForVisibleElement(titleAllEngagement, "Title All Engagement");
        validateElementText(titleAllEngagement, "All Engagements");
    }
}
