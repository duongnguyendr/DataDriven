package com.auvenir.ui.pages.auditor.contact;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

//import org.testng.log4testng.Logger;

public class AuditorContactsPage extends AbstractPage {

	private final static int waitTime = 60;

	private final static  String ENGAGEMENT_LINK_TITLE = "Engagements";
	private final static  String ENGAGEMENT_LINK_CSS = "header-menu";
	private final static  String CONTACT_LINK_TITLE = "Contacts";
	private final static  String CONTACT_LINK_CSS = "header-menu header-menu-active";

	private final static  String AUDIT_FIRM_HEADER_COLUMN_TITLE = "Audit Firm/ Client";
	private final static  String TYPE_HEADER_COLUMN_TITLE = "Type";
	private final static  String CONTACT_HEADER_COLUMN_TITLE = "Contact";
	private final static  String ROLE_HEADER_COLUMN_TITLE = "Role";
	private final static  String STATUS_HEADER_COLUMN_TITLE = "Status";


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

	@FindBy(xpath = "//span[@id='h-engagementsLink']")
	private WebElement eleEngagementLink;

	@FindBy(xpath = "//span[@id='h-clientListLink']")
	private WebElement eleContactLink;

	@FindBy(xpath = "//table[@id ='v-c-table']/tr[@class='contacts-tableHeader']/td/input[@class='contacts-checkBoxes']")
	private WebElement eleContactsCheckBox;

	@FindBy(xpath = "//table[@id ='v-c-table']/tr/td[@id='v-c-thAuditFirm']")
	private WebElement eleAuditFirmClientHeaderColumn;

	@FindBy(xpath = "//table[@id ='v-c-table']/tr/td[@id='v-c-thType']")
	private WebElement eleAuditTypeHeaderColumn;

	@FindBy(xpath = "//table[@id ='v-c-table']/tr/td[@id='v-c-thContact']")
	private WebElement eleAuditContactHeaderColumn;

	@FindBy(xpath = "//table[@id ='v-c-table']/tr/td[@id='v-c-thRole']")
	private WebElement eleAuditRoleHeaderColumn;

	@FindBy(xpath = "//table[@id ='v-c-table']/tr/td[@id='v-c-thStatus']")
	private WebElement eleAuditStatusHeaderColumn;

	/**
	 * Verify GUI of Auditor Contacts Page
	 */
	public void verifyAuditorContactsPage() {
		try
		{
			boolean checkResult;
			waitForVisibleElement(eleEngagementLink,"engagement link");
			checkResult = validateElementText(eleEngagementLink, ENGAGEMENT_LINK_TITLE);
			Assert.assertTrue(checkResult, "engagement link text is wrong");

			checkResult = validateAttributeElement(eleEngagementLink,"class", ENGAGEMENT_LINK_CSS);
			Assert.assertTrue(checkResult, "engagement link css is wrong");


			waitForVisibleElement(eleContactLink,"contact link");
			checkResult = validateElementText(eleContactLink, CONTACT_LINK_TITLE);
			Assert.assertTrue(checkResult, "contact link text is wrong");

			checkResult = validateAttributeElement(eleContactLink,"class", CONTACT_LINK_CSS);
			Assert.assertTrue(checkResult, "contact link css is wrong");

			waitForVisibleElement(contactHeaderEle, "contact header title");
			checkResult = validateElementText(contactHeaderEle, CONTACT_LINK_TITLE);
			Assert.assertTrue(checkResult, "contact title is wrong");

		}
		catch (AssertionError assertionError){
			AbstractService.sStatusCnt++;
			NXGReports.addStep("verify GUI contacts page.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),assertionError.getMessage());
		}
		catch(Exception ex){
			AbstractService.sStatusCnt++;
			NXGReports.addStep("verify GUI contacts page.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),ex.getMessage());
		}
	}

	/**
	 * Click on engagement link in contact page
	 */
	public void clickOnEngagementLink(){
		try{
			waitForVisibleElement(eleEngagementLink,"engagement link");
			clickElement(eleEngagementLink);
		}catch (Exception ex){
			AbstractService.sStatusCnt++;
			NXGReports.addStep("Click on Engagement link.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),ex.getMessage());
		}
	}

	/**
	 * Verify GUI data table in contact page
	 */
	public void verifyGUIDataTableInContactPage(){
		try{
			boolean checkResult;

			waitForVisibleElement(eleContactsCheckBox,"contacts check box all");

			waitForVisibleElement(eleAuditFirmClientHeaderColumn,"audit firm header column");
			checkResult = validateElementText(eleAuditFirmClientHeaderColumn, AUDIT_FIRM_HEADER_COLUMN_TITLE);
			Assert.assertTrue(checkResult, "audit firm header column text is wrong");

			waitForVisibleElement(eleAuditTypeHeaderColumn,"type header column");
			checkResult = validateElementText(eleAuditTypeHeaderColumn, TYPE_HEADER_COLUMN_TITLE);
			Assert.assertTrue(checkResult, "type header column text is wrong");

			waitForVisibleElement(eleAuditContactHeaderColumn,"status header column");
			checkResult = validateElementText(eleAuditContactHeaderColumn, CONTACT_HEADER_COLUMN_TITLE);
			Assert.assertTrue(checkResult, "status header column text is wrong");

			waitForVisibleElement(eleAuditRoleHeaderColumn,"role header column");
			checkResult = validateElementText(eleAuditRoleHeaderColumn, ROLE_HEADER_COLUMN_TITLE);
			Assert.assertTrue(checkResult, "role header column text is wrong");

			waitForVisibleElement(eleAuditStatusHeaderColumn,"status header column");
			checkResult = validateElementText(eleAuditStatusHeaderColumn, STATUS_HEADER_COLUMN_TITLE);
			Assert.assertTrue(checkResult, "status header column text is wrong");


		}catch (Exception ex){
			AbstractService.sStatusCnt++;
			NXGReports.addStep(" Verify GUI data table in contact page.", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),ex.getMessage());
		}
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