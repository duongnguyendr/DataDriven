package com.auvenir.ui.pages.auditor;

import java.util.List;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class AuditorDashboardPage extends AbstractPage {


    public AuditorDashboardPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }


    @FindBy(id = "h-clientListLink")
    private WebElement eleClientsLnk;

    public WebElement getEleClientsLnk() {
        return eleClientsLnk;
    }

    @FindBy(id = "engagement-invite-button")
    private WebElement eleInviteBtn;

    public WebElement getEleInviteBtn() {
        return eleInviteBtn;
    }

    @FindBy(id = "w-tm-tasksDropdownSelected")
    private WebElement eleTaskDrpDwn;

    public WebElement getEleTaskDrpDwn() {
        return eleTaskDrpDwn;
    }

    @FindBy(id = "w-mc-inviteBtn")
    private WebElement eleSelectClientBtn;

    public WebElement getEleSelectClientBtn() {
        return eleSelectClientBtn;
    }

    @FindBy(id = "taskSelectClientDivBtn")
    private WebElement eleSelectBtn;

    public WebElement getEleSelectBtn() {
        return eleSelectBtn;
    }

    @FindBy(id = "taskRequestsDivBtn")
    private WebElement eleSetBtn;

    public WebElement getEleSetBtn() {
        return eleSetBtn;
    }

    @FindBy(id = "engagement-archive-button")
    private WebElement eleArchiveBtn;

    public WebElement getEleArchiveBtn() {
        return eleArchiveBtn;
    }

    @FindBy(xpath = "//*[text()='My Clients']")
    private WebElement eleMyClientTxt;

    public WebElement getEleMyClientTxt() {
        return eleMyClientTxt;
    }

    @FindBy(className = "w-mc-profilePicture")
    private WebElement eleProfileImg;

    public WebElement getEleProfileImg() {
        return eleProfileImg;
    }

    @FindBy(xpath = "//p[text()='No Client Selected']")
    private WebElement eleNoClientTxt;

    public WebElement getEleNoClientTxt() {
        return eleNoClientTxt;
    }

    @FindBy(id = "w-as-title")
    private WebElement eleStatusTxt;

    public WebElement getEleStatusTxt() {
        return eleStatusTxt;
    }

    @FindBy(xpath = "//button[text()='Add New']")
    private WebElement eleAddNewBtn;

    public WebElement getEleAddNewBtn() {
        return eleAddNewBtn;
    }

    @FindBy(id = "engagementDashboardLink")
    private WebElement eleDashboardLnk;

    public WebElement getEleDashboardLnk() {
        return eleDashboardLnk;
    }

    @FindBy(id = "engagementRequestsLink")
    private WebElement eleRequestLnk;

    public WebElement getEleRequestLnk() {
        return eleRequestLnk;
    }

    @FindBy(id = "engagementFileMangerLink")
    private WebElement eleFilesLnk;

    public WebElement getEleFilesLnk() {
        return eleFilesLnk;
    }

    @FindBy(id = "engagementActivityLink")
    private WebElement eleActivityLnk;

    public WebElement getEleActivityLnk() {
        return eleActivityLnk;
    }

    @FindBy(id = "engagement-backButton")
    private WebElement eleEngagementBackBtn;

    public WebElement getEleEngagementBackBtn() {
        return eleEngagementBackBtn;
    }

    @FindBy(id = "a-header-title")
    private WebElement eleEngagementTitleTxt;

    public WebElement getEleEngagementTitleTxt() {
        return eleEngagementTitleTxt;
    }


    @FindBy(xpath = "//span[text()='Please']")
    private WebElement elePleaseTxt;

    public WebElement getElePleaseTxt() {
        return elePleaseTxt;
    }

    @FindBy(xpath = "//span[text()='Please']//..//span[@id='w-as-txtBtn']")
    private WebElement eleSetTxt;

    public WebElement getEleSetTxt() {
        return eleSetTxt;
    }

    @FindBy(xpath = "//span[text()='your client request list.']")
    private WebElement eleClientRqstTxt;

    public WebElement getEleClientRqstTxt() {
        return eleClientRqstTxt;
    }

    @FindBy(xpath = "//img[contains(@id,'w-mc-profilePicture-')]")
    private WebElement eleMyClientImg;

    public WebElement getEleMyClientImg() {
        return eleMyClientImg;
    }

    @FindBy(xpath = "//div[@class='archive-engagement-headerText']")
    private WebElement eleArchiveEngagementTxt;

    public WebElement getEleArchiveEngagementTxt() {
        return eleArchiveEngagementTxt;
    }

    @FindBy(xpath = "//img[@class='archive-engagement-fileContainer-icon']")
    private WebElement eleArchiveEngagementImg;

    public WebElement getEleArchiveEngagementImg() {
        return eleArchiveEngagementImg;
    }

    @FindBy(xpath = "//div[@class='archive-engagement-bodyText']")
    private WebElement eleYouWillNoTxt;

    public WebElement getEleYouWillNoTxt() {
        return eleYouWillNoTxt;
    }

    @FindBy(xpath = "//button[@class='btn archive-engagement-cancel-btn']")
    private WebElement eleCancelBtn;

    public WebElement getEleCancelBtn() {
        return eleCancelBtn;
    }

    @FindBy(xpath = "//button[@class='btn archive-engagement-yes-btn']")
    private WebElement eleYesBtn;

    public WebElement getEleYesBtn() {
        return eleYesBtn;
    }

    @FindBy(xpath = "//img[@src='images/icons/x-small.svg']")
    private WebElement eleCloseSmallIcn;

    public WebElement getEleCloseSmallIcn() {
        return eleCloseSmallIcn;
    }

    @FindBy(xpath = "//img[@class='inner-space tsk-p']")
    private List<WebElement> eleTaskFormTxts;

    public List<WebElement> getEleTaskFormTxts() {
        return eleTaskFormTxts;
    }

    @FindBy(xpath = "//h4[text()='Activity Feed']")
    private WebElement eleActivityFeedTxt;

    public WebElement getEleActivityFeedTxt() {
        return eleActivityFeedTxt;
    }

    @FindBy(className = "w-activity-date-text")
    private WebElement eleActivityDayTxt;

    public WebElement getEleActivityDayTxt() {
        return eleActivityDayTxt;
    }

    @FindBy(className = "w-activity-text")
    private WebElement eleYouCreatedTxt;

    public WebElement getEleYouCreatedTxt() {
        return eleYouCreatedTxt;
    }

}
