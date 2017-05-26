package com.auvenir.ui.services.signup;

import com.auvenir.ui.pages.onboarding.FirmPO;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by tan.pham on 5/24/2017.
 */
public class FirmService extends AbstractService {
    private FirmPO firmPO;

    public FirmService(Logger logger, WebDriver driver) {
        super(logger, driver);
        firmPO = new FirmPO(getLogger(),getDriver());
    }

    public void verifyFirmSignUpPage(){
        firmPO.verifyPageContent();
    }

    public void registerFirmInfo(String strName, String strPreName, String strWebsite, String strStreetAddr, String strOffNum, String strZipCode, String strCity, String strState, String strMemberID, String strNumEmp, String strPhone, String strAffName, String strPathLogo) {
        firmPO.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strState,  strMemberID,  strNumEmp,  strPhone,  strAffName,  strPathLogo);
    }

    public void clickOnChangedNameCheckBox(){
        firmPO.clickOnChangedNameCheckBox();
    }

    public void clickOnAllFirmCheckBox(){
        firmPO.clickOnAllFirmCheckBox();
    }

    public void clickOnRuleLogoCheckBox(){
        firmPO.clickOnRuleLogoCheckBox();
    }

    public void inputValueIntoFirmNameTextBox(String strName){
        firmPO.inputValueIntoFirmNameTextBox(strName);
    }

    public void inputValueIntoPreviousFirmNameTextBox(String strName){
        firmPO.inputValueIntoPreviousFirmNameTextBox(strName);
    }


    public void verifyColorFirmNameTextBox(String attributeName, String attributeValue) {
       firmPO.verifyColorFirmNameTextBox(attributeName,attributeValue);
    }

    public void verifyColorPreFirmNameTextBox(String attributeName, String attributeValue) {
        firmPO.verifyColorPreFirmNameTextBox(attributeName,attributeValue);
    }

    public void inputValueIntoFirmWebsiteTextBox(String strName){
        firmPO.inputValueIntoWebsiteTextBox(strName);
    }

    public void verifyColorFirmWebsiteTextBox(String attributeName, String attributeValue) {
        firmPO.verifyColorFirmWebsiteTextBox(attributeName,attributeValue);
    }

    public void inputValueIntoFullAddressTextBox(String strName){
        firmPO.inputValueIntoFullAddressTextBox(strName);
    }

    public void verifyColorFullAddressTextBox(String attributeName, String attributeValue) {
        firmPO.verifyColorFullAddressTextBox(attributeName,attributeValue);
    }

    public void inputValueIntoZipCodeTextBox(String strName){
        firmPO.inputValueIntoZipCodeTextBox(strName);
    }

    public void verifyColorZipCodeTextBox(String attributeName, String attributeValue) {
        firmPO.verifyColorZipCodeTextBox(attributeName,attributeValue);
    }

    public void inputValueIntoMemberIdTextBox(String strName){
        firmPO.inputValueIntoMemberIdTextBox(strName);
    }

    public void verifyColorMemberIdTextBox(String attributeName, String attributeValue) {
        firmPO.verifyColorMemberIdTextBox(attributeName,attributeValue);
    }

    public void inputValueIntoPhoneNumberIdTextBox(String strName){
        firmPO.inputValueIntoPhoneNumberIdTextBox(strName);
    }

    public void verifyColorPhoneNumberIdTextBox(String attributeName, String attributeValue) {
        firmPO.verifyColorPhoneNumberIdTextBox(attributeName,attributeValue);
    }

    public void inputValueIntoAffiliatedFirmNameTextBox(String strName){
        firmPO.inputValueIntoAffiliatedFirmNameTextBox(strName);
    }

    public void verifyColorAffFirmTextBox(String attributeName, String attributeValue) {
        firmPO.verifyColorAffFirmTextBox(attributeName,attributeValue);
    }
}
