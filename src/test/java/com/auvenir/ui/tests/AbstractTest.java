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
    protected String SELENIUM_GRID_HUB = "http://192.168.1.213:4444/wd/hub";

    /*
    We should input 2 options:
        +SeleniumGrid
        +Local
     */
    public static final String httpProtocol = "http://";
    public static final int lagreTimeOut = 2000;
    private String toEmail = "";
    private String ccEmail = "";
    public String   getToEmail(){
        setToEmail(System.getProperty("toEmail"));
        return toEmail;
    }
    public void setToEmail(String tosEmail){
        toEmail = tosEmail;
        getLogger().info("Email that We will send report: " +tosEmail);
    }
    public String  getCcEmail(){
        setCcEmail(System.getProperty("ccEmail"));
        return ccEmail;
    }
    public void setCcEmail(String tocEmail){
        ccEmail = tocEmail;
        getLogger().info("cc Email that We will send report: " +tocEmail);
    }
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
    //public static final String engagementName = "engagement 01";

    @BeforeSuite
    public void setConfig() {
        //System.out.println("AAAAAAA");
        getRunMode();
        getToEmail();
        getCcEmail();
        GenericService.sToEmail = toEmail;
        GenericService.sCcEmail = ccEmail;
        GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
        testData = System.getProperty("user.dir") + "\\" + GenericService.getConfigValue(GenericService.sConfigFile, "DATA_FILE");
        /*
        if (server.equalsIgnoreCase("cadet")) {
            GenericService.sConfigFile = GenericService.sDirPath + "/cadet.properties";
        } else if (server.equalsIgnoreCase("local")) {
            GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
        } else {
            GenericService.sConfigFile = GenericService.sDirPath + "/ariel.properties";
        }
        */
    }


    @Parameters({"browser", "version", "os"})
    @BeforeMethod
    public void setUp(Method method, String browser, String version, String os) {
        getLogger().info("Before Method.");
        getRunMode();
        GenericService.sVersionData = version;
        GenericService.sOperationData = os;
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
                if (browser.equalsIgnoreCase("chrome")) {
                    //if (GenericService.getConfigValue(GenericService.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")) {
                    getLogger().info("Chrome is open.");
                    System.setProperty("webdriver.chrome.driver", GenericService.sDirPath + "/src/test/resources/chromedriver.exe");
                    DesiredCapabilities cap = setDownloadLocationChrome();
                    getLogger().info("Chrome is set");
                    driver = new ChromeDriver(cap);
                    GenericService.sBrowserData = "chr.";
                } else if (browser.equalsIgnoreCase("firefox")) {
                    getLogger().info("Firefox is set");
                    System.setProperty("webdriver.gecko.driver", GenericService.sDirPath + "/src/test/resources/geckodriver.exe");
                    FirefoxProfile profile = setDownloadLocationFirefox();
                    driver = new FirefoxDriver(profile);
                    GenericService.sBrowserData = "ff.";
                } else if (browser.equalsIgnoreCase("internet explorer")) {
                    getLogger().info("Intetnet Explorer is set");
                    System.setProperty("webdriver.ie.driver", GenericService.sDirPath + "/src/test/resources/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    GenericService.sBrowserData = "ie.";
                } else if (browser.equalsIgnoreCase("edge")) {
                    getLogger().info("Edge is set");
                    System.setProperty("webdriver.edge.driver", GenericService.sDirPath + "/src/test/resources/MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                    GenericService.sBrowserData = "edge.";
                }

                if (browser.equalsIgnoreCase("internet explorer")){
                    GenericService.sBrowserTestNameList.add("IE_");
                }else {
                    GenericService.sBrowserTestNameList.add(browser.toUpperCase() + "_");
                }
            } else if (runMode.equalsIgnoreCase("SeleniumGrid")) {

            /*Initialize Selenium for Selenium Grid*/

                //DesiredCapabilities capabilities;
                if (browser.equalsIgnoreCase("chrome")) {
                    DesiredCapabilities capabilitiesChrome;
                    capabilitiesChrome = DesiredCapabilities.chrome();
                    String downloadFilepath = GenericService.sDirPath + "/src/test/resources/download/";
                    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                    chromePrefs.put("profile.default_content_settings.popups", 0);
                    chromePrefs.put("download.default_directory", downloadFilepath);
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", chromePrefs);
                    capabilitiesChrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilitiesChrome.setPlatform(setOSForBrowser(os));
                    capabilitiesChrome.setVersion(version);
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesChrome, capabilitiesChrome);
                    GenericService.sBrowserData = "chr.";
                } else if (browser.equalsIgnoreCase("firefox")) {
                    DesiredCapabilities capabilitiesFireFox;
                    capabilitiesFireFox = DesiredCapabilities.firefox();
                    FirefoxProfile profile = setDownloadLocationFirefox();
                    capabilitiesFireFox.setCapability(FirefoxDriver.PROFILE, profile);
                    capabilitiesFireFox.setPlatform(setOSForBrowser(os));
                    capabilitiesFireFox.setVersion(GenericService.sVersionData);
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesFireFox, capabilitiesFireFox);
                    GenericService.sBrowserData = "ff.";
                } else if (browser.equalsIgnoreCase("internet explorer")) {
                    DesiredCapabilities capabilitiesIE;
                    capabilitiesIE = DesiredCapabilities.internetExplorer();
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesIE, capabilitiesIE);
                    GenericService.sBrowserData = "ie.";
                } else if (browser.equalsIgnoreCase("safari")) {
                    DesiredCapabilities capabilitiesSafari;
                    capabilitiesSafari = DesiredCapabilities.safari();
                    capabilitiesSafari.setPlatform(setOSForBrowser(os));
                    capabilitiesSafari.setVersion(version);
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesSafari, capabilitiesSafari);
                    GenericService.sBrowserData = "saf.";
                } else if (browser.equalsIgnoreCase("edge")) {
                    DesiredCapabilities capabilitiesEdge;
                    capabilitiesEdge = DesiredCapabilities.edge();
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesEdge, capabilitiesEdge);
                    GenericService.sBrowserData = "edge.";
                } else {
                    throw new IllegalArgumentException("Unknown browser - " + GenericService.sBrowserData);
                }

                if (browser.equalsIgnoreCase("internet explorer")){
                    GenericService.sBrowserTestNameList.add("IE_");
                }else {
                    GenericService.sBrowserTestNameList.add(browser.toUpperCase() + "_");
                }
            }
            NXGReports.setWebDriver(driver);
        } catch (Exception e) {
            getLogger().info("Problem in launching driver");
            e.printStackTrace();
        }
    }

    public Platform setOSForBrowser(String os) {

        Platform osType = null;
        System.out.println("Current OS: " + os);
        if (os.equalsIgnoreCase("WIN10")) {
            osType = Platform.WIN10;
        } else if (os.equalsIgnoreCase("WIN8")) {
            osType = Platform.WIN8;
        } else if (os.equalsIgnoreCase("WIN8.1")) {
            osType = Platform.WIN8_1;
        } else if (os.equalsIgnoreCase("MAC")) {
            osType = Platform.MAC;
        } else {
            osType = Platform.LINUX;
        }
        return osType;
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

    public DesiredCapabilities setDownloadLocationChrome() {
        //Vien.pham added some new rows to set Download dir of Chrome.
        String downloadFilepath = GenericService.sDirPath + "/src/test/resources/download/";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        return cap;
    }

    /*
    Update for method: setDownload Location on Firefox
     */
    public FirefoxProfile setDownloadLocationFirefox() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        String downloadFilepath = GenericService.sDirPath + "/src/test/resources/download/";
        profile.setPreference("browser.download.dir", downloadFilepath);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-gzip");
        profile.setAcceptUntrustedCertificates(false);
        return profile;
    }

}

