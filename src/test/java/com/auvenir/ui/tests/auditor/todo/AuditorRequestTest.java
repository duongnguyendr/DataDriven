package com.auvenir.ui.tests.auditor.todo;

import com.auvenir.ui.dataprovider.SmokeDataProvider;
import com.auvenir.ui.dataprovider.auditor.AuditorTodoPageDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorCreateToDoService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorTodoListService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by doai.tran on 7/20/2017.
 */
public class AuditorRequestTest extends AbstractTest {

    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private MarketingService marketingService;
    private AuditorTodoListService auditorTodoListService;

    @Test(priority = 26, enabled = true, description = "Verify upload request files", dataProvider = "verifyUploadRequestFiles",
            dataProviderClass = AuditorTodoPageDataProvider.class)
    public void verifyUploadNewRequestFile(String auditorId, String auditorPwd, String engagementName, String pathOfUploadLocation,
            String toDoName,String txtFile,String docxFile,String xlsxFile,String pdfFile,String pngFile,String jpgFile) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            //upload txt file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, txtFile, 1);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(txtFile);
            //upload docx file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, docxFile, 2);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(docxFile);
            //upload xlsx file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, xlsxFile, 3);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(xlsxFile);
            //upload pdf file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, pdfFile, 4);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(pdfFile);
            //upload png file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, pngFile, 5);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(pngFile);
            //upload jpg file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, jpgFile, 6);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(jpgFile);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor add new request", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor add new request", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 19, enabled = true, description = "Verify to create new request on ToDo page", dataProvider = "verifyAddNewRequestOnToDoPage",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyAddNewRequestOnToDoPage(String auditorId, String auditorPwd, String engagementName, String pathOfUploadLocation,
            String fileName, String toDoName, String deadlineDate, String endDate, String startDate, String request01Value, String request02Value,
            String position01Value, String position02Value) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.createNewRequest("request 01", "1");
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.createNewRequest("request 02", "2");
            // temporary return Engagement to verify newRequest.
            auditorCreateToDoService.reselectEngagementName(engagementName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.uploadeNewFileByRequestName(pathOfUploadLocation, fileName, "request 01");
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify to create new request on ToDo page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify to create new request on ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Added by Vien Pham on July 10, 2017
     */
    @Test(priority = 21, enabled = true, description = "Verify auditor can download.", dataProvider = "verifyAuditorDownloadOnRequest",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorDownloadOnRequest(String auditorId, String auditorPwd, String engagementName, String pathOfUploadLocation,
            String fileName, String pathOfDownloadLocation) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.downloadRequestFile(pathOfUploadLocation, pathOfDownloadLocation, fileName, 1);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor download file", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor download file", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 28, enabled = true, description = "Verify auditor attach file in request.", dataProvider = "verifyAuditorAttachFile",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorAttachFile(String auditorId, String auditorPwd, String engagementName, String pathOfAttachLocation, String fileName,
            String toDoName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            getLogger().info("Verifying auditor attach a TXT file..");
            auditorCreateToDoService.auditorAttachNewFile(pathOfAttachLocation, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor attach file in request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor attach file in request.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

}
