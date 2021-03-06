package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

/**
 * Created by vien.pham on 7/21/2017.
 */
public abstract class TodoPage extends AbstractPage {
    public TodoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    //==============================**************===================================================

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr")
    protected List<WebElement> toDoTaskRowEle;
    @FindBy(xpath = "//div[@class='ui dropdown client todo-bulkDdl ']")
    protected List<WebElement> listClientAssigneeDdl;
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr/td[7]/img")
    private List<WebElement> commentIconToDoListEle;
    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//span[contains(@class,'detCommentUser')]")
    private List<WebElement> userNameCommenterEle;
    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p[@class='detComment']")
    private List<WebElement> descriptionCommentEle;
    @FindBy(xpath = "//div[@id='comment-form']/input[@placeholder='Type a comment']")
    private WebElement typeCommentFieldEle;
    @FindBy(xpath = "//*[@id='comment-box']/p/span/span")
    private WebElement commentboxTitleEle;
    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p")
    private List<WebElement> listCommentItemEle;
    @FindBy(xpath = "//*[@id='comment-button']")
    private WebElement postCommentButton;
    @FindBy(xpath = "//tr[@class='newRow']")
    private List<WebElement> listRow;
    @FindBy(xpath = "//span[@class='todo-name-readonly']")
    private List<WebElement> listDisableTodoTextbox;
    @FindBy(xpath = "//tr[@class='newRow']//input[@type='text']")
    private List<WebElement> listEnableTodoTextbox;
    @FindBy(xpath = "//tr[@class='newRow']//span[@class='ui label todo-category-readonly']")
    private List<WebElement> listDisableCategoryBtn;
    @FindBy(xpath = "//div[contains(@class,'ui dropdown todoCategory')]")
    private List<WebElement> listEnableCategoryBtn;
    @FindBy(xpath = "//input[contains(@class,'input-due-date ')]")
    private List<WebElement> listDisableDatePickerBtn;
    @FindBy(xpath = "//input[contains(@class,'datepicker')]")
    private List<WebElement> listEnableDatePickerBtn;
    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div")
    private List<WebElement> listNewRequest;
    @FindBy(xpath = "(//div[@id='todoDetailsReqCont']/div)[1]")
    private WebElement firstRequest;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    private WebElement newRequestTable;
    @FindBy(xpath = "//div[contains(@class,'auvicon-line-circle-more')]")
    private List<WebElement> listRequestOptionBtn;
    @FindBy(xpath = "//div[contains(@class,'auvicon-line-circle-more')]/div[@class='menu']/a")
    private List<WebElement> listRequestSelection;
    @FindBy(xpath = "//div[@class='menu']/a[text()='Delete request']")
    private List<WebElement> deleteRequestSelection;

    @FindBy(xpath = "(//div[@class='menu']/a[text()='Delete request'])[1]")
    private WebElement firstDeleteRequestSelection;

    @FindBy(xpath = "//div[@class='auvicon-ex']")
    WebElement requestCloseBtn;
    @FindBy(xpath = "//div[@id='auv-todo-details']")
    WebElement addNewRequestWindow;

    private String activeStatus = "ui dropdown auvicon-line-circle-more todo-circle-more todo-icon-hover active";
    @FindBy(id = "auv-todo-createToDo")
    protected WebElement createToDoBtnEle;

    @FindBy(id = "engOverview-status")
    protected WebElement engOveviewStatus;

    String auditAssignNotEditPath = "//td/span[text()='%s']/../../td[6]/p";
    String auditAssignCanEditPath = "//td/input[@value='%s']/../../td[6]/p";
    String clientAssignPath = "//td/span[text()='%s']/../../td[4]/p";
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[contains(@class,'newTodoInput')]")
    protected List<WebElement> toDoNameTextColumnEle;

    protected String assineeClientEle = ".//button[text()='%s']";

    @FindBy(xpath = "//div[@id='auv-todo-detailsReqBox']//div[@id='todoDetailsReqCont']/div[contains(@id, 'todo-req-box')]/span[1]")
    protected List<WebElement> listRequestEle;

    @FindBy(xpath = "//div[contains(@class,'ui dropdown todoCategory')]")
    private List<WebElement> categoryButton;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr//input[@type='checkbox']")
    protected List<WebElement> eleToDoCheckboxRow;


    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div/div[2]")
    List<WebElement> uploadRequestList;

