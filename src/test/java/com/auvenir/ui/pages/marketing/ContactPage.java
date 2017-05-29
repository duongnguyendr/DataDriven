package com.auvenir.ui.pages.marketing;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class ContactPage extends AboutPage {

    public ContactPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify page content
     */
/*
    @Override
    public void verifyContentPage() {
        System.out.println("Verify contact page content.");
    }
*/

    /*@Override
    protected void load() {
        getFooterPage().getEleContact().click();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(webDriver.getTitle(), "Contact");
    }*/
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*/div[@class='ui center aligned header header-main-text']")
    private WebElement headerText;
    @FindBy(xpath = ".//*[@id='contact-form']/div[1]/div/h2")
    private WebElement getInTouchText;
    @FindBy(xpath = ".//input[@name='name']")
    private WebElement nameTextBox;
    @FindBy(xpath = ".//input[@name='email']")
    private  WebElement emailTextBox;
    @FindBy(xpath = "//div[@class='ui selection dropdown']")
    private WebElement directMessageDropdown;
    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement messageTextBox;
    @FindBy(xpath = ".//*[@id='contact-form']/form/button")
    private WebElement sendMessageBTN;
    @FindBy(xpath = ".//*[@id='contact_map']")
    private WebElement contactMapImage;

    public void verifyContactContentPage(){
        waitForVisibleElement(auvenirLogoImage,"auvenirLogoImage");
        waitForVisibleElement(headerText,"headerText");
        waitForVisibleElement(getInTouchText,"getInTouchText");
        waitForVisibleElement(nameTextBox,"nameTextBox");
        waitForVisibleElement(emailTextBox,"emailTextBox");
        waitForVisibleElement(directMessageDropdown,"directMessageDropdown");
        waitForVisibleElement(messageTextBox,"messageTextBox");
        waitForVisibleElement(sendMessageBTN,"sendMessageBTN");
        waitForVisibleElement(contactMapImage,"contactMapImage");
    }
}
