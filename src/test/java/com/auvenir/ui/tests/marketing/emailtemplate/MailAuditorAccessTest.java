package com.auvenir.ui.tests.marketing.emailtemplate;


import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class MailAuditorAccessTest extends AbstractTest {

    private MarketingService marketingService;
    private GmailLoginService gmailLoginService;
    private AdminService adminService;
    private AuditorSignUpService auditorSignUpService;
    private EmailTemplateService emailTemplateService;

    @Test(priority = 1, enabled = true, description = "Verify Auditor sign up and Admin set status to On-boarding")
    public void verifyAdminGiveAditorAccess() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        String auditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
        String strAdminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Admin");
        String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "PasswordAdmin");
        try {
            gmailLoginService.deleteAllExistedEmail(auditorID, password);
            auditorSignUpService.deleteUserUsingApi(auditorID);
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), auditorID);
            getLogger().info("Auditor sign up..");
            auditorSignUpService.setPrefixProtocol("http://");
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser("Auditor Test", auditorID, password);
            getLogger().info("Admin gives Auditor access..");
            marketingService.clickLoginButton();
            marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
            getLogger().info("Admin find auditor email and status to On boarding..");
//        adminService.verifyAuditorRowOnAdminUserTable("AUDITOR", "auvenirtestor@gmail.com", "06/7/2017", "Wait listed");
            adminService.changeTheStatusUser(auditorID, "Onboarding");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor sign up and Admin set status to On-boarding.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor sign up and Admin set status to On-boarding.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify template of Active Email")
    public void verifyActiveEmailTemplate() throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        String auditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
        try {
            getLogger().info("Auditor open Email and verify it.. ");
            getLogger().info("Auditor login his email to verify Welcome email template");
            gmailLoginService.gmailLogin(auditorID, password);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyActiveEmailTemplateContent();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify template of Active Email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify template of Active Email.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /*
    Vien.Pham refactor
     */
}
