package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.AuditorAccountSettingsService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.auvenir.utilities.constant.*;
/**
 * Created by cuong.nguyen on 4/27/2017.
 * Edited by Doai.Tran - PLAT 2273
 */

public class AuditorSettingsTest extends AbstractTest {
    AuditorAccountSettingsService auditorAccountSettingsService;
    AuditorEngagementService auditorEngagementService;


    //@Test(priority=1,enabled=true, description="Verify Footer in Auditor Account Settings page.")
    @Test(priority=1,enabled=true, description= TestConstants.VERIFY_FOOTER_AUDITOR_ACCOUNT_SETTING_PAGE)
    public void verifyFooterAuditorAccountSettingsPage() throws Exception
    {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(),getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        //String userId= GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, TestConstants.AUDITOR_ID_PARAMETER);
        try
        {
            auditorAccountSettingsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyAccountSettingsPage();
            auditorAccountSettingsService.verifyFooter();
            //NXGReports.addStep("Verify Footer in Auditor Account Settings page.", LogAs.PASSED, null);
            NXGReports.addStep(TestConstants.VERIFY_FOOTER_AUDITOR_ACCOUNT_SETTING_PAGE_PASS, LogAs.PASSED, null);
        }

        catch (Exception e)
        {
            //NXGReports.addStep("Verify Footer in Auditor Account Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            NXGReports.addStep(TestConstants.VERIFY_FOOTER_AUDITOR_ACCOUNT_SETTING_PAGE_FAIL, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
    //@Test(priority = 2,enabled = true,description = "Verify GUI auditor setting page.")
    @Test(priority = 2,enabled = true,description = TestConstants.VERIFY_GUI_AUDITOR_ACCOUNT_SETTING_PAGE)
    public void verifyUIAuditorSetting() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(),getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        //String userId= GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, TestConstants.AUDITOR_ID_PARAMETER);
        try{
            auditorAccountSettingsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyBody();
            auditorAccountSettingsService.verifyFooter();
            //Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, TestConstants.SCRIPT_FAIL);
            //NXGReports.addStep("Verify GUI auditor setting page: PASSED", LogAs.PASSED, (CaptureScreen)null);
            NXGReports.addStep(TestConstants.VERIFY_GUI_AUDITOR_ACCOUNT_SETTING_PAGE_PASS, LogAs.PASSED, null);
        }catch (Exception e)
        {
            //NXGReports.addStep("Verify All UI Audit Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            NXGReports.addStep(TestConstants.VERIFY_GUI_AUDITOR_ACCOUNT_SETTING_PAGE_FAIL, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
    //@Test(priority = 3,enabled = true,description = "Test First and Last name on Auditor Setting Page.")
    @Test(priority = 3,enabled = true,description = TestConstants.TEST_FIRST_LAST_NAME_FIELD_IN_ACCOUNT_SETTING_PAGE)
    public void InputValueFullName() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(),getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try{
            auditorAccountSettingsService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            getLogger().info("Input any value on FullName TextBox.");
            auditorAccountSettingsService.inputFullName("Doai Test");
            auditorAccountSettingsService.sendTabkeyFullNametxt();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test First and Last name on Auditor Setting Page: Passed", LogAs.PASSED, (CaptureScreen)null);
        }catch (Exception e)
        {
            NXGReports.addStep("Test First and Last name on Auditor Setting Page: PASSED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


