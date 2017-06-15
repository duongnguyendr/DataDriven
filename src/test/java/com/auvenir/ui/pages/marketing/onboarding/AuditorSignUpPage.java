package com.auvenir.ui.pages.marketing.onboarding;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.pages.marketing.MarketingPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

/**
 * Created by cuong.nguyen on 4/12/2017.
 */
public class AuditorSignUpPage extends AbstractPage {
    MarketingPage marketingPage;
    public AuditorSignUpPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    // =============================================== Element of Breadcrumb Completed page ===============================
    @FindBy(xpath = "(//div[@class='completed step']/div/div[@class='title'])[1]")
    private WebElement personalInfoCompleteIconEle;

    public WebElement getPersonalInfoCompleteIconEle() {
        return personalInfoCompleteIconEle;
    }

    // Element of Breadcrumb of Active page
    @FindBy(xpath = "//div[@class='active step']/div[div[text()='RAFFERMIR'] or text()='FIRM']")
    private WebElement elePageActive;

    public WebElement getElePageActive() {
        return elePageActive;
    }

    // ================================================ Element of Firm Name  =============================================
    @FindBy(xpath = "//input[@name='firm_name']")
    private WebElement eleFirmName;

    public WebElement getEleFirmName() {
        return eleFirmName;
    }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_name']")
    private WebElement eleFirmNameError;

    // Element of checkbox rule changed Name
    @FindBy(xpath = "//div[@class='ui checkbox']/label[starts-with(text(),'Firm') or starts-with(text(),'Le')]")
    private WebElement chkChangedName;

    public WebElement getChkChangedName() {
        return chkChangedName;
    }

    // Element of Firm previous Name
    @FindBy(xpath = "//input[@name='firm_previous_name']")
    private WebElement elePreFirmName;

    public WebElement getElePreFirmName() {
        return elePreFirmName;
    }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_previous_name']")
    private WebElement elePreFirmNameError;

    // Element of Firm website
    @FindBy(xpath = "//input[@name='firm_website']")
    private WebElement eleFirmWebsite;

    public WebElement getEleFirmWebsite() {
        return eleFirmWebsite;
    }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_website']")
    private WebElement elePreFirmWebsiteError;

    // Element of Full Address
    @FindBy(xpath = "//input[@name='firm_full_address']")
    private WebElement eleFullAddress;

    public WebElement getEleFullAddress() {
        return eleFullAddress;
    }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_full_address']")
    private WebElement eleFullAddressError;

    // Element of Street Address
    @FindBy(xpath = "//input[@name='firm_street_address']")
    private WebElement eleStreetAddress;

    public WebElement getEleStreetAddress() {
        return eleStreetAddress;
    }

    // Element of Office number
    @FindBy(xpath = "//input[@name='firm_suit_number']")
    private WebElement eleOfficeNumber;

    public WebElement getEleOfficeNumber() {
        return eleOfficeNumber;
    }

    // Element of Zip Code
    @FindBy(xpath = "//input[@name='firm_postal_code']")
    private WebElement eleZipCode;

    public WebElement getEleZipCode() {
        return eleZipCode;
    }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_postal_code']")
    private WebElement eleZipCodeError;

    // Element of City
    @FindBy(xpath = "//input[@name='firm_city']")
    private WebElement eleCity;

    public WebElement getEleCity() {
        return eleCity;
    }

    // Element of State Dropdown list
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[1]")
    private WebElement provinceDropdownEle;

    public WebElement getProvinceDropdownEle() {
        return provinceDropdownEle;
    }

    // Element with locator of Menu listbox
    @FindBy(xpath = "//div[@class='menu transition visible']")
    private WebElement eleMenu;

    public WebElement getEleMenu() {
        return eleMenu;
    }

    // Element of Member I.D
    @FindBy(xpath = "//input[@name='firm_member_id']")
    private WebElement eleMemberID;

    public WebElement getEleMemberID() {
        return eleMemberID;
    }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_member_id']")
    private WebElement eleMemberIdError;

    // Element of Number of Employees Dropdown
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[2]")
    private WebElement numberEmployeeDropdown;

    public WebElement getNumberEmployeeDropdown() {
        return numberEmployeeDropdown;
    }

    // Element of Phone Number
    @FindBy(xpath = "//input[@name='firm_phone_number']")
    private WebElement phoneNumberFirmInfoEle;

    public WebElement getPhoneNumberFirmInfoEle() {
        return phoneNumberFirmInfoEle;
    }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_phone_number']")
    private WebElement elePhoneNumberIdError;

    // Element of checkbox affiliated Firm
    @FindBy(xpath = "//div[@class='ui checkbox']/label[starts-with(text(),'I') or starts-with(text(),'Je')]")
    private WebElement chkAffFirm;

    public WebElement getChkAffFirm() {
        return chkAffFirm;
    }

    // Element of Affiliated Firm Name
    @FindBy(xpath = "//label[text()='Affiliated Firm’s Name' or contains(text(),'Nom de')]/following-sibling::div[1]/input")
    private WebElement eleAffFirm;

    public WebElement getEleAffFirm() {
        return eleAffFirm;
    }

    @FindBy(xpath = "//div[@class='error field']//label[text()='Affiliated Firm’s Name' or contains(text(),'Nom de')]/following-sibling::div[1]/input")
    private WebElement eleAffFirmError;


    // Element of Link add Affiliated Firm
    @FindBy(css = ".add-field")
    private WebElement lnkAddFirm;

    public WebElement getLnkAddFirm() {
        return lnkAddFirm;
    }

    // Element of Update Logo button
    @FindBy(xpath = "//label[@for='btn-upload']")
    private WebElement btnUpdateLogo;

    public WebElement getBtnUpdateLogo() {
        return btnUpdateLogo;
    }

    // Element of checkbox Rule Logo
    @FindBy(xpath = "//label[starts-with(text(),'Once') or starts-with(text(),'Un')]")
    private WebElement chkRuleLogo;

    public WebElement getChkRuleLogo() {
        return chkRuleLogo;
    }

    // Element of button Continue
    @FindBy(id = "btn-continue")
    private WebElement btnContinue;

    public WebElement getBtnContinue() {
        return btnContinue;
    }

    // Page Security Information Div Element
    @FindBy(xpath = "//*[@id='create-password']")
    private WebElement pageSecurityInfoEle;

    public WebElement getPageSecurityInfoEle() {
        return pageSecurityInfoEle;
    }

    // List Item of Province/State Dropdown list
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[1]//div[@class='menu transition visible']/div")
    private List<WebElement> provinceDdlListItemEle;

    public List<WebElement> getprovinceDdlListItemEle() {
        return provinceDdlListItemEle;
    }

    // List Item of Number Of Employee Dropdown list
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[2]//div[@class='menu transition visible']/div")
    private List<WebElement> numberEmployeeDdlListItemEle;

