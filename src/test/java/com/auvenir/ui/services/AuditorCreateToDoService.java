package com.auvenir.ui.services;

//import library
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

	public void verifyButtonCreateToDo(){

		try {
			createToDoPage.verifyButtonCreateToDo(); 
			NXGReports.addStep("[PLAT 2288]-03: verify button create to do display with green background and white text.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-03: verify button create to do display with green background and white text.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
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
	
	public void navigateToDoListPage() throws Exception{
		this.createToDoPage.navigateToEngagementPage();
		this.createToDoPage.navigateToToDoList();
	}

}
