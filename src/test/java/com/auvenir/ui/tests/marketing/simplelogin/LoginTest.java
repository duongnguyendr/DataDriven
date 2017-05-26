package com.auvenir.ui.tests.marketing.simplelogin;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.HomeService;
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
    private HomeService homeService;

    @Test(priority = 1,enabled = true, description = "Test positive tests case login and logout")
    public void loginAndLogoutTest() {
        try {
            homeService = new HomeService(getLogger(),getDriver());
            String email = GenericService.readExcelData(testData, "Login", 1, 1);
            String password = GenericService.readExcelData(testData, "Login", 1, 2);
            homeService.goToBaseURL();
            homeService.clickLoginButton();
            homeService.loginWithUserNamePassword(email, password);
            homeService.logout();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive tests case login and logout: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Test positive tests case login and logout: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    @Test(priority = 2, enabled = true,description = "Clear all cookies after user login successfully.")
    public void clearCookieAfterLoginSuccessTest(){
        try {
            homeService = new HomeService(getLogger(),getDriver());
            homeService.goToBaseURL();
            homeService.clickLoginButton();
            homeService.loginWithUserNamePassword(GenericService.readExcelData(testData, "Login", 1, 1),
                    GenericService.readExcelData(testData, "Login", 1, 2));
            homeService.deleteCookieName("token_data");
            homeService.deleteCookieName("au_urs_info");
            homeService.refreshHomePage();
            homeService.verifyLoginBTN();
            homeService.verifySignUpBTN();
            homeService.verifyLogoutBTNIsNotPresented();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Clear all cookies after user login successfully: PASSED", LogAs.PASSED, (CaptureScreen) null);
            //homePO.validateElememt(homePO.getHeaderPage().getBtnLogout(), "Button Logout", AbstractPage.Element_Type.NOT_EXIST);
//        Assert.assertEquals(webDriver.manage().getCookies().size(), 0);
        }catch (Exception e){
            NXGReports.addStep("Clear all cookies after user login successfully: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    @Test(priority = 3, enabled = true,description = "Test login when user does not input email and password.")
    public  void loginWithNullEmailAndPassword() {
        try {
            homeService = new HomeService(getLogger(),getDriver());
            homeService.loginToMarketingPage("","");

            //Verify border and background-color of email input

            homeService.verifyColorUserNameTxtBox("border-color","rgb(253, 109, 71)");
            homeService.verifyColorUserNameTxtBox("background-color","rgba(241, 103, 57, 0.2)");

            //Verify border and background-color of password input

            homeService.verifyColorPasswordTxtBox("border-color","rgb(253, 109, 71)");
            homeService.verifyColorPasswordTxtBox("background-color","rgba(241, 103, 57, 0.2)");
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
            homeService = new HomeService(getLogger(),getDriver());
            String email = GenericService.readExcelData(testData, "Login", 2, 1);
            String password = GenericService.readExcelData(testData, "Login", 1, 2);
            homeService.loginToMarketingPage(email,password);
            //The error message should be displayed.
            homeService.verifyErrorLoginMessage("The email is invalid!");
            homeService.verifyColorErrorLoginMessage("color","rgba(159, 58, 56, 1)");
            homeService.verifyColorErrorLoginMessage("background-color","rgba(255, 246, 246, 1)");
            homeService.refreshHomePage();
            String email1 = GenericService.readExcelData(testData, "Login", 3, 1);
            String password1 = GenericService.readExcelData(testData, "Login", 1, 2);
            homeService.loginToMarketingPage(email1,password1);
            //The error message should be displayed.
            homeService.verifyErrorLoginMessage("The email is invalid!");
            homeService.verifyColorErrorLoginMessage("color","rgba(159, 58, 56, 1)");
            homeService.verifyColorErrorLoginMessage("background-color","rgba(255, 246, 246, 1)");

            homeService.refreshHomePage();
            String email2 = GenericService.readExcelData(testData, "Login", 4, 1);
            String password2 = GenericService.readExcelData(testData, "Login", 1, 2);
            homeService.loginToMarketingPage(email1,password1);
            //The error message should be displayed.
            homeService.verifyErrorLoginMessage("The email is invalid!");
            homeService.verifyColorErrorLoginMessage("color","rgba(159, 58, 56, 1)");
            homeService.verifyColorErrorLoginMessage("background-color","rgba(255, 246, 246, 1)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test login when user input invalid email: PASSED", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Test login when user does not input email and password: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    @Test(priority = 5, enabled = true, description = "Test login with incorrect email or password")
    public void loginWithIncorrectEmailOrPassword() {
        try {
            homeService = new HomeService(getLogger(), getDriver());

            NXGReports.addStep("Test login with incorrect email or password", LogAs.PASSED, null);
            String email = GenericService.readExcelData(testData, "Login", 5, 1);
            String password = GenericService.readExcelData(testData, "Login", 5, 2);
            homeService.loginToMarketingPage(email, password);
            //Verify border and background-color of email input
            homeService.verifyColorUserNameTxtBox("border-color", "rgb(253, 109, 71)");
            homeService.verifyColorUserNameTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            //Verify border and background-color of password input
            homeService.verifyColorPasswordTxtBox("border-color", "rgb(253, 109, 71)");
            homeService.verifyColorPasswordTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            //The error message should be displayed.
            homeService.verifyErrorLoginMessage("Wrong username or password!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test login when user input invalid email: PASSED", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test login with incorrect email or password: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