    public List<WebElement> getNumberEmployeeDdlListItemEle() {
        return numberEmployeeDdlListItemEle;
    }

//    final String warningBorderCSSColor = "rgb(253, 109, 71)";
//    final String warningBackgroundCSSColor = "rgba(241, 103, 57, 0.2)";
    // This constant is used with color - CSS name;
    final String warningTextCSSColor = "rgba(235, 80, 44, 1)";
    final String successTextCSSColor = "rgba(73, 138, 144, 1)";

    ///////////////Element from PersonalPage.java
    // ================================= Element of Content page ==============================================
    @FindBy(xpath = "//div[@class='step-content' and @id='step1']")
    private WebElement eleFrameAuditorPersonal;

    public WebElement getEleFrameAuditorPersonal() {
        return eleFrameAuditorPersonal;
    }

    // ================================= Element of First and Last Name =======================================
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_fullname']")
    private WebElement eleName;

    public WebElement getEleName() {
        return eleName;
    }

    // Element of EmailAddress
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_email']")
    private WebElement eleEmail;

    public WebElement getEleEmail() {
        return eleEmail;
    }

    // Element with locator of confirm EmailAddress
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_email_confirm']")
    private WebElement eleConfirmEmail;

    public WebElement getEleConfirmEmail() {
        return eleConfirmEmail;
    }

    // Element of ListBox Role in Firm
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[1]")
    private WebElement eleRoleFirm;

    public WebElement getEleRoleFirm() {
        return eleRoleFirm;
    }

    // Element of Phone Number
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_phone_number']")
    private WebElement elePhoneNumber;

    public WebElement getElePhoneNumber() {
        return phoneNumberFirmInfoEle;
    }

    // Element of Hear about Auvenir
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[2]")
    private WebElement eleReference;

    public WebElement getEleReference() {
        return eleReference;
    }

    // Element of checkbox I agree
    @FindBy(xpath = "//div[@class='ui checkbox']/label/span")
    private WebElement chkAgree;

    public WebElement getChkAgree() {
        return chkAgree;
    }

    // Element of checkbox I confirm
    @FindBy(xpath = "//div[@class='ui checkbox']/label[contains(text(),'confirm')]/..")
    private WebElement chkConfirm;

    public WebElement getChkConfirm() {
        return chkConfirm;
    }

    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_fullname']")
    private WebElement fullNameError;

    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_email']")
    private WebElement emailError;

    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_email_confirm']")
    private WebElement confirmEmailError;

    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_phone_number']")
    private WebElement phoneError;

    // List Item of ListBox Role in Firm
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[1]//div[@class='menu transition visible']/div")
    private List<WebElement> listItemRoleFirmEle;

    public List<WebElement> getListItemRoleFirmEle() {
        return listItemRoleFirmEle;
    }

    // List Item of Option 'Hear about Auvenir'
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[2]//div[@class='menu transition visible']/div")
    private List<WebElement> listItemReferenceEle;

    public List<WebElement> getListItemReferenceEle() {
        return listItemReferenceEle;
    }

    // Page Provide Firm Information Div Element
    @FindBy(xpath = "//div[@class='step-content' and @id='step2']")
    private WebElement pageProvideFirmInfoEle;

    public WebElement getPageProvideFirmInfoEle() {
        return pageProvideFirmInfoEle;
    }

    //Header Provide Personal Info form.
    @FindBy(xpath = "//*[@id='step1']/h2")
    private WebElement personalPageSignUpHeaderEle;

    public WebElement getPersonalPageSignUpHeaderEle() {
        return personalPageSignUpHeaderEle;
    }


    // Element of Breadcrumb Completed page FIRM
    @FindBy(xpath = "(//div[@class='completed step']/div/div[@class='title'])[2]")
    private WebElement firmInfoCompleteIconEle;

    public WebElement getFirmInfoCompleteIconEle() {
        return firmInfoCompleteIconEle;
    }

    // Element of Breadcrumb of Security page
    @FindBy(xpath = "//div[@class='active step']/div[div[text()='SÉCURITÉ'] or text()='SECURITY']")
    private WebElement securityInfoActiveIconEle;

    public WebElement getSecurityInfoActiveIconEle() {
        return securityInfoActiveIconEle;
    }

    // ======================================  Element of Create Password ===================================================
//    @FindBy(xpath = "//input[@name='password']")
    @FindBy(xpath = "//input[@id='first-password']")
    private WebElement elePassword;

    public WebElement getElePassword() {
        return elePassword;
    }

    // Element of Confirm Password
//    @FindBy(xpath = "//input[@name='retype_password']")
    @FindBy(xpath = "//input[@id='second-password']")
    private WebElement eleConfirmPass;

    public WebElement getEleConfirmPass() {
        return eleConfirmPass;
    }

    // Element of checkbox Captcha
    @FindBy(css = ".rc-anchor-checkbox-holder")
    private WebElement chkCaptcha;

    public WebElement getChkCaptcha() {
        return chkCaptcha;
    }

    // Element of Create password warning
    @FindBy(id = "reset-password-warning-popup")
    private WebElement resetPasswordWarningPopup;

    // Element of Rule Password warning in English
    // Consist of at least 8 characters
    @FindBy(xpath = "//div[@class='item' and i[@class='warning sign icon']]/div[text()='Consist of at least 8 characters']")
    private WebElement warning8charPasswordEngEle;

    @FindBy(xpath = "//div[@class='item' and i[@class='checkmark icon']]/div[text()='Consist of at least 8 characters']")
    private WebElement success8charPasswordEngEle;

    // Contain at least 1 letter
    @FindBy(xpath = "//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least 1 letter']")
    private WebElement warning1LetterPasswordEngEle;

    @FindBy(xpath = "//div[@class='item' and i[@class='checkmark icon']]/div[text()='Contain at least 1 letter']")
    private WebElement success1LetterPasswordEngEle;

    // Contain at least 1 number
    @FindBy(xpath = "//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least 1 number']")
    private WebElement warning1NumberPasswordEngEle;

    @FindBy(xpath = "//div[@class='item' and i[@class='checkmark icon']]/div[text()='Contain at least 1 number']")
    private WebElement success1NumberPasswordEngEle;

    // Contain at least one capital letter
    @FindBy(xpath = "//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contain at least one capital letter']")
    private WebElement warning1CapLetterPasswordEngEle;

    @FindBy(xpath = "//div[@class='item' and i[@class='checkmark icon']]/div[text()='Contain at least one capital letter']")
    private WebElement success1CapLetterPasswordEngEle;

    // Element of Rule Password warning in French
    // Consist of at least 8 characters
    @FindBy(xpath = "//div[@class='item' and i[@class='warning sign icon']]/div[contains(text(), 'moins 8 caractères')]")
    private WebElement warning8charPasswordFraEle;

