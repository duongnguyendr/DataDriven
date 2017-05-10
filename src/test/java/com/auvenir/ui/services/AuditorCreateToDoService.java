package com.auvenir.ui.services;

//import library
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

import java.util.List;
import java.util.Random;

/**
 * Created by hai.nguyen on 05/04/2017.
 */

public class AuditorCreateToDoService extends AbstractService {

	AuditorCreateToDoPage createToDoPage;
	String todoNamePage = "";
	/*
	 * contructor
	 */
	public AuditorCreateToDoService(Logger logger, WebDriver driver) {

		super(logger, driver);
		createToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
	

	}

	
	public void verifyButtonFilter(){

		try {
			createToDoPage.verifyButtonFilter(); 
			NXGReports.addStep("[PLAT 2288]-05: verify displayed of this button filter", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-05: verify displayed of this button filter", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	public void verifyColumnsInGrid(){

		try {
			createToDoPage.verifyColumnsInGrid();
			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	public void verifySotleOnTitle(){

		try {
			createToDoPage.verifySotleOnTitle();
			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	public void navigateToDoListPage() throws Exception{
		this.createToDoPage.navigateToEngagementPage();
		this.createToDoPage.navigateToToDoList();
	}

	public void verifyAuditorCreateToDo() {

		try {
			this.createToDoPage.navigateToEngagementTask();
			this.createToDoPage.navigateToToDoList();
			createToDoPage.verifyToDoListPage();
			NXGReports.addStep("verify create to do page", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("verify create to do page", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyGUIAddNewToDoTextBox(){
		try {
			createToDoPage.verifyDefaultValueToDoTextBox();
			createToDoPage.verifyCssValueToDoTextBox();
			createToDoPage.verifyCssValueWarningToDoTextBox();
			NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void navigatetoCreateToDoTab() {
		getLogger().info("Navigate to CreateToDo Tab");
		try {
			createToDoPage.clickCreateToDoTask();
			NXGReports.addStep("verify Navigate to Create ToDo TextBox", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("verify Navigate to Create ToDo TextBox", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyInputDataToDoTextBox(String value){
		getLogger().info("Input data into ToDo name Textbox.");
		try {
			createToDoPage.verifyInputValueToDoNameTextBox(value);
			NXGReports.addStep("Input value " + value + " on ToDo Name Textbox successfully.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Input value " + value + " on ToDo Name Textbox unsuccessfully.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyToDoNameInputLimitCharacter(int maxLength){
		getLogger().info(String.format("Verify To Do name text box can put %d characters.",maxLength));
		try {
			createToDoPage.verifyToDoNameInputLimitCharacter(maxLength);
			NXGReports.addStep("Input " + maxLength + " characters on ToDo Name Textbox successfully.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Input " + maxLength + " characters on ToDo Name Textbox successfully.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyToDoNameInputSpecialCharacter(String value){
		getLogger().info("Input special characters into ToDo name Text box.");
		try {
			createToDoPage.verifyToDoNameInputSpecialCharacter(value);
			NXGReports.addStep("Input special characters: " + value + " on ToDo Name Textbox successfully.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Input special characters: " + value + " on ToDo Name Textbox unsuccessfully.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyGUIToDoSaveIcon(){
		getLogger().info("Verify GUI of the To Do Save Icon");
		try {
			createToDoPage.verifyDisableToDoSaveIcon();
			createToDoPage.verifyEnableToDoSaveIcon();
			NXGReports.addStep("Verify GUI of the To Do Save Icon.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify GUI of the To Do Save Icon.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyGUIToDoCloseIcon(){
		getLogger().info("Verify GUI of To Do Close Icon.");
		try {
			createToDoPage.verifyEnableToDoCloseIcon();
			NXGReports.addStep("Verify GUI of To Do Close Icon.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify GUI of To Do Close Icon.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyButtonCreateToDo(){

		try {
			createToDoPage.verifyButtonCreateToDo(); 
			NXGReports.addStep("[PLAT 2288]-03: verify button create to do display with green background and white text.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-03: verify button create to do display with green background and white text.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	public void verifySearchPlaceholder(){

		try {
			createToDoPage.verifySearchDefault(); 
			NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	
	public void verifySearchHover(){

		try {
			createToDoPage.verifySearchHover(); 
			NXGReports.addStep("[PLAT 2288]-07: verify when hover on Search change bounary color to green.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-07: verify when hover on Search change bounary color to green.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	
	public void verifySearchInputText(){

		try {
			createToDoPage.verifySearchInputText(); 
			NXGReports.addStep("[PLAT 2288]-08: verify input text.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-08: verify input text.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	
	public void verifySearchInputNumber(){
		try {			
			createToDoPage.verifySearchInputNumber(); 
			NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
//	public void verifySearchLimit255(){
//		try {
//			createToDoPage.verifySearchLimit255(); 
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//		}
//	}

	
	public void verifyCheckOnCheckBox(){

		try {
			createToDoPage.verifyCheckOnCheckBox();
			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	public void verifyUnCheckOnCheckBox(){

		try {
			
			createToDoPage.verifyUnCheckOnCheckBox();
			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void createToDoPage(){

		try {
			Random randNum = new Random();
			int  n = randNum.nextInt(10000) + 1;
			todoNamePage = "To-do name " + n;
			createToDoPage.createToDoPage(todoNamePage);
			NXGReports.addStep("Create To-Do page", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Create To-Do page", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyDataSearch() throws Exception {
		try {
			boolean isCheckData = createToDoPage.checkSearchData(todoNamePage);
			if(isCheckData) {
				NXGReports.addStep("verify search data on the to do page", LogAs.PASSED, null);
			}
			else
			{
				NXGReports.addStep("verify search data on the to do page", LogAs.FAILED, null);
			}
			System.out.println("isCheckData = " + isCheckData);
		} catch (Exception e) {
			NXGReports.addStep("verify search data on the to do page", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyAddNewDataGridIcon(String toDoName) throws Exception {
		try {
			createToDoPage.createToDoPage(toDoName);
			NXGReports.addStep("New To Do task is added successfully", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("New To Do task is added unsuccessfully", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifySortDataGridIcon(List<String> toDoName) throws Exception {
		try {
			for (int i = 0; i < toDoName.size(); i++) {
				createToDoPage.createToDoPage(toDoName.get(i));
			}
			createToDoPage.verifySortToDoTaskOnName();
			NXGReports.addStep("The data on Data Grid is sorted successfully", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("The data on Data Grid is sorted unsuccessfully", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}

	public void verifyCheckBoxToDoPage(){
		try {
			createToDoPage.verifyCheckAllCheckbox();
			createToDoPage.verifyUnCheckAllCheckbox();
			createToDoPage.verifyCheckMultipleCheckBox();
			NXGReports.addStep("CheckBox on Data Grid is working successfully", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("CheckBox on Data Grid is working unsuccessfully", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
}
