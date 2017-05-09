package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by hungcuong1105 on 4/15/2017.
 */
public class AbstractPage {
    private    Logger logger = null;
    private  WebDriver driver = null;
    private static final int waitTime = 60;

    public AbstractPage(Logger logger,WebDriver driver){
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements( new AjaxElementLocatorFactory(driver,waitTime),this);
    }
    public WebDriver getDriver(){

        return driver;
    }


    public Logger getLogger(){
        return logger;
    }

    @FindBy(xpath = "//span[contains(text(),'© 2017 Auvenir Inc')]")
    private WebElement eleAuvenirIncTxt;

    @FindBy(xpath = "//span[contains(text(),'© 2017 Auvenir Inc')]//..//..//a[contains(text(),'Terms of Service')]")
    private WebElement eleTermsOfServiceLnk;

    @FindBy(xpath = "(//span[contains(text(),'© 2017 Auvenir Inc')]//..//..//a[contains(text(),'.')])[last()-1]")
    private WebElement eleTermsOfServiceDotTxt;

    @FindBy(id = "privacy")
    private WebElement elePrivacyStatementLnk;

    @FindBy(xpath = "(//span[contains(text(),'© 2017 Auvenir Inc')]//..//..//a[contains(text(),'.')])[last()]")
    private WebElement elePrivacyStatementDotTxt;

    @FindBy(id = "cookies")
    private WebElement eleCookieNoticeLnk;

    @FindBy(id="dashboardUsername")
    private WebElement dashboardUserNameEle;

    @FindBy(id="h-ddl-item-settings")
    WebElement settingsTabEle;

