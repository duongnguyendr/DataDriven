package com.auvenir.ui.pages.marketing.onboarding;

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
import org.testng.Assert;

import java.util.List;

/**
 * Created by cuong.nguyen on 4/12/2017.
 */
public class AuditorSignUpPage extends AbstractPage {

    public AuditorSignUpPage(Logger logger, WebDriver driver) {
        super(logger,driver);
        PageFactory.initElements(driver, this);
    }

    // =============================================== Element of Breadcrumb Completed page ===============================
    @FindBy(xpath = "(//div[@class='completed step']/div/div[@class='title'])[1]")
    private WebElement personalInfoCompleteIconEle;
    public WebElement getPersonalInfoCompleteIconEle(){return personalInfoCompleteIconEle; }

    // Element of Breadcrumb of Active page
    @FindBy(xpath = "//div[@class='active step']/div[div[text()='RAFFERMIR'] or text()='FIRM']")
    private WebElement elePageActive;
    public WebElement getElePageActive(){return elePageActive; }

    // ================================================ Element of Firm Name  =============================================
    @FindBy(xpath = "//input[@name='firm_name']")
    private WebElement eleFirmName;
    public WebElement getEleFirmName() {return eleFirmName;}

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_name']")
    private WebElement eleFirmNameError;

    // Element of checkbox rule changed Name
    @FindBy(xpath = "//div[@class='ui checkbox']/label[starts-with(text(),'Firm') or starts-with(text(),'Le')]")
    private WebElement chkChangedName;
    public WebElement getChkChangedName() { return chkChangedName; }

    // Element of Firm previous Name
    @FindBy(xpath = "//input[@name='firm_previous_name']")
    private WebElement elePreFirmName;
    public WebElement getElePreFirmName() { return elePreFirmName; }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_previous_name']")
    private WebElement elePreFirmNameError;

    // Element of Firm website
    @FindBy(xpath = "//input[@name='firm_website']")
    private WebElement eleFirmWebsite;
    public WebElement getEleFirmWebsite() { return eleFirmWebsite;}

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_website']")
    private WebElement elePreFirmWebsiteError;

    // Element of Full Address
    @FindBy(xpath = "//input[@name='firm_full_address']")
    private WebElement eleFullAddress;
    public WebElement getEleFullAddress(){return  eleFullAddress; }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_full_address']")
    private WebElement eleFullAddressError;


    // Element of Street Address
    @FindBy(xpath = "//input[@name='firm_street_address']")
    private WebElement eleStreetAddress;
    public WebElement getEleStreetAddress() { return eleStreetAddress;}



    // Element of Office number
    @FindBy(xpath = "//input[@name='firm_suit_number']")
    private WebElement eleOfficeNumber;
    public WebElement getEleOfficeNumber() {
        return eleOfficeNumber;
    }

    // Element of Zip Code
    @FindBy(xpath = "//input[@name='firm_postal_code']")
    private WebElement eleZipCode;
    public WebElement getEleZipCode() { return eleZipCode;}

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_postal_code']")
    private WebElement eleZipCodeError;

    // Element of City
    @FindBy(xpath = "//input[@name='firm_city']")
    private WebElement eleCity;
    public WebElement getEleCity() { return eleCity; }

    // Element of State Dropdown list
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[1]")
    private WebElement provinceDropdownEle;
    public WebElement getProvinceDropdownEle() {
        return provinceDropdownEle;
    }

    // Element with locator of Menu listbox
    @FindBy(xpath = "//div[@class='menu transition visible']")
    private WebElement eleMenu;
    public WebElement getEleMenu(){ return eleMenu; }

    // Element of Member I.D
    @FindBy(xpath = "//input[@name='firm_member_id']")
    private WebElement eleMemberID;
    public WebElement getEleMemberID() {return eleMemberID;}

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
    public WebElement getPhoneNumberFirmInfoEle() {return phoneNumberFirmInfoEle;}

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_phone_number']")
    private WebElement elePhoneNumberIdError;

    // Element of checkbox affiliated Firm
    @FindBy(xpath = "//div[@class='ui checkbox']/label[starts-with(text(),'I') or starts-with(text(),'Je')]")
    private WebElement chkAffFirm;
    public WebElement getChkAffFirm(){ return chkAffFirm;}

