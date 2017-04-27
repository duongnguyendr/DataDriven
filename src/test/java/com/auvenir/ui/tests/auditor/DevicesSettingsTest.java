package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AuditorAccountSettingsService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.AuditorDevicesSettingsService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class DevicesSettingsTest extends AbstractTest {
    AuditorDevicesSettingsService auditorDevicesSettingsService;
    AuditorEngagementService auditorEngagementService;
    AuditorAccountSettingsService auditorAccountSettingsService;


    @Test(priority=1,enabled=true, description="Verify Footer in Auditor Notifications Settings page.")
    public void verifyFooterNotificationsSettingsPage() throws Exception
    {
        auditorDevicesSettingsService = new AuditorDevicesSettingsService(getLogger(),getDriver());
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(),getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        String getTokenUrl =   GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try
        {
            auditorDevicesSettingsService.loginWithUserRole(userId,getTokenUrl,checkTokenUrl);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyAccountSettingsPage();
            auditorAccountSettingsService.navigateToDevicesPage();
            auditorDevicesSettingsService.verifyAuditorDevicesSettingsPage();
            auditorDevicesSettingsService.verifyFooter();
            NXGReports.addStep("Verify Footer in Auditor Notifications Settings page.", LogAs.PASSED, null);

        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify Footer in Auditor Notifications Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


