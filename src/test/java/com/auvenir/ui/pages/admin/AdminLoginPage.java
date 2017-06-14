package com.auvenir.ui.pages.admin;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GeneralUtilities;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.apache.log4j.Logger;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//import org.testng.log4testng.Logger;

public class AdminLoginPage extends AbstractPage {

    AuvenirPage auvenirPage = null;
    WebElement SelectStatus = null;
    private int waitTime = 60;

    public AdminLoginPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    //@FindBy(xpath = "//span[@id='pageHeadBackText']")
    @FindBy(id = "pageHeadBackText")
    private WebElement eleAdminHdrTxt;

    public WebElement getEleAdminHdrTxt() {
        return eleAdminHdrTxt;
    }

    @FindBy(xpath = "//button[text()='View Credentials']")
    private WebElement eleViewCredentialsBtn;

    public WebElement getEleViewCredentialsBtn() {
        return eleViewCredentialsBtn;
    }

    @FindBy(xpath = "//p[text()='Auvenir Users']//..//h3")
    private WebElement eleAuvenirUserCountTxt;

    public WebElement getEleAuvenirUserCountTxt() {
        return eleAuvenirUserCountTxt;
    }

    @FindBy(xpath = "//p[text()='Auvenir Users']")
    private WebElement eleAuvenirUserTxt;

    public WebElement getEleAuvenirUserTxt() {
        return eleAuvenirUserTxt;
    }

    @FindBy(xpath = "//p[text()='Auvenir Users']//..//i")
    private WebElement eleAuvenirUserImg;

    public WebElement getEleAuvenirUserImg() {
        return eleAuvenirUserImg;
    }

    @FindBy(xpath = "//p[text()='Auditors']//..//h3")
    private WebElement eleAuditorsCountTxt;

    public WebElement getEleAuditorsCountTxt() {
        return eleAuditorsCountTxt;
    }

    @FindBy(xpath = "//p[text()='Auditors']")
    private WebElement eleAuditorsTxt;

    public WebElement getEleAuditorsTxt() {
        return eleAuditorsTxt;
    }

    @FindBy(xpath = "//p[text()='Auditors']//..//i")
    private WebElement eleAuditorsImg;

    public WebElement getEleAuditorsImg() {
        return eleAuditorsImg;
    }

    @FindBy(xpath = "//p[text()='Businesses']//..//h3")
    private WebElement eleBusinessesCountTxt;

    public WebElement getEleBusinessesCountTxt() {
        return eleBusinessesCountTxt;
    }

    @FindBy(xpath = "//p[text()='Businesses']")
    private WebElement eleBusinessesTxt;

    public WebElement getEleBusinessesTxt() {
        return eleBusinessesTxt;
    }

    @FindBy(xpath = "//p[text()='Businesses']//..//i")
    private WebElement eleBusinessesImg;

    public WebElement getEleBusinessesImg() {
        return eleBusinessesImg;
    }

    @FindBy(xpath = "//p[text()='Engagements']//..//h3")
    private WebElement eleEngagementsCountTxt;

    public WebElement getEleEngagementsCountTxt() {
        return eleEngagementsCountTxt;
    }

    @FindBy(xpath = "//p[text()='Engagements']")
    private WebElement eleEngagementsTxt;

    public WebElement getEleEngagementsTxt() {
        return eleEngagementsTxt;
    }

    @FindBy(xpath = "//p[text()='Engagements']//..//i")
    private WebElement eleEngagementsImg;

    public WebElement getEleEngagementsImg() {
        return eleEngagementsImg;
    }

    @FindBy(xpath = "//td[text()='Name']")
    private WebElement eleNameTxt;

    public WebElement getEleNameTxt() {
        return eleNameTxt;
    }

    @FindBy(xpath = "//td[text()='User Type']")
    private WebElement eleUserTypeTxt;

    public WebElement getEleUserTypeTxt() {
        return eleUserTypeTxt;
    }

    @FindBy(xpath = "//td[text()='Email']")
    private WebElement eleEmailTxt;

    public WebElement getEleEmailTxt() {
        return eleEmailTxt;
    }

    @FindBy(xpath = "//td[text()='Date Created']")
    private WebElement eleDateCreatedTxt;

    public WebElement getEleDateCreatedTxt() {
        return eleDateCreatedTxt;
    }

    @FindBy(xpath = "//td[text()='Auvenir Rep']")
    private WebElement eleAuvenirRepTxt;

    public WebElement getEleAuvenirRepTxt() {
        return eleAuvenirRepTxt;
    }

    @FindBy(xpath = "//td[text()='Current CPA']")
    private WebElement eleCurrentCPATxt;

    public WebElement getEleCurrentCPATxt() {
        return eleCurrentCPATxt;
    }

    @FindBy(xpath = "//td[text()='Status']")
    private WebElement eleStatusTxt;

    public WebElement getEleStatusTxt() {
        return eleStatusTxt;
    }

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement eleStatusConfirmBtn;

    public WebElement getEleStatusConfirmBtn() {
        return eleStatusConfirmBtn;
    }


    @FindBy(xpath = "//img[@src='images/icons/x-small.svg']")
    private WebElement eleVerifyAuditorSuccessFullyBtn;

