package com.auvenir.ui.tests;

import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.WebService;
import com.auvenir.utilities.listeners.TestngListener;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestMethodFinder;
import org.testng.ITestNGListener;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by cuong.nguyen on 4/24/2017.
 */

public class AbstractTest
{
    private Logger logger = Logger.getLogger(AbstractTest.class) ;
    private WebDriver driver;
    protected static final String SD_START = "start";
    /**
     * Default differentiator - end of the step.
     */
    protected static final String SD_END = "end";
    /**
     * Default differentiator - failure.
     */
    protected static final String SD_FAILURE = "failure";



    private String testName = "initial";

    @Parameters({"server"})
    @BeforeSuite
    public void setConfig(String server)
    {
        if(server.equalsIgnoreCase("cadet"))
        {
            GenericService.sConfigFile = GenericService.sDirPath+"/cadet.properties";
        }
        else if(server.equalsIgnoreCase("local")){
            GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
        }

        else
        {
            GenericService.sConfigFile = GenericService.sDirPath+"/ariel.properties";
        }
    }

    @BeforeMethod
    public void setUp(Method method)
    {
    	System.out.println("setUp");
        testName = method.getName();
        logCurrentStepStart();
        
        try
        {
            if(GenericService.getCongigValue(GenericService.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")){
                System.setProperty("webdriver.chrome.driver", GenericService.sDirPath+"/src/test/resources/chromedriver.exe");
                System.out.println("Chrome is set");
                driver = new ChromeDriver();
            }
            else
            {
                System.out.println("Firefox is set");
                System.setProperty("webdriver.gecko.driver", GenericService.sDirPath+"/src/test/resources/geckodriver.exe");

                driver = new FirefoxDriver();
            }
            NXGReports.setWebDriver(driver);
        }
        catch(Exception e)
        {
            System.out.println("Problem in launching driver");
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(Method method)
    {
        testName = method.getName();
        logger.info("Close the browser.");
        driver.quit();
        logCurrentStepEnd();
    }
    public WebDriver getDriver(){
        return driver;
    }
    public Logger getLogger(){
        return logger;
    }

    /**
     * Records the start of the current step.
     */
    @SuppressWarnings("deprecation")
    protected void logCurrentStepStart() {
    	System.out.println("logCurrentStepStart");
        logForCurrentStep(Priority.INFO, SD_START);

    }

    /**
     * Records the end of the current step.
     */
    @SuppressWarnings("deprecation")
    protected void logCurrentStepEnd() {
        logForCurrentStep(Priority.INFO, SD_END);

    }

    /**
     * Records a failure of the current step.
     *
     * @param t exception/error that happened
     */
    @SuppressWarnings("deprecation")
    protected void logCurrentStepFailure(Throwable t) {
        logForCurrentStep(Priority.FATAL, SD_FAILURE, t);

    }

    /**
     * Logs a message related to the current step.
     *
     * @param priority priority of the message
     * @param differentiator message differentiator
     */
    protected void logForCurrentStep(Priority priority, String differentiator) {
        logForCurrentStep(priority, differentiator, null);
    }

    /**
     * Logs a message related to the current step.
     *
     * @param priority priority of the message
     * @param differentiator message differentiator
     * @param t exception/error that happened (if any)
     */
    protected void logForCurrentStep(Priority priority, String differentiator, Throwable t) {
        if (t == null) {
            logger.log(priority, "STEP INFO - " + testName + " - " + differentiator);
        } else {
            logger.log(priority, "STEP INFO - " + testName + " - " + differentiator, t);
        }
    }




}

