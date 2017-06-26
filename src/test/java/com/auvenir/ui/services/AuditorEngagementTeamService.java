package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorEngagementTeamPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by thuan.duong on 6/16/2017.
 */
public class AuditorEngagementTeamService extends AbstractService {

    AuditorEngagementTeamPage auditorEngagementTeamPage;

    /*
     * contructor
     */
    public AuditorEngagementTeamService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorEngagementTeamPage = new AuditorEngagementTeamPage(getLogger(), getDriver());
    }

    public void clickEngagementTeamMenu() {
        auditorEngagementTeamPage.clickEngagementTeamMenu();
    }

    public void deleteAllMemberInEngagement() {
        auditorEngagementTeamPage.deleteAllMemberInEngagement();
    }

    public void clickInviteMember() {
        auditorEngagementTeamPage.clickInviteMember();
    }

    public void inputInviteNewMemberInfo(String fullName, String email, String roleMember) {
        auditorEngagementTeamPage.inputInviteNewMemberInfo(fullName, email, roleMember);
    }

    public void verifyAddNewInvitedMember(String fullName, String roleMember) {
        auditorEngagementTeamPage.verifyAddNewInvitedMember(fullName, roleMember);
    }

    public void deleteMemberInEngagementByName(String fullNameMember) {
        auditorEngagementTeamPage.deleteMemberInEngagementByName(fullNameMember);
    }

    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - Start
     */
    public void verifyMemberIsShownInTeamList(String memberFullName, String roleInFirm){
        auditorEngagementTeamPage.verifyMemberIsShownInTeamList(memberFullName,roleInFirm);
    }
    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - End
     */
}