    public WebElement getEleVerifyAuditorSuccessFullyBtn() {
        return eleVerifyAuditorSuccessFullyBtn;
    }

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement eleConfirmBtn;

    public WebElement getEleConfirmBtn() {
        return eleConfirmBtn;
    }

    @FindBy(xpath = "//p[text()='PENDING to ONBOARDING']")
    private WebElement elePENDINGtoONBOARDINGTxt;

    public WebElement getElePENDINGtoONBOARDINGTxt() {
        return elePENDINGtoONBOARDINGTxt;
    }

    @FindBy(xpath = "//p[text()='WAIT-LIST to ONBOARDING']")
    private WebElement eleWAITLISTtoONBOARDINGTxt;

    public WebElement getEleWAITLISTtoONBOARDINGTxt() {
        return eleWAITLISTtoONBOARDINGTxt;
    }

    @FindBy(xpath = "//p[text()='ONBOARDING to ACTIVE']")
    private WebElement eleONBOARDINGtoACTIVETxt;

    public WebElement getEleONBOARDINGtoACTIVETxt() {
        return eleONBOARDINGtoACTIVETxt;
    }

    @FindBy(xpath = "//div[@id='msgContainer']/p/div[contains(text(),'Updated')]")
    private WebElement eleUpdatedtoACTIVETxt;

    public WebElement getEleUpdatedtoACTIVETxt() {
        return eleUpdatedtoACTIVETxt;
    }

    @FindBy(id = "msgText-vyeaMOlY")
    private WebElement elePENDINGcanINVITEDTxt;

    public WebElement getElePENDINGcanINVITEDTxt() {
        return elePENDINGcanINVITEDTxt;
    }

    @FindBy(id = "msgText-iP3tMBkM")
    private WebElement eleUsercannotACTIVETxt;

    public WebElement getEleUsercannotACTIVETxt() {
        return eleUsercannotACTIVETxt;
    }


    @FindBy(xpath = "//div[@class='au-modal-container modalTransition-popUp-container']/img[@class='au-modal-closeBtn']")
    private WebElement eleCredentialsCloseIcn;

    public WebElement getEleCredentialsCloseIcn() {
        return eleCredentialsCloseIcn;
    }

    @FindBy(xpath = "//div[@class='au-modal-container modalTransition-popUp-container']/img")
    private WebElement eleCloseIcn;

    public WebElement getEleCloseIcn() {
        return eleCloseIcn;
    }

    @FindBy(xpath = "//div[@class='au-modal-container au-modal-fullScreen modalTransition-fp-container']/img")
    private WebElement elePopupCloseIcn;

    public WebElement getElePopupCloseIcn() {
        return elePopupCloseIcn;
    }

    @FindBy(xpath = "//img[@src='images/icons/close-x.svg']")
    private WebElement eleMailCloseIcn;

    public WebElement getEleMailCloseIcn() {
        return eleMailCloseIcn;
    }

    @FindBy(xpath = "//xhtml:pre")
    private WebElement eleDeletedTxt;

    public WebElement getEleDeletedTxt() {
        return eleDeletedTxt;
    }

    @FindBy(xpath = "//b[text()='Auth ID:']")
    private WebElement eleAuthIDTxt;

    public WebElement getEleAuthIDTxt() {
        return eleAuthIDTxt;
    }

    @FindBy(xpath = "//b[text()='API Key:']")
    private WebElement eleAPIKeyTxt;

    public WebElement getEleAPIKeyTxt() {
        return eleAPIKeyTxt;
    }

    @FindBy(className = "inbox-view-messages")
    private WebElement eleViewMessagesBtn;

    public WebElement getEleViewMessagesBtn() {
        return eleViewMessagesBtn;
    }

    @FindBy(xpath = "//div[contains(text(),'There are no emails')]")
    private WebElement eleThereNoEmailsTxt;

    public WebElement getEleThereNoEmailsTxt() {
        return eleThereNoEmailsTxt;
    }

    @FindBy(className = "inbox-header-default-title")
    private WebElement eleMyMessagesTxt;

    public WebElement getEleMyMessagesTxt() {
        return eleMyMessagesTxt;
    }

    @FindBy(xpath = "//button[text()='New Message']")
    private WebElement eleNewMessageBtn;

    public WebElement getEleNewMessageBtn() {
        return eleNewMessageBtn;
    }

    @FindBy(className = "m-email-header")
    private WebElement eleNewMessageTxt;

    public WebElement getEleNewMessageTxt() {
        return eleNewMessageTxt;
    }

    @FindBy(xpath = "//div[@class='m-email-header']//img")
    private WebElement eleNewMsgCloseIcn;

    public WebElement getEleNewMsgCloseIcn() {
        return eleNewMsgCloseIcn;
    }

    @FindBy(xpath = "//label[text()='To:']")
    private WebElement eleEmailToTxt;

    public WebElement getEleEmailToTxt() {
        return eleEmailToTxt;
    }

    @FindBy(xpath = "//li[@class='search-field']/input[@type='text']")
    private WebElement eleEmailToTxtFld;

    public WebElement getEleEmailToTxtFld() {
        return eleEmailToTxtFld;
    }

