package com.auvenir.ui.pages.mailtemplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorCompletePO extends NotificationMailTemplatePO {

    @FindBy(xpath = "")
    private WebElement eleContentComplete;
    public WebElement getEleContentComplete(){ return eleContentComplete; }


    public NotificationMailAuditorCompletePO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /*public void verifyPageContent(){
        super.get();
        super.verifyPageContent();

        // Checking content Complete To-Do Engagement
        NXGReports.addStep("Verify content Complete To-Do Engagement", LogAs.PASSED, null);
        this.validateElememt(eleContentComplete,"Element of content Complete To-Do Engagement",Element_Type.DISPLAYED);
    }*/
}
