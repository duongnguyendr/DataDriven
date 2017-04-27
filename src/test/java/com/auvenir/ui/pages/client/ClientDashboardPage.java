package com.auvenir.ui.pages.client;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class ClientDashboardPage extends AbstractPage {
	AuvenirPage auvenirPage = null;
	private static final int waitTime= 60;
	public ClientDashboardPage(Logger logger,WebDriver driver)
	{
		super(logger,driver);
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
	}

	@FindBy(xpath = "//img[@class='header-auvenirLogo']")
	private WebElement eleAuvenirHeaderImg;
	public WebElement getEleAuvenirHeaderImg() {
		return eleAuvenirHeaderImg;
	}

	@FindBy(id ="h-dashboardLink")
	private WebElement eleDashboardLnk;
	public WebElement getEleDashboardLnk() {
		return eleDashboardLnk;
	}

	@FindBy(id = "h-requestLink")
	private WebElement eleRequestLnk;
	public WebElement getEleRequestLnk() {
		return eleRequestLnk;
	}

	@FindBy(xpath = "//*[@id='h-filesLink']")
	private WebElement eleFilesLnk;
	public WebElement getEleFilesLnk() {
		return eleFilesLnk;
	}

	@FindBy(xpath = "//span[@id='dashboardUsername'][@class='header-userName']")
	private WebElement eleDashboardUserNameTxt;
	public WebElement getEleDashboardUserNameTxt() {
		return eleDashboardUserNameTxt;
	}

	@FindBy(xpath = "//span[@id='dashboardUsername'][@class='header-userName']/../i")
	private WebElement eleDashboardUserNameIcn;
	public WebElement getEleDashboardUserNameIcn() {
		return eleDashboardUserNameIcn;
	}

	@FindBy(id = "dropdownEmptyPic")
	private WebElement eleUserInitialImg;
	public WebElement getEleUserInitialImg() {
		return eleUserInitialImg;
	}

	@FindBy(id = "dropdownPicInitials")
	private WebElement eleUserInitialTxt;
	public WebElement getEleUserInitialTxt() {
		return eleUserInitialTxt;
	}

	@FindBy(id = "dropdownUsername")
	private WebElement eleUserNameTxt;
	public WebElement getEleUserNameTxt() {
		return eleUserNameTxt;
	}

	@FindBy(xpath = "//a[text()='Settings']")
	private WebElement eleSettingsLnk;
	public WebElement getEleSettingsLnk() {
		return eleSettingsLnk;
	}

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement eleSignOutLnk;
	public WebElement getEleSignOutLnk() {
		return eleSignOutLnk;
	}

	@FindBy(xpath = "//div[@id='h-f-inbox-dropdown']")
	private WebElement eleInboxIcn;
	public WebElement getEleInboxIcn() {
		return eleInboxIcn;
	}

	@FindBy(xpath = "//div[contains(text(),'There are no emails')]")
	private WebElement eleThereAreNoEmailsTxt;
	public WebElement getEleThereAreNoEmailsTxt() {
		return eleThereAreNoEmailsTxt;
	}

	@FindBy(xpath = "//div[contains(text(),'View Messages')]")
	private WebElement eleViewMessagesTxt;
	public WebElement getEleViewMessagesTxt() {
		return eleViewMessagesTxt;
	}

	@FindBy(xpath = "//div[@class='au-dropdown-trigger notification-trigger']")
	private WebElement eleNotificationIcn;
	public WebElement getEleNotificationIcn() {
		return eleNotificationIcn;
	}

	@FindBy(xpath = "//div[contains(text(),'You have no new')]")
	private WebElement eleYouHaveNoNewNotificationTxt;
	public WebElement getEleYouHaveNoNewNotificationTxt() {
		return eleYouHaveNoNewNotificationTxt;
	}

	@FindBy(xpath = "//div[contains(text(),'View All')]")
	private WebElement eleViewAllTxt;
	public WebElement getEleViewAllTxt() {
		return eleViewAllTxt;
	}

	@FindBy(xpath = "//div[contains(text(),'My Messages')]")
	private WebElement eleMyMessagesTxt;
	public WebElement getEleMyMessagesTxt() {
		return eleMyMessagesTxt;
	}

	@FindBy(xpath = "//button[contains(text(),'New Message')]")
	private WebElement eleNewMessagesBtn;
	public WebElement getEleNewMessagesBtn() {
		return eleNewMessagesBtn;
	}

	@FindBy(xpath = "//div[@class='m-email-header']")
	private WebElement eleNewMessagesHeaderTxt;
	public WebElement getEleNewMessagesHeaderTxt() {
		return eleNewMessagesHeaderTxt;
	}

	@FindBy(xpath = "//img[@src='images/icons/close-x.svg']")
	private WebElement eleCloseImg;
	public WebElement getEleCloseImg() {
		return eleCloseImg;
	}

	@FindBy(xpath = "//label[text()='To:']")
	private WebElement eleToTxt;
	public WebElement getEleToTxt() {
		return eleToTxt;
	}

	@FindBy(xpath = "//label[text()='To:']//..//input")
	private WebElement eleTypeTheContactNameTxt;
	public WebElement getEleTypeTheContactNameTxt() {
		return eleTypeTheContactNameTxt;
	}

	@FindBy(xpath = "//label[text()='Subject:']")
	private WebElement eleSubjectTxt;
	public WebElement getEleSubjectTxt() {
		return eleSubjectTxt;
	}

	@FindBy(xpath = "//label[text()='Subject:']//..//input")
	private WebElement eleTypeTheMessageSubjectTxt;
	public WebElement getEleTypeTheMessageSubjectTxt() {
		return eleTypeTheMessageSubjectTxt;
	}

	@FindBy(xpath = "//img[@src='/images/illustrations/illustration-envelope-grey.svg']")
	private WebElement eleEmptyEmailImg;
	public WebElement getEleEmptyEmailImg() {
		return eleEmptyEmailImg;
	}

	@FindBy(xpath = "//div[contains(text(),'have any messages yet')]")
	private WebElement eleYouDontHaveAnyMessageTxt;
	public WebElement getEleYouDontHaveAnyMessageTxt() {
		return eleYouDontHaveAnyMessageTxt;
	}

	@FindBy(xpath = "//textarea[@placeholder='Type your message']")
	private WebElement eleTypeYourMessageTxt;
	public WebElement getEleTypeYourMessageTxt() {
		return eleTypeYourMessageTxt;
	}

	@FindBy(xpath = "//div[@class='m-email-footer']//button[contains(text(),'Send')]")
	private WebElement eleSendBtn;
	public WebElement getEleSendBtn() {
		return eleSendBtn;
	}

	@FindBy(xpath = "//div[@class='m-email-footer']//img")
	private WebElement eleAttachmentImg;
	public WebElement getEleAttachmentImg() {
		return eleAttachmentImg;
	}

	@FindBy(xpath = "//span[@id='callToActionPicInitials']")
	private WebElement eleProfileInitialsTxt;
	public WebElement getEleProfileInitialsTxt() {
		return eleProfileInitialsTxt;
	}

	@FindBy(xpath = "//p[contains(text(),'Welcome to your Dashboard')]")
	private WebElement eleWelcomeToYourDashboardTxt;
	public WebElement getEleWelcomeToYourDashboardTxt() {
		return eleWelcomeToYourDashboardTxt;
	}

	@FindBy(xpath = "//p[contains(text(),'Please complete')]")
	private WebElement elePleaseCompleteTxt;
	public WebElement getElePleaseCompleteTxt() {
		return elePleaseCompleteTxt;
	}

	@FindBy(xpath = "//button[contains(text(),'View Requests')]")
	private WebElement eleViewRequestsBtn;
	public WebElement getEleViewRequestsBtn() {
		return eleViewRequestsBtn;
	}

	@FindBy(xpath = "//h4[contains(text(),'My Auditor')]")
	private WebElement eleMyAuditorTxt;
	public WebElement getEleMyAuditorTxt() {
		return eleMyAuditorTxt;
	}

	@FindBy(xpath = "//img[@id='auditorWidgetPhoto']")
	private WebElement eleAuditorImg;
	public WebElement getEleAuditorImg() {
		return eleAuditorImg;
	}

	@FindBy(id="h-ddl-item-settings")
	WebElement settingsTabEle;
	public WebElement getSettingTabEle(){
		return settingsTabEle;
	}

	@FindBy(xpath = "//p[@id='auditorWidgetFullName']")
	private WebElement eleAuditorFullNameTxt;
	public WebElement getEleAuditorFullNameTxt() {
		return eleAuditorFullNameTxt;
	}

	@FindBy(xpath = "//span[contains(text(),'Send a Message')]")
	private WebElement eleSendAMessageTxt;
	public WebElement getEleSendAMessageTxt() {
		return eleSendAMessageTxt;
	}

	@FindBy(xpath = "//h4[contains(text(),'Activity Feed')]")
	private WebElement eleActivityFeedTxt;
	public WebElement getEleActivityFeedTxt() {
		return eleActivityFeedTxt;
	}

	@FindBy(xpath = "//div[@class='w-activity-date-text']")
	private WebElement eleCreationDateTxt;
	public WebElement getEleCreationDateTxt() {
		return eleCreationDateTxt;
	}

	@FindBy(xpath = "//span[@class='w-activity-border-circle']")
	private WebElement eleCircleBulletinImg;
	public WebElement getEleCircleBulletinImg() {
		return eleCircleBulletinImg;
	}

	@FindBy(xpath = "//span[@class='icon auvicon-line-clock w-activity-timeStampIcon']")
	private WebElement eleTimeStampImg;
	public WebElement getEleTimeStampImg() {
		return eleTimeStampImg;
	}

	@FindBy(xpath = "//div[@class='w-activity-timeStampText']")
	private WebElement eleTimeStampTxt;
	public WebElement getEleTimeStampTxt() {
		return eleTimeStampTxt;
	}
	@FindBy(xpath = "//span[contains(text(),'In Progress')]")
	WebElement inProgressText;
	public  WebElement getInProgressText(){
		return inProgressText;
	}
	@FindBy(id="clientDashboardLink")
	private WebElement inProgressTab;
	public WebElement getInProgressTab(){
		return inProgressTab;
	}
	@FindBy(id="clientCompletedLink")
	WebElement completedTabEle;
	public WebElement getCompletedTabEle(){return completedTabEle;}

	@FindBy(xpath = "//h3[contains(text(),'Dernière mise à jour : le 16 janvier, 2017')]")
	private WebElement privacyFrenchLastRevisedTextEle;

	@FindBy(xpath = "//h3[contains(text(),'Dernière mise à jour: le 16 Janvier, 2017')]")
	private WebElement cookiesNotesLastRevisedTextEle;


	@FindBy(xpath = "//div[@class='w-activity-profileEmpty']")
	private WebElement eleActivityProfileInitialsTxt;
	public WebElement getEleActivityProfileInitialsTxt() {
		return eleActivityProfileInitialsTxt;
	}

	@FindBy(xpath = "//div[contains(text(),'joined to the')]//..//span[contains(text(),'You')]")
	private WebElement eleYouTxt;
	public WebElement getEleYouTxt() {
		return eleYouTxt;
	}

	@FindBy(xpath = "//div[contains(text(),'joined to the')]")
	private WebElement eleJoinedToTheTxt;
	public WebElement getEleJoinedToTheTxt() {
		return eleJoinedToTheTxt;
	}

	@FindBy(xpath = "//span[contains(text(),'Untitled')]")
	private WebElement eleUntitledTxt;
	public WebElement getEleUntitledTxt() {
		return eleUntitledTxt;
	}

	@FindBy(xpath = "//span[contains(text(),'© 2017 Auvenir Inc')]")
	private WebElement eleAuvenirIncTxt;
	public WebElement getEleAuvenirIncTxt() {
		return eleAuvenirIncTxt;
	}

	@FindBy(xpath = "//span[contains(text(),'© 2017 Auvenir Inc')]//..//..//a[contains(text(),'Terms of Service')]")
	private WebElement eleTermsOfServiceLnk;
	public WebElement getEleTermsOfServiceLnk() {
		return eleTermsOfServiceLnk;
	}
	@FindBy(xpath = "//h3[contains(text(),'Last revised: January 16th, 2017')]")
	private WebElement privacyEnglishLastRevisedTextEle;

	@FindBy(xpath = "(//span[contains(text(),'© 2017 Auvenir Inc')]//..//..//a[contains(text(),'.')])[last()-1]")
	private WebElement eleTermsOfServiceDotTxt;
	@FindBy(xpath = "//span[@class='custom-close']")
	private WebElement termsOfServicePageCloseButton;

	public WebElement getEleTermsOfServiceDotTxt() {
		return eleTermsOfServiceDotTxt;
	}

	@FindBy(id = "privacy")
	private WebElement elePrivacyStatementLnk;
	public WebElement getElePrivacyStatementLnk() {
		return elePrivacyStatementLnk;
	}

	@FindBy(xpath = "(//span[contains(text(),'© 2017 Auvenir Inc')]//..//..//a[contains(text(),'.')])[last()]")
	private WebElement elePrivacyStatementDotTxt;
	public WebElement getElePrivacyStatementDotTxt() {
		return elePrivacyStatementDotTxt;
	}

	@FindBy(id = "cookies")
	private WebElement eleCookieNoticeLnk;
	public WebElement getEleCookieNoticeLnk() {
		return eleCookieNoticeLnk;
	}

	@FindBy(id = "english")
	private WebElement englishLinkEle;

	@FindBy(id = "french")
	private WebElement frenchLinkEle;
	@FindBy(xpath = "//h3[contains(text(),'Effective: 16th January, 2017')]")
	private WebElement termsEnglishDateEle;

	@FindBy(xpath = "//h3[contains(text(),'Prise d’effet : le 16 janvier, 2017')]")
	private WebElement termFrenchDateEle;

	//@FindBy(xpath = "//h3[@class='custom-modal-title']")
	@FindBy(xpath = "//h3[contains(text(),'Terms of Service')]")
	private WebElement termsOfServiceTextEle;

	//@FindBy(xpath = "//h3[@class='custom-modal-header']")
	@FindBy(xpath = "//div[@id='custom-modal-content']//h3[contains(text(),'Auvenir')]")
	private WebElement auvenirTextEle;

	@FindBy(id="dashboardUsername")
	private WebElement dashboardUserNameEle;
	public WebElement getDashboardUserNameEle(){
		return getDashboardUserNameEle();
	}

	public void verifyClientFooter()
	{
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		auvenirPage.toValidate(getEleAuvenirIncTxt(),"Auvenir Inc Text", "Displayed");
		auvenirPage.toValidate(getEleTermsOfServiceLnk(),"Terms Of Service Link", "Displayed");
		auvenirPage.toValidate(getEleTermsOfServiceDotTxt(),"Terms Of Service Dot Text", "Displayed");
		auvenirPage.toValidate(getElePrivacyStatementLnk(),"Privacy Statement Link", "Displayed");
		auvenirPage.toValidate(getElePrivacyStatementDotTxt(),"Privacy Statement Dot Text", "Displayed");
		auvenirPage.toValidate(getEleCookieNoticeLnk(),"Cookie Notice Link", "Displayed");
	}

	public void verifyClientHeader()
	{
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		auvenirPage.toValidate(getEleAuvenirHeaderImg(),"Auvenir Header Image", "Displayed");
		auvenirPage.toValidate(getEleDashboardLnk(),"Dashboard Link", "Displayed");
		auvenirPage.toValidate(getEleRequestLnk(),"Request Link", "Displayed");
		auvenirPage.toValidate(getEleFilesLnk(),"Files Link", "Displayed");
		auvenirPage.toValidate(getEleDashboardUserNameTxt(),"Dashboard UserName Text", "Displayed");
		auvenirPage.toValidate(getEleDashboardUserNameIcn(),"Dashboard UserName Icon", "Displayed");
		getEleDashboardUserNameIcn().click();
		auvenirPage.toValidate(getEleUserInitialImg(),"User Initial Image", "Displayed");
		auvenirPage.toValidate(getEleUserInitialTxt(),"User Initial Text", "Displayed");
		auvenirPage.toValidate(getEleUserNameTxt(),"User Name Text", "Displayed");
		auvenirPage.toValidate(getEleSettingsLnk(),"Settings Link", "Displayed");
		auvenirPage.toValidate(getEleSignOutLnk(),"Sign Out Link", "Displayed");
		auvenirPage.toValidate(getEleInboxIcn(),"Inbox Icon", "Displayed");
		getEleInboxIcn().click();
		auvenirPage.toValidate(getEleThereAreNoEmailsTxt(),"There Are No Emails Text", "Displayed");
		auvenirPage.toValidate(getEleViewMessagesTxt(),"View Messages Text", "Displayed");
		auvenirPage.toValidate(getEleMyMessagesTxt(),"My Messages Text", "Displayed");
		auvenirPage.toValidate(getEleNewMessagesBtn(),"New Messages Button", "Displayed");
		auvenirPage.toValidate(getEleNotificationIcn(),"Notification Icon", "Displayed");
		getEleNotificationIcn().click();
		auvenirPage.toValidate(getEleYouHaveNoNewNotificationTxt(),"You Have No New Notification Text", "Displayed");
		auvenirPage.toValidate(getEleViewAllTxt(),"View All Text", "Displayed");

	}

	public void clickAuvenirLogo() {
		getLogger().info("Click Auvenir header button.");

	}

	public void navigateToInProgressTab() {
		inProgressTab.click();
	}

	public void navigateToCompletedTab() {
		WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
		wait.until(ExpectedConditions.visibilityOf(completedTabEle));
		completedTabEle.click();
	}

	public void navigateToClientSettingsPage() {
		dashboardUserNameEle.click();
		waitForSettingsTab();
		settingsTabEle.click();
	}

	private void waitForSettingsTab() {
		WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Settings')]")));
	}

	public void verifyTermsOfServiceLink() throws AWTException{
		getLogger().info("Verify Terms of service link.");
		eleTermsOfServiceLnk.click();
		waitForVisibleOfLocator(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
		getLogger().info("verify texts are rendered.");

		WebElement terms = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-title']"));
		validateElementText(terms,"Terms of Service");
		WebElement english = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='english']"));
		validateElementText(english,"English");
		WebElement french = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='french']"));
		validateElementText(french,"French");
		WebElement termsDate = getDriver().findElement(By.xpath("//div[@id='custom-modal']//div[@id='agreement']/h3"));
		validateElementText(termsDate,"Effective: 16th January, 2017");
		french.click();
		getLogger().info("click close Terms of Service wizard.");
		getDriver().findElement(By.xpath("//div[@id='custom-modal']//span[@class='custom-close']")).click();

	}



	public void verifyPrivacyStateLink() {
		getLogger().info("Verify Pricacy statement link.");
		elePrivacyStatementLnk.click();
		waitForVisibleOfLocator(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
		WebElement auvenir = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
		validateElementText(auvenir,"Auvenir");
		WebElement terms = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-title']"));
		validateElementText(terms,"Privacy Statement");
		WebElement english = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='english']"));
		validateElementText(english,"English");
		WebElement french = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='french']"));
		validateElementText(french,"French");
		WebElement termsDate = getDriver().findElement(By.xpath("//div[@id='custom-modal']//div[@id='agreement']/h3"));
		validateElementText(termsDate,"Last revised: January 16th, 2017");
		french.click();
		getDriver().findElement(By.xpath("//div[@id='custom-modal']//span[@class='custom-close']")).click();

	}

	public void verifyCookieNotice() {
		getLogger().info("verify cookie notices page.");
		eleCookieNoticeLnk.click();
		waitForVisibleOfLocator(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
		WebElement auvenir = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
		validateElementText(auvenir,"Auvenir");
		WebElement terms = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-title']"));
		validateElementText(terms,"Cookie Notice");
		WebElement english = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='english']"));
		validateElementText(english,"English");
		WebElement french = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='french']"));
		validateElementText(french,"French");
		WebElement termsDate = getDriver().findElement(By.xpath("//div[@id='custom-modal']//div[@id='agreement']/h3"));
		validateElementText(termsDate,"Last revised: January 16th, 2017");
		french.click();
		getDriver().findElement(By.xpath("//div[@id='custom-modal']//span[@class='custom-close']")).click();

	}
}
