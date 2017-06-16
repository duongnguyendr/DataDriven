package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by thuan.duong on 6/16/2017.
 */
public class AuditorEngagementTeamPage extends AbstractPage {

    public AuditorEngagementTeamPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "engagementTeamLink")
    private WebElement teamMemberLinkEle;

    @FindBy(id = "team-inviteMember-btn")
    private WebElement inviteNewMemeberBtnEle;

    @FindBy(id = "team-emptyDiv")
    private WebElement teamEmptyDivEle;

    @FindBy(xpath = "//*[@id='team-checkAll']")
    private  WebElement allMemberCheckBoxEle;

    @FindBy(xpath = "//*[@id='team-bulk-dropdown']")
    private  WebElement bulkActionsDropdownEle;

    @FindBy(xpath = "//*[@id='team-delete-btn']")
    private WebElement deleteOptionActionsEle;

    public void clickEngagementTeamMenu() {
        getLogger().info("Click Engagement Team menu.");
        clickElement(teamMemberLinkEle, "Team Member Engagement Menu");
    }

    public void clickInviteNewMemeberBtnEle() {
        getLogger().info("Click Invite New Memeber Button.");
        clickElement(inviteNewMemeberBtnEle, "Invite New Memeber Button");
    }

    public void deleteAllMemberInEngagement() {
        getLogger().info("Click Delete All Member.");
        try {
            String displayedValue = teamEmptyDivEle.getCssValue("display");
            if(displayedValue.equals("none")){
                clickElement(allMemberCheckBoxEle, "All Member Check Box");
                boolean checked = allMemberCheckBoxEle.isSelected();
                if(checked) {
                    clickElement(bulkActionsDropdownEle, "Bulk Actions Dropdown");
                    clickElement(deleteOptionActionsEle, "Delete Option Dropdown");
                    waitForAtrributeValueChanged(teamEmptyDivEle, "Team Empty Icon", "display", "block");
                }
            }
            NXGReports.addStep("Delete All Member in Engagement.", LogAs.PASSED, null);
        } catch (Exception e){
            AbstractService.sStatusCnt ++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed:  Delete All Member in Engagement.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
