package com.auvenir.ui.pages.auditor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import com.auvenir.ui.pages.common.AbstractPage;

import java.util.List;

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

	@FindAll(@FindBy(xpath="//div[@class='e-widget-content']//div[@class='e-widget-options']//input[@type='button']"))
	private List<WebElement> eleViewEngagementPage;

	@FindAll(@FindBy(xpath="//div[@class='e-widget-content']//div[@class='e-widget-options']"))
	private List<WebElement> planningEngagementPage;
	
	@FindBy(xpath="//nav[@id='dashboardLinks']//div[@id='engagementTodoLink']")
	private WebElement eleToDoLnk;

	@FindBy(xpath="//div[@id='divName']/div/input[@id='todo-name']")
	private WebElement eleToDoNameInput;

	@FindBy(xpath="//input[@id='due-date']")
	private WebElement eleDueDateInput;

	@FindBy(xpath="//div[@id='divName']/div/p[@class='auv-inputError']")
	private WebElement eleToDoNameErrorLabel;

	public void verifyToDoListPage() throws Exception {
		 validateAttributeElement(eleCreateToDoBtn,"background","#2c8188");
		 validateAttributeElement(eleCreateToDoBtn,"color","#fff");
		 validateDisPlayedElement(eleCreateToDoBtn,"eleCreateToDoBtn");
		 validateDisPlayedElement(eleFilterBtn,"eleFilterBtn");
		 validateDisPlayedElement(eleToDoSearchInput,"eleFilterBtn");
		 validateAttributeElement(eleToDoSearchInput,"placeholder","Search...");
		 eleToDoSearchInput.click();
		 validateAttributeElement(eleCreateToDoBtn,"border","#599ba1");
		 validateDisPlayedElement(eleCheckBox,"eleCheckBox");
		 validateElementText(eleNameToDoTitleLabel, "To-Dos");
		 validateElementText(eleCategoryTitleLabel, "Category");
		 validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
		 validateElementText(eleDueDateTitleLabel, "Due Date");
		 validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
		 validateDisPlayedElement(eleSortByNameToDo,"eleSortByNameToDo");
		 validateDisPlayedElement(eleSortByClientAssignee,"eleSortByClientAssignee");
		 validateDisPlayedElement(eleSortByDueDate,"eleSortByDueDate");
		 validateDisPlayedElement(eleSortByAuditAssignee,"eleSortByAuditAssignee");
		 if(!this.eleCheckBox.isSelected()){
			 this.eleCheckBox.click();
		 }
		 this.validateAttributeElement(this.eleCreateToDoBtn,"background","#5cd4c0");		 
		 if(this.eleCheckBox.isSelected()){
			 this.eleCheckBox.click();
		 }
		 this.validateAttributeElement(this.eleCreateToDoBtn,"background","#cacece");		 	 
	}
	
	public void navigateToEngagementTask(){
		if(eleViewEngagementPage.size()>0)
			clickAndHold(eleViewEngagementPage.get(0),"eleViewEngagementPage");
		else{
			//ToDo: With create new Engagement Task
			clickAndHold(eleViewEngagementPage.get(0),"eleViewEngagementPage");
		}
	}
	
	public void navigateToToDoList(){
		waitForClickableOfElement(eleToDoLnk,"eleToDoLnk");
		eleToDoLnk.click();
	}

	public void clickCreateToDoTask(){
		waitForClickableOfElement(eleCreateToDoBtn,"eleCreateToDoBtn");
		eleCreateToDoBtn.click();
	}

	public void verifyDefaultValueToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput,"eleToDoNameInput");
		validateDisPlayedElement(eleToDoNameInput,"eleToDoNameInput");
		validateAttributeElement(eleToDoNameInput,"placeholder","Write your first to do here");
	}
	public void verifyCssValueToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput,"eleToDoNameInput");
		clickAndHold(eleToDoNameInput,"eleToDoNameInput");
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgb(89, 155, 161)");
	}
	public void verifyCssValueWarningToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput,"eleToDoNameInput");
		waitForVisibleElement(eleDueDateInput,"eleDueDateInput");
		clickAndHold(eleToDoNameInput,"eleToDoNameInput");
		eleDueDateInput.click();
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgba(253, 109, 71, 0.4)");
		//waitForVisibleElement(eleToDoNameErrorLabel);
		//validateElementText(eleToDoNameErrorLabel,"Not a valid name.");
	}


	//Will be deleted after finish coding
	public void verifyAddNewToDoTask(){
		validateDisPlayedElement(eleToDoNameInput,"eleToDoNameInput");
		validateAttributeElement(eleToDoNameInput,"placeholder","Write your first to do here");//Write your first to do here
		clickAndHold(eleToDoNameInput,"eleToDoNameInput");
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgb(89, 155, 161)");

	}

	public void verifyInputValueToDoNameTextBox(String Value) {
		waitForVisibleElement(eleToDoNameInput,"eleToDoNameInput");
		eleToDoNameInput.clear();
		eleToDoNameInput.sendKeys(Value);
		validateAttributeElement(eleToDoNameInput, "value", Value);
	}
}
