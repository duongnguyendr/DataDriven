package com.auvenir.ui.services.marketing.signup;

import com.auvenir.ui.pages.marketing.onboarding.*;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by tan.pham on 5/24/2017.
 */
public class FirmService extends AbstractService {
    private AuditorSignUpFirmPage auditorSignUpFirmPage;

    public FirmService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorSignUpFirmPage = new AuditorSignUpFirmPage(getLogger(),getDriver());
    }

    public void verifyFirmSignUpPage(){
        auditorSignUpFirmPage.verifyPageContent();
    }

    public void registerFirmInfo(String strName, String strPreName, String strWebsite, String strStreetAddr, String strOffNum, String strZipCode, String strCity, String strState, String strMemberID, String strNumEmp, String strPhone, String strAffName, String strPathLogo) {
        auditorSignUpFirmPage.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhone,  strAffName,  strPathLogo);
    }

    public void clickOnChangedNameCheckBox(){
        auditorSignUpFirmPage.clickOnChangedNameCheckBox();
    }

    public void clickOnAllFirmCheckBox(){
        auditorSignUpFirmPage.clickOnAllFirmCheckBox();
    }

    public void clickOnRuleLogoCheckBox(){
        auditorSignUpFirmPage.clickOnRuleLogoCheckBox();
    }

    public void inputValueIntoFirmNameTextBox(String strName){
        auditorSignUpFirmPage.inputValueIntoFirmNameTextBox(strName);
    }

    public void inputValueIntoPreviousFirmNameTextBox(String strName){
        auditorSignUpFirmPage.inputValueIntoPreviousFirmNameTextBox(strName);
    }


    public void verifyInputValidValueOnFirmNameTextBox(List<String> invalidValue) {
        System.out.println("Size Invalid Data: " + invalidValue.size());
        for(int i = 0 ; i < invalidValue.size(); i++){
            auditorSignUpFirmPage.verifyInputValidValueOnFirmNameTextBox(invalidValue.get(i));
        }
    }

    public void verifyInputValidValueOnPreFirmNameTextBox(List<String> invalidValue) {
        System.out.println("Size Invalid Data: " + invalidValue.size());
        for(int i = 0 ; i < invalidValue.size(); i++){
            auditorSignUpFirmPage.verifyInputValidValueOnPreFirmNameTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoFirmWebsiteTextBox(String strName){
        auditorSignUpFirmPage.inputValueIntoWebsiteTextBox(strName);
    }

    public void verifyInputValidValueOnFirmWebsiteTextBox(List<String> invalidValue) {
        System.out.println("Size Invalid Data: " + invalidValue.size());
        for(int i = 0 ; i < invalidValue.size(); i++){
            auditorSignUpFirmPage.verifyInputValidValueOnFirmWebsiteTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoFullAddressTextBox(String strName){
        auditorSignUpFirmPage.inputValueIntoFullAddressTextBox(strName);
    }

    public void verifyInputValidValueOnFullAddressTextBox(String invalidValue) {
        auditorSignUpFirmPage.verifyInputValidValueOnFullAddressTextBox(invalidValue);
    }

    public void inputValueIntoZipCodeTextBox(String strName){
        auditorSignUpFirmPage.inputValueIntoZipCodeTextBox(strName);
    }

    public void verifyInputValidValueOnZipCodeTextBox(List<String> invalidValue) {
        System.out.println("Size Invalid Data: " + invalidValue.size());
        for(int i = 0 ; i < invalidValue.size(); i++){
            auditorSignUpFirmPage.verifyInputValidValueOnZipCodeTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoMemberIdTextBox(String strName){
        auditorSignUpFirmPage.inputValueIntoMemberIdTextBox(strName);
    }

    public void verifyInputValidValueOnMemberIdTextBox(List<String> invalidValue) {
        System.out.println("Size Invalid Data: " + invalidValue.size());
        for(int i = 0 ; i < invalidValue.size(); i++){
            auditorSignUpFirmPage.verifyInputValidValueOnMemberIdTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoPhoneNumberIdTextBox(String strName){
        auditorSignUpFirmPage.inputValueIntoPhoneNumberIdTextBox(strName);
    }

    public void verifyInputValidValueOnPhoneNumberIdTextBox(List<String> invalidValue) {
        System.out.println("Size Invalid Data: " + invalidValue.size());
        for(int i = 0 ; i < invalidValue.size(); i++){
            auditorSignUpFirmPage.verifyInputValidValueOnPhoneNumberIdTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoAffiliatedFirmNameTextBox(String strName){
        auditorSignUpFirmPage.inputValueIntoAffiliatedFirmNameTextBox(strName);
    }

    public void verifyInputValidValueOnAffFirmTextBox(List<String> invalidValue) {
        System.out.println("Size Invalid Data: " + invalidValue.size());
        for(int i = 0 ; i < invalidValue.size(); i++){
            auditorSignUpFirmPage.verifyInputValidValueOnAffFirmTextBox(invalidValue.get(i));
        }
    }
}
