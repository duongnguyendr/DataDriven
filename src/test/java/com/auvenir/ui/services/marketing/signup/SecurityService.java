package com.auvenir.ui.services.marketing.signup;

import com.auvenir.ui.pages.marketing.onboarding.*;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by tan.pham on 5/24/2017.
 */
public class SecurityService extends AbstractService {
    private SecurityPO securityPO;

    public SecurityService(Logger logger, WebDriver driver) {
        super(logger, driver);
        securityPO = new SecurityPO(getLogger(),getDriver());
    }

    public void verifySecuritySignUpPage(){
        securityPO.verifyPageContent();
    }

    public void createPassword(String strPass, String strCaptcha){
        securityPO.createPassword(strPass,strCaptcha);
    }

    public void verifyCreatePasswordPopupWarning(int passwordLength, boolean isContainsCapialLetter, boolean isContainsLetter, boolean isContainsNumber){
        securityPO.verifyCreatePasswordPopupWarning(passwordLength, isContainsCapialLetter, isContainsLetter, isContainsNumber);
    }

    public void verifyConfirmPasswordPopupWarning(){
        securityPO.verifyConfirmPasswordPopupWarning();
    }

    public void inputValueIntoPaswordInput(String strName){
        securityPO.inputValueIntoPaswordInput(strName);
    }

    public void inputValueIntoConfirmPaswordInput(String strName){
        securityPO.inputValueIntoConfirmPaswordInput(strName);
    }
}
