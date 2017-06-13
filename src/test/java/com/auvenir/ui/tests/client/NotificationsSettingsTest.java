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
public class NotificationsSettingsTest extends AbstractTest {
    private ClientService clientService;


    @Test(priority=1,enabled=true, description="Verify Footer in Client Notification Settings page.")
    public void verifyFooterClientNotificationsSettingsPage() throws Exception {
        clientService = new ClientService(getLogger(),getDriver());
        String userId = GenericService.getUserFromExcelData("ClientTestData", "Valid User", "Client");

        try {
            //logCurrentStepStart();
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHomePage();
            clientService.navigateToClientSettingsPage();
            clientService.verifyAccountSettingsPage();
            clientService.navigateToNotificationsTab();
            clientService.verifyNotificationsSettingsPage();
            clientService.verifyClientFooter();
            NXGReports.addStep("Verify Notification Setting footer page.", LogAs.PASSED, null);
            //logCurrentStepEnd();
        } catch (Exception e) {
            NXGReports.addStep("Verify Notification Setting footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


