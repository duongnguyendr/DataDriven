package com.auvenir.ui.pages.mailtemplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorRequestToDoPO extends NotificationMailTemplatePO {

    @FindBy(xpath = "")
    private WebElement eleContentRequestToDo;
    public WebElement getEleContentRequestToDo(){ return eleContentRequestToDo; }

    public NotificationMailAuditorRequestToDoPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /*public void verifyPageContent(){
        super.get();
        super.verifyPageContent();

        // Checking content Request a To-Do
        NXGReports.addStep("Verify content Request within To-Do", LogAs.PASSED, null);
        this.validateElememt(eleContentRequestToDo,"Element of content Request within To-Do ",Element_Type.DISPLAYED);
    }*/

}

