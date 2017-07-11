package com.auvenir.ui.dataprovider;

import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by doai.tran on 7/10/2017.
 */
public class SmokeDataProvider {
    public static final String FRENCH_LANGUAGE = "French";

    @DataProvider(name = "verifyAdminLogin")
    public static Object[][] getVerifyAdminLogin(){
        String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");

        Object[][] arrayData = new Object[][]{{adminId,adminPassword}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId,adminPassword}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifySignUpAuditorUser")
    public static Object[][] getVerifySignUpAuditorUser(){
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String strFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Lead Name");
        String strRoleFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Role in Firm", "Valid Value");
        String strPhone = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Auditor", "Valid Value");
        String strReference = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Reference to Auvenir", "Valid Value");
        // firm information
        String strName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Name", "Valid Value");
        String strPreName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Previous Name", "Valid Value");
        String strWebsite = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Website", "Valid Value");
        String strStreetAddress = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Street Address", "Valid Value");
        String strOffNum = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Suite / Office Number", "Valid Value");
        String strZipCode = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Postal Code/ Zip Code", "Valid Value");
        String strCity = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "City", "Valid Value");
        String strCountry = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Country", "Valid Value");
        String strState = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Province / State", "Valid Value");
        String strMemberID = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D", "Valid Value");
        String strNumEmp = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Number of Employee", "Valid Value");
        String strPhoneFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Firm", "Valid Value");
        String strAffName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Affiliated Firm's Name", "Valid Value");
        String strPathLogo = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Path Logo", "Valid Value");

        Object[][] arrayData = new Object[][]{{emailCreate,strFullName, strRoleFirm, strPhone, strReference,
                                               strName, strPreName, strWebsite, strStreetAddress, strOffNum,
                                               strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp,
                                               strPhoneFirm, strAffName, strPathLogo}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailCreate,strFullName, strRoleFirm, strPhone, strReference,
                                        strName, strPreName, strWebsite, strStreetAddress, strOffNum,
                                        strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp,
                                        strPhoneFirm, strAffName, strPathLogo}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminChangeStatusUserToOnBoarding")
    public static Object[][] getVerifyAdminChangeStatusUserToOnBoarding(){
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String adminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
        String gmailAuditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Email Password");
        String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");

        Object[][] arrayData = new Object[][] {{emailCreate,adminEmail,gmailAuditorPassword,strAdminPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{emailCreate,adminEmail,gmailAuditorPassword,strAdminPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorLoginGmailAndActiveUser")
    public static Object[][] getVerifyAuditorLoginGmailAndActiveUser(){
        String gmailAuditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Email Password");
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");

        Object[][] arrayData = new Object[][] {{gmailAuditorPassword,emailCreate, auditorPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{gmailAuditorPassword,emailCreate, auditorPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLoginAuditorUser")
    public static Object[][] getVerifyLoginAuditorUser(){
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");

        Object[][] arrayData = new Object[][] {{emailCreate, auditorPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{emailCreate, auditorPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyCreateSimpleEngagement")
    public static Object[][] getVerifyCreateSimpleEngagement(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        Object[][] arrayData = new Object[][] {{auditorId, auditorPassword, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{auditorId, auditorPassword, engagementName}};
        }
        return arrayData;
    }
}
