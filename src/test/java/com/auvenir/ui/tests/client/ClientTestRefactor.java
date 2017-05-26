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
    @Test(priority = 7, enabled = true, description = "To Verify the display of Elements in Client Home Page")
    public void verifyClientHomePage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        try {
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHeader();
            clientService.verifyClientInboxMessage();
            clientService.verifyMyAuditsPage();
            clientService.verifyClientFooterRefactor();
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
    @Test(priority=8,enabled=true, description="To Verify the display of Elements in Client Request Page")
    public void verifyClientRequestPage() throws Exception
    {
        AbstractRefactorService.sStatusCnt=0;
        clientDashboardPage =new ClientDashboardPage(getLogger(),getDriver());
        clientRequestPage =new ClientRequestPage(getLogger(),getDriver());
        auvenirPage =new AuvenirPage(getLogger(),getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        try
        {
            clientService.verifyClientHeader();
            clientDashboardPage.getEleRequestLnk().click();
            Thread.sleep(5000);
            //Will Update later.
//            auvenirPage.toValidate(clientRequestPage.getEleAllRequestTxt(),"All Request Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleFinancialsTxt(),"Financials Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleGeneralLedgerTxt(),"General Ledger Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleTrialBalanceTxt(),"Trial Balance Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleBankStatementsTxt(),"Bank Statements Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleGeneralLedgerHeaderTxt(),"General Legder Header Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleDescriptionGeneralLedgerTxt(),"Description General Legder Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleGeneralLedgerContainerFld(),"General Legder Container Field", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleUploadGeneralLedgerImg(),"Upload General Legder Image", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleDragAndDropGeneralLedgerTxt(),"Drag and Drop General Legder Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleBrowseGeneralLedgerTxt(),"Browse General Legder Text", "Displayed");
//            Thread.sleep(5000);
//            clientRequestPage.getEleTrialBalanceTxt().click();
//            Thread.sleep(5000);
//            auvenirPage.toValidate(clientRequestPage.getEleTrialBalanceHeaderTxt(),"Trial Balance Header Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleDescriptionTrialBalanceTxt(),"Description Trial Balance Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleTrialBalanceContainerFld(),"Trial Balance container Field", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleUploadTrialBalanceImg(),"Upload Trial Balance Image", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleDragAndDropTrialBalanceTxt(),"Drag and Drop Trial Balance Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleBrowseTrialBalanceTxt(),"Browse Trial Balance Text", "Displayed");
//            Thread.sleep(5000);
//            clientRequestPage.getEleBankStatementsTxt().click();
//            Thread.sleep(5000);
//            auvenirPage.toValidate(clientRequestPage.getEleBankStatementsHeaderTxt(),"Bank Statements Header Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleDescriptionBankStatementsTxt(),"Description Bank Statements Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleBankStatementContainerFld(),"Bank Statements Container Field", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleUploadBankStatementsImg(),"Upload Bank Statements Image", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleDragAndDropBankStatementsTxt(),"Drag and Drop Bank Statements Text", "Displayed");
//            auvenirPage.toValidate(clientRequestPage.getEleBrowseBankStatementsTxt(),"My Audits Text", "Displayed");
//            clientDashboardPage.verifyClientFooter();
            Assert.assertTrue(AbstractRefactorService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        }
        catch (AssertionError e)
        {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
        catch (Exception e)
        {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
