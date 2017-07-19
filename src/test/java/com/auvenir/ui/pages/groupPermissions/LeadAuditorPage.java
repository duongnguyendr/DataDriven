package com.auvenir.ui.pages.groupPermissions;

import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.todo.AuditorTodoListPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duong.nguyen on 7/17/2017.
 */
public class LeadAuditorPage extends AbstractPage {
    AuditorCreateToDoPage auditorCreateToDoPage;
    public LeadAuditorPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
    }

    @FindBy(xpath = "//div[@id='engagement-todo']//table[@id='todo-table']//td//div[@class='fileNumber']")
    private List<WebElement> listNumberFileRequest;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div/div[2]")
    List<WebElement> uploadRequestList;

    private String newRequestImgByTodoName = "//*[@id='todo-table']/tbody/tr/td/input[@data-dbname='%s']//../../td/img";

    public int getTotalNumberFileRequest(){
        int totalNumberFileRequest = 0;
        for (WebElement el : listNumberFileRequest){
            totalNumberFileRequest += Integer.parseInt(el.getText());
        }
        return  totalNumberFileRequest;
    }

    public void verifyLeadAuditorSeeAllFileRequest(int numberFileRequest){
        int totalFileRequest = getTotalNumberFileRequest();
        if (numberFileRequest == totalFileRequest){
            NXGReports.addStep("verify lead auditor can see all file request within engagement.", LogAs.PASSED, null);
        }else{
            NXGReports.addStep("verify lead auditor can see all file request within engagement.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickOpenNewRequestByTodoName(String toDoName){
        try{
            WebElement addNewRequestImg = getDriver().findElement(By.xpath(String.format(newRequestImgByTodoName, toDoName)));
            clickElement(addNewRequestImg, "Click open request windows.");
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Click open request windows.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyFileRequestInTodo(String toDoName, String... fileNames){
        try{
            clickOpenNewRequestByTodoName(toDoName);
            List<String> lstFileDisplayed = new ArrayList<String>();
            for (WebElement el : uploadRequestList){
                lstFileDisplayed.add(el.getText());
            }
            for (String fileName : fileNames){
                if (!lstFileDisplayed.contains(fileName)){
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("verify file request displayed in todo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                            .BROWSER_PAGE));
                }
            }
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify file request displayed in todo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE));
        }finally {
            auditorCreateToDoPage.closeAddNewRequestWindow();
        }
    }
}
