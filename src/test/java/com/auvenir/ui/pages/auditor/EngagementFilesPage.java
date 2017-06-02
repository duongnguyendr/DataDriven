package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class EngagementFilesPage extends AbstractPage {

    public EngagementFilesPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "module-filemanager-titleSpan")
    private WebElement eleFilesTxt;

    public WebElement getEleFilesTxt() {
        return eleFilesTxt;
    }

    @FindBy(xpath = "//img[@class='module-fm-emptyClipboard']")
    private WebElement eleEmptyClipbrdImg;

    public WebElement getEleEmptyClipbrdImg() {
        return eleEmptyClipbrdImg;
    }

    @FindBy(xpath = "//p[@class='module-fm-emptyText']")
    private WebElement eleNoFilesTxt;

    public WebElement getEleNoFilesTxt() {
        return eleNoFilesTxt;
    }

    public void verifyDisplayElementInEngagementFilesPage(){
        validateDisPlayedElement(eleFilesTxt, "Files Text");
        validateDisPlayedElement(eleEmptyClipbrdImg, "Empty Clipboard Image");
        validateDisPlayedElement(eleNoFilesTxt, "'You haven't added any files yet.' text");
    }

}
