package com.auvenir.ui.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by hai.nguyen on 05/04/2017.
 */

public class AuditorCreateToDoService extends AbstractService {

	AuditorCreateToDoPage createToDoPage;

	/*
	 * contructor
	 */
	public AuditorCreateToDoService(Logger logger, WebDriver driver) {

		super(logger, driver);
		createToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());

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
			createToDoPage.navigateToEngagementTask();
			createToDoPage.navigateToToDoList();
			createToDoPage.clickCreateToDoTask();
			//createToDoPage.verifyAddNewToDoTask();
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
