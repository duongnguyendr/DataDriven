package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class EngagementTest extends AbstractTest {
    AuditorEngagementService auditorEngagementService;

    @Test(priority=1,enabled=true, description="Verify Footer in Auditor Engagements page.")
    public void verifyFooterAuditorEngagementPage() throws Exception
    {
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        String getTokenUrl =   GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try
        {
            logCurrentStepStart();
            auditorEngagementService.loginWithUserRole(userId,getTokenUrl,checkTokenUrl);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifyAuditorFooter();
            NXGReports.addStep("Verify footer in Auditor Engagement page.", LogAs.PASSED, null);
            logCurrentStepEnd();

        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify footer in Auditor Engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}