    public void verifyFooter()
    {
        validateDisPlayedElement(eleAuvenirIncTxt);
        validateDisPlayedElement(eleTermsOfServiceLnk);
        validateDisPlayedElement(eleTermsOfServiceDotTxt);
        validateDisPlayedElement(elePrivacyStatementLnk);
        validateDisPlayedElement(elePrivacyStatementDotTxt);
        validateDisPlayedElement(eleCookieNoticeLnk);
    }
    public void verifyTermsOfServiceLink() throws AWTException{
        getLogger().info("Verify Terms of service link.");
        eleTermsOfServiceLnk.click();
        waitForVisibleOfLocator(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
        getLogger().info("verify texts are rendered.");

        WebElement terms = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-title']"));
        validateElementText(terms,"Terms of Service");
        WebElement english = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='english']"));
        validateElementText(english,"English");
        WebElement french = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='french']"));
        validateElementText(french,"French");
        WebElement termsDate = getDriver().findElement(By.xpath("//div[@id='custom-modal']//div[@id='agreement']/h3"));
        validateElementText(termsDate,"Effective: 16th January, 2017");
        french.click();
        getLogger().info("click close Terms of Service wizard.");
        getDriver().findElement(By.xpath("//div[@id='custom-modal']//span[@class='custom-close']")).click();

    }
    public void verifyPrivacyStateLink() {
        getLogger().info("Verify Pricacy statement link.");
        elePrivacyStatementLnk.click();
        waitForVisibleOfLocator(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
        WebElement auvenir = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
        validateElementText(auvenir,"Auvenir");
        WebElement terms = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-title']"));
        validateElementText(terms,"Privacy Statement");
        WebElement english = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='english']"));
        validateElementText(english,"English");
        WebElement french = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='french']"));
        validateElementText(french,"French");
        WebElement termsDate = getDriver().findElement(By.xpath("//div[@id='custom-modal']//div[@id='agreement']/h3"));
        validateElementText(termsDate,"Last revised: January 16th, 2017");
        french.click();
        getDriver().findElement(By.xpath("//div[@id='custom-modal']//span[@class='custom-close']")).click();

    }

    public void verifyCookieNotice() {
        getLogger().info("verify cookie notices page.");
        eleCookieNoticeLnk.click();
        waitForVisibleOfLocator(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
        WebElement auvenir = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-header']"));
        validateElementText(auvenir,"Auvenir");
        WebElement terms = getDriver().findElement(By.xpath("//div[@id='custom-modal']//h3[@class='custom-modal-title']"));
        validateElementText(terms,"Cookie Notice");
        WebElement english = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='english']"));
        validateElementText(english,"English");
        WebElement french = getDriver().findElement(By.xpath("//div[@id='custom-modal']//a[@id='french']"));
        validateElementText(french,"French");
        WebElement termsDate = getDriver().findElement(By.xpath("//div[@id='custom-modal']//div[@id='agreement']/h3"));
        validateElementText(termsDate,"Last revised: January 16th, 2017");
        french.click();
        getDriver().findElement(By.xpath("//div[@id='custom-modal']//span[@class='custom-close']")).click();

    }

    public void visibilityOfElementWait(WebElement webElement, String elementName, int waitTime) {
        try {
         WebDriverWait   sWebDriverWait = new WebDriverWait(driver, waitTime);
            sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(elementName + " is not Visible", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void validateElementText(WebElement webElement, String elementText) {
        try {
            getLogger().info("Check renderd of text: " + elementText);
            getLogger().info("Actual Text is displayed: " + webElement.getText().trim());
            Assert.assertEquals(webElement.getText().trim(),elementText);
            NXGReports.addStep(elementText + " rendered", LogAs.PASSED,null);
        }catch (AssertionError error) {
            getLogger().info(error);
            NXGReports.addStep(elementText + " rendered", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void validateDisPlayedElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify Displayed of: " + element.getText());

        try
        {
            element.isDisplayed();
            NXGReports.addStep(element.getTagName() + " is displayed", LogAs.PASSED, null);
        }

        catch (Exception e)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }
    public void validateEnabledElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify enabled of: " + element.getText());

        try
        {
            element.isEnabled();
            NXGReports.addStep(element.getTagName() + " is enabled", LogAs.PASSED, null);
        }

        catch (Exception e)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is  enabled", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }
    public void validateSelectedElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify selected of: " + element.getText());

        try
        {
            element.isEnabled();
            NXGReports.addStep(element.getTagName() + " is selected", LogAs.PASSED, null);
        }

        catch (Exception e)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is  selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }
    /*
    Improvement to detect value: true/ false after take actions
    Updated by: Doai.Tran 8/5/2017
     */
    public void scrollPageUp() throws AWTException {
        getLogger().info("Try to scroll Page up.");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_UP);
            robot.keyRelease(KeyEvent.VK_PAGE_UP);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to scroll Page up.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void scrollPageDown() throws AWTException {
        getLogger().info("Try to scroll Page down.");
        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to scroll Page down.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void waitForVisibleElement(WebElement element){
        getLogger().info("Try to waitForVisibleElement: " +element.getText());
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForPresentOfLocator(By by){
        getLogger().info("Try to waitForPresentOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not present.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForVisibleOfLocator(By by){
        getLogger().info("Try to waitForVisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForInvisibleOfLocator(By by){
        getLogger().info("Try to waitForInvisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not invisible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForClickableOfLocator(By by){
        getLogger().info("Try to waitForClickableOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not clickable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForClickableOfElement(WebElement element){
        getLogger().info("Try to waitForClickableOfElement: "+element.getText());
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not clickable on Element: "+element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForInvisibleElement(WebElement element){
        getLogger().info("Try to waitForInvisibleElement: "+element.getText());
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOf(element));
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not invisible on Element: "+element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void validateDisabledElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify enabled of: " + element.getText());
        try {
            if(!(element.isEnabled()))
            {
            NXGReports.addStep(element.getTagName() + " is disabled", LogAs.PASSED, null);
            }
        }catch (Exception e){
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is  enabled", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /*
    Method to go to setting page for Admin, Auditor, Client
     */
    public void navigateToSettingsPage() {
        try {
            waitForClickableOfElement(dashboardUserNameEle);
            dashboardUserNameEle.click();
            waitForPresentOfLocator(By.xpath("//a[contains(text(),'Settings')]"));
            waitForClickableOfElement(settingsTabEle);
            settingsTabEle.click();
        }catch (Exception e){
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep("Unable to go to setting page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void ClickAndHold(WebElement element){
        getLogger().info("Try to ClickAndHold: "+element.getText());
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click(element);
            actions.perform();
        }catch (Exception e){
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep("Unable to ClickAndHold on: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void HoverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.build().perform();
    }
    public void sendTabkey(WebElement element) {
        getLogger().info("Try to sendTabkey: "+element.getText());
        try {
            element.sendKeys(Keys.TAB);
            element.sendKeys(Keys.ENTER);
        }catch (Exception e){
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep("Unable to sendTabkey on: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void validateAttributeElement(WebElement element, String attributeName, String expectedAttributeValue) throws InvalidElementStateException {
        getLogger().info("verify Attribute " + attributeName + " of: " + element.toString());
        String actualAttributeValue = null;
        try {
            actualAttributeValue = element.getAttribute(attributeName).trim();
            getLogger().info("actualAttributeValue of " + attributeName + " is: " + actualAttributeValue);
            if (actualAttributeValue.equals(expectedAttributeValue)) {
                NXGReports.addStep(element.getTagName() + " has attribute " + actualAttributeValue, LogAs.PASSED, null);
            } else {
                AbstractRefactorService.sStatusCnt++;
                NXGReports.addStep(element.getTagName() + " has attribute " + actualAttributeValue, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getTagName() + " has attribute " + actualAttributeValue, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void validateCSSValueElement(WebElement element, String cSSValueName, String expectedCSSValue) throws InvalidElementStateException {
        getLogger().info("verify CSS Value " + expectedCSSValue + " of: " + element.toString());
        String actualCSSValue = null;
        try {
            actualCSSValue = element.getCssValue(cSSValueName);
            getLogger().info("actualCSSValue of " + cSSValueName + " is: " + actualCSSValue);
            if (actualCSSValue.equals(expectedCSSValue)) {
                NXGReports.addStep(element.getTagName() + " has CSSValue " + actualCSSValue, LogAs.PASSED, null);
            } else {
                AbstractRefactorService.sStatusCnt++;
                NXGReports.addStep(element.getTagName() + " has CSSValue " + actualCSSValue, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getTagName() + " has CSSValue " + actualCSSValue, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
