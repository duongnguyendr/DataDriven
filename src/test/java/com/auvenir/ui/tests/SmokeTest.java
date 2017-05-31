package com.auvenir.ui.tests;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.CreateNewAuditPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.auvenir.ui.pages.auditor.AddNewClientPage;
import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorOnBoardingPage;
import com.auvenir.ui.pages.client.ClientOnBoardingPage;
import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.jayway.restassured.response.Response;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.given;

//import org.testng.log4testng.Logger;

public class SmokeTest extends AbstractRefactorService {
    public SmokeTest(Logger logger, WebDriver driver) {
        super(logger, driver);
    }
    //Logger logger = Logger.getLogger(SmokeTest.class);

    CreateNewAuditPage createNewAuditPage = null;
    Actions actions = null;
    AdminLoginPage adminLoginPage = null;

    AuditorOnBoardingPage auditorOnBoardingPage = null;
    AuvenirPage auvenirPage = null;
    DateFormat dateFormat = null;
    Date date = null;
    ClientOnBoardingPage clientOnBoardingPage = null;
    AuditorEngagementPage auditorEngagementPage = null;
    AddNewClientPage addNewClientPage = null;
    GmailPage gmailPage = null;
    //WebDriver driver = null;
    static String gmailWindowHandles;
    public static WebDriverWait sWebDriverWait = null;
    static String CurrentDate = null;
    public static String parentWin = null;
    public static String newWin = null;
    private static int waittime = 60;

    @Parameters({"server"})
    /*
	@BeforeSuite
	public void setServer(String server) {
		if (server.equalsIgnoreCase("cadet")) {
			getLogger().info("Set cadet properties.");
			GenericService.sConfigFile = GenericService.sDirPath + "/cadet.properties";
		}
		else if(server.equalsIgnoreCase("local")){
			getLogger().info("set local properties.");
			GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
		}
		else  {
			getLogger().info("Set ariel properties.");
			GenericService.sConfigFile = GenericService.sDirPath + "/ariel.properties";
		}

	}
*/

    @BeforeClass
    public void preRequiste() {

        String sURL = null;

        try {
            getLogger().info("Delete existed user before create.");

            sURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                    + GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID") + "/delete";
            getLogger().info("Call rest api: " + sURL);


            Response response = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(sURL);
            if (response.getStatusCode() == 200) {
                getLogger().info("The Auditor has been delete.");
            } else if (response.getStatusCode() == 404) {
                getLogger().info("The auditor is not existed in database.");
            } else {
            }

            sURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                    + GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID") + "/delete";
            getLogger().info("Call rest api: " + sURL);
            Response response1 = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(sURL);
            if (response1.getStatusCode() == 200) {
                getLogger().info("The client has been deleted successful.");
                NXGReports.addStep("Auditor is deleted sucessfully", LogAs.PASSED, null);
            } else if (response1.getStatusCode() == 404) {
                getLogger().info("the client is not existed in database.");
            } else {
            }


        } catch (Exception e) {
            System.out.println("Problem in launching driver");
            e.printStackTrace();
        }

    }

    /*
        @BeforeMethod
        public void setUp() {
            try {
                getLogger().info("Start browser");
                if (GenericService.getConfigValue(GenericService.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")) {
                    System.setProperty("webdriver.chrome.driver",
                            GenericService.sDirPath + "\\src\\tests\\resources\\chromedriver.exe");
                    getLogger().info("Chrome is set");
                     getDriver() = new ChromeDriver();

                } else {
                    getLogger().info("Firefox is set");
                    getDriver() = new FirefoxDriver();
                }
                NXGReports.setWebDriver(driver);

            } catch (Exception e) {
                getLogger().info("Problem in launching driver");
                e.printStackTrace();
            }
        }*/
/*
	@AfterMethod
	public void tearDown() {
		getLogger().info("Close the browser.");
		driver.quit();
	}
*/
	/*
	 * @Description: To verify admin is able to login
	 * 
	 * @Author:Vinay
	 */
    @Test(priority = 1, enabled = true, description = "To verify admin is able to login")
    public void adminLogin() throws Exception {
        try {
            getLogger().info("Login Auvenir with Admin role.");
            adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", waittime);
            //Thread.sleep(5000);
            getLogger().info("The text is rendered: " + adminLoginPage.getEleAdminHdrTxt().getText());
            Assert.assertTrue(adminLoginPage.getEleAdminHdrTxt().getText().equals("Admin"),
                    "Admin Login is not successfull");
            NXGReports.addStep("Admin Login is successfull", LogAs.PASSED, null);


        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*@Description: To verify auditor is created with status as pending in
     * admin panel
     * 	 * @Author:Vinay
     */
    @Test(priority = 2, enabled = true, description = "To verify auditor is created with status as pending in admin panel")
    public void auditorCreation() throws Exception {
        try {
            getLogger().info("Create Auditor");
            adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
            auvenirPage = new AuvenirPage(getLogger(), getDriver());
            dateFormat = new SimpleDateFormat("MM/d/yyyy");
            date = new Date();
            CurrentDate = dateFormat.format(date);

            getLogger().info("Login to home page.");
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "URL"));
            getLogger().info("wait for page load.");
            visibilityOfElementWait(auvenirPage.getEleAuditorEmailAddressTxtFld(), "Email Address Text Field", waittime);
            Assert.assertTrue(auvenirPage.getEleAuditorEmailAddressTxtFld().isDisplayed(),
                    "Auivenir application is not displayed");
            NXGReports.addStep("Auivenir application is displayed successfully", LogAs.PASSED, null);
            getLogger().info("Enter auditor email.");

            auvenirPage.getEleAuditorEmailAddressTxtFld()
                    .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));
            getLogger().info("click to regedit auditor user.");
            auvenirPage.getEleJoinBtn().click();

