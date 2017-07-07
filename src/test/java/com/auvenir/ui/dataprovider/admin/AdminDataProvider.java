package com.auvenir.ui.dataprovider.admin;

import com.auvenir.utilities.GenericData;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by thuan.duong on 7/7/2017.
 */
public class AdminDataProvider {

    private static String superAdminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Email", "Valid Value");;
    private static String superAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Password", "Valid Value");
    private static String superAdminFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Name", "Valid Value");
    private static String superAdminPhoneNum = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Phone", "Valid Value");
    private static String normalAdminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Email", "Valid Value");
    private static String normalAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Password", "Valid Value");
    private static String normalAdminFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Name", "Valid Value");
    private static String normalAdminPhoneNum = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Phone", "Valid Value");
    private static String clientEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Client Email", "Valid Value");
    private static String auditorEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Auditor Email", "Valid Value");
    private static String onboardingStatus = GenericData.UserStatus.ONBOARDING.value;
    private static String waitListedStatus = GenericData.UserStatus.WAITLISTED.value;
    private static String activeStatus = GenericData.UserStatus.ACTIVE.value;
    private static String inactiveStatus = GenericData.UserStatus.INACTIVE.value;

    @DataProvider(name = "verifyGUISuperAdminHomePage")
    public static Object[][] getVerifyGUISuperAdminHomePage() {
        Object[][] arrayData = new Object[][]{{superAdminId, superAdminPwd, superAdminFullName, superAdminPhoneNum, normalAdminId
                , clientEmail, auditorEmail, onboardingStatus, waitListedStatus, activeStatus, inactiveStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {superAdminId, superAdminPwd, superAdminFullName, superAdminPhoneNum, normalAdminId
                            , clientEmail, auditorEmail, onboardingStatus, waitListedStatus, activeStatus, inactiveStatus}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGUINormalAdminHomePage")
    public static Object[][] getVerifyGUINormalAdminHomePage() {
        Object[][] arrayData = new Object[][]{{normalAdminId, normalAdminPwd, normalAdminFullName, normalAdminPhoneNum, clientEmail, auditorEmail, onboardingStatus, waitListedStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {normalAdminId, normalAdminPwd, normalAdminFullName, normalAdminPhoneNum, clientEmail, auditorEmail, onboardingStatus, waitListedStatus}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAssignSuperAdminRole")
    public static Object[][] getVerifyAssignSuperAdminRole() {
        Object[][] arrayData = new Object[][]{{superAdminId, superAdminPwd, normalAdminId, normalAdminPwd, normalAdminFullName, superAdminFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {superAdminId, superAdminPwd, normalAdminId, normalAdminPwd, normalAdminFullName, superAdminFullName}
            };
        }
        return arrayData;
    }
}
