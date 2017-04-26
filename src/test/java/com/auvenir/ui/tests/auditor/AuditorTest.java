package com.auvenir.ui.tests.auditor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.utilities.GenericService;
import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.auvenir.ui.pages.auditor.*;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auvenir.ui.pages.auditor.AuditorSettingsPage;
import com.auvenir.ui.pages.auditor.AddNewClientPage;
import com.auvenir.ui.pages.auditor.EngagementFilesPage;
import com.auvenir.ui.pages.EngagementRequestPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;

import static com.jayway.restassured.RestAssured.given;

public class AuditorTest extends AbstractRefactorService
{
	//Logger logger =Logger.getLogger(AuditorTest.class);
	AuditorOnBoardingPage auditorOnBoardingPage = null;
	AuditorEngagementPage auditorEngagementPage = null;

	AuditorDashboardPage auditorDashboardPage =null;
	EngagementRequestPage engagementRequestPage =null;
	EngagementFilesPage engagementFilesPage =null;

	AddNewClientPage addNewClientPage =null;
	AdminLoginPage adminLoginPage =null;
	AuditorClientPage auditorClientPage =null;
	AuditorSettingsPage auditorSettingsPage =null;
	
	AuvenirPage auvenirPage =null;
	String testCaseId = null;
	String sData[] = null;
	DateFormat dateFormat = null;
	Date date = null;
	static String CurrentDate=null;
	Actions actions=null;
	private int waittime=60;
	
	@BeforeClass
	public void preCondition()
	{
		getLogger().info("Delete existed Auditor user.");
		adminLoginPage = new AdminLoginPage(getLogger(),getDriver());
		String sURL = null;
	try{
		sURL = GenericService.getCongigValue(GenericService.sConfigFile, "DELETE_URL")+ GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID")+"/delete";
		getLogger().info("Call api to delete existed Audit user: " + sURL);
		//driver.get(sURL);
		Response response = given().keystore(GenericService.sDirPath+"/src/tests/resources/auvenircom.jks","changeit").get(sURL);
		if(response.getStatusCode()==200){
			getLogger().info("Existed auditor user has been deleted.");
			NXGReports.addStep("Auditor is deleted sucessfully", LogAs.PASSED, null);
		}
		else if(response.getStatusCode()==404){
			getLogger().info("the auditor is not existed in database.");
		}
		else {}

		
	}catch (Exception e) 
		{
			
		}
	}
		
