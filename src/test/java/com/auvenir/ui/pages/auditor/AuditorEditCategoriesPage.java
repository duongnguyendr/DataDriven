package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.omg.PortableInterceptor.ServerRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by vien.pham on 5/13/2017.
 */
public class AuditorEditCategoriesPage extends AbstractPage {
    public static final String specialCharacters = "!@#$%^&*()";
    public static final String nullValue = "";
    public static final int oneItemBeRemoved = 1;
    public static final int twoItemsBeRemoved = 2;

    public AuditorEditCategoriesPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"form-todo\"]/td[3]/div/div[1]")
    private WebElement dropdownCategoryEle;

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

    @FindBy(xpath = "//img[contains(@id,\"cat-trash-btn\")]")
    List<WebElement> listOfEditTrashEle;

    @FindBy(xpath = "//img[contains(@id,\"cat-edit-btn\")]")
    List<WebElement> listOfEditPenEle;

    @FindBy(xpath = "//div[@class=\"auv-cat-error\"]/p[@class=\"auv-inputError\"]")
    WebElement notAValidNameEle;
    @FindBy(id = "auv-todo-createToDo")
    WebElement createToDoBtnEle;

    @FindBy(xpath = "//div[contains(@class, 'ui dropdown category todo-bulkDdl ')]/div[2]/div/button")
    List<WebElement> listOfCategoriesDropdownTableEle;


    public void selectEditCategories() throws Exception {
        getLogger().info("Select Category DropDown menu");
        waitForVisibleElement(dropdownCategoryEle, "SelectCategory menu");
        dropdownCategoryEle.click();
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
        Thread.sleep(2000);

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


    public void verifyCancelBtn() throws Exception {
        getLogger().info("Verifying Cancel button..");
        try {
            validateCssValueElement(eleEditCategoryCancelBtn, "background-color", "rgba(151, 147, 147, 1)");
            validateCssValueElement(eleEditCategoryCancelBtn, "color", "rgba(255, 255, 255, 1)");
            validateEnabledElement(eleEditCategoryCancelBtn, "Cancel Button");

            NXGReports.addStep("Cancel displayed correctly", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Cancel displayed incorrectly", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void selectCancelBtn() throws Exception {
        getLogger().info("Trying to click Cancel button...");
        try {
            waitForVisibleElement(eleEditCategoryCancelBtn, "Cancel button");
            eleEditCategoryCancelBtn.click();
            NXGReports.addStep("Select Cancel button successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Select Cancel button unsuccessfully", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void selectSaveBtn() throws Exception {
        getLogger().info("Trying to click Save button...");
        try {
            waitForVisibleElement(eleEditCategorySaveBtn, "Cancel button");
            eleEditCategorySaveBtn.click();
            NXGReports.addStep("Select Save button successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Select Save button unsuccessfully", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDefaultSaveBtn() throws Exception {
        try {
            getLogger().info("Verifying Default Save button...");
            validateDisPlayedElement(eleEditCategorySaveBtn, "Save");
            validateCssValueElement(eleEditCategorySaveBtn, "background-color", "rgba(89, 155, 161, 1)");
            validateCssValueElement(eleEditCategorySaveBtn, "color", "rgba(255, 255, 255, 1)");
            getLogger().info("Verifying Default Save button is disable...");
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), "true");
            NXGReports.addStep("Default Save button displayed correctly", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Default Save button displayed incorrectly", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyUnActiveSaveBtn() throws Exception {
        Thread.sleep(smallTimeOut);
        getLogger().info("Verify Save button is disable...");
        try {
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), "true");
            NXGReports.addStep("Save button is disable", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Save button is enable", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));


        }

    }


    public void verifyActiveSaveBtn() throws Exception {
        Thread.sleep(smallTimeOut);
        getLogger().info("Verify Save button is enable...");
        try {
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), null);
            eleEditCategorySaveBtn.click();
            NXGReports.addStep("Save button is enable", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Save button is disable", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyCategoriesSaved(String newValue) {

        try {
            listOfCategoriesDropdownTableEle.get(0).getText().equals(newValue);
            NXGReports.addStep("Valid value was saved ", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Valid value was not saved ", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyCategoriesNotSaved(String newVlue) throws InterruptedException {
        for (WebElement tdElement : listOfCategoriesDropdownTableEle) {
            String isCheckCategory = "";
            Thread.sleep(smallerTimeOut);
            isCheckCategory = tdElement.getText();
            getLogger().info("SearchValue = " + isCheckCategory);
            if (isCheckCategory.equals(newVlue)) {
                NXGReports.addStep("Invalid value still appear in list", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            } else {
                NXGReports.addStep("Invalid value do not appear in list", LogAs.PASSED, null);
            }

        }
    }


    public void editCategoryItem() throws Exception {
        try {
            getLogger().info("Trying to edit with 1 new valid value...");
            String newValue = "NewCategory " + randomNumber();
            scrollPageUp();
            editSameMultiItems(newValue, 1);
            scrollPageDown();
            verifyActiveSaveBtn();
            Thread.sleep(smallTimeOut);
            clickElement(dropdownCategoryEle, " dropdownCategoryEle");
            Thread.sleep(smallTimeOut);
            getLogger().info("Verifying new valid value should be saved...");
            verifyCategoriesSaved(newValue);
            clickElement(eleEditCategory, "Edit category option");
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("User can save 1 new valid value successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("User can not save 1 new valid value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void editSameMultiItems() throws Exception {
        try {
            getLogger().info("Trying to edit with 2 same valid values...");
            String newValue = "NewCategory " + randomNumber();
            scrollPageUp();
            Thread.sleep(2000);
            editSameMultiItems(newValue, 3);
            scrollPageDown();
            verifyUnActiveSaveBtn();
            Thread.sleep(smallTimeOut);
            clickElement(dropdownCategoryEle, "dropdownCategoryEle");
            Thread.sleep(smallTimeOut);
            getLogger().info("Verifying multi valid values should be not saved...");
            verifyCategoriesNotSaved(newValue);
            clickElement(eleEditCategory, "Edit category option");
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can not save same multi value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can not save same multi value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void editInValidMultiItems() throws Exception {
        try {
            getLogger().info("Trying to edit with valid and invalid values...");
            scrollPageUp();
            Thread.sleep(2000);
            editSameMultiItems(specialCharacters, 2);
            eleEditCategoryGuide.click();
            scrollPageDown();
            verifyUnActiveSaveBtn();
            selectCancelBtn();
            Thread.sleep(smallTimeOut);
            clickElement(dropdownCategoryEle, " dropdownCategoryEle");
            Thread.sleep(2000);
            getLogger().info("verifying multi invalid values was saved or not...?");
            verifyCategoriesNotSaved(specialCharacters);
            clickElement(eleEditCategory, "Edit category option");
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify User can not save multi invalid value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can not save multi invalid value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public void editOnlyNumber() throws Exception {
        try {
            getLogger().info("Trying to edit with new Only number...");
            scrollPageUp();
            Thread.sleep(2000);
            String newValue = Integer.toString(randomNumber());
            editSameMultiItems(newValue, 1);
            scrollPageDown();
            verifyActiveSaveBtn();
            Thread.sleep(smallTimeOut);
            clickElement(dropdownCategoryEle, "DropdownCategoryEle");
            Thread.sleep(2000);
            getLogger().info("Verifying new number was saved or not...");
            verifyCategoriesSaved(newValue);
            clickElement(eleEditCategory, "Edit category option");
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("User can save number successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("User can not save number", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public void editNullChar() throws Exception {
        try {
            getLogger().info("Trying to edit with null value...");
            scrollPageUp();
            Thread.sleep(2000);
            editSameMultiItems(nullValue, 1);
            eleEditCategoryGuide.click();
            validateDisPlayedElement(notAValidNameEle, "Warning");
            scrollPageDown();
            verifyUnActiveSaveBtn();
            selectCancelBtn();
            Thread.sleep(smallTimeOut);
            clickElement(dropdownCategoryEle, "click to dropdownCategoryEle");
            Thread.sleep(2000);
            getLogger().info("verifying null values was saved or not...?");
            verifyCategoriesNotSaved(nullValue);
            clickElement(eleEditCategory, "Edit category option");
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("User can not save null value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("User still save null value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void editSpecialChars() throws Exception {
        try {
            getLogger().info("Trying to edit with special value...");
            scrollPageUp();
            Thread.sleep(2000);
            editSameMultiItems(specialCharacters, 1);
            validateDisPlayedElement(notAValidNameEle, "Warning");
            scrollPageDown();
            verifyUnActiveSaveBtn();
            selectCancelBtn();
            Thread.sleep(2000);
            getLogger().info("verifying invalid values was saved or not...?");
            clickElement(dropdownCategoryEle, "click to dropdownCategoryEle");
            Thread.sleep(2000);
            verifyCategoriesNotSaved(specialCharacters);
            clickElement(eleEditCategory, "Edit category option");
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("User can not save special value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("User still save special value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void remove1Item() throws Exception {
        try {
            getLogger().info("Trying remove 1 category...");
            clickElement(dropdownCategoryTodoPageEle, "dropdown Category");
            validateDisPlayedElement(editCategoryTodoPage, "select EditOption");
            clickElement(editCategoryTodoPage, "select EditOption");
            int numberItemsBefore = verifyListOfCurrentCategories(listOfCategoriesItemEle);
            System.out.println("so luong item before la: " + numberItemsBefore);
            scrollPageUp();
            Thread.sleep(2000);
            removeCategories(oneItemBeRemoved);
            scrollPageDown();
            verifyActiveSaveBtn();
            Thread.sleep(2000);
            getLogger().info("verifying item was removed or not...");
            clickElement(dropdownCategoryTodoPageEle, "dropdownCategory");
            Thread.sleep(2000);
            clickElement(editCategoryTodoPage, "select EditOption");
            verifyItemsRemovedOrNot(numberItemsBefore, oneItemBeRemoved, listOfCategoriesItemEle);
            NXGReports.addStep("Verify User can remove 1 Item", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify User can remove 1 Item", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void removeMultiItems() throws Exception {
        try {
            getLogger().info("Trying remove multi categories...");
//            clickElement(dropdownCategoryTodoPageEle, "dropdown Category");
//            validateDisPlayedElement(editCategoryTodoPage, "select EditOption");
//            clickElement(editCategoryTodoPage, "select EditOption");
            int numberItemsBefore = verifyListOfCurrentCategories(listOfCategoriesItemEle);
            System.out.println("So tuong items before la: " + numberItemsBefore);
            scrollPageUp();
            Thread.sleep(2000);
            removeCategories(4);
            scrollPageDown();
            verifyActiveSaveBtn();
            Thread.sleep(2000);
            getLogger().info("verifying multi items were removed or not...");
            clickElement(dropdownCategoryTodoPageEle, "dropdownCategory");
            Thread.sleep(2000);
            clickElement(editCategoryTodoPage, "select EditOption");
            verifyItemsRemovedOrNot(numberItemsBefore, twoItemsBeRemoved, listOfCategoriesItemEle);
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

    public void verifyHoverOnCategoryItem() {

        try {
            getLogger().info("Verifying Trash and Pen appear after hovered on item..");
            waitForVisibleElement(listOfCategoriesItemEle.get(0), "Category item 1");
            hoverElement(listOfCategoriesItemEle.get(0), "Category item 1");
            validateDisPlayedElement(listOfEditPenEle.get(0), "Pen 1");
            validateDisPlayedElement(listOfEditTrashEle.get(0), "Trash 1");
            getLogger().info("Verifying Item is removed temporary when select Trash icon..");
            listOfEditTrashEle.get(0).click();
            Thread.sleep(smallerTimeOut);
            verifyActiveRemoveStatus();
            getLogger().info("Verifying item returned to previous status if user select Trash icon again..");
            hoverElement(listOfCategoriesItemEle.get(0), "Category item 1");
            validateDisPlayedElement(listOfEditTrashEle.get(0), "Trash 1");
            listOfEditTrashEle.get(0).click();
            Thread.sleep(smallerTimeOut);
            verifyUnActiveRemoveStatus();
            validateDisPlayedElement(eleEditCategoryCancelBtn, "Cancel btn");
            eleEditCategoryCancelBtn.click();
            Thread.sleep(1000);
            selectEditCategories();

            NXGReports.addStep("Hover works as expected", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Hover works as unexpected", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyActiveRemoveStatus() {

        if (listOfCategoriesItemEle.get(0).getAttribute("data-del").equals("1")) {

            NXGReports.addStep("Item is temporary removed", LogAs.PASSED, null);

        } else {
            NXGReports.addStep("Item is not temporary removed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyUnActiveRemoveStatus() {
        if (listOfCategoriesItemEle.get(0).getAttribute("data-del").equals("0")) {
            NXGReports.addStep("Item returned to unActiveRemove", LogAs.PASSED, null);

        } else {
            NXGReports.addStep("Item did not return to unActiveRemoved", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

}
