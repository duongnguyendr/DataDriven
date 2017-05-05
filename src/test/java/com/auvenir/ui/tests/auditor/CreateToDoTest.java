package com.auvenir.ui.tests.auditor;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.ui.services.AuditorCreateToDoService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by Hai.Nguyen on 05/04/2017.
 * Implement for PLAT - 2288
 */
public class CreateToDoTest extends AbstractTest {
    AuditorCreateToDoService auditorCreateToDoService;
    
    
    @Test(  priority = 1,enabled = true, description = "Verify GUI auditor create to do page.")
    public void verifyUIAuditorCreateToDo() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);            
            auditorCreateToDoService.verifyAuditorCreateToDo();
            auditorCreateToDoService.verifyDataSearch("MinhNH test 01");
            //Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI auditor create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
