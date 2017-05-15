package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by Hai.Nguyen on 05/04/2017.
 * Implement for PLAT - 2288
 */
public class CreateToDoTest extends AbstractTest {
	AuditorCreateToDoService auditorCreateToDoService;
	AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;

    @Test(  priority = 1,enabled = false, description = "Verify GUI auditor create to do page.")
    public void verifyUIAuditorCreateToDo() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorCreateToDoService.verifyAuditorCreateToDo();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI auditor create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
	@Test(  priority = 3,enabled = false, description = "Verify to create To-Do page and search data.")
	public void verifyCreateToDoPageCategorySearchData() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.createToDoPage();
			auditorCreateToDoService.verifyDataSearch();
			auditorCreateToDoService.verifyCheckMaxLength();
			auditorCreateToDoService.verifyContentTextSearch();
			Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 5,enabled = false, description = "[PLAT 2288]-06:verify default value(Search...) of this Search")
	public void verifySearchPlaceholder() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifySearchPlaceholder();
			NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 6,enabled = false, description = "[PLAT 2288]-07: verify when hover on Search change bounary color to green.")
	public void verifySearchHover() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifySearchHover();
			NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 7,enabled = false, description = "[PLAT 2288]-08: verify input text.")
	public void verifySearchInputText() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifySearchInputText();
			NXGReports.addStep("verify input text.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("verify input text.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 8,enabled = false, description = "[PLAT 2288]-10: verify input number to field search.")
	public void verifySearchInputNumber() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");

		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifySearchInputNumber();
			NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 14,enabled = false, description = "Verify to create new Category")
	public void verifyCreateNewCategory() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifyCreateNewCategory();
			Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify to create new Category", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify to create new Category", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

