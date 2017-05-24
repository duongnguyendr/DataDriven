package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class AddNewClientPage extends AbstractPage {
    Logger logger = null;
    WebDriver driver = null;

    public AddNewClientPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]")
    private WebElement eleAddNewClientTxt;

    public WebElement getEleAddNewClientTxt() {
        return eleAddNewClientTxt;
    }

    @FindBy(xpath = "//div[@class='au-modal-container au-modal-fullScreen modalTransition-fp-container']/img")
    private WebElement eleCloseBtn;

    public WebElement getEleCloseBtn() {
        return eleCloseBtn;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//h3[contains(text(),'Company Information')]")
    private WebElement eleCompanyInformationTxt;

    public WebElement getEleCompanyInformationTxt() {
        return eleCompanyInformationTxt;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//h3[contains(text(),'Key Contact')]")
    private WebElement eleKeyContactInformationTxt;

    public WebElement getEleKeyContactInformationTxt() {
        return eleKeyContactInformationTxt;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Legal Name of Entity')]")
    private WebElement eleLegalNameOfEntityTxt;

    public WebElement getEleLegalNameOfEntityTxt() {
        return eleLegalNameOfEntityTxt;
    }

    @FindBy(id = "m-ac-legalName")
    private WebElement eleLegalNameOfEntityTxtFld;

    public WebElement getEleLegalNameOfEntityTxtFld() {
        return eleLegalNameOfEntityTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//label[contains(text(),'The legal name changed')]")
    private WebElement eleTheLegalNameChangedTxt;

    public WebElement getEleTheLegalNameChangedTxt() {
        return eleTheLegalNameChangedTxt;
    }

    @FindBy(xpath = "//img[@id='m-ac-legalNameChange']")
    private WebElement eleTheLegalNameChkBox;

    public WebElement getEleTheLegalNameChkBox() {
        return eleTheLegalNameChkBox;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//label[contains(text(),'The entity is publicly listed')]")
    private WebElement eleTheEntityIsPubliclyListedTxt;

    public WebElement getEleTheEntityIsPubliclyListedTxt() {
        return eleTheEntityIsPubliclyListedTxt;
    }

    @FindBy(xpath = "//img[@id='m-ac-publiclyListed']")
    private WebElement eleTheEntityIsPubliclyListedChkBox;

    public WebElement getEleTheEntityIsPubliclyListedChkBox() {
        return eleTheEntityIsPubliclyListedChkBox;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//label[contains(text(),'The entity has operations')]")
    private WebElement eleTheEntityHasOperationsTxt;

    public WebElement getEleTheEntityHasOperationsTxt() {
        return eleTheEntityHasOperationsTxt;
    }

    @FindBy(xpath = "//img[@id='m-ac-overseasOps']")
    private WebElement eleTheEntityHasOperationsChkBox;

    public WebElement getEleTheEntityHasOperationsChkBox() {
        return eleTheEntityHasOperationsChkBox;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Please list parent')]")
    private WebElement elePleaseListParentTxt;

    public WebElement getElePleaseListParentTxt() {
        return elePleaseListParentTxt;
    }

    @FindBy(xpath = "//textarea[@id='m-ac-parentStakeholders']")
    private WebElement elePleaseListParentTxtFld;

    public WebElement getElePleaseListParentTxtFld() {
        return elePleaseListParentTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Industry')]")
    private WebElement eleIndustryTxt;

    public WebElement getEleIndustryTxt() {
        return eleIndustryTxt;
    }

    @FindBy(id = "m-ac-industry")
    private WebElement eleIndustryDrpDwn;

    public WebElement getEleIndustryDrpDwn() {
        return eleIndustryDrpDwn;
    }

    @FindBy(xpath = "//ul[@class='ddlLink inputDdl inputDdl-after']//a[contains(text(),'Accommodation')]")
    private WebElement eleSelectIndustryTypeDrpDwn;

    public WebElement getEleSelectIndustryTypeDrpDwn() {
        return eleSelectIndustryTypeDrpDwn;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Accounting Framework')]")
    private WebElement eleAccountingFrameWorkTxt;

    public WebElement getEleAccountingFrameWorkTxt() {
        return eleAccountingFrameWorkTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Accounting Framework')]/../input")
    private WebElement eleAccountingFrameWorkDrpDwn;

    public WebElement getEleAccountingFrameWorkDrpDwn() {
        return eleAccountingFrameWorkDrpDwn;
    }

    @FindBy(xpath = "//p[contains(text(),'Accounting Framework')]//..//a[contains(text(),'IFRS')]")
    private WebElement eleSelectAccountingFrameWorkDrpDwn;

    public WebElement getEleSelectAccountingFrameWorkDrpDwn() {
        return eleSelectAccountingFrameWorkDrpDwn;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Street Number')]")
    private WebElement eleStreetNumberTxt;

    public WebElement getEleStreetNumberTxt() {
        return eleStreetNumberTxt;
    }

    @FindBy(xpath = "//input[@id='m-ac-streetAddress']")
    private WebElement eleAddressTxtFld;

    public WebElement getEleAddressTxtFld() {
        return eleAddressTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[text()='Street']")
    private WebElement eleStreetTxt;

    public WebElement getEleStreetTxt() {
        return eleStreetTxt;
    }

    @FindBy(id = "m-ac-address-streetName")
    private WebElement eleStreetTxtFld;

    public WebElement getEleStreetTxtFld() {
        return eleStreetTxtFld;
    }

    @FindBy(xpath = "//p[text()='Address *']")
    private WebElement eleAddressTxt;

    public WebElement getEleAddressTxt() {
        return eleAddressTxt;
    }

    @FindBy(id = "m-ac-unit")
    private WebElement eleUnitTxtFld;

    public WebElement getEleUnitTxtFld() {
        return eleUnitTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Unit / Suite Number *')]")
    private WebElement eleUnitNumberTxt;

    public WebElement getEleUnitNumberTxt() {
        return eleUnitNumberTxt;
    }

    @FindBy(id = "m-ac-unit")
    private WebElement eleUnitNumberTxtFld;

    public WebElement getEleUnitNumberTxtFld() {
        return eleUnitNumberTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'City')]")
    private WebElement eleCityTxt;

    public WebElement getEleCityTxt() {
        return eleCityTxt;
    }

    @FindBy(id = "m-ac-city")
    private WebElement eleCityTxtFld;

    public WebElement getEleCityTxtFld() {
        return eleCityTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Province / State *')]")
    private WebElement eleProvinceStateTxt;

    public WebElement getEleProvinceStateTxt() {
        return eleProvinceStateTxt;
    }

    @FindBy(xpath = "//input[@id='m-ac-stateProvince']")
    private WebElement eleProvinceStateTxtFld;

    public WebElement getEleProvinceStateTxtFld() {
        return eleProvinceStateTxtFld;
    }

    @FindBy(id = "m-ac-country")
    private WebElement eleCountryTxtFld;

    public WebElement getEleCountryTxtFld() {
        return eleCountryTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Postal / Zip Code *')]")
    private WebElement elePostalCodeTxt;

    public WebElement getElePostalCodeTxt() {
        return elePostalCodeTxt;
    }

    @FindBy(className = "addClient-footerBtnHolder")
    private WebElement eleAddClientFtrTab;

    public WebElement getEleAddClientFtrTab() {
        return eleAddClientFtrTab;
    }

    @FindBy(id = "m-ac-postalCode")
    private WebElement elePostalCodeTxtFld;

    public WebElement getElePostalCodeTxtFld() {
        return elePostalCodeTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'First and Last Name')]")
    private WebElement eleFirstAndLastNameTxt;

    public WebElement getEleFirstAndLastNameTxt() {
        return eleFirstAndLastNameTxt;
    }

    @FindBy(id = "m-ac-fullName")
    private WebElement eleFirstAndLastNameTxtFld;

    public WebElement getEleFirstAndLastNameTxtFld() {
        return eleFirstAndLastNameTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Email Address')]")
    private WebElement eleEmailAddressTxt;

    public WebElement getEleEmailAddressTxt() {
        return eleEmailAddressTxt;
    }

    @FindBy(id = "m-ac-email")
    private WebElement eleEmailAddressTxtFld;

    public WebElement getEleEmailAddressTxtFld() {
        return eleEmailAddressTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//p[contains(text(),'Phone Number')]")
    private WebElement elePhoneNumberTxt;

    public WebElement getElePhoneNumberTxt() {
        return elePhoneNumberTxt;
    }

    @FindBy(id = "m-ac-phoneNumber")
    private WebElement elePhoneNumberTxtFld;

    public WebElement getElePhoneNumberTxtFld() {
        return elePhoneNumberTxtFld;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//span[@id='m-ac-emptyCamera']")
    private WebElement eleCameraImg;

    public WebElement getEleCameraImg() {
        return eleCameraImg;
    }

    @FindBy(xpath = "//h1[contains(text(),'Add New Client')]//..//button[@id='uploadCoverBtn']")
    private WebElement eleUploadPhotoBtn;

    public WebElement getEleUploadPhotoBtn() {
        return eleUploadPhotoBtn;
    }

    @FindBy(xpath = "//button[@id='m-ac-addBtn']")
    private WebElement eleAddBtn;

    public WebElement getEleAddBtn() {
        return eleAddBtn;
    }
}
