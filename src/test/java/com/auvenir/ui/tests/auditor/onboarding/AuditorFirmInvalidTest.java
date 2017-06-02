package com.auvenir.ui.tests.auditor.onboarding;

import com.auvenir.ui.services.AbstractService;
//import com.auvenir.ui.services.marketing.HomeService;
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
    private AuditorSignUpService auditorSignUpService;
    private SecurityService securityService;
    private SuccessService successService;

    // personal information
    String strFullName = GenericService.readExcelData(testData, "OnBoarding", 1, 1);
    String strEmail = GenericService.readExcelData(testData, "OnBoarding", 1, 2);
    String strRoleFirm = GenericService.readExcelData(testData, "OnBoarding", 1, 3);
    String strPhone = GenericService.readExcelData(testData, "OnBoarding", 1, 4);
    String strReference = GenericService.readExcelData(testData, "OnBoarding", 1, 5);

    @Test(priority = 1,enabled = false,description = "Verify firm sign up page and Input Invalid Test.")
    public void verifyAuditorFirmInputInvalidValue() {
        homeService = new MarketingService(getLogger(),getDriver());
        personalService = new PersonalService(getLogger(),getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(),getDriver());
        //Create List Invalid Data for Firm Name Text Box.
        List<String> firmNameInvalidDataList = new ArrayList<>();
        for(int i = 2 ; i < 5; i++)
        {
            firmNameInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 6));
        }
        //Create List Invalid Data for Previous Firm Name Text Box.
        List<String> preFirmNameInvalidDataList = new ArrayList<>();
        for(int i = 2 ; i < 5; i++)
        {
            preFirmNameInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 7));
        }
        //Create List Invalid Data for Firm Website Text Box.
        List<String> firmWebsiteInvalidDataList = new ArrayList<>();
        for(int i = 2 ; i < 6; i++)
        {
            firmWebsiteInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 8));
        }
        //Create List Invalid Data for Zip Code Text Box.
        List<String> zipCodeInvalidDataList = new ArrayList<>();
        for(int i = 2 ; i < 7; i++)
        {
            zipCodeInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 11));
        }
        //Create List Invalid Data for Member Id Text Box.
        List<String> memberIdInvalidDataList = new ArrayList<>();
        memberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", 2, 14));
        for(int i = 4 ; i < 6; i++)
        {
            memberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 14));
        }
        //Create List Invalid Data for Member Id Text Box.
        List<String> phoneNumberIdInvalidDataList = new ArrayList<>();
        phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", 2, 16));
        phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", 3, 16));
        for(int i = 5 ; i < 7; i++)
        {
            phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 16));
        }
        //Create List Invalid Data for AffFirm Text Box.
        List<String> affFirmInvalidDataList = new ArrayList<>();
        for(int i = 2 ; i < 5; i++)
        {
            affFirmInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 17));
        }

        try {
            homeService.setPrefixProtocol("http://");
            homeService.goToBaseURL();
            personalService.navigateToSignUpPage();
            personalService.verifyPersonalSignUpPage();
            personalService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
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
            NXGReports.addStep("Verify firm sign up page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify firm sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
