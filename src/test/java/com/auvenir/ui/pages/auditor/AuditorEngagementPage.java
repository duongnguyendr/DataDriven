package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

import java.util.List;

public class AuditorEngagementPage extends AbstractPage {


    AuvenirPage auvenirPage = null;
    AuditorEngagementPage auditorEngagementPage = null;

    public AuditorEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(css = "img[class='header-auvenirLogo']")
    private WebElement eleAuvenirLogoImg;

    public WebElement getEleAuvenirLogoImg() {
        return eleAuvenirLogoImg;
    }

    @FindBy(xpath = "//span[text()='My Engagements']")
    private WebElement eleMyEngmntTxt;

    public WebElement getEleMyEngmntTxt() {
        return eleMyEngmntTxt;
    }

    @FindBy(id = "newAuditBtn")
    private WebElement eleCreateNewBtn;

    public WebElement getEleCreateNewBtn() {
        return eleCreateNewBtn;
    }

    @FindBy(id = "tooltip-createEngagement-mainText")
    private WebElement eleClickhereTipTxt;

    public WebElement getEleClickhereTipTxt() {
        return eleClickhereTipTxt;
    }

    @FindBy(className = "noEngagement-txt")
    private WebElement eleYouDontHaveTxt;

    public WebElement getEleYouDontHaveTxt() {
        return eleYouDontHaveTxt;
    }

    @FindBy(id = "dashboardUsername")
    private WebElement eleAuditorNameDrpDwn;

    public WebElement getEleAuditorNameDrpDwn() {
        return eleAuditorNameDrpDwn;
    }

    @FindBy(xpath = "//a[text()='Settings']")
    private WebElement eleSettingsLnk;

    public WebElement getEleSettingsLnk() {
        return eleSettingsLnk;
    }

    @FindBy(id = "h-ddl-signOut")
    private WebElement eleSignOutLnk;

    public WebElement getEleSignOutLnk() {
        return eleSignOutLnk;
    }

    @FindBy(id = "h-f-inbox-dropdown")
    private WebElement eleChatIcn;

    public WebElement getEleChatIcn() {
        return eleChatIcn;
    }

    @FindBy(xpath = "//div[@class='au-dropdown-trigger notification-trigger']")
    private WebElement eleNotificationIcn;

    public WebElement getEleNotificationIcn() {
        return eleNotificationIcn;
    }

    @FindBy(id = "h-engagementsLink")
    private WebElement eleEngagementLnk;

    public WebElement getEleEngagementLnk() {
        return eleEngagementLnk;
    }

    @FindBy(id = "h-clientListLink")
    private WebElement eleClientsLnk;

    public WebElement getEleClientsLnk() {
        return eleClientsLnk;
    }

    @FindBy(xpath = "//div[contains(@id,'progress-')]")
    private WebElement eleEngagementNameTxt;

    public WebElement getEleEngagementNameTxt() {
        return eleEngagementNameTxt;
    }

    @FindBy(xpath = "//p[contains(@id,'date-')]")
    private WebElement eleEngagementDateTxt;

    public WebElement getEleEngagementDateTxt() {
        return eleEngagementDateTxt;
    }

    @FindBy(xpath = "//img[contains(@id,'w-ei-bgimg-')]")
    private WebElement eleEngagementImg;

    public WebElement getEleEngagementImg() {
        return eleEngagementImg;
    }

    @FindBy(xpath = "//label[text()='Set schedule']")
    private WebElement eleSetScheduleLabel;

    public WebElement getEleSetScheduleLabel() {
        return eleSetScheduleLabel;
    }

    @FindBy(id = "c-header-title")
    private WebElement myEngagementTextEle;

    @FindBy(id = "h-clientListLink")
    private WebElement contactsLinkEle;

    @FindBy(id = "newAuditBtn")
    private WebElement newEngagementButtonEle;
    @FindBy(xpath = "//div[@id='cpa-main']/div")
    private List<WebElement> engagementListEle;

    @FindBy(xpath = "//button[contains(text(),'Add New')]")
    private WebElement eleAddNewBtn;

    public WebElement getEleAddNewBtn() {
        return eleAddNewBtn;
    }

    public void auditorPageHeaderContent() {
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        auvenirPage.toValidate(auditorEngagementPage.getEleAuvenirLogoImg(), "Auvenir Logo", "Displayed");
        auvenirPage.toValidate(auditorEngagementPage.getEleEngagementLnk(), "Engagement Link", "Displayed");
        auvenirPage.toValidate(auditorEngagementPage.getEleClientsLnk(), "Clients Link", "Displayed");
        auvenirPage.toValidate(auditorEngagementPage.getEleAuditorNameDrpDwn(), "Auditor Name Dropdown", "Displayed");
        auvenirPage.toValidate(auditorEngagementPage.getEleSettingsLnk(), "Dropdown Settings Link", "Displayed");
        auvenirPage.toValidate(auditorEngagementPage.getEleSignOutLnk(), "Dropdown SignOut Link", "Displayed");
        auvenirPage.toValidate(auditorEngagementPage.getEleChatIcn(), "Chat Icon", "Displayed");
        auvenirPage.toValidate(auditorEngagementPage.getEleNotificationIcn(), "Notification Icon", "Displayed");
    }

    public void verifyAuditorEngagementPage() {
        waitForVisibleElement(myEngagementTextEle, "myEngagementTextEle");
        validateElementText(myEngagementTextEle, "My Engagements");

    }

    public void navigateToContactsTab() {
        waitForClickableOfElement(contactsLinkEle, "contactsLinkEle");
        contactsLinkEle.click();

	}
	public void clickNewEnagementButton() {
		waitForVisibleElement(newEngagementButtonEle,"New Engagement Button");
		waitForClickableOfElement(newEngagementButtonEle,"New Engagement Button");
		newEngagementButtonEle.click();
	}
	public void viewEngagementDetailsPage(String engagementName) throws Exception{
		//current we cannot view engagement by name we test with first engagment
		hoverElement(engagementListEle.get(0).findElement(By.xpath(".//div/div/div[2]/div[2]/input")),engagementName);
		waitForClickableOfElement(engagementListEle.get(0).findElement(By.xpath(".//div/div/div[2]/div[2]/input")),engagementName);
		clickAndHold(engagementListEle.get(0).findElement(By.xpath(".//div/div/div[2]/div[2]/input")),engagementName);
	}
    public void enterEngagementDetailWithName(String engagementTitle, String engagementName) throws Exception {
        WebElement webElement = getDriver().findElement(By.xpath("//p[contains(text(),'" + engagementTitle + "')]/ancestor::div[@id='cpa-main']//input"));
        System.out.println("+++++++++++++++++++++++++++++  " + engagementTitle);
        //current we cannot view engagement by name we test with first engagment
        //TODO bug here, fix later
        hoverElement(webElement, engagementName);
        waitForClickableOfElement(webElement, engagementName);
        clickAndHold(webElement, engagementName);
    }
    public void viewEngagementDetailsPageWithName(String engagementName) throws Exception{
        String xpath = "//div[@id='cpa-main']/div//p[text()='%s']/parent::*/parent::div//div[@class='e-widget-content']//input";
        WebElement engagementEle = getDriver().findElement(By.xpath(String.format(xpath, engagementName)));
        hoverElement(engagementEle, engagementName);
        waitForClickableOfElement(engagementEle, engagementName);
        clickAndHold(engagementEle, engagementName);
    }
}