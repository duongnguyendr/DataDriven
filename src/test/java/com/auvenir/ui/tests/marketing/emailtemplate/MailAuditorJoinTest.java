package com.auvenir.ui.tests.marketing.emailtemplate;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class MailAuditorJoinTest extends AbstractTest {

    AuditorSignUpService auditorSignUpService;
    GmailLoginService gmailLoginService;
    EmailTemplateService emailTemplateService;

    @Test(priority = 1, description = "Open gmail to verify content mail")
    public void openGmailforAuditorRegister(){
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        try{
            String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
            String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
            auditorSignUpService.setPrefixProtocol(httpProtocol);
            auditorSignUpService.deleteUserUsingApi(auditorId);
            auditorSignUpService.deleteUserUsingMongoDB(auditorId);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser("Auditor Test", auditorId, password);
            gmailLoginService.verifyOpenGmailIndexRegisterAccount(auditorId, password);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify content mail.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify content mail.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, description = "Verify template mail : Auditor joins and is on Waitlist")
    public void verifyMailAuditorJoin(){
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        try{
            String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Auditor");
            String password = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Valid User", "Password");
            auditorSignUpService.setPrefixProtocol(httpProtocol);
            auditorSignUpService.deleteUserUsingApi(auditorId);
            auditorSignUpService.deleteUserUsingMongoDB(auditorId);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.verifyRegisterNewAuditorUser("Auditor Test", auditorId, password);
            gmailLoginService.verifyOpenGmailIndexRegisterAccount(auditorId, password);
            emailTemplateService.verifyWaitListPageContent();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify template mail : Auditor joins and is on Waitlist.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify template mail : Auditor joins and is on Waitlist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
/**
 *  Refactor by Duong Nguyen
 *  Date: 7/6/2017
 */
