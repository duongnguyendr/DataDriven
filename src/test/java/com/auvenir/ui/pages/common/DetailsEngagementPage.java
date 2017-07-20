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

    @FindBy(xpath = "//img[contains(@id,'Set User To Lead')]/following-sibling::div//button[@class='auvbtn warning']")
    private WebElement buttonConfirmSetUserToLead;

    public DetailsEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void navigateToTeamTab() {
        clickElement(tabTeam, "Tab Team");
    }

    public void clickInviteNewMember() {
        clickElement(buttonInviteNewMember, "Button Invite New Member");
    }

    public void chooseLeadWithTeamMemberName(String name) {
        String xpathRadioButtonLeadClient = "//td[text()='%s']/following-sibling::td/input";
        clickElement(getElementByXpath(xpathRadioButtonLeadClient, name), "Radio Button Lead Client");
    }

    public void confirmSetUserToLead() {
        clickElement(buttonConfirmSetUserToLead, "Button Confirm Set User To Lead");
    }

    public void verifyLeadSetByName(String name, String leadText) {
        String xpathCellPermissionLevel = "//td[text()='%s']/following-sibling::td[2]";
        validateElementText(getElementByXpath(xpathCellPermissionLevel, name), leadText);
    }
}
