package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorCreateToDoService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.groupPermissions.AdminAuditorService;
import com.auvenir.ui.services.groupPermissions.LeadAuditorService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duong.nguyen on 7/17/2017.
 */
public class LeadAuditorTest extends AbstractTest {
    private LeadAuditorService leadAuditorService;
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    AuditorCreateToDoService auditorCreateToDoService;

    @Test(priority = 22, enabled = true, description = "To Verify lead auditor can change request name.")
    public void verifyLeadAuditorCanChangeRequestName() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(),getDriver());
        String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement Duong";
        String todoName = "lead vien1";
        String oldRequestName = "request1";
        String newRequestName = "request1 modify";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            leadAuditorService.clickCommentIconByTodoName(todoName);
            leadAuditorService.verifyLeadAuditorCanChangeRequestName(oldRequestName,newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead auditor change request name: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead auditor change request name: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 23, enabled = true, description = "To Verify lead Auditor can delete request")
    public void verifyAdminAuditorCanNotDeleteRequest() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(),getDriver());
        String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement_LeadAuditor";
        String todoName = "lead vien1";
        String requestName = "lead request modify1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.clickCommentIconPerTaskName(todoName, false);
            leadAuditorService.verifyLeadAuditorCanDeleteRequest(requestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Auditor can delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Auditor can delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 24, enabled = true, description = "To Verify lead Auditor can change Duedate")
    public void verifyAdminAuditorCanChangeDueDate() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(),getDriver());
        String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement_LeadAuditor";
        String todoName = "lead vien1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            leadAuditorService.verifyLeadAuditorCanChangeDueDate(todoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Auditor can delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Auditor can delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 25, enabled = true, description = "To Verify lead Auditor can edit Category")
    public void verifyAdminAuditorCanEditCategory() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(),getDriver());
        String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement_LeadAuditor";
        String todoName = "lead vien1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            leadAuditorService.verifyLeadAuditorCanEditCategory(todoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Auditor can delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Auditor can delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 13, enabled = true, description = "Verify Lead Auditor can create todo.",testName = "LA-13")
    public void verifyLeadAuditorCanCreateTodo () throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        String adminUser = "duong.lead.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String [] todoName = {"Todo 123", "Todo 124"};
        try{
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadAuditorService.verifyLeadAuditorCanCreateTodo(Arrays.asList(todoName));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can create todo.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify Admin Auditor can create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 14, enabled = true, description = "Verify Lead Auditor can remove todo.",testName = "LA-14 + 15")
    public void verifyLeadAuditorCanRemoveTodo () throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        String adminUser = "duong.lead.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String [] todoName = {"Todo 123"};
        try{
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadAuditorService.verifyLeadAuditorCanRemoveTodo(Arrays.asList(todoName));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can remove todo.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify Admin Auditor can remove todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Admin Auditor can mark todo completed.",testName = "LA-16")
    public void verifyLeadAuditorCanMarkTodoCompleted () throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        String adminUser = "duong.lead.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String [] todoName = {"Todo 124"};
        try{
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadAuditorService.verifyLeadAuditorCanMarkTodoCompleted(Arrays.asList(todoName));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can mark todo completed.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify Admin Auditor can mark todo completed: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Admin Auditor cannot assign todo to general client.",testName = "LA-19")
    public void verifyLeadAuditorCannotAssignToGeneralClient() throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        String adminUser = "duong.lead.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String [] todoName = {"Todo 1"};
        String generalClient = "Duong General Client";
        try{
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadAuditorService.verifyLeadAuditorCannotAssignToGeneralClient(Arrays.asList(todoName), generalClient);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can mark todo completed.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify Admin Auditor can mark todo completed: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify Admin Auditor can comment on todo they are no assign to.",testName = "LA-19")
    public void verifyLeadAuditorCanCommentingWithOutAssign() throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        String adminUser = "duong.lead.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String todoName = "Todo 1";
        String comment = "Comment 12345";
        try{
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadAuditorService.verifyLeadAuditorCanCommentOnTodoWithOutAssign(todoName, comment);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can comment on todo they are no assign to.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify Admin Auditor can comment on todo they are no assign to: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
