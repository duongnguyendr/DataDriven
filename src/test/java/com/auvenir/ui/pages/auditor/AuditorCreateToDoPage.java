package com.auvenir.ui.pages.auditor;

//import library

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.extentionLibraries.DatePicker;
import com.auvenir.utilities.extentionLibraries.MongoDB;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.mongodb.DBCollection;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.List;

public class AuditorCreateToDoPage extends AbstractPage {

    public AuditorCreateToDoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(xpath = "//div[@class='e-widget-content']//div[@class='e-widget-options']"))
    private List<WebElement> planningEngagementPage;

    private String todoNamePage = "";
    private String todoContentTextSearch = "name";
    public static final int smallTimeOut = 2000;

    @FindBy(id = "auv-todo-createToDo")
    private WebElement createToDoBtnEle;

    @FindBy(id = "auv-todo-filter")
    private WebElement eleFilterBtn;

    @FindBy(id = "todo-search")
    private WebElement eleToDoSearchInput;

    @FindBy(xpath = "//*[@id='todo-table']/thead//th/input[@type='checkbox']")
    private WebElement eleCheckBox;

    @FindBy(xpath = "//th[@data-id='name']")
    private WebElement eleNameToDoTitleLabel;

    @FindBy(xpath = "//th[@data-id='name']//i")
    private WebElement sortByToDoNameIconEle;

    @FindBy(xpath = "//th[@data-id='category']")
    private WebElement eleCategoryTitleLabel;

    @FindBy(xpath = "//th[@data-id='category']//i")
    private WebElement eleSortByCategory;

    @FindBy(xpath = "//th[@data-id='client']")
    private WebElement eleClientAssigneeTitleLabel;

    @FindBy(xpath = "//th[@data-id='client']//i")
    private WebElement eleSortByClientAssignee;

    @FindBy(xpath = "//th[@data-id='dueDate']")
    private WebElement eleDueDateTitleLabel;

    @FindBy(xpath = "//th[@data-id='dueDate']//i")
    private WebElement eleSortByDueDate;

    @FindBy(xpath = "//th[@data-id='audit']")
    private WebElement eleAuditAssigneeTitleLabel;
    @FindBy(xpath = "//th[@data-id='audit']")
    private WebElement eleSortByAuditAssignee;

    @FindBy(xpath = "//div[@class='e-widget-content']")
    private List<WebElement> eleWidgetContent;

    @FindBy(xpath = "//div[@class='e-widget-content']//div[@class='e-widget-options']//input[@type='button']")
    private List<WebElement> eleViewEngagementPage;

    @FindBy(id = "engagementTodoLink")
    private WebElement eleToDoLnk;

    @FindBy(xpath = "//tr[@id='empty-todo']//..//..//img")
    private WebElement eleImgEmtyToDo;

    @FindBy(xpath = "//tr[@id='empty-todo']//..//..//div")
    private WebElement eleNotesEmtyToDo;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']")
    private WebElement categoryDropdownEle;
    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']//button")
    private List<WebElement> categoryOptionItemEle;
    @FindBy(id = "due-date")
    private WebElement dueDateFieldEle;
    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")
    private WebElement dateItemonCalendarEle;

    public void verifyImgEmtyToDo() throws Exception {
        validateDisPlayedElement(eleImgEmtyToDo, "EmptyTodoImage");
    }

    //@FindBy(xpath="//div[@id='divName']/div/input[@id='todo-name']")
    @FindBy(id = "todo-name")
    private WebElement toDoNameInputEle;

    @FindBy(xpath = "//div[@class='inputMargin div-name-container']//p[@class='auv-inputError']")
    private WebElement toDoNameErrorLabelEle;

    @FindBy(xpath = "//*[@id='todo-add-btn']")
    private WebElement toDoSaveIconEle;

    @FindBy(xpath = "//*[@id='todo-cancel-btn']")
    private WebElement eleToDoCloseIcon;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']")
    private List<WebElement> toDoTaskRowEle;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@type='checkbox']")
    private List<WebElement> eleToDoCheckboxRow;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@type='text']")
    private List<WebElement> eleToDoNameRow;

    @FindBy(id = "todo-table")
    private WebElement tblIdTodoTable;
    @FindBy(id = "todo-name")
    private WebElement createToDoNameTextBoxEle;
    @FindBy(id = "todo-add-btn")
    private WebElement eleBtnToDoAdd;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@class='newTodoInput']")
    private List<WebElement> toDoNameTextColumnEle;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']/div[@class='text']")
    private List<WebElement> categoryComboBoxTextEle;

    //Category ComboBox
    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']")
    private List<WebElement> categoryComboBoxEle;

    //Category dropdown menu
    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']/div[@class = 'menu']")
    private List<WebElement> categoryComboBoxMenuEle;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']/div[1]")
    private WebElement addNewCategoryMenuItemEle;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']/div[2]")
    WebElement editCategoryEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//h3 [@class='setup-header']")
    WebElement categoryTitleEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//img[@class='au-modal-closeBtn']")
    WebElement closePopupBtnEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//button[@id = 'm-ce-cancelBtn']")
    WebElement editCategoryCancelBtnEle;

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- Start
    @FindBy(xpath = "//div[@class='auvicon-calendar']")
    private WebElement eleDueDateValue;

    @FindBy(xpath = "//a[@class='ui-datepicker-prev ui-corner-all']")
    private WebElement elePrevDataPickerLink;

    @FindBy(xpath = "//a[@class='ui-datepicker-next ui-corner-all']")
    private WebElement eleNextDataPickerLink;

    @FindBy(xpath = "//div[@class='ui-datepicker-title']")
    private WebElement eleDataPickerTitle;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@class='auv-input input-due-date datepicker hasDatepicker']")
    private List<WebElement> eleToDoNewRowDueDateText;

    @FindBy(id = "due-date")
    private WebElement eleIdDueDate;
    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")
    private WebElement eleXpathChooseDate;

    @FindBy(xpath = "//*/span[@class='ui-datepicker-month']")
    private WebElement eleDataPickerTitleTest;
    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']")
    private WebElement eleDataPickerToDate;
    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']//a[@class='ui-state-default ui-state-highlight']")
    private WebElement eleDataPickerToDay;

    @FindBy(id = "bulk-container")
    private WebElement btnBulkActions;

    @FindBy(xpath = "//button[contains(text(),'Download Attachments')]")
    WebElement optionDownloadAttachments;

    @FindBy(xpath = "//button[contains(text(),'Mark as complete')]")
    WebElement optionMarkAsComplete;

    @FindBy(xpath = "//button[contains(text(),'Delete')][@class='item']")
    WebElement optionDelete;

    @FindBy(xpath = "//div[contains(text(),'Assign to')]")
    WebElement optionAssignTo;

    //TODO hard until redo new list
    @FindBy(xpath = "//button[contains(text(),'client 01 so (client)')]")
    WebElement optionAssignee;

    @FindBy(xpath = "//button[contains(text(),'Archive')]")
    private WebElement btnArchive;

    @FindBy(xpath = "//div[@class='ce-footerBtnHolder']/button[contains(text(),'Delete')]")
    private WebElement btnDelete;

    @FindBy(id = "btn-todo-undo")
    private WebElement btnToDoUndo;

    @FindBy(xpath = "//div[@class='ui dropdown']")
    WebElement bulkActionsDropdownEle;

    @FindBy(xpath = "//div[@id='todo-bulk-dropdown']/div[@class='menu']")
    WebElement bulkActionsDropdownMenuEle;

    @FindBy(xpath = "//div[@class='ui dropdown']/div[@class='menu']/button[contains(text(),'Download Attachments')]")
    WebElement downloadAttachBulkActionsMenuEle;

    @FindBy(xpath = "//div[@class='ui dropdown']/div[@class='menu']/button[contains(text(),'Mark as complete')]")
    WebElement markAsCompleteBulkActionsMenuEle;

    @FindBy(xpath = "//div[@class='ui dropdown']/div[@class='menu']/div[contains(text(),'Assign to')]")
    WebElement assignToBulkActionsMenuEle;

    @FindBy(xpath = "//div[@class='ui dropdown']/div[@class='menu']/button[contains(text(),'Delete')]")
    WebElement deletedBulkActionsMenuEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//button[contains(text(),'Cancel')]")
    WebElement cancelDeletedToDoButtonEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//div[@class='center']/div[@class='des-delete-modal']")
    WebElement centerDeleteToDoDescriptionEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]")
    WebElement popUpWindows;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//button[contains(text(),'Delete')]")
    WebElement deletedToDoButtonEle;

    @FindBy(xpath = "//div[contains(@id,'flashAlert')]//div[@class='send-message-success-alert']")
    private WebElement toastMessageSucessEle;

    @FindBy(xpath = "//*[@id='m-ce-systemContainer']//h3[contains(text(),'Mark As Complete?')]")
    private WebElement markAsCompleteTitle;

    @FindBy(xpath = "//img[@class='au-modal-closeBtn']")
    private WebElement markPopupCloseBtn;

    @FindBy(xpath = "//div[@class='ce-footerBtnHolder']//button[contains(text(),'Cancel')]")
    private WebElement cancelMarkPopupBtn;
    @FindBy(xpath = "//div[@class='ce-footerBtnHolder']//button[contains(text(),'Archive')]")
    private WebElement archiveMarkPopupBtn;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@type='text']")
    private List<WebElement> textToDoName;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow todoCompleted']")
    private WebElement textToDoNameArchiveComplete;

    @FindBy(xpath = "//tr[@class='newRow']/td[7]/img")
    private List<WebElement> commentIconToDoListEle;

    public WebElement getToDoSaveIconEle() {
        return toDoSaveIconEle;
    }

    public List<WebElement> getToDoNameTextColumnEle() {
        return toDoNameTextColumnEle;
    }

    public void verifyButtonCreateToDo() throws Exception {
        validateCssValueElement(createToDoBtnEle, "background-color", "rgba(89, 155, 161, 1)");
        validateCssValueElement(createToDoBtnEle, "color", "rgba(255, 255, 255, 1)");
        validateDisPlayedElement(createToDoBtnEle, "Create Todo Button");
    }

    public void verifyGUIButtonCreateToDo() {
        try {
            boolean result;
            result = validateCssValueElement(createToDoBtnEle, "background-color", "rgba(89, 155, 161, 1)");
            Assert.assertTrue(result, "Background-color of Create To Do Button is displayed unsuccessfully");
            result = validateCssValueElement(createToDoBtnEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text Color of Create To Do Button is displayed unsuccessfully");
            result = validateDisPlayedElement(createToDoBtnEle, "Create Todo Button");
            Assert.assertTrue(result, "Text Value of Create To Do Button is displayed unsuccessfully");
            NXGReports.addStep("Verify GUI of Create To Do Button", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("GUI of Create To Do Button is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify GUI of Create To Do Button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyButtonFilter() throws Exception {
        validateDisPlayedElement(eleFilterBtn, "Filer Button");
    }

    public void verifyColumnsInGrid() throws Exception {
        validateElementText(eleNameToDoTitleLabel, "To-Dos");
        validateElementText(eleCategoryTitleLabel, "Category");
        validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
        validateElementText(eleDueDateTitleLabel, "Due Date");
        validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
    }


    public void verifySotleOnTitle() throws Exception {
        validateDisPlayedElement(sortByToDoNameIconEle, "Sort By Name Button");
        validateDisPlayedElement(eleSortByClientAssignee, "Sort By Client Assignee Button.");
        validateDisPlayedElement(eleSortByDueDate, "Sort By");
        validateDisPlayedElement(eleSortByAuditAssignee, "Sort by Auditor Assignee button.");
    }


    public void verifyToDoListPage() throws Exception {
        validateAttributeElement(createToDoBtnEle, "background", "#2c8188");
        validateAttributeElement(createToDoBtnEle, "color", "#fff");
        validateDisPlayedElement(createToDoBtnEle, "Create Todo Button");
        validateDisPlayedElement(eleFilterBtn, "Filter Button");
        validateDisPlayedElement(eleToDoSearchInput, "Search button");
        validateAttributeElement(eleToDoSearchInput, "placeholder", "Search...");
        eleToDoSearchInput.click();
        validateAttributeElement(createToDoBtnEle, "border", "#599ba1");
        validateDisPlayedElement(eleCheckBox, "Check Box");
        validateElementText(eleNameToDoTitleLabel, "To-Dos");
        validateElementText(eleCategoryTitleLabel, "Category");
        validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
        validateElementText(eleDueDateTitleLabel, "Due Date");
        validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
        validateDisPlayedElement(sortByToDoNameIconEle, "Sort By Name");
        validateDisPlayedElement(eleSortByClientAssignee, "Sort By Assign button.");
        validateDisPlayedElement(eleSortByDueDate, "Sort By Due Date button.");
        validateDisPlayedElement(eleSortByAuditAssignee, "Sort by Auditor Assignee.");
        if (!eleCheckBox.isSelected()) {
            eleCheckBox.click();
        }
        validateAttributeElement(createToDoBtnEle, "background", "#5cd4c0");
        if (eleCheckBox.isSelected()) {
            eleCheckBox.click();
        }
        validateAttributeElement(createToDoBtnEle, "background", "#cacece");
    }


    public void clickCreateToDoTask() {
        waitForClickableOfElement(createToDoBtnEle, "Create Todo button");
        createToDoBtnEle.click();
    }

    public void verifyDefaultValueToDoNameTextBox(int numberOfTask) {
        try {
            boolean result;
            String defaultValueToDoNameText;
            if (numberOfTask > 0) {
                defaultValueToDoNameText = "Write your to do here";
            } else {
                defaultValueToDoNameText = "Write your first to do here";
            }
            getLogger().info("Verify Default Value To Do Text Box");
            waitForVisibleElement(toDoNameInputEle, "Todo name input field.");
            validateDisPlayedElement(toDoNameInputEle, "Todo name input field.");
            result = validateAttributeElement(toDoNameInputEle, "placeholder", defaultValueToDoNameText);
            Assert.assertTrue(result, "Default Value To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("Verify Default Value To Do Text Box", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Default Value To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Default Value To Do Text Box", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyHoverCssValueToDoNameTextBox() {
        try {
            boolean result;
            getLogger().info("Verify Hover CSS Value To Do Text Box");
            waitForVisibleElement(toDoNameInputEle, "Todo Name input field");
            clickAndHold(toDoNameInputEle, "Todo Name input field");
            result = validateCSSValueElement(toDoNameInputEle, "border", "1px solid rgb(89, 155, 161)");
            Assert.assertTrue(result, "Hover CSS Value of To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("Verify Hover CSS Value of To Do Text Box", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Hover CSS Value of To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Hover CSS Value To Do Text Box", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyWarningCssValueToDoNameTextBox() {
        try {
            boolean result;
            getLogger().info("Verify CSS Value Warning To Do Name Text Box");
            waitForVisibleElement(toDoNameInputEle, "Todo name input field");
            waitForVisibleElement(dueDateFieldEle, "Due Date input field");
            clickAndHold(toDoNameInputEle, "Todo Name input field");
            dueDateFieldEle.click();
            result = validateCSSValueElement(toDoNameInputEle, "border", "1px solid rgba(253, 109, 71, 0.4)");
            Assert.assertTrue(result, "Warning CSS Value of To Do TextBox is displayed unsuccessfully");
            waitForVisibleElement(toDoNameErrorLabelEle, "Todo Name error  Label");
            result = validateElementText(toDoNameErrorLabelEle, "Not a valid name.");
            Assert.assertTrue(result, "Warning Value of To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("Verify Warning CSS Value of To Do Text Box", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Warning CSS Value of To Do Name TextBox is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Warning CSS Value To Do Name Text Box", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyAddNewToDoTask(String toDoName) {
        try {
            boolean result;
            validateDisPlayedElement(toDoNameTextColumnEle.get(0), "Todo New Row Name");
            result = validateAttributeElement(toDoNameTextColumnEle.get(0), "value", toDoName);
            Assert.assertTrue(result, String.format("New To Do task '%s' is NOT added successfully", toDoName));
            NXGReports.addStep("New To Do task is added successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("New To Do task is added unsuccessfully", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public boolean verifyInputValueToDoNameTextBox(String toDoNameValue) {
        try {
            boolean result;
            getLogger().info("Verify Input Value ToDo Name TextBox");
            waitForVisibleElement(toDoNameInputEle, "Todo Name input field");
            sendKeyTextBox(toDoNameInputEle, toDoNameValue, "To Do Name Input");
            result = validateAttributeElement(toDoNameInputEle, "value", toDoNameValue);
            Assert.assertTrue(result, "Input Value into ToDo Name TextBox is unsuccessfully");
            NXGReports.addStep("Verify Input Value ToDo Name TextBox", LogAs.PASSED, null);
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Input Value into ToDo Name TextBox is unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Input Value ToDo Name TextBox", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public void verifyCheckMaxLength() {
        try {
            boolean isCheckMaxLength = false;
            waitForClickableOfElement(eleToDoSearchInput, "wait for txtIdTodoSearch");
            clickElement(eleToDoSearchInput, "click to txtIdTodoSearch");
            clearTextBox(eleToDoSearchInput, "clear txtIdTodoSearch");
            Thread.sleep(smallerTimeOut);
            eleToDoSearchInput.sendKeys(maxLenghtString);
            Thread.sleep(smallerTimeOut);
            eleToDoSearchInput.sendKeys(numberSequence);
            // Get the text from eleToDoSearchInput
            Thread.sleep(smallerTimeOut);
            String txtSearchText = getTextByJavaScripts(eleToDoSearchInput);
            getLogger().info("The input txtSearchText = " + txtSearchText);
            if (txtSearchText.equals(maxLenghtString)) {
                isCheckMaxLength = true;
            } else {
                isCheckMaxLength = false;
            }
            getLogger().info("The result after comparing text search isSearchText = " + isCheckMaxLength);

            if (isCheckMaxLength) {
                NXGReports.addStep("Verify check max length of search textbox", LogAs.PASSED, null);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyCreateNewCategory() {
        try {
            getLogger().info("Verify create new category");
            boolean isCheckCategory = createNewCategory(categoryIndiMode, "");
            if (isCheckCategory) {
                NXGReports.addStep("Create new category", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Create new category", LogAs.FAILED, null);
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Create new category", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyAddNewCategoryPopupTitle() {
        verifyCategoryTitle();
    }

    public void verifyNewCategoryNameTextbox() {
        verifyCategoryDefaultValue();
        verifyHoverClickCategoryName();
        verifyShowAllTextCategoryName();
        verifyCategoryNameRequiredData();
        verifyCategoryNameMaxLength();
        verifyCategoryNameInputNumber();
        verifyCategoryNameSpecialCharacter();
    }

    public void verifyNewCategoryColorCombobox() {
        verifyCategoryColorAllQuantityColor();
        verifyChoosedCategoryColor();
    }

    public void verifyNewCategoryCreateCancelButton() {
        verifyColorCategoryCancelButton();
        verifyColorCategoryCreateButton();
        //verifyClickCategoryCancelButton();
        verifyNotCompleteCreateCategory();
        verifyExistedCategory();
    }

    public void createToDoTask(String toDoName) throws Exception {
        waitForClickableOfElement(createToDoBtnEle, "Create To Do Button");
        createToDoBtnEle.click();
        //Thread.sleep(smallTimeOut);
        waitForJSandJQueryToLoad();
        createToDoNameTextBoxEle.sendKeys(toDoName);
        // Create new category
        createNewCategory("", "");
        //Thread.sleep(smallTimeOut);
        //waitForPopupToClose();
        waitForClickableOfElement(categoryDropdownEle, "Category Dropdown");
        categoryDropdownEle.click();
        waitForClickableOfElement(categoryOptionItemEle.get(0), "Category Option Item");
        categoryOptionItemEle.get(0).click();
        waitForClickableOfElement(dueDateFieldEle, "Due Date field");
        dueDateFieldEle.click();
        waitForClickableOfElement(dateItemonCalendarEle, "Date value");
        dateItemonCalendarEle.click();
        waitForVisibleElement(toDoSaveIconEle, "Save Icon");
        toDoSaveIconEle.click();
//			waitForVisibleElement(toastMessageSucessEle,"Toast Message Successful");
//			waitForCssValueChanged(toastMessageSucessEle,"Toast Message Successful","class")
        verifyAddNewToDoTask(toDoName);
    }

    public void createToDoTask() throws Exception {
        getLogger().info("Run createToDoTask()");
        todoNamePage = "To-do name " + randomNumber();
        waitForClickableOfElement(createToDoBtnEle, "create todo button.");
        clickElement(createToDoBtnEle, "click to createToDoBtnEle");
        waitForClickableOfElement(createToDoNameTextBoxEle, "wait for eleIdToDoName");
        clickElement(createToDoNameTextBoxEle, "click to eleIdToDoName");
        createToDoNameTextBoxEle.sendKeys(todoNamePage);
        createNewCategory("", "");
        hoverElement(categoryDropdownEle, "eleDdlCategory");
        waitForClickableOfElement(categoryDropdownEle, "eleDdlCategory");
        Thread.sleep(smallTimeOut);
        clickElement(categoryDropdownEle, "click to eleDdlCategory");
        waitForClickableOfElement(categoryOptionItemEle.get(0), "eleXpathCategoryItem");
        clickElement(categoryOptionItemEle.get(0), "click to eleXpathCategoryItem");
        waitForClickableOfElement(dueDateFieldEle, "eleIdDueDate");
        Thread.sleep(smallerTimeOut);
        clickElement(dueDateFieldEle, "click to eleIdDueDate");
        waitForClickableOfElement(dateItemonCalendarEle, "eleXpathChooseDate");
        clickElement(dateItemonCalendarEle, "click to eleXpathChooseDate");
        waitForClickableOfElement(eleBtnToDoAdd, "eleBtnToDoAdd");
        clickElement(eleBtnToDoAdd, "click to eleBtnToDoAdd");
        //Wait for new task is displayed.
        Thread.sleep(smallTimeOut);
    }

    public void verifyToDoNameInputLimitCharacter(int maxLength) throws Exception {
        waitForVisibleElement(toDoNameInputEle, "eleToDoNameInput");
        validateMaxlenght(toDoNameInputEle, "ToDo Name Input", maxLength);
    }

    public void verifyToDoNameInputSpecialCharacter(String value) throws Exception {
        waitForVisibleElement(toDoNameInputEle, "eleToDoNameInput");
        toDoNameInputEle.clear();
        toDoNameInputEle.sendKeys(value);
        dueDateFieldEle.click();
        waitForVisibleElement(toDoNameErrorLabelEle, "toDoNameErrorLabelEle");
        validateElementText(toDoNameErrorLabelEle, "Not a valid name.");
    }

    public void verifyDisableToDoSaveIcon() {
        try {
            boolean result;
            waitForVisibleElement(toDoNameInputEle, "To Do Name Input");
            toDoNameInputEle.clear();
            waitForVisibleElement(toDoSaveIconEle, "To Do Save Icon");
            result = validateAttributeElement(toDoSaveIconEle, "class", "fa fa-floppy-o disabled");
            Assert.assertTrue(result, "To Do Save Icon is not disabled");
            getLogger().info("To Do Save Icon is disabled");
            NXGReports.addStep("Verify Disable ToDo Save Icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("To Do Save Icon is not disabled");
            NXGReports.addStep("TestScript Failed: Verify Disable ToDo Save Icon", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyEnableToDoSaveIcon() {
        try {
            boolean result;
            waitForVisibleElement(toDoNameInputEle, "To Do Name Input");
            toDoNameInputEle.sendKeys("Task01");
            waitForVisibleElement(toDoSaveIconEle, "To Do Save Icon");
            result = validateAttributeElement(toDoSaveIconEle, "class", "fa fa-floppy-o");
            Assert.assertTrue(result, "To Do Save Icon is not enabled");
            getLogger().info("To Do Save Icon is enabled");
            NXGReports.addStep("Verify Enabled ToDo Save Icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("To Do Save Icon is not enabled");
            NXGReports.addStep("TestScript Failed: Verify Enabled ToDo Save Icon", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyToDoCloseIcon() {
        int count = -1;
        if (toDoTaskRowEle.isEmpty())
            count = 0;
        else count = toDoTaskRowEle.size();
        clickCreateToDoTask();
        waitForVisibleElement(eleToDoCloseIcon, "To Do Close Icon");
        eleToDoCloseIcon.click();
        getLogger().info("Verify new To Do Task is not created.");
        try {
            if (count == toDoTaskRowEle.size()) {
                NXGReports.addStep("New To Do Task is not created", LogAs.PASSED, null);
                NXGReports.addStep("Close Icon is working", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("New To Do Task is created", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                NXGReports.addStep("Close Icon is not working", LogAs.PASSED, null);
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("New To Do Task is created", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            NXGReports.addStep("Close Icon is not working", LogAs.PASSED, null);
        }
    }

    public void verifySearchDefault() {
        try {
            boolean isCheckSearchDefault = validateAttributeElement(this.eleToDoSearchInput, "placeholder", searchTextDefault);
            if (isCheckSearchDefault) {
                NXGReports.addStep("verify default value(Search...) of this Search", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify default value(Search...) of this Search", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchHover() {
        try {
            waitForClickableOfElement(eleToDoSearchInput, "wait for eleToDoSearchInput");
            clickElement(eleToDoSearchInput, "click to eleToDoSearchInput");
            boolean isCheckSearchHover = validateCssValueElement(this.eleToDoSearchInput, borderColor, "rgb(89, 155, 161)");
            if (isCheckSearchHover) {
                NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchInputText() {
        try {
            clickElement(eleToDoSearchInput, "click to eleToDoSearchInput");
            sendKeyTextBox(eleToDoSearchInput, searchTextToDoListPage, "send key to searchTextToDoListPage");
            System.out.println(this.eleToDoSearchInput.getText());
            boolean isCheckSearchInput = validateAttributeElement(this.eleToDoSearchInput, "value", searchTextToDoListPage);
            if (isCheckSearchInput) {
                NXGReports.addStep("verify input text.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify input text.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify input text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchLimit255() throws Exception {
        waitForClickableOfElement(eleToDoSearchInput, "wait for click eleToDoSearchInput");
        clickElement(eleToDoSearchInput, "click to eleToDoSearchInput");
        sendKeyTextBox(eleToDoSearchInput, maxLenghtString, "send key to maxLenghtString");
        validateMaxlenght(this.eleToDoSearchInput, "To Do Search Input", maxLenght);
    }

    public void verifySearchInputNumber() {
        try {
            waitForClickableOfElement(eleToDoSearchInput, "wait for eleToDoSearchInput");
            clickElement(eleToDoSearchInput, "click to eleToDoSearchInput");
            sendKeyTextBox(eleToDoSearchInput, numberSequence, "send key to numberSequence");
            boolean isCheckSearchNumber = validateAttributeElement(this.eleToDoSearchInput, "value", numberSequence);
            if (isCheckSearchNumber) {
                NXGReports.addStep("verify input number to field search.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify input number to field search.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify input number to field search.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCheckOnCheckBox() throws Exception {
        if (!this.eleCheckBox.isSelected()) {
            this.eleCheckBox.click();
        }
        this.validateCssValueElement(this.eleCheckBox, backgroundColor, "rgba(92, 212, 192, 1)");
    }

    public void verifyUnCheckOnCheckBox() throws Exception {
        if (this.eleCheckBox.isSelected()) {
            this.eleCheckBox.click();

        }
        this.validateCssValueElement(this.eleCheckBox, backgroundColor, "rgba(202, 206, 206, 1)");
    }

    public void navigateToEngagementPage() throws Exception {
        getLogger().info("Click view button open Engagement Page");
        waitForClickableOfElement(eleWidgetContent.get(0), "eleWidgetContent");
        clickAndHold(eleWidgetContent.get(0), "eleWidgetContent");
    }

    public void navigateToToDoList() throws Exception {
        waitForClickableOfElement(eleToDoLnk, "");
        eleToDoLnk.click();
    }

    public void checkSearchData() {
        getLogger().info("Run checkSearchData()");
        try {
            boolean isCheckData = false;
            waitForVisibleElement(eleToDoSearchInput, "txtIdTodoSearch");
            Thread.sleep(smallTimeOut);
            clearTextBox(eleToDoSearchInput, "clear txtIdTodoSearch");
            Thread.sleep(smallTimeOut);
            sendKeyTextBox(eleToDoSearchInput, todoNamePage, "sendkey to txtIdTodoSearch");
            waitForVisibleElement(tblIdTodoTable.findElement(By.xpath("id('todo-table')/tbody/tr")), "");
            // Check the result in the list data
            List<WebElement> tr_collection = tblIdTodoTable.findElements(By.xpath("id('todo-table')/tbody/tr"));
            for (WebElement trElement : tr_collection) {
                List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
                for (WebElement tdElement : td_collection) {
                    String strSearchValue = "";
                    try {
                        strSearchValue = tdElement.findElement(By.tagName("input")).getAttribute("value");
                    } catch (Exception ex) {
                    }
                    getLogger().info("SearchValue = " + strSearchValue);
                    if (strSearchValue.equals(todoNamePage)) {
                        isCheckData = true;
                        break;
                    }
                }
                if (isCheckData) {
                    break;
                }
            }
            if (isCheckData) {
                NXGReports.addStep("Verify realtime search", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify realtime search", LogAs.FAILED, null);
            }
            getLogger().info("verifyDataSearch() isCheckData = " + isCheckData);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify realtime search", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void checkContentTextSearch() {
        getLogger().info("Run checkContentTextSearch()");
        try {
            //boolean isCheckData = createToDoPage.checkContentTextSearch();
            boolean isCheckData = false;
            waitForVisibleElement(eleToDoSearchInput, "");
            Thread.sleep(smallTimeOut);
            clearTextBox(eleToDoSearchInput, "clear txtIdTodoSearch");
            Thread.sleep(smallTimeOut);
            sendKeyTextBox(eleToDoSearchInput, todoContentTextSearch, "sendkey to todoContentTextSearch");
            waitForVisibleElement(tblIdTodoTable.findElement(By.xpath("id('todo-table')/tbody/tr")), "");
            // Check the result in the list data
            List<WebElement> tr_collection = tblIdTodoTable.findElements(By.xpath("id('todo-table')/tbody/tr"));
            for (WebElement trElement : tr_collection) {
                List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
                for (WebElement tdElement : td_collection) {
                    String strSearchValue = "";
                    try {
                        strSearchValue = tdElement.findElement(By.tagName("input")).getAttribute("value");
                    } catch (Exception ex) {
                    }
                    getLogger().info("Search contain text = " + strSearchValue);
                    if (strSearchValue.contains(todoContentTextSearch)) {
                        isCheckData = true;
                        break;
                    }
                }
                if (isCheckData) {
                    break;
                }
            }
            if (isCheckData) {
                NXGReports.addStep("Verify content of text search", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify content of text search", LogAs.FAILED, null);
            }
            getLogger().info("verifyContentTextSearch() isCheckContentText = " + isCheckData);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify content of text search", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySortToDoTaskOnName() {
        getLogger().info("Verify Sort ToDo Task On Name");
        verifySortDataGrid(toDoNameTextColumnEle, sortByToDoNameIconEle);
    }

    public void verifyCheckAllCheckboxToDoName() throws Exception {
        try {
            if (!eleCheckBox.isSelected()) eleCheckBox.click();
            for (int i = 0; i < eleToDoCheckboxRow.size(); i++) {
                if (!eleToDoCheckboxRow.get(i).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is NOT checked");
                    throw new Exception();
                }
            }
            getLogger().info("Check box icons are selected all.");
            NXGReports.addStep("Check box icons are selected all.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are not selected all.");
            NXGReports.addStep("Failed: Check box icons are not selected all.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyUnCheckAllCheckboxToDoName() throws Exception {
        try {
            if (eleCheckBox.isSelected()) eleCheckBox.click();
            for (int i = 0; i < eleToDoCheckboxRow.size(); i++) {
                if (eleToDoCheckboxRow.get(i).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is checked");
                    throw new Exception();
                }
            }
            getLogger().info("Check box icons are unselected all.");
            NXGReports.addStep("Check box icons are unselected all.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are not unselected all.");
            NXGReports.addStep("Failed: Check box icons are not unselected all.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCheckMultipleCheckBoxToDoName() throws Exception {
        try {
            if (eleCheckBox.isSelected()) eleCheckBox.click();
            if (eleToDoCheckboxRow.size() > 3) {
                eleToDoCheckboxRow.get(0).click();
                if (!eleToDoCheckboxRow.get(0).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Cannot select single checkbox on row");
                    throw new Exception();
                }
                eleToDoCheckboxRow.get(eleToDoCheckboxRow.size() - 1).click();
                if (!eleToDoCheckboxRow.get(eleToDoCheckboxRow.size() - 1).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Cannot select single checkbox on row");
                    throw new Exception();
                }
            }
            getLogger().info("Select single and multiple checkbox successfully");
            NXGReports.addStep("Select single and multiple checkbox successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are NOT selected multiple.");
            NXGReports.addStep("Failed: Check box icons are NOT selected multiple.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDefaultValueofCategoryComboBox(String defaultValueComboBox) {
        boolean result = false;
        getLogger().info("Verify Default Value Of Category ComboBox");
        System.out.println("Default Value in Dropdown box: " + categoryComboBoxTextEle.get(0).getText());
        result = validateElementText(categoryComboBoxTextEle.get(0), defaultValueComboBox);
        if (result) {
            NXGReports.addStep("Verify Default Value Of Category ComboBox successfully.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Failed: Verify Default Value Of Category ComboBox", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyHoverCategoryComboBox() {
        getLogger().info("Verify Default Value Of Category ComboBox.");
        verifyHoverElement(categoryComboBoxEle.get(0), "border", "1px solid rgb(92, 155, 160)");
    }

    public void createToDoTaskWithCategoryName(String toDoName, String categoryName) throws Exception {
        waitForClickableOfElement(createToDoBtnEle, "Create To Do Button");
        createToDoBtnEle.click();
        // Will changed after finding new solution for waiting Element
        Thread.sleep(smallTimeOut);
        createToDoNameTextBoxEle.sendKeys(toDoName);
        // Create new category
        createNewCategory("", categoryName);
        // Will changed after finding new solution for waiting Element
        //Thread.sleep(smallTimeOut);
        waitForClickableOfElement(categoryDropdownEle, "Category Dropdown");
        categoryDropdownEle.click();
        waitForClickableOfElement(categoryOptionItemEle.get(0), "Category Option Item");
        categoryOptionItemEle.get(0).click();
        waitForClickableOfElement(dueDateFieldEle, "Due Date field");
        dueDateFieldEle.click();
        waitForClickableOfElement(dateItemonCalendarEle, "Date value");
        dateItemonCalendarEle.click();
        waitForVisibleElement(toDoSaveIconEle, "Save Icon");
        toDoSaveIconEle.click();
        verifyAddNewToDoTask(toDoName);
    }

    public void verifyListValueofCategoryComboxBox(String categoryName) {
        try {
            boolean result;
            waitForClickableOfElement(createToDoNameTextBoxEle, "To Task name Textbox");
            createToDoNameTextBoxEle.click();
            waitForClickableOfElement(categoryComboBoxEle.get(0), "Category Combo box");
            categoryComboBoxEle.get(0).click();
            List<WebElement> menuCateComboBox = categoryComboBoxMenuEle.get(0).findElements(By.tagName("div"));
            result = validateElementText(menuCateComboBox.get(0), "Add New Category");
            Assert.assertTrue(result, "Add New Category option is not displayed");
            validateElementText(menuCateComboBox.get(1), "Edit Categories");
            Assert.assertTrue(result, "Edit Categories option is not displayed");
            validateElementText(menuCateComboBox.get(2).findElement(By.tagName("button")), categoryName);
            Assert.assertTrue(result, String.format("%s option is not displayed", categoryName));
            NXGReports.addStep("Verify List Value of Category ComboxBox", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify List Value of Category ComboxBox", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyNewCategoryPopUpDisplayed() throws Exception {
        try {
            boolean result;
            waitForVisibleElement(categoryTitleEle, "Category Title");
            result = validateElementText(categoryTitleEle, "Add New Category");
            Assert.assertTrue(result, "Add New Category popup is not displayed");
//            hoverElement(editCategoryCancelBtnEle,"Cancel Catergory button");
//            waitForClickableOfElement(editCategoryCancelBtnEle,"Cancel Create Category Button");
//			WebElement popUpDiv = getDriver().findElement(By.xpath("//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]"));
//			clickElement(editCategoryCancelBtnEle, "Cancel Add New Category Button");
//			waitForCssValueChanged(popUpDiv,"PopUp Windows","display","none");
            NXGReports.addStep("Verify New Category popup is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify New Category popup is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyEditCategoriesPopUpDisplayed() throws Exception {
        try {
            boolean result;
            waitForVisibleElement(categoryTitleEle, "Category Title");
            result = validateElementText(categoryTitleEle, "Edit Categories");
            Assert.assertTrue(result, "Edit Categories popup is not displayed");
//            hoverElement(editCategoryCancelBtnEle,"Cancel Catergory button");
//            waitForClickableOfElement(editCategoryCancelBtnEle,"Cancel Edit Category Button");
//			WebElement popUpDiv = getDriver().findElement(By.xpath("//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]"));
//			clickElement(editCategoryCancelBtnEle, "Cancel Add New Category Button");
//			waitForCssValueChanged(popUpDiv,"PopUp Windows","display","none");
            NXGReports.addStep("Verify Edit Categories popup is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify Edit Categories popup is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCreateToDoTaskWithoutCategory(String toDoName) throws Exception {
        getLogger().info("Verify Create ToDo Task Without Category");
        waitForClickableOfElement(createToDoNameTextBoxEle, "To Task name Textbox");
        createToDoNameTextBoxEle.sendKeys(toDoName);
        // Choose Due Date
        waitForClickableOfElement(dueDateFieldEle, "Due Date field");
        dueDateFieldEle.click();
        waitForClickableOfElement(dateItemonCalendarEle, "Date value");
        dateItemonCalendarEle.click();
        waitForVisibleElement(toDoSaveIconEle, "Save Icon");
        toDoSaveIconEle.click();
        verifyAddNewToDoTask(toDoName);
    }

    public void verifyInputMaxLengthToDoNameTextBox() {
        try {
            boolean result = false;
            getLogger().info("Verify Input Max Length ToDo Name TextBox.");
            result = validateMaxlenght(toDoNameInputEle, "ToDo Name Input", 255);
            Assert.assertTrue(result, "Input 255 Characters into ToDo Name TextBox is unsuccessfully.");
            NXGReports.addStep("Verify Edit Categories popup is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Input 255 Characters into ToDo Name TextBox is unsuccessfully.");
            NXGReports.addStep("TestScript Failed: Verify Input Max Length ToDo Name TextBox", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void inputInvalidValueToDoNameTextBox() {
        getLogger().info("Input Invalid Value into To Do Name TextBox.");
        verifyInputValueToDoNameTextBox("~!@#$%^&*+?><,.");
    }

    public void selectDueDateToDoTask() {
        waitForClickableOfElement(dueDateFieldEle, "Due Date field");
        clickElement(dueDateFieldEle, "Due Date field");
        waitForClickableOfElement(dateItemonCalendarEle, "Date value on Calendar");
        clickElement(dateItemonCalendarEle, "Date value on Calendar");
    }

    public void clickAddNewCategory() {
        try {
            Thread.sleep(smallerTimeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForClickableOfElement(createToDoNameTextBoxEle, "To Task name Textbox");
        createToDoNameTextBoxEle.click();
        waitForClickableOfElement(categoryComboBoxEle.get(0), "Category Combo box");
        categoryComboBoxEle.get(0).click();
        addNewCategoryMenuItemEle.click();
    }

    public void clickEditCategory() {
        waitForClickableOfElement(createToDoNameTextBoxEle, "To Task name Textbox");
        createToDoNameTextBoxEle.click();
        waitForClickableOfElement(categoryComboBoxEle.get(0), "Category Combo box");
        categoryComboBoxEle.get(0).click();
        editCategoryEle.click();
    }

    private String checkMarkToDoName = "";

    public void clickCheckboxNewToDoTask() {
        waitForClickableOfElement(eleToDoCheckboxRow.get(0), "CheckBox New ToDo Task");
        clickElement(eleToDoCheckboxRow.get(0), "CheckBox New ToDo Task");
        checkMarkToDoName = textToDoName.get(0).getAttribute("value").toString();
        getLogger().info("checkMarkToDoName first = " + checkMarkToDoName);
    }

    public void clickBulkActionsDropdown() {
        //waitForClickableOfElement(bulkActionsDropdownEle,"Bulk Actions Dropdown List");
        //hoverElement(bulkActionsDropdownEle,"Bulk Actions Dropdown List");
        clickElement(bulkActionsDropdownEle, "Bulk Actions Dropdown List");
    }

    public void verifyDefaultValueofBulkActionsDropdown(String defaultValueComboBox) {
        boolean result = false;
        getLogger().info("Verify Default value of Bulk Actions Dropdown.");
        System.out.println("Default Value in Dropdown box: " + bulkActionsDropdownEle.getText());
        result = validateElementText(bulkActionsDropdownEle, defaultValueComboBox);
        if (result) {
            NXGReports.addStep("Verify Default value of Bulk Actions Dropdown successfully.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Failed: Verify Default value of Bulk Actions Dropdown.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyHoverBulkActionsDropdown() {
        getLogger().info("Verify Default Value Of Bulk Actions Dropdown.");
        verifyHoverElement(bulkActionsDropdownEle, "border", "1px solid rgb(92, 155, 160)");
    }

    public void verifyListValueofBulkActionsDropdown() {
        try {
            getLogger().info("Verify List Value of Bulk Actions Dropdown.");
            boolean result;
            List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
            result = validateElementText(menuBulkActionsDropdown.get(0), "Download Attachments");
            Assert.assertTrue(result, "Download Attachments option is not displayed");
            validateElementText(menuBulkActionsDropdown.get(1), "Mark as complete");
            Assert.assertTrue(result, "Mark as complete option is not displayed");
            validateElementText(menuBulkActionsDropdown.get(2), "Delete");
            Assert.assertTrue(result, "Delete option is not displayed");
            WebElement assginToSubMenuEle = bulkActionsDropdownMenuEle.findElement(By.tagName("div"));
            validateElementText(assginToSubMenuEle, "Assign to");
            Assert.assertTrue(result, "Assign to sub Menu is not displayed");
            NXGReports.addStep("Verify List Value of Bulk Actions Dropdown", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify List Value of Bulk Actions Dropdown", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickDeleteToDoBulkActions() {
        List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
        clickElement(menuBulkActionsDropdown.get(2), "Deleted ToDo Button");
    }

    public void verifyCompleteMarkPopup() {
        verifyShowConfirmPopupAndMarkTitle();
        verifyDisplayImageInPopup();
        verifyMarkPopupColorCancelBtn();
        verifyMarkPopupColorArchiveBtn();
        //verifyClickClosePopup();
        verifyMarkCompleteArchive();
    }

    public void verifyShowConfirmPopupAndMarkTitle() {
        getLogger().info("Verify complete mark popup");
        try {
            List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
            clickElement(menuBulkActionsDropdown.get(1), "Bulk complete button");
            waitForVisibleElement(markAsCompleteTitle, "wait for visible markAsCompleteTitle");
            String markCompleteTitle = markAsCompleteTitle.getText();
            getLogger().info("markCompleteTitle = " + markCompleteTitle);
            if (markCompleteTitle.equals("Mark As Complete?")) {
                NXGReports.addStep("Verify complete mark popup", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify complete mark popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            getLogger().info(ex.getMessage());
            NXGReports.addStep("Verify complete mark popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDisplayImageInPopup() {
        getLogger().info("Verify to display image in popup");
        try {
            waitForVisibleOfLocator(By.cssSelector("img[src='../../images/icons/clipboard-yellow.png']"));
            WebElement imageInPopup = getDriver().findElement(By.cssSelector("img[src='../../images/icons/clipboard-yellow.png']"));
            waitForVisibleElement(imageInPopup, "visible " + imageInPopup);
            NXGReports.addStep("Verify to display image in popup", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to display image in popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyMarkPopupColorCancelBtn() {
        boolean isCheckColorCancelButton = false;
        getLogger().info("Verify the cancel button in Mark as complete popup");
        try {
            waitForPresentOfLocator(By.xpath("//div[@class='ce-footerBtnHolder']/button[contains(text(),'Cancel')]"));
            isCheckColorCancelButton = validateCSSValueElement(cancelMarkPopupBtn, backgroundColor, "rgba(151, 147, 147, 1)");
            isCheckColorCancelButton = validateCSSValueElement(cancelMarkPopupBtn, color, "rgba(255, 255, 255, 1)");
            if (isCheckColorCancelButton) {
                NXGReports.addStep("Verify the cancel button in Mark as complete popup", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the cancel button in Mark as complete popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the cancel button in Mark as complete popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyMarkPopupColorArchiveBtn() {
        boolean isCheckColorCancelButton = false;
        getLogger().info("Verify the archive button in Mark as complete popup");
        try {
            waitForPresentOfLocator(By.xpath("//div[@class='ce-footerBtnHolder']/button[contains(text(),'Archive')]"));
            isCheckColorCancelButton = validateCSSValueElement(archiveMarkPopupBtn, backgroundColor, "rgba(89, 155, 161, 1)");
            isCheckColorCancelButton = validateCSSValueElement(archiveMarkPopupBtn, color, "rgba(255, 255, 255, 1)");
            clickElement(archiveMarkPopupBtn, "click to archiveMarkPopupBtn");
            if (isCheckColorCancelButton) {
                NXGReports.addStep("Verify the archive button in Mark as complete popup", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the archive button in Mark as complete popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the archive button in Mark as complete popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyClickClosePopup() {
        getLogger().info("Verify to click to close complete mark popup");
        try {
            waitForVisibleOfLocator(By.cssSelector("img[src='../../images/icons/clipboard-yellow.png']"));
            WebElement closePopup = getDriver().findElement(By.cssSelector("img[src='../../images/icons/clipboard-yellow.png']"));
            waitForClickableOfElement(closePopup, "wait for click to closePopup");
            boolean isClickClose = clickElement(closePopup, "click to closePopup");
            if (isClickClose) {
                NXGReports.addStep("Verify to click to close complete mark popup", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to click to close complete mark popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to click to close complete mark popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyMarkCompleteArchive() {
        getLogger().info("Verify mark ToDo page complete archive");
        boolean isMarkCompleteArchive = false;
        try {
            for (WebElement markToDoPageMark : textToDoName) {
                if (checkMarkToDoName.equals(markToDoPageMark.getAttribute("value").toString())) {
                    getLogger().info("checkMarkToDoName = " + checkMarkToDoName);
                    waitForVisibleElement(textToDoNameArchiveComplete, "wait for " + textToDoNameArchiveComplete);
                    String dataComplete = textToDoNameArchiveComplete.getAttribute("data-completed").toString();
                    getLogger().info("dataComplete = " + dataComplete);
                    if (dataComplete.equals("true")) {
                        isMarkCompleteArchive = true;
                    }
                    break;
                }
            }
            if (isMarkCompleteArchive) {
                NXGReports.addStep("Verify mark ToDo page complete archive", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify mark ToDo page complete archive", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify mark ToDo page complete archive", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGUIDeleteToDoPopUp() {
        try {
            final String guideSentenceDes = "Are you sure you'd like to delete these To-Dos? Once deleted, you " +
                    "will not be able to retrieve any documents uploaded to the selected To-Dos.";
            getLogger().info("Verify GUI Delete To-Dos popup.");
            boolean result;
            waitForVisibleElement(categoryTitleEle, "Delete To-Do Title");
            result = validateElementText(categoryTitleEle, "Delete To-Do?");
            Assert.assertTrue(result, "Delete To Do popup is not displayed");
            waitForVisibleElement(centerDeleteToDoDescriptionEle, "Guide Sentence Description Delete ToDo");
            result = validateElementText(centerDeleteToDoDescriptionEle, guideSentenceDes);
            Assert.assertTrue(result, "Guide Sentence Description Delete ToDo is not displayed");
            waitForVisibleElement(deletedToDoButtonEle, "Delete To-Do button");
            result = validateCSSValueElement(deletedToDoButtonEle, "background-color", "rgba(241, 103, 57, 1)");
            Assert.assertTrue(result, "Background color of Delete To-Do button is NOT orange");
            result = validateCSSValueElement(deletedToDoButtonEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text color of Delete To-Do button is NOT white");
            waitForVisibleElement(cancelDeletedToDoButtonEle, "Cancel delete To-Do button");
            result = validateCSSValueElement(cancelDeletedToDoButtonEle, "background-color", "rgba(151, 147, 147, 1)");
            Assert.assertTrue(result, "Background color of Cancel delete To-Do button is NOT gray");
            result = validateCSSValueElement(cancelDeletedToDoButtonEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text color of Cancel delete To-Do button is NOT white");
            NXGReports.addStep("Verify GUI Delete To-Dos popup is displayed successfully", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify GUI Delete To-Dos popup is displayed unsuccessfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickCancelButtonOnPopup() {
        getLogger().info("Click Cancel Button on PopUp windows.");
        WebElement popUpDiv = getDriver().findElement(By.xpath("//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]"));
        hoverElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");
        waitForClickableOfElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo Button");
        clickElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    public void clickCloseButtonOnPopup() {
        getLogger().info("Click Close Button on PopUp windows.");
        WebElement popUpDiv = getDriver().findElement(By.xpath("//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]"));
        //Will remove after finding solution for checking the toast message is closed.
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        hoverElement(closePopupBtnEle, "Close Delete ToDo button");
        waitForClickableOfElement(closePopupBtnEle, "Close Delete ToDo Button");
        clickElement(closePopupBtnEle, "Close Delete ToDo button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    public void verifyBulkActionsDropdownIsClosed() {
        try {
            getLogger().info("Verify Bulk Actions Dropdown Is Closed.");
            boolean result;
            List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
            result = validateElementTextNotDisplayed(menuBulkActionsDropdown.get(0), "Download Attachments");
            Assert.assertTrue(result, "Bulk Actions Dropdown should be closed");
            NXGReports.addStep("Verify Bulk Actions Dropdown Is Closed.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify Bulk Actions Dropdown Is Closed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public int findToDoTaskName(String toDoName) {
        getLogger().info("Find Position of To Do Task Name");
        return findElementByValue(eleToDoNameRow, toDoName);
    }

    public void selectToDoCheckboxByName(String todoName) {
        getLogger().info("Select To Do Task Check Box by Name");
        int index = findToDoTaskName(todoName);
        if (!eleToDoCheckboxRow.get(index).isSelected())
            clickElement(eleToDoCheckboxRow.get(index), String.format("Check box of Task Name: %s", todoName));
    }

    public void unSelectToDoCheckboxByName(String todoName) {
        getLogger().info("Un Select To Do Task Check Box by Name");
        int index = findToDoTaskName(todoName);
        if (eleToDoCheckboxRow.get(index).isSelected())
            clickElement(eleToDoCheckboxRow.get(index), String.format("Check box of Task Name: %s", todoName));
    }

    public int getNumberofToDoTask() {
        getLogger().info("Get the number of To Do task in To Do list page.");
        int count;
        if (toDoTaskRowEle.isEmpty())
            count = 0;
        else count = toDoTaskRowEle.size();
        return count;
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- Start

    /**
     * check select data drop down is show when click
     *
     * @throws Exception
     */
    public void verifySelectDateDropDown() throws Exception {
        try {
            waitForClickableOfElement(eleIdDueDate, "Select date drop down");
            eleIdDueDate.click();
            NXGReports.addStep("Verify Select date drop down is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify Select date drop down is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * move to add new To-do page
     *
     * @throws Exception
     */
    public void navigateAddNewToDoPage() throws Exception {
        getLogger().info("Run createToDoPage()");
        waitForClickableOfElement(createToDoBtnEle, "create todo button.");
        this.createToDoBtnEle.click();
    }

    /**
     * check default value of due date text box
     *
     * @return true | false
     */
    public boolean checkDefaultDueDateValue() {
        waitForVisibleElement(eleDueDateValue, "Engagement Due date");
        waitForVisibleElement(eleIdDueDate, "Default Due date");
        String engagementDueDate = eleDueDateValue.getText().substring(5, eleDueDateValue.getText().length());
        String defaultDueDate = eleIdDueDate.getText();
        getLogger().info(engagementDueDate);
        getLogger().info(defaultDueDate);
        return engagementDueDate.equals(defaultDueDate);
    }

    /**
     * check default format
     */
    public boolean checkFormatDueDate() {
        waitForVisibleElement(eleIdDueDate, "Due date");
        return isThisDateValid(eleIdDueDate.getAttribute("value").trim(), "mm/dd/yyyy");
    }

    /**
     * Verify data on date picker
     */
    public boolean verifyDataOfDatePicker(boolean isNewToDoPage) {
        try {
            Calendar cal = Calendar.getInstance();
            int currentDay = cal.get(Calendar.DAY_OF_MONTH);
            int currentMonth = cal.get(Calendar.MONTH);
            int currentYear = cal.get(Calendar.YEAR);
            int focusDay = 0;
            int focusMonth = 0;
            int focusYear = 0;
            // If isNewToDoPage = true, verify in add new to-do page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                eleIdDueDate.click();
                waitForClickableOfElement(eleXpathChooseDate, "Date picker");
                waitForVisibleElement(eleDataPickerToDate, "Date picker to date");
                waitForVisibleElement(eleDataPickerToDay, "Date picker to day");

                focusDay = Integer.parseInt(eleDataPickerToDay.getAttribute("text").trim());
                focusMonth = Integer.parseInt(eleDataPickerToDate.getAttribute("data-month").trim());
                focusYear = Integer.parseInt(eleDataPickerToDate.getAttribute("data-year").trim());
                getLogger().info("Day : " + eleDataPickerToDay.getAttribute("text") + "Month :" + eleDataPickerToDate.getAttribute("data-month") + " Year :" + eleDataPickerToDate.getAttribute("data-year"));

            }
            // Compare focus day, month, year with current day, month, year
            if (focusDay != currentDay || focusMonth != currentMonth || focusYear != currentYear) {
                NXGReports.addStep("TestScript Failed: Verify data in date pickerd", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }
            NXGReports.addStep("Verify data in date picker", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify data in date pickerd", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return true;
    }


    /**
     * Hover on date picker
     */
    public void hoverDateItemInDatePicker(boolean isNewToDoPage) {
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                eleIdDueDate.click();
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                eleToDoNewRowDueDateText.get(0).click();
            }
            waitForClickableOfElement(eleXpathChooseDate, "Date picker");
            hoverElement(eleXpathChooseDate, "Date picker");
            NXGReports.addStep("Verify hover select date in date picker", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify hover select date in date pickerd", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * choose date item in date picker
     *
     * @return true | false
     */
    public boolean chooseDateItemInDataPicker(boolean isNewToDoPage) throws Exception {
        boolean result = true;
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date tex box");
                eleIdDueDate.click();
                waitForClickableOfElement(eleXpathChooseDate, "Date picker");
                eleXpathChooseDate.click();
                result = "".equals(eleIdDueDate.getAttribute("value").trim());
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                eleToDoNewRowDueDateText.get(0).click();
                waitForClickableOfElement(eleXpathChooseDate, "Date picker");
                eleXpathChooseDate.click();
                result = "".equals(eleToDoNewRowDueDateText.get(0).getAttribute("value").trim());
            }
            //If result = true : before and after value as same --> data picker not work
            if (result) {
                NXGReports.addStep("TestScript Failed: Choose date in date picker", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }

            NXGReports.addStep("Choose date in date picker", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Choose date in date picker", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        return true;
    }

    /**
     * Check date picker is move next or previous month when click Prev or Next link.
     *
     * @param actionLink : prev | next
     * @return true | false
     */
    public boolean checkDatePickerChangeMonth(String actionLink, boolean isNextMonth, boolean isNewToDoPage) {
        boolean result = true;
        String beforeTitle = "";
        String afterTitle = "";
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                eleIdDueDate.click();
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                eleToDoNewRowDueDateText.get(0).click();
            }

            waitForVisibleElement(eleDataPickerTitle, "Date picker title");
            //Get tile date picker before click next or previous link
            beforeTitle = eleDataPickerTitle.getText();

            // If isNextMonth = true : click on Next link in date picker |
            //    isNextMonth = false, click on Prev link in date picker
            if (!isNextMonth) {
                waitForClickableOfElement(elePrevDataPickerLink, "Previous date picker link");
                elePrevDataPickerLink.click();
            } else {
                waitForClickableOfElement(eleNextDataPickerLink, "Next date picker link");
                eleNextDataPickerLink.click();
            }

            //Get tile date picker after click next or previous link
            afterTitle = eleDataPickerTitle.getText();
            result = beforeTitle.equals(afterTitle);

            //If result = true : before and after value as same --> data picker not work
            if (result) {
                NXGReports.addStep("TestScript Failed: Date picker is change " + actionLink + " month", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }

            NXGReports.addStep("Date picker is change " + actionLink + " month", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Date picker is change " + actionLink + " month", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        return true;
    }

    /**
     * Verify input correct format date into due date text box
     *
     * @param dateValue
     * @return true | false
     */
    public boolean verifyInputCorrectFormatDate(String dateValue, boolean isNewToDoPage) {
        boolean result = true;
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                clickElement(eleIdDueDate, "Due date text box");
                sendKeyTextBox(eleIdDueDate, dateValue, "Due date text box");
                result = validateAttributeElement(eleIdDueDate, "value", "");
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                clickElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                sendKeyTextBox(eleToDoNewRowDueDateText.get(0), dateValue, "Select due date text box");
                result = validateAttributeElement(eleToDoNewRowDueDateText.get(0), "value", "");

            }
            //If result = false : before and after value as not same --> can not input correct data into due date control
            if (!result) {
                NXGReports.addStep("TestScript Failed: Input correct date format in due date text box ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }
            NXGReports.addStep("Input correct date format in due date text box ", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Input correct date format in due date text box ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        return result;
    }

    /**
     * Verify input wrong format date into due date text box
     *
     * @param dateValue
     * @return true | false
     */
    public boolean verifyInputWrongValue(String dateValue, boolean isNewToDoPage) {
        boolean result = true;
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                clickElement(eleIdDueDate, "Due date text box");
                sendKeyTextBox(eleIdDueDate, dateValue, "Due date text box");
                result = eleIdDueDate.getAttribute("value").equals(dateValue);
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                clickElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                sendKeyTextBox(eleToDoNewRowDueDateText.get(0), dateValue, "Select due date text box");
                result = eleToDoNewRowDueDateText.get(0).getAttribute("value").equals(dateValue);

            }
            //If result = true : before and after value as same --> can input wrong data into due date control
            if (result) {
                NXGReports.addStep("TestScript Failed: Input wrong date format in due date text box ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }
            NXGReports.addStep("Input wrong date format in due date text box ", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Input wrong date format in due date text box ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        return true;
    }
    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- End

    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- Start
    @FindBy(id = "btn-todo-trash")
    private WebElement trashToDoBtnEle;

    @FindBy(xpath = "//div[@id='CategoryModel']//h3[@class='setup-header']")
    private WebElement eleDeleteConfrimPopupTitle;

    @FindBy(xpath = "//div[@id='CategoryModel']//h3[@class='setup-header']")
    private WebElement eleDeleteConfrimPopupDescription;

    @FindBy(xpath = "//*[@class='newRow']")
    private List<WebElement> eleToDoRowList;

    @FindBy(xpath = "//*[@class='newRow todoCompleted']")
    private List<WebElement> eleToDoCompleteRowList;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow todoCompleted']//input[@type='checkbox']")
    private List<WebElement> eleToDoCompleteCheckboxRow;

    @FindBy(id = "cb-select-all-todo")
    private WebElement eleCheckAllCheckBox;

    /**
     * Verify trash to do icon.
     */
    public void verifyTrashToDoIcon() {
        try {
            waitForVisibleElement(trashToDoBtnEle, "Trash ToDo icon");
            NXGReports.addStep("Verify trash ToDo icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify trash ToDo icon", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify default status trash to do icon.
     */
    public void verifyDefaultStatusTrashToDoIcon() {
        try {
            waitForVisibleElement(trashToDoBtnEle, "Trash ToDo icon");
            validateAttributeElement(trashToDoBtnEle, "class", "fa fa-trash disabled");
            NXGReports.addStep("Verify default status trash ToDo icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify default status trash ToDo icon", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Check list row is empty
     *
     * @param eleList : list row need check
     * @return true : list empty | false : list not empty
     */
    public boolean checkListIsEmpty(List<WebElement> eleList) {
        if (eleList.size() == 0) {
            return true;
        }
        return false;
    }


    /**
     * Verify gui of delete confirm popup
     */
    public void verifyGUIDeleteConfirmPopup() {
        try {
            String guideSentenceDes = "Are you sure you'd like to delete these To-Dos? " +
                    "Once deleted, you will not be able to retrieve any documents uploaded to the selected To-Dos.";
            String errorMessage = "Can not test verify gui of delete confirm popup because ToDo list is empty ";
            boolean result = true;
            getLogger().info("Verify GUI Delete ToDo popup when click trash ToDo icon.");
            boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            // Check ToDo row list is empty
            if (checkEmptyToDoListRow && checkEmptyToDoCompleteListRow) {
                NXGReports.addStep("TestScript Failed: " + errorMessage, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                AbstractService.sStatusCnt++;
                return;
            }
            if (!checkEmptyToDoListRow) {
                waitForVisibleElement(eleToDoCheckboxRow.get(0), "Select check box of ToDo row has not complete");
                hoverElement(eleToDoCheckboxRow.get(0), "Hover check box in to do row has not complete");
                if (!eleToDoCheckboxRow.get(0).isSelected()) {
                    clickElement(eleToDoCheckboxRow.get(0), "Check on select check box");
                }
            } else {
                waitForVisibleElement(eleToDoCompleteCheckboxRow.get(0), "Select check box of ToDo row has complete");
                hoverElement(eleToDoCompleteCheckboxRow.get(0), "Hover check box in to do row has complete");
                if (!eleToDoCompleteCheckboxRow.get(0).isSelected()) {
                    clickElement(eleToDoCompleteCheckboxRow.get(0), "Check on select check box");
                }
            }


            //verify delete confirm icon
            clickElement(trashToDoBtnEle, "Trash icon click");
            // verify popup title
            waitForVisibleElement(categoryTitleEle, "Delete ToDo title");
            result = validateElementText(categoryTitleEle, "Delete To-Do?");
            Assert.assertTrue(result, "Delete ToDo popup title is not displayed correct");
            NXGReports.addStep("Popup title is show correct", LogAs.PASSED, null);

            // verify guide sentence
            waitForVisibleElement(centerDeleteToDoDescriptionEle, "Guide sentence description delete to-do");
            result = validateElementText(centerDeleteToDoDescriptionEle, guideSentenceDes);
            Assert.assertTrue(result, "Guide sentence description delete ToDo is not displayed correct");
            NXGReports.addStep("Popup Guide sentence is show correct", LogAs.PASSED, null);

            // verify back-ground and text of delete button
            waitForVisibleElement(deletedToDoButtonEle, "Delete ToDo button");
            result = validateCSSValueElement(deletedToDoButtonEle, "background-color", "rgba(241, 103, 57, 1)");
            Assert.assertTrue(result, "Background color of delete ToDo button is not orange");
            result = validateCSSValueElement(deletedToDoButtonEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text color of delete ToDo button is not white");
            NXGReports.addStep("Popup delete button is show correct", LogAs.PASSED, null);

            // verify back-ground and text of cancel button
            waitForVisibleElement(cancelDeletedToDoButtonEle, "Cancel to-do button");
            result = validateCSSValueElement(cancelDeletedToDoButtonEle, "background-color", "rgba(151, 147, 147, 1)");
            Assert.assertTrue(result, "Background color of cancel ToDo button is not gray");
            result = validateCSSValueElement(cancelDeletedToDoButtonEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text color of cancel to-do button is not white");
            NXGReports.addStep("Popup cancel button is show correct", LogAs.PASSED, null);

            //verify close popup icon
            int beforeTotalRows = eleToDoNewRowDueDateText.size();
            waitForVisibleElement(closePopupBtnEle, "Close popup icon");
            int afterTotalRows = eleToDoNewRowDueDateText.size();
            result = beforeTotalRows == afterTotalRows;
            Assert.assertTrue(result, "Close popup icon working do not correct");
            NXGReports.addStep("Close popup icon working correct", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify gui of delete confirm popup in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Check all check box of ToDo list is check/uncheck
     *
     * @param isCheck      true : check | false : uncheck
     * @param checkBoxList check box list need check
     * @return true | false
     */
    public boolean checkAllCheckBoxIsCheckOrUnCheck(List<WebElement> checkBoxList, boolean isCheck) {
        int totalRows = checkBoxList.size();
        for (int i = 0; i < totalRows; i++) {
            if (isCheck) {
                if (!checkBoxList.get(i).isSelected())
                    return false;
            } else {
                if (checkBoxList.get(i).isSelected())
                    return false;
            }
        }
        return true;
    }

    /**
     * Check/Uncheck check box of row list
     *
     * @param checkBoxList : check box row list need check/uncheck
     * @param isCheck      : true : check | false
     * @return : true : check/un check all check box | can not check/un check all check box
     */
    public boolean checkAllCheckBox(List<WebElement> checkBoxList, boolean isCheck) {
        int beforeError = AbstractService.sStatusCnt;
        int totalRows = checkBoxList.size();
        for (int i = 0; i < totalRows; i++) {
            if (isCheck) {
                if (!checkBoxList.get(i).isSelected()) {
                    hoverElement(checkBoxList.get(i), "Hover check box");
                    clickElement(checkBoxList.get(i), "Check on check box");

                }
            } else {
                if (checkBoxList.get(i).isSelected()) {
                    hoverElement(checkBoxList.get(i), "Hover check box");
                    clickElement(checkBoxList.get(i), "Un check on check box");
                }

            }
            int afterError = AbstractService.sStatusCnt;
            if (beforeError != afterError)
                return false;
        }
        return true;
    }

    /**
     * Check row is delete out ToDo list
     *
     * @param idRow : id delete row
     * @return true  : already delete | false : not yet delete
     */
    public boolean checkRowIsDeleteOutOfToDoList(List<WebElement> eleList, String idRow) {
        int totalRows = eleList.size();
        for (int i = 0; i < totalRows; i++) {
            if (eleList.get(i).getAttribute("data-id").equals(idRow))
                return false;
        }
        return true;
    }

    /**
     * verify check all check box
     */
    public void verifyCheckAllCheckBox() {
        try {
            boolean result = true;
            String errorMessage = "Can not test verify check all check box in ToDo page because ToDo list is empty ";
            boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            // Check ToDo row list is empty
            if (checkEmptyToDoListRow && checkEmptyToDoCompleteListRow) {
                NXGReports.addStep("TestScript Failed: " + errorMessage, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                AbstractService.sStatusCnt++;
                return;
            }
            //verify "CheckAll" check box
            waitForClickableOfElement(eleCheckAllCheckBox, "Check all check box");
            clickElement(eleCheckAllCheckBox, "Click 'CheckALL' check box");
            // verify all check box are checked when check all checkbox is check
            if (!checkEmptyToDoListRow) {
                result = checkAllCheckBoxIsCheckOrUnCheck(eleToDoCheckboxRow, true);
            }
            if (!checkEmptyToDoCompleteListRow) {
                if (result)
                    checkAllCheckBoxIsCheckOrUnCheck(eleToDoCompleteCheckboxRow, true);
            }
            Assert.assertTrue(result, "All checkbox do not check");
            NXGReports.addStep("Verify when check on 'CheckAll' check box in ToDo page", LogAs.PASSED, null);

            //verify all check box are checked when check all checkbox is un check
            waitForClickableOfElement(eleCheckAllCheckBox, "Check all check box");
            clickElement(eleCheckAllCheckBox, "Click 'CheckALL' check box");
            if (!checkEmptyToDoListRow) {
                result = checkAllCheckBoxIsCheckOrUnCheck(eleToDoCheckboxRow, false);
            }
            if (!checkEmptyToDoCompleteListRow) {
                if (result)
                    checkAllCheckBoxIsCheckOrUnCheck(eleToDoCompleteCheckboxRow, false);
            }
            Assert.assertTrue(result, "All checkbox do not uncheck");
            NXGReports.addStep("Verify when un check on 'CheckAll' check box in ToDo page", LogAs.PASSED, null);

            // verify "CheckAll" check box is checked when all check box are check
            //// check all check box in ToDo page
            if (!checkEmptyToDoListRow) {
                result = checkAllCheckBox(eleToDoCheckboxRow, true);
                if (result == false) {
                    NXGReports.addStep("TestScript Failed: can not check on all check box in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    return;
                }
            }

            if (!checkEmptyToDoCompleteListRow) {
                result = checkAllCheckBox(eleToDoCompleteCheckboxRow, true);
                if (result == false) {
                    NXGReports.addStep("TestScript Failed: can not check on all check box in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    return;
                }
            }
            //// verify "CheckAll" check box is checked
            waitForVisibleElement(eleCheckAllCheckBox, "CheckAll check box");
            if (!eleCheckAllCheckBox.isSelected()) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("TestScript Failed: CheckAll do not auto check in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return;
            }
            NXGReports.addStep("Verify 'CheckAll' check box is check when check all check box in ToDo page", LogAs.PASSED, null);

            // verify "CheckAll" check box is unchecked when have any check box is un check
            //// un check any check box in ToDo page
            if (!checkEmptyToDoListRow) {
                result = checkAllCheckBox(eleToDoCheckboxRow, false);
                if (result == false) {
                    NXGReports.addStep("TestScript Failed: can not uncheck on all check box in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    return;
                }
            }

            if (!checkEmptyToDoCompleteListRow) {
                result = checkAllCheckBox(eleToDoCompleteCheckboxRow, false);
                if (result == false) {
                    NXGReports.addStep("TestScript Failed: can not uncheck on all check box in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    return;
                }
            }
            //// verify "CheckAll" check box is unchecked
            waitForVisibleElement(eleCheckAllCheckBox, "CheckAll check box");
            if (eleCheckAllCheckBox.isSelected()) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("TestScript Failed: CheckAll do not auto uncheck in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return;
            }
            NXGReports.addStep("Verify 'CheckAll' check box is un check when un check all check box in ToDo page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify 'CheckAll' check box in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * get id delete row
     *
     * @param checkToDoList         : todoList is empty or not empty
     * @param checkToDoCompleteList : todoComplete is empty or not empty
     * @return id delete row value
     */
    public String getIdRowDelete(boolean checkToDoList, boolean checkToDoCompleteList,
                                 List<WebElement> eleToDoCheckBoxList, List<WebElement> eleToDoCompleteCheckBoxList,
                                 List<WebElement> eleToDoList, List<WebElement> eleToDoCompleteList) {
        String idRow = "";
        // Check have row has complete satatus
        if (!checkToDoList && "".equals(idRow)) {
            waitForVisibleElement(eleToDoCheckBoxList.get(0), "Select check box of ToDo item has not status complete");
            if (!eleToDoCheckBoxList.get(0).isSelected()) {
                eleToDoCheckBoxList.get(0).click();
            }
            idRow = eleToDoList.get(0).getAttribute("data-id");
            getLogger().info("Lay id cua list todo not complete");
        } else if (!checkToDoCompleteList && "".equals(idRow)) {
            waitForVisibleElement(eleToDoCompleteCheckBoxList.get(0), "Select check box of ToDo item has status complete");
            if (!eleToDoCompleteCheckBoxList.get(0).isSelected()) {
                eleToDoCompleteCheckBoxList.get(0).click();
            }
            idRow = eleToDoCompleteList.get(0).getAttribute("data-id");
            getLogger().info("Lay id cua list todo complete");
        }
        return idRow;
    }

    /**
     * verify work flow of delete button
     */
    public void verifyWorkFlowOfDeleteButton() {
        try {
            boolean result = true;
            String errorMessage = "Can not test work flow of delete button in confirm popup because ToDo list is empty ";
            boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            // Check ToDo row list is empty
            if (checkEmptyToDoListRow && checkEmptyToDoCompleteListRow) {
                NXGReports.addStep("TestScript Failed: " + errorMessage, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                AbstractService.sStatusCnt++;
                return;
            }
            // Get id delete row
            String idRow = getIdRowDelete(checkEmptyToDoListRow, checkEmptyToDoCompleteListRow,
                    eleToDoCheckboxRow, eleToDoCompleteCheckboxRow,
                    eleToDoRowList, eleToDoCompleteRowList);
            //verify delete confirm icon
            clickElement(trashToDoBtnEle, "Trash icon delete");
            //verify delete button
            // Hard code wait delete button enable
            Thread.sleep(5000);
            hoverElement(deletedToDoButtonEle, "Hover delete button");
            clickElement(deletedToDoButtonEle, "Delete button click");
            // Hard code wait ajax load done
            Thread.sleep(5000);
            // Check list again
            checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            // Check in todo list
            if (!checkEmptyToDoListRow) {
                result = checkRowIsDeleteOutOfToDoList(eleToDoRowList, idRow);

            }
            // Check in to do complete list
            if (!checkEmptyToDoCompleteListRow && result) {
                result = checkRowIsDeleteOutOfToDoList(eleToDoCompleteRowList, idRow);
            }

            Assert.assertTrue(result, "Delete button does not work");
            NXGReports.addStep("Verify work flow of delete button in ToDo page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify work flow of delete button in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * verify work flow of cancel button
     */
    public void verifyWorkFlowOfCancelButton() {
        try {
            boolean result = true;
            String errorMessage = "Can not test work flow of cancel button in confirm popup because ToDo list is empty ";
            boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            // Check ToDo row list is empty
            if (checkEmptyToDoListRow && checkEmptyToDoCompleteListRow) {
                NXGReports.addStep("TestScript Failed: " + errorMessage, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                AbstractService.sStatusCnt++;
                return;
            }
            // Get id delete row
            String idRow = getIdRowDelete(checkEmptyToDoListRow, checkEmptyToDoCompleteListRow,
                    eleToDoCheckboxRow, eleToDoCompleteCheckboxRow,
                    eleToDoRowList, eleToDoCompleteRowList);
            //verify delete confirm icon
            clickElement(trashToDoBtnEle, "Trash icon delete");
            //Hard code wait cancel button enable
            Thread.sleep(5000);
            hoverElement(cancelDeletedToDoButtonEle, "Hover cancel button");
            clickElement(cancelDeletedToDoButtonEle, "Cancel button click");
            // Check row is delete out of list
            if (!checkEmptyToDoListRow) {
                result = checkRowIsDeleteOutOfToDoList(eleToDoRowList, idRow);
            }
            if (!checkEmptyToDoCompleteListRow && result) {
                result = checkRowIsDeleteOutOfToDoList(eleToDoCompleteRowList, idRow);
            }
            Assert.assertFalse(result, "Cancel button does not work");
            NXGReports.addStep("Verify work flow of cancel button in ToDo page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify work flow of cancel button in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- End

    public void selectToDoCommentIconByName(String toDoTaskName) {
        getLogger().info("Select To Do Comment Icon by Name");
        int index = findToDoTaskName(toDoTaskName);
        clickElement(commentIconToDoListEle.get(index), String.format("Comment Icon on Task Name: %s", toDoTaskName));
    }

    /**
     * Added by huy.huynh on 18/05/2017.
     * Scenarios : PLAT 2285 - Add undo option
     */

    /**
     * verify button Undo exist
     */
    public void uiVerifyButtonUndoExist() {
        try {
            getLogger().info("Verify button Undo Todo exist.");
            btnToDoUndo.getAttribute("class");
            NXGReports.addStep("Verify button Undo Todo exist.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify button Undo Todo exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verify button Undo disable
     */
    public void uiVerifyButtonUndoDisable() {
        try {
            getLogger().info("Verify button Undo Todo disable.");
            Thread.sleep(2000);

            if (btnToDoUndo.getAttribute("class").toString().equals("fa fa-undo disabled")) {
                NXGReports.addStep("Verify button Undo Todo disable.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify button Undo Todo disable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * verify button Undo enable
     */
    public void uiVerifyButtonUndoEnable() {
        try {
            getLogger().info("Verify button Undo Todo enable.");
            Thread.sleep(2000);

            if (btnToDoUndo.getAttribute("class").toString().equals("fa fa-undo")) {
                NXGReports.addStep("Verify button Undo Todo enable.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify button Undo Todo enable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * create a record with name and date(of this month- implement choose month and year later)
     *
     * @param toDoName name of To-Do to create
     * @param dueDate  date of this month which chosen as dueDate
     */
    public void createToDoPageWithNameAndDate(String toDoName, String dueDate) {
        try {
            getLogger().info("Run createToDoPageWithNameAndDate(String toDoName, String dueDate)");
            Thread.sleep(smallTimeOut);
            clickCreateToDoTask();
            Thread.sleep(smallTimeOut);

            sendKeyTextBox(createToDoNameTextBoxEle, toDoName, "To Do Name Input");

            clickElement(eleIdDueDate, "Due Date Input");
            DatePicker datePicker = new DatePicker(getDriver(), eleXpathChooseDate);
            datePicker.pickADate(dueDate);

            clickElement(toDoSaveIconEle, "Save New Todo Icon");
            NXGReports.addStep("Created a new To-Do with given name and dueDate.", LogAs.PASSED, null);
        } catch (InterruptedException e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Created a new To-Do with given name and dueDate.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * create a record with name and date(of this month- implement choose month and year later)
     *
     * @param toDoName name of To-Do to choose
     */
    public void clickCheckBoxAtRowName(String toDoName) {
        try {
            getLogger().info("Chose a row with given name(which just created).");
            getDriver().findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[@class='newRow']//input[@type='checkbox']")).click();
            NXGReports.addStep("Chose a row with given name(which just created).", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Chose a row with given name(which just created).", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * click button Bulk Actions
     */
    public void clickBulkActions() {
        btnBulkActions.click();
    }

    /**
     * choose Mark as complete option
     */
    public void chooseOptionMarkAsCompleteOnBulkActionsDropDown() {
        try {
            getLogger().info("Choose option: Mark as complete");
            optionMarkAsComplete.click();
            NXGReports.addStep("Choose option: Mark as complete.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose option: Mark as complete.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * choose Delete option
     */
    public void chooseOptionDeleteOnBulkActionsDropDown() {
        try {
            getLogger().info("Choose option: Delete.");
            optionDelete.click();
            NXGReports.addStep("Choose option: Delete.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose option: Delete.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * choose Assign to option
     */
    public void chooseOptionAssignToOnBulkActionsDropDown() {
        try {
            getLogger().info("Choose option: Assign to.");
            optionAssignTo.click();
            NXGReports.addStep("Choose option: Assign to.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose option: Assign to.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * choose Download Attachments option
     */
    public void verifyOptionDownloadAttachmentsOnBulkActionsDropDown() {
        getLogger().info("Bulk Actions option Download Attachments disable.");
        if (optionDownloadAttachments.getAttribute("class").equals("item disabled")) {
            NXGReports.addStep("Bulk Actions option Download Attachments disable.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Bulk Actions option Download Attachments disable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * choose an assignee on list Assign to
     * TODO hardcoding, rewrite later, list assignee not stable now
     */
    public void chooseOptionAssignToAssigneeOnBulkActionsDropDownWithName(String assigneeName) {
        try {
            getLogger().info("Choose first assignee(any) to assign.");
            getDriver().findElement(By.xpath("//button[contains(text(),'" + assigneeName + "')]")).click();
            //optionAssignee.click();
            NXGReports.addStep("Choose first assignee(any) to assign.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose first assignee(any) to assign.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verify 'completed'  a To-Do in frontend
     *
     * @param toDoName name of To-Do to choose
     */
    public void verifyTodoCompleteFrontend(String toDoName, String status) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO move xpath to properties file
        WebElement toDoRow = getDriver().findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[contains(@class,'newRow')]"));
        WebElement toDoCategory = getDriver().findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[contains(@class,'newRow')]//div[contains(@class,'ui dropdown category')]"));
        WebElement toDoClient = getDriver().findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[contains(@class,'newRow')]//div[contains(@class,'ui dropdown client')]"));
        WebElement toDoAuditor = getDriver().findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[contains(@class,'newRow')]//div[contains(@class,'ui dropdown auditor')]"));

        if (status.equals("true")) {
            getLogger().info("Verify Completed To-Do front-end");
            if ((toDoRow.getAttribute("class").endsWith("todoCompleted")) && (toDoCategory.getAttribute("class").endsWith("disabled")) && (toDoClient.getAttribute("class").endsWith("disabled")) && (toDoAuditor.getAttribute("class").endsWith("disabled"))) {
                NXGReports.addStep("Verify Completed To-Do front-end", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify Completed To-Do front-end", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } else {
            getLogger().info("Verify not Completed To-Do front-end");
            if ((!toDoRow.getAttribute("class").endsWith("todoCompleted")) && (!toDoCategory.getAttribute("class").endsWith("disabled")) && (!toDoClient.getAttribute("class").endsWith("disabled")) && (!toDoAuditor.getAttribute("class").endsWith("disabled"))) {
                NXGReports.addStep("Verify not Completed To-Do front-end", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify not Completed To-Do front-end", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        }
    }

    /**
     * create a record with name and date(of this month- implement choose month and year later)
     * TODO split into 2 cases: Assign to-> Auditor || Client . So insane!
     *
     * @param toDoName     name of To-Do to choose
     * @param assigneeName name of assignee
     */
    public void verifyTodoAssignToFrontend(String toDoName, String assigneeName) {
        getLogger().info("Verify name of assignee on UI after assign. Expected: " + assigneeName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String assignee = getDriver().findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[@class='newRow']//div[contains(@class,'ui dropdown auditor')]/div[@class='text']")).getText();
        //System.out.println("++++++++++++++++++++++++++++++++++++++++assigneeName - text " + assignee + " - " + assigneeName);
        if (assigneeName.equals(assignee)) {
            NXGReports.addStep("Verify name of assignee on UI after assign. Expected: " + assigneeName, LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify name of assignee on UI after assign. Expected: " + assigneeName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verify deleted To-Do(not exist) in frontend
     *
     * @param toDoName name of To-Do to choose
     */
    public void verifyTodoDeletedFrontend(String toDoName, String status) {
        try {
            getLogger().info("Verify a Todo not exist. Name: " + toDoName);
            //Thread.sleep(1000);
            //TODO move xpath to properties file, very low peformance
            getDriver().findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']"));
            if (status.equals("INACTIVE")) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify a Todo not exist. Name: " + toDoName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                NXGReports.addStep("Verify a Todo exist. Name: " + toDoName, LogAs.PASSED, null);
            }
        } catch (NoSuchElementException ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            if (status.equals("INACTIVE")) {
                NXGReports.addStep("Verify a Todo not exist. Name: " + toDoName, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify a Todo exist. Name: " + toDoName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            getLogger().info(ex.getStackTrace());
        }
    }

    /**
     * click button Archive
     */
    public void clickComfirmArchive() {
        try {
            getLogger().info("Verify click button Archive.");
            Thread.sleep(smallTimeOut);
            btnArchive.click();
            NXGReports.addStep("Verify click button Archive.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click button Archive.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * click button Delete
     */
    public void clickComfirmDelete() {
        try {
            getLogger().info("Verify click button Delete.");
            Thread.sleep(smallTimeOut);
            btnDelete.click();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify click button Delete.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click button Delete.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * click button(icon) Undo
     */
    public void clickBtnUndo() {
        try {
            getLogger().info("Verify click button(icon) Undo.");
            Thread.sleep(smallTimeOut);
            btnToDoUndo.click();
            NXGReports.addStep("Verify click button(icon) Undo.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click button(icon) Undo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**-----end of huy.huynh PLAT-2285-----*/

    /**
     * Added by huy.huynh on 19/05/2017.
     * Scenarios : PLAT 2303 - Backend Undo
     */

    /**
     * get 'engagements' collection(table on mongo)
     */
    public DBCollection getEngagementCollection() {
        DBCollection dbCollection = null;
        try {
            //TODO move db config to properties file
            MongoDB db = new MongoDB("34.205.90.145", 27017, "TestDB");
            dbCollection = db.getCollection("auvenir", "engagements");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return dbCollection;
    }

    /**
     * get 'engagements' collection(table on mongo)
     */
    public DBCollection getUserCollection() {
        DBCollection dbCollection = null;
        try {
            //TODO move db config to properties file
            MongoDB db = new MongoDB("34.205.90.145", 27017, "TestDB");
            dbCollection = db.getCollection("auvenir", "users");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return dbCollection;
    }

    /**
     * verify 'completed' field of a To-Do in backend
     *
     * @param engagementField engagement field chosen as key
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status complete expected
     */
    public void verifyToDoCompleteBackend(String engagementField, String engagementValue, String todoName, String status) {
        getLogger().info("Verify To-Do complete status on database.");
        JSONObject jsonObject = MongoDB.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
        //TODO get from properties file
        if (jsonObject.get("completed").toString().equals(status)) {
            NXGReports.addStep("Verify To-Do complete status on database.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify To-Do complete status on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verify 'status' field of a To-Do
     *
     * @param engagementField engagement field chosen as key
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param assigneeName    name of assignee
     */
    public void verifyToDoAssignToBackend(String engagementField, String engagementValue, String todoName, String assigneeName) {
        getLogger().info("Verify To-Do delete status on database.");
        String idAssignee = MongoDB.getUserObjectByFirstNameLastName(getUserCollection(), assigneeName);
        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++idAssignee = " + idAssignee);

        JSONObject jsonObject = MongoDB.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++auditorAssignee = " + jsonObject.get("auditorAssignee").toString());

        //TODO get from properties file
        if (jsonObject.get("auditorAssignee").toString().contains(idAssignee)) {
            NXGReports.addStep("Verify To-Do complete status on database.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify To-Do complete status on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verify 'status' field of a To-Do
     *
     * @param engagementField engagement field chosen as key
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status delete expected
     */
    public void verifyToDoDeteteBackend(String engagementField, String engagementValue, String todoName, String status) {
        getLogger().info("Verify To-Do delete status on database.");
        JSONObject jsonObject = MongoDB.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++jsonObject = " + jsonObject.get("status"));
        //TODO get from properties file
        if (jsonObject.get("status").toString().equals(status)) {
            NXGReports.addStep("Verify To-Do delete status on database.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify To-Do delete status on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**-----end of huy.huynh PLAT-2303-----*/
}

