package com.auvenir.ui.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by huy.huynh on 20/07/2017.
 */
public class EngagementPage extends AbstractPage{

    @FindBy(id = "newAuditBtn")
    private WebElement buttonNewEngagement;

    public EngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }


}
