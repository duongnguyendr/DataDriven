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


    @Test(priority=1,enabled=true, description="Verify Auditor empty Todo List page.")
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
            // auditorEngagementService.verifyCreatedEngagementRendered("engagement01");
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
    @Test(  priority = 2,enabled = false, description = "Verify GUI auditor create to do page.")
    public void verifyUIAuditorCreateToDo() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();



            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifyAuditorCreateToDo();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI auditor create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 3,enabled = false, description = "Add new To Do")
    public void verifyGUIToDoTextBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();


            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyGUIAddNewToDoTextBox();
            auditorCreateToDoService.verifyInputDataToDoTextBox("Task01");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI auditor create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 4,enabled = true, description = "Verify to create To-Do page and search data.")
    public void verifyCreateToDoPageCategorySearchData() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            //auditorTodoListService.verifyTodoListPage();

            //auditorCreateToDoService.navigatetoCreateToDoTab();
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

    @Test(  priority = 5,enabled = true, description = "[PLAT 2288]-05: verify displayed of this button filter")
    public void verifyButtonFilter() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifyButtonFilter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-05: verify displayed of this button filter", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-05: verify displayed of this button filter", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 6,enabled = true, description = "[PLAT 2288]-06:verify default value(Search...) of this Search")
    public void verifySearchPlaceholder() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            //auditorCreateToDoService.verifySearchPlaceholder();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    @Test(  priority = 7,enabled = true, description = "[PLAT 2288]-07: verify when hover on Search change bounary color to green.")
    public void verifySearchHover() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifySearchHover();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-07: verify when hover on Search change bounary color to green.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-07: verify when hover on Search change bounary color to green.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 8,enabled = true, description = "[PLAT 2288]-08: verify input text.")
    public void verifySearchInputText() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifySearchInputText();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-08: verify input text.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-08: verify input text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    //    @Test(  priority = 7,enabled = true, description = "[PLAT 2288]-09:verify input with max length limit with  255 character")
//    public void verifySearchLimit255() throws Exception {
//    	try {
//    		auditorCreateToDoService.verifySearchLimit255();
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//			throw e;
//		}
//    }
//
    @Test(  priority = 9,enabled = true, description = "[PLAT 2288]-10: verify input number to field search.")
    public void verifySearchInputNumber() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();


            auditorCreateToDoService.verifySearchInputNumber();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 10,enabled = true, description = "[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title")
    public void verifyColumnsInGrid() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.verifyColumnsInGrid();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 11,enabled = true, description = "[PLAT 2288]-15: verify after each column title have a arrow icon to sort.")
    public void verifySotleOnTitle() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifySotleOnTitle();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 12,enabled = true, description = "[PLAT 2288]-16: verify checkbox will change green color a have stick icon")
    public void verifyCheckOnCheckBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();


            auditorCreateToDoService.verifyCheckOnCheckBox();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 13,enabled = true, description = "[PLAT 2288]-17: verify checkbox will change green color a have stick icon")
    public void verifyUnCheckOnCheckBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();


            auditorCreateToDoService.verifyCheckOnCheckBox();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 14,enabled = true, description = "[PLAT 2282]-03: Verify GUI To Do Save Icon")
    public void verifyGUIToDoSaveIcon() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            AbstractService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyGUIToDoSaveIcon();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI Save Icon - create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI Save Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 15,enabled = true, description = "Verify to create new Category")
    public void verifyCreateNewCategory() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            AbstractRefactorService.sStatusCnt = 0;
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

    @Test(  priority = 16,enabled = true, description = "[PLAT 2282]-03: Verify GUI To Do Close Icon")
    public void verifyGUIToDoCloseIcon() throws Exception {
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            AbstractRefactorService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.verifyGUIToDoCloseIcon();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI Close Icon - create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI Close Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
    @Test(  priority = 17,enabled = true, description = "[PLAT 2282]-03: Verify Data Grid after adding new To Do Task")
    public void verifyDataGridToDoTaskPage() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            AbstractRefactorService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();


            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyAddNewDataGridIcon("ZAToDo PLAT 2282");
            ArrayList<String> names = new ArrayList<String>();
            names.add("416 To Do Task02");
            names.add("a To Do Task02");
            names.add("za To Do Task02");
            names.add("bbb To Do Task02");
            names.add("cc To Do Task02");
            auditorCreateToDoService.verifySortDataGridIcon(names);
            auditorCreateToDoService.verifyCheckBoxToDoPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Data Grid after adding new To Do Task", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Data Grid after adding new To Do Task", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(  priority = 18,enabled = true, description = "[PLAT 2289]: Verify 'Category' combo box on Create to-do")
    public void verifyCategoryComboxBoxOnCreateToDo() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            AbstractRefactorService.sStatusCnt = 0;
            auditorEngagementService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");
            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
            auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createToDoTaskWithoutCategory("Category PLAT 2289");
            auditorCreateToDoService.verifyDefaultValueofCategoryComboBox("Select Category");
            auditorCreateToDoService.verifyHoverCategoryComboBox();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify 'Category' combo box on Create to-do", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify 'Category' combo box on Create to-do", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

}




