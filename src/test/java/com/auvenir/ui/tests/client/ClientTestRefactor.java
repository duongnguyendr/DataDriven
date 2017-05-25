package com.auvenir.ui.tests.client;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.CreateNewAuditPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.auvenir.ui.pages.auditor.AddNewClientPage;
import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.client.*;
import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.ui.services.ClientService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thuan.duong on 5/24/2017.
 */
public class ClientTestRefactor extends AbstractTest {
    //Logger logger = Logger.getLogger(ClientTest.class);
    ClientLoginPage clientLoginPage = null;
    String expectedTxt = null;
    AuvenirPage auvenirPage =null;
    GmailPage gmailPage =null;
    CreateNewAuditPage createNewAuditPage =null;
    AddNewClientPage addNewClientPage =null;
    AuditorEngagementPage auditorEngagementPage =null;
    AdminLoginPage adminLoginPage =null;
    ClientOnBoardingPage clientOnBoardingPage =null;
    ClientDashboardPage clientDashboardPage =null;
    ClientHomePage clientHomePage = null;
    ClientRequestPage clientRequestPage =null;
    ClientFilesPage clientFilesPage =null;
    String sURL = null;
    String testCaseId = null;
    String sData[] = null;
    private ClientService clientService;

    DateFormat dateFormat = null;
    Date date = null;
    static String CurrentDate=null;
    private int waittime = 60;
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
     * @Description: To Verify the display of Elements in Client Home Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 7, enabled = false, description = "To Verify the display of Elements in Client Home Page")
    public void verifyClientHomePage() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        clientDashboardPage = new ClientDashboardPage(getLogger(), getDriver());
        clientHomePage = new ClientHomePage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        Actions actions = new Actions(getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        try {
            //driver.get("https://ariel.auvenir.com/api/user/"+GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ACTIVE_ID")+"/update?status=ACTIVE");
            //Thread.sleep(15000);
//            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            clientService.loginWithUserRole(userId);
            //Thread.sleep(5000);

            clientDashboardPage.verifyClientHeader();
            clientDashboardPage.getEleAuvenirHeaderImg().click();
            Thread.sleep(10000);
            auvenirPage.toValidate(clientHomePage.getEleMyAuditsTxt(), "My Audits Text", "Displayed");
            auvenirPage.toValidate(clientHomePage.getEleInProgressTxt(), "In Progress Text", "Displayed");
            auvenirPage.toValidate(clientHomePage.getEleCompletedTxt(), "Completed Text", "Displayed");
            //auvenirPage.toValidate(clientHomePage.getEleBusinessLogoImg(),"Business Logo Image", "Displayed");
            actions.moveToElement(clientHomePage.getEleDataGatheringIcn()).perform();
            Thread.sleep(3000);
            auvenirPage.toValidate(clientHomePage.getEleViewBtn(), "View Button", "Displayed");
            auvenirPage.toValidate(clientHomePage.getEleDataGatheringTxt(), "Data Gathering Text", "Displayed");
            Thread.sleep(5000);

            auvenirPage.toValidate(clientHomePage.getEleUntitledTxt(), "Untitled Text", "Displayed");
            auvenirPage.toValidate(clientHomePage.getEleUpdatedTxt(), "Updated Text", "Displayed");
            clientDashboardPage.verifyClientFooter();
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

//    /*
//     * @Description: Inviting a client
//     * @Author:Lakshmi BS
//     */
//    @Test(priority = 1, enabled = true, description = "Inviting a client from Auditor")
//    public void verifyInvitingNewClient() throws Exception {
//        try {
//            getLogger().info("Inviting a client from auditor.");
//            createNewAuditPage = new CreateNewAuditPage(getLogger(),getDriver());
//            addNewClientPage = new AddNewClientPage(getLogger(),getDriver());
//            auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
//            adminLoginPage = new AdminLoginPage(getLogger(),getDriver());
//            clientOnBoardingPage = new ClientOnBoardingPage(getLogger(),getDriver());
//            clientService = new ClientService(getLogger(),getDriver());
//            dateFormat = new SimpleDateFormat("MM/d/yyyy");
//            date = new Date();
//            CurrentDate = dateFormat.format(date);
//            String newClientData[] = GenericService.toReadExcelData("creating_NewClient_Data");
//            String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
//            getLogger().info("Login with Auditor user.");
////            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDIT_ID"),
////                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
////                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
//            clientService.loginWithUserRole(userId);
//            visibilityOfElementWait(auditorEngagementPage.getEleClientsLnk(), "Clients Link", 50);
//            Thread.sleep(5000);
//			/*
//			 * auditorEngagementPage.getEleClientsLnk().click();
//			 * auditorEngagementPage.getEleAddNewBtn().click();
//			 */
//            Assert.assertTrue(auditorEngagementPage.getEleCreateNewBtn().isDisplayed(), "Auditor failed to login");
//            NXGReports.addStep("Auditor login is successful", LogAs.PASSED, null);
//
//            auditorEngagementPage.getEleCreateNewBtn().click();
//            Thread.sleep(5000);
////            visibilityOfElementWait(createNewAuditPage.getEleSelectClientBtn(), "Select Client", 15);
//            Thread.sleep(8000);
//            createNewAuditPage.getEleSelectClientBtn().click();
////            visibilityOfElementWait(createNewAuditPage.getElePleaseSelectYourTxt(), "Please Select your text", 15);
//            Assert.assertTrue(createNewAuditPage.getElePleaseSelectYourTxt().isDisplayed(),
//                    "Please select your client text is not displayed");
//            NXGReports.addStep("Please select your client text is displayed successful", LogAs.PASSED, null);
//            Thread.sleep(3000);
//
//            createNewAuditPage.getEleSelectYourClientDrpDwn().click();
////            visibilityOfElementWait(createNewAuditPage.getEleCreateNewClientDrpDwn(), "Create New Client Drop Down", 10);
//            createNewAuditPage.getEleCreateNewClientDrpDwn().click();
//            try {
//                createNewAuditPage.getEleContinueBtn().click();
//            } catch (Exception e) {
//
//            }
////            visibilityOfElementWait(createNewAuditPage.getEleAddNewClientTxt(), "Add New Client", 15);
//            Thread.sleep(8000);
//            Assert.assertTrue(createNewAuditPage.getEleAddNewClientTxt().isDisplayed(),
//                    "Add New Client page is not displayed");
//            NXGReports.addStep("Add New Client page is displayed successfully", LogAs.PASSED, null);
//
//            addNewClientPage.getEleLegalNameOfEntityTxtFld().sendKeys(newClientData[1]);
//            NXGReports.addStep(newClientData[1] + " Data entered in Legal Name of Entity Text field successfully",
//                    LogAs.PASSED, null);
//            addNewClientPage.getEleFirstAndLastNameTxtFld().sendKeys(newClientData[2]);
//            NXGReports.addStep(newClientData[2] + " Data entered in First and Last Name Text field successfully",
//                    LogAs.PASSED, null);
//            addNewClientPage.getEleEmailAddressTxtFld()
//                    .sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID"));
//            NXGReports.addStep(GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID")
//                    + " Data entered in Email ID Text field successfully", LogAs.PASSED, null);
//            addNewClientPage.getElePhoneNumberTxtFld().sendKeys(newClientData[3]);
//            NXGReports.addStep(newClientData[3] + " Data entered in Phone Number Text field successfully", LogAs.PASSED,
//                    null);
//            addNewClientPage.getEleTheLegalNameChkBox().click();
//            addNewClientPage.getEleTheEntityIsPubliclyListedChkBox().click();
//            addNewClientPage.getEleTheEntityHasOperationsChkBox().click();
//            addNewClientPage.getElePleaseListParentTxtFld().sendKeys(newClientData[4]);
//            NXGReports.addStep(newClientData[4] + " Data entered in List of Parent Company Text field successfully",
//                    LogAs.PASSED, null);
//            addNewClientPage.getEleIndustryDrpDwn().click();
//            addNewClientPage.getEleSelectIndustryTypeDrpDwn().click();
//            Thread.sleep(10000);
//            addNewClientPage.getElePleaseListParentTxtFld().sendKeys(Keys.PAGE_DOWN);
//
//            Thread.sleep(5000);
//            addNewClientPage.getEleAccountingFrameWorkDrpDwn().click();
//
//            addNewClientPage.getEleSelectAccountingFrameWorkDrpDwn().click();
//            addNewClientPage.getEleAddressTxtFld().sendKeys(newClientData[5]);
//            NXGReports.addStep(newClientData[5] + " Data entered in Street Number Text field successfully",
//                    LogAs.PASSED, null);
//
//            addNewClientPage.getEleUnitNumberTxtFld().sendKeys(newClientData[7]);
//            NXGReports.addStep(newClientData[7] + " Data entered in Unit Number Text field successfully", LogAs.PASSED,
//                    null);
//            addNewClientPage.getEleCityTxtFld().sendKeys(newClientData[8]);
//            NXGReports.addStep(newClientData[8] + " Data entered in City Text field successfully", LogAs.PASSED, null);
//            addNewClientPage.getEleProvinceStateTxtFld().sendKeys(newClientData[9]);
//            NXGReports.addStep(newClientData[9] + " Data entered in Province State Text field successfully",
//                    LogAs.PASSED, null);
//
//            addNewClientPage.getEleCountryTxtFld().sendKeys("France");
//            NXGReports.addStep(newClientData[9] + " Data entered in Province State Text field successfully",
//                    LogAs.PASSED, null);
//
//            addNewClientPage.getElePostalCodeTxtFld().sendKeys(newClientData[10]);
//            NXGReports.addStep(newClientData[10] + " Data entered in Postal Code Text field successfully", LogAs.PASSED,
//                    null);
//
//
//            Thread.sleep(5000);
//            getLogger().info("click country field.");
//            addNewClientPage.getElePleaseListParentTxtFld().click();
//
//
//            Thread.sleep(5000);
//            getLogger().info("click Add button.");
//            addNewClientPage.getEleAddBtn().click();
//            Thread.sleep(5000);
//            getLogger().info("Click select button.");
//            createNewAuditPage.getEleSelectBtn().click();
////            visibilityOfElementWait(createNewAuditPage.getEleSelectYourClientDrpDwn(), "Select Your Client Drop Down", 10);
//            getLogger().info("Select client.");
//            createNewAuditPage.getEleSelectYourClientDrpDwn().click();
//            Thread.sleep(3000);
//            createNewAuditPage.getEleSelectCreatedClientDrpDwn(newClientData[2]).click();
//            getLogger().info("click continue button.");
////            visibilityOfElementWait(createNewAuditPage.getEleContinueBtn(), "Continue Button",waittime);
//            createNewAuditPage.getEleContinueBtn().click();
//            Thread.sleep(5000);
//
//            Assert.assertTrue(createNewAuditPage.getEleInviteBtn().isDisplayed(), "New Client is not created");
//            NXGReports.addStep("New Client is successfully created", LogAs.PASSED, null);
//
//            createNewAuditPage.getEleInviteBtn().click();
//            Thread.sleep(5000);
//            Assert.assertTrue(createNewAuditPage.getEleResendBtn().isDisplayed(), "Engagement invitation is not sent");
//            Thread.sleep(5000);
//            createNewAuditPage.getEleResendBtn().click();
//            Thread.sleep(5000);
//			/*loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
//					GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
//					GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
//			visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 15);
//			Assert.assertTrue(adminLoginPage.getEleAdminHdrTxt().getText().equals("Admin"),
//					"Admin Login is not successfull");
//			NXGReports.addStep("Admin Login is successfull", LogAs.PASSED, null);
//
//			Assert.assertTrue(adminLoginPage
//					.getEleAuditorStatusLst("CLIENT",
//							GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID"), CurrentDate)
//					.equals("Onboarding"), "Auditor is not created with Pending status");*/
//            // Assert.assertTrue(createNewAuditPage.getEleEnagagementInivitationTxt().getText().equals("Your
//            // engagement invitation has been sent."), "Engagement Invitation
//            // sent success message is not displayed");
//
//
//
//            NXGReports.addStep("Engagement Invitations is not sent successfully for Client", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//            throw e;
//        }
//    }

	/*
	 * @Description: To Verify the display of Elements in Email: Invitation from to complete your financial audit
	 * @Author: Lakshmi BS
	 */
}
