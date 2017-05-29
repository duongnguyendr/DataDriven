package com.auvenir.ui.services.marketing.engagement;

import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/26/2017.
 */
public class AdminPortalReviewService extends AbstractService {
    public AdminPortalReviewService(Logger logger, WebDriver driver) {
        super(logger, driver);
        //loginPage = new LoginPage(getLogger(),getDriver());
    }
}
