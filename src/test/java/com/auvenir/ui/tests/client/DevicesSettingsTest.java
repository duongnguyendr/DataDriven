package com.auvenir.ui.tests.client;

import com.auvenir.ui.services.ClientService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/24/2017.
 */
public class DevicesSettingsTest extends AbstractTest {
    ClientService clientService;


    @Test(priority=1,enabled=true, description="Verify Footer in Client Devices Settings page.")
    public void verifyFooterClientDevicesSettingsPage() throws Exception
    {
        clientService = new ClientService(getLogger(),getDriver());
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        String getTokenUrl =   GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try
        {
            //logCurrentStepStart();
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHomePage();
            clientService.navigateToClientSettingsPage();
            clientService.verifyAccountSettingsPage();
            clientService.navigateToDevicesTab();
            clientService.verifyDevicesSettingsPage();
            clientService.verifyClientFooter();
            NXGReports.addStep("Verify Footer in Devices Settings page.", LogAs.PASSED, null);
            //logCurrentStepEnd();

        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify Footer in Devices Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
