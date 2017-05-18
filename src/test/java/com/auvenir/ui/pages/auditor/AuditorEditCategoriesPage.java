package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.omg.PortableInterceptor.ServerRequestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;


/**
 * Created by vien.pham on 5/13/2017.
 */
public class AuditorEditCategoriesPage extends AbstractPage {
//    public int numberRandom = randomNumberForCategoryItems();

    public AuditorEditCategoriesPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    // Vien.Pham added EditCategories Elements

    @FindBy(xpath = "//*[@id=\"form-todo\"]/td[3]/div/div[1]")
    private WebElement eleIdDdlCategory;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]/td[3]//div[@class='text']")
    WebElement dropdownCategoryTodoPageEle;

    @FindBy(xpath = "//*[@id=\"form-todo\"]/td[3]/div/div[2]/div[2]")
    WebElement eleEditCategory;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]/td[3]//div[@class=\"menu\"]/div[2]")
    WebElement editCategoryTodoPage;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//h3 [@class='setup-header']")
    WebElement eleEditCategoryTitle;

    @FindBy(xpath = "//div[27]//div[@class=\"todo-modal-component\"]//*[@id=\"setup-component-body\"]/div/div[1]")
    WebElement eleEditCategoryGuide;


    @FindBy(xpath = "//div[27][starts-with(@id,\"categoryModel\")]//button[@id=\"m-ce-cancelBtn\"]")
    WebElement eleEditCategoryCancelBtn;

    @FindBy(xpath = "//div[@class=\"ce-footerBtnHolder\"]/button[@id=\"category-updateBtn\"]")
    WebElement eleEditCategorySaveBtn;


    @FindBy(xpath = "//*[@id=\"todo-cancel-btn\"]")
    WebElement eleEditCategoryCloseBtn;

    @FindBy(xpath = "//input[contains(@id,'forge-InputBox')]")
    List<WebElement> listOfCategoriesItemEle;

    @FindBy(xpath = "//div[@class=\"auv-cat-error\"]/p[@class=\"auv-inputError\"]")
    WebElement notAValidNameEle;
    @FindBy(id = "auv-todo-createToDo")
    WebElement createToDoBtnEle;

    @FindBy(xpath = "//div[contains(@class,\"setup-input\")]/div[@class=\"item\"]")
    List<WebElement> listOfCategoriesItems;


    public void selectEditCategories() throws Exception {
        getLogger().info("Select Category DropDown menu");
        waitForVisibleElement(eleIdDdlCategory, "SelectCategory menu");
        eleIdDdlCategory.click();
        getLogger().info("Select Edit Categories option");
        waitForVisibleElement(eleEditCategory, "Edit Categories option");
        eleEditCategory.click();
        Thread.sleep(smallTimeOut);

    }

    public void selectEditCategoriesAtTodoPage() throws Exception {
        getLogger().info("Select Category DropDown menu");
        waitForVisibleElement(dropdownCategoryTodoPageEle, "SelectCategory menu");
        dropdownCategoryTodoPageEle.click();
        getLogger().info("Select Edit Categories option");
        waitForVisibleElement(editCategoryTodoPage, "Edit Categories option");
        editCategoryTodoPage.click();
        Thread.sleep(smallTimeOut);

    }



    public void returnToCreateNewTodoPage() {
        getLogger().info("Return to Create new todo page");
        waitForVisibleElement(createToDoBtnEle, "Create Todo Button");
        createToDoBtnEle.click();

    }

    public void verifyEditCategoriesPopupTitle() {
        validateDisPlayedElement(eleEditCategoryTitle, "PopUp Title");

    }

    public void verifyEditCategoriesPopupGuide() {
        validateDisPlayedElement(eleEditCategoryGuide, "PopUp Guide");

    }

    public void verifyListOfCategories() throws Exception{
        getLogger().info("Verify list of Current Catagory items...");
        try {



        }catch (Exception e){

        }
    }


    public void verifyCancelBtn() throws Exception {
        getLogger().info("Verify attributes of Cancel button");
        try {
            validateCssValueElement(eleEditCategoryCancelBtn, "background-color", "rgba(151, 147, 147, 1)");
            validateCssValueElement(eleEditCategoryCancelBtn, "color", "rgba(255, 255, 255, 1)");
            validateEnabledElement(eleEditCategoryCancelBtn, "Cancel Button");
//            validateDisPlayedElement(eleEditCategoryCancelBtn, "Cancel");
            NXGReports.addStep("Verify attributes of Cancel button", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify attributes of Cancel button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void selectCancelBtn() throws Exception {
        getLogger().info("Trying to click Cancel button");
        try {
            waitForVisibleElement(eleEditCategoryCancelBtn, "Cancel button");
            eleEditCategoryCancelBtn.click();
            NXGReports.addStep("Trying to click Cancel button", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Trying to click Cancel button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void selectSaveBtn() throws Exception {
        getLogger().info("Trying to click Save button");
        try {
            waitForVisibleElement(eleEditCategorySaveBtn, "Cancel button");
            eleEditCategorySaveBtn.click();
            NXGReports.addStep("Trying to click Cancel button", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Trying to click Cancel button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyReturnToCreateNewTodoPage() throws Exception {
        getLogger().info("Verify After click Cancel, return to Create new todo page...");
        try {
            validateDisPlayedElement(eleEditCategoryCloseBtn, "X close element");
            NXGReports.addStep("Verify return to Create new todo page", LogAs.PASSED, null);
        } catch (Exception e) {

            NXGReports.addStep("Verify return to Create new todo page", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyDefaultSaveBtn() throws Exception {
        try {
            getLogger().info("Verifying name and color of Default Save button...");
            validateCssValueElement(eleEditCategorySaveBtn, "background-color", "rgba(89, 155, 161, 1)");
            validateCssValueElement(eleEditCategorySaveBtn, "color", "rgba(255, 255, 255, 1)");
            validateDisPlayedElement(eleEditCategorySaveBtn, "Save");
            getLogger().info("Verifying Default Save button is disable...");
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), "true");
            NXGReports.addStep("Verify default Save button", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify default Save button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyUnActiveSaveBtn() throws Exception {
        Thread.sleep(smallTimeOut);
        getLogger().info("Verify Save button is disable...");
        try {
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), "true");
            NXGReports.addStep("Verify Save button is disable", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Verify Save button is disable", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }


    public void verifyActiveSaveBtn() throws Exception {
        Thread.sleep(smallTimeOut);
        getLogger().info("Verify Save button is enable...");
        try {
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), null);
            eleEditCategorySaveBtn.click();
            NXGReports.addStep("Verify Save button is enable", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Save button is enable", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void editCategoryItem() throws Exception {
        try {
            getLogger().info("Trying to edit with 1 new valid value...");
            String newValue = "NewCategory " + randomNumber();
            scrollPageUp();
            editCategories(newValue, 1);
            scrollPageDown();
            verifyActiveSaveBtn();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can save new valid value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can save new valid value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void editValidMultiItems() throws Exception {
        try {
            getLogger().info("Trying to edit with 3 new valid values...");
            String newValue1 = "NewCategory " + randomNumber();
            scrollPageUp();
            Thread.sleep(2000);
            editCategories(newValue1, 3);
            scrollPageDown();
            verifyActiveSaveBtn();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can save new valid value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can save new valid value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void editInValidMultiItems() throws Exception {
        try {
            getLogger().info("Trying to edit with valid and invalid values...");
//            String newValue = "NewCategory " + randomNumber();
            scrollPageUp();
            Thread.sleep(2000);
            editCategories("@#$%^&*", 3);
            eleEditCategoryGuide.click();
            scrollPageDown();
            verifyUnActiveSaveBtn();
            selectCancelBtn();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can save new valid value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can save new valid value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public void editOnlyNumber() throws Exception {
        try {
            getLogger().info("Trying to edit with new Only number...");
            scrollPageUp();
            Thread.sleep(2000);
            String newValue = Integer.toString(randomNumber());
            editCategories(newValue, 1);
            scrollPageDown();
            verifyActiveSaveBtn();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can save new valid value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can save new valid value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public void editNullChar() throws Exception {
        try {
            getLogger().info("Trying to edit with null value...");
            scrollPageUp();
            Thread.sleep(2000);
            editCategories("", 1);
            eleEditCategoryGuide.click();
            validateDisPlayedElement(notAValidNameEle, "Warning");
            scrollPageDown();
            verifyUnActiveSaveBtn();
            selectCancelBtn();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can not save null value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can not save null value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void editSpecialChars() throws Exception {
        try {
            getLogger().info("Trying to edit with special value...");
            scrollPageUp();
            Thread.sleep(2000);
            editCategories("~!@#$%^&*+?>", 1);
            validateDisPlayedElement(notAValidNameEle, "Warning");
            scrollPageDown();
            verifyUnActiveSaveBtn();
            selectCancelBtn();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can not save null value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can not save null value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }



    public void remove1Item() throws Exception {
        try {
            getLogger().info("Trying remove 1 category...");
            scrollPageUp();
            Thread.sleep(2000);
            removeCategories(1);
            scrollPageDown();
            verifyActiveSaveBtn();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can not save null value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can not save null value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void removeMultiItems() throws Exception {
        try {
            getLogger().info("Trying remove 3 categories...");
            scrollPageUp();
            Thread.sleep(2000);
            removeCategories(3);
            scrollPageDown();
            verifyActiveSaveBtn();
            selectSaveBtn();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can not save null value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can not save null value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public int randomNumberForCategoryItems() {
        Random randNum = new Random();
        int intRanNum = randNum.nextInt(3) + 1;
        return intRanNum;
    }

}
