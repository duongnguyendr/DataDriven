package com.auvenir.ui.pages.common;

//import library
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;
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

import com.auvenir.ui.services.AbstractRefactorService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

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

    // Minh.Nguyen & Thuan.Duong Create Category======================


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
    @FindBy(xpath = "//*[@id='category-dropdown']/div[@class='text']")
    private WebElement eleCategoryCombobox;
    //====================================

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

    //================================================

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
            AbstractRefactorService.sStatusCnt++;
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
            AbstractRefactorService.sStatusCnt++;
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
            AbstractRefactorService.sStatusCnt++;
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
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is  selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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



    public void scrollPageUp() throws AWTException {

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
    }
    public void scrollPageDown() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    }

    public void waitForVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForPresentOfLocator(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitForVisibleOfLocator(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForInvisibleOfLocator(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void waitForClickableOfLocator(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitForClickableOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForInvisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
        wait.until(ExpectedConditions.invisibilityOf(element));
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
    public void navigateToSettingsPage() {
        waitForClickableOfElement(dashboardUserNameEle);
        dashboardUserNameEle.click();
        waitForPresentOfLocator(By.xpath("//a[contains(text(),'Settings')]"));
        waitForClickableOfElement(settingsTabEle);
        settingsTabEle.click();
    }
    public void ClickAndHold(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click(element);
        actions.perform();
    }
    public void HoverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.build().perform();
    }
    public void sendTabkey(WebElement element) {
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.ENTER);
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

    public void validateIsNotDisPlayedElement(WebElement element) throws InvalidElementStateException {
        getLogger().info("Verify element is not displayed of: " + element.getText());

        try {
            if (!element.isDisplayed())
                NXGReports.addStep(element.getTagName() + " is displayed", LogAs.PASSED, null);
            else
                NXGReports.addStep(element.getTagName() + " is NOT displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            AbstractRefactorService.sStatusCnt++;
            NXGReports.addStep(element.getText() + " is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }



    //Minh.Nguyen added createNewCategory May10th 2017=============


    public void createNewCategory () throws Exception
    {
        // Create new Category
        waitForClickableOfElement(eleXpathCreateNewCategory);
        eleXpathCreateNewCategory.click();
        waitForClickableOfElement(eleIdCategoryName);
        eleIdCategoryName.sendKeys("Category " + randomNumber());
        waitForClickableOfElement(eleIdCategoryColor);
        Thread.sleep(smallTimeOut);
        eleIdCategoryColor.click();
        waitForClickableOfElement(eleXpathDetailCateColor);
        eleXpathDetailCateColor.click();
        waitForClickableOfElement(eleIdBtnAddCategory);
        eleIdBtnAddCategory.click();


            }


    // Vien.Pham added new EditCategory method
       public void EditCategories ( )throws Exception{
        waitForClickableOfElement(eleCategoryCombobox);
        eleCategoryCombobox.click();
        //Verify Category_Dropdown GUI


           //=========

           //Click EditCategories option
        waitForClickableOfElement(eleEditCategory);
        eleEditCategory.click();
    }

        // to verify the Elements of EditCategories Window are displayed correctly.
//        public void verifyEditCategoriesElements(){




//        }

        // to verfy the List of Categories is displayed correctly








    //====================================


    //===============================
    public int randomNumber()
    {
        Random randNum = new Random();
        int  intRanNum = randNum.nextInt(10000) + 1;
        return intRanNum;
    }

    public String getTextByJavaScripts(WebElement eleGetText)
    {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        return (String) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].value;",eleGetText);
    }
    public static  final int smallerTimeOut = 500;
    public static  final int smallTimeOut = 1000;






}
