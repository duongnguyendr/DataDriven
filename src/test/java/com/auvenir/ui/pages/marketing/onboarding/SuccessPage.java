package com.auvenir.ui.pages.marketing.onboarding;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/12/2017.
 */
public class SuccessPage extends AbstractPage {

    public SuccessPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    // Element of Success Creation Account
    @FindBy(xpath = "//*[@id='account-created-confirmation']//h1[@class='ui header']")
    private WebElement successPageHeaderEle;

    public WebElement getSuccessPageHeaderEle() {
        return successPageHeaderEle;
    }

    // Element image letter
    @FindBy(css = ".ui.image")
    private WebElement eleImageLetter;

    public WebElement getEleImageLetter() {
        return eleImageLetter;
    }

    // Element button Continue
    @FindBy(id = "btn-continue")
    private WebElement btnContinue;

    public WebElement getBtnClose() {
        return btnContinue;
    }


    //@Override
    public void verifyPageContent() {
        waitForVisibleElement(successPageHeaderEle, "Success Page Header");
        validateElememt(successPageHeaderEle, "Success Page Header", Element_Type.DISPLAYED);
        validateElememt(successPageHeaderEle, "Your Account Is on the Waitlist!", Element_Type.TEXT_VALUE);
        isLoaded();
    }

    /*@Override
    public void load(){
        //
    }

    @Override*/
    public void isLoaded() throws Error {
        // Checking Image Letter element is displayed
        waitForVisibleElement(eleImageLetter, "Image Letter");
        validateElememt(eleImageLetter, "Element of Image Letter", Element_Type.DISPLAYED);
        // Checking button Close element is displayed
        validateElememt(btnContinue, "Element of button Continue", Element_Type.DISPLAYED);

    }

    public void acceptCreateAccountAuditor() {
        clickElement(btnContinue, "Continue Button");
    }
}
