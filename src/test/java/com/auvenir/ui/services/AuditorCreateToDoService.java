package com.auvenir.ui.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorTodoListPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

import java.util.List;

/**
 * Created by hai.nguyen on 05/04/2017.
 */

public class AuditorCreateToDoService extends AbstractService {

    AuditorCreateToDoPage createToDoPage;
    AuditorTodoListPage todoListPage;
    AuditorEngagementPage engagementPage;
    AuditorDetailsEngagementPage detailsEngagementPage;

    /*
     * contructor
     */
    public AuditorCreateToDoService(Logger logger, WebDriver driver) {

        super(logger, driver);
        createToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
        todoListPage = new AuditorTodoListPage(getLogger(), getDriver());
        engagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        detailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
    }


    public void verifyGUIAddNewToDoNameTextBox(int numberOfTask) {
        getLogger().info("Verify GUI Add New To Do Text Box");
        createToDoPage.verifyDefaultValueToDoNameTextBox(numberOfTask);
        createToDoPage.verifyHoverCssValueToDoNameTextBox();
        createToDoPage.verifyWarningCssValueToDoNameTextBox();
        createToDoPage.verifyGUIButtonCreateToDo();
    }

    public void verifyAuditorCreateToDo() {

        try {
            //this.createToDoTask.navigateToEngagementTask();
            this.createToDoPage.navigateToToDoList();
            createToDoPage.verifyToDoListPage();
            NXGReports.addStep("verify create to do page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify create to do page", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

//    public void verifyGUIAddNewToDoNameTextBox() {
//        try {
//            createToDoTask.verifyDefaultValueToDoNameTextBox();
//            createToDoTask.verifyHoverCssValueToDoNameTextBox();
//            createToDoTask.verifyWarningCssValueToDoNameTextBox();
//            NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.PASSED, null);
//        } catch (Exception e) {
//            NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        }
//    }

    public void verifyButtonFilter() {
        try{
            todoListPage.verifyButtonFilter();
            NXGReports.addStep("verify Filter button displayed.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("verify Filter button displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigatetoCreateToDoTab() {
        getLogger().info("Navigate to CreateToDo Tab");
        try {
            todoListPage.clickCreateToDoBtn();
            todoListPage.waitForNumberOfTodoListIncreased();
            NXGReports.addStep("verify Create ToDo TextBox", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Create ToDo TextBox", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchPlaceholder() {
        getLogger().info("Todo page verify default value(Search...)");
        createToDoPage.verifySearchDefault();
    }

    public void verifyInputDataToDoNameTextBox(String toDoNameValue) {
        getLogger().info("Input data into ToDo name Textbox.");
        createToDoPage.verifyInputValueToDoNameTextBox(toDoNameValue);
    }

    public void verifySearchHover() {
        getLogger().info("Todo page search hover");
        createToDoPage.verifySearchHover();
    }

    public void verifySearchInputText() {
        getLogger().info("Todo page search to input text");
        createToDoPage.verifySearchInputText();
    }

    public void verifySearchInputNumber() {
        getLogger().info("Todo page search to input number");
        createToDoPage.verifySearchInputNumber();
    }

    public void verifySearchInputSpecialChar(){

        createToDoPage.verifySearchInputSpecialChar();
    }

    public void inputSearchText(String inputSearch){

        createToDoPage.inputSearchText(inputSearch);
    }

    public void verifySearchResult(String inputSearch){
        createToDoPage.checkSearchData(inputSearch);
    }

    public void verifySearchResutlNotMatch(){
        createToDoPage.verifySearchResutlNotMatch();
    }
//	public void verifySearchLimit255(){
//		try {
//			createToDoTask.verifySearchLimit255();
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//		}
//	}


//	public void verifyColumnsInGrid(){
//
//		try {
//			createToDoTask.verifyColumnsInGrid();
//			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//		}
//	}
//
//	public void verifySotleOnTitle(){
//
//		try {
//			createToDoTask.verifySotleOnTitle();
//			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//		}
//	}
/*
    public void navigatetoCreateToDoTab() {
        getLogger().info("Navigate to CreateToDo Tab");
        try {
            //createToDoTask.navigateToEngagementTask();
            createToDoTask.navigateToToDoList();
            createToDoTask.clickCreateToDoTask();
            //createToDoTask.verifyAddNewToDoTask();
            NXGReports.addStep("verify Create ToDo TextBox", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Create ToDo TextBox", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
	*/
//	public void verifyCheckOnCheckBox(){
//
//		try {
//			createToDoTask.verifyCheckOnCheckBox();
//			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//		}
//	}
//
//	public void verifyUnCheckOnCheckBox(){
//
//		try {
//
//			createToDoTask.verifyUnCheckOnCheckBox();
//			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//		}
//	}

    public void navigateToDoListPage() throws Exception {
        //this.createToDoPage.navigateToEngagementPage();
        this.createToDoPage.navigateToToDoList();
    }


/*
    public void verifyInputDataToDoNameTextBox(String value) {
        getLogger().info("Input data into ToDo name Textbox.");
        try {
            createToDoTask.verifyInputValueToDoNameTextBox(value);
            NXGReports.addStep("Input value " + value + " on ToDo Name Textbox successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Input value " + value + " on ToDo Name Textbox unsuccessfully.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
*/

//	public void verifySearchLimit255(){
//		try {
//			createToDoTask.verifySearchLimit255();
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//		}
//	}

    public void verifyToDoNameInputSpecialCharacter(String value) {
        getLogger().info("Input special characters into ToDo name Text box.");
        try {
            createToDoPage.verifyToDoNameInputSpecialCharacter(value);
            NXGReports.addStep("Input special characters: " + value + " on ToDo Name Textbox successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Input special characters: " + value + " on ToDo Name Textbox unsuccessfully.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGUIToDoSaveIconDisabled() {
        getLogger().info("Verify GUI of the To Do Save Icon is disabled");
        createToDoPage.verifyDisableToDoSaveIcon();
    }

    public void verifyGUIToDoSaveIconEnabled() {
        getLogger().info("Verify GUI of the To Do Save Icon is enabled");
        createToDoPage.verifyEnableToDoSaveIcon();
    }

    public void verifyToDoCloseIcon() {
        getLogger().info("Verify To Do Close Icon.");
        createToDoPage.verifyToDoCloseIcon();
    }

    public void verifyColumnsInGrid() {

        try {
            createToDoPage.verifyColumnsInGrid();
            NXGReports.addStep("Verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySotleOnTitle() {

        try {
            createToDoPage.verifySotleOnTitle();
            NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCheckOnCheckBox() {

        try {
            createToDoPage.verifyCheckOnCheckBox();
            NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCheckAllCheckBox() throws Exception {
        createToDoPage.verifyCheckAllCheckboxToDoName();
    }

    public void verifyUncheckAllCheckbox() throws Exception {
        createToDoPage.verifyUnCheckAllCheckboxToDoName();
    }

    public void verifyUnCheckOnCheckBox() {

        try {

            createToDoPage.verifyUnCheckOnCheckBox();
            NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    // Vien.Pham added new numberCategories
    public void createToDoPage() {

        try {
            createToDoPage.createToDoTask();
            NXGReports.addStep("Create To-Do page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Create To-Do page", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    /*
        public void verifyGUIAddNewToDoNameTextBox() {
            try {
                createToDoTask.verifyDefaultValueToDoNameTextBox();
                createToDoTask.verifyHoverCssValueToDoNameTextBox();
                createToDoTask.verifyWarningCssValueToDoNameTextBox();
                NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.PASSED, null);
            } catch (Exception e) {
                NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        }
    */
    public void verifyAddNewToDoTask(String toDoName) throws Exception {
        createToDoPage.createToDoTask(toDoName);
    }

    public void verifySortDataGridIcon() {
        createToDoPage.verifySortToDoTaskOnName();
    }

    public void verifyCheckBoxToDoName() throws Exception {
        // bug for check all button so we skip
        //createToDoPage.verifyCheckAllCheckboxToDoName();
//        createToDoPage.verifyUnCheckAllCheckboxToDoName();
        createToDoPage.verifyCheckMultipleCheckBoxToDoName();
    }

    public void verifyDefaultValueofCategoryComboBox(String defaultValueComboBox) {
        createToDoPage.verifyDefaultValueofCategoryComboBox(defaultValueComboBox);
    }

    public void verifyHoverCategoryComboBox() {

        createToDoPage.verifyHoverCategoryComboBox();
    }

//    public void verifyCreateNewCategory() {
//        getLogger().info("Verify create new Category");
//        createToDoPage.verifyCreateNewCategory();
//    }

    public void verifyAddNewCategoryPopupTitle() {
        getLogger().info("Verify title of add new category popup");
        createToDoPage.verifyAddNewCategoryPopupTitle();
    }

    public void verifyNewCategoryNameTextbox() {
        getLogger().info("Verify new category name textbox");
        createToDoPage.verifyNewCategoryNameTextbox();
    }

    public void verifyNewCategoryColorCombobox() {
        getLogger().info("Verify new category color combobox");
        createToDoPage.verifyNewCategoryColorCombobox();
    }

    public void verifyNewCategoryCreateCancelButton() {
        getLogger().info("Verify new category create/cancel button");
        createToDoPage.verifyNewCategoryCreateCancelButton();
    }

    public void verifyDataSearch() {
        getLogger().info("Verify the search data");
        createToDoPage.checkSearchData();
    }

    public void verifyCheckMaxLength() {
        getLogger().info("Verify to check max length");
        createToDoPage.verifyCheckMaxLength();
    }

    public void verifyContentTextSearch() {
        getLogger().info("Verify the content text search");
        createToDoPage.checkContentTextSearch();
    }

//    public void createFailedTodoPage() throws Exception {
//        try {
//            boolean isCheckData = createToDoPage.checkSearchData();
//            if(isCheckData) {
//                NXGReports.addStep("Verify realtime search", LogAs.PASSED, null);
//            }
//            else
//            {
//                NXGReports.addStep("Verify realtime search", LogAs.FAILED, null);
//            }
//            getLogger().info("verifyDataSearch() isCheckData = " + isCheckData);
//        } catch (Exception e) {
//            NXGReports.addStep("Verify realtime search", LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        }
//    }

    public void createToDoTaskWithCategoryName(String toDoNameTask, String categoryName) throws Exception {
        createToDoPage.createToDoTaskWithCategoryName(toDoNameTask, categoryName);
    }

    public void clickCreateToDoTask() throws Exception {
        createToDoPage.clickCreateToDoTask();
    }

    public void verifyValueofCategoryComboBox(String categoryName) throws Exception {
        createToDoPage.verifyListValueofCategoryComboxBox(categoryName);
    }

    public void verifyNewCategoryPopUpDisplayed() throws Exception {
        createToDoPage.clickAddNewCategory();
        createToDoPage.verifyNewCategoryPopUpDisplayed();
    }

    public void verifyEditCategoryPopUpDisplayed() throws Exception {
        createToDoPage.clickEditCategory();
        createToDoPage.verifyEditCategoriesPopUpDisplayed();
    }

    public void verifyCreateToDoTaskWithoutCategory(String todoName) throws Exception {
        createToDoPage.verifyCreateToDoTaskWithoutCategory(todoName);
    }

    public void verifyInputMaxLengthToDoNameTextBox() {
        createToDoPage.verifyInputMaxLengthToDoNameTextBox();
    }

    public void verifyInputInValidValueToDoNameTextBox() {
        createToDoPage.inputInvalidValueToDoNameTextBox();
        createToDoPage.selectDueDateToDoTask();
        createToDoPage.verifyWarningCssValueToDoNameTextBox();
    }

    public void setDueDateField() {
        createToDoPage.selectDueDateToDoTask();
    }

    public void createListToDoTask(List<String> toDoTaskNames) throws Exception {
        for (int i = 0; i < toDoTaskNames.size(); i++) {
            createToDoPage.createToDoTask(toDoTaskNames.get(i));
        }
    }

    public void clickCheckboxNewToDoTask() {
        createToDoPage.clickCheckboxNewToDoTask();
    }

    public void clickBulkActionsDropdown() {
        createToDoPage.clickBulkActionsDropdown();
    }

    public void verifyDefaultValueofBulkActionsDropdown(String defaultValueBulkActions) {
        createToDoPage.verifyDefaultValueofBulkActionsDropdown(defaultValueBulkActions);
    }

    public void verifyHoverBulkActionsDropdown() {
        createToDoPage.verifyHoverBulkActionsDropdown();
    }

    public void verifyListValueofBulkActionsDropdown() {
        createToDoPage.verifyListValueofBulkActionsDropdown();
    }

    public void clickDeleteToDoBulkActions() {
        createToDoPage.clickDeleteToDoBulkActions();
    }

    public void verifyCompleteMarkPopup() {
        createToDoPage.verifyCompleteMarkPopup();
    }

    public void verifyClickCloseMarkPopup() {
        createToDoPage.verifyClickCloseMarkPopup();
    }

    public void verifyDeleteToDoPopUpDisplayed() {
        createToDoPage.verifyGUIDeleteToDoPopUp();
    }

    public void clickCloseButtonOnPopup() {
        createToDoPage.clickCloseButtonOnPopup();
    }

    public void clickCancelButtonOnPopup() {
        createToDoPage.clickCancelButtonOnPopup();
    }

    public void verifyBulkActionsDropdownIsClosed() {
        createToDoPage.verifyBulkActionsDropdownIsClosed();
    }

    public void selectToDoTaskName(String toDoName) {
        createToDoPage.selectToDoCheckboxByName(toDoName);
    }

    public void unselectToDoTaskName(String toDoName) {
        createToDoPage.unSelectToDoCheckboxByName(toDoName);
    }

    public int getNumberofToDoTask() {
        return createToDoPage.getNumberofToDoTask();
    }

    public void waitMessageIsDisappear() {
        //createToDoPage.waitMessageIsDisappear();
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- Start

    /**
     * Move add new to do page
     */
    public void navigateAddNewToDoPage() {

        try {
            createToDoPage.navigateAddNewToDoPage();
            NXGReports.addStep("Move Add new To-Do page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Move Add new To-Do page", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify select data drop down
     */
    public void verifySelectDateDropDown() throws Exception {
        createToDoPage.verifySelectDateDropDown();
    }

    /**
     * Check default value of due date text box
     */
    public void checkDefaultValueDueDate() {
        boolean result = createToDoPage.checkDefaultDueDateValue();
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Check deafult format due date
     */
    public void checkFormatDueDate() {
        boolean result = createToDoPage.checkFormatDueDate_TodoListPage();
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify data in date picker
     */
    public void verifyDataOfDatePicker(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyDataOfDatePicker(isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }


    /**
     * Hover item in date picker
     */
    public void hoverItemInDatePikcer(boolean isNewToDoPage) {
        createToDoPage.hoverDateItemInDatePicker(isNewToDoPage);
    }

    /**
     * Choose date item in date picker
     */
    public void chooseDateItemInDatePicker(boolean isNewToDoPage) throws Exception {
        boolean result = createToDoPage.chooseDateItemInDataPicker(isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify previous date picker link is click
     */
    public void verifyPreviousDatePickerLink(boolean isNewToDoPage) {
        boolean result = createToDoPage.checkDatePickerChangeMonth("prev", false, isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify next date picker link is click
     */
    public void verifyNextDatePickerLink(boolean isNewToDoPage) {
        boolean result = createToDoPage.checkDatePickerChangeMonth("next", true, isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify input correct format date in due date text box
     */
    public void verifyInputCorrectFormatDate(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyInputCorrectFormatDate("05/20/2017", isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify input wrong format date in due date text box
     */
    public void verifyInputWrongFormatDate(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyInputWrongValue("055/20/2017", isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify input text in due date text box
     */
    public void verifyInputTextValue(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyInputWrongValue("dadasdasdad", isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify input text in due date text box
     */
    public void verifyInputSpecialCharacterValue(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyInputWrongValue("~!@#$%^&*+?><,. ", isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- End

    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- Start

    /**
     * Verify trash to do icon
     */
    public void verifyTrashToDoIcon() {
        createToDoPage.verifyTrashToDoIcon();
    }

    /**
     * Verify default status trash to do icon
     */
    public void verifyDefaultStatusTrashToDoIcon() {
        createToDoPage.verifyDefaultStatusTrashToDoIcon();
    }

    /**
     * Click on trash delete icon
     */
    public void clickOnTrashIcon() {
        createToDoPage.clickOnTrashIcon();
    }

    /**
     * Verify GUI and Close icon of delete confirm popup
     */
    public void verifyGUIDeleteConfirmPopup() {
        createToDoPage.verifyGUIDeleteConfirmPopup();
    }

    /**
     * Check or Uncheck CheckAll check box control
     *
     * @param isCheck : true check | false is un check
     */
    public void checkOrUnCheckCheckAllCheckBox(boolean isCheck) {
        createToDoPage.checkOrUnCheckCheckAllCheckBox(isCheck);
    }

    /**
     * Verify all check box is check or un check
     *
     * @param isCheck : true check | false is un check
     */
    public void verifyAllCheckBoxIsCheckOrUnCheck(boolean isCheck) {
        createToDoPage.verifyAllCheckBoxIsCheckOrUnCheck(isCheck);
    }

    /**
     * Check or Uncheck all check box control
     *
     * @param isCheck : true check | false is un check
     */
    public void checkOrUnCheckAllCheckBox(boolean isCheck) {
        createToDoPage.checkOrUnCheckCheckAllCheckBox(isCheck);
    }

    /**
     * Verify all check box is check or un check
     *
     * @param isCheck : true check | false is un check
     */
    public void verifyCheckAllCheckBoxIsCheckOrUncheck(boolean isCheck) {
        createToDoPage.verifyAllCheckBoxIsCheckOrUnCheck(isCheck);
    }

    /**
     * Click on delete button popup
     */
    public void clickOnDeleteButtonOnPopup() {
        createToDoPage.clickOnDeleteButtonOnPopup();
    }

    /**
     * Click on cancel button popup
     */
    public void clickOnCancelButtonOnPopup() {
        createToDoPage.clickOnCancelButtonOnPopup();
    }

    /**
     * Check ToDo item is exist
     *
     * @param isExists : true : is exists | false : is not exists
     * @param ToDoName : ToDo name need check
     */
    public void checkToDoIsExists(boolean isExists, String ToDoName) {
        if (!createToDoPage.checkToDoIsExists(isExists, ToDoName)) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * Check ToDo item list is exists
     *
     * @param isExists  : true : is exists | false : is not exists
     * @param ToDoNames : ToDo name list need check
     */
    public void checkToDoListIsExists(boolean isExists, List<String> ToDoNames) {
        if (!createToDoPage.checkToDoListIsExists(isExists, ToDoNames)) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * Check all ToDo item is delete
     */
    public void checkAllToDoIsDelete() {
        if (!createToDoPage.checkAllToDoIsDelete()) {
            AbstractService.sStatusCnt++;
        }
    }


    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- End

    public void clickCommentIconPerTaskName(String toDoTaskName) {
        createToDoPage.selectToDoCommentIconByName(toDoTaskName);
    }

    public void verifyDefaultHintValueInputComment() {
        createToDoPage.verifyDefaultHintValueInputComment();
    }

    public void verifyCancelCompleteMarkPopup() {
        createToDoPage.verifyCancelCompleteMarkPopup();
    }

    public void closeSuccessToastMes() {
        createToDoPage.closeSuccessToastMes();
    }

    public void verifyBoxTitleComment() {
        createToDoPage.verifyGUIBoxTitleComment();
    }

    public void verifyGUICommentList(String commentContent) {
        createToDoPage.verifyGUICommentList(commentContent);
    }

    public void verifyInputAComment(String commentContent) {
        createToDoPage.verifyInputAComment(commentContent);
    }

    public void clickPostComment() {
        createToDoPage.clickPostComment();
    }

    public int getNumberOfListComment() {
        return createToDoPage.getNumberOfListComment();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyAddNewRequestButton() {
        createToDoPage.verifyAddNewRequestButton();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyRequestNameTextbox() {
        createToDoPage.verifyRequestNameTextbox();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyCreateRequest() {
        createToDoPage.verifyNewRequestStoreInDatabase();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyUpdateRequest() {
        createToDoPage.verifyUpdateRequestStoreInDatabase();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyDeleteRequest() {
        createToDoPage.verifyDeleteRequestOnPopup();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyCopyRequest() {
        createToDoPage.verifyCopyTaskOnPopup();
    }

    public void verifyNewCommentIsDisplayed(int numberListCommentBeforeAdding, String commentContent) {
        createToDoPage.verifyNewCommentIsDisplayed(numberListCommentBeforeAdding, commentContent);
    }

    public void verifyClickOnInputCommentField() {
        createToDoPage.verifyClickOnInputCommentField();
    }

    public void verifyUserInputNoContentComment() {
        createToDoPage.verifyUserInputNoContentComent();
    }

    public void verifyInputMaxLenghtContentComment(int maxLength) {
        createToDoPage.verifyInputMaxLenghtContentComment(maxLength);
    }

    public void verifyInputSpecialCharactersContentComment() {
        createToDoPage.verifyInputSpecialCharactersContentComment();
    }


    /**
     * Create ToDo name list
     *
     * @author : TanPham
     * @date : 29/05/2017
     */

    public List<String> createToDoNameList(String todoName, int numberToDo) {
        return createToDoPage.createToDoNameList(todoName, numberToDo);
    }

    /**
     * Select check box follow To-Do name list
     *
     * @author : TanPham
     * @date : 29/05/2017
     */
    public void selectMultiToDoTaskByNameList(List<String> toDoNameList) {
        for (int i = 0; i < toDoNameList.size(); i++) {
            createToDoPage.selectToDoCheckboxByName(toDoNameList.get(i));
        }
    }

    public void verifyGUIPostButton() {
        createToDoPage.verifyGUIPostButton();
    }

    /*
    Vien add new method for PLAT 2326-2301 TO verify To-dos textbox
     */


    public void waitForNewTodoNameApplied(){
       createToDoPage.waitForNewTodoNameSaved();
    }
    public void createCategories(String cate1) throws Exception {
        createToDoPage.createNewCategory(cate1);
    }

    public void createMultiCategory(String cate1, String cate2, String cate3) throws Exception {
        createToDoPage.createNewCategory(cate1);
        createToDoPage.createNewCategory(cate2);
        createToDoPage.createNewCategory(cate3);
    }

    public void navigateToEditNewCategory() throws InterruptedException {
        createToDoPage.navigateToEditCategory();

    }

    public void verifyTodosTextBox_DefaultGUI() throws InterruptedException {
        createToDoPage.verifyTodoTextbox_DefaultName();
        createToDoPage.verifyFirstTodoTextbox_PlaceHolderValue();
        createToDoPage.verifySecondTodoTextbox_PlaceHolderValue();
        createToDoPage.verifyTodoTextboxBorder_Default();
        createToDoPage.verifyTodoTextboxBorder_WhileHovered();
    }

    public void InputValidValue(String validValue) {

        createToDoPage.InputValue_TodoName(validValue);
    }

    public void verifyInputValidValue(String validValue) {
        createToDoPage.verifyInputValidValue(validValue);
    }

    public void InputOnlyNumber(int number) {
        createToDoPage.InputValue_TodoName(Integer.toString(number));
    }

    public void verifyInputNumber(int number) {
        createToDoPage.verifyInputValidValue(Integer.toString(number));

    }

    public void InputSpecialChar(String specialChar) {

        createToDoPage.InputValue_TodoName(specialChar);
    }

    public void verifyInputSpecialChar(String specialChar) {

        createToDoPage.verifyInputInvalidValue(specialChar);
    }

    public void InputNullChar(String nullChar) {
        createToDoPage.InputValue_TodoName(nullChar);

    }

    public void verifyInputNullChar(String nullChar) {
        createToDoPage.verifyInputInvalidValue(nullChar);

    }

    public void verifyCategoryComboBox_DefaultGUI() {
        getLogger().info("Verifying Category ComboBox...");
        createToDoPage.verifyCategoryBox_DefaultValue();
        createToDoPage.verifyBorderCategoryBox_WhileHovered();
    }

    public void verifyNewCategorySaved(String cate1) {
        createToDoPage.verifyCreateNewCategory(cate1);
    }

    public void selectCategory() {
        createToDoPage.selectCategory();
    }

    public void verifyNewCategoryChosenCorrectly(String cate1) {
        createToDoPage.verifyCategoryIsSelectedCorrectly(cate1);
    }

    public void verifyClientAssigneeComboBox() {
        getLogger().info("Verifying Client Assignee ComboBox...");
        createToDoPage.verifyClientAssignee_DefaultValue();
        createToDoPage.verifyBorderClientAssignee_WhileHovered();
    }

    public void verifyClientAssigneeIsSelectedCorrectly(){
        createToDoPage.verifyClientAssigneeIsSelectedCorrectly();
    }


    public void verifyDuedateTimebox() {
//        getLogger().info("Verifying default value..");
        //Will added after fixed
        getLogger().info("Verifying DueDate Timebox...");
        createToDoPage.verifyBorderDuedate_WhileHovered();
    }

    public void verifyUnableToInputDuedate(String dateInput){
        createToDoPage.verifyUnableToInputDuedate(dateInput);
    }

    public void verifyAuditAssigneeBox() {
        getLogger().info("Verifying AuditAssignee box..");
        createToDoPage.verifyAditAssignee_DefaultValue();
        createToDoPage.verifyBorderAuditAssignee_WhileHoverd();
    }
    public void verifyAuditAssigneeIsSelectedCorrectly(){
        createToDoPage.verifyAuditAssigneeIsSelectedCorrectly();
    }

    public void verifyCreateTodoBtn() {
        createToDoPage.verifyCreateTodoBtn_DefaultValue();
//        createToDoPage.verifyCreateTodoBtn_Click();
    }

    public void verifyFilterBtn() {
        createToDoPage.verifyFilterBtn_Position();
    }

    public void verifyBulkActionBtn() {
        createToDoPage.verifyBulkActionBtn_Position();
    }

    public void verifySearchBox_DefaultGUI() {
        getLogger().info("Verifying default value: Search...");
        createToDoPage.verifySearchDefault();
        getLogger().info("Verifying Search border is Green when hovered...");
        createToDoPage.verifySearchHover();
    }

    public void verifyNameReturnDefault(){
        createToDoPage.verifyNameReturnDefault();

    }

    public void verifyExistedCategory(){
        createToDoPage.verifyExistedCategory();
    }

}

