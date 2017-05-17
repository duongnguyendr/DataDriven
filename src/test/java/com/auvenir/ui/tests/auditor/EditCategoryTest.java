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
    AuditorEngagementService auditorEngagementService;

    @BeforeMethod
    public void preCondition() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        //Login User
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        auditorCreateToDoService.loginWithUserRole(userId);
        auditorCreateToDoService.navigateToDoListPage();
        auditorCreateToDoService.navigatetoCreateToDoTab();
        auditorCreateToDoService.createToDoPage();
//        auditorCreateToDoService.verifyCreateNewCategory();
        auditorEditCategoryService.returnToCreateNewTodoPage();
        auditorEditCategoryService.navigateToEditCategoriesOption();
    }


    @Test(priority = 1, enabled = false, description = "Verify EditCategories_PopUp GUI")
    public void verifyDefaultPopUpGUI() throws Exception {

        try {
            auditorEditCategoryService.verifyEditCategoriesTitle();
            auditorEditCategoryService.verifyEditCategoriesGuide();
            auditorEditCategoryService.verifyDefaultSaveButton();
            auditorEditCategoryService.verifyDefaultCancelButton();

//            auditorEditCategoryService.verifyListOfCategories();


            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 2, enabled = true, description = "Verify Edit Function")
    public void verifyEditFunction() throws Exception {

        try {
            getLogger().info("Verifying Edit cases..");
            auditorEditCategoryService.editValidValue();
            auditorEditCategoryService.navigateToEditCategoriesOption();
            auditorEditCategoryService.editValidMultiItems();
            auditorEditCategoryService.navigateToEditCategoriesOption();
            auditorEditCategoryService.editOnlyNumber();
            auditorEditCategoryService.navigateToEditCategoriesOption();
            auditorEditCategoryService.editNullChars();
            auditorEditCategoryService.navigateToEditCategoriesOption();
            auditorEditCategoryService.editSpecialChars();
            auditorEditCategoryService.navigateToEditCategoriesOption();
            auditorEditCategoryService.editUnvalidMultiItems();
            NXGReports.addStep("Verify Edit Fuction.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Edit Fuction.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 3, enabled = false, description = "Verify Remove function")
    public void verifyRemoveOne() throws Exception {
        try {

            //Verify EditCategories_PopUp Guide
//            auditorEditCategoryService.verifyRemove1Category();

            NXGReports.addStep("Verify Remove function.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Remove Function.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


}