    // Element of Affiliated Firm Name
    @FindBy(xpath = "//label[text()='Affiliated Firm’s Name' or contains(text(),'Nom de')]/following-sibling::div[1]/input")
    private WebElement eleAffFirm;
    public WebElement getEleAffFirm() {return eleAffFirm;}

    @FindBy(xpath = "//div[@class='error field']//label[text()='Affiliated Firm’s Name' or contains(text(),'Nom de')]/following-sibling::div[1]/input")
    private WebElement eleAffFirmError;


    // Element of Link add Affiliated Firm
    @FindBy(css = ".add-field")
    private WebElement lnkAddFirm;
    public WebElement getLnkAddFirm() {return lnkAddFirm;}

    // Element of Update Logo button
    @FindBy(xpath = "//label[@for='btn-upload']")
    private WebElement btnUpdateLogo;
    public WebElement getBtnUpdateLogo() {return btnUpdateLogo;}

    // Element of checkbox Rule Logo
    @FindBy(xpath = "//label[starts-with(text(),'Once') or starts-with(text(),'Un')]")
    private WebElement chkRuleLogo;
    public WebElement getChkRuleLogo() {return chkRuleLogo;}

    // Element of button Continue
    @FindBy(id = "btn-continue")
    private WebElement btnContinue;
    public WebElement getBtnContinue() {return btnContinue;}

    // Page Security Information Div Element
    @FindBy(xpath = "//*[@id='create-password']")
    private WebElement pageSecurityInfoEle;
    public WebElement getPageSecurityInfoEle(){ return pageSecurityInfoEle; }

    // List Item of Province/State Dropdown list
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[1]//div[@class='menu transition visible']/div")
    private List<WebElement> provinceDdlListItemEle;
    public List<WebElement> getprovinceDdlListItemEle(){
        return provinceDdlListItemEle;
    }

    // List Item of Number Of Employee Dropdown list
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[2]//div[@class='menu transition visible']/div")
    private List<WebElement> numberEmployeeDdlListItemEle;
    public List<WebElement> getNumberEmployeeDdlListItemEle(){
        return numberEmployeeDdlListItemEle;
    }

    final String warningBorderCSSColor = "rgb(253, 109, 71)";
    final String warningBackgroundCSSColor = "rgba(241, 103, 57, 0.2)";

    ///////////////Element from PersonalPO.java
    // ================================= Element of Content page ==============================================
    @FindBy(xpath = "//div[@class='step-content' and @id='step1']")
    private WebElement eleFrameAuditorPersonal;
    public WebElement getEleFrameAuditorPersonal(){ return eleFrameAuditorPersonal; }

    // ================================= Element of First and Last Name =======================================
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_fullname']")
    private WebElement eleName;
    public WebElement getEleName(){
        return eleName;
    }

    // Element of EmailAddress
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_email']")
    private  WebElement eleEmail;
    public WebElement getEleEmail(){
        return eleEmail;
    }

    // Element with locator of confirm EmailAddress
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_email_confirm']")
    private WebElement eleConfirmEmail;
    public WebElement getEleConfirmEmail(){
        return eleConfirmEmail;
    }

    // Element of ListBox Role in Firm
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[1]")
    private WebElement eleRoleFirm;
    public WebElement getEleRoleFirm(){
        return eleRoleFirm;
    }

//    // Element of Menu listbox
//    @FindBy(xpath = "//div[@class='menu transition visible']")
//    private WebElement eleMenu;
//    public WebElement getEleMenu(){ return eleMenu; }

    // Element of Phone Number
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_phone_number']")
    private WebElement elePhoneNumber;
    public WebElement getElePhoneNumber(){
        return phoneNumberFirmInfoEle;
    }

    // Element of Hear about Auvenir
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[2]")
    private WebElement eleReference;
    public WebElement getEleReference(){
        return eleReference;
    }

    // Element of checkbox I agree
    @FindBy(xpath = "//div[@class='ui checkbox']/label/span")
    private WebElement chkAgree;
    public WebElement getChkAgree(){
        return chkAgree;
    }

