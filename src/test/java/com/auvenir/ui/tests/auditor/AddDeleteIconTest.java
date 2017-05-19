package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by tan.pham on 5/17/2017.
 */
public class AddDeleteIconTest extends AbstractTest
{
    AuditorCreateToDoService auditorCreateToDoService;
    AuditorEngagementService auditorEngagementService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;

    @Test(  priority = 1,enabled = false, description = "Verify GUI of delete icon in ToDo page.")
    public void verifyGUIDeleteIconInToDoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            // Verify trash to do icon
            auditorCreateToDoService.verifyTrashToDoIcon();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of delete icon in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of delete icon in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 2,enabled = false, description = "Verify default status of delete icon in ToDo page.")
    public void verifyDefaultStatusDeleteIconInToDoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            // Verify trash to do icon
            auditorCreateToDoService.verifyDefaultStatusTrashToDoIcon();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify default status of delete icon in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify default status of delete icon in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 3,enabled = false, description = "Verify gui of delete confirm popup in ToDo page.")
    public void verifyGUIDeleteConfirmPopupInToDoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            // Verify trash to do icon
            auditorCreateToDoService.verifyGUIDeleteConfirmPopup();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify gui of delete confirm popup in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify gui of delete confirm popup in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 4,enabled = false, description = "Verify work flow of 'CheckAll' check box in ToDo page.")
    public void verifyCheckAllCheckBoxInToDoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            // Verify work flow of 'CheckAll' check box
            auditorCreateToDoService.verifyCheckAllCheckBox();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of 'CheckAll' check box in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of 'CheckAll' check box in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 5,enabled = false, description = "Verify work flow of delete button in ToDo page.")
    public void verifyWorkFlowOfDeleteButtonInToDoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            // Verify work flow of delete button
            auditorCreateToDoService.verifyWorkFlowOfDeleteButton();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete button in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete button in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 6,enabled = true, description = "Verify work flow of cancel button in ToDo page.")
    public void verifyWorkFlowOfCancelButtonInToDoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            // Verify work flow of cancel button
            auditorCreateToDoService.verifyWorkFlowOfCancelButton();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel button in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel button in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
