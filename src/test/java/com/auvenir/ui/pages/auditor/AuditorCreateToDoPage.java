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
	private WebElement eleCreateToDoBtn;

	@FindBy(id="auv-todo-filter")
	private WebElement eleFilterBtn;

	@FindBy(id="todo-search")
	private WebElement eleToDoSearchInput;

	@FindBy(xpath="//*[@id='todo-table']/thead//th/input[@type='checkbox']")
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

	@FindBy(id="category-dropdown")
	private WebElement eleDdlCategory;
	@FindBy(xpath = "//*[@id=\"category-dropdown-menu\"]/div[3]")
	private WebElement eleXpathCategoryItem;
	@FindBy(id="due-date")
	private WebElement eleIdDueDate;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")
	private WebElement eleXpathChooseDate;

	public void verifyImgEmtyToDo()throws Exception {
		validateDisPlayedElement(eleImgEmtyToDo,"EmptyTodoImage");
	}

	@FindBy(xpath="//div[@id='divName']/div/input[@id='todo-name']")
	private WebElement eleToDoNameInput;

	@FindBy(xpath="//input[@id='due-date']")
	private WebElement eleDueDateInput;

	@FindBy(xpath="//*/table[@id='todo-table']//div[@id='divName']//p[@class='auv-inputError']")
	private WebElement eleToDoNameErrorLabel;

	@FindBy(xpath="//*[@id='todo-add-btn']")
	private WebElement eleToDoSaveIcon;
	public WebElement getEleToDoSaveIcon() {
		return eleToDoSaveIcon;
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
	private WebElement eleIdToDoName;
	@FindBy(id="todo-add-btn")
	private WebElement eleBtnToDoAdd;

	@FindBy(xpath="//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@class='newTodoInput']")
	private List<WebElement> eleToDoNewRowNameText;
	public List<WebElement> getEleToDoNewRowNameText() {
		return eleToDoNewRowNameText;
	}

    @FindBy(xpath = "//*[@id='category-dropdown']/div[@class='text']")
    private List<WebElement> eleCategoryComboBoxText;

    //Category ComboBox
    @FindBy(id ="category-dropdown")
    private List<WebElement> eleCategoryComboBox;

    //Category dropdown menu
    @FindBy(id = "category-dropdown-menu")
    private List<WebElement> eleCategoryComboBoxMenu;

    @FindBy(xpath = "//*[@id='category-dropdown-menu']/div[1]")
    private WebElement eleXpathCreateNewCategory;

    @FindBy(xpath = "//*[@id='category-dropdown-menu']/div[2]")
    WebElement eleEditCategory;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//h3 [@class='setup-header']")
    WebElement eleCategoryTitle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//img[starts-with(@id,'modal-close-categoryModel')]")
    WebElement eleEditCategoryCloseBtn;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//button[@id = 'm-ce-cancelBtn']")
    WebElement eleEditCategoryCancelBtn;
	
	public void verifyButtonCreateToDo()throws Exception {
		validateCssValueElement(eleCreateToDoBtn,"background-color","rgba(89, 155, 161, 1)");
		validateCssValueElement(eleCreateToDoBtn,"color","rgba(255, 255, 255, 1)");
		validateDisPlayedElement(eleCreateToDoBtn,"Create Todo Button");

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
		validateDisPlayedElement(eleSortByNameToDo,"Sort By Name Button");
		validateDisPlayedElement(eleSortByClientAssignee,"Sort By Client Assignee Button.");
		validateDisPlayedElement(eleSortByDueDate,"Sort By");
		validateDisPlayedElement(eleSortByAuditAssignee,"Sort by Auditor Assignee button.");
	}


	public void verifyToDoListPage() throws Exception {
		validateAttributeElement(eleCreateToDoBtn,"background","#2c8188");
		validateAttributeElement(eleCreateToDoBtn,"color","#fff");
		validateDisPlayedElement(eleCreateToDoBtn,"Create Todo Button");
		validateDisPlayedElement(eleFilterBtn,"Filter Button");
		validateDisPlayedElement(eleToDoSearchInput,"Search button");
		validateAttributeElement(eleToDoSearchInput,"placeholder","Search...");
		eleToDoSearchInput.click();
		validateAttributeElement(eleCreateToDoBtn,"border","#599ba1");
		validateDisPlayedElement(eleCheckBox,"Check Box");
		validateElementText(eleNameToDoTitleLabel, "To-Dos");
		validateElementText(eleCategoryTitleLabel, "Category");
		validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
		validateElementText(eleDueDateTitleLabel, "Due Date");
		validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
		validateDisPlayedElement(eleSortByNameToDo,"Sort By Name");
		validateDisPlayedElement(eleSortByClientAssignee,"Sort By Assign button.");
		validateDisPlayedElement(eleSortByDueDate,"Sort By Due Date button.");
		validateDisPlayedElement(eleSortByAuditAssignee,"Sort by Auditor Assignee.");
		if(!eleCheckBox.isSelected()){
			eleCheckBox.click();
		}
		validateAttributeElement(eleCreateToDoBtn,"background","#5cd4c0");
		if(eleCheckBox.isSelected()){
			eleCheckBox.click();
		}
		validateAttributeElement(eleCreateToDoBtn,"background","#cacece");
	}


	public void clickCreateToDoTask(){
		waitForClickableOfElement(eleCreateToDoBtn,"Create Todo button");
		eleCreateToDoBtn.click();
	}

	public void verifyDefaultValueToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput,"Todo name input field.");
		validateDisPlayedElement(eleToDoNameInput,"Todo name input field.");
		validateAttributeElement(eleToDoNameInput,"placeholder","Write your first to do here");
	}
	public void verifyCssValueToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput,"Todo Name input field");
		clickAndHold(eleToDoNameInput,"Todo Name input field");
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgb(89, 155, 161)");
	}
	public void verifyCssValueWarningToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput,"Todo name input field");
		waitForVisibleElement(eleDueDateInput,"Due Date input field");
		clickAndHold(eleToDoNameInput,"Todo Name input field");
		eleDueDateInput.click();
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgba(253, 109, 71, 0.4)");
		waitForVisibleElement(eleToDoNameErrorLabel,"Todo Name error  Label");
		validateElementText(eleToDoNameErrorLabel,"Not a valid name.");
	}


	public void verifyAddNewToDoTask(String toDoName) {
		validateDisPlayedElement(eleToDoNewRowNameText.get(0),"Todo New Row Name");
		validateAttributeElement(eleToDoNewRowNameText.get(0), "value", toDoName);
	}

	public void verifyInputValueToDoNameTextBox(String Value) {
		waitForVisibleElement(eleToDoNameInput,"Todo Name input field");
		eleToDoNameInput.clear();
		eleToDoNameInput.sendKeys(Value);
		validateAttributeElement(eleToDoNameInput, "value", Value);
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

    public void createToDoPage(String toDoName)throws Exception {
        waitForClickableOfElement(eleCreateToDoBtn,"Create To Do Button");
        eleCreateToDoBtn.click();
        Thread.sleep(smallTimeOut);
        eleIdToDoName.sendKeys(toDoName);
        // Create new category
        createNewCategory("");
        Thread.sleep(smallTimeOut);
        waitForClickableOfElement(eleDdlCategory,"Category Dropdown");
        eleDdlCategory.click();
        waitForClickableOfElement(eleXpathCategoryItem,"Category Option Item");
        eleXpathCategoryItem.click();
        waitForClickableOfElement(eleIdDueDate,"Due Date field");
        eleIdDueDate.click();
        waitForClickableOfElement(eleXpathChooseDate,"Date value");
        eleXpathChooseDate.click();
        waitForVisibleElement(eleToDoSaveIcon,"Save Icon");
        eleToDoSaveIcon.click();
        verifyAddNewToDoTask(toDoName);
    }

	public void createToDoPage()throws Exception {
		getLogger().info("Run createToDoPage()");
		todoNamePage = "To-do name " + randomNumber();
		waitForClickableOfElement(eleCreateToDoBtn,"create todo button.");
		this.eleCreateToDoBtn.click();
		Thread.sleep(smallTimeOut);
		eleIdToDoName.sendKeys(todoNamePage);
		//waitForClickableOfElement(eleDdlCategory);
		//eleDdlCategory.click();
		// Create new category
		createNewCategory("");
		Thread.sleep(smallTimeOut);
		hoverElement(eleDdlCategory,"eleDdlCategory");
		waitForClickableOfElement(eleDdlCategory,"eleDdlCategory");
		eleDdlCategory.click();
		waitForClickableOfElement(eleXpathCategoryItem,"eleXpathCategoryItem");
		eleXpathCategoryItem.click();
		waitForClickableOfElement(eleIdDueDate,"eleIdDueDate");
		Thread.sleep(2000);
		eleIdDueDate.click();
		waitForClickableOfElement(eleXpathChooseDate,"eleXpathChooseDate");
		eleXpathChooseDate.click();
		waitForClickableOfElement(eleBtnToDoAdd,"eleBtnToDoAdd");
		eleBtnToDoAdd.click();
	}

	public void verifyToDoNameInputLimitCharacter(int maxLength)throws Exception {
		waitForVisibleElement(eleToDoNameInput,"eleToDoNameInput");
		validateMaxlenght(eleToDoNameInput, maxLength);
	}

	public void verifyToDoNameInputSpecialCharacter(String value)throws Exception {
		waitForVisibleElement(eleToDoNameInput,"eleToDoNameInput");
		eleToDoNameInput.clear();
		eleToDoNameInput.sendKeys(value);
		eleDueDateInput.click();
		waitForVisibleElement(eleToDoNameErrorLabel,"eleToDoNameErrorLabel");
		validateElementText(eleToDoNameErrorLabel,"Not a valid name.");
	}

	public void verifyDisableToDoSaveIcon(){
		waitForVisibleElement(eleToDoNameInput,"eleToDoNameInput");
		eleToDoNameInput.clear();
		waitForVisibleElement(eleToDoSaveIcon,"eleToDoSaveIcon");
		validateDisabledElement(eleToDoSaveIcon,"eleToDoSaveIcon");
	}

	public void verifyEnableToDoSaveIcon(){
		waitForVisibleElement(eleToDoNameInput,"eleToDoNameInput");
		eleToDoNameInput.sendKeys("Task01");
		waitForVisibleElement(eleToDoSaveIcon,"eleToDoSaveIcon");
		validateEnabledElement(eleToDoSaveIcon,"eleToDoSaveIcon");
	}

	public void verifyEnableToDoCloseIcon(){
		int count = -1;
		if(eleToDoNewRow.isEmpty())
			count = 0;
		else count = eleToDoNewRow.size();
		clickCreateToDoTask();
		waitForVisibleElement(eleToDoCloseIcon,"eleToDoCloseIcon");
		eleToDoCloseIcon.click();
		getLogger().info("Verify new To Do Task is not created.");
		try {
			if (count == eleToDoNewRow.size())
				NXGReports.addStep( "New To Do Task is not created", LogAs.PASSED, null);
			else{
				AbstractService.sStatusCnt++;
				NXGReports.addStep("New To Do Task is created", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			}
		} catch (Exception e) {
			AbstractService.sStatusCnt++;
			NXGReports.addStep("New To Do Task is created", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
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
		this.validateMaxlenght(this.eleToDoSearchInput, 255);
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
		waitForClickableOfElement(eleWidgetContent.get(0),"eleWidgetContent");
		clickAndHold(eleWidgetContent.get(0),"eleWidgetContent");
	}

	public void navigateToToDoList() throws Exception{
		waitForClickableOfElement(eleToDoLnk,"");
		eleToDoLnk.click();
	}

	public boolean checkSearchData() throws InterruptedException {
		getLogger().info("Run checkSearchData()");
		boolean isCheckData = false;
		waitForVisibleElement(txtIdTodoSearch,"txtIdTodoSearch");
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



	public void verifySortToDoTaskOnName() throws Exception {
		try {
			verifySortDataGrid(eleToDoNewRowNameText,eleSortByNameToDo);
		} catch (Exception e) {
			AbstractService.sStatusCnt++;
			getLogger().info("Cannot sort data on Data Grid View.");
		}

	}

    public void verifyCheckAllCheckbox() throws Exception {
        try {
            if (!eleCheckBox.isSelected()) eleCheckBox.click();
            for (int i = 0; i < eleToDoCheckboxRow.size(); i++) {
                System.out.println("Checkbox is selected:? " + eleToDoCheckboxRow.get(i).isSelected());
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

    public void verifyUnCheckAllCheckbox()throws Exception{
        try{
            if (eleCheckBox.isSelected()) eleCheckBox.click();
            for (int i = 0 ; i < eleToDoCheckboxRow.size();i++){
                System.out.println("Checkbox is selected:? " + eleToDoCheckboxRow.get(i).isSelected());
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

    public void verifyCheckMultipleCheckBox() throws Exception{
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

    public void verifyDefaultValueofCategoryComboBox(String value) {
            boolean result = false;
            getLogger().info("Verify Default Value Of Category ComboBox");
            //System.out.println("First Option in Dropdown box: " + selectEleCategoryComboBox.getFirstSelectedOption());
            System.out.println("Default Value in Dropdown box: " + eleCategoryComboBoxText.get(0).getText());
            result  = validateElementText(eleCategoryComboBoxText.get(0), value);
            if(result){
                NXGReports.addStep("Verify Default Value Of Category ComboBox successfully.", LogAs.PASSED, null);
            }else{
                NXGReports.addStep("Failed: Verify Default Value Of Category ComboBox", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
    }

    public void verifyHoverCategoryComboBox(){
        getLogger().info("Verify Default Value Of Category ComboBox.");
        verifyHoverElement(eleCategoryComboBox.get(0),"border","1px solid rgb(92, 155, 160)");
    }

    public void createToDoTaskWithCategoryName(String toDoName, String categoryName)throws Exception {
        waitForClickableOfElement(eleCreateToDoBtn,"Create To Do Button");
        eleCreateToDoBtn.click();
        Thread.sleep(smallTimeOut);
        eleIdToDoName.sendKeys(toDoName);
        // Create new category
        createNewCategory("",categoryName);
        Thread.sleep(smallTimeOut);
        waitForClickableOfElement(eleDdlCategory, "Category Dropdown");
        eleDdlCategory.click();
        waitForClickableOfElement(eleXpathCategoryItem,"Category Option Item");
        eleXpathCategoryItem.click();
        waitForClickableOfElement(eleIdDueDate,"Due Date field");
        eleIdDueDate.click();
        waitForClickableOfElement(eleXpathChooseDate,"Date value");
        eleXpathChooseDate.click();
        waitForVisibleElement(eleToDoSaveIcon,"Save Icon");
        eleToDoSaveIcon.click();
        verifyAddNewToDoTask(toDoName);
    }

    public void verifyListValueofCategoryComboxBox(String categoryName) {
        try{
            boolean result;
            waitForClickableOfElement(eleIdToDoName,"To Task name Textbox");
            eleIdToDoName.click();
            waitForClickableOfElement(eleCategoryComboBox.get(0),"Category Combo box");
            eleCategoryComboBox.get(0).click();
            List<WebElement> menuCateComboBox = eleCategoryComboBoxMenu.get(0).findElements(By.tagName("div"));
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
            waitForClickableOfElement(eleIdToDoName,"To Task name Textbox");
            eleIdToDoName.click();
            waitForClickableOfElement(eleCategoryComboBox.get(0),"Category Combo box");
            eleCategoryComboBox.get(0).click();
            eleXpathCreateNewCategory.click();
            waitForVisibleElement(eleCategoryTitle,"Category Title");
            result = validateElementText(eleCategoryTitle,"Add New Category");
            Assert.assertTrue(result, "Add New Category popup is not displayed");
            hoverElement(eleEditCategoryCancelBtn,"Cancel Catergory button");
            waitForClickableOfElement(eleEditCategoryCancelBtn,"Cancel Create Category Button");
            eleEditCategoryCancelBtn.click();
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
            waitForClickableOfElement(eleIdToDoName,"To Task name Textbox");
            eleIdToDoName.click();
            waitForClickableOfElement(eleCategoryComboBox.get(0),"Category Combo box");
            eleCategoryComboBox.get(0).click();
            eleEditCategory.click();
            waitForVisibleElement(eleCategoryTitle,"Category Title");
            result = validateElementText(eleCategoryTitle,"Edit Categories");
            Assert.assertTrue(result, "Edit Categories popup is not displayed");
            hoverElement(eleEditCategoryCancelBtn,"Cancel Catergory button");
            waitForClickableOfElement(eleEditCategoryCancelBtn,"Cancel Edit Category Button");
            eleEditCategoryCancelBtn.click();
            //Will be change to wait Ajax change function
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify Edit Categories popup is displayed", LogAs.PASSED,null);
        }catch (AssertionError e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify Edit Categories popup is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCreateToDoTaskWithoutCategory(String toDoName)throws Exception {
        waitForClickableOfElement(eleIdToDoName,"To Task name Textbox");
        eleIdToDoName.sendKeys(toDoName);
        // Choose Due Date
        waitForClickableOfElement(eleIdDueDate, "Due Date field");
        eleIdDueDate.click();
        waitForClickableOfElement(eleXpathChooseDate,"Date value");
        eleXpathChooseDate.click();
        waitForVisibleElement(eleToDoSaveIcon,"Save Icon");
        eleToDoSaveIcon.click();
        verifyAddNewToDoTask(toDoName);
    }
}

