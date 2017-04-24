package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

/**
 * Created by hungcuong1105 on 4/15/2017.
 */
public class AbstractPage {
    private    Logger logger = null;
    private  WebDriver driver = null;

    public AbstractPage(Logger logger,WebDriver driver){
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver,this);
    }
    public WebDriver getDriver(){

        return driver;
    }
    public Logger getLogger(){
        return logger;
    }
    public void visibilityOfElementWait(WebElement webElement, String elementName, int waitTime) {
        try {
         WebDriverWait   sWebDriverWait = new WebDriverWait(driver, waitTime);
            sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(elementName + " is not Visible", LogAs.FAILED, null);
        }
    }

}
