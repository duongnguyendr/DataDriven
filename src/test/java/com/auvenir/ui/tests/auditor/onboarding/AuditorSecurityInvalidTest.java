package com.auvenir.ui.tests.auditor.onboarding;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.signup.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/24/2017.
 */
public class AuditorSecurityInvalidTest extends AbstractTest {

    private MarketingService marketingService;
    PersonalService personalService;
    AuditorSignUpService firmService;
    SecurityService securityService;

    // personal information
    String strFullName = GenericService.readExcelData(testData, "OnBoarding", 1, 1);
    String strEmail =  GenericService.readExcelData(testData, "OnBoarding", 1, 2);
    String strRoleFirm = GenericService.readExcelData(testData, "OnBoarding", 1, 3);
    String strPhone = GenericService.readExcelData(testData, "OnBoarding", 1, 4);
    String strReference = GenericService.readExcelData(testData, "OnBoarding", 1, 5);
    // firm information
    String strName = GenericService.readExcelData(testData, "OnBoarding", 1, 6);
    String strPreName = GenericService.readExcelData(testData, "OnBoarding", 1, 7);
    String strWebsite = GenericService.readExcelData(testData, "OnBoarding", 1, 8);
    String strStreetAddr = GenericService.readExcelData(testData, "OnBoarding", 1, 9);
    String strOffNum = GenericService.readExcelData(testData, "OnBoarding", 1, 10);
    String strZipCode = GenericService.readExcelData(testData, "OnBoarding", 1, 11);
    String strCity = GenericService.readExcelData(testData, "OnBoarding", 1, 12);
    String strState = GenericService.readExcelData(testData, "OnBoarding", 1, 13);
    String strMemberID = GenericService.readExcelData(testData, "OnBoarding", 1, 14);
    String strNumEmp = GenericService.readExcelData(testData, "OnBoarding", 1, 15);
    String strPhoneFirm = GenericService.readExcelData(testData, "OnBoarding", 1, 16);
    String strAffName = GenericService.readExcelData(testData, "OnBoarding", 1, 17);
    String strPathLogo = GenericService.readExcelData(testData, "OnBoarding", 1, 18);

    @Test(priority = 1,enabled = true, description = "Verify open home page")
    public void openHomePage() {
        marketingService = new MarketingService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Open home page successful: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Open home page successful: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2,enabled = true, description = "Verify open sign up page")
    public void verifyAuditorPersonalPageContent() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Open sign up page successful: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Open sign up page successful: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 3, enabled = true, description = "Input information auditor personal")
    public void inputInformationPersonalAuditor() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information auditor personal successful: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Input information auditor personal successful: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 4,enabled = true,description = "Verify firm sign up page")
    public void verifyAuditorFirmPageContent() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify firm sign up page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify firm sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 5,enabled = true, description = "Input information firm sign up pgae")
    public void registerFirmAuditor() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 6,enabled = true,description = "Verify security sign up page")
    public void verifySecurityPageContent() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify security sign up page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify security sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 7,enabled = true,description = "Verify GUI when input password random blank")
    public void verifyGUIWhenInputRandomPasswordBlank() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            marketingService.setPrefixProtocol("http://");
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            String ranPassword = "";
            securityService.inputValueIntoPaswordInput(ranPassword);
            securityService.verifyCreatePasswordPopupWarning(ranPassword.length(), false, false, false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input password random have invalid length: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI when input password random have invalid length: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 8,enabled = true,description = "Verify GUI when input password random have invalid length")
    public void verifyGUIWhenInputRandomPasswordInValidLength() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            String ranPassword = "aA12345";
            securityService.inputValueIntoPaswordInput(ranPassword);
            securityService.verifyCreatePasswordPopupWarning(ranPassword.length(), true, true, true);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input password random have invalid length: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI when input password random have invalid length: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 9,enabled = true,description = "Verify GUI when input random password not contain upper case")
    public void verifyGUIWhenInputRandomPasswordNotContaintUpperCase() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            String ranPassword = "abc1234d";
            securityService.inputValueIntoPaswordInput(ranPassword);
            securityService.verifyCreatePasswordPopupWarning(ranPassword.length(), false, true, true);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input password random not contain upper character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI when input password random not contain upper character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 10,enabled = true,description = "Verify GUI when input random password not contain lower character")
    public void verifyGUIWhenInputRandomPasswordNotContainLowerCharacter() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            String ranPassword = "1234ABCD";
            securityService.inputValueIntoPaswordInput(ranPassword);
            securityService.verifyCreatePasswordPopupWarning(ranPassword.length(), true, false, true);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input password random not contain lower character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI when input password random not contain lower character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 11,enabled = true,description = "Verify GUI when input random password not contain digits")
    public void verifyGUIWhenInputRandomPasswordNotContainDigits() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            String ranPassword = "abcdABCD";
            securityService.inputValueIntoPaswordInput(ranPassword);
            securityService.verifyCreatePasswordPopupWarning(ranPassword.length(), true, true, false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input password random not contain digits: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI when input password random not contain digits: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 12,enabled = true,description = "Verify GUI when input random password not contain character")
    public void verifyGUIWhenInputRandomPasswordNotContainCharacter() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            String ranPassword = "12345678";
            securityService.inputValueIntoPaswordInput(ranPassword);
            securityService.verifyCreatePasswordPopupWarning(ranPassword.length(), false, false, true);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input password random not contain character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI when input password random not contain character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 13,enabled = true,description = "Verify GUI when input confirm password invalid")
    public void verifyConfirmPasswordWithInvalid() {
        marketingService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new AuditorSignUpService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            String ranPassword = "12345678X";
            securityService.inputValueIntoPaswordInput(ranPassword);
            String confirmPassword = "1";
            securityService.inputValueIntoConfirmPaswordInput(confirmPassword);
            securityService.verifyConfirmPasswordPopupWarning();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input confirm password invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI when input confirm password invalid: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}
