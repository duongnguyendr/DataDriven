package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.pages.client.engagement.ClientDetailsEngagementPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.groupPermissions.GeneralClientService;
import com.auvenir.ui.services.groupPermissions.LeadClientService;
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
public class GeneralClientTest extends AbstractTest{
    private MarketingService marketingService;
    private ClientEngagementService clientEngagementService;
    private ClientDetailsEngagementPage clientDetailsEngagementService;
    private GeneralClientService generalClientService;

    @Test(priority = 22, enabled = true, description = "To Verify general Client can not change request name ")
    public void verifyGeneralClientCanNotChangeRequestName() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(),getDriver());
        generalClientService = new GeneralClientService(getLogger(),getDriver());
        String generalClientId = "chr.vienpham.client@gmail.com";
        String generalClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String requequestName = "request1";
        String newRequestName = "request1 modify";
        try {
            marketingService.loginUsingUsernamePassword(generalClientId, generalClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            generalClientService.clickCommentIconByTodoName(todoName);
            generalClientService.verifyGeneralClientCanNotChangeRequestName(requequestName, newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can not change request Name : Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can not change request Name : Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}
