package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorCategoryPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by vien.pham on 5/10/2017.
 */
public class AuditorEditCategoryService extends AbstractService{

    AuditorCategoryPage auditorCategoryPage ;

        /*
     * contructor
     */
    public AuditorEditCategoryService(Logger logger, WebDriver driver) {

        super(logger, driver);

    }

    public void navigateToCategoryTab() throws Exception {

        auditorCategoryPage.navigateToCategoryMenu();
    auditorCategoryPage.navigateToEditCategory();


        try {

            NXGReports.addStep("[PLAT 2288]-03: verify button create to do display with green background and white text.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-03: verify button create to do display with green background and white text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }



}
