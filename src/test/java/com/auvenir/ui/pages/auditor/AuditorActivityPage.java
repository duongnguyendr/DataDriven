package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class AuditorActivityPage extends AbstractPage {


    public AuditorActivityPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//h4[text()='Activity Feed']")
    private WebElement eleActivityFeedTxt;

    public WebElement getEleActivityFeedTxt() {
        return eleActivityFeedTxt;
    }

}
