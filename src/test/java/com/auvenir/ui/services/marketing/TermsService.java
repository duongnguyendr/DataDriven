package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.TermsPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class TermsService extends AbstractService {
    TermsPage termsPage;
    public TermsService(Logger logger, WebDriver driver) {
        super(logger, driver);
        termsPage = new TermsPage(getLogger(), getDriver());
    }
    public void verifyTermsContentPage(){
        termsPage.verifyTermsContentPage();
    }
}
