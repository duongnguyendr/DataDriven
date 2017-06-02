package com.auvenir.ui.pages.marketing.mailtemplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorCommentPO extends NotificationMailTemplatePO {

    @FindBy(xpath = "")
    private WebElement eleContentComment;
    public WebElement getEleContentComment(){ return eleContentComment; }

    public NotificationMailAuditorCommentPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /*public void verifyPageContent(){
        super.get();
        super.verifyPageContent();

        // Checking content invite
        NXGReports.addStep("Verify content Comment", LogAs.PASSED, null);
        this.validateElememt(eleContentComment,"Element of content Comment ",Element_Type.DISPLAYED);
    }*/

}
