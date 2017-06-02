package com.auvenir.ui.tests.auditor.onboarding;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.marketing.signup.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thuan.duong on 6/2/2017.
 */
public class AuditorSignUpTest extends AbstractTest {
    private AuditorSignUpService auditorSignUpService;

    // personal information
    String strFullName = GenericService.readExcelData(testData, "OnBoarding", 1, 1);
    String strEmail = GenericService.readExcelData(testData, "OnBoarding", 1, 2);
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


    @Test(priority = 1, enabled = true, description = "Verify Firm sign up page and Input Invalid Test.")
    public void verifyAuditorFirmInputInvalidValue() {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        //Create List Invalid Data for Firm Name Text Box.
        List<String> firmNameInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            firmNameInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 6));
        }
        //Create List Invalid Data for Previous Firm Name Text Box.
        List<String> preFirmNameInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            preFirmNameInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 7));
        }
        //Create List Invalid Data for Firm Website Text Box.
        List<String> firmWebsiteInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 6; i++) {
            firmWebsiteInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 8));
        }
        //Create List Invalid Data for Zip Code Text Box.
        List<String> zipCodeInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 7; i++) {
            zipCodeInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 11));
        }
        //Create List Invalid Data for Member Id Text Box.
        List<String> memberIdInvalidDataList = new ArrayList<>();
        memberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", 2, 14));
        for (int i = 4; i < 6; i++) {
            memberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 14));
        }
        //Create List Invalid Data for Member Id Text Box.
        List<String> phoneNumberIdInvalidDataList = new ArrayList<>();
        phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", 2, 16));
        phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", 3, 16));
        for (int i = 5; i < 7; i++) {
            phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 16));
        }
        //Create List Invalid Data for AffFirm Text Box.
        List<String> affFirmInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            affFirmInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 17));
        }

        try {
            auditorSignUpService.deleteUserUsingApi(strEmail);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), "bb@gmail.com");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
//            Verify input valid Value on Firm name: with one Blank, two spaces in character, with one blank and character"
            auditorSignUpService.verifyInputValidValueOnFirmNameTextBox(firmNameInvalidDataList);
//            Verify input valid Value on Previous name: with one Blank, two spaces in character and special character"
            auditorSignUpService.clickOnChangedNameCheckBox();
            auditorSignUpService.verifyInputValidValueOnPreFirmNameTextBox(preFirmNameInvalidDataList);
//            Verify input valid Value on Website Textbox: with one Blank, space before character, invalid format, special character"
            auditorSignUpService.verifyInputValidValueOnFirmWebsiteTextBox(firmWebsiteInvalidDataList);
//            Verify input valid Value on Zip Code: with one Blank, five character, seventh character, with Number and Special Character, Special Character
            auditorSignUpService.verifyInputValidValueOnZipCodeTextBox(zipCodeInvalidDataList);
//            Verify input valid Value on Member Id: with one Blank, with Special Character, with Space between Number
            auditorSignUpService.verifyInputValidValueOnMemberIdTextBox(memberIdInvalidDataList);
//            Verify input valid Value on Phone Number Id: with one Blank, with nine number, with Character, with special character
            auditorSignUpService.verifyInputValidValueOnPhoneNumberIdTextBox(phoneNumberIdInvalidDataList);
//            Verify input valid Value Affiliated Firm's Name: with one Blank, with 2 Space in character, with Special Character
            auditorSignUpService.clickOnAllFirmCheckBox();
            auditorSignUpService.verifyInputValidValueOnAffFirmTextBox(affFirmInvalidDataList);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("Verify firm sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = false, description = "Verify Register Auditor User")
    public void verifyRegisterAuditorUser() {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        try {
            auditorSignUpService.deleteUserUsingApi(strEmail);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), "bb@gmail.com");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
            auditorSignUpService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo);
            auditorSignUpService.verifySecuritySignUpPage();
            auditorSignUpService.createPassword(strPassword, strPassword);
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
