package com.auvenir.ui.tests.auditor.onboarding;

//import com.auvenir.utilities.PropertiesHelper;

import com.auvenir.ui.pages.marketing.HomePage;
import com.auvenir.ui.pages.onboarding.PersonalPO;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.signup.PersonalService;
import com.auvenir.ui.services.marketing.HomeService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/20/2017.
 */
public class AuditorPersonalInvalidTest extends AbstractTest {

    private HomePage home = null;
    private PersonalPO personal = null;

    private HomeService homeService;
    private PersonalService personalService;


    @Test(priority = 1, enabled = true, description = "Navigate to  Home Page")
    public void openHomePage() {
        homeService = new HomeService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Open home page successful: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Open home page successful: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = true, description = "Navigate to Auditor OnBoarding Page")
    public void verifyAuditorPersonalPageContent() {
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Open sign up page successful: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Open sign up page successful: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify GUI of full name when put one character.")
    public void verifyNameWithOneCharacter() {
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoFullNameTexBox(GenericService.readExcelData(testData, "OnBoarding", 2, 1));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorFullNameTxtBox("border-color","rgb(253, 109, 71)");
            personalService.verifyColorFullNameTxtBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Full Name are highlight when input only with 1 character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Full Name are highlight when input only with 1 character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify GUI of full name when input one character and one blank")
    public void verifyNameWithOneCharacterAndSpace() {
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoFullNameTexBox(GenericService.readExcelData(testData, "OnBoarding", 3, 1));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorFullNameTxtBox("border-color","rgb(253, 109, 71)");
            personalService.verifyColorFullNameTxtBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Full Name are highlight when input one character and one blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Full Name are highlight when input one character and one blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify GUI of full name when input only two blank")
    public void verifyNameWithTwoBlank() {
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoFullNameTexBox(GenericService.readExcelData(testData, "OnBoarding", 4, 1));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorFullNameTxtBox("border-color","rgb(253, 109, 71)");
            personalService.verifyColorFullNameTxtBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Full Name are highlight when input only two blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Full Name are highlight when input only two blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify GUI of full name when input two special Characters")
    public void verifyNameWithTwoSpecialCharacter() {
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoFullNameTexBox(GenericService.readExcelData(testData, "OnBoarding", 5, 1));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorFullNameTxtBox("border-color","rgb(253, 109, 71)");
            personalService.verifyColorFullNameTxtBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of full name when input two special Characters: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of full name when input two special Characters: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 7, enabled = true, description = "Verify GUI of full name when input one special Characters")
    public void verifyNameWithSpecialCharacter() {
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoFullNameTexBox(GenericService.readExcelData(testData, "OnBoarding", 6, 1));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorFullNameTxtBox("border-color","rgb(253, 109, 71)");
            personalService.verifyColorFullNameTxtBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of full name when input one special Characters: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of full name when input one special Characters: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 8, enabled = true, description = "Verify GUI of full name when input with number")
    public void verifyNameWithNumber() {
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoFullNameTexBox(GenericService.readExcelData(testData, "OnBoarding", 7, 1));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorFullNameTxtBox("border-color","rgb(253, 109, 71)");
            personalService.verifyColorFullNameTxtBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of full name when input with number: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of full name when input with number: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 9, enabled = true, description = "Verify GUI of email when input one character")
    public void verifyEmailWithOneCharacter() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoEmailTexBox(GenericService.readExcelData(testData, "OnBoarding", 2, 2));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorEmailTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorEmailTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of email when input with one character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of email when input with one character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 10, enabled = true, description = "Verify GUI of email when input blank")
    public void verifyEmailWithBlank() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoEmailTexBox(GenericService.readExcelData(testData, "OnBoarding", 3, 2));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorEmailTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorEmailTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of email when input with blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of email when input with blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 11, enabled = true, description = "Verify GUI of email when input invalid format Name")
    public void verifyEmailWithInvalidFormatName() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoEmailTexBox(GenericService.readExcelData(testData, "OnBoarding", 4, 2));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorEmailTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorEmailTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of email when input invalid format Name: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of email when input invalid format Name: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 12, enabled = true, description = "Verify GUI of email when input invalid format Style")
    public void verifyEmailWithInvalidFormatStyle() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoEmailTexBox(GenericService.readExcelData(testData, "OnBoarding", 5, 2));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorEmailTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorEmailTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of email when input invalid format Style: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of email when input invalid format Style: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 13, enabled = true, description = "Verify GUI of confirm email with invalid value")
    public void verifyConfirmEmailWithInvalidValue() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoEmailTexBox(GenericService.readExcelData(testData, "OnBoarding", 1, 2));
            personalService.inputValueIntoConfirmEmailTextBox("test");
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorConfirmEmailTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorConfirmEmailTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of confirm email with invalid value: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of confirm email with invalid value: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 14, enabled = true, description = "Verify GUI of phone with blank")
    public void verifyPhoneWithBlank() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoPhoneNumberTextBox(GenericService.readExcelData(testData, "OnBoarding", 2, 4));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorPhoneNumberTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorPhoneNumberTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Thread.sleep(10000);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of phone with blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of phone with blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 15, enabled = true, description = "Verify GUI of phone with 9 number")
    public void verifyPhoneNineNumber() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoPhoneNumberTextBox(GenericService.readExcelData(testData, "OnBoarding", 3, 4));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorPhoneNumberTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorPhoneNumberTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Thread.sleep(10000);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of phone with 9 number: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of phone with 9 number: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 16, enabled = true,description = "Verify GUI of phone with character")
    public void verifyPhoneWithCharacter() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoPhoneNumberTextBox(GenericService.readExcelData(testData, "OnBoarding", 5, 4));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorPhoneNumberTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorPhoneNumberTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Thread.sleep(10000);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of phone with character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of phone with character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify GUI of phone with Special Character")
    public void verifyPhoneWithSpecialCharacter() {
        homeService = new HomeService(getLogger(), getDriver());
        personalService = new PersonalService(getLogger(), getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.inputValueIntoPhoneNumberTextBox(GenericService.readExcelData(testData, "OnBoarding", 6, 4));
            personalService.clickOnCheckBoxConfirm();
            personalService.verifyColorPhoneNumberTxtBox("border-color", "rgb(253, 109, 71)");
            personalService.verifyColorPhoneNumberTxtBox("background-color", "rgba(241, 103, 57, 0.2)");
            Thread.sleep(10000);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of phone with special character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of phone with special character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


}