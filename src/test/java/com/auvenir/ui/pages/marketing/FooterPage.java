package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class FooterPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'list-content-footer')]/a[text()='Home']")
    private WebElement eleHome;
    public WebElement getEleHome() { return eleHome; }

    @FindBy(xpath = "//div[contains(@class, 'list-content-footer')]/a[text()='About']")
    private WebElement eleAbout;
    public WebElement getEleAbout() { return eleAbout; }

    @FindBy(xpath = "//div[contains(@class, 'list-content-footer')]/a[text()='Contact']")
    private WebElement eleContact;
    public WebElement getEleContact() { return eleContact; }

    @FindBy(xpath = "//div[contains(@class, 'list-content-footer')]/a[text()='Terms of Service']")
    private WebElement eleTerms;
    public WebElement getEleTerms() { return eleTerms; }

    @FindBy(xpath = "//div[contains(@class, 'list-content-footer')]/a[text()='Privacy Policy']")
    private WebElement elePrivacy;
    public WebElement getElePrivacy() { return elePrivacy; }

    @FindBy(xpath = "//div[contains(@class, 'list-content-footer')]/a[text()='Cookie Notice']")
    private WebElement eleCookieNotice;
    public WebElement getEleCookieNotice() { return eleCookieNotice; }

    @FindBy(id = "facebook")
    private WebElement iconFB;
    public WebElement getIconFB() { return iconFB; }

    @FindBy(id = "twitter")
    private WebElement iconTwitter;
    public WebElement getIconTwitter() { return iconTwitter; }

    @FindBy(id = "linkedln")
    private WebElement iconLinkedln;
    public WebElement getIconLinkedln() { return  iconLinkedln; }

    public FooterPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*@Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }*/

    /**
     * Navigate to Home page
     * @return
     */
    /*public HomePage navigateHome(){
        eleHome.click();
        return new HomePage(getLogger(), driver);
    }

    *//**
     * Navigate to About page
     * @return
     *//*
    public AboutPage navigateAbout(){
        eleAbout.click();
        return new AboutPage(driver);
    }

    *//**
     * Navigate to Contact page
     * @return
     *//*
    public ContactPage navigateContact(){
        eleContact.click();
        return new ContactPage(driver);
    }

    *//**
     * Navigate to Terms of Services
     * @return
     *//*
    public TermsPage navigateTerms(){
        eleTerms.click();
        return new TermsPage(driver);
    }

    *//**
     * Navigate Privacy Policy page
     * @return
     *//*
    public PrivacyPolicyPage navigatePolicty(){
        elePrivacy.click();
        return new PrivacyPolicyPage(driver);
    }

    *//**
     * Navigate to Cookie Notice page
     * @return
     *//*
    public CookieNoticePage navigateCookieNotice(){
        eleCookieNotice.click();
        return new CookieNoticePage(driver);
    }*/
}
