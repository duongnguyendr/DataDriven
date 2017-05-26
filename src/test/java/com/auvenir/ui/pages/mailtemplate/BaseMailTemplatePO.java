package com.auvenir.ui.pages.mailtemplate;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public abstract class BaseMailTemplatePO extends AbstractPage {
    public BaseMailTemplatePO(Logger logger, WebDriver driver){
        super(logger,driver);
        PageFactory.initElements(driver, this);
    }
    // Element of header mail
    @FindBy(xpath = "//center/img[contains(@src,'png') and @alt='logo.png']")
    protected WebElement eleHeader;
    public WebElement getEleHeader(){
        return  eleHeader;
    }

    // Element of logo footer mail
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']")
    protected WebElement eleLogoFooter;
    public WebElement getEleFooter(){
        return eleLogoFooter;
    }

    // Element of content Logo Footer mail
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[1]")
    protected WebElement eleContentLogoFooter;
    public WebElement getEleContentLogoFooter(){return eleContentLogoFooter; }

    // Element of Full Address Auvenir
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[2]")
    protected WebElement eleAddressMailFooter;
    public WebElement getEleAddressMailFooter(){ return  eleAddressMailFooter; }

    // Element of "terms of service" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[3]/a[@href='http://auvenir.s3corp.com.vn:5000/terms']")
    protected WebElement eleLinkTermsFooter;
    public WebElement getEleLinkTermsFooter(){ return eleLinkTermsFooter; }

    // Element of "privacy statement" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[3]/a[@href='http://auvenir.s3corp.com.vn:5000/privacy']")
    protected WebElement eleLinkPrivacyFooter;
    public WebElement getEleLinkPrivacyFooter() { return eleLinkPrivacyFooter; }

    // Element of "unsubscribe" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[4]/a[@href='mailto:unsubscribe@auvenir.com?Subject=Unsubscribe']")
    protected WebElement eleLinkUnSubscribeFooter;
    public WebElement getEleLinkUnSubscribeFooter(){ return eleLinkUnSubscribeFooter; }

    public BaseMailTemplatePO(WebDriver webDriver) {super(webDriver);}

    /**
     * Verify Page Content
     */
    public abstract void verifyPageContent();



}
