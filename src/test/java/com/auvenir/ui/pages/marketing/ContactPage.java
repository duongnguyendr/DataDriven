package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
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
    private String headerTextCst = "Get In Touch! We are here to support you and would love to hear your feedback.";
    private String getInTouchTextCst = "Get in Touch with Auvenir\n" + "We will respond within 24 hours.";
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
        getLogger().info("Verify contact content page");
        boolean checkHeaderText = false;
        String strGetTouchText = "";
        boolean isCheckContactContentPage,isCheckContactContentPage1,isCheckContactContentPage2,isCheckContactContentPage3,isCheckContactContentPage4,
                isCheckContactContentPage5, isCheckContactContentPage6, isCheckContactContentPage7,isCheckContactContentPage8= false;
        isCheckContactContentPage = waitForVisibleElement(auvenirLogoImage,"auvenirLogoImage");
        isCheckContactContentPage1 = waitForVisibleElement(headerText,"headerText");
        if(headerText.getText().equals(headerTextCst))
        {
            checkHeaderText = true;
        }
        isCheckContactContentPage2 = waitForVisibleElement(getInTouchText,"getInTouchText");
        strGetTouchText = getInTouchText.getText();
        boolean isCheckTouchText = false;
        if(strGetTouchText.equals(getInTouchTextCst))
        {
            isCheckTouchText = true;
        }
        getLogger().info("strGetTouchText = " + strGetTouchText);
        isCheckContactContentPage3 = waitForVisibleElement(nameTextBox,"nameTextBox");
        isCheckContactContentPage4 = waitForVisibleElement(emailTextBox,"emailTextBox");
        isCheckContactContentPage5 = waitForVisibleElement(directMessageDropdown,"directMessageDropdown");
        isCheckContactContentPage6 = waitForVisibleElement(messageTextBox,"messageTextBox");
        isCheckContactContentPage7 = waitForVisibleElement(sendMessageBTN,"sendMessageBTN");
        isCheckContactContentPage8 = waitForVisibleElement(contactMapImage,"contactMapImage");
        if(isCheckTouchText & isCheckContactContentPage & isCheckContactContentPage1 & isCheckContactContentPage2 & isCheckContactContentPage3
                & isCheckContactContentPage4 & isCheckContactContentPage5 & isCheckContactContentPage6 & isCheckContactContentPage7 & isCheckContactContentPage8
                & checkHeaderText)
        {
            NXGReports.addStep("Verify contact content page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }
        else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify contact content page: PASSED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
