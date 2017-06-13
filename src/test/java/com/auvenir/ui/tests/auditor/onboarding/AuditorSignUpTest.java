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

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thuan.duong on 6/2/2017.
 */
public class AuditorSignUpTest extends AbstractTest {
    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;
    private EmailTemplateService emailTemplateService;
    private AuditorEngagementService auditorEngagementService;

    // personal information
    final String strFullName = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 1);
    //    String strEmail = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 2);
    //    String strEmail = "thuan.duong@titancorpvn.com";
    final String strRoleFirm = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 3);
    final String strPhone = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 4);
    final String strReference = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 5);
    // firm information
    final String strName = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 6);
    final String strPreName = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 7);
    final String strWebsite = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 8);
    final String strStreetAddr = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 9);
    final String strOffNum = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 10);
    final String strZipCode = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 11);
    final String strCity = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 12);
    final String strState = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 13);
    final String strMemberID = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 14);
    final String strNumEmp = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 15);
    final String strPhoneFirm = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 16);
    final String strAffName = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 17);
    final String strPathLogo = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 18);
    // security information
    final String strPassword = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 19);



//    final String fullNameCreate = "Test Login Auditor";
//        final String fullNameCreate = "Minh Nguyen";
//    final String emailCreate = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 1);
     //        final String emailCreate = "ff.minhtest@gmail.com";
    final String passwordCreate = GenericService.readExcelData(testData, "AuditorSignUpTest", 1, 22);


    final String strAdminEmail = GenericService.readExcelData(testData, "Login", 1, 3);
    final String strAdminPwd = GenericService.readExcelData(testData, "Login", 1, 4);

    @Test(priority = 1, enabled = true, description = "Verify Register and Active Auditor User")
    public void verifyRegisterAndActiveAuditorUser() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        final String emailCreate = GenericService.getUserFromExcelData("AuditorSignUpTest", "AUDITOR_USER_ID", "Valid Value");
        try {
            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            System.out.println("emailCreate: " + emailCreate);
            auditorSignUpService.deleteUserUsingApi(emailCreate);
            auditorSignUpService.deleteUserUsingMongoDB(emailCreate);

            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, emailCreate, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
            auditorSignUpService.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo);
            auditorSignUpService.verifySecuritySignUpPage();
            auditorSignUpService.createPassword(passwordCreate, "");
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();
            gmailLoginService.deleteAllExistedEmail(emailCreate, passwordCreate);
            marketingService.setPrefixProtocol(httpProtocol);
            marketingService.goToBaseURL();
            marketingService.clickLoginButton();
            marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
            adminService.changeTheStatusAuditorToOnBoarding(emailCreate, "Onboarding");
            gmailLoginService.gmailReLogin(passwordCreate);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyActiveEmailTemplateContent();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();
            auditorSignUpService.confirmInfomationNewAuditorUser(strFullName, emailCreate, passwordCreate);
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify Firm sign up page and Input Invalid Test.")
    public void verifyAuditorFirmInputInvalidValue() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        final String strEmail = GenericService.getUserFromExcelData("AuditorSignUpTest", "Email Address", "Valid Value");
        //Create List Invalid Data for Firm Name Text Box.
        List<String> firmNameInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            firmNameInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 6));
        }
        //Create List Invalid Data for Previous Firm Name Text Box.
        List<String> preFirmNameInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            preFirmNameInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 7));
        }
        //Create List Invalid Data for Firm Website Text Box.
        List<String> firmWebsiteInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 6; i++) {
            firmWebsiteInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 8));
        }
        //Create List Invalid Data for Zip Code Text Box.
        List<String> zipCodeInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 7; i++) {
            zipCodeInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 11));
        }
        //Create List Invalid Data for Member Id Text Box.
        List<String> memberIdInvalidDataList = new ArrayList<>();
        memberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 14));
        for (int i = 4; i < 6; i++) {
            memberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 14));
        }
        //Create List Invalid Data for Member Id Text Box.
        List<String> phoneNumberIdInvalidDataList = new ArrayList<>();
        phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 16));
        phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", 3, 16));
        for (int i = 5; i < 7; i++) {
            phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 16));
        }
        //Create List Invalid Data for AffFirm Text Box.
        List<String> affFirmInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            affFirmInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 17));
        }

        try {
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

    @Test(priority = 3, enabled = true, description = "Verify Personal sign up page and Input Invalid Test.")
    public void verifyAuditorPersonalInputInvalidValue() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        final String strEmail = GenericService.getUserFromExcelData("AuditorSignUpTest", "Email Address", "Valid Value");
        //Create List Invalid Data for First Last Name Text Box.
        List<String> firstLastNameInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            firstLastNameInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 1));
        }
        List<String> emailInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 6; i++) {
            emailInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 2));
        }
        final String confirmemailInvalidData = "test";
        List<String> phoneInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 4; i++) {
            phoneInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 4));
        }
        for (int i = 5; i < 7; i++) {
            phoneInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 4));
        }
        try {
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
        final String strEmail = GenericService.getUserFromExcelData("AuditorSignUpTest", "Email Address", "Valid Value");
        final String blankPassword = GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 23);
        final String invalidLengthPassword = GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 24);
        final String noUpperCasePassword = GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 25);
        final String noLowerCasePassword = GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 26);
        final String noDigitsPassword =  GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 27);
        final String noCharPassword = GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 28);
        final String successPassword = GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 29);
        final String confirmPassword = GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 30);
        try {
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
}
