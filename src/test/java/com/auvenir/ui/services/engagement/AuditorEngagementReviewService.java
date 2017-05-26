package com.auvenir.ui.services.engagement;

import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/26/2017.
 */
public class AuditorEngagementReviewService extends AbstractService {
    public AuditorEngagementReviewService(Logger logger, WebDriver driver) {
        super(logger, driver);
        //loginPage = new LoginPage(getLogger(),getDriver());
    }
}
