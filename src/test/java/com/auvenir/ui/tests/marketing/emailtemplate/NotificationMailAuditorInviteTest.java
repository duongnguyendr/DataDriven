package com.auvenir.ui.tests.marketing.emailtemplate;

import com.auvenir.ui.pages.marketing.mailtemplate.*;
import com.auvenir.ui.tests.AbstractTest;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailAuditorInviteTest extends AbstractTest {

    private NotificationMailAuditorInvitePO notification;

    @Test(priority = 1, description = "Invite a client to Engagement")
    public void openAuvenir() {

    }

    @Test(priority = 2, description = "Verify template of Notification Mail when SO is invited ")
    public void verifyNotificationMailAuditorInvite() {
        notification = new NotificationMailAuditorInvitePO(getDriver());
        //notification.verifyPageContent();
    }
}
