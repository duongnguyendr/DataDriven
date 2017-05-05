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

	public void verifyAuditorCreateToDo() {

		try {
			this.createToDoPage.navigateToEngagementPage();
			this.createToDoPage.navigateToToDoList();
			createToDoPage.verifyToDoListPage();
			NXGReports.addStep("verify create to do page", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("verify create to do page", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	

}