    // Element of checkbox I confirm
    @FindBy(xpath = "//div[@class='ui checkbox']/label[contains(text(),'confirm')]")
    private WebElement chkConfirm;
    public WebElement getChkConfirm(){
        return chkConfirm;
    }

//    // Element of button Continue
//    @FindBy(id = "btn-continue")
//    private WebElement btnContinue;
//    public WebElement getBtnContinue(){
//        return btnContinue;
//    }

    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='error field']//div[@class='ui input']//input[@name='member_fullname']")
    private WebElement fullNameError;

    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='error field']//div[@class='ui input']//input[@name='member_email']")
    private WebElement emailError;

    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='error field']//div[@class='ui input']//input[@name='member_email_confirm']")
    private  WebElement confirmEmailError;

    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='error field']//div[@class='ui input']//input[@name='member_phone_number']")
    private  WebElement phoneError;

    // List Item of ListBox Role in Firm
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[1]//div[@class='menu transition visible']/div")
    private List<WebElement> listItemRoleFirmEle;
    public List<WebElement> getListItemRoleFirmEle(){
        return listItemRoleFirmEle;
    }

    // List Item of Option 'Hear about Auvenir'
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[2]//div[@class='menu transition visible']/div")
    private List<WebElement> listItemReferenceEle;
    public List<WebElement> getListItemReferenceEle(){
        return listItemReferenceEle;
    }

    // Page Provide Firm Information Div Element
    @FindBy(xpath = "//div[@class='step-content' and @id='step2']")
    private WebElement pageProvideFirmInfoEle;
    public WebElement getPageProvideFirmInfoEle(){ return pageProvideFirmInfoEle; }


    ///////////////Element from SuPO.java
    //=======================================  Element of Breadcrumb Completed page PERSONAL ===================================
//    @FindBy(xpath = "(//div[@class='completed step']/div/div[@class='title'])[1]")
//    private WebElement personalInfoCompleteIconEle;
//    public WebElement getPersonalInfoCompleteIconEle() {return personalInfoCompleteIconEle;}

    // Element of Breadcrumb Completed page FIRM
    @FindBy(xpath = "(//div[@class='completed step']/div/div[@class='title'])[2]")
    private WebElement firmInfoCompleteIconEle;
    public WebElement getFirmInfoCompleteIconEle() {return firmInfoCompleteIconEle;}

    // Element of Breadcrumb of Security page
    @FindBy(xpath = "//div[@class='active step']/div[div[text()='SÉCURITÉ'] or text()='SECURITY']")
    private WebElement securityInfoActiveIconEle;
    public WebElement getSecurityInfoActiveIconEle(){return securityInfoActiveIconEle; }

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

//    // Element of Continue Button
//    @FindBy(id = "btn-continue")
//    private WebElement btnContinue;
//    public WebElement getBtnContinue() {return btnContinue;}

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

    ////////Element from SuccessPO.java
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

