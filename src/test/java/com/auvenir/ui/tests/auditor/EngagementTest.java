package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class EngagementTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;

    String auditorId;
    String timeStamp;

    @Test(priority = 1, enabled = true, description = "Verify Footer in Auditor Engagements page.")
    public void verifyFooterAuditorEngagementPage() throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        /*String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");*/
        try {
            //logCurrentStepStart();
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifyAuditorFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify footer in Auditor Engagement page.", LogAs.PASSED, null);
            // logCurrentStepEnd();

        } catch (Exception e) {
            NXGReports.addStep("Verify footer in Auditor Engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * verify UI of New Engagement flow
     */
    @Test(priority = 2, enabled = true, description = "Verify UI of New Engagement page.")
    public void verifyUINewEngagement() {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        try {
//            auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
            auditorId = GenericService.getUserFromExcelData("LoginData", "Valid User", "Auditor");
//            auditorId= auditorId.replace("chr.","");
//            System.out.println("auditorId = " + auditorId);

            String name= "engagement" + GeneralUtilities.getTimeStampForNameSuffix();

            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();

            auditorNewEngagementService.verifyUINewEngagementSetUp(name);
            auditorNewEngagementService.verifyUINewEngagementTeam(name);
            auditorNewEngagementService.verifyUINewEngagementCustomize(name);

            NXGReports.addStep("Finish: Verify UI of New Engagement page.", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  Verify UI of New Engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of List Engagement page
     */
    @Test(priority = 3, enabled = true, description = "Verify UI of List Engagement page.")
    public void verifyUIListEngagement() {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        try {
//            auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
            auditorId = GenericService.getUserFromExcelData("LoginData", "Valid User", "Auditor");
//            auditorId= auditorId.replace("chr.","");
//            System.out.println("auditorId = " + auditorId);

            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();

            auditorEngagementService.verifyUIListEngagement();

            NXGReports.addStep("Finish: Verify UI of List Engagement page.", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  Verify UI of List Engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }
}



