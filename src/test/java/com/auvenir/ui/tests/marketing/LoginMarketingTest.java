package com.auvenir.ui.tests.marketing;


import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 4/11/2017.
 * Update by minh.nguyen on 06/02/2017
 */
public class LoginMarketingTest extends AbstractTest {
    private MarketingService marketingService;
    private GmailLoginService gmailLoginService;

    //private LoginTest loginTest;
    private AuditorEngagementService auditorEngagementService;

    private String emailId = null;
    private String emailPassword = null;

    @Test(priority = 1, enabled= true, description = "Test positive behavior forgot password.")
    public void forgotPasswordTest() throws Exception {
        emailId = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","VALID VALUE");
        emailPassword = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        try {
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);

            String ranPassword = GenericService.genPassword(8, true, true, true);
            NXGReports.addStep("Enter new password: " + ranPassword, LogAs.PASSED, null);
            marketingService.verifyResetPassword(ranPassword,ranPassword);

            marketingService.exitClick();
            GenericService.updateExcelData(testData, "ForgotPassword", 1, 3, ranPassword);
            NXGReports.addStep("Login again after user resets password successfully.", LogAs.PASSED, null);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
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
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
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
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            emailId = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","VALID VALUE");
            NXGReports.addStep("Enter " + emailId + " into email address.", LogAs.PASSED, null);
            Assert.assertFalse(GenericService.isValidEmailAddress(emailId), "Email address is readed from excel file which is a invalid.");
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            marketingService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            marketingService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            marketingService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            marketingService.verifyContentEmailForgotPasswordMessage("The email is invalid!");
            marketingService.refreshHomePage();
            String invalidEmailAddress1 = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","INVALID VALUE");
            marketingService.openLoginDialog();
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
            String invalidEmailAddress2 = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","NOT EXIST");
            marketingService.openLoginDialog();
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
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            String invalidEmailAddress = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","INVALID VALUE");
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
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
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        emailId = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","VALID VALUE");
        emailPassword = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(emailId, emailPassword);
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
        marketingService = new MarketingService(getLogger(),getDriver());
        String emailAuditorLogin = GenericService.getTestDataFromExcel("LoginData", "Valid User4", "Auditor");
        String passwordAuditorLogin = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(emailAuditorLogin, passwordAuditorLogin);
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

    @Test(priority = 7, enabled = true, description = "Test login when user input invalid email and password.")
    public  void loginWithInvalidEmailAndPassword() {
        String emailInvalid1 = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "INVALID VALUE1", "Auditor");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String emailInvalid2 = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "INVALID VALUE2", "Auditor");
        String emailInvalid3 = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "INVALID VALUE3", "Auditor");
        String emailNotExists = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "NOT EXIST", "Auditor");
//        String passwordNotExists = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", 5, 2);
        marketingService = new MarketingService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            //Verify Test login when user does not input email and password.
            marketingService.loginToMarketingPageWithInvalidValue("","");
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyColorPasswordTxtBox();
            //Verify Test login when user input invalid email.
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid1,password);
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid2,password);
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid3,password);
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            //Verify Test login with incorrect email or password.
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailNotExists, password);
            //Business is changed, User Name and Password textbox is not changed color error.
//            marketingService.verifyColorUserNameTxtBox();
//            marketingService.verifyColorPasswordTxtBox();
            marketingService.verifyErrorLoginMessage("Wrong username or password!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test login when user does not input email and password: PASSED", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Test login when user does not input email and password: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    @Test(priority = 8, enabled = true, description = "Forgot password with password is invalid.")
    public void forgotPasswordWithInvalidValue() {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        try {
            emailId = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","VALID VALUE");
            emailPassword = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);

            String ranPassword = GenericService.genPassword(7, true, true, true);
            NXGReports.addStep("Enter new password: " + ranPassword, LogAs.PASSED, null);
            marketingService.verifyNewPassword(ranPassword);
            marketingService.verifyPopupWarning(ranPassword, true, true, true);

            String ranPasswordNotContainsUpperCase = "abc1234d";
            NXGReports.addStep("Enter new  invalid password is: " + ranPasswordNotContainsUpperCase, LogAs.PASSED, null);
            marketingService.verifyNewPassword(ranPasswordNotContainsUpperCase);
            marketingService.verifyPopupWarning(ranPasswordNotContainsUpperCase, false, true, true);

            String ranPasswordNotContainsDigit = "abcdABCD";
            NXGReports.addStep("Enter new  invalid password is: " + ranPasswordNotContainsDigit, LogAs.PASSED, null);
            marketingService.verifyNewPassword(ranPasswordNotContainsDigit);
            marketingService.verifyPopupWarning(ranPasswordNotContainsDigit, true, true, false);

            String randomPasswordContaintDigit = "12345678";
            NXGReports.addStep("Enter new  invalid password is: " + randomPasswordContaintDigit, LogAs.PASSED, null);
            marketingService.verifyNewPassword(randomPasswordContaintDigit);
            marketingService.verifyPopupWarning(randomPasswordContaintDigit, false, false, true);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with password is invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Forgot password with password is invalid: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
    @Test(priority = 9, enabled = true , description = "Verify alert when user re-types new password not match.")
    public void forgotPasswordWithRetypePasswordNotMatchTest(){
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        try {
            emailId = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","VALID VALUE");
            emailPassword = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);
            String ranPassword = GenericService.genPassword(8, true, true, true);
            String ranReNewPassword = GenericService.genPassword(7, true, true, true);
            NXGReports.addStep("Enter new valid password: " + ranPassword, LogAs.PASSED, null);
            marketingService.verifyNewPassword(ranPassword);
            marketingService.verifyPopupWarning(ranPassword, true, true, true);
            marketingService.verifyEnterRenewPassword(ranReNewPassword);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify alert when user re-types new password not match: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify alert when user re-types new password not match: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
