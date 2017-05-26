package com.auvenir.ui.pages.onboarding;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by cuong.nguyen on 4/12/2017.
 */
public abstract class BaseAuditorOnBoardingPO extends AbstractPage {

    protected WebElement eleHeader;
    protected WebElement eleFooter;

    /**
     * Verify Page Content
     */
    public abstract void verifyPageContent();

    public BaseAuditorOnBoardingPO(Logger logger, WebDriver webDriver){
        super(logger,webDriver);
    }

    public WebElement getEleHeader(){
        return  eleHeader;
    }

    public WebElement getEleFooter(){
        return eleFooter;
    }

    public void selectListBoxByText(WebElement eleListBox, String strName){
        List<WebElement> lists = eleListBox.findElements(By.xpath("//div[span[text()='" + strName + "' or contains(text(),'"+ strName +"')]]"));
        for (WebElement e : lists){
            if(e.isDisplayed()){
                e.click();
                break;
            }
        }
    }

}
