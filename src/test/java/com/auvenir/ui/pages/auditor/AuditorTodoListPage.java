package com.auvenir.ui.pages.auditor;

//import library

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AuditorTodoListPage extends AbstractPage {

    public AuditorTodoListPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "auv-todo-createToDo")
    private WebElement eleCreateToDoBtn;

    @FindBy(id = "todo-filter-dropdown")
    private WebElement eleFilterBtn;

    @FindBy(id = "todo-search")
    private WebElement eleToDoSearchInput;
    @FindBy(xpath = "//button[contains(text(),'Create To-Do')]")
    private WebElement createTodoTextEle;

    @FindBy(xpath = "//table[@id='todo-table']//..//..//th//input[@type='checkbox']")
    private WebElement eleCheckBox;

    @FindBy(xpath = "//th[@data-id='name']")
    private WebElement eleNameToDoTitleLabel;

    @FindBy(xpath = "//th[@data-id='name']//i")
    private WebElement eleSortByNameToDo;

    @FindBy(xpath = "//th[@data-id='categoryName']")
    private WebElement eleCategoryTitleLabel;

    @FindBy(xpath = "//th[@data-id='categoryName']//i")
    private WebElement eleSortByCategory;

    @FindBy(xpath = "//th[@data-id='clientAssigneeName']")
    private WebElement eleClientAssigneeTitleLabel;

    @FindBy(xpath = "//th[@data-id='clientAssigneeName']//i")
    private WebElement eleSortByClientAssignee;

    @FindBy(xpath = "//th[@data-id='dueDate']")
    private WebElement eleDueDateTitleLabel;

    @FindBy(xpath = "//th[@data-id='dueDate']//i")
    private WebElement eleSortByDueDate;

    @FindBy(xpath = "//th[@data-id='auditorAssigneeName']")
    private WebElement eleAuditAssigneeTitleLabel;
    @FindBy(xpath = "//th[@data-id='auditorAssigneeName']//i")
    private WebElement eleSortByAuditAssignee;


    @FindBy(xpath = "//tr[@id='empty-todo']//..//..//img")
    private WebElement eleImgEmtyToDo;

    @FindBy(xpath = "//tr[@id='empty-todo']//td//div//div")
    private WebElement eleNotesEmtyToDo;

    /*
    Filter elements
     */
    @FindBy(id = "filter-container")
    private WebElement eleFilterDropDownList;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Show All')]")
    private WebElement eleShowAllBTN;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Due Date')]")
    private WebElement eleDueDateBTN;
    @FindBy(xpath = "//*[@id='filter-container']//div[contains(text(),'Assigned')]")
    private WebElement eleAssignedBTN;
    @FindBy(xpath = "//*[@id='filter-container']//div[contains(text(),'Assigned')]//button")
    private List<WebElement> AssignValue;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'With Comments')]")
    private WebElement eleWithCommentBTN;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Complete')]")
    private WebElement eleCompleteBTN;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Outstanding')]")
    private WebElement eleOutstandingBTN;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Flagged For Request')]")
    private WebElement eleFlaggedForRequest;


    @FindBy(xpath = "//tr[@class=\"newRow\"]")
    List<WebElement> tableTodoList;

    /////////////////////////////////////////////////
    public void verifyTodoListPageColumnHeader() throws Exception {
        getLogger().info("verify create to do button.");
        verifyButtonCreateToDo();
        NXGReports.addStep("verify create to do button.", LogAs.PASSED, null);

        getLogger().info("verify filter button.");
        verifyFilterDropDownList();
        NXGReports.addStep("verify filter button.", LogAs.PASSED, null);

        getLogger().info("verify check on checkbox.");
        verifyCheckOnCheckBox();
        NXGReports.addStep("verify check on checkbox.", LogAs.PASSED, null);

        getLogger().info("verify uncheck on checkbox.");
        verifyUnCheckOnCheckBox();
        NXGReports.addStep("verify uncheck on checkbox.", LogAs.PASSED, null);

        getLogger().info("verify columns in gird.");
        verifyColumnsInGrid();
        NXGReports.addStep("verify columns in gird.", LogAs.PASSED, null);

        getLogger().info("verify icon sort on title.");
        verifySortOnTitle();
        NXGReports.addStep("verify icon sort on title.", LogAs.PASSED, null);

        getLogger().info("verify search hover.");
        verifySearchHover();
        NXGReports.addStep("verify search hover.", LogAs.PASSED, null);

        getLogger().info("verify input text for field search.");
        verifySearchInputText();
        NXGReports.addStep("verify input text for field search.", LogAs.PASSED, null);

        getLogger().info("verify input number for field search.");
        verifySearchInputNumber();
        NXGReports.addStep("verify input number for field search.", LogAs.PASSED, null);

        getLogger().info("verify default value(hint) field search.");
        verifySearchDefault();
        NXGReports.addStep("verify default value(hint) field search.", LogAs.PASSED, null);


    }

    /*
    Vien.Pham changed Boolean for verifyEmptyTodoList.
     */
    public void verifyEmptyTodoList() throws Exception {
        waitForVisibleElement(eleImgEmtyToDo, "Empty Todo Image");
        validateDisPlayedElement(eleImgEmtyToDo, "Empty Todo Image");
        waitForVisibleElement(eleNotesEmtyToDo, "Empty Todo Note");
        validateDisPlayedElement(eleNotesEmtyToDo, "Empty Todo Note");
    }


    public void verifyButtonCreateToDo() throws Exception {
        validateCssValueElement(eleCreateToDoBtn, "background-color", "rgba(89, 155, 161, 1)");
        validateCssValueElement(eleCreateToDoBtn, "color", "rgba(255, 255, 255, 1)");
        validateDisPlayedElement(eleCreateToDoBtn, "Create Todo Button");

    }

    public void verifyButtonFilter() throws Exception {
        validateDisPlayedElement(eleFilterBtn, "Filter button");
    }

    public void verifySearchDefault() throws Exception {
        validateAttributeElement(eleToDoSearchInput, "placeholder", "Search...");
    }

    public void verifySearchHover() throws Exception {
        clickAndHold(eleToDoSearchInput, "Search Button");
        waitForPresentOfLocator(By.xpath("//input[@id='todo-search']"));

        validateCssValueElement(eleToDoSearchInput, "border-color", "rgb(89, 155, 161)");
    }

    public void verifySearchInputText() throws Exception {
        enterSearchToDoTask("To do task name");
        validateAttributeElement(eleToDoSearchInput, "value", "To do task name");
    }


    public void verifySearchInputNumber() throws Exception {
        enterSearchToDoTask("123");
        validateAttributeElement(eleToDoSearchInput, "value", "123");
    }


    public void verifyColumnsInGrid() throws Exception {
        validateElementText(eleNameToDoTitleLabel, "To-Dos");
        validateElementText(eleCategoryTitleLabel, "Category");
        validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
        validateElementText(eleDueDateTitleLabel, "Due Date");
        validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
    }


    public void verifySortOnTitle() throws Exception {
        validateDisPlayedElement(eleSortByNameToDo, "Sort By name");
        validateDisPlayedElement(eleSortByClientAssignee, "Sort By Client Assignee");
        validateDisPlayedElement(eleSortByDueDate, "Sort By due Date");
        validateDisPlayedElement(eleSortByAuditAssignee, "Sort By Auditor Assignee");
    }

    public void verifyCheckOnCheckBox() throws Exception {
        checkAllToDoTask();
        waitForPresentOfLocator(By.xpath("//table[@id='todo-table']//..//..//th//input[@type='checkbox']"));
        validateCssValueElement(eleCheckBox, "background-color", "rgba(92, 212, 192, 1)");
    }

    public void verifyUnCheckOnCheckBox() throws Exception {
        unCheckAllToDoTask();
        waitForPresentOfLocator(By.xpath("//table[@id='todo-table']//..//..//th//input[@type='checkbox']"));
        validateCssValueElement(eleCheckBox, "background-color", "rgba(202, 206, 206, 1)");
    }

    public void clickCreateToDoBtn() throws Exception{
        // Create todo button could sleep before click, investigate in-progress.
//        Thread.sleep(smallTimeOut);
//        waitForClickableOfElement(eleCreateToDoBtn);
        waitForTextValueChanged(eleCreateToDoBtn,"Create Todo Butto","Create To-Do");
        clickElement(eleCreateToDoBtn, "Create Todo Button");
    }

    public void checkAllToDoTask() {
        if (!eleCheckBox.isSelected()) {
            clickOnCheckBox(eleCheckBox, "All Check Box");
        }
    }

    public void unCheckAllToDoTask() {
        if (eleCheckBox.isSelected()) {
            clickOnCheckBox(eleCheckBox, "CheckBox");
        }
    }

    public void enterSearchToDoTask(String searchValue) {
        sendKeyTextBox(eleToDoSearchInput, searchValue, "Search Field");
    }

    public void clickSortByNameToDoTask() {
        clickElement(eleSortByNameToDo, "Sort By Name");
    }

    public void clickSortByAuditAssignee() {
        clickElement(eleSortByAuditAssignee, "Sort By auditor Assignee");
    }

    public void clickSortByCategory() {
        clickElement(eleSortByCategory, "Sort by Category");
    }

    public void clickSortByDueDate() {
        clickElement(eleSortByDueDate, "Sort By Due Date");
    }

    public void clickSortByClientAssignee() {
        clickElement(eleSortByClientAssignee, "Sort By client assignee");
    }


    public void verifyTodoListPage() {
        //waitForClickableOfElement(eleCreateToDoBtn,"Create Todo button");
        //validateElementText(eleCreateToDoBtn,"Create To-Do");
        waitForClickableOfElement(createTodoTextEle, "Create Todo text");

    }

    public void verifyFilterDropDownList() {
        waitForVisibleElement(eleFilterDropDownList, "eleFilterDropDownList");
        hoverElement(eleFilterDropDownList, "eleFilterDropDownList");
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForVisibleElement(eleShowAllBTN, "eleShowAllBTN");
        // Busniess rule is changed, remove Due Date and FlagForRequest Option.
//        waitForVisibleElement(eleDueDateBTN, "eleDueDateBTN");
        waitForVisibleElement(eleAssignedBTN, "eleAssignedBTN");
        waitForVisibleElement(eleWithCommentBTN, "eleWithCommentBTN");
        waitForVisibleElement(eleCompleteBTN, "eleCompleteBTN");
        waitForVisibleElement(eleOutstandingBTN, "eleOutstandingBTN");
//        waitForVisibleElement(eleFlaggedForRequest, "eleFlaggedForRequest");
        waitForClickableOfElement(eleShowAllBTN, "eleShowAllBTN");
//        waitForClickableOfElement(eleDueDateBTN, "eleDueDateBTN");
        waitForClickableOfElement(eleAssignedBTN, "eleAssignedBTN");
        waitForClickableOfElement(eleWithCommentBTN, "eleWithCommentBTN");
        waitForClickableOfElement(eleCompleteBTN, "eleCompleteBTN");
        waitForClickableOfElement(eleOutstandingBTN, "eleOutstandingBTN");
//        waitForClickableOfElement(eleFlaggedForRequest, "eleFlaggedForRequest");
    }

    public void verifyDefaultValueFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Filter");
    }

    public boolean verifyHoverFilterDropDownList() {
        boolean isCheckBorderColor = false;
        getLogger().info("Verify hover on Filter DropDown list.");
        try {
            // Green color
            hoverElement(eleFilterDropDownList, "eleFilterDropDownList");
            isCheckBorderColor = validateCssValueElement(eleFilterDropDownList, "border-bottom-color", "rgba(117, 117, 117, 1)");
            if (isCheckBorderColor) {
                NXGReports.addStep("Verify  hover on Filter DropDown list: PASSED", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify  hover on Filter DropDown list: FAILED", LogAs.FAILED, null);
            }
            return isCheckBorderColor;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify  hover on Filter DropDown list: FAILED", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckBorderColor;
        }
    }

    public void selectShowAllFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleShowAllBTN, "eleShowAllBTN");
        clickElement(eleShowAllBTN, "eleShowAllBTN");
    }

    public void verifySelectShowAllFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Show All");
    }

    public void selectDueDateFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleDueDateBTN, "eleDueDateBTN");
        clickElement(eleDueDateBTN, "eleDueDateBTN");
    }

    public void verifySelectDueDateFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Due Date");
    }

    public void selectAndVerifyFirstAssignFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        hoverElement(eleAssignedBTN, "eleAssignedBTN");
        getLogger().info("Select the first value on  Assign.");
        String firstTextValue = AssignValue.get(0).getText().trim();
        clickElement(AssignValue.get(0), "AssignValue");
        validateElementText(eleFilterDropDownList, firstTextValue);
    }

    public void selectWithCommentsFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleWithCommentBTN, "eleWithCommentBTN");
        clickElement(eleWithCommentBTN, "eleWithCommentBTN");
    }

    public void verifySelectWithCommentsFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "With Comments");
    }

    public void selectCompleteFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleCompleteBTN, "eleCompleteBTN");
        clickElement(eleCompleteBTN, "eleCompleteBTN");
    }

    public void verifySelectCompleteFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Complete");
    }

    public void selectFlaggedForRequestFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleCompleteBTN, "eleCompleteBTN");
        clickElement(eleFlaggedForRequest, "eleFlaggedForRequest");
    }

    public void verifySelectFlaggedForRequestFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Flagged For Request");
    }

    public void verifyUnableAddMoreOptionFilterDropDownList() {
        waitForVisibleElement(eleFilterDropDownList, "eleFilterDropDownList");
        hoverElement(eleFilterDropDownList, "eleFilterDropDownList");
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForVisibleElement(eleShowAllBTN, "eleShowAllBTN");
        waitForVisibleElement(eleDueDateBTN, "eleDueDateBTN");
        waitForVisibleElement(eleAssignedBTN, "eleAssignedBTN");
        waitForVisibleElement(eleWithCommentBTN, "eleWithCommentBTN");
        waitForVisibleElement(eleCompleteBTN, "eleCompleteBTN");
        waitForVisibleElement(eleOutstandingBTN, "eleOutstandingBTN");
        waitForVisibleElement(eleFlaggedForRequest, "eleFlaggedForRequest");
        NXGReports.addStep("Dropdown list have only above options.", LogAs.PASSED, null);
    }

    public void verifyClickAndDoNotSelectValue() {
        waitForVisibleElement(eleFilterDropDownList, "eleFilterDropDownList");
        hoverElement(eleFilterDropDownList, "eleFilterDropDownList");
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
    }

    /**
     * Refactored by huy.huynh on 02/06/2017.
     * New for smoke test
     */
    @FindBy(id = "engagementUserBtn")
    private WebElement buttonInviteClient;

    /**
     * Click Invite button
     */
    public void navigateToInviteClientPage() {
        validateElementText(buttonInviteClient, "Invite Client");
        clickByJavaScripts(buttonInviteClient, "Button Invite Client");
    }
    /*-----------end of huy.huynh on 02/06/2017.*/

    /*
 Vien.Pham add new method.
  */
    public void waitForNumberOfTodoListIncreased() throws Exception {
        getLogger().info("Waiting for number of Todo list change...");
        int sizeOfTodoListExpected = tableTodoList.size() + 1;
        waitForSizeListElementChanged(tableTodoList, "Table Todolist", sizeOfTodoListExpected);
    }


}
