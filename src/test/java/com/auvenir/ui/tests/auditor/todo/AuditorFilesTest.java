package com.auvenir.ui.tests.auditor.todo;

import com.auvenir.ui.dataprovider.SmokeDataProvider;
import com.auvenir.ui.dataprovider.auditor.AuditorToDoListDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.*;
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
public class AuditorFilesTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService ;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private MarketingService marketingService;
    private AuditorCreateToDoService auditorCreateToDoService;
    /**
     * (case)verify Undo action Download Attachments disable
     */
    @Test(priority = 33, enabled = true, testName = "Undo failed", description = "verify Undo action Download Attachments disable", groups =
            "workflow", dataProvider = "verifyDownloadAttachmentsDisable", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDownloadAttachmentsDisable(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName, String toDoName01) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
            //            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
            //            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
            //            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
            //            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.verifyToDoDownloadAttachmentsDisable(toDoName01);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Download Attachments disable.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Download Attachments disable.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 25, enabled = true, description = "Verify auditor download all attachment file form all ToDo.",
            dataProvider = "verifyDownloadAttachmentFromAllToDo", dataProviderClass = SmokeDataProvider.class)
    public void verifyDownloadAttachmentFromAllToDo(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Move file manager tab
            auditorDetailsEngagementService.clickOnFileManagerLink();
            // Click on all file check box
            auditorDetailsEngagementService.clickOnAllFileCheckBox();
            // Click on down load icon
            auditorDetailsEngagementService.clickOnDownLoadIcon();

            auditorDetailsEngagementService.closeBrowserAfterDownLoad();
            // verify down load popup
            // auditorDetailsEngagementService.verifyDownLoadPopup();
            // Click on down load button in popup
            // auditorDetailsEngagementService.clickOnDownLoadButtonInPopup();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor download all attachment file form all ToDo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify auditor download all attachment file form all ToDo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
}
