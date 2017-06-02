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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuong.nguyen on 4/21/2017.
 */
public class AuditorFirmInvalidTest extends AbstractTest {

    private MarketingService homeService;
    private PersonalService personalService;
    private FirmService firmService;
    private SecurityService securityService;
    private SuccessService successService;

    // personal information
    String strFullName = GenericService.readExcelData(testData, "OnBoarding", 1, 1);
    String strEmail =  GenericService.readExcelData(testData, "OnBoarding", 1, 2);
    String strRoleFirm = GenericService.readExcelData(testData, "OnBoarding", 1, 3);
    String strPhone = GenericService.readExcelData(testData, "OnBoarding", 1, 4);
    String strReference = GenericService.readExcelData(testData, "OnBoarding", 1, 5);


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
        //Create List Invalid Data for Firm Name Text Box.
        List<String> firmNameInvalidDataList = new ArrayList<>();
        for(int i = 2 ; i < 5; i++)
        {
            firmNameInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 6));
        }
    }


    @Test(priority = 5, enabled = true, description = "Verify name are highlight when name with one Blank")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyNameWithBlank(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoFirmNameTextBox(GenericService.readExcelData(testData, "OnBoarding", 2, 6));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFirmNameTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFirmNameTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify name are highlight when name with one Blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify name are highlight when name with one Blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    @Test(priority = 6,enabled = true, description = "Verify name are highlight when name with two spaces in character")
    //Fail : because current code set border-color is : rgb(230, 123, 99), expected is : rgb(253, 109, 71)
    public void verifyNameWithTwoSpaceInCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoFirmNameTextBox(GenericService.readExcelData(testData, "OnBoarding", 3, 6));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFirmNameTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFirmNameTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Thread.sleep(10000);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify name are highlight when name with two spaces in character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify name are highlight when name with two spaces in character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 7,enabled = true,description = "Verify name are highlight when name with one blank and character")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyNameWithSpecialCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoFirmNameTextBox(GenericService.readExcelData(testData, "OnBoarding", 4, 6));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFirmNameTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFirmNameTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify name are highlight when name with one blank and character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify name are highlight when name with one blank and character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 8,enabled = true, description = "Verify previous name are highlight when name with blank")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyPreviousNameWithBlank(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnChangedNameCheckBox();
            firmService.inputValueIntoPreviousFirmNameTextBox(GenericService.readExcelData(testData, "OnBoarding", 2, 7));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorPreFirmNameTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorPreFirmNameTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify previous name are highlight when name with blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify previous name are highlight when name with blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 9,enabled = true, description = "Verify previous name are highlight when name with two space in character")
    public void verifyPreNameWithTwoSpaceInCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnChangedNameCheckBox();
            firmService.inputValueIntoPreviousFirmNameTextBox(GenericService.readExcelData(testData, "OnBoarding", 3, 7));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorPreFirmNameTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorPreFirmNameTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify previous name are highlight when name with two space in character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify previous name are highlight when name with two space in character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        //Create List Invalid Data for AffFirm Text Box.
        List<String> affFirmInvalidDataList = new ArrayList<>();
        for(int i = 2 ; i < 5; i++)
        {
            affFirmInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 17));
        }

    @Test(priority = 10,enabled = true, description = "Verify previous name are highlight when name with special character")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyPreviousNameWithSpecialCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.setPrefixProtocol("http://");
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
//            Verify input valid Value on Firm name: with one Blank, two spaces in character, with one blank and character"
            firmService.verifyInputValidValueOnFirmNameTextBox(firmNameInvalidDataList);
