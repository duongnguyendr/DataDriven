package com.auvenir.ui.pages.marketing.forgotpassword;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/12/2017.
 * Define all of elements in Reset Link Sent modal
 */
public class ResetLinkSentModalPO extends AbstractPage {

    @FindBy(id = "email-sending-popup")
    private WebElement resetLinkSendModal;
    public WebElement getResetLinkSendModal() { return resetLinkSendModal; }

    @FindBy(css = "#email-sending-popup .email-sending-title span")
    private WebElement titile;
    public WebElement getTitile() { return titile; }

    @FindBy(css = "#email-sending-popup .email-sending-content span")
    private WebElement eleTextContent;
    public WebElement getEleTextContent() { return eleTextContent; }

    public ResetLinkSentModalPO(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /*@Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        validateElememt(resetLinkSendModal, "Reset password modal", Element_Type.DISPLAYED);
    }*/

    /**
     * TODO
     * Verify content modal
     */
    public void verifyContentModal(String email){
        String expectedContent = "A reset link has been sent to " + email + ".\n" +
                "Follow the instructions to reset your password.";
        //String expectedContent = "A reset link has been sent to " + email + ". Follow the instructions to reset your password.";
        validateElememt(eleTextContent, expectedContent, Element_Type.TEXT_VALUE);
    }

    /**
     * TODO
     * Verify email receiver
     */
    public void verifyEmailReceiver(){
        
    }
}
