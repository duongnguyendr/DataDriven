package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by tan.pham on 5/17/2017.
 */
public class AddDeleteIconTest extends AbstractTest
{
    AuditorCreateToDoService auditorCreateToDoService;
    AuditorEngagementService auditorEngagementService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;

    @Test(  priority = 1,enabled = true, description = "Verify GUI of delete icon in to-do page.")
    public void verifyGUIDeleteIconInToDoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of delete icon in to-do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of delete icon in to-do page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