//            Verify input valid Value on Previous name: with one Blank, two spaces in character and special character"
            firmService.clickOnChangedNameCheckBox();
            firmService.inputValueIntoPreviousFirmNameTextBox(GenericService.readExcelData(testData, "OnBoarding", 4, 7));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorPreFirmNameTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorPreFirmNameTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify previous name are highlight when name with special character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify previous name are highlight when name with special character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 11,enabled = true, description = "Verify website are highlight when input with blank")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyWebsiteWithBlank(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoFirmWebsiteTextBox(GenericService.readExcelData(testData, "OnBoarding", 2, 8));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFirmWebsiteTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFirmWebsiteTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify website are highlight when input with blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify website are highlight when input with blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 12,enabled = true, description = "Verify website are highlight when input with space before character ")
    //Fail : because current code set border-color is : rgb(230, 123, 99), expected is : rgb(253, 109, 71)
    public void verifyWebsiteWithSpaceBeforeCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoFirmWebsiteTextBox(GenericService.readExcelData(testData, "OnBoarding", 3, 8));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFirmWebsiteTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFirmWebsiteTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify website are highlight when input with space before character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify website are highlight when input with space before character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 13,enabled = true, description = "Verify website are highlight when input with invalid format")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyWebsiteWithInvalidFormat(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoFirmWebsiteTextBox(GenericService.readExcelData(testData, "OnBoarding", 4, 8));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFirmWebsiteTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFirmWebsiteTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify website are highlight when input with invalid format: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify website are highlight when input with invalid format: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 14, enabled = true, description = "Verify website are highlight when input with special character")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyWebsiteWithSpecialCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoFirmWebsiteTextBox(GenericService.readExcelData(testData, "OnBoarding", 5, 8));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFirmWebsiteTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFirmWebsiteTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify website are highlight when input with special character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify website are highlight when input with special character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /*@Test(priority = 15,enabled = true, description = "Verify full address are highlight when input with blank")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyFullAddressWithBlank(){
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnChangedNameCheckBox();
            firmService.inputValueIntoFullAddressTextBox(GenericService.readExcelData(testData, "OnBoarding", 2, 9));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFullAddressTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFullAddressTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify full address are highlight when name with blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify full address are highlight when name with blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 16,enabled = false, description = "Verify full address are highlight when input with two special character ")
    //Fail : because current code set border-color is : rgb(230, 123, 99), expected is : rgb(253, 109, 71)
    public void verifyFullAdrressWithTwoSpecialCharacter(){
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnChangedNameCheckBox();
            firmService.inputValueIntoFullAddressTextBox(GenericService.readExcelData(testData, "OnBoarding", 3, 9));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFullAddressTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFullAddressTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify full address are highlight when input with two special character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify full address are highlight when input with two special character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 17,enabled = false, description = "Verify full address are highlight when input with one character and one specical character")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyFullAddressWithOneCharacterOneSpecialCharacter(){
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnChangedNameCheckBox();
            firmService.inputValueIntoFullAddressTextBox(GenericService.readExcelData(testData, "OnBoarding", 4, 9));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFullAddressTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFullAddressTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify full address are highlight when input with one character and one specical character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify full address are highlight when input with one character and one specical character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 18, enabled = false, description = "Verify full address are highlight when input with one number and one special character")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyFullAddressWithOneNumberOnSpecialCharacter(){
        homeService = new HomeService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnChangedNameCheckBox();
            firmService.inputValueIntoFullAddressTextBox(GenericService.readExcelData(testData, "OnBoarding", 5, 9));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorFullAddressTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorFullAddressTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify full address are highlight when input with one number and one special character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify full address are highlight when input with one number and one special character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }*/


    @Test(priority = 21,enabled = true, description = "Verify Zip Code are highlight when input with blank")
    //Fail : because current code set border-color is : rgb(251, 110, 73), expected is : rgb(253, 109, 71)
    public void verifyZipCodeWithBlank(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoZipCodeTextBox(GenericService.readExcelData(testData, "OnBoarding", 2, 11));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorZipCodeTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorZipCodeTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Zip Code are highlight when input with blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Zip Code are highlight when input with blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 22,enabled = true, description = "Verify Zip Code are highlight when input with five character")
    //Fail : because current code set border-color is : rgb(251, 110, 73), expected is : rgb(253, 109, 71)
    public void verifyZipCodeWithFiveCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoZipCodeTextBox(GenericService.readExcelData(testData, "OnBoarding", 3, 11));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorZipCodeTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorZipCodeTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Zip Code are highlight when input with five character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Zip Code are highlight when input with five character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 23,enabled = true, description = "Verify Zip Code are highlight when input with seventh character")
    //Fail : because current code set border-color is : rgb(251, 110, 73), expected is : rgb(253, 109, 71)
    public void verifyZipCodeWithSeventhCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoZipCodeTextBox(GenericService.readExcelData(testData, "OnBoarding", 4, 11));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorZipCodeTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorZipCodeTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Zip Code are highlight when input with seventh character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Zip Code are highlight when input with seventh character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 24,enabled = true, description = "Verify Zip Code are highlight when input with Number and Special Character")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyZipCodeWithNumberSpecialCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoZipCodeTextBox(GenericService.readExcelData(testData, "OnBoarding", 5, 11));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorZipCodeTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorZipCodeTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Zip Code are highlight when input with seventh character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Zip Code are highlight when input with seventh character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 25,enabled = true, description = "Verify Zip Code are highlight when input contains Special Character")
    //Fail : because current code set border-color is : rgb(251, 110, 73), expected is : rgb(253, 109, 71)
    public void verifyZipCodeContainsSpecialCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoZipCodeTextBox(GenericService.readExcelData(testData, "OnBoarding", 6, 11));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorZipCodeTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorZipCodeTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Zip Code are highlight when input contains Special Character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Zip Code are highlight when input contains Special Character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 29 , enabled = true, description = "Verify Member Id are highlight when input with Blank")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyMemberIDWithBlank(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoMemberIdTextBox(GenericService.readExcelData(testData, "OnBoarding", 2, 14));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorMemberIdTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorMemberIdTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Member Id are highlight when input with Blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Member Id are highlight when input with Blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 30,enabled = true, description = "Verify Member Id are highlight when input with Special Character")
    //Fail : because current code set border-color is : rgb(251, 110, 73), expected is : rgb(253, 109, 71)
    public void verifyMemberIDContainSpecialCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoMemberIdTextBox(GenericService.readExcelData(testData, "OnBoarding", 4, 14));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorMemberIdTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorMemberIdTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Member Id are highlight when input with Special Character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Member Id are highlight when input with Special Character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 31,enabled = true, description = "Verify Member Id are highlight when input with Space between Number")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyMemberIDContainSpaceBetweenNumber(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoMemberIdTextBox(GenericService.readExcelData(testData, "OnBoarding", 5, 14));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorMemberIdTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorMemberIdTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Member Id are highlight when input with Space between Number: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Member Id are highlight when input with Space between Number: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 32,enabled = true, description = "Verify Phone Number Id are highlight when input with Blank")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyPhoneNumberWithBlank(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoPhoneNumberIdTextBox(GenericService.readExcelData(testData, "OnBoarding", 2, 16));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorPhoneNumberIdTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorPhoneNumberIdTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Phone Number Id are highlight when input with Blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Phone Number Id are highlight when input with Blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 33,enabled = true,description = "Verify Phone Number Id are highlight when input with nine number")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyPhoneNumberWithNineNumber(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoPhoneNumberIdTextBox(GenericService.readExcelData(testData, "OnBoarding", 3, 16));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorPhoneNumberIdTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorPhoneNumberIdTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Phone Number Id are highlight when input with nine number: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Phone Number Id are highlight when input with nine number: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 35,enabled = true,description = "Verify Phone Number Id are highlight when input with Character")
    //Fail : because current code set border-color is : rgb(251, 110, 73), expected is : rgb(253, 109, 71)
    public void verifyPhoneNumberWithCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoPhoneNumberIdTextBox(GenericService.readExcelData(testData, "OnBoarding", 5, 16));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorPhoneNumberIdTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorPhoneNumberIdTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Phone Number Id are highlight when input with Character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Phone Number Id are highlight when input with Character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 36,enabled = true, description = "Verify Phone Number Id are highlight when input with special character")
    //Fail : because current code set border-color is : rgb(244, 114, 82), expected is : rgb(253, 109, 71)
    public void verifyPhoneNumberWithSpecialCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.inputValueIntoPhoneNumberIdTextBox(GenericService.readExcelData(testData, "OnBoarding", 6, 16));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorPhoneNumberIdTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorPhoneNumberIdTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Phone Number Id are highlight when input with special character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Phone Number Id are highlight when input with special character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 37,enabled = true, description = "Verify Affiliated Firm's Nam are highlight when input with blank")
    //Fail : because current code set border-color is : rgb(251, 110, 73), expected is : rgb(253, 109, 71)
    public void verifyAffFirmWithBlank(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnAllFirmCheckBox();
            firmService.verifyInputValidValueOnAffFirmTextBox(affFirmInvalidDataList);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify firm sign up page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify firm sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 38,enabled = true, description = "Affiliated Firm's Name with 2 Space in character")
    public void verifyAffFirmWithTwoSpaceInCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnAllFirmCheckBox();
            firmService.inputValueIntoAffiliatedFirmNameTextBox(GenericService.readExcelData(testData, "OnBoarding", 3, 17));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorAffFirmTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorAffFirmTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Affiliated Firm's Nam are highlight when input with blank: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Affiliated Firm's Nam are highlight when input with blank: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 39,enabled = true, description = "Verify Affiliated Firm's Nam are highlight when input with Special Character")
    //Fail : because current code set border-color is : rgb(251, 110, 73), expected is : rgb(253, 109, 71)
    public void verifyAffFirmContainSpecialCharacter(){
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        firmService = new FirmService(getLogger(),getDriver());
        try {
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            firmService.verifyFirmSignUpPage();
            firmService.clickOnAllFirmCheckBox();
            firmService.inputValueIntoAffiliatedFirmNameTextBox(GenericService.readExcelData(testData, "OnBoarding", 4, 17));
            firmService.clickOnRuleLogoCheckBox();
            firmService.verifyColorAffFirmTextBox("border-color","rgb(253, 109, 71)");
            firmService.verifyColorAffFirmTextBox("background-color","rgba(241, 103, 57, 0.2)");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Affiliated Firm's Nam are highlight when input with Special Character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Affiliated Firm's Nam are highlight when input with Special Character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
