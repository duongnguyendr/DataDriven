package com.auvenir.ui.pages.auditor;

//import library

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.pages.common.PopUpPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.extentionLibraries.DatePicker;
import com.itextpdf.text.pdf.PdfName;
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

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.sql.rowset.spi.SyncFactoryException;
import com.auvenir.utilities.extentionLibraries.DatePicker;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class AuditorCreateToDoPage extends AbstractPage {

    public AuditorCreateToDoPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindAll(@FindBy(xpath = "//div[@class='e-widget-content']//div[@class='e-widget-options']"))
    private List<WebElement> planningEngagementPage;

    private String todoNamePage = "";
    private String todoContentTextSearch = "name";
    public static final int smallTimeOut = 2000;
    private String todoPageAddRequestImg = "//*[@id='todo-table']/tbody/tr[1]/td[7]/img";
    private String todoPageAddRequestBtn = "//*[@id='add-request-btn']";
    private static final String todoPageAddRequestTxtFirst = "//*[@id='todoDetailsReqCont']/div[1]/input";
    private static final String todoPageAddRequestTxtSecond = "//*[@id='todoDetailsReqCont']/div[2]/input";
    private static final String closeAddNewRequestPopup = "//*[@id='auv-todo-details']/div[3]";
    private static final String deleteRequestMenuStr = "//*[@id='todoDetailsReqCont']/div[1]/span/div/div/a[1]";
    private static final String copyTaskMenuStr = "//*[@id='todoDetailsReqCont']/div[1]/span/div/div/a[2]";
    private static final String requestNotEmptyStr = "//p[contains(text(),'Request name must not be empty')]";
    private static final String chracterMoreThan100 = "//p[contains(text(),'Request name can not have more than 100 characters')]";
    private static final String todoDetailName  = "//*[@id='todoDetailsName']";
    private static final String displayImageInPopup = "img[src='../../images/icons/clipboard-yellow.png']";
    private static final String markCompletePopupCancelBtn = "//div[@class='ce-footerBtnHolder']/button[contains(text(),'Cancel')]";
    private static final String markCompletePopupArchiveBtn = "//div[@class='ce-footerBtnHolder']/button[contains(text(),'Archive')]";
    private static final String popUpWindowsToClose = "//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]";
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

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl']")
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

    @FindBy(xpath = "//div[@id='auv-todo-details']/input[@placeholder='Type a comment']")
    private WebElement typeCommentFieldEle;

    @FindBy(xpath = "//*[@id='comment-box']/p")
    private WebElement commentboxTitleEle;

    @FindBy(xpath = "//*[@id='comment-box']/p//span[@class='details-comment-count commentNumber']")
    private WebElement commentboxCountNumberEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']")
    private List<WebElement> listCommentItemEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']/img[contains(@class,'user-profile-pic')]")
    private List<WebElement> userIconCommenterEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']/p[contains(@class,'detCommentUser')]")
    private List<WebElement> userNameCommenterEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']/time[@class='comment-time']")
    private List<WebElement> commentTimeEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']/div[@class='detComment']")
    private List<WebElement> descriptionCommentEle;

    @FindBy(xpath = "//*[@id='comment-button']")
    private WebElement postCommentButton;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[1]/td[7]/img")
    private WebElement todoListAddNewRequestImg;

    @FindBy(xpath = "//*[@id='add-request-btn']")
    private WebElement totoPageAddRequestBtn;

    @FindBy (xpath = "//*[@id='todoDetailsReqCont']/div[1]/input")
    private WebElement findRequestEmpty1;

    @FindBy (xpath = "//*[@id='todoDetailsReqCont']/div[2]/input")
    private WebElement findRequestEmpty2;

    @FindBy (xpath = "//*[@id='todoDetailsName']")
    private WebElement popupToDoDetailName;

    @FindBy (xpath = "//p[contains(text(),'Request name must not be empty')]")
    private WebElement messageEmptyRequest;
    private String checkMarkToDoName = "";
    private String checkToDoNameAddNewRequest = "";
    @FindBy (xpath = "//*[@id='auv-todo-details']/div[3]")
    private WebElement closeAddNewRequest;
    @FindBy (xpath="//*[@id='todoDetailsReqCont']/div[1]/span/div")
    private WebElement deleteRequestBtn;
    @FindBy (xpath="//*[@id='todoDetailsReqCont']/div[1]/span/div/div/a[1]")
    private WebElement deleteRequestMenu;
    @FindBy (xpath="//*[@id='todoDetailsReqCont']/div[1]/span/div/div/a[2]")
    private WebElement copyTaskMenu;
    private String newRequest01 = "New request01 " + randomNumber();
    private String newRequest02 = "New request02 " + randomNumber();

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
            result = validateCssValueElement(toDoNameInputEle, "border", "1px solid rgb(89, 155, 161)");
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
            result = validateCssValueElement(toDoNameInputEle, "border", "1px solid rgba(253, 109, 71, 0.4)");
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
            clickElement(eleToDoSearchInput, "cick to eleToDoSearchInput");
            eleToDoSearchInput.sendKeys(maxLenghtString);
            eleToDoSearchInput.sendKeys(numberSequence);
            // Get the text from eleToDoSearchInput
            String txtSearchText = getTextByJavaScripts(eleToDoSearchInput, "eleToDoSearchInput");
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
        } catch (Exception e) {
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

    /**
     * Author: minh.nguyen
     */
    public void verifyAddNewCategoryPopupTitle() {
        verifyCategoryTitle();
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyNewCategoryNameTextbox() {
        verifyCategoryDefaultValue();
        verifyHoverClickCategoryName();
        verifyShowAllTextCategoryName();
        verifyCategoryNameRequiredData();
        verifyCategoryNameMaxLength();
        verifyCategoryNameInputNumber();
        verifyCategoryNameSpecialCharacter();
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyNewCategoryColorCombobox() {
        verifyCategoryColorAllQuantityColor();
        verifyChoosedCategoryColor();
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyNewCategoryCreateCancelButton() {
        verifyColorCategoryCancelButton();
        verifyColorCategoryCreateButton();
        verifyNotCompleteCreateCategory();
        verifyExistedCategory();
        verifyClickCategoryCancelButton();
    }

    public void createToDoTask(String toDoName) throws Exception {
        waitForClickableOfElement(createToDoBtnEle, "Create To Do Button");
        createToDoBtnEle.click();
        waitForJSandJQueryToLoad();
        createToDoNameTextBoxEle.sendKeys(toDoName);
        // Create new category
        createNewCategory("", "");
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

    /*
        Vien added new switch case 22/5/2017
    */
    public void createToDoTask(int numberOfNewCategories) throws Exception {
        getLogger().info("Run createToDoTask()");
        todoNamePage = "To-do name " + randomNumber();
        waitForClickableOfElement(createToDoBtnEle, "create todo button.");
        clickElement(createToDoBtnEle, "click to createToDoBtnEle");
        waitForClickableOfElement(createToDoNameTextBoxEle, "wait for eleIdToDoName");
        clickElement(createToDoNameTextBoxEle, "click to eleIdToDoName");
        createToDoNameTextBoxEle.sendKeys(todoNamePage);
        switch (numberOfNewCategories) {

            case 1:
                createNewCategory("", "");
            case 2:
                createNewCategory("", "");
                createNewCategory("", "");
                break;

            case 3:
                createNewCategory("", "");
                createNewCategory("", "");
                createNewCategory("", "");
                break;

            case 4:
                createNewCategory("", "");
                createNewCategory("", "");
                createNewCategory("", "");
                createNewCategory("", "");
                break;

        }

        waitForClickableOfLocator(By.id("due-date"));
        waitForClickableOfElement(dueDateFieldEle, "eleIdDueDate");
        clickElement(dueDateFieldEle, "click to eleIdDueDate");
        waitForClickableOfElement(dateItemonCalendarEle, "eleXpathChooseDate");
        clickElement(dateItemonCalendarEle, "click to eleXpathChooseDate");
        waitForClickableOfElement(eleBtnToDoAdd, "eleBtnToDoAdd");
        clickElement(eleBtnToDoAdd, "click to eleBtnToDoAdd");
        //Wait for new task is displayed.
        waitForClickableOfLocator(By.xpath(todoPageAddRequestImg));
    }

    public void verifyToDoNameInputLimitCharacter(int maxLength) throws Exception {
        waitForVisibleElement(toDoNameInputEle, "eleToDoNameInput");
        validateMaxlenght(toDoNameInputEle, "ToDo Name Input", maxLength);
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyToDoNameInputSpecialCharacter(String value) throws Exception {
        waitForVisibleElement(toDoNameInputEle, "eleToDoNameInput");
        sendKeyTextBox(toDoNameInputEle, value, "To Do Name Input");
        clickElement(dueDateFieldEle, "Due Date Field");
        waitForVisibleElement(toDoNameErrorLabelEle, "toDoNameErrorLabelEle");
        validateElementText(toDoNameErrorLabelEle, "Not a valid name.");
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyDisableToDoSaveIcon() {
        try {
            boolean result;
            waitForVisibleElement(toDoNameInputEle, "To Do Name Input");
            clearTextBox(toDoNameInputEle, "To Do Name Input");
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
            sendKeyTextBox(toDoNameInputEle,"Task01", "To Do Name Input");
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
        clickElement(eleToDoLnk, "To Do Link menu");
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
            waitForVisibleOfLocator(By.id("todo-search"));
            //Thread.sleep(smallTimeOut);
            clickElement(eleToDoSearchInput, "click to eleToDoSearchInput");
            clearTextBox(eleToDoSearchInput, "clear txtIdTodoSearch");
            //Thread.sleep(smallTimeOut);
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
            AbstractService.sStatusCnt++;
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
        waitForClickableOfLocator(By.xpath("//*[@class='ui dropdown category todo-bulkDdl ']"));
        clickElement(categoryDropdownEle, "click to categoryDropdownEle");
        waitForClickableOfElement(categoryOptionItemEle.get(0), "Category Option Item");
        clickElement(categoryOptionItemEle.get(0), "click to categoryOptionItemEle.get(0)");
        waitForClickableOfElement(dueDateFieldEle, "Due Date field");
        clickElement(dueDateFieldEle, "click to dueDateFieldEle");
        waitForClickableOfElement(dateItemonCalendarEle, "Date value");
        clickElement(dateItemonCalendarEle, "click to dateItemonCalendarEle");
        waitForVisibleElement(toDoSaveIconEle, "Save Icon");
        clickElement(toDoSaveIconEle, "click to toDoSaveIconEle");
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

    public void clickToBulkCompleteButton()
    {
        List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
        clickElement(menuBulkActionsDropdown.get(1), "Bulk complete button");
    }

    public void verifyShowConfirmPopupAndMarkTitle() {
        getLogger().info("Verify complete mark popup");
        try {
            clickToBulkCompleteButton();
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
            waitForVisibleOfLocator(By.cssSelector(displayImageInPopup));
            WebElement imageInPopup = getDriver().findElement(By.cssSelector(displayImageInPopup));
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
            waitForPresentOfLocator(By.xpath(markCompletePopupCancelBtn));
            isCheckColorCancelButton = validateCssValueElement(cancelMarkPopupBtn, backgroundColor, "rgba(151, 147, 147, 1)");
            isCheckColorCancelButton = validateCssValueElement(cancelMarkPopupBtn, color, "rgba(255, 255, 255, 1)");
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
            waitForPresentOfLocator(By.xpath(markCompletePopupArchiveBtn));
            isCheckColorCancelButton = validateCssValueElement(archiveMarkPopupBtn, backgroundColor, "rgba(89, 155, 161, 1)");
            isCheckColorCancelButton = validateCssValueElement(archiveMarkPopupBtn, color, "rgba(255, 255, 255, 1)");
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
            clickToBulkCompleteButton();
            waitForVisibleOfLocator(By.cssSelector(displayImageInPopup));
            WebElement closePopup = getDriver().findElement(By.cssSelector(displayImageInPopup));
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
            result = validateCssValueElement(deletedToDoButtonEle, "background-color", "rgba(241, 103, 57, 1)");
            Assert.assertTrue(result, "Background color of Delete To-Do button is NOT orange");
            result = validateCssValueElement(deletedToDoButtonEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text color of Delete To-Do button is NOT white");
            waitForVisibleElement(cancelDeletedToDoButtonEle, "Cancel delete To-Do button");
            result = validateCssValueElement(cancelDeletedToDoButtonEle, "background-color", "rgba(151, 147, 147, 1)");
            Assert.assertTrue(result, "Background color of Cancel delete To-Do button is NOT gray");
            result = validateCssValueElement(cancelDeletedToDoButtonEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text color of Cancel delete To-Do button is NOT white");
            NXGReports.addStep("Verify GUI Delete To-Dos popup is displayed successfully", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify GUI Delete To-Dos popup is displayed unsuccessfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickCancelButtonOnPopup() {
        getLogger().info("Click Cancel Button on PopUp windows.");
        WebElement popUpDiv = getDriver().findElement(By.xpath(popUpWindowsToClose));
        hoverElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");
        waitForClickableOfElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo Button");
        clickElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    public void clickCloseButtonOnPopup() {
        getLogger().info("Click Close Button on PopUp windows.");
        WebElement popUpDiv = getDriver().findElement(By.xpath(popUpWindowsToClose));
        hoverElement(closePopupBtnEle, "Close Delete ToDo button");
        waitForClickableOfElement(closePopupBtnEle, "Close Delete ToDo Button");
        clickElement(closePopupBtnEle, "Close Delete ToDo button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    public void verifyClickCloseMarkPopup() {
        verifyClickClosePopup();
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
		return findElementByAttributeValue(eleToDoNameRow, toDoName);
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

    @FindBy(xpath = "//div[@class = 'fl-a-container fl-a-container-show']/div[@class = 'fl-a-dismiss auvicon-line-circle-ex'] ")
    WebElement successToastMesCloseIconEle;

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
     * Click on trash icon
     */
    public void clickOnTrashIcon(){
        try {
            waitForVisibleElement(trashToDoBtnEle, "Trash ToDo icon");
            hoverElement(trashToDoBtnEle,"Hover trash icon ");
            clickElement(trashToDoBtnEle,"Click on trash icon");
            NXGReports.addStep("Click on trash ToDo icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Can not click on trash ToDo icon", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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
            // Get id delete row
            String idRow = getIdRowDelete(checkEmptyToDoListRow, checkEmptyToDoCompleteListRow,
                    eleToDoCheckboxRow, eleToDoCompleteCheckboxRow,
                    eleToDoRowList, eleToDoCompleteRowList);
            //verify delete confirm icon
            clickElement(trashToDoBtnEle, "Trash icon click");
            //verify popup
            PopUpPage popUpPage = new PopUpPage(getLogger(), getDriver());
            result = popUpPage.verifyGUIPopUpDelete(categoryTitleEle, centerDeleteToDoDescriptionEle,
                    cancelDeletedToDoButtonEle, deletedToDoButtonEle);
            if (!result) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("TestScript Failed: Verify gui of delete confirm popup in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            //verify close popup icon
            // Check row is delete out of list
            if (!checkEmptyToDoListRow) {
                result = checkRowIsDeleteOutOfToDoList(eleToDoRowList, idRow);
            }
            if (!checkEmptyToDoCompleteListRow && result) {
                result = checkRowIsDeleteOutOfToDoList(eleToDoCompleteRowList, idRow);
            }
            Assert.assertFalse(result, "Popup icon close does not work");
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
     * Check/Uncheck checkall check box
     * @param isCheck
     */
    public void checkOrUnCheckCheckAllCheckBox(boolean isCheck){
        try {
            waitForVisibleElement(eleCheckAllCheckBox,"'CheckAll' check box");
            hoverElement(eleCheckAllCheckBox,"Hover 'CheckAll' check box");
            if(isCheck){
                if(!eleCheckAllCheckBox.isSelected()){
                    clickElement(eleCheckAllCheckBox,"Check on 'CheckAll' checkbox");
                }else{
                    clickElement(eleCheckAllCheckBox,"Un check on 'CheckAll' checkbox");
                    clickElement(eleCheckAllCheckBox,"Check on 'CheckAll' checkbox");
                }
                NXGReports.addStep("Check on 'CheckAll' check box in ToDo page complete", LogAs.PASSED,null);
            }else{
                if(eleCheckAllCheckBox.isSelected()){
                    clickElement(eleCheckAllCheckBox,"Un Check on 'CheckAll' checkbox");
                }else{
                    clickElement(eleCheckAllCheckBox,"Un check on 'CheckAll' checkbox");
                    clickElement(eleCheckAllCheckBox,"Check on 'CheckAll' checkbox");
                }
                NXGReports.addStep("UnCheck on 'CheckAll' check box in ToDo page complete", LogAs.PASSED,null);
            }
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Can not check/uncheck 'CheckAll' check box in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify all check box is un check or check in ToDo list
     * @param isCheck true : check | false : un check
     */
    public void verifyAllCheckBoxIsCheckOrUnCheck(boolean isCheck){
        try {
            boolean result = true;
            boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            if (!checkEmptyToDoListRow) {
                result = checkAllCheckBoxIsCheckOrUnCheck(eleToDoCheckboxRow, isCheck);
            }
            if (!checkEmptyToDoCompleteListRow) {
                if (result)
                    checkAllCheckBoxIsCheckOrUnCheck(eleToDoCompleteCheckboxRow, isCheck);
            }
            Assert.assertTrue(result, "All checkbox do not check/uncheck");
            if(isCheck){
                NXGReports.addStep("All check box are check in ToDo page", LogAs.PASSED, null);
            }else{
                NXGReports.addStep("All check box are uncheck in ToDo page", LogAs.PASSED, null);
            }

        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            if(isCheck){
                NXGReports.addStep("TestScript Failed: All check box are not check in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }else{
                NXGReports.addStep("TestScript Failed: All check box are not uncheck in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        }
    }

    /**
     * Check/Uncheck checkall check box
     * @param isCheck
     */
    public void checkOrUnCheckAllCheckBox(boolean isCheck){
            boolean result = true;
            boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            // verify "CheckAll" check box is checked when all check box are check
            //// check all check box in ToDo page
            if (!checkEmptyToDoListRow) {
                result = checkAllCheckBox(eleToDoCheckboxRow, isCheck);
                if (result == false) {
                    if(isCheck){
                        NXGReports.addStep("TestScript Failed: can not check on all check box has not complete status in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }else{
                        NXGReports.addStep("TestScript Failed: can not uncheck on all check box has not complete status in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                    return;
                }
            }

            if (!checkEmptyToDoCompleteListRow) {
                result = checkAllCheckBox(eleToDoCompleteCheckboxRow, isCheck);
                if (result == false) {
                    if(isCheck){
                        NXGReports.addStep("TestScript Failed: can not check on all check box has complete status in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }else{
                        NXGReports.addStep("TestScript Failed: can not uncheck on all check box has complete status in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                    return;
                }
            }
            if(result){
                NXGReports.addStep("Check all check box in ToDo page", LogAs.PASSED, null);
            }else{
                NXGReports.addStep("Uncheck all check box in ToDo page", LogAs.PASSED, null);
            }
    }

    /**
     * Verify 'CheckAll' check box is check or uncheck
     * @param isCheck : true : check | false : uncheck
     */
    public void verifyCheckAllCheckBoxIsCheckOrUncheck(boolean isCheck){
            waitForVisibleElement(eleCheckAllCheckBox, "CheckAll check box");
            if(isCheck){
                if (!eleCheckAllCheckBox.isSelected()) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("TestScript Failed: CheckAll check box do not auto check in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    return;
                }
            }else{
                if (eleCheckAllCheckBox.isSelected()) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("TestScript Failed: CheckAll check box do not auto uncheck in ToDo page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    return;
                }
            }
            if(isCheck){
                NXGReports.addStep("'CheckAll' check box is check when check all check box in ToDo page", LogAs.PASSED, null);
            }else{
                NXGReports.addStep("'CheckAll' check box is uncheck when uncheck all check box in ToDo page", LogAs.PASSED, null);
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
                hoverElement(eleToDoCheckBoxList.get(0), "Hover on check box of ToDo has status not complete");
                clickElement(eleToDoCheckBoxList.get(0), "Click on check box of ToDo has status not complete");
            }
            idRow = eleToDoList.get(0).getAttribute("data-id");
        } else if (!checkToDoCompleteList && "".equals(idRow)) {
            waitForVisibleElement(eleToDoCompleteCheckBoxList.get(0), "Select check box of ToDo item has status complete");
            if (!eleToDoCompleteCheckBoxList.get(0).isSelected()) {
                hoverElement(eleToDoCompleteCheckBoxList.get(0), "Hover on check box of ToDo has status complete");
                clickElement(eleToDoCompleteCheckBoxList.get(0), "Click on check box of ToDo has status complete");
            }
            idRow = eleToDoCompleteList.get(0).getAttribute("data-id");
        }
        return idRow;
    }

    /**
     * get index of ToDo name in ToDo list
     * @param toDoName : ToDo need search
     * @return -1 : not found | index : if found
     */
    public int getIndexOfToDoItem(List<WebElement> eleDataRowList, String toDoName){
        for (int i = 0; i < eleDataRowList.size(); i++) {
            String actualAttributeValue = eleDataRowList.get(i).getAttribute("value").trim();
            if (actualAttributeValue.equals(toDoName)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Check ToDo item delete is exists in ToDo list
     * @param isExists : true : exists | false : not exists
     * @param todoName : ToDo name need check
     * @return true | false
     */
    public boolean checkToDoIsExists(boolean isExists, String todoName){
        getLogger().info("Select To Do Task Check Box by Name");
        int index = getIndexOfToDoItem(eleToDoNameRow,todoName);
        if(!isExists && index!= -1)
            return false;

        if(isExists && index == -1)
            return false;

        return true;

    }

    /**
     * Check ToDo item list delete is exists in ToDo list
     * @param isExists : true : exists | false : not exists
     * @param todoNameList : ToDo name list need check
     * @return
     */
    public boolean checkToDoListIsExists(boolean isExists, List<String> todoNameList){
        getLogger().info("Select To Do Task List Check Box by Name");
        for(int i=0; i<todoNameList.size(); i++){
            int index = getIndexOfToDoItem(eleToDoNameRow,todoNameList.get(i));
            if(!isExists && index!= -1)
                return false;

            if(isExists && index == -1)
                return false;
        }
        return true;
    }

    /**
     * Click on delete button in popup delete
     */
    public void clickOnDeleteButtonOnPopup() {
        waitForClickableOfElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
        clickElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
        clickDeleteButtonOnPopUp();
    }

    /**
     * Click on cancel button in popup delete
     */
    public void clickOnCancelButtonOnPopup() {
        waitForClickableOfElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
        clickElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
        clickCancelButtonOnPopup();

    }

    /**
     * Click on delete button in pop up
     */
    public void clickDeleteButtonOnPopUp(){
        getLogger().info("Click Delete Button on PopUp windows.");
        WebElement popUpDiv = getDriver().findElement(By.xpath("//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]"));
        hoverElement(deletedToDoButtonEle, "Delete ToDo button");
        waitForClickableOfElement(deletedToDoButtonEle, "Delete ToDo Button");
        clickElement(deletedToDoButtonEle, "Delete ToDo button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    /**
     * Check all ToDo item is delete
     * @return true : all is deleted | false : not delete all
     */
    public boolean checkAllToDoIsDelete(){
        if(!checkListIsEmpty(eleToDoRowList) || !checkListIsEmpty(eleToDoCompleteRowList)){
            return false;
        }
        return true;
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
    public DBCollection getEngagementCollection() throws SyncFactoryException {
        try {
            //TODO move db config to properties file
            return MongoDBService.getCollection("auvenir", "engagements");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get 'engagements' collection(table on mongo)
     */
    public DBCollection getUserCollection() throws SyncFactoryException {
        DBCollection dbCollection = null;
        try {
            //TODO move db config to properties file
            return MongoDBService.getCollection("auvenir", "users");
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
    public void verifyToDoCompleteBackend(String engagementField, String engagementValue, String todoName, String status) throws SyncFactoryException {
        getLogger().info("Verify To-Do complete status on database.");
        JSONObject jsonObject = MongoDBService.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
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
    public void verifyToDoAssignToBackend(String engagementField, String engagementValue, String todoName, String assigneeName) throws SyncFactoryException {
        getLogger().info("Verify To-Do delete status on database.");
        String idAssignee = MongoDBService.getUserObjectByFirstNameLastName(getUserCollection(), assigneeName);
        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++idAssignee = " + idAssignee);

        JSONObject jsonObject = MongoDBService.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
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
    public void verifyToDoDeteteBackend(String engagementField, String engagementValue, String todoName, String status) throws SyncFactoryException {
        getLogger().info("Verify To-Do delete status on database.");
        JSONObject jsonObject = MongoDBService.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
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

    public void verifyDefaultHintValueInputComment() {
        try{
            boolean result;
            final String defaultValueInputComment = "Type a comment";
            getLogger().info("Verify Default Hint Value Input Comment");
            waitForVisibleElement(typeCommentFieldEle,"Input Comment field.");
            validateDisPlayedElement(typeCommentFieldEle,"Input Comment field.");
            result = validateAttributeElement(typeCommentFieldEle,"placeholder", defaultValueInputComment);
            Assert.assertTrue(result, "Default Hint Value Input Comment is displayed unsuccessfully");
            NXGReports.addStep("Verify Default Hint Value Input Comment", LogAs.PASSED, null);
        }catch (AssertionError e){
            AbstractService.sStatusCnt++;
            getLogger().info("Default Hint Value Input Comment is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Default Hint Value Input Comment", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Added by duong.nguyen on 22/05/2017.
     * Scenarios : PLAT 2305 - Backend Mark as complete
     * verify 'completed' field of a To-Do
     *
     * @param engagementField engagement field chosen as key
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status update expected
     */
    public void verifyMarkAsCompleteBackend(String engagementField, String engagementValue, String todoName, String status) throws SyncFactoryException {
        getLogger().info("Verify Completed field updated on database.");
//        JSONObject jsonObject = MongoDB.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
        JSONObject jsonObject = MongoDBService.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
        if (jsonObject.get("completed").toString().equals(status)){
            NXGReports.addStep("Verify Completed field updated on database.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Completed field updated on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void verifyCancelCompleteMarkPopup() {
        verifyShowConfirmPopupAndMarkTitle();
        verifyDisplayImageInPopup();
        verifyMarkPopupColorCancelBtn();
        clickCancelButtonOnPopup();
    }
    /**-----end of duong.nguyen PLAT-2305-----*/

    public void verifyGUIBoxTitleComment() {
        getLogger().info("Verify Box's Title Comment");
        try {
            boolean result;
            final String count;
            if(!listCommentItemEle.isEmpty())
                count = "" + listCommentItemEle.size();
            else
                count = "0";
            final String defaultBoxTitleComment = "Comments" + "\n" + count;
            waitForVisibleElement(commentboxTitleEle, "Comment Box Title.");
            validateDisPlayedElement(commentboxTitleEle, "Comment Box Title.");
            result = validateElementText(commentboxCountNumberEle, count);
            Assert.assertTrue(result, "Box's Title Count Number Comment is displayed unsuccessfully");
            result = validateElementText(commentboxTitleEle, defaultBoxTitleComment);
            Assert.assertTrue(result, "Box's Title Comment is displayed unsuccessfully");
            NXGReports.addStep("Verify Box's Title Comment", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify Box's Title Comment", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGUICommentList(String commentContent) {
        try {
            boolean result;
            getLogger().info("Verify GUI of Comment List");
            final String currentDay = "" + getDate(0, "EEEE, MMM dd") + getCurrentDayNumberSuffix();
            waitForVisibleElement(userIconCommenterEle.get(userIconCommenterEle.size() - 1), "User Icon of Commenter");
            result = validateDisPlayedElement(userIconCommenterEle.get(userIconCommenterEle.size() - 1), "User Icon of Commenter");
            Assert.assertTrue(result, "User Icon of Commenter is displayed unsuccessfully");
            validateDisPlayedElement(userNameCommenterEle.get(userNameCommenterEle.size() - 1), "User Name of Commenter");
            result = validateElementText(userNameCommenterEle.get(userNameCommenterEle.size() - 1), getCurrentUserNameLogOn());
            Assert.assertTrue(result, "User Name Commenter is displayed unsuccessfully");
            result = validateCssValueElement(userNameCommenterEle.get(userNameCommenterEle.size() - 1), "font-weight", "bold");
            Assert.assertTrue(result, "User Name Commenter is NOT displayed with Bold text.");
            validateDisPlayedElement(commentTimeEle.get(commentTimeEle.size() - 1), "Time of Comment Field.");
            result = validateElementText(commentTimeEle.get(commentTimeEle.size() - 1), currentDay);
            Assert.assertTrue(result, "Time of Comment Field is displayed unsuccessfully.");
            result = verifyCommentContentIsDisplayed(commentContent);
            Assert.assertTrue(result, "Content of Comment is displayed unsuccessfully.");
            NXGReports.addStep("Verify GUI of Comment List", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify GUI of Comment List", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public boolean verifyCommentContentIsDisplayed(String commentContent) {
        try {
            boolean result;
            getLogger().info("Verify Comment Content is displayed");
            validateDisPlayedElement(descriptionCommentEle.get(descriptionCommentEle.size() - 1), "Comment Content Field");
            result = validateElementText(descriptionCommentEle.get(descriptionCommentEle.size() - 1), commentContent);
            Assert.assertTrue(result, "Comment Content is displayed unsuccessfully.");
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            return false;
        }
    }

    public boolean verifyInputAComment(String commentContent) {
        try {
            boolean result;
            getLogger().info("Verify Input a Comment");
            waitForVisibleElement(typeCommentFieldEle, "Input Comment field");
            sendKeyTextBox(typeCommentFieldEle, commentContent, "Input Comment field");
            result = validateAttributeElement(typeCommentFieldEle, "value", commentContent);
            Assert.assertTrue(result, "Input a Comment is unsuccessfully");
            NXGReports.addStep("Verify Input Comment", LogAs.PASSED, null);
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify Input a Comment", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public void clickPostComment() {
        getLogger().info("Click Post Comment Button");
        waitForVisibleElement(postCommentButton, "Comment Input field");
        clickElement(postCommentButton, "Comment Input field");
    }

    public int getNumberOfListComment() {
        getLogger().info("Get Number of List Comment.");
        if(listCommentItemEle.isEmpty()){
            return 0;
        } else {
            return listCommentItemEle.size();
        }
    }

    public boolean verifyNewCommentIsDisplayed(int numberListCommentBeforeAdding, String commentContent) {
        try {
            boolean result;
            getLogger().info("Verify New Comment is displayed");
            int count = numberListCommentBeforeAdding + 1;
            result = waitForSizeListElementChanged(listCommentItemEle, "List Comment", count);
            Assert.assertTrue(result, "No New Comment is displayed.");
            result = verifyCommentContentIsDisplayed(commentContent);
            Assert.assertTrue(result, "Content of comment is NOT displayed.");
            NXGReports.addStep("Verify New Comment Is Displayed", LogAs.PASSED, null);
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify New Comment Is Displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public void verifyClickOnInputCommentField() {
        try {
            boolean result;
            getLogger().info("Verify click on Input Comment Field - Border color change to green");
            waitForVisibleElement(typeCommentFieldEle, "Input Comment field");
            clickElement(typeCommentFieldEle, "Input Comment field");
            result = validateCssValueElement(typeCommentFieldEle, "border", "1px solid rgb(92, 155, 160)");
            Assert.assertTrue(result, "Border color of Input Comment is NOT changed to green.");
            NXGReports.addStep("Verify click on Input Comment Field", LogAs.PASSED, null);

        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify click on Input Comment Field", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyUserInputNoContentComent() {
        try {
            boolean result;
            final String noContentWarning = "Comment content must not be empty";
            getLogger().info("Verify User Input No Content Comment");
            waitForVisibleElement(typeCommentFieldEle, "Input Comment field");
            clearTextBox(typeCommentFieldEle, "Input Comment field");
            clickPostComment();
            result = verifyContentOfWarningToastMessage(noContentWarning);
            Assert.assertTrue(result, "Content of warning message is displayed unsuccessfully.");
            NXGReports.addStep("Verify User Input No Content Comment", LogAs.PASSED, null);

        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify User Input No Content Comment", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public boolean verifyInputMaxLenghtContentComment(int maxLength) {
        try {
            boolean result;
            final String inputTextWithMaxLength = randomCharacters(maxLength);
            getLogger().info("Verify input a comment with max length with " + maxLength + " characters");
            verifyInputAComment(inputTextWithMaxLength);
            int numberOfListBefore = getNumberOfListComment();
            clickPostComment();
            result = verifyNewCommentIsDisplayed(numberOfListBefore, inputTextWithMaxLength);
            Assert.assertTrue(result, String.format("Cannot input max length %d characters", maxLength));
            NXGReports.addStep("Input a comment with max length with " + maxLength + "character", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            AbstractService.sStatusCnt++;
            getLogger().info(error);
            NXGReports.addStep("TestScript Failed: Input a comment with max length with " + maxLength + "character", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public boolean verifyInputSpecialCharactersContentComment() {
        try {
            boolean result;
            final String specialCharacters = "~!@#$%^&*+?><,.";
            getLogger().info("Verify input a comment with special characters.");
            verifyInputAComment(specialCharacters);
            int numberOfListBefore = getNumberOfListComment();
            clickPostComment();
            result = verifyNewCommentIsDisplayed(numberOfListBefore, specialCharacters);
            Assert.assertTrue(result, String.format("Cannot input a comment with special characters '%s'", specialCharacters));
            NXGReports.addStep("Verify input a comment with special characters.", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            AbstractService.sStatusCnt++;
            getLogger().info(error);
            NXGReports.addStep("TestScript Failed: Verify input a comment with special characters.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public void verifyGUIPostButton() {
        try {
            getLogger().info("Verifying GUI Post button");
            boolean result;
            validateDisPlayedElement(postCommentButton, "Post Button");
            result = validateCssValueElement(postCommentButton, "background-color", "rgba(89, 155, 161, 1)");
            Assert.assertTrue(result, "The background color of the Post button is displayed unsuccessfully.");
            validateCssValueElement(postCommentButton, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "The text color of the Post button is displayed unsuccessfully.");
            NXGReports.addStep("Verifying GUI Post button", LogAs.PASSED, null);
        } catch (AssertionError error) {
            getLogger().info(error);
            NXGReports.addStep("TestScript Failed: Verifying GUI Post button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     * Author minh.nguyen
     */
    public void verifyAddNewRequest()
    {
        verifyPopupColorAddRequestBtn();
        verifyClickAddRequestBtn();
        verifyDefaultToDoNameNewRequestPopup();
        verifyShowAllTextNewRequestPopup();
        verifyMaxLengthNewRequestPopup();
        verifyEmptyNewRequestPopup();
        verifyInputNumberToNewRequestPopup();
        verifyNewRequestStoreInDatabase();
        verifyUpdateRequestStoreInDatabase();
    }
    /**
     * Author minh.nguyen
     */
    public void clickToDoListAddNewRequest() throws InterruptedException {
        // Need to use Thread.sleep that support stable scripts
        checkToDoNameAddNewRequest = textToDoName.get(0).getAttribute("value").toString();
        waitForVisibleOfLocator(By.xpath(todoPageAddRequestImg));
        waitForClickableOfLocator(By.xpath(todoPageAddRequestImg));
        waitForClickableOfElement(todoListAddNewRequestImg);
        Thread.sleep(smallerTimeOut);
        clickElement(todoListAddNewRequestImg, "click to todoListAddNewRequestImg");
    }
    /**
     * Author minh.nguyen
     */
    public void verifyPopupColorAddRequestBtn()
    {
        getLogger().info("Verify the background and text color of the Add request button.");
        boolean isCheckColor = false;
        try {
            clickToDoListAddNewRequest();
            isCheckColor = verifyColorBackgroundTextBtn(totoPageAddRequestBtn, "rgba(151, 147, 147, 1)", "rgba(255, 255, 255, 1)");
            if(isCheckColor)
            {
                NXGReports.addStep("Verify to click the add request button and show the empty request", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the background and text color of the Add request button.", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the background and text color of the Add request button.", LogAs.FAILED, null);
        }
    }
    /**
     * Author minh.nguyen
     */
    public void verifyClickAddRequestBtn()
    {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to click the add request button and show the empty request");
        boolean isCheckRequestEmpty = false;
        try {
            waitForClickableOfLocator(By.xpath(todoPageAddRequestBtn));
            Thread.sleep(smallerTimeOut);
            clickElement(totoPageAddRequestBtn, "click to totoPageAddRequestBtn");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            waitForClickableOfElement(findRequestEmpty1, "wait for findRequestEmpty1");
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1);
            clickElement(totoPageAddRequestBtn);
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            isCheckRequestEmpty = clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            if(isCheckRequestEmpty)
            {
                NXGReports.addStep("Verify to click the add request button and show the empty request", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to click the add request button and show the empty request", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to click the add request button and show the empty request", LogAs.FAILED, null);
        }
    }
    /**
     * Author minh.nguyen
     */
    public void verifyDefaultToDoNameNewRequestPopup()
    {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify the default ToDo name on new request popup.");
        boolean isCheckColor = false;
        try {
            waitForVisibleOfLocator(By.xpath(todoDetailName));
            Thread.sleep(smallerTimeOut);
            clickElement(popupToDoDetailName, "click to popupToDoDetailName");
            String todoDetailText = getTextByJavaScripts(popupToDoDetailName, "popupToDoDetailName");
            clearTextBox(popupToDoDetailName,"clear popupToDoDetailName");
            String pleaseNameYourTodo = popupToDoDetailName.getAttribute("placeholder");
            getLogger().info("todoDetailText = " + todoDetailText);
            getLogger().info("pleaseNameYourTodo = " + pleaseNameYourTodo);
            if(todoDetailText.equals(checkToDoNameAddNewRequest) && pleaseNameYourTodo.equals("Please name your To-Do"))
            {
                isCheckColor = true;
            }
            if(isCheckColor)
            {
                NXGReports.addStep("Verify the default ToDo name on new request popup.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the default ToDo name on new request popup.", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the default ToDo name on new request popup.", LogAs.FAILED, null);
        }
    }
    /**
     * Author minh.nguyen
     */
    public void verifyShowAllTextNewRequestPopup()
    {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to show all text in the new request on popup.");
        boolean isCheckColor = false;
        try {
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            clearTextBox(findRequestEmpty1, "clear findRequestEmpty1");
            String enterRequestName = "Add new request " + randomNumber();
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            sendKeyTextBox(findRequestEmpty1, enterRequestName, "add text to findRequestEmpty1");
            String todoShowAllText = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            if(todoShowAllText.equals(enterRequestName))
            {
                isCheckColor = true;
            }
            if(isCheckColor)
            {
                NXGReports.addStep("Verify to show all text in the new request on popup.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to show all text in the new request on popup.", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to show all text in the new request on popup.", LogAs.FAILED, null);
        }
    }
    /**
     * Author minh.nguyen
     */
    public void verifyMaxLengthNewRequestPopup()
    {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify the max length of new request.");
        boolean isCheckMaxLength = false;
        try {
            boolean ischeckvalidateMaxlenght = validateMaxlenght(findRequestEmpty1, "findRequestEmpty1", 101);
            getLogger().info("ischeckvalidateMaxlenght = " + ischeckvalidateMaxlenght);
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            isCheckMaxLength = waitForVisibleOfLocator(By.xpath(chracterMoreThan100));
            getLogger().info("isCheckMaxLength = " + isCheckMaxLength);
            if(isCheckMaxLength)
            {
                NXGReports.addStep("Verify the max length of new request.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the max length of new request.", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the max length of new request.", LogAs.FAILED, null);
        }
    }
    /**
     * Author minh.nguyen
     */
    public void verifyEmptyNewRequestPopup()
    {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify the empty new request on popup.");
        boolean isCheckEmptyRequest = false;
        try {
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clearTextBox(findRequestEmpty1, "clear text of findRequestEmpty1");
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            isCheckEmptyRequest = waitForVisibleOfLocator(By.xpath(requestNotEmptyStr));
            getLogger().info("isCheckEmptyRequest = " + isCheckEmptyRequest);
            String emptyMessageAddRequest = messageEmptyRequest.getText();
            getLogger().info("emptyMessageAddRequest = " + emptyMessageAddRequest);
            if(emptyMessageAddRequest.equals("Request name must not be empty"))
            {
                NXGReports.addStep("Verify the empty new request on popup.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the empty new request on popup.", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the empty new request on popup.", LogAs.FAILED, null);
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyInputNumberToNewRequestPopup()
    {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to input number to new request in the add new request popup.");
        try {
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1);
            clearTextBox(findRequestEmpty1, "clear text of findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            sendKeyTextBox(findRequestEmpty1, numberSequence, "send number to findRequestEmpty1");
            String numberText = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            getLogger().info("numberText = " + numberText);
            if(numberText.equals(numberSequence))
            {
                NXGReports.addStep("Verify to input number to new request in the add new request popup.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to input number to new request in the add new request popup.", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to input number to new request in the add new request popup.", LogAs.FAILED, null);
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyNewRequestStoreInDatabase()
    {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify these new request are stored in the database.");
        try {
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            clearTextBox(findRequestEmpty1, "clear text of findRequestEmpty1");
            Thread.sleep(smallerTimeOut);
            sendKeyTextBox(findRequestEmpty1, newRequest01, "send data to findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            clearTextBox(findRequestEmpty2, "clear text of findRequestEmpty2");
            Thread.sleep(smallerTimeOut);
            sendKeyTextBox(findRequestEmpty2, newRequest02, "send data to findRequestEmpty2");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1);
            Thread.sleep(smallerTimeOut);
            String todoShowAllText01 = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            clickElement(findRequestEmpty2);
            Thread.sleep(smallerTimeOut);
            String todoShowAllText02 = getTextByJavaScripts(findRequestEmpty2, "findRequestEmpty2");
            clickElement(closeAddNewRequest, "click to closeAddNewRequest");
            clickToDoListAddNewRequest();
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1);
            Thread.sleep(smallerTimeOut);
            String todoShowAllText03 = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty2);
            Thread.sleep(smallerTimeOut);
            String todoShowAllText04 = getTextByJavaScripts(findRequestEmpty2, "findRequestEmpty2");
            if(todoShowAllText01.equals(todoShowAllText03) && todoShowAllText02.equals(todoShowAllText04))
            {
                NXGReports.addStep("Verify these new request are stored in the database.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify these new request are stored in the database.", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify these new request are stored in the database.", LogAs.FAILED, null);
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyUpdateRequestStoreInDatabase()
    {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to update these requests and these are stored in the database.");
        try {
            newRequest01 = "updated01";
            newRequest02 = "updated02";
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            sendKeyTextBox(findRequestEmpty1, newRequest01, "send data to findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            sendKeyTextBox(findRequestEmpty2, newRequest02, "send data to findRequestEmpty2");
            getLogger().info("Value findRequestEmpty2: " + findRequestEmpty2.getAttribute("value"));
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            Thread.sleep(smallerTimeOut);
            String todoShowAllText01 = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            Thread.sleep(smallerTimeOut);
            String todoShowAllText02 = getTextByJavaScripts(findRequestEmpty2, "findRequestEmpty2");
            waitForVisibleOfLocator(By.xpath(closeAddNewRequestPopup));
            clickElement(closeAddNewRequest, "click to closeAddNewRequest");
            clickToDoListAddNewRequest();
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            Thread.sleep(smallerTimeOut);
            String todoShowAllText03 = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            Thread.sleep(smallerTimeOut);
            String todoShowAllText04 = getTextByJavaScripts(findRequestEmpty2, "findRequestEmpty2");
            if(todoShowAllText01.equals(todoShowAllText03) && todoShowAllText02.equals(todoShowAllText04))
            {
                NXGReports.addStep("Verify to update these requests and these are stored in the database.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to update these requests and these are stored in the database.", LogAs.FAILED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to update these requests and these are stored in the database.", LogAs.FAILED, null);
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyDeleteRequestOnPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to delete a request on the popup.");
        boolean isCheckDeleteRequest = false;
        try {
            clickElement(deleteRequestBtn,"click to deleteRequestBtn");
            waitForClickableOfLocator(By.xpath(deleteRequestMenuStr));
            isCheckDeleteRequest = clickElement(deleteRequestMenu, "click to deleteRequestMenu");
            if(isCheckDeleteRequest)
            {
                NXGReports.addStep("Verify to delete a request on the popup.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to delete a request on the popup.", LogAs.FAILED, null);
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to delete a request on the popup.", LogAs.FAILED, null);
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyCopyTaskOnPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to copy a task on the popup.");
        boolean isCheckCopyRequest = false;
        try {
            clickElement(deleteRequestBtn,"click to deleteRequestBtn");
            waitForClickableOfLocator(By.xpath(copyTaskMenuStr));
            isCheckCopyRequest = clickElement(copyTaskMenu, "click to copyTaskMenu");
            if(isCheckCopyRequest)
            {
                NXGReports.addStep("Verify to copy a task on the popup.", LogAs.PASSED, null);
            }
            else
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to copy a task on the popup.", LogAs.FAILED, null);
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to copy a task on the popup.", LogAs.FAILED, null);
        }
    }

    /**
     * Create ToDo name list
     * @author : TanPham
     * @date : 29/05/2017
     */

    public List<String> createToDoNameList(String todoName, int numberToDo){
        List<String> toDoListNames = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        // Add one ToDo name
        for (int i = 0; i < numberToDo; i++) {
            toDoListNames.add(todoName + i + dateFormat.format(date));
        }

        return toDoListNames;
    }

    /**
     * -----end of huy.huynh PLAT-2303-----
     */

    /*
    Vien Pham add new method for PLAT 2326-2301
     */

    @FindBy(xpath = "//table [@id=\"todo-table\"]//input[@type=\"text\"]")
    List<WebElement> TodosTextboxEle;

    @FindBy(xpath = "//input [@id=\"cb-select-all-todo\"]")
    WebElement todoAllCheckbox;

    @FindBy(xpath = "//*[@id=\"btn-todo-trash\"]")
    WebElement todoTrashBtn;

    @FindBy(xpath = "//input [contains(@class,\"due\")]")
    List<WebElement> newDueDateEle;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown category')]")
    List<WebElement> DropdownCategoryEle;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown client')]")
    List<WebElement> DropdownClientAssignee;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown auditor')]")
    List<WebElement> DropdoownAuditAssignee;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]//div[@class=\"item\"]")
    List<WebElement> listOfCategoryItemsDropdown;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]//div[contains(@class,\"ui dropdown client\")]//div[contains(@class,\"menu\")]/button[@class=\"item\"]")
    List<WebElement> listOfClientAssigneesDropdown;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]//div[contains(@class,\"ui dropdown audit\")]//button[@class=\"item\"]")
    List<WebElement> listOfAuditAssigneeDropdown;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]//input[contains(@class,\"input-due-date\")]")
    WebElement DropdownDuedateBtn;

    @FindBy(xpath = "//div[@id=\"ui-datepicker-div\"]")
    WebElement TableOfDatePicker;


    @FindBy(xpath = "//div[@id=\"ui-datepicker-div\"]//span[contains(@class,\"month\")]")
    WebElement Month;

    @FindBy(xpath = "//div[contains(@class,\"ui-datepicker\")]/a[1]")
    WebElement PrevBtn;
    @FindBy(xpath = "//div[contains(@class,\"ui-datepicker\")]/a[2]")
    WebElement NextBtn;

    @FindBy(xpath = "//span[contains(text(),'© 2017 Auvenir Inc')]")
    private WebElement eleAuvenirIncTxt;

    @FindBy(id = "engagement-backButton")
    WebElement engagementBackBtn;


    public void verifyTodoTextbox_DefaultValue() {
        getLogger().info("Verifying Untitle Todo text...");
        String title = "Untitled Todo";
        try {
            validateDisPlayedElement(TodosTextboxEle.get(0), "Todos Textbox");
            if (TodosTextboxEle.get(0).getAttribute("value").equals(title)) {
                NXGReports.addStep("Untitle Todo displayed as expected.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Untitle Todo does not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            }

        } catch (Exception e) {
            NXGReports.addStep("Untitle Todo does not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyFirstTodoTextbox_PlaceHolderValue() {
        getLogger().info("Verifying Hint text on first todo...");
        String firstHintValue = "Write your first To-Do here";

        try {
            if (TodosTextboxEle.get(0).getAttribute("placeholder").equals(firstHintValue)) {
                NXGReports.addStep("PlaceHolder value exist as expected.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("PlaceHolder value not exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            NXGReports.addStep("PlaceHolder value not exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifySecondTodoTextbox_PlaceHolderValue() {
        getLogger().info("Verify Hint text on second todo...");
        String secondHintValue = "Write your To-Do here";

        try {
            createToDoBtnEle.click();
            Thread.sleep(smallerTimeOut);
            String value1 = TodosTextboxEle.get(1).getAttribute("placeholder");
            if (value1.equals(secondHintValue)) {
                NXGReports.addStep("PlaceHolder value exist as expected.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("PlaceHolder value not exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            NXGReports.addStep("PlaceHolder value not exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    public void verifyTodoTextboxBorder_Default() {
        WebElement textbox1 = TodosTextboxEle.get(0);
        getLogger().info("Verifying border of todo Textbox default is white...");
        String deFaultBorder = "1px solid rgb(255, 255, 255)";
        try {
            validateCSSValueElement(textbox1, "border", deFaultBorder);
            NXGReports.addStep("Default border is White as expected.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Default border is not White.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }


    }

    public void verifyTodoTextboxBorder_WhileHovered() {
        WebElement textbox1 = TodosTextboxEle.get(0);
        String GreenBorder = "rgb(92, 155, 160)";
        getLogger().info("Verifying border of todo Textbox is Green while hovered...");
        try {
            hoverElement(textbox1, "Todos Textbox");
            validateCSSValueElement(textbox1, "border-color", GreenBorder);
            NXGReports.addStep("Border is Green while hovered on it.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Border is not Green while hovered on it.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyTodoTextboxBorder_WhileMissedName() {

        String OrangeBorder = "1px solid rgba(253, 109, 71, 0.4)";
        try {
            WebElement textbox1 = TodosTextboxEle.get(0);
            getLogger().info("Clear todo Textbox...");
            sendKeyTextBox(textbox1, nullChars, "Todos Textbox");
            getLogger().info("Click anywhere...");
            clickElement(todoTrashBtn, "todo Trash Btn");
            getLogger().info("Verifying border of todo Textbox is Orange while missed name or not...");
            validateCSSValueElement(textbox1, "border", OrangeBorder);
            NXGReports.addStep("Border is Orange while missed name as expected.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Border is not Orange while missed name.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    public void verifyTodoTextbox_InputText() {
        String deFaultBorder = "1px solid rgb(255, 255, 255)";
        String GreenBorder = "1px solid rgb(92, 155, 160)";
        String value1 = "To-do" + randomNumber();

        try {
            Thread.sleep(smallerTimeOut);
            WebElement textbox1 = TodosTextboxEle.get(0);
            getLogger().info("Verifying while user input valid text, textbox border is green...");
            sendKeyTextBox(textbox1, value1, "Todos Textbox");
            validateCSSValueElement(textbox1, "border", GreenBorder);
            getLogger().info("Click anywhere to verify textbox border is White..");
            clickElement(todoTrashBtn, "todo Trash Btn");
            validateCSSValueElement(textbox1, "border", deFaultBorder);
            getLogger().info("Verify valid value was saved or not...");
            if (textbox1.getAttribute("value").equals(value1)) {
                NXGReports.addStep("Valid Todo name was saved as expected.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Valid Todo name was not saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            }
        } catch (Exception e) {

            NXGReports.addStep("Valid Todo name was not saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyTodoTextbox_MissingInput() {
        String valueName = TodosTextboxEle.get(0).getAttribute("value");
        try {
            Thread.sleep(smallerTimeOut);
            verifyTodoTextboxBorder_WhileMissedName();
            getLogger().info("Verifing null value was saved or not...");
            if (!valueName.equals(nullChars)) {
                NXGReports.addStep("Null Todo name was not saved as expected.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Null Todo name was saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            NXGReports.addStep("Null Todo name was saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyTodoTextbox_InputNumber() {
        String deFaultBorder = "1px solid rgb(255, 255, 255)";
        String GreenBorder = "1px solid rgb(92, 155, 160)";
        Integer value1 = randomNumber();


        try {
            getLogger().info("Verifying while user input valid number textbox border is green...");
            Thread.sleep(smallerTimeOut);
            WebElement textbox1 = TodosTextboxEle.get(0);
            sendKeyTextBox(textbox1, value1.toString(), "Todos Textbox");
            validateCSSValueElement(textbox1, "border", GreenBorder);
            getLogger().info("Click anywhere to verify textbox border is White..");
            clickElement(todoTrashBtn, "todo Trash Btn");
            validateCSSValueElement(textbox1, "border", deFaultBorder);
            getLogger().info("Verify valid number was saved or not...");
            if (textbox1.getAttribute("value").equals(value1.toString())) {
                NXGReports.addStep("Number as Todo Name was saved as expected.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Number as Todo name was not saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            }
        } catch (Exception e) {

            NXGReports.addStep("Number as Todo name was not saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }


    public void verifyTodoTextbox_InputSpecialChars() {
        String OrangeBorder = "1px solid rgba(253, 109, 71, 0.4)";
        try {
            int count = TodosTextboxEle.size() + 1;
            clickElement(createToDoBtnEle, "Create todo btn");
            getLogger().info("Verifying while user input special char, textbox border is orange...");
            waitForSizeListElementChanged(TodosTextboxEle, "list To Do Task", count);
            WebElement textbox1 = TodosTextboxEle.get(0);
            sendKeyTextBox(textbox1, specialCharacter, "Todos Textbox");
            validateCSSValueElement(textbox1, "border", OrangeBorder);
            getLogger().info("Create new Todo textbox...");
            count = TodosTextboxEle.size() + 1;
            clickElement(createToDoBtnEle, "Create todo btn");
            waitForSizeListElementChanged(TodosTextboxEle, "list To Do Task", count);
            WebElement textbox2 = TodosTextboxEle.get(1);
            getLogger().info("Verifying special chars was saved or not...");
            if (!specialCharacter.equals(textbox2.getAttribute("value"))) {
                NXGReports.addStep("Special chars was not saved as expected.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Special chars was saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("Special chars was saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyCategoryBox_DefaultValue() {
        String defaultValue = "Select";
        try {
            Thread.sleep(500);
            if (DropdownCategoryEle.get(0).getText().equals(defaultValue)) {
                NXGReports.addStep("Default value of CategoryBox is Select.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Default value of CategoryBox is not Select.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            NXGReports.addStep("Default value of CategoryBox is not Select.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyBorderCategoryBox_WhileHovered() {
        String GreenBorder = "1px solid rgb(92, 155, 160)";
        try {
            hoverElement(DropdownCategoryEle.get(0), "Category Dropdown Menu");
            validateCSSValueElement(DropdownCategoryEle.get(0), "border", GreenBorder);
            NXGReports.addStep("Border of Categorybox is Green when hovered.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Border of Categorybox is not Green when hovered.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyAddNewCategory() {
        try {
            createNewToDoTask(2);
            NXGReports.addStep("Add new Category successfully.", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Add new Category failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    public void verifyCategoryIsSelectedCorrectly() {
        try {
            clickElement(DropdownCategoryEle.get(0), "CategoryDropdown");
            String value1 = listOfCategoryItemsDropdown.get(0).getText();
            clickElement(listOfCategoryItemsDropdown.get(0), "");
            Thread.sleep(smallerTimeOut);
            String value2 = DropdownCategoryEle.get(0).getText();
            if (value1.equals(value2)) {
                NXGReports.addStep("Category is selected successfully.", LogAs.PASSED, null);

            } else {
                NXGReports.addStep("Category is selected failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            }

        } catch (Exception e) {
            NXGReports.addStep("Category is selected failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }


    }

    public void createNewToDoTask(int numberOfNewCategories) throws Exception {
        getLogger().info("Run createToDoTask()");

        int count = TodosTextboxEle.size() + 1;
        clickElement(createToDoBtnEle, "Create To Do Button");
        todoNamePage = "To-do name " + randomNumber();
        waitForSizeListElementChanged(TodosTextboxEle, "To Do Name Task", count);
        sendKeyTextBox(TodosTextboxEle.get(0), todoNamePage, "Todos Textbox");
        switch (numberOfNewCategories) {

            case 1:
                createNewCategory("", "");
                break;
            case 2:
                createNewCategory("", "");
                createNewCategory("", "");
                break;

            case 3:
                createNewCategory("", "");
                createNewCategory("", "");
                createNewCategory("", "");
                break;

            case 4:
                createNewCategory("", "");
                createNewCategory("", "");
                createNewCategory("", "");
                createNewCategory("", "");
                break;

        }

    }

    public void verifyClientAssignee_DefaultValue() {
        String defaultValue = "Unassigned";
        try {
            Thread.sleep(500);
            if (DropdownClientAssignee.get(0).getText().equals(defaultValue)) {
                NXGReports.addStep("Default value of Assignee is Select.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Default value of Assignee is not Select.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            NXGReports.addStep("Default value of Assignee is not Select.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyBorderClientAssignee_WhileHovered() {

        String GreenBorder = "1px solid rgb(92, 155, 160)";
        try {
            hoverElement(DropdownClientAssignee.get(0), "Category Dropdown Menu");
            validateCSSValueElement(DropdownClientAssignee.get(0), "border", GreenBorder);
            NXGReports.addStep("Border of ClientAssigneebox is Green when hovered.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Border of ClientAssigneebox is not Green when hovered.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyClientAssigneeIsSelectedCorrectly() {
        try {
            getLogger().info("List of Client Assignee..");
            clickElement(DropdownClientAssignee.get(0), "ClientAssignee Dropdown");
            getLogger().info("the number of client assignee is: " + listOfClientAssigneesDropdown.size());
            getLogger().info("First client Assignee is: " + listOfClientAssigneesDropdown.get(0).getText());
            String value1 = listOfClientAssigneesDropdown.get(0).getText();
            getLogger().info("Trying to select First one..");
            clickElement(listOfClientAssigneesDropdown.get(0), "First client Assignee");
//            waitForClickableOfLocator(By.xpath(""));
            getLogger().info("Verifying selection is correctly..");
            Thread.sleep(smallerTimeOut);
            String value2 = DropdownClientAssignee.get(0).getText();
            if (value1.equals(value2)) {
                getLogger().info("after selected, client assignee is: " + value2);
                NXGReports.addStep("Client assignee is selected correctly.", LogAs.PASSED, null);

            } else {
                NXGReports.addStep("Client assignee is not selected correctly.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            System.out.println("error is: " + e);
            NXGReports.addStep("Client assignee is not selected correctly.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyBorderDuedate_WhileHovered() {
        String GreenBorder = "1px solid rgb(89, 155, 161)";
        try {
            hoverElement(DropdownDuedateBtn, "Duedate Dropdown Menu");
            validateCSSValueElement(DropdownDuedateBtn, "border", GreenBorder);
            NXGReports.addStep("Border of DueDate is Green when hovered.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Border of DueDate is not Green when hovered.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public WebElement getTableOfDataPicker() {
        return TableOfDatePicker;
    }

    public void verifyDuedateTable() {
//        DatePicker datePicker = new DatePicker();
        try {
            DropdownDuedateBtn.click();
            waitForCssValueChanged(TableOfDatePicker, "Date Picker Table", "display", "block");
            getLogger().info("Current Month is: " + Month.getText());
            Thread.sleep(2000);
//            datePicker.pickADate("12","5","2017");


//            verifyPrevFunction();
//            verifyNextFunction();

        } catch (Exception e) {


        }
    }

    public void verifyBorderAuditAssignee_WhileHoverd() {
        String GreenBorder = "1px solid rgb(89, 155, 161)";
        try {
            hoverElement(DropdownDuedateBtn, "Duedate Dropdown Menu");
            validateCSSValueElement(DropdownDuedateBtn, "border", GreenBorder);
            NXGReports.addStep("Border of AuditAssignee  is Green when hovered.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Border of AuditAssignee is not Green when hovered.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyAuditAssigneeIsSelectedCorrectly() {
        try {
            getLogger().info("List of Audit Assignee..");
            clickElement(DropdoownAuditAssignee.get(0), "AuditAssignee Dropdown");
            getLogger().info("the number of Audit assignee is: " + listOfAuditAssigneeDropdown.size());
            getLogger().info("First audit Assignee is: " + listOfAuditAssigneeDropdown.get(0).getText());
            String value1 = listOfAuditAssigneeDropdown.get(0).getText();
            getLogger().info("Trying to select First one..");
            clickElement(listOfAuditAssigneeDropdown.get(0), "First Audit Assignee");
//            waitForClickableOfLocator(By.xpath(""));
            getLogger().info("Verifying selection is correctly..");
            Thread.sleep(smallerTimeOut);
            String value2 = DropdoownAuditAssignee.get(0).getText();
            if (value1.equals(value2)) {
                getLogger().info("After selected, audit assignee is: " + value2);
                NXGReports.addStep("Audit assignee is selected correctly.", LogAs.PASSED, null);

            } else {
                NXGReports.addStep("Audit assignee is not selected correctly.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            System.out.println("error is: " + e);
            NXGReports.addStep("Audit assignee is not selected correctly.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }


    }


    public void vefifyInvalidTodoNameNotSaved(String invalidName) {
        AuditorEngagementPage auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        AuditorDetailsEngagementPage auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(),getDriver());
        String OrangeBorder = "1px solid rgba(253, 109, 71, 0.4)";
        try {
            WebElement textbox1 = TodosTextboxEle.get(0);
            getLogger().info("Click anywhere...");
            clickElement(eleAuvenirIncTxt, "Auvernir Inc");
            getLogger().info("Verifying border of todo Textbox is Orange while enter invalid values or not...");
            validateCSSValueElement(textbox1, "border", OrangeBorder);
            getLogger().info("Make sure invalid name is not saved after return to Todo list Page again...");
            getLogger().info("Back to Engagement page...");
            engagementBackBtn.click();
            getLogger().info("Return to Todo list page again..");
            auditorEngagementPage.viewEngagementDetailsPage("vienpham007");
            auditorDetailsEngagementPage.verifyDetailsEngagementPage("vienpham007");
            getLogger().info("Comparing...");
            String comparedValue = TodosTextboxEle.get(0).getAttribute("value");
            if (!comparedValue.equals(invalidName)){
                NXGReports.addStep("Invalid name is not saved as expected.", LogAs.PASSED, null);
            }else {
                NXGReports.addStep("Invalid name still be saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            }
        } catch (Exception e) {
            NXGReports.addStep("Invalid name still be saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }


}

