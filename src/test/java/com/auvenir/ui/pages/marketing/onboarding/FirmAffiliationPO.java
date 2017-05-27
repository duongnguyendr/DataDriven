package com.auvenir.ui.pages.marketing.onboarding;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/12/2017.
 */
public class FirmAffiliationPO extends BaseAuditorOnBoardingPO {

    public FirmAffiliationPO(Logger logger, WebDriver webDriver){
        super(logger, webDriver);
        PageFactory.initElements(webDriver,this);
    }

    // TODO need to update locator of Element button Close
    @FindBy(id = "buttonClose")
    private WebElement btnClose;
    public WebElement getBtnClose(){return btnClose; }

    // TODO need to update model of popup
    @FindBy(id = "frmPopup")
    private WebElement frmPopup;
    public WebElement getFrmPopup(){return frmPopup; }

    // TODO need to update locator of Element icon Close
    @FindBy(id = "iconClose")
    private WebElement iconClose;
    public WebElement getIconClose(){return iconClose; }

    @Override
    public void verifyPageContent(){

    }

    /*@Override
    protected void load(){

    }

    @Override*/
    protected void isLoaded() throws Error{
        // Checking model of popup element is displayed
        this.validateElememt(frmPopup,"Element of model Popup", Element_Type.DISPLAYED);

        // Checking button Close element is displayed
        this.validateElememt(btnClose,"Element of button Close", Element_Type.DISPLAYED);

        // Checking icon Close element is displayed
        this.validateElememt(iconClose,"Element of icon Close", Element_Type.DISPLAYED);

    }

    public void acceptContentFirmAffililated(){
        btnClose.click();
    }

}
