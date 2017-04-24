package com.auvenir.ui.pages.common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.auvenir.utilities.GenericService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class GmailPage extends AbstractPage {

		//static String gmailWindowHandles;
		public GmailPage(Logger logger,WebDriver driver)
		{
			super(logger,driver);
			PageFactory.initElements(driver, this);
		}	
		
		/*@FindBy(xpath = "//a[text()='Sign In']")
		private WebElement eleSignInLink;
		public WebElement getEleSignInLink()
		{
			return eleSignInLink;
		}
			*/	
		@FindBy(xpath = "//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']/span")
		private WebElement eleProfileIcn;
		public WebElement getEleProfileIcn()
		{
			return eleProfileIcn;
		}
		
		@FindBy(xpath="//a[text()='Sign out']")
		private WebElement eleSignOutBtn;
		public WebElement getEleSignOutBtn() {
			return eleSignOutBtn;
		}
		
		@FindBy(id = "Email")
		private WebElement eleEmailIDTxtFld;
		public WebElement getEleEmailIDTxtFld()
		{
			return eleEmailIDTxtFld;
		}
		
		@FindBy(id = "next")
		private WebElement eleNextBtn;
		public WebElement getEleNextBtn() {
			return eleNextBtn;
		}
		
		@FindBy(id = "Passwd")
		private WebElement elePasswordTxtFld;
		public WebElement getElePasswordTxtFld()
		{
			return elePasswordTxtFld;
		}
		
		@FindBy(id = "signIn")
		private WebElement eleSignInBtn;
		public WebElement getEleSignInBtn() {
			return eleSignInBtn;
		}
		
		@FindBy(id = "gbqfq")
		private WebElement eleSearchTxtFld;
		public WebElement getEleSearchTxtFld()
		{
			return eleSearchTxtFld;
		}

		@FindBy(xpath="//div[contains(text(),'COMPOSE')]")
		private WebElement composeTextFld;
		
		@FindBy(id = "gbqfb")
		private WebElement eleSearchBtn;
		public WebElement getEleSearchBtn() {
			return eleSearchBtn;
		}
		
		@FindBy(xpath = "(//span[contains(text(),'to complete your financial audit')])[last()]")
		private WebElement eleInviteMailLnk;
		public WebElement getEleInviteMailLnk() {
			return eleInviteMailLnk;
		}
		@FindBys({@FindBy(xpath="//span[contains(text(),'to complete your financial audit')]")})
		private List<WebElement> lsEleInviteMailLnk;
		public List<WebElement> getLsEleInviteMailLnk() {
			return lsEleInviteMailLnk;
		}
		
		@FindBys({@FindBy(xpath="//b[contains(text(),'Sign in to Auvenir')]")})
		private List<WebElement> lsEleSignInMailLnk;
		public List<WebElement> getLsEleSignInMailLnk() {
			return lsEleSignInMailLnk;
		}
		/*@FindBy(xpath = "(//span[contains(text(),'Sign in to Auvenir!')])[position()=1]")
		private WebElement eleSignInMailLnk;
		public WebElement getEleSignInMailLnk() {
			return eleSignInMailLnk;
		}*/
		
		@FindBys({@FindBy(xpath="//span[contains(text(),'Account is Active')]")})
		private List<WebElement> lsEleYourAccActiveLnk;
		public List<WebElement> getLsEleYourAccActiveLnk() {
			return lsEleYourAccActiveLnk;
		}
		@FindBy(xpath = "//b[contains(text(),'Account is Active')]")
		private WebElement eleYourAccActiveLnk;
		public WebElement getEleYourAccActiveLnk() {
			return eleYourAccActiveLnk;
		}
		
		@FindBy(xpath = "(//a[contains(text(),'Start')])[last()]")
		private WebElement eleStartBtn;
		public WebElement getEleStartBtn() {
			return eleStartBtn;
		}
		
		@FindBy(xpath = "//a[contains(text(),'Sign In')]")
		private WebElement eleSignInLnk;
		public WebElement getEleSignInLnk() {
			return eleSignInLnk;
		}
		@FindBy(xpath = "//a[@id='edit-account-list'][text()='Remove']")
		private WebElement eleRemoveLnk;
		public WebElement getEleRemoveLnk() {
			return eleRemoveLnk;
		}
		@FindBy(xpath = "//a[@id='edit-account-list'][text()='Done']")
		private WebElement eleDoneLnk;
		public WebElement getEleDoneLnk() {
			return eleDoneLnk;
		}
		@FindBy(xpath = "//span[contains(text(),'@gmail.com'])")
		private WebElement eleAccountCloseIcn;
		public WebElement getEleAccountCloseIcn() {
			return eleAccountCloseIcn;
		}
		@FindBy(xpath = "//div[@aria-label='Show trimmed content']/img")
		private WebElement eleShowTrimBtn;
		public WebElement getEleShowTrimBtn() {
			return eleShowTrimBtn;
		}	
		public void gmailLogout() throws Exception {
		try{
			getEleProfileIcn().click();
			getEleSignOutBtn().click();
		    }catch (Exception e) 
			{
				NXGReports.addStep("Failed to logout from gmail", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				throw e;
			}
		}
				
		
		public void gmailLogin(String sUSN, String sPWD) throws InterruptedException
		{
			try{
				getDriver().get(GenericService.getCongigValue(GenericService.sConfigFile,"GMAIL_URL"));
		    	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	getDriver().manage().window().maximize();
		    	try{
		    	if(getEleSignInLnk().isDisplayed())
		    	{
		    		getEleSignInLnk().click();
		    	}}catch(Exception e){}
		    	try{
			    	if(getEleRemoveLnk().isDisplayed())
			    	{
			    		getEleRemoveLnk().click();
			    		Thread.sleep(2000);
			    		getDriver().findElement(By.xpath("//span[text()='"+sUSN+"']")).click();
			    		try{
					    	if(getEleRemoveLnk().isDisplayed())
					    	{
					    		getEleRemoveLnk().click();
					    	}}catch(Exception e){}
			    		
			    		getEleDoneLnk().click();
			    		Thread.sleep(2000);
			    	}}catch(Exception e){}
		    
		    	try{if(getEleEmailIDTxtFld().isDisplayed()){
					getEleEmailIDTxtFld().sendKeys(sUSN);
		    		getEleNextBtn().click();
		    	}}catch(Exception e){}
		    	getElePasswordTxtFld().sendKeys(sPWD);
		    	getEleSignInBtn().click();
		    	Assert.assertTrue(getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
		    	NXGReports.addStep("Login to Gmail is successful", LogAs.PASSED,null);
				
		    }catch (Exception e) 
			{
				NXGReports.addStep("Failed to login to Gmail", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				throw e;
			}
		}

		public void inviteEmail()
		{
			try{
			
			for(int i=0;i<lsEleInviteMailLnk.size();i++)
			{
				System.out.println(lsEleInviteMailLnk.get(i).getText());
				if(lsEleInviteMailLnk.get(i).getText().contains("to complete your financial audit"))
						{
						lsEleInviteMailLnk.get(i).click();
						try
						{
							if(getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed())
							{
								getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
								Thread.sleep(2000);
								
								Robot rb = new Robot();
								rb.keyPress(KeyEvent.VK_PAGE_DOWN);
							}
						}catch(Exception e){}
						break;
						}
				
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		public void signInEmail()
		{
			try{
			System.out.println(lsEleSignInMailLnk.size());
			for(int i=0;i<lsEleSignInMailLnk.size();i++)
			{
				System.out.println(lsEleSignInMailLnk.get(i).getText());
				if(lsEleSignInMailLnk.get(i).getText().contains("Sign in to Auvenir"))
						{
					lsEleSignInMailLnk.get(i).click();
						try
						{
							if(getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed())
							{
								getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
								Thread.sleep(2000);
								
								Robot rb = new Robot();
								rb.keyPress(KeyEvent.VK_PAGE_DOWN);
							}
						}catch(Exception e){}
						break;
						}
				
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		public void accountActiveEmail()
		{
			try{
			System.out.println(lsEleYourAccActiveLnk.size());
			for(int i=0;i<lsEleYourAccActiveLnk.size();i++)
			{
				System.out.println(lsEleYourAccActiveLnk.get(i).getText());
				if(lsEleYourAccActiveLnk.get(i).getText().contains("Account is Active"))
						{
					lsEleYourAccActiveLnk.get(i).click();
						try
						{
							if(getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed())
							{
								getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
								Thread.sleep(2000);
								
								Robot rb = new Robot();
								rb.keyPress(KeyEvent.VK_PAGE_DOWN);
							}
						}catch(Exception e){}
						break;
						}
				
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}

	public WebElement getComposeTextFld() {
		return composeTextFld;
	}
}
