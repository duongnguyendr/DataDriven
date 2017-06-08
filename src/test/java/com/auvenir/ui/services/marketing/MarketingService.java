package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.*;
import com.auvenir.ui.pages.marketing.onboarding.AuditorSignUpPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class MarketingService extends AbstractService {
    MarketingPage marketingPage;
    AuditorSignUpPage auditorSignUpPage;
    public MarketingService(Logger logger, WebDriver driver) {
        super(logger, driver);
        marketingPage = new MarketingPage(getLogger(), getDriver());
        auditorSignUpPage = new AuditorSignUpPage(getLogger(), getDriver());
    }
    public void verifyAboutContentPage(){
        marketingPage.verifyAboutContentPage();
    }
    public void goToCareersPage(){
        marketingPage.goToCareersPage();
    }

    public void verifyCareersContentPage(){
        marketingPage.verifyCareersContentPage();
    }

    public void verifyAboutContactPage(){
        marketingPage.verifyContactContentPage();
    }

    public void verifyCookiesNoticeContentPage(){
        marketingPage.verifyCookiesNoticeContentPage();
    }

    public void clickLoginButton(){
        getLogger().info("Click on login button.");
        marketingPage.clickOnLoginBTN();
    }
    public void loginWithUserNamePassword(String UserName, String Password) {
        getLogger().info("Input Username and Password.");
        marketingPage.inputUserNamePassword(UserName,Password);
        getLogger().info("Click on Login button.");
        marketingPage.clickOnSubmitBTN();
        marketingPage.waitForProgressOverlayIsClosed();
    }
    public void logout(){
        marketingPage.clickOnProfile();
        getLogger().info("Logout.");
        marketingPage.clickOnLogoutBTN();
    }
    public void deleteAllCookies(){
        marketingPage.deleteAllCookies();
    }
    public void deleteCookieName(String cookieName){
        marketingPage.deleteCookieName(cookieName);
    }
    public void refreshHomePage(){
        marketingPage.refreshPage();
    }
    public void verifyLoginBTN(){
        marketingPage.verifyLoginBTN();
    }
    public void verifySignUpBTN(){
        marketingPage.verifySignUpBTN();
    }
    public void verifyLogoutBTNIsNotPresented(){
        marketingPage.verifyLogoutBTNIsNotPresented();
    }
    public void verifyColorUserNameTxtBox() {
        marketingPage.verifyColorUserNameTxtBox();
    }
    public void verifyColorPasswordTxtBox(){
        marketingPage.verifyColorPasswordTxtBox();
    }
    public void verifyErrorLoginMessage(String messsage){
        marketingPage.verifyErrorLoginMessage(messsage);
    }
    public void verifyColorErrorLoginMessage(String attributeName, String attributeValue){
        marketingPage.verifyColorErrorLoginMessage(attributeName, attributeValue);
    }
    public void deleteGmail(String emailAddress, String password)
    {
        deleteAllExistedGMail(emailAddress,password);
    }
    public void goToForgotPassword(){
        marketingPage.clickOnForgotPasswordLink();
    }
    public void verifyForgotPasswordTitle(){
        marketingPage.verifyForgotPasswordTitle();
    }
    public void inputEmailForgotPassword(String text){
        marketingPage.inputEmailForgotPassword(text);
    }
    public void clickOnRequestResetLinkBTN() throws InterruptedException {
        marketingPage.clickOnRequestResetLinkBTN();
        marketingPage.waitPageLoad();
    }
    public void verifyColorEmailForgotPasswordTextBox(String attributeName, String attributeValue){
        marketingPage.verifyColorEmailForgotPasswordTextBox(attributeName,attributeValue);
    }
    public void verifyColorEmailForgotPasswordMessage(String attributeName, String attributeValue){
        marketingPage.verifyColorEmailForgotPasswordMessage(attributeName,attributeValue);
    }
    public void verifyContentEmailForgotPasswordMessage(String text){
        marketingPage.verifyContentEmailForgotPasswordMessage(text);
    }
    public void verifyHomeContentPage(){
        marketingPage.verifyHomeContentPage();
    }
    public void goToAboutPage(){
        marketingPage.goToAboutPage();
    }
    public void goToContactPage(){
        marketingPage.goToContactPage();
    }
    public void goToCookiesNoticePage(){
        marketingPage.goToCookiesNoticePage();
    }
    public void goToPrivacyPolicyPage(){
        marketingPage.goToPrivacyPolicyPage();
    }
    public void goToTermsOfService(){
        marketingPage.goToTermOfService();
    }

    public void verifyPrivacyPolicyContentPage(){
        marketingPage.verifyPrivacyPolicyContentPage();
    }

    public void verifyTermsContentPage(){
        marketingPage.verifyTermsContentPage();
    }

    /*
Vien.Pham added login With New User Role
*/
    public void loginWithNewUserRole(String userEmail, String usePwd) throws Exception {
        loginWithUserNamePassword(userEmail,usePwd);
    }


    public void verifyResetPassword(String newPass, String retypeResetPass) throws InterruptedException {
        marketingPage.resetPassword(newPass, retypeResetPass);
    }
    public void verifyNewPassword(String newPassword) throws InterruptedException {
        marketingPage.setNewPassword(newPassword);
    }
    public void verifyPopupWarning(String passwordString, boolean isContainsCapialLetter, boolean isContainsLetter, boolean isContainsNumber){
        auditorSignUpPage.verifyCreateInvalidPassword(passwordString, isContainsCapialLetter, isContainsLetter, isContainsNumber);
    }

    public void verifyEnterRenewPassword(String passwordString)
    {
        auditorSignUpPage.verifyInputWrongConfirmPassword(passwordString);
    }

    public  void exitClick()
    {
        marketingPage.exit();
    }
}
