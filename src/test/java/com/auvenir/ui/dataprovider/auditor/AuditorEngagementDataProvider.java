package com.auvenir.ui.dataprovider.auditor;

import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/6/2017.
 */
public class AuditorEngagementDataProvider {

    private static  String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();

    @DataProvider(name = "verifyFooterAuditorEngagementPage")
    public static Object[][] getVerifyFooterAuditorEngagementPage(){
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");*/
        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";

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
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");*/
        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";

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
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");*/
        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";

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
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");*/
        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";


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
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");*/
        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";
        String companyName = "Company Auvenir";
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
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");*/
        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";
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
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");*/
        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd}};
        if(GenericService.sLanguage.equals("French")){
            arrayData = new Object[][]{
                    {auditorId, auditorPwd}
            };
        }
        return arrayData;
    }

}