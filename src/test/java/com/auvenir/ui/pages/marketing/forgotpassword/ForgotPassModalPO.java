package com.auvenir.ui.pages.marketing.forgotpassword;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/12/2017.
 * Define all of elements in Forgot Password modal
 */
public class ForgotPassModalPO extends AbstractPage {

    @FindBy(id = "forgot-popup")
    private WebElement eleForgorPasswordModal;
    public WebElement getEleForgorPasswordModal() { return eleForgorPasswordModal; }

    @FindBy(css = "#forgot-popup input[name='email']")
    private WebElement eleEmail;
    public WebElement getEleEmail() { return eleEmail; }

    @FindBy(css = "#forgot-popup .submit-forgot")
    private WebElement eleRequestResetLink;
    public WebElement getEleRequestResetLink() { return eleRequestResetLink; }

    @FindBy(css = "#forgot-popup .message p")
    private WebElement eleErrorMessage;
    public WebElement getEleErrorMessage() { return  eleErrorMessage; }

    public ForgotPassModalPO(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /*@Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        validateElememt(eleForgorPasswordModal, "Forgot password modal", Element_Type.DISPLAYED);
        validateElememt(eleErrorMessage, "Error message", Element_Type.NOT_EXIST);
    }*/

    /**
     * Verify Forgot Password modal hide
     * @param timeOut
     */
    public void modalHide(int timeOut){
        waitUtilElementHidden(By.id("forgot-popup"), 10);
        validateElememt(eleForgorPasswordModal, "Forgot password modal", Element_Type.HIDDEN);
    }

    /**
     * Reset password
     * @param email
     */
    /*public ResetLinkSentModalPO resetPassword(String email){
        eleEmail.sendKeys(email);
        eleRequestResetLink.click();
        ResetLinkSentModalPO resetLinkSentModalPO =  new ResetLinkSentModalPO(driver);

        if(IS_ENGLISH_LANGUAGE){
            waitUtilTextPresent(resetLinkSentModalPO.getTitile(), 20, "Reset Link Sent");
        }else{
            waitUtilTextPresent(resetLinkSentModalPO.getTitile(), 20, "Lien de réinitialisation envoyé");
        }
        return resetLinkSentModalPO;
    }*/
}
