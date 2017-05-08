package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorNewEngagementPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
            getLogger().info("navigate to Contacts page.");
            auditorNewEngagementPage.verifyNewEngagementPage();
            NXGReports.addStep("navigate to Contacts page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}

