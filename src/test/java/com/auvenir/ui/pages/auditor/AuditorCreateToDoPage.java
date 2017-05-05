package com.auvenir.ui.pages.auditor;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.String;
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
	
	@FindBy(xpath="//div[@class='e-widget-content']//div[@class='e-widget-options']//input[@type='button']")
	private WebElement[] eleViewEngagementPage;
	
	@FindBy(xpath="//nav[@id='dashboardLinks']//div[@id='engagementTodoLink']")
	private WebElement eleToDoLnk;

	@FindBy(id="todo-search")
	private WebElement txtIdTodoSearch;
	@FindBy(id="todo-table")
	private WebElement tblIdTodoTable;

	public void verifyToDoListPage() throws Exception {
		 //this.validateAttributeElement(this.eleCreateToDoBtn,"background","#2c8188");
		 //this.validateAttributeElement(this.eleCreateToDoBtn,"color","#fff");
		 this.validateDisPlayedElement(this.eleCreateToDoBtn);
		 this.validateDisPlayedElement(this.eleFilterBtn);
		 this.validateDisPlayedElement(this.eleToDoSearchInput);
		 //this.validateAttributeElement(this.eleToDoSearchInput,"placeholder","Search...");
		 this.eleToDoSearchInput.click();
		 //this.validateAttributeElement(this.eleCreateToDoBtn,"border","#599ba1");
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
		 //this.validateAttributeElement(this.eleCreateToDoBtn,"background","#5cd4c0");
		 if(this.eleCheckBox.isSelected()){
			 this.eleCheckBox.click();
		 }
		 //this.validateAttributeElement(this.eleCreateToDoBtn,"background","#cacece");
	    }
	
	public void navigateToEngagementPage(){
		waitForClickableOfElement(eleViewEngagementPage[0]);
		eleViewEngagementPage[0].click();
	}
	
	public void navigateToToDoList(){
		waitForClickableOfElement(eleToDoLnk);
		eleToDoLnk.click();
	}

	public boolean checkSearchData(String strSearchData)
	{
	    boolean isCheckData = false;
        waitForVisibleElement(txtIdTodoSearch);
        txtIdTodoSearch.sendKeys(strSearchData);
        // Check the result in the list data
        List<WebElement> tr_collection = tblIdTodoTable.findElements(By.xpath("id('todo-table')/tbody/tr"));
        for (WebElement trElement : tr_collection) {
            List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
            for (WebElement tdElement : td_collection) {
                String strSearchValue = "";
                try {
                    strSearchValue = tdElement.findElement(By.tagName("input")).getAttribute("value");
                }
                catch(Exception ex)
                {}
                System.out.println("strSearchValue = " + strSearchValue);
                if(strSearchValue.equals(strSearchData))
                {
                    isCheckData = true;
                    break;
                }
            }
            if(isCheckData)
            {
                break;
            }
        }
        return isCheckData;
	}
}
