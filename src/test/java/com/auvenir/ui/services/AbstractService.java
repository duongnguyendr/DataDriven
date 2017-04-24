package com.auvenir.ui.services;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.WebService;
import com.auvenir.ui.pages.common.GmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;


public class AbstractService
{
	private Logger logger = Logger.getLogger(AbstractService.class) ;
	private WebDriver driver;
	public static int sStatusCnt=0;
	public static WebDriverWait sWebDriverWait=null;
	public static String gmailWindow;
	public static String parentWin = null;
	public static String newWin = null;

	@Parameters({"server"})
	@BeforeSuite
	public void setConfig(String server)
	{
		if(server.equalsIgnoreCase("cadet"))
		{
			GenericService.sConfigFile = GenericService.sDirPath+"/cadet.properties";
		}
		else if(server.equalsIgnoreCase("local")){
			GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
		}

		else
		{
			GenericService.sConfigFile = GenericService.sDirPath+"/ariel.properties";
		}
	}
	
	@BeforeMethod
	public void setUp()
	{
		try
		{
			if(GenericService.getCongigValue(GenericService.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", GenericService.sDirPath+"/src/tests/resources/chromedriver.exe");
				System.out.println("Chrome is set");
				driver = new ChromeDriver();
			}
			else
			{
				System.out.println("Firefox is set");
				System.setProperty("webdriver.gecko.driver", GenericService.sDirPath+"/src/tests/resources/geckodriver.exe");
				
				driver = new FirefoxDriver();
			}		
			NXGReports.setWebDriver(driver);
		}
		catch(Exception e)
		{
			System.out.println("Problem in launching driver");
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		logger.info("Close the browser.");
		driver.quit();
	}

	/*public void loadURL(String sUrl)
	{
		try
		{
			driver.get(sUrl);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}	
	}*/
	/*public void setURL(String sEMAILID, String sAUTHID, String sLOGINURL, String sDevAuthID, String sApiKey) throws Exception
	{
		try
		{
			WebService http = new WebService();
			System.out.println(sEMAILID);
			http.gettingUserID(sEMAILID,sAUTHID, sDevAuthID, sApiKey);
			http.gettingURL(sEMAILID,sLOGINURL, sDevAuthID, sApiKey);
			System.out.println(GenericService.getCongigValue(GenericService.sConfigFile,sLOGINURL));
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Fail to load Logged-In Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}	
	}
	
	public void loadURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL)
	{
		driver.get(sGetTokenURL+sEmailID);
		String s1 = driver.findElement(By.xpath("//pre")).getText();
		String[] parts = s1.split("(\")");
		String token = parts[3]; 
		driver.get(sCheckTokenURL+sEmailID+"&token="+token);
	}*/
	
	/*public  void waitForElementDisplay(WebElement element)
	{
		try
		{
			new FluentWait<WebElement>(element).withTimeout(30, TimeUnit.SECONDS).pollingEvery(50, TimeUnit.MILLISECONDS).until(new Function<WebElement,Boolean>() {
			@Override
			public Boolean apply(WebElement element) 
			{	
				return element.isDisplayed();	
			}	
			});
		}
		catch (AssertionError e) 
		{
			NXGReports.addStep("Element is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			e.printStackTrace();
			Assert.fail();	
		}		
	}	*/

	public WebDriver getDriver(){
		return driver;
	}

	public Logger getLogger(){
		return logger;
	}
	   //Getting the URL by passing GetTokenURl and CheckTokenURL

	
		public void loadURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL)
		{
			driver.get(sGetTokenURL+sEmailID);
			String s1 = driver.findElement(By.xpath("//pre")).getText();
			String[] parts = s1.split("(\")");
			String token = parts[3]; 
			GenericService.setCongigValue(GenericService.sConfigFile, "LOGIN_URL", sCheckTokenURL+sEmailID+"&token="+token);
			driver.get(sCheckTokenURL+sEmailID+"&token="+token);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		
		//Loading the URL by keeping in config properties
		
		public void loadURL(String sUrl)
		{
			try
			{
				System.out.println(sUrl);
				driver.get(sUrl);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
			catch(AssertionError e)
			{
				NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				throw e;
			}	
		}
	
		//Getting the URl by passing Dev Auth ID and Authentication key
		
		public void setURL(String sEMAILID, String sAUTHID, String sLOGINURL, String sDevAuthID, String sApiKey) throws Exception
		{
			try
			{
				WebService http = new WebService(logger);
				http.gettingUserID(sEMAILID,sAUTHID, sDevAuthID, sApiKey);
				http.gettingURL(sEMAILID,sLOGINURL, sDevAuthID, sApiKey);
				System.out.println(GenericService.getCongigValue(GenericService.sConfigFile,sLOGINURL));
			}
			catch(AssertionError e)
			{
				NXGReports.addStep("Fail to load Logged-In Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				throw e;
			}	
		}
		
		
		
		public void visibilityOfElementWait(WebElement webElement,String elementName,int waitTime)
		{
		   try 
		   {
			   sWebDriverWait = new WebDriverWait(driver, waitTime);
			   sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
		   } 
		   catch (Exception e) 
		   {
			    AbstractService.sStatusCnt++;
		      	NXGReports.addStep(elementName+ " is not Visible", LogAs.FAILED, null);
		   }
		} 
		public void gmaillLogin() throws Exception
		 {
			 	try
			 	{
			    	GmailPage gmailLoginPo = new GmailPage(logger,driver);
			    	driver.get(GenericService.getCongigValue(GenericService.sConfigFile,"GMAIL_URL"));
			    	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			    	driver.manage().window().maximize();
			    	
			    	//gmailLoginPo.getEleSignInLink().click();
			    	if(gmailLoginPo.getEleEmailIDTxtFld().isDisplayed()){
			    		gmailLoginPo.getEleEmailIDTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"));
			    		gmailLoginPo.getEleNextBtn().click();
			    	}
			    	Thread.sleep(5000);
			    	gmailLoginPo.getElePasswordTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile,"CLIENT_PWD"));
			    	gmailLoginPo.getEleSignInBtn().click();
			    	Assert.assertTrue(gmailLoginPo.getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
			    	Thread.sleep(5000);
			    	gmailLoginPo.getEleSearchTxtFld().sendKeys(GenericService.getCongigValue(GenericService.sConfigFile,"GMAIL_SEARCHMAIL"));
			    	gmailLoginPo.getEleSearchBtn().click();
			    	gmailLoginPo.getEleInviteMailLnk().click();	    	
			    	gmailWindow = driver.getWindowHandle();
					
			    	gmailLoginPo.getEleStartBtn().click();
			    	switchToWindow();
			    	
			    	driver.close();
			    	driver.switchTo().window(parentWin);
			 	}
			 	catch(AssertionError e)
			 	{
					NXGReports.addStep("Page not Loaded", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
			 	}
			}
		
		public void auditorLogout() throws Exception
		{
			Thread.sleep(10000);
			GmailPage gmailLoginPo = new GmailPage(logger,driver);
			driver.close();
			
			driver.switchTo().window(gmailWindow); 
			gmailLoginPo.getEleProfileIcn().click();
			gmailLoginPo.getEleSignOutBtn().click();	
		}
		
		public void switchToWindow()
		{
			logger.info("Detect new windows.");
			Set <String> handles =driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			while (it.hasNext()){
				parentWin = it.next();
				newWin= it.next();
			
			}
			logger.info("Swithc to new windwos.");
			driver.switchTo().window(newWin);
			
		}
}
