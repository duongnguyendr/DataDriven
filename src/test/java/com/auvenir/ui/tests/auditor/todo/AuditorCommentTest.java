package com.auvenir.ui.tests.auditor.todo;

import com.auvenir.ui.dataprovider.SmokeDataProvider;
import com.auvenir.ui.dataprovider.auditor.AuditorToDoListDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorCreateToDoService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorTodoListService;
import com.auvenir.ui.services.client.ClientService;
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
public class AuditorCommentTest extends AbstractTest {

    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private MarketingService marketingService;
    private ClientService clientService;

    @Test(priority = 1, enabled = true, description = "Verify To-do Details Commenting", dataProvider = "verifyToDoDetailsCommenting",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyToDoDetailsCommenting(String auditorId, String auditorPwd, String engagementName, String todoName, String inputComment) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            //            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement2299");
            // Will edit when the code is updated with the new xpath and business.
            //            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.navigateToDoListPage();

            // Will uncomment when the code is updated with the new xpath and business.
            auditorCreateToDoService.createNewToDoTask(todoName);
            //            auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task2299");
            //            auditorCreateToDoService.closeSuccessToastMes();
            auditorCreateToDoService.selectToDoTaskName(todoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(todoName);
            auditorCreateToDoService.verifyInputAComment(inputComment);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, inputComment);
            auditorCreateToDoService.verifyBoxTitleComment();
            auditorCreateToDoService.verifyClickOnInputCommentField();
            auditorCreateToDoService.verifyGUIPostButton();
            auditorCreateToDoService.verifyDefaultHintValueInputComment();
            auditorCreateToDoService.verifyGUICommentList(inputComment);
            auditorCreateToDoService.verifyUserInputNoContentComment();
            auditorCreateToDoService.verifyInputMaxLenghtContentComment(512);
            auditorCreateToDoService.verifyInputSpecialCharactersContentComment();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify Auditor post new comment on a ToDo.", dataProvider = "verifyAuditorPostComment",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorPostComment(String auditorId, String auditorPwd, String engagementName, String toDoName,
            String commentContent) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            // Will uncomment when the code is updated with the new xpath and business.
            // auditorCreateToDoService.verifyAddNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName);
            auditorCreateToDoService.verifyInputAComment(commentContent);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Auditor post new comment on a ToDo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor post new comment on a ToDo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    @Test(priority = 3, enabled = true, description = "Verify Auditor can see client's post comment.",
            dataProvider = "verifyAuditorViewClientComment", dataProviderClass = SmokeDataProvider.class)
    public void verifyAuditorViewClientComment(String auditorId, String auditorPwd, String engagementName, String toDoName, String commentContent,
            String clientFullName, boolean isClient) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.clickCommentIconPerTaskName(toDoName, isClient);
            auditorCreateToDoService.verifyLastCommentOfUserDisplayed(commentContent, clientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Auditor can see client's post comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor can see client's post comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
}
