package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.engagement.AuditorTeamPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 04/08/2017.
 */
public class AuditorTeamService extends AbstractService {

    private AuditorTeamPage auditorTeamPage;

    public AuditorTeamService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorTeamPage = new AuditorTeamPage(getLogger(), getDriver());
    }

    public void navigateToTeamTab() {
        auditorTeamPage.navigateToTeamTab();
    }

    public void inviteNewMemberToTeam() {
        auditorTeamPage.clickInviteNewMember();
    }
}
