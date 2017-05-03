package com.auvenir.ui.services;

import com.auvenir.ui.pages.admin.AdminAccountSettingsPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.bind.Element;

/**
 * Created by doai.tran on 4/27/2017.
 *
 */
public class AdminAccountSettingsService extends AbstractService{
    AdminAccountSettingsPage adminAccountSettingsPage;
    public AdminAccountSettingsService(Logger logger, WebDriver driver){
        super(logger,driver);
        adminAccountSettingsPage = new AdminAccountSettingsPage(getLogger(), getDriver());
    }
    public void verifyHeaderAdminSettingPage() {
        try {
            getLogger().info("Start verify Elements on Admin Setting page.");
            adminAccountSettingsPage.verifyElementsHeader();
        } catch (Exception e) {
            getLogger().info("Header Elements on Admin Setting page is not displayed" + e.getMessage());
        }

    }

    public void verifyBodyAdminSettingPage() {
        try {
            getLogger().info("Start verify Element on Account Tab on Admin Setting page.");
            adminAccountSettingsPage.verifyElementsOnAccountTab();
            adminAccountSettingsPage.navigateToDevicesTab();
            adminAccountSettingsPage.verifyElementsOnDevicesTab();
        } catch (Exception e) {
            getLogger().info("Body Elements on Admin Setting page is not displayed" + e.getMessage());
        }

    }

    public void verifyFooterAdminSettingPage() {
        try {
            getLogger().info("Start verify Elements on Admin Setting page.");
            adminAccountSettingsPage.verifyElementsFooter();
        } catch (Exception e) {
            getLogger().info("Footer Elements on Admin Setting page is not displayed" + e.getMessage());
        }

    }

    public void inputFullNameAdminSettingPage(String Value) {
        try {
            getLogger().info("Input data for FullName Textbox.");
            adminAccountSettingsPage.inputValueFullName(Value);
            NXGReports.addStep("Input value " + Value + " on FullName successfully.", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception e) {
            getLogger().info("Unable to input new value for Admin Setting Page.");
            NXGReports.addStep("Input value " + Value + " on FullName successfully.", LogAs.FAILED, (CaptureScreen)null);
        }

    }

    public void inputPhoneNumberAdminSettingPage(String Value) {
        try {
            getLogger().info("Input data for Phone Number Textbox.");
            adminAccountSettingsPage.inputValuePhoneNumber(Value);
            NXGReports.addStep("Input value " + Value + " on PhoneNumber successfully.", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception e) {
            getLogger().info("Unable to input new value for Admin Setting Page.");
            NXGReports.addStep("Input value " + Value + " on PhoneNumber successfully.", LogAs.FAILED, (CaptureScreen)null);
        }

    }

    public void verifyEmailTextBoxVisible() {
        try {
            getLogger().info("Verify that Email TextBox is disable.");
            adminAccountSettingsPage.verifyEmailTextBoxIsDisable();
            NXGReports.addStep("Email TextBox is visible.", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception e) {
            NXGReports.addStep("Email TextBox is NOT visible.", LogAs.FAILED, (CaptureScreen)null);
        }

    }
    public void verifyTextFullNameLable(){
        try{
            getLogger().info("Verify text of Element: FullName lable ");
            adminAccountSettingsPage.validateTextMessageFullNametxtbox();
            NXGReports.addStep("Element: FullName lable ",LogAs.PASSED, (CaptureScreen)null);
        }catch (Exception e){
            NXGReports.addStep("Element : FullName lable has not text as expected.",LogAs.FAILED,(CaptureScreen)null);
        }
    }
    public void verifyTextphoneLabel(){
        try{
            getLogger().info("Verify text of Element: phoneLabel");
            adminAccountSettingsPage.validateTextMessagePhoneTxtbox();
            NXGReports.addStep("Element: FullName lable ",LogAs.PASSED, (CaptureScreen)null);
        }catch (Exception e){
            NXGReports.addStep("Element : FullName lable has not text as expected.",LogAs.FAILED,(CaptureScreen)null);
        }
    }
}
