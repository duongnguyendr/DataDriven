package com.auvenir.ui.dataprovider.admin;

import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

/**
 * Created by thuan.duong on 7/7/2017.
 */
public class AdminDataProvider {

    private static String superAdminId;
    private static String superAdminPwd;
    private static String superAdminFullName;
    private static String superAdminPhoneNum;
    private static String normalAdminId;
    private static String normalAdminPwd;
    private static String normalAdminFullName;
    private static String normalAdminPhoneNum;
    private static String clientEmail;
    private static String auditorEmail;
    private static String onboardingStatus;
    private static String waitListedStatus;
    private static String activeStatus;
    private static String inactiveStatus;

    @DataProvider(name = "verifyGUISuperAdminHomePage")
    public static Object[][] getverifyGUISuperAdminHomePage() {
        superAdminId = GenericService.getTestDataFromExcel("SuperAdminTest", "Super Admin Email", "Valid Value");
        superAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Password", "Valid Value");
        superAdminFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Name", "Valid Value");
        superAdminPhoneNum = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Phone", "Valid Value");
        normalAdminId = GenericService.getTestDataFromExcel("SuperAdminTest", "Normal Admin Email", "Valid Value");
        normalAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Password", "Valid Value");
        normalAdminFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Name", "Valid Value");
        normalAdminPhoneNum = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Phone", "Valid Value");
        clientEmail = GenericService.getTestDataFromExcel("SuperAdminTest", "Client Email", "Valid Value");
        auditorEmail = GenericService.getTestDataFromExcel("SuperAdminTest", "Auditor Email", "Valid Value");
        onboardingStatus = "Onboarding";
        waitListedStatus = "Wait Listed";
        activeStatus = "Active";
        inactiveStatus = "Inactive";
        System.out.println("Prefix: " + superAdminId);
        Object[][] arrayData = new Object[][]{{superAdminId, superAdminPwd, superAdminFullName, superAdminPhoneNum, normalAdminId
                , clientEmail, auditorEmail, onboardingStatus, waitListedStatus, activeStatus, inactiveStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {superAdminId, superAdminPwd, superAdminFullName, superAdminPhoneNum, normalAdminId,
                            normalAdminPwd, normalAdminFullName, normalAdminPhoneNum, clientEmail, auditorEmail, onboardingStatus, waitListedStatus, activeStatus, inactiveStatus}
            };
        }
        return arrayData;
    }
}
