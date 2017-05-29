package com.auvenir.ui.pages.marketing.mailtemplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorUpDocPO extends NotificationMailTemplatePO {

    @FindBy(xpath = "")
    private WebElement eleContentUploadDoc;
    public WebElement getEleContentUploadDoc(){ return eleContentUploadDoc; }


    public NotificationMailAuditorUpDocPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }


    /*public void verifyPageContent(){
        super.get();
        super.verifyPageContent();

        // Checking content Uploaded Document
        NXGReports.addStep("Verify content Uploaded Document", LogAs.PASSED, null);
        this.validateElememt(eleContentUploadDoc,"Element of content Uploaded Document",Element_Type.DISPLAYED);
    }*/

}
