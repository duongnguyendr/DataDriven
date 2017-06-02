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
 * Created by cuong.nguyen on 4/12/2017.
 */
public class AuditorOnBoardingTest extends AbstractTest {

    private MarketingService homeService;
    PersonalService personalService;
    FirmService firmService;
    SecurityService securityService;
    SuccessService successService;

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
    // security information
    String strPassword = GenericService.readExcelData(testData, "OnBoarding", 1, 19);



    @Test(priority = 1,enabled = true, description = "Verify open home page")
    public void openHomePage() {
        homeService = new MarketingService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Open home page successful: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Open home page successful: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2,enabled = true, description = "Verify open sign up page")
    public void verifyAuditorPersonalPageContent() {
        homeService = new MarketingService(getLogger(),getDriver());
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

    @Test(priority = 3, enabled = true, description = "Input information auditor personal")
    public void inputInformationPersonalAuditor() {
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
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
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
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
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
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
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
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


    @Test(priority = 7,enabled = false,description = "Input information security sign up page")
    public void createAuditorPassword() {
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());

        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            securityService.createPassword( strPassword,strPassword);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information security sign up page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Input information security sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 8, enabled = false, description = "Verify success sign up page")
    public void verifySuccessPageContent() {
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        securityService = new SecurityService(getLogger(),getDriver());
        successService = new SuccessService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhoneFirm,  strAffName,  strPathLogo);
            securityService.verifySecuritySignUpPage();
            securityService.createPassword( strPassword,strPassword);
            successService.verifySuccessSignUpPage();
            successService.acceptCreateAccountAuditor();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify success sign up page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify success sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


}
