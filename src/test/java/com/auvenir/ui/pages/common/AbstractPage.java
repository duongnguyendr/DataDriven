package com.auvenir.ui.pages.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.util.List;

//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by hungcuong1105 on 4/15/2017.
 * Updated by Doai.Tran on 5/9/2017.
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
            NXGReports.addStep(elementName + " is visibility.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(elementName + " is not visibility.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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
        try{
            element.isDisplayed();
            getLogger().info("Element : " + element.getText() +"is presented");
            NXGReports.addStep(element.getText() + " is presented.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is not presented");
            NXGReports.addStep("Element : " + element.getText() +"is not presented", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void validateEnabledElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify enabled of: " + element.getText());
        try{
            element.isEnabled();
            getLogger().info("Element : " + element.getText() +"is enable");
            NXGReports.addStep(element.getText() + " is enable.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is not enable.");
            NXGReports.addStep("Element : " + element.getText() +"is not enable", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void validateSelectedElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify selected of: " + element.getText());
        try{
            element.isSelected();
            getLogger().info("Element : " + element.getText() +"is selected.");
            NXGReports.addStep(element.getText() + " is selected.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is not selected.");
            NXGReports.addStep("Element : " + element.getText() +"is not selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void validateNotSelectedElement(WebElement element) throws InvalidElementStateException
    {
        getLogger().info("verify not selected of: " + element.getText());
        try{
            if(!element.isSelected()){
                getLogger().info("Element : " + element.getText() +"is not selected.");
                NXGReports.addStep(element.getText() + " is not selected.", LogAs.PASSED, null);
            }else {
                new Exception();
            }
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is selected.");
            NXGReports.addStep("Element : " + element.getText() +"is selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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
            NXGReports.addStep("Scrolled Page up.", LogAs.PASSED, null);

        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("scroll Page up unsuccessfully.");
            NXGReports.addStep("scroll Page up unsuccessfully.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void scrollPageDown() throws AWTException {
        getLogger().info("Try to scroll Page down.");
        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            NXGReports.addStep("Scrolled Page down.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("scroll Page down unsuccessfully.");
            NXGReports.addStep("scroll Page down unsuccessfully.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     @Description In order to wait element to be visible.
     @param element element defined on page class
     */
    public void waitForVisibleElement(WebElement element){
        getLogger().info("Try to waitForVisibleElement: " +element.getText());
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            NXGReports.addStep("eElement: "+ element.getText()+"is visible.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element: " + element.getText() +"is not visible.");
            NXGReports.addStep("eElement: "+ element.getText()+"is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForPresentOfLocator(By by){
        getLogger().info("Try to waitForPresentOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            NXGReports.addStep("eElement: is presented.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not present.");
            NXGReports.addStep("eElement: is not present.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForVisibleOfLocator(By by){
        getLogger().info("Try to waitForVisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            NXGReports.addStep("eElement is visible.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not visible.");
            NXGReports.addStep("eElement: is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForInvisibleOfLocator(By by){
        getLogger().info("Try to waitForInvisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            NXGReports.addStep("eElement is invisible.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not invisible.");
            NXGReports.addStep("eElement: is not invisible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForClickableOfLocator(By by){
        getLogger().info("Try to waitForClickableOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            NXGReports.addStep("eElement is clickable.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable.");
            NXGReports.addStep("eElement: is not clickable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForClickableOfElement(WebElement element){
        getLogger().info("Try to waitForClickableOfElement: "+element.getText());
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            NXGReports.addStep("eElement is clickable.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: "+element.getText());
            NXGReports.addStep("eElement: is not clickable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void waitForInvisibleElement(WebElement element){
        getLogger().info("Try to waitForInvisibleElement: "+element.getText());
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOf(element));
            NXGReports.addStep("eElement is invisible.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not invisible on Element: "+element.getText());
            NXGReports.addStep("eElement: is not invisible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    
    /**
    @Description In order to wait element list to be visible.
    @param element element defined on page class
    */
   public void waitForVisibilityOfAllElements(List<WebElement> elements){
       getLogger().info("Try to waitForVisibilityOfAllElements ");
       try {
           WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
           wait.until(ExpectedConditions.visibilityOfAllElements(elements));
           NXGReports.addStep("Element list: is visible.", LogAs.PASSED, null);
       }catch (Exception e){
           AbstractService.sStatusCnt++;
           getLogger().info("Element list is not visible.");
           NXGReports.addStep("Element list is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
       }
   }
   
   public void waitForVisibilityOfAllElementsLocatedBy(By by){
       getLogger().info("Try to waitForVisibilityOfAllElementsLocatedBy :"+getDriver().findElement(by).getTagName()+" type "+getDriver().findElement(by).getAttribute("type"));
       try {
           WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
           wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
           NXGReports.addStep("Element:"+getDriver().findElement(by).getTagName()+" is visible.", LogAs.PASSED, null);
       }catch (Exception e){
           AbstractService.sStatusCnt++;
           getLogger().info("Element:"+getDriver().findElement(by).getTagName()+" is not visible.");
           NXGReports.addStep("eElement: is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
       }
   }
   
   
    public void validateDisabledElement(WebElement element)
    {
        getLogger().info("verify disable of: " + element.getText());
        try {
            if(!(element.isEnabled()))
            {
                getLogger().info(element.getTagName() + " is disabled");
                NXGReports.addStep("eElement is disable.", LogAs.PASSED, null);
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info(element.getText() + " is  not disabled");
            NXGReports.addStep("eElement: is not disabled.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to go to setting page.");
        }
    }
    /**
    @Description: Click on element
     @param element element defined on page class
     */
    public void clickElement(WebElement element){
        getLogger().info("Try to ClickElement: "+element.getText());
        try{
            waitForClickableOfElement(element);
            element.click();
            NXGReports.addStep("Clicked on element: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to Click on: " +element.getText());
            NXGReports.addStep("Unable to Click on: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     @Description: Click and Hold on element
     @param element element defined on page class
     */
    public void clickAndHold(WebElement element){
        getLogger().info("Try to ClickAndHold: "+element.getText());
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click(element);
            actions.perform();
            NXGReports.addStep("Clicked and Hold on element: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to ClickAndHold on: " +element.getText());
            NXGReports.addStep("Unable to ClickAndHold on: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     @Description: Hover on element
     @param element element defined on page class
     */
    public void hoverElement(WebElement element){
        getLogger().info("Try to hoverElement: "+element.getText());
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            NXGReports.addStep("Hover on element: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to hoverElement on: " +element.getText());
            NXGReports.addStep("Unable to hoverElement on: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * @Description: Send a String to textBox.
     * @param element element defined on page class
     */
    public void sendKeyTextBox(WebElement element, String text){
        getLogger().info("Try to sendKey on : "+element.getText());
        try {
            element.clear();
            element.sendKeys(text);
            NXGReports.addStep("Send text: "+text+ "on element: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendKey on: " +element.getText());
            NXGReports.addStep("Unable to sendKey on: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     *@Description: Clear all Strings to textBox.
     * @param element element defined on page class
     */
    public void clearTextBox(WebElement element){
        getLogger().info("Try to sendKey on : "+element.getText());
        try {
            element.clear();
            NXGReports.addStep("Cleared text: on element: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to clear on: " +element.getText());
            NXGReports.addStep("Unable to clear on: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     *@Description: Click on checkbox
     * @param element element defined on page class
     */
    public void clickOnCheckBox(WebElement element){
        getLogger().info("Try to click on checkbox: "+element.getText());
        try {
            waitForClickableOfElement(element);
            element.click();
            NXGReports.addStep("Click on checkbox: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to click on checkbox element: " +element.getText());
            NXGReports.addStep("Unable to click on checkbox: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     *@Description: select a value on dropdown via visible text
     * @param element element defined on page class
     * @param selText Visible text that you want to select on dropdown
     */
    public void selectByVisibleText(WebElement element, String selText){
        getLogger().info("Try to selectByVisibleText on element: "+element.getText());
        try {
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(selText);
            NXGReports.addStep("selectByVisibleText on checkbox: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByVisibleText on element: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     *@Description: select a value on dropdown via visible text
     * @param element element defined on page class
     * @param selValue Value that you want to select on dropdown
     */
    public void selectByValue(WebElement element, String selValue){
        getLogger().info("Try to selectByValue on element: "+element.getText());
        try {
            Select dropDown = new Select(element);
            dropDown.selectByValue(selValue);
            NXGReports.addStep("selectByValue on checkbox: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByValue on element: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     *@Description: select a value on dropdown via visible text
     * @param element element defined on page class
     * @param selIndex Value that you want to select on dropdown
     */
    public void selectByIndex(WebElement element, int selIndex){
        getLogger().info("Try to selectByIndex on element: "+element.getText());
        try {
            Select dropDown = new Select(element);
            dropDown.selectByIndex(selIndex);
            NXGReports.addStep("selectByIndex on checkbox: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByIndex on element: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     * @Description: Send a tabKey.
     * @param element element defined on page class
     */
    public void sendTabkey(WebElement element) {
        getLogger().info("Try to sendTabkey: "+element.getText());
        try {
            element.sendKeys(Keys.TAB);
            element.sendKeys(Keys.ENTER);
            NXGReports.addStep("sendTabkey on element: "+ element.getText(), LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendTabkey on: " +element.getText());
            NXGReports.addStep("Unable to sendTabkey on: " +element.getText(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void validateAttributeElement(WebElement element, String attributeName, String expectedAttributeValue){
        getLogger().info("verify Attribute " + attributeName + " of: " + element.toString());
        String actualAttributeValue = null;
        try {
            actualAttributeValue = element.getAttribute(attributeName).trim();
            getLogger().info("actualAttributeValue of " + attributeName + " is: " + actualAttributeValue);
            if (actualAttributeValue.equals(expectedAttributeValue)) {
                getLogger().info(element.getTagName() + " has attribute " + actualAttributeValue);
                NXGReports.addStep(element.getTagName() + " has attribute " + actualAttributeValue, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                getLogger().info(element.getTagName() + " has attribute not as expected with actual:" + actualAttributeValue);
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(element.getTagName() + " has attribute not as expected with actual:" + actualAttributeValue);
            NXGReports.addStep(element.getTagName() + " has attribute not as expected with actual:" + actualAttributeValue, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void validateCSSValueElement(WebElement element, String cSSValueName, String expectedCSSValue) {
        getLogger().info("verify CSS Value " + expectedCSSValue + " of: " + element.getTagName()+" type "+ element.getAttribute("type"));
        String actualCSSValue = null;
        try {
        	
            actualCSSValue = element.getCssValue(cSSValueName);
            System.out.println(actualCSSValue);
        	System.out.println(expectedCSSValue);
            getLogger().info("actualCSSValue of " + cSSValueName + " is: " + actualCSSValue);
            if (actualCSSValue.equals(expectedCSSValue)) {
                getLogger().info(element.getTagName() + " has CSSValue " + actualCSSValue);
                NXGReports.addStep(element.getTagName() + " has CSSValue " + actualCSSValue, LogAs.PASSED, null);
            } else {
                AbstractRefactorService.sStatusCnt++;
                getLogger().info(element.getTagName() + " has CSSValue " + actualCSSValue);
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(element.getTagName() + " has CSSValue " + actualCSSValue);
            NXGReports.addStep(element.getTagName() + " has CSSValue " + actualCSSValue, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
