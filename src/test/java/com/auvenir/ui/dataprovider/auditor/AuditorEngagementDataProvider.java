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
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd}};
        if(GenericService.sLanguage.equals("French")){
            arrayData = new Object[][]{
                        {auditorId, auditorPwd}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifyUINewEngagement")
    public static Object[][] getVerifyUINewEngagement(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                        {auditorId, auditorPwd, engagementName}
            };
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUIListEngagement")
    public static Object[][] getVerifyGUIListEngagement(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd}};
        if(GenericService.sLanguage.equals("French")){
            arrayData = new Object[][]{
                    {auditorId, auditorPwd}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifySearchDataListByName")
    public static Object[][] getVerifySearchDataListByName(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {auditorId, auditorPwd, engagementName}
            };
        }
        return  arrayData;

    }

    @DataProvider(name = "verifySearchDataListByCompany")
    public static Object[][] getVerifySearchDataListByCompany(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, companyName}};
        if(GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {auditorId, auditorPwd, companyName}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifySearchDataListByFilterSelectBox")
    public static Object[][] getVerifySearchDataListByFilterSelectBox(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd}};
        if(GenericService.sLanguage.equals("French")){
            arrayData = new Object[][]{
                    {auditorId, auditorPwd}
            };
        }
        return arrayData;
    }

    @DataProvider(name = "verifyDataSortByClickOnColumnName")
    public static Object[][] getVerifyDataSortByClickOnColumnName(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd}};
        if(GenericService.sLanguage.equals("French")){
            arrayData = new Object[][]{
                    {auditorId, auditorPwd}
            };
        }
        return arrayData;
    }

}
