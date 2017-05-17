package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */


public class AuditorDetailsEngagementPage extends AbstractPage {


    public AuditorDetailsEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "engagementTodoLink")
    private WebElement eleToDoListLnk;

    @FindBy(id = "engagementDashboardLink")
    private WebElement dashBoardLinkEle;
    @FindBy(xpath = "//div[contains(text(),'Dashboard')]")
    private WebElement dashboardTextEle;
    @FindBy(xpath = "//div[contains(text(),'To-Dos')]")
    private WebElement toDoLinkTextEle;
    @FindBy(id = "btn-todo-undo")
    private WebElement btnUndoTodo;

    public void verifyDetailsEngagementPage(String engagement01) {
        //we can not navigae engagement by name now, will improve letter, just check detail page is rendered.
        //waitForClickableOfElement(dashBoardLinkEle,"DashBoard Link");
        waitForVisibleElement(dashboardTextEle, "dashboard text");

    }

    public void navigateToTaskList() throws Exception {
        clickElement(eleToDoListLnk, "Todo List");
    }

    public void navigateToTodoListPage() throws Exception {
        waitForVisibleElement(eleToDoListLnk, "Todo link text");
        //waitForClickableOfElement(eleToDoListLnk,"Todo Link");
        clickElement(eleToDoListLnk, "Todo Link");
    }

    public void uiVerifyButtonUndoExist() {
        try {
            btnUndoTodo.getAttribute("class");
            NXGReports.addStep("Verify button Undo Todo exist.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify button Undo Todo exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void uiVerifyButtonUndoDisable() {
        try {
            Thread.sleep(2000);

            if (btnUndoTodo.getAttribute("class").toString().equals("fa fa-undo disabled")) {
                NXGReports.addStep("Verify button Undo Todo disable.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("verify button Undo Todo disable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void uiVerifyButtonUndoEnable() {
        try {
            Thread.sleep(2000);

            if (btnUndoTodo.getAttribute("class").toString().equals("fa fa-undo")) {
                NXGReports.addStep("Verify button Undo Todo enable.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("verify button Undo Todo enable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void navigateToEngagementDetailPage() {
        waitForVisibleElement(eleToDoListLnk, "Todo link text");
    }
}

