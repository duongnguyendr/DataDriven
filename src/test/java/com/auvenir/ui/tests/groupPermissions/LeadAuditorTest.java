package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
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
