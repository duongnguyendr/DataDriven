package com.auvenir.ui.dataprovider.groupPermissions;

import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorDataProvider {
    private static String adminAuditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Valid Value");
    private static String adminAuditorPasword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Auvenir Password", "Valid Value");
    private static String leadAuditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor", "Valid Value");
    private static String leadAuditorPasword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor Auvenir Password", "Valid Value");
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor", "Valid Value");
    private static String auditorPasword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor Auvenir Password", "Valid Value");
    private static String adminClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client", "Valid Value");
    private static String adminClientPasword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client Auvenir Password", "Valid Value");
    private static String leadClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client", "Valid Value");
    private static String leadClientPasword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
    private static String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client", "Valid Value");
    private static String clientPasword =
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
        Object[][] arrayData = new Object[][]{{adminAuditorId, adminAuditorPasword, isAdminAuditorCanCreateAnEngagement},
                {auditorId, auditorPasword, isAuditorCanCreateAnEngagement}, {adminClientId, adminClientPasword, isAdminClientCanCreateAnEngagement},
                {leadClientId, leadClientPasword, isLeadClientCanCreateAnEngagement}, {clientId, clientPasword, isClientCanCreateAnEngagement}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorId, adminAuditorPasword, isAdminAuditorCanCreateAnEngagement},
                    {auditorId, auditorPasword, isAuditorCanCreateAnEngagement},
                    {adminClientId, adminClientPasword, isAdminClientCanCreateAnEngagement},
                    {leadClientId, leadClientPasword, isLeadClientCanCreateAnEngagement}, {clientId, clientPasword, isClientCanCreateAnEngagement}};
        }
        return arrayData;
    }
}
