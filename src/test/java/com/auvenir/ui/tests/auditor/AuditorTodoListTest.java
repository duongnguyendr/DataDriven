package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.List;

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

    String auditorId;
    String timeStamp;
    String firstEngagementTitleOnWeb;

    @Test(priority = 1, enabled = true, description = "Verify Auditor empty Todo List page.")
    public void verifyAuditorEmptyTodoListPage() throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {

            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createAndSelectNewEnagement("engagement01","","Company Auvenir");
            // Need to change the flow of the code, it always creates new one to verify the empty to do list.
//            auditorEngagementService.clickNewEnagementButton();
//            auditorNewEngagementService.verifyNewEngagementPage();
//            auditorNewEngagementService.enterDataForNewEngagementPage("engagement01", "", "Company Auvenir");
            //will implement later, current we can not navigate engagment by name
//            auditorEngagementService.verifyAuditorEngagementPage();
//            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");

            //auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyEmptyTodoList();
            auditorTodoListService.verifyTodoListPageColumnHeader();
            // verifyFooter error due to change of footer locator from build to build
            //auditorEngagementService.verifyAuditorFooter();
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify to create To-Do page and search data.")
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

    @Test(priority = 3, enabled = true, description = "Verify to create new Category")
    public void verifyCreateNewCategory() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement" + GeneralUtilities.getTimeStampForNameSuffix());
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

    @Test(priority = 12, enabled = true, description = "[PLAT 2282]-03: Verify Data Grid after adding new To Do Task")
    public void verifyDataGridToDoTaskPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("vienpham007");

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

    @Test(priority = 13, enabled = true, description = "[PLAT 2289]: Verify 'Category' combo box on Create to-do")
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
            auditorCreateToDoService.clickCancelButtonOnPopup();
            auditorCreateToDoService.verifyEditCategoryPopUpDisplayed();
            auditorCreateToDoService.clickCancelButtonOnPopup();
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

    @Test(priority = 21, enabled = true, description = "[PLAT 2282]-Verify To Do Name TextBox when Add new To Do")
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

    @Test(priority = 22, enabled = true, description = "[PLAT 2284]-Verify GUI Add Bulk Actions on To Do Page")
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

    /**
     * Scenarios : [PLAT 2299] - Verify To-do Details Commenting
     */
    @Test(priority = 26, enabled = false, description = "Verify To-do Details Commenting")
    public void verifyToDoDetailsCommenting() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement2299");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement2299");
            // Will edit when the code is updated with the new xpath and business.
//            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.navigateToDoListPage();

            // Will uncomment when the code is updated with the new xpath and business.
