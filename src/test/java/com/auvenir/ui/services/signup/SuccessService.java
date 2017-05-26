package com.auvenir.ui.services.signup;

import com.auvenir.ui.pages.onboarding.SuccessPO;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by tan.pham on 5/24/2017.
 */
public class SuccessService extends AbstractService {
    private SuccessPO successPO;

    public SuccessService(Logger logger, WebDriver driver) {
        super(logger, driver);
        successPO = new SuccessPO(getLogger(),getDriver());
    }

    public void verifySuccessSignUpPage(){
        successPO.verifyPageContent();
    }

    public void acceptCreateAccountAuditor(){
        successPO.acceptCreateAccountAuditor();
    }
}
