package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.dataprovider.auditor.AuditorToDoListDataProvider;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */


public class AuditorTodoListTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEditCategoryService auditorEditCategoryService;
    private MarketingService marketingService;

    //String auditorId;
    String timeStamp;
    String firstEngagementTitleOnWeb;
    //String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
    private ClientService clientService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;

    @Test(priority = 1, enabled = true, description = "Verify Auditor empty Todo List page.", dataProvider = "verifyAuditorEmptyTodoListPage" , dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyAuditorEmptyTodoListPage(String auditorId, String auditorPwd, String engagementType, String companyName, String engagementName) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementType = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Type", "Valid Data");
        String companyName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Company Name", "Valid Data");*/
        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();

            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);

            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyEmptyTodoList();
            auditorTodoListService.verifyTodoListPageColumnHeader();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.PASSED, null);
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify to create To-Do page and search data.", dataProvider = "verifyCreateToDoPageCategorySearchData", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCreateToDoPageCategorySearchData(String auditorId, String auditorPwd, String toDoName, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
/*
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.verifyDataSearch();
            auditorCreateToDoService.verifyCheckMaxLength();
            auditorCreateToDoService.verifyContentTextSearch(toDoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

//    @Test(priority = 3, enabled = true, description = "Verify to create new Category")
//    public void verifyCreateNewCategory() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
//        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
//        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
//        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
//        try {
//            auditorEngagementService.loginWithUserRole(userId);
//            auditorEngagementService.verifyAuditorEngagementPage();
//            auditorEngagementService.viewEngagementDetailsPage(engagementName);
//            auditorCreateToDoService.createToDoPage();
//            auditorCreateToDoService.verifyCreateNewCategory();
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
//            NXGReports.addStep("Verify to create new Category", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("Verify to create new Category", LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//            getLogger().info(e);
//            throw e;
//        }
//    }

    @Test(priority = 4, enabled = true, description = "Verify new Category popup", dataProvider ="verifyNewCategoryPopup", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyNewCategoryPopup(String auditorId, String auditorPwd, String toDoName, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.verifyAddNewCategoryPopupTitle();
            auditorCreateToDoService.verifyNewCategoryNameTextbox();
            auditorCreateToDoService.verifyNewCategoryColorCombobox();
            auditorCreateToDoService.verifyNewCategoryCreateCancelButton();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify new Category popup", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify new Category popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "verify displayed of this button filter", dataProvider = "verifyButtonFilter", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyButtonFilter(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.verifyButtonFilter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify displayed of this button filter", LogAs.PASSED, null);
        } catch (Exception e) {
            /*NXGReports.addStep("verify displayed of this button filter", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);*/
            String stepException = "Verify displayed of this button filter failed because " + e.getMessage();
            NXGReports.addStep("verify displayed of this button filter", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), stepException);
            throw e;
        }
    }

    @Test(priority = 6, enabled = true, description = "verify default value(Search...) of this Search", dataProvider = "verifySearchPlaceholder", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifySearchPlaceholder(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            auditorCreateToDoService.verifySearchPlaceholder();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    @Test(priority = 7, enabled = true, description = "verify when hover on Search change bounary color to green.", dataProvider = "verifySearchHover", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifySearchHover(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
/*
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            auditorCreateToDoService.verifySearchHover();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 8, enabled = true, description = "verify input text.",dataProvider = "verifySearchInputText", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifySearchInputText(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.inputSearchText("Search Todo");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify input text.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify input text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

//    @Test(priority = 9, enabled = true, description = "verify input number to field search.")
//    public void verifySearchInputNumber() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
//        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
//        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
//        marketingService = new MarketingService(getLogger(), getDriver());
//        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
//        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
//        try {
//            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
//            auditorEngagementService.verifyAuditorEngagementPage();
//            auditorEngagementService.viewEngagementDetailsPage(engagementName);
//            auditorCreateToDoService.inputSearchNumber(12121212);
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
//            NXGReports.addStep("verify input number to field search.", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("verify input number to field search.", LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//            getLogger().info(e);
//            throw e;
//        }
//    }

    // These testcases are removed because the business is changed, Save Icon and Close Icon do not exists anymore.
/*    @Test(priority = 10, enabled = true, description = "[PLAT 2282]-03: Verify GUI To Do Save Icon")
    public void verifyGUIToDoSaveIcon() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.clickCreateToDoTask();
            auditorCreateToDoService.verifyGUIToDoSaveIconDisabled();
            auditorCreateToDoService.verifyInputDataToDoNameTextBox("Task Test Save Icon");
            auditorCreateToDoService.setDueDateField();
            auditorCreateToDoService.verifyGUIToDoSaveIconEnabled();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI Save Icon - create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI Save Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 11, enabled = true, description = "[PLAT 2282]-03: Verify GUI To Do Close Icon")

    public void verifyGUIToDoCloseIcon() throws Exception {
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifyToDoCloseIcon();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI Close Icon - create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI Close Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }*/

    @Test(priority = 12, enabled = true, description = "[PLAT 2282]-03: Verify Data Grid after adding new To Do Task", dataProvider = "verifyDataGridToDoTaskPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDataGridToDoTaskPage(String auditorId, String auditorPwd, String engagementName, String[] toDoListNames) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String toDoListNames[] = {"416 To Do Task02", "a To Do Task02", "z To Do Task02", "b To Do Task02", "c To Do Task02"};*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.createListToDoTask(Arrays.asList(toDoListNames));
            auditorCreateToDoService.verifySortDataGridIcon();
            auditorCreateToDoService.verifyCheckBoxToDoName();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Data Grid after adding new To Do Task", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Data Grid after adding new To Do Task", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 13, enabled = true, description = "[PLAT 2289]: Verify 'Category' combo box on Create to-do", dataProvider = "verifyCategoryComboBoxOnCreateToDo", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCategoryComboxBoxOnCreateToDo(String auditorId, String auditorPwd, String engagementName, String toDoName, String categoryName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
        String categoryName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Category Name", "Valid Data");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.createToDoTaskWithCategoryName(toDoName, categoryName);
            auditorCreateToDoService.clickCreateToDoTask();
            auditorCreateToDoService.verifyDefaultValueofCategoryComboBox();
            auditorCreateToDoService.verifyHoverCategoryComboBox();
            auditorCreateToDoService.verifyValueofCategoryComboBox(categoryName);
            auditorCreateToDoService.verifyNewCategoryPopUpDisplayed();
            auditorCreateToDoService.clickCancelButtonOnPopup();
            auditorCreateToDoService.verifyEditCategoryPopUpDisplayed();
            auditorCreateToDoService.clickCancelButtonOnPopup();
            auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task01 2289 without Category");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify 'Category' combo box on Create to-do", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify 'Category' combo box on Create to-do", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
    TestCase to cover ticket: PLAT 2283
     */
    @Test(priority = 14, enabled = true, description = "[PLAT 2283]: Verify Filter button next to create to-do button.", dataProviderClass = AuditorToDoListDataProvider.class, dataProvider = "verifyFilterButton")
    public void verifyFilterButton(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
/*
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyFilterDropDownList();
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Filter button next to create to-do button", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 15, enabled = true, description = "[PLAT 2283]: Verify default value on Filter dropdown.", dataProvider = "verifyDefaultValueFilterButton", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDefaultValueFilterButton(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyDefaultValueFilterDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI auditor create to do page: PASSED", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 16, enabled = true, description = "[PLAT 2283]: Verify border on Filter dropdown.",dataProvider = "verifyBorderOnFilterButton" , dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyBorderOnFilterButton(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyHoverFilterDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify border on Filter dropdown: PASSED.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 17, enabled = true, description = "[PLAT 2283]: Verify default value on Filter dropdown.",dataProvider = "verifyChooseAnOptionFilterButton", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyChooseAnOptionFilterButton(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifySelectShowAllDropDownList();
            auditorTodoListService.verifySelectDueDateDropDownList();
            auditorTodoListService.selectAndVerifyFirstAssignFilterDropDownList();
            auditorTodoListService.verifySelectWithCommentsDropDownList();
            auditorTodoListService.verifySelectCompleteDropDownList();
            //OutStanding is not implemented by DEV team
            auditorTodoListService.verifySelectFlaggedForRequestDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("verify ChooseAnOption Filter Button: PASSED.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }

    }

    @Test(priority = 18, enabled = true, description = "[PLAT 2283]: verify Unable Add More Option Filter DropDownList",dataProvider = "verifyUnableAddMoreOptionFilter", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyUnableAddMoreOptionFilter(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyUnableAddMoreOptionFilterDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("verify ChooseAnOption Filter Button: PASSED.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }

    }

    @Test(priority = 19, enabled = true, description = "[PLAT 2283]: verify select An VaLue On Assign Option Filter", dataProvider = "selectAnVaLueOnAssignOptionFilter", dataProviderClass = AuditorToDoListDataProvider.class)
    public void selectAnVaLueOnAssignOptionFilter(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.selectAndVerifyFirstAssignFilterDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("verify select An VaLue On Assign Option Filter: PASSED.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 20, enabled = true, description = "[PLAT 2283]: verify click And Do Not Select Option Filter", dataProvider = "clickAndDoNotSelectOptionFilter", dataProviderClass = AuditorToDoListDataProvider.class)
    public void clickAndDoNotSelectOptionFilter(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyClickAndDoNotSelectValue();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("verify select An VaLue On Assign Option Filter: PASSED.", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 21, enabled = true, description = "[PLAT 2282]-Verify To Do Name TextBox when Add new To Do", dataProvider = "verifyGUIToDoTextBox", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUIToDoTextBox(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            //auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            int numberOfTask = auditorCreateToDoService.getNumberofToDoTask();
            auditorCreateToDoService.clickCreateToDoTask();
            auditorCreateToDoService.verifyGUIAddNewToDoNameTextBox(numberOfTask);
            auditorCreateToDoService.verifyInputDataToDoNameTextBox("Task01");
            auditorCreateToDoService.verifyInputMaxLengthToDoNameTextBox();
            auditorCreateToDoService.verifyInputInValidValueToDoNameTextBox();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI auditor create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 22, enabled = true, description = "[PLAT 2284]-Verify GUI Add Bulk Actions on To Do Page", dataProvider = "verifyGUIToDoAddBulkActions", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUIToDoAddBulkActions(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.createNewToDoTask("Task 01 2284");
            auditorCreateToDoService.closeSuccessToastMes();
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.verifyDefaultValueofBulkActionsDropdown("Bulk Actions");
            auditorCreateToDoService.verifyHoverBulkActionsDropdown();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyListValueofBulkActionsDropdown();
            auditorCreateToDoService.clickDeleteToDoBulkActions();
            auditorCreateToDoService.verifyDeleteToDoPopUpDisplayed();
            auditorCreateToDoService.clickCloseButtonOnPopup();
            auditorCreateToDoService.verifyBulkActionsDropdownIsClosed();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Add Bulk Actions on To do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Add Bulk Actions on To do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 23, enabled = true, description = "Verify GUI of select date drop down in add new to-do page.", dataProvider = "verifyGUISelectDateDropDownInNewToDoPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUISelectDateDropDownInNewToDoPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Move to add new To-do page
            auditorCreateToDoService.navigateAddNewToDoPage();
            //Show Select date drop down
            auditorCreateToDoService.verifySelectDateDropDown();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of select date drop down on add new to-do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of select date drop down on add new to-do page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

//   @Test(priority = 24, enabled = true, description = "Verify due date drop down in add new to-do page.")
//    /**
//     * Fail :
//     * 1. default value due date date picker is not match with engagement due date :
//     auditorCreateToDoService.checkDefaultValueDueDate()
//     *  2. default format of engagement due date is not correct (dd/mm/yyyy) --> expected is mm/dd/yyyy :
//     auditorCreateToDoService.checkFormatDueDate()
//     * Note
//     * Current date picker has not ">" and "<" link, so will check "prev" and "next" replaced
//     *                          auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
//     *                          auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
//     */
//    public void verifyDueDateDropDownInNewToDoPage() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
//        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
//        marketingService = new MarketingService(getLogger(), getDriver());
//        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
//        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
//        try {
////            boolean isNewToDoPage = true; // true : verify in add new to-do page, false : verify in add to-do list page
//            // Login
//            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
//            // Move to engagement page
//            auditorEngagementService.verifyAuditorEngagementPage();
//            // Move to engagement detail page
//            auditorEngagementService.viewEngagementDetailsPage(engagementName);
//            // Move to add new To-do page
//            auditorCreateToDoService.navigateAddNewToDoPage();
//            //Check default value of due date
//            //auditorCreateToDoService.checkDefaultValueDueDate();
//            //Check format of due date
//            //auditorCreateToDoService.checkFormatDueDate();
//            //Check hove item in data picker
//            auditorCreateToDoService.hoverItemInDatePikcer(isNewToDoPage);
//            // Verify data of data picker
//            auditorCreateToDoService.verifyDataOfDatePicker(isNewToDoPage);
//            //Choose date item in date picker
//            auditorCreateToDoService.chooseDateItemInDatePicker(isNewToDoPage);
//            //Click on previous date picker link
//            auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
//            //Click on next date picker link
//            auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
//            // Verify input correct format date value
//            auditorCreateToDoService.verifyInputCorrectFormatDate(isNewToDoPage);
//            // Verify input wrong format date value
//            auditorCreateToDoService.verifyInputWrongFormatDate(isNewToDoPage);
//            // Verify input text in due date text box
//            auditorCreateToDoService.verifyInputTextValue(isNewToDoPage);
//            // Verify input text in due date text box
//            auditorCreateToDoService.verifyInputSpecialCharacterValue(isNewToDoPage);
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
//            NXGReports.addStep("Verify due date date picker on add new to-do page.", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("Verify due date date picker on add new to-do page.", LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//            throw e;
//        }
//    }

//    @Test(priority = 25, enabled = true, description = "Verify due date drop down in to-do list page.")
//    /**
//     * Fail :
//     * 1. Current code does not against when user input text and special character :
//     *                        auditorCreateToDoService.verifyInputSpecialCharacterValue(isNewToDoPage);
//     *                        auditorCreateToDoService.verifyInputTextValue(isNewToDoPage)
//     *
//     * Note
//     * Current date picker has not ">" and "<" link, so will check "prev" and "next" replaced
//     *                          auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
//     *                          auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
//     */
//    public void verifyDueDateDropDownInToDoListPage() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
//        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
//        marketingService = new MarketingService(getLogger(), getDriver());
//        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
//        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
//        try {
//            boolean isNewToDoPage = false;// true : verify in add new to-do page, false : verify in add to-do list page
//            // Login
//            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
//            // Move to engagement page
//            auditorEngagementService.verifyAuditorEngagementPage();
//            // Move to engagement detail page
//            auditorEngagementService.viewEngagementDetailsPage(engagementName);
//            //Check hove item in data picker
//            auditorCreateToDoService.hoverItemInDatePikcer(isNewToDoPage);
//            //Click on previous date picker link
//            auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
//            //Click on next date picker link
//            auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
//            //Choose date item in date picker
//            auditorCreateToDoService.chooseDateItemInDatePicker(isNewToDoPage);
//            // Verify input correct format date value
//            auditorCreateToDoService.verifyInputCorrectFormatDate(isNewToDoPage);
//            // Verify input wrong format date value
//            auditorCreateToDoService.verifyInputWrongFormatDate(isNewToDoPage);
//            // Verify input text in due date text box
//            //auditorCreateToDoService.verifyInputTextValue(isNewToDoPage);
//            //getLogger().info(AbstractService.sStatusCnt);
//            // Verify input text in due date text box
//            //auditorCreateToDoService.verifyInputSpecialCharacterValue(isNewToDoPage);
//            //getLogger().info(AbstractService.sStatusCnt);
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
//        } catch (Exception e) {
//            NXGReports.addStep("Verify due date date picker on to-do list page.", LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//            throw e;
//        }
//    }

    /**
     * Scenarios : [PLAT 2299] - Verify To-do Details Commenting
     */
    @Test(priority = 26, enabled = true, description = "Verify To-do Details Commenting", dataProvider = "verifyToDoDetailsCommenting", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyToDoDetailsCommenting(String auditorId, String auditorPwd, String engagementName, String todoName, String inputComment) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
//            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement2299");
            // Will edit when the code is updated with the new xpath and business.
//            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.navigateToDoListPage();

            // Will uncomment when the code is updated with the new xpath and business.
            auditorCreateToDoService.createNewToDoTask(todoName);
//            auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task2299");
//            auditorCreateToDoService.closeSuccessToastMes();
            auditorCreateToDoService.selectToDoTaskName(todoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(todoName);
            auditorCreateToDoService.verifyInputAComment(inputComment);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, inputComment);
            auditorCreateToDoService.verifyBoxTitleComment();
            auditorCreateToDoService.verifyClickOnInputCommentField();
            auditorCreateToDoService.verifyGUIPostButton();
            auditorCreateToDoService.verifyDefaultHintValueInputComment();
            auditorCreateToDoService.verifyGUICommentList(inputComment);
            auditorCreateToDoService.verifyUserInputNoContentComment();
            auditorCreateToDoService.verifyInputMaxLenghtContentComment(512);
            auditorCreateToDoService.verifyInputSpecialCharactersContentComment();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Added by minh.nguyen on 19/05/2017.
     */
    @Test(priority = 27, enabled = true, description = "Verify mark as complete", dataProvider = "verifyMarkAsComplete", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyMarkAsComplete(String auditorId, String auditorPwd, String engagementName, String toDoName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String toDoName = "TestMarkComplete01";
        String engagementName = "Engagement 07";*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.verifyClickCloseMarkPopup();

            auditorCreateToDoService.createNewToDoTask(toDoName);
            int index = auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickArchiveTaskButton();
            auditorCreateToDoService.verifyMarkCompleteArchive(index);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify new Category popup", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify new Category popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Added by huy.huynh on 18/05/2017.
     * Scenarios : PLAT 2285 - Add undo option
     * Modified by huy.huynh on 19/05/2017.
     * Merge with PLAT 2303(merge frontend and backend)
     */

    /**
     * (precondition)init value for variables
     * dependsOnMethods: setUp on AbstractTest
     */
    //TODO
    //@BeforeMethod(dependsOnMethods = {"setUp"})
    /*public void initVariable() {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());

        auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();

        auditorEngagementService.loginWithUserRole(auditorId);
        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.clickNewEnagementButton();
        auditorNewEngagementService.verifyNewEngagementPage();

        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
        auditorEngagementService.verifyAuditorEngagementPage();

        //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
        firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();

        auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
        auditorDetailsEngagementService.navigateToTodoListPage();
    }*/

    /**
     * (precondition)flow to Needed-To-Test page
     * dependsOnMethods: initVariable
     */
    //@BeforeMethod(dependsOnMethods = {"initVariable"})
    /*public void navigationPreconditions() {
        auditorEngagementService.loginWithUserRole(auditorId);
        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.clickNewEnagementButton();
        auditorNewEngagementService.verifyNewEngagementPage();

        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
        auditorEngagementService.verifyAuditorEngagementPage();

        //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
        firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();

        auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
        auditorDetailsEngagementService.navigateToTodoListPage();
    }*/

    /**
     * (case)verify button Undo action exist
     */
    @Test(priority = 28, enabled = true, testName = "Verify GUI.", description = "verify Undo Button exist ", groups = "ui", dataProvider = "verifyButtonUndoExist", dataProviderClass = AuditorToDoListDataProvider.class)
    public void uiVerifyButtonUndoExist(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
//            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
//            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
//            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
//            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.uiVerifyButtonUndoExist();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify button Undo exist.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify button Undo exist.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify button Undo action disable
     */
    @Test(priority = 29, enabled = true, testName = "Undo arrow.", description = "verify button Undo action disable", groups = "ui", dataProvider = "verifyButtonUndoStatus", dataProviderClass = AuditorToDoListDataProvider.class)
    public void uiVerifyButtonUndoStatus(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName, String toDoName) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName,engagementType,companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
//            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
//            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
//            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
//            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.uiVerifyButtonUndoDisable();

            auditorTodoListService.createToDoRecord(toDoName, "25");
            auditorTodoListService.chooseAndActAToDoWithName(toDoName, "Mark as complete", "");
            auditorTodoListService.uiVerifyButtonUndoEnable();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify button Undo status.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify button Undo status.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify Undo action Complete a To-Do, verified change on database but UI
     */
    @Test(priority = 30, enabled = true, testName = "Undo successfully", description = "verify Undo action Complete a To-Do, verified change on database but UI", groups = "workflow", dataProvider = "verifyUndoActionWithCompleteCase", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyUndoActionWithCompleteCase(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName, String toDoName01, String toDoName02) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
/*
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
*/
        try {
            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
//            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
//            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
//            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
//            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.createToDoRecord(toDoName02, "26");

            auditorTodoListService.chooseAndActAToDoWithName(toDoName01, "Mark as complete", "");
            auditorTodoListService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, toDoName01, "true");

            auditorTodoListService.undoAction();
            auditorTodoListService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, toDoName01, "false");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Undo action with Complete case.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Undo action with Complete case.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify Undo action Assign to a To-Do, verified change on UI but database
     */
    @Test(priority = 31, enabled = true, testName = "Undo successfully", description = "verify Undo action Assign to a To-Do, verified change on UI but database", groups = "workflow", dataProvider = "verifyUndoActionWithAssignToCase", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyUndoActionWithAssignToCase(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName, String toDoName01, String toDoName02) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
//            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
//            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
//            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
//            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.createToDoRecord(toDoName02, "26");

            auditorTodoListService.chooseAndActAToDoWithName(toDoName01, "Assign to", "huy assignee (auditor)");
            auditorTodoListService.verifyToDoAssigneeToName(firstEngagementTitleOnWeb, toDoName01, "huy assignee");
            Thread.sleep(2000);
            auditorTodoListService.undoAction();
            auditorTodoListService.verifyToDoAssigneeToName(firstEngagementTitleOnWeb, toDoName01, "huy huynh");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Undo action with Assign to case.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Undo action with Assign to case.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify Undo action Delete a To-Do, verified change on database but UI
     */
    @Test(priority = 32, enabled = true, testName = "Undo successfully", description = "verify Undo action Delete a To-Do, verified change on database but UI", groups = "workflow", dataProvider = "verifyUndoActionWithDeleteCase", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyUndoActionWithDeleteCase(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName, String toDoName01, String toDoName02) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
/*
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
*/
        try {

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
//            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
//            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
//            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
//            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.createToDoRecord(toDoName02, "26");

            auditorTodoListService.chooseAndActAToDoWithName(toDoName02, "Delete", "huy assignee (auditor)");
            auditorTodoListService.verifyToDoDeleteStatusByName(firstEngagementTitleOnWeb, toDoName02, "INACTIVE");

            auditorTodoListService.undoAction();
            auditorTodoListService.verifyToDoDeleteStatusByName(firstEngagementTitleOnWeb, toDoName02, "ACTIVE");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Undo action with Delete case.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Undo action with Delete case.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify Undo action Download Attachments disable
     */
    @Test(priority = 33, enabled = true, testName = "Undo fail", description = "verify Undo action Download Attachments disable", groups = "workflow", dataProvider = "verifyDownloadAttachmentsDisable", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDownloadAttachmentsDisable(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName, String toDoName01) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
/*
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
//            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
//            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
//            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
//            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.verifyToDoDownloadAttachmentsDisable(toDoName01);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Download Attachments disable.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Download Attachments disable.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * -----end of huy.huynh PLAT-2285-----
     */

    /**
     * Added by tan.pham on 19/05/2017.
     * Scenarios : PLAT 2286 - Add delete icon
     */
    @Test(priority = 34, enabled = true, description = "Verify GUI of delete icon in ToDo page.", dataProvider = "verifyGUIDeleteIconInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUIDeleteIconInToDoListPage(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            //Login
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createAndSelectNewEnagement(engagementName, engagementType, companyName);
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

    @Test(priority = 35, enabled = true, description = "Verify default status of delete icon in ToDo page.", dataProvider = "verifyDefaultStatusDeleteIconInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDefaultStatusDeleteIconInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
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

    @Test(priority = 36, enabled = true, description = "Verify gui of delete confirm popup in ToDo page.", dataProvider = "verifyGUIDeleteConfirmPopupInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUIDeleteConfirmPopupInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String todoName = "ToDo" + dateFormat.format(date);
            // Add one To-Do name
            ArrayList<String> toDoListNames = new ArrayList<String>();
            toDoListNames.add(todoName);
            // Create To-Do follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select To-Do has just created
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

    @Test(priority = 37, enabled = true, description = "Verify work flow of 'CheckAll' check box in ToDo page.", dataProvider = "verifyCheckAllCheckBoxInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCheckAllCheckBoxInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
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

    @Test(priority = 38, enabled = true, description = "Verify work flow of delete button in ToDo page.", dataProvider = "verifyWorkFlowOfDeleteButtonInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfDeleteButtonInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Create To-Do name list
            String todoName = "ToDoDelete";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, 1);
            // Create To-Do follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select To-Do has just created
            auditorCreateToDoService.selectToDoTaskName(todoName);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkToDoIsExists(false, todoName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete button in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete button in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 39, enabled = true, description = "Verify work flow of cancel button in ToDo page.",dataProvider = "verifyWorkFlowOfCancelButtonInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfCancelButtonInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Create To-Do name list
            String todoName = "ToDoCancel";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, 1);
            // Create To-Do follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select To-Do has just created
            auditorCreateToDoService.selectToDoTaskName(todoName);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickCancelButtonOnPopup();
            // Check To-Do has exists
            auditorCreateToDoService.checkToDoIsExists(true, todoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel button in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel button in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * -----end of tan.pham PLAT-2286-----
     */

    /*
    Vien Pham merged editCategoriesTEst into this page
     */
    @Test(priority = 40, enabled = true, description = "Verify EditCategories GUI ", dataProvider = "verifyDefaultEditCategoryGuiAtCreateNewTodoPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDefaultEditCategoryGuiAtCreateNewTodoPage(String auditorId, String auditorPwd, String categoryName01, String categoryName02, String categoryName03) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategory(categoryName01,categoryName02,categoryName03);
            auditorEditCategoryService.returnToCreateNewTodoPage();
            auditorEditCategoryService.navigateToEditAtCreateTodoPage();
            auditorEditCategoryService.verifyEditCategoriesTitle();
            auditorEditCategoryService.verifyEditCategoriesGuide();
            auditorEditCategoryService.hoverOnCategoryItem();
            auditorEditCategoryService.verifyDefaultSaveButton();
            auditorEditCategoryService.verifyDefaultCancelButton();
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
/*
Vien.Pham refactor PLAT2291
 */

    @Test(priority = 42, enabled = true, description = "Verify Edit Function", dataProvider = "verifyEditFunctionAtCreateNewTodoPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyEditFunctionAtCreateNewTodoPage(String auditorId, String auditorPwd, String engagementName,
                                                      String categoryName, String editCategoryName, String numberCategoryName,
                                                      String nullCategoryName, String specialCategoryName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createCategories(categoryName);
            auditorCreateToDoService.navigateToEditNewCategory();
            getLogger().info("Verifying Edit valid value..");
            auditorEditCategoryService.editValidValue(editCategoryName);
            auditorEditCategoryService.verifyValidValue(editCategoryName);
            getLogger().info("Verifying Edit only number..");
            auditorEditCategoryService.editOnlyNumber(Integer.valueOf(numberCategoryName));
            auditorEditCategoryService.verifyNumber(Integer.valueOf(numberCategoryName));
            getLogger().info("Verifying Edit null chars..");
            auditorEditCategoryService.editNullChars(nullCategoryName);
            auditorEditCategoryService.verifyNullChars(nullCategoryName);
            getLogger().info("Verifying Edit Special chars..");
            auditorEditCategoryService.editSpecialChars(specialCategoryName);
            auditorEditCategoryService.verifySpecialChars(specialCategoryName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Edit Fuction.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Edit Fuction.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /*
    Vien.Pham refactor PLAT2291
     */
    @Test(priority = 44, enabled = true, description = "Verify Remove function", dataProvider = "verifyRemoveFunctionAtTodoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyRemoveFunctionAtTodoListPage(String auditorId, String auditorPwd,
                                                   String engagementName, String categoryName01,
                                                   String categoryName02, String categoryName03) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategory(categoryName01,categoryName02,categoryName03);
            auditorCreateToDoService.navigateToEditNewCategory();
            getLogger().info("Verifying remove 1 item..");
            auditorEditCategoryService.removeItem(1);
            getLogger().info("Verifying remove multi items..");
            auditorEditCategoryService.removeItem(2);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Remove function.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Remove Function.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

/*
End of merged VienPham.
 */
    /**
     * PLAT-2286 : Add new test suite : delete and cancel when user select multi ToDo item - Start
     */
    int ToDoItemNumber = 4;

    @Test(priority = 45, enabled = true, description = "Verify work flow of delete multi ToDo item in ToDo page.", dataProvider = "verifyWorkFlowOfDeleteMultiToDoInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfDeleteMultiToDoInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Create ToDo name list
            String todoName = "ToDoDelete";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, ToDoItemNumber);
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo list has just created
            auditorCreateToDoService.selectMultiToDoTaskByNameList(toDoListNames);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkToDoListIsExists(false, toDoListNames);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete multi ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete multi ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 46, enabled = true, description = "Verify work flow of delete all ToDo item in ToDo page.", dataProvider = "verifyWorkFlowOfDeleteAllToDoInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfDeleteAllToDoInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Create ToDo name list
            String todoName = "ToDoDelete";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, ToDoItemNumber);
            // Create ToDo follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Check on 'CheckAll' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkAllToDoIsDelete();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete all ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete all ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 47, enabled = true, description = "Verify work flow of cancel multi ToDo item in ToDo page.", dataProvider = "verifyWorkFlowOfCancelMultiToDoInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfCancelMultiToDoInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Create To-Do name list
            String todoName = "ToDoCancel";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, ToDoItemNumber);
            // Create ToDo follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo list has just created
            auditorCreateToDoService.selectMultiToDoTaskByNameList(toDoListNames);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnCancelButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkToDoListIsExists(true, toDoListNames);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel multi ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel multi ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 48, enabled = true, description = "Verify work flow of cancel all ToDo item in ToDo page.", dataProvider = "verifyWorkFlowOfCancelAllToDoInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfCancelAllToDoInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            // Create ToDo name list
            String todoName = "ToDoCancel";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, ToDoItemNumber);
            // Create ToDo follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Check on 'CheckAll' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnCancelButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkAllToDoIsDelete();

            Assert.assertFalse(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel all ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel all ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * PLAT-2286 : Add new test suite : delete and cancel when user select multi ToDo item - End
     */

    /**
     * Added by duong.nguyen on 22/05/2017.
     * Scenarios : PLAT 2305 - Backend Mark To-Do as complete
     */
    @Test(priority = 49, enabled = true, description = "PLAT-2305: Verify DB update completed field is true when archive mart as completed.", dataProvider = "verifyCompletedFieldUpdateSuccessful", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCompletedFieldUpdateSuccessful(String auditorId, String auditorPwd, String engagementName, String toDoName, String categoryName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        Random random = new Random();
        String engagementName = "Engagement-PLAT-2350" + random.nextInt(1000);
        String taskName = "Task-2305" + random.nextInt(1000);*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, "", "Company Auvenir");
            //will implement later, current we can not navigate engagment by name
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.createToDoTaskWithCategoryName(toDoName,categoryName);
            //Check status of completed field before mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, toDoName, "false");
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            //Check status of completed field after archive mark as completed. Expected: true
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, toDoName, "true");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify DB update field completed is true when archive mart as completed.",
                    LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify DB update field completed is true when archive mart as completed.",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 50, enabled = true, description = "PLAT-2305: Verify DB not update field completed is true when cancel mart as completed.", dataProvider = "verifyCancelCompleteAction", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCancelCompleteAction(String auditorId, String auditorPwd, String engagementName, String toDoName, String categoryName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        Random random = new Random();
        String engagementName = "Engagement-PLAT-2350" + random.nextInt(1000);
        String taskName = "Task-2305" + random.nextInt(1000);*/
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, "", "Company Auvenir");
            //will implement later, current we can not navigate engagment by name
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.createToDoTaskWithCategoryName(toDoName,categoryName);
            //Check status of completed field before mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, toDoName, "false");
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCancelCompleteMarkPopup();
            auditorTodoListService.verifyTodoListPage();
            //Check status of completed field after cancel mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, toDoName, "false");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify DB not update field completed is true when cancel mart as completed.",
                    LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify DB not update field completed is true when cancel mart as completed.",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**-----end of duong.nguyen PLAT-2305-----*/

    /**
     * Added by minh.nguyen on 24/05/2017.
     */
    /*
    @Test(priority = 51, enabled = true, description = "Verify to create new request on ToDo page")
    public void verifyAddNewRequestOnToDoPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
//        auditorId = GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID");
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User3", "Auditor");
//        auditorId = auditorId.replace("chr.", "");
//        System.out.println("auditorId = " + auditorId);
        try {
            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorCreateToDoService.createToDoPage();
            auditorCreateToDoService.verifyAddNewRequestButton();
            auditorCreateToDoService.verifyRequestNameTextbox();
            auditorCreateToDoService.verifyCreateRequest("new Request 01");
//            auditorCreateToDoService.verifyUpdateRequest("new Request 02");
            auditorCreateToDoService.verifyDeleteRequest();
            auditorCreateToDoService.verifyCopyRequest();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify new Category popup", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify new Category popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }*/

    @Test(priority = 51, enabled = true, description = "Verify notification email when Auditor invite a lead client")
    public void verifyNotificationAuditorInviteClient(String auditorId, String auditorPassword, String engagementName,
                                                      String clientId, String clientEmailPassword, String clientFullName) throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());


        /*auditorId = GenericService.getTestDataFromExcel("NotificationEmailTest", "Auditor", "Valid Value");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Auditor Password", "Valid Value");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Engagement Name", "Valid Value");
        String clientId = GenericService.getTestDataFromExcel("NotificationEmailTest", "New Client", "Valid Value");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client Email Password", "Valid Value");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client Full Name", "Valid Value");*/
//
//        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();

        //need precondition for save engagement name, and delete this engagement or client on acl

        try {

            MongoDBService.removeEngagementByInvitedClientEmail(MongoDBService.getCollection("engagements"), clientId);
            MongoDBService.removeBusinessByInvitedClientEmail(MongoDBService.getCollection("businesses"), clientId);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);

            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient(clientFullName, clientId, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }
}