    @FindBy(xpath = "//div[@class='item' and i[@class='checkmark icon']]/div[contains(text(), 'moins 8 caractères')]")
    private WebElement success8charPasswordFraEle;

    // Contain at least 1 letter
    @FindBy(xpath = "//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contenir au moins 1 lettre']")
    private WebElement warning1LetterPasswordFraEle;

    @FindBy(xpath = "//div[@class='item' and i[@class='checkmark icon']]/div[text()='Contenir au moins 1 lettre']")
    private WebElement success1LetterPasswordFraEle;

    // Contain at least 1 number
    @FindBy(xpath = "//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contenir au moins 1 numéro']")
    private WebElement warning1NumberPasswordFraEle;

    @FindBy(xpath = "//div[@class='item' and i[@class='checkmark icon']]/div[text()='Contenir au moins 1 numéro']")
    private WebElement success1NumberPasswordFraEle;

    // Contain at least one capital letter
    @FindBy(xpath = "//div[@class='item' and i[@class='warning sign icon']]/div[text()='Contenir au moins une lettre majuscule']")
    private WebElement warning1CapLetterPasswordFraEle;

    @FindBy(xpath = "//div[@class='item' and i[@class='checkmark icon']]/div[text()='Contenir au moins une lettre majuscule']")
    private WebElement success1CapLetterPasswordFraEle;

    // Element of Password Confirmation not Match warning in French and English
    @FindBy(xpath = "//div[i[@class='warning sign icon']]/div[text()='Your passwords do not match.']")
    private WebElement warningPasswordNotMacthEngEle;

    @FindBy(xpath = "//div[i[@class='warning sign icon']]/div[text()='Vos mots de passe ne correspondent pas.']")
    private WebElement warningPasswordNotMacthFraEle;

    // Element of Create password warning
    @FindBy(id = "create-password-warning-popup")
    private WebElement createPasswordWarningPopup;

    public WebElement getCreatePasswordWarningPopup() {
        return createPasswordWarningPopup;
    }

    // Element of Confirm password warning
    @FindBy(id = "confirm-password-message")
    private WebElement confirmPasswordWarningPopup;

    public WebElement getConfirmPasswordWarningPopup() {
        return confirmPasswordWarningPopup;
    }

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-checkmark']")
    private WebElement captchaCheckBox;

    @FindBy(xpath = "//*[contains(text(),'Contain at least one capital letter')]")
    private WebElement capitalLetterMessage;

    ////////Element from SuccessPage.java
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

    // ======================================  Element of Confirm Information Sign Up=====================================
    @FindBy(xpath = "//*[@id='personal-name']")
    private WebElement fullNameConfirmTxtEle;

    @FindBy(xpath = "//*[@id='personal-email']")
    private WebElement emailConfirmTxtEle;

    @FindBy(xpath = "//*[@id='personal-secondEmail']")
    private WebElement emailReEnterConfirmTxtEle;

    @FindBy(xpath = "//*[@id='personal-role']")
    private WebElement roleConfirmTxtEle;

    @FindBy(xpath = "//*[@id='personal-phoneNumber']")
    private WebElement phoneConfirmTxtEle;

    @FindBy(xpath = "//*[@id='personal-referral']")
    private WebElement referalConfirmDrdEle;

    @FindBy(xpath = "//*[@id='personal-referral-container']/ul/li")
    private List<WebElement> listItemreferalConfirmDrdEle;

    @FindBy(xpath = "//*[@id='agreement-personal']")
    private WebElement agreePrivacyConfirmCheckboxEle;

    @FindBy(xpath = "//*[@id='agreement-personal-cpa']")
    private WebElement agreeCPAConfirmCheckboxEle;

    @FindBy(xpath = "//button[@id='personal-coninueBtn']")
    private WebElement continuePerConfirmBtnEle;

    @FindBy(xpath = "//*[@id='firm-name']")
    private WebElement firmNameConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-website']")
    private WebElement firmWebsiteConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-streetAddress']")
    private WebElement firmStreetAdrConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-unit']")
    private WebElement firmSuiteNumConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-city']")
    private WebElement firmCityConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-stateProvince']")
    private WebElement firmStateConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-country']")
    private WebElement firmCountryConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-postalCode']")
    private WebElement firmPostalConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-size']")
    private WebElement firmNumEmployeeConfirmTxtEle;

    @FindBy(xpath = "//*[@id='firm-size-container']/ul/li")
    private List<WebElement> firmListItemEmployeeConfirmDrdEle;

    @FindBy(xpath = "//*[@id='firm-phone']")
    private List<WebElement> firmPhoneConfirmTxtEle;

    @FindBy(xpath = "//*[@id='onboarding-firm-container']/div/h3")
    private WebElement firmHeaderTxtEle;

    @FindBy(xpath = "//button[@id='onboard-firm-continue']")
    private WebElement continueFirmConfirmBtnEle;

    @FindBy(xpath = "//*[@id='security-continueBtn']")
    private WebElement continueSecurityConfirmBtnEle;

    @FindBy(xpath = "//p[@id= 'security-title']")
    private WebElement headerSecurityConfirmTxtEle;

    @FindBy(xpath = "//p[@id = 'epilogue-title']")
    private WebElement headerCreateSusscessAccountTxtEle;

    @FindBy(xpath = "//button[@id = 'epilogue-closeBtn']")
    private WebElement closeSusscessMessageBtnEle;

//    @FindBy(xpath = "//div[@class = 'recaptcha-checkbox-checkmark']")
    @FindBy(xpath = "//div[contains(@class,'rc-anchor')]")
    private WebElement capcharTextBoxEle;

    @FindBy(xpath = "//button[@id='security-continueBtn']")
    private WebElement createAccountBtnEle;


