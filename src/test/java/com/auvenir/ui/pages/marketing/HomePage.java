package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.sun.deploy.config.WinPlatform;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class HomePage extends AbstractPage {

    public HomePage(Logger logger, WebDriver driver){
        super(logger,driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify page content
     */
    /*@Override
    public void verifyContentPage() {
        System.out.println("Verify home page content.");
    }

    @Override
    protected void load() {
        getFooterPage().getEleHome().click();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(webDriver.getTitle(), "Home");
    }

    public PersonalPO navigateAuditorSignUp(){
        this.getHeaderPage().getAuditorSignUp().click();
        return new PersonalPO(webDriver);
    }*/
    @FindBy(xpath = "//*[@id='language-flag']/button")
    private WebElement changeLanguageBTN;
    @FindBy(xpath = "//*[@class='ui right aligned container']/button")
    private WebElement loginBTN;
    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='email']")
    private WebElement emailTextBox;
    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='password']")
    private WebElement passwordTextBox;
    @FindBy(xpath = ".//*[@id='login-popup']//button")
    private WebElement submitBTN;
    @FindBy(xpath = "//*[@class='ui label userAligment']")
    private WebElement profileLink;
    @FindBy(xpath = "//div[@class='menu transition visible']//div[2]/span")
    private WebElement logoutBTN;
    @FindBy(xpath = "//*/a[@class='ui large basic inverted button']")
    private WebElement signUpBTN;
    @FindBy(xpath = "//div[@class='ui center aligned container']//div[@class='ui error message']//div/p")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[@class='ui center aligned container']//div[@class='ui error message']")
    private WebElement errorMessageBorder;
    @FindBy(xpath = "//*/form[@class='ui error form login-form']//input[@name='email']")
    private WebElement userError;
    @FindBy(xpath = "//*/form[@class='ui error form login-form']//input[@name='password']")
    private WebElement passwordError;
    @FindBy(xpath = "//form[@class='ui form login-form']//a[@class='ui label forgot-password']")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//span[@class='forgot-title']")
    private WebElement forgotPasswordTitle;
    @FindBy(xpath = "//form[@class='ui form forgot-form']//input")
    private WebElement emailForgotPasswordTextBox;
    @FindBy(xpath = "//button[contains(text(),'Request Reset Link')]")
    private WebElement requestResetLinkBTN;
    @FindBy(xpath = "//div[@class='error field']//input")
    private WebElement EmailForgotPasswordTextBox;
    @FindBy(xpath = "//div[@id='forgot-popup']//div[@class='ui error message']")
    private WebElement EmailForgotPasswordMessage;

    public void clickOnChangeLanguageBTN(){
        clickElement(changeLanguageBTN,"changeLanguageBTN");
    }
    public void clickOnLoginBTN(){
        clickElement(loginBTN,"loginBTN");
    }
    public void inputUserNamePassword(String username, String password){
        sendKeyTextBox(emailTextBox, username,"emailTextBox");
        sendKeyTextBox(passwordTextBox,password,"passwordTextBox");
    }
    public void clickOnSubmitBTN(){
        clickElement(submitBTN,"loginBTN");
    }
    public void clickOnProfile(){
        clickAndHold(profileLink,"profileLink");
    }
    public void clickOnLogoutBTN(){
        clickElement(logoutBTN,"logoutBTN");
    }
    public void verifyLoginBTN(){
        waitForClickableOfElement(loginBTN,"loginBTN");
    }
    public void verifySignUpBTN(){
        waitForClickableOfElement(signUpBTN,"signUpBTN");
    }
    public void verifyLogoutBTNIsNotPresented(){
        validateNotExistedElement(logoutBTN,"logoutBTN");
    }
    public void verifyColorUserNameTxtBox(String attributeName, String attributeValue){
        waitForVisibleElement(userError,"userError");
        validateCssValueElement(userError,attributeName,attributeValue);
    }
    public void verifyColorPasswordTxtBox(String attributeName, String attributeValue){
        waitForVisibleElement(passwordError,"passwordError");
        validateCssValueElement(passwordError,attributeName,attributeValue);
    }
    public void verifyErrorLoginMessage(String messsage){
        validateElementText(errorMessage,messsage);
    }
    public void verifyColorErrorLoginMessage(String attributeName, String attributeValue){
        waitForVisibleElement(errorMessageBorder,"errorMessageBorder");
        validateCssValueElement(errorMessageBorder,attributeName,attributeValue);
    }
    public void clickOnForgotPasswordLink(){
        waitForClickableOfElement(forgotPasswordLink,"forgotPasswordLink");
        clickElement(forgotPasswordLink,"forgotPasswordLink");
    }
    public void verifyForgotPasswordTitle(){
        waitForVisibleElement(forgotPasswordTitle,"forgotPasswordTitle");
        validateElementText(forgotPasswordTitle,"Forgot Your Password?");
    }
    public void inputEmailForgotPassword(String text){
        clearTextBox(emailForgotPasswordTextBox,"emailForgotPasswordTextBox");
        sendKeyTextBox(emailForgotPasswordTextBox,text,"emailForgotPasswordTextBox");
    }
    public void clickOnRequestResetLinkBTN(){
        clickElement(requestResetLinkBTN,"requestResetLinkBTN");
    }
    public void verifyColorEmailForgotPasswordTextBox(String attributeName, String attributeValue){
        waitForVisibleElement(EmailForgotPasswordTextBox,"EmailForgotPasswordTextBox");
        validateCssValueElement(EmailForgotPasswordTextBox,attributeName,attributeValue);
    }
    public void verifyColorEmailForgotPasswordMessage(String attributeName, String attributeValue){
        waitForVisibleElement(EmailForgotPasswordMessage,"EmailForgotPasswordMessage");
        validateCssValueElement(EmailForgotPasswordMessage,attributeName,attributeValue);
    }
    public void verifyContentEmailForgotPasswordMessage(String text){
        validateElementText(EmailForgotPasswordMessage,text);
    }

    public void clickOnSignupButton(){
        waitForClickableOfElement(signUpBTN,"signup button");
        clickElement(signUpBTN,"signup button");
    }
    public void verifyHomeContentPage(){
        waitForVisibleElement(avenirLogo,"avenirLogo");
        waitForVisibleElement(weHelpYouAuditSmarterText,"weHelpYouAuditSmarterText");
        waitForVisibleElement(joinAsAnAuditorTodayText,"joinAsAnAuditorTodayText");
        waitForVisibleElement(ourMissionText,"ourMissionText");
        waitForVisibleElement(ourMissionText1,"ourMissionText1");
        waitForVisibleElement(ourMissionText2,"ourMissionText2");
        waitForVisibleElement(ourMissionText3,"ourMissionText3");
        waitForVisibleElement(whyAuvenirText,"whyAuvenirText");
        waitForVisibleElement(whyAuvenirText1,"whyAuvenirText1");
        waitForVisibleElement(whyAuvenirText2,"whyAuvenirText2");
        waitForVisibleElement(productFeaturesText,"productFeaturesText");
        waitForVisibleElement(belowProductFeaturesText,"belowProductFeaturesText");
        waitForVisibleElement(spendLessTimeImage,"spendLessTimeImage");
        waitForVisibleElement(spendLessTimeText,"spendLessTimeText");
        waitForVisibleElement(spendLessTimeDescriptionText,"spendLessTimeDescriptionText");
    }
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement avenirLogo;
    @FindBy(xpath = ".//*[@id='marketing-header']//h1")
    private WebElement weHelpYouAuditSmarterText;
    @FindBy(xpath = ".//*[@id='marketing-header']//a[contains(text(),'Join as an Auditor Today')]")
    private WebElement joinAsAnAuditorTodayText;
    @FindBy(xpath = ".//*[@id='home_mission']/h2[contains(text(),'Our Mission')]")
    private WebElement ourMissionText;
    @FindBy(xpath = ".//*[@id='home_mission']/p[1]")
    private WebElement ourMissionText1;
    @FindBy(xpath = ".//*[@id='home_mission']/p[2]")
    private WebElement ourMissionText2;
    @FindBy(xpath = ".//*[@id='home_mission']/p[3]")
    private WebElement ourMissionText3;
    @FindBy(xpath = ".//*[@id='home_whyAuvenir']//h2[contains(text(),'Why Auvenir?')]")
    private WebElement whyAuvenirText;
    @FindBy(xpath = ".//*[@id='home_whyAuvenir']//div[@class='middle aligned column why-auvenir-content']/p[1]")
    private WebElement whyAuvenirText1;
    @FindBy(xpath = ".//*[@id='home_whyAuvenir']//div[@class='middle aligned column why-auvenir-content']/p[2]")
    private WebElement whyAuvenirText2;
    @FindBy(xpath = ".//*[@id='home_productFeatures']/header/h2")
    private WebElement productFeaturesText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']/header/p")
    private WebElement belowProductFeaturesText;
    @FindBy(xpath = "//img[@src=\"/static/images/home/img_feature_1.png\"]")
    private WebElement spendLessTimeImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Spend Less Time, Earn More')]")
    private WebElement spendLessTimeText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[1]/p")
    private WebElement spendLessTimeDescriptionText;
    @FindBy(xpath = "//a[@href='/about']")
    private WebElement aBoutLink;
    @FindBy(xpath = "//a[@href='/contact']")
    private WebElement contactLink;
    @FindBy(xpath = "//a[@href='/cookies']")
    private WebElement cookiesNoticeLink;
    @FindBy(xpath = "//a[@href='/privacy']")
    private WebElement privacyPolicyLink;
    public void goToAboutPage(){
        clickElement(aBoutLink,"aBoutLink");
    }
    public void goToContactPage(){
        clickElement(contactLink,"contactLink");
    }
    public void goToCookiesNoticePage(){
        clickElement(cookiesNoticeLink,"cookiesNoticeLink");
    }
    public void goToPrivacyPolicyPage(){
        clickElement(privacyPolicyLink,"privacyPolicyLink");
    }
}
