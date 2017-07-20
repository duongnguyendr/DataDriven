package com.auvenir.ui.pages.client.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by vien.pham on 7/19/2017.
 */
public class ClientEngagementTeamPage extends AbstractPage {
    public ClientEngagementTeamPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[2]")
    List<WebElement> listTeamMember;
    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//input[@type='checkbox']")
    List<WebElement> listCheckboxTeamMember;
    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//span[contains(@id,'team-trash')]")
    List<WebElement> listTrashIconTeamMember;
    @FindBy(xpath = "//div[@class='send-message-success-alert']")
    WebElement messageRemoveMemberDone;
    @FindBy(xpath = "//div[@class='fl-a-container fl-a-container-show']")
    WebElement popUpRemoveMemberDone;
    @FindBy(id = "engagementTeamLink")
    private WebElement teamMemberLinkEle;


    /**
     * Vien.Pham added method removeTeamMember() for removing member in list.
     *
     * @param memberFullName: input memberFullName to filter corresponding row include it.
     */
    public void removeTeamMember(String memberFullName) {
        try {
            System.out.println("The number of Team member before removing is: " + listTeamMember.size());
            int index = findMemberByName(memberFullName);
            clickElement(listCheckboxTeamMember.get(index), "select member check box");
            waitForCssValueChanged(listTrashIconTeamMember.get(index), "member trash icon", "display", "block");
            clickElement(listTrashIconTeamMember.get(index));
            NXGReports.addStep("Completing do remove action: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Completing do remove action: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

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

    public void verifyRemoveTeamMember(String memberName) {
        System.out.println("The number of Team member after removing is: " + listTeamMember.size());
        int isCheck = findMemberByName(memberName);
        if (isCheck == -1) {
            NXGReports.addStep("Verify team member is removed : Pass.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify team member is removed : Failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyMessageFromRemovingTeamMember(){
        waitForVisibleElement(popUpRemoveMemberDone,"Popup alerts remove member done");
        validateElementText(messageRemoveMemberDone, "Your team member has been removed.");

    }

    public void selectEngagementTeamMenu(){
        clickElement(teamMemberLinkEle, "Team Member Engagement Menu");
    }

}
