package com.auvenir.ui.pages.marketing.onboarding;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
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
public class PersonalPage extends AbstractPage {

    public PersonalPage(Logger logger, WebDriver driver){
        super(logger,driver);
        PageFactory.initElements(driver,this);
    }

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

    // Element of Menu listbox
    @FindBy(xpath = "//div[@class='menu transition visible']")
    private WebElement eleMenu;
    public WebElement getEleMenu(){ return eleMenu; }

    // Element of Phone Number
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_phone_number']")
    private WebElement elePhoneNumber;
    public WebElement getElePhoneNumber(){
        return elePhoneNumber;
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

    // Element of button Continue
    @FindBy(id = "btn-continue")
    private WebElement btnContinue;
    public WebElement getBtnContinue(){
        return btnContinue;
    }

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

    //@Override
    public void verifyPageContent(){
        //this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.isLoaded();
    }

    /*@Override
    protected void load(){
        //
    }

    //@Override*/
    protected void isLoaded() throws Error {
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

    public void verifyColorControl(WebElement eleError, String strDescription, String attributeName, String attributeValue){
        waitForVisibleElement(eleError,strDescription);
        validateCssValueElement(eleError,attributeName,attributeValue);
    }

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
}

