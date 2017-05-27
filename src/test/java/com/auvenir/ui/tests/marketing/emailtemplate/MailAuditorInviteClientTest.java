package com.auvenir.ui.tests.marketing.emailtemplate;

import com.auvenir.ui.pages.marketing.mailtemplate.MailAuditorInviteClientPO;
import com.auvenir.ui.tests.AbstractTest;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class MailAuditorInviteClientTest extends AbstractTest {

    private MailAuditorInviteClientPO mailAuditorInviteClientPO;

    @Test(priority = 1,description = "")
    public void openA(){
        //
    }

    @Test(priority = 2, description = "Verify template of mail: Auditor Invite Client")
    public void verifyMailAuditorInviteClient(){
        mailAuditorInviteClientPO = new MailAuditorInviteClientPO(getDriver());
        mailAuditorInviteClientPO.verifyPageContent();
    }


}
