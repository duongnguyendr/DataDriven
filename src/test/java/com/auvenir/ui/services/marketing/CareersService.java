package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.CareersPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class CareersService extends AbstractService {
    CareersPage careersPage;
    public CareersService(Logger logger, WebDriver driver) {
        super(logger, driver);
        careersPage = new CareersPage(getLogger(), getDriver());
    }
    public void verifyCareersContentPage(){
        careersPage.verifyCareersContentPage();
    }
}
