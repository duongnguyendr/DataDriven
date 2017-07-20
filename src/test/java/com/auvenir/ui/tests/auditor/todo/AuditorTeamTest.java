package com.auvenir.ui.tests.auditor.todo;

import com.auvenir.ui.dataprovider.SmokeDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AuditorEngagementTeamService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
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
public class AuditorTeamTest extends AbstractTest {

    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorEngagementTeamService auditorEngagementTeamService;
    private MarketingService marketingService;

    @Test(priority = 26, enabled = true, description = "Verify auditor check list team.", dataProvider = "verifyCheckListTeam",
            dataProviderClass = SmokeDataProvider.class)
    public void verifyCheckListTeam(String auditorId, String auditorPwd, String engagementName, String fullNameMember,
            String roleMember) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
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
            // Move to engagement detail
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Click on team link
            auditorEngagementTeamService.clickEngagementTeamMenu();
            // Verify member is already exist in team list data
            auditorEngagementTeamService.verifyMemberIsShownInTeamList(fullNameMember, roleMember);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor check list team.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports
                    .addStep("Test script Failed: Verify auditor check list team.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                            .BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
}
