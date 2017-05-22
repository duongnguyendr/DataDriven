package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tan.pham on 5/17/2017.
 */
public class AddDeleteIconTest extends AbstractTest
{
    AuditorCreateToDoService auditorCreateToDoService;
    AuditorEngagementService auditorEngagementService;
    AuditorDetailsEngagementService auditorDetailsEngagementService;

    @Test(  priority = 1,enabled = true, description = "Verify GUI of delete icon in ToDo page.")
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
            auditorEngagementService.createAndSelectNewEnagement("Engagement 01","","AAA");
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

    @Test(  priority = 2,enabled = true, description = "Verify default status of delete icon in ToDo page.")
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

    @Test(  priority = 3,enabled = true, description = "Verify gui of delete confirm popup in ToDo page.")
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
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String todoName = "ToDo" + dateFormat.format(date);
            // Add one ToDo name
            ArrayList<String> toDoListNames = new ArrayList<String>();
            toDoListNames.add(todoName);
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo has just created
            auditorCreateToDoService.selectToDoTaskName(todoName);
            // verify GUI delete confirm popup
            auditorCreateToDoService.verifyGUIDeleteConfirmPopup();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify gui of delete confirm popup in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify gui of delete confirm popup in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 4,enabled = true, description = "Verify work flow of 'CheckAll' check box in ToDo page.")
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
            //Check on 'Check all' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            //Verify all check box is checked
            auditorCreateToDoService.verifyAllCheckBoxIsCheckOrUnCheck(true);
            //Un Check on 'Check all' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(false);
            //Verify all check box is un checked
            auditorCreateToDoService.verifyAllCheckBoxIsCheckOrUnCheck(false);
            //Check all check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            //Verify 'CheckAll' check box is check
            auditorCreateToDoService.verifyCheckAllCheckBoxIsCheckOrUncheck(true);
            //Uncheck all check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(false);
            //Verify 'CheckAll' check box is uncheck
            auditorCreateToDoService.verifyCheckAllCheckBoxIsCheckOrUncheck(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of 'CheckAll' check box in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of 'CheckAll' check box in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 5,enabled = true, description = "Verify work flow of delete button in ToDo page.")
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
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String todoName = "ToDoDelete" + dateFormat.format(date);
            // Add one ToDo name
            ArrayList<String> toDoListNames = new ArrayList<String>();
            toDoListNames.add(todoName);
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo has just created
            auditorCreateToDoService.selectToDoTaskName(todoName);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check ToDo has not exists
            auditorCreateToDoService.checkToDoIsExists(false,todoName);

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
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String todoName = "ToDoCancel" + dateFormat.format(date);
            // Add one ToDo name
            ArrayList<String> toDoListNames = new ArrayList<String>();
            toDoListNames.add(todoName);
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo has just created
            auditorCreateToDoService.selectToDoTaskName(todoName);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickCancelButtonOnPopup();
            // Check ToDo has exists
            auditorCreateToDoService.checkToDoIsExists(true,todoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel button in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel button in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
