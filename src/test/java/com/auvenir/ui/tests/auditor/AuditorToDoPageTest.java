package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.dataprovider.auditor.AuditorTodoPageDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AuvenirService;
import com.auvenir.ui.services.ClientDetailsEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientSignUpService;
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
    private AuditorTodoListService auditorTodoListService;
    private ClientService clientService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;
    private AuvenirService auvenirService;
    private ClientSignUpService clientSignUpService;
    private ClientDetailsEngagementService clientDetailsEngagementService;
    private AuditorToDoService auditorToDoService;

    @Test(priority = 1, enabled = true, description = "Verify Todos Textbox")
    public void verifyTodosTextBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  01");
        String number = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Number Value", "Todo Name  01");
        String specialChars = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Special Chars", "Todo Name  01");
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
            auditorCreateToDoService.inputNullChar("");
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
        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
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
            //            auditorCreateToDoService.createNewToDoTask(validTodo);
            auditorCreateToDoService.verifyCategoryComboBox_DefaultValue();
            auditorCreateToDoService.createCategories(categoryName1);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName1);
            auditorCreateToDoService.createCategories(categoryName2);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName2);
            auditorCreateToDoService.selectCategoryByName(categoryName1);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName1);
            //            auditorCreateToDoService.verifyCheckMaxLength_CategoryName();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Category Combo box.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Category Combo box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify that Auditor can invite a client")
    public void verifyAuditorInvitingTheClient() throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Email Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
        String adminId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Admin");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Admin Auvenir Password");
        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");

        //        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        //   MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
        // MongoDBService.removeEngagementObjectByName(MongoDBService.getCollection("engagements"), engagementName);
        //need precondition for save engagement name, and delete this engagement or client on acl
        try {
            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(clientFullName, clientId, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");
            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed"/*, dependsOnMethods = {"verifyChangeTheStatusClientToOnBoarding"}*/)
    public void verifyClientLogsInAndActive() throws Exception {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Email Password");
        String clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        //        MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), clientId, "status", "ONBOARDING");

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();
            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm("0123456789");//10 number required
            clientSignUpService.fillUpBusinessForm("Titancorpvn");
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientAuvenirPassword);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify Client Assignee Combo box")
    public void verifyClientAssigneeComboBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());

        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
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
            auditorCreateToDoService.selectClientAssignee(clientFullName);
            auditorCreateToDoService.verifyClientAssigneeIsSelectedCorrectly(clientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify Due date Time box")
    public void verifyDuedateTimebox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
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
            auditorCreateToDoService.verifyDuedateTimebox_DefaultValue(deadlineDate);
            //            auditorCreateToDoService.checkFormatDueDate();
            //            auditorCreateToDoService.verifyUnableToInputDuedate("12/4/2017");
            auditorCreateToDoService.chooseDateItemInDatePicker("07", "16", "2017");
            auditorCreateToDoService.verifyDateSelectedCorrectly("07/16/2017");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Due date Time box.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Due date Time box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 7, enabled = true, description = "Verify Audit Assignee box")
    public void verifyAuditAssigneeBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());

        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String auditAssigneeDefault = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "First and Last Name", "Valid Value");
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifyAuditAssigneeBox(auditAssigneeDefault);
            //            auditorCreateToDoService.verifyAuditAssigneeIsSelectedCorrectly();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 8, enabled = true, description = "Verify CreateNewTodo, Filter, BulkAction buttons")
    public void verifyTodoPage_Buttons() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());

        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
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
            auditorCreateToDoService.verifyCreateTodoBtn();
            auditorCreateToDoService.verifyFilterBtn();
            auditorCreateToDoService.verifyBulkActionBtn();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Buttons of Todo Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Buttons of Todo Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 9, enabled = true, description = "Verify SearchBox")
    public void verifySearchBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());

        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String searchText = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Search Input");
        String searchNumber = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Number Value", "Search Input");
        String searchSpecialCharacter = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Special Chars", "Search Input");

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifySearchBox_DefaultGUI();
            auditorCreateToDoService.inputSearchText(searchText);
            auditorCreateToDoService.verifySearchWhileInput();
            auditorCreateToDoService.inputSearchNumber(searchNumber);
            auditorCreateToDoService.verifySearchWhileInput();
            auditorCreateToDoService.inputSearchCharacter(searchSpecialCharacter);
            auditorCreateToDoService.verifySearchWhileInput();
            auditorCreateToDoService.verifyCheckMaxLength();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify SearchBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 10, enabled = true, description = "Verify realtime Search")
    public void verifyRealTimeSearch() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  02");
        String categoryName3 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 03");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
        String auditAssigneeDefault = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "First and Last Name", "Valid Value");

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.inputValidValue_TodoName(validTodo);
            auditorCreateToDoService.createCategories(categoryName3);
            auditorCreateToDoService.selectClientAssignee(clientFullName);
            auditorCreateToDoService.chooseDateItemInDatePicker("07", "18", "2017");
            auditorCreateToDoService.inputSearchText(validTodo);
            auditorCreateToDoService.verifySearchResult(validTodo);
            auditorCreateToDoService.inputSearchText(categoryName3);
            auditorCreateToDoService.verifySearchResult(categoryName3);
            auditorCreateToDoService.inputSearchText(clientFullName);
            auditorCreateToDoService.verifySearchResult(clientFullName);
            auditorCreateToDoService.inputSearchText(auditAssigneeDefault);
            auditorCreateToDoService.verifySearchResult(auditAssigneeDefault);
            auditorCreateToDoService.inputSearchText("you can input anything");
            auditorCreateToDoService.verifySearchResutlNotMatch();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify SearchBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 11, enabled = true, description = "Verify Data Grid")
    public void verifyDataGrid() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
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
            auditorCreateToDoService.verifyColumnsInGrid();
            auditorCreateToDoService.verifySortIconOnTitle();
            auditorCreateToDoService.verifySortDataGridIcon();
            auditorCreateToDoService.verifyCheckAllCheckBox();
            auditorCreateToDoService.verifyUncheckAllCheckbox();
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

    @Test(priority = 12, enabled = true, description = "Verify UI on Todo Detail Popup.", testName = "dp_1")
    public void verifyDueDateOnToDoDetailsUI() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerShow();

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

    @Test(priority = 13, enabled = true, description = "Verify Default Value on Todo Detail Popup.", testName = "dp_3")
    public void verifyDueDateOnToDoDetailsDefaultValue() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
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
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify Default Value on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify Default Value on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify Default Value on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 14, enabled = true, description = "Verify Date Format on Todo Detail Popup.", testName = "dp_4")
    public void verifyDueDateOnToDoDetailsDateFormat() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerDateFormat();
            //auditorToDoService.verifyDatePickerShow();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify Date Format on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify Date Format on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify Date Format on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 15, enabled = true, description = "Verify date picker when mouse hover on a date.", testName = "dp_5")
    public void verifyDueDateOnToDoDetailsHoverOnField() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerShow();

            auditorToDoService.verifyHoverOnField();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker when mouse hover on a date.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify date picker when mouse hover on a date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify date picker when mouse hover on a date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify date picker focusing to the current due date.", testName = "dp_6")
    public void verifyDueDateOnToDoDetailsFocusingCurrentDueDate() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerShow();

            auditorToDoService.verifyDueDateFocusing();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker focusing to the current due date.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify date picker focusing to the current due date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify date picker focusing to the current due date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify date picker Disable Date after Engagement Due Date on Todo Detail Popup.",
            testName = "dp_7")
    public void verifyDatePickerOnToDoDetailsDisableDateAfterDueDate() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        String engagementDueDate;
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            engagementDueDate = auditorToDoService.getEngagementDueDate();
            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerShow();

            auditorToDoService.verifyDisableDateAfterDueDate(engagementDueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker Disable Date after Engagement Due Date on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify date picker Disable Date after Engagement Due Date on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify date picker Disable Date after Engagement Due Date on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify dueDate on Todo Detail Popup when choose another date.", testName = "dp_8")
    public void verifyDueDateOnToDoDetailsChooseAnotherDate() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        int date;
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.openDatePickerOnTodoDetail();
            date = auditorToDoService.getValidDateHasIndex(0);
            auditorToDoService.changeDueDateOnTodoDetail(0);
            auditorToDoService.verifyChoosingAnotherDate(date);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup when choose another date.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup when choose another date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup when choose another date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 19, enabled = true, description = "Verify date picker previous month icon.", testName = "dp_9")
    public void verifyDueDateOnToDoDetailsDatePickerPreviousMonthIcon() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        String monthYear = "";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.resetEngagementDueDateToNextMonth(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.openDatePickerOnTodoDetail();

            auditorToDoService.goToNextMonth();
            monthYear = auditorToDoService.getMonthYearTitle();
            auditorToDoService.goToPreviousMonth();
            auditorToDoService.verifyPreviousMonthIcon(monthYear);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker previous month icon.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify date picker previous month icon.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify date picker previous month icon.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 20, enabled = true, description = "Verify date picker next month icon.", testName = "dp_10")
    public void verifyDueDateOnToDoDetailsDatePickerNextMonthIcon() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        String monthYear = "";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.resetEngagementDueDateToNextMonth(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.openDatePickerOnTodoDetail();

            monthYear = auditorToDoService.getMonthYearTitle();
            auditorToDoService.goToNextMonth();
            auditorToDoService.verifyNextMonthIcon(monthYear);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker next month icon.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports
                    .addStep("Error: Verify date picker next month icon.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports
                    .addStep("Error: Verify date picker next month icon.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 21, enabled = true, description = "Verify dueDate on Todo Detail Popup can't input Date Time.", testName = "dp_11")
    public void verifyDueDateOnToDoDetailsInputDateTime() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);


            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.inputToDueDate("07/04/2017");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup can't input Date Time.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Date Time.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Date Time.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 22, enabled = true, description = "Verify dueDate on Todo Detail Popup can't input Text.", testName = "dp_12")
    public void verifyDueDateOnToDoDetailsInputText() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.inputToDueDate("abc xyz");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup can't input Text.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 23, enabled = true, description = "Verify dueDate on Todo Detail Popup can't input Special Character.", testName = "dp_13")
    public void verifyDueDateOnToDoDetailsInputSpecialCharacter() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());

        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.inputToDueDate("~!@#$%^&*+?><,.");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup can't input Special Character.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Special Character.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Special Character.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 24, enabled = true, description = "Verify change dueDate on Todo Detail Popup.", testName = "dp_14")
    public void verifyDueDateOnToDoDetailsChangeDueDateOnTodoDetail() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
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
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.openDatePickerOnTodoDetail();
            auditorToDoService.changeDueDateOnTodoDetail(0);
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify change dueDate on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify change dueDate on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify change dueDate on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 25, enabled = true, description = "Verify change dueDate on Todo Row.", testName = "dp_15")
    public void verifyDueDateOnToDoDetailsChangeDueDateOnTodoRow() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
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
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.changeDueDateOnTodoRow(todoName, 1);
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify change dueDate on Todo Row.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify change dueDate on Todo Row.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify change dueDate on Todo Row.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 99, enabled = true, description = "Verify dueDate on Todo Detail Popup is match with on Todo Row.", testName = "dp_")
    public void verifyDueDateOnToDoDetailsMatchWithOnToDoRow() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
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
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            auditorToDoService.openDatePickerOnTodoDetail();
            auditorToDoService.changeDueDateOnTodoDetail(0);
            auditorToDoService.closePopupTodoDetail();
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            auditorToDoService.closePopupTodoDetail();
            auditorToDoService.changeDueDateOnTodoRow(todoName, 0);
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    /*-----------end of huy.huynh on 28/06/2017.*/
    @Test(priority = 26, enabled = true, description = "Verify upload request files", dataProvider = "verifyUploadRequestFiles",
            dataProviderClass = AuditorTodoPageDataProvider.class)
    public void verifyUploadNewRequestFile(String auditorId, String auditorPwd, String engagementName, String pathOfUploadLocation,
            String toDoName,String txtFile,String docxFile,String xlsxFile,String pdfFile,String pngFile,String jpgFile) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            //upload txt file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, txtFile, 1);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(txtFile);
            //upload docx file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, docxFile, 2);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(docxFile);
            //upload xlsx file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, xlsxFile, 3);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(xlsxFile);
            //upload pdf file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, pdfFile, 4);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(pdfFile);
            //upload png file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, pngFile, 5);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(pngFile);
            //upload jpg file
            auditorCreateToDoService.verifyClickAddRequestBtn();
            auditorCreateToDoService.uploadNewFileByPosition(pathOfUploadLocation, jpgFile, 6);
            auditorCreateToDoService.verifyColorAddRequestBtn();
            auditorCreateToDoService.verifyUploadFileSuccessfully(jpgFile);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify auditor add new request", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify auditor add new request", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

}


