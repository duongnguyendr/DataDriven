<<<<<<< HEAD
package com.auvenir.ui.pages.auditor;

//import library
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
	
	@FindBy(id="auv-todo-createToDo")
	private WebElement eleCreateToDoBtn;
	
	@FindBy(id="auv-todo-filter")
	private WebElement eleFilterBtn;
	
	@FindBy(id="todo-search")
	private WebElement eleToDoSearchInput;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement eleCheckBox;
	
	@FindBy(xpath="//th[@data-id='name']")
	private WebElement eleNameToDoTitleLabel;
	
	@FindBy(xpath="//th[@data-id='name']//i")
	private WebElement eleSortByNameToDo;
	
	@FindBy(xpath="//th[@data-id='category']")
	private WebElement eleCategoryTitleLabel;
	
	@FindBy(xpath="//th[@data-id='category']//i")
	private WebElement eleSortByCategory;
	
	@FindBy(xpath="//th[@data-id='client']")
	private WebElement eleClientAssigneeTitleLabel;
	
	@FindBy(xpath="//th[@data-id='client']//i")
	private WebElement eleSortByClientAssignee;
	
	@FindBy(xpath="//th[@data-id='dueDate']")
	private WebElement eleDueDateTitleLabel;
	
	@FindBy(xpath="//th[@data-id='dueDate']//i")
	private WebElement eleSortByDueDate;
	
	@FindBy(xpath="//th[@data-id='audit']")
	private WebElement eleAuditAssigneeTitleLabel;	
	@FindBy(xpath="//th[@data-id='audit']")
	private WebElement eleSortByAuditAssignee;
	
	@FindBy(xpath="//div[@class='e-widget-content']")
	private List<WebElement> eleWidgetContent;
	
	@FindBy(xpath="//div[@class='e-widget-content']//div[@class='e-widget-options']//input[@type='button']")
	private List<WebElement> eleViewEngagementPage;
	
	@FindBy(id="engagementTodoLink")
	private WebElement eleToDoLnk;
	
	@FindBy(xpath="//tr[@id='empty-todo']//..//..//img")
	private WebElement eleImgEmtyToDo;
	
	@FindBy(xpath="//tr[@id='empty-todo']//..//..//div")
	private WebElement eleNotesEmtyToDo;
	
	public void verifyImgEmtyToDo()throws Exception {
		this.validateDisPlayedElement(this.eleImgEmtyToDo);		
	}
	
	
	
	public void verifyButtonCreateToDo()throws Exception {
		 this.validateCssValueElement(this.eleCreateToDoBtn,"background-color","rgba(89, 155, 161, 1)");
		 this.validateCssValueElement(this.eleCreateToDoBtn,"color","rgba(255, 255, 255, 1)");
		 this.validateDisPlayedElement(this.eleCreateToDoBtn);
		
	}
	
	public void verifyButtonFilter()throws Exception {
		this.validateDisPlayedElement(this.eleFilterBtn);		
	}
	
	public void verifySearchDefault()throws Exception {
		 this.validateAttributeElement(this.eleToDoSearchInput,"placeholder","Search...");	
	}
	
	public void verifySearchHover()throws Exception {
		 this.eleToDoSearchInput.click();
		 this.validateCssValueElement(this.eleToDoSearchInput,"border-color","rgb(89, 155, 161)");
	}
	
	public void verifySearchInputText()throws Exception {
		this.eleToDoSearchInput.click();
		 this.eleToDoSearchInput.sendKeys("Search to do");
		 System.out.println(this.eleToDoSearchInput.getText());
		 this.validateAttributeElement(this.eleToDoSearchInput, "value",  "Search to do");
	}
	
	public void verifySearchLimit255()throws Exception {
		this.eleToDoSearchInput.click();
		 this.eleToDoSearchInput.sendKeys("limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character  limit with 255 character ");
		this.validateMaxlenght(this.eleToDoSearchInput, 255);
	}
	
	public void verifySearchInputNumber()throws Exception {
		this.eleToDoSearchInput.click();	
		this.eleToDoSearchInput.sendKeys("123");
		 this.validateAttributeElement(this.eleToDoSearchInput, "value", "123");
	}
	
		
	public void verifyColumnsInGrid()throws Exception {
		this.validateElementText(this.eleNameToDoTitleLabel, "To-Dos");
		 this.validateElementText(this.eleCategoryTitleLabel, "Category");	
		 this.validateElementText(this.eleClientAssigneeTitleLabel, "Client Assignee");
		 this.validateElementText(this.eleDueDateTitleLabel, "Due Date");
		 this.validateElementText(this.eleAuditAssigneeTitleLabel, "Audit Assignee");
	}
	

	public void verifySotleOnTitle()throws Exception {
		this.validateDisPlayedElement(this.eleSortByNameToDo);	
		 this.validateDisPlayedElement(this.eleSortByClientAssignee);
		 this.validateDisPlayedElement(this.eleSortByDueDate);
		 this.validateDisPlayedElement(this.eleSortByAuditAssignee);
	}
	
	public void verifyCheckOnCheckBox()throws Exception {
		if(!this.eleCheckBox.isSelected()){
			 this.eleCheckBox.click();
		 }
		 this.validateCssValueElement(this.eleCheckBox,"background-color","rgba(92, 212, 192, 1)");	
	}
	
	public void verifyUnCheckOnCheckBox()throws Exception {
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
=======
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
		 this.validateAttributeElement(this.eleCreateToDoBtn,"background","#2c8188");
		 this.validateAttributeElement(this.eleCreateToDoBtn,"color","#fff");
		 this.validateDisPlayedElement(this.eleCreateToDoBtn);
		 this.validateDisPlayedElement(this.eleFilterBtn);
		 this.validateDisPlayedElement(this.eleToDoSearchInput);
		 this.validateAttributeElement(this.eleToDoSearchInput,"placeholder","Search...");
		 this.eleToDoSearchInput.click();
		 this.validateAttributeElement(this.eleCreateToDoBtn,"border","#599ba1");
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
		 this.validateAttributeElement(this.eleCreateToDoBtn,"background","#5cd4c0");		 
		 if(this.eleCheckBox.isSelected()){
			 this.eleCheckBox.click();
		 }
		 this.validateAttributeElement(this.eleCreateToDoBtn,"background","#cacece");		 	 
	}
	
	public void navigateToEngagementTask(){
		if(eleViewEngagementPage.size()>0)
			ClickAndHold(eleViewEngagementPage.get(0));
		else{
			//ToDo: With create new Engagement Task
			ClickAndHold(eleViewEngagementPage.get(0));
		}
	}
	
	public void navigateToToDoList(){
		waitForClickableOfElement(eleToDoLnk);
		eleToDoLnk.click();
	}

	public void clickCreateToDoTask(){
		waitForClickableOfElement(eleCreateToDoBtn);
		eleCreateToDoBtn.click();
	}

	public void verifyDefaultValueToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput);
		validateDisPlayedElement(eleToDoNameInput);
		validateAttributeElement(eleToDoNameInput,"placeholder","Write your first to do here");
	}
	public void verifyCssValueToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput);
		ClickAndHold(eleToDoNameInput);
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgb(89, 155, 161)");
	}
	public void verifyCssValueWarningToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput);
		waitForVisibleElement(eleDueDateInput);
		ClickAndHold(eleToDoNameInput);
		eleDueDateInput.click();
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgba(253, 109, 71, 0.4)");
		//waitForVisibleElement(eleToDoNameErrorLabel);
		//validateElementText(eleToDoNameErrorLabel,"Not a valid name.");
	}


	//Will be deleted after finish coding
	public void verifyAddNewToDoTask(){
		validateDisPlayedElement(eleToDoNameInput);
		validateAttributeElement(eleToDoNameInput,"placeholder","Write your first to do here");//Write your first to do here
		ClickAndHold(eleToDoNameInput);
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgb(89, 155, 161)");

	}

	public void verifyInputValueToDoNameTextBox(String Value) {
		waitForVisibleElement(eleToDoNameInput);
		eleToDoNameInput.clear();
		eleToDoNameInput.sendKeys(Value);
		validateAttributeElement(eleToDoNameInput, "value", Value);
	}
}
>>>>>>> origin/thuan.duong