//    // Element button Continue
//    @FindBy(id = "btn-continue")
//    private WebElement btnContinue;
//
//    public WebElement getBtnClose() {
//        return btnContinue;
//    }

    //@Override
    public void verifyFirmInfoPageContent(){
        getLogger().info("Verify Page Content Firm PO.");
        if(IS_ENGLISH_LANGUAGE)
            validateElememt(personalInfoCompleteIconEle,"PERSONAL", Element_Type.TEXT_VALUE);
        else
            validateElememt(personalInfoCompleteIconEle,"PERSONNEL", Element_Type.TEXT_VALUE);
        // Checking Firm Name element is displayed
        validateElememt(eleFirmName, "ELement of Firm Name", Element_Type.DISPLAYED);
        // Checking checkbox Changed Name element is displayed
        validateElememt(chkChangedName, "Element of Checkbox Changed Name", Element_Type.DISPLAYED);
        // Checking Firm Website element is displayed
        validateElememt(eleFirmWebsite, "Element of Firm Website", Element_Type.DISPLAYED);
        // Checking Zip Code element is displayed
        validateElememt(eleZipCode, "Element of Zip Code", Element_Type.DISPLAYED);
        // Checking City element is displayed
        validateElememt(eleCity, "Element of City", Element_Type.DISPLAYED);
        // Checking State element is displayed
        validateElememt(provinceDropdownEle, "Element of State", Element_Type.DISPLAYED);
        // Checking Member I.D element is displayed
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

    /*@Override
    protected void load() {
        //
    }

//    @Override*/
//    protected void isLoaded() throws Error {
//
//    }

    public void registerFirmInfo(String strName, String strPreName, String strWebsite, String strStreetAddr, String strOffNum, String strZipCode, String strCity, String strState, String strMemberID, String strNumEmp, String strPhone, String strAffName, String strPathLogo) {
        boolean result;
        try {
            waitForVisibleElement(eleFirmName, "Firm Name Input");
            sendKeyTextBox(eleFirmName, strName, "Firm Name Input");

            waitForVisibleElement(eleFirmWebsite, "Firm Website Input");
            sendKeyTextBox(eleFirmWebsite, strWebsite, "Firm Website Input");

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

            waitForVisibleElement(btnContinue, "Continue Button");
            clickElement(btnContinue, "Continue Button");

            // Verify Register Auditor FIRM Page is passed
            result = validateDisPlayedElement(pageSecurityInfoEle, "Page Securiy Infomation");
            Assert.assertTrue(result, "Page Security Information should be loaded.");
            NXGReports.addStep("Register Auditor Firm passed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Register Auditor FIRM Page is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickOnChangedNameCheckBox(){
        hoverElement(this.chkChangedName," change name check box");
        clickElement(this.chkChangedName, " change name check box");
    }

    public void clickOnAllFirmCheckBox(){
        hoverElement(this.chkAffFirm," all firm check box");
        clickElement(this.chkAffFirm, " all firm check box");
    }

    public void clickOnRuleLogoCheckBox(){
        getLogger().info("Click On Rule Logo CheckBox");
        hoverElement(chkRuleLogo," rule logo check box");
        clickElement(chkRuleLogo, " rule logo check box");
    }

    public void inputValueIntoFirmNameTextBox(String strName){
        getLogger().info("Input Value Into Firm Name TextBox.");
        inputValueIntoControl(eleFirmName, "firm name",strName);
    }

    public void inputValueIntoPreviousFirmNameTextBox(String strName){
        inputValueIntoControl(elePreFirmName, "previous firm name",strName);
    }

    public void inputValueIntoWebsiteTextBox(String strName){
        inputValueIntoControl(eleFirmWebsite, "website",strName);
    }

    public void inputValueIntoFullAddressTextBox(String strName){
        inputValueIntoControl(eleFullAddress, "street address",strName);
    }

    public void inputValueIntoZipCodeTextBox(String strName){
        inputValueIntoControl(eleZipCode, "zip code",strName);
    }

    public void inputValueIntoMemberIdTextBox(String strName){
        inputValueIntoControl(eleMemberID, "member id",strName);
    }

    public void inputValueIntoPhoneNumberIdTextBox(String strName){
        inputValueIntoControl(phoneNumberFirmInfoEle, "phone number id",strName);
    }

    public void inputValueIntoAffiliatedFirmNameTextBox(String strName){
        inputValueIntoControl(eleAffFirm, "affiliated firm's name",strName);
    }

    public void verifyColorControl(WebElement eleError, String strDescription, String attributeName, String attributeValue) {
        waitForVisibleElement(eleError, strDescription);
        waitForCssValueChanged(eleError, strDescription, attributeName, attributeValue);
        validateCssValueElement(eleError, attributeName, attributeValue);
    }

    public void verifyInputValidValueOnFirmNameTextBox(String invalidValue) {
        inputValueIntoFirmNameTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleFirmNameError, "firm name error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleFirmNameError, "firm name error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputValidValueOnPreFirmNameTextBox(String invalidValue) {
        inputValueIntoPreviousFirmNameTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(elePreFirmNameError, "previous firm name error", "border-color", warningBorderCSSColor);
        verifyColorControl(elePreFirmNameError, "previous firm name error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputValidValueOnFirmWebsiteTextBox(String invalidValue) {
        inputValueIntoWebsiteTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(elePreFirmWebsiteError, "firm website error", "border-color", warningBorderCSSColor);
        verifyColorControl(elePreFirmWebsiteError, "firm website error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputValidValueOnFullAddressTextBox(String invalidValue) {
        inputValueIntoFullAddressTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleFullAddressError, "street address error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleFullAddressError, "street address error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputValidValueOnZipCodeTextBox(String invalidValue) {
        inputValueIntoZipCodeTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleZipCodeError, "zip code error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleZipCodeError, "zip code error", "background-color", warningBackgroundCSSColor);

    }

    public void verifyInputValidValueOnMemberIdTextBox(String invalidValue) {
        inputValueIntoMemberIdTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleMemberIdError, "member id error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleMemberIdError, "member id error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputValidValueOnPhoneNumberIdTextBox(String invalidValue) {
        inputValueIntoPhoneNumberIdTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(elePhoneNumberIdError, "phone number id error", "border-color", warningBorderCSSColor);
        verifyColorControl(elePhoneNumberIdError, "phone number id error", "background-color", warningBackgroundCSSColor);
    }

    public void verifyInputValidValueOnAffFirmTextBox(String invalidValue) {
        inputValueIntoAffiliatedFirmNameTextBox(invalidValue);
        clickOnRuleLogoCheckBox();
        verifyColorControl(eleAffFirmError, "affiliated firm's name error", "border-color", warningBorderCSSColor);
        verifyColorControl(eleAffFirmError, "affiliated firm's name error", "background-color", warningBackgroundCSSColor);
    }

    ////////////Function from PersonalPO.java

    public void verifyPersonalInfoPageContent(){
        //this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Checking First and Last Name element is displayed
        validateElememt(eleName,"Element First and Last Name", Element_Type.DISPLAYED);
        // Checking Email Address element is displayed
        validateElememt(eleEmail,"Element of Email Address", Element_Type.DISPLAYED);
        // Checking ReEnter Email Address element is displayed
        validateElememt(eleConfirmEmail,"Element of ReEnter Email Address", Element_Type.DISPLAYED);
        //  Checking Role in Firm element is displayed
        validateElememt(eleRoleFirm,"Element of Role in Firm", Element_Type.DISPLAYED);
        // Checking Phone Number element is displayed
        validateElememt(elePhoneNumber,"Element of Phone Number", Element_Type.DISPLAYED);
        // Checking Reference Auvenir element is displayed
        validateElememt(eleReference,"Element of Reference Auvenir", Element_Type.DISPLAYED);
    }

    /*@Override
    protected void load(){
        //
    }

//    //@Override*/
//    protected void isLoaded() throws Error {
//
//    }

    public void registerAuditorPersonal(String strName, String strEmail, String strRoleFirm, String strPhone, String strReference) {
        boolean result;
        try {
            waitForVisibleElement(eleName, "Full name");
            sendKeyTextBox(eleName, strName, "Full Name TextBox");

            waitForVisibleElement(eleEmail, "Email");
            sendKeyTextBox(eleEmail, strEmail, "Email Name TextBox");

            waitForVisibleElement(eleConfirmEmail, "Email");
            sendKeyTextBox(eleConfirmEmail, strEmail, "Confirm Email TextBox");

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

    public void clickOnCheckBoxConfirm(){
        try{
            waitForVisibleElement(chkConfirm,"check confirm checkbox");
            clickElement(chkConfirm, "continue button");
            NXGReports.addStep("Click on check box confirm", LogAs.PASSED, null);

        }catch (NoSuchElementException e){
            NXGReports.addStep("Element is not found", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }

    public void inputValueIntoFullNameInput(String strName){
        inputValueIntoControl(eleName, "first and last name",strName);
    }

//    public void verifyColorControl(WebElement eleError, String strDescription, String attributeName, String attributeValue){
//        waitForVisibleElement(eleError,strDescription);
//        validateCssValueElement(eleError,attributeName,attributeValue);
//    }

    public void verifyColorFullNameTxtBox(String attributeName, String attributeValue) {
        verifyColorControl(fullNameError, "full name error", attributeName, attributeValue);
    }

    public void inputValueIntoEmailTextBox(String strName) {
        inputValueIntoControl(eleEmail, "email", strName);
    }

    public void verifyColorEmailTxtBox(String attributeName, String attributeValue){
        verifyColorControl(emailError,"email error", attributeName,attributeValue);
    }

    public void inputValueIntoConfirmEmailTextBox(String strName){
        inputValueIntoControl(eleConfirmEmail, "confirm email",strName);
    }

    public void verifyColorConfirmEmailTxtBox(String attributeName, String attributeValue){
        verifyColorControl(confirmEmailError, "confirm email error" ,attributeName,attributeValue);
    }

    public void inputValueIntoPhoneNumberTextBox(String strName){
        inputValueIntoControl(elePhoneNumber, "phone number",strName);
    }

    public void verifyColorPhoneNumberTxtBox(String attributeName, String attributeValue){
        verifyColorControl(phoneError, "phone name error" ,attributeName,attributeValue);
    }


    //////////Function from SecurityPO.java
    public void verifySecurityInfoPageContent() {
        if(IS_ENGLISH_LANGUAGE) {
            validateElememt(personalInfoCompleteIconEle, "PERSONAL", Element_Type.TEXT_VALUE);
            validateElememt(firmInfoCompleteIconEle, "FIRM", Element_Type.TEXT_VALUE);
        }else {
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

    public void createPassword(String strPass, String strCaptcha) {
        boolean result;
        try {
            waitForVisibleElement(elePassword, "Password Input");
            sendKeyTextBox(elePassword, strPass, "Password Input");

            waitForVisibleElement(eleConfirmPass, "Confirm Password Input");
            sendKeyTextBox(eleConfirmPass, strPass, "Confirm Password Input");

            clickElement(btnContinue,"continue button");
            // Verify Register Auditor Security Page is passed
            waitForVisibleElement(successPageHeaderEle, "Success Page Header");
            result = validateElementText(successPageHeaderEle, "Your Account Is on the Waitlist!");
            Assert.assertTrue(result, "Success Page should be displayed.");

        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Success Page is not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyCreatePasswordPopupWarning(int passwordLength, boolean isContainsCapialLetter, boolean isContainsLetter, boolean isContainsNumber) {
        String expectedColor = GenericService.getConfigValue("auvenir.properties", "TEXT_COLOR_ERROR");
        waitForVisibleElement(resetPasswordWarningPopup, "password error message");
        if (IS_ENGLISH_LANGUAGE) {
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

    public void inputValueIntoPaswordInput(String strName){
        inputValueIntoControl(elePassword, "password",strName);
    }

    public void inputValueIntoConfirmPaswordInput(String strName){
        inputValueIntoControl(eleConfirmPass, "password",strName);
    }

    ///////Function from SuccessPO.java
    //@Override
    public void verifySuccessPageContent() {
        waitForVisibleElement(successPageHeaderEle, "Success Page Header");
        validateElememt(successPageHeaderEle, "Success Page Header", Element_Type.DISPLAYED);
        validateElememt(successPageHeaderEle, "Your Account Is on the Waitlist!", Element_Type.TEXT_VALUE);
        // Checking Image Letter element is displayed
        waitForVisibleElement(eleImageLetter, "Image Letter");
        validateElememt(eleImageLetter, "Element of Image Letter", Element_Type.DISPLAYED);
        // Checking button Close element is displayed
        validateElememt(btnContinue, "Element of button Continue", Element_Type.DISPLAYED);
    }

    /*@Override
    public void load(){
        //
    }

//    @Override*/
//    public void isLoaded() throws Error {
//        // Checking Image Letter element is displayed
//        waitForVisibleElement(eleImageLetter, "Image Letter");
//        validateElememt(eleImageLetter, "Element of Image Letter", Element_Type.DISPLAYED);
//        // Checking button Close element is displayed
//        validateElememt(btnContinue, "Element of button Continue", Element_Type.DISPLAYED);
//
//    }

    public void acceptCreateAccountAuditor() {
        clickElement(btnContinue, "Continue Button");
    }
}
