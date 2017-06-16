package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorEngagementTeamPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by thuan.duong on 6/16/2017.
 */
public class AuditorEngagementTeamService extends AbstractService {

    AuditorEngagementTeamPage auditorEngagementPage;

    /*
     * contructor
     */
    public AuditorEngagementTeamService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorEngagementPage = new AuditorEngagementTeamPage(getLogger(), getDriver());
    }

    public void clickEngagementTeamMenu() {
        auditorEngagementPage.clickEngagementTeamMenu();
    }

    public void deleteAllMemberInEngagement() {
        auditorEngagementPage.deleteAllMemberInEngagement();
    }
}
