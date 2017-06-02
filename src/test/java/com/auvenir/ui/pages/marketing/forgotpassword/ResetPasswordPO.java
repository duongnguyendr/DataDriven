package com.auvenir.ui.pages.marketing.forgotpassword;

//import com.auvenir.utilities.PropertiesHelper;
import com.auvenir.ui.pages.marketing.BaseMarketingPO;
import com.auvenir.utilities.GenericService;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/12/2017.
 * Reset password page
 */
public class ResetPasswordPO extends BaseMarketingPO {

    @FindBy(css = "#reset-password input[name='password']")
    private WebElement eleNewPasword;
    public WebElement getEleNewPasword(){ return eleNewPasword; }

    @FindBy(css = "#reset-password input[name='retype_password']")
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

    public ResetPasswordPO(Logger logger, WebDriver driver) {
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

    public PasswordResetSuccessPO reset(String newPass, String retypeResetPass){
        this.eleNewPasword.sendKeys(newPass);
        this.eleRetypeNewPassword.sendKeys(retypeResetPass);
        this.btnReset.click();

        return new PasswordResetSuccessPO(getLogger(),getDriver());
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
