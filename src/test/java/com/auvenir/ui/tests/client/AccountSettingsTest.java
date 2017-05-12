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

public class AccountSettingsTest extends AbstractTest {
    private ClientService clientService;


    @Test(priority=1,enabled=true, description="Verify Footer in  client Account Settings page.")
    public void verifyFooterClientAccountSettingsPage() throws Exception
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
            clientService.verifyClientFooter();
            NXGReports.addStep("Verify client Account Settings page footer.", LogAs.PASSED, null);
            //logCurrentStepEnd();

        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify client Account Settings page footer", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


