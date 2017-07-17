package com.auvenir.ui.dataprovider.marketing;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/14/2017.
 */
public class LoginMarketingDataProvider extends CommonDataProvider {
    public static final String FRENCH_LANGUAGE = "French";

    private static String emailId = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","VALID VALUE");
    private static String emailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");

    @DataProvider(name = "forgotPasswordTest")
    public static Object[][] getForgotPasswordTest(){
        String ranPassword = GenericService.genPassword(8, true, true, true);
        Object[][] arrayData = new Object[][]{{emailId, emailPassword, ranPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailId, emailPassword, ranPassword}};
        }
        return  arrayData;
    }

    @DataProvider(name = "forgotPasswordWithInvalidEmail")
    public static Object[][] getForgotPasswordWithInvalidEmail(){
        String invalidEmailAddress = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","INVALID VALUE");
        String invalidEmailAddress1 = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","INVALID VALUE1");
        String invalidEmailAddress2 = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","NOT EXIST");
        String errorMessage = "The email is invalid!";

        Object[][] arrayData = new Object[][]{{invalidEmailAddress, invalidEmailAddress1, invalidEmailAddress2, errorMessage}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{invalidEmailAddress, invalidEmailAddress1, invalidEmailAddress2, errorMessage}};
        }
        return  arrayData;
    }


    @DataProvider(name = "forgotPasswordWithEmailIsNotExist")
    public static Object[][] getForgotPasswordWithEmailIsNotExist(){
        String invalidEmailAddress = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","INVALID VALUE");

        Object[][] arrayData = new Object[][]{{invalidEmailAddress}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{invalidEmailAddress}};
        }
        return  arrayData;
    }

    @DataProvider(name = "loginAndLogoutTest")
    public static Object[][] getLoginAndLogoutTest(){

        Object[][] arrayData = new Object[][]{{emailId, emailPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailId, emailPassword}};
        }
        return  arrayData;
    }

}
