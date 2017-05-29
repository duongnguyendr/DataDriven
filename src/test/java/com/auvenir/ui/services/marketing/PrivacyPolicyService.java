package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.PrivacyPolicyPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class PrivacyPolicyService extends AbstractService {
    PrivacyPolicyPage privacyPolicyPage;
    public PrivacyPolicyService(Logger logger, WebDriver driver) {
        super(logger, driver);
        privacyPolicyPage = new PrivacyPolicyPage(getLogger(), getDriver());
    }
    public void verifyPrivacyPolicyContentPage(){
        privacyPolicyPage.verifyPrivacyPolicyContentPage();
    }
}
