package com.auvenir.ui.pages;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class CreateNewAuditPage extends AbstractPage {

    public CreateNewAuditPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//button[text()='Create New']")
    private WebElement eleNewAuditBtn;

    public WebElement getEleNewAuditBtn() {
        return eleNewAuditBtn;
    }

    @FindBy(xpath = "//input[@placeholder='Enter your audit name']")
    private WebElement eleEnterYourAuditNameTxtBox;

    public WebElement getEleEnterYourAuditNameTxtBox() {
        return eleEnterYourAuditNameTxtBox;
    }

    //@FindBy(xpath = "//h4[contains(text(),'My Client')]/../div//button[text()='Select Client']")
    @FindBy(id = "taskSelectClientDivBtn")
    private WebElement eleSelectClientBtn;

    public WebElement getEleSelectClientBtn() {
        return eleSelectClientBtn;
    }

    @FindBy(id = "taskSelectClientDivBtn")
    private WebElement eleSelectBtn;

    public WebElement getEleSelectBtn() {
        return eleSelectBtn;
    }

    @FindBy(xpath = "//input[@id='m-ci-step-one-input']")
    private WebElement eleSelectYourClientDrpDwn;

    public WebElement getEleSelectYourClientDrpDwn() {
        return eleSelectYourClientDrpDwn;
    }

    @FindBy(xpath = "//p[text()='Please select your client']")
    private WebElement elePleaseSelectYourTxt;

    public WebElement getElePleaseSelectYourTxt() {
        return elePleaseSelectYourTxt;
    }

    @FindBy(xpath = "//h1[@class='addClient-header']")
    private WebElement eleAddNewClientTxt;

    public WebElement getEleAddNewClientTxt() {
        return eleAddNewClientTxt;
    }

    @FindBy(xpath = "//a[text()='Create New']")
    private WebElement eleCreateNewClientDrpDwn;

    public WebElement getEleCreateNewClientDrpDwn() {
        return eleCreateNewClientDrpDwn;
    }

    @FindBy(xpath = "//input[@placeholder='mm/dd/yyyy']")
    private WebElement eleEnterDueDateTxtBox;

    public WebElement getEleEnterDueDateTxtBox() {
        return eleEnterDueDateTxtBox;
    }

    @FindBy(xpath = "//input[@placeholder='Enter email address']")
    private WebElement eleEnterEmailAddTxtBox;

    public WebElement getEleEnterEmailAddTxtBox() {
        return eleEnterEmailAddTxtBox;
    }

    @FindBy(xpath = "//button[@id='m-ic-continueBtn']")
    private WebElement eleContinueBtn;

    public WebElement getEleContinueBtn() {
        return eleContinueBtn;
    }

    @FindBy(xpath = "//button[@class='w-mc-name']")
    private WebElement eleFirstNameTxt;

    public WebElement getEleFirstNameTxt() {
        return eleFirstNameTxt;
    }

    public WebElement getEleSelectCreatedClientDrpDwn(String newClientName) {
        return getDriver().findElement(By.xpath("//a[text()='" + newClientName + "']"));
    }

    @FindBy(xpath = "//div[contains(text(),'Your enagagement invitation has been sent.')]")
    private WebElement eleEnagagementInivitationTxt;

    public WebElement getEleEnagagementInivitationTxt() {
        return eleEnagagementInivitationTxt;
    }

    @FindBy(xpath = "//button[text()='Invite']")
    private WebElement eleInviteBtn;

    public WebElement getEleInviteBtn() {
        return eleInviteBtn;
    }

    @FindBy(xpath = "//button[text()='Resend']")
    private WebElement eleResendBtn;

    public WebElement getEleResendBtn() {
        return eleResendBtn;
    }

}
