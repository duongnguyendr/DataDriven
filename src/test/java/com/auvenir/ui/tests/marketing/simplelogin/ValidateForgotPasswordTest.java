package com.auvenir.ui.tests.marketing.simplelogin;

import com.auvenir.ui.pages.marketing.forgotpassword.ResetPasswordPO;
import com.auvenir.ui.pages.marketing.mailtemplate.EmailResetPassPO;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 4/21/2017.
 */
public class ValidateForgotPasswordTest extends AbstractTest {
    private MarketingService marketingService;
    /*private LoginModalPO loginPO = null;
    private ForgotPassModalPO forgotPassModalPO = null;
    private ResetLinkSentModalPO resetLinkSentModalPO = null;
    private EmailResetPassPO emailResetPassPO = null;
    */
    private ResetPasswordPO resetPassPO = null;
    private String emailId = null;
    private String emailPassword = null;
    private GmailLoginService gmailLoginService;

    @Test(priority = 1, enabled = true, description = "Forgot password with password is invalid.")
    public void forgotPasswordWithInvalidValue() {
        try {
            emailId = GenericService.readExcelData(testData, "ForgotPassword", 1, 1);
            emailPassword = GenericService.readExcelData(testData, "ForgotPassword", 1, 2);
            marketingService = new MarketingService(getLogger(), getDriver());
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService = new GmailLoginService(getLogger(), getDriver());
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);
            EmailResetPassPO emailResetPassPO = new EmailResetPassPO(getDriver());
            resetPassPO = emailResetPassPO.navigateResetPasswordPage();
            resetPassPO.getEleNewPasword().click();
            //webDriver.navigate().refresh();
            /*homePO = new HomePage(webDriver);
            NXGReports.addStep("Open login modal", LogAs.PASSED, null);
            loginPO = homePO.getHeaderPage().openLoginModal().get();
            NXGReports.addStep("Open forgot password modal", LogAs.PASSED, null);
            forgotPassModalPO = loginPO.navigateToForgotPassword().get();
            NXGReports.addStep("Typing email and click forgot password to navigate to reset link sent modal.", LogAs.PASSED, null);
            resetLinkSentModalPO = forgotPassModalPO.resetPassword(emailId);
            NXGReports.addStep("Checking email", LogAs.PASSED, null);
            GmailPO gmailPO = new GmailPO(webDriver).get();
            gmailPO.openGmailIndexForgotPassword(emailId, emailPassword);
            emailResetPassPO = new EmailResetPassPO(webDriver).get();
            NXGReports.addStep("Navigate to Reset password page.", LogAs.PASSED, null);
            resetPassPO = emailResetPassPO.navigateResetPasswordPage().get();
            resetPassPO.getEleNewPasword().click();*/
            /*try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            String ranPassword = GenericService.genPassword(7, true, true, true);
            NXGReports.addStep("Enter new valid password: " + ranPassword, LogAs.PASSED, null);
            resetPassPO.getEleNewPasword().sendKeys(ranPassword);
            resetPassPO.verifyPopupWarning(ranPassword.length(), true, true, true);
            marketingService.refreshHomePage();
            //getDriver().navigate().refresh();
            resetPassPO.getEleNewPasword().click();
            /*try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            String ranPasswordNotContainsUpperCase = "abc1234d";
            NXGReports.addStep("Enter new  invalid password is: " + ranPasswordNotContainsUpperCase, LogAs.PASSED, null);
            resetPassPO.getEleNewPasword().sendKeys(ranPasswordNotContainsUpperCase);
            resetPassPO.verifyPopupWarning(ranPasswordNotContainsUpperCase.length(), false, true, true);
            marketingService.refreshHomePage();
            //webDriver.navigate().refresh();
            resetPassPO.getEleNewPasword().click();
            /*try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            String ranPasswordNotContainsLowerCase = "1234ABCD";
            NXGReports.addStep("Enter new  invalid password is: " + ranPasswordNotContainsLowerCase, LogAs.PASSED, null);
            resetPassPO.getEleNewPasword().sendKeys(ranPasswordNotContainsLowerCase);
            resetPassPO.verifyPopupWarning(ranPasswordNotContainsLowerCase.length(), true, true, true);
            marketingService.refreshHomePage();
            //webDriver.navigate().refresh();
            resetPassPO.getEleNewPasword().click();
            /*try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            String ranPasswordNotContainsDigit = "abcdABCD";
            NXGReports.addStep("Enter new  invalid password is: " + ranPasswordNotContainsDigit, LogAs.PASSED, null);
            resetPassPO.getEleNewPasword().sendKeys(ranPasswordNotContainsDigit);
            resetPassPO.verifyPopupWarning(ranPasswordNotContainsDigit.length(), true, true, false);
            marketingService.refreshHomePage();
            //webDriver.navigate().refresh();
            resetPassPO.getEleNewPasword().click();
            /*try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            String randomPasswordContaintDigit = "12345678";
            NXGReports.addStep("Enter new  invalid password is: " + randomPasswordContaintDigit, LogAs.PASSED, null);
            resetPassPO.getEleNewPasword().sendKeys(randomPasswordContaintDigit);
            resetPassPO.verifyPopupWarning(randomPasswordContaintDigit.length(), false, false, true);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with password is invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Forgot password with password is invalid: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
    @Test(priority = 2, enabled = true , description = "Verify alert when user re-types new password not match.")
    public void forgotPasswordWithRetypePasswordNotMatchTest(){
        try {
            emailId = GenericService.readExcelData(testData, "ForgotPassword", 1, 1);
            emailPassword = GenericService.readExcelData(testData, "ForgotPassword", 1, 2);
            marketingService = new MarketingService(getLogger(), getDriver());
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService = new GmailLoginService(getLogger(), getDriver());
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);
            EmailResetPassPO emailResetPassPO = new EmailResetPassPO(getDriver());
            resetPassPO = emailResetPassPO.navigateResetPasswordPage();
            resetPassPO.getEleNewPasword().click();
            String ranPassword = GenericService.genPassword(8, true, true, true);
            NXGReports.addStep("Enter new valid password: " + ranPassword, LogAs.PASSED, null);
            resetPassPO.getEleNewPasword().sendKeys(ranPassword);
            resetPassPO.verifyPopupWarning(ranPassword.length(), true, true, true);
            resetPassPO.getEleRetypeNewPassword().click();
            String ranReNewPassword = GenericService.genPassword(7, true, true, true);
            NXGReports.addStep("Enter re new password: " + ranReNewPassword, LogAs.PASSED, null);
            resetPassPO.getEleRetypeNewPassword().sendKeys(ranReNewPassword);
            resetPassPO.verifyPopupWarningWhenUserEnterReNewpassword();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify alert when user re-types new password not match: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify alert when user re-types new password not match: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

}
