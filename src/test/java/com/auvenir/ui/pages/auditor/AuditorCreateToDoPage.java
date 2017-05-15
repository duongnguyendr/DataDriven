package com.auvenir.ui.pages.auditor;

//import library
import java.util.List;

import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auvenir.ui.pages.common.AbstractPage;
import org.testng.Assert;

public class AuditorCreateToDoPage  extends AbstractPage{

	public AuditorCreateToDoPage(Logger logger, WebDriver driver) {
		super(logger, driver);
		PageFactory.initElements(driver, this);
	}

	@FindAll(@FindBy(xpath="//div[@class='e-widget-content']//div[@class='e-widget-options']"))
	private List<WebElement> planningEngagementPage;

    private String todoNamePage = "";
    private String todoContentTextSearch = "name";
    public static  final int smallTimeOut = 2000;

	@FindBy(id="auv-todo-createToDo")
	private WebElement createToDoBtnEle;

	@FindBy(id="auv-todo-filter")
	private WebElement eleFilterBtn;

	@FindBy(id="todo-search")
	private WebElement eleToDoSearchInput;

	@FindBy(xpath="//*[@id='todo-table']/thead//th/input[@type='checkbox']")
	private WebElement eleCheckBox;

	@FindBy(xpath="//th[@data-id='name']")
	private WebElement eleNameToDoTitleLabel;

	@FindBy(xpath="//th[@data-id='name']//i")
	private WebElement sortByToDoNameIconEle;

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

	@FindBy(id="category-dropdown")
	private WebElement categoryDropdownEle;
	@FindBy(xpath = "//*[@id=\"category-dropdown-menu\"]/div[3]")
	private WebElement categoryOptionItemEle;
	@FindBy(id="due-date")
	private WebElement dueDateFieldEle;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")
	private WebElement dateItemonCalendarEle;

	public void verifyImgEmtyToDo()throws Exception {
		validateDisPlayedElement(eleImgEmtyToDo,"EmptyTodoImage");
	}

	@FindBy(xpath="//div[@id='divName']/div/input[@id='todo-name']")
	private WebElement toDoNameInputEle;

	@FindBy(xpath="//*/table[@id='todo-table']//div[@id='divName']//p[@class='auv-inputError']")
	private WebElement toDoNameErrorLabelEle;

	@FindBy(xpath="//*[@id='todo-add-btn']")
	private WebElement toDoSaveIconEle;
	public WebElement getToDoSaveIconEle() {
		return toDoSaveIconEle;
	}

	@FindBy(xpath="//*[@id='todo-cancel-btn']")
	private WebElement eleToDoCloseIcon;

	@FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']")
	private List<WebElement> eleToDoNewRow;

