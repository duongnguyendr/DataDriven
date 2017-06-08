package com.auvenir.ui.tests.marketing.simplelogin;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.signup.AuditorSignUpService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 4/11/2017.
 * Refactor by doai.tran on 5/19/2017.
 * Flowing FW designed by Titan team.
 */
public class LoginTest extends AbstractTest {
    //private LoginTest loginTest;
    private MarketingService marketingService;
    private AuditorSignUpService auditorSignUpService;
    final String fullName = "Test Login Auditor";
//    final String fullName = "Duong Nguyen";
    final String strEmail = GenericService.readExcelData(testData, "Login", 1, 1);
//    final String strEmail = "auvenirinfo@gmail.com";
    final String password = GenericService.readExcelData(testData, "Login", 1, 2);

    @Test(priority = 1,enabled = true, description = "Test positive tests case login and logout")
    public void loginAndLogoutTest() throws Exception {

        try {
            auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
            marketingService = new MarketingService(getLogger(),getDriver());
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.verifyRegisterNewAuditorUser(fullName, strEmail, password);
            marketingService.setPrefixProtocol("http://");
            marketingService.updateUserActiveUsingAPI(strEmail);
            marketingService.updateUserActiveUsingMongoDB(strEmail);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithUserNamePassword(strEmail, password);
            marketingService.logout();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive tests case login and logout: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Test positive tests case login and logout: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true,description = "Clear all cookies after user login successfully.")
    public void clearCookieAfterLoginSuccessTest(){
        try {
            marketingService = new MarketingService(getLogger(),getDriver());
            marketingService.setPrefixProtocol("http://");
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
//            marketingService.loginWithUserNamePassword(strEmail, password);
//            marketingService.deleteCookieName("token_data");
//            marketingService.deleteCookieName("au_urs_info");
            marketingService.deleteCookieName("_ga");
            marketingService.deleteCookieName("_gat");
            marketingService.deleteCookieName("_gid");
            marketingService.deleteCookieName("_hjIncludedInSample");
            marketingService.deleteCookieName("connect.sid");
            marketingService.deleteCookieName("io");
            marketingService.refreshHomePage();
            //Will uncomment this code when web app is redirect to right website.
//            marketingService.verifyLoginBTN();
//            marketingService.verifySignUpBTN();
            marketingService.verifyLogoutBTNIsNotPresented();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Clear all cookies after user login successfully: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (AssertionError e){
            NXGReports.addStep("Clear all cookies after user login successfully: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test(priority = 3, enabled = true,description = "Test login when user does not input email and password.")
    public  void loginWithNullEmailAndPassword() {
        try {
            marketingService = new MarketingService(getLogger(),getDriver());
            marketingService.loginToMarketingPage("","");

            //Verify border and background-color of email input

            marketingService.verifyColorUserNameTxtBox("border-color","rgb(253, 109, 71)");
            marketingService.verifyColorUserNameTxtBox("background-color","rgba(241, 103, 57, 0.2)");

            //Verify border and background-color of password input

            marketingService.verifyColorPasswordTxtBox("border-color","rgb(253, 109, 71)");
            marketingService.verifyColorPasswordTxtBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Email input and password input are highlight when user does not input value.", LogAs.PASSED, null);
            NXGReports.addStep("Test login when user does not input email and password: PASSED", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Test login when user does not input email and password: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    @Test(priority = 4, enabled = true,description = "Test login when user input invalid email.")
    public void loginWithEmailInvalid(){
        try {
            marketingService = new MarketingService(getLogger(),getDriver());
            String email = GenericService.readExcelData(testData, "Login", 2, 1);
            String password = GenericService.readExcelData(testData, "Login", 1, 2);
            marketingService.loginToMarketingPage(email,password);
            //The error message should be displayed.
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.verifyColorErrorLoginMessage("color","rgba(159, 58, 56, 1)");
            marketingService.verifyColorErrorLoginMessage("background-color","rgba(255, 246, 246, 1)");
            marketingService.refreshHomePage();
            String email1 = GenericService.readExcelData(testData, "Login", 3, 1);
            String password1 = GenericService.readExcelData(testData, "Login", 1, 2);
            marketingService.loginToMarketingPage(email1,password1);
            //The error message should be displayed.
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.verifyColorErrorLoginMessage("color","rgba(159, 58, 56, 1)");
            marketingService.verifyColorErrorLoginMessage("background-color","rgba(255, 246, 246, 1)");

            marketingService.refreshHomePage();
            String email2 = GenericService.readExcelData(testData, "Login", 4, 1);
            String password2 = GenericService.readExcelData(testData, "Login", 1, 2);
            marketingService.loginToMarketingPage(email1,password1);
            //The error message should be displayed.
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.verifyColorErrorLoginMessage("color","rgba(159, 58, 56, 1)");
            marketingService.verifyColorErrorLoginMessage("background-color","rgba(255, 246, 246, 1)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test login when user input invalid email: PASSED", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Test login when user does not input email and password: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    @Test(priority = 5, enabled = true, description = "Test login with incorrect email or password")
    public void loginWithIncorrectEmailOrPassword() {
        try {
            marketingService = new MarketingService(getLogger(), getDriver());

            NXGReports.addStep("Test login with incorrect email or password", LogAs.PASSED, null);
            String email = GenericService.readExcelData(testData, "Login", 5, 1);
            String password = GenericService.readExcelData(testData, "Login", 5, 2);
            marketingService.loginToMarketingPage(email, password);
            //Verify border and background-color of email input
            marketingService.verifyColorUserNameTxtBox("border-color", "rgb(253, 109, 71)");
            marketingService.verifyColorUserNameTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            //Verify border and background-color of password input
            marketingService.verifyColorPasswordTxtBox("border-color", "rgb(253, 109, 71)");
            marketingService.verifyColorPasswordTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            //The error message should be displayed.
            marketingService.verifyErrorLoginMessage("Wrong username or password!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test login when user input invalid email: PASSED", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test login with incorrect email or password: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
