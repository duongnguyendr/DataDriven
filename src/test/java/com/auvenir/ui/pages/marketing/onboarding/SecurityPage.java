package com.auvenir.ui.pages.marketing.onboarding;

//import com.auvenir.utilities.PropertiesHelper;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/12/2017.
 */
public class SecurityPage extends AbstractPage {

    public SecurityPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    //=======================================  Element of Breadcrumb Completed page PERSONAL ===================================
    @FindBy(xpath = "(//div[@class='completed step']/div/div[@class='title'])[1]")
    private WebElement elePagePersonal;
    public WebElement getElePagePersonal() {return elePagePersonal;}

    // Element of Breadcrumb Completed page FIRM
    @FindBy(xpath = "(//div[@class='completed step']/div/div[@class='title'])[2]")
    private WebElement elePageFirm;
    public WebElement getElePageFirm() {return elePageFirm;}

    // Element of Breadcrumb of Active page
    @FindBy(xpath = "//div[@class='active step']/div[div[text()='SÉCURITÉ'] or text()='SECURITY']")
    private WebElement elePageActive;
    public WebElement getElePageActive(){return elePageActive; }

    // ======================================  Element of Create Password ===================================================
    @FindBy(xpath = "//input[@name='password']")
    private WebElement elePassword;
    public WebElement getElePassword() {return elePassword;}

    // Element of Confirm Password
    @FindBy(xpath = "//input[@name='retype_password']")
    private WebElement eleConfirmPass;
    public WebElement getEleConfirmPass() {return eleConfirmPass;}

    // Element of checkbox Captcha
    @FindBy(css = ".rc-anchor-checkbox-holder")
    private WebElement chkCaptcha;
    public WebElement getChkCaptcha() { return chkCaptcha;}

    // Element of Continue Button
    @FindBy(id = "btn-continue")
    private WebElement btnContinue;
    public WebElement getBtnContinue() {return btnContinue;}

    // Element of Create password warning
    @FindBy(id = "reset-password-warning-popup")
    private WebElement resetPasswordWarningPopup;

    // Element of Create password warning
    @FindBy(id = "create-password-warning-popup")
    private WebElement createPasswordWarningPopup;
    public WebElement getCreatePasswordWarningPopup() {return createPasswordWarningPopup;}

    // Element of Confirm password warning
    @FindBy(id = "confirm-password-message")
    private WebElement confirmPasswordWarningPopup;
    public WebElement getConfirmPasswordWarningPopup() {return confirmPasswordWarningPopup;}

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-checkmark']")
    private WebElement captchaCheckBox;

    @FindBy(xpath = "//*[contains(text(),'Contain at least one capital letter')]")
    private  WebElement capitalLetterMessage;

    //@Override
    public void verifyPageContent() {
        if(IS_ENGLISH_LANGUAGE) {
            validateElememt(elePagePersonal, "PERSONAL", Element_Type.TEXT_VALUE);
            validateElememt(elePageFirm, "FIRM", Element_Type.TEXT_VALUE);
        }else {
            validateElememt(elePagePersonal, "PERSONNEL", Element_Type.TEXT_VALUE);
            validateElememt(elePageFirm, "RAFFERMIR", Element_Type.TEXT_VALUE);
        }
        isLoaded();
    }

    /*@Override
    protected void load() {

    }

    @Override*/
    protected void isLoaded() throws Error {
        // Checking Create Password element is displayed
        validateElememt(elePassword, "Element of Password", Element_Type.DISPLAYED);
        // Checking Confirm Password element is displayed
        validateElememt(eleConfirmPass, "Element of Confirm Password", Element_Type.DISPLAYED);
        // Checking button Continue element is displayed
        validateElememt(btnContinue, "Element of button Continue", Element_Type.DISPLAYED);
    }

