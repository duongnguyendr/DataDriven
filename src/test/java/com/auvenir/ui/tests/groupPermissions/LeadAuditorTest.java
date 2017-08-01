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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by duong.nguyen on 7/17/2017.
 */
public class LeadAuditorTest extends AbstractTest {
    MarketingService marketingService;
    AuditorEngagementService auditorEngagementService;
    LeadAuditorService leadAuditorService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;
    AuditorCreateToDoService auditorCreateToDoService;

    @Test(priority = 22, enabled = true, description = "To Verify lead auditor can change request name.")
    public void verifyLeadAuditorCanChangeRequestName() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(),getDriver());
        String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement_LeadAuditor";
        String todoName = "lead vien1";
        String oldRequestName = "lead request1";
        String newRequestName = "lead request modify1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.clickCommentIconPerTaskName(todoName, false);
            leadAuditorService.verifyLeadAuditorCanChangeRequestName(oldRequestName,newRequestName);
            auditorCreateToDoService.reselectEngagementName(engagementName);
            auditorCreateToDoService.clickCommentIconPerTaskName(todoName, false);
            leadAuditorService.verifyNewRequestChangedSuccessfully(newRequestName);
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
        String requestName = "lead request1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.clickCommentIconPerTaskName(todoName, false);
            leadAuditorService.verifyLeadAuditorCanDeleteRequest(requestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Auditor can delete request created by Lead auditor: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Auditor can delete request created by Lead auditor: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


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


}
