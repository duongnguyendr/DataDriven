package com.auvenir.ui.tests.client;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.CreateNewAuditPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.auvenir.ui.pages.auditor.AddNewClientPage;
import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.client.*;
import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.ClientService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.jayway.restassured.response.Response;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Date;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by thuan.duong on 5/24/2017.
 */
public class ClientTestRefactor extends AbstractTest {
    //Logger logger = Logger.getLogger(ClientTest.class);
    private ClientService clientService;

//	@BeforeClass
//	public void preCondition()
//	{
//
//		sURL = GenericService.getCongigValue(GenericService.sConfigFile, "DELETE_URL")
//				+ GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID") + "/delete";
//		getLogger().info("Call rest api to delete existed client user :" + sURL);
//		Response response = given().keystore(GenericService.sDirPath+"/src/tests/resources/auvenircom.jks","changeit").get(sURL);
//		if(response.getStatusCode()==200){
//			getLogger().info("Existed user is deleted successful.");
//
//		}
//		else if(response.getStatusCode()==404){
//			getLogger().info("The client is not existed in database.");
//		}
//		else {}
//	}
//
//
//	@AfterMethod
//	public void deleteCookies()
//	{
//		getDriver().manage().deleteAllCookies();
//	}

    /*
     * @Description: To Verify the display of Elements in Client Onboarding Page.
	 * @Author: Lakshmi BS
	 */
    @Test(priority = 3, enabled = true, description = "To Verify the display of Elements in Auditor Onboarding Page")
    public void verifyClientOnboardingPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        ClientOnBoardingPage clientOnBoardingPage = new ClientOnBoardingPage(getLogger(), getDriver());
        try {
            /*String onBoardingUrl;
            getLogger().info("update status of client to onboarding.");
            onBoardingUrl = GenericService.getCongigValue(GenericService.sConfigFile, "DELETE_URL") + GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID") + "/update?status=ONBOARDING";
            Response response = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(onBoardingUrl);
            if (response.getStatusCode() == 200) {
                getLogger().info("The client is on boarding.");
            } else {
            }*/
            //driver.get("https://ariel.auvenir.com/api/user/auvclient02@gmail.com/update?status=ONBOARDING");

//            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            clientService.loginWithUserRole(userId);
//            Thread.sleep(5000);
            clientService.verifyClientOnBoardingPersonalStep();
			/*
			clientOnBoardingPage.getEleFirstLastNameTxtFld().clear();
			clientOnBoardingPage.getEleFirstLastNameTxtFld().sendKeys(sData[1]);
			clientOnBoardingPage.getEleEmailAddressTxtFld().click();
			clientOnBoardingPage.getEleEmailAddressTxtFld().clear();
			clientOnBoardingPage.getEleEmailAddressTxtFld().sendKeys(sData[2]);*/

//            clientOnBoardingPage.getEleIAgreeImg().click();
//            Thread.sleep(3000);
//            clientOnBoardingPage.getEleContinueBtn().click();
//            Thread.sleep(5000);
//            GeneralUtilities.toValidate(clientOnBoardingPage.getElePleaseConfirmBuisnessTxt(), "Please confirm your buisness - Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleBuisnessNameTxt(), "Buisness Name Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleBuisnessNameTxtFld(), "Buisness Name Text Field", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleFiscalYearTxt(), "Fiscal Year End Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleFiscalYearTxtFld(), "Fiscal Year End Text Field", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleAccountingFrameTxt(), "Accounting Framework Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleAccountingFrameTxtFld(), "Accounting Framework Text Field", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleBuisnessCameraImg(), "Buisness Camera Image", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleBuisnessUploadBtn(), "Upload -Button", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleBuisnessContinueBtn(), "Continue button", "Enabled");
//            clientOnBoardingPage.getEleBuisnessContinueBtn().click();
//            Thread.sleep(5000);
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleIntegrateFileTxt(), "Integrate with your file storage - Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getElePleaseSelectTxt(), "Please select the directory - Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleGoogleDriveTxt(), "Google Drive - Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleGoogleDriveImg(), "Google Drive - Image", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleLocalTxt(), "Local - Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleLocalImg(), "Local Image", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleSkipBtn(), "Skip - Button", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleNotReadyTxt(), "Not ready to integrate - Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleYouCanSkipTxt(), "You can skip - Text", "Displayed");
//            clientOnBoardingPage.getEleSkipBtn().click();
//            Thread.sleep(5000);
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleSetUpTxt(), "Set Up Security - Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleDownloadtheAuvenirTxt(), "Download the auvenir - Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getElePhoneNumberSmsInputTxtFld(), "Phone Number - Text Fld", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleTextAppLinkBtn(), "Text App Link - Button", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getElePhoneImg(), "Phone Image", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleAppStoreImg(), "App Store Image", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleGooglePlayImg(), "Google Play Image", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleSkipBtn(), "Skip Button", "Enabled");
//            Robot rb = new Robot();
//            rb.keyPress(KeyEvent.VK_PAGE_DOWN);
//            Thread.sleep(3000);
//            clientOnBoardingPage.getEleSecuritySkipBtn().click();
//            Thread.sleep(5000);
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleWarningImg(), "Warning Image", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleCloseImg(), "Close Image", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleSkipSecurityTxt(), "Skip Security Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleByChoosingTxt(), "By Choosing Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleIAmDefaultingChkBox(), "I am Defaulting Check Box", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleIAmDefaultingTxt(), "I am Defaulting Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleITakeResponsibilityChkBox(), "I Take Responsibility Check Box", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleITakeResponsibilityTxt(), "I Take Responsibility Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleIAgreeToAuvenirChkBox(), "I Agree to Auvenir Check Box", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleIAgreeToAuvenirTxt(), "I Agree to Auvenir Text", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleTermsAndConditionsSkipSecurityLnk(), "Terms and Conditions Link", "Displayed");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleCancelSkipSecurityBtn(), "Cancel Button", "Enabled");
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleAgreeSkipSecurityBtn(), "Agree Button", "Enabled");
//            clientOnBoardingPage.getEleIAmDefaultingChkBox().click();
//            clientOnBoardingPage.getEleITakeResponsibilityChkBox().click();
//            clientOnBoardingPage.getEleIAgreeToAuvenirChkBox().click();
//            clientOnBoardingPage.getEleAgreeSkipSecurityBtn().click();
//            Thread.sleep(5000);
//
//            GeneralUtilities.toValidate(clientOnBoardingPage.getEleWelcomeToDashboardTxt(), "Welcome to DashBoard - Text", "Displayed");


			/*
			GeneralUtilities.toValidate(auditorOnBoardingPage.getEleStreetNumberTxt(),"Street Number Text","Displayed");
			GeneralUtilities.toValidate(auditorOnBoardingPage.getEleStreetNumberTxtFld(),"Street Number Text Field","Displayed");
			GeneralUtilities.toValidate(auditorOnBoardingPage.getEleStreetTxt(),"Street Text","Displayed");
			GeneralUtilities.toValidate(auditorOnBoardingPage.getEleStreetTxtFld(),"Street Text Field","Displayed");
			*/


            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }

    }

    /*
     * @Description: To Verify the display of Elements in Client Dashboard Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 6, enabled = true, description = "To Verify the display of Elements in Client Dashboard Page")
    public void verifyClientDashboardPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        try {
            //Will update later.
//            String onBoardingUrl;
//            getLogger().info("update status of client to active.");
//            onBoardingUrl = GenericService.getCongigValue(GenericService.sConfigFile, "DELETE_URL") + GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID") + "/update?status=ACTIVE";
//            Response response = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(onBoardingUrl);
//            if (response.getStatusCode() == 200) {
//                getLogger().info("The client is active.");
//            } else {
//            }
//            //driver.get("https://ariel.auvenir.com/api/user/"+ GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID")+"/update?status=ACTIVE");
//            Thread.sleep(15000);
//            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHomePage();
            clientService.clickDashBoardLink();
            clientService.verifyClientHeader();
            clientService.clickInboxMessage();
            clientService.clickNewMessageButton();
            clientService.verifyNewMessageForm();
            clientService.clickCloseMessageButton();
            clientService.clickDashBoardLink();
            clientService.verifyDashboardPage();
            clientService.verifyClientFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Client Dashboard Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Dashboard Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Dashboard Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Client Home Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 7, enabled = true, description = "To Verify the display of Elements in Client Home Page")
    public void verifyClientHomePage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        try {
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHeader();
            clientService.verifyClientInboxMessage();
            clientService.verifyMyAuditsPage();
            clientService.verifyClientFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Client Home Page.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Home Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Home Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Client Request Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 8, enabled = true, description = "To Verify the display of Elements in Client Request Page")
    public void verifyClientRequestPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        try {
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHomePage();
            clientService.clickRequestLnk();
            clientService.verifyClientRequestPage();
            clientService.verifyClientHeader();
            clientService.verifyGeneralLedgerTab();
            clientService.clickTrialBalanceMenuLink();
            clientService.verifyTrialBalanceTab();
            clientService.clickBankStatementsMenuLink();
            clientService.verifyBankStatementsTab();
            clientService.verifyClientFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Client Request Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Request Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Request Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Client Files Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 9, enabled = true, description = "To Verify the display of Elements in Client Files Page")
    public void verifyClientFilesPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        try {
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHomePage();
            clientService.clickFilesLink();
            clientService.verifyClientHeader();
            clientService.verifyFilesTab();
            clientService.verifyClientFooter();
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Client Files Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Files Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Files Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
