package com.auvenir.ui.services;

import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.ui.pages.marketing.MarketingPage;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.WebService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    public static WebDriverWait sWebDriverWait = null;
    public static String gmailWindow;

    /*
    Variable to validate Passed - Failed of a TestCases
     */
    public static int sStatusCnt = 0;

    /**
     * Base url this value is set at runtime.
     */
    private String baseUrl = "https://ariel.auvenir.com";
    MarketingPage homePO;
    private final String keywordApiDelete = "/delete";
    private final String keywordApiUpdateActive = "/update?status=ACTIVE";
    private final String keywordApiUpdateOnboading = "/update?status=ONBOARDING";

    private String apiUrl = "";

    public void setApiUrl(String apiURL) {
        this.apiUrl = "https://" + apiURL;
        getLogger().info("API Url: " + this.apiUrl);
    }

    public String getApiUrl() {
        return apiUrl;
    }

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
        homePO = new MarketingPage(getLogger(), getDriver());
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
            if (prefixProtocol == "") {
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
            if ("".equals(prefixProtocol)) {
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
            if (sLanguage == null) {
                sLanguage = "English";
            }
            getLogger().info(sLanguage);
            if (sLanguage.equals("French")) {
                getLogger().info("Language is : " + baseLanguage);
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
        if (prefixProtocol == "") {
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
            getLogger().info("Go to home auvenri url : " + homeAuvenir);
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

    public void callRestApiUpdateUser(String userId, String keywordUpdate) {
        try {
            getLogger().info("Update user role: " + userId);
            setApiUrl(System.getProperty("apiURL") + "/api/user/");
            String apiUpdateUserUrl = getApiUrl() + userId + keywordUpdate;
            driver.get(apiUpdateUserUrl);
            String s1 = driver.findElement(By.xpath("//pre")).getText();
//            String[] parts = s1.split("(\")");
//            String statusCode = parts[6];
//            statusCode = StringUtils.replaceChars(statusCode, ":", "");
//            statusCode = StringUtils.replaceChars(statusCode, "}", "");
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
            System.out.println("Status Code: " + s1);
            if (s1.contains("\"code\":200")) {
                getLogger().info("Existed user is deleted successful.");
            } else if (s1.contains("\"code\":400")) {
                getLogger().info("The client is not existed in database.");
            } else {
                getLogger().info(s1);
            }
            NXGReports.addStep("Call API service successfully" + userId, LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Call API service unsuccessfully" + userId, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * Delete User using API Url
     * @param userEmail The email which is deleted.
     */
    public void deleteUserUsingApi(String userEmail) {
        callRestApiUpdateUser(userEmail, keywordApiDelete);
    }

    /**
     * Update status of user to Onboarding using API Url
     * @param userEmail The email which is updated.
     */
    public void updateUserOnboardingUsingAPI(String userEmail) {
        callRestApiUpdateUser(userEmail, keywordApiUpdateOnboading);
    }

    /**
     * Update status of user to Active using API Url
     * @param userEmail The email which is updated.
     */
    public void updateUserActiveUsingAPI(String userEmail) {
        callRestApiUpdateUser(userEmail, keywordApiUpdateActive);
    }

    /*
    Refactoring to join AbstractRefactorService
     */
    public void loadURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL) {
        driver.get(sGetTokenURL + sEmailID);
        String s1 = driver.findElement(By.xpath("//pre")).getText();
        String[] parts = s1.split("(\")");
        String token = parts[3];
        GenericService.setConfigValue(GenericService.sConfigFile, "LOGIN_URL", sCheckTokenURL + sEmailID + "&token=" + token);
        driver.get(sCheckTokenURL + sEmailID + "&token=" + token);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //Getting the URl by passing Dev Auth ID and Authentication key

    public void setURL(String sEMAILID, String sAUTHID, String sLOGINURL, String sDevAuthID, String sApiKey) throws Exception {
        try {
            WebService http = new WebService(logger);
            http.gettingUserID(sEMAILID, sAUTHID, sDevAuthID, sApiKey);
            http.gettingURL(sEMAILID, sLOGINURL, sDevAuthID, sApiKey);
            System.out.println(GenericService.getConfigValue(GenericService.sConfigFile, sLOGINURL));
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load Logged-In Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


    public void visibilityOfElementWait(WebElement webElement, String elementName, int waitTime) {
        try {
            sWebDriverWait = new WebDriverWait(driver, waitTime);
            sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            sStatusCnt++;
            NXGReports.addStep(elementName + " is not Visible", LogAs.FAILED, null);
        }
    }

    public void gmaillLogin() throws Exception {
        try {
            GmailPage gmailLoginPo = new GmailPage(logger, driver);
            driver.get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            //gmailLoginPo.getEleSignInLink().click();
            if (gmailLoginPo.getEleEmailIDTxtFld().isDisplayed()) {
                gmailLoginPo.getEleEmailIDTxtFld().sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"));
                gmailLoginPo.getEleNextBtn().click();
            }
            Thread.sleep(5000);
            gmailLoginPo.getElePasswordTxtFld().sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_PWD"));
            gmailLoginPo.getEleSignInBtn().click();
            Assert.assertTrue(gmailLoginPo.getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
            Thread.sleep(5000);
            gmailLoginPo.getEleSearchTxtFld().sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_SEARCHMAIL"));
            gmailLoginPo.getEleSearchBtn().click();
            gmailLoginPo.getEleInviteMailLnk().click();
            gmailWindow = driver.getWindowHandle();

            gmailLoginPo.getEleStartBtn().click();
            switchToWindow();

            driver.close();
            driver.switchTo().window(parentWin);
        } catch (AssertionError e) {
            NXGReports.addStep("Page not Loaded", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void auditorLogout() throws Exception {
        Thread.sleep(10000);
        GmailPage gmailLoginPo = new GmailPage(logger, driver);
        driver.close();

        driver.switchTo().window(gmailWindow);
        gmailLoginPo.getEleProfileIcn().click();
        gmailLoginPo.getEleSignOutBtn().click();
    }

    /**
     * Refactored by huy.huynh on 06/06/2017.
     * New for smoke test
     */

    /**
     * Scroll to footer of current page
     *
     * @param webDriver current webDriver
     */
    public void scrollToFooter(WebDriver webDriver) {
        getLogger().info("Scroll down to see page footer.");
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Delete given email user
     *
     * @param email current webDriver
     */
    public String deleteUserViaAPI(String email) {
        String deleteURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                + email + "/delete";
        loadURL(deleteURL);
        return GeneralUtilities.getElementByXpath(getDriver(), "//pre").getText();
    }

    /**
     * Check if response code equal 200(success code)
     *
     * @param message response message
     * @param role    role of user: Admin, Auditor, Client..(for log n report only)
     */
    public void verifyAPIResponseSuccessCode(String message, String role) {
        getLogger().info(message);
        if (!message.contains("\"code\":200")) {
            NXGReports.addStep(role + " is delete fail. Message: " + message, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(role + " is delete fail");
            sStatusCnt++;
        } else {
            NXGReports.addStep(role + " is delete success. " + message, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(role + " is delete success.");
        }
    }

    /*-----------end of huy.huynh on 06/06/2017.*/
    /*
    Method to delete all existed mail in GMail.
     */
    public void deleteAllExistedGMail(String eGMail,String ePassword){
        getLogger().info("Try to delete all existed eGMail");
        try{
            GmailPage gmailLoginPo = new GmailPage(logger, driver);
            driver.get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginPo.signInGmail(eGMail,ePassword);
            gmailLoginPo.deleteAllMail();
        }catch (Exception e){
            getLogger().info("Unable to delete all existed mail.");
        }
    }
    /*
    Method to the lasted mail in GMail.
     */
    public void deleteTheLastedGMail(String eGMail,String ePassword){
        getLogger().info("Try to delete all existed eGMail");
        try{
            GmailPage gmailLoginPo = new GmailPage(logger, driver);
            driver.get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginPo.signInGmail(eGMail,ePassword);
            gmailLoginPo.deleteLastedMail();
        }catch (Exception e){
            getLogger().info("Unable to delete all existed mail.");
        }
    }

    /**
     * Delete user using MongoDB service.
     * @param email The email which is deleted.
     */
    public void deleteUserUsingMongoDB(String email) {
        try {
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), email);
        } catch (Exception e) {
            sStatusCnt++;
            NXGReports.addStep("User cannot be deleted.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    /**
     * Update status of user to ONBOARDING using MongoDB service.
     * @param email The email which is deleted.
     */
    public void updateUserOnboardingUsingMongoDB(String email) {
        try {
            MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), email, "status", "ONBOARDING");
        } catch (Exception e) {
            sStatusCnt++;
            NXGReports.addStep("User cannot be deleted.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    /**
     * Update status of user to ACTIVE using MongoDB service.
     * @param email The email which is updated.
     */
    public void updateUserActiveUsingMongoDB(String email) {
        try {
            MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), email, "status", "ACTIVE");
        } catch (Exception e) {
            sStatusCnt++;
            NXGReports.addStep("User cannot be deleted.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }
}