    /**
     * Verify Content of Register Firm Information Page
     */
    public void verifyFirmInfoPageContent() {
        getLogger().info("Verify Content of Register Firm Information Page");
        if (IS_ENGLISH_LANGUAGE)
            validateElememt(personalInfoCompleteIconEle, "PERSONAL", Element_Type.TEXT_VALUE);
        else
            validateElememt(personalInfoCompleteIconEle, "PERSONNEL", Element_Type.TEXT_VALUE);

        validateElememt(eleFirmName, "ELement of Firm Name", Element_Type.DISPLAYED);
        validateElememt(chkChangedName, "Element of Checkbox Changed Name", Element_Type.DISPLAYED);
        validateElememt(eleFirmWebsite, "Element of Firm Website", Element_Type.DISPLAYED);
        validateElememt(eleZipCode, "Element of Zip Code", Element_Type.DISPLAYED);
        validateElememt(eleCity, "Element of City", Element_Type.DISPLAYED);
        validateElememt(provinceDropdownEle, "Element of State", Element_Type.DISPLAYED);
        validateElememt(eleMemberID, "Element of Member I.D", Element_Type.DISPLAYED);
        // Checking Number of Employee element is displayed
        validateElememt(numberEmployeeDropdown, "Element of Number Employee", Element_Type.DISPLAYED);
        // Checking Phone Number element is displayed
        validateElememt(phoneNumberFirmInfoEle, "Element of Phone Number", Element_Type.DISPLAYED);
        // Checking checkbox Affiliated Firm element is displayed
        validateElememt(chkAffFirm, "Element of checkbox Affiliated", Element_Type.DISPLAYED);
        // Checking button Update Logo element is displayed
        validateElememt(btnUpdateLogo, "Element of button Update Logo", Element_Type.DISPLAYED);
        // Checking checkbox Rule Logo element is displayed
        validateElememt(chkRuleLogo, "Element of checkbox Rule Logo", Element_Type.DISPLAYED);
        // Checking button Continue element is displayed
        validateElememt(btnContinue, "Element of button Continue", Element_Type.DISPLAYED);
    }

    /**
     * Verify Content of Register Success Page
     */
    public void verifySuccessPageContent() {
        getLogger().info("Verify Content of Register Success Page");
        waitForVisibleElement(successPageHeaderEle, "Success Page Header");
        validateElememt(successPageHeaderEle, "Success Page Header", Element_Type.DISPLAYED);
        validateElememt(successPageHeaderEle, "Your Account Is on the Waitlist!", Element_Type.TEXT_VALUE);
        // Checking Image Letter element is displayed
        waitForVisibleElement(eleImageLetter, "Image Letter");
        validateElememt(eleImageLetter, "Element of Image Letter", Element_Type.DISPLAYED);
        // Checking button Close element is displayed
        validateElememt(btnContinue, "Element of button Continue", Element_Type.DISPLAYED);
    }

    /**
     * Verify Content of Register Personal Information Page
     */
    public void verifyPersonalInfoPageContent() {
        getLogger().info("Verify Content of Register Personal Information Page");
        // Checking First and Last Name element is displayed
        validateElememt(eleName, "Element First and Last Name", Element_Type.DISPLAYED);
        // Checking Email Address element is displayed
        validateElememt(eleEmail, "Element of Email Address", Element_Type.DISPLAYED);
        // Checking ReEnter Email Address element is displayed
        validateElememt(eleConfirmEmail, "Element of ReEnter Email Address", Element_Type.DISPLAYED);
        //  Checking Role in Firm element is displayed
        validateElememt(eleRoleFirm, "Element of Role in Firm", Element_Type.DISPLAYED);
        // Checking Phone Number element is displayed
        validateElememt(elePhoneNumber, "Element of Phone Number", Element_Type.DISPLAYED);
        // Checking Reference Auvenir element is displayed
        validateElememt(eleReference, "Element of Reference Auvenir", Element_Type.DISPLAYED);
    }

    /**
     * Verify Content of Register Security Information Page
     */
    public void verifySecurityInfoPageContent() {
        getLogger().info("Verify Content of Register Security Information Page");
        if (IS_ENGLISH_LANGUAGE) {
            validateElememt(personalInfoCompleteIconEle, "PERSONAL", Element_Type.TEXT_VALUE);
            validateElememt(firmInfoCompleteIconEle, "FIRM", Element_Type.TEXT_VALUE);
        } else {
            validateElememt(personalInfoCompleteIconEle, "PERSONNEL", Element_Type.TEXT_VALUE);
            validateElememt(firmInfoCompleteIconEle, "RAFFERMIR", Element_Type.TEXT_VALUE);
        }
        // Checking Create Password element is displayed
        validateElememt(elePassword, "Element of Password", Element_Type.DISPLAYED);
        // Checking Confirm Password element is displayed
        validateElememt(eleConfirmPass, "Element of Confirm Password", Element_Type.DISPLAYED);
        // Checking button Continue element is displayed
        validateElememt(btnContinue, "Element of button Continue", Element_Type.DISPLAYED);
    }

