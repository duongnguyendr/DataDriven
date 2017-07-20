package com.auvenir.ui.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by huy.huynh on 20/07/2017.
 */
public abstract class DetailsEngagementPage extends AbstractPage {

    @FindBy(id = "engagementTeamLink")
    private WebElement tabTeam;

    @FindBy(id = "team-inviteMember-btn")
    private WebElement buttonInviteNewMember;

    public DetailsEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void navigateToTeamTab() {
        clickElement(tabTeam, "Tab Team");
    }

    public void clickInviteNewMember() {
        clickElement(buttonInviteNewMember, "Button Invite New Member");
    }
}
