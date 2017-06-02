package com.auvenir.ui.tests.marketing.emailtemplate;

import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.ui.pages.marketing.mailtemplate.*;
import com.auvenir.ui.tests.AbstractTest;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class MailAuditorJoinTest extends AbstractTest {

    private MailAuditorJoinPO mailAuditorJoinPO = null;
    private GmailPage gmailPage = null;

    @Test(priority = 1,description = "Open gmail to verify content mail")
    public void openGmailforAuditorRegister(){
        gmailPage = new GmailPage(getLogger(),getDriver());
        gmailPage.openGmailIndexRegisterAccount("anh.cuong882014@gmail.com", "12345678@X");
    }

    @Test(priority = 2,description = "Verify template mail : Auditor joins and is on Waitlist")
    public void verifyMailAuditorJoin(){
        mailAuditorJoinPO = new MailAuditorJoinPO(getDriver());
        mailAuditorJoinPO.verifyPageContent();

    }

}