    /**
     * Input all field in Register Firm Information Page and click Continue Button
     *
     * @param firmName      String Firm Name
     * @param firmPreName   String Firm Previous Name
     * @param firmWebsite   String Website Name
     * @param strStreetAddr String Street Address Name
     * @param strOffNum     String Office Number
     * @param strZipCode    String Zip Code
     * @param strCity       String City
     * @param strState      String State
     * @param strMemberID   String MemberID
     * @param strNumEmp     String Number of Employee
     * @param strPhone      String Phone Number Firm
     * @param strAffName    Affiliated Firm's Name
     * @param strPathLogo   Path Logo
     */
    public void registerFirmInfo(String firmName, String firmPreName, String firmWebsite, String strStreetAddr, String strOffNum, String strZipCode, String strCity, String strState, String strMemberID, String strNumEmp, String strPhone, String strAffName, String strPathLogo) {
        getLogger().info("Input all field in Register Firm Information Page and click Continue Button");
        boolean result;
        try {
            waitForVisibleElement(eleFirmName, "Firm Name Input");
            sendKeyTextBox(eleFirmName, firmName, "Firm Name Input");

            waitForVisibleElement(eleFirmWebsite, "Firm Website Input");
            sendKeyTextBox(eleFirmWebsite, firmWebsite, "Firm Website Input");

            waitForVisibleElement(eleStreetAddress, "Street Address Input");
            sendKeyTextBox(eleStreetAddress, strStreetAddr, "Street Address Input");

            waitForVisibleElement(eleOfficeNumber, "Office Number Input");
            sendKeyTextBox(eleOfficeNumber, strOffNum, "Office Number Input");

            waitForVisibleElement(eleZipCode, "Zip Code Input");
            sendKeyTextBox(eleZipCode, strZipCode, "Zip Code Input");

            waitForVisibleElement(eleCity, "City Input");
            sendKeyTextBox(eleCity, strCity, "City Input");

            waitForVisibleElement(provinceDropdownEle, "Province Dropdown");
            clickElement(provinceDropdownEle, "Province Dropdown");
            waitForAtrributeValueChanged(provinceDropdownEle, "Province Dropdown", "aria-expanded", "true");
            clickElement(provinceDdlListItemEle.get(0), "Province Dropdown");
            waitForAtrributeValueChanged(provinceDropdownEle, "Province Dropdown", "aria-expanded", "false");

            waitForVisibleElement(eleMemberID, "Member ID Input");
            sendKeyTextBox(eleMemberID, strMemberID, "Member ID Input");

            waitForVisibleElement(numberEmployeeDropdown, "Number Of Employee Dropdown");
            clickElement(numberEmployeeDropdown, "Number Of Employee Dropdown");
            waitForAtrributeValueChanged(numberEmployeeDropdown, "Number Of Employee Dropdown", "aria-expanded", "true");
            clickElement(numberEmployeeDdlListItemEle.get(0), "First Item on Number of Employee Dropdown");
            waitForAtrributeValueChanged(numberEmployeeDropdown, "Number Of Employee Dropdown", "aria-expanded", "false");

            waitForVisibleElement(phoneNumberFirmInfoEle, "Phone Number Input");
            sendKeyTextBox(phoneNumberFirmInfoEle, strPhone, "Phone Number Input");

            clickOnRuleLogoCheckBox();
            clickOnAllFirmCheckBox();
            waitForVisibleElement(eleAffFirm, "Affiliated Firm's Name Input");
            sendKeyTextBox(eleAffFirm, strAffName, "Affiliated Firm's Name Input");

            Thread.sleep(2000);
            scrollToFooter();
            final List<WebElement> iframes = getDriver().findElements(By.xpath("//iframe"));
            System.out.println("iframes: " + iframes.size());
            getDriver().switchTo().frame(0);
//            System.out.println("capcharTextBoxEle get Attribute: " + iframes.get(0).getAttribute("src"));
            capcharTextBoxEle = getDriver().findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']"));
            System.out.println("capcharTextBoxEle get Attribute: " + capcharTextBoxEle.getAttribute("class"));
            clickElement(capcharTextBoxEle, "Capchar Text Box");

            getDriver().switchTo().defaultContent();
            waitForVisibleElement(btnContinue, "Continue Button");
            clickElement(btnContinue, "Continue Button");

            // Verify Register Auditor FIRM Page is passed
//            result = validateDisPlayedElement(pageSecurityInfoEle, "Page Securiy Infomation");
//            Assert.assertTrue(result, "Page Security Information should be loaded.");
//            NXGReports.addStep("Register Auditor Firm passed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Register Auditor FIRM Page is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Input all field in Register Personal Information Page and click Continue Button
     *
     * @param strName      String First and Last Name
     * @param strEmail     String Email Address
     * @param strRoleFirm  String Role Firm
     * @param strPhone     String Phone Number Auditor
     * @param strReference String Reference to Auvenir
     */
    public void registerAuditorPersonal(String strName, String strEmail, String strRoleFirm, String strPhone, String strReference) {
        getLogger().info("Input all field in Register Personal Information Page and click Continue Button");
        boolean result;
        try {
            waitForVisibleElement(eleName, "Full name");
            sendKeyTextBox(eleName, strName, "Full Name TextBox");
//            eleName.sendKeys(strName);

            waitForVisibleElement(eleEmail, "Email");
            sendKeyTextBox(eleEmail, strEmail, "Email Name TextBox");
//            eleEmail.sendKeys(strEmail);

            waitForVisibleElement(eleConfirmEmail, "Email");
            sendKeyTextBox(eleConfirmEmail, strEmail, "Confirm Email TextBox");
//            eleConfirmEmail.sendKeys(strEmail);

            waitForClickableOfElement(eleRoleFirm, "Role in Firm Dropdown");
            clickElement(eleRoleFirm, "Role");
            waitForAtrributeValueChanged(eleRoleFirm, "Role in Firm Dropdown", "aria-expanded", "true");
            clickElement(listItemRoleFirmEle.get(0), "First Item on Role Dropdown");
            waitForAtrributeValueChanged(eleRoleFirm, "Role in Firm Dropdown", "aria-expanded", "false");

            waitForVisibleElement(elePhoneNumber, "Phone number");
            sendKeyTextBox(elePhoneNumber, strPhone, "Phone number TextBox");

            waitForVisibleElement(eleReference, "Reference check box");
            clickElement(eleReference, "Reference check box");
            waitForAtrributeValueChanged(eleReference, "Reference 'Hear' Dropdown", "aria-expanded", "true");
            clickElement(listItemReferenceEle.get(0), "First Item on Reference 'Hear' Dropdown");
            waitForAtrributeValueChanged(eleReference, "Reference 'Hear' Dropdown", "aria-expanded", "false");


            waitForVisibleElement(chkAgree, "Check box agree");
            clickElement(chkAgree, " check box agree");
            if(GenericService.sBrowserData.equals("ff.")){
                switchToOtherTab(1);
                getDriver().close();
                switchToOtherTab(0);
            }

            waitForVisibleElement(chkConfirm, "Check box confirm");
            clickElement(chkConfirm, "check box confirm");

            waitForVisibleElement(btnContinue, "Continue button");
            clickElement(btnContinue, "continue button");

            result = validateDisPlayedElement(pageProvideFirmInfoEle, "Page Provide Firm Infomation");
            Assert.assertTrue(result, "Page Provide Your Firm Infomation should be loaded.");
            NXGReports.addStep("Register Auditor Personal passed", LogAs.PASSED, null);

        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Page Provide Your Firm Infomation is not loaded.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickOnChangedNameCheckBox() {
        hoverElement(this.chkChangedName, " change name check box");
        clickElement(this.chkChangedName, " change name check box");
    }

    public void clickOnAllFirmCheckBox() {
        hoverElement(this.chkAffFirm, " all firm check box");
        clickElement(this.chkAffFirm, " all firm check box");
    }

    public void clickOnRuleLogoCheckBox() {
        hoverElement(chkRuleLogo, " rule logo check box");
        clickElement(chkRuleLogo, " rule logo check box");
    }

    public void inputValueIntoFirmNameTextBox(String strName) {
        inputValueIntoControl(eleFirmName, "firm name", strName);
    }

    public void inputValueIntoPreviousFirmNameTextBox(String strName) {
        inputValueIntoControl(elePreFirmName, "previous firm name", strName);
    }

    public void inputValueIntoWebsiteTextBox(String strName) {
        inputValueIntoControl(eleFirmWebsite, "website", strName);
    }

    public void inputValueIntoFullAddressTextBox(String strName) {
        inputValueIntoControl(eleFullAddress, "street address", strName);
    }

    public void inputValueIntoZipCodeTextBox(String strName) {
        inputValueIntoControl(eleZipCode, "zip code", strName);
    }

    public void inputValueIntoMemberIdTextBox(String strName) {
        inputValueIntoControl(eleMemberID, "member id", strName);
    }

    public void inputValueIntoPhoneNumberIdTextBox(String strName) {
        inputValueIntoControl(phoneNumberFirmInfoEle, "phone number id", strName);
    }

    public void inputValueIntoAffiliatedFirmNameTextBox(String strName) {
        inputValueIntoControl(eleAffFirm, "affiliated firm's name", strName);
    }

    public void verifyColorControl(WebElement eleError, String strDescription, String attributeName, String attributeValue) {
        getLogger().info("Verify Color of Control.");
        waitForVisibleElement(eleError, strDescription);
        waitForCssValueChanged(eleError, strDescription, attributeName, attributeValue);
        validateCssValueElement(eleError, attributeName, attributeValue);
    }

    public void verifyInputInValidValueOnFirmNameTextBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Firm Name TextBox.");
        inputValueIntoFirmNameTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleFirmNameError, "firm name error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleFirmNameError, "firm name error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputInValidValueOnPreFirmNameTextBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Previous Firm Name TextBox.");
        inputValueIntoPreviousFirmNameTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(elePreFirmNameError, "previous firm name error", "border-color", warningBorderCSSColor);
        verifyColorControl(elePreFirmNameError, "previous firm name error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputInValidValueOnFirmWebsiteTextBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Website TextBox.");
        inputValueIntoWebsiteTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(elePreFirmWebsiteError, "firm website error", "border-color", warningBorderCSSColor);
        verifyColorControl(elePreFirmWebsiteError, "firm website error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputInValidValueOnFullAddressTextBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Full Address TextBox.");
        inputValueIntoFullAddressTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleFullAddressError, "street address error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleFullAddressError, "street address error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputInValidValueOnZipCodeTextBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Full Address TextBox.");
        inputValueIntoZipCodeTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleZipCodeError, "zip code error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleZipCodeError, "zip code error", "background-color", warningBackgroundCSSColor);

    }

    public void verifyInputInValidValueOnMemberIdTextBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Member ID TextBox.");
        inputValueIntoMemberIdTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleMemberIdError, "member id error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleMemberIdError, "member id error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputInValidValueOnPhoneNumberIdTextBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Phone Number TextBox.");
        inputValueIntoPhoneNumberIdTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(elePhoneNumberIdError, "phone number id error", "border-color", warningBorderCSSColor);
        verifyColorControl(elePhoneNumberIdError, "phone number id error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputInValidValueOnAffFirmTextBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Affiliated Firm TextBox.");
        inputValueIntoAffiliatedFirmNameTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleAffFirmError, "affiliated firm's name error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleAffFirmError, "affiliated firm's name error", "background-color", warningBackgroundCSSColor);
    }

    public void clickOnCheckBoxConfirm() {
        waitForVisibleElement(chkConfirm, "check confirm checkbox");
        hoverElement(chkConfirm, " check confirm checkbox");
        clickElement(chkConfirm, "check confirm checkbox");
    }

    public void clickOnHeaderPersonalPage() {
        waitForVisibleElement(personalPageSignUpHeaderEle, "check confirm checkbox");
        hoverElement(personalPageSignUpHeaderEle, "Personal Page Header");
        clickElement(personalPageSignUpHeaderEle, "check confirm checkbox");
    }

    public void inputValueIntoFullNameInput(String strName) {
        inputValueIntoControl(eleName, "first and last name", strName);
    }

    public void verifyInputInValidValueOnFullNameTxtBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Full Name TextBox.");
        inputValueIntoFullNameInput(invalidValue);
        clickOnHeaderPersonalPage();
        verifyColorControl(fullNameError, "full name error", "border-color", warningBorderCSSColor);
        verifyColorControl(fullNameError, "full name error", "background-color", warningBackgroundCSSColor);
    }

    public void inputValueIntoEmailTextBox(String strName) {
        inputValueIntoControl(eleEmail, "email", strName);
    }

    public void verifyInputInValidValueOnEmailTxtBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Email TextBox.");
        inputValueIntoEmailTextBox(invalidValue);
        clickOnHeaderPersonalPage();
        verifyColorControl(emailError, "email error", "border-color", warningBorderCSSColor);
        verifyColorControl(emailError, "email error", "background-color", warningBackgroundCSSColor);
    }

