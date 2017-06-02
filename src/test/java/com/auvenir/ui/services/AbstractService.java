package com.auvenir.ui.services;

import com.auvenir.ui.pages.marketing.HomePage;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by cuong.nguyen on 4/25/2017.
 * Updated by Doai.Tran
 */
public class AbstractService {
    private WebDriver driver;
    private Logger logger;
    private static final int waitTime = 60;
    /*
    Variable to validate Passed - Failed of a TestCases
     */
    public static int sStatusCnt = 0;

    /**
     * Base url this value is set at runtime.
     */
    private String baseUrl = "https://ariel.auvenir.com";
    HomePage homePO;

    private String prefixProtocol = "";
    public String getPrefixProtocol() {
        return prefixProtocol;
    }

    public void setPrefixProtocol(String prefixProtocol) {
        this.prefixProtocol = prefixProtocol;
    }

    public AbstractService(Logger logger, WebDriver driver) {
        this.logger = logger;
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, waitTime), this);
        homePO = new HomePage(getLogger(), getDriver());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Logger getLogger() {
        return logger;
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String serverDomainName) {
        // S3 do not use HTTPS
        baseUrl = serverDomainName;
        getLogger().info("Url of testing server is: " + baseUrl);
    }

    public void loginWithUserRole(String userId, String getTokenUrl, String checkTokenUrl) {
        try {
            getLogger().info("Login with user role: " + userId);
            driver.get(getTokenUrl + userId);
            String s1 = driver.findElement(By.xpath("//pre")).getText();
            String[] parts = s1.split("(\")");
            String token = parts[3];
            GenericService.setConfigValue(GenericService.sConfigFile, "LOGIN_URL", checkTokenUrl + userId + "&token=" + token);
            driver.get(checkTokenUrl + userId + "&token=" + token);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            NXGReports.addStep("Login with userid: " + userId, LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Login with userid: " + userId, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public void loginWithUserRole(String userId) {
        try {
            getLogger().info("Login with user role: " + userId);
            if(prefixProtocol == "")
            {
                prefixProtocol = "https://";
            }
            setBaseUrl(prefixProtocol + System.getProperty("serverDomainName"));
            String getTokenUrl = getBaseUrl() + "/getToken?email=";
            getLogger().info("gettoken link: " + getTokenUrl);
            driver.get(getTokenUrl + userId);
            String s1 = driver.findElement(By.xpath("//pre")).getText();
            String[] parts = s1.split("(\")");
            String token = parts[3];
            String checkTokenUrl = getBaseUrl() + "/checkToken?email=";
            getLogger().info("checktokenurl: " + checkTokenUrl);
            GenericService.setConfigValue(GenericService.sConfigFile, "LOGIN_URL", checkTokenUrl + userId + "&token=" + token);
            driver.get(checkTokenUrl + userId + "&token=" + token);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            NXGReports.addStep("Login with userid: " + userId, LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Login with userid: " + userId, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }

    }

    public void executeAutoITScriptUploadImage(String AutoITScripDirectory, String fileDirectory) throws IOException {
        try {
            String[] cmdRun = new String[]{AutoITScripDirectory, fileDirectory};
            Runtime.getRuntime().exec(cmdRun);
            NXGReports.addStep("Execute AutoITScriptUploadImage successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Execute AutoITScriptUploadImage successfully", LogAs.FAILED, null);
            throw e;
        }
    }

    private String baseLanguage = "English";

    public String getLanguage() {
        return baseLanguage;
    }

    public void setLanguage(String language) {
        baseLanguage = language;
        getLogger().info("Language of page is: " + baseLanguage);
    }

    /*
    This method will be used on Advertisement and Marketing page.
     */
    public void goToBaseURL() {
        try {
            if("".equals(prefixProtocol))
            {
                prefixProtocol = "https://";
            }
            setBaseUrl(prefixProtocol + System.getProperty("serverDomainName"));
            String baseUrl = getBaseUrl();
            getLogger().info("Go to baseURL: " + baseUrl);
            driver.get(baseUrl);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            setLanguage(System.getProperty("language"));
            String sLanguage = getLanguage();
            if(sLanguage == null)
            {
                sLanguage = "English";
            }
            System.out.println(sLanguage);

            if (sLanguage.equals("French")) {
                System.out.println("Language is : " + baseLanguage);
                homePO.clickOnChangeLanguageBTN();
            }
            NXGReports.addStep("Go to home page successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("unable to go to home page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void loginToMarketingPage(String UserName, String Password) {
        try {
            goToBaseURL();
            homePO.clickOnLoginBTN();
            getLogger().info("Input Username and Password.");
            homePO.inputUserNamePassword(UserName, Password);
            getLogger().info("Click on Login button.");
            homePO.clickOnSubmitBTN();
            //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            homePO.waitPageLoad();
            homePO.waitForJSandJQueryToLoad();
        } catch (Exception e) {
            NXGReports.addStep("unable to login to Marketing page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    //Loading the URL by keeping in config properties
    private String homeAuvenirUrl = "https://ariel.auvenir.com";
    public String getHomeAuvenirUrl() {
        return homeAuvenirUrl;
    }

    public void setHomeAuvenirUrl(String serverDomainName) {
        if(prefixProtocol == "")
        {
            prefixProtocol = "https://";
        }
        // S3 do not use HTTPS
        homeAuvenirUrl = prefixProtocol + serverDomainName;
        getLogger().info("Url of testing server is: " + homeAuvenirUrl);
    }

    public void goToAuvenirHomePage() {
        try {
            setHomeAuvenirUrl(System.getProperty("serverDomainName"));
            String homeAuvenir = getHomeAuvenirUrl();
            getLogger().info("Go to home auvenri url : "+ homeAuvenir);
            System.out.println(homeAuvenir);
            driver.get(homeAuvenir);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public static String parentWin = null;
    public static String newWin = null;

    public void switchToWindow() {
        logger.info("Detect new windows.");
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            parentWin = it.next();
            newWin = it.next();

        }
        logger.info("Switch to new windwos.");
        driver.switchTo().window(newWin);

    }
    public void loadURL(String sUrl) {
        try {
            System.out.println(sUrl);
            driver.get(sUrl);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
