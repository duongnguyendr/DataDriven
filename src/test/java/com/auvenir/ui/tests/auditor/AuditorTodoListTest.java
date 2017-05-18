package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.By;
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

    String auditorId;
    String timeStamp;
    String firstEngagementTitleOnWeb;

    @Test(priority = 1, enabled = false, description = "Verify Auditor empty Todo List page.")
    public void verifyAuditorEmptyTodoListPage() throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {

            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement01", "", "");
            //will implement later, current we can not navigate engagment by name
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyEmptyTodoList();
            auditorTodoListService.verifyTodoListPageColumnHeader();
            // verifyFooter error due to change of footer locator from build to build
            auditorEngagementService.verifyAuditorFooter();
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 2, enabled = false, description = "Verify to create To-Do page and search data.")
    public void verifyCreateToDoPageCategorySearchData() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
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

    @Test(priority = 3, enabled = false, description = "Verify to create new Category")
    public void verifyCreateNewCategory() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorCreateToDoService.createToDoPage();
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

    @Test(priority = 4, enabled = true, description = "Verify new Category popup")
    public void verifyNewCategoryPopup() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorCreateToDoService.createToDoPage();
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

    @Test(priority = 5, enabled = false, description = "verify displayed of this button filter")
    public void verifyButtonFilter() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            //auditorDetailsEngagementService.navigateToTodoListPage();
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

    @Test(priority = 6, enabled = false, description = "verify default value(Search...) of this Search")
    public void verifySearchPlaceholder() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
            auditorCreateToDoService.verifySearchPlaceholder();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    @Test(priority = 7, enabled = false, description = "verify when hover on Search change bounary color to green.")
    public void verifySearchHover() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
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

    @Test(priority = 8, enabled = false, description = "verify input text.")
    public void verifySearchInputText() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
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

    @Test(priority = 9, enabled = false, description = "verify input number to field search.")
    public void verifySearchInputNumber() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
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


    @Test(priority = 10, enabled = false, description = "[PLAT 2282]-03: Verify GUI To Do Save Icon")
    public void verifyGUIToDoSaveIcon() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
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


    @Test(priority = 11, enabled = false, description = "[PLAT 2282]-03: Verify GUI To Do Close Icon")

    public void verifyGUIToDoCloseIcon() throws Exception {
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {

            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
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

    @Test(priority = 12, enabled = false, description = "[PLAT 2282]-03: Verify Data Grid after adding new To Do Task")
    public void verifyDataGridToDoTaskPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifyAddNewToDoTask("ZAToDo PLAT 2282");
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

    @Test(priority = 13, enabled = false, description = "[PLAT 2289]: Verify 'Category' combo box on Create to-do")
    public void verifyCategoryComboxBoxOnCreateToDo() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            //auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.createToDoTaskWithCategoryName("Task01 2289", "Category1");
            auditorCreateToDoService.clickCreateToDoTask();
            auditorCreateToDoService.verifyDefaultValueofCategoryComboBox("Select Category");
            auditorCreateToDoService.verifyHoverCategoryComboBox();
            auditorCreateToDoService.verifyValueofCategoryComboBox("Category1");
            auditorCreateToDoService.verifyNewCategoryPopUpDisplayed();
            auditorCreateToDoService.clickCloseButtonOnPopup();
            auditorCreateToDoService.verifyEditCategoryPopUpDisplayed();
            auditorCreateToDoService.clickCloseButtonOnPopup();
            auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task01 2289 without Category");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify 'Category' combo box on Create to-do", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify 'Category' combo box on Create to-do", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /*
    TestCase to cover ticket: PLAT 2283
     */
    @Test(priority = 14, enabled = false, description = "[PLAT 2283]: Verify Filter button next to create to-do button.")
    public void verifyFilterButton() throws Exception {

        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyFilterDropDownList();
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Filter button next to create to-do button", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 15, enabled = false, description = "[PLAT 2283]: Verify default value on Filter dropdown.")
    public void verifyDefaultValueFilterButton() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
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

    @Test(priority = 16, enabled = false, description = "[PLAT 2283]: Verify border on Filter dropdown.")
    public void verifyBorderOnFilterButton() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
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

    @Test(priority = 17, enabled = false, description = "[PLAT 2283]: Verify default value on Filter dropdown.")
    public void verifyChooseAnOptionFilterButton() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
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

    @Test(priority = 18, enabled = false, description = "[PLAT 2283]: verify Unable Add More Option Filter DropDownList")
    public void verifyUnableAddMoreOptionFilter() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
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

    @Test(priority = 19, enabled = false, description = "[PLAT 2283]: verify select An VaLue On Assign Option Filter")
    public void selectAnVaLueOnAssignOptionFilter() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
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

    @Test(priority = 20, enabled = false, description = "[PLAT 2283]: verify click And Do Not Select Option Filter")
    public void clickAndDoNotSelectOptionFilter() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
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

    @Test(priority = 21, enabled = false, description = "[PLAT 2282]-Verify To Do Name TextBox when Add new To Do")
    public void verifyGUIToDoTextBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
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

    @Test(priority = 22, enabled = false, description = "[PLAT 2284]-Verify GUI Add Bulk Actions on To Do Page")
    public void verifyGUIToDoAddBulkActions() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifyAddNewToDoTask("Task 01 2284");
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

    @Test(priority = 23, enabled = false, description = "Verify GUI of select date drop down in add new to-do page.")
    public void verifyGUISelectDateDropDownInNewToDoPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
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

    @Test(priority = 24, enabled = false, description = "Verify due date drop down in add new to-do page.")
    /**
     * Fail :
     * 1. default value due date date picker is not match with engagement due date :
     auditorCreateToDoService.checkDefaultValueDueDate()
     *  2. default format of engagement due date is not correct (dd/mm/yyyy) --> expected is mm/dd/yyyy :
     auditorCreateToDoService.checkFormatDueDate()
     * Note
     * Current date picker has not ">" and "<" link, so will check "prev" and "next" replaced
     *                          auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
     *                          auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
     */
    public void verifyDueDateDropDownInNewToDoPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            boolean isNewToDoPage = true; // true : verify in add new to-do page, false : verify in add to-do list page
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            // Move to add new To-do page
            auditorCreateToDoService.navigateAddNewToDoPage();
            //Check default value of due date
            //auditorCreateToDoService.checkDefaultValueDueDate();
            //Check format of due date
            //auditorCreateToDoService.checkFormatDueDate();
            //Check hove item in data picker
            auditorCreateToDoService.hoverItemInDatePikcer(isNewToDoPage);
            // Verify data of data picker
            auditorCreateToDoService.verifyDataOfDatePicker(isNewToDoPage);
            //Choose date item in date picker
            auditorCreateToDoService.chooseDateItemInDatePicker(isNewToDoPage);
            //Click on previous date picker link
            auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
            //Click on next date picker link
            auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
            // Verify input correct format date value
            auditorCreateToDoService.verifyInputCorrectFormatDate(isNewToDoPage);
            // Verify input wrong format date value
            auditorCreateToDoService.verifyInputWrongFormatDate(isNewToDoPage);
            // Verify input text in due date text box
            auditorCreateToDoService.verifyInputTextValue(isNewToDoPage);
            // Verify input text in due date text box
            auditorCreateToDoService.verifyInputSpecialCharacterValue(isNewToDoPage);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify due date date picker on add new to-do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify due date date picker on add new to-do page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 25, enabled = false, description = "Verify due date drop down in to-do list page.")
    /**
     * Fail :
     * 1. Current code does not against when user input text and special character :
     *                        auditorCreateToDoService.verifyInputSpecialCharacterValue(isNewToDoPage);
     *                        auditorCreateToDoService.verifyInputTextValue(isNewToDoPage)
     *
     * Note
     * Current date picker has not ">" and "<" link, so will check "prev" and "next" replaced
     *                          auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
     *                          auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
     */
    public void verifyDueDateDropDownInToDoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            boolean isNewToDoPage = false;// true : verify in add new to-do page, false : verify in add to-do list page
            // Login
            auditorCreateToDoService.loginWithUserRole(userId);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.viewEngagementDetailsPage("Engagement 01");
            //Check hove item in data picker
            auditorCreateToDoService.hoverItemInDatePikcer(isNewToDoPage);
            //Click on previous date picker link
            auditorCreateToDoService.verifyPreviousDatePickerLink(isNewToDoPage);
            //Click on next date picker link
            auditorCreateToDoService.verifyNextDatePickerLink(isNewToDoPage);
            //Choose date item in date picker
            auditorCreateToDoService.chooseDateItemInDatePicker(isNewToDoPage);
            // Verify input correct format date value
            auditorCreateToDoService.verifyInputCorrectFormatDate(isNewToDoPage);
            // Verify input wrong format date value
            auditorCreateToDoService.verifyInputWrongFormatDate(isNewToDoPage);
            // Verify input text in due date text box
            //auditorCreateToDoService.verifyInputTextValue(isNewToDoPage);
            //getLogger().info(AbstractService.sStatusCnt);
            // Verify input text in due date text box
            //auditorCreateToDoService.verifyInputSpecialCharacterValue(isNewToDoPage);
            //getLogger().info(AbstractService.sStatusCnt);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
        } catch (Exception e) {
            NXGReports.addStep("Verify due date date picker on to-do list page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 26, enabled = false, description = "[PLAT 2284]-Verify Action of Add Bulk Actions on To Do Page")
    public void verifyActionToDoAddBulkActions() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorTodoListService.verifyTodoListPage();

            ArrayList<String> toDoListNames = new ArrayList<String>();
            toDoListNames.add("416 To Do Task02");
            toDoListNames.add("a To Do Task02");
            toDoListNames.add("b To Do Task02");
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            auditorCreateToDoService.selectToDoTaskName("b To Do Task02");
            auditorCreateToDoService.selectToDoTaskName("416 To Do Task02");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Action of Add Bulk Actions on To do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Action of Add Bulk Actions on To do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Added by huy.huynh on 18/05/2017.
     * Scenarios : PLAT 2285 - Add undo option
     */

    /**
     * (precondition)init value for variables
     * dependsOnMethods: setUp on AbstractTest
     */
    //@BeforeMethod(dependsOnMethods = {"setUp"})
    public void initVariable() {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());

        auditorId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
    }

    /**
     * (precondition)flow to Needed-To-Test page
     * dependsOnMethods: initVariable
     */
    //@BeforeMethod(dependsOnMethods = {"initVariable"})
    public void navigationPreconditions() {
        auditorEngagementService.loginWithUserRole(auditorId);
        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.clickNewEnagementButton();
        auditorNewEngagementService.verifyNewEngagementPage();

        auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);
        auditorEngagementService.verifyAuditorEngagementPage();

        //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
        firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();

        auditorEngagementService.viewEngagementDetailsPage("ViewEngagementButton");
        auditorDetailsEngagementService.navigateToTodoListPage();
    }

    /**
     * (case)verify button Undo action exist
     */
    @Test(priority = 150, enabled = true, testName = "Verify GUI.", description = "undo_1", groups = "ui"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void uiVerifyButtonUndoExist() throws Exception {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.uiVerifyButtonUndoExist();

        NXGReports.addStep("Verify button Undo exist", LogAs.PASSED, null);
    }

    /**
     * (case)verify button Undo action disable
     */
    @Test(priority = 200, enabled = true, testName = "Undo arrow.", description = "undo_3", groups = "ui"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void uiVerifyButtonUndoStatus() throws Exception {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.uiVerifyButtonUndoDisable();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Mark as complete");
        auditorTodoListService.uiVerifyButtonUndoEnable();

        NXGReports.addStep("Verify button Undo status", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Complete a To-Do, verified change on database but UI
     */
    @Test(priority = 250, enabled = true, testName = "Undo successfully", description = "undo_4", groups = "workflow")
    public void verifyUndoActionWithCompleteCase() {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorTodoListService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Mark as complete");
        auditorTodoListService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, "toDoName01" + timeStamp, "true");

        auditorTodoListService.undoAction();
        auditorTodoListService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, "toDoName01" + timeStamp, "false");

        NXGReports.addStep("Verify Undo action with Complete case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Assign to a To-Do, verified change on UI but database
     */
    @Test(priority = 300, enabled = true, testName = "Undo successfully", description = "undo_5", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyUndoActionWithAssignToCase() throws Exception {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorTodoListService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Assign to");
        auditorTodoListService.verifyAssigneeNameOnUI("toDoName01" + timeStamp, "client 01 so");
        Thread.sleep(2000);
        auditorTodoListService.undoAction();
        auditorTodoListService.verifyAssigneeNameOnUI("toDoName01" + timeStamp, "Unassigned");

        NXGReports.addStep("Verify Undo action with Assign to case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Delete a To-Do, verified change on database but UI
     */
    @Test(priority = 350, enabled = true, testName = "Undo successfully", description = "undo_6", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyUndoActionWithDeleteCase() {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorTodoListService.chooseAndActAToDoWithName("toDoName02" + timeStamp, "Delete");
        auditorTodoListService.verifyToDoDeleteStatusByName(firstEngagementTitleOnWeb, "toDoName02" + timeStamp, "INACTIVE");

        auditorTodoListService.undoAction();
        auditorTodoListService.verifyToDoDeleteStatusByName(firstEngagementTitleOnWeb, "toDoName02" + timeStamp, "ACTIVE");

        NXGReports.addStep("Verify Undo action with Delete case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Download Attachments disable
     */
    @Test(priority = 400, enabled = true, testName = "Undo fail", description = "undo_8", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyDownloadAttachmentsDisable() {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.verifyDownloadAttachmentsDisable("toDoName01" + timeStamp);

        NXGReports.addStep("Verify Download Attachments disable", LogAs.PASSED, null);
    }
}




