package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.auditor.engagement.AuditorNewEngagementPage;
import com.auvenir.ui.pages.groupPermissions.AdminAuditorPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorService extends AbstractService {
    private AdminAuditorPage adminAuditorPage;
    private AuditorNewEngagementPage auditorNewEngagementPage;

    public AdminAuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        adminAuditorPage = new AdminAuditorPage(getLogger(), getDriver());
        auditorNewEngagementPage= new AuditorNewEngagementPage(getLogger(), getDriver());
    }

    public void verifyCanCreateAnEngagement(boolean exist) {
        adminAuditorPage.verifyCanCreateAnEngagement(exist);
        if (exist) {
            auditorNewEngagementPage.verifyNewEngagementPage();
        }
    }
}
