package com.auvenir.ui.tests.marketing.simplelogin;


import com.auvenir.ui.pages.marketing.forgotpassword.ForgotPassModalPO;
import com.auvenir.ui.pages.marketing.forgotpassword.PasswordResetSuccessPO;
import com.auvenir.ui.pages.marketing.forgotpassword.ResetLinkSentModalPO;
import com.auvenir.ui.pages.marketing.forgotpassword.ResetPasswordPO;
import com.auvenir.ui.pages.marketing.mailtemplate.EmailResetPassPO;
import com.auvenir.ui.pages.marketing.HomePage;
import com.auvenir.ui.pages.marketing.LoginModalPO;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.HomeService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 4/18/2017.
 */
public class ForgotPasswordTest extends AbstractTest {
    private HomeService homeService;
    private GmailLoginService gmailLoginService;
    private HomePage homePO = null;
    private LoginModalPO loginPO = null;
    private ForgotPassModalPO forgotPassModalPO = null;
    private ResetLinkSentModalPO resetLinkSentModalPO = null;
    private EmailResetPassPO emailResetPassPO = null;
    private ResetPasswordPO resetPassPO = null;
    private PasswordResetSuccessPO passwordResetSuccessPO = null;

    private String emailId = null;
    private String emailPassword = null;

    @Test(priority = 1, enabled= true, description = "Test positive behavior forgot password.")
    public void forgotPasswordTest(){
        try {
            emailId = GenericService.readExcelData(testData, "ForgotPassword", 1, 1);
            emailPassword = GenericService.readExcelData(testData, "ForgotPassword", 1, 2);
            homeService = new HomeService(getLogger(), getDriver());
            homeService.goToBaseURL();
            homeService.clickLoginButton();
            homeService.goToForgotPassword();
            homeService.verifyForgotPasswordTitle();
            homeService.inputEmailForgotPassword(emailId);
            homeService.clickOnRequestResetLinkBTN();
            //NXGReports.addStep("Open login modal", LogAs.PASSED, null);
            //loginPO = homePO.getHeaderPage().openLoginModal().get();
            //NXGReports.addStep("Open forgot password modal", LogAs.PASSED, null);
            //forgotPassModalPO = loginPO.navigateToForgotPassword().get();
            //NXGReports.addStep("Typing email and click forgot password to navigate to reset link sent modal.", LogAs.PASSED, null);
            //resetLinkSentModalPO = forgotPassModalPO.resetPassword(emailId);
            //resetLinkSentModalPO.verifyContentModal(emailId);
            //NXGReports.addStep("Checking email", LogAs.PASSED, null);
            gmailLoginService = new GmailLoginService(getLogger(), getDriver());
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);
            EmailResetPassPO emailResetPassPO = new EmailResetPassPO(getDriver());
            //emailResetPassPO = new EmailResetPassPO(webDriver).get();
            //NXGReports.addStep("Navigate to Reset password page.", LogAs.PASSED, null);
            resetPassPO = emailResetPassPO.navigateResetPasswordPage();
            //emailResetPassPO.navigateResetPasswordPage();
            String ranPassword = GenericService.genPassword(8, true, true, true);
            NXGReports.addStep("Enter new password: " + ranPassword, LogAs.PASSED, null);
            passwordResetSuccessPO = resetPassPO.reset(ranPassword, ranPassword);
            passwordResetSuccessPO.exit();
            GenericService.updateExcelData(testData, "ForgotPassword", 1, 3, ranPassword);
            NXGReports.addStep("Login again after user resets password successfully.", LogAs.PASSED, null);
            /*homePO.getHeaderPage().login(emailId, ranPassword);
            homePO.getHeaderPage().logOut();*/
            homeService.goToBaseURL();
            homeService.clickLoginButton();
            homeService.loginWithUserNamePassword(emailId, ranPassword);
            homeService.logout();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive behavior forgot password: PASSED", LogAs.PASSED, (CaptureScreen) null);

        }catch (Exception e){
            NXGReports.addStep("Test positive behavior forgot password: FAILED", LogAs.FAILED, (CaptureScreen) null);

        }
    }

    @Test(priority = 2, enabled= true, description = "Forgot password with blank email address.")
    public void forgotPasswordWithBlankEmail(){
        try {
            homeService = new HomeService(getLogger(), getDriver());
            homeService.goToBaseURL();
            homeService.clickLoginButton();
            homeService.goToForgotPassword();
            homeService.verifyForgotPasswordTitle();
            homeService.clickOnRequestResetLinkBTN();
            homeService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            homeService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            homeService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            homeService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with blank email address: PASSED", LogAs.PASSED, (CaptureScreen) null);
            /*homePO = new HomePage(webDriver);
            NXGReports.addStep("Open login modal", LogAs.PASSED, null);
            loginPO = homePO.getHeaderPage().openLoginModal().get();
            NXGReports.addStep("Open forgot password modal", LogAs.PASSED, null);
            forgotPassModalPO = loginPO.navigateToForgotPassword().get();
            NXGReports.addStep("Click Reset password button.", LogAs.PASSED, null);
            forgotPassModalPO.getEleRequestResetLink().click();*/
            //Verify expected result
            /*try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            /*homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "border-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BORDER_COLOR_ERROR"));
            homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BACKGROUND_COLOR_ERROR"));*/
            //homePO.getValueCssOfBeforeElement(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-image", PropertiesHelper.getConfigValue(PROPERTIES_DATA,"URL_IMAGE_WARNING"));
        }catch (Exception e){
            NXGReports.addStep("Forgot password with blank email address: FAILED", LogAs.FAILED, (CaptureScreen) null);

        }
    }

    @Test(priority = 3, enabled= true, description = "Forgot password with email is invalid")
    public void forgotPasswordWithInvalidEmail() {
        try {
            String invalidEmailAddress = GenericService.readExcelData(testData, "ForgotPassword", 2, 1);
            NXGReports.addStep("Enter " + invalidEmailAddress + " into email address.", LogAs.PASSED, null);
            Assert.assertFalse(GenericService.isValidEmailAddress(invalidEmailAddress), "Email address is readed from excel file which is a invalid.");

            homeService = new HomeService(getLogger(), getDriver());
            homeService.goToBaseURL();
            homeService.clickLoginButton();
            homeService.goToForgotPassword();
            homeService.verifyForgotPasswordTitle();
            homeService.inputEmailForgotPassword(invalidEmailAddress);
            homeService.clickOnRequestResetLinkBTN();
            homeService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            homeService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            homeService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            homeService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            homeService.verifyContentEmailForgotPasswordMessage("The email is invalid!");
            homeService.refreshHomePage();
            String invalidEmailAddress1 = GenericService.readExcelData(testData, "ForgotPassword", 3, 1);
            homeService.clickLoginButton();
            homeService.goToForgotPassword();
            homeService.verifyForgotPasswordTitle();
            homeService.inputEmailForgotPassword(invalidEmailAddress1);
            homeService.clickOnRequestResetLinkBTN();
            homeService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            homeService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            homeService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            homeService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            homeService.verifyContentEmailForgotPasswordMessage("The email is invalid!");
            homeService.refreshHomePage();
            String invalidEmailAddress2 = GenericService.readExcelData(testData, "ForgotPassword", 4, 1);
            homeService.clickLoginButton();
            homeService.goToForgotPassword();
            homeService.verifyForgotPasswordTitle();
            homeService.inputEmailForgotPassword(invalidEmailAddress2);
            homeService.clickOnRequestResetLinkBTN();
            homeService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            homeService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            homeService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            homeService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            homeService.verifyContentEmailForgotPasswordMessage("The email is invalid!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with email is invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);

            /*webDriver.navigate().refresh();
            NXGReports.addStep("Open login modal", LogAs.PASSED, null);
            loginPO = homePO.getHeaderPage().openLoginModal().get();
            NXGReports.addStep("Open forgot password modal", LogAs.PASSED, null);
            forgotPassModalPO = loginPO.navigateToForgotPassword().get();
            NXGReports.addStep("Enter a invalid email address.", LogAs.PASSED, null);
            forgotPassModalPO.getEleEmail().sendKeys(invalidEmailAddress);*/
            /*NXGReports.addStep("Click Reset password button.", LogAs.PASSED, null);
            forgotPassModalPO.getEleRequestResetLink().click();
            //Verify expected result
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            /*homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "border-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BORDER_COLOR_ERROR"));
            homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BACKGROUND_COLOR_ERROR"));

            //homePO.getValueCssOfBeforeElement(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-image", PropertiesHelper.getConfigValue(PROPERTIES_DATA,"URL_IMAGE_WARNING"));
            homePO.validateElememt(homePO.getHeaderPage().getForgotPassModalPO().getEleErrorMessage(), "Error message", AbstractPage.Element_Type.DISPLAYED);

            String invalidEmailAddress1 = ExcelHelper.readExcelData(testData, "ForgotPassword", 3, 1);
            NXGReports.addStep("Enter " + invalidEmailAddress1 + " into email address.", LogAs.PASSED, null);
            Assert.assertFalse("Email address is readed from excel file which is a invalid.", GenericLib.isValidEmailAddress(invalidEmailAddress1));

            webDriver.navigate().refresh();

            NXGReports.addStep("Open login modal", LogAs.PASSED, null);
            loginPO = homePO.getHeaderPage().openLoginModal().get();

            NXGReports.addStep("Open forgot password modal", LogAs.PASSED, null);
            forgotPassModalPO = loginPO.navigateToForgotPassword().get();

            NXGReports.addStep("Enter a invalid email address.", LogAs.PASSED, null);
            forgotPassModalPO.getEleEmail().sendKeys(invalidEmailAddress1);

            NXGReports.addStep("Click Reset password button.", LogAs.PASSED, null);
            forgotPassModalPO.getEleRequestResetLink().click();

            //Verify expected result
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "border-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BORDER_COLOR_ERROR"));
            homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BACKGROUND_COLOR_ERROR"));

            //homePO.getValueCssOfBeforeElement(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-image", PropertiesHelper.getConfigValue(PROPERTIES_DATA,"URL_IMAGE_WARNING"));
            homePO.validateElememt(homePO.getHeaderPage().getForgotPassModalPO().getEleErrorMessage(), "Error message", AbstractPage.Element_Type.DISPLAYED);

            String invalidEmailAddress2 = ExcelHelper.readExcelData(testData, "ForgotPassword", 4, 1);
            NXGReports.addStep("Enter " + invalidEmailAddress2 + " into email address.", LogAs.PASSED, null);
            Assert.assertFalse("Email address is readed from excel file which is a invalid.", GenericLib.isValidEmailAddress(invalidEmailAddress2));

            webDriver.navigate().refresh();

            NXGReports.addStep("Open login modal", LogAs.PASSED, null);
            loginPO = homePO.getHeaderPage().openLoginModal().get();

            NXGReports.addStep("Open forgot password modal", LogAs.PASSED, null);
            forgotPassModalPO = loginPO.navigateToForgotPassword().get();

            NXGReports.addStep("Enter a invalid email address.", LogAs.PASSED, null);
            forgotPassModalPO.getEleEmail().sendKeys(invalidEmailAddress2);

            NXGReports.addStep("Click Reset password button.", LogAs.PASSED, null);
            forgotPassModalPO.getEleRequestResetLink().click();

            //Verify expected result
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "border-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BORDER_COLOR_ERROR"));
            homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BACKGROUND_COLOR_ERROR"));

            //homePO.getValueCssOfBeforeElement(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-image", PropertiesHelper.getConfigValue(PROPERTIES_DATA,"URL_IMAGE_WARNING"));
            homePO.validateElememt(homePO.getHeaderPage().getForgotPassModalPO().getEleErrorMessage(), "Error message", AbstractPage.Element_Type.DISPLAYED);*/
        } catch (Exception e) {
            NXGReports.addStep("Forgot password with email is invalid: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
    @Test(priority = 4, enabled= true, description = "Forgot password with email is not exist.")
    public void forgotPasswordWithEmailIsNotExist(){
        try {
            homeService = new HomeService(getLogger(), getDriver());
            String invalidEmailAddress = GenericService.readExcelData(testData, "ForgotPassword", 5, 1);
            homeService.goToBaseURL();
            homeService.clickLoginButton();
            homeService.goToForgotPassword();
            homeService.verifyForgotPasswordTitle();
            homeService.inputEmailForgotPassword(invalidEmailAddress);
            homeService.clickOnRequestResetLinkBTN();
            homeService.verifyColorEmailForgotPasswordTextBox("border-color","rgb(253, 109, 71)");
            homeService.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
            homeService.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
            homeService.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
            homeService.verifyContentEmailForgotPasswordMessage("The email does not exist!");
            /*webDriver.navigate().refresh();

            NXGReports.addStep("Open login modal", LogAs.PASSED, null);
            loginPO = homePO.getHeaderPage().openLoginModal().get();

            NXGReports.addStep("Open forgot password modal", LogAs.PASSED, null);
            forgotPassModalPO = loginPO.navigateToForgotPassword().get();

            NXGReports.addStep("Enter email is invalid.", LogAs.PASSED, null);
            String invalidEmailAddress = ExcelHelper.readExcelData(testData, "ForgotPassword", 5, 1);

            NXGReports.addStep("Enter a invalid email address.", LogAs.PASSED, null);
            forgotPassModalPO.getEleEmail().sendKeys(invalidEmailAddress);

            NXGReports.addStep("Click Reset password button.", LogAs.PASSED, null);
            forgotPassModalPO.getEleRequestResetLink().click();

            //Verify expected result
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "border-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BORDER_COLOR_ERROR"));
            homePO.verifyCssValue(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-color", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "BACKGROUND_COLOR_ERROR"));

            homePO.getValueCssOfBeforeElement(homePO.getHeaderPage().getForgotPassModalPO().getEleEmail(), "background-image", PropertiesHelper.getConfigValue(PROPERTIES_DATA, "URL_IMAGE_WARNING"));
            homePO.validateElememt(homePO.getHeaderPage().getForgotPassModalPO().getEleErrorMessage(), "Error message", AbstractPage.Element_Type.DISPLAYED);*/
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with email is not exist: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Forgot password with email is not exist: FAILED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
