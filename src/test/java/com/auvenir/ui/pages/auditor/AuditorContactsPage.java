package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import htmlreport.com.nxgreport.NXGReports;
import htmlreport.com.nxgreport.logging.LogAs;
import htmlreport.com.nxgreport.selenium.reports.CaptureScreen;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

//import org.testng.log4testng.Logger;

public class AuditorContactsPage extends AbstractPage {

	private final static int waitTime = 60;

	public AuditorContactsPage(Logger logger, WebDriver driver) {
		super(logger, driver);

	}

	@FindBy(xpath = "//span[contains(text(),'My Clients')]")
	private WebElement myClientsTextEle;

	@FindBy(id = "clientList-header-left")
	private WebElement contactHeaderEle;

	private String contactsListWithName = "//div[contains(@id, 'w-cl-clientContainer')]//td[contains(@id,'v-c-contactTd') and text()='%s']";
	private String contactsExpandIcon = "./following-sibling::td/div[contains(@id, 'expandIconcontacts')]";

	@FindBy(xpath = "//div[contains(@id, 'w-cl-clientContainer')]//tr[contains(@id, 'expandedRow') and @style='display: table-row;']//a")
	private WebElement emailContactEle;

	public void verifyAuditorContactsPage() {
		waitForVisibleElement(contactHeaderEle, "contactHeaderEle");

	}

	public void verifyContactDisplayedInContactsPage(String contactName, String emailContact) {
		boolean result = false;
		try {
			List<WebElement> listcontactsListWithNameEle = getDriver()
					.findElements(By.xpath(String.format(contactsListWithName, contactName)));
			for (WebElement contact : listcontactsListWithNameEle) {
				clickElement(contact.findElement(By.xpath(contactsExpandIcon)), "Expand Icon");
				if (emailContactEle.getText().equals(emailContact)) {
					result = true;
					break;
				} else {
					clickElement(contact.findElement(By.xpath(contactsExpandIcon)), "Expand Icon");
				}
			}
			
			if (result){
				NXGReports.addStep("verify contact: " + contactName + " displayed in contacts page.", LogAs.PASSED, null);
			}else{
				AbstractService.sStatusCnt++;
				NXGReports.addStep("verify contact: " + contactName + " displayed in contacts page.", LogAs.FAILED,
						new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			}
			
		} catch (Exception e) {
			AbstractService.sStatusCnt++;
			NXGReports.addStep("verify contact: " + contactName + " displayed in contacts page.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		}
	}
}