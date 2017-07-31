package com.auvenir.ui.pages.common;

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
 * Created by vien.pham on 7/28/2017.
 */
public abstract class TeamPage extends AbstractPage {
    public TeamPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[2]")
    private List<WebElement> listTeamMember;
    @FindBy(id = "engagementTeamLink")
    private WebElement tabTeam;
    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//input[@type='checkbox']")
    private List<WebElement> listCheckboxTeamMember;
    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//input[contains(@type,'checkbox') and (@disabled)]")
    private List<WebElement> listDisableCheckboxTeamMember;

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

    public void navigateToTeamTab() {
        clickElement(tabTeam, "Tab Team");
    }

    public void verifyPermisionToSeeMemberList(String memberFullName, boolean permissionToSee) {
        getLogger().info("Finding member in list...");
        int index = findMemberByName(memberFullName);
        if (permissionToSee) {
            if (index != -1) {

            }

        } else {
            if (index == -1) {
                getLogger().info("Can not see member: " + memberFullName + " in list");
                NXGReports.addStep("Verify can " + (permissionToSee ? "see member: " : "not see member: " + memberFullName + " in list :Pass"),
                        LogAs.PASSED, null);
            } else {
                getLogger().info("Can see member: " + memberFullName + " in list");
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify can " + (permissionToSee ? "see member: " : "not see member: " + memberFullName + " in list :Fail"),
                        LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        }
    }

    public void verifyPermisionToSeclectMemberCheckbox(String memberFullName, boolean permissionToSelect) {
        getLogger().info("Finding member in list...");
        int index = findMemberByName(memberFullName);
        getLogger().info("Verifying checkbox is disabled..");
        if (permissionToSelect) {

        } else {
            Boolean isDisplayed = validateDisPlayedElement(listDisableCheckboxTeamMember.get(index),"disable checkbox");
                    if(isDisplayed){
            NXGReports.addStep("Verify can " + (permissionToSelect ? "select member Checkbox " : "not select member Checkbox "), LogAs.PASSED, null);
        } else{
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify can " + (permissionToSelect ? "select member Checkbox " : "not select member Checkbox "), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
}
