package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class PrivacyPolicyPage extends AbstractPage {

    public PrivacyPolicyPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify page content
     */
    /*@Override
    public void verifyContentPage() {
        System.out.println("Verify privacy policy page content.");
    }*/
/*
    @Override
    protected void load() {
        getFooterPage().getElePrivacy().click();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(webDriver.getTitle(), "Privacy Policy");
    }*/
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[contains(text(),'Privacy Policy')]")
    private WebElement privacyHeaderText;
    @FindBy(xpath = ".//*[@id='privacy-page']//h1/div")
    private WebElement auvenirPrivacyPolicyText;
    @FindBy(xpath = ".//*[@id='privacy-page']//div[@class='ui text container privacy-content']")
    private WebElement privacyPolicyTextContent;
    public void verifyPrivacyPolicyContentPage(){
        waitForVisibleElement(auvenirLogoImage,"auvenirImageLogo");
        waitForVisibleElement(privacyHeaderText,"privacyHeaderText");
        waitForVisibleElement(auvenirPrivacyPolicyText,"auvenirPrivacyPolicyText");
        waitForVisibleElement(privacyPolicyTextContent,"privacyPolicyTextContent");
    }
}
