package com.auvenir.ui.services;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by vien.pham on 5/10/2017.
 */
public class AuditorEditCategoryService extends AbstractService{

    AbstractPage auditorEditCategories = new AbstractPage(getLogger(),getDriver()) ;

        /*
     * contructor
     */
    public AuditorEditCategoryService(Logger logger, WebDriver driver) {

        super(logger, driver);

    }

    public void navigateToEditCategoriesOption(){
    getLogger().info("Navigate to EditCategories ");
          try {
            auditorEditCategories.EditCategories();
           // auditorEditCategories.navigateToEditCategory();

            NXGReports.addStep(" Access Edit Categories window.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep(" Access Edit Categories window.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

//    public void verifyEditCategoriesGUI (){
//        getLogger().info("Verify EditCategories GUI");
//        try {
//
//            verify the elements of Edit Categories are displayed correctly
//            auditorEditCategories.verifyEditCategoriesElements();
//
//            NXGReports.addStep("Verify EditCategories GUI", LogAs.PASSED,null
//        }catch (Exception e)(
//                NXGReports.addStep("Verify EditCategories GUI", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//                )
//
//    }


//    public void verifyListOfCategories (){
//        getLogger().info("Verify EditCategories GUI");
//        try {
//
//
//            NXGReports.addStep("Verify EditCategories GUI", LogAs.PASSED,null
//        }catch (Exception e) (
//                NXGReports.addStep("Verify EditCategories GUI", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//                )
//
//    }


}
