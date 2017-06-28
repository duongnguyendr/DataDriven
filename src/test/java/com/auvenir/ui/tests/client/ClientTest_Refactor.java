package com.auvenir.ui.tests.client;

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
import htmlreport.com.nxgreport.NXGReports;
import htmlreport.com.nxgreport.logging.LogAs;
import htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by huy.huynh on 26/06/2017.
 */
public class ClientTest_Refactor extends AbstractTest {
    private ClientService clientService;
    private AuditorEngagementService auditorEngagementService;
    private MarketingService marketingService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;

    private String adminId, auditorId, clientId;
    private String adminPassword, auditorPassword, clientPassword;
    private String clientEmailPassword;
    private String engagementName;

    @Test(priority = 1, enabled = true, description = "Inviting a client from Auditor")
    public void verifyInvitingNewClient() throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        clientId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Client");
        adminId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Admin");
        auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin Auvenir Password");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Email Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Assignee");
        String invalidClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Invalid User", "Client");

//        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
//        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
//        MongoDBService.removeEngagementObjectByName(MongoDBService.getCollection("engagements"), engagementName);
        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);

            marketingService.loginWithUserRolesUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
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

    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Email: Invitation from to complete your financial audit")
    public void verifyInvitationEmail() throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        clientId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Client");
        clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Email Password");
        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId,clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateToEmailDetail();

            gmailLoginService.verifyHeaderImage("images/logo.png");
            gmailLoginService.verifyGreetingTitle("Hi");
            gmailLoginService.verifyAnnouncementTitle("Test has invited you to complete your engagement. Please click below to get started!");
            gmailLoginService.verifyAuvenirIntroducingTitle("Auvenir is on a mission to make financial audits smarter and more efficient. Our technology helps auditors and clients collaborate better for faster, easier engagements.");
            gmailLoginService.verifyIntroducingBenefitTitle("Here are some of the benefits.");
            gmailLoginService.verifyFirstBenefitTitle("- Highly secure, cloud based platform to upload your documents");
            gmailLoginService.verifySecondBenefitTitle("- Customized, detailed notifications and task management system keeps everyone on schedule and on budget");
            gmailLoginService.verifyThirdBenefitTitle("- Bank and accounting system integrations");
            gmailLoginService.verifyFeedbackTitle("We welcome your feedback, ideas and suggestions to make the audit experience better. Send us an email at feedback@auvenir.com.");
            gmailLoginService.verifyGoodbyeTitle("Best Regards,\n" +
                    "\n" +
                    "-Andi,\n" +
                    "Auvenir Customer Success Team");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }
}
