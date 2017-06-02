package com.auvenir.ui.pages.marketing.onboarding;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/12/2017.
 */
public class SuccessPO extends AbstractPage {

    public SuccessPO(Logger logger, WebDriver driver){
        super(logger, driver);
        PageFactory.initElements(driver,this);
    }

    // Element of Success Creation Account
    @FindBy(css = ".ui.header")
    private WebElement elePageSuccess;
    public WebElement getElePageSuccess(){return  elePageSuccess; }

    // Element image letter
    @FindBy(css = ".ui.image")
    private WebElement eleImageLetter;
    public WebElement getEleImageLetter(){return eleImageLetter; }

    // Element button CLose
    @FindBy(id = "btn-continue")
    private WebElement btnContinue;
    public WebElement getBtnClose(){return btnContinue; }


    //@Override
    public void verifyPageContent(){
        this.validateElememt(elePageSuccess,"Your Account Has Been Created!", Element_Type.TEXT_VALUE);
        this.isLoaded();
    }

    /*@Override
    public void load(){
        //
    }

    @Override*/
    public void isLoaded()throws Error{
        // Checking Image Letter element is displayed
        this.validateElememt(eleImageLetter,"Element of Image Letter", Element_Type.DISPLAYED);

        // Checking button Close element is displayed
        this.validateElememt(btnContinue,"Element of button Continue", Element_Type.DISPLAYED);

    }

    public void acceptCreateAccountAuditor(){
        btnContinue.click();
    }



}
