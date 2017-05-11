package com.auvenir.ui.pages.auditor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */

public class AuditorNewEngagementPage extends AbstractPage {



    public AuditorNewEngagementPage(Logger logger, WebDriver driver)
    {
        super(logger,driver);
    }
    
    
    @FindBy(id="engagement-name")
	private WebElement eleEngagementNameInput;
    
    @FindBy(id="engagement-type-container")
	private WebElement eleEngagementTypeSelect; 
    
    @FindBy(xpath="//div[@id='engagement-type-container']//..//..//..//a[@class='ddlText auv-inputDdl-text']")
   	private List<WebElement> eleEngagementTypeList;
    
    @FindBy(id="engagement-company")
	private WebElement eleCompanyNameInput;
    
    @FindBy(id="engagement-deadline")
	private WebElement eleReportDeadlineInput;
    
    
    @FindBy(id="engagement-date-range-start")
	private WebElement eleStartDateInput;
    
    @FindBy(id="engagement-date-range-end")
	private WebElement eleEndDateInput;
    
    @FindBy(id="m-ce-addBtn")
   	private WebElement eleContinueBtn;
    
    @FindBy(id="m-ce-cancelBtn")
   	private WebElement eleCancelBtn;
    
    @FindBy(id="team-continue-btn")
   	private WebElement eleContinueNoMemberBtn;
    
    @FindBy(id="team-add-btn")
   	private WebElement eleAddMemberBtn;
    
    
    @FindBy(id="customize-create-btn")
   	private WebElement eleCustomizeCreateBtn;
    @FindBy(xpath = "//h2[contains(text(),'New Engagement')]")
    private WebElement newEngagementHeaderTextEle;


    public void verifyNewEngagementPage() {
    	getLogger().info("Verify New engagement Page.");
    	waitForVisibleElement(newEngagementHeaderTextEle);
    }

    public void enterDataForNewEngagementPage(String name, String engagementType, String company) throws Exception {
    	
        getLogger().info("Enter engagement name.");
        enterEngagementName(name);
        NXGReports.addStep("Enter engagement name.", LogAs.PASSED, null);
        
        getLogger().info("Select engagement type.");
        selectEngagementType(engagementType);
        NXGReports.addStep("Select engagement type.", LogAs.PASSED, null);
                
        getLogger().info("Enter company name.");
        enterCompanyName(company);
        NXGReports.addStep("Enter company name.", LogAs.PASSED, null);
        
        getLogger().info("Enter deadline date.");
        enterDeadLineDate(getDate(10));
        NXGReports.addStep("Enter deadline date.", LogAs.PASSED, null);
    	
        getLogger().info("Enter start date.");
        enterStartDate(getDate(0));
        NXGReports.addStep("Enter star date.", LogAs.PASSED, null);
        
        getLogger().info("Enter end date.");
        enterEndDate(getDate(10));
        NXGReports.addStep("Enter end date.", LogAs.PASSED, null);
    	
        getLogger().info("Click Continue button.");
        clickContinueBtn();
        NXGReports.addStep("Click Continue button.", LogAs.PASSED, null);
        
        getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
        clickNoMemberBtn();
        NXGReports.addStep("Click continue button.(I don't need to add any team members to this engagement).", LogAs.PASSED, null);
        
        getLogger().info("Click create to do button.");
        clickCreateToDoBtn();
        NXGReports.addStep("Click create to do button.", LogAs.PASSED, null);
    }
    
    
    
    
    
    public void enterEngagementName(String engagementName){
    	waitForClickableOfElement(this.eleEngagementNameInput);
    	eleEngagementNameInput.sendKeys(engagementName);
    	
    }
    
    public void selectEngagementType(String engagementType){
    	eleEngagementTypeSelect.click();
    	eleEngagementTypeList.get(0).click();
    }
    
    
    public void enterCompanyName(String conpanyName){
    	eleCompanyNameInput.sendKeys(conpanyName);
    }
    
    public void enterDeadLineDate(String dateLineDate){    	
    	eleReportDeadlineInput.sendKeys(dateLineDate);
    }
    
    public void enterStartDate(String startDate){    	
    	eleStartDateInput.sendKeys(startDate);
    }
    
    public void enterEndDate(String endDate){    	
    	eleStartDateInput.sendKeys(endDate);
    }
    
    public void clickContinueBtn(){
    	eleContinueBtn.click();
    }
    
    public void clickNoMemberBtn(){
    	this.waitForClickableOfElement(eleContinueNoMemberBtn);
    	eleContinueNoMemberBtn.click();
    }
    
    public void clickCreateToDoBtn(){
    	waitForClickableOfElement(this.eleCustomizeCreateBtn);
    	eleCustomizeCreateBtn.click();
    }
    
    public String getDate(int day){
    	Calendar date=Calendar.getInstance();
    	date.add(Calendar.DATE, day);
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	return simpleDateFormat.format(date.getTime());
    }
}
