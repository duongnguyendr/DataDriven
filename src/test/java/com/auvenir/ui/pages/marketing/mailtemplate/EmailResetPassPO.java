package com.auvenir.ui.pages.marketing.mailtemplate;

import com.auvenir.ui.pages.marketing.forgotpassword.ResetPasswordPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/12/2017.
 * Define all of elements in email template after user enter email to forgot password
 */
public class EmailResetPassPO extends BaseMailTemplatePO {

    @FindBy(xpath = "//a[contains(@href, 'http://auvenir.s3corp.com.vn:5000/reset-password?token=')]")
    private WebElement btnResetPassword;
    public WebElement getBtnResetPassword() { return btnResetPassword; }

    public EmailResetPassPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void verifyPageContent() {

    }

    /*@Override
    protected void load() {

    }

    @Override*/
    protected void isLoaded() throws Error {
        validateElememt(btnResetPassword, "Reset password button in email", Element_Type.DISPLAYED);
    }

    /**
     * Navigate to reset password
     */
    public ResetPasswordPO navigateResetPasswordPage(){
        btnResetPassword.click();
        //Switch to Reset password tab
        switchToOtherTab(1);
        return new ResetPasswordPO(getLogger(),getDriver());
    }
}
