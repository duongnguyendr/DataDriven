package com.auvenir.ui.services.marketing.emailtemplate;

import com.auvenir.ui.pages.marketing.mailtemplate.MailAuditorJoinPO;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by duong.nguyen on 6/7/2017.
 */
public class EmailTemplateService extends AbstractService{

    MailAuditorJoinPO mailAuditorJoinPO;
    public EmailTemplateService(Logger logger, WebDriver driver) {
        super(logger, driver);
        mailAuditorJoinPO = new MailAuditorJoinPO(getLogger(), getDriver());
    }

    public void verifyWaitListPageContent(){
        mailAuditorJoinPO.verifyPageContent();
    }

    /*
    Vien.Pham added
     */
    public void verifyActiveEmailTemplateContent(){
        mailAuditorJoinPO.verifyActiveEmailContent();
    }

    public void verifyAuditorInviteClientEmail(){
        mailAuditorJoinPO.verifyAuditorInviteClientEmail();
    }
}
