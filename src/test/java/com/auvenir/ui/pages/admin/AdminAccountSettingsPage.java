package com.auvenir.ui.pages.admin;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
Created by: Doai. Tran
Date: 27-Apr-2017
 */
public class AdminAccountSettingsPage extends AbstractPage {
    AuvenirPage auvenirPage = null;
    WebElement SelectStatus = null;
    private int waitTime = 30;
    public AdminAccountSettingsPage(Logger logger,WebDriver driver) {
        super(logger,driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
    }

    @FindBy(xpath = "//img[@src='images/logos/auvenir/auvenir.svg']")
    private WebElement eleAuvenirLogoImg;
    public WebElement getAuvenirLogoImg() {
        return this.eleAuvenirLogoImg;
    }
    @FindBy(id = "dashboardUsername")
    private WebElement dashboardUserNameEle;
    public WebElement getDashboardUserNameEle() {
        return this.dashboardUserNameEle;
    }
    @FindBy(id = "navTitle")
    private WebElement settingTitle;
    public WebElement getSettingTitle() {
        return this.settingTitle;
    }
    @FindBy(id = "link-setting-account")
    private WebElement accountTab;
    public WebElement getAccountTab() {
        return this.accountTab;
    }
    @FindBy(id = "link-setting-device")
    private WebElement devicesTab;
    public WebElement getDevicesTab() {
        return this.devicesTab;
    }
    @FindBy(id = "titleContainer")
    private WebElement accountSettingTitle;
    public WebElement getAccountSettingTitle() {
        return this.accountSettingTitle;
    }
    @FindBy(id = "acc-ay-fullName")
    private WebElement fullNameTextBox;
    public WebElement getFullnameTextBox() {
        return this.fullNameTextBox;
    }
    @FindBy(id = "acc-ay-email")
    private WebElement emailTextBox;
    public WebElement getEmailTextBox() {
        return this.emailTextBox;
    }
    @FindBy(id = "acc-ay-phone")
    private WebElement phoneNoTextBox;
    public WebElement getPhoneNoTextBox() {
        return this.phoneNoTextBox;
    }
    @FindBy(id = "acc-ay-photo")
    private WebElement userPhoto;
    public WebElement getUserPhoto() {
        return this.userPhoto;
    }
    @FindBy(id = "uploadButton")
    private WebElement uploadButton;
    public WebElement getUploadButton() {
        return this.uploadButton;
    }
    @FindBy(xpath = "//*[@class='auvbtn secondary']")
    private WebElement deactivateButton;
    public WebElement getDeactivateButton() {
        return this.deactivateButton;
    }
    @FindBy(xpath = "//*[@class='auvbtn primary']")
    private WebElement updateButton;
    public WebElement getUpdateButton() {
        return this.updateButton;
    }
    @FindBy(xpath = "//*[@id='card-Mydevices']/div[1]/div")
    private WebElement myDeviceTitle;
    public WebElement getMyDeviceTitle() {
        return this.myDeviceTitle;
    }
    @FindBy(id = "pNumDevices")
    private WebElement numberDevicesText;
    public WebElement getNumberDevicesText() {
        return this.numberDevicesText;
    }
    @FindBy(xpath = "//img[@src='images/illustrations/devices/Desktop.svg']")
    private WebElement computerImage;
    public WebElement getComputerImage() {
        return this.computerImage;
    }
    @FindBy(xpath = "//*[@class='c-devices-deviceCustomName']")
    private WebElement deviceCustomName;
    public WebElement getDeviceCustomName() {
        return this.deviceCustomName;
    }
    @FindBy(xpath = "//*[@class='c-devices-deviceName']")
    private WebElement deviceName;
    public WebElement getDeviceName() {
        return this.deviceName;
    }
    @FindBy(xpath = "//*[@class='btn-lg ghost c-devices-viewDeviceBtn']")
    private WebElement viewButton;
    public WebElement getViewButton() {
        return this.viewButton;
    }
    @FindBy(xpath = "//*[@id='card-Mydevices']/button")
    private WebElement addAnotherButton;
    public WebElement getAddAnotherButton() {
        return this.addAnotherButton;
    }
    @FindBy(xpath = "/html/body/footer/div/div/div[1]/span")
    private WebElement allRightReservedLink;
    public WebElement getAllRightReservedText() {
        return this.allRightReservedLink;
    }
    @FindBy(xpath = "/html/body/footer/div/div/div[2]/a[1]")
    private WebElement termOfServiceLink;
    public WebElement getTermOfService() {
        return this.termOfServiceLink;
    }
    @FindBy(xpath = "/html/body/footer/div/div/div[2]/a[3]")
    private WebElement privacyStatementLink;
    public WebElement getPrivacyStatementLink() {
        return this.privacyStatementLink;
    }
    @FindBy(xpath = "/html/body/footer/div/div/div[2]/a[5]")
    private WebElement cookiesNoticeLink;
    public WebElement getCookiesNoticeLink() {
        return this.cookiesNoticeLink;
    }
    @FindBy(id = "h-ddl-item-settings")
    private WebElement settingsTabEle;
    public WebElement getSettingTabEle() {
        return this.settingsTabEle;
    }

    public void goToSettingPage() {
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 60L);
        wait.until(ExpectedConditions.visibilityOf(this.dashboardUserNameEle));
        getDashboardUserNameEle().click();
        wait.until(ExpectedConditions.visibilityOf(this.settingsTabEle));
        getSettingTabEle().click();
    }

