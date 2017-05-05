package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorAcountSettingsPage;
import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import javax.xml.bind.Element;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorAccountSettingsService extends AbstractService {

    AuditorAcountSettingsPage auditorAccountSettingsPage;

/*
 * contructor
 */
    public AuditorAccountSettingsService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorAccountSettingsPage = new AuditorAcountSettingsPage(getLogger(), getDriver());

    }
    /*
    Refactor Verify Footer of Auditor Account Settings by DoaiTran for PLAT-2273
     */
    public void verifyFooter() {
        try {
            /*auditorAccountSettingsPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorAccountSettingsPage.verifyFooter();
            getLogger().info("verfify term of service link.");
            auditorAccountSettingsPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorAccountSettingsPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorAccountSettingsPage.verifyCookieNotice();
            auditorAccountSettingsPage.scrollPageUp();*/

            auditorAccountSettingsPage.verifyFooterAcountSetting();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyAccountSettingsPage() {

        try {
            getLogger().info("verify Auditor Engagement page.");
            auditorAccountSettingsPage.verifyAccountSettingsPage();
            NXGReports.addStep("verify Auditor Account Settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Auditor Account Settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToNotificationsPage() {
        try {
            getLogger().info("navigate to Notifications tab.");
            auditorAccountSettingsPage.navigateToNotificationsPage();
            NXGReports.addStep("navigate to Notifications tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Notifications tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToDevicesPage() {
        try {
            getLogger().info("navigate to Devices tab.");
            auditorAccountSettingsPage.navigateToDevicesPage();
            NXGReports.addStep("navigate to Devices tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Devices tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }
    public void verifyHeader(){
        try{
            getLogger().info("Start verify header of auditor settings page.");
            auditorAccountSettingsPage.verifyHeader();
            NXGReports.addStep("All elements are displayed on auditor settings page.", LogAs.PASSED, null);
        }catch (Exception e) {
            NXGReports.addStep("Some elements on header are not displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
    public void verifyBody(){
        try{
            getLogger().info("Start verify account tab of auditor settings page.");
            auditorAccountSettingsPage.verifyElementsOnAccountTab();
            getLogger().info("Go to Notification tab of auditor settings page.");
            auditorAccountSettingsPage.navigateToNotificationTab();
            getLogger().info("Start verify Notification Tab of auditor settings page.");
            auditorAccountSettingsPage.verifyElementsOnNotificationTab();
            getLogger().info("Go to Devices tab of auditor settings page.");
            auditorAccountSettingsPage.navigateToDevicesTab();
            getLogger().info("Start verify Devices Tab of auditor settings page.");
            auditorAccountSettingsPage.verifyElementsOnDevicesTab();
        }catch (Exception e){
            NXGReports.addStep("Some elements on body are not displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
    public void inputFullName(String TextValue){
        try{
            getLogger().info("Try to input value: "+ TextValue+" on FullName TextBox.");
            auditorAccountSettingsPage.inputFullName(TextValue);
            NXGReports.addStep("Inputed value: "+ TextValue+" on FullName TextBox.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Unable to input value: "+ TextValue+" on FullName TextBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
    public void sendTabkeyFullNametxt(){
        try{
            auditorAccountSettingsPage.sendTabkeyFullNameTxt();
            NXGReports.addStep("Tab successfully", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Unable to tab on Element FullNametxt.", LogAs.FAILED, null);
            throw e;
        }
    }
    public void sendTabkeyPhoneNumbertxt(){
        try{
            auditorAccountSettingsPage.sendTabkeyPhoneNumberTxt();
            NXGReports.addStep("Tab successfully", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Unable to tab on Element PhoneNumbertx.", LogAs.FAILED, null);
            throw e;
        }
    }
}

