package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
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
    private AdminAuditorService adminAuditorService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;

    @Test(priority = 27, enabled = true, description = "Verify lead auditor can see all files within an engagement.")
    public void verifyLeadAuditorSeeAllFileRequest() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        String auditorLeadId = GenericService.getTestDataFromExcel("GroupPermissionTest", "Lead Auditor", "Valid Value");
        String auditorLeadPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 2 Name", "Valid Value");
        String toDo1 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 1 name", "Valid Value");
        String toDo2 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 2 name", "Valid Value");
        String toDo3 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 3 name", "Valid Value");
        String toDo4 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 4 name", "Valid Value");

        String fileRequest1 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "File Request 1", "Valid Value");
        String fileRequest1_Client = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "File Request 1 Client", "Valid " +
                "Value");
        String fileRequest2 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "File Request 2", "Valid Value");
        String fileRequest2_Client = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "File Request 2 Client", "Valid " +
                "Value");
        String fileRequest3 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "File Request 3", "Valid Value");
        String fileRequest3_Client = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "File Request 3 Client", "Valid " +
                "Value");
        String fileRequest4 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "File Request 4", "Valid Value");
        HashMap<String, String[]> todoData = new HashMap<String, String[]>();
        todoData.put(toDo1, new String[]{fileRequest1, fileRequest1_Client});
        todoData.put(toDo2, new String[]{fileRequest2, fileRequest2_Client});
        todoData.put(toDo3, new String[]{fileRequest3, fileRequest3_Client});
        todoData.put(toDo4, new String[]{fileRequest4});
        try{
            marketingService.loginUsingUsernamePassword(auditorLeadId, auditorLeadPwd);
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            for (Map.Entry<String, String[]> entry : todoData.entrySet()){
                leadAuditorService.verifyFileRequestInTodo(entry.getKey(), entry.getValue());
            }
            leadAuditorService.verifyLeadAuditorSeeAllFileRequest(7);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify lead auditor can see all files within an engagement.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify lead auditor can see all files within an engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
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
