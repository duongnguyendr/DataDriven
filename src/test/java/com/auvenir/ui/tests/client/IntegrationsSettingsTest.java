package com.auvenir.ui.tests.client;

import com.auvenir.ui.services.ClientService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */


/**
 * Created by cuong.nguyen on 4/24/2017.
 */
public class IntegrationsSettingsTest extends AbstractTest {
    ClientService clientService;


    @Test(priority=1,enabled=true, description="Verify Footer in Client Integrations Settings page.")
    public void verifyFooterClientIntegrationsSettingsPage() throws Exception
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
            clientService.navigateToIntegrationTab();
            clientService.verifyIntegrationsSettingsPage();
            clientService.verifyClientFooter();
            NXGReports.addStep("Verify Footer in Integrations Settings page.", LogAs.PASSED, null);
           // logCurrentStepEnd();

        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify Footer in Integrations Settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


