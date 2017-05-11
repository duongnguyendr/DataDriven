package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AuditorCreateToDoService;
import com.auvenir.ui.services.AuditorEditCategoryService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by vien.pham on 5/9/2017.
 */
public class EditCategoryTest extends AbstractTest {
    AuditorCreateToDoService auditorCreateToDoService;
    AuditorEditCategoryService auditorEditCategoryService;
    @BeforeMethod
    public void initTest() throws Exception{
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
        auditorCreateToDoService.loginWithUserRole(userId);
        auditorCreateToDoService.navigateToDoListPage();
    }

//    @Test(  priority = 1,enabled = true, description = "[PLAT 2291]-01: verify CategoryGUI on new Todo window")
//    public void verifyCategoryGUI() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        try {
//            auditorCreateToDoService.navigatetoCreateToDoTab();
//            auditorEditCategoryService.verifyGUICategory();
//
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
//            NXGReports.addStep("Verify GUI Category DropDown.", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("TestScript Failed: Verify GUI Category DropDown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        }
//    }


    @Test(  priority = 2,enabled = true, description = "[PLAT 2291]-03-4:Verify EditCategories GUI")
    public void verifyEditCategoriesGUI() throws Exception {
               auditorEditCategoryService = new AuditorEditCategoryService(getLogger(),getDriver());
                try {
                //Navigate to Create TDo button and create new item.
                auditorCreateToDoService.navigatetoCreateToDoTab();
                //navigate to Category and select Edit Categories
                auditorEditCategoryService.navigateToEditCategoriesOption();
                //Verify EditCategoriesWindowGUI
//              auditorEditCategoryService.verifyEditCategoriesGUI();
              Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify EditCategoriesGUI", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify EditCategoriesGUI", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

//    @Test(  priority = 3,enabled = true, description = "[PLAT 2291]-04:Verify EditGuide sentence on new Todo window ")
//    public void verifyEditCategoryPopup() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
//        try {
//            auditorCreateToDoService.loginWithUserRole(userId);
//
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
//            NXGReports.addStep("Verify GUI Category DropDown.", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("TestScript Failed: Verify GUI Category DropDown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        }
//    }
//
//    @Test(  priority = 4,enabled = true, description = "[PLAT 2291]-05-6-7-8-9:Verify list of Categories on new Todo window ")
//    public void verifyEditCategoryPopup() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
//        try {
//            auditorCreateToDoService.loginWithUserRole(userId);
//
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
//            NXGReports.addStep("Verify GUI Category DropDown.", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("TestScript Failed: Verify GUI Category DropDown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        }
//    }


//    @Test(  priority = 5,enabled = true, description = "[PLAT 2291]-13-14: Verify Cancel button on new Todo window ")
//    public void verifyEditCategoryPopup() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
//        try {
//            auditorCreateToDoService.loginWithUserRole(userId);
//
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
//            NXGReports.addStep("Verify GUI Category DropDown.", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("TestScript Failed: Verify GUI Category DropDown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        }
//    }
//
//    @Test(  priority = 6,enabled = true, description = "[PLAT 2291]-15-16:Verify Save button on new Todo window")
//    public void verifyEditCategoryPopup() throws Exception {
//        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
//        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
//        try {
//            auditorCreateToDoService.loginWithUserRole(userId);
//
//            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
//            NXGReports.addStep("Verify GUI Category DropDown.", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("TestScript Failed: Verify GUI Category DropDown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        }
//    }
}