	@FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@type='checkbox']")
	private List<WebElement> eleToDoCheckboxRow;

	@FindBy(id="todo-search")
	private WebElement txtIdTodoSearch;
	@FindBy(id="todo-table")
	private WebElement tblIdTodoTable;
	@FindBy(id="todo-name")
	private WebElement createToDoNameTextBoxEle;
	@FindBy(id="todo-add-btn")
	private WebElement eleBtnToDoAdd;

	@FindBy(xpath="//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@class='newTodoInput']")
	private List<WebElement> toDoNameTextColumnEle;
	public List<WebElement> getToDoNameTextColumnEle() {
		return toDoNameTextColumnEle;
	}

    @FindBy(xpath = "//*[@id='category-dropdown']/div[@class='text']")
    private List<WebElement> eleCategoryComboBoxText;

    //Category ComboBox
    @FindBy(id ="category-dropdown")
    private List<WebElement> categoryComboBoxEle;

    //Category dropdown menu
    @FindBy(id = "category-dropdown-menu")
    private List<WebElement> categoryComboBoxMenuEle;

    @FindBy(xpath = "//*[@id='category-dropdown-menu']/div[1]")
    private WebElement addNewCategoryMenuItemEle;

    @FindBy(xpath = "//*[@id='category-dropdown-menu']/div[2]")
    WebElement editCategoryEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//h3 [@class='setup-header']")
    WebElement categoryTitleEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//img[starts-with(@id,'modal-close-categoryModel')]")
    WebElement eleEditCategoryCloseBtn;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//button[@id = 'm-ce-cancelBtn']")
    WebElement editCategoryCancelBtnEle;
	
	public void verifyGUIButtonCreateToDo(){
		try{
			boolean result;
			result = validateCssValueElement(createToDoBtnEle,"background-color","rgba(89, 155, 161, 1)");
			Assert.assertTrue(result, "Background-color of Create To Do Button is displayed unsuccessfully");
			result = validateCssValueElement(createToDoBtnEle,"color","rgba(255, 255, 255, 1)");
			Assert.assertTrue(result, "Text Color of Create To Do Button is displayed unsuccessfully");
			result = validateDisPlayedElement(createToDoBtnEle,"Create Todo Button");
			Assert.assertTrue(result, "Text Value of Create To Do Button is displayed unsuccessfully");
			NXGReports.addStep("Verify GUI of Create To Do Button", LogAs.PASSED, null);
		}catch (AssertionError e){
			AbstractService.sStatusCnt++;
			getLogger().info("GUI of Create To Do Button is displayed unsuccessfully");
			NXGReports.addStep("TestScript Failed: Verify GUI of Create To Do Button", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyButtonFilter()throws Exception {
		validateDisPlayedElement(eleFilterBtn,"Filer Button");
	}




	public void verifyColumnsInGrid()throws Exception {
		validateElementText(eleNameToDoTitleLabel, "To-Dos");
		validateElementText(eleCategoryTitleLabel, "Category");
		validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
		validateElementText(eleDueDateTitleLabel, "Due Date");
		validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
	}


	public void verifySotleOnTitle()throws Exception {
		validateDisPlayedElement(sortByToDoNameIconEle,"Sort By Name Button");
		validateDisPlayedElement(eleSortByClientAssignee,"Sort By Client Assignee Button.");
		validateDisPlayedElement(eleSortByDueDate,"Sort By");
		validateDisPlayedElement(eleSortByAuditAssignee,"Sort by Auditor Assignee button.");
	}


	public void verifyToDoListPage() throws Exception {
		validateAttributeElement(createToDoBtnEle,"background","#2c8188");
		validateAttributeElement(createToDoBtnEle,"color","#fff");
		validateDisPlayedElement(createToDoBtnEle,"Create Todo Button");
		validateDisPlayedElement(eleFilterBtn,"Filter Button");
		validateDisPlayedElement(eleToDoSearchInput,"Search button");
		validateAttributeElement(eleToDoSearchInput,"placeholder","Search...");
		eleToDoSearchInput.click();
		validateAttributeElement(createToDoBtnEle,"border","#599ba1");
		validateDisPlayedElement(eleCheckBox,"Check Box");
		validateElementText(eleNameToDoTitleLabel, "To-Dos");
		validateElementText(eleCategoryTitleLabel, "Category");
		validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
		validateElementText(eleDueDateTitleLabel, "Due Date");
		validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
		validateDisPlayedElement(sortByToDoNameIconEle,"Sort By Name");
		validateDisPlayedElement(eleSortByClientAssignee,"Sort By Assign button.");
		validateDisPlayedElement(eleSortByDueDate,"Sort By Due Date button.");
		validateDisPlayedElement(eleSortByAuditAssignee,"Sort by Auditor Assignee.");
		if(!eleCheckBox.isSelected()){
			eleCheckBox.click();
		}
		validateAttributeElement(createToDoBtnEle,"background","#5cd4c0");
		if(eleCheckBox.isSelected()){
			eleCheckBox.click();
		}
		validateAttributeElement(createToDoBtnEle,"background","#cacece");
	}


	public void clickCreateToDoTask(){
		waitForClickableOfElement(createToDoBtnEle,"Create Todo button");
		createToDoBtnEle.click();
	}

	public void verifyDefaultValueToDoNameTextBox(){
		try{
			boolean result;
			getLogger().info("Verify Default Value To Do Text Box");
			waitForVisibleElement(toDoNameInputEle,"Todo name input field.");
			validateDisPlayedElement(toDoNameInputEle,"Todo name input field.");
			result = validateAttributeElement(toDoNameInputEle,"placeholder","Write your to do here");
			Assert.assertTrue(result, "Default Value To Do TextBox is displayed unsuccessfully");
			NXGReports.addStep("Verify Default Value To Do Text Box", LogAs.PASSED, null);
		}catch (AssertionError e){
			AbstractService.sStatusCnt++;
			getLogger().info("Default Value To Do TextBox is displayed unsuccessfully");
			NXGReports.addStep("TestScript Failed: Verify Default Value To Do Text Box", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}

	}
	public void verifyHoverCssValueToDoNameTextBox(){
		try{
			boolean result;
			getLogger().info("Verify Hover CSS Value To Do Text Box");
			waitForVisibleElement(toDoNameInputEle,"Todo Name input field");
			clickAndHold(toDoNameInputEle,"Todo Name input field");
			result = validateCSSValueElement(toDoNameInputEle,"border","1px solid rgb(89, 155, 161)");
			Assert.assertTrue(result, "Hover CSS Value of To Do TextBox is displayed unsuccessfully");
			NXGReports.addStep("Verify Hover CSS Value of To Do Text Box", LogAs.PASSED, null);
		}catch (AssertionError e){
			AbstractService.sStatusCnt++;
			getLogger().info("Hover CSS Value of To Do TextBox is displayed unsuccessfully");
			NXGReports.addStep("TestScript Failed: Verify Hover CSS Value To Do Text Box", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	public void verifyWarningCssValueToDoNameTextBox(){
		try{
			boolean result;
			getLogger().info("Verify CSS Value Warning To Do Name Text Box");
			waitForVisibleElement(toDoNameInputEle,"Todo name input field");
			waitForVisibleElement(dueDateFieldEle,"Due Date input field");
			clickAndHold(toDoNameInputEle,"Todo Name input field");
			dueDateFieldEle.click();
			result = validateCSSValueElement(toDoNameInputEle,"border","1px solid rgba(253, 109, 71, 0.4)");
			Assert.assertTrue(result, "Warning CSS Value of To Do TextBox is displayed unsuccessfully");
			waitForVisibleElement(toDoNameErrorLabelEle,"Todo Name error  Label");
			result = validateElementText(toDoNameErrorLabelEle,"Not a valid name.");
			Assert.assertTrue(result, "Warning Value of To Do TextBox is displayed unsuccessfully");
			NXGReports.addStep("Verify Warning CSS Value of To Do Text Box", LogAs.PASSED,null);
		}catch (AssertionError e){
			AbstractService.sStatusCnt++;
			getLogger().info("Warning CSS Value of To Do Name TextBox is displayed unsuccessfully");
			NXGReports.addStep("TestScript Failed: Verify Warning CSS Value To Do Name Text Box", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}


	public void verifyAddNewToDoTask(String toDoName) {
		try {
			boolean result;
			validateDisPlayedElement(toDoNameTextColumnEle.get(0),"Todo New Row Name");
			result = validateAttributeElement(toDoNameTextColumnEle.get(0), "value", toDoName);
			Assert.assertTrue(result, String.format("New To Do task '%s' is NOT added successfully",toDoName));
			NXGReports.addStep("New To Do task is added successfully", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("New To Do task is added unsuccessfully", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public boolean verifyInputValueToDoNameTextBox(String toDoNameValue) {
		try{
			boolean result;
			getLogger().info("Verify Input Value ToDo Name TextBox");
			waitForVisibleElement(toDoNameInputEle,"Todo Name input field");
			sendKeyTextBox(toDoNameInputEle, toDoNameValue, "To Do Name Input");
			result = validateAttributeElement(toDoNameInputEle, "value", toDoNameValue);
			Assert.assertTrue(result, "Input Value into ToDo Name TextBox is unsuccessfully");
			NXGReports.addStep("Verify Input Value ToDo Name TextBox", LogAs.PASSED, null);
			return true;
		}catch (AssertionError e) {
			AbstractService.sStatusCnt++;
			getLogger().info("Input Value into ToDo Name TextBox is unsuccessfully");
			NXGReports.addStep("TestScript Failed: Verify Input Value ToDo Name TextBox", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			return false;
		}
	}

	public boolean verifyCheckMaxLength()throws Exception {
		boolean isSearchText = false;
		txtIdTodoSearch.clear();
		Thread.sleep(smallerTimeOut);
		eleToDoSearchInput.sendKeys("12345678901112131415161718192021222324252627282930313233343536373839401234567890111213141516171819202122232425262728293031323334353637383940123456789011121314151617181920212223242526272829303132333435363738394011111111111111111111111111MMMMnnnnnnnnnn55255");
		Thread.sleep(smallerTimeOut);
		eleToDoSearchInput.sendKeys("678");
		// Get the text from eleToDoSearchInput
		Thread.sleep(smallerTimeOut);
		String txtSearchText = getTextByJavaScripts(eleToDoSearchInput);
		getLogger().info("The input txtSearchText = " + txtSearchText);
		if(txtSearchText.equals("12345678901112131415161718192021222324252627282930313233343536373839401234567890111213141516171819202122232425262728293031323334353637383940123456789011121314151617181920212223242526272829303132333435363738394011111111111111111111111111MMMMnnnnnnnnnn55255"))
		{
			isSearchText = true;
		}
		else
		{
			isSearchText = false;
		}
		getLogger().info("The result after comparing text search isSearchText = " + isSearchText);
		return isSearchText;
	}

	public  boolean verifyCreateNewCategory() throws Exception {
		return createNewCategory(categoryIndiMode);
	}

    public void createToDoTask(String toDoName)throws Exception {
			waitForClickableOfElement(createToDoBtnEle,"Create To Do Button");
			createToDoBtnEle.click();
			Thread.sleep(smallTimeOut);
			createToDoNameTextBoxEle.sendKeys(toDoName);
			// Create new category
			createNewCategory("");
			Thread.sleep(smallTimeOut);
			waitForClickableOfElement(categoryDropdownEle,"Category Dropdown");
			categoryDropdownEle.click();
			waitForClickableOfElement(categoryOptionItemEle,"Category Option Item");
			categoryOptionItemEle.click();
			waitForClickableOfElement(dueDateFieldEle,"Due Date field");
			dueDateFieldEle.click();
			waitForClickableOfElement(dateItemonCalendarEle,"Date value");
			dateItemonCalendarEle.click();
			waitForVisibleElement(toDoSaveIconEle,"Save Icon");
			toDoSaveIconEle.click();
			verifyAddNewToDoTask(toDoName);
    }

	public void createToDoTask()throws Exception {
		getLogger().info("Run createToDoTask()");
		todoNamePage = "To-do name " + randomNumber();
		waitForClickableOfElement(createToDoBtnEle,"create todo button.");
		this.createToDoBtnEle.click();
		Thread.sleep(smallTimeOut);
		createToDoNameTextBoxEle.sendKeys(todoNamePage);
		//waitForClickableOfElement(categoryDropdownEle);
		//categoryDropdownEle.click();
		// Create new category
		createNewCategory("");
		Thread.sleep(smallTimeOut);
		waitForClickableOfElement(categoryDropdownEle,"");
		categoryDropdownEle.click();
		waitForClickableOfElement(categoryOptionItemEle,"");
		categoryOptionItemEle.click();
		waitForClickableOfElement(dueDateFieldEle,"");
		Thread.sleep(2000);
		dueDateFieldEle.click();
		waitForClickableOfElement(dateItemonCalendarEle,"");
		dateItemonCalendarEle.click();
		waitForClickableOfElement(eleBtnToDoAdd,"");
		eleBtnToDoAdd.click();
	}

	public void verifyToDoNameInputLimitCharacter(int maxLength)throws Exception {
		waitForVisibleElement(toDoNameInputEle,"");
		validateMaxlenght(toDoNameInputEle, "ToDo Name Input",maxLength);
	}

	public void verifyToDoNameInputSpecialCharacter(String value)throws Exception {
		waitForVisibleElement(toDoNameInputEle,"");
		toDoNameInputEle.clear();
		toDoNameInputEle.sendKeys(value);
		dueDateFieldEle.click();
		waitForVisibleElement(toDoNameErrorLabelEle,"");
		validateElementText(toDoNameErrorLabelEle,"Not a valid name.");
	}

	public void verifyDisableToDoSaveIcon() {
		try {
			boolean result;
			waitForVisibleElement(toDoNameInputEle, "To Do Name Input");
			toDoNameInputEle.clear();
			waitForVisibleElement(toDoSaveIconEle, "To Do Save Icon");
			result = validateAttributeElement(toDoSaveIconEle, "class", "fa fa-floppy-o disabled");
			Assert.assertTrue(result, "To Do Save Icon is not disabled");
			getLogger().info("To Do Save Icon is disabled");
			NXGReports.addStep("Verify Disable ToDo Save Icon", LogAs.PASSED, null);
		} catch (AssertionError e) {
			AbstractService.sStatusCnt++;
			getLogger().info("To Do Save Icon is not disabled");
			NXGReports.addStep("TestScript Failed: Verify Disable ToDo Save Icon", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyEnableToDoSaveIcon(){
		try{
			boolean result;
			waitForVisibleElement(toDoNameInputEle,"To Do Name Input");
			toDoNameInputEle.sendKeys("Task01");
			waitForVisibleElement(toDoSaveIconEle,"To Do Save Icon");
			result = validateAttributeElement(toDoSaveIconEle, "class", "fa fa-floppy-o");
			Assert.assertTrue(result, "To Do Save Icon is not enabled");
			getLogger().info("To Do Save Icon is enabled");
			NXGReports.addStep("Verify Enabled ToDo Save Icon", LogAs.PASSED, null);
		}catch (AssertionError e){
			AbstractService.sStatusCnt++;
			getLogger().info("To Do Save Icon is not enabled");
			NXGReports.addStep("TestScript Failed: Verify Enabled ToDo Save Icon", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyToDoCloseIcon(){
		int count = -1;
		if(eleToDoNewRow.isEmpty())
			count = 0;
		else count = eleToDoNewRow.size();
		clickCreateToDoTask();
		waitForVisibleElement(eleToDoCloseIcon,"To Do Close Icon");
		eleToDoCloseIcon.click();
		getLogger().info("Verify new To Do Task is not created.");
		try {
			if (count == eleToDoNewRow.size()) {
				NXGReports.addStep("New To Do Task is not created", LogAs.PASSED, null);
				NXGReports.addStep("Close Icon is working", LogAs.PASSED, null);
			}
			else{
				AbstractService.sStatusCnt++;
				NXGReports.addStep("New To Do Task is created", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
				NXGReports.addStep("Close Icon is not working", LogAs.PASSED, null);
			}
		} catch (Exception e) {
			AbstractService.sStatusCnt++;
			NXGReports.addStep("New To Do Task is created", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			NXGReports.addStep("Close Icon is not working", LogAs.PASSED, null);
		}
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
		this.validateMaxlenght(this.eleToDoSearchInput, "ToDo Search Input", 255);
	}

	public void verifySearchInputNumber()throws Exception {
		this.eleToDoSearchInput.click();
		this.eleToDoSearchInput.sendKeys("123");
		this.validateAttributeElement(this.eleToDoSearchInput, "value", "123");
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
		waitForClickableOfElement(eleWidgetContent.get(0),"");
		clickAndHold(eleWidgetContent.get(0),"");
	}

	public void navigateToToDoList() throws Exception{
		waitForClickableOfElement(eleToDoLnk,"");
		eleToDoLnk.click();
	}

	public boolean checkSearchData() throws InterruptedException {
		getLogger().info("Run checkSearchData()");
		boolean isCheckData = false;
		waitForVisibleElement(txtIdTodoSearch,"");
		Thread.sleep(smallTimeOut);
		txtIdTodoSearch.clear();
		Thread.sleep(smallTimeOut);
		txtIdTodoSearch.sendKeys(todoNamePage);
		waitForVisibleElement(tblIdTodoTable.findElement(By.xpath("id('todo-table')/tbody/tr")),"");
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
				getLogger().info("SearchValue = " + strSearchValue);
				if(strSearchValue.equals(todoNamePage))
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

	public boolean checkContentTextSearch() throws InterruptedException {
		getLogger().info("Run checkContentTextSearch()");
		boolean isCheckData = false;
		waitForVisibleElement(txtIdTodoSearch,"");
		Thread.sleep(smallTimeOut);
		txtIdTodoSearch.clear();
		Thread.sleep(smallTimeOut);
		txtIdTodoSearch.sendKeys(todoContentTextSearch);
		waitForVisibleElement(tblIdTodoTable.findElement(By.xpath("id('todo-table')/tbody/tr")),"");
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
				getLogger().info("Search contain text = " + strSearchValue);
				if(strSearchValue.contains(todoContentTextSearch))
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



	public void verifySortToDoTaskOnName(){
		getLogger().info("Verify Sort ToDo Task On Name");
		verifySortDataGrid(toDoNameTextColumnEle, sortByToDoNameIconEle);
	}

    public void verifyCheckAllCheckboxToDoName() throws Exception {
        try {
            if (!eleCheckBox.isSelected()) eleCheckBox.click();
            for (int i = 0; i < eleToDoCheckboxRow.size(); i++) {
                if (!eleToDoCheckboxRow.get(i).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is NOT checked");
                    throw new Exception();
                }
            }
            getLogger().info("Check box icons are selected all.");
            NXGReports.addStep("Check box icons are selected all.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are not selected all.");
            NXGReports.addStep("Failed: Check box icons are not selected all.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyUnCheckAllCheckboxToDoName()throws Exception{
        try{
            if (eleCheckBox.isSelected()) eleCheckBox.click();
            for (int i = 0 ; i < eleToDoCheckboxRow.size();i++){
                if(eleToDoCheckboxRow.get(i).isSelected()){
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is checked");
                    throw new Exception();
                }
            }
            getLogger().info("Check box icons are unselected all.");
            NXGReports.addStep("Check box icons are unselected all.", LogAs.PASSED, null);
        }catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are not unselected all.");
            NXGReports.addStep("Failed: Check box icons are not unselected all.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCheckMultipleCheckBoxToDoName() throws Exception{
        try{
            if(eleCheckBox.isSelected()) eleCheckBox.click();
            if(eleToDoCheckboxRow.size()>3) {
                eleToDoCheckboxRow.get(0).click();
                if (!eleToDoCheckboxRow.get(0).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Cannot select single checkbox on row");
                    throw new Exception();
                }
                eleToDoCheckboxRow.get(eleToDoCheckboxRow.size()-1).click();
                if (!eleToDoCheckboxRow.get(eleToDoCheckboxRow.size()-1).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Cannot select single checkbox on row");
                    throw new Exception();
                }
            }
            getLogger().info("Select single and multiple checkbox successfully");
            NXGReports.addStep("Select single and multiple checkbox successfully.", LogAs.PASSED, null);
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are NOT selected multiple.");
            NXGReports.addStep("Failed: Check box icons are NOT selected multiple.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDefaultValueofCategoryComboBox(String defaultValueComboBox) {
            boolean result = false;
            getLogger().info("Verify Default Value Of Category ComboBox");
            //System.out.println("First Option in Dropdown box: " + selectEleCategoryComboBox.getFirstSelectedOption());
            System.out.println("Default Value in Dropdown box: " + eleCategoryComboBoxText.get(0).getText());
            result  = validateElementText(eleCategoryComboBoxText.get(0), defaultValueComboBox);
            if(result){
                NXGReports.addStep("Verify Default Value Of Category ComboBox successfully.", LogAs.PASSED, null);
            }else{
                NXGReports.addStep("Failed: Verify Default Value Of Category ComboBox", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
    }

    public void verifyHoverCategoryComboBox(){
        getLogger().info("Verify Default Value Of Category ComboBox.");
        verifyHoverElement(categoryComboBoxEle.get(0),"border","1px solid rgb(92, 155, 160)");
    }

    public void createToDoTaskWithCategoryName(String toDoName, String categoryName)throws Exception {
        waitForClickableOfElement(createToDoBtnEle,"Create To Do Button");
        createToDoBtnEle.click();
        // Will changed after finding new solution for waiting Element
        Thread.sleep(smallTimeOut);
        createToDoNameTextBoxEle.sendKeys(toDoName);
        // Create new category
        createNewCategory("",categoryName);
		// Will changed after finding new solution for waiting Element
        Thread.sleep(smallTimeOut);
        waitForClickableOfElement(categoryDropdownEle, "Category Dropdown");
        categoryDropdownEle.click();
        waitForClickableOfElement(categoryOptionItemEle,"Category Option Item");
        categoryOptionItemEle.click();
        waitForClickableOfElement(dueDateFieldEle,"Due Date field");
		dueDateFieldEle.click();
        waitForClickableOfElement(dateItemonCalendarEle,"Date value");
        dateItemonCalendarEle.click();
        waitForVisibleElement(toDoSaveIconEle,"Save Icon");
        toDoSaveIconEle.click();
        verifyAddNewToDoTask(toDoName);
    }

    public void verifyListValueofCategoryComboxBox(String categoryName) {
        try{
            boolean result;
            waitForClickableOfElement(createToDoNameTextBoxEle,"To Task name Textbox");
            createToDoNameTextBoxEle.click();
            waitForClickableOfElement(categoryComboBoxEle.get(0),"Category Combo box");
            categoryComboBoxEle.get(0).click();
            List<WebElement> menuCateComboBox = categoryComboBoxMenuEle.get(0).findElements(By.tagName("div"));
            result = validateElementText(menuCateComboBox.get(0), "Add New Category");
            Assert.assertTrue(result, "Add New Category option is not displayed");
            validateElementText(menuCateComboBox.get(1), "Edit Categories");
            Assert.assertTrue(result, "Edit Categories option is not displayed");
            validateElementText(menuCateComboBox.get(2).findElement(By.tagName("button")), categoryName);
            Assert.assertTrue(result, String.format("%s option is not displayed",categoryName));
            NXGReports.addStep("Verify List Value of Category ComboxBox", LogAs.PASSED,null);
        }catch (AssertionError e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify List Value of Category ComboxBox", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyNewCategoryPopUpDisplayed() throws  Exception{
        try{
            boolean result;
            waitForVisibleElement(categoryTitleEle,"Category Title");
            result = validateElementText(categoryTitleEle,"Add New Category");
            Assert.assertTrue(result, "Add New Category popup is not displayed");
            hoverElement(editCategoryCancelBtnEle,"Cancel Catergory button");
            waitForClickableOfElement(editCategoryCancelBtnEle,"Cancel Create Category Button");
            editCategoryCancelBtnEle.click();
            //Will be change to wait Ajax change function
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify New Category popup is displayed", LogAs.PASSED,null);
        }catch (AssertionError e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify New Category popup is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyEditCategoriesPopUpDisplayed() throws Exception{
        try{
            boolean result;
            waitForVisibleElement(categoryTitleEle,"Category Title");
            result = validateElementText(categoryTitleEle,"Edit Categories");
            Assert.assertTrue(result, "Edit Categories popup is not displayed");
            hoverElement(editCategoryCancelBtnEle,"Cancel Catergory button");
            waitForClickableOfElement(editCategoryCancelBtnEle,"Cancel Edit Category Button");
            editCategoryCancelBtnEle.click();
            //Will be change to wait Ajax change function
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify Edit Categories popup is displayed", LogAs.PASSED,null);
        }catch (AssertionError e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify Edit Categories popup is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCreateToDoTaskWithoutCategory(String toDoName)throws Exception {
    	getLogger().info("Verify Create ToDo Task Without Category");
        waitForClickableOfElement(createToDoNameTextBoxEle,"To Task name Textbox");
        createToDoNameTextBoxEle.sendKeys(toDoName);
        // Choose Due Date
        waitForClickableOfElement(dueDateFieldEle, "Due Date field");
		dueDateFieldEle.click();
        waitForClickableOfElement(dateItemonCalendarEle,"Date value");
        dateItemonCalendarEle.click();
        waitForVisibleElement(toDoSaveIconEle,"Save Icon");
        toDoSaveIconEle.click();
        verifyAddNewToDoTask(toDoName);
    }

	public void verifyInputMaxLengthToDoNameTextBox(){
    	try{
			boolean result = false;
			getLogger().info("Verify Input Max Length ToDo Name TextBox.");
			result = validateMaxlenght(toDoNameInputEle,"ToDo Name Input",255);
			Assert.assertTrue(result, "Input 255 Characters into ToDo Name TextBox is unsuccessfully.");
			NXGReports.addStep("Verify Edit Categories popup is displayed", LogAs.PASSED,null);
		}catch (AssertionError e){
			AbstractService.sStatusCnt++;
			getLogger().info("Input 255 Characters into ToDo Name TextBox is unsuccessfully.");
			NXGReports.addStep("TestScript Failed: Verify Input Max Length ToDo Name TextBox", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	public void inputInvalidValueToDoNameTextBox(){
		getLogger().info("Input Invalid Value into To Do Name TextBox.");
		verifyInputValueToDoNameTextBox("~!@#$%^&*+?><,.");
	}

	public void selectDueDateToDoTask(){
		waitForClickableOfElement(dueDateFieldEle, "Due Date field");
		clickElement(dueDateFieldEle,"Due Date field");
		waitForClickableOfElement(dateItemonCalendarEle,"Date value on Calendar");
		clickElement(dateItemonCalendarEle,"Date value on Calendar");
	}

	public void clickAddNewCategory(){
		waitForClickableOfElement(createToDoNameTextBoxEle,"To Task name Textbox");
		createToDoNameTextBoxEle.click();
		waitForClickableOfElement(categoryComboBoxEle.get(0),"Category Combo box");
		categoryComboBoxEle.get(0).click();
		addNewCategoryMenuItemEle.click();
	}

	public void clickEditCategory(){
		waitForClickableOfElement(createToDoNameTextBoxEle,"To Task name Textbox");
		createToDoNameTextBoxEle.click();
		waitForClickableOfElement(categoryComboBoxEle.get(0),"Category Combo box");
		categoryComboBoxEle.get(0).click();
		editCategoryEle.click();
	}
}

