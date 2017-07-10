package com.auvenir.ui.dataprovider.admin;

import com.auvenir.utilities.GenericData;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by thuan.duong on 7/7/2017.
 */
public class AdminDataProvider {

    private static String superAdminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin", "Valid Value");
    private static String superAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Password", "Valid Value");
    private static String superAdminFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Name", "Valid Value");
    private static String superAdminPhoneNum = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Phone", "Valid Value");
    private static String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Admin", "Valid Value");
    private static String adminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Admin Password", "Valid Value");
    private static String adminFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Admin Name", "Valid Value");
    private static String adminPhoneNum = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Admin Phone", "Valid Value");
    private static String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Client", "Valid Value");
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Auditor", "Valid Value");
    private static String onboardingStatus = GenericData.UserStatus.ONBOARDING.value;
    private static String waitListedStatus = GenericData.UserStatus.WAITLISTED.value;
    private static String activeStatus = GenericData.UserStatus.ACTIVE.value;
    private static String inactiveStatus = GenericData.UserStatus.INACTIVE.value;
    private static String lockedStatus = GenericData.UserStatus.LOCKED.value;

    @DataProvider(name = "verifyGUISuperAdminHomePage")
    public static Object[][] getVerifyGUISuperAdminHomePage() {
        Object[][] arrayData = new Object[][]{{superAdminId, superAdminPwd, superAdminFullName, superAdminPhoneNum, adminId
                , clientId, auditorId, onboardingStatus, waitListedStatus, activeStatus, inactiveStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {superAdminId, superAdminPwd, superAdminFullName, superAdminPhoneNum, adminId
                            , clientId, auditorId, onboardingStatus, waitListedStatus, activeStatus, inactiveStatus}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGUIAdminHomePage")
    public static Object[][] getVerifyGUIAdminHomePage() {
        Object[][] arrayData = new Object[][]{{adminId, adminPwd, adminFullName, adminPhoneNum, clientId, auditorId, onboardingStatus, waitListedStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminId, adminPwd, adminFullName, adminPhoneNum, clientId, auditorId, onboardingStatus, waitListedStatus}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAssignSuperAdminRole")
    public static Object[][] getVerifyAssignSuperAdminRole() {
        Object[][] arrayData = new Object[][]{{superAdminId, superAdminPwd, adminId, adminPwd, adminFullName, superAdminFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {superAdminId, superAdminPwd, adminId, adminPwd, adminFullName, superAdminFullName}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifySuperAdminChangeStatusAdmin")
    public static Object[][] getVerifySuperAdminChangeStatusAdmin() {
        Object[][] arrayData = new Object[][]{{superAdminId, superAdminPwd, adminId, inactiveStatus, lockedStatus, onboardingStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {superAdminId, superAdminPwd, adminId, inactiveStatus, lockedStatus, onboardingStatus}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifySuperAdminChangeStatusAuditor")
    public static Object[][] getVerifySuperAdminChangeStatusAuditor() {
        Object[][] arrayData = new Object[][]{{superAdminId, superAdminPwd, auditorId, inactiveStatus, lockedStatus, activeStatus, onboardingStatus, waitListedStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {superAdminId, superAdminPwd, auditorId, inactiveStatus, lockedStatus, activeStatus, onboardingStatus, waitListedStatus}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifySuperAdminChangeStatusClient")
    public static Object[][] getVerifySuperAdminChangeStatusClient() {
        Object[][] arrayData = new Object[][]{{superAdminId, superAdminPwd, clientId, inactiveStatus, lockedStatus, activeStatus, onboardingStatus, waitListedStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {superAdminId, superAdminPwd, clientId, inactiveStatus, lockedStatus, activeStatus, onboardingStatus, waitListedStatus}
            };
        }
        return arrayData;
    }
}