    @FindBy(xpath = "//label[text()='Subject:']")
    private WebElement eleSubjectTxt;

    public WebElement getEleSubjectTxt() {
        return eleSubjectTxt;
    }

    @FindBy(id = "m-email-subjectInput")
    private WebElement eleSubjectTxtFld;

    public WebElement getEleSubjectTxtFld() {
        return eleSubjectTxtFld;
    }

    @FindBy(id = "m-email-bodyText")
    private WebElement eleEmailBodyTxtFld;

    public WebElement getEleEmailBodyTxtFld() {
        return eleEmailBodyTxtFld;
    }

    @FindBy(xpath = "//button[text()='Send']")
    private WebElement eleSendBtn;

    public WebElement getEleSendBtn() {
        return eleSendBtn;
    }

    @FindBy(id = "m-email-fileUpload")
    private WebElement eleAttachmentIcn;

    public WebElement getEleAttachmentIcn() {
        return eleAttachmentIcn;
    }

    @FindBy(xpath = "//div[@id='inbox-empty']//img")
    private WebElement eleInboxMsgImg;

    public WebElement getEleInboxMsgImg() {
        return eleInboxMsgImg;
    }

    @FindBy(className = "inbox-empty-text")
    private WebElement eleYouDontHaveTxt;

    public WebElement getEleYouDontHaveTxt() {
        return eleYouDontHaveTxt;
    }

    @FindBy(xpath = "//div[@class='notification-content notification-noContent']")
    private WebElement eleYouHaveNoNotificationTxt;

    public WebElement getEleYouHaveNoNotificationTxt() {
        return eleYouHaveNoNotificationTxt;
    }

    @FindBy(xpath = "//div[text()='View All']")
    private WebElement eleViewAllLnk;

    public WebElement getEleViewAllLnk() {
        return eleViewAllLnk;
    }

    @FindBy(xpath = "//h4[text()='My Notifications']")
    private WebElement eleMyNotificationsTxt;

    public WebElement getEleMyNotificationsTxt() {
        return eleMyNotificationsTxt;
    }

    @FindBy(xpath = "//i[@class='icon auvicon-notifications']")
    private WebElement eleNotificationsIcn;

    public WebElement getEleNotificationsIcn() {
        return eleNotificationsIcn;
    }

    @FindBy(className = "notification-noNoti-text")
    private WebElement eleYouDontHaveNotificationTxt;

    public WebElement getEleYouDontHaveNotificationTxt() {
        return eleYouDontHaveNotificationTxt;
    }

    @FindBy(className = "notification-noNoti-link")
    private WebElement eleClickHereLnk;

    public WebElement getEleClickHereLnk() {
        return eleClickHereLnk;
    }

    @FindBy(id = "navTitle")
    private WebElement eleSettingsTxt;

    public WebElement getEleSettingsTxt() {
        return eleSettingsTxt;
    }

    @FindBy(id = "titleContent")
    private WebElement eleAccountSettingsTxt;

    public WebElement getEleAccountSettingsTxt() {
        return eleAccountSettingsTxt;
    }

    @FindBy(id = "link-setting-account")
    private WebElement eleAccountLnk;

    public WebElement getEleAccountLnk() {
        return eleAccountLnk;
    }

    @FindBy(id = "fullNameLabel")
    private WebElement eleFirstLastNameTxt;

    public WebElement getEleFirstLastNameTxt() {
        return eleFirstLastNameTxt;
    }

    @FindBy(id = "acc-ay-fullName")
    private WebElement eleFirstLastNameTxtFld;

    public WebElement getEleFirstLastNameTxtFld() {
        return eleFirstLastNameTxtFld;
    }

    @FindBy(id = "emailLabel")
    private WebElement eleEmailAddressTxt;

    public WebElement getEleEmailAddressTxt() {
        return eleEmailAddressTxt;
    }

    @FindBy(id = "acc-ay-email")
    private WebElement eleEmailAddressTxtFld;

    public WebElement getEleEmailAddressTxtFld() {
        return eleEmailAddressTxtFld;
    }

    @FindBy(id = "phoneLabel")
    private WebElement elePhomeNumberTxt;

    public WebElement getElePhomeNumberTxt() {
        return elePhomeNumberTxt;
    }

    @FindBy(id = "acc-ay-phone")
    private WebElement elePhoneNumberTxtFld;

    public WebElement getElePhoneNumberTxtFld() {
        return elePhoneNumberTxtFld;
    }

    @FindBy(id = "acc-ay-photo")
    private WebElement elePhotoImg;

    public WebElement getElePhotoImg() {
        return elePhotoImg;
    }

    @FindBy(id = "uploadButtonLabel")
    private WebElement eleYourPhotoTxt;

    public WebElement getEleYourPhotoTxt() {
        return eleYourPhotoTxt;
    }

    @FindBy(id = "uploadButton")
    private WebElement eleUpdateBtn;

    public WebElement getEleUpdateBtn() {
        return eleUpdateBtn;
    }

    @FindBy(xpath = "//button[text()='Deactivate My Account']")
    private WebElement eleDeactivateLnk;

    public WebElement getEleDeactivateLnk() {
        return eleDeactivateLnk;
    }

    @FindBy(xpath = "//label[text()='Deactivate Account']")
    private WebElement eleDeactivatAccTxt;