            getLogger().info("wait for wait aproval popup shown.");
            visibilityOfElementWait(auvenirPage.getEleAwaitingApprovalTxt(), "Awaiting Approval", waittime);
            Assert.assertTrue(auvenirPage.getEleAwaitingApprovalTxt().isDisplayed(),
                    "Awaiting approval popup is not displayed");
            NXGReports.addStep("Awaiting approval popup is successfully displayed", LogAs.PASSED, null);
            visibilityOfElementWait(auvenirPage.getEleDoneBtn(), "Awaiting Approval popup ", waittime);
            getLogger().info("click Done button.");
            auvenirPage.getEleDoneBtn().click();
            Thread.sleep(5000);
            getLogger().info("Login with admin role.");
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("Wait for admin logged in page load.");
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", waittime);
            Assert.assertTrue(adminLoginPage.getEleAdminHdrTxt().getText().equals("Admin"),
                    "Admin Login is not successfull");
            NXGReports.addStep("Admin Login is successfull", LogAs.PASSED, null);
            getLogger().info("verify registered auditor in wait listed status.");
            Assert.assertTrue(adminLoginPage
                    .getEleAuditorStatusLst("AUDITOR",
                            GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), CurrentDate)
                    .equals("Wait Listed"), "Auditor is not created with Pending status");
            NXGReports.addStep("Auditor is successfully created with Wait Listed status", LogAs.PASSED, null);
            getLogger().info("registered auditor user is in wait listed status.");
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: Changing the status of the Auditor to OnBoarding
     *
     * @Author:Vinay
     */
    @Test(priority = 3, enabled = true, description = "Change the status of the Auditor to OnBoarding")
    public void changeTheStatusAuditorToOnBoarding() throws Exception {
        try {
            getLogger().info("Change Status of Aditor to Onboarding.");
            adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
            clientOnBoardingPage = new ClientOnBoardingPage(getLogger(), getDriver());
            dateFormat = new SimpleDateFormat("MM/d/yyyy");
            date = new Date();
            CurrentDate = dateFormat.format(date);
            getLogger().info("Login with admin role.");
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("wait for logged in admin page load.");
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", waittime);
            Assert.assertTrue(adminLoginPage.getEleAdminHdrTxt().getText().equals("Admin"),
                    "Admin Login is not successfull");
            NXGReports.addStep("Admin Login is successfull", LogAs.PASSED, null);
            getLogger().info("change auditor to onboarding status.");
            adminLoginPage.getEleChangeOnBoardingStatus("AUDITOR",
                    GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), CurrentDate);
            getLogger().info("Login with auditor user.");
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("wait for confirm your tests message of auditor page..");
            visibilityOfElementWait(clientOnBoardingPage.getElePleaseConfirmYourInfoTxt(),
                    "Please confirm your Info Text", waittime);
            //Thread.sleep(5000);
            getLogger().info("check Auditor logged in page.");
            Assert.assertTrue(clientOnBoardingPage.getElePleaseConfirmYourInfoTxt().getText()
                    .equals("Please Confirm your Information"), "Onboarding Page is not displayed");
            NXGReports.addStep("Onboarding Page is displayed", LogAs.PASSED, null);
            NXGReports.addStep("Auditor is successfully landedup in OnBoarding Page", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }

    }

    /*
     * @Description: To Verify the display of Elements in Auditor Onboarding Page.
     * @Author: Jeevaraj SP
     */
    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Auditor Onboarding Page")
    public void verifyAuditorOnboardingPage() throws Exception {
        getLogger().info("Verify Auditor onboarding page.");
        String sData[] = null;
        AbstractRefactorService.sStatusCnt = 0;
        auditorOnBoardingPage = new AuditorOnBoardingPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        clientOnBoardingPage = new ClientOnBoardingPage(getLogger(), getDriver());
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        String testCaseId = "auditor_Onboarding";
        sData = GenericService.toReadExcelData(testCaseId);
        try {

            getLogger().info("Login with auditor user.");
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("Wait for page is loaded.");
            visibilityOfElementWait(auditorOnBoardingPage.getElePleaseConfirmTxt(), "Please Confirm your information", waittime);
            getLogger().info("verify logo is rendered.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleAuvenirLogoImg(), "Auvenir Logo", "Displayed");
            getLogger().info("verify personal text.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePersonalTxt(), "Personal Text", "Displayed");
            getLogger().info("verify firm text.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleFirmTxt(), "Firm Text", "Displayed");
            getLogger().info("verfify security text.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleSecurityTxt(), "Security Text", "Displayed");
            getLogger().info("verify personal image.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePersonalNumberCircleImg(), "Personal Number Circle Image", "Displayed");
            getLogger().info("verify firm image.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleFirmNumberCircleImg(), "Firm Number Circle Image", "Displayed");
            getLogger().info("verify security image.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleSecurityNumberCircleImg(), "Security Number Circle Image", "Displayed");
            getLogger().info("verify please confirm text.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePleaseConfirmTxt(), "Please Confirm your Information Text ", "Displayed");
            getLogger().info("verify first and last name text.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleFirstAndLastNameTxt(), "First and Last name Text", "Displayed");
            getLogger().info("verify first and last name text field.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleFirstAndLastNameTxtFld(), "First and Last name Text Field", "Displayed");
            getLogger().info("verify email address tests.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleEmailAddressTxt(), "Email Address Text", "Displayed");
            getLogger().info("verify email field.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleEmailAddressTxtFld(), "Email Address Text Field", "Displayed");
            getLogger().info("verify phone text.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePersonalPhoneNumberTxt(), "Personal Phone Number Text", "Displayed");
            getLogger().info("verify fone field.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePersonalPhoneNumberTxtFld(), "Personal Phone Number Text Field", "Displayed");
            getLogger().info("verify agree checkbox.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIAgreeToChkBox(), "I Agree to Check Box", "Displayed");
            getLogger().info("verify agree text.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIAgreeToTxt(), "I Agree to Text", "Displayed");
            getLogger().info("verify privacy link.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePrivacyLnk(), "Privacy link", "Displayed");
            getLogger().info("verify term and condition link.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleTermsAndConditionsLnk(), "Terms and Conditions link", "Displayed");
            getLogger().info("verify confirm checkbox.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIHerebyConfirmChkBox(), "I hereby confirm Check Box", "Displayed");
            getLogger().info("verify confirm text");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIHerebyConfirmTxt(), "I hereby confirm Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleCameraImg(), "Camera Image", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleUpdatePhotoBtn(), "Update Photo Button", "Enabled");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleContinueBtn(), "Continue button", "Enabled");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleNortonBadgesImg(), "Norton and Truste Image", "Displayed");
            auditorOnBoardingPage.getEleFirstAndLastNameTxtFld().clear();
            auditorOnBoardingPage.getEleFirstAndLastNameTxtFld().sendKeys(sData[1]);
            auditorOnBoardingPage.getElePersonalPhoneNumberTxtFld().click();
            auditorOnBoardingPage.getElePersonalPhoneNumberTxtFld().clear();
            auditorOnBoardingPage.getElePersonalPhoneNumberTxtFld().sendKeys(sData[2]);
            auditorOnBoardingPage.getEleIAgreeToChkBox().click();
            auditorOnBoardingPage.getEleIHerebyConfirmChkBox().click();
            getLogger().info("Wait for Continue button is enabled.");
            visibilityOfElementWait(auditorOnBoardingPage.getEleContinueBtn(), "Continue button", waittime);
            getLogger().info("click Continue button.");
            auditorOnBoardingPage.getEleContinueBtn().click();
            visibilityOfElementWait(auditorOnBoardingPage.getElePleaseProvideTxt(), "Please Provide your Firm Information", waittime);
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePleaseProvideTxt(), "Please Provide your Firm Information", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleNameTxt(), "Name Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleNameTxtFld(), "Name Text Field", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleNumberOfEmployeesTxt(), "Number of Employees Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleNumberOfEmployeesTxtFld(), "Number of Employees Text Field", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleFirmPhoneNumberTxt(), "Phone Number Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleFirmPhoneNumberTxtFld(), "Phone Number Text Field", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleAddressTxt(), "Address Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleAddressTxtFld(), "Address Text Field", "Displayed");
			
			/*
			GeneralUtilities.toValidate(auditorOnBoardingPage.getEleStreetNumberTxt(),"Street Number Text","Displayed");
			GeneralUtilities.toValidate(auditorOnBoardingPage.getEleStreetNumberTxtFld(),"Street Number Text Field","Displayed");
			GeneralUtilities.toValidate(auditorOnBoardingPage.getEleStreetTxt(),"Street Text","Displayed");
			GeneralUtilities.toValidate(auditorOnBoardingPage.getEleStreetTxtFld(),"Street Text Field","Displayed");
			*/
            //GeneralUtilities.toValidate(auditorOnBoardingPage.getEleUnitNumberTxt(),"Unit Number Text","Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleUnitNumberTxtFld(), "Unit Number Text Field", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleCityTxt(), "City Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleCityTxtFld(), "City Text Field", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleCountryTxt(), "Country Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleCountryTxtFld(), "Country Text Field", "Displayed");

            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleProvinceStateTxt(), "Province / State Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleProvinceStateTxtFld(), "Province / State Text Field", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePostalCodeZipCodeTxt(), "Postal Code / Zip Code Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePostalCodeZipCodeTxtFld(), "Postal Code / Zip Code Text Field", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIAmAffiliatedChkBox(), "I am affiliated Check Box", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIAmAffiliatedTxt(), "I am affiliated Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleContinueFirmBtn(), "Continue button", "Enabled");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleCameraFirmImg(), "Camera Firm Image", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleUpdatePhotoFirmBtn(), "Update Photo Firm Button", "Enabled");
            auditorOnBoardingPage.getEleNameTxtFld().clear();
            auditorOnBoardingPage.getEleNameTxtFld().sendKeys(sData[3]);
            auditorOnBoardingPage.getEleNumberOfEmployeesTxtFld().clear();
            auditorOnBoardingPage.getEleNumberOfEmployeesTxtFld().sendKeys(sData[4]);
            auditorOnBoardingPage.getEleFirmPhoneNumberTxtFld().clear();
            auditorOnBoardingPage.getEleFirmPhoneNumberTxtFld().sendKeys(sData[5]);
            auditorOnBoardingPage.getEleAddressTxtFld().clear();
            auditorOnBoardingPage.getEleAddressTxtFld().sendKeys(sData[6] + ", " + sData[7]);
			/*auditorOnBoardingPage.getEleStreetNumberTxtFld().clear();
			auditorOnBoardingPage.getEleStreetNumberTxtFld().sendKeys(sData[6]);
			auditorOnBoardingPage.getEleStreetTxtFld().clear();
			auditorOnBoardingPage.getEleStreetTxtFld().sendKeys(sData[7]);*/
            auditorOnBoardingPage.getEleUnitNumberTxtFld().clear();
            auditorOnBoardingPage.getEleUnitNumberTxtFld().sendKeys(sData[8]);
            auditorOnBoardingPage.getEleCityTxtFld().clear();
            auditorOnBoardingPage.getEleCityTxtFld().sendKeys(sData[9]);
            auditorOnBoardingPage.getEleProvinceStateTxtFld().clear();
            auditorOnBoardingPage.getEleProvinceStateTxtFld().sendKeys(sData[10]);
            auditorOnBoardingPage.getEleCountryTxtFld().clear();
            auditorOnBoardingPage.getEleCountryTxtFld().sendKeys(sData[9]);
            auditorOnBoardingPage.getElePostalCodeZipCodeTxtFld().clear();
            auditorOnBoardingPage.getElePostalCodeZipCodeTxtFld().sendKeys(sData[11]);
            auditorOnBoardingPage.getEleIAmAffiliatedChkBox().click();
            Thread.sleep(3000);
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleAffliatedNameTxt(), "Affliated Name - Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleAffliatedNameTxtFld(), "Affliated Name - Text Field", "Displayed");

            auditorOnBoardingPage.getEleAffliatedNameTxtFld().sendKeys(sData[9]);
            GeneralUtilities.toValidate(auvenirPage.getEleTermsOfUserFtrLnk(), "Terms of Service - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getElePrivacyPolicyFtrLnk(), "Privacy Statement - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleCookieNoticeFtrLnk(), "Cookie Notice footer - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleAllRightsReservedTxt(), "All Rights Reserversd - Text", "Displayed");
            getLogger().info("click continue button.");
            auditorOnBoardingPage.getEleContinueFirmBtn().click();
            //Thread.sleep(3000);
            getLogger().info("Wait for page load.");
            visibilityOfElementWait(auditorOnBoardingPage.getEleSetUpTxt(), "Setup security text", waittime);
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleSetUpTxt(), "Set Up Security Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleDownloadtheAuvenirTxt(), "Download the Auvenir Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleTextMeALinkBtn(), "Text me a link Button", "Enabled");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePhoneNumberSmsInputTxtFld(), "Phone number Text Field", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getElePhoneImg(), "Phone Image", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleAppStoreImg(), "App Store Image", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleGooglePlayImg(), "Google Play Image", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleSkipBtn(), "Skip Button", "Enabled");
            getLogger().info("Click skip button.");
            auditorOnBoardingPage.getEleSkipBtn().click();
            getLogger().info("wait for new page load.");
            visibilityOfElementWait(auditorOnBoardingPage.getEleSkipSecurityTxt(), "Skip security text", waittime);
            getLogger().info("The new page is loaded.");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleWarningImg(), "Warning Image", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleCloseImg(), "Close Image", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleSkipSecurityTxt(), "Skip Security Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleByChoosingTxt(), "By Choosing Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIAmDefaultingChkBox(), "I am Defaulting Check Box", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIAmDefaultingTxt(), "I am Defaulting Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleITakeResponsibilityChkBox(), "I Take Responsibility Check Box", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleITakeResponsibilityTxt(), "I Take Responsibility Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIAgreeToAuvenirChkBox(), "I Agree to Auvenir Check Box", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleIAgreeToAuvenirTxt(), "I Agree to Auvenir Text", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleTermsAndConditionsSkipSecurityLnk(), "Terms and Conditions Link", "Displayed");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleCancelSkipSecurityBtn(), "Cancel Button", "Enabled");
            GeneralUtilities.toValidate(auditorOnBoardingPage.getEleAgreeSkipSecurityBtn(), "Agree Button", "Enabled");
            auditorOnBoardingPage.getEleIAmDefaultingChkBox().click();
            auditorOnBoardingPage.getEleITakeResponsibilityChkBox().click();
            auditorOnBoardingPage.getEleIAgreeToAuvenirChkBox().click();
            getLogger().info("click Skip security button to finish.");
            auditorOnBoardingPage.getEleAgreeSkipSecurityBtn().click();
            //Thread.sleep(5000);
            getLogger().info("wait for new page is loaded.");
            visibilityOfElementWait(auditorEngagementPage.getEleCreateNewBtn(), "Create New Button", waittime);
            GeneralUtilities.toValidate(auditorEngagementPage.getEleCreateNewBtn(), "'Create New' Button", "Displayed");
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }

    }

    /*
     * @Description: Check the status of the Auditor being Active
     *
     * @Author:Vinay
     */
    @Test(priority = 5, enabled = true, description = "Check the status of the Auditor to Active")
    public void verifyTheStatusAuditorToActive() throws Exception {
        try {
            getLogger().info("Verify auditor status to active.");
            adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
            auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
            dateFormat = new SimpleDateFormat("MM/d/yyyy");
            date = new Date();
            CurrentDate = dateFormat.format(date);
            getLogger().info("Log in with admin user.");
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("Wait for admin logged in page load.");
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", waittime);
            Assert.assertTrue(adminLoginPage.getEleAdminHdrTxt().getText().equals("Admin"),
                    "Admin Login is not able to login correctly");
            NXGReports.addStep("Admin Login is able to login correctly", LogAs.PASSED, null);


            Assert.assertTrue(adminLoginPage
                    .getEleAuditorStatusLst("AUDITOR",
                            GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), CurrentDate)
                    .equalsIgnoreCase("Active"), "Auditor is not created with Active status");
            NXGReports.addStep("Auditor change to Active status", LogAs.PASSED, null);
			/*
			adminLoginPage.getEleChangeActiveStatus("AUDITOR",
					GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"), CurrentDate);
			Thread.sleep(5000);
			loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"),
					GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
					GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleAuvenirLogoImg(), "Auvenir Logo Image", 15);
			Assert.assertTrue(auditorEngagementPage.getEleAuvenirLogoImg().isDisplayed(), "Home Page is not displayed");
			NXGReports.addStep("Home Page is displayed", LogAs.PASSED, null);
			NXGReports.addStep("Auditor is successfully landedup in Home Page", LogAs.PASSED, null);*/
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }

    }

    /*
     * @Description: Inviting a client
     *
     * @Author:Vinay
     */
    @Test(priority = 6, enabled = true, description = "Inviting a client")
    public void invitingTheClient() throws Exception {
        try {
            getLogger().info("Invite client.");
            createNewAuditPage = new CreateNewAuditPage(getLogger(), getDriver());
            addNewClientPage = new AddNewClientPage(getLogger(), getDriver());
            auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
            adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
            clientOnBoardingPage = new ClientOnBoardingPage(getLogger(), getDriver());
            String newClientData[] = GenericService.toReadExcelData("creating_NewClient_Data");
            getLogger().info("Login with Auditor user.");
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("wait for page load.");
            visibilityOfElementWait(auditorEngagementPage.getEleClientsLnk(), "Clients Link", waittime);
            Assert.assertTrue(auditorEngagementPage.getEleCreateNewBtn().isDisplayed(), "Auditor failed to login");
            NXGReports.addStep("Auditor login is successful", LogAs.PASSED, null);
            auditorEngagementPage.getEleCreateNewBtn().click();
            visibilityOfElementWait(createNewAuditPage.getEleSelectClientBtn(), "Select Client button", waittime);
            createNewAuditPage.getEleSelectClientBtn().click();
            visibilityOfElementWait(createNewAuditPage.getElePleaseSelectYourTxt(), "Please Select your client text", waittime);
            Assert.assertTrue(createNewAuditPage.getElePleaseSelectYourTxt().isDisplayed(),
                    "Please select your client text is not displayed");
            NXGReports.addStep("Please select your client text is displayed successful", LogAs.PASSED, null);
            getLogger().info("click dropdown button to create new client.");
            createNewAuditPage.getEleSelectYourClientDrpDwn().click();
            getLogger().info("Wait for option shows..");
            visibilityOfElementWait(createNewAuditPage.getEleCreateNewClientDrpDwn(), "Create New Client Drop Down", 10);
            getLogger().info("Select Create new option.");
            createNewAuditPage.getEleCreateNewClientDrpDwn().click();
            //try {
            //	createNewAuditPage.getEleContinueBtn().click();
            //} catch (Exception e) {

            //}
            getLogger().info("Wait for creat new client page shows.");
            visibilityOfElementWait(createNewAuditPage.getEleAddNewClientTxt(), "Add New Client", 15);
            //Thread.sleep(8000);
            Assert.assertTrue(createNewAuditPage.getEleAddNewClientTxt().isDisplayed(),
                    "Add New Client page is not displayed");
            NXGReports.addStep("Add New Client page is displayed successfully", LogAs.PASSED, null);
            getLogger().info("enter client name.");
            addNewClientPage.getEleLegalNameOfEntityTxtFld().sendKeys(newClientData[1]);
            NXGReports.addStep(newClientData[1] + " Data entered in Legal Name of Entity Text field successfully",
                    LogAs.PASSED, null);
            getLogger().info("Enter first last name.");
            addNewClientPage.getEleFirstAndLastNameTxtFld().sendKeys(newClientData[2]);
            NXGReports.addStep(newClientData[2] + " Data entered in First and Last Name Text field successfully",
                    LogAs.PASSED, null);
            getLogger().info("Enter email.");
            addNewClientPage.getEleEmailAddressTxtFld()
                    .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"));
            NXGReports.addStep(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID")
                    + " Data entered in Email ID Text field successfully", LogAs.PASSED, null);
            getLogger().info("Enter phone.");
            addNewClientPage.getElePhoneNumberTxtFld().sendKeys(newClientData[3]);
            NXGReports.addStep(newClientData[3] + " Data entered in Phone Number Text field successfully", LogAs.PASSED,
                    null);
            getLogger().info("Select the legal name check box.");
            addNewClientPage.getEleTheLegalNameChkBox().click();
            getLogger().info("Select public checkbox.");
            addNewClientPage.getEleTheEntityIsPubliclyListedChkBox().click();
            getLogger().info("Select the entity operation checkbox.");
            addNewClientPage.getEleTheEntityHasOperationsChkBox().click();
            getLogger().info("Enter parent company check box.");
            addNewClientPage.getElePleaseListParentTxtFld().sendKeys(newClientData[4]);
            NXGReports.addStep(newClientData[4] + " Data entered in List of Parent Company Text field successfully",
                    LogAs.PASSED, null);
            getLogger().info("Select industry");
            addNewClientPage.getEleIndustryDrpDwn().click();
            addNewClientPage.getEleSelectIndustryTypeDrpDwn().click();
            Thread.sleep(3000);
            addNewClientPage.getElePleaseListParentTxtFld().sendKeys(Keys.PAGE_DOWN);

            Thread.sleep(3000);
            getLogger().info("Select framework.");
            addNewClientPage.getEleAccountingFrameWorkDrpDwn().click();

            addNewClientPage.getEleSelectAccountingFrameWorkDrpDwn().click();
            addNewClientPage.getEleAddressTxtFld().sendKeys(newClientData[5]);
            NXGReports.addStep(newClientData[5] + " Data entered in Street Number Text field successfully",
                    LogAs.PASSED, null);
            getLogger().info("Enter data for unit number.");
            addNewClientPage.getEleUnitNumberTxtFld().sendKeys(newClientData[7]);
            NXGReports.addStep(newClientData[7] + " Data entered in Unit Number Text field successfully", LogAs.PASSED,
                    null);
            addNewClientPage.getEleCityTxtFld().sendKeys(newClientData[8]);
            NXGReports.addStep(newClientData[8] + " Data entered in City Text field successfully", LogAs.PASSED, null);
            addNewClientPage.getEleProvinceStateTxtFld().sendKeys(newClientData[9]);
            NXGReports.addStep(newClientData[9] + " Data entered in Province State Text field successfully",
                    LogAs.PASSED, null);

            addNewClientPage.getEleCountryTxtFld().sendKeys("France");
            NXGReports.addStep(newClientData[9] + " Data entered in Province State Text field successfully",
                    LogAs.PASSED, null);

            addNewClientPage.getElePostalCodeTxtFld().sendKeys(newClientData[10]);
            NXGReports.addStep(newClientData[10] + " Data entered in Postal Code Text field successfully", LogAs.PASSED,
                    null);

            addNewClientPage.getEleCountryTxtFld().click();
            Thread.sleep(3000);
            addNewClientPage.getEleAddBtn().click();
            Thread.sleep(5000);

            createNewAuditPage.getEleSelectBtn().click();
            visibilityOfElementWait(createNewAuditPage.getEleSelectYourClientDrpDwn(), "Select Your Client Drop Down",
                    waittime);
            createNewAuditPage.getEleSelectYourClientDrpDwn().click();
            Thread.sleep(3000);
            createNewAuditPage.getEleSelectCreatedClientDrpDwn(newClientData[2]).click();
            visibilityOfElementWait(createNewAuditPage.getEleContinueBtn(), "Continue Button", 10);
            createNewAuditPage.getEleContinueBtn().click();
            Thread.sleep(5000);

            Assert.assertTrue(createNewAuditPage.getEleInviteBtn().isDisplayed(), "New Client is not created");
            NXGReports.addStep("New Client is successfully created", LogAs.PASSED, null);

            createNewAuditPage.getEleInviteBtn().click();
            Thread.sleep(5000);
            Assert.assertTrue(createNewAuditPage.getEleResendBtn().isDisplayed(), "Engagement invitation is not sent");
            // Assert.assertTrue(createNewAuditPage.getEleEnagagementInivitationTxt().getText().equals("Your
            // engagement invitation has been sent."), "Engagement Invitation
            // sent success message is not displayed");

            createNewAuditPage.getEleResendBtn().click();
            Thread.sleep(5000);
            NXGReports.addStep("Engagement Invitations is not sent successfully for Client", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: Client logs in and OnBoarding page is displayed
     *
     * @Author:Vinay
     */
    @Test(priority = 7, enabled = true, description = "Client logs in and OnBoarding page is displayed")
    public void clientLogsInAndOnBoards() throws Exception {
        dateFormat = new SimpleDateFormat("MM/d/yyyy");
        date = new Date();
        CurrentDate = dateFormat.format(date);
        clientOnBoardingPage = new ClientOnBoardingPage(getLogger(), getDriver());
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        try {
            getLogger().info("Client login and onboard.");
            gmailLogin();
            System.out.println("Tested four");

            Assert.assertTrue(clientOnBoardingPage.getElePleaseConfirmYourInfoTxt().isDisplayed(), "Onboarding Page is not displayed");
            System.out.println("Tested five");
            visibilityOfElementWait(clientOnBoardingPage.getElePleaseConfirmYourInfoTxt(),
                    "Please Confirm your Info Text", 5);
            Assert.assertTrue(clientOnBoardingPage.getElePleaseConfirmYourInfoTxt().getText()
                    .equals("Please Confirm your Information"), "Onboarding Page is not displayed");
            NXGReports.addStep("Client successfully logged in and Onboarding screen is displayed", LogAs.PASSED, null);
            //gmailLogout();
            NXGReports.addStep("Client successfully logged Out from Gmail", LogAs.PASSED, null);
            loadURL(GenericService.getConfigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 50);
            Assert.assertTrue(adminLoginPage.getEleAdminHdrTxt().getText().equals("Admin"),
                    "Admin Login is not able to login correctly");
            NXGReports.addStep("Admin Login is able to login correctly", LogAs.PASSED, null);
            Assert.assertTrue(adminLoginPage
                    .getEleClientStatusLst("CLIENT",
                            GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"), CurrentDate)
                    .equals("Onboarding"), "Client is not created with Active status");
            NXGReports.addStep("Client is created with Active status", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: Admin is able to delete the existing Auditor and Client
     *
     * @Author:Vinay
     */
    @Test(priority = 8, enabled = false, description = "Admin is able to delete the existing Auditor and Client")
    public void adminIsAbleToDeleteClientAndAuditor() throws Exception {
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        String sURL = null;
        try {
            getLogger().info("Admin delete client and auditor.");

            sURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                    + GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID") + "/delete";
            System.out.println(sURL);
            getDriver().get(sURL);
            System.out.println(adminLoginPage.getEleDeletedTxt().getText());
            Assert.assertTrue(
                    (adminLoginPage.getEleDeletedTxt().getText().contains("deleted"))
                            && (adminLoginPage.getEleDeletedTxt().getText().contains(
                            GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"))),
                    "Auditor is not deleted");
            NXGReports.addStep("Auditor is deleted sucessfully", LogAs.PASSED, null);
            sURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                    + GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID") + "/delete";
            getDriver().get(sURL);
            Assert.assertTrue(
                    (adminLoginPage.getEleDeletedTxt().getText().contains("deleted")) && (adminLoginPage.getEleDeletedTxt()
                            .getText().contains(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"))),
                    "Client is not deleted");
            NXGReports.addStep("Client is deleted sucessfully", LogAs.PASSED, null);
			/*
			 * visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(),
			 * "Admin Header Text",50); JavascriptExecutor javascriptExecutor =
			 * (JavascriptExecutor) driver;
			 * javascriptExecutor.executeScript("window.scrollBy(0,250)", "");
			 * adminLoginPage.getEleDeleteTheCreatedUser(GenericService.getConfigValue
			 * (GenericService.sConfigFile, "CLIENT_EMAIL_ID")); NXGReports.addStep(
			 * "Admin is able to delete Auditor sucessfully", LogAs.PASSED,
			 * null); driver.navigate().refresh();
			 * adminLoginPage.getEleDeleteTheCreatedUser(GenericService.getConfigValue
			 * (GenericService.sConfigFile, "AUDITOR_LOGIN_EMAILID"));
			 * NXGReports.addStep("Admin is able to delete Auditor sucessfully",
			 * LogAs.PASSED, null); driver.navigate().refresh();
			 */
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    // Getting the URL by passing GetTokenURL and CheckTokenURL
    public void loadURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL) {
        getDriver().get(sGetTokenURL + sEmailID);
        // String s1 = driver.findElement(By.xpath("//pre")).getText();
        String[] parts = getDriver().findElement(By.xpath("//pre")).getText().split("(\")");
        System.out.println(parts.length);
        String token = parts[3];
        loadURL(sCheckTokenURL + sEmailID + "&token=" + token);
    }

    // Loading the URL by keeping in config properties
    public void loadURL(String sUrl) {
        try {
            System.out.println(sUrl);
            getDriver().get(sUrl);
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED,
                    new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public void gmailLogin() throws Exception {
        try {
            gmailPage = new GmailPage(getLogger(), getDriver());
            getDriver().get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
            getLogger().info("Wait for gmail page load.");
            visibilityOfElementWait(gmailPage.getEleEmailIDTxtFld(), "Email field", waittime);
            if (gmailPage.getEleEmailIDTxtFld().isDisplayed()) {
                gmailPage.getEleEmailIDTxtFld()
                        .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"));
                gmailPage.getEleNextBtn().click();
            }
            visibilityOfElementWait(gmailPage.getElePasswordTxtFld(), "Passwd", waittime);
            gmailPage.getElePasswordTxtFld()
                    .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_PWD"));
            gmailPage.getEleSignInBtn().click();
            visibilityOfElementWait(gmailPage.getComposeTextFld(), "Compose", waittime);
            Assert.assertTrue(gmailPage.getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
            gmailPage.getEleSearchTxtFld().clear();
            gmailPage.getEleSearchTxtFld()
                    .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_SEARCHMAIL"));
            gmailPage.getEleSearchBtn().click();
            Thread.sleep(8000);
            gmailPage.inviteEmail();
            try {
                getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).click();
            } catch (Exception e) {

            }
            Thread.sleep(5000);
            Assert.assertTrue(gmailPage.getEleStartBtn().isDisplayed(), "Start Audit email is not displayed");
            NXGReports.addStep("Start Your Audit email is displayed", LogAs.PASSED, null);
            gmailPage.getEleStartBtn().click();
            switchToWindow();
            Thread.sleep(5000);
            getLogger().info("Tested three");
        } catch (AssertionError e) {
            NXGReports.addStep("Page not Loaded", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void gmailLogout() throws Exception {
        Thread.sleep(10000);
        getDriver().close();
        getDriver().switchTo().window(gmailWindowHandles);
        gmailPage.getEleProfileIcn().click();
        gmailPage.getEleSignOutBtn().click();
    }

    public void visibilityOfElementWait(WebElement webElement, String elementName, int waitTime) {
        try {
            sWebDriverWait = new WebDriverWait(getDriver(), waitTime);
            sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(elementName + " is not Visible", LogAs.FAILED, null);
        }
    }

    public void switchToWindow() {
        Set<String> handles = getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            parentWin = it.next();
            newWin = it.next();
            System.out.println("Tested");
        }
        getDriver().switchTo().window(newWin);
        System.out.println("Tested teo");
    }
}
