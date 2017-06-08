package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.pages.marketing.forgotpassword.PasswordResetSuccessPO;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class LoginMarketingPage extends AbstractPage {

    //@FindBy(xpath = "//input[@name='password']")
    @FindBy(xpath = "//*[@id=\"reset-password\"]/center/form/div[1]/div/input")
    private WebElement eleNewPasword;
    public WebElement getEleNewPasword(){ return eleNewPasword; }

    @FindBy(xpath = "//input[@name='retype_password']")
    private WebElement eleRetypeNewPassword;
    public WebElement getEleRetypeNewPassword() { return eleRetypeNewPassword; }

    @FindBy(xpath = "//div/button[contains(@class, 'button') and (text()='Cancel' or text()='Annuler')]")
    private WebElement btnCancel;
    public WebElement getBtnCancel() { return btnCancel; }

    @FindBy(xpath = "//div/button[contains(@class, 'button') and (text()='Reset' or text()='Réinitialiser')]")
    private WebElement btnReset;
    public WebElement getBtnReset() { return btnReset; }

    @FindBy(id = "reset-password-warning-popup")
    private WebElement resetPasswordWarningPopup;
    public WebElement getResetPasswordWarningPopup() { return resetPasswordWarningPopup; }

    @FindBy(id= "confirm-password-message")
    private WebElement confirmPasswordMessage;
    public WebElement getConfirmPasswordMessage() { return  confirmPasswordMessage; }

    public LoginMarketingPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#reset-password .exit")
    private WebElement btnExit;
    public WebElement getBtnExit() { return btnExit; }

    @FindBy(css = "#reset-password .login")
    private WebElement btnLogin;
    public WebElement getBtnLogin() { return btnLogin; }


    /*@Override
    protected void load() {

    }*/

    /**
     * TODO verify layout of this page
     * @throws Error
     */
    /*@Override*/
    protected void isLoadedExitLogin() throws Error {
        validateElememt(btnExit, "Exit button", Element_Type.DISPLAYED);
        validateElememt(btnLogin, "Login button", Element_Type.DISPLAYED);
    }

    public void exit(){
        btnExit.click();
    }

    public void login(){
        btnLogin.click();
    }

    /*@Override
    protected void load() {

    }

    *//**
     * TODO check layout of this page
     * @throws Error
     *//*
    @Override*/
    protected void isLoaded() throws Error {
        validateElememt(eleNewPasword, "New password input", Element_Type.DISPLAYED);
        validateElememt(eleRetypeNewPassword, "New retype password input", Element_Type.DISPLAYED);
    }

    public void resetPassword(String newPass, String retypeResetPass) throws InterruptedException {
        try {
            getLogger().info("Verify to reset password");
            Thread.sleep(smallTimeOut);
            switchToOtherTab(1);
            sendKeyTextBox(eleNewPasword, newPass, "send key to eleNewPasword");
            Thread.sleep(smallTimeOut);
            sendKeyTextBox(eleRetypeNewPassword, retypeResetPass, "send key to eleRetypeNewPassword");
            clickElement(btnReset, "click to btnReset");
            NXGReports.addStep("Verify to reset password", LogAs.PASSED, (CaptureScreen) null);
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to reset password", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    /**
     * Verify alert message when user inputs re new password
     */
    public void verifyPopupWarningWhenUserEnterReNewpassword(){
        String expectedColor =  GenericService.getConfigValue("auvenir.properties", "TEXT_COLOR_ERROR");
        if(IS_ENGLISH_LANGUAGE){
            if(!this.eleNewPasword.getText().equals(eleRetypeNewPassword.getText())){
                WebElement ele = this.confirmPasswordMessage.findElement(By.xpath("//div[i[@class='warning sign icon']]/div[text()='Your passwords do not match.']"));
                validateElememt(ele, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(ele, "color", expectedColor);
            }
        }else{
            if(!this.eleNewPasword.getText().equals(eleRetypeNewPassword.getText())){
                WebElement ele = this.confirmPasswordMessage.findElement(By.xpath("//div[i[@class='warning sign icon']]/div[text()='Vos mots de passe ne correspondent pas.']"));
                validateElememt(ele, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(ele, "color", expectedColor);
            }
        }
    }

    /**
     * Verufy alert message when user inputs new password
     * @param passwordLength
     * @param isContainsCapialLetter
     * @param isContainsLetter
     * @param isContainsNumber
     */
    public void verifyPopupWarning(int passwordLength, boolean isContainsCapialLetter, boolean isContainsLetter, boolean isContainsNumber){

        String expectedColor = GenericService.getConfigValue("auvenir.properties", "TEXT_COLOR_ERROR");
        if(IS_ENGLISH_LANGUAGE) {

            if (passwordLength < 8) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Consist of at least 8 characters']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsLetter) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least 1 letter']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsNumber) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least 1 number']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsCapialLetter) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least one capital letter']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsCapialLetter && !isContainsLetter) {
                WebElement elertMessageOfCapialLetter = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least one capital letter']"));
                validateElememt(elertMessageOfCapialLetter, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elertMessageOfCapialLetter, "color", expectedColor);

                WebElement elertMessageOfLowerLetter = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least 1 letter']"));
                validateElememt(elertMessageOfLowerLetter, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elertMessageOfLowerLetter, "color", expectedColor);
            }
        }else{
            if (passwordLength < 8) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[contains(text(), 'moins 8 caractères')]"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsLetter) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contenir au moins 1 lettre']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsNumber) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contenir au moins 1 numéro']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsCapialLetter) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contenir au moins une lettre majuscule']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsCapialLetter && !isContainsLetter) {
                WebElement elertMessageOfCapialLetter = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contenir au moins une lettre majuscule']"));
                validateElememt(elertMessageOfCapialLetter, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elertMessageOfCapialLetter, "color", expectedColor);

                WebElement elertMessageOfLowerLetter = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contenir au moins 1 lettre']"));
                validateElememt(elertMessageOfLowerLetter, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(elertMessageOfLowerLetter, "color", expectedColor);
            }
        }
    }


}
