package com.auvenir.ui.pages.client;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
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

import java.util.List;

public class ClientToDoPage extends AbstractPage{
	
	public ClientToDoPage(Logger logger, WebDriver driver){
		super(logger, driver);
	}

    AuditorCreateToDoPage auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());

	
	@FindBy(xpath = "//*[@id='todo-table']/tbody/tr")
    private List<WebElement> toDoTaskRowEle;
	
	
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

    public void verifyToDoTaskExist(String toDoName, boolean isClient){
        try{

            int index = auditorCreateToDoPage.findToDoTaskName(toDoName, isClient);
            if (index != -1) {
                NXGReports.addStep("Verify ToDo task: " + toDoName + " exists.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt ++;
                NXGReports.addStep("Verify ToDo task: " + toDoName + " exists.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            waitSomeSeconds(5);
        } catch (Exception e) {
            AbstractService.sStatusCnt ++;
            NXGReports.addStep("Verify ToDo task: " + toDoName + " exists.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}