    public WebElement getEleDeactivatAccTxt() {
        return eleDeactivatAccTxt;
    }

    @FindBy(className = "au-modal-title-icon")
    private WebElement eleAlertIcn;

    public WebElement getEleAlertIcn() {
        return eleAlertIcn;
    }

    @FindBy(id = "deactivateAccountText")
    private WebElement eleYouareAboutTxt;

    public WebElement getEleYouareAboutTxt() {
        return eleYouareAboutTxt;
    }

    @FindBy(xpath = "//*[text()='Cancel']")
    private WebElement eleCancelBtn;

    public WebElement getEleCancelBtn() {
        return eleCancelBtn;
    }

    @FindBy(xpath = "//input[@value='Deactivate']")
    private WebElement eleDeactivateBtn;

    public WebElement getEleDeactivateBtn() {
        return eleDeactivateBtn;
    }

    @FindBy(id = "link-setting-device")
    private WebElement eleDevicesLnk;

    public WebElement getEleDevicesLnk() {
        return eleDevicesLnk;
    }

    @FindBy(className = "card-account-title")
    private WebElement eleMyDevicesTxt;

    public WebElement getEleMyDevicesTxt() {
        return eleMyDevicesTxt;
    }

    @FindBy(id = "pNumDevices")
    private WebElement eleYouRegisteredTxt;

    public WebElement getEleYouRegisteredTxt() {
        return eleYouRegisteredTxt;
    }

    @FindBy(className = "c-devices-deviceImg")
    private WebElement eleDeviceImg;

    public WebElement getEleDeviceImg() {
        return eleDeviceImg;
    }

    @FindBy(className = "c-devices-deviceCustomName")
    private WebElement eleDeviceCustomerNmTxt;

    public WebElement getEleDeviceCustomerNmTxt() {
        return eleDeviceCustomerNmTxt;
    }

    @FindBy(className = "c-devices-deviceName")
    private WebElement eleDeviceNameTxt;

    public WebElement getEleDeviceNameTxt() {
        return eleDeviceNameTxt;
    }

    @FindBy(xpath = "//button[text()='View']")
    private WebElement eleViewBtn;

    public WebElement getEleViewBtn() {
        return eleViewBtn;
    }

    @FindBy(xpath = "//div[@class='au-modal-title']/label")
    private WebElement eleCustomerNameTxt;

    public WebElement getEleCustomerNameTxt() {
        return eleCustomerNameTxt;
    }

    @FindBy(className = "c-devices-deviceViewImg")
    private WebElement eleDeviceViewImg;

    public WebElement getEleDeviceViewImg() {
        return eleDeviceViewImg;
    }

    @FindBy(xpath = "//button[text()='Disconnect Device']")
    private WebElement eleDisconnectDeviceBtn;

    public WebElement getEleDisconnectDeviceBtn() {
        return eleDisconnectDeviceBtn;
    }

    @FindBy(xpath = "//div[text()='Disconnect this device?']")
    private WebElement eleDisconnectthisDeviceTxt;

    public WebElement getEleDisconnectthisDeviceTxt() {
        return eleDisconnectthisDeviceTxt;
    }

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement eleCancelDisconnectBtn;

    public WebElement getEleCancelDisconnectBtn() {
        return eleCancelDisconnectBtn;
    }

    @FindBy(xpath = "//button[text()='Disconnect']")
    private WebElement eleDisconnectBtn;

    public WebElement getEleDisconnectBtn() {
        return eleDisconnectBtn;
    }

    @FindBy(xpath = "//td[text()='Device:']")
    private WebElement eleDeviceTxt;

    public WebElement getEleDeviceTxt() {
        return eleDeviceTxt;
    }

    @FindBy(xpath = "//td[text()='OS: ']")
    private WebElement eleOSTxt;

    public WebElement getEleOSTxt() {
        return eleOSTxt;
    }

    @FindBy(xpath = "//td[text()='Browser: ']")
    private WebElement eleBrowserTxt;

    public WebElement getEleBrowserTxt() {
        return eleBrowserTxt;
    }

    @FindBy(xpath = "//td[text()='Last Used: ']")
    private WebElement eleLastUsedTxt;

    public WebElement getEleLastUsedTxt() {
        return eleLastUsedTxt;
    }


    @FindBy(xpath = "//button[text()='+ Add Another']")
    private WebElement eleAddAnotherLnk;

    public WebElement getEleAddAnotherLnk() {
        return eleAddAnotherLnk;
    }

    @FindBy(id = "component-title")
    private WebElement eleRegisterDeviceTxt;

    public WebElement getEleRegisterDeviceTxt() {
        return eleRegisterDeviceTxt;
    }

    @FindBy(id = "component-description")
    private WebElement eleDownloadAuvenirTxt;

    public WebElement getEleDownloadAuvenirTxt() {
        return eleDownloadAuvenirTxt;
    }

    @FindBy(id = "smsInputBox")
    private WebElement eleTextMeTxtFld;

    public WebElement getEleTextMeTxtFld() {
        return eleTextMeTxtFld;
    }

    @FindBy(id = "smsSendBtn")
    private WebElement eleTextMeBtn;

