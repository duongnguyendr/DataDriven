package com.auvenir.ui.services.auditor;

/**
 * Created by tan.pham on 6/30/2017.
 */
import com.auvenir.ui.pages.auditor.contact.AuditorContactsPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AuditorContactService extends AbstractService{
    AuditorContactsPage auditorContactsPage;
    /*
     * contructor
     */
    public AuditorContactService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorContactsPage = new AuditorContactsPage(getLogger(), getDriver());

    }

    public void verifyAuditorContactPage(){
        auditorContactsPage.verifyAuditorContactsPage();
    }

    public void clickOnEngagementLink(){
        auditorContactsPage.clickOnEngagementLink();
    }

    public void verifyGUIDataTableContactPage(){
        auditorContactsPage.verifyGUIDataTableInContactPage();
    }
}
