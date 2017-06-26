package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by vien.pham on 5/22/2017.
 */
public class AuditorToDoPageTest extends AbstractTest {

    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEditCategoryService auditorEditCategoryService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;


    @Test(priority = 1, enabled = true, description = "Verify Todos Textbox")
    public void verifyTodosTextBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  01");
        String number = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Number Value", "Todo Name  01");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyTodosTextBox_AfterClickedAddTodo();
            auditorCreateToDoService.inputValidValue(validTodo);
            auditorCreateToDoService.verifyInputValidValue(validTodo);
            auditorCreateToDoService.inputOnlyNumber("1212121");
            auditorCreateToDoService.verifyInputNumber("1212121");
            getLogger().info("Verifying input Special Char..");
            auditorCreateToDoService.InputSpecialChar("1308@#%^&*()");
            auditorCreateToDoService.verifyInputSpecialChar("1308@#%^&*()");
            getLogger().info("Verifying input Nullchar...");
            auditorCreateToDoService.InputNullChar("");
            auditorCreateToDoService.verifyInputNullChar("");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Todos Textbox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Todos Textbox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = false, description = "Verify Category Combo box")
    public void verifyCategoryComboBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            getLogger().info("Verifying Category box default value..");
            auditorCreateToDoService.verifyCategoryComboBox_DefaultGUI();
            getLogger().info("Verifying new Category was created correctly..");
            auditorCreateToDoService.createCategories("automation011");
            auditorCreateToDoService.verifyNewCategorySaved("automation010");
            getLogger().info("Verifying new Category was chosen and displayed correctly..");
            auditorCreateToDoService.selectCategory();
            auditorCreateToDoService.verifyNewCategoryChosenCorrectly("automation011");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Category Combo box.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Category Combo box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 3, enabled = false, description = "Verify Client Assignee Combo box")
    public void verifyClientAssigneeComboBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyClientAssigneeComboBox();
            auditorCreateToDoService.verifyClientAssigneeIsSelectedCorrectly();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 4, enabled = false, description = "Verify Due date Time box")
    public void verifyDuedateTimebox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            boolean isNewToDoPage = false;
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            getLogger().info("Verifying Duedate Timebox..");
            auditorCreateToDoService.verifyDuedateTimebox();
            getLogger().info("Verifying unable to send text into Duedate box..");
            auditorCreateToDoService.verifyUnableToInputDuedate("12/4/2017");
            getLogger().info("Choosing date in table due-date..");
            auditorCreateToDoService.chooseDateItemInDatePicker(isNewToDoPage);
            getLogger().info("Verifying format is mm/dd/yyy..");
            auditorCreateToDoService.checkFormatDueDate();
            getLogger().info("Verifying click to Prev Date..");
            auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
//            getLogger().info("Verifying click to Next Date..");
//            auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Due date Time box.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Due date Time box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 5, enabled = false, description = "Verify Audit Assignee box")
    public void verifyAuditAssigneeBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyAuditAssigneeBox();
            auditorCreateToDoService.verifyAuditAssigneeIsSelectedCorrectly();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 6, enabled = false, description = "Verify CreateNewTodo, Filter, BulkAction buttons")
    public void verifyTodoPage_Buttons() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            getLogger().info("Verifying Create Todo Button..");
            auditorCreateToDoService.verifyCreateTodoBtn();
            getLogger().info("Verifying Filter Btn next to Createtodo Btn..");
            auditorCreateToDoService.verifyFilterBtn();
            getLogger().info("Verifying BulkAction Btn next to Filter Btn..");
            auditorCreateToDoService.verifyBulkActionBtn();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Buttons of Todo Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Buttons of Todo Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 7, enabled = false, description = "Verify SearchBox")
    public void verifySearchBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            getLogger().info("Verifying Search Box default value..");
            auditorCreateToDoService.verifySearchBox_DefaultGUI();
            getLogger().info("Verifying input text on Search box..");
            auditorCreateToDoService.verifySearchInputText();
            getLogger().info("Verifying input number on Search box..");
            auditorCreateToDoService.verifySearchInputNumber();
            getLogger().info("Verifying iput special chars Search box..");
            auditorCreateToDoService.verifySearchInputSpecialChar();
            getLogger().info("Verifying search max length..");
            auditorCreateToDoService.verifyCheckMaxLength();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify SearchBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 8, enabled = false, description = "Verify realtime Search")
    public void verifyRealTimeSearch() throws Exception {

        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            boolean isNewToDoPage = false;
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            getLogger().info("Preparing Todo list data..");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.inputValidValue("happytime6969");
            auditorCreateToDoService.waitForNewTodoNameApplied();
            auditorCreateToDoService.createCategories("automation114");
            auditorCreateToDoService.selectCategory();
            auditorCreateToDoService.verifyClientAssigneeIsSelectedCorrectly();
            auditorCreateToDoService.chooseDateItemInDatePicker(isNewToDoPage);
            auditorCreateToDoService.verifyAuditAssigneeIsSelectedCorrectly();
            getLogger().info("Verifying realtime search..");
            getLogger().info("Input search full match with todo name, categoryname, assignclient or assignAudit..");
            auditorCreateToDoService.inputSearchText("happytime6969");
            Thread.sleep(500);
            auditorCreateToDoService.verifySearchResult("happytime6969");
            getLogger().info("Input search full match with categoryname..");
            auditorCreateToDoService.inputSearchText("automation114");
            Thread.sleep(500);
            auditorCreateToDoService.verifySearchResult("automation114");
            getLogger().info("Input search full match with assignclient..");
            auditorCreateToDoService.inputSearchText("admin client");
            Thread.sleep(500);
            auditorCreateToDoService.verifySearchResult("admin client");
            getLogger().info("Input search full match with assignAudit..");
            auditorCreateToDoService.inputSearchText("Admin Auditor");
            Thread.sleep(500);
            auditorCreateToDoService.verifySearchResult("Admin Auditor");
            getLogger().info("Input search do not match with todo name, categoryname, assignclient and assignAudit..");
            auditorCreateToDoService.inputSearchText("FATREWAFDFYRETRETE");
            auditorCreateToDoService.verifySearchResutlNotMatch();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify SearchBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 9, enabled = true, description = "Verify Data Grid")
    public void verifyDataGrid() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");
            auditorCreateToDoService.navigatetoCreateToDoTab();
            getLogger().info("Verifying column in Grid..");
            auditorCreateToDoService.verifyColumnsInGrid();
            getLogger().info("Verifying Sort icon..");
            auditorCreateToDoService.verifySotleOnTitle();
            getLogger().info("Verifying Sort action..");
            auditorCreateToDoService.verifySortDataGridIcon();
            getLogger().info("Verifying check checkall..");
            auditorCreateToDoService.verifyCheckAllCheckBox();
            getLogger().info("Verifying uncheck checkall..");
            auditorCreateToDoService.verifyUncheckAllCheckbox();
            getLogger().info("Verifying check multi line");
            auditorCreateToDoService.verifyCheckBoxToDoName();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify SearchBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}


