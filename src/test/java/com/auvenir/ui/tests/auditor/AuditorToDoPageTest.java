package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
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
        String specialChars = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Special Chars", "Todo Name  01");
        String nullChars = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Null Char", "Todo Name  01");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyTodosTextBox_AfterClickedAddTodo();
            auditorCreateToDoService.inputValidValue_TodoName(validTodo);
            auditorCreateToDoService.verifyInputValidValue(validTodo);
            auditorCreateToDoService.inputOnlyNumber(number);
            auditorCreateToDoService.verifyInputNumber(number);
            auditorCreateToDoService.InputSpecialChar(specialChars);
            auditorCreateToDoService.verifyInputSpecialChar(specialChars);
            auditorCreateToDoService.InputNullChar("");
            auditorCreateToDoService.verifyInputNullChar("");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Todos Textbox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Todos Textbox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify Category Combo box")
    public void verifyCategoryComboBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  01");
        String categoryName1 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 01");
        String categoryName2 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 02");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.inputValidValue_TodoName(validTodo);
            auditorCreateToDoService.verifyCategoryComboBox_DefaultValue();
            auditorCreateToDoService.createCategories(categoryName1);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName1);
            auditorCreateToDoService.createCategories(categoryName2);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName2);
            auditorCreateToDoService.selectCategoryByName(categoryName1);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName1);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Category Combo box.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Category Combo box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify Client Assignee Combo box")
    public void verifyClientAssigneeComboBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifyClientAssigneeComboBox_DefaultValue();
//            auditorCreateToDoService.verifyClientAssigneeIsSelectedCorrectly();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify Due date Time box")
    public void verifyDuedateTimebox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        try {
            boolean isNewToDoPage = false;
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifyDuedateTimebox_DefaultValue(deadlineDate);
            auditorCreateToDoService.checkFormatDueDate();
            auditorCreateToDoService.verifyUnableToInputDuedate("12/4/2017");
            auditorCreateToDoService.chooseDateItemInDatePicker(isNewToDoPage, "", "", "");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Due date Time box.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Due date Time box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify Audit Assignee box")
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

    @Test(priority = 6, enabled = true, description = "Verify CreateNewTodo, Filter, BulkAction buttons")
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

    @Test(priority = 7, enabled = true, description = "Verify SearchBox")
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

    @Test(priority = 8, enabled = true, description = "Verify realtime Search")
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
            auditorCreateToDoService.inputValidValue_TodoName("happytime6969");
            auditorCreateToDoService.waitForNewTodoNameApplied();
            auditorCreateToDoService.createCategories("automation114");
            auditorCreateToDoService.selectCategoryByName("automation114");
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


    /**
     * Add new by huy.huynh on 28/06/2017.
     * R2.1 NewFeature
     */
    private String adminId, auditorId, clientId;
    private String adminPassword, auditorPassword, clientPassword;
    private String engagementName, todoName;

    @Test(priority = 10, enabled = true, description = "Verify dueDate on Todo Detail Popup is match with on Todo Row.")
    public void verifyDueDateOnToDoDetailsMatchWithOnToDoRow() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        String dueDate = "";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);


            auditorCreateToDoService.createNewToDoTask(todoName);
            dueDate = auditorCreateToDoService.getToDoDueDateOnRow(todoName);
            auditorCreateToDoService.openPopupTodoDetail(todoName);
            auditorCreateToDoService.verifyDueDateMatching(dueDate);

            auditorCreateToDoService.changeDueDateOnTodoDetail();
            auditorCreateToDoService.closePopupTodoDetail();
            dueDate = auditorCreateToDoService.getToDoDueDateOnRow(todoName);
            auditorCreateToDoService.openPopupTodoDetail(todoName);
            auditorCreateToDoService.verifyDueDateMatching(dueDate);

            auditorCreateToDoService.closePopupTodoDetail();
            auditorCreateToDoService.changeDueDateOnTodoRow(todoName);
            dueDate = auditorCreateToDoService.getToDoDueDateOnRow(todoName);
            auditorCreateToDoService.openPopupTodoDetail(todoName);
            auditorCreateToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 10, enabled = true, description = "Verify UI on Todo Detail Popup.")
    public void verifyUIOnToDoDetails() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        String dueDate = "";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);


            auditorCreateToDoService.createNewToDoTask(todoName);
            //dueDate = auditorCreateToDoService.getToDoDueDateOnRow(todoName);
            auditorCreateToDoService.openPopupTodoDetail(todoName);
            auditorCreateToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify UI on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify UI on Todo Detail Popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify UI on Todo Detail Popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }
    /*-----------end of huy.huynh on 28/06/2017.*/
}


