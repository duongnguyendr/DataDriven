package com.auvenir.ui.tests.client;

import com.auvenir.ui.dataprovider.client.ClientDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorNewEngagementService;
import com.auvenir.ui.services.auditor.AuditorTodoListService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by huy.huynh on 11/07/2017.
 */
public class ClientTest extends AbstractTest {
    private ClientService clientService;
    private AuditorEngagementService auditorEngagementService;
    private MarketingService marketingService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;

    //    private String adminId, auditorId, clientId;
    //    private String adminPassword, auditorPassword, clientPassword;
    //    private String clientEmailPassword;
    //    private String engagementName;

    @Test(priority = 1, enabled = true, description = "Inviting a client from Auditor", dataProvider = "verifyInvitingNewClient",
          dataProviderClass = ClientDataProvider.class)
    public void verifyInvitingNewClient(String adminId, String adminPassword, String auditorId, String auditorPassword, String clientId,
                                        String clientEmailPassword, String clientFullName, String invalidClientId,
                                        String engagementName) throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        adminId = GenericService.addBrowserPrefix(adminId);
        auditorId = GenericService.addBrowserPrefix(auditorId);
        clientId = GenericService.addBrowserPrefix(clientId);

        //        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
        MongoDBService.removeEngagementObjectByName(MongoDBService.getCollection("engagements"), engagementName);
        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            System.out.println("invalidClientId = " + invalidClientId);
            clientService.inviteNewClient(clientFullName, invalidClientId, "");
            clientService.verifyInviteClientFailure("Error on finding existing user");

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.inviteNewClient(clientFullName, clientId, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Onboarding");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Email: Invitation from to complete your financial audit",
          dataProvider = "verifyInvitationEmail", dataProviderClass = ClientDataProvider.class)
    public void verifyInvitationEmail(String clientId, String clientEmailPassword, String imageLogo, String greetingTitle, String announcementTitle,
                                      String auvenirIntroducingTitle, String introducingBenefitTitle, String firstBenefitTitle,
                                      String secondBenefitTitle, String thirdBenefitTitle, String feedbackTitle,
                                      String goodbyeTitle) throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        clientId = GenericService.addBrowserPrefix(clientId);
        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateToEmailDetail();

            gmailLoginService.verifyHeaderImage(imageLogo);
            gmailLoginService.verifyGreetingTitle(greetingTitle);
            gmailLoginService.verifyAnnouncementTitle(announcementTitle);
            gmailLoginService.verifyAuvenirIntroducingTitle(auvenirIntroducingTitle);
            gmailLoginService.verifyIntroducingBenefitTitle(introducingBenefitTitle);
            gmailLoginService.verifyFirstBenefitTitle(firstBenefitTitle);
            gmailLoginService.verifySecondBenefitTitle(secondBenefitTitle);
            gmailLoginService.verifyThirdBenefitTitle(thirdBenefitTitle);
            gmailLoginService.verifyFeedbackTitle(feedbackTitle);
            gmailLoginService.verifyGoodbyeTitle(goodbyeTitle);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 4, enabled = true, description = "To Verify the content of Login email received at clients account")
    public void verifySignInEmail() throws Exception {

    }
}
