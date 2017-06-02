package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
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
    private String ourMissionText1Cst = "Auvenir is on a mission to enable a Smarter Audit. The Auvenir platform seamlessly integrates advanced technology to enhance the financial audit workflow, improving efficiency for auditors and minimizing the opportunity cost for their clients.";
    private String ourMissionText2Cst = "As a Deloitte venture, Auvenir benefits from the agility of a start-up culture while leveraging deep world-class technology and audit expertise. Our people are dedicated to continuously improving our offering to make the audit process better for auditors and their clients.";
    private String ourMissionText3Cst = "Our long term vision is to inspire full trust and confidence in financial reporting through accessible, timely, and reliable communication of financial performance between companies and their financiers.";
    private String whyAuvenirText2Cct = "We have developed a robust collaboration tool for auditors and their clients as well as patent pending machine learning software that automates a great deal of the audit process.";
    private String belowProductFeaturesTextCst = "Our platform re-imagines the audit, making it smarter for all parties.";
    private String spendLessTimeDescriptionTextCst = "Automate mundane tasks, freeing up time for higher value services and a better ROI";
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
    @FindBy(xpath = "//img[@src='/static/images/home/img_feature_1.png']")
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
    @FindBy(xpath = "//a[@href='/terms']")
    private WebElement termsOfService;

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
    public void verifyHomeContentPage() {
        getLogger().info("Verify home content page");
        boolean checkOurMissionText1 = false;
        boolean checkOurMissionText2 = false;
        boolean checkOurMissionText3 = false;
        boolean checkWhyAuvenir2 = false;
        boolean checkProductFeatures = false;
        boolean checkBelowProductFeatures = false;
        boolean checkSpendLessTimeDescription = false;
        boolean checkHomePageContentPage, checkHomePageContentPage1, checkHomePageContentPage2, checkHomePageContentPage3,checkHomePageContentPage4
                ,checkHomePageContentPage5, checkHomePageContentPage6, checkHomePageContentPage7, checkHomePageContentPage8 = false;
        checkHomePageContentPage = waitForVisibleElement(avenirLogo, "avenirLogo");
        checkHomePageContentPage1 = waitForVisibleElement(weHelpYouAuditSmarterText, "weHelpYouAuditSmarterText");
        checkHomePageContentPage2 = waitForVisibleElement(joinAsAnAuditorTodayText, "joinAsAnAuditorTodayText");
        checkHomePageContentPage3 = waitForVisibleElement(ourMissionText, "ourMissionText");

        waitForVisibleElement(ourMissionText1, "ourMissionText1");
        if (ourMissionText1.getText().equals(ourMissionText1Cst)) {
            checkOurMissionText1 = true;
        }
        waitForVisibleElement(ourMissionText2, "ourMissionText2");
        if (ourMissionText2.getText().equals(ourMissionText2Cst)) {
            checkOurMissionText2 = true;
        }
        waitForVisibleElement(ourMissionText3, "ourMissionText3");
        if (ourMissionText3.getText().equals(ourMissionText3Cst)) {
            checkOurMissionText3 = true;
        }
        checkHomePageContentPage4 = waitForVisibleElement(whyAuvenirText, "whyAuvenirText");
        checkHomePageContentPage5 = waitForVisibleElement(whyAuvenirText1, "whyAuvenirText1");
        checkHomePageContentPage6 = waitForVisibleElement(whyAuvenirText2, "whyAuvenirText2");
        if (whyAuvenirText2.getText().equals(whyAuvenirText2Cct)) {
            checkWhyAuvenir2 = true;
        }

        waitForVisibleElement(productFeaturesText, "productFeaturesText");
        if (productFeaturesText.getText().contains("Product Features"))
        {
            checkProductFeatures = true;
        }
        waitForVisibleElement(belowProductFeaturesText,"belowProductFeaturesText");
        if(belowProductFeaturesText.getText().equals(belowProductFeaturesTextCst))
        {
            checkBelowProductFeatures = true;
        }
        checkHomePageContentPage7 = waitForVisibleElement(spendLessTimeImage,"spendLessTimeImage");
        checkHomePageContentPage8 = waitForVisibleElement(spendLessTimeText,"spendLessTimeText");

        waitForVisibleElement(spendLessTimeDescriptionText,"spendLessTimeDescriptionText");
        if(spendLessTimeDescriptionText.getText().equals(spendLessTimeDescriptionTextCst))
        {
            checkSpendLessTimeDescription = true;
        }
        if(checkHomePageContentPage & checkHomePageContentPage1 & checkHomePageContentPage2 & checkHomePageContentPage3 & checkHomePageContentPage4 & checkHomePageContentPage5
                & checkHomePageContentPage6 & checkHomePageContentPage7 & checkHomePageContentPage8 & checkOurMissionText1 & checkOurMissionText2 & checkOurMissionText3
                & checkWhyAuvenir2 & checkProductFeatures & checkBelowProductFeatures & checkSpendLessTimeDescription)
        {
            NXGReports.addStep("Verify home content page", LogAs.PASSED, null);
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify home content page", LogAs.FAILED, null);
        }
    }

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
    public void goToTermOfService()
    {
        clickElement(termsOfService,"termsOfService");
    }
}
