package com.auvenir.ui.dataprovider.auditor;

import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/6/2017.
 */
public class AuditorEngagementDataProvider {

    /*private static String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
    private static String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");*/

    private static String auditorId = "chr.auvenirauditor@gmail.com";
    private static String auditorPwd = "Changeit@123";
    private static String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
    private static String companyName = "Company Auvenir";

    @DataProvider(name = "verifyFooterAuditorEngagementPage")
    public static Object[][] getVerifyFooterAuditorEngagementPage(){
         return new Object[][]{
                    {auditorId, auditorPwd}
         };
    }

    @DataProvider(name = "verifyUINewEngagement")
    public static Object[][] getVerifyUINewEngagement(){
        return new Object[][]{
                {auditorId, auditorPwd, engagementName}
        };

    }

    @DataProvider(name = "verifyGUIListEngagement")
    public static Object[][] getVerifyGUIListEngagement(){
        return new Object[][]{
                {auditorId, auditorPwd}
        };
    }

    @DataProvider(name = "verifySearchDataListByName")
    public static Object[][] getVerifySearchDataListByName(){
        return new Object[][]{
                {auditorId, auditorPwd, engagementName}
        };

    }

    @DataProvider(name = "verifySearchDataListByCompany")
    public static Object[][] getEngagementDataGroupC(){
        return new Object[][]{
                {auditorId, auditorPwd, companyName}
        };
    }

    @DataProvider(name = "verifySearchDataListByFilterSelectBox")
    public static Object[][] getVerifySearchDataListByFilterSelectBox(){
        return new Object[][]{
                {auditorId, auditorPwd}
        };
    }

    @DataProvider(name = "verifyDataSortByClickOnColumnName")
    public static Object[][] getVerifyDataSortByClickOnColumnName(){
        return new Object[][]{
                {auditorId, auditorPwd}
        };
    }

}
