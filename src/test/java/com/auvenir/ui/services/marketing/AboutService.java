package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.AboutPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class AboutService extends AbstractService {
    AboutPage aboutPage;
    public AboutService(Logger logger, WebDriver driver) {
        super(logger, driver);
        aboutPage = new AboutPage(getLogger(), getDriver());
    }
    public void verifyAboutContentPage(){
        aboutPage.verifyAboutContentPage();
    }
    public void goToCareersPage(){
        aboutPage.goToCareersPage();
    }
}