/*
	@Test(  priority = 1,enabled = false, description = "Verify GUI auditor create to do page.")
	public void verifyUIAuditorCreateToDo() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorEngagementService.verifyAuditorEngagementPage();
			auditorCreateToDoService.verifyAuditorCreateToDo();
			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("TestScript Failed: Verify GUI auditor create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

    @Test(  priority = 2,enabled = false, description = "Add new To Do")
    public void verifyGUIToDoTextBox() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        try {
            auditorCreateToDoService.loginWithUserRole(userId);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyGUIAddNewToDoNameTextBox();
            auditorCreateToDoService.verifyInputDataToDoNameTextBox("Task01");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI auditor create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(  priority = 3,enabled = false, description = "Verify to create To-Do page and search data.")
    public void verifyCreateToDoPageCategorySearchData() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.createToDoTask();
			auditorCreateToDoService.verifyDataSearch();
			auditorCreateToDoService.verifyCheckMaxLength();
			auditorCreateToDoService.verifyContentTextSearch();
			Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 4,enabled = false, description = "[PLAT 2288]-05: verify displayed of this button filter")
	public void verifyButtonFilter() throws Exception {

		try {
			auditorCreateToDoService.verifyButtonFilter();
			NXGReports.addStep("[PLAT 2288]-05: verify displayed of this button filter", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-05: verify displayed of this button filter", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 5,enabled = false, description = "[PLAT 2288]-06:verify default value(Search...) of this Search")
	public void verifySearchPlaceholder() throws Exception {

		try {
			//auditorCreateToDoService.verifySearchPlaceholder();
			NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 6,enabled = false, description = "[PLAT 2288]-07: verify when hover on Search change bounary color to green.")
	public void verifySearchHover() throws Exception {

		try {
			auditorCreateToDoService.verifySearchHover();
			NXGReports.addStep("[PLAT 2288]-07: verify when hover on Search change bounary color to green.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-07: verify when hover on Search change bounary color to green.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 7,enabled = false, description = "[PLAT 2288]-08: verify input text.")
	public void verifySearchInputText() throws Exception {

		try {
			auditorCreateToDoService.verifySearchInputText();
			NXGReports.addStep("[PLAT 2288]-08: verify input text.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-08: verify input text.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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
	@Test(  priority = 8,enabled = false, description = "[PLAT 2288]-10: verify input number to field search.")
	public void verifySearchInputNumber() throws Exception {

		try {
			auditorCreateToDoService.verifySearchInputNumber();
			NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 9,enabled = false, description = "[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title")
	public void verifyColumnsInGrid() throws Exception {

		try {
			auditorCreateToDoService.verifyColumnsInGrid();
			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 10,enabled = false, description = "[PLAT 2288]-15: verify after each column title have a arrow icon to sort.")
	public void verifySotleOnTitle() throws Exception {

		try {
			auditorCreateToDoService.verifySotleOnTitle();
			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 11,enabled = false, description = "[PLAT 2288]-16: verify checkbox will change green color a have stick icon")
	public void verifyCheckOnCheckBox() throws Exception {

		try {
			auditorCreateToDoService.verifyCheckOnCheckBox();
			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 12,enabled = false, description = "[PLAT 2288]-17: verify checkbox will change green color a have stick icon")
	public void verifyUnCheckOnCheckBox() throws Exception {

		try {
			auditorCreateToDoService.verifyCheckOnCheckBox();
			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 13,enabled = false, description = "[PLAT 2282]-03: Verify GUI To Do Save Icon")
	public void verifyGUIToDoSaveIcon() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
		try {
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifyGUIToDoSaveIcon();
			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
			NXGReports.addStep("Verify GUI Save Icon - create to do page.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("TestScript Failed: Verify GUI Save Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	@Test(  priority = 14,enabled = false, description = "Verify to create new Category")
	public void verifyCreateNewCategory() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifyCreateNewCategory();
			Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify to create new Category", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify to create new Category", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	@Test(  priority = 15,enabled = false, description = "[PLAT 2282]-03: Verify GUI To Do Close Icon")
	public void verifyToDoCloseIcon() throws Exception {
		try {
			auditorCreateToDoService.verifyToDoCloseIcon();
			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
			NXGReports.addStep("Verify GUI Close Icon - create to do page.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("TestScript Failed: Verify GUI Close Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	@Test(  priority = 16,enabled = false, description = "[PLAT 2282]-03: Verify Data Grid after adding new To Do Task")
	public void verifyDataGridToDoTaskPage() throws Exception {
		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
		try {
			auditorCreateToDoService.loginWithUserRole(userId);
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifyAddNewDataGridIcon("ZAToDo PLAT 2282");
			ArrayList<String> names = new ArrayList<String>();
			names.add("416 To Do Task02");
			names.add("a To Do Task02");
			names.add("za To Do Task02");
			names.add("bbb To Do Task02");
			names.add("cc To Do Task02");
			auditorCreateToDoService.verifySortDataGridIcon(names);
			auditorCreateToDoService.verifyCheckBoxToDoName();
			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
			NXGReports.addStep("Verify Data Grid after adding new To Do Task", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("TestScript Failed: Verify Data Grid after adding new To Do Task", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
    */
//	@Test(  priority = 17,enabled = true, description = "[PLAT 2289]: Verify 'Category' combo box on Create to-do")
//	public void verifyCategoryComboxBoxOnCreateToDo() throws Exception {
//		auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//		auditorEngagementService = new AuditorEngagementService(getLogger(),getDriver());
//        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(),getDriver());
//        auditorTodoListService = new AuditorTodoListService(getLogger(),getDriver());
//		String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
//    	try {
//            auditorEngagementService.loginWithUserRole(userId);
//            auditorEngagementService.verifyAuditorEngagementPage();
//            auditorEngagementService.viewEngagementDetailsPage("engagement01");
//            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement01");
//            auditorDetailsEngagementService.navigateToTodoListPage();
//            auditorTodoListService.verifyTodoListPage();
//
//			//auditorCreateToDoService.navigatetoCreateToDoTab();
//			auditorCreateToDoService.createToDoTaskWithCategoryName("Task01 2289", "Category1");
//			auditorCreateToDoService.clickCreateToDoTask();
//			auditorCreateToDoService.verifyDefaultValueofCategoryComboBox("Select Category");
//			auditorCreateToDoService.verifyHoverCategoryComboBox();
//			auditorCreateToDoService.verifyValueofCategoryComboBox("Category1");
//			auditorCreateToDoService.verifyNewCategoryPopUpDisplayed();
//			auditorCreateToDoService.verifyEditCategoryPopUpDisplayed();
//			auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task01 2289 without Category");
//			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
//			NXGReports.addStep("Verify 'Category' combo box on Create to-do", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("TestScript Failed: Verify 'Category' combo box on Create to-do", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//		}
//	}
}

