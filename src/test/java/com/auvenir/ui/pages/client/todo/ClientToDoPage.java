package com.auvenir.ui.pages.client.todo;

import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.pages.common.DetailsEngagementPage;
import com.auvenir.ui.pages.common.TodoPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ClientToDoPage extends TodoPage {

    public ClientToDoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    AuditorCreateToDoPage auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
    //    ClientToDoPage clientToDoPage = new ClientToDoPage(getLogger(),getDriver());


    //    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr")
    //    private List<WebElement> toDoTaskRowEle;


    @FindBy(xpath = "//div[contains(@id,'todo-bulk-dropdown')]")
    private  WebElement bulkActionsDropdownEle;

    public int findToDoTaskName(String toDoName) {
        getLogger().info("Find Position of To Do Task Name");
        String actualAttributeValue;
        String classAttribute;
        for (int i = 0; i < toDoTaskRowEle.size(); i++) {
            classAttribute = toDoTaskRowEle.get(i).getAttribute("class");
            if (classAttribute.equals("newRow")) {
                WebElement toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/span[@class='todo-name-readonly']"));
                actualAttributeValue = toDoNameCell.getText();
                if (actualAttributeValue.equals(toDoName)) {
                    getLogger().info("Element is found at " + i);
                    NXGReports.addStep(String.format("The position of To Do task: '%s' at %d", toDoName, i), LogAs.PASSED, null);
                    return i;
                }
            }
        }
        return -1;
    }

    public void verifyToDoTaskExist(String toDoName, boolean isClient) {
        try {

            int index = findToDoTaskName(toDoName);
            if (index != -1) {
                NXGReports.addStep("Verify ToDo task: " + toDoName + " exists.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify ToDo task: " + toDoName + " exists.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            waitSomeSeconds(5);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Verify ToDo task: " + toDoName + " exists.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void selectClientAssigneeByName(String todoName, String clientAssignee) {
        try {
            String assineeClientEle = ".//button[text()='%s']";
            int index = findToDoTaskName(todoName);
            clickElement(listClientAssigneeDdl.get(index), "listClientAssigneeDdl");
            waitSomeSeconds(2);
            WebElement clientAssigneeSelected =
                    listClientAssigneeDdl.get(index).findElement(By.xpath(String.format(assineeClientEle, clientAssignee)));
            clickElement(clientAssigneeSelected, "clientAssigneeSelected");
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Select client assignee with name: " + clientAssignee, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public void verifyClientAssigneeSelected(String todoName, String clientAssignee) {
        try {
            Thread.sleep(bigTimeOut);
            int index = findToDoTaskName(todoName);
            WebElement clientAssigneeSelected = listClientAssigneeDdl.get(index).findElement(By.xpath("./div[@class='text']"));
            waitForTextValueChanged(clientAssigneeSelected, "listClientAssigneeDdl", clientAssignee);
            if (clientAssigneeSelected.getText().equals(clientAssignee)) {
                NXGReports.addStep("verify auditor assignee selected with name: " + clientAssignee, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify auditor assignee selected with name: " + clientAssignee, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify auditor assignee selected with name: " + clientAssignee, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public int selectToDoCheckboxByName(String todoName) {
        getLogger().info("Select To Do Task Check Box by Name");
        int index = findToDoTaskName(todoName);
        System.out.println("Index: " + index);
        if (index != -1) {
            if (!eleToDoCheckboxRow.get(index).isSelected())
                clickElement(eleToDoCheckboxRow.get(index), String.format("Check box of Task Name: %s", todoName));
        }
        return index;
    }

    public void clickBulkActionsDropdown() {
//        waitForAtrributeValueChanged(bulkActionsDropdownEle,"","class","ui dropdown");
        clickElement(bulkActionsDropdownEle, "Bulk Actions Dropdown List");
    }
}