//            auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task2299");
//            auditorCreateToDoService.closeSuccessToastMes();
            auditorCreateToDoService.selectToDoTaskName("Task2299");
            auditorCreateToDoService.clickCommentIconPerTaskName("Task2299");
            auditorCreateToDoService.verifyInputAComment("comment Task22991");
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickPostComment();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, "comment Task22991");
            auditorCreateToDoService.verifyBoxTitleComment();
            auditorCreateToDoService.verifyClickOnInputCommentField();
            auditorCreateToDoService.verifyGUIPostButton();
            auditorCreateToDoService.verifyDefaultHintValueInputComment();
            auditorCreateToDoService.verifyGUICommentList("comment Task22991");
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
    @Test(priority = 27, enabled = true, description = "Verify mark as complete")
    public void verifyMarkAsComplete() throws Exception {
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
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.createToDoPage();
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyClickCloseMarkPopup();

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
    @Test(priority = 28, enabled = true, testName = "Verify GUI.", description = "verify Undo Button exist ", groups = "ui"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void uiVerifyButtonUndoExist() throws Exception {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.uiVerifyButtonUndoExist();

        NXGReports.addStep("Verify button Undo exist", LogAs.PASSED, null);
    }

    /**
     * (case)verify button Undo action disable
     */
    @Test(priority = 29, enabled = true, testName = "Undo arrow.", description = "verify button Undo action disable", groups = "ui"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void uiVerifyButtonUndoStatus() throws Exception {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.uiVerifyButtonUndoDisable();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Mark as complete", "");
        auditorTodoListService.uiVerifyButtonUndoEnable();

        NXGReports.addStep("Verify button Undo status", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Complete a To-Do, verified change on database but UI
     */
    @Test(priority = 30, enabled = true, testName = "Undo successfully", description = "verify Undo action Complete a To-Do, verified change on database but UI", groups = "workflow")
    public void verifyUndoActionWithCompleteCase() {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorTodoListService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Mark as complete", "");
        auditorTodoListService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, "toDoName01" + timeStamp, "true");

        auditorTodoListService.undoAction();
        auditorTodoListService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, "toDoName01" + timeStamp, "false");

        NXGReports.addStep("Verify Undo action with Complete case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Assign to a To-Do, verified change on UI but database
     */
    @Test(priority = 31, enabled = true, testName = "Undo successfully", description = "verify Undo action Assign to a To-Do, verified change on UI but database", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyUndoActionWithAssignToCase() throws Exception {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorTodoListService.chooseAndActAToDoWithName("toDoName01" + timeStamp, "Assign to", "huy assignee (auditor)");
        auditorTodoListService.verifyToDoAssigneeToName(firstEngagementTitleOnWeb, "toDoName01" + timeStamp, "huy assignee");
        Thread.sleep(2000);
        auditorTodoListService.undoAction();
        auditorTodoListService.verifyToDoAssigneeToName(firstEngagementTitleOnWeb, "toDoName01" + timeStamp, "huy huynh");

        NXGReports.addStep("Verify Undo action with Assign to case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Delete a To-Do, verified change on database but UI
     */
    @Test(priority = 32, enabled = true, testName = "Undo successfully", description = "verify Undo action Delete a To-Do, verified change on database but UI", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyUndoActionWithDeleteCase() {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.createToDoRecord("toDoName02" + timeStamp, "26");

        auditorTodoListService.chooseAndActAToDoWithName("toDoName02" + timeStamp, "Delete", "huy assignee (auditor)");
        auditorTodoListService.verifyToDoDeleteStatusByName(firstEngagementTitleOnWeb, "toDoName02" + timeStamp, "INACTIVE");

        auditorTodoListService.undoAction();
        auditorTodoListService.verifyToDoDeleteStatusByName(firstEngagementTitleOnWeb, "toDoName02" + timeStamp, "ACTIVE");

        NXGReports.addStep("Verify Undo action with Delete case", LogAs.PASSED, null);
    }

    /**
     * (case)verify Undo action Download Attachments disable
     */
    @Test(priority = 33, enabled = true, testName = "Undo fail", description = "verify Undo action Download Attachments disable", groups = "workflow"/*, dependsOnMethods = {"verifyUndoActionWithCompleteCase"}*/)
    public void verifyDownloadAttachmentsDisable() {
        initVariable();
        navigationPreconditions();

        auditorTodoListService.createToDoRecord("toDoName01" + timeStamp, "25");
        auditorTodoListService.verifyToDoDownloadAttachmentsDisable("toDoName01" + timeStamp);

        NXGReports.addStep("Verify Download Attachments disable", LogAs.PASSED, null);
    }

    /**
     * -----end of huy.huynh PLAT-2285-----
     */

    /**
     * Added by tan.pham on 19/05/2017.
     * Scenarios : PLAT 2286 - Add delete icon
     */
    @Test(  priority = 34,enabled = true, description = "Verify GUI of delete icon in ToDo page.")
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

    @Test(  priority = 35,enabled = true, description = "Verify default status of delete icon in ToDo page.")
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

    @Test(  priority = 36,enabled = true, description = "Verify gui of delete confirm popup in ToDo page.")
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

    @Test(  priority = 37,enabled = true, description = "Verify work flow of 'CheckAll' check box in ToDo page.")
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

    @Test(  priority = 38,enabled = true, description = "Verify work flow of delete button in ToDo page.")
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

    @Test(  priority = 39,enabled = true, description = "Verify work flow of cancel button in ToDo page.")
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

    /**
     * -----end of tan.pham PLAT-2286-----
     */

    /*
    Vien Pham merged editCategoriesTEst into this page
     */
    @Test(priority = 40, enabled = false, description = "Verify EditCategories GUI at Create New Todo Page")
    public void verifyDefaultEditCategoryGuiAtCreateNewTodoPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        //Login User
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategories();
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


    @Test(priority = 41, enabled = false, description = "Verify EditCategories GUI at Todo list Page")
    public void verifyDefaultEditCategoryGuiAtTodoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        //Login User
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategories();
            auditorEditCategoryService.navigateToEditAtCreateTodoPage();
            auditorEditCategoryService.verifyEditCategoriesTitle();
            auditorEditCategoryService.verifyEditCategoriesGuide();
            auditorEditCategoryService.hoverOnCategoryItem_TodoListPage();
            auditorEditCategoryService.verifyDefaultSaveButton();
            auditorEditCategoryService.verifyDefaultCancelButton();
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 42, enabled = true, description = "Verify Edit Function at Create new todo page")
    public void verifyEditFunctionAtCreateNewTodoPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        //Login User
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");


        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategories();
            auditorEditCategoryService.returnToCreateNewTodoPage();
            auditorEditCategoryService.navigateToEditAtCreateTodoPage();
            getLogger().info("Verifying Edit cases..");
            auditorEditCategoryService.editValidValue();
            auditorEditCategoryService.editOnlyNumber();
            auditorEditCategoryService.editNullChars();
            auditorEditCategoryService.editSpecialChars();
            auditorEditCategoryService.editSameMultiValidItems();

            NXGReports.addStep("Verify Edit Fuction.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Edit Fuction.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 43, enabled = false, description = "Verify Edit Function at todo list page")
    public void verifyEditFunctionAtTodoListPage() throws Exception {

        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        //Login User
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategories();
            auditorEditCategoryService.navigateToEditAtCreateTodoPage();
            getLogger().info("Verifying Edit cases..");
            auditorEditCategoryService.editValidValue_TodoListPage();
            auditorEditCategoryService.editOnlyNumber_TodoListPage();
            auditorEditCategoryService.editNullChars_TodoListPage();
            auditorEditCategoryService.editSpecialChars_TodoListPage();
            auditorEditCategoryService.editSameMultiValidItems_TodoListPage();
            NXGReports.addStep("Verify Edit Fuction.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Edit Fuction.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 44, enabled = false, description = "Verify Remove function at Todo list Page")
    public void verifyRemoveFunctionAtTodoListPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        //Login User
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategories();
            auditorEditCategoryService.navigateToEditAtCreateTodoPage();
            getLogger().info("Verifying Remove case..");
            auditorEditCategoryService.remove1Item();
            auditorEditCategoryService.removeMultiItems();

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
    @Test(  priority = 45,enabled = true, description = "Verify work flow of delete multi ToDo item in ToDo page.")
    public void verifyWorkFlowOfDeleteMultiToDoInToDoListPage() throws Exception {
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
            String todoName = "ToDoDelete";
            // Add one ToDo name
            List<String> toDoListNames = new ArrayList<String>();
            for(int i=0 ; i < ToDoItemNumber; i++){
                toDoListNames.add(todoName + i + dateFormat.format(date));
            }
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo has just created
            for(int i=0 ; i< toDoListNames.size(); i++){
                auditorCreateToDoService.selectToDoTaskName(toDoListNames.get(i));
            }
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check ToDo has not exists
            auditorCreateToDoService.checkToDoListIsExists(false,toDoListNames);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete multi ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete multi ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 46,enabled = true, description = "Verify work flow of delete all ToDo item in ToDo page.")
    public void verifyWorkFlowOfDeleteAllToDoInToDoListPage() throws Exception {
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
            String todoName = "ToDoDelete";
            // Add one ToDo name
            List<String> toDoListNames = new ArrayList<String>();
            for(int i=0 ; i < ToDoItemNumber; i++){
                toDoListNames.add(todoName + i + dateFormat.format(date));
            }
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Check on 'CheckAll' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check ToDo has not exists
            auditorCreateToDoService.checkAllToDoIsDelete();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete all ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete all ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 47,enabled = true, description = "Verify work flow of cancel multi ToDo item in ToDo page.")
    public void verifyWorkFlowOfCancelMultiToDoInToDoListPage() throws Exception {
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
            String todoName = "ToDoCancel";
            // Add one ToDo name
            List<String> toDoListNames = new ArrayList<String>();
            for(int i=0 ; i < ToDoItemNumber; i++){
                toDoListNames.add(todoName + i + dateFormat.format(date));
            }
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo has just created
            for(int i=0 ; i< toDoListNames.size(); i++){
                auditorCreateToDoService.selectToDoTaskName(toDoListNames.get(i));
            }
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnCancelButtonOnPopup();
            // Check ToDo has not exists
            auditorCreateToDoService.checkToDoListIsExists(true,toDoListNames);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel multi ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel multi ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(  priority = 48,enabled = true, description = "Verify work flow of cancel all ToDo item in ToDo page.")
    public void verifyWorkFlowOfCancelAllToDoInToDoListPage() throws Exception {
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
            String todoName = "ToDoCancel";
            // Add one ToDo name
            List<String> toDoListNames = new ArrayList<String>();
            for(int i=0 ; i < ToDoItemNumber; i++){
                toDoListNames.add(todoName + i + dateFormat.format(date));
            }
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Check on 'CheckAll' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnCancelButtonOnPopup();
            // Check ToDo has not exists
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
    @Test(priority = 49, enabled = true, description = "PLAT-2305: Verify DB update completed field is true when archive mart as completed.")
    public void verifyCompletedFieldUpdateSuccessful() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        Random r = new Random();
        String engagementName = "Engagement-PLAT-2350" + r.nextInt(1000);
        String taskName = "Task-2305" + r.nextInt();
        try{
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName,"","Company Auvenir");
            //will implement later, current we can not navigate engagment by name
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPageWithName(engagementName, engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.createToDoTaskWithCategoryName(taskName, "Category1");
            //Check status of completed field before mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, taskName, "false");
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            //Check status of completed field after archive mark as completed. Expected: true
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, taskName, "true");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify DB update field completed is true when archive mart as completed.",
                    LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify DB update field completed is true when archive mart as completed.",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 50, enabled = true, description = "PLAT-2305: Verify DB not update field completed is true when cancel mart as completed.")
    public void verifyCancelCompleteAction() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        Random r = new Random();
        String engagementName = "Engagement-PLAT-2350" + r.nextInt(1000);
        String taskName = "Task-2305" + r.nextInt();
        try{
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName,"","Company Auvenir");
            //will implement later, current we can not navigate engagment by name
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPageWithName(engagementName, engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.createToDoTaskWithCategoryName(taskName, "Category1");
            //Check status of completed field before mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, taskName, "false");
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCancelCompleteMarkPopup();
            auditorTodoListService.verifyTodoListPage();
            //Check status of completed field after cancel mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, taskName, "false");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify DB not update field completed is true when cancel mart as completed.",
                    LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify DB not update field completed is true when cancel mart as completed.",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**-----end of duong.nguyen PLAT-2305-----*/
}




