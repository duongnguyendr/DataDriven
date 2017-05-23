package com.auvenir.ui.pages.common;

//import library
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;

//import org.testng.log4testng.Logger;
import com.auvenir.ui.services.AbstractService;
import javafx.scene.control.Tab;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.log4testng.Logger;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by hungcuong1105 on 4/15/2017.
 * Updated by Doai.Tran on 5/9/2017.
 */
public class AbstractPage {
    private    Logger logger = null;
    private  WebDriver driver = null;
    private static final int waitTime = 60;
    public static final int smallerTimeOut = 500;
    public static final int smallTimeOut = 1000;
    public static final String categoryIndiMode = "indicategory";
    public static final String categoryTitleOfAddNew = "Add New Category";
    public static final String backgroundColor = "background-color";
    public static final String numberSequence = "123456";
    public static final String maxLenghtString = "limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit";
    public static final String borderColor = "border-color";
    public static final String border = "border";
    public static final String background = "background";
    public static final String searchTextToDoListPage = "Search to do";
    public static final String searchTextDefault = "Search...";
    public static final String greenColor = "1px solid rgb(89, 155, 161)";
    public static final String blueColor = "rgb(43, 72, 117) none repeat scroll 0% 0% / auto padding-box border-box";
    public static final String greyColor = "1px solid rgb(151, 147, 147)";
    public static final String whiteColor = "1px solid rgb(255, 255, 255)";
    public static final String color = "color";
    public static final String categoryNameAllText = "category name all text";
    public static final String notValidNameMessage = "Not a valid name.";
    public static final String specialCharacter = "~!@#$%^&*+?><,.";
    public static final String existedCategoryName = "Category name already existed";
    public static final int maxLenght = 255;
    public static final int maxLenghtOneHundred = 100;
    public static final String nullChars = "";
    public static final String categoryColor = "//*[@id='category-color']";
    public static final String categoryColorContainer = "//*[@id='category-color-container']/ul/li[4]";
    public static final String dropdownCategoryToDoBulkDdl = "//*[@class='ui dropdown category todo-bulkDdl ']";
    public static final String dropdownCategoryToDoBulkDdlDiv1 = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']/div[1]";
    public static final String popUpDivCategoryModel ="//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]";
    public static final String dropdownCategoryToDoBulkDllDivDiv = "//div[contains(@class, 'ui dropdown category todo-bulkDdl ')]/div/div";


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

    @FindBy(xpath = "/*//*[@id='category-dropdown']/div[@class='text']")
    private WebElement eleCategoryCombobox;
    // Create Category
    @FindBy(xpath = "//*[@id='category-dropdown']/div[@class='text']")
    private WebElement eleCategoryComboBox;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']/div[1]")
    private WebElement addNewCategoryMenuEle;

    @FindBy(id="category-name")
    private WebElement categoryNameFieldOnFormEle;

    @FindBy(xpath="//*[@id='category-color']")
    private WebElement categoryColorFieldOnFromEle;

    @FindBy(xpath = "//*[@id=\"category-color-container\"]/ul/li[4]")
    private WebElement detailCateColorEle;
    @FindBy(id="category-addBtn")
    private WebElement eleIdBtnAddCategory;

    @FindBy(xpath="//*[@class='ui dropdown category todo-bulkDdl ']")
    private WebElement dropdownCategoryEle;

    @FindBy(id="todo-table")
    private WebElement tblXpathTodoTable;
    @FindBy(xpath="//*[@id=\"category-dropdown-menu\"]/div/button")
    private WebElement eleCategoryText;

    @FindBy(xpath="//div[contains(@class, 'ui dropdown category todo-bulkDdl ')]/div/div")
    private WebElement eleIndiCategoryText;

    @FindBy(xpath = "//*[@id=\"category-color-container\"]/ul/li")
    private WebElement categoryColors;

    @FindBy(xpath="//div[contains(@class,'ce-parent todo-modal-container')]/div/h3")
    private WebElement idTitleCategory;

    @FindBy(xpath = "//*[@id='setup-component-body']/div/div[1]//p[contains(text(),'Not a valid name.')]")
    private WebElement xpathRequiredDataCategoryName;

    @FindBy(xpath = "//*[@id=\"category-color-container\"]/ul/li")
    private WebElement xpathAllCategoryColor;
    @FindBy(xpath = "//p[contains(text(),'Category name already existed')]")
    private WebElement xpathCategoryExistedText;
    @FindBy(xpath="//div[contains(text(),'Select Category')]")
    private WebElement containsSelectCategoryText;
    @FindBy(xpath="//*[@id='todo-table']/tbody/tr[1]/td[7]/img")
    private WebElement imgListTodoPage;


    @FindBy(xpath = "//input[contains(@id,'forge-InputBox')]")
    List<WebElement> listOfCategoriesItemEle;

    @FindBy(xpath = "//img[contains(@id,\"cat-trash-btn\")]")
    List<WebElement> listOfEditTrashEle;

    @FindBy(xpath = "//img[contains(@id,\"cat-edit-btn\")]")
    List<WebElement> listOfEditPenEle;

    @FindBy(xpath = "//div[@id=\"category-dropdown-menu\"]/div[@class=\"\"]")
    List<WebDriver> listOfCategoriesDropdownTableEle;

    @FindBy(xpath = "//div[contains(@class,'au-modal-container modalTransition-popUp-container')]//button[contains(text(),'Cancel')]")
    WebElement cancelDeletedToDoButtonEle;

    @FindBy(xpath = "//div[@class = 'fl-a-container fl-a-container-show']/div[@class = 'fl-a-dismiss auvicon-line-circle-ex'] ")
    WebElement successToastMesCloseIconEle;

