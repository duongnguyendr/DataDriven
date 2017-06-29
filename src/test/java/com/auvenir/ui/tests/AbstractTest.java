package com.auvenir.ui.tests;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by cuong.nguyen on 4/24/2017.
 */

public class AbstractTest {
    private Logger logger = Logger.getLogger(AbstractTest.class);
    private WebDriver driver;
    /*
    refactor to fix hardcode
     */
    String localPropertiesDest = GenericService.sDirPath + "/local.properties";
    protected String testData = System.getProperty("user.dir") + "\\" + GenericService.getConfigValue(localPropertiesDest, "DATA_FILE");
    protected String SELENIUM_GRID_HUB = "http://192.168.1.50:4444/wd/hub";

    /*
    We should input 2 options:
        +SeleniumGrid
        +Local
     */
    public static final String httpProtocol = "http://";
    public static final int lagreTimeOut = 2000;
    private String runMode = "Local";

    public String getRunMode() {
        setRunMode(System.getProperty("runSeleniumMode"));
        return runMode;
    }

    public void setRunMode(String runSeleniumMode) {
        runMode = runSeleniumMode;
        getLogger().info("RunMode is: " + runMode);
    }

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
    // minh.nguyen updated May 26,2017 updated
    public static final String engagementName = "engagement 01";
    /*
    Doai.Tran fix
     */

    @BeforeSuite
    public void setConfig() {
        System.out.println("AAAAAAA");
        getRunMode();
        GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
        testData = System.getProperty("user.dir") + "\\" + GenericService.getConfigValue(GenericService.sConfigFile, "DATA_FILE");

        /*if (server.equalsIgnoreCase("cadet")) {
            GenericService.sConfigFile = GenericService.sDirPath + "/cadet.properties";
        } else if (server.equalsIgnoreCase("local")) {
            GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
        } else {
            GenericService.sConfigFile = GenericService.sDirPath + "/ariel.properties";
        }*/
    }

