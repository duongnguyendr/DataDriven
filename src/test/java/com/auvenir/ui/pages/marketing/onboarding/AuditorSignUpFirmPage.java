package com.auvenir.ui.pages.marketing.onboarding;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/12/2017.
 */
public class AuditorSignUpFirmPage extends AbstractPage {

    public AuditorSignUpFirmPage(Logger logger, WebDriver driver) {
        super(logger,driver);
        PageFactory.initElements(driver, this);
    }

    // =============================================== Element of Breadcrumb Completed page ===============================
    @FindBy(css = ".completed>div>.title")
    private WebElement elePagePersonal;
    public WebElement getElePagePersonal(){return elePagePersonal; }

    // Element of Breadcrumb of Active page
    @FindBy(xpath = "//div[@class='active step']/div[div[text()='RAFFERMIR'] or text()='FIRM']")
    private WebElement elePageActive;
    public WebElement getElePageActive(){return elePageActive; }

    // ================================================ Element of Firm Name  =============================================
    @FindBy(xpath = "//input[@name='firm_name']")
    private WebElement eleFirmName;
    public WebElement getEleFirmName() {return eleFirmName;}

//    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='error field']//div[@class='ui input']//input[@name='firm_name']")
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

//    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='error field']//div[@class='ui input']//input[@name='firm_previous_name']")
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

    // Element of State
    @FindBy(xpath = "(//div[@role='listbox'])[1]")
    private WebElement eleState;
    public WebElement getEleState() {
        return eleState;
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

    // Element of Number of Employees
    @FindBy(xpath = "(//div[@role='listbox'])[2]")
    private WebElement eleNumberEmployee;
    public WebElement getEleNumberEmployee() {
        return eleNumberEmployee;
    }

    // Element of Phone Number
    @FindBy(xpath = "//input[@name='firm_phone_number']")
    private WebElement elePhoneNumber;
    public WebElement getElePhoneNumber() {return elePhoneNumber;}

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

    final String warningBorderCSSColor = "rgb(253, 109, 71)";
    final String warningBackgroundCSSColor = "rgba(241, 103, 57, 0.2)";

    //@Override
    public void verifyPageContent(){
        getLogger().info("Verify Page Content Firm PO.");
        if(IS_ENGLISH_LANGUAGE)
            validateElememt(elePagePersonal,"PERSONAL", Element_Type.TEXT_VALUE);
        else
            validateElememt(elePagePersonal,"PERSONNEL", Element_Type.TEXT_VALUE);
        this.isLoaded();
    }

    /*@Override
    protected void load() {
        //
    }

    @Override*/
    protected void isLoaded() throws Error{
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
        validateElememt(eleState, "Element of State", Element_Type.DISPLAYED);
        // Checking Member I.D element is displayed
        validateElememt(eleMemberID, "Element of Member I.D", Element_Type.DISPLAYED);
        // Checking Number of Employee element is displayed
        validateElememt(eleNumberEmployee, "Element of Number Employee", Element_Type.DISPLAYED);
        // Checking Phone Number element is displayed
        validateElememt(elePhoneNumber, "Element of Phone Number", Element_Type.DISPLAYED);
        // Checking checkbox Affiliated Firm element is displayed
        validateElememt(chkAffFirm, "Element of checkbox Affiliated", Element_Type.DISPLAYED);
        // Checking button Update Logo element is displayed
        validateElememt(btnUpdateLogo, "Element of button Update Logo", Element_Type.DISPLAYED);
        // Checking checkbox Rule Logo element is displayed
        validateElememt(chkRuleLogo, "Element of checkbox Rule Logo", Element_Type.DISPLAYED);
        // Checking button Continue element is displayed
        validateElememt(btnContinue, "Element of button Continue", Element_Type.DISPLAYED);
    }

    public void registerFirmInfo(String strName, String strPreName, String strWebsite, String strStreetAddr, String strOffNum, String strZipCode, String strCity, String strState, String strMemberID, String strNumEmp, String strPhone, String strAffName, String strPathLogo) {
        try {

            //this.getChkAffFirm().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            eleFirmName.sendKeys(strName);
            NXGReports.addStep("Input Firm Name", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

//            elePreFirmName.sendKeys(strPreName);
//            NXGReports.addStep("Input Firm Previous Name", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleFirmWebsite.sendKeys(strWebsite);
            NXGReports.addStep("Input Firm Website", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleStreetAddress.sendKeys(strStreetAddr);
            NXGReports.addStep("Input Street Address", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleOfficeNumber.sendKeys(strOffNum);
            NXGReports.addStep("Input Office Number", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleZipCode.sendKeys(strZipCode);
            NXGReports.addStep("Input Zip Code", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleCity.sendKeys(strCity);
            NXGReports.addStep("Input City", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleState.click();
            //this.selectListBoxByText(eleMenu, strState);
            NXGReports.addStep("Select Status State", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleMemberID.sendKeys(strMemberID);
            NXGReports.addStep("Input Member ID", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleNumberEmployee.click();
            //this.selectListBoxByText(eleMenu, strNumEmp);
            NXGReports.addStep("Select Number of Employee", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            elePhoneNumber.sendKeys(strPhone);
            NXGReports.addStep("Input Phone Number", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            eleAffFirm.sendKeys(strAffName);
            NXGReports.addStep("Input Affiliated Firm's Name", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            // Click button Update Logo
            /*Actions actions = new Actions(this.driver);
            actions.moveToElement(btnUpdateLogo).click().perform();*/
            /*try {
                Thread.sleep(2000);
                Keyboard keyboard = null;
                keyboard = new Keyboard();
                keyboard.type(strPathLogo);
                Thread.sleep(2000);
                keyboard.type("\n");
                Thread.sleep(3000);
                NXGReports.addStep("Update photo Logo", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }catch (InterruptedException e ) {
                e.printStackTrace();
            } catch (AWTException e) {
                e.printStackTrace();
            }*/

            chkRuleLogo.click();
            NXGReports.addStep("Check to checkbox Rule of Logo", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            btnContinue.click();
            NXGReports.addStep("Click button Continue", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (NoSuchElementException e) {
            NXGReports.addStep("Element is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }

        // Verify Register Auditor FIRM Page is passed
        try {
            this.validateElememt(elePageActive,"Page Register Auditor FIRM ", Element_Type.NOT_EXIST);
            NXGReports.addStep("Register Auditor Firm Information passed", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (NoSuchElementException e) {
            NXGReports.addStep("Register Auditor Firm Information failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError("Register Auditor Firm Information failed");
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
        inputValueIntoControl(elePhoneNumber, "phone number id",strName);
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
}
