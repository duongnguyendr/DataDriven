package com.auvenir.ui.services.marketing.signup;

import com.auvenir.ui.pages.marketing.onboarding.*;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by tan.pham on 5/24/2017.
 */
public class SuccessService extends AbstractService {
    private SuccessPage successPage;

    public SuccessService(Logger logger, WebDriver driver) {
        super(logger, driver);
        successPage = new SuccessPage(getLogger(),getDriver());
    }

    public void verifySuccessSignUpPage(){
        successPage.verifyPageContent();
    }

    public void acceptCreateAccountAuditor(){
        successPage.acceptCreateAccountAuditor();
    }
}
