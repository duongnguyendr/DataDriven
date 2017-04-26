package com.auvenir.ui.tests.client;


        import com.auvenir.ui.pages.AuvenirPage;
        import com.auvenir.ui.pages.client.ClientLoginPage;
        import com.auvenir.ui.pages.common.GmailPage;
        import com.auvenir.ui.services.AbstractRefactorService;
        import com.auvenir.ui.services.ClientService;
        import com.auvenir.ui.tests.AbstractTest;
        import com.auvenir.utilities.GenericService;
        import com.kirwa.nxgreport.NXGReports;
        import com.kirwa.nxgreport.logging.LogAs;
        import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
        import org.apache.log4j.Logger;
        import org.openqa.selenium.WebDriver;
        import org.testng.Assert;
        import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/24/2017.
 */
public class ClientFooterTest extends AbstractTest {
    ClientService clientService;


    @Test(priority=1,enabled=true, description="Verify Footer in all page of client.")
    public void verifyclientfooter() throws Exception
    {
        clientService = new ClientService(getLogger(),getDriver());
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID");
        String getTokenUrl =   GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try
        {
            clientService.loginWithUserRole(userId,getTokenUrl,checkTokenUrl);
            clientService.navigateToClientDashboardPage();
            clientService.navigateToInProgressTab();
            clientService.verifyClientFooter();
            clientService.navigateToCompletedTab();
            clientService.verifyClientFooter();
            clientService.navigateToClientSettingsPage();
            //clientService.navigateToAccountTab();
            clientService.verifyAccountSettingsPage();
            clientService.verifyClientFooter();
            clientService.navigateToNotificationsTab();
            clientService.verifyNotificationsSettingsPage();
            clientService.verifyClientFooter();
            clientService.navigateToIntegrationTab();
            clientService.verifyIntegrationsSettingsPage();
            clientService.verifyClientFooter();
            clientService.navigateToDevicesTab();
            clientService.verifyDevicesSettingsPage();
            clientService.verifyClientFooter();
            NXGReports.addStep("Verify Footer page of client.", LogAs.PASSED, null);

        }

        catch (Exception e)
        {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}

