package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.ClientDetailsEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientSignUpService;
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
 * Created by huy.huynh on 19/07/2017.
 */
public class GroupPermissionsInitialTest extends AbstractTest {
    private MarketingService marketingService;
    private ClientEngagementService clientEngagementService;
    private ClientDetailsEngagementService clientDetailsEngagementService;
    private ClientService clientService;
    private GmailLoginService gmailLoginService;
    private AdminService adminService;
    private ClientSignUpService clientSignUpService;

    @Test(priority = 1, enabled = true, description = "Verify Admin Client have permission to invite client via email."/*,
            dataProvider = "verifyPermissionAdminClientCanInviteClient", dataProviderClass = GroupPermissionsDataProvider.class*/)
    public void verifyPermissionAdminClientCanInviteClient() throws Exception {
        //        MongoDBService.removeClientAndIndicatedValueByEmail("auvenirclient01@gmail.com");
        //        MongoDBService.removeClientAndIndicatedValueByEmail("auvenirclient02@gmail.com");
        getLogger().info("Verify Admin Client have permission to invite client via email.");
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService= new AdminService(getLogger(),getDriver());

        String adminClientId = GenericService.addBrowserPrefix("auvenirclient01@gmail.com");
        String adminClientPassword = "Changeit@123";
        String invitedClient = "auvenirclient01@gmail.com";
        String invitedClientEmailPassword = "TESTPASSWORD";
        String adminId = "chr.auveniradm@gmail.com";
        String adminPassword = "Changeit@123";

        MongoDBService.removeClientAndIndicatedValueByEmail(invitedClient);
        try {
            gmailLoginService.deleteAllExistedEmail(invitedClient, invitedClientEmailPassword);

            marketingService.loginWithUserRolesUsingUsernamePassword(adminClientId, adminClientPassword);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage("Engagement Huy Huynh");
            clientDetailsEngagementService.navigateToTeamTab();
            clientDetailsEngagementService.inviteNewMemberToTeam();
            clientService.fillInfoToInviteNewMember("abc xyzz", invitedClient, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginWithUserRolesUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(invitedClient, "Onboarding");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify Invited Client have permission to seft-active via email."/*,
            dataProvider = "verifyPermissionAdminClientCanInviteClient", dataProviderClass = GroupPermissionsDataProvider.class*/)
    public void verifyPermissionClientCanActiveViaEmail() throws Exception {
        getLogger().info("Verify Invited Client have permission to seft-active via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        String invitedClient = "auvenirclient01@gmail.com";
        String invitedClientEmailPassword = "TESTPASSWORD";
        String phoneNumber = "0123456789";
        //String parentStackHolder = "titancorpvn";
        String clientAuvenirPassword = "Changeit@123";
        String engagementName = "Engagement Huy Huynh";

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(invitedClient, invitedClientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(phoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm("");
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientAuvenirPassword);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    
}
