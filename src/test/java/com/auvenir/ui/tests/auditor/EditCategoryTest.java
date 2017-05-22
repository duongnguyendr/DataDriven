package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AuditorCreateToDoService;
import com.auvenir.ui.services.AuditorEditCategoryService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by vien.pham on 5/9/2017.
 */
public class EditCategoryTest extends AbstractTest {
    AuditorCreateToDoService auditorCreateToDoService;
    AuditorEditCategoryService auditorEditCategoryService;

    @BeforeMethod
    public void preCondition() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        //Login User
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        auditorCreateToDoService.loginWithUserRole(userId);
        auditorCreateToDoService.navigateToDoListPage();
        auditorCreateToDoService.navigatetoCreateToDoTab();
        auditorCreateToDoService.createMultiCategories();
    }


    @Test(priority = 1, enabled = true, description = "Verify EditCategories GUI at Create New Todo Page")
    public void verifyDefaultEditCategoryGuiAtCreateNewTodoPage() throws Exception {
        auditorEditCategoryService.returnToCreateNewTodoPage();
        auditorEditCategoryService.navigateToEditAtCreateTodoPage();
        try {
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


    @Test(priority = 2, enabled = false, description = "Verify EditCategories GUI at Todo list Page")
    public void verifyDefaultEditCategoryGuiAtTodoListPage() throws Exception {

        auditorEditCategoryService.navigateToEditAtTodoListPage();
        try {
            auditorEditCategoryService.verifyEditCategoriesTitle();
            auditorEditCategoryService.verifyEditCategoriesGuide();
            auditorEditCategoryService.verifyDefaultSaveButton();
            auditorEditCategoryService.verifyDefaultCancelButton();
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 3, enabled = false, description = "Verify Edit Function at Create new todo page")
    public void verifyEditFunctionAtCreateNewTodoPage() throws Exception {
        auditorEditCategoryService.returnToCreateNewTodoPage();
        auditorEditCategoryService.navigateToEditAtCreateTodoPage();

        try {
            getLogger().info("Verifying Edit cases..");
            auditorEditCategoryService.editValidValue();
            auditorEditCategoryService.editOnlyNumber();
            auditorEditCategoryService.editNullChars();
            auditorEditCategoryService.editSpecialChars();
//            auditorEditCategoryService.editUnvalidMultiItems();
            auditorEditCategoryService.editSameMultiValidItems();

            NXGReports.addStep("Verify Edit Fuction.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Edit Fuction.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 4, enabled = false, description = "Verify Edit Function at todo list page")
    public void verifyEditFunctionAtTodoListPage() throws Exception {

        auditorEditCategoryService.navigateToEditAtTodoListPage();
        try {
            getLogger().info("Verifying Edit cases..");
            auditorEditCategoryService.editValidValue();
            auditorEditCategoryService.editOnlyNumber();
            auditorEditCategoryService.editNullChars();
            auditorEditCategoryService.editSpecialChars();
            auditorEditCategoryService.editUnvalidMultiItems();
//            auditorEditCategoryService.editSameMultiItems();
            NXGReports.addStep("Verify Edit Fuction.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Edit Fuction.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 6, enabled = false, description = "Verify Remove function at Todo list Page")
    public void verifyRemoveFunctionAtTodoListPage() throws Exception {
        try {
            getLogger().info("Verifying Remove case..");
            auditorEditCategoryService.remove1Item();
            auditorEditCategoryService.removeMultiItems();

            NXGReports.addStep("Verify Remove function.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Remove Function.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


}