    public void verifyFooter() {
        validateDisPlayedElement(eleAuvenirIncTxt, "eleAuvenirIncTxt");
        validateDisPlayedElement(eleTermsOfServiceLnk,"eleAuvenirIncTxt");
        validateDisPlayedElement(eleTermsOfServiceDotTxt,"eleAuvenirIncTxt");
        validateDisPlayedElement(elePrivacyStatementLnk,"eleAuvenirIncTxt");
        validateDisPlayedElement(elePrivacyStatementDotTxt,"eleAuvenirIncTxt");
        validateDisPlayedElement(eleCookieNoticeLnk,"eleAuvenirIncTxt");
    }

    public void verifyTermsOfServiceLink() throws AWTException {
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
    public boolean validateElementText(WebElement webElement, String elementText) {
        try {
            getLogger().info("Check renderd of text: " + elementText);
            getLogger().info("Actual Text is displayed: " + webElement.getText().trim());
            Assert.assertEquals(webElement.getText().trim(),elementText);
            NXGReports.addStep(elementText + " rendered", LogAs.PASSED,null);
            return true;
        }catch (AssertionError error) {
            getLogger().info(error);
            AbstractService.sStatusCnt++;
            NXGReports.addStep(elementText + " rendered", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     *
     * @param element
     * @throws InvalidElementStateException
     * @elementName Name of element that we want to verify
     */
    public boolean validateDisPlayedElement(WebElement element, String elementName) throws InvalidElementStateException
    {
        getLogger().info("verify Displayed of: " + elementName);
        try{
            element.isDisplayed();
            getLogger().info("Element : " + elementName +"is presented");
            NXGReports.addStep("Element : "+ elementName + " is presented.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element +"is not presented");
            NXGReports.addStep("Element : " + elementName +"is not presented", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     *
     * @param element element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */

    public boolean validateEnabledElement(WebElement element, String elementName) throws InvalidElementStateException
    {
        getLogger().info("verify enabled of: " + elementName);
        try{
            element.isEnabled();
            getLogger().info("Element : " + elementName +"is enable");
            NXGReports.addStep(elementName + " is enable.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + elementName +"is not enable.");
            NXGReports.addStep("Element : " + elementName +"is not enable", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     *
     * @param element element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public boolean validateSelectedElement(WebElement element,String elementName) throws InvalidElementStateException
    {
        getLogger().info("verify selected of: " + elementName);
        try{
            element.isSelected();
            getLogger().info("Element : " + element.getText() +"is selected.");
            NXGReports.addStep("Element: "+ elementName + " is selected.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is not selected.");
            NXGReports.addStep("Element : " + elementName +"is not selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     *
     * @param element element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public boolean validateNotSelectedElement(WebElement element, String elementName) throws InvalidElementStateException
    {
        getLogger().info("verify not selected of: " + elementName);
        try{
            if(!element.isSelected()){
                getLogger().info("Element : " + element.getText() +"is not selected.");
                NXGReports.addStep("Element : " + elementName + " is not selected.", LogAs.PASSED, null);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() +"is selected.");
            NXGReports.addStep("Element : " + elementName +"is selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public boolean validateCssValueElement(WebElement element,String attributeName,String attributeValue) throws InvalidElementStateException
    {
        getLogger().info("verify style with "+ attributeName);
        try
        {
        	 Assert.assertEquals(element.getCssValue(attributeName),attributeValue);
            NXGReports.addStep(element.getTagName() + " has style with  "+attributeName, LogAs.PASSED, null);
            return true;
        }
        catch (Exception e)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(element + " has style with  "+attributeName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }

    }

    public boolean validateMaxlenght(WebElement webElement, String webElementName, int maxLength) {
        try {
            String inputTextwithMaxLength = randomCharacters(maxLength);
            getLogger().info("Verify input with max length with " + maxLength + " characters");
            clickElement(webElement, webElementName);
            clearTextBox(webElement, webElementName);
            webElement.sendKeys(inputTextwithMaxLength);
            String actualTextInput = webElement.getAttribute("value");
            Assert.assertEquals(actualTextInput, inputTextwithMaxLength, String.format("%s cannot input %d characters", webElementName, maxLength));
            NXGReports.addStep("input with max length with " + maxLength + "character", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
            NXGReports.addStep("input with max length with " + maxLength + "character", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
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
    public boolean waitForVisibleElement(WebElement element, String elementName){
        getLogger().info("Try to waitForVisibleElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            NXGReports.addStep("Element: "+ elementName + " is visible.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element: " + element.getText() +"is not visible.");
            NXGReports.addStep("Element: "+ elementName +" is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
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
    public boolean clickElement(WebElement element,String elementName){
        getLogger().info("Try to ClickElement: " + elementName);
        try{
            waitForClickableOfElement(element, "click to " + elementName);
            element.click();
            NXGReports.addStep("Clicked on element: " + elementName, LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to Click on: " + elementName);
            NXGReports.addStep("Unable to Click on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     @Description: Click and Hold on element
     @param element element defined on page class
     @param elementName Name of element that we want to click and hold
     */
    public void clickAndHold(WebElement element, String elementName){
        getLogger().info("Try to ClickAndHold: "+ elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click(element);
            actions.perform();
            NXGReports.addStep("Clicked and Hold on element: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to ClickAndHold on: " +elementName);
            NXGReports.addStep("Unable to ClickAndHold on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     @Description: Hover on element
     @param element element defined on page class
     @param elementName Name of element that we want to hover to
     */
    public void hoverElement(WebElement element, String elementName){
        getLogger().info("Try to hoverElement: "+elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            NXGReports.addStep("Hover on element: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to hoverElement on: " +elementName);
            NXGReports.addStep("Unable to hoverElement on: " +elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * @Description: Send a String to textBox.
     * @param element element defined on page class
     * @param text The content of text that we want to input.
     * @param elementName Name of element that we want to input value.
     * @Description: Send a String to textBox.
     */
    public void sendKeyTextBox(WebElement element, String text,String elementName){
        getLogger().info("Try to sendKey on : "+elementName);
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
            NXGReports.addStep("Send text: "+text+ "on element: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendKey on: " +elementName);
            NXGReports.addStep("Unable to sendKey on: " +elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     *@Description: Clear all Strings to textBox.
     * @param element element defined on page class
     * @param elementName Name of element that we want to input value.
     * @Description: Clear all Strings to textBox.
     */
    public void clearTextBox(WebElement element,String elementName){
        getLogger().info("Try to clear text on : "+elementName);
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
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     */
    public boolean selectByVisibleText(WebElement element, String selText, String elementName){
        getLogger().info("Try to selectByVisibleText on element: "+ elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(selText);
            NXGReports.addStep("selectByVisibleText on checkbox: "+ elementName, LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByVisibleText on element: " +elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /**
     *@Description: select a value on dropdown via visible text
     * @param element element defined on page class
     * @param selValue Value that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     */
    public void selectByValue(WebElement element, String selValue, String elementName){
        getLogger().info("Try to selectByValue on element: "+ elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByValue(selValue);
            NXGReports.addStep("selectByValue on checkbox: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByValue on element: " +elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     *@Description: select a value on dropdown via visible text
     * @param element element defined on page class
     * @param selIndex Value that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     */
    public void selectByIndex(WebElement element, int selIndex, String elementName){
        getLogger().info("Try to selectByIndex on element: "+elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByIndex(selIndex);
            NXGReports.addStep("selectByIndex on checkbox: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByIndex on element: " +elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * @Description: Send TabKey
     * @param element element defined on page class
     * @param elementName Name of element: CheckBox that we want to Send TabKey
     * @Description: Send TabKey
     */
    public void sendTabkey(WebElement element, String elementName) {
        getLogger().info("Try to sendTabkey: "+elementName);
        try {
            element.sendKeys(Keys.TAB);
            element.sendKeys(Keys.ENTER);
            NXGReports.addStep("sendTabkey on element: "+ elementName, LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendTabkey on: " +elementName);
            NXGReports.addStep("Unable to sendTabkey on: " +elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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

    public boolean validateIsNotDisPlayedElement(WebElement element, String elementName) {
        getLogger().info("Verify element is not displayed of: " + elementName);
        try {
            if (!element.isDisplayed()){
                NXGReports.addStep(elementName + " is displayed", LogAs.PASSED, null);
                return true;
            }else{
                NXGReports.addStep(elementName + " is NOT displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(elementName + " is not displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }

    }


    public String getTextByJavaScripts(WebElement eleGetText) {
        getLogger().info("Get text by javascript of element " + eleGetText);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            NXGReports.addStep("Get text by javascript of element " + eleGetText, LogAs.PASSED, null);
            return (String) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].value;", eleGetText);
        } catch (Exception ex) {
            NXGReports.addStep("Get text by javascript of element " + eleGetText, LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return "";
        }
    }

    public void verifySortDataGrid(List<WebElement> elementRowValue, WebElement elementSortIcon){
        try{
            List<String> listToDoTaskName = new ArrayList<String>();
            List<String> listSortedToDoTaskName;
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            listSortedToDoTaskName = listToDoTaskName;
            Collections.sort(listSortedToDoTaskName);
            elementSortIcon.click();
            listToDoTaskName.clear();
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            Assert.assertEquals(listSortedToDoTaskName, listToDoTaskName, "Ascending sort is NOT as expected");
            NXGReports.addStep("The data on Data Grid is sorted in ascending order successfully", LogAs.PASSED, null);
            Collections.reverse(listSortedToDoTaskName);
            elementSortIcon.click();
            listToDoTaskName.clear();
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            Assert.assertEquals(listSortedToDoTaskName, listToDoTaskName, "Descending sort is NOT as expected");
            NXGReports.addStep("The data on Data Grid is sorted in descending order successfully", LogAs.PASSED, null);
        }catch (AssertionError e){
            AbstractService.sStatusCnt++;
            getLogger().info("Cannot sort data on Data Grid View.");
            NXGReports.addStep("The data on Data Grid is sorted unsuccessfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickToNewCategoryDllInList() throws Exception
    {
        waitForClickableOfLocator(By.xpath(dropdownCategoryToDoBulkDdl));
        waitForClickableOfElement(dropdownCategoryEle, "dropdownCategoryEle");
        clickElement(dropdownCategoryEle, "click to dropdownCategoryEle");
        waitForClickableOfLocator(By.xpath(dropdownCategoryToDoBulkDdlDiv1));
        waitForClickableOfElement(addNewCategoryMenuEle,"addNewCategoryMenuEle");
        Thread.sleep(smallerTimeOut);
        clickElement(addNewCategoryMenuEle, "click to addNewCategoryMenuEle");
    }

    public void chooseCategoryColorInPopup () throws Exception
    {
        hoverElement(categoryColorFieldOnFromEle,"categoryColorFieldOnFromEle");
        waitForClickableOfLocator(By.xpath(categoryColor));
        waitForClickableOfElement(categoryColorFieldOnFromEle,"categoryColorFieldOnFromEle");
        clickElement(categoryColorFieldOnFromEle, "click to categoryColorFieldOnFromEle");
        waitForClickableOfLocator(By.xpath(categoryColorContainer));
        waitForClickableOfElement(detailCateColorEle,"detailCateColorEle");
        clickElement(detailCateColorEle, "click to detailCateColorEle");
    }

    public void clickNewCategoryCreateButton() throws Exception
    {
        waitForClickableOfElement(eleIdBtnAddCategory,"Add Category Button");
        waitForJSandJQueryToLoad();
        WebElement popUpDiv = getDriver().findElement(By.xpath(popUpDivCategoryModel));
        clickElement(eleIdBtnAddCategory, "Add Category Button");
        waitForCssValueChanged(popUpDiv,"PopUp Windows","display","none");
    }

    /**
     * categoryMode = categoryIndiMode: create new category from list ToDoPage
     * categoryMode = "": create new category in a ToDoPage
     */
    public boolean createNewCategory (String categoryMode, String categoryNameInput) throws Exception
    {
        boolean isCheckCategory = false;
        String categoryName = "";
        if(categoryNameInput.equals("")) {
            categoryName = "Category " + randomNumber();
        }
        else
        {
            categoryName = categoryNameInput;
        }
        // Create new Category
        clickToNewCategoryDllInList();
        waitForClickableOfElement(categoryNameFieldOnFormEle,"categoryNameFieldOnFormEle");
        waitForJSandJQueryToLoad();
        clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
        sendKeyTextBox(categoryNameFieldOnFormEle, categoryName, "send key to categoryNameFieldOnFormEle");
        chooseCategoryColorInPopup();
        clickNewCategoryCreateButton();
        // Verify the category that has just created
        waitForVisibleElement(tblXpathTodoTable,"tblXpathTodoTable");
        List<WebElement> td_collection = new ArrayList<>();
        if(categoryMode.equals(categoryIndiMode)) {
            hoverElement(dropdownCategoryEle, "dropdownCategoryEle");
            waitForClickableOfElement(dropdownCategoryEle,"dropdownCategoryEle");
            waitForJSandJQueryToLoad();
            waitForVisibleElement(imgListTodoPage, "wait for imgListTodoPage");
            clickElement(dropdownCategoryEle, "click to dropdownCategoryEle");
            waitForVisibleElement(eleIndiCategoryText,"eleIndiCategoryText");
            td_collection = tblXpathTodoTable.findElements(By.xpath(dropdownCategoryToDoBulkDllDivDiv));
            for (WebElement tdElement : td_collection) {
                String strSearchValue = "";
                try {
                    waitForVisibleElement(tdElement,"eleIndiCategoryText Get category name in list");
                    strSearchValue = tdElement.getText();
                } catch (Exception ex) {
                }
                getLogger().info("SearchValue = " + strSearchValue);
                if (strSearchValue.equals(categoryName)) {
                    isCheckCategory = true;
                    break;
                }
            }
        }
        else {
            isCheckCategory = true;
        }
        waitForDisappearElement(categoryNameFieldOnFormEle,"categoryNameFieldOnFormEle");
        getLogger().info("isCheckCategory = " + isCheckCategory);
        return isCheckCategory;
    }

    public boolean chooseCategoryByNameFromDll(String categoryName)
    {
        boolean isCheckCategoryName = false;
        getLogger().info("Choose category by name from dropdownlist");
        try {
            List<WebElement> listCategoryName = new ArrayList<>();
            hoverElement(dropdownCategoryEle, "dropdownCategoryEle");
            waitForClickableOfElement(dropdownCategoryEle, "dropdownCategoryEle");
            waitForJSandJQueryToLoad();
            waitForVisibleElement(imgListTodoPage, "wait for imgListTodoPage");
            clickElement(dropdownCategoryEle, "click to dropdownCategoryEle");
            waitForVisibleElement(eleIndiCategoryText, "eleIndiCategoryText");
            listCategoryName = tblXpathTodoTable.findElements(By.xpath(dropdownCategoryToDoBulkDllDivDiv));
            for (WebElement categoryNameEle : listCategoryName) {
                String strSearchValue = "";
                try {
                    waitForVisibleElement(categoryNameEle, "eleIndiCategoryText Get category name in list");
                    strSearchValue = categoryNameEle.getText();
                } catch (Exception ex) {
                }
                getLogger().info("SearchValue = " + strSearchValue);
                if (strSearchValue.equals(categoryName)) {
                    clickElement(categoryNameEle, "click to " + categoryNameEle);
                    isCheckCategoryName = true;
                    NXGReports.addStep("Choose category by name from dropdownlist", LogAs.PASSED, null);
                    break;
                }
            }
        }
        catch(Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose category by name from dropdownlist", LogAs.FAILED, null);
        }
        return isCheckCategoryName;
    }

    public boolean countCategoryColor()
    {
        boolean isCountColor = false;
        waitForClickableOfElement(categoryColors,"categoryColors");
        return  isCountColor;
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
        hoverElement(element, "Element");
        validateCSSValueElement(element, cssValueName, expectedCssValue);
    }

    /**
     *
     * @param elements List<WebElement></WebElement>
     * @return true: All checkbox on Element list be selected
     * @throws Exception
     */
    public boolean verifyCheckAllCheckboxList(List<WebElement> elements, String elementListName) throws Exception {
        try {
            for (int i = 0; i < elements.size(); i++){
                if (!elements.get(i).isSelected()){
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is NOT checked");
                    throw new Exception();
                }else{
                    System.out.println("Checkbox is selected:? " + elements.get(i).isSelected());
                }
            }
            getLogger().info("Check box icons are selected all.");
            NXGReports.addStep("All checkbox: "+elementListName+" is selected", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are not selected all.");
            NXGReports.addStep("All checkbox: "+elementListName+" is NOT selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     *
     * @param elements List<WebElement></WebElement>
     * @return true: All checkbox on Element list be not selected
     * @throws Exception
     */
    public boolean verifyUnCheckAllCheckboxList(List<WebElement> elements,String elementListName) throws Exception {
        try {
            for (int i = 0; i < elements.size(); i++){
                if (elements.get(i).isSelected()){
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is checked");
                    throw new Exception();
                }else{
                    System.out.println("Checkbox is not selected:? " + elements.get(i).isSelected());
                }
            }
            getLogger().info("Check box icons are not selected all.");
            NXGReports.addStep("All checkbox: "+elementListName+" is NOT selected", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are  selected all.");
            NXGReports.addStep("All checkbox: "+elementListName+" is selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     *
     * @param element The element that we want to check.
     * @param elementName Name of element we are verifying.
     * @return
     */
    public boolean HoverAndWaitForClickableOfElement(WebElement element, String elementName){
        getLogger().info("Try to waitForClickableOfElement: "+elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
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
     *
     * @param element The element that we want to check.
     * @param verifyText The expected text should be displayed.
     * @param elementName Name of element we are verifying.
     * @return
     */
    public boolean HoverAndWaitForPresentOfElement(WebElement element, String verifyText, String elementName){
        getLogger().info("Try to waitForClickableOfElement: "+elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.textToBePresentInElement(element,verifyText));
            NXGReports.addStep("Element: "+ elementName+" is  presented and have the correct text.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: "+element.getText());
            NXGReports.addStep("Element: "+ elementName+" is not presented and have the incorrect text.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
    /**
     *
     * @param element The element that we want to check.
     * @param elementName Name of element we are verifying.
     * @return
     */
    public boolean HoverAndWaitForVisibleOfElement(WebElement element, String elementName){
        getLogger().info("Try to waitForClickableOfElement: "+elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            NXGReports.addStep("Element: "+ elementName+" is  visible.", LogAs.PASSED, null);
            return true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: "+element.getText());
            NXGReports.addStep("Element: "+ elementName+" is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public boolean verifyCategoryTitle()
    {
        boolean isCheckTitle = false;
        getLogger().info("Verify category title");
        try {
            clickToNewCategoryDllInList();
            waitForVisibleElement(idTitleCategory, "wait idTitleCategory");
            String strCategoryTitle = idTitleCategory.getText();
            if (categoryTitleOfAddNew.equals(strCategoryTitle)) {
                isCheckTitle = true;
                NXGReports.addStep("Verify category title", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify category title", LogAs.FAILED, null);
            }
            return isCheckTitle;
        }
        catch(Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify category title", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckTitle;
        }
    }

    public boolean verifyCategoryDefaultValue()
    {
        boolean isCheckDetaultValue = false;
        getLogger().info("Verify category default value");
        try
        {
            waitForClickableOfElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            String strCateDefaultValue = getTextByJavaScripts(categoryNameFieldOnFormEle);
            if(strCateDefaultValue.equals(""))
            {
                isCheckDetaultValue = true;
                NXGReports.addStep("Verify category default value", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify category default value", LogAs.FAILED, null);
            }

            return isCheckDetaultValue;
        }
        catch(Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify category default value", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckDetaultValue;
        }
    }

    public boolean verifyHoverClickCategoryName()
    {
        boolean isCheckBorderColor = false;
        getLogger().info("Verify hover and click to category name");
        try {
            // Green color
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            //sendKeyTextBox(categoryNameFieldOnFormEle,"test color", "send key to test color");
            isCheckBorderColor = validateCSSValueElement(categoryNameFieldOnFormEle, border, greenColor);
            getLogger().info("isCheckBorderColor = " + isCheckBorderColor);
            if(isCheckBorderColor) {
                NXGReports.addStep("Verify hover and click to category name", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify hover and click to category name", LogAs.FAILED, null);
            }
            return isCheckBorderColor;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify hover and click to category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckBorderColor;
        }
    }

    public boolean verifyShowAllTextCategoryName()
    {
        boolean isCheckShowAllText = false;
        getLogger().info("Verify check show all text of category name");
        try
        {
            clickElement(categoryNameFieldOnFormEle,"click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle,categoryNameAllText,"send key to categoryNameFieldOnFormEle");
            String strGetCategoryName = getTextByJavaScripts(categoryNameFieldOnFormEle);
            if(categoryNameAllText.equals(strGetCategoryName))
            {
                isCheckShowAllText = true;
                NXGReports.addStep("Verify check show all text of category name", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify check show all text of category name", LogAs.FAILED, null);
            }
            return isCheckShowAllText;
        }
        catch(Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify check show all text of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckShowAllText;
        }
    }

    public boolean verifyCategoryNameRequiredData()
    {
        boolean isCheckRequiredData = false;
        getLogger().info("Verify to check required data of category name");
        try
        {
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear categoryNameFieldOnFormEle");
            clickElement(categoryColorFieldOnFromEle, "click to categoryColorFieldOnFromEle");
            boolean isCheckDisplay = waitForVisibleElement(xpathRequiredDataCategoryName, "wait for visible xpathRequiredDataCategoryName");
            getLogger().info("isCheckDisplay = " + isCheckDisplay);
            String strRequiredDataMessage = xpathRequiredDataCategoryName.getText();
            getLogger().info("strRequiredDataMessage = " + strRequiredDataMessage);
            if(strRequiredDataMessage.equals(notValidNameMessage))
            {
                isCheckRequiredData = true;
                NXGReports.addStep("Verify to check required data of category name", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check required data of category name", LogAs.FAILED, null);
            }
            return isCheckRequiredData;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check required data of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckRequiredData;
        }
    }

    public boolean verifyCategoryNameMaxLength()
    {
        boolean isCheckMaxLength = false;
        getLogger().info("Verify to check max length of category name");
        try
        {
            isCheckMaxLength = validateMaxlenght(categoryNameFieldOnFormEle, "Category Name TextBox", maxLenghtOneHundred);
            getLogger().info("isCheckMaxLength = " + isCheckMaxLength);
            if(isCheckMaxLength) {
                NXGReports.addStep("Verify to check max length of category name", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check max length of category name", LogAs.FAILED, null);
            }
            return isCheckMaxLength;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check max length of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckMaxLength;
        }
    }

    public boolean verifyCategoryNameInputNumber()
    {
        boolean isCheckMaxLength = false;
        getLogger().info("Verify to check the number value of category name");
        try
        {
            waitForClickableOfElement(categoryNameFieldOnFormEle,"wait for click categoryNameFieldOnFormEle");
            clickElement(categoryNameFieldOnFormEle,"click to categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle,numberSequence,"send key to categoryNameFieldOnFormEle");
            String strNumberValue = getTextByJavaScripts(categoryNameFieldOnFormEle);
            if(strNumberValue.equals(numberSequence))
            {
                isCheckMaxLength = true;
                NXGReports.addStep("Verify to check the number value of category name", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check the number value of category name", LogAs.FAILED, null);
            }

            return isCheckMaxLength;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check the number value of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckMaxLength;
        }
    }
    public String randomCharacters(int maxLength){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String results = sb.toString();
        return results;
    }

    public boolean verifyCategoryNameSpecialCharacter()
    {
        boolean isCheckSpecialCharacter = false;
        getLogger().info("Verify to check special character of category name");
        try
        {
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle,"clear text categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, specialCharacter,"send special character to categoryNameFieldOnFormEle");
            clickElement(categoryColorFieldOnFromEle, "click to categoryColorFieldOnFromEle");
            waitForVisibleElement(xpathRequiredDataCategoryName, "wait for visible xpathRequiredDataCategoryName");
            String strRequiredDataMessage = xpathRequiredDataCategoryName.getText();
            if(strRequiredDataMessage.equals(notValidNameMessage))
            {
                isCheckSpecialCharacter = true;
                NXGReports.addStep("Verify to check special character of category name", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check special character of category name", LogAs.FAILED, null);
            }
            return isCheckSpecialCharacter;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check special character of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckSpecialCharacter;
        }
    }

    public boolean verifyCategoryColorAllQuantityColor()
    {
        boolean isCheckAllQuantityColor = false;
        getLogger().info("Verify to check all quantity color of category color");
        try
        {
            waitForVisibleElement(xpathAllCategoryColor, "wait for visible xpathAllCategoryColor");
            List<WebElement> listCategoryColor = getDriver().findElements(By.xpath("//*[@id=\"category-color-container\"]/ul/li"));
            if(listCategoryColor.size() == 10)
            {
                isCheckAllQuantityColor = true;
                NXGReports.addStep("Verify to check all quantity color of category color", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check all quantity color of category color", LogAs.FAILED, null);
            }
            return isCheckAllQuantityColor;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check all quantity color of category color", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckAllQuantityColor;
        }
    }

    public boolean verifyChoosedCategoryColor()
    {
        boolean isCheckChoosedColor = false;
        getLogger().info("Verify to choose the category color");
        try {
            // blue color
            chooseCategoryColorByColorName("#2b4875");
            isCheckChoosedColor = validateCSSValueElement(categoryColorFieldOnFromEle, background, blueColor);
            if(isCheckChoosedColor) {
                NXGReports.addStep("Verify to choose the category color", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to choose the category color", LogAs.FAILED, null);
            }
            return isCheckChoosedColor;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to choose the category color", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckChoosedColor;
        }
    }

    public void chooseCategoryColorByColorName(String colorName)
    {
        boolean isCheckAllQuantityColor = false;
        getLogger().info("Choose category color by color name");
        try
        {
            waitForVisibleElement(xpathAllCategoryColor, "wait for visible xpathAllCategoryColor");
            List<WebElement> listCategoryColor = getDriver().findElements(By.xpath("//*[@id=\"category-color-container\"]/ul/li/a"));
            for(WebElement colorNameEle : listCategoryColor)
            {
                if(colorNameEle.getText().equals(colorName))
                {
                    clickElement(colorNameEle, "click to colorNameEle");
                    isCheckAllQuantityColor = true;
                    break;
                }
            }
            if(isCheckAllQuantityColor)
            {
                NXGReports.addStep("Choose category color by color name", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Choose category color by color name", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose category color by color name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
        }
    }

    public boolean verifyColorCategoryCancelButton()
    {
        boolean isCheckColorCancelButton = false;
        getLogger().info("Verify color of Category cancel button");
        try {
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear text categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, "CreateCancel", "send key to categoryNameFieldOnFormEle");
            //waitForVisibleElement(eleEditCategoryCancelBtn, "wait for visible eleEditCategoryCancelBtn");
            isCheckColorCancelButton = validateCSSValueElement(eleEditCategoryCancelBtn, backgroundColor, "rgba(151, 147, 147, 1)");
            isCheckColorCancelButton = validateCSSValueElement(eleEditCategoryCancelBtn, color, "rgba(255, 255, 255, 1)");
            if(isCheckColorCancelButton) {
                NXGReports.addStep("Verify color of Category cancel button", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify color of Category cancel button", LogAs.FAILED, null);
            }
            return isCheckColorCancelButton;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify color of Category cancel button", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckColorCancelButton;
        }
    }

    public boolean verifyColorCategoryCreateButton()
    {
        boolean isCheckColorCreateButton = false;
        getLogger().info("Verify color of Category create button");
        try {
            isCheckColorCreateButton = validateCSSValueElement(eleIdBtnAddCategory, backgroundColor, "rgba(89, 155, 161, 1)");
            isCheckColorCreateButton = validateCSSValueElement(eleIdBtnAddCategory, color, "rgba(255, 255, 255, 1)");
            if(isCheckColorCreateButton) {
                NXGReports.addStep("Verify color of Category create button", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify color of Category create button", LogAs.FAILED, null);
            }
            return isCheckColorCreateButton;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify color of Category create button", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckColorCreateButton;
        }
    }

    public boolean verifyClickCategoryCancelButton()
    {
        boolean isCheckCancelClick = false;
        getLogger().info("Verify to click Category cancel button");
        try {
            // click to cancel button
            clickToNewCategoryDllInList();
            hoverElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");
            waitForClickableOfLocator(By.xpath("//div[contains(@class,'au-modal-container modalTransition-popUp-container')]//button[contains(text(),'Cancel')]"));
            waitForClickableOfElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo Button");
            isCheckCancelClick = clickElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");

            getLogger().info("isCheckCancelClick = " + isCheckCancelClick);
            if(isCheckCancelClick) {
                NXGReports.addStep("Verify to click Category cancel button", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to click Category cancel button", LogAs.FAILED, null);
            }
            return isCheckCancelClick;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to click Category cancel button", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckCancelClick;
        }
    }

    public boolean verifyNotCompleteCreateCategory()
    {
        boolean isCheckCreateCateFail = false;
        getLogger().info("Verify not complete to create category");
        try {
           clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
           clearTextBox(categoryNameFieldOnFormEle, "clear text categoryNameFieldOnFormEle");
           sendKeyTextBox(categoryNameFieldOnFormEle,"create", "send key to categoryNameFieldOnFormEle");
           //clickElement(eleIdBtnAddCategory, "click to eleIdBtnAddCategory");
           isCheckCreateCateFail = waitForVisibleElement(eleIdBtnAddCategory, "wait for visible eleIdBtnAddCategory");
            if(isCheckCreateCateFail) {
                NXGReports.addStep("Verify not complete to create category", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify not complete to create category", LogAs.FAILED, null);
            }
            return isCheckCreateCateFail;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify not complete to create category", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckCreateCateFail;
        }
    }

    public boolean verifyExistedCategory()
    {
        boolean isCheckExistedCategory = false;
        getLogger().info("Verify existed category");
        try {
            String categoryName = "Existed category " + randomNumber();
            //Thread.sleep(smallerTimeOut);
            waitForJSandJQueryToLoad();
            waitForClickableOfLocator(By.id("category-name"));
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, categoryName, "send key to categoryNameFieldOnFormEle");
            chooseCategoryColorInPopup();
            clickNewCategoryCreateButton();
            clickToNewCategoryDllInList();
            waitForJSandJQueryToLoad();
            waitForClickableOfLocator(By.id("category-name"));
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, categoryName, "send key to categoryNameFieldOnFormEle");
            chooseCategoryColorInPopup();
            clickNewCategoryCreateButton();

            waitForVisibleElement(xpathCategoryExistedText, "wait for xpathCategoryExistedText");
            String strGetExistedMessage = xpathCategoryExistedText.getText();
            if(strGetExistedMessage.equals(existedCategoryName))
            {
                isCheckExistedCategory = true;
            }
            if(isCheckExistedCategory) {
                NXGReports.addStep("Verify not complete to create category", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify not complete to create category", LogAs.FAILED, null);
            }
            return isCheckExistedCategory;
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify not complete to create category", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckExistedCategory;
        }
    }


    //Vien Added=================
    public void hoverElementAndClickToOtherElement(WebElement element1, String elementName1, WebElement element2, String elementName2) {
        getLogger().info("Try to hoverElement: " + elementName1 + " and click to " + elementName2);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element1).moveToElement(element2).click(element2);
            actions.build().perform();
            NXGReports.addStep("Hover and click", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Hover and click", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void editSameMultiItems(String newValue, int numberOfItems) throws Exception {
        int i;
        try {
            for (i = 0; i < numberOfItems; i++) {
                waitForVisibleElement(listOfCategoriesItemEle.get(i), "Category Item " + i);
                hoverElementAndClickToOtherElement(listOfCategoriesItemEle.get(i), "Category Item " + i, listOfEditPenEle.get(i), "Edit Pen " + i);
                sendKeyTextBox(listOfCategoriesItemEle.get(i), newValue, String.format("Category Item %d", i));
                Thread.sleep(smallerTimeOut);
            }
            NXGReports.addStep("Enter new value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Enter new value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void removeCategories(int numberOfItems) throws Exception {
        int i;
        try {
            for (i = 0; i < numberOfItems; i++) {
                waitForVisibleElement(listOfCategoriesItemEle.get(i), "Category Item " + i);
                hoverElementAndClickToOtherElement(listOfCategoriesItemEle.get(i), "Category Item " + i, listOfEditTrashEle.get(i), "Trash " + i);
                Thread.sleep(smallTimeOut);
            }
            NXGReports.addStep("Temporary Remove categories", LogAs.PASSED, null);


        } catch (Exception e) {
            NXGReports.addStep("Temporary Remove categories", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));


        }


    }

    /**
     @Description In order to wait element to be visible.
     @param element element defined on page class
     @param elementName Name of element that we want to verify
     */
    public boolean waitForCssValueChanged(WebElement element, String elementName, String cssName, String cssValue) {
        getLogger().info("Try to waitForCssValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualcssValue = element.getCssValue(cssName);
                    System.out.println("Actual Displayed Value: " + actualcssValue);
                    if (actualcssValue.equals(cssValue))
                        return true;
                    else
                        return false;
                }
            });
            NXGReports.addStep(String.format("CSS '%s' of element '%s' is changed to '%s'", cssName, elementName, cssValue), LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("CSS Value is not changed");
            NXGReports.addStep(String.format("CSS '%s' of element '%s' is NOT changed", cssName, elementName), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     *
     * @param webElement  WebElement
     * @param elementText Text of Element not be presented.
     */
    public boolean validateElementTextNotDisplayed(WebElement webElement, String elementText) {
        try {
            getLogger().info("Check renderd of text: " + elementText);
            getLogger().info("Actual Text is displayed: " + webElement.getText().trim());
            Assert.assertNotEquals(webElement.getText().trim(),elementText);
            NXGReports.addStep(elementText + " did not rendered", LogAs.PASSED,null);
            return true;
        }catch (AssertionError error) {
            getLogger().info(error);
            AbstractService.sStatusCnt++;
            NXGReports.addStep(elementText + " rendered", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     * Find the index(position) of Web Element in the list Web Element by attribute value
     * @param listElement List WebElement
     * @param textValue   String text which is compared with each WebElements.
     * @return i if the WebElement is matched, otherwise return -1.
     *
     */
    public int findElementByAttributeValue(List<WebElement> listElement, String textValue) {
        try {
            String actualAttributeValue;
            for (int i = 0; i < listElement.size(); i++) {
                actualAttributeValue = listElement.get(i).getAttribute("value").trim();
                if (actualAttributeValue.equals(textValue)) {
                    getLogger().info("Element is found at " + i);
                    NXGReports.addStep(String.format("The position of the text name '%s' at %d", textValue, i), LogAs.PASSED, null);
                    return i;
                }
            }
            AbstractService.sStatusCnt++;
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            NXGReports.addStep(String.format("Cannot find the text name: %s", textValue), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return -1;

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            NXGReports.addStep(String.format("Cannot find the text name: %s", textValue), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return -1;
        }
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- Start
    public boolean isThisDateValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null || "".equals(dateToValidate)){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /*
    Method to wait Ajax function on Site be loaded successfully.
     */
    public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)getDriver()).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)getDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
    public boolean waitForDisappearElement(WebElement element, String elementName){
        getLogger().info("Try to waitForDisappearElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
            NXGReports.addStep("Element: " + elementName + " is disappear.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element: " + element.getText() + "is not disappear.");
            NXGReports.addStep("Element: " + elementName + " is not disappear.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public void waitPageLoad() throws InterruptedException {
        getLogger().info("Just a moment. Page is loading.");
        Thread.sleep(smallerTimeOut);
    }


    //Vien.Pham add for ticket 2291
    public int verifyListOfCurrentCategories(List<WebElement> webElement) {
        int numberOfItemsBefore = 0;
        for (WebElement tdElement : webElement) {
            String isCheckCategory = nullChars;
            try {
                isCheckCategory = tdElement.getAttribute("data-dbdata");
                numberOfItemsBefore++;
            } catch (Exception ex) {
            }
        }

        return numberOfItemsBefore;
    }

    public void verifyItemsRemovedOrNot(int numberOfItemsBefore, int numberOfItemsbeRemoved, List<WebElement> webElement) {
        int numberOfItemDisplayed = 0;
        int result = numberOfItemsBefore - numberOfItemsbeRemoved;
        try {
            for (WebElement tdElement : webElement) {
                String isCheckCategory = nullChars;
                isCheckCategory = tdElement.getAttribute("data-dbdata");
                if (isCheckCategory == null) {
                    numberOfItemDisplayed = 0;
                    break;
                } else {
                    numberOfItemDisplayed++;
                }
                if (numberOfItemDisplayed == result) {
                    NXGReports.addStep("Remove completed ", LogAs.PASSED, null);

                } else {
                    NXGReports.addStep("Remove completed ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }


            }
            System.out.println("so luong item after: " + result);
        } catch (Exception e) {
            NXGReports.addStep("Remove completed ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * Find the index(position) of Web Element in the list Web Element by text value
     *
     * @param listElement List WebElement
     * @param textValue   String text which is compared with each WebElements.
     * @return i if the WebElement is matched, otherwise return -1.
     */
    public int findElementByText(List<WebElement> listElement, String textValue) {
        try {
            String actualTextValue;
            for (int i = 0; i < listElement.size(); i++) {
                actualTextValue = listElement.get(i).getText().trim();
                if (actualTextValue.equals(textValue)) {
                    getLogger().info("Element is found at " + i);
                    NXGReports.addStep(String.format("The position of the text name '%s' at %d", textValue, i), LogAs.PASSED, null);
                    return i;
                }
            }
            AbstractService.sStatusCnt++;
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            NXGReports.addStep(String.format("Cannot find the text name: %s", textValue), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return -1;

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            NXGReports.addStep(String.format("Cannot find the text name: %s", textValue), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return -1;
        }
    }

    /**
     * Find the index(position) of Web Element in the list Web Element by attribute value
     *
     * @param listElement List WebElement
     * @param textValue   String text which is compared with each WebElements.
     * @param attributeName   String attributeName which attribute will be found with get Attribute method.
     * @return i if the WebElement is matched, otherwise return -1.
     */
    public int findElementByAttribute(List<WebElement> listElement, String textValue, String attributeName) {
        try {
            String actualAttributeValue;
            for (int i = 0; i < listElement.size(); i++) {
                actualAttributeValue = listElement.get(i).getAttribute(attributeName).trim();
                if (actualAttributeValue.equals(textValue)) {
                    getLogger().info("Element is found at " + i);
                    NXGReports.addStep(String.format("The position of the text name '%s' at %d", textValue, i), LogAs.PASSED, null);
                    return i;
                }
            }
            AbstractService.sStatusCnt++;
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            NXGReports.addStep(String.format("Cannot find the text name: %s", textValue), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return -1;

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            NXGReports.addStep(String.format("Cannot find the text name: %s", textValue), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return -1;
        }
    }

    public boolean closeSuccessToastMes(){
        try {
            getLogger().info("Close the Success Toast Message.");
            boolean result;
            waitForClickableOfElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
            result = clickElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
            Assert.assertTrue(result, "The Toast Message should be closed.");
            NXGReports.addStep("The Toast Message is closed successfully", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return true;

        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Cannot close the Success Toast Message.");
            NXGReports.addStep("The Toast Message is closed unsuccessfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public String getDate(int day) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, day);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return simpleDateFormat.format(date.getTime());
    }

    public String getDate(int day, String formatDate) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, day);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
        return simpleDateFormat.format(date.getTime());
    }

    public String getCurrentDayNumberSuffix() {
        Date date = new Date();
        SimpleDateFormat formatDayOfMonth  = new SimpleDateFormat("d");
        int day = Integer.parseInt(formatDayOfMonth.format(date));
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    /**
     @Description In order to wait text value of Element is changed.
     @param element element defined on page class
     @param elementName Name of element that we want to verify
     */
    public boolean waitForTextValueChanged(WebElement element, String elementName, String textValue) {
        getLogger().info("Try to waitForCssValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualTextValue = element.getText().trim();
                    System.out.println("Actual Displayed Value: " + actualTextValue);
                    System.out.println("Expected Displayed Value: " + textValue);
                    if (actualTextValue.equals(textValue))
                        return true;
                    else
                        return false;
                }
            });
            NXGReports.addStep(String.format("Text Value of element '%s' is changed to '%s'", elementName, textValue), LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("CSS Value is not changed");
            NXGReports.addStep(String.format("Text Value of element '%s' is NOT changed", elementName), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }
}