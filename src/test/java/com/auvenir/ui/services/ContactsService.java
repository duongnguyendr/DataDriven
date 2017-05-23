package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorContactsPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class ContactsService extends AbstractService {

    AuditorContactsPage auditorContactsPage;

    /*
     * contructor
     */
    public ContactsService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorContactsPage = new AuditorContactsPage(getLogger(), getDriver());

    }


    public void verifyAuditorFooter() {

        try {
            auditorContactsPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorContactsPage.verifyFooter();
            getLogger().info("verfify term of service link.");
            auditorContactsPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorContactsPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorContactsPage.verifyCookieNotice();
            auditorContactsPage.scrollPageUp();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyAuditorContactsPage() {

        try {
            getLogger().info("verify Auditor Contacts page.");
            auditorContactsPage.verifyAuditorContactsPage();
            NXGReports.addStep("verify Auditor Contacts page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Auditor Contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


}

