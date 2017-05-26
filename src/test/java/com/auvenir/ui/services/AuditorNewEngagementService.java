package com.auvenir.ui.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.auvenir.ui.pages.auditor.AuditorNewEngagementPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by hai.nguyen on 5/8/2017.
 */

public class AuditorNewEngagementService extends AbstractService {

    AuditorNewEngagementPage auditorNewEngagementPage;

    /*
     * contructor 
     */
    public AuditorNewEngagementService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorNewEngagementPage = new AuditorNewEngagementPage(getLogger(), getDriver());

    }


    public void verifyNewEngagementPage() {
        try {
            getLogger().info("verify create new Engagement form page.(Implemented later)");
            auditorNewEngagementPage.verifyNewEngagementPage();
            NXGReports.addStep("verify create new Engagement form page.(Implemented later)", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify create new Engagement form page.(Implemented later)", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void enterDataForNewEngagementPage(String name, String engagementType, String company) {
        try {
            getLogger().info("Enter data for new Engagement form.(Hard code)");
            auditorNewEngagementPage.enterDataForNewEngagementPage(name, engagementType, company);
            NXGReports.addStep("Enter data for new Engagement form.(Hard code)", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Enter data for new Engagement form.(Hard code)", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}

