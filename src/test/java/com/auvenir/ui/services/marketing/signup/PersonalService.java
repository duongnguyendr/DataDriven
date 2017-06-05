package com.auvenir.ui.services.marketing.signup;

import com.auvenir.ui.pages.marketing.MarketingPage;
import com.auvenir.ui.pages.marketing.onboarding.*;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by tan.pham on 5/24/2017.
 */
public class PersonalService extends AbstractService {

    private MarketingPage marketingPage;
    private PersonalPage personalSignupPage;

    public PersonalService(Logger logger, WebDriver driver) {
        super(logger, driver);
        marketingPage = new MarketingPage(getLogger(),getDriver());
        personalSignupPage = new PersonalPage(getLogger(),getDriver());
    }

    public void navigateToSignUpPage(){
        marketingPage.clickOnSignupButton();
    }

    public void verifyPersonalSignUpPage(){
        personalSignupPage.verifyPageContent();
    }

    public void registerAuditorPersonal(String strName, String strEmail, String strRoleFirm, String strPhone, String strReference){
        personalSignupPage.registerAuditorPersonal(strName,strEmail,strRoleFirm,strPhone,strReference);
    }

    public void clickOnCheckBoxConfirm(){
        personalSignupPage.clickOnCheckBoxConfirm();
    }

    public void inputValueIntoFullNameTexBox(String strName){
        personalSignupPage.inputValueIntoFullNameInput(strName);
    }

    public void verifyColorFullNameTxtBox(String attributeName, String attributeValue){
        personalSignupPage.verifyColorFullNameTxtBox(attributeName,attributeValue);
    }

    public void inputValueIntoEmailTexBox(String strName){
        personalSignupPage.inputValueIntoEmailTextBox(strName);
    }

    public void verifyColorEmailTxtBox(String attributeName, String attributeValue){
        personalSignupPage.verifyColorEmailTxtBox(attributeName,attributeValue);
    }

    public void inputValueIntoConfirmEmailTextBox(String strName){
        personalSignupPage.inputValueIntoConfirmEmailTextBox(strName);
    }

    public void verifyColorConfirmEmailTxtBox(String attributeName, String attributeValue){
        personalSignupPage.verifyColorConfirmEmailTxtBox(attributeName,attributeValue);
    }

    public void inputValueIntoPhoneNumberTextBox(String strName){
        personalSignupPage.inputValueIntoPhoneNumberTextBox(strName);
    }

    public void verifyColorPhoneNumberTxtBox(String attributeName, String attributeValue){
        personalSignupPage.verifyColorPhoneNumberTxtBox(attributeName,attributeValue);
    }
}