    public int findToDoTaskName(String toDoName, boolean isClient) {
        getLogger().info("Find Position of To Do Task Name");
        String actualAttributeValue;
        String classAttribute;
        WebElement toDoNameCell = null;
        for (int i = 0; i < toDoTaskRowEle.size(); i++) {
            classAttribute = toDoTaskRowEle.get(i).getAttribute("class");
            if (classAttribute.equals("newRow")) {
                if (isClient) {
                    toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/span[@class='todo-name-readonly']"));
                } else {
                    toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']"));
                }
                if (toDoNameCell != null) {
                    if (isClient) {
                        actualAttributeValue = toDoNameCell.getText().trim();
                    } else {
                        actualAttributeValue = toDoNameCell.getAttribute("value").trim();
                    }
                    if (actualAttributeValue.equals(toDoName)) {
                        getLogger().info("Element is found at " + i);
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public void verifyLastCommentOfUserDisplayed(String commentContent, String userFullName) {
        getLogger().info("Verify Last Comment Of User is Displayed");
        try {
            boolean result;
            result = validateElementText(userNameCommenterEle.get(userNameCommenterEle.size() - 1), userFullName);
            Assert.assertTrue(result, String.format("User Name Commenter '%s' should be displayed", userFullName));
            verifyCommentContentIsDisplayed(commentContent);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed: Verify Last Comment Of User is Displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify Last Comment Of User is Displayed", LogAs.FAILED,
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

    public boolean verifyPermissionSeeListToDoTask(List<String> listToDoName, boolean isNotEditedToDo, boolean possibleSee) {
        boolean result = true;
        try {
            for (int i = 0; i < listToDoName.size(); i++) {
                if (!verifyPermissionSeeToDoTask(listToDoName.get(i), isNotEditedToDo, possibleSee))
                    result = false;
            }
            Assert.assertTrue(result, "User " + (possibleSee ? "should" : "should not") + " has permission to see list ToDo task");
            NXGReports.addStep("Verify User " + (possibleSee ? "has" : "does not have") + " permission to see list ToDo task", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed: Verify User " + (possibleSee ? "has" : "does not have") + " permission to see list ToDo task",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify User " + (possibleSee ? "has" : "does not have") + " permission to see list ToDo task",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return result;
    }

    public boolean verifyPermissionSeeToDoTask(String toDoName, boolean isNotEditedToDo, boolean isDisplayed) {
        boolean result = false;
        try {
            int count = findToDoTaskName(toDoName, isNotEditedToDo);
            if (isDisplayed) {
                if (count != -1)
                    result = true;
            } else {
                if (count == -1)
                    result = true;
            }
            Assert.assertTrue(result, "To Do Name is not displayed");
            NXGReports.addStep(String.format("Verify To Do '%s' is displayed", toDoName), LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports
                    .addStep("Test Failed: Verify ToDo Name is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Test Failed: Verify ToDo Name is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return result;
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
            NXGReports.addStep("TestScript Failed: Verify Input a Comment", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public int getNumberOfListComment() {
        getLogger().info("Get Number of List Comment.");
        if (commentboxTitleEle.getText().trim().equals("0")) {
            return 0;
        } else {
            return listCommentItemEle.size();
        }
    }

    public void clickOnPostCommentButton() {
        getLogger().info("Click Post Comment Button");
        int size = getNumberOfListComment();
        waitForVisibleElement(postCommentButton, "Comment Input field");
        clickElement(postCommentButton, "Comment Input field");
        waitForSizeListElementChanged(listCommentItemEle, "List Comment", size + 1);
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

    /**
     * Vien.Pham own this function
     *
     * @param todoName: to find row correspoding with todoName inputed. if "All": verify all rows.
     * @param editable: true: editable or False:  not editable
     */
    public void verifyCategoryEditableCapability(String todoName, boolean editable) {
        try {
            if (editable) {
                int index = findRowByTodoName(todoName, true);
                clickElement(categoryButton.get(index));
                //Select Edit Categoru
                clickElement(categoryButton.get(index).findElement(By.xpath("//div[contains(text(),'Edit Categories')]")));

            }

            if (todoName.equals("All") && editable) {
                if (listRow.size() == listEnableCategoryBtn.size()) {
                    System.out.println("All of Categories is Enable.");
                    NXGReports.addStep("Verify all categories is " + (editable ? "editable" : "not editable") + " :Pass.", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify all categories is " + (editable ? "editable" : "not editable" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
            if (todoName.equals("All") && editable == false) {
                if (listRow.size() == listDisableCategoryBtn.size()) {
                    System.out.println("All of Categories is Disable.");
                    NXGReports.addStep("Verify all categories is " + (editable ? "editable" : "not editable") + " :Pass.", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify all categories is " + (editable ? "editable" : "not editable" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify all categories is " + (editable ? "editable" : "not editable" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Vien.Pham own this function
     *
     * @param todoName: to find row correspoding with todoName inputed. if "All": verify all rows.
     * @param editable: true: can be changed or False: can not be changed.
     */
    public void verifyDueDateEditableCapability(String todoName, boolean editable) {

        try {
            if (editable) {
                int index = findRowByTodoName(todoName, editable);

            }

            if (todoName.equals("All") && editable) {
                if (listRow.size() == listEnableDatePickerBtn.size()) {
                    System.out.println("All of DueDate can be changed");
                    NXGReports.addStep("Verify all DueDate can be " + (editable ? "changed" : "not changed") + " :Pass.", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify all DueDate can " + (editable ? "changed" : "not changed" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
            if (todoName.equals("All") && editable == false) {
                if (listRow.size() == listDisableDatePickerBtn.size()) {
                    System.out.println("All of DueDate can not be changed");
                    NXGReports.addStep("Verify all DueDate can " + (editable ? "changed" : "not changed") + " :Pass.", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify all DueDate can " + (editable ? "changed" : "not changed" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify all DueDate can " + (editable ? "changed" : "not changed" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    private int findRowByTodoName(String todoName, boolean editablePage) {
        int index = -1;
        for (int i = 0; i < listRow.size(); i++) {
            if (editablePage) {
                String actualName = listEnableTodoTextbox.get(i).getAttribute("value").trim();
                if (actualName.equals(todoName)) {
                    index = i;
                    break;
                }
            } else {
                String actualName = listDisableTodoTextbox.get(i).getText().trim();
                if (actualName.equals(todoName)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * Vien.Pham own this function
     *
     * @param requestName:find         corresponding requestName
     * @param deleteRequestCapability: true: can delete request or False: can not delete request.
     */
    public void verifyRequestDeletionCapability(String requestName, boolean deleteRequestCapability) {
        try {
            if (deleteRequestCapability) {
                int index = findRequestByName(requestName);
                clickElement(listRequestOptionBtn.get(index - 1));
                int numberRequestBefore = listNewRequest.size();
                clickElement(deleteRequestSelection.get(index));
                boolean isVerify = verifyDeleteRequest(numberRequestBefore);
                if (isVerify) {
                    NXGReports.addStep("Verify request can  " + (deleteRequestCapability ? "be deleted" : "not be deleted") + " :Pass.", LogAs.PASSED,
                            null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request can " + (deleteRequestCapability ? "be deleted" : "not be deleted" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            } else {
                clickElement(listRequestOptionBtn.get(0),"");
                boolean isVerify = validateNotExistedElement(firstDeleteRequestSelection, "delete selection");
                if (isVerify) {
                    getLogger().info("Delete request option is invisible");
                    NXGReports.addStep("Verify request can  " + (deleteRequestCapability ? "be deleted" : "not be deleted") + " :Pass.", LogAs.PASSED,
                            null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request can " + (deleteRequestCapability ? "be deleted" : "not be deleted" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify request can " + (deleteRequestCapability ? "be deleted" : "not be deleted" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public boolean verifyDeleteRequest(int numberRequestBefore) {
        boolean isVerify = false;
        System.out.println("Number of requests before deleted: " + numberRequestBefore);
        if (numberRequestBefore > 1) {
            int numberRequestAfter = listNewRequest.size();
            System.out.println("Number of requests after deleted: " + numberRequestAfter);
            if (numberRequestAfter == numberRequestBefore - 1) {
                isVerify = true;
            }
        } else {
            boolean isNotDisplayed = validateNotExistedElement(firstRequest, "Request");
            if (isNotDisplayed) {
                isVerify = true;
                System.out.println("List of request is empty after deleted");
            }
        }
        return isVerify;
    }


    private int findRequestByName(String requestName) {
        int isFind = -1;
        for (int i = 1; i < (listNewRequest.size() + 1); i++) {
            if (newRequestTable.findElement(By.xpath("./div[" + i + "]/span")).getText().equals(requestName)) {
                isFind = i;
                getLogger().info("Request " + requestName + " at position: " + isFind);
                break;
            }
        }
        return isFind;
    }

    public void clickCommentIconByTodoName(String todoName, boolean editablePage) {
        getLogger().info("Select To Do Comment Icon by Todo Name");
        int index = findRowByTodoName(todoName, editablePage);
        clickElement(commentIconToDoListEle.get(index), String.format("Comment Icon on Task Name: %s", todoName));
    }

    public void verifyGroupPermissionCanMarkCompleted(List<String> listTodo, boolean possibleCompleted) {
        try {
            for (int i = 0; i < listTodo.size(); i++) {
                if (possibleCompleted) {
                    selectToDoCheckboxByName(listTodo.get(i));
                    clickBulkActionsDropdown();
                    verifyCompleteMarkPopup();
                    clickOnArchiveButtonInMarkAsCompletePopup();
                    verifyTodoMarkCompleted(listTodo.get(i));
                    NXGReports.addStep("Verify " + (possibleCompleted ? "can" : "cannot") + " mark complete todo.", LogAs.PASSED,
                            null);
                } else {
                    int todoIndexCanChecked = selectToDoCheckboxByName(listTodo.get(i));
                    if (todoIndexCanChecked == -1) {
                        NXGReports.addStep("Verify " + (possibleCompleted ? "can" : "cannot") + " mark complete todo.", LogAs.PASSED,
                                null);
                    } else {
                        AbstractService.sStatusCnt++;
                        NXGReports
                                .addStep("Test Failed: Verify " + (possibleCompleted ? "can" : "cannot") + " mark complete todo :" + listTodo.get(i),
                                        LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify " + (possibleCompleted ? "can" : "cannot") + " mark complete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    public int selectToDoCheckboxByName(String todoName) {
        return -1;
    }


    public void clickBulkActionsDropdown() throws InterruptedException {
    }

    public void clickOnArchiveButtonInMarkAsCompletePopup() {
    }

    public void verifyTodoMarkCompleted(String todoName) {
    }

    public void verifyCompleteMarkPopup() {
    }

    public void verifyGroupPermissionCanAssignTodoToAuditor(List<String> listTodo, boolean possibleAssign, boolean canEdit) {
        try {
            for (int i = 0; i < listTodo.size(); i++) {
                if (possibleAssign) {

                } else {
                    boolean result = false;
                    if (canEdit){
                        result = validateDisPlayedElement(getDriver().findElement(By.xpath(String.format(auditAssignCanEditPath, listTodo.get(i)))),
                                listTodo.get(i));
                    }else{
                        result = validateDisPlayedElement(getDriver().findElement(By.xpath(String.format(auditAssignNotEditPath, listTodo.get(i)))),
                                listTodo.get(i));
                    }
                    Assert.assertTrue(result, "verify auditor assign element.");
                    NXGReports.addStep(String.format("verify auditor assign element.", listTodo.get(i)), LogAs.PASSED, null);
                    if (!result) {
                        AbstractService.sStatusCnt++;
                        NXGReports
                                .addStep("Test Failed: Verify " + (possibleAssign ? "can" : "cannot") + " assign todo to auditor :" + listTodo.get(i),
                                        LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify " + (possibleAssign ? "can" : "cannot") + " assign todo to auditor.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * @param listTodo
     * @param clientFullName
     * @param possibleAssign:   User can/cannot assign to client
     * @param possibleEditTodo: Todo can/cannot edit
     */
    public void verifyGroupPermissionCanAssignTodoToClient(List<String> listTodo, String clientFullName, boolean possibleAssign,
            boolean possibleEditTodo) {
        try {
            for (int i = 0; i < listTodo.size(); i++) {
                if (possibleAssign) {
                } else {
                    if (possibleEditTodo) {
                        boolean clientAssignExist = verifyClientAssignExist(listTodo.get(i), clientFullName);
                        Assert.assertFalse(clientAssignExist, "verify client assign exists.");
                        if (clientAssignExist) {
                            AbstractService.sStatusCnt++;
                            NXGReports.addStep("Client assign: " + clientFullName + " shouldn't display.", LogAs.FAILED,
                                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        }
                    } else {
                        boolean result = validateDisPlayedElement(getDriver().findElement(By.xpath(String.format(clientAssignPath, listTodo.get(i)))),
                                listTodo.get(i));
                        Assert.assertTrue(result, "verify client assign element.");
                        NXGReports.addStep(String.format("verify client assign element.", listTodo.get(i)), LogAs.PASSED, null);
                        if (!result) {
                            AbstractService.sStatusCnt++;
                            NXGReports.addStep(
                                    "Test Failed: Verify " + (possibleAssign ? "can" : "cannot") + " assign todo to auditor :" + listTodo.get(i),
                                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        }
                    }
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify " + (possibleAssign ? "can" : "cannot") + " assign todo to auditor.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * @param listTodo
     * @param possibleCreate: User can/cannot create todo
     */
    public void verifyGroupPermissionCanCreateTodo(List<String> listTodo, boolean possibleCreate) {
        try {
            if (possibleCreate) {
                for (String todoName : listTodo) {
                    createToDoTaskWithCategoryName(todoName, "Category 22");
                    verifyPermissionSeeToDoTask(todoName, false, true);
                }
            } else {
                boolean result = validateDisPlayedElement(createToDoBtnEle, "createToDoBtnEle");
                Assert.assertFalse(result, "Verify create todo button displayed.");
                NXGReports.addStep("Verify create todo button displayed.", LogAs.PASSED, null);
                if (result) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Test Failed: Verify " + (possibleCreate ? "can" : "cannot") + " create todo :", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify " + (possibleCreate ? "can" : "cannot") + " create todo :", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * @param listTodo
     * @param possibleRemove: User can/cannot create todo
     */
    public void verifyGroupPermissionCanRemoveTodo(List<String> listTodo, boolean possibleRemove) {
        try {
            for (int i = 0; i < listTodo.size(); i++) {
                if (possibleRemove) {
                    selectToDoCheckboxByName(listTodo.get(i));
                    clickBulkActionsDropdown();
                    chooseOptionDeleteOnBulkActionsDropDown();
                    clickConfirmDeleteButton();
                    verifyToDoNotExist(listTodo.get(i));
                } else {
                    int todoIndexCanChecked = selectToDoCheckboxByName(listTodo.get(i));
                    if (todoIndexCanChecked == -1) {
                        NXGReports.addStep("Test Failed: Verify " + (possibleRemove ? "can" : "cannot") + " remove todo.", LogAs.PASSED, null);
                    } else {
                        AbstractService.sStatusCnt++;
                        NXGReports.addStep("Test Failed: Verify " + (possibleRemove ? "can" : "cannot") + " remove todo :" + listTodo.get(i),
                                LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify " + (possibleRemove ? "can" : "cannot") + " remove todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    public void chooseOptionDeleteOnBulkActionsDropDown() {
    }

    public void clickConfirmDeleteButton() {
    }

    public void verifyToDoNotExist(String todoName) {
    }

    /**
     * @param todoName
     * @param possibleComment: user can/cannot add comment
     */
    public void verifyGroupPermissionCanAddComment(String todoName, String comment, boolean possibleComment) {
        try {
            if (possibleComment) {
                clickOpenNewRequestByTodoName(todoName);
                boolean commentExists = validateDisPlayedElement(typeCommentFieldEle, "Comment input");
                NXGReports.addStep("verify can input comment.", LogAs.PASSED, null);
                Assert.assertTrue(commentExists, "User can comment.");
                verifyInputAComment(comment);
                int numCommentBefore = getNumberOfListComment();
                clickOnPostCommentButton();
                verifyNewCommentIsDisplayed(numCommentBefore, comment);
                if (!commentExists) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Test Failed: Verify " + (possibleComment ? "can" : "cannot") + " comment.", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            } else {
                clickOpenNewRequestByTodoNameAtAdminPage(todoName);
                boolean commentExists = validateNotExistedElement(typeCommentFieldEle, "Comment input");
                NXGReports.addStep("verify can input comment.", LogAs.PASSED, null);
                Assert.assertTrue(commentExists, "User can comment.");
                if (!commentExists) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Test Failed: Verify " + (possibleComment ? "can" : "cannot") + " comment.", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify " + (possibleComment ? "can" : "cannot") + " comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public void clickOpenNewRequestByTodoNameAtAdminPage(String todoName) {
    }

    public void clickOpenNewRequestByTodoName(String todoName) {
    }

    public void createToDoTaskWithCategoryName(String todoName, String categoryName) {
    }

    public void chooseOptionAssignToAssigneeOnBulkActionsDropDownWithName(String assigneeName) {
    }

    public void verifyClientAssigneeSelected(String toDoName, String clientAssignee) {

    }


    /**
     * Verify client assign exist in list client assign dropdown
     *
     * @param toDoName
     * @param clientFullName
     * @return
     */
    public boolean verifyClientAssignExist(String toDoName, String clientFullName) {
        boolean result = false;
        try {
            int index = findToDoTaskName(toDoName);
            clickElement(listClientAssigneeDdl.get(index), "listClientAssigneeDdl");
            List<WebElement> clientAssigneeSelected = listClientAssigneeDdl.get(index).findElements(By.xpath(".//button"));
            for (WebElement item : clientAssigneeSelected) {
                if (clientFullName.equals(item.getText())) {
                    result = true;
                    break;
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Error: Verify client assign existed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
        return result;
    }

    /**
     * Vien.Pham own this function
     *
     * @param requestName:               to find corresponding requestName.
     * @param editRequestNameCapability: true: can change requestName or False: can not change
     */
    public void verifyEditRequestNameCapability(String requestName, String newRequestName, boolean editRequestNameCapability) {
        try {
            int index = findRequestByName(requestName);
            if (editRequestNameCapability) {
                System.out.println("Name of old request: " + requestName);
                inputRequestName(index, newRequestName);
                boolean isVerify = verifyNewRequestSaved(newRequestName);
                if (isVerify) {
                    NXGReports.addStep("Verify request Name can  " + (editRequestNameCapability ? "be changed" : "not be changed") + " :Pass.",
                            LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request Name can " + (editRequestNameCapability ? "be changed" : "not be changed" + " :Fail"),
                            LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }

            } else {
                clickElement(newRequestTable.findElement(By.xpath("./div[" + index + "]/span")), "");
                waitSomeSeconds(1);
                boolean isCheck =
                        validateCssValueElement(newRequestTable.findElement(By.xpath("./div[" + index + "]/span")), "display", "inline-block");
                if (isCheck) {

                    NXGReports.addStep("Verify request Name can  " + (editRequestNameCapability ? "be changed" : "not be changed") + " :Pass.",
                            LogAs.PASSED, null);

                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request Name can " + (editRequestNameCapability ? "be changed" : "not be changed" + " :Fail"),
                            LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify request Name can " + (editRequestNameCapability ? "be changed" : "not be changed" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * @param position:   the position of request Name: 1st =1, 2nd = 2..etc
     * @param requestName
     */
    public void inputRequestName(int position, String requestName) {
        //        waitForCssValueChanged(newRequestTable.findElement(By.xpath("./div[" + position + "]/span")), "", "display", "inline-block");
        clickElement(newRequestTable.findElement(By.xpath("./div[" + position + "]/span")), "");
        clearTextBox(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), "");
        sendKeyTextBox(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), requestName, "");
        sendTabkey(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), "");
    }

    public void closeAddNewRequestWindow() {
        clickElement(requestCloseBtn);
        waitForCssValueChanged(addNewRequestWindow, "Add new Request Window", "display", "none");
    }


    public boolean verifyNewRequestSaved(String newRequestName) {
        boolean isVerify = false;
        try {
            int index = findRequestByName(newRequestName);
            if (index != -1) {
                System.out.println("Name of new request: " + newRequestName);
                NXGReports.addStep("Verify request saved: Pass", LogAs.PASSED, null);
                isVerify = true;
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify request saved: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify request saved: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return isVerify;
    }

    public void verifyRequestCreated(List<String> listRequest) {
        try {
            List<String> lstRequestDisplayed = new ArrayList<>();
            for (WebElement requestEle : listRequestEle) {
                lstRequestDisplayed.add(requestEle.getText());
            }
            for (int i = 0; i < listRequest.size(); i++) {
                if (!lstRequestDisplayed.contains(listRequest.get(i))) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request: " + listRequest.get(i) + " created: Fail", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
            closeAddNewRequestWindow();

        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify request created: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCanSeeAllToDosWithinEngagement(List<String> todoListNames, List<Boolean> todoListSeeable, String role) {
        //        String xpathEngagementName = "//input[@class='newTodoInput'][@value='%s']";
        String xpathToDosName = "//tr[contains(@class,'newRow')]/td[2]/*";
        boolean exist = true;
        List<WebElement> webElements = getListElementsByXpath(xpathToDosName);
        for (int i = 0; i < todoListNames.size(); i++) {
            String xpathToDoName = getFullXpath(webElements, xpathToDosName, todoListNames.get(i));
            if (todoListSeeable.get(i)) {
                if (getElementByXpath(xpathToDoName) == null) {
                    System.out.println("name= " + todoListNames.get(i));
                    exist = false;
                }
            } else {
                if (getElementByXpath(xpathToDoName) != null) {
                    System.out.println("name= " + todoListNames.get(i));
                    exist = false;
                }
            }
        }
        if (exist) {
            NXGReports.addStep("Verify " + role + " can see all engagements within firm", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Fail: Verify " + role + " can see all engagements within firm", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public String getFullXpath(List<WebElement> webElements, String xpath, String todoName) {
        for (int i = 0; i < webElements.size(); i++) {
            if (webElements.get(i).getTagName().equals("span")) {
                if (webElements.get(i).getText().equals(todoName)) {
                    //System.out.println("webElements i = " + webElements.get(i).getText());
                    return xpath + "[text()='" + todoName + "']";
                }
            } else if (webElements.get(i).getTagName().equals("input")) {
                if (webElements.get(i).getAttribute("value").equals(todoName)) {
                    //System.out.println("webElements i = " + webElements.get(i).getAttribute("value"));
                    return xpath + "[@value='" + todoName + "']";
                }
            }
        }
        return "";
    }

    public void uploadeNewFileByRequestName(String concatUpload, String requestName) {
        try {
            int isFind = findRequestByName(requestName);
            if (isFind == -1) {
                getLogger().info("Can not find any request has name is: " + requestName);
                AbstractService.sStatusCnt++;
                NXGReports.addStep("End of Upload createNewRequest File", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                clickElement(newRequestTable.findElement(By.xpath("./div[" + isFind + "]//label")));
                Thread.sleep(largeTimeOut);
                getLogger().info("Input path of file..");
                //                upLoadRequestFile(concatUpload);
                StringSelection ss = new StringSelection(concatUpload);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                //                getLogger().info("Waiting for checkSign visible..");
                //                waitForCssValueChanged(checkUploadRequest.get(isFind), "checkSuccessful", "display", "inline-block");
                //                                closeAddNewRequestWindow();
                waitSomeSeconds(1);
                NXGReports.addStep("End of Upload createNewRequest File", LogAs.PASSED, null);
            }
        } catch (InterruptedException itr) {
            AbstractService.sStatusCnt++;
            itr.printStackTrace();
            NXGReports.addStep("End of Upload createNewRequest File", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    /*
   Vien.Pham added new method
    */
    public void verifyUploadFileSuccessfully(String fileName) {
        try {
            int isFind = findUploadFile(fileName);
            System.out.println("value is: " + isFind);
            if (isFind != -1) {
                NXGReports.addStep(String.format("File '%s' is displayed successfully.", fileName), LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep(String.format("File '%s' is NOT displayed", fileName), LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep(String.format("File '%s' is NOT displayed", fileName), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
            e.printStackTrace();
        }
    }


    public int findUploadFile(String fileName) {
        getLogger().info(String.format("Verifying this file '%s' existed in the list..", fileName));
        int isFind = -1;
        for (int i = 0; i < uploadRequestList.size(); i++) {
            System.out.println("UploadName at position: " + i + " is " + uploadRequestList.get(i).getText());
            if (uploadRequestList.get(i).getText().equals(fileName)) {
                isFind = i;
                break;
            }
        }
        return isFind;
    }

    public void downloadRequestFile(String downloadLocation, String fileName) {
        downloadNewRequestFile(downloadLocation, fileName, false);
    }

    public void downloadFileFromComment(String downloadLocation, String fileName) {
        downloadNewRequestFile(downloadLocation.concat(fileName), fileName, true);
    }

    //    public void downloadNewRequestFile(String downloadLocation, String fileName, boolean fileInComment){}

    @FindBy(xpath = "//div[@class='todo-comment-container']//p[contains(@class,'comment-fileName')]")
    WebElement verifyAttachComplete;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div//span[contains(@class,'auvicon-line-download')]")
    List<WebElement> downloadRequestBtn;

    public void downloadNewRequestFile(String pathDownloadFolder, String fileName, boolean fileInComment) {
        try {
            //Delete file before download
            String concatDownload = pathDownloadFolder.concat(fileName);
            checkFileExists(concatDownload, true);
            Thread.sleep(largeTimeOut);
            if (fileInComment) {
                clickElement(verifyAttachComplete, "download attachment from comment");
                waitSomeSeconds(3);
            } else {
                int isFind = findUploadFile(fileName);
                clickElement(downloadRequestBtn.get(isFind), "download newRequest");
                waitSomeSeconds(3);
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Check sum failed_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDownloadFileRequestSuccess(String pathUpload, String pathDownload, String fileName) {
        try {
            String concatUpload = pathUpload.concat(fileName);
            String concatDownload = pathDownload.concat(fileName);
            boolean fileExisted = checkFileExists(concatDownload, false);
            if (fileExisted) {
                String checkMd5UploadFile = calculateMD5(concatUpload);
                getLogger().info("md5 upload is: " + checkMd5UploadFile);
                String checkMd5DownloadFile = calculateMD5(concatDownload);
                getLogger().info("md5 download is: " + checkMd5DownloadFile);
                if (checkMd5UploadFile.equals(checkMd5DownloadFile)) {
                    NXGReports.addStep("Check sum done", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Check sum failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Download file failed, file: " + fileName + "not in " + pathDownload, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Check sum failed_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public String calculateMD5(String fileMD5) {
        String md5 = null;
        try {
            FileInputStream fis = new FileInputStream(fileMD5);
            System.out.println("fileMD5 = " + fileMD5);
            md5 = md5Hex(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().info("Unable to calculate MD5 file.");
        }

        return md5;

    }

    //    public boolean checkFileExists(String downloadFile, boolean isDeletedFile){return false;}
    public boolean checkFileExists(String pathLocation, boolean deleteExisted) {
        //        waitSomeSeconds(3);
        Path path = Paths.get(pathLocation);
        System.out.println("file: " + path);
        boolean result = false;
        try {
            if (Files.exists(path)) {
                result = true;
                if (deleteExisted) {
                    Files.delete(path);
                    if (Files.exists(path)) {
                        AbstractService.sStatusCnt++;
                        NXGReports.addStep("Delete file failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                }
            }
        } catch (IOException ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Delete file failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
        return result;
    }

    public int findToDoTaskName(String toDoName) {
        getLogger().info("Find Position of To Do Task Name");
        try{
        String actualAttributeValue;
        String classAttribute;
        for (int i = 0; i < toDoTaskRowEle.size(); i++) {
            classAttribute = toDoTaskRowEle.get(i).getAttribute("class");
            if (classAttribute.equals("newRow")) {
                boolean elementExisted = validateNotExistedElement(toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']")), "toDoTaskRowEle");
                if (!elementExisted) {
                    WebElement toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']"));
                    actualAttributeValue = toDoNameCell.getAttribute("value").trim();

                    if (actualAttributeValue.equals(toDoName)) {
                        getLogger().info("Element is found at " + i);
                        NXGReports.addStep(String.format("The position of To Do task: '%s' at %d", toDoName, i), LogAs.PASSED, null);
                        return i;
                    }
                }
            }
        }
        	return -1;
	    }catch (NoSuchElementException e) {
	    	return -1;
		}
    }

    /**
     * Created by Thuan Duong.
     * Verify all File will be displayed.
     *
     * @param listFileName list file will be verified
     */
    public void verifyCanSeeAllFileWithinToDo(List<String> listFileName) {
        try {
            int isFind = -1;
            boolean result = true;
            for (int i = 0; i < listFileName.size(); i++) {
                isFind = findUploadFile(listFileName.get(i));
                System.out.println("value is: " + isFind);
                if (isFind == -1) {
                    result = false;
                    System.out.println(String.format("File Name '%s' is not displayed: ", listFileName.get(i)));
                    break;
                }
            }
            if(result) {
                NXGReports.addStep("All file '%s' is displayed successfully.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("All file '%s' is NOT displayed successfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                        .BROWSER_PAGE));
            }

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("All file '%s' is NOT displayed successfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
            e.printStackTrace();
        }
    }
}