	/* 
	 * @Description: To Verify the display of Elements in Auditor Login Page.
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=1,enabled=true, description="To Verify the display of Elements in Auditor Login Page")
	public void verifyAuditorLoginPage() throws Exception
	{	AbstractRefactorService.sStatusCnt=0;
		adminLoginPage =new AdminLoginPage(getLogger(),getDriver());
		auvenirPage = new AuvenirPage(getLogger(),getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_URL"));
			auvenirPage.toValidate(auvenirPage.getEleAuvenirImg(),"Auvenir Header Logo Image","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleAuditorLoginLnk(),"Auditor Login Link","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleAuditorLoginImg(),"Auditor Login Image","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleWeHelpYouAuditTxt(),"We help you audit Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleJoinTheWaitlistTxt(),"Join the Waitlist Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleWorkEmailTxt(),"Work Email Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleAuditorEmailAddressTxtFld(),"Auditor Email Address Text Field","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleJoinBtn(),"Join Button","Enabled");
			auvenirPage.toValidate(auvenirPage.getEleBySigningUpTxt(),"By signing up, you agree to our Terms of Use and Privacy Poclicy - Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleSpendLessTimeClockImg(),"Spend Less Time Clock Image","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleSpendLessTimeTxt(),"Spend Less Time Clock Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleUseSophisticatedTxt(),"Use Sophisticated Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleDevelopDeeperImg(),"Develop Deeper Image","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleDevelopDeeperTxt(),"Develop Deeper Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleLeverageMachineTxt(),"Leverage Machine Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleSecurelyManageImg(),"Securely Manage Image","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleSecurelyManageTxt(),"Securely Manage Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleAccessACloudTxt(),"Access a cloud Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getElePersonalizedForYouImg(),"Personalized for you Image","Displayed");
			auvenirPage.toValidate(auvenirPage.getElePersonalizedForYouTxt(),"Personalized for you Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleCustomizeSchedulesTxt(),"Customize Schedules Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleAccessAndManageTxt(),"Access and Manage Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleStoreAllTxt(),"Store All Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleAuvenirFooterImg(),"Auvenir Footer Image","Displayed");
			//auvenirPage.toValidate(auvenirPage.getEleJoinAsABusinessLnk(),"Join as a business link","Displayed");
			//auvenirPage.toValidate(auditorLoginPo.getEleJoinAsAnAuditorLnk(),"Join as an auditor link","Displayed");
			auvenirPage.verifyFooter();
			getLogger().info("click Login button.");
			auvenirPage.getEleAuditorLoginLnk().click();
			auvenirPage.toValidate(auvenirPage.getEleEmailAddressTxt(),"Email Address Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleEmailAddressPopUpTxtFld(),"Email Address PopUp Text Field","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleGoBtn(),"Go Button","Enabled");
			getLogger().info("enter auditor email.");
			auvenirPage.getEleEmailAddressPopUpTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"));
			auvenirPage.getEleGoBtn().click();
			//visibilityOfElementWait(auvenirPage.getEleWaitVerificationTxt(),"Wait verification text",waittime );
			visibilityOfElementWait(auvenirPage.getEleWaitVerificationTxt(),"Your email is awaiting verification",waittime );
			//auvenirPage.toValidate(auvenirPage.getEleWelcomePleaseCheckTxt(),"Welcome! Please Check Text","Displayed");
			//auvenirPage.toValidate(auvenirPage.getEleCloseBtn(),"Close Button","Enabled");
			//Thread.sleep(3000);
			auvenirPage.getEleAuditorEmailAddressTxtFld().sendKeys("auvaudit");
		//	auvenirPage.toValidate(auvenirPage.getEleNotValidEmailTxt(),"Not a valid email address - Text","Displayed");
			auvenirPage.getEleAuditorEmailAddressTxtFld().clear();
			auvenirPage.getEleAuditorEmailAddressTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"));
			auvenirPage.getEleJoinBtn().click();
			Thread.sleep(3000);
			Assert.assertTrue(auvenirPage.getEleAwaitingApprovalTxt().isDisplayed(),
					"Awaiting approval popup is not displayed");
			NXGReports.addStep("Awaiting approval popup is successfully displayed", LogAs.PASSED, null);
			visibilityOfElementWait(auvenirPage.getEleDoneBtn(), "Awaiting Approval popup ",15);
			
			auvenirPage.getEleDoneBtn().click();
			/*
			auvenirPage.toValidate(auvenirPage.getEleMailImg(),"Mail Image","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleCheckYourEmailTxt(),"Check your Email Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleWeSentTxt(),"We Sent Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleDoneBtn(),"Done Button","Enabled");
			auvenirPage.getEleDoneBtn().click();*/
			//Assert.assertTrue(driver.switchTo().frame("intercom-container").findElement(By.className("intercom-launcher-close-icon")).isDisplayed(),"Intercom chatting launcher is not displayed");
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e)
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
		
	/* 
	 * @Description: To Verify the display of Elements in Auditor Onboarding Page.
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=2,enabled=true, description="To Verify the display of Elements in Auditor Onboarding Page")
	public void verifyAuditorOnboardingPage() throws Exception
	{	AbstractRefactorService.sStatusCnt=0;
		auditorOnBoardingPage = new AuditorOnBoardingPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		testCaseId = "auditor_Onboarding";
		sData = GenericService.toReadExcelData(testCaseId);
		try
		{
			String onBoardingUrl;
            getLogger().info("update status of auditor to onboarding.");
			onBoardingUrl= GenericService.getCongigValue(GenericService.sConfigFile,"DELETE_URL")+ GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID") +"/update?status=ONBOARDING";
			Response response = given().keystore(GenericService.sDirPath+"/src/tests/resources/auvenircom.jks","changeit").get(onBoardingUrl);
			if(response.getStatusCode()==200){
				getLogger().info("The Auditor is on boarding.");
			}
			else {}

			getLogger().info("Login with auditor role.");
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			Thread.sleep(5000);
			auvenirPage.toValidate(auditorOnBoardingPage.getEleAuvenirLogoImg(),"Auvenir Logo","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePersonalTxt(),"Personal Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleFirmTxt(),"Firm Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleSecurityTxt(),"Security Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePersonalNumberCircleImg(),"Personal Number Circle Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleFirmNumberCircleImg(),"Firm Number Circle Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleSecurityNumberCircleImg(),"Security Number Circle Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePleaseConfirmTxt(),"Please Confirm Text ","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleFirstAndLastNameTxt(),"First and Last name Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleFirstAndLastNameTxtFld(),"First and Last name Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleEmailAddressTxt(),"Email Address Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleEmailAddressTxtFld(),"Email Address Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePersonalPhoneNumberTxt(),"Personal Phone Number Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePersonalPhoneNumberTxtFld(),"Personal Phone Number Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIAgreeToChkBox(),"I Agree to Check Box","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIAgreeToTxt(),"I Agree to Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePrivacyLnk(),"Privacy link","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleTermsAndConditionsLnk(),"Terms and Conditions link","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIHerebyConfirmChkBox(),"I hereby confirm Check Box","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIHerebyConfirmTxt(),"I hereby confirm Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleCameraImg(),"Camera Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleUpdatePhotoBtn(),"Update Photo Button","Enabled");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleContinueBtn(),"Continue button","Enabled");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleNortonBadgesImg(),"Norton and Truste Image","Displayed");
			auditorOnBoardingPage.getEleFirstAndLastNameTxtFld().clear();
			auditorOnBoardingPage.getEleFirstAndLastNameTxtFld().sendKeys(sData[1]);
			auditorOnBoardingPage.getElePersonalPhoneNumberTxtFld().click();
			auditorOnBoardingPage.getElePersonalPhoneNumberTxtFld().clear();
			auditorOnBoardingPage.getElePersonalPhoneNumberTxtFld().sendKeys(sData[2]);
			auditorOnBoardingPage.getEleIAgreeToChkBox().click();
			auditorOnBoardingPage.getEleIHerebyConfirmChkBox().click();
			Thread.sleep(3000);
			auditorOnBoardingPage.getEleContinueBtn().click();
			Thread.sleep(5000);
			auvenirPage.toValidate(auditorOnBoardingPage.getElePleaseProvideTxt(),"Please Provide Your Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleNameTxt(),"Name Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleNameTxtFld(),"Name Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleNumberOfEmployeesTxt(),"Number of Employees Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleNumberOfEmployeesTxtFld(),"Number of Employees Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleFirmPhoneNumberTxt(),"Phone Number Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleFirmPhoneNumberTxtFld(),"Phone Number Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleAddressTxt(),"Address Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleAddressTxtFld(),"Address Text Field","Displayed");
			
			/*
			auvenirPage.toValidate(auditorOnBoardingPage.getEleStreetNumberTxt(),"Street Number Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleStreetNumberTxtFld(),"Street Number Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleStreetTxt(),"Street Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleStreetTxtFld(),"Street Text Field","Displayed");
			*/
			//auvenirPage.toValidate(auditorOnBoardingPage.getEleUnitNumberTxt(),"Unit Number Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleUnitNumberTxtFld(),"Unit Number Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleCityTxt(),"City Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleCityTxtFld(),"City Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleCountryTxt(),"Country Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleCountryTxtFld(),"Country Text Field","Displayed");
			
			auvenirPage.toValidate(auditorOnBoardingPage.getEleProvinceStateTxt(),"Province / State Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleProvinceStateTxtFld(),"Province / State Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePostalCodeZipCodeTxt(),"Postal Code / Zip Code Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePostalCodeZipCodeTxtFld(),"Postal Code / Zip Code Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIAmAffiliatedChkBox(),"I am affiliated Check Box","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIAmAffiliatedTxt(),"I am affiliated Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleContinueFirmBtn(),"Continue button","Enabled");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleCameraFirmImg(),"Camera Firm Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleUpdatePhotoFirmBtn(),"Update Photo Firm Button","Enabled");
			auditorOnBoardingPage.getEleNameTxtFld().clear();
			auditorOnBoardingPage.getEleNameTxtFld().sendKeys(sData[3]);
			auditorOnBoardingPage.getEleNumberOfEmployeesTxtFld().clear();
			auditorOnBoardingPage.getEleNumberOfEmployeesTxtFld().sendKeys(sData[4]);
			auditorOnBoardingPage.getEleFirmPhoneNumberTxtFld().clear();
			auditorOnBoardingPage.getEleFirmPhoneNumberTxtFld().sendKeys(sData[5]);
			auditorOnBoardingPage.getEleAddressTxtFld().clear();
			auditorOnBoardingPage.getEleAddressTxtFld().sendKeys(sData[6]+", "+sData[7]);
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
			auvenirPage.toValidate(auditorOnBoardingPage.getEleAffliatedNameTxt(),"Affliated Name - Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleAffliatedNameTxtFld(),"Affliated Name - Text Field","Displayed");
		
			auditorOnBoardingPage.getEleAffliatedNameTxtFld().sendKeys(sData[9]);
			auvenirPage.toValidate(auvenirPage.getEleTermsOfUserFtrLnk(),"Terms of Service - Link","Displayed");
			auvenirPage.toValidate(auvenirPage.getElePrivacyPolicyFtrLnk(),"Privacy Statement - Link","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleCookieNoticeFtrLnk(),"Cookie Notice footer - Link","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleAllRightsReservedTxt(),"All Rights Reserversd - Text","Displayed");
			
			auditorOnBoardingPage.getEleContinueFirmBtn().click();
			Thread.sleep(3000);
			auvenirPage.toValidate(auditorOnBoardingPage.getEleSetUpTxt(),"Set Up Security Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleDownloadtheAuvenirTxt(),"Download the Auvenir Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleTextMeALinkBtn(),"Text me a link Button","Enabled");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePhoneNumberSmsInputTxtFld(),"Phone number Text Field","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getElePhoneImg(),"Phone Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleAppStoreImg(),"App Store Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleGooglePlayImg(),"Google Play Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleSkipBtn(),"Skip Button","Enabled");
			auditorOnBoardingPage.getEleSkipBtn().click();
			auvenirPage.toValidate(auditorOnBoardingPage.getEleWarningImg(),"Warning Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleCloseImg(),"Close Image","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleSkipSecurityTxt(),"Skip Security Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleByChoosingTxt(),"By Choosing Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIAmDefaultingChkBox(),"I am Defaulting Check Box","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIAmDefaultingTxt(),"I am Defaulting Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleITakeResponsibilityChkBox(),"I Take Responsibility Check Box","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleITakeResponsibilityTxt(),"I Take Responsibility Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIAgreeToAuvenirChkBox(),"I Agree to Auvenir Check Box","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleIAgreeToAuvenirTxt(),"I Agree to Auvenir Text","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleTermsAndConditionsSkipSecurityLnk(),"Terms and Conditions Link","Displayed");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleCancelSkipSecurityBtn(),"Cancel Button","Enabled");
			auvenirPage.toValidate(auditorOnBoardingPage.getEleAgreeSkipSecurityBtn(),"Agree Button","Enabled");
			
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		
	}
	
	
	/* 
	 * @Description: To Verify the display of Elements in Auditor Engagement Page.
	 * @Author: Yashi Priya
	 */
	@Test(priority=3,enabled=true, description="To Verify the display of Elements in Auditor Engagement Page")
	public void verifyAuditorEngagementPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auditorOnBoardingPage = new AuditorOnBoardingPage(getLogger(),getDriver());
		auditorDashboardPage = new AuditorDashboardPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			adminLoginPage = new AdminLoginPage(getLogger(),getDriver());
			auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
			dateFormat = new SimpleDateFormat("MM/d/yyyy");
			date = new Date();
			CurrentDate = dateFormat.format(date);
			
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
					GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
					GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text",15);
			Assert.assertTrue(adminLoginPage.getEleAdminHdrTxt().getText().equals("Admin"),
					"Admin Login is not able to login correctly");
			NXGReports.addStep("Admin Login is able to login correctly", LogAs.PASSED, null);
			adminLoginPage.getEleChangeActiveStatus("AUDITOR",
			GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), CurrentDate);
			NXGReports.addStep("status of auditor changed to ACTIVE", LogAs.PASSED, null);
			Thread.sleep(5000);
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			auvenirPage.verifyHeader();
			auvenirPage.toValidate(auditorEngagementPage.getEleEngagementLnk(),"Engagement Link","Displayed");
			auvenirPage.toValidate(auditorEngagementPage.getEleClientsLnk(),"Clients Link","Displayed");
			auvenirPage.toValidate(auditorEngagementPage.getEleMyEngmntTxt(),"My Engagement Text","Displayed");
			auvenirPage.toValidate(auditorEngagementPage.getEleCreateNewBtn(),"'Create New' Button","Displayed");
			auvenirPage.toValidate(auditorEngagementPage.getEleClickhereTipTxt(),"Click here tool tip - Text","Displayed");
			auvenirPage.toValidate(auditorEngagementPage.getEleYouDontHaveTxt(),"You dont have engagement - Text","Displayed");
			auvenirPage.verifyFooter();
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: To Verify the display of Elements in Auditor Dashboard Page.
	 * @Author: Yashi Priya
	 */
	@Test(priority=4,enabled=true, description="To Verify the display of Elements in Auditor Dashboard Page")
	public void verifyAuditorDashboardPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auditorOnBoardingPage = new AuditorOnBoardingPage(getLogger(),getDriver());
		auditorDashboardPage = new AuditorDashboardPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			auditorEngagementPage.auditorPageHeaderContent();
			auditorEngagementPage.getEleCreateNewBtn().click();
			auvenirPage.toValidate(auditorDashboardPage.getEleDashboardLnk(),"Dashboard Link","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleRequestLnk(),"Requests Link","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleFilesLnk(),"Files Link","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleActivityLnk(),"Activity Link","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleTaskDrpDwn(),"Current Tasks Dropdown","Displayed");
			for(WebElement eleTaskFormTxt: auditorDashboardPage.getEleTaskFormTxts())
			{
				auvenirPage.toValidate(eleTaskFormTxt, eleTaskFormTxt.getText(), "Displayed");
			}
			auvenirPage.toValidate(auditorDashboardPage.getEleSelectBtn(),"Select Button","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleSetBtn(),"Set Button","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleInviteBtn(),"Invite Button","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleArchiveBtn(),"Archive Button","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleMyClientTxt(),"My Client Text","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleProfileImg(),"Profile image","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleNoClientTxt(),"No Client - Text","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleMyClientImg(),"My client image","Displayed");
			//auvenirPage.toValidate(auditorDashboardPage.getEleSelectClientBtn(),"Select Client Button","Displayed");
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		
	}
	
	/* 
	 * @Description: To Verify the display of Elements in Engagement Requests Page.
	 * @Author: Yashi Priya
	 */
	@Test(priority=5,enabled=true, description="To Verify the display of Elements in Engagement Requests Page")
	public void verifyEngagementRequestsPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auditorDashboardPage = new AuditorDashboardPage(getLogger(),getDriver());
		engagementRequestPage = new EngagementRequestPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleCreateNewBtn(), "Create New Button",15);
			auditorEngagementPage.getEleCreateNewBtn().click();
			visibilityOfElementWait(auditorDashboardPage.getEleRequestLnk(), "Request Link",15);
			auditorDashboardPage.getEleRequestLnk().click();
			auvenirPage.toValidate(engagementRequestPage.getEleAllRequestsTxt(),"All Requests Text","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleCreateCategoryLnk(),"Create Category Link","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleGeneralLedgerTxt(),"General Ledger Text","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleDescriptionTxt(),"Description Text","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleDueDateTxt(),"Due Date Text","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleFileUploadIcn(),"File Upload Icon","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleDragDropTxt(),"All Requests Text","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleBrowseFileTxt(),"Browse File Text","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleFINANCIALSLnk(),"Financials - Link","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleGeneralLedgerLnk(),"General Ledger - Link","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleTrialBalanceLnk(),"Trial Balance - Link","Displayed");
			auvenirPage.toValidate(engagementRequestPage.getEleCompleteTxt(),"Complete - Text","Displayed");
			
			
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: To Verify the display of Elements in Engagement File Manager Page.
	 * @Author: Yashi Priya
	 */
	@Test(priority=6,enabled=true, description="To Verify the display of Elements in Engagement File Manager Page")
	public void verifyEngagementFilesPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auditorDashboardPage = new AuditorDashboardPage(getLogger(),getDriver());
		engagementFilesPage = new EngagementFilesPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleCreateNewBtn(), "Create New Button",15);
			auditorEngagementPage.getEleCreateNewBtn().click();
			visibilityOfElementWait(auditorDashboardPage.getEleFilesLnk(), "Files Link",15);
			auditorDashboardPage.getEleFilesLnk().click();
			auvenirPage.toValidate(engagementFilesPage.getEleFilesTxt(),"Files Text","Displayed");
			auvenirPage.toValidate(engagementFilesPage.getEleEmptyClipbrdImg(),"Empty Clipboard Image","Displayed");
			auvenirPage.toValidate(engagementFilesPage.getEleNoFilesTxt(),"'You haven't added any files yet.' text","Displayed");
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		
	}
	
	/* 
	 * @Description: To Verify the display of Elements in Engagement Activity Page.
	 * @Author: Yashi Priya
	 */
	@Test(priority=7,enabled=true, description="To Verify the display of Elements in Engagement Activity Page")
	public void verifyEngagementActivityPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auditorDashboardPage = new AuditorDashboardPage(getLogger(),getDriver());
		
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleCreateNewBtn(), "Create New Button",15);
			auditorEngagementPage.getEleCreateNewBtn().click();
			visibilityOfElementWait(auditorDashboardPage.getEleActivityLnk(), "Activity Link",15);
			auditorDashboardPage.getEleActivityLnk().click();
			auvenirPage.toValidate(auditorDashboardPage.getEleActivityFeedTxt(),"Activity Feed Text","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleActivityDayTxt(),"Activity Day Text","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleYouCreatedTxt(),"You created a new Engagement- Text","Displayed");
			
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
		
	/* 
	 * @Description: To Verify the display of Elements in Add New Client Page.
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=8,enabled=true, description="To Verify the display of Elements in Add New Client Page")
	public void verifyAddNewClientPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		addNewClientPage = new AddNewClientPage(getLogger(),getDriver());
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleClientsLnk(), "Clients Link",15);
			auditorEngagementPage.getEleClientsLnk().click();
			auditorEngagementPage.getEleAddNewBtn().click();
			auvenirPage.toValidate(addNewClientPage.getEleAddNewClientTxt(),"Add New Client Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleCloseBtn(),"Close Button","Enabled");
			auvenirPage.toValidate(addNewClientPage.getEleCompanyInformationTxt(),"Company Information Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleKeyContactInformationTxt(),"Contact Information Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleLegalNameOfEntityTxt(),"Legal Name of Entity Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleLegalNameOfEntityTxtFld(),"Legal Name of Entity Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleTheLegalNameChangedTxt(),"The Legal Name Changed Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleTheLegalNameChkBox(),"The Legal Name CheckBox","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleTheEntityIsPubliclyListedTxt(),"The Entity is Publicly Listed Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleTheEntityIsPubliclyListedChkBox(),"The Entity is Publicly Listed CheckBox","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleTheEntityHasOperationsTxt(),"The Entity Has Operations Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleTheEntityHasOperationsChkBox(),"The Entity Has Operations CheckBox","Displayed");
			auvenirPage.toValidate(addNewClientPage.getElePleaseListParentTxt(),"Please List Parent Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getElePleaseListParentTxtFld(),"Please List Parent Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleIndustryTxt(),"Industry Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleIndustryDrpDwn(),"Industry Drop Down","Displayed");
			addNewClientPage.getEleIndustryDrpDwn().click();
			auvenirPage.toValidate(addNewClientPage.getEleSelectIndustryTypeDrpDwn(),"Select Industry Type Drop Down","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleAccountingFrameWorkTxt(),"Accounting Framework Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleAccountingFrameWorkDrpDwn(),"Accounting Framework Drop Down","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleSelectAccountingFrameWorkDrpDwn(),"Select Accounting Framework Drop Down","Displayed");
			//auvenirPage.toValidate(addNewClientPage.getEleStreetNumberTxt(),"Street Number Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleAddressTxtFld(),"Address Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleAddressTxt(),"Address Text","Displayed");
			//auvenirPage.toValidate(addNewClientPage.getEleStreetTxt(),"Street Text","Displayed");
			//auvenirPage.toValidate(addNewClientPage.getEleStreetTxtFld(),"Street Text Field","Displayed");
			//auvenirPage.toValidate(addNewClientPage.getEleUnitNumberTxt(),"Unit Number Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleUnitNumberTxtFld(),"Unit Number Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleCityTxt(),"City Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleCityTxtFld(),"City Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleProvinceStateTxt(),"Province/State Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleProvinceStateTxtFld(),"Province/State Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getElePostalCodeTxt(),"Postal Code Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getElePostalCodeTxtFld(),"Postal Code Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleFirstAndLastNameTxt(),"First and Last Name Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleFirstAndLastNameTxtFld(),"First and Last Name Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleEmailAddressTxt(),"Email Address Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleEmailAddressTxtFld(),"Email Address Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getElePhoneNumberTxt(),"Phone Number Text","Displayed");
			auvenirPage.toValidate(addNewClientPage.getElePhoneNumberTxtFld(),"Phone Number Text Field","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleCameraImg(),"Camera Image","Displayed");
			auvenirPage.toValidate(addNewClientPage.getEleUploadPhotoBtn(),"Upload Photo Button","Enabled");
			auvenirPage.toValidate(addNewClientPage.getEleAddBtn(),"Add Button","Enabled");
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: To Verify the display of Elements in Auditor client Page.
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=9,enabled=true, description="To Verify the display of Elements in Auditor Client Page")
	public void verifyAuditorClientPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auditorClientPage = new AuditorClientPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleClientsLnk(), "Clients Link",15);
			auditorEngagementPage.getEleClientsLnk().click();
			auditorEngagementPage.auditorPageHeaderContent();
			auvenirPage.toValidate(auditorClientPage.getEleMyClientTxt(),"My Client Text","Displayed");
			auvenirPage.toValidate(auditorClientPage.getEleNoClientsImg(),"No Client - Image","Displayed");
			auvenirPage.toValidate(auditorClientPage.getEleAddNewBtn(),"Add New Button","Enabled");
			auvenirPage.toValidate(auditorClientPage.getEleYouDontHaveTxt(),"Add New Button","Enabled");
			
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: To Verify the display of Elements in Auditor Settings Account Page.
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=10,enabled=true, description="To Verify the display of Elements in Auditor Settings Account Page")
	public void auditorSettingsAccountPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		auditorSettingsPage =new AuditorSettingsPage(getLogger(),getDriver());
		adminLoginPage =new AdminLoginPage(getLogger(),getDriver());
		actions=new Actions(getDriver());
		try
		{
			getLogger().info("Login with auditor user.");
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleClientsLnk(), "Clients Link",waittime);
			auditorEngagementPage.getEleAuditorNameDrpDwn().click();
			//Thread.sleep(5000);
			visibilityOfElementWait(auditorEngagementPage.getEleSettingsLnk(), "Settings Link",waittime);
			auditorEngagementPage.getEleSettingsLnk().click();
			auditorEngagementPage.auditorPageHeaderContent();
			visibilityOfElementWait(auditorSettingsPage.getEleSettingsTxt(), "Settings Title",waittime);
			auvenirPage.toValidate(auditorSettingsPage.getEleSettingsTxt(), "Settings  - Title","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleAccountLnk(), "Account  - Link","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleNotificationsLnk(), "Notification  - Link","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleDevicesLnk(), "Devices  - Link","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleAccountSettingsTxt(), "Account Settings  - Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleFirstLastNameTxt(), "First and Last Name  - Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleFirstAndLastNameTxtFld(), "First and Last Name  - Text Field","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleEmailAddressTxt(), "Email Address  - Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleEmailAddressTxtFld(), "Email Address  - Text Field","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getElePhoneNumberTxt(), "Phone Number  - Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getElePhoneNumberTxtFld(), "Phone Number  - Text Field","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleProfilePictureImg(), "Photo  - Image","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleYourPhotoTxt(), "your Photo  - Text", "Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleUpdateBtn(), "Update   - Button", "Displayed");
			auvenirPage.toValidate(adminLoginPage.getEleDeactivateLnk(), "Deactivate My Account - Link", "Displayed");
			adminLoginPage.getEleDeactivateLnk().click();
			auvenirPage.toValidate(adminLoginPage.getEleDeactivatAccTxt(), "Deactivate Account - Text", "Displayed");
			auvenirPage.toValidate(adminLoginPage.getEleAlertIcn(), "Alert - Icon", "Displayed");
			auvenirPage.toValidate(adminLoginPage.getEleYouareAboutTxt(), "You are about to - Text", "Displayed");
			auvenirPage.toValidate(adminLoginPage.getEleCancelBtn(), "Cancel   - Button", "Displayed");
			auvenirPage.toValidate(adminLoginPage.getEleDeactivateBtn(), "Deactivate   - Button", "Displayed");
			adminLoginPage.getEleCloseIcn().click();
			
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	
	/* 
	 * @Description: To Verify the display of Elements in Auditor Settings Notification Page.
	 * @Author: Lakshmi BS
	 */
	@Test(priority=11,enabled=true, description="To Verify the display of Elements in Auditor Settings Notification Page")
	public void verifyAuditorSettingsNotificationPage() throws Exception
	{
		AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		auditorSettingsPage =new AuditorSettingsPage(getLogger(),getDriver());
		adminLoginPage =new AdminLoginPage(getLogger(),getDriver());
		actions=new Actions(getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleClientsLnk(), "Clients Link",waittime);
			auditorEngagementPage.getEleAuditorNameDrpDwn().click();
			Thread.sleep(5000);
			visibilityOfElementWait(auditorEngagementPage.getEleSettingsLnk(), "Settings Link",waittime);
			auditorEngagementPage.getEleSettingsLnk().click();
			auditorEngagementPage.auditorPageHeaderContent();
			visibilityOfElementWait(auditorSettingsPage.getEleSettingsTxt(), "Settings Title",waittime);
			auditorSettingsPage.getEleNotificationsLnk().click();
			auvenirPage.toValidate(auditorSettingsPage.getEleNotificationsSettingsTxt(),"Notification Settings Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleWeWillAlertTxt(),"We Will Alert Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleByEmailTxt(),"By Email Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleGetNotifiedTxt(),"Get Notified Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleIsInventedTxt(),"Is Invented Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleIsInventedSliderBtn(),"Is Invented Slider Button","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleHasJoinedTxt(),"Has Joined Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleHasJoinedSliderBtn(),"Has Joined Slider Button","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleSendYouTxt(),"Send You Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleSendYouSliderBtn(),"Send You Slider Button","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleUploadATxt(),"Upload A Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleUploadASliderBtn(),"Upload A Slider Button","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleCommentsTxt(),"Comment Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleCommentsSliderBtn(),"Comment Slider Button","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleCreateATxt(),"Create A Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleCreateASliderBtn(),"Create A Slider Button","Displayed");
			auditorSettingsPage.getEleDevicesLnk().click();
			auvenirPage.toValidate(auditorSettingsPage.getEleMyDevicesTxt(),"My Devices Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleYouHaveRegisteredTxt(),"You Have Registered Text","Displayed");
			auvenirPage.toValidate(auditorSettingsPage.getEleAddAnotherBtn(),"Add Another Button","Enabled");
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	

	
	/* 
	 * @Description: To Verify the display of Elements in Archive Page.
	 * @Author: Lakshmi BS
	 */
	@Test(priority=12,enabled=true, description="To Verify the display of Elements in Archive Page")
	public void verifyEngagementArchivePage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auditorDashboardPage = new AuditorDashboardPage(getLogger(),getDriver());
		
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleCreateNewBtn(), "Create New Button",waittime);
			auditorEngagementPage.getEleCreateNewBtn().click();
			visibilityOfElementWait(auditorDashboardPage.getEleArchiveBtn(), "Archive Button",waittime);
			auditorDashboardPage.getEleArchiveBtn().click();
			auvenirPage.toValidate(auditorDashboardPage.getEleArchiveEngagementTxt(),"Archive Engagement Header Text","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleArchiveEngagementImg(),"Archive Engagement Image","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleYouWillNoTxt(),"You will not longer be able to access - Text","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleCancelBtn(),"Cancel Button","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleYesBtn(),"Yes - Button","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleCloseSmallIcn(),"Close icon","Displayed");
			auditorDashboardPage.getEleCancelBtn().click();
			
			//auvenirPage.toValidate(engagementActivityPo.getEleActivityFeedTxt(),"Activity Feed Text","Displayed");
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description: To Verify the display of Elements in Archive Page.
	 * @Author: Lakshmi BS
	 */
	@Test(priority=13,enabled=true, description="To Verify the display of Elements in Clients Page")
	public void verifyEngagementClientPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(getLogger(),getDriver());
		auditorDashboardPage = new AuditorDashboardPage(getLogger(),getDriver());
				auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"), GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"), GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
			visibilityOfElementWait(auditorEngagementPage.getEleCreateNewBtn(), "Create New Button",waittime);
			auditorEngagementPage.getEleClientsLnk().click();
			visibilityOfElementWait(auditorDashboardPage.getEleMyClientTxt(), "My Clients header text",waittime);
			auvenirPage.toValidate(auditorDashboardPage.getEleMyClientTxt(),"Activity Feed Text","Displayed");
			auvenirPage.toValidate(auditorDashboardPage.getEleAddNewBtn(),"Add New Button","Displayed");
			
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	
	
/*	 
	 * @Description: To Verify the display of Elements in Auditor Gmail Login Page.
	 * @Author: Jeevaraj SP
	 
	@Test(priority=12,enabled=false, description="To Verify the display of Elements in Auditor Gmail Login Page")
	public void auditorGmailLoginPage() throws Exception
	{   AbstractRefactorService.sStatusCnt=0;
		auditorEngagementPage = new AuditorEngagementPage(driver);
		
		auvenirPage=new AuvenirPage(driver);
		auditorLoginPo=new AuditorLoginPage(driver);
		auditorGmailLoginPo = new AuditorGmailLoginPage(driver);
		try
		{
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_URL"));
			visibilityOfElementWait(auvenirPage.getEleAuditorEmailAddressTxtFld(), "Email Address Text Field", 15);
			auvenirPage.getEleAuditorEmailAddressTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"));
			auvenirPage.getEleJoinBtn().click();
			auvenirPage.toValidate(auvenirPage.getEleMailImg(),"Mail Image","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleCheckYourEmailTxt(),"Check Your Email Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleWeSentTxt(),"We Sent Text","Displayed");
			auvenirPage.toValidate(auvenirPage.getEleDoneBtn(),"Done Button","Enabled");
			auvenirPage.getEleDoneBtn().click();
	    	driver.get(GenericService.getCongigValue(GenericService.sConfigFile,"GMAIL_URL"));
	    	if(auditorGmailLoginPo.getEleSignInLink().isDisplayed())
	    	{
	    		auditorGmailLoginPo.getEleSignInLink().click();
	    	}
	    	if(auditorGmailLoginPo.getEleEmailIDTxtFld().isDisplayed())
	    	{
	    		auditorGmailLoginPo.getEleEmailIDTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID"));
	    		auditorGmailLoginPo.getEleNextBtn().click();
	    	}
	    	visibilityOfElementWait(auditorGmailLoginPo.getElePasswordTxtFld(), "Password Text Field", 10);
			auditorGmailLoginPo.getElePasswordTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile,"AUDITOR_PWD"));
	    	auditorGmailLoginPo.getEleSignInBtn().click();
	    	Assert.assertTrue(auditorGmailLoginPo.getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
	    	visibilityOfElementWait(auditorGmailLoginPo.getEleSearchTxtFld(), "Search Text Field", 10);
			auditorGmailLoginPo.getEleSearchTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile,"GMAIL_SEARCHMAIL"));
	    	auditorGmailLoginPo.getEleSearchBtn().click();
	    	auditorGmailLoginPo.getEleFirstMailLnk().click();
	    	auvenirPage.toValidate(auditorGmailLoginPo.getEleNoReplyTxt(),"No Reply Text","Displayed");
	    	auvenirPage.toValidate(auditorGmailLoginPo.getEleAuvenirImg(),"Auvenir Image","Displayed");
	    	auvenirPage.toValidate(auditorGmailLoginPo.getEleAuvenirTxt(),"Auvenir Text","Displayed");
	    	auvenirPage.toValidate(auditorGmailLoginPo.getEleAuditSmarterTxt(),"Audit Smarter Text","Displayed");
	    	auvenirPage.toValidate(auditorGmailLoginPo.getEleYouHaveBeenTxt(),"You Have Been Text","Displayed");
	    	auvenirPage.toValidate(auditorGmailLoginPo.getEleClickToLoginLnk(),"Click to Login Link","Displayed");
	    	auvenirPage.toValidate(auditorGmailLoginPo.getEleWeWelcomeYourTxt(),"We Welcome Your Text","Displayed");
	    	auvenirPage.toValidate(auditorGmailLoginPo.getEleFeedbackLnk(),"Feedback Link","Displayed");
			Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	*/
}