    @Parameters({"browser", "version", "os"})
    @BeforeMethod
    public void setUp(Method method, String browser, String version, String os) {
        getLogger().info("Before Method.");
        getRunMode();
        if (browser.equalsIgnoreCase("chrome")) {
            GenericService.sBrowserData = "chr.";
        } else if (browser.equalsIgnoreCase("firefox")) {
            GenericService.sBrowserData = "ff.";
        } else if (browser.equalsIgnoreCase("internet explorer")) {
            GenericService.sBrowserData = "ie.";
        } else if (browser.equalsIgnoreCase("safari")) {
            GenericService.sBrowserData = "saf.";
        } else if (browser.equalsIgnoreCase("edge")) {
            GenericService.sBrowserData = "edge.";
        }
        if(browser.equalsIgnoreCase("internet explorer")){
            GenericService.sBrowserTestNameList.add("IE_");
        }else{
            GenericService.sBrowserTestNameList.add(browser.toUpperCase()+"_");
        }

        getLogger().info("setUp: " + browser);
        testName = method.getName();
        logCurrentStepStart();
        AbstractService.sStatusCnt = 0;
        getLogger().info("=====*****======");
        try {
            if (runMode.equalsIgnoreCase("Local")) {
            /*
            Initialize Selenium Local WebDriver
             */
                if (GenericService.sBrowserData.equalsIgnoreCase("chr.")) {
                    //if (GenericService.getConfigValue(GenericService.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")) {
                    getLogger().info("Chrome is open.");
                    System.setProperty("webdriver.chrome.driver", GenericService.sDirPath + "/src/test/resources/chromedriver.exe");
                    DesiredCapabilities cap = setDownloadLocationChrome();
                    getLogger().info("Chrome is set");
                    driver = new ChromeDriver(cap);

                } else if (GenericService.sBrowserData.equalsIgnoreCase("ff.")) {
                    getLogger().info("Firefox is set");
                    System.setProperty("webdriver.gecko.driver", GenericService.sDirPath + "/src/test/resources/geckodriver.exe");

//                    ProfilesIni allProfiles = new ProfilesIni();
//                    System.setProperty("webdriver.gecko.driver", GenericService.sDirPath + "/src/test/resources/geckodriver.exe");
//                    //System.setProperty("webdriver.firefox.profile","your custom firefox profile name");
//                    String browserProfile = System.getProperty("webdriver.gecko.driver");
//                    FirefoxProfile profile = allProfiles.getProfile(browserProfile);
//                    profile.setAcceptUntrustedCertificates (true);
//                    driver = new FirefoxDriver(profile);

//                    DesiredCapabilities capabilities = new DesiredCapabilities();
//                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//                    driver = new FirefoxDriver(capabilities);

                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setAcceptUntrustedCertificates(false);
                    driver = new FirefoxDriver(profile);

//                    DesiredCapabilities dc = DesiredCapabilities.firefox();
//                    dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//
//                    FirefoxProfile profile = new FirefoxProfile();
//                    profile.setAcceptUntrustedCertificates(true);
//
//                    dc.setCapability(FirefoxDriver.PROFILE, profile);
//
//                    // this is the important line - i.e. don't use Marionette
//                    dc.setCapability(FirefoxDriver.MARIONETTE, true);
//
//                    driver =  new FirefoxDriver(dc);

                } else if (GenericService.sBrowserData.equalsIgnoreCase("ie.")) {
                    getLogger().info("Intetnet Explorer is set");
                    System.setProperty("webdriver.ie.driver", GenericService.sDirPath + "/src/test/resources/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                } else if (GenericService.sBrowserData.equalsIgnoreCase("edge.")) {
                    getLogger().info("Edge is set");
                    System.setProperty("webdriver.edge.driver", GenericService.sDirPath + "/src/test/resources/MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                }

            } else if (runMode.equalsIgnoreCase("SeleniumGrid")) {

            /*Initialize Selenium for Selenium Grid*/

                DesiredCapabilities capabilities;
                if (GenericService.sBrowserData.equalsIgnoreCase("chr.")) {
                    capabilities = DesiredCapabilities.chrome();
                    String downloadFilepath = GenericService.sDirPath+ "/src/test/resources/download/";
                    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                    chromePrefs.put("profile.default_content_settings.popups", 0);
                    chromePrefs.put("download.default_directory", downloadFilepath);
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs",chromePrefs);
                    //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                } else if (GenericService.sBrowserData.equalsIgnoreCase("ff.")) {
                    capabilities = DesiredCapabilities.firefox();
                } else if (GenericService.sBrowserData.equalsIgnoreCase("ie.")) {
                    capabilities = DesiredCapabilities.internetExplorer();
                } else if (GenericService.sBrowserData.equalsIgnoreCase("saf.")) {
                    capabilities = DesiredCapabilities.safari();
                } else if (GenericService.sBrowserData.equalsIgnoreCase("edge.")) {
                    capabilities = DesiredCapabilities.edge();
                } else {
                    throw new IllegalArgumentException("Unknown browser - " + GenericService.sBrowserData);
                }

                if (os.equalsIgnoreCase("WIN10")) {
                    capabilities.setPlatform(Platform.WIN10);
                } else if (os.equalsIgnoreCase("WIN8")) {
                    capabilities.setPlatform(Platform.WIN8);
                } else if (os.equalsIgnoreCase("LINUX")) {
                    capabilities.setPlatform(Platform.LINUX);
                } else if (os.equalsIgnoreCase("MAC")) {
                    capabilities.setPlatform(Platform.MAC);
                } else {
                    throw new IllegalArgumentException("Unknown platform - " + os);
                }
                driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilities, capabilities);
            }
            NXGReports.setWebDriver(driver);
        } catch (Exception e) {
            getLogger().info("Problem in launching driver");
            e.printStackTrace();
        }
    }

    public void closeAllTab() {
        String originalHandle = driver.getWindowHandle();
        //Do something to open new tabs
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }

        driver.switchTo().window(originalHandle);
        driver.quit();
    }

    @AfterMethod
    public void tearDown(Method method) {
        testName = method.getName();
        logger.info("Close .the browser.");
        closeAllTab();
        logCurrentStepEnd();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Logger getLogger() {
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
     * @param priority       priority of the message
     * @param differentiator message differentiator
     */
    protected void logForCurrentStep(Priority priority, String differentiator) {
        logForCurrentStep(priority, differentiator, null);
    }

    /**
     * Logs a message related to the current step.
     *
     * @param priority       priority of the message
     * @param differentiator message differentiator
     * @param t              exception/error that happened (if any)
     */
    protected void logForCurrentStep(Priority priority, String differentiator, Throwable t) {
        if (t == null) {
            logger.log(priority, "STEP INFO - " + testName + " - " + differentiator);
        } else {
            logger.log(priority, "STEP INFO - " + testName + " - " + differentiator, t);
        }
    }

    public DesiredCapabilities setDownloadLocationChrome(){
        //Vien.pham added some new rows to set Download dir of Chrome.
        String downloadFilepath = GenericService.sDirPath+ "/src/test/resources/download/";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        return cap;
    }

}

