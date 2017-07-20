package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.dataprovider.SmokeDataProvider;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.client.ClientEngagementTeamService;
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


public class GroupPermissionsInitialTest extends AbstractTest {
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorEngagementTeamService auditorEngagementTeamService;
    private ClientEngagementTeamService clientEngagementTeamService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private GmailLoginService gmailLoginService;
    private ClientService clientService;
    private ClientSignUpService clientSignUpService;
    private ClientDetailsEngagementService clientDetailsEngagementService;

    @Test(priority = 25, enabled = true, description = "To verify Lead Client on Todo")
    public void verifyLeadClientOnTodo() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorEngagementTeamService = new AuditorEngagementTeamService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(),getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(),getDriver());
        String leadClientID = GenericService.getTestDataFromExcel("GroupPermissionTest", "Lead Client", "Valid Value");
        String leadClientPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
        String generalClient = GenericService.getTestDataFromExcel("GroupPermissionTest", "Client", "Valid Value");
        String generalClientEmailPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");
        String generalClientAuvenirPassword =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 1 Name", "Valid Value");
        MongoDBService.removeClientAndIndicatedValueByEmail(generalClient);
        try {
            gmailLoginService.deleteAllExistedEmail(generalClient, generalClientEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientID, leadClientPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            auditorEngagementTeamService.clickEngagementTeamMenu();
            clientEngagementTeamService.removeAdminClient("Admin Client");
            clientEngagementTeamService.verifyMessageFromRemovingAdminClient();
            clientEngagementTeamService.verifyRemoveAdminClient("Admin Client");
            clientService.selectInviteNewMemberButton();
            clientService.inviteNewMember("General Client", generalClient, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");
            gmailLoginService.gmailReLogin(generalClientEmailPassword);
            gmailLoginService.selectActiveEmaill();
            gmailLoginService.selectStartEngagementBtnToNavigateToAuvenirPage();
            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm("0123456789");
            clientSignUpService.fillUpBusinessForm("Titancorpvn");//updateStackerHolder
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(generalClientAuvenirPassword);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client on Todo: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client on Todo: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }


}
