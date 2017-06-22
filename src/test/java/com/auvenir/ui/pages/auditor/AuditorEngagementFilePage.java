package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tan.pham on 6/22/2017.
 */
public class AuditorEngagementFilePage extends AbstractPage {
    public AuditorEngagementFilePage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    private static final String PAGE_TITLE = "Files";
    @FindBy(xpath = "//div[@class='pageHeader-leftContainer']//input[@id='a-header-title']")
    private WebElement dashboardTextEle;

    @FindBy(xpath = "//h4[@id='module-filemanager-title']//span[@id='module-filemanager-titleSpan']")
    private WebElement elePageTitle;

    @FindBy(xpath = "//thead[@class='module-fm-tableHeader']/td/div")
    private WebElement eleAllFileCheckBox;

    @FindBy(xpath = "//*[@id='module-fm-download']")
    private WebElement eleDownloadIcon;

    @FindBy(xpath = "//button[@id='fm-downloadBtn']")
    private  WebElement eldDownloadButtonInPopup;

    @FindBy(xpath = "//*[@class='au-modal-container modalTransition-popUp-container']//label[contains(text(),'Ready To Download')]")
    private WebElement elePopupTitle;

    /**
     * Verify engagement file of engagement
     * @param engagementName : engagement name need check
     */
    public void verifyDetailsEngagementPage(String engagementName){
        waitForVisibleElement(dashboardTextEle, "dashboard text");
        validateAttributeElement(dashboardTextEle, "value", engagementName);
        waitForVisibleElement(elePageTitle, "page title");
        validateAttributeElement(elePageTitle, "text", PAGE_TITLE);
        waitForClickableOfElement(eleAllFileCheckBox, "all file check box");
        waitForClickableOfElement(eleDownloadIcon, "down load icon");
    }

    /**
     * Click on down load icon
     */
    public void clickOnDownLoadIcon(){
        waitForVisibleElement(eleDownloadIcon, "down load icon");
        hoverElement(eleDownloadIcon, "hover down load icon");
        clickElement(eleDownloadIcon);
    }

    /**
     * Click on all file check box
     */
    public void clickOnAllFileCheckBox(){
        waitForVisibleElement(eleAllFileCheckBox, "all file check box");
        hoverElement(eleAllFileCheckBox, "hover all file check box");
        clickElement(eleAllFileCheckBox);
    }

    /**
     * Click on down load button in popup
     */
    public void clickOnDownloadButtonInPopup(){
        waitForVisibleElement(eldDownloadButtonInPopup, "down load button in popup");
        hoverElement(eldDownloadButtonInPopup, "hover download button icon");
        clickElement(eldDownloadButtonInPopup);
    }

    /**
     * Verify down load popup
     */
    public void verifyDownLoadPopup(){
        waitForVisibleElement(elePopupTitle, "down load popup title");
        validateElementText(elePopupTitle,"Ready To Download");
    }
}
