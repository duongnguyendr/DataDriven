package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */



public class AuditorTodoListTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AuditorCreateToDoService auditorCreateToDoService;


    @Test(priority=1,enabled= true, description="Verify Auditor empty Todo List page.")
    public void verifyAuditorEmptyTodoListPage() throws Exception
    {
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId= GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try
        {

            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement01","","");
            //will implement later, current we can not navigate engagment by name
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();
            //auditorTodoListService.verifyEmptyTodoList();
            //auditorTodoListService.verifyTodoListPageColumnHeader();
            // verifyFooter error due to change of footer locator from build to build
            //auditorEngagementService.verifyAuditorFooter();
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.PASSED,null);
        }

        catch (Exception e)
        {
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 2,enabled = false, description = "Verify to create To-Do page and search data.")
    public void verifyCreateToDoPageCategorySearchData() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorCreateToDoService.createToDoPage();
            auditorCreateToDoService.verifyDataSearch();
            auditorCreateToDoService.verifyCheckMaxLength();
            auditorCreateToDoService.verifyContentTextSearch();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 3,enabled = false, description = "Verify to create new Category")
    public void verifyCreateNewCategory() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorCreateToDoService.verifyCreateNewCategory();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify to create new Category", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify to create new Category", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 4,enabled = true, description = "verify displayed of this button filter")
    public void verifyButtonFilter() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorCreateToDoService.verifyButtonFilter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify displayed of this button filter", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify displayed of this button filter", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 5,enabled = true, description = "verify default value(Search...) of this Search")
    public void verifySearchPlaceholder() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorCreateToDoService.verifySearchPlaceholder();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    @Test(  priority = 6,enabled = true, description = "verify when hover on Search change bounary color to green.")
    public void verifySearchHover() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
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

    @Test(  priority = 7,enabled = true, description = "verify input text.")
    public void verifySearchInputText() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorCreateToDoService.verifySearchInputText();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify input text.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify input text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 8,enabled = true, description = "verify input number to field search.")
    public void verifySearchInputNumber() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorCreateToDoService.verifySearchInputNumber();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify input number to field search.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify input number to field search.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    @Test(  priority = 9,enabled = false, description = "[PLAT 2282]-03: Verify GUI To Do Save Icon")
    public void verifyGUIToDoSaveIcon() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
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

    @Test(  priority = 15,enabled = false, description = "Verify to create new Category")
    public void verifyCreateNewCategory() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorCreateToDoService.verifyCreateNewCategory();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify to create new Category", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify to create new Category", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    @Test(  priority = 10,enabled = false, description = "[PLAT 2282]-03: Verify GUI To Do Close Icon")
    public void verifyGUIToDoCloseIcon() throws Exception {
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {

            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifyToDoCloseIcon();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI Close Icon - create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI Close Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
    @Test(  priority = 11,enabled = true, description = "[PLAT 2282]-03: Verify Data Grid after adding new To Do Task")
    public void verifyDataGridToDoTaskPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifyAddNewDataGridIcon("ZAToDo PLAT 2282");
            ArrayList<String> toDoListNames = new ArrayList<String>();
            toDoListNames.add("416 To Do Task02");
            toDoListNames.add("a To Do Task02");
            toDoListNames.add("z To Do Task02");
            toDoListNames.add("b To Do Task02");
            toDoListNames.add("c To Do Task02");
            auditorCreateToDoService.createListToDoTask(toDoListNames);
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

    @Test(  priority = 12,enabled = false, description = "[PLAT 2289]: Verify 'Category' combo box on Create to-do")
    public void verifyCategoryComboxBoxOnCreateToDo() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.createToDoTaskWithCategoryName("Task01 2289", "Category1");
            auditorCreateToDoService.clickCreateToDoTask();
            auditorCreateToDoService.verifyDefaultValueofCategoryComboBox("Select Category");
            auditorCreateToDoService.verifyHoverCategoryComboBox();
            auditorCreateToDoService.verifyValueofCategoryComboBox("Category1");
            auditorCreateToDoService.verifyNewCategoryPopUpDisplayed();
            auditorCreateToDoService.verifyEditCategoryPopUpDisplayed();
            auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task01 2289 without Category");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify 'Category' combo box on Create to-do", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify 'Category' combo box on Create to-do", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(  priority = 13,enabled = true, description = "[PLAT 2282]-Verify To Do Name TextBox when Add new To Do")
    public void verifyGUIToDoTextBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.clickCreateToDoTask();
            auditorCreateToDoService.verifyGUIAddNewToDoNameTextBox();
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

}




