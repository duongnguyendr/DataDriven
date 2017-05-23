package com.auvenir.ui.pages.client;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class ClientFilesPage extends AbstractPage {

    public ClientFilesPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src='images/views/docsEmpty.svg']//..//..//span[contains(text(),'Files')]")
    private WebElement eleFilesHeaderTxt;

    public WebElement getEleFilesHeaderTxt() {
        return eleFilesHeaderTxt;
    }

    @FindBy(xpath = "//img[@src='images/views/docsEmpty.svg']")
    private WebElement eleEmptyFilesImg;

    public WebElement getEleEmptyFilesImg() {
        return eleEmptyFilesImg;
    }

    @FindBy(xpath = "//p[contains(text(),'added any files yet')]")
    private WebElement eleYouHaventAddedTxt;

    public WebElement getEleYouHaventAddedTxt() {
        return eleYouHaventAddedTxt;
    }
}