    public WebElement getEleTextMeBtn() {
        return eleTextMeBtn;
    }

    @FindBy(className = "register-mb-img")
    private WebElement eleRegisterMobileImg;

    public WebElement getEleRegisterMobileImg() {
        return eleRegisterMobileImg;
    }

    @FindBy(xpath = "//img[@src='images/components/applestore.png']")
    private WebElement eleDownloadAppStoreImg;

    public WebElement getEleDownloadAppStoreImg() {
        return eleDownloadAppStoreImg;
    }

    @FindBy(xpath = "//img[@src='images/components/googlestore.png']")
    private WebElement eleGetItGooglePlayImg;

    public WebElement getEleGetItGooglePlayImg() {
        return eleGetItGooglePlayImg;
    }


    public void getEleClientEntryValidate(String UserType, String Email, String DateCreated, String ClientName) throws InterruptedException {
        Thread.sleep(10000);
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        WebElement getEleClientTxt = getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + UserType + "')]"));
        validateDisPlayedElement(getEleClientTxt, "Client Text");
        WebElement getEleClientNameTxt = getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + ClientName + "')]"));
        validateDisPlayedElement(getEleClientNameTxt, "Client Name Text");
        WebElement getEleClientEmailTxt = getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]"));
        validateDisPlayedElement(getEleClientEmailTxt, "Client Email Text");
        WebElement getEleClientDateCreatedTxt = getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + DateCreated + "')]"));
        validateDisPlayedElement(getEleClientDateCreatedTxt, "Client Date Created Text");
        WebElement getEleClientStatusDrpDwn = getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//select"));
        validateDisPlayedElement(getEleClientStatusDrpDwn, "Client Status Drop Down");
    }


    public String getEleAuditorStatusLst(String UserType, String Email, String DateCreated) throws InterruptedException {
        Thread.sleep(10000);
        SelectStatus = getDriver().findElement(By.xpath("//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//td//select"));
        Select select = new Select(SelectStatus);
        String eleAuditorStatusLst = select.getAllSelectedOptions().get(0).getText();
        return eleAuditorStatusLst;
    }

    public void getEleChangeOnBoardingStatus(String UserType, String Email, String DateCreated) throws InterruptedException {
        getLogger().info("Change status of auditor to Onboarding.");
        //Thread.sleep(10000);
        getLogger().info("Set status for auditor to Onboarding.");
        SelectStatus = getDriver().findElement(By.xpath("//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//td//select"));
        Select select = new Select(SelectStatus);
        select.selectByVisibleText("Onboarding");
        //Thread.sleep(3000);
        getLogger().info("Wait for confirm popup render.");
        visibilityOfElementWait(getEleWAITLISTtoONBOARDINGTxt(), "Confirm Poup", waitTime);
        Assert.assertTrue(getEleWAITLISTtoONBOARDINGTxt().isDisplayed(), "Onboarding status is not selected");
        NXGReports.addStep("Confirmation popup changing status from pending to onboarding is displayed", LogAs.PASSED, null);
        getLogger().info("Click confirm button.");
        getEleStatusConfirmBtn().click();
        visibilityOfElementWait(getEleCredentialsCloseIcn(), "Auditor onboarding successful message", waitTime);
        getLogger().info("Change Auditor to Onboarding successful.");
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[text()='Verified " + Email + " successfully.']")).isDisplayed(), "Wait-List user is verified");
        NXGReports.addStep("Verified user is successfully displayed", LogAs.PASSED, null);
        getEleCredentialsCloseIcn().click();
    }

    public void getEleChangeActiveStatus(String UserType, String Email, String DateCreated) throws InterruptedException {
        Thread.sleep(10000);
        SelectStatus = getDriver().findElement(By.xpath("//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//td//select"));
        Select select = new Select(SelectStatus);
        select.selectByVisibleText("Active");
        Assert.assertTrue(getEleONBOARDINGtoACTIVETxt().isDisplayed(), "ACTIVE status is not selected");
        NXGReports.addStep("Confirmation popup changing status from onboarding to active is displayed", LogAs.PASSED, null);
        Thread.sleep(3000);
        getEleStatusConfirmBtn().click();
        Thread.sleep(3000);
        Assert.assertTrue(getEleUpdatedtoACTIVETxt().isDisplayed(), "OnBoarding text is not displayed");
        NXGReports.addStep("ONBoarding text is displayed", LogAs.PASSED, null);
        getEleCredentialsCloseIcn().click();

    }

    public String getEleClientStatusLst(String UserType, String Email, String DateCreated) throws InterruptedException {
        Thread.sleep(10000);
        SelectStatus = getDriver().findElement(By.xpath("//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//td//select"));
        Select select = new Select(SelectStatus);
        String eleAuditorStatusLst = select.getAllSelectedOptions().get(0).getText();
        return eleAuditorStatusLst;
    }

    public void getEleDeleteTheCreatedUser(String Email) throws InterruptedException {
        WebElement deleteBtn = getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]//..//i[@title='Delete User']"));
        deleteBtn.click();
        getEleConfirmBtn().click();
    }

    public void verifyAdminLoginPage() {
        try {
            waitForVisibleElement(eleAdminHdrTxt, "eleAdminHdrTxt");
            validateElementText(eleAdminHdrTxt, "Admin");
            validateDisPlayedElement(eleAdminHdrTxt, "eleAdminHdrTxt");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void verifyAdminHeaderText() {
        validateDisPlayedElement(getEleAdminHdrTxt(), "Auvenir Header Text");
    }

    public void verifyAdminDashBoard() {
        validateEnabledElement(getEleViewCredentialsBtn(), "View Credentials Button");
        validateDisPlayedElement(getEleAuvenirUserCountTxt(), "Auvenir User Count Text");
        validateDisPlayedElement(getEleAuvenirUserTxt(), "Auvenir User Text");
        validateDisPlayedElement(getEleAuvenirUserImg(), "Auvenir User Image");
        validateDisPlayedElement(getEleAuditorsCountTxt(), "Auvenir Count Text");
        validateDisPlayedElement(getEleAuditorsTxt(), "Auditor Text");
        validateDisPlayedElement(getEleAuditorsImg(), "Auditor Image");
        validateDisPlayedElement(getEleBusinessesCountTxt(), "Businesses Count Text");
        validateDisPlayedElement(getEleBusinessesTxt(), "Businesses Text");
        validateDisPlayedElement(getEleBusinessesImg(), "Businesses Image");
        validateDisPlayedElement(getEleEngagementsCountTxt(), "Engagements Count Text");
        validateDisPlayedElement(getEleEngagementsTxt(), "Engagements Text");
        validateDisPlayedElement(getEleEngagementsImg(), "Engagements Image");
    }

    public void verifyUserTable() {
        validateDisPlayedElement(getEleNameTxt(), "Name Text");
        validateDisPlayedElement(getEleUserTypeTxt(), "User Type Text");
        validateDisPlayedElement(getEleEmailTxt(), "Email Text");
        validateDisPlayedElement(getEleDateCreatedTxt(), "Date Created Text");
        validateDisPlayedElement(getEleStatusTxt(), "Status Text");
    }

    public void viewAndVerifyCredentials() {
        getEleViewCredentialsBtn().click();

//        validateDisPlayedElement(getEleAuthIDTxt(), "Auth ID key");
//        validateDisPlayedElement(getEleAPIKeyTxt(), "API Text");
    }

    public void verifyDropMenuMessage() {
        visibilityOfElementWait(getEleThereNoEmailsTxt(), "Inbox Icon", 15);
        getLogger().info("Check mail box.");
        validateDisPlayedElement(getEleThereNoEmailsTxt(), "There are no Emails - Text");
        getLogger().info("Check View message button.");
        validateEnabledElement(getEleViewMessagesBtn(), "View Messages - Button");
        getLogger().info("Check My message text is displayed.");
        validateDisPlayedElement(getEleMyMessagesTxt(), "My Messages - Text");
    }

    public void verifyBodyMessagePage() {
        visibilityOfElementWait(getEleNewMessageBtn(), "New Messages", 15);
        validateDisPlayedElement(getEleNewMessageBtn(), "New Messages - Button");
        validateDisPlayedElement(getEleInboxMsgImg(), "Inbox Messages - Images");
        validateDisPlayedElement(getEleYouDontHaveTxt(), "You dont have - Text");
    }

    public void clickNewMessage() {
        getEleNewMessageBtn().click();
    }

    public void verifyNewMessagePopup() {
        validateDisPlayedElement(getEleNewMessageTxt(), "New Message - Title");
        validateDisPlayedElement(getEleEmailToTxt(), "To: - Text");
        validateDisPlayedElement(getEleEmailToTxtFld(), "Email To: - Text Field");
        validateDisPlayedElement(getEleSubjectTxt(), "Subject: - Text");
        validateDisPlayedElement(getEleSubjectTxtFld(), "Subject - Text Field");
        validateDisPlayedElement(getEleEmailBodyTxtFld(), "Email body - Text Field");
        validateDisPlayedElement(getEleSendBtn(), "Send - Button");
        validateDisPlayedElement(getEleAttachmentIcn(), "Attachment - Icon");
        validateDisPlayedElement(getEleMailCloseIcn(), "Mail Close - Icon");
    }

    public void closeNewMessagePopup() {
        getEleMailCloseIcn().click();
    }

    public void verifyDropMenuNotification() {
        visibilityOfElementWait(getEleYouHaveNoNotificationTxt(), "You have no new - Text", 8);
        validateDisPlayedElement(getEleYouHaveNoNotificationTxt(), "you have no Notifications - Text");
        validateDisPlayedElement(getEleViewAllLnk(), "View All - Link");
    }

    public void clickViewAllNotification() {
        getEleViewAllLnk().click();
    }

    public void verifyBodyNotificationPage() {
        validateDisPlayedElement(getEleMyNotificationsTxt(), "My Notification - Text");
        validateDisPlayedElement(getEleNotificationsIcn(), "Notification - Icon");
        validateDisPlayedElement(getEleYouDontHaveNotificationTxt(), "My Messages - Text");
        validateDisPlayedElement(getEleClickHereLnk(), "View Messages - Button");
    }

    public void navigateToSettingAccountPage() {
        auvenirPage.getEleNotificationImg().click();
        getEleViewAllLnk().click();
        visibilityOfElementWait(getEleClickHereLnk(), "Click Here - Link", 20);
        getEleClickHereLnk().click();
    }

    public void verifySettingAccountPage() {
        visibilityOfElementWait(getEleSettingsTxt(), "Settings Title", 20);
        validateDisPlayedElement(getEleSettingsTxt(), "Settings  - Title");
        validateDisPlayedElement(getEleAccountLnk(), "Account  - Link");
        validateDisPlayedElement(getEleDevicesLnk(), "Devices  - Link");
        validateDisPlayedElement(getEleAccountSettingsTxt(), "Account Settings  - Text");
        validateDisPlayedElement(getEleFirstLastNameTxt(), "First and Last Name  - Text");
        validateDisPlayedElement(getEleFirstLastNameTxtFld(), "First and Last Name  - Text Field");
        validateDisPlayedElement(getEleEmailAddressTxt(), "Email Address  - Text");
        validateDisPlayedElement(getEleEmailAddressTxtFld(), "Email Address  - Text Field");
        validateDisPlayedElement(getElePhomeNumberTxt(), "Phone Number  - Text");
        validateDisPlayedElement(getElePhoneNumberTxtFld(), "Phone Number  - Text Field");
        validateDisPlayedElement(getElePhotoImg(), "Photo  - Image");
        validateDisPlayedElement(getEleYourPhotoTxt(), "your Photo  - Text");
        validateDisPlayedElement(getEleUpdateBtn(), "Update   - Button");
        validateDisPlayedElement(getEleDeactivateLnk(), "Deactivate My Account - Link");
    }

    public void clickDeactiveLink() {
        getEleDeactivateLnk().click();
    }

    public void verifyDeactivePopup() {
        validateDisPlayedElement(getEleDeactivatAccTxt(), "Deactivate Account - Text");
        validateDisPlayedElement(getEleAlertIcn(), "Alert - Icon");
        validateDisPlayedElement(getEleYouareAboutTxt(), "You are about to - Text");
        validateDisPlayedElement(getEleCancelBtn(), "Cancel   - Button");
        validateDisPlayedElement(getEleDeactivateBtn(), "Deactivate   - Button");
    }

    public void closeDeactivePopup() {
        getEleCloseIcn().click();
    }

    public void navigateToSettingDevicesPage() {
        visibilityOfElementWait(auvenirPage.getEleNotificationImg(), "Notification Icon", 10);
        auvenirPage.getEleNotificationImg().click();
        visibilityOfElementWait(getEleViewAllLnk(), "Notification Icon", 10);
        getEleViewAllLnk().click();
        visibilityOfElementWait(getEleClickHereLnk(), "Notification Icon", 10);
        getEleClickHereLnk().click();
        visibilityOfElementWait(getEleSettingsTxt(), "Settings Title", 10);
        getEleDevicesLnk().click();
    }

    public void verifySettingDevicesPage() {
        validateDisPlayedElement(getEleMyDevicesTxt(), "MyDevices  - Title");
        validateDisPlayedElement(getEleYouRegisteredTxt(), "You Have Registered  - Text");
        validateDisPlayedElement(getEleDeviceImg(), "Devices  - Image");
        validateDisPlayedElement(getEleDeviceCustomerNmTxt(), "Customer Name  - Text");
        validateDisPlayedElement(getEleDeviceNameTxt(), "Device Type  - Text");
        validateDisPlayedElement(getEleViewBtn(), "View  - Button");
        validateDisPlayedElement(getEleAddAnotherLnk(), "Add Another - Link");
    }

    public void addAnotherDeviceLink() {
        getEleAddAnotherLnk().click();
    }

    public void verifyAddAnotherPopup() {
        visibilityOfElementWait(getEleRegisterDeviceTxt(), "Settings Title", 20);
        validateDisPlayedElement(getEleRegisterDeviceTxt(), "Register a New Device  - Text");
        validateDisPlayedElement(getEleDownloadAuvenirTxt(), "Download the Auvenir  - Text");
        validateDisPlayedElement(getEleTextMeBtn(), "Text me a Link  - Button");
        validateDisPlayedElement(getEleRegisterMobileImg(), "Register Mobile  - Image");
        validateDisPlayedElement(getEleDownloadAppStoreImg(), "Download App store - Image");
        validateDisPlayedElement(getEleGetItGooglePlayImg(), "Google Play - Image");
        validateDisPlayedElement(getElePopupCloseIcn(), "Register Device Close - Icn");
    }

    public void navigateToSettingDevicesDisconnect() {
        navigateToSettingDevicesPage();
        getEleViewBtn().click();
    }

    public void verifySettingDevicesDisconnectPopup() {
        validateDisPlayedElement(getEleCustomerNameTxt(), "Customer Name - Text");
        validateDisPlayedElement(getEleDeviceViewImg(), "Device - Image");
        validateDisPlayedElement(getEleDeviceNameTxt(), "Device Name - Text");
        validateDisPlayedElement(getEleOSTxt(), "Device OS - Text");
        validateDisPlayedElement(getEleBrowserTxt(), "Browser - Text");
        validateDisPlayedElement(getEleLastUsedTxt(), "Last Used: - Text");
        validateDisPlayedElement(getEleDisconnectDeviceBtn(), "Disconnect Devices - Button");
        validateDisPlayedElement(getEleDisconnectthisDeviceTxt(), "Disconnect this device - Text");
        validateDisPlayedElement(getEleCancelDisconnectBtn(), "Cancel - Button");
        validateDisPlayedElement(getEleDisconnectBtn(), "Disconnect - Button");
        validateDisPlayedElement(getEleCloseIcn(), "Disconnect this device Close - Icon");
    }

    public void verifyDisplayElementInDeActivePage() {
        validateDisPlayedElement(getEleDeactivateLnk(), "Deactivate My Account - Link");
        clickElement(getEleDeactivateLnk(), "Deactive link");
        validateDisPlayedElement(getEleDeactivatAccTxt(), "Deactivate Account - Text");
        validateDisPlayedElement(getEleAlertIcn(), "Alert - Icon");
        validateDisPlayedElement(getEleYouareAboutTxt(), "You are about to - Text");
        validateDisPlayedElement(getEleCancelBtn(), "Cancel   - Button");
        validateDisPlayedElement(getEleDeactivateBtn(), "Deactivate   - Button");
        clickElement(getEleCloseIcn(), "Close button");
    }

    public void verifyUserIsChangeStatusOnTheList(String userType, String email, String dateCreated, String expectedStatus){
        getLogger().info("Verify user is changed status on the list.");
        try {
            String actualStatus = getEleAuditorStatusLst(userType, email, dateCreated);
            Assert.assertTrue(actualStatus.equals(expectedStatus), String.format("Auditor is not created with %s status", actualStatus));
            NXGReports.addStep("Verify user is changed status on the list.", LogAs.PASSED, null);
        } catch (AssertionError e){
            AbstractService.sStatusCnt ++;
            getLogger().info(e);
            NXGReports.addStep("Failed: Verify user is changed status on the list.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e){
            AbstractService.sStatusCnt ++;
            getLogger().info(e);
            NXGReports.addStep("Failed: Verify user is changed status on the list.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }


    }

    /**
     * Refactored by huy.huynh on 30/05/2017.
     * New for smoke test
     */
    @FindBy(xpath = "//table[@id='w-mu-table']")
    private WebElement tableUser;

    @FindBy(xpath = "//p[contains(@id,'msgText')]/div/p[1]")
    private WebElement textViewOnPopupConfirm;

    private String xpathUserTypeCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[2]";
    private String xpathEmailCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[3]";
    private String xpathDateCreatedCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[4]";
    private String xpathStatusCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[6]/select";

    /**
     * verify info of user
     *
     * @param userType      type of user
     * @param userEmail     email
     * @param createdDate   create date(today)
     * @param userStatus    status
     */
    public void verifyAuditorRowOnAdminUserTable(String userType, String userEmail, String createdDate, String userStatus) {
        try {
            WebElement type = GeneralUtilities.getElementByXpath(getDriver(), xpathUserTypeCellOnUserTableAdminX, userEmail);
            WebElement email = GeneralUtilities.getElementByXpath(getDriver(), xpathEmailCellOnUserTableAdminX, userEmail);
            WebElement date = GeneralUtilities.getElementByXpath(getDriver(), xpathDateCreatedCellOnUserTableAdminX, userEmail);

            validateElementText(type, userType);
            validateElementText(email, userEmail);
            validateElementText(date, createdDate);

            verifyAuditorStatusOnAdminUserTable(userEmail, userStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * verify status of user
     *
     * @param userEmail     email
     * @param userStatus    status
     */
    public void verifyAuditorStatusOnAdminUserTable(String userEmail, String userStatus) {
        WebElement status = GeneralUtilities.getElementByXpath(getDriver(), xpathStatusCellOnUserTableAdminX, userEmail);
        validateSelectedItemText(status, userStatus);
    }

    /**
     * verify status of user
     *
     * @param userEmail         email
     * @param chooseOption      status wanna change to
     */
    public void changeTheStatusUser(String userEmail, String chooseOption) {
        try {
            getLogger().info(String.format("Try change status of user to %s", chooseOption));
            Select status = new Select(GeneralUtilities.getElementByXpath(getDriver(), xpathStatusCellOnUserTableAdminX, userEmail));
            status.selectByVisibleText(chooseOption);

            waitForVisibleElement(textViewOnPopupConfirm, "Are you sure you want to change user status from");
            validateElementText(textViewOnPopupConfirm, "Are you sure you want to change user status from");

            waitForVisibleElement(getEleStatusConfirmBtn(), "Confirm Poup");
            waitForClickableOfElement(getEleStatusConfirmBtn(), "Confirm Poup");
            clickElement(getEleStatusConfirmBtn(), "Status Confirm Button");
//            getEleStatusConfirmBtn().click();

            waitForProgressOverlayIsClosed();
            waitForVisibleElement(getEleCredentialsCloseIcn(), "Close Icon");
            waitForClickableOfElement(getEleCredentialsCloseIcn(), "Close Icon");
            clickElement(getEleCredentialsCloseIcn(), "Close Icon");
//            getEleCredentialsCloseIcn().click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /*-----------end of huy.huynh on 30/05/2017.*/
}
