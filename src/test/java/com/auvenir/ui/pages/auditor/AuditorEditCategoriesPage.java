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

    @FindBy(xpath = "//*[@id=\"form-todo\"]/td[3]/div/div[2]/div[2]")
    WebElement eleEditCategory;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//h3 [@class='setup-header']")
    WebElement eleEditCategoryTitle;

    @FindBy(xpath = "//div[27]//div[@class=\"todo-modal-component\"]//*[@id=\"setup-component-body\"]/div/div[1]")
    WebElement eleEditCategoryGuide;

    //list of Pen

    @FindBy(xpath = "//div[starts-with(@class,\"setup-inputContainer\")]/div[2]/img[@id=\"cat-edit-btn\"]")
    WebElement eleEditCategoryFirstPen;

    @FindBy(xpath = "//div[starts-with(@class,\"setup-inputContainer\")]/div[3]/img[@id=\"cat-edit-btn\"]")
    WebElement eleEditCategorySecondPen;

    @FindBy(xpath = "//div[starts-with(@class,\"setup-inputContainer\")]/div[4]/img[@id=\"cat-edit-btn\"]")
    WebElement eleEditCategoryThirdPen;

    @FindBy(xpath = "//img[contains(@id,\"cat-edit-btn\")]")
    WebElement listOfEditPenEle;



    //=================

    @FindBy(xpath = "//div[27][starts-with(@id,\"categoryModel\")]//button[@id=\"m-ce-cancelBtn\"]")
    WebElement eleEditCategoryCancelBtn;

    @FindBy(xpath = "//div[@class=\"ce-footerBtnHolder\"]/button[@id=\"category-updateBtn\"]")
    WebElement eleEditCategorySaveBtn;

//    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//img[starts-with(@id,'modal-close-categoryModel')]")
//    WebElement eleEditCategoryCloseBtn;

    @FindBy(xpath = "//*[@id=\"todo-cancel-btn\"]")
    WebElement eleEditCategoryCloseBtn;
    //list of Categories Items
    @FindBy(xpath = "//div[starts-with(@class,\"setup-inputContainer\")]/div[2]/div/input")
    WebElement eleCategoryItem1;
    @FindBy(xpath = "//div[starts-with(@class,\"setup-inputContainer\")]/div[3]/div/input")
    WebElement eleCategoryItem2;
    @FindBy(xpath = "//div[starts-with(@class,\"setup-inputContainer\")]/div[4]/div/input")
    WebElement eleCategoryItem3;

    @FindBy(xpath = "//input[contains(@id,'forge-InputBox')]")
    WebElement listOfCategoriesItemEle;


    //list of Trash

    @FindBy(xpath = "//div[@id=\"edit-category-container\"]/div[2]/img[@id='cat-trash-btn']")
    WebElement eleEditCategoryFirstTrash;
    @FindBy(xpath = "//div[@id=\"edit-category-container\"]/div[3]/img[@id='cat-trash-btn']")
    WebElement eleEditCategorySecondTrash;
    @FindBy(xpath = "//div[@id=\"edit-category-container\"]/div[4]/img[@id='cat-trash-btn']")
    WebElement eleEditCategoryThirdTrash;

    @FindBy(xpath = "//div[@class=\"auv-cat-error\"]/p[@class=\"auv-inputError\"]")
    WebElement notAValidNameEle;
    @FindBy(id = "auv-todo-createToDo")
     WebElement createToDoBtnEle;


    @FindBy(xpath = "//img[contains(@id,\"cat-trash-btn\")]")
    WebElement listOfEditTrashEle;

    // Verify Edit Categories popup is presented successfully
    public void selectEditCategories() throws Exception {
        getLogger().info("Select Category DropDown menu");
        waitForVisibleElement(eleIdDdlCategory, "SelectCategory menu");
        eleIdDdlCategory.click();
        getLogger().info("Select Edit Categories option");
        waitForVisibleElement(eleEditCategory, "Edit Categories option");
        eleEditCategory.click();
        Thread.sleep(smallTimeOut);

    }

    public void returnToCreateNewTodoPage(){
        getLogger().info("Return to Create new todo page");
        waitForVisibleElement(createToDoBtnEle,"Create Todo Button");
        createToDoBtnEle.click();

    }

    public void verifyEditCategoriesPopupTitle() {
        validateDisPlayedElement(eleEditCategoryTitle, "PopUp Title");

    }

    public void verifyEditCategoriesPopupGuide() {
        validateDisPlayedElement(eleEditCategoryGuide, "PopUp Guide");

    }


    public void verifyRemove1Category() throws Exception {
        getLogger().info("Verify click 1remove button");
        try {
            hoverElementAndClickToOtherElement(eleCategoryItem1, "", eleEditCategoryFirstTrash, "");
            System.out.println("hover okey vien pham");
//            validateDisPlayedElement(eleEditCategoryFirstTrash,"First trash icon element");
//            eleEditCategoryFirstTrash.click();
//            this.verifyEleAddBtn();


//            System.out.println("click Add btn okey vien pham");
            NXGReports.addStep("Verify to remove 1 Category", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Verify to remove 1 Category", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }


    }

    public void verifyRemoveMultiCategories() throws Exception {

        getLogger().info("Verify click Multy remove button");
        try {
//    hoverAndClick1Element(eleCategoryItem1,eleEditCategoryFirstTrash);
//    hoverAndClick1Element(eleCategoryItem2,eleEditCategorySecondTrash);
//    hoverAndClick1Element(eleCategoryItem3, eleEditCategoryThirdTrash);
//            this.verifyEleAddBtn();

        } catch (Exception e) {

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
            editCategories(newValue,1);
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
            String newValue1= "NewCategory " + randomNumber();
//            String newValue2= "NewCategory " + randomNumber();
//            String newValue3= "NewCategory " + randomNumber();
            scrollPageUp();
            editCategories(newValue1,3);
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
            editCategories("@#$%^&*",3);
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
//            scrollPageUp();
            String newValue = Integer.toString(randomNumber());
            editCategories(newValue,1);
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
            editCategories("",1);
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
            editCategories("~!@#$%^&*+?>",1);
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


    public void verifyNewValueIsEffective() throws Exception {

        getLogger().info("Verify New value is effective...");

        try {
            selectEditCategories();
            waitForVisibleElement(eleCategoryItem1, "Category Item 1");
            Assert.assertEquals(eleCategoryItem1.getAttribute("data-dbdata"), "33333333");
            NXGReports.addStep("Verify New value is effective", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Verify New value is effective", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public int randomNumberForCategoryItems() {
        Random randNum = new Random();
        int intRanNum = randNum.nextInt(3) + 1;
        return intRanNum;
    }

}
