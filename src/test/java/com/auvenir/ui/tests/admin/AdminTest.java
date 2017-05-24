package com.auvenir.ui.tests.admin;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.utilities.GeneralUtilities;
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
            //
            GeneralUtilities.toValidate(adminLoginPage.getEleAdminHdrTxt(), "Auvenir Header Text", "Displayed");
            //
            getLogger().info("Verify View Credential Button.");
            GeneralUtilities.toValidate(adminLoginPage.getEleViewCredentialsBtn(), "View Credentials Button", "Enabled");
            GeneralUtilities.toValidate(adminLoginPage.getEleAuvenirUserCountTxt(), "Auvenir User Count Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAuvenirUserTxt(), "Auvenir User Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAuvenirUserImg(), "Auvenir User Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAuditorsCountTxt(), "Auvenir Count Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAuditorsTxt(), "Auditor Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAuditorsImg(), "Auditor Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleBusinessesCountTxt(), "Businesses Count Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleBusinessesTxt(), "Businesses Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleBusinessesImg(), "Businesses Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEngagementsCountTxt(), "Engagements Count Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEngagementsTxt(), "Engagements Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEngagementsImg(), "Engagements Image", "Displayed");
            //
            GeneralUtilities.toValidate(adminLoginPage.getEleNameTxt(), "Name Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleUserTypeTxt(), "User Type Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEmailTxt(), "Email Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDateCreatedTxt(), "Date Created Text", "Displayed");
            //GeneralUtilities.toValidate(adminLoginPage.getEleAuvenirRepTxt(),"Auvenir Rep Text","Displayed");
            //GeneralUtilities.toValidate(adminLoginPage.getEleCurrentCPATxt(),"Current CPA Text","Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleStatusTxt(), "Status Text", "Displayed");
            getLogger().info("Scroll down to see page footer.");
            actions.sendKeys(Keys.PAGE_DOWN);
            //
            getLogger().info("Verify page footer.");
            auvenirPage.verifyFooter();
            adminLoginPage.getEleViewCredentialsBtn().click();
            GeneralUtilities.toValidate(adminLoginPage.getEleAuthIDTxt(), "Auth ID key", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAPIKeyTxt(), "API Text", "Displayed");
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
            GeneralUtilities.toValidate(adminLoginPage.getEleThereNoEmailsTxt(), "There are no Emails - Text", "Displayed");
            getLogger().info("Check View message button.");
            GeneralUtilities.toValidate(adminLoginPage.getEleViewMessagesBtn(), "View Messages - Button", "Enabled");
            getLogger().info("Check My message text is displayed.");
            GeneralUtilities.toValidate(adminLoginPage.getEleMyMessagesTxt(), "My Messages - Text", "Displayed");
            adminLoginPage.getEleMyMessagesTxt().click();
            visibilityOfElementWait(adminLoginPage.getEleNewMessageBtn(), "New Messages", 15);
            GeneralUtilities.toValidate(adminLoginPage.getEleNewMessageBtn(), "New Messages - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleInboxMsgImg(), "Inbox Messages - Images", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleYouDontHaveTxt(), "You dont have - Text", "Displayed");
            adminLoginPage.getEleNewMessageBtn().click();
            GeneralUtilities.toValidate(adminLoginPage.getEleNewMessageTxt(), "New Message - Title", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEmailToTxt(), "To: - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEmailToTxtFld(), "Email To: - Text Field", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleSubjectTxt(), "Subject: - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleSubjectTxtFld(), "Subject - Text Field", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEmailBodyTxtFld(), "Email body - Text Field", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleSendBtn(), "Send - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAttachmentIcn(), "Attachment - Icon", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleMailCloseIcn(), "Mail Close - Icon", "Displayed");
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
            GeneralUtilities.toValidate(adminLoginPage.getEleYouHaveNoNotificationTxt(), "you have no Notifications - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleViewAllLnk(), "View All - Link", "Displayed");
            adminLoginPage.getEleViewAllLnk().click();
            GeneralUtilities.toValidate(adminLoginPage.getEleMyNotificationsTxt(), "My Notification - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleNotificationsIcn(), "Notification - Icon", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleYouDontHaveNotificationTxt(), "My Messages - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleClickHereLnk(), "View Messages - Button", "Displayed");
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
            GeneralUtilities.toValidate(adminLoginPage.getEleSettingsTxt(), "Settings  - Title", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAccountLnk(), "Account  - Link", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDevicesLnk(), "Devices  - Link", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAccountSettingsTxt(), "Account Settings  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleFirstLastNameTxt(), "First and Last Name  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleFirstLastNameTxtFld(), "First and Last Name  - Text Field", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEmailAddressTxt(), "Email Address  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleEmailAddressTxtFld(), "Email Address  - Text Field", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getElePhomeNumberTxt(), "Phone Number  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getElePhoneNumberTxtFld(), "Phone Number  - Text Field", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getElePhotoImg(), "Photo  - Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleYourPhotoTxt(), "your Photo  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleUpdateBtn(), "Update   - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDeactivateLnk(), "Deactivate My Account - Link", "Displayed");
            adminLoginPage.getEleDeactivateLnk().click();
            GeneralUtilities.toValidate(adminLoginPage.getEleDeactivatAccTxt(), "Deactivate Account - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAlertIcn(), "Alert - Icon", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleYouareAboutTxt(), "You are about to - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleCancelBtn(), "Cancel   - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDeactivateBtn(), "Deactivate   - Button", "Displayed");
            adminLoginPage.getEleCloseIcn().click();
            Thread.sleep(10000);
            //To verify settings page via clicking on user dropdown profile
        /*	actions = new Actions(driver);
			actions.clickAndHold(auvenirPage.getEleUserNameDropDownImg()).click(auvenirPage.getEleSettingsLnk()).release().perform();
			auvenirPage.getEleUserNameDropDownImg().click();
			auvenirPage.getEleSettingsLnk().click();
			visibilityOfElementWait(adminLoginPage.getEleSettingsTxt(), "Settings Title",20);
			GeneralUtilities.toValidate(adminLoginPage.getEleSettingsTxt(), "Settings  - Title","Displayed");
			GeneralUtilities.toValidate(adminLoginPage.getEleAccountLnk(), "Account  - Link","Displayed");
			GeneralUtilities.toValidate(adminLoginPage.getEleDevicesLnk(), "Devices  - Link","Displayed");*/
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
            GeneralUtilities.toValidate(adminLoginPage.getEleMyDevicesTxt(), "MyDevices  - Title", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleYouRegisteredTxt(), "You Have Registered  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDeviceImg(), "Devices  - Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDeviceCustomerNmTxt(), "Customer Name  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDeviceNameTxt(), "Device Type  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleViewBtn(), "View  - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleAddAnotherLnk(), "Add Another - Link", "Displayed");
            adminLoginPage.getEleAddAnotherLnk().click();
            visibilityOfElementWait(adminLoginPage.getEleRegisterDeviceTxt(), "Settings Title", 20);
            GeneralUtilities.toValidate(adminLoginPage.getEleRegisterDeviceTxt(), "Register a New Device  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDownloadAuvenirTxt(), "Download the Auvenir  - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleTextMeBtn(), "Text me a Link  - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleRegisterMobileImg(), "Register Mobile  - Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDownloadAppStoreImg(), "Download App store - Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleGetItGooglePlayImg(), "Google Play - Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getElePopupCloseIcn(), "Register Device Close - Icn", "Displayed");

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
            GeneralUtilities.toValidate(adminLoginPage.getEleCustomerNameTxt(), "Customer Name - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDeviceViewImg(), "Device - Image", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDeviceNameTxt(), "Device Name - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleOSTxt(), "Device OS - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleBrowserTxt(), "Browser - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleLastUsedTxt(), "Last Used: - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDisconnectDeviceBtn(), "Disconnect Devices - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDisconnectthisDeviceTxt(), "Disconnect this device - Text", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleCancelDisconnectBtn(), "Cancel - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleDisconnectBtn(), "Disconnect - Button", "Displayed");
            GeneralUtilities.toValidate(adminLoginPage.getEleCloseIcn(), "Disconnect this device Close - Icon", "Displayed");
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
            GeneralUtilities.toValidate(auvenirPage.getEleTOSTitleTxt(), "Terms of Service - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleEnglishFrenchTxt(), "English French - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleEffectiveTxt(), "Effective: 16th Jan  - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleTheseTermsTxt(), "These terms of service  - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleContactInfoLnk(), "Contact info@auvenir.com - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleVisitDeloitteLnk(), "Visit DEloitte - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getElePrivacyStatementLnk(), "Privacy Statement - Link", "Displayed");

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
            GeneralUtilities.toValidate(auvenirPage.getElePrivacyTitleTxt(), "Privacy Statement - Title", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleEnglishFrenchTxt(), "English French - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleLastRevisedTxt(), "Last Revised - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleContactInfoLnk(), "Contact info@auvenir.com - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getElePrivacyTOSLnk(), "Privacy - TOS - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getElePrivacyCookiesLnk(), "Privacy Cookies - Link", "Displayed");
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
            GeneralUtilities.toValidate(auvenirPage.getEleCookieNoticeTitleTxt(), "Cookie Notice - Title", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleEnglishFrenchTxt(), "English French - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleLastRevisedTxt(), "Last Revised - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleAuvenirUsesTxt(), "Last Revised - Text", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleContactInfoLnk(), "Contact info@auvenir.com - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getElePrivacyStatementLnk(), "Privacy Statement - Link", "Displayed");
            GeneralUtilities.toValidate(auvenirPage.getEleAboutCookiesLnk(), "About Cookies - Link", "Displayed");
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
