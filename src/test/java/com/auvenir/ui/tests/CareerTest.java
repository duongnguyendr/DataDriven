package com.auvenir.ui.tests;

import com.auvenir.utilities.GenericService;
import com.auvenir.ui.pages.CareerPage;
import com.auvenir.ui.services.AbstractService;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.auvenir.ui.pages.AuvenirPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;


public class CareerTest extends AbstractService
{
	//Logger logger = Logger.getLogger(CareerTest.class);
	CareerPage careerPage =null;
	String auditorLoginPageHandles = null;
	AuvenirPage auvenirPage =null;
	
	/* 
	 * @Description: To Verify the display of Elements in Career Page
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=1,enabled=true, description="To Verify the display of Elements in Career Page")
	public void verifyCareerPage() throws Exception
	{
        AbstractService.sStatusCnt=0;
		careerPage =new CareerPage(getLogger(),getDriver());
		auvenirPage =new AuvenirPage(getLogger(),getDriver());
		try
		{
			getLogger().info("Log into home page.");
			loadURL(GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_URL"));
			auditorLoginPageHandles = getDriver().getWindowHandle();
			getLogger().info("Switch to New page.");
			auvenirPage.getEleCareersLnk().click();
			
			switchToWindow();
			auvenirPage.toValidate(auvenirPage.getEleAuvenirImg(),"Auvenir Header Logo Image","Displayed");
			auvenirPage.toValidate(careerPage.getEleWeAreGrowingTxt(),"We are Growing Text","Displayed");
			auvenirPage.toValidate(careerPage.getEleCareersAtAuvenirTxt(),"Careers at Auvenir Text","Displayed");
			//auvenirPage.toValidate(careerPage.getEleBusinessTxt(),"Business Text","Displayed");
			auvenirPage.toValidate(careerPage.getEleProductLeadLnk(),"Product text","Displayed");
			//auvenirPage.toValidate(careerPage.getEleMarketingTxt(),"Marketing Text","Displayed");
			//auvenirPage.toValidate(careerPage.getEleSalesBizDevelopmentLnk(),"Sales/Biz Development link","Displayed");
			auvenirPage.toValidate(careerPage.getEleTechnologyTxt(),"Technology Text","Displayed");
			auvenirPage.toValidate(careerPage.getEleDeveloperLnk(),"Developer Link","Displayed");
			//auvenirPage.toValidate(careerPage.getEleSeniorDevOpsLnk(),"Senior Dev Ops Link","Displayed");
			auvenirPage.verifyFooter();
			getDriver().close();
			Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
			NXGReports.addStep("All elements are displayed", LogAs.PASSED, null);
		//	driver.switchTo().window(AbstractService.newWin).close();
			
		}
		catch (AssertionError e)
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		catch (Exception e) 
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}
