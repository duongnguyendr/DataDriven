package com.auvenir.ui.tests.marketing.emailtemplate;


import com.auvenir.ui.pages.marketing.mailtemplate.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class MailAuditorAccessTest extends AbstractTest {

    private MailAuditorAccessPO mailAuditorAccessPO;
    private MarketingService marketingService;

    /*@Test(priority = 1, description = "")
    public void openAuvenir() {

    }*/

    @Test(priority = 2, description = "Verify template of mail : Admin gives Auditor access")
    public void verifyMailAuditorAccess() {
        marketingService = new MarketingService(getLogger(),getDriver());
        String email = GenericService.readExcelData(testData, "Login", 1, 1);
        String password = GenericService.readExcelData(testData, "Login", 1, 2);
        marketingService.goToBaseURL();
        marketingService.clickLoginButton();
        marketingService.loginWithUserNamePassword(email, password);
        mailAuditorAccessPO = new MailAuditorAccessPO(getLogger(),getDriver());
        mailAuditorAccessPO.verifyPageContent();
    }
}
