package com.auvenir.ui.dataprovider.groupPermissions;

import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorDataProvider {
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
    private static String auditorPasword = GenericService
            .getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir " + "Password");

    @DataProvider(name = "verifyPermissionCreateAnEngagement")
    public static Object[][] getVerifyPermissionCreateAnEngagement() {

        Object[][] arrayData = new Object[][]{{auditorId, auditorPasword}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorId, auditorPasword}};
        }
        return arrayData;
    }
}
