package com.auvenir.ui.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorTodoListPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by hai.nguyen on 05/04/2017.
 */

public class AuditorCreateToDoService extends AbstractService {

	AuditorCreateToDoPage createToDoPage;
	AuditorTodoListPage todoListPage;
	AuditorEngagementPage engagementPage;
	AuditorDetailsEngagementPage  detailsEngagementPage ;

	/*
	 * contructor
	 */
	public AuditorCreateToDoService(Logger logger, WebDriver driver) {

		super(logger, driver);
		createToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
		todoListPage=new AuditorTodoListPage(getLogger(), getDriver());
		engagementPage= new AuditorEngagementPage(getLogger(), getDriver());
		detailsEngagementPage =new AuditorDetailsEngagementPage(getLogger(), getDriver());
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
			engagementPage.navigateToEngagementTask("engagement");
			detailsEngagementPage.navigateToTaskList();
			todoListPage.clickCreateToDoBtn();
			createToDoPage.verifyAddNewToDoTask();
			NXGReports.addStep("verify Create ToDo TextBox", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("verify Create ToDo TextBox", LogAs.FAILED,
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

}
