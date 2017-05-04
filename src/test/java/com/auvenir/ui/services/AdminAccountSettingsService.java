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
    public void clickUpdateImageBTN(){
        try{
            getLogger().info("Try to click on Update Image button.");
            adminAccountSettingsPage.clickUpdateImageBTN();
            NXGReports.addStep("Clicked on Update Image button.",LogAs.PASSED, (CaptureScreen)null);
        }catch (Exception e){
            NXGReports.addStep("Unable to click on Update Image button.",LogAs.FAILED,(CaptureScreen)null);
        }
    }
    public void clickUpdateBTN(){
        try{
            getLogger().info("Try to click on Update button.");
            adminAccountSettingsPage.ClickUpdateBTN();
            NXGReports.addStep("clicked on Update button.",LogAs.PASSED,(CaptureScreen)null);
        }catch (Exception e){
            NXGReports.addStep("Unable to click on Update button.",LogAs.FAILED,(CaptureScreen)null);
        }
    }
    public void waitAndVerifyUpdatedTextMessage(){
        try{
            getLogger().info("Try to waitAndVerifyUpdatedTextMessage.");
            adminAccountSettingsPage.waitAndVerifyUpdatedTextMessage();
            NXGReports.addStep("waitAndVerifyUpdatedTextMessage successfully.",LogAs.PASSED,(CaptureScreen)null);
        }catch (Exception e){
            NXGReports.addStep("waitAndVerifyUpdatedTextMessage failed.",LogAs.FAILED,(CaptureScreen)null);
        }
    }
    public void waitAndVerifyErrorMessageUploadImage() {
        try {
            this.getLogger().info("Try to waitAndVerifyUpdatedTextMessage.");
            this.adminAccountSettingsPage.waitAndVerifyErrorMessageUploadImage();
            NXGReports.addStep("waitAndVerifyErrorMessageUploadImage successfully.", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception var2) {
            NXGReports.addStep("waitAndVerifyErrorMessageUploadImage failed.", LogAs.FAILED, (CaptureScreen)null);
        }

    }

    public void waitAndVerifyErrorMessageBigFile() {
        try {
            this.getLogger().info("Try to waitAndVerifyErrorMessageBigFile.");
            this.adminAccountSettingsPage.waitAndVerifyErrorMessageBigFile();
            NXGReports.addStep("waitAndVerifyErrorMessageBigFile successfully.", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception var2) {
            NXGReports.addStep("waitAndVerifyErrorMessageBigFile failed.", LogAs.FAILED, (CaptureScreen)null);
        }

    }

    public void verifyUpdateButtonDisableDefault() {
        try {
            this.getLogger().info("Try to verifyUpdateButtonDisableDefault.");
            this.adminAccountSettingsPage.verifyUpdateButtonDisableDefault();
            NXGReports.addStep("verifyUpdateButtonDisableDefault successfully.", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception e) {
            NXGReports.addStep("verifyUpdateButtonDisableDefault failed.", LogAs.FAILED, (CaptureScreen)null);
        }

    }
    public void verifyUpdateButtonEnable() {
        try {
            getLogger().info("Try to verifyUpdateButtonEnable.");
            adminAccountSettingsPage.verifyUpdateButtonEnable();
            NXGReports.addStep("verifyUpdateButtonEnable successfully.", LogAs.PASSED, (CaptureScreen)null);
        } catch (Exception e) {
            NXGReports.addStep("verifyUpdateButtonEnable failed.", LogAs.FAILED, (CaptureScreen)null);
        }

    }
}