    public void createPassword(String strPass, String strCaptcha) {
        try {
            waitForVisibleElement(elePassword, "Password Input");
            sendKeyTextBox(elePassword, strPass, "Password Input");
//            elePassword.sendKeys(strPass);
//            NXGReports.addStep("Input Password", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            waitForVisibleElement(eleConfirmPass, "Confirm Password Input");
            sendKeyTextBox(eleConfirmPass, strPass, "Confirm Password Input");
//            eleConfirmPass.sendKeys(strPass);
//            NXGReports.addStep("Input confirm Password", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            /*waitForVisibleElement(captchaCheckBox,"captcha check box");
            clickElement(captchaCheckBox,"captcha check box");*/
            /*Keyboard keyboard = null;
            try {
                keyboard = new Keyboard();
                Thread.sleep(1000);
                keyboard.type("\t");
                Thread.sleep(1000);
                keyboard.type(" ");
            } catch (AWTException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            clickElement(btnContinue,"continue button");
            //btnContinue.click();

        } catch (NoSuchElementException e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }

        // Verify Register Auditor Security Page is passed
//        try {
//            this.validateElememt(elePageActive,"Page Register Auditor SECURITY ", Element_Type.NOT_EXIST);
//            NXGReports.addStep("Register Auditor Security passed", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        } catch (NoSuchElementException e) {
//            NXGReports.addStep("Register Auditor Security failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//            throw new AssertionError(e.getMessage());
//        }
    }


    public void verifyCreatePasswordPopupWarning(int passwordLength, boolean isContainsCapialLetter, boolean isContainsLetter, boolean isContainsNumber) {
//        String expectedColor = GenericService.getConfigValue("auvenir.properties", "TEXT_COLOR_ERROR");
        String expectedColor = "#eb502c";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForVisibleElement(resetPasswordWarningPopup, "password error message");
        if (IS_ENGLISH_LANGUAGE) {
            if (passwordLength < 8) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Consist of at least 8 characters']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
                validateCssValueElement(elert, "color", expectedColor);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsLetter) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least 1 letter']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
//                validateCssValueElement(elert, "color", expectedColor);
                verifyCssValue(elert, "color", expectedColor);
            }

            if (!isContainsNumber) {
                WebElement elert = this.resetPasswordWarningPopup.findElement(By.xpath("//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least 1 number']"));
                validateElememt(elert, "Alert message.", Element_Type.DISPLAYED);
//                validateCssValueElement(elert, "color", expectedColor);
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
        } else {
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

    public void verifyConfirmPasswordPopupWarning() {
        String expectedColor = GenericService.getConfigValue("auvenir.properties", "TEXT_COLOR_ERROR");
        waitForVisibleElement(resetPasswordWarningPopup, "password error message");
        if(IS_ENGLISH_LANGUAGE){
            if(!this.elePassword.getText().equals(eleConfirmPass.getText())){
                WebElement ele = this.resetPasswordWarningPopup.findElement(By.xpath("//div[i[@class='warning sign icon']]/div[text()='Your passwords do not match.']"));
                validateElememt(ele, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(ele, "color", expectedColor);
            }
        }else{
            if(!this.elePassword.getText().equals(eleConfirmPass.getText())){
                WebElement ele = this.resetPasswordWarningPopup.findElement(By.xpath("//div[i[@class='warning sign icon']]/div[text()='Vos mots de passe ne correspondent pas.']"));
                validateElememt(ele, "Alert message.", Element_Type.DISPLAYED);
                verifyCssValue(ele, "color", expectedColor);
            }
        }
    }

    public void inputValueIntoControl(WebElement eleInput, String strDescription, String strName){
        try {
            waitForVisibleElement(eleInput,strDescription);
            eleInput.sendKeys(strName);
            NXGReports.addStep("Input "+ strDescription, LogAs.PASSED, null);

        }catch (NoSuchElementException e){
            NXGReports.addStep("Element is not found", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }

    public void inputValueIntoPaswordInput(String strName){
        inputValueIntoControl(elePassword, "password",strName);
    }

    public void inputValueIntoConfirmPaswordInput(String strName){
        inputValueIntoControl(eleConfirmPass, "password",strName);
    }

}
