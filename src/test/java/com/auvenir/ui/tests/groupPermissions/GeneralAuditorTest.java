package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.groupPermissions.GeneralAuditorService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class GeneralAuditorTest extends AbstractTest {
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

    @Test(priority = 18, enabled = true, description = "To Verify auditor can change request name assigned to it.", testName = "au_18")
    public void verifyGeneralAuditorCanAssignToAuditor() throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorService = new GeneralAuditorService(getLogger(), getDriver());
        String todoName = "todo1";
        String adminUser = "duong.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement AUV353";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorService.verifyGeneralAuditorCanNotAssignTodoToAuditor(Arrays.asList(todoName));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 20, enabled = true, description = "To Verify general auditor cannot assigned todo to general client.", testName = "au_20")
    public void verifyGeneralAuditorCannotAssignToGeneralClient() throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorService = new GeneralAuditorService(getLogger(), getDriver());
        String adminUser = "chr.vienpham.auditor@gmail.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String generalClient = "General Client";
        try{
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorService.verifyGeneralAuditorCannotAssignToDoToGeneralClient(Arrays.asList(todoName), generalClient);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can mark todo completed.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify Admin Auditor can mark todo completed: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
