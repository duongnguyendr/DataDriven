package com.auvenir.ui.pages.common;

import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by vien.pham on 7/21/2017.
 */
public class TodoPage extends AbstractPage {
    public TodoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

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
    //    @FindBy(xpath = "//*[@id='comment-box']/p")
    private WebElement commentboxTitleEle;
    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p")
    //    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']")
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
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    private WebElement newRequestTable;

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

    public void clickCommentIconPerTaskName(String toDoTaskName, boolean isClient) {
        getLogger().info("Select To Do Comment Icon by Name");
        int index = findToDoTaskName(toDoTaskName, isClient);
        clickElement(commentIconToDoListEle.get(index), String.format("Comment Icon on Task Name: %s", toDoTaskName));
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
        int index = 0;
        for (int i = 0; i < listRow.size(); i++) {
            if (editablePage) {
                String actualName = listEnableTodoTextbox.get(i).getAttribute("value").trim();
                System.out.println("actualName is: " + actualName);
                if (actualName.equals(todoName)) {
                    index = i;
                    break;
                }
            } else {
                String actualName = listDisableTodoTextbox.get(i).getText().trim();
                System.out.println("actualName is: " + actualName);
                if (actualName.equals(todoName)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @FindBy(xpath = "//div[contains(@class,'auvicon-line-circle-more')]")
    private WebElement requestOptionBtn;

    private  String activeName = "ui dropdown auvicon-line-circle-more todo-circle-more todo-icon-hover active";
    public void verifyRequestDeletionCapability(String requestName, boolean deleteCapability) {
        if (deleteCapability) {

        } else {
            clickElement(requestOptionBtn);
            waitForAtrributeValueChanged(requestOptionBtn,"","class",activeName);
        }
    }


    private int findRequestByName(String requestName) {
        int isFind = -1;
        for (int i = 1; i < (listNewRequest.size() + 1); i++) {
            if (newRequestTable.findElement(By.xpath("./div[" + i + "]/span")).getText().equals(requestName)) {
                isFind = i;
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
}
