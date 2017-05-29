package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/11/2017.
 * Define all of elements in Login modal
 */
public class LoginModalPO extends AbstractPage {

    public LoginModalPO(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "login-popup")
    private WebElement eleLoginModal;
    public WebElement getEleLoginModal(){ return eleLoginModal; }

    @FindBy(css = "#login-popup input[name='email']")
    private WebElement eleEmail;
    public WebElement getEleEmail(){ return eleEmail; }

    @FindBy(css = "#login-popup input[name='password']")
    private WebElement elePassword;
    public WebElement getElePassword() { return elePassword; }

    @FindBy(css = "#login-popup .forgot-password")
    private WebElement eleForgot;
    public WebElement getEleForgot() { return eleForgot; }

    @FindBy(css = "#login-popup .submit-login")
    private WebElement btnLogin;
    public  WebElement getBtnLogin() { return btnLogin; }

    @FindBy(css = "#login-popup .message")
    private WebElement eleForgotPassword;
    public WebElement getEleForgotPassword() { return eleForgotPassword; }

    @FindBy(css = "#login-popup .message")
    private WebElement eleErrorMessage;
    public WebElement getEleErrorMessage() { return  eleErrorMessage; }

    /*@Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        verifyDesignLoginModal();
    }*/

    /**
     * Check login feature
     */
    public void login(String email, String pass){

        NXGReports.addStep("Enter email: " + email, LogAs.PASSED, null);
        eleEmail.sendKeys(email);

        NXGReports.addStep("Enter password: " + pass, LogAs.PASSED, null);
        elePassword.sendKeys(pass);

        btnLogin.click();
    }

    /**
     * Navigate to forgot password
     */
    /*public ForgotPassModalPO navigateToForgotPassword(){
        this.eleForgot.click();
        return new ForgotPassModalPO(driver);
    }*/

    /**
     * Verify Login modal hide
     * @param timeOut
     */
    public void modalHide(int timeOut){
        waitUtilElementHidden(By.id("login-popup"), 10);
        validateElememt(eleLoginModal, "Login modal", Element_Type.HIDDEN);
    }

    /**
     * Verify of all elements in Login modal
     */
    public void verifyDesignLoginModal(){
        validateElememt(eleLoginModal, "Login modal", Element_Type.DISPLAYED);
        validateElememt(eleErrorMessage, "Error message", Element_Type.NOT_EXIST);
    }
}
