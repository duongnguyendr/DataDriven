package com.auvenir.ui.pages.client;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

public class ClientToDoPage extends AbstractPage{
	
	public ClientToDoPage(Logger logger, WebDriver driver){
		super(logger, driver);
	}
	
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

}
