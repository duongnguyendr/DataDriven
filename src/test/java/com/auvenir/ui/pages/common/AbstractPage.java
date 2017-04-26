package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractRefactorService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by hungcuong1105 on 4/15/2017.
 */
public class AbstractPage {
    private    Logger logger = null;
    private  WebDriver driver = null;
    private static final int waitTime = 60;

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
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(elementName + " is not Visible", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void validateElementText(WebElement webElement, String elementText) {
        try {
            getLogger().info("Check renderd of text: " + elementText);
            Assert.assertEquals(webElement.getText().trim(),elementText);
            NXGReports.addStep(elementText + " rendered", LogAs.PASSED,null);
        }catch (AssertionError error) {
            getLogger().info(error);
            NXGReports.addStep(elementText + " rendered", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void validateDisPlayedElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify Displayed of: " + element.getText());

        try
        {
            element.isDisplayed();
            NXGReports.addStep(element.getTagName() + " is displayed", LogAs.PASSED, null);
        }

        catch (Exception e)
        {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }
    public void validateEnabledElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify enabled of: " + element.getText());

        try
        {
            element.isEnabled();
            NXGReports.addStep(element.getTagName() + " is enabled", LogAs.PASSED, null);
        }

        catch (Exception e)
        {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is  enabled", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }
    public void validateSelectedElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify selected of: " + element.getText());

        try
        {
            element.isEnabled();
            NXGReports.addStep(element.getTagName() + " is selected", LogAs.PASSED, null);
        }

        catch (Exception e)
        {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is  selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }
    public void scrollPageUp() throws AWTException {

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
    }
    public void scrollPageDown() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    }
    public void waitForVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
