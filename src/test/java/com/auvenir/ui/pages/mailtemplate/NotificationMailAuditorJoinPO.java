package com.auvenir.ui.pages.mailtemplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorJoinPO extends NotificationMailTemplatePO {

    @FindBy(xpath = "")
    private WebElement eleContentJoin;
    public WebElement getEleContentJoin(){ return eleContentJoin; }

    public NotificationMailAuditorJoinPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /*public void verifyPageContent(){
        super.get();
        super.verifyPageContent();

        // Checking content invite
        NXGReports.addStep("Verify content join", LogAs.PASSED, null);
        this.validateElememt(eleContentJoin,"Element of content join ",Element_Type.DISPLAYED);
    }*/


}
