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
	AuditorDetailsEngagementPage  detailsEngagementPage ;

	/*
	 * contructor
	 */
	public AuditorCreateToDoService(Logger logger, WebDriver driver) {

		super(logger, driver);
		createToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
		todoListPage=new AuditorTodoListPage(getLogger(), getDriver());
		engagementPage= new AuditorEngagementPage(getLogger(), getDriver());
		detailsEngagementPage =new AuditorDetailsEngagementPage(getLogger(), getDriver());
	}


	public void verifyGUIAddNewToDoNameTextBox(){
		    getLogger().info("Verify GUI Add New To Do Text Box");
			createToDoPage.verifyDefaultValueToDoNameTextBox();
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

    public void navigatetoCreateToDoTab () {
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

    public void verifySearchPlaceholder(){
        getLogger().info("Todo page verify default value(Search...)");
        createToDoPage.verifySearchDefault();
    }

    public void verifyInputDataToDoNameTextBox(String toDoNameValue){
		getLogger().info("Input data into ToDo name Textbox.");
        createToDoPage.verifyInputValueToDoNameTextBox(toDoNameValue);
	}

    public void verifySearchHover(){
        getLogger().info("Todo page search hover");
        createToDoPage.verifySearchHover();
	}
	
	public void verifySearchInputText(){
        getLogger().info("Todo page search to input text");
        createToDoPage.verifySearchInputText();
	}
	
	public void verifySearchInputNumber(){
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
	
	public void navigateToDoListPage() throws Exception{
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

    public void verifyToDoNameInputSpecialCharacter(String value){
        getLogger().info("Input special characters into ToDo name Text box.");
        try {
            createToDoPage.verifyToDoNameInputSpecialCharacter(value);
            NXGReports.addStep("Input special characters: " + value + " on ToDo Name Textbox successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Input special characters: " + value + " on ToDo Name Textbox unsuccessfully.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGUIToDoSaveIconDisabled(){
        getLogger().info("Verify GUI of the To Do Save Icon is disabled");
        createToDoPage.verifyDisableToDoSaveIcon();
    }

    public void verifyGUIToDoSaveIconEnabled(){
        getLogger().info("Verify GUI of the To Do Save Icon is enabled");
        createToDoPage.verifyEnableToDoSaveIcon();
    }

    public void verifyToDoCloseIcon(){
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

    public void verifySortDataGridIcon(){
            createToDoPage.verifySortToDoTaskOnName();
    }

    public void verifyCheckBoxToDoName() throws Exception {
            // bug for check all button so we skip
            //createToDoPage.verifyCheckAllCheckboxToDoName();
            createToDoPage.verifyUnCheckAllCheckboxToDoName();
            createToDoPage.verifyCheckMultipleCheckBoxToDoName();
    }

    public void verifyDefaultValueofCategoryComboBox(String defaultValueComboBox){
        createToDoPage.verifyDefaultValueofCategoryComboBox(defaultValueComboBox);
    }

    public void verifyHoverCategoryComboBox() {
        createToDoPage.verifyHoverCategoryComboBox();
    }

    public void verifyCreateNewCategory(){
        getLogger().info("Verify create new Category");
        createToDoPage.verifyCreateNewCategory();
    }

    public void verifyAddNewCategoryPopupTitle(){
        getLogger().info("Verify title of add new category popup");
        createToDoPage.verifyAddNewCategoryPopupTitle();
    }
    public void verifyNewCategoryNameTextbox(){
        getLogger().info("Verify new category name textbox");
        createToDoPage.verifyNewCategoryNameTextbox();
    }

    public void verifyNewCategoryColorCombobox(){
        getLogger().info("Verify new category color combobox");
        createToDoPage.verifyNewCategoryColorCombobox();
    }

    public void verifyNewCategoryCreateCancelButton(){
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

    public void clickCreateToDoTask()throws  Exception{
        createToDoPage.clickCreateToDoTask();
    }

    public void verifyValueofCategoryComboBox(String categoryName) throws Exception{
        createToDoPage.verifyListValueofCategoryComboxBox(categoryName);
    }

    public void verifyNewCategoryPopUpDisplayed() throws Exception{
        createToDoPage.clickAddNewCategory();
        createToDoPage.verifyNewCategoryPopUpDisplayed();
    }

    public void verifyEditCategoryPopUpDisplayed() throws Exception{
        createToDoPage.clickEditCategory();
        createToDoPage.verifyEditCategoriesPopUpDisplayed();
    }

    public void verifyCreateToDoTaskWithoutCategory(String todoName) throws Exception {
        createToDoPage.verifyCreateToDoTaskWithoutCategory(todoName);
    }

    public void verifyInputMaxLengthToDoNameTextBox(){
        createToDoPage.verifyInputMaxLengthToDoNameTextBox();
    }

    public void verifyInputInValidValueToDoNameTextBox(){
        createToDoPage.inputInvalidValueToDoNameTextBox();
        createToDoPage.selectDueDateToDoTask();
        createToDoPage.verifyWarningCssValueToDoNameTextBox();
    }

    public void setDueDateField(){
        createToDoPage.selectDueDateToDoTask();
    }

    public void createListToDoTask(List<String> toDoTaskNames) throws Exception {
        for (int i = 0; i < toDoTaskNames.size(); i++) {
            createToDoPage.createToDoTask(toDoTaskNames.get(i));
        }
    }

    public void clickCheckboxNewToDoTask(){
        createToDoPage.clickCheckboxNewToDoTask();
    }
}

