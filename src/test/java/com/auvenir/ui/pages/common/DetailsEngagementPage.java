package com.auvenir.ui.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by huy.huynh on 20/07/2017.
 */
public abstract class DetailsEngagementPage extends AbstractPage {


    @FindBy(id = "team-inviteMember-btn")
    private WebElement buttonInviteNewMember;

    @FindBy(xpath = "//img[contains(@id,'Set User To Lead')]/following-sibling::div//button[@class='auvbtn warning']")
    private WebElement buttonConfirmSetUserToLead;

    @FindBy(id = "engagementTeamLink")
    private WebElement tabTeam;


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
        //        String xpathRadioButtonLeadClient = "//td[text()='%s']/following-sibling::td/input";
        String xpathSelectPermissionLevel = "//td[text()='%s']/following-sibling::td/div";
        String xpathOptionLead = "//td[text()='%s']/following-sibling::td/div//div[@data-id='Lead']";
        clickElement(getElementByXpath(xpathSelectPermissionLevel, name), "Select Permission Level");
        clickElement(getElementByXpath(xpathOptionLead, name), "Option Lead");
    }

    public void confirmSetUserToLead() {
        waitSomeSeconds(1);
        clickElement(buttonConfirmSetUserToLead, "Button Confirm Set User To Lead");
    }

    public void verifyLeadSetByName(String name, String leadText) {
        waitSomeSeconds(1);
        String xpathCellPermissionLevel = "//td[text()='%s']/following-sibling::td[2]";
        validateElementText(getElementByXpath(xpathCellPermissionLevel, name), leadText);
    }

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[2]")
    protected List<WebElement> listTeamMember;
    @FindBy(id = "engagementTeamLink")
    protected WebElement teamMemberLinkEle;


    public int findMemberByName(String memberName) {
        int index = -1;
        for (int i = 0; i < listTeamMember.size(); i++) {
            if (listTeamMember.get(i).getText().equals(memberName)) {
                index = i;
                break;
            }
        }
        return index;
    }


}
