package com.auvenir.utilities;

import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by huy.huynh on 12/05/2017.
 * Contain all popular utility methods
 */
public class GeneralUtilities {

    public static String getTimeStampForNameSuffix() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss_ddMMyy");
        Date date = new Date();
        return sdf.format(date);
    }

    public static boolean verifyElementExist(WebDriver webDriver, WebElement webElement) {
        return true;
    }

    public static Properties getMongoDBProperties() {
        Properties properties = null;
        try {
            FileInputStream fis = new FileInputStream(GenericService.MONGODBPROPERTIESFILE);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public static void toValidate(WebElement element, String sExpectedText, String checkType) throws InvalidElementStateException {
        System.out.println("verify present of: " + sExpectedText);
        //getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        switch (checkType) {
            case "Displayed":
                try {
                    element.isDisplayed();
                    NXGReports.addStep(sExpectedText + " is displayed", LogAs.PASSED, null);
                } catch (Exception e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(sExpectedText + " is not displayed", LogAs.FAILED, null);
                }

                break;
            case "Enabled":
                try {
                    element.isEnabled();
                    NXGReports.addStep(sExpectedText + " is enabled", LogAs.PASSED, null);
                } catch (Exception e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(sExpectedText + " is not enabled", LogAs.FAILED, null);
                }

                break;
            case "Selected":
                try {
                    element.isSelected();
                    NXGReports.addStep(sExpectedText + " is selected", LogAs.PASSED, null);
                } catch (Exception e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(sExpectedText + " is not selected", LogAs.FAILED, null);
                }

            case "ElementText":
                try {
                    element.getText().equals(sExpectedText);
                    NXGReports.addStep(sExpectedText + " text is displayed", LogAs.PASSED, null);
                } catch (Exception e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(sExpectedText + " text is displayed", LogAs.FAILED, null);
                }
                break;
        }
    }

    public static void scrollToFooter(WebDriver webDriver) {
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //indian code, reuse temporyly
    public static void switchToWindow(Logger logger, WebDriver webDriver) {
        logger.info("Detect new windows.");
        String parentWin = null;
        String newWin = null;
        Set<String> handles = webDriver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            parentWin = it.next();
            newWin = it.next();

        }
        logger.info("Swithc to new windwos.");
        webDriver.switchTo().window(newWin);

    }

    /**
     * Refactored by huy.huynh on 01/06/2017.
     * New for smoke test
     */
    public static WebElement getElement(WebDriver webDriver, String xpath, String... arg) {
        WebElement webElement = null;
        xpath = String.format(xpath, arg);
        try {
            webElement = webDriver.findElement(By.xpath(xpath));
        } catch (Exception ex) {
            NXGReports.addStep("Can't find element for xpath: " + xpath, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return webElement;
    }

    public static void visibilityOfElementWait(WebDriver webDriver, WebElement webElement, String elementName, int waitTime) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, waitTime);
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(elementName + " is not Visible", LogAs.FAILED, null);
        }
    }

    // Loading the URL by keeping in config properties
    public static void loadURL(WebDriver webDriver, String sUrl) {
        try {
            System.out.println(sUrl);
            webDriver.get(sUrl);
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
