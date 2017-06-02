package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.ContactPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class ContactService extends AbstractService {
    ContactPage contactPage;
    public ContactService(Logger logger, WebDriver driver) {
        super(logger, driver);
        contactPage = new ContactPage(getLogger(), getDriver());
    }
    public void verifyAboutContactPage(){
        contactPage.verifyContactContentPage();
    }
}
