package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.AbstractService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auvenir.ui.services.AuditorCreateToDoService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;

/**
 * Created by Hai.Nguyen on 05/04/2017.
 * Implement for PLAT - 2288
 */
public class CreateToDoTest extends AbstractTest {
    AuditorCreateToDoService auditorCreateToDoService;
    
    @BeforeMethod
    public void initTest() throws Exception{
    	auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        String userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
    	 auditorCreateToDoService.loginWithUserRole(userId);   
    	 auditorCreateToDoService.navigateToDoListPage();
    }
    
    
    @Test(  priority = 1,enabled = false, description = "[PLAT 2288]-03: verify button create to do display with green background and white text.")
    public void verifyUIAuditorCreateToDo() throws Exception {        
    	try {
    		auditorCreateToDoService.verifyButtonCreateToDo(); 
			NXGReports.addStep("[PLAT 2288]-03: verify button create to do display with green background and white text.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-03: verify button create to do display with green background and white text.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(  priority = 3,enabled = false, description = "[PLAT 2288]-05: verify displayed of this button filter")
    public void verifyButtonFilter() throws Exception {        

		try {
			auditorCreateToDoService.verifyButtonFilter(); 
			NXGReports.addStep("[PLAT 2288]-05: verify displayed of this button filter", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-05: verify displayed of this button filter", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(  priority = 4,enabled = false, description = "[PLAT 2288]-06:verify default value(Search...) of this Search")
    public void verifySearchPlaceholder() throws Exception {        

    	try {
    		auditorCreateToDoService.verifySearchPlaceholder(); 
			NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-06: verify default value(Search...) of this Search", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(  priority = 5,enabled = false, description = "[PLAT 2288]-07: verify when hover on Search change bounary color to green.")
    public void verifySearchHover() throws Exception {        

    	try {
    		auditorCreateToDoService.verifySearchHover(); 
			NXGReports.addStep("[PLAT 2288]-07: verify when hover on Search change bounary color to green.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-07: verify when hover on Search change bounary color to green.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(  priority = 6,enabled = false, description = "[PLAT 2288]-08: verify input text.")
    public void verifySearchInputText() throws Exception {        

    	try {
    		auditorCreateToDoService.verifySearchInputText(); 
			NXGReports.addStep("[PLAT 2288]-08: verify input text.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-08: verify input text.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
//    @Test(  priority = 7,enabled = true, description = "[PLAT 2288]-09:verify input with max length limit with  255 character")
//    public void verifySearchLimit255() throws Exception {        
//    	try {
//    		auditorCreateToDoService.verifySearchLimit255(); 
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.PASSED, null);
//		} catch (Exception e) {
//			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.FAILED,
//					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//			throw e;
//		}
//    }
    
    @Test(  priority = 8,enabled = false, description = "[PLAT 2288]-10: verify input number to field search.")
    public void verifySearchInputNumber() throws Exception {        

    	try {
    		auditorCreateToDoService.verifySearchInputNumber(); 
			NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-10: verify input number to field search.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(  priority = 9,enabled = false, description = "[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title")
    public void verifyColumnsInGrid() throws Exception {        

    	try {
    		auditorCreateToDoService.verifyColumnsInGrid(); 
			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(  priority = 10,enabled = false, description = "[PLAT 2288]-15: verify after each column title have a arrow icon to sort.")
    public void verifySotleOnTitle() throws Exception {        

    	try {
    		auditorCreateToDoService.verifySotleOnTitle();
			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(  priority = 11,enabled = false, description = "[PLAT 2288]-16: verify checkbox will change green color a have stick icon")
    public void verifyCheckOnCheckBox() throws Exception {        

    	try {
    		auditorCreateToDoService.verifyCheckOnCheckBox();
			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(  priority = 12,enabled = false, description = "[PLAT 2288]-17: verify checkbox will change green color a have stick icon")
    public void verifyUnCheckOnCheckBox() throws Exception {        

    	try {
    		auditorCreateToDoService.verifyCheckOnCheckBox();
			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }

    @Test(  priority = 2,enabled = false, description = "[PLAT 2282]-03: Verify GUI To Dos Textbox")
    public void verifyGUIToDoTextBox() throws Exception {
        try {
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyGUIAddNewToDoTextBox();
            auditorCreateToDoService.verifyInputDataToDoTextBox("Task01");
			auditorCreateToDoService.verifyToDoNameInputLimitCharacter(255);
			auditorCreateToDoService.verifyToDoNameInputSpecialCharacter("~!@#$%^&*+?><,.");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI To Dos Text box - create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI To Dos Text box - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

	@Test(  priority = 13,enabled = false, description = "[PLAT 2282]-03: Verify GUI To Do Save Icon")
	public void verifyGUIToDoSaveIcon() throws Exception {
		try {
			auditorCreateToDoService.navigatetoCreateToDoTab();
			auditorCreateToDoService.verifyGUIToDoSaveIcon();
			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
			NXGReports.addStep("Verify GUI Save Icon - create to do page.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("TestScript Failed: Verify GUI Save Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	@Test(  priority = 14,enabled = true, description = "[PLAT 2282]-03: Verify GUI To Do Close Icon")
	public void verifyGUIToDoCloseIcon() throws Exception {
		try {
			auditorCreateToDoService.verifyGUIToDoCloseIcon();
			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
			NXGReports.addStep("Verify GUI Close Icon - create to do page.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("TestScript Failed: Verify GUI Close Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
	@Test(  priority = 15,enabled = true, description = "[PLAT 2282]-03: Verify Data Grid after adding new To Do Task")
	public void verifyDataGridToDoTaskPage() throws Exception {
		try {
			auditorCreateToDoService.verifyGUIToDoCloseIcon();
			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
			NXGReports.addStep("Verify GUI Close Icon - create to do page.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("TestScript Failed: Verify GUI Close Icon - create to do page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
}
