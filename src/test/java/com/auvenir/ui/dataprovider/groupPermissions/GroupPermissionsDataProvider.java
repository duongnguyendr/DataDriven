package com.auvenir.ui.dataprovider.groupPermissions;

import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class GroupPermissionsDataProvider {
    private static String adminAuditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Valid Value");
    private static String adminAuditorPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Auvenir Password", "Valid Value");
    private static String leadAuditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor", "Valid Value");
    private static String leadAuditorPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor Auvenir Password", "Valid Value");
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor", "Valid Value");
    private static String auditorPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor Auvenir Password", "Valid Value");
    private static String adminClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client", "Valid Value");
    private static String adminClientPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client Auvenir Password", "Valid Value");
    private static String leadClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client", "Valid Value");
    private static String leadClientPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
    private static String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client", "Valid Value");
    private static String clientPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");

    private static String isAdminAuditorCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Can Create An Engagement");
    private static String isAuditorCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor", "Can Create An Engagement");
    private static String isAdminClientCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client", "Can Create An Engagement");
    private static String isLeadClientCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client", "Can Create An Engagement");
    private static String isClientCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client", "Can Create An Engagement");


    @DataProvider(name = "verifyPermissionCreateAnEngagement")
    public static Object[][] getVerifyPermissionCreateAnEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorId, adminAuditorPassword}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorId, adminAuditorPassword}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionAdminClientCanInviteClient")
    public static Object[][] getVerifyPermissionAdminClientCanInviteClient() {
        Object[][] arrayData = new Object[][]{{adminClientId, adminClientPassword}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorId, adminAuditorPassword}};
        }
        return arrayData;
    }
}
