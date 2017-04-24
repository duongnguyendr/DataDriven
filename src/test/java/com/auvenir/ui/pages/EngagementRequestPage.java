package com.auvenir.ui.pages;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class EngagementRequestPage extends AbstractPage {

	public EngagementRequestPage(Logger logger,WebDriver driver)
	{
		super(logger,driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dashboardUsername")
	private WebElement eleAllRequestsTxt;
	public WebElement getEleAllRequestsTxt(){
		return eleAllRequestsTxt;
	}
	
	@FindBy(id="req-nav-newCatBtn")
	private WebElement eleCreateCategoryLnk;
	public WebElement getEleCreateCategoryLnk(){
		return eleCreateCategoryLnk;
	}
	
	@FindBy(xpath="//div[text()='Financials']")
	private WebElement eleFINANCIALSLnk;
	public WebElement getEleFINANCIALSLnk(){
		return eleFINANCIALSLnk;
	}
	@FindBy(xpath="//div[text()='General Ledger'][@class='req-nav-listTitle noSelect']")
	private WebElement eleGeneralLedgerLnk;
	public WebElement getEleGeneralLedgerLnk(){
		return eleGeneralLedgerLnk;
	}
	@FindBy(xpath="//div[text()='Trial Balance']")
	private WebElement eleTrialBalanceLnk;
	public WebElement getEleTrialBalanceLnk(){
		return eleTrialBalanceLnk;
	}
	@FindBy(xpath="//div[text()='Bank Statements']")
	private WebElement eleBankStatementsLnk;
	public WebElement getEleBankStatementsLnk(){
		return eleBankStatementsLnk;
	}
	
	@FindBy(id="m-req-requestname")
	private WebElement eleGeneralLedgerTxt;
	public WebElement getEleGeneralLedgerTxt(){
		return eleGeneralLedgerTxt;
	}
	
	@FindBy(id="m-req-description")
	private WebElement eleDescriptionTxt;
	public WebElement getEleDescriptionTxt(){
		return eleDescriptionTxt;
	}
	
	@FindBy(xpath="//div[@class='auvicon-line-cloud-upload']")
	private WebElement eleFileUploadIcn;
	public WebElement getEleFileUploadIcn(){
		return eleFileUploadIcn;
	}
	
	@FindBy(id="photoUploadText")
	private WebElement eleDragDropTxt;
	public WebElement getEleDragDropTxt(){
		return eleDragDropTxt;
	}
	
	@FindBy(id="photoBrowseText")
	private WebElement eleBrowseFileTxt;
	public WebElement getEleBrowseFileTxt(){
		return eleBrowseFileTxt;
	}
	
	@FindBy(id="request-totalNumber")
	private WebElement eleCompleteTxt;
	public WebElement getEleCompleteTxt(){
		return eleCompleteTxt;
	}
	@FindBy(id="req-det-duedate")
	private WebElement eleDueDateTxt;
	public WebElement getEleDueDateTxt(){
		return eleDueDateTxt;
	}

}
