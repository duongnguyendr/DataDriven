package com.auvenir.ui.pages.auditor;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auvenir.ui.pages.common.AbstractPage;

public class AuditorCreateToDoPage  extends AbstractPage{

	public AuditorCreateToDoPage(Logger logger, WebDriver driver) {
		super(logger, driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//section//button[@id='auv-todo-createToDo']")
	private WebElement eleCreateToDoBtn;
	
	@FindBy(xpath="//section//button[@id='auv-todo-filter']")
	private WebElement eleFilterBtn;
	
	@FindBy(xpath="//section//input[@id='todo-search']")
	private WebElement eleToDoSearchInput;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//..//input[@type='checkbox']")
	private WebElement eleCheckBox;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//th[@data-id='name']")
	private WebElement eleNameToDoTitleLabel;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//th[@data-id='name']//i")
	private WebElement eleSortByNameToDo;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//th[@data-id='category']")
	private WebElement eleCategoryTitleLabel;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//th[@data-id='category']//i")
	private WebElement eleSortByCategory;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//th[@data-id='client']")
	private WebElement eleClientAssigneeTitleLabel;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//th[@data-id='client']//i")
	private WebElement eleSortByClientAssignee;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//..//th[@data-id='dueDate']")
	private WebElement eleDueDateTitleLabel;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//..//th[@data-id='dueDate']//i")
	private WebElement eleSortByDueDate;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//..//th[@data-id='audit']")
	private WebElement eleAuditAssigneeTitleLabel;	
	@FindBy(xpath="//table[@id='todo-table']//..//..//..//th[@data-id='audit']")
	private WebElement eleSortByAuditAssignee;
	
	@FindBy(xpath="//div[@class='e-widget-content']")
	private List<WebElement> eleWidgetContent;
	
	@FindBy(xpath="//div[@class='e-widget-content']//div[@class='e-widget-options']//input[@type='button']")
	private List<WebElement> eleViewEngagementPage;
	
	@FindBy(xpath="//nav[@id='dashboardLinks']//div[@id='engagementTodoLink']")
	private WebElement eleToDoLnk;
	

	public void verifyToDoListPage() throws Exception {
		
		 this.validateCssValueElement(this.eleCreateToDoBtn,"background-color","rgba(89, 155, 161, 1)");
		 this.validateCssValueElement(this.eleCreateToDoBtn,"color","rgba(255, 255, 255, 1)");
		 this.validateDisPlayedElement(this.eleCreateToDoBtn);
		 this.validateDisPlayedElement(this.eleFilterBtn);
		 this.validateDisPlayedElement(this.eleToDoSearchInput);
		 this.validateAttributeElement(this.eleToDoSearchInput,"placeholder","Search...");
		 this.eleToDoSearchInput.click();
		 this.validateCssValueElement(this.eleToDoSearchInput,"border-color","rgb(89, 155, 161)");
		 this.validateDisPlayedElement(this.eleCheckBox);
		 this.validateElementText(this.eleNameToDoTitleLabel, "To-Dos");
		 this.validateElementText(this.eleCategoryTitleLabel, "Category");	
		 this.validateElementText(this.eleClientAssigneeTitleLabel, "Client Assignee");
		 this.validateElementText(this.eleDueDateTitleLabel, "Due Date");
		 this.validateElementText(this.eleAuditAssigneeTitleLabel, "Audit Assignee");			 
		 this.validateDisPlayedElement(this.eleSortByNameToDo);	
		 this.validateDisPlayedElement(this.eleSortByClientAssignee);
		 this.validateDisPlayedElement(this.eleSortByDueDate);
		 this.validateDisPlayedElement(this.eleSortByAuditAssignee);		 
		 if(!this.eleCheckBox.isSelected()){
			 this.eleCheckBox.click();
		 }
		 this.validateCssValueElement(this.eleCheckBox,"background-color","rgba(92, 212, 192, 1)");		 
		 if(this.eleCheckBox.isSelected()){
			 this.eleCheckBox.click();
			 
		 }
		 this.validateCssValueElement(this.eleCheckBox,"background-color","rgba(202, 206, 206, 1)");		 	 
	    }
	
	public void navigateToEngagementPage() throws Exception{
		getLogger().info("Click view button open Engagement Page");
		waitForClickableOfElement(eleWidgetContent.get(0));
		ClickAndHold(eleWidgetContent.get(0));
	}
	
	public void navigateToToDoList() throws Exception{
		waitForClickableOfElement(eleToDoLnk);
		eleToDoLnk.click();
	}

}