    public void verifyElementsHeader() {
        getLogger().info("verify Element: eleAuvenirLogoImg displayed.");
        waitForVisibleElement(this.eleAuvenirLogoImg);
        NXGReports.addStep("verified Element: eleAuvenirLogoImg displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: dashboardUserNameEle displayed.");
        waitForVisibleElement(this.dashboardUserNameEle);
        NXGReports.addStep("verified Element: dashboardUserNameEle displayed.", LogAs.PASSED, (CaptureScreen)null);
    }

    public void verifyElementsOnAccountTab() {
        getLogger().info("verify Element: settingTitle displayed.");
        waitForVisibleElement(this.settingTitle);
        NXGReports.addStep("verified Element: settingTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: accountTab displayed.");
        waitForVisibleElement(this.accountTab);
        NXGReports.addStep("verified Element: accountTab displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: devicesTab displayed.");
        waitForVisibleElement(this.devicesTab);
        NXGReports.addStep("verified Element: devicesTab displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: accountSettingTitle displayed.");
        waitForVisibleElement(this.accountSettingTitle);
        NXGReports.addStep("verify Element: accountSettingTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: fullNameTextBox displayed.");
        waitForVisibleElement(this.fullNameTextBox);
        NXGReports.addStep("verified Element: fullNameTextBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: emailTextBox displayed.");
        waitForVisibleElement(this.emailTextBox);
        NXGReports.addStep("verified Element: emailTextBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: phoneNoTextBox displayed.");
        waitForVisibleElement(this.phoneNoTextBox);
        NXGReports.addStep("verified Element: phoneNoTextBox displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: userPhoto displayed.");
        waitForVisibleElement(this.userPhoto);
        NXGReports.addStep("verified Element: userPhoto displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: uploadButton displayed.");
        waitForVisibleElement(this.uploadButton);
        NXGReports.addStep("verified Element: uploadButton displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: deactivateButton displayed.");
        validateElementText(this.deactivateButton, "Deactivate My Account");
        NXGReports.addStep("verified Element: deactivateButton displayed and disable", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: updateButton displayed.");
        validateElementText(this.updateButton, "Update");
        NXGReports.addStep("verified Element: updateButton displayed and disable", LogAs.PASSED, (CaptureScreen)null);
    }

    public void navigateToDevicesTab() {
        waitForVisibleElement(this.devicesTab);
        getLogger().info("verify Element: devicesTab displayed.");
        devicesTab.click();
        NXGReports.addStep("Go to Device Tab successfully.", LogAs.PASSED, (CaptureScreen)null);
    }

    public void verifyElementsOnDevicesTab() {
        getLogger().info("verify Element: settingTitle displayed.");
        this.waitForVisibleElement(this.settingTitle);
        NXGReports.addStep("verified Element: settingTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: accountTab displayed.");
        waitForVisibleElement(this.accountTab);
        NXGReports.addStep("verified Element: accountTab displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: devicesTab displayed.");
        waitForVisibleElement(this.devicesTab);
        NXGReports.addStep("verified Element: devicesTab displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: myDeviceTitle displayed.");
        waitForVisibleElement(this.myDeviceTitle);
        NXGReports.addStep("verified Element: myDeviceTitle displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: numberDevicesText displayed.");
        waitForVisibleElement(this.numberDevicesText);
        NXGReports.addStep("verified Element: numberDevicesText displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: computerImage displayed.");
        waitForVisibleElement(this.computerImage);
        NXGReports.addStep("verified Element: computerImage displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: deviceCustomName displayed.");
        waitForVisibleElement(this.deviceCustomName);
        NXGReports.addStep("verified Element: deviceCustomName displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: deviceName displayed.");
        waitForVisibleElement(this.deviceName);
        NXGReports.addStep("verified Element: deviceName displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: viewButton displayed.");
        waitForVisibleElement(this.viewButton);
        NXGReports.addStep("verify Element: viewButton displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: addAnotherButton displayed.");
        waitForVisibleElement(this.addAnotherButton);
        NXGReports.addStep("verified Element: addAnotherButton displayed.", LogAs.PASSED, (CaptureScreen)null);
    }

    public void verifyElementsFooter() {
        getLogger().info("verify Element: allRightReservedLink displayed.");
        waitForVisibleElement(this.allRightReservedLink);
        NXGReports.addStep("verified Element: allRightReservedLink displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: termOfServiceLink displayed.");
        waitForVisibleElement(this.termOfServiceLink);
        NXGReports.addStep("verified Element: termOfServiceLink displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: privacyStatementLink displayed.");
        waitForVisibleElement(this.privacyStatementLink);
        NXGReports.addStep("verified Element: privacyStatementLink displayed.", LogAs.PASSED, (CaptureScreen)null);
        getLogger().info("verify Element: cookiesNoticeLink displayed.");
        waitForVisibleElement(this.cookiesNoticeLink);
        NXGReports.addStep("verified Element: cookiesNoticeLink displayed.", LogAs.PASSED, (CaptureScreen)null);
    }

    public void inputValueFullName(String Value) {
        waitForVisibleElement(fullNameTextBox);
        fullNameTextBox.clear();
        fullNameTextBox.sendKeys(Value);
    }

    public void inputValuePhoneNumber(String Value) {
        waitForVisibleElement(phoneNoTextBox);
        phoneNoTextBox.clear();
        phoneNoTextBox.sendKeys(Value);
    }

    public void verifyEmailTextBoxIsDisable() {
        validatDisabledElement(phoneNoTextBox);
    }
}
