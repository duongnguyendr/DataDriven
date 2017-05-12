package com.auvenir.ui.pages.common;

//import library
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//import org.testng.log4testng.Logger;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.auvenir.ui.services.AbstractRefactorService;
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
    public static  final int smallerTimeOut = 500;
    public static  final int smallTimeOut = 1000;


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

    // ====================== ======================




    // Vien.Pham added EditCategories Elements

    @FindBy(xpath = "//*[@id=\"category-dropdown-menu\"]/div[2]")
    WebElement eleEditCategory;
    @FindBy(xpath = "//*[@id=\"m-ce-systemContainer\"]/h3/text()")
    WebElement eleEditCategoryTitle;
    @FindBy(xpath = "//*[@id=\"edit-category-container\"]/div[1]")
    WebElement eleEditCategoryGuide;
    @FindBy(id = "cat-edit-btn")
    WebElement eleEditCategoryPen;
    @FindBy(id = "cat-trash-btn")
    WebElement eleEditCategoryTrash;
    @FindBy (id = "m-ce-cancelBtn")
    WebElement eleEditCategoryCancelBtn;
    @FindBy(id = "category-updateBtn")
    WebElement eleEditCategorySaveBtn;
    @FindBy(xpath = "//img[@id='modal-close-categoryModel-2Dd9bM38sb25ObfMVSJG6Ui8tLVE205c']")
    WebElement eleEditCategoryCloseBtn;

    /*
    Elements for create a Category
    Create by: Minh.Nguyen & Thuan.Duong
    Update: Doai.Tran
     */

    @FindBy(xpath = "//*[@id='category-dropdown']/div[@class='text']")
    private WebElement eleCategoryComboBox;
    @FindBy(xpath = "//*[@id=\"category-dropdown-menu\"]/div[1]")
    private WebElement eleXpathCreateNewCategory;
    @FindBy(id="category-name")
    private WebElement eleIdCategoryName;
    @FindBy(id="category-color")
    private WebElement eleIdCategoryColor;
    @FindBy(xpath = "//*[@id=\"category-color-container\"]/ul/li[4]")
    private WebElement eleXpathDetailCateColor;
    @FindBy(id="category-addBtn")
    private WebElement eleIdBtnAddCategory;
    @FindBy(id="category-dropdown")
    private WebElement eleIdDdlCategory;
    @FindBy(xpath="\"id('todo-table')/tbody/tr\"")
    private WebElement tblXpathTodoTable;
    @FindBy(xpath="//*[@id=\"category-dropdown-menu\"]/div/a")
    private WebElement eleCategoryText;
    @FindBy(xpath = "/*//*[@id='category-dropdown']/div[@class='text']")
    private WebElement eleCategoryCombobox;
    public void verifyFooter()
    {
        validateDisPlayedElement(eleAuvenirIncTxt, "eleAuvenirIncTxt");
        validateDisPlayedElement(eleTermsOfServiceLnk,"eleAuvenirIncTxt");
        validateDisPlayedElement(eleTermsOfServiceDotTxt,"eleAuvenirIncTxt");
        validateDisPlayedElement(elePrivacyStatementLnk,"eleAuvenirIncTxt");
        validateDisPlayedElement(elePrivacyStatementDotTxt,"eleAuvenirIncTxt");
        validateDisPlayedElement(eleCookieNoticeLnk,"eleAuvenirIncTxt");
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

    /**
     *
     * @param webElement
     * @param elementName
     * @param waitTime
     */
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

    /**
     *
     * @param webElement  WebElement
     * @param elementText Text of Element be presented.
     */
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

    /**
     *
     * @param element
     * @throws InvalidElementStateException
     * @elementName Name of element that we want to verify
     */
    public void validateDisPlayedElement(WebElement element, String elementName) throws InvalidElementStateException
    {
        getLogger().info("verify Displayed of: " + element.getText());
        try{
            element.isDisplayed();
            getLogger().info("Element : " + element.getText() +"is presented");
            NXGReports.addStep("Element : "+ elementName + " is presented.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is not presented");
            NXGReports.addStep("Element : " + elementName +"is not presented", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     *
     * @param element element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */

    public void validateEnabledElement(WebElement element, String elementName) throws InvalidElementStateException
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

    /**
     *
     * @param element element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public void validateSelectedElement(WebElement element,String elementName) throws InvalidElementStateException
    {
        getLogger().info("verify selected of: " + element.getText());
        try{
            element.isSelected();
            getLogger().info("Element : " + element.getText() +"is selected.");
            NXGReports.addStep("Element: "+ elementName + " is selected.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is not selected.");
            NXGReports.addStep("Element : " + elementName +"is not selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     *
     * @param element element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public void validateNotSelectedElement(WebElement element, String elementName) throws InvalidElementStateException
    {
        getLogger().info("verify not selected of: " + element.getText());
        try{
            if(!element.isSelected()){
                getLogger().info("Element : " + element.getText() +"is not selected.");
                NXGReports.addStep("Element : " + elementName + " is not selected.", LogAs.PASSED, null);
            }else {
                new Exception();
            }
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is selected.");
            NXGReports.addStep("Element : " + elementName +"is selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void validateCssValueElement(WebElement element,String attributeName,String attributeValue) throws InvalidElementStateException
    {
        getLogger().info("verify style with "+ attributeName);


        try
        {
        	 Assert.assertEquals(element.getCssValue(attributeName),attributeValue);
            NXGReports.addStep(element.getTagName() + " has style with  "+attributeName, LogAs.PASSED, null);
        }

        catch (Exception e)
        {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getTagName() + " has style with  "+attributeName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void validateMaxlenght(WebElement webElement, int maxLenght) throws Exception{
        try {
            getLogger().info("verify input with max length with " + maxLenght +"character");
            webElement.click();
            webElement.sendKeys("limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character  limit with 255 character ");
            Assert.assertTrue(webElement.getAttribute("value").length()<=maxLenght);
            NXGReports.addStep("input with max length with " + maxLenght +"character", LogAs.PASSED,null);
        }catch (AssertionError error) {
            getLogger().info(error);
            NXGReports.addStep("input with max length with " + maxLenght +"character", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw error;
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
    /*
    Method to scrollPageDown
     */
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
     @param elementName Name of element that we want to verify
     */
    public void waitForVisibleElement(WebElement element, String elementName){
        getLogger().info("Try to waitForVisibleElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            NXGReports.addStep("Element: "+ elementName + " is visible.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element: " + element.getText() +"is not visible.");
            NXGReports.addStep("Element: "+ elementName +" is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     @Description In order to wait element to be present by locator.
     */
    public boolean waitForPresentOfLocator(By by){
        getLogger().info("Try to waitForPresentOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            NXGReports.addStep("Element is presented.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not present.");
            NXGReports.addStep("Element is not present.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /**
     @Description In order to wait element to be visible by locator.
     */
    public boolean waitForVisibleOfLocator(By by){
        getLogger().info("Try to waitForVisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            NXGReports.addStep("Element is visible.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not visible.");
            NXGReports.addStep("Element is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /**
     @Description In order to wait element to be invisible by locator.
     */
    public boolean waitForInvisibleOfLocator(By by){
        getLogger().info("Try to waitForInvisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            NXGReports.addStep("eElement is invisible.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not invisible.");
            NXGReports.addStep("eElement: is not invisible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /**
     @Description In order to wait element to be clickable by locator.
     */
    public boolean waitForClickableOfLocator(By by){
        getLogger().info("Try to waitForClickableOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            NXGReports.addStep("eElement is clickable.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable.");
            NXGReports.addStep("eElement: is not clickable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /**
     @Description In order to wait element to be visible.
     @param element element defined on page class
     @param elementName Name of element that we want to verify
     */
    public boolean waitForClickableOfElement(WebElement element, String elementName){
        getLogger().info("Try to waitForClickableOfElement: "+elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            NXGReports.addStep("Element: "+ elementName+" is  clickable.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: "+element.getText());
            NXGReports.addStep("Element: "+ elementName+" is not clickable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /**
     @Description In order to wait element to be visible.
     @param element element defined on page class
     @param elementName Name of element that we want to verify
     */
    public boolean waitForInvisibleElement(WebElement element, String elementName){
        getLogger().info("Try to waitForInvisibleElement: "+elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOf(element));
            NXGReports.addStep("Element: "+elementName+ " is invisible.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not invisible on Element: "+elementName);
            NXGReports.addStep("Element: "+elementName+" is not invisible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /**
     @Description In order to wait element to be visible.
     @param element element defined on page class
     @param elementName Name of element that we want to verify
     */
    public boolean validateDisabledElement(WebElement element, String elementName)
    {
        getLogger().info("verify disable of: " + elementName);
        try {
            if(!(element.isEnabled()))
            {
                getLogger().info(element.getTagName() + " is disabled");
                NXGReports.addStep("Element: "+elementName+" is disable.", LogAs.PASSED, null);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info(elementName + " is  not disabled");
            NXGReports.addStep("Element: "+elementName+" is not disabled.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /*
    Method to go to setting page for Admin, Auditor, Client
     */
    public void navigateToSettingsPage() {
        try {
            waitForClickableOfElement(dashboardUserNameEle,"dashboardUserNameEle");
            dashboardUserNameEle.click();
            waitForPresentOfLocator(By.xpath("//a[contains(text(),'Settings')]"));
            waitForClickableOfElement(settingsTabEle,"dashboardUserNameEle");
            settingsTabEle.click();
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to go to setting page.");
        }
    }

    /**
    @Description: Click on element
     @param element element defined on page class
     @param elementName Name of element that we want to click
     */
    public void clickElement(WebElement element,String elementName){
        getLogger().info("Try to ClickElement: "+element.getText());
        try{
            element.click();
            NXGReports.addStep("Clicked on element: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to Click on: " +element.getText());
            NXGReports.addStep("Unable to Click on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     @Description: Click and Hold on element
     @param element element defined on page class
     @param elementName Name of element that we want to click and hold
     */
    public void clickAndHold(WebElement element, String elementName){
        getLogger().info("Try to ClickAndHold: "+element.getText());
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click(element);
            actions.perform();
            NXGReports.addStep("Clicked and Hold on element: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to ClickAndHold on: " +element.getText());
            NXGReports.addStep("Unable to ClickAndHold on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     @Description: Hover on element
     @param element element defined on page class
     @param elementName Name of element that we want to hover to
     */
    public void hoverElement(WebElement element, String elementName){
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
     * @param text The content of text that we want to input.
     * @param elementName Name of element that we want to input value.
     */
    public void sendKeyTextBox(WebElement element, String text,String elementName){
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
     * @param elementName Name of element that we want to input value.
     */
    public void clearTextBox(WebElement element,String elementName){
        getLogger().info("Try to sendKey on : "+elementName);
        try {
            element.clear();
            NXGReports.addStep("Cleared text: on element: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to clear on: " +elementName);
            NXGReports.addStep("Unable to clear on: " +elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     *@Description: Click on checkbox
     * @param element element defined on page class
     * @param elementName Name of element: CheckBox that we want to click
     */
    public void clickOnCheckBox(WebElement element,String elementName){
        getLogger().info("Try to click on checkbox: "+elementName);
        try {
            element.click();
            NXGReports.addStep("Click on checkbox: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to click on checkbox element: " +elementName);
            NXGReports.addStep("Unable to click on checkbox: " +elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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
     * @Description: Send TabKey
     * @param element element defined on page class
     * @param elementName Name of element: CheckBox that we want to Send TabKey
     */
    public void sendTabkey(WebElement element, String elementName) {
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

    /**
     *
     * @param element element defined on page class
     * @param attributeName Attribute that we want to validate
     * @param expectedAttributeValue Expected value that we want to validate
     */
    public boolean validateAttributeElement(WebElement element, String attributeName, String expectedAttributeValue){
        getLogger().info("verify Attribute " + attributeName + " of: " + element.toString());
        String actualAttributeValue = null;
        try {
            actualAttributeValue = element.getAttribute(attributeName).trim();
            getLogger().info("actualAttributeValue of " + attributeName + " is: " + actualAttributeValue);
            if (actualAttributeValue.equals(expectedAttributeValue)) {
                getLogger().info(element.getTagName() + " has attribute " + actualAttributeValue);
                NXGReports.addStep(element.getTagName() + " has attribute " + actualAttributeValue, LogAs.PASSED, null);
                return true;
            } else {
                AbstractService.sStatusCnt++;
                getLogger().info(element.getTagName() + " has attribute not as expected with actual:" + actualAttributeValue);
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(element.getTagName() + " has attribute not as expected with actual:" + actualAttributeValue);
            NXGReports.addStep(element.getTagName() + " has attribute not as expected with actual:" + actualAttributeValue, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     *
     * @param element element defined on page class
     * @param cSSValueName AttributeCSSS that we want to validate
     * @param expectedCSSValue Expected value that we want to validate
     */
    public boolean validateCSSValueElement(WebElement element, String cSSValueName, String expectedCSSValue) {
        getLogger().info("verify CSS Value " + expectedCSSValue + " of: " + element.toString());
        String actualCSSValue = null;
        try {
            actualCSSValue = element.getCssValue(cSSValueName);
            getLogger().info("actualCSSValue of " + cSSValueName + " is: " + actualCSSValue);
            if (actualCSSValue.equals(expectedCSSValue)) {
                getLogger().info(element.getTagName() + " has CSSValue " + actualCSSValue);
                NXGReports.addStep(element.getTagName() + " has CSSValue " + actualCSSValue, LogAs.PASSED, null);
                return true;
            } else {
                AbstractService.sStatusCnt++;
                getLogger().info(element.getTagName() + " has CSSValue " + actualCSSValue);
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(element.getTagName() + " has CSSValue " + actualCSSValue);
            NXGReports.addStep(element.getTagName() + " has CSSValue " + actualCSSValue, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public boolean validateIsNotDisPlayedElement(WebElement element) throws InvalidElementStateException {
        getLogger().info("Verify element is not displayed of: " + element.getText());
        try {
            if (!element.isDisplayed()){
                NXGReports.addStep(element.getTagName() + " is displayed", LogAs.PASSED, null);
                return true;
            }else{
                NXGReports.addStep(element.getTagName() + " is NOT displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }

    }

    // EditCategory method
    public void EditCategories() throws Exception {
        waitForClickableOfElement(eleCategoryCombobox, "eleCategoryCombobox");
        eleCategoryCombobox.click();
        //Verify Category_Dropdown GUI
        //=========
        //Click EditCategories option
        waitForClickableOfElement(eleEditCategory, "eleEditCategory");
        eleEditCategory.click();
    }

    public String getTextByJavaScripts(WebElement eleGetText)
    {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        return (String) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].value;",eleGetText);
    }

    public void verifySortDataGrid(List<WebElement> elementRowValue, WebElement elementSortIcon) throws Exception {
        try{
            List<String> toDoTaskName = new ArrayList<String>();
            List<String> sortToDoTaskName;
            for (int i = 0; i < elementRowValue.size(); i++) {
                toDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            sortToDoTaskName = toDoTaskName;
            Collections.sort(sortToDoTaskName);
            elementSortIcon.click();
            toDoTaskName.clear();
            for (int i = 0; i < elementRowValue.size(); i++) {
                toDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            if (sortToDoTaskName.equals(toDoTaskName)) {
                getLogger().info("Ascending sort is as expected");
            } else {
                getLogger().info("Ascending sort is NOT as expected");
                throw new Exception();
            }
            Collections.reverse(sortToDoTaskName);
            elementSortIcon.click();
            toDoTaskName.clear();
            for (int i = 0; i < elementRowValue.size(); i++) {
                toDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            if (sortToDoTaskName.equals(toDoTaskName)) {
                getLogger().info("Descending sort is successfully");
            } else {
                getLogger().info("Descending sort is NOT successfully");
                throw new Exception();
            }
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Cannot sort data on Data Grid View.");
        }
    }

    public boolean createNewCategory () throws Exception
    {
        boolean isCheckCategory = false;
        String categoryName = "Category " + randomNumber();
        // Create new Category
        waitForClickableOfElement(eleIdDdlCategory,"eleIdDdlCategory");
        eleIdDdlCategory.click();
        waitForClickableOfElement(eleXpathCreateNewCategory,"eleXpathCreateNewCategory");
        eleXpathCreateNewCategory.click();
        waitForClickableOfElement(eleIdCategoryName,"eleIdCategoryName");
        eleIdCategoryName.sendKeys(categoryName);
        waitForClickableOfElement(eleIdCategoryColor,"eleIdCategoryColor");
        Thread.sleep(smallTimeOut);
        eleIdCategoryColor.click();
        waitForClickableOfElement(eleXpathDetailCateColor,"eleXpathDetailCateColor");
        eleXpathDetailCateColor.click();
        waitForClickableOfElement(eleIdBtnAddCategory,"eleIdBtnAddCategory");
        eleIdBtnAddCategory.click();
        // Verify the category that has just created
        waitForVisibleElement(tblXpathTodoTable,"tblXpathTodoTable");

        List<WebElement> td_collection = tblXpathTodoTable.findElements(By.xpath("td"));
        for (WebElement tdElement : td_collection) {
            String strSearchValue = "";
            try {
                strSearchValue = eleCategoryText.getText();
            }
            catch(Exception ex)
            {}
            getLogger().info("SearchValue = " + strSearchValue);
            if(strSearchValue.equals(categoryName))
            {
                isCheckCategory = true;
                break;
            }
        }
        return isCheckCategory;
    }


    public int randomNumber()
    {
        Random randNum = new Random();
        int  intRanNum = randNum.nextInt(10000) + 1;
        return intRanNum;
    }



    public void verifyDefaultValueOfElement(WebElement element, String attributeName, String defaultValue) {
        waitForVisibleElement(element,"Element");
        validateDisPlayedElement(element,"Element");
        validateAttributeElement(element, attributeName, defaultValue);
    }

    public void verifyHoverElement(WebElement element, String cssValueName, String expectedCssValue) {
        clickAndHold(element, "Element");
        validateCSSValueElement(element, cssValueName, expectedCssValue);
    }
}
