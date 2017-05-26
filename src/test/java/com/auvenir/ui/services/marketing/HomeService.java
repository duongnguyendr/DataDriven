package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.HomePage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/19/2017.
 */
public class HomeService extends AbstractService {
    HomePage homePO;
    public HomeService(Logger logger, WebDriver driver) {
        super(logger, driver);
        homePO = new HomePage(getLogger(), getDriver());
    }

    public void clickLoginButton(){
        getLogger().info("Click on login button.");
        homePO.clickOnLoginBTN();
    }
    public void loginWithUserNamePassword(String UserName, String Password){
        getLogger().info("Input Username and Password.");
        homePO.inputUserNamePassword(UserName,Password);
        getLogger().info("Click on Login button.");
        homePO.clickOnSubmitBTN();
    }
    public void logout(){
        homePO.clickOnProfile();
        getLogger().info("Logout.");
        homePO.clickOnLogoutBTN();
    }
    public void deleteAllCookies(){
        homePO.deleteAllCookies();
    }
    public void deleteCookieName(String cookieName){
        homePO.deleteCookieName(cookieName);
    }
    public void refreshHomePage(){
        homePO.refreshPage();
    }
    public void verifyLoginBTN(){
        homePO.verifyLoginBTN();
    }
    public void verifySignUpBTN(){
        homePO.verifySignUpBTN();
    }
    public void verifyLogoutBTNIsNotPresented(){
        homePO.verifyLogoutBTNIsNotPresented();
    }
    public void verifyColorUserNameTxtBox(String attributeName, String attributeValue){
        homePO.verifyColorUserNameTxtBox(attributeName, attributeValue);
    }
    public void verifyColorPasswordTxtBox(String attributeName, String attributeValue){
        homePO.verifyColorPasswordTxtBox(attributeName, attributeValue);
    }
    public void verifyErrorLoginMessage(String messsage){
        homePO.verifyErrorLoginMessage(messsage);
    }
    public void verifyColorErrorLoginMessage(String attributeName, String attributeValue){
        homePO.verifyColorErrorLoginMessage(attributeName, attributeValue);
    }
    public void goToForgotPassword(){
        homePO.clickOnForgotPasswordLink();
    }
    public void verifyForgotPasswordTitle(){
        homePO.verifyForgotPasswordTitle();
    }
    public void inputEmailForgotPassword(String text){
        homePO.inputEmailForgotPassword(text);
    }
    public void clickOnRequestResetLinkBTN() throws InterruptedException {
        homePO.clickOnRequestResetLinkBTN();
        homePO.waitPageLoad();
    }
    public void verifyColorEmailForgotPasswordTextBox(String attributeName, String attributeValue){
        homePO.verifyColorEmailForgotPasswordTextBox(attributeName,attributeValue);
    }
    public void verifyColorEmailForgotPasswordMessage(String attributeName, String attributeValue){
        homePO.verifyColorEmailForgotPasswordMessage(attributeName,attributeValue);
    }
    public void verifyContentEmailForgotPasswordMessage(String text){
        homePO.verifyContentEmailForgotPasswordMessage(text);
    }
    public void verifyHomeContentPage(){
        homePO.verifyHomeContentPage();
    }
    public void goToAboutPage(){
        homePO.goToAboutPage();
    }
    public void goToContactPage(){
        homePO.goToContactPage();
    }
    public void goToCookiesNoticePage(){
        homePO.goToCookiesNoticePage();
    }
    public void goToPrivacyPolicyPage(){
        homePO.goToPrivacyPolicyPage();
    }
}
