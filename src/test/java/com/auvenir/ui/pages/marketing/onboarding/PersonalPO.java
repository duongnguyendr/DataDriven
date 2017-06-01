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
public class PersonalPO extends AbstractPage {

    public PersonalPO(Logger logger,WebDriver driver){
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
        this.validateElememt(eleName,"Element First and Last Name", Element_Type.DISPLAYED);
        NXGReports.addStep("Input First and Last Name", LogAs.PASSED, null);

        // Checking Email Address element is displayed
        this.validateElememt(eleEmail,"Element of Email Address", Element_Type.DISPLAYED);
        NXGReports.addStep("Input Email Address", LogAs.PASSED, null);

        // Checking ReEnter Email Address element is displayed
        this.validateElememt(eleConfirmEmail,"Element of ReEnter Email Address", Element_Type.DISPLAYED);
        NXGReports.addStep("Input confirm Email Address", LogAs.PASSED, null);

        //  Checking Role in Firm element is displayed
        this.validateElememt(eleRoleFirm,"Element of Role in Firm", Element_Type.DISPLAYED);
        NXGReports.addStep("select Role in Firm", LogAs.PASSED, null);

        // Checking Phone Number element is displayed
        this.validateElememt(elePhoneNumber,"Element of Phone Number", Element_Type.DISPLAYED);
        NXGReports.addStep("Input Phone Number", LogAs.PASSED, null);

        // Checking Reference Auvenir element is displayed
        this.validateElememt(eleReference,"Element of Reference Auvenir", Element_Type.DISPLAYED);
        NXGReports.addStep("Select reference about Auvenir", LogAs.PASSED, null);

    }

    public void registerAuditorPersonal(String strName, String strEmail, String strRoleFirm, String strPhone, String strReference){
       try {
           waitForVisibleElement(eleName,"Full name");
           eleName.sendKeys(strName);
           NXGReports.addStep("Input First and Last Name", LogAs.PASSED, null);

           waitForVisibleElement(eleEmail,"Email");
           eleEmail.sendKeys(strEmail);
           NXGReports.addStep("Input Email Address", LogAs.PASSED, null);

           waitForVisibleElement(eleConfirmEmail,"Email");
           eleConfirmEmail.sendKeys(strEmail);
           NXGReports.addStep("Input confirm Email Address", LogAs.PASSED, null);

           waitForClickableOfElement(eleRoleFirm,"Role");
           clickElement(eleRoleFirm,"Role");
           //selectListBoxByText(eleMenu,strRoleFirm);
           NXGReports.addStep("select Role in Firm", LogAs.PASSED, null);

           waitForVisibleElement(elePhoneNumber, "Phone number");
           clickElement(elePhoneNumber,"phone number");
           elePhoneNumber.sendKeys(strPhone);
           NXGReports.addStep("Input Phone Number", LogAs.PASSED, null);

           waitForVisibleElement(eleReference,"Reference check box");
           clickElement(eleReference, "Reference check box");
           //selectListBoxByText(eleMenu,strReference);
           NXGReports.addStep("Select reference about Auvenir", LogAs.PASSED, null);


           waitForVisibleElement(chkAgree,"Check box agree");
           clickElement(chkAgree, " check box agree");
           NXGReports.addStep("Check to checkbox Privacy policy and Term of Service", LogAs.PASSED, null);

           waitForVisibleElement(chkConfirm,"Check box confirm");
           clickElement(chkConfirm, "check box confirm");
           NXGReports.addStep("Check to checkbox I confirm ", LogAs.PASSED, null);

           waitForVisibleElement(btnContinue,"Continue button");
           clickElement(btnContinue, "continue button");
           NXGReports.addStep("Click button continue", LogAs.PASSED, null);

       }catch (NoSuchElementException e){
           NXGReports.addStep("Element is not found", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
           throw new AssertionError(e.getMessage());
       }

        // Verify Register Auditor Personal Page is passed
        try{
            this.validateElememt(eleFrameAuditorPersonal,"Page Register Auditor Personal", Element_Type.NOT_EXIST);
            NXGReports.addStep("Register Auditor Personal passed", LogAs.PASSED,null);
        }catch (NoSuchElementException e){
            NXGReports.addStep("Register Auditor Personal failed", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError("Register Auditor Personal failed");
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

    public void inputValueIntoControl(WebElement eleInput, String strDescription, String strName){
        try {
            waitForVisibleElement(eleInput,strDescription);
            clickElement(eleInput,strDescription);
            eleInput.sendKeys(strName);
            NXGReports.addStep("Input "+ strDescription, LogAs.PASSED, null);

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

    public void inputValueIntoEmailTextBox(String strName){
        inputValueIntoControl(eleEmail, "email",strName);
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

