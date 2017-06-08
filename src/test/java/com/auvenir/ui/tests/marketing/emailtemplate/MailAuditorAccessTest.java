package com.auvenir.ui.tests.marketing.emailtemplate;


import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.ui.pages.marketing.mailtemplate.*;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.AdminService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.services.marketing.emailtemplate.EmailTemplateService;
import com.auvenir.ui.services.marketing.signup.AuditorSignUpService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class MailAuditorAccessTest extends AbstractTest {

    String strAdminEmail = GenericService.readExcelData(testData, "Login", 1, 3);
    String strAdminPwd = GenericService.readExcelData(testData, "Login", 1, 4);
    private MailAuditorAccessPO mailAuditorAccessPO;
    private MarketingService marketingService;
    private GmailLoginService gmailLoginService;
    private AdminService adminService;
    private AuditorSignUpService auditorSignUpService;
    private EmailTemplateService emailTemplateService;

    /*@Test(priority = 1, description = "")
    Vien.Pham refactor
   */
//    @BeforeSuite
//    public void preCondition() {
//        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
//        gmailLoginService.deleteAllExistedEmail("auvenirtestor@gmail.com", "Change@123");
//    }
//    @AfterMethod
//    public void deleteCookies() {
//        getDriver().manage().deleteAllCookies();
//    }
//    /*
//     * @Description: Inviting a client
//	 * @Author:Lakshmi BS
//	 */


    @Test(priority = 1, enabled = true, description = "Verify Auditor sign up and Admin set status to On-boarding")
    public void verifyAdminGiveAditorAccess() throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        gmailLoginService.deleteAllExistedEmail("auvenirtestor@gmail.com", "Change@123");
        getLogger().info("Auditor sign up..");
        auditorSignUpService.verifyRegisterNewAuditorUser("Vien Pham", "auvenirtestor@gmail.com", "Change@123");
        getLogger().info("Admin gives Auditor access..");
        marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
        getLogger().info("Admin find auditor email and status to On boarding..");
//        adminService.verifyAuditorRowOnAdminUserTable("AUDITOR", "auvenirtestor@gmail.com", "06/7/2017", "Wait listed");
        adminService.changeTheStatusAuditorToOnBoarding("auvenirtestor@gmail.com", "Onboarding");
    }

    @Test(priority = 2, enabled = true, description = "Verify template of Active Email")
    public void verifyActiveEmailTemplate() throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        mailAuditorAccessPO = new MailAuditorAccessPO(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(),getDriver());
        getLogger().info("Auditor open Email and verify it.. ");
        getLogger().info("Auditor login his email to verify Welcome email template");
        gmailLoginService.gmailLogin("auvenirtestor@gmail.com", "Change@123");
        gmailLoginService.selectActiveEmaill();
        emailTemplateService.verifyActiveEmailTemplateContent();
    }

    /*
    Vien.Pham refactor
     */
}
