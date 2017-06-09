package com.auvenir.ui.tests.marketing;


import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.LoginMarketingService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.emailtemplate.EmailTemplateService;
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
 * Update by minh.nguyen on 06/02/2017
 */
public class LoginMarketingTest extends AbstractTest {
    private MarketingService marketingService;
    private GmailLoginService gmailLoginService;
    private LoginMarketingService loginMarketingService;
    //private LoginTest loginTest;
    private AuditorSignUpService auditorSignUpService;
    private AdminService adminService;
    private EmailTemplateService emailTemplateService;
    private AuditorEngagementService auditorEngagementService;

    final String fullName = "Test Login Auditor";
    //    final String fullName = "Duong Nguyen";
    final String strEmail = GenericService.readExcelData(testData, "Login", 1, 1);
    //    final String strEmail = "auvenirinfo@gmail.com";
    final String password = GenericService.readExcelData(testData, "Login", 1, 2);

    String strAdminEmail = GenericService.readExcelData(testData, "Login", 1, 3);
    String strAdminPwd = GenericService.readExcelData(testData, "Login", 1, 4);

    private String emailId = null;
    private String emailPassword = null;

    @Test(priority = 1, enabled= true, description = "Test positive behavior forgot password.")
    public void forgotPasswordTest() throws InterruptedException {
        try {
            emailId = GenericService.readExcelData(testData, "ForgotPassword", 1, 1);
            emailPassword = GenericService.readExcelData(testData, "ForgotPassword", 1, 2);
            marketingService = new MarketingService(getLogger(), getDriver());
            loginMarketingService = new LoginMarketingService(getLogger(),getDriver());
            gmailLoginService = new GmailLoginService(getLogger(), getDriver());
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.deleteGmail(emailId,emailPassword);
            Thread.sleep(2000);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);
            String ranPassword = GenericService.genPassword(8, true, true, true);
            NXGReports.addStep("Enter new password: " + ranPassword, LogAs.PASSED, null);
            loginMarketingService.verifyResetPassword(ranPassword,ranPassword);
            loginMarketingService.exitClick();
            GenericService.updateExcelData(testData, "ForgotPassword", 1, 3, ranPassword);
            NXGReports.addStep("Login again after user resets password successfully.", LogAs.PASSED, null);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithUserNamePassword(emailId, ranPassword);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive behavior forgot password: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e){
            NXGReports.addStep("Test positive behavior forgot password: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 2, enabled= true, description = "Forgot password with blank email address.")
    public void forgotPasswordWithBlankEmail() throws InterruptedException {
        try {
            marketingService = new MarketingService(getLogger(), getDriver());
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            marketingService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            marketingService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            marketingService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with blank email address: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e){
            NXGReports.addStep("Forgot password with blank email address: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 3, enabled= true, description = "Forgot password with email is invalid")
    public void forgotPasswordWithInvalidEmail() throws InterruptedException {
        try {
            String invalidEmailAddress = GenericService.readExcelData(testData, "ForgotPassword", 2, 1);
            NXGReports.addStep("Enter " + invalidEmailAddress + " into email address.", LogAs.PASSED, null);
            Assert.assertFalse(GenericService.isValidEmailAddress(invalidEmailAddress), "Email address is readed from excel file which is a invalid.");
            marketingService = new MarketingService(getLogger(), getDriver());
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            marketingService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            marketingService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            marketingService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            marketingService.verifyContentEmailForgotPasswordMessage("The email is invalid!");
            marketingService.refreshHomePage();
            String invalidEmailAddress1 = GenericService.readExcelData(testData, "ForgotPassword", 3, 1);
            marketingService.clickLoginButton();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress1);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            marketingService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            marketingService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            marketingService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            marketingService.verifyContentEmailForgotPasswordMessage("The email is invalid!");
            marketingService.refreshHomePage();
            String invalidEmailAddress2 = GenericService.readExcelData(testData, "ForgotPassword", 4, 1);
            marketingService.clickLoginButton();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress2);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            marketingService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            marketingService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            marketingService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            marketingService.verifyContentEmailForgotPasswordMessage("The email is invalid!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with email is invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Forgot password with email is invalid: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 4, enabled= true, description = "Forgot password with email is not exist.")
    public void forgotPasswordWithEmailIsNotExist() throws InterruptedException {
        try {
            marketingService = new MarketingService(getLogger(), getDriver());
            String invalidEmailAddress = GenericService.readExcelData(testData, "ForgotPassword", 5, 1);
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyContentEmailForgotPasswordMessage("The email does not exist!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with email is not exist: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Forgot password with email is not exist: FAILED", LogAs.FAILED, (CaptureScreen) null);
            throw e;
        }
    }

    @Test(priority = 5,enabled = true, description = "Test positive tests case login and logout")
    public void loginAndLogoutTest() throws Exception {
        try {
            marketingService = new MarketingService(getLogger(),getDriver());
            auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
            marketingService.setPrefixProtocol("http://");
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithUserNamePassword(strEmail, password);
            auditorEngagementService.verifyAuditorEngagementPage();
            marketingService.logout();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive tests case login and logout: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Test positive tests case login and logout: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 6, enabled = true,description = "Clear all cookies after user login successfully.")
    public void clearCookieAfterLoginSuccessTest(){
        try {
            marketingService = new MarketingService(getLogger(),getDriver());
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithUserNamePassword(strEmail, password);
            //Will uncomment this code when web app is redirect to right website.
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
        }
    }

    @Test(priority = 7, enabled = true,description = "Test login when user input invalid email and password.")
    public  void loginWithInvalidEmailAndPassword() {
        String emailInvalid1 = GenericService.readExcelData(testData, "Login", 2, 1);
        String password = GenericService.readExcelData(testData, "Login", 1, 2);
        String emailInvalid2 = GenericService.readExcelData(testData, "Login", 3, 1);
        String emailInvalid3 = GenericService.readExcelData(testData, "Login", 4, 1);
        String emailNotExists = GenericService.readExcelData(testData, "Login", 5, 1);
        String passwordNotExists = GenericService.readExcelData(testData, "Login", 5, 2);
        try {
            marketingService = new MarketingService(getLogger(),getDriver());
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            //Verify Test login when user does not input email and password.
            marketingService.loginToMarketingPageWithInvalidValue("","");
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyColorPasswordTxtBox();
            //Verify Test login when user input invalid email.
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid1,password);
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid2,password);
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid3,password);
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            //Verify Test login with incorrect email or password.
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailNotExists, passwordNotExists);
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyColorPasswordTxtBox();
            marketingService.verifyErrorLoginMessage("Wrong username or password!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test login when user does not input email and password: PASSED", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Test login when user does not input email and password: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
