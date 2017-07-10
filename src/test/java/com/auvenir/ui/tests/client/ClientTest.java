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
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by thuan.duong on 5/24/2017.
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

    //AbstractService abstractService;

    private String adminId, auditorId, clientId;
    private String adminPassword, auditorPassword, clientPassword;
    private String clientEmailPassword;
    private String engagementName;

    @BeforeClass
    public void preCondition() {

         /*String sURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                + GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_ID") + "/delete";
        getLogger().info("Call rest api to delete existed client user :" + sURL);
        Response response = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(sURL);
        if (response.getStatusCode() == 200) {
            getLogger().info("Existed user is deleted successful.");

        } else if (response.getStatusCode() == 404) {
            getLogger().info("The client is not existed in database.");
        } else {
        }*/
        //abstractService.deleteUserUsingApi(GenericService.getConfigValue(GenericService.sConfigFile, "AUDITOR_ID"));
    }

    @AfterMethod
    public void deleteCookies() {
        getDriver().manage().deleteAllCookies();
    }

    /*
     * @Description: Inviting a client
	 * @Author:Lakshmi BS
	 */
    /*@Test(priority = 1, enabled = true, description = "Inviting a client from Auditor")
    public void verifyInvitingNewClient() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        String auditUserId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Auditor");
        String clientUserId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        String adminUserId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Admin");
        String newClientData[] = GenericService.toReadExcelData("creating_NewClient_Data");
        try {
            clientService.loginWithUserRole(auditUserId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.clickNewEnagementButton();
            clientService.clickSelectClientButton();
            clientService.verifyPleaseSelectClientText();
            clientService.clickCreateNewClient();
            clientService.verifyAddNewClientPopUpDisplayed();
            clientService.inputDataKeyContactInfo(newClientData[2], clientUserId, newClientData[3]);
            clientService.inputDataCompanyInfo(newClientData[1], newClientData[4], newClientData[5], newClientData[7], newClientData[8],
                    newClientData[9], newClientData[9], newClientData[10]);
            clientService.selectAllCheckboxInCompanyInformation();
            clientService.clickAddNewClientButton();
            clientService.closeSuccessToastMes();
            clientService.clickSelectClientButton();
            clientService.clickSelectClient(newClientData[2]);
            clientService.verifyClientIsSelected(newClientData[2]);
            clientService.sendInvitationName();
            //
            clientService.loginWithUserRole(adminUserId);
            clientService.verifyAdminLoginPage();
            //Will be update later. User cannot accept the link invitation to change the status "Onboarding"
//            clientService.verifyUserIsChangeStatusOnTheList(userType, clientUserId, currentDate, expectedStatus);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Inviting New Client", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Testscript Failed: Verify Inviting New Client", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("Testscript Failed: Verify Inviting New Client", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    *//*
     * @Description: To Verify the display of Elements in Email: Invitation from to complete your financial audit
	 * @Author: Lakshmi BS
	 *//*
    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Email: Invitation from to complete your financial audit")
    public void verifyInvitationEmail() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String client_ID = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        String gmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Password");
        String searchGmailName = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "GmailSearch");

        try {
            //Will be update later. Create new class of API testing to change status.
            //driver.get("https://ariel.auvenir.com/api/user/"+GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_ID")+"/update?status=ONBOARDING");
            //Thread.sleep(5000);
            //navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "URL"));
            clientService.gmailLogin(client_ID, gmailPassword);
            clientService.searchGmail(searchGmailName);
            clientService.inviteEmail();
            clientService.verifyClientLoginPageInvitationEmail();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Invitation Email", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Testscript Failed: Verify Invitation Email", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("Testscript Failed: Verify Invitation Email", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }*/

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

    /*
     * @Description: To Verify the display of Elements in Client Onboarding Page.
	 * @Author: Lakshmi BS
	 */
    @Test(priority = 3, enabled = true, description = "To Verify the display of Elements in Auditor Onboarding Page")
    public void verifyClientOnboardingPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        try {
            //Will be update later. Create new class of API testing to change status.
            /*String onBoardingUrl;
            getLogger().info("update status of client to onboarding.");
            onBoardingUrl = GenericService.getCongigValue(GenericService.sConfigFile, "DELETE_URL") + GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID") + "/update?status=ONBOARDING";
            Response response = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(onBoardingUrl);
            if (response.getStatusCode() == 200) {
                getLogger().info("The client is on boarding.");
            } else {
            }*/
            //driver.get("https://ariel.auvenir.com/api/user/auvclient02@gmail.com/update?status=ONBOARDING");
            clientService.loginWithUserRole(userId);
            clientService.verifyClientOnBoardingPersonalStep();
            clientService.clickContinuePersonalInformationButton();
            //Will update later. For now, the Business step is not displayed.
//            clientService.verifyClientOnBoardingBusinessStep();
//            clientService.clickContinueBusinessInformationButton();
            //Will update later. For now, the Integrate File step is not displayed.
//            clientService.verifyClientOnBoardingIntegrateFileStep();
            //Will update later. For now, the skip button is not displayed.
//            clientService.clickSkipIntegrateFileButton();
            clientService.verifyClientOnBoardingSecurityStep();
            clientService.clickSkipSecurityButton();

            clientService.verifySkipSecurityPopUp();
            clientService.clickSkipSecurityWarning();
            //Will update later. For now, the welcome Dashboard is not displayed.
//            clientService.verifyDashBoardText();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Onboarding Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify Client Onboarding Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify Client Onboarding Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the content of Login email received at clients account
	 * @Author: Lakshmi BS
	 */
    @Test(priority = 4, enabled = true, description = "To Verify the content of Login email received at clients account")
    public void verifySignInEmail() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String url = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "GmailUrl");
        String client_ID = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        String gmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Password");
        String searchGmailName = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "GmailSearch");
        try {
            //Will be update later. Create new class of API testing to change status.
            //driver.get("https://ariel.auvenir.com/api/user/"+GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_ID")+"/update?status=ONBOARDING");
            clientService.navigateToURL(url);
            clientService.signInEmailOnClientLoginPage(client_ID);
            clientService.verifyWelcomePleaseCheckTxtIsDisplayed();
            clientService.gmailLogin(client_ID, gmailPassword);
            clientService.searchGmail(searchGmailName);
            clientService.signInEmail();
            clientService.verifyClientLoginPageAfterSignIn();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Sign In Email", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify Sign In Email", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Email: Your Auvenir Account is Active!
	 * @Author: Lakshmi BS
	 */
    @Test(priority = 5, enabled = true, description = "To Verify the display of Elements in Email: Your Auvenir Account is Active!")
    public void verifyCLientActiveEmail() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String client_ID = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        String gmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Password");
        String searchGmailName = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "GmailSearch");
        try {
            clientService.gmailLogin(client_ID, gmailPassword);
            clientService.searchGmail(searchGmailName);
            clientService.searchGmail(searchGmailName);
            /* Edited: Doai Tran
            Currently, Run manually we do not get an active mail
			clientService.accountActiveEmail();
	    	clientService.verifyClientLoginPageAfterActiveAccount();
			gmailPage.gmailLogout();
			*/
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify CLient Active Email", LogAs.PASSED, null);

        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify CLient Active Email", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify CLient Active Email", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Client Dashboard Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 6, enabled = true, description = "To Verify the display of Elements in Client Dashboard Page")
    public void verifyClientDashboardPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        try {
            //Will update later.
//            String onBoardingUrl;
//            getLogger().info("update status of client to active.");
//            onBoardingUrl = GenericService.getCongigValue(GenericService.sConfigFile, "DELETE_URL") + GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID") + "/update?status=ACTIVE";
//            Response response = given().keystore(GenericService.sDirPath + "/src/tests/resources/auvenircom.jks", "changeit").get(onBoardingUrl);
//            if (response.getStatusCode() == 200) {
//                getLogger().info("The client is active.");
//            } else {
//            }
//            //driver.get("https://ariel.auvenir.com/api/user/"+ GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_ID")+"/update?status=ACTIVE");
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHomePage();
            clientService.clickDashBoardLink();
            clientService.verifyClientHeader();
            clientService.clickInboxMessage();
            clientService.clickNewMessageButton();
            clientService.verifyNewMessageForm();
            clientService.clickCloseMessageButton();
            clientService.clickDashBoardLink();
            clientService.verifyDashboardPage();
            clientService.verifyClientFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Client Dashboard Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Dashboard Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Dashboard Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Client Home Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 7, enabled = true, description = "To Verify the display of Elements in Client Home Page")
    public void verifyClientHomePage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        try {
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHeader();
            clientService.verifyClientInboxMessage();
            clientService.verifyMyAuditsPage();
            clientService.verifyClientFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Client Home Page.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Home Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Home Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Client Request Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 8, enabled = true, description = "To Verify the display of Elements in Client Request Page")
    public void verifyClientRequestPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        try {
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHomePage();
            clientService.clickRequestLnk();
            clientService.verifyClientRequestPage();
            clientService.verifyClientHeader();
            clientService.verifyGeneralLedgerTab();
            clientService.clickTrialBalanceMenuLink();
            clientService.verifyTrialBalanceTab();
            clientService.clickBankStatementsMenuLink();
            clientService.verifyBankStatementsTab();
            clientService.verifyClientFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Client Request Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Request Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Request Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Client Files Page
	 * @Author: Jeevaraj SP
	 */
    @Test(priority = 9, enabled = true, description = "To Verify the display of Elements in Client Files Page")
    public void verifyClientFilesPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        String userId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        try {
            clientService.loginWithUserRole(userId);
            clientService.verifyClientHomePage();
            clientService.clickFilesLink();
            clientService.verifyClientHeader();
            clientService.verifyFilesTab();
            clientService.verifyClientFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Client Files Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Files Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed: Verify the display of Elements in Client Files Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
