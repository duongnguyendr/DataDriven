package com.auvenir.ui.pages.marketing.mailtemplate;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorInvitePO extends AbstractPage {

    public NotificationMailAuditorInvitePO(Logger logger, WebDriver webDriver) {
        super(logger, webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /*public void verifyPageContent(){
        super.get();
        super.verifyPageContent();

        // Checking content invite
        NXGReports.addStep("Verify content invite", LogAs.PASSED, null);
        this.validateElememt(eleContentInvite,"Element of content Invite ",Element_Type.DISPLAYED);
    }*/
}
