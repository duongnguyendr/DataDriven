package com.auvenir.ui.pages.marketing.mailtemplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorNewToDoPO extends NotificationMailTemplatePO {

    @FindBy(xpath = "")
    private WebElement eleContentNewToDo;
    public WebElement getEleContentNewToDo(){ return eleContentNewToDo; }

    public NotificationMailAuditorNewToDoPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /*public void verifyPageContent(){
        super.get();
        super.verifyPageContent();

        // Checking content Create a new To-Do
        NXGReports.addStep("Verify content Create a new ToDo", LogAs.PASSED, null);
        this.validateElememt(eleContentNewToDo,"Element of content Create a new ToDo",Element_Type.DISPLAYED);
    }*/
}
