package com.auvenir.ui.pages.forgotpassword;

import com.auvenir.ui.pages.marketing.BaseMarketingPO;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/12/2017.
 * Reset password successful page
 */
public class PasswordResetSuccessPO extends BaseMarketingPO {

    @FindBy(css = "#reset-password .exit")
    private WebElement btnExit;
    public WebElement getBtnExit() { return btnExit; }

    @FindBy(css = "#reset-password .login")
    private WebElement btnLogin;
    public WebElement getBtnLogin() { return btnLogin; }

    public PasswordResetSuccessPO(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify page content
     */
    @Override
    public void verifyContentPage() {

    }

    /*@Override
    protected void load() {

    }*/

    /**
     * TODO verify layout of this page
     * @throws Error
     */
    /*@Override*/
    protected void isLoaded() throws Error {
        validateElememt(btnExit, "Exit button", Element_Type.DISPLAYED);
        validateElememt(btnLogin, "Login button", Element_Type.DISPLAYED);
    }

    public void exit(){
        btnExit.click();
    }

    public void login(){
        btnLogin.click();
    }
}
