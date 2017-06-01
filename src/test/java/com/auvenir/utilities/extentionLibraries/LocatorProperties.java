package com.auvenir.utilities.extentionLibraries;

import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by huy.huynh on 29/05/2017.
 */
public class LocatorProperties {
    private Properties properties = null;

    private LocatorProperties() {
        try {
            if (properties == null) {
                FileInputStream fis = new FileInputStream(GenericService.LOCATORPROPERTIESFILE);
                properties = new Properties();
                properties.load(fis);
            }
        } catch (Exception ex) {
            NXGReports.addStep("Can't find/load DBProperties file", LogAs.FAILED, null);
            ex.printStackTrace();
        }
    }

//    public static By getElement(String elementName) {
//        LocatorProperties locatorProperties = new LocatorProperties();
//        String locator = locatorProperties.properties.getProperty(elementName);
//
//        return getObject(elementName, locator);
//    }

    public static By getElement(String elementName, String... arg) {
        LocatorProperties locatorProperties = new LocatorProperties();
        String locator = locatorProperties.properties.getProperty(elementName);
        locator = String.format(locator, arg);
//        System.out.println("++++++++++++++++locator = " + locator);
//        System.out.println("++++++++++++++--locator = " + getObject(elementName, locator));

        return getObject(elementName, locator);
    }

    /**
     * Find element BY using object type and value
     *
     * @param elementName
     * @return
     * @throws Exception
     */
    private static By getObject(String elementName, String locator) {
        if ((locator == null) || (locator.isEmpty())) {
            NXGReports.addStep("Locator not exist or empty for element: " + elementName, LogAs.FAILED, null);
            return null;
        }

        //Find by xpath
        if (elementName.endsWith("X")) {

            return By.xpath(locator);
        }
        //find by id
        else if (elementName.endsWith("I")) {

            return By.id(locator);
        }
        //find by class
        else if (elementName.endsWith("C")) {

            return By.className(locator);

        }
        //find by name
        else if (elementName.endsWith("N")) {

            return By.name(locator);

        }
        //Find by css
        else if (elementName.endsWith("S")) {

            return By.cssSelector(locator);

        }
        //find by link
        else if (elementName.endsWith("L")) {

            return By.linkText(locator);

        }
        //find by partial link
        else if (elementName.endsWith("P")) {

            return By.partialLinkText(locator);

        }
        //find by tag name
        else if (elementName.endsWith("T")) {

            return By.tagName(locator);

        } else {
            System.out.println("Wrong object type for element: " + elementName);
            NXGReports.addStep("Wrong object type for element: " + elementName, LogAs.FAILED, null);
            return null;
        }
    }
}
