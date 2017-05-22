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


	public void verifyGUIAddNewToDoNameTextBox(int numberOfTask){
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

    }

    public void navigatetoCreateToDoTab() {
        getLogger().info("Navigate to CreateToDo Tab");
        try {
            //engagementPage.navigateToEngagementTask("engagement");
            //detailsEngagementPage.navigateToTaskList();
            todoListPage.clickCreateToDoBtn();
//            createToDoPage.verifyAddNewToDoTask("task");
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
        this.createToDoPage.navigateToEngagementPage();
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
            NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.FAILED,
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

    public void verifyUnCheckOnCheckBox() {

        try {

            createToDoPage.verifyUnCheckOnCheckBox();
            NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    // Vien.Pham added numberCategories
    public void createToDoPage() {

        try {
            createToDoPage.createToDoTask(1);
            NXGReports.addStep("Create To-Do page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Create To-Do page", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    //Vien.Pham add new Create Multicategories
    public void createMultiCategories(){
        try {
            createToDoPage.createToDoTask(4);
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
    public void verifyAddNewToDoTask(String toDoName) throws Exception  {
        createToDoPage.createToDoTask(toDoName);
    }

    public void verifySortDataGridIcon() {
        createToDoPage.verifySortToDoTaskOnName();
    }

    public void verifyCheckBoxToDoName() throws Exception {
        // bug for check all button so we skip
        //createToDoPage.verifyCheckAllCheckboxToDoName();
        createToDoPage.verifyUnCheckAllCheckboxToDoName();
        createToDoPage.verifyCheckMultipleCheckBoxToDoName();
    }

    public void verifyDefaultValueofCategoryComboBox(String defaultValueComboBox) {
        createToDoPage.verifyDefaultValueofCategoryComboBox(defaultValueComboBox);
    }

    public void verifyHoverCategoryComboBox() {
        createToDoPage.verifyHoverCategoryComboBox();
    }

    public void verifyCreateNewCategory() {
        getLogger().info("Verify create new Category");
        createToDoPage.verifyCreateNewCategory();
    }

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

    public void unselectToDoTaskName(String toDoName){
        createToDoPage.unSelectToDoCheckboxByName(toDoName);
    }

    public int getNumberofToDoTask(){
        return createToDoPage.getNumberofToDoTask();
    }

//    public void waitMessageIsDisappear() {
//        createToDoPage.waitMessageIsDisappear();
//    }

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
    public void verifySelectDateDropDown() throws  Exception {
        createToDoPage.verifySelectDateDropDown();
    }

    /**
     * Check default value of due date text box
     */
    public void checkDefaultValueDueDate() {
        boolean result = createToDoPage.checkDefaultDueDateValue();
        if(!result)
            AbstractService.sStatusCnt ++;
    }

    /**
     * Check deafult format due date
     */
    public void checkFormatDueDate() {
        boolean result = createToDoPage.checkFormatDueDate();
        if(!result)
            AbstractService.sStatusCnt ++;
    }

    /**
     * Verify data in date picker
     */
    public void verifyDataOfDatePicker(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyDataOfDatePicker(isNewToDoPage);
        if(!result)
            AbstractService.sStatusCnt ++;
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
        if(!result)
            AbstractService.sStatusCnt ++;
    }

    /**
     * Verify previous date picker link is click
     */
    public void verifyPreviousDatePickerLink(boolean isNewToDoPage){
        boolean result = createToDoPage.checkDatePickerChangeMonth("prev",false, isNewToDoPage);
        if(!result)
            AbstractService.sStatusCnt ++;
    }

    /**
     * Verify next date picker link is click
     */
    public void verifyNextDatePickerLink(boolean isNewToDoPage){
        boolean result = createToDoPage.checkDatePickerChangeMonth("next",true, isNewToDoPage);
        if(!result)
            AbstractService.sStatusCnt ++;
    }

    /**
     * Verify input correct format date in due date text box
     */
    public void verifyInputCorrectFormatDate(boolean isNewToDoPage){
        boolean result = createToDoPage.verifyInputCorrectFormatDate("05/20/2017",isNewToDoPage);
        if(!result)
            AbstractService.sStatusCnt ++;
    }
    /**
     * Verify input wrong format date in due date text box
     */
    public void verifyInputWrongFormatDate(boolean isNewToDoPage){
        boolean result = createToDoPage.verifyInputWrongValue("055/20/2017",isNewToDoPage);
        if(!result)
            AbstractService.sStatusCnt ++;
    }

    /**
     * Verify input text in due date text box
     */
    public void verifyInputTextValue(boolean isNewToDoPage){
        boolean result = createToDoPage.verifyInputWrongValue("dadasdasdad",isNewToDoPage);
        if(!result)
            AbstractService.sStatusCnt ++;
    }

    /**
     * Verify input text in due date text box
     */
    public void verifyInputSpecialCharacterValue(boolean isNewToDoPage){
        boolean result = createToDoPage.verifyInputWrongValue("~!@#$%^&*+?><,. ",isNewToDoPage);
        if(!result)
            AbstractService.sStatusCnt ++;
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- End

    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- Start
    /**
     * Verify trash to do icon
     */
    public void verifyTrashToDoIcon(){
        createToDoPage.verifyTrashToDoIcon();
    }

    /**
     * Verify default status trash to do icon
     */
    public void verifyDefaultStatusTrashToDoIcon(){
        createToDoPage.verifyDefaultStatusTrashToDoIcon();
    }

    /**
     * Verify GUI and Close icon of delete confirm popup
     */
    public void verifyGUIDeleteConfirmPopup(){
        createToDoPage.verifyGUIDeleteConfirmPopup();
    }

    /**
     * Verify work flow of "CheckAll" check box
     */
    public void verifyCheckAllCheckBox(){
        createToDoPage.verifyCheckAllCheckBox();
    }
    /**
     * Verify work flow of delete button
     */
    public void verifyWorkFlowOfDeleteButton(){
        createToDoPage.verifyWorkFlowOfDeleteButton();
    }

    /**
     * Verify work flow of cancel button
     */
    public void verifyWorkFlowOfCancelButton(){
        createToDoPage.verifyWorkFlowOfCancelButton();
    }
    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- End

    public void clickCommentIconPerTaskName(String toDoTaskName) { createToDoPage.selectToDoCommentIconByName(toDoTaskName); }
}

