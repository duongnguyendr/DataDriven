package com.auvenir.ui.tests.marketing.emailtemplate;

import com.auvenir.ui.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.marketing.mailtemplate.*;
import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.services.AuditorEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.signup.AuditorSignUpService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.MongoDBService;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class MailAuditorInviteClientTest extends AbstractTest {

    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;
    private MailAuditorInviteClientPO mailAuditorInviteClientPO;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementPage auditorDetailsEngagementPage;

    @Test(priority = 1, enabled = true, description = "Verify Auditor sign up and Active")
    public void verifyAuditorSignUp() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        getLogger().info("Auditor sign up..");
        auditorSignUpService.deleteUserUsingApi("auvenirtestor@gmail.com");
        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), "auvenirtestor@gmail.com");
        auditorSignUpService.setPrefixProtocol("http://");
        auditorSignUpService.goToBaseURL();
        auditorSignUpService.verifyRegisterNewAuditorUser("Vien Pham", "auvenirtestor@gmail.com", "Change@123");
        auditorSignUpService.updateUserActiveUsingAPI("auvenirtestor@gmail.com");
        auditorSignUpService.updateUserActiveUsingMongoDB("auvenirtestor@gmail.com");
    }

    @Test(priority = 2, enabled = true, description = "Verify Auditor login and invite client..")
    public void verifyAuditorInviteClient() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        getLogger().info("Auditor log in..");
        auditorSignUpService.setPrefixProtocol("http://");
        auditorSignUpService.goToBaseURL();
        marketingService.clickLoginButton();
        marketingService.loginWithNewUserRole("auvenirtestor@gmail.com","Change@123");
        auditorEngagementService.viewEngagementDetailsPage("vienpham");
        auditorDetailsEngagementPage.verifyDetailsEngagementPage("vienpham");

    }


//
//
//    @Test(priority = 2, description = "Verify template of mail: Auditor Invite Client")
//    public void verifyMailAuditorInviteClient() {
//        mailAuditorInviteClientPO = new MailAuditorInviteClientPO(getDriver());
//        mailAuditorInviteClientPO.verifyPageContent();
//    }


}
