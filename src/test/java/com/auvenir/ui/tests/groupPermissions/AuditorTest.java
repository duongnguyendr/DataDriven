package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorCreateToDoService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorToDoService;
import com.auvenir.ui.services.groupPermissions.AuditorService;
import com.auvenir.ui.services.groupPermissions.LeadAuditorService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class AuditorTest extends AbstractTest {
    private AuditorToDoService auditorToDoService;
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorService auditorService;

    @Test(priority = 22, enabled = true, description = "To Verify auditor can change request name assigned to it.")
    public void verifyLeadAuditorCanChangeRequestName() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorService = new AuditorService(getLogger(), getDriver());
        String leadAuditorId = "chr.vienpham.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement Duong";
        String todoName = "lead vien1";
        String oldRequestName = "request1";
        String newRequestName = "request1 modify";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorService.clickCommentIconByTodoName(todoName);
            auditorService.verifyAuditorCanChangeRequestNameBeAssigned(oldRequestName, newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead auditor change request name: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead auditor change request name: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}
