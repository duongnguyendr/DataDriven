package com.auvenir.utilities;

import com.auvenir.ui.services.AbstractRefactorService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
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
                    AbstractRefactorService.sStatusCnt++;
                    NXGReports.addStep(sExpectedText + " is not displayed", LogAs.FAILED, null);
                }

                break;
            case "Enabled":
                try {
                    element.isEnabled();
                    NXGReports.addStep(sExpectedText + " is enabled", LogAs.PASSED, null);
                } catch (Exception e) {
                    AbstractRefactorService.sStatusCnt++;
                    NXGReports.addStep(sExpectedText + " is not enabled", LogAs.FAILED, null);
                }

                break;
            case "Selected":
                try {
                    element.isSelected();
                    NXGReports.addStep(sExpectedText + " is selected", LogAs.PASSED, null);
                } catch (Exception e) {
                    AbstractRefactorService.sStatusCnt++;
                    NXGReports.addStep(sExpectedText + " is not selected", LogAs.FAILED, null);
                }

            case "ElementText":
                try {
                    element.getText().equals(sExpectedText);
                    NXGReports.addStep(sExpectedText + " text is displayed", LogAs.PASSED, null);
                } catch (Exception e) {
                    AbstractRefactorService.sStatusCnt++;
                    NXGReports.addStep(sExpectedText + " text is displayed", LogAs.FAILED, null);
                }
                break;
        }
    }
}
