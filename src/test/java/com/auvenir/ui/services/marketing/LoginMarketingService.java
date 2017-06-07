package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.LoginMarketingPage;
import com.auvenir.ui.pages.marketing.MarketingPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class LoginMarketingService extends AbstractService {
    LoginMarketingPage loginMarketingPage;
    public LoginMarketingService(Logger logger, WebDriver driver) {
        super(logger, driver);
        loginMarketingPage = new LoginMarketingPage(getLogger(), getDriver());
    }
    public void verifyResetPassword(String newPass, String retypeResetPass) throws InterruptedException {
        loginMarketingPage.resetPassword(newPass, retypeResetPass);
    }
    public  void exitClick()
    {
        loginMarketingPage.exit();
    }
}