    public void inputValueIntoConfirmEmailTextBox(String strName) {
        inputValueIntoControl(eleConfirmEmail, "confirm email", strName);
    }

    public void verifyInputInValidValueOnConfirmEmailTxtBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Confirmation Email TextBox.");
        inputValueIntoConfirmEmailTextBox(invalidValue);
        clickOnHeaderPersonalPage();
        verifyColorControl(confirmEmailError, "confirm email error", "border-color", warningBorderCSSColor);
        verifyColorControl(confirmEmailError, "confirm email error", "background-color", warningBackgroundCSSColor);
    }

    public void inputValueIntoPhoneNumberTextBox(String strName) {
        inputValueIntoControl(elePhoneNumber, "phone number", strName);
    }

    public void verifyInputInValidValueOnPhoneNumberTxtBox(String invalidValue) {
        getLogger().info("Verify Input InValid Value On Phone Number TextBox.");
        inputValueIntoPhoneNumberTextBox(invalidValue);
        clickOnHeaderPersonalPage();
        verifyColorControl(phoneError, "phone nunber error", "border-color", warningBorderCSSColor);
        verifyColorControl(phoneError, "phone nunber error", "background-color", warningBackgroundCSSColor);
    }

    public void createPassword(String strPass, String strCaptcha) {
        getLogger().info("Create Password for New User.");
        boolean result;
        try {
            waitForVisibleElement(elePassword, "Password Input");
            sendKeyTextBox(elePassword, strPass, "Password Input");

            waitForVisibleElement(eleConfirmPass, "Confirm Password Input");
            sendKeyTextBox(eleConfirmPass, strPass, "Confirm Password Input");

            clickElement(createAccountBtnEle, "Create Account button");
            // Verify Register Auditor Security Page is passed
//            waitForVisibleElement(successPageHeaderEle, "Success Page Header");
//            result = validateElementText(successPageHeaderEle, "Your Account Is on the Waitlist!");
//            Assert.assertTrue(result, "Success Page should be displayed.");

        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Success Page is not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Input Invalid Password and verify the error message is displayed.
     *
     * @param password               String password
     * @param isContainsCapialLetter Boolean isContainsCapialLetter,
     *                               It is true if password has at least one capital letter, otherwise it is false
     * @param isContainsLetter       Boolean isContainsCapialLetter,
     *                               It is true if password has at least one letter, otherwise it is false
     * @param isContainsNumber       Boolean isContainsNumber,
     *                               It is true if password has at least one number, otherwise it is false
     */
    public void verifyCreateInvalidPassword(String password, boolean isContainsCapialLetter, boolean isContainsLetter, boolean isContainsNumber) {
        getLogger().info("Verify Create Invalid Password.");
        inputValueIntoPaswordInput(password);
        final int passwordLength = password.length();
        waitForVisibleElement(resetPasswordWarningPopup, "Password Error Message Popup.");
        if (IS_ENGLISH_LANGUAGE) {
            if (passwordLength < 8) {
                validateElememt(warning8charPasswordEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warning8charPasswordEngEle, "Contains 8 Chars Error", "color", warningTextCSSColor);
            } else {
                validateElememt(success8charPasswordEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(success8charPasswordEngEle, "Contains 8 Chars Success", "color", successTextCSSColor);
            }
            if (!isContainsLetter) {
                validateElememt(warning1LetterPasswordEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warning1LetterPasswordEngEle, "Contains 1 Letter Error", "color", warningTextCSSColor);
            } else {
                validateElememt(success1LetterPasswordEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(success1LetterPasswordEngEle, "Contains 1 Letter Success", "color", successTextCSSColor);
            }
            if (!isContainsNumber) {
                validateElememt(warning1NumberPasswordEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warning1NumberPasswordEngEle, "Contains 1 Number Error", "color", warningTextCSSColor);
            } else {
                validateElememt(success1NumberPasswordEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(success1NumberPasswordEngEle, "Contains 1 Number Success", "color", successTextCSSColor);
            }
            if (!isContainsCapialLetter) {
                validateElememt(warning1CapLetterPasswordEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warning1CapLetterPasswordEngEle, "Contains 1 Capital Letter Error", "color", warningTextCSSColor);
            } else {
                validateElememt(success1CapLetterPasswordEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(success1CapLetterPasswordEngEle, "Contains 1 Capital Letter Success", "color", successTextCSSColor);
            }
        } else {
            if (passwordLength < 8) {
                validateElememt(warning8charPasswordFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warning8charPasswordFraEle, "Contains 8 Chars Error", "color", warningTextCSSColor);
            } else {
                validateElememt(success8charPasswordFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(success8charPasswordFraEle, "Contains 8 Chars Success", "color", successTextCSSColor);
            }
            if (!isContainsLetter) {
                validateElememt(warning1LetterPasswordFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warning1LetterPasswordFraEle, "Contains 1 Letter Error", "color", warningTextCSSColor);
            } else {
                validateElememt(success1LetterPasswordFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(success1LetterPasswordFraEle, "Contains 1 Letter Success", "color", successTextCSSColor);
            }
            if (!isContainsNumber) {
                validateElememt(warning1NumberPasswordFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warning1NumberPasswordFraEle, "Contains 1 Number Error", "color", warningTextCSSColor);
            } else {
                validateElememt(success1NumberPasswordFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(success1NumberPasswordFraEle, "Contains 1 Number Success", "color", successTextCSSColor);
            }
            if (!isContainsCapialLetter) {
                validateElememt(warning1CapLetterPasswordFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warning1CapLetterPasswordFraEle, "Contains 1 Capital Letter Error", "color", warningTextCSSColor);
            } else {
                validateElememt(success1CapLetterPasswordFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(success1CapLetterPasswordFraEle, "Contains 1 Capital Letter Success", "color", successTextCSSColor);
            }
        }
    }

    /**
     * Input Wrong Confirmation Password and verify the error message is displayed.
     *
     * @param password String password
     */
    public void verifyInputWrongConfirmPassword(String password) {
        getLogger().info("Verify Input Wrong Confirm Password");
        inputValueIntoConfirmPaswordInput(password);
        waitForVisibleElement(resetPasswordWarningPopup, "password error message");
        if (IS_ENGLISH_LANGUAGE) {
            if (!this.elePassword.getText().equals(eleConfirmPass.getText())) {
                validateElememt(warningPasswordNotMacthEngEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warningPasswordNotMacthEngEle, "Password Not Match Error", "color", warningTextCSSColor);
            }
        } else {
            if (!this.elePassword.getText().equals(eleConfirmPass.getText())) {
                validateElememt(warningPasswordNotMacthFraEle, "Alert message.", Element_Type.DISPLAYED);
                verifyColorControl(warningPasswordNotMacthFraEle, "Password Not Match Error", "color", warningTextCSSColor);
            }
        }
    }

    public void inputValueIntoPaswordInput(String strName) {
        inputValueIntoControl(elePassword, "password", strName);
    }

    public void inputValueIntoConfirmPaswordInput(String strName) {
        inputValueIntoControl(eleConfirmPass, "Confirm Password", strName);
    }

    public void acceptCreateAccountAuditor() {
        clickElement(btnContinue, "Continue Button");
    }

    public void registerNewAuditorUser(String fullName, String strEmail, String strPassword){
        marketingPage = new MarketingPage(getLogger(), getDriver());
        marketingPage.clickOnSignupButton();
        verifyPersonalInfoPageContent();
//        if(GenericService.sBrowserData.equals("")){
//            switchToOtherTab(1);
//            getDriver().close();
//            switchToOtherTab(0);
//        }
        registerAuditorPersonal(fullName, strEmail, "IT", "4167877865", "Online");
        verifyFirmInfoPageContent();
        registerFirmInfo("Test Audits LLC", "Audits NLD", "www.auditissszzz.com", "123 Audit Road",
                "12", "K8M9J0", "Toroton", "Quebec", "165782", "4-10",
                "1234567890", "KMPD", "C:\\Users\\Chrysanthemum.jpg");
        verifySecurityInfoPageContent();
        createPassword(strPassword, strPassword);
        verifySuccessPageContent();
        acceptCreateAccountAuditor();
    }

    public void confirmInfomationNewAuditorUser(String fullName, String strEmail, String strPassword){
        confirmAuditorPersonalInfo(fullName, strEmail, "IT", "4167877865", "Online");
        confirmFirmInformation("Test Audits LLC", "Audits NLD", "www.auditissszzz.com", "123 Audit Road",
                "12", "K8M9J0", "Toroton", "Quebec", "165782", "4-10",
                "1234567890", "KMPD", "C:\\Users\\Chrysanthemum.jpg");
        clickCreateAccountBtn();
        verifyConfirmSuccessPageContent();
        clickCloseSuccessMessageBtn();
    }

    /**
     * Confirm Personal Information Page and click Continue Button
     *
     * @param strName      String First and Last Name
     * @param strEmail     String Email Address
     * @param strRoleFirm  String Role Firm
     * @param strPhone     String Phone Number Auditor
     * @param strReference String Reference to Auvenir
     */
    public void confirmAuditorPersonalInfo(String strName, String strEmail, String strRoleFirm, String strPhone, String strReference) {
        getLogger().info("Input all field in Register Personal Information Page and click Continue Button");
        boolean result;
        try {
//            waitForVisibleElement(fullNameConfirmTxtEle, "Full name");
//            sendKeyTextBox(fullNameConfirmTxtEle, strName, "Full Name TextBox");

//            waitForVisibleElement(emailConfirmTxtEle, "Email");
//            sendKeyTextBox(emailConfirmTxtEle, strEmail, "Email Name TextBox");

//            waitForVisibleElement(emailReEnterConfirmTxtEle, "Email");
//            sendKeyTextBox(emailReEnterConfirmTxtEle, strEmail, "Confirm Email TextBox");

            waitForVisibleElement(roleConfirmTxtEle, "Role Firm Textbox");
            sendKeyTextBox(roleConfirmTxtEle, strRoleFirm,"Role Firm Textbox");

            waitForVisibleElement(phoneConfirmTxtEle, "Phone number");
            sendKeyTextBox(phoneConfirmTxtEle, strPhone, "Phone number TextBox");
            waitForAtrributeValueChanged(phoneConfirmTxtEle, "Phone number TextBox","value", strPhone);

            WebElement dropdownpopup = getDriver().findElement(By.xpath("//*[@id='personal-referral']/../ul"));
            waitForClickableOfElement(referalConfirmDrdEle, "Referal Dropdown List");
            clickElement(referalConfirmDrdEle, "Referal Dropdown List");

            waitForAtrributeValueChanged(dropdownpopup, "Role in Firm Dropdown", "class", "ddlLink inputDdl inputDdl-after");

            String firstItemText = listItemreferalConfirmDrdEle.get(0).getText();
            clickElement(listItemreferalConfirmDrdEle.get(0), "First Item on Role Dropdown");
            System.out.print("firstItemText: " + firstItemText);
            waitForAtrributeValueChanged(referalConfirmDrdEle, "Referal Dropdown List", "value", firstItemText);
            if (GenericService.sBrowserData.equals("ff."))
                clickElement(referalConfirmDrdEle, "Referal Dropdown List");
            waitForAtrributeValueChanged(dropdownpopup, "Role in Firm Dropdown", "class", "ddlLink inputDdl");

            waitForVisibleElement(agreePrivacyConfirmCheckboxEle, "Agree Check Box");
            clickElement(agreePrivacyConfirmCheckboxEle, "Agree Check Box");

            waitForVisibleElement(agreeCPAConfirmCheckboxEle, "Confirm CPA Check Box");
            clickElement(agreeCPAConfirmCheckboxEle, "Confirm CPA Check Box");

            waitForVisibleElement(continuePerConfirmBtnEle, "Continue button");
            clickElement(continuePerConfirmBtnEle, "continue button");

            waitForVisibleElement(firmHeaderTxtEle, "Header Firm Info Page");
            validateDisPlayedElement(firmHeaderTxtEle, "Header Firm Info Page");
            result = validateElementText(firmHeaderTxtEle, "Please Provide Your Firm Information");
            Assert.assertTrue(result, "Page Provide Your Firm Infomation should be loaded.");
            NXGReports.addStep("Confirm Auditor Personal Info passed", LogAs.PASSED, null);

        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Confirm Firm Information is not loaded.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Confirm Firm Information Page and click Continue Button
     *
     * @param firmName      String Firm Name
     * @param firmPreName   String Firm Previous Name
     * @param firmWebsite   String Website Name
     * @param strStreetAddr String Street Address Name
     * @param strOffNum     String Office Number
     * @param strZipCode    String Zip Code
     * @param strCity       String City
     * @param strState      String State
     * @param strMemberID   String MemberID
     * @param strNumEmp     String Number of Employee
     * @param strPhone      String Phone Number Firm
     * @param strAffName    Affiliated Firm's Name
     * @param strPathLogo   Path Logo
     */
    public void confirmFirmInformation(String firmName, String firmPreName, String firmWebsite, String strStreetAddr, String strOffNum, String strZipCode, String strCity, String strState, String strMemberID, String strNumEmp, String strPhone, String strAffName, String strPathLogo) {
        getLogger().info("Input all field in Register Firm Information Page and click Continue Button");
        boolean result;
        try {

            waitForVisibleElement(firmWebsiteConfirmTxtEle, "Firm Website Input");
            sendKeyTextBox(firmWebsiteConfirmTxtEle, firmWebsite, "Firm Website Input");


            waitForVisibleElement(firmSuiteNumConfirmTxtEle, "Office Number Input");
            sendKeyTextBox(firmSuiteNumConfirmTxtEle, strOffNum, "Office Number Input");


            waitForVisibleElement(firmCountryConfirmTxtEle, "City Input");
            sendKeyTextBox(firmCountryConfirmTxtEle, strState, "City Input");

            WebElement dropdownpopup = getDriver().findElement(By.xpath("//*[@id='firm-size']/../ul"));
            waitForVisibleElement(firmNumEmployeeConfirmTxtEle, "Number Of Employee Dropdown");
            clickElement(firmNumEmployeeConfirmTxtEle, "Number Of Employee Dropdown");
            waitForAtrributeValueChanged(dropdownpopup, "Number Of Employee Dropdown", "class", "ddlLink inputDdl inputDdl-after");

            String firstItemText = firmListItemEmployeeConfirmDrdEle.get(0).getText();
            clickElement(firmListItemEmployeeConfirmDrdEle.get(0), "First Item on Number of Employee Dropdown");
            System.out.print("firstItemText: " + firstItemText);
            waitForAtrributeValueChanged(firmNumEmployeeConfirmTxtEle, "Referal Dropdown List", "value", firstItemText);
            if (GenericService.sBrowserData.equals("ff."))
                clickElement(firmNumEmployeeConfirmTxtEle, "Number Of Employee Dropdown");
            waitForAtrributeValueChanged(dropdownpopup, "Number Of Employee Dropdown", "class", "ddlLink inputDdl");

            waitForVisibleElement(continueFirmConfirmBtnEle, "Continue Firm Button");
            clickElement(continueFirmConfirmBtnEle, "Continue Firm Button");

            // Verify Confirm Auditor FIRM Page is passed
            waitForVisibleElement(headerSecurityConfirmTxtEle, "Header Security Info Page");
            validateDisPlayedElement(headerSecurityConfirmTxtEle, "Header Security Info Page");
            result = validateElementText(headerSecurityConfirmTxtEle, "Create Your Password");
            Assert.assertTrue(result, "Page Security Information should be loaded.");
            NXGReports.addStep("Confirm Auditor Firm Info Page passed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Confirm Auditor Firm Info Page is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickCreateAccountBtn() {
        waitForVisibleElement(continueSecurityConfirmBtnEle, "Create Account Button");
        clickElement(continueSecurityConfirmBtnEle, "Create Account Button");
    }

    public void clickCloseSuccessMessageBtn() {
        waitForVisibleElement(closeSusscessMessageBtnEle, "Close Button");
        clickElement(closeSusscessMessageBtnEle, "Close Button");
    }

    /**
     * Verify Content of Confirm Success Page
     */
    public void verifyConfirmSuccessPageContent() {
        getLogger().info("Verify Content of Register Success Page");
        waitForVisibleElement(headerCreateSusscessAccountTxtEle, "Confirm Info Success Page Header");
        validateElememt(headerCreateSusscessAccountTxtEle, "Confirm Info Success Page Header", Element_Type.DISPLAYED);
        validateElememt(headerCreateSusscessAccountTxtEle, "Your Account Has Been Created!", Element_Type.TEXT_VALUE);
    }
}
