package com.auvenir.ui.tests.auditor.onboarding;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.emailtemplate.EmailTemplateService;
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
//    String strEmail = "thuan.duong@titancorpvn.com";
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

    private MarketingService marketingService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;

    final String fullNameCreate = "Test Login Auditor";
//        final String fullNameCreate = "Minh Nguyen";
    final String strEmailCreate = GenericService.readExcelData(testData, "Login", 1, 1);
//        final String strEmailCreate = "ff.minhtest@gmail.com";
    final String passwordCreate = GenericService.readExcelData(testData, "Login", 1, 2);

    String strAdminEmail = GenericService.readExcelData(testData, "Login", 1, 3);
    String strAdminPwd = GenericService.readExcelData(testData, "Login", 1, 4);

    private String emailId = null;
    private String emailPassword = null;
    private EmailTemplateService emailTemplateService;
    private AuditorEngagementService auditorEngagementService;


    @Test(priority = 1, enabled = true, description = "Verify Firm sign up page and Input Invalid Test.")
    public void verifyAuditorFirmInputInvalidValue() throws Exception {
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
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), strEmail);
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
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Verify firm sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify Register Auditor User")
    public void verifyRegisterAuditorUser() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        try {
            auditorSignUpService.deleteUserUsingApi(strEmail);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), strEmail);
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
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify Personal sign up page and Input Invalid Test.")
    public void verifyAuditorPersonalInputInvalidValue() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        //Create List Invalid Data for First Last Name Text Box.
        List<String> firstLastNameInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            firstLastNameInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 1));
        }
        List<String> emailInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 6; i++) {
            emailInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 2));
        }
        final String confirmemailInvalidData = "test";
        List<String> phoneInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 4; i++) {
            phoneInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 4));
        }
        for (int i = 5; i < 7; i++) {
            phoneInvalidDataList.add(GenericService.readExcelData(testData, "OnBoarding", i, 4));
        }
        try {
            auditorSignUpService.deleteUserUsingApi(strEmail);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), strEmail);
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
//            Verify input valid Value on Full Name Text box: with one character, only two blank, with one character and one blank, two spaces in character, one special Characters, with number"
            auditorSignUpService.verifyInputValidValueOnFullNameTxtBox(firstLastNameInvalidDataList);
//            Verify input valid Value on Email Text box: with one character, input blank, input invalid format Name, input invalid format Style
            auditorSignUpService.verifyInputValidValueOnEmailTxtBox(emailInvalidDataList);
//            Verify input valid Value on Confirm Email Text box: with invalid value"
            auditorSignUpService.inputValueIntoEmailTextBox(strEmail);
            auditorSignUpService.verifyInputValidValueOnConfirmEmailTxtBox(confirmemailInvalidData);
//            Verify input valid Value on Phone Number Text box: with blank, with 9 number, with character, with Special Character
            auditorSignUpService.verifyInputValidValueOnPhoneNumberTxtBox(phoneInvalidDataList);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Full Name are highlight when input only with 1 character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Full Name are highlight when input only with 1 character: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify GUI when input password random blank")
    public void verifyAuditorSecurityInputInvalidPassword() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        final String blankPassword = "";
        final String invalidLengthPassword = "aA12345";
        final String noUpperCasePassword = "abc1234d";
        final String noLowerCasePassword = "1234ABCD";
        final String noDigitsPassword =  "abcdABCD";
        final String noCharPassword = "12345678";
        final String successPassword = "12345678X";
        final String confirmPassword = "1";
        try {
            auditorSignUpService.deleteUserUsingApi(strEmail);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), strEmail);
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
            auditorSignUpService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo);
            auditorSignUpService.verifySecuritySignUpPage();
            auditorSignUpService.verifyCreateInvalidPassword(blankPassword, false, false, false);
            auditorSignUpService.verifyCreateInvalidPassword(invalidLengthPassword, true, true, true);
            auditorSignUpService.verifyCreateInvalidPassword(noUpperCasePassword, false, true, true);
            auditorSignUpService.verifyCreateInvalidPassword(noLowerCasePassword, true, true, true);
            auditorSignUpService.verifyCreateInvalidPassword(noDigitsPassword, true, true, false);
            auditorSignUpService.verifyCreateInvalidPassword(noCharPassword, false, false, true);
            auditorSignUpService.inputValueIntoPaswordInput(successPassword);
            auditorSignUpService.verifyInputWrongConfirmPassword(confirmPassword);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input password random have invalid length: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Verify GUI when input password random have invalid length: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 5,enabled = true, description = "Test positive tests case login and logout")
    public void createAndActiveAuditorUser() throws Exception {
        try {
            auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
            marketingService = new MarketingService(getLogger(),getDriver());
            adminService = new AdminService(getLogger(), getDriver());
            gmailLoginService = new GmailLoginService(getLogger(), getDriver());
            emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
            auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            auditorSignUpService.setPrefixProtocol(httpProtocol);
            auditorSignUpService.deleteUserUsingApi(strEmailCreate);
            auditorSignUpService.deleteUserUsingMongoDB(strEmailCreate);

            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser(fullNameCreate, strEmailCreate, passwordCreate);
//            auditorSignUpService.verifyRegisterNewAuditorUser("ADMIN AUVENIR", "admin@auvenir.com", "Changeit@123");

            gmailLoginService.deleteAllExistedEmail(strEmailCreate, passwordCreate);
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
            adminService.changeTheStatusAuditorToOnBoarding(strEmailCreate, "Onboarding");
            getLogger().info("Auditor open Email and verify it.. ");
            getLogger().info("Auditor login his email to verify Welcome email template");
            gmailLoginService.gmailReLogin(passwordCreate);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyActiveEmailTemplateContent();
            emailTemplateService.clickGetStartedButton();
            emailTemplateService.switchToWindow();
            auditorSignUpService.confirmInfomationNewAuditorUser(fullNameCreate, strEmailCreate, passwordCreate);
            auditorEngagementService.verifyAuditorEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test Create And Active Auditor User: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Test Create And Active Auditor User: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
