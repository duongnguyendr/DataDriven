package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorToDoService;
import com.auvenir.ui.services.groupPermissions.GeneralAuditorService;
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
public class GeneralAuditorTest extends AbstractTest {
    private AuditorToDoService auditorToDoService;
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private GeneralAuditorService auditorService;

    @Test(priority = 22, enabled = true, description = "To Verify auditor can change request name assigned to it.")
    public void verifyAuditorCanChangeRequestNameBeAssigned() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorService = new GeneralAuditorService(getLogger(), getDriver());
        String generalAuditor = "chr.vienpham.auditor@gmail.com";
        String generalAuditorPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String oldRequestName = "request2";
        String newRequestName = "request2 modify";
        try {
            marketingService.loginUsingUsernamePassword(generalAuditor, generalAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorService.clickCommentIconByTodoName(todoName);
            auditorService.verifyAuditorCanChangeRequestNameBeAssigned(oldRequestName, newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general auditor can change request name assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general auditor can change request name assigned: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}
