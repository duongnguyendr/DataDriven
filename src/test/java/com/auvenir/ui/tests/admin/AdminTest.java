package com.auvenir.ui.tests.admin;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.utilities.GenericService;
import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;


public class AdminTest extends AbstractRefactorService {
    //Logger logger =Logger.getLogger(AdminTest.class);
    AdminLoginPage adminLoginPage = null;
    AuvenirPage auvenirPage = null;
    String testCaseId = null;
    String sData[] = null;
    Actions actions = null;
    String sTOSurl = "https://ariel.auvenir.com/terms";
    String sPrivacyurl = "https://ariel.auvenir.com/privacy";
    String sCookieurl = "https://ariel.auvenir.com/cookies";
    private int waittime = 60;


    /*
     * @Description: To Verify the display of Elements in Admin Home Page
     * @Author: Jeevaraj SP
     */
    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Admin Home Page")
    public void verifyAdminHomePage() throws Exception {
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        actions = new Actions(getDriver());
        AbstractRefactorService.sStatusCnt = 0;
        try {
            testCaseId = "VerifyAdminClientEntry";
            sData = GenericService.toReadExcelData(testCaseId);
            adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
            getLogger().info("Login with Admin role.");
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 15);
            getLogger().info("Verify Admin logged in header.");
            auvenirPage.verifyHeader();
            auvenirPage.toValidate(adminLoginPage.getEleAdminHdrTxt(), "Auvenir Header Text", "Displayed");
            getLogger().info("Verify View Credential Button.");
            auvenirPage.toValidate(adminLoginPage.getEleViewCredentialsBtn(), "View Credentials Button", "Enabled");
            auvenirPage.toValidate(adminLoginPage.getEleAuvenirUserCountTxt(), "Auvenir User Count Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAuvenirUserTxt(), "Auvenir User Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAuvenirUserImg(), "Auvenir User Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAuditorsCountTxt(), "Auvenir Count Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAuditorsTxt(), "Auditor Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAuditorsImg(), "Auditor Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleBusinessesCountTxt(), "Businesses Count Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleBusinessesTxt(), "Businesses Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleBusinessesImg(), "Businesses Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEngagementsCountTxt(), "Engagements Count Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEngagementsTxt(), "Engagements Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEngagementsImg(), "Engagements Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleNameTxt(), "Name Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleUserTypeTxt(), "User Type Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEmailTxt(), "Email Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDateCreatedTxt(), "Date Created Text", "Displayed");
            //auvenirPage.toValidate(adminLoginPage.getEleAuvenirRepTxt(),"Auvenir Rep Text","Displayed");
            //auvenirPage.toValidate(adminLoginPage.getEleCurrentCPATxt(),"Current CPA Text","Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleStatusTxt(), "Status Text", "Displayed");
            getLogger().info("Scroll down to see page footer.");
            actions.sendKeys(Keys.PAGE_DOWN);
            getLogger().info("Verify page footer.");
            auvenirPage.verifyFooter();
            adminLoginPage.getEleViewCredentialsBtn().click();
            auvenirPage.toValidate(adminLoginPage.getEleAuthIDTxt(), "Auth ID key", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAPIKeyTxt(), "API Text", "Displayed");
            //adminLoginPage.getEleCredentialsCloseIcn().click(); //- Need to update
            Thread.sleep(5000);

            //adminLoginPage.getEleClientEntryValidate(sData[1], sData[2], sData[3], sData[4]);
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Messages screen
     * @Author: Lakshmi BS
     */
    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Messages screen")
    public void verifyMessagesContent() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        actions = new Actions(getDriver());
        try {
            getLogger().info("Login with admin role.");
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("Check Admin logged in page header.");
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 15);
            Thread.sleep(15000);
            getLogger().info("Check Message Inbox icon.");
            visibilityOfElementWait(auvenirPage.getEleInboxImg(), "Inbox Icon", 20);
            getLogger().info("Click icon to view Inbox.");
            auvenirPage.getEleInboxImg().click();
            visibilityOfElementWait(adminLoginPage.getEleThereNoEmailsTxt(), "Inbox Icon", 15);
            getLogger().info("Check mail box.");
            auvenirPage.toValidate(adminLoginPage.getEleThereNoEmailsTxt(), "There are no Emails - Text", "Displayed");
            getLogger().info("Check View message button.");
            auvenirPage.toValidate(adminLoginPage.getEleViewMessagesBtn(), "View Messages - Button", "Enabled");
            getLogger().info("Check My message text is displayed.");
            auvenirPage.toValidate(adminLoginPage.getEleMyMessagesTxt(), "My Messages - Text", "Displayed");
            adminLoginPage.getEleMyMessagesTxt().click();
            visibilityOfElementWait(adminLoginPage.getEleNewMessageBtn(), "New Messages", 15);
            auvenirPage.toValidate(adminLoginPage.getEleNewMessageBtn(), "New Messages - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleInboxMsgImg(), "Inbox Messages - Images", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleYouDontHaveTxt(), "You dont have - Text", "Displayed");
            adminLoginPage.getEleNewMessageBtn().click();
            auvenirPage.toValidate(adminLoginPage.getEleNewMessageTxt(), "New Message - Title", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEmailToTxt(), "To: - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEmailToTxtFld(), "Email To: - Text Field", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleSubjectTxt(), "Subject: - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleSubjectTxtFld(), "Subject - Text Field", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEmailBodyTxtFld(), "Email body - Text Field", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleSendBtn(), "Send - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAttachmentIcn(), "Attachment - Icon", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleMailCloseIcn(), "Mail Close - Icon", "Displayed");
            adminLoginPage.getEleMailCloseIcn().click();

            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }

    }

    /*
     * @Description: To Verify the display of Elements in Notification screen
     * @Author: Lakshmi BS
     */
    @Test(priority = 3, enabled = true, description = "To Verify the display of Elements in Notification screen")
    public void verifyAlertContent() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());

        try {
            getLogger().info("Login with Admin role to check notification.");
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 15);
            Thread.sleep(20000);
            auvenirPage.getEleNotificationImg().click();
            visibilityOfElementWait(adminLoginPage.getEleYouHaveNoNotificationTxt(), "You have no new - Text", 8);
            auvenirPage.toValidate(adminLoginPage.getEleYouHaveNoNotificationTxt(), "you have no Notifications - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleViewAllLnk(), "View All - Link", "Displayed");
            adminLoginPage.getEleViewAllLnk().click();
            auvenirPage.toValidate(adminLoginPage.getEleMyNotificationsTxt(), "My Notification - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleNotificationsIcn(), "Notification - Icon", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleYouDontHaveNotificationTxt(), "My Messages - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleClickHereLnk(), "View Messages - Button", "Displayed");
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Admin Account Settings  screen
     * @Author: Lakshmi BS
     */
    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Admin Account Settings and Deactivate screen")
    public void verifyAdminSettingsAccContent() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        try {
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 15);
            Thread.sleep(10000);
            auvenirPage.getEleNotificationImg().click();
            adminLoginPage.getEleViewAllLnk().click();
            visibilityOfElementWait(adminLoginPage.getEleClickHereLnk(), "Click Here - Link", 20);
            adminLoginPage.getEleClickHereLnk().click();
            visibilityOfElementWait(adminLoginPage.getEleSettingsTxt(), "Settings Title", 20);
            auvenirPage.toValidate(adminLoginPage.getEleSettingsTxt(), "Settings  - Title", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAccountLnk(), "Account  - Link", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDevicesLnk(), "Devices  - Link", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAccountSettingsTxt(), "Account Settings  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleFirstLastNameTxt(), "First and Last Name  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleFirstLastNameTxtFld(), "First and Last Name  - Text Field", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEmailAddressTxt(), "Email Address  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleEmailAddressTxtFld(), "Email Address  - Text Field", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getElePhomeNumberTxt(), "Phone Number  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getElePhoneNumberTxtFld(), "Phone Number  - Text Field", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getElePhotoImg(), "Photo  - Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleYourPhotoTxt(), "your Photo  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleUpdateBtn(), "Update   - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDeactivateLnk(), "Deactivate My Account - Link", "Displayed");
            adminLoginPage.getEleDeactivateLnk().click();
            auvenirPage.toValidate(adminLoginPage.getEleDeactivatAccTxt(), "Deactivate Account - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAlertIcn(), "Alert - Icon", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleYouareAboutTxt(), "You are about to - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleCancelBtn(), "Cancel   - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDeactivateBtn(), "Deactivate   - Button", "Displayed");
            adminLoginPage.getEleCloseIcn().click();
            Thread.sleep(10000);
            //To verify settings page via clicking on user dropdown profile
        /*	actions = new Actions(driver);
			actions.clickAndHold(auvenirPage.getEleUserNameDropDownImg()).click(auvenirPage.getEleSettingsLnk()).release().perform();
			auvenirPage.getEleUserNameDropDownImg().click();
			auvenirPage.getEleSettingsLnk().click();
			visibilityOfElementWait(adminLoginPage.getEleSettingsTxt(), "Settings Title",20);
			auvenirPage.toValidate(adminLoginPage.getEleSettingsTxt(), "Settings  - Title","Displayed");
			auvenirPage.toValidate(adminLoginPage.getEleAccountLnk(), "Account  - Link","Displayed");
			auvenirPage.toValidate(adminLoginPage.getEleDevicesLnk(), "Devices  - Link","Displayed");*/
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Admin Settings Devices Registration screen
     * @Author: Lakshmi BS
     */
    @Test(priority = 5, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Registration screen")
    public void verifyAdminSettingsDevicesContentRegister() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        try {
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 15);
            Thread.sleep(10000);
            visibilityOfElementWait(auvenirPage.getEleNotificationImg(), "Notification Icon", 10);
            auvenirPage.getEleNotificationImg().click();
            visibilityOfElementWait(adminLoginPage.getEleViewAllLnk(), "Notification Icon", 10);
            adminLoginPage.getEleViewAllLnk().click();
            visibilityOfElementWait(adminLoginPage.getEleClickHereLnk(), "Notification Icon", 10);
            adminLoginPage.getEleClickHereLnk().click();
            visibilityOfElementWait(adminLoginPage.getEleSettingsTxt(), "Settings Title", 10);
            adminLoginPage.getEleDevicesLnk().click();
            //visibilityOfElementWait(adminLoginPage.getEleMyDevicesTxt(), "My Devices",8);
            auvenirPage.toValidate(adminLoginPage.getEleMyDevicesTxt(), "MyDevices  - Title", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleYouRegisteredTxt(), "You Have Registered  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDeviceImg(), "Devices  - Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDeviceCustomerNmTxt(), "Customer Name  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDeviceNameTxt(), "Device Type  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleViewBtn(), "View  - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleAddAnotherLnk(), "Add Another - Link", "Displayed");
            adminLoginPage.getEleAddAnotherLnk().click();
            visibilityOfElementWait(adminLoginPage.getEleRegisterDeviceTxt(), "Settings Title", 20);
            auvenirPage.toValidate(adminLoginPage.getEleRegisterDeviceTxt(), "Register a New Device  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDownloadAuvenirTxt(), "Download the Auvenir  - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleTextMeBtn(), "Text me a Link  - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleRegisterMobileImg(), "Register Mobile  - Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDownloadAppStoreImg(), "Download App store - Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleGetItGooglePlayImg(), "Google Play - Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getElePopupCloseIcn(), "Register Device Close - Icn", "Displayed");

            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Admin Settings Devices Disconnect screen
     * @Author: Lakshmi BS
     */
    @Test(priority = 6, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminSettingsDevicesContentDisconnect() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        try {
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 15);
            Thread.sleep(10000);
            visibilityOfElementWait(auvenirPage.getEleNotificationImg(), "Notification Icon", 10);
            auvenirPage.getEleNotificationImg().click();
            visibilityOfElementWait(adminLoginPage.getEleViewAllLnk(), "Notification Icon", 10);
            adminLoginPage.getEleViewAllLnk().click();
            visibilityOfElementWait(adminLoginPage.getEleClickHereLnk(), "Notification Icon", 10);
            adminLoginPage.getEleClickHereLnk().click();
            visibilityOfElementWait(adminLoginPage.getEleSettingsTxt(), "Settings Title", 10);
            adminLoginPage.getEleDevicesLnk().click();
            adminLoginPage.getEleViewBtn().click();
            auvenirPage.toValidate(adminLoginPage.getEleCustomerNameTxt(), "Customer Name - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDeviceViewImg(), "Device - Image", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDeviceNameTxt(), "Device Name - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleOSTxt(), "Device OS - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleBrowserTxt(), "Browser - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleLastUsedTxt(), "Last Used: - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDisconnectDeviceBtn(), "Disconnect Devices - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDisconnectthisDeviceTxt(), "Disconnect this device - Text", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleCancelDisconnectBtn(), "Cancel - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleDisconnectBtn(), "Disconnect - Button", "Displayed");
            auvenirPage.toValidate(adminLoginPage.getEleCloseIcn(), "Disconnect this device Close - Icon", "Displayed");
            Assert.assertTrue(AbstractRefactorService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Terms of Service screen of Admin login
     * @Author: Lakshmi BS
     */
    @Test(priority = 7, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminTOS() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        try {
            getLogger().info("Login with admin role.");
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("wait for admin header page.");
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", waittime);
            Thread.sleep(10000);
            auvenirPage.getEleTermsOfUserFtrLnk().click();
            getLogger().info("Switch to new windows.");
            switchToWindow();
            Thread.sleep(5000);
            Assert.assertTrue(getDriver().getCurrentUrl().equals(sTOSurl), "Terms of Service page is not displayed");
            auvenirPage.toValidate(auvenirPage.getEleTOSTitleTxt(), "Terms of Service - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleEnglishFrenchTxt(), "English French - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleEffectiveTxt(), "Effective: 16th Jan  - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleTheseTermsTxt(), "These terms of service  - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleContactInfoLnk(), "Contact info@auvenir.com - Link", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleVisitDeloitteLnk(), "Visit DEloitte - Link", "Displayed");
            auvenirPage.toValidate(auvenirPage.getElePrivacyStatementLnk(), "Privacy Statement - Link", "Displayed");

        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Privacy Statement screen of Admin login
     * @Author: Lakshmi BS
     */
    @Test(priority = 8, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminPrivacyPage() throws Exception {
        AbstractRefactorService.sStatusCnt = 0;
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        try {
            getLogger().info("Login to admin page.");
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            getLogger().info("Wait for admin header.");
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", waittime);
            Thread.sleep(10000);
            auvenirPage.getElePrivacyPolicyFtrLnk().click();
            Thread.sleep(5000);
            switchToWindow();
            Assert.assertTrue(getDriver().getCurrentUrl().equals(sPrivacyurl), "Privacy Statement page is not displayed");
            auvenirPage.toValidate(auvenirPage.getElePrivacyTitleTxt(), "Privacy Statement - Title", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleEnglishFrenchTxt(), "English French - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleLastRevisedTxt(), "Last Revised - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleContactInfoLnk(), "Contact info@auvenir.com - Link", "Displayed");
            auvenirPage.toValidate(auvenirPage.getElePrivacyTOSLnk(), "Privacy - TOS - Link", "Displayed");
            auvenirPage.toValidate(auvenirPage.getElePrivacyCookiesLnk(), "Privacy Cookies - Link", "Displayed");
            //driver.switchTo().window(AbstractRefactorService.newWin).close();

        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /*
     * @Description: To Verify the display of Elements in Cookie Notice screen of Admin login
     * @Author: Lakshmi BS
     */
    @Test(priority = 9, enabled = true, description = "To Verify the display of Elements in Admin Settings Devices Disconnect screen")
    public void verifyAdminCookieNoticePage() throws Exception {

        AbstractRefactorService.sStatusCnt = 0;
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        try {
            loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "ADMINEMAILID"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "GETTOKENURL"),
                    GenericService.getCongigValue(GenericService.sConfigFile, "CHECKTOKENURL"));
            visibilityOfElementWait(adminLoginPage.getEleAdminHdrTxt(), "Admin Header Text", 15);
            Thread.sleep(10000);
            auvenirPage.getEleCookieNoticeFtrLnk().click();
            switchToWindow();
            Assert.assertTrue(getDriver().getCurrentUrl().equals(sCookieurl), "Cookie Notice page page is not displayed");
            auvenirPage.toValidate(auvenirPage.getEleCookieNoticeTitleTxt(), "Cookie Notice - Title", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleEnglishFrenchTxt(), "English French - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleLastRevisedTxt(), "Last Revised - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleAuvenirUsesTxt(), "Last Revised - Text", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleContactInfoLnk(), "Contact info@auvenir.com - Link", "Displayed");
            auvenirPage.toValidate(auvenirPage.getElePrivacyStatementLnk(), "Privacy Statement - Link", "Displayed");
            auvenirPage.toValidate(auvenirPage.getEleAboutCookiesLnk(), "About Cookies - Link", "Displayed");
            //driver.switchTo().window(AbstractRefactorService.newWin).close();
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
