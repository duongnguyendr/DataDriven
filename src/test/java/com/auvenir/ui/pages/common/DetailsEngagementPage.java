package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
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

    @FindBy(xpath = "//span[@id='a-header-title']")
    private WebElement dashboardTextAtPage;

    @FindBy(xpath = "//input[@id='a-header-title']")
    private WebElement dashboardTextEle;

    @FindBy(id = "engagementUserBtn")
    private WebElement buttonInviteClient;

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

    /**
     * @param engagementName : to verify engagement name displayed correctly
     * @param editablePage:  true: elements of Page can be edited or false: elements of Page can not be edited
     */
    public void verifyDetailsEngagementPage(String engagementName, boolean editablePage) {
        if (editablePage) {
            waitForVisibleElement(dashboardTextEle, "dashboard text");
            clickElement(dashboardTextEle);
            sendTabkey(dashboardTextEle, "");
            validateAttributeElement(dashboardTextEle, "placeholder", engagementName);
        } else {
            waitForVisibleElement(dashboardTextAtPage, "dashboard text");
            validateElementText(dashboardTextAtPage, engagementName);
        }
    }

    public void verifyCantInviteClientIntoEngagement(boolean possible) {
        if (validateExistedElement(buttonInviteClient, "Button Invite Client") == possible) {
            NXGReports.addStep("Verify Invite Client Into Engagement.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Fail: Verify Invite Client Into Engagement.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
