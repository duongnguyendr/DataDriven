package com.auvenir.ui.tests.marketing;


import com.auvenir.ui.dataprovider.marketing.LoginMarketingDataProvider;
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

import java.util.Random;

/**
 * Created by toan.nguyenp on 4/11/2017.
 * Update by minh.nguyen on June 30, 2017
 */
public class LoginMarketingTest extends AbstractTest {
    private MarketingService marketingService;
    private GmailLoginService gmailLoginService;

    //private LoginTest loginTest;
    private AuditorEngagementService auditorEngagementService;

/*    private String emailId = null;
    private String emailPassword = null;*/

    @Test(priority = 1, enabled= true, description = "Test positive behavior forgot password.", dataProvider = "forgotPasswordTest",
                                        dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordTest(String emailId, String emailPassword, String ranPassword) throws Exception {
        /*emailId = GenericService.getTestDataFromExcel("ForgotPassword","AUDITOR_EMAIL_ADDRESS","VALID VALUE");
        emailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");*/
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailId = GenericService.sBrowserData + emailId;
        getLogger().info(ranPassword);
        try {
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);

            NXGReports.addStep("Enter new password: " + ranPassword, LogAs.PASSED, null);
            marketingService.verifyResetPassword(ranPassword,ranPassword);

            GenericService.updateExcelData(testData, "ForgotPassword", 1, 3, ranPassword);
            NXGReports.addStep("Login again after user resets password successfully.", LogAs.PASSED, null);

            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(emailId, ranPassword);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive behavior forgot password: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e){
            NXGReports.addStep("Test positive behavior forgot password: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled= true, description = "Forgot password with blank email address.", dataProvider = "forgotPasswordWithBlankEmail",
                                dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithBlankEmail(String errorMessage) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);
            marketingService.verifyGUIEmailForgotPasswordTextBox();
            marketingService.verifyGUIEmailForgotPasswordMessage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with blank email address: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e){
            NXGReports.addStep("Forgot password with blank email address: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled= true, description = "Forgot password with email is invalid", dataProvider = "forgotPasswordWithInvalidEmail",
                                       dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithInvalidEmail(String invalidEmailAddress, String invalidEmailAddress1,
                                               String invalidEmailAddress2, String errorMessage) throws
            InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        invalidEmailAddress = GenericService.sBrowserData + invalidEmailAddress;
        invalidEmailAddress1 = GenericService.sBrowserData + invalidEmailAddress1;
        invalidEmailAddress2 = GenericService.sBrowserData + invalidEmailAddress2;
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyGUIEmailForgotPasswordTextBox();
            marketingService.verifyGUIEmailForgotPasswordMessage();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);

            marketingService.closeForgotPasswordDialog();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress1);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyGUIEmailForgotPasswordTextBox();
            marketingService.verifyGUIEmailForgotPasswordMessage();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);

            marketingService.closeForgotPasswordDialog();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress2);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyGUIEmailForgotPasswordTextBox();
            marketingService.verifyGUIEmailForgotPasswordMessage();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with email is invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Forgot password with email is invalid: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled= true, description = "Forgot password with email is not exist.", dataProvider = "forgotPasswordWithEmailIsNotExist",
                                        dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithEmailIsNotExist(String invalidEmailAddress, String errorMessage) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        invalidEmailAddress = GenericService.sBrowserData + invalidEmailAddress;
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with email is not exist: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Forgot password with email is not exist: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 5,enabled = true, description = "Test positive tests case login and logout", dataProvider = "loginAndLogoutTest",
                                        dataProviderClass = LoginMarketingDataProvider.class)
    public void loginAndLogoutTest(String emailId, String emailPassword) throws Exception {
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        emailId = GenericService.sBrowserData + emailId;
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

    @Test(priority = 6, enabled = true,description = "Clear all cookies after user login successfully.", dataProvider = "clearCookieAfterLoginSuccessTest"
                                                                                                ,dataProviderClass = LoginMarketingDataProvider.class )
    public void clearCookieAfterLoginSuccessTest(String emailId, String emailPassword){
        marketingService = new MarketingService(getLogger(),getDriver());
        emailId = GenericService.sBrowserData + emailId;
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(emailId, emailPassword);
            marketingService.deleteAllCookieName();
            marketingService.refreshHomePage();
            marketingService.verifyLogoutBTNIsNotPresented();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Clear all cookies after user login successfully: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (AssertionError e){
            NXGReports.addStep("Clear all cookies after user login successfully: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 7, enabled = true, description = "Test login when user input invalid email and password.", dataProvider =
                                                "loginWithInvalidEmailAndPassword", dataProviderClass = LoginMarketingDataProvider.class)
    public void loginWithInvalidEmailAndPassword(String emailInvalid1, String emailInvalid2, String emailInvalid3, String emailNotExists,
            String password) {
        marketingService = new MarketingService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.loginToMarketingPageWithInvalidValue("","");
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyColorPasswordTxtBox();
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
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailNotExists, password);
            marketingService.verifyErrorLoginMessage("Wrong username or password!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test login when user does not input email and password: PASSED", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Test login when user does not input email and password: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 8, enabled = true, description = "Forgot password with password is invalid.", dataProvider = "forgotPasswordWithInvalidValue",
                                                                                              dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithInvalidValue(String emailId, String emailPassword,
            String ranPasswordHas7Character, String ranPasswordNotContainsUpperCase,
            String ranPasswordNotContainsLowerCase, String ranPasswordNotContainsDigit, String ranPasswordNotContainsSpecial,
            String ranPasswordOnlyUpperCase, String ranPasswordOnlyLowerCase, String ranPasswordOnlyDigit, String ranPasswordOnlySpecial) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailId = GenericService.sBrowserData + emailId;
        try {
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);


            marketingService.verifyNewPassword(ranPasswordHas7Character);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordHas7Character, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordNotContainsUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsUpperCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordNotContainsLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordNotContainsDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordNotContainsSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyUpperCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlySpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlySpecial, LogAs.PASSED, null);


            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with password is invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Forgot password with password is invalid: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
    @Test(priority = 9, enabled = true , description = "Verify alert when user re-types new password not match.", dataProvider =
                            "forgotPasswordWithRetypePasswordNotMatchTest",dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithRetypePasswordNotMatchTest(String emailId, String emailPassword,
                                                             String ranPassword, String ranReNewPassword) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailId = GenericService.sBrowserData + emailId;
        try {
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);
            marketingService.verifyNewPassword(ranPassword);
            marketingService.setConfirmPassword(ranReNewPassword);
            marketingService.verifyConfirmPasswordErrorMessage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify alert when user re-types new password not match: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify alert when user re-types new password not match: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
