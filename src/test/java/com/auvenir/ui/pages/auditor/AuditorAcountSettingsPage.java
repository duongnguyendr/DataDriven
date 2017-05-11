package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class AuditorAcountSettingsPage extends AbstractPage {
    private final static int waitTime=60;
    public AuditorAcountSettingsPage(Logger logger,WebDriver driver){
        super(logger,driver);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
        
    }
    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]")
    private WebElement auditorAccountSettingsHeaderTextEle;

    @FindBy(id = "link-setting-notifications-auditor")
    private WebElement notificationLinkEle;
    @FindBy(id = "link-setting-device-auditor")
    private WebElement devicesLinkEle;


    public void verifyAccountSettingsPage() {
        waitForVisibleElement(auditorAccountSettingsHeaderTextEle);
    }

    public void navigateToNotificationsPage() {
        waitForClickableOfElement(notificationLinkEle);
        notificationLinkEle.click();

    }

    public void navigateToDevicesPage() {
        waitForClickableOfElement(devicesLinkEle);
        devicesLinkEle.click();

    }
    /*
    Verify all elements on body of Auditor Settings Page
    Created by DoaiTran on 5/5/2017
     */
    public void verifyElementsOnAccountTab() {
        waitForVisibleElement(settingTitle);
        NXGReports.addStep("verified Element: settingTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(accountTab);
        NXGReports.addStep("verified Element: accountTab displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(notificationTab);
        NXGReports.addStep("verified Element: notificationTab displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(devicesTab);
        NXGReports.addStep("verified Element: devicesTab displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(accountSettingTitle);
        NXGReports.addStep("verified Element: accountSettingTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(fullNameTextBox);
        NXGReports.addStep("verified Element: fullNameTextBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(emailTextBox);
        NXGReports.addStep("verified Element: emailTextBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(phoneNoTextBox);
        NXGReports.addStep("verified Element: phoneNoTextBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(userPhoto);
        NXGReports.addStep("verified Element: userPhoto displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(uploadButton);
        NXGReports.addStep("verified Element: uploadButton displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(firNameTextBox);
        NXGReports.addStep("verified Element: firNameTextBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(roleTextBox);
        NXGReports.addStep("verified Element: roleTextBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(firmSizeDropBox);
        NXGReports.addStep("verified Element: firmSizeDropBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(firmLogo);
        NXGReports.addStep("verified Element: firmLogo displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(logoUploadButton);
        NXGReports.addStep("verified Element: logoUploadButton displayed.", LogAs.PASSED, (CaptureScreen)null);
        validateElementText(deactivateButton, "Deactivate My Account");
        //validateDisabledElement(deactivateButton);
        NXGReports.addStep("verified Element: deactivateButton displayed and disable", LogAs.PASSED, (CaptureScreen)null);
        validateElementText(updateButton, "Update");
        //validateDisabledElement(updateButton);
        NXGReports.addStep("verified Element: updateButton displayed and disable.", LogAs.PASSED, (CaptureScreen)null);
    }
    public void navigateToNotificationTab() {
        waitForVisibleElement(notificationTab);
        getLogger().info("verify Element: notificationTab displayed.");
        notificationTab.click();
        NXGReports.addStep("Go to Notification Tab successfully.", LogAs.PASSED, (CaptureScreen)null);
    }
    public void navigateToDevicesTab() {
        waitForVisibleElement(devicesTab);
        getLogger().info("verify Element: devicesTab displayed.");
        devicesTab.click();
        NXGReports.addStep("Go to Device Tab successfully.", LogAs.PASSED, (CaptureScreen)null);
    }
    public void verifyElementsOnNotificationTab() {
        waitForVisibleElement(notificationSettingTitle);
        NXGReports.addStep("verified Element: notificationSettingTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(notificationNote);
        NXGReports.addStep("verified Element: notificationNote displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(byEmailTitle);
        NXGReports.addStep("verified Element: byEmailTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(SubNotification);
        NXGReports.addStep("verified Element: SubNotification displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(isInventedToYourEngagementSlider);
        NXGReports.addStep("verified Element: isInventedToYourEngagementSlider displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(hasJoinedYourEngagementSlider);
        NXGReports.addStep("verified Element: hasJoinedYourEngagementSlider displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(sendYouAMessageSlider);
        NXGReports.addStep("verified Element: sendYouAMessageSlider displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(uploadsADocumentSlider);
        NXGReports.addStep("verified Element: uploadsADocumentSlider displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(commentsOnEngagementSlider);
        NXGReports.addStep("verified Element: commentsOnEngagementSlider displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(createANewRequestSlider);
        NXGReports.addStep("verified Element: createANewRequestSlider displayed.", LogAs.PASSED, (CaptureScreen)null);
    }
    public void verifyElementsOnDevicesTab() {
        waitForVisibleElement(myDeviceTitle);
        NXGReports.addStep("verified Element: myDeviceTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(numberDevicesText);
        NXGReports.addStep("verified Element: numberDevicesText displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(computerImage);
        NXGReports.addStep("verified Element: computerImage displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(deviceCustomName);
        NXGReports.addStep("verified Element: deviceCustomName displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(deviceName);
        NXGReports.addStep("verified Element: deviceName displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(viewButton);
        NXGReports.addStep("verified Element: viewButton displayed.", LogAs.PASSED, (CaptureScreen)null);
        waitForVisibleElement(addAnotherButton);
        NXGReports.addStep("verified Element: addAnotherButton displayed.", LogAs.PASSED, (CaptureScreen)null);
    }
    public void inputFullName(String TextVlaue){
        waitForVisibleElement(fullNameTextBox);
        fullNameTextBox.sendKeys(TextVlaue);
    }
    public void sendTabkeyFullNameTxt(){
        sendTabkey(fullNameTextBox);
    }
    public void sendTabkeyPhoneNumberTxt(){
        sendTabkey(phoneNoTextBox);
    }
}
