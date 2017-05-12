package com.auvenir.ui.pages.auditor;

//import library
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

public class AuditorTodoListPage  extends AbstractPage{ 

	public AuditorTodoListPage(Logger logger, WebDriver driver) {
		super(logger, driver);
	}
	
	@FindBy(id="auv-todo-createToDo")
	private WebElement eleCreateToDoBtn;
	
	@FindBy(id="auv-todo-filter")
	private WebElement eleFilterBtn;
	
	@FindBy(id="todo-search")
	private WebElement eleToDoSearchInput;
	
	@FindBy(xpath="//table[@id='todo-table']//..//..//th//input[@type='checkbox']")
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
	@FindBy(xpath="//th[@data-id='audit']//i")
	private WebElement eleSortByAuditAssignee;
	
	
	@FindBy(xpath="//tr[@id='empty-todo']//..//..//img")
	private WebElement eleImgEmtyToDo;
	
	@FindBy(xpath="//tr[@id='empty-todo']//td//div//div")
	private WebElement eleNotesEmtyToDo;
	
	
	 public void verifyTodoListPage() throws Exception {
		 getLogger().info("verify create to do button.");
		 	verifyButtonCreateToDo();
	     NXGReports.addStep("verify create to do button.", LogAs.PASSED, null);
		
		 getLogger().info("verify filter button.");
		 verifyButtonFilter();		
	     NXGReports.addStep("verify filter button.", LogAs.PASSED, null);
		 
		 getLogger().info("verify check on checkbox.");
		 verifyCheckOnCheckBox();
	     NXGReports.addStep("verify check on checkbox.", LogAs.PASSED, null);
		
		 getLogger().info("verify uncheck on checkbox.");
		 verifyUnCheckOnCheckBox();
	     NXGReports.addStep("verify uncheck on checkbox.", LogAs.PASSED, null);
		 
		 getLogger().info("verify columns in gird.");
		 verifyColumnsInGrid();
	     NXGReports.addStep("verify columns in gird.", LogAs.PASSED, null);
		
		 getLogger().info("verify icon sort on title.");
		 verifySortOnTitle();
	     NXGReports.addStep("verify icon sort on title.", LogAs.PASSED, null);
		
		 getLogger().info("verify search hover.");
		 verifySearchHover();
	     NXGReports.addStep("verify search hover.", LogAs.PASSED, null);
		
		 getLogger().info("verify input text for field search.");
		 verifySearchInputText();
	     NXGReports.addStep("verify input text for field search.", LogAs.PASSED, null);
		 
		 getLogger().info("verify input number for field search.");
		 verifySearchInputNumber();	
	     NXGReports.addStep("verify input number for field search.", LogAs.PASSED, null);
		 
		 getLogger().info("verify default value(hint) field search.");
		 verifySearchDefault();
	     NXGReports.addStep("verify default value(hint) field search.", LogAs.PASSED, null);
		 
		
	  }

	public void verifyEmptyTodoList() throws Exception {
		waitForVisibleElement(eleImgEmtyToDo);
    	validateDisPlayedElement(eleImgEmtyToDo);		
    	waitForVisibleElement(eleNotesEmtyToDo);
		validateDisPlayedElement(eleNotesEmtyToDo);
	}
	
	
	
	
	
	public void verifyButtonCreateToDo()throws Exception {
		 validateCSSValueElement(eleCreateToDoBtn,"background-color","rgba(89, 155, 161, 1)");
		 validateCSSValueElement(eleCreateToDoBtn,"color","rgba(255, 255, 255, 1)");
		 validateDisPlayedElement(eleCreateToDoBtn);
		
	}
	
	public void verifyButtonFilter()throws Exception {
		validateDisPlayedElement(eleFilterBtn);		
	}
	
	public void verifySearchDefault()throws Exception {
		 validateAttributeElement(eleToDoSearchInput,"placeholder","Search...");	
	}
	
	public void verifySearchHover()throws Exception {
		 clickAndHold(eleToDoSearchInput);
		 waitForPresentOfLocator(By.xpath("//input[@id='todo-search']"));
		 
		 validateCSSValueElement(eleToDoSearchInput,"border-color","rgb(89, 155, 161)");
	}
	
	public void verifySearchInputText()throws Exception {
		enterSearchToDoTask("To do task name");
		 validateAttributeElement(eleToDoSearchInput, "value",  "To do task name");
	}

	
	public void verifySearchInputNumber()throws Exception {
		enterSearchToDoTask("123");
		 validateAttributeElement(eleToDoSearchInput, "value", "123");
	}
	
		
	public void verifyColumnsInGrid()throws Exception {
		validateElementText(eleNameToDoTitleLabel, "To-Dos");
		 validateElementText(eleCategoryTitleLabel, "Category");	
		 validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
		 validateElementText(eleDueDateTitleLabel, "Due Date");
		 validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
	}
	

	public void verifySortOnTitle()throws Exception {
		validateDisPlayedElement(eleSortByNameToDo);	
		 validateDisPlayedElement(eleSortByClientAssignee);
		 validateDisPlayedElement(eleSortByDueDate);
		 validateDisPlayedElement(eleSortByAuditAssignee);
	}
	
	public void verifyCheckOnCheckBox()throws Exception {
		checkAllToDoTask();
		waitForPresentOfLocator(By.xpath("//table[@id='todo-table']//..//..//th//input[@type='checkbox']"));
		 validateCSSValueElement(eleCheckBox,"background-color","rgba(92, 212, 192, 1)");	
	}
	
	public void verifyUnCheckOnCheckBox()throws Exception {
		unCheckAllToDoTask();
		waitForPresentOfLocator(By.xpath("//table[@id='todo-table']//..//..//th//input[@type='checkbox']"));
		 validateCSSValueElement(eleCheckBox,"background-color","rgba(202, 206, 206, 1)");
	}
	
	public void clickCreateToDoBtn(){
		clickElement(eleCreateToDoBtn);
	}
	
	public void checkAllToDoTask(){
		if(!eleCheckBox.isSelected()){
			clickOnCheckBox(eleCheckBox);			
		 }
	}
	
	public void unCheckAllToDoTask(){
		if(eleCheckBox.isSelected()){
			clickOnCheckBox(eleCheckBox);			
		 }
	}
	
	public void enterSearchToDoTask(String searchValue){
		sendKeyTextBox(eleToDoSearchInput, searchValue);
	}
	
	public void clickSortByNameToDoTask(){
		clickElement(eleSortByNameToDo);
	}
	
	public void clickSortByAuditAssignee(){
		clickElement(eleSortByAuditAssignee);
	}
	
	public void clickSortByCategory(){
		clickElement(eleSortByCategory);
	}
	
	public void clickSortByDueDate(){
		clickElement(eleSortByDueDate);
	}
	
	public void clickSortByClientAssignee(){
		clickElement(eleSortByClientAssignee);
	}
	
	
	

}