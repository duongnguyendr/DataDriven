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


    public void verifyNewEngagementPage() {
    	///Updated later because I do not know which component to test
    }

    public void enterDataForNewEngagementPage(String engagement01, String s, String s1) throws Exception {
    	
        getLogger().info("Enter engagement name.");
        enterEngagementName(engagement01);
        NXGReports.addStep("Enter engagement name.", LogAs.PASSED, null);
        
        getLogger().info("Select engagement type.");
        selectEngagementType(s);
        NXGReports.addStep("Select engagement type.", LogAs.PASSED, null);
                
        getLogger().info("Enter company name.");
        enterCompanyName(s1);
        NXGReports.addStep("Enter company name.", LogAs.PASSED, null);
        
        getLogger().info("Enter deadline date.");
        enterDeadLineDate(this.tmp(10));
        NXGReports.addStep("Enter deadline date.", LogAs.PASSED, null);
    	
        getLogger().info("Enter start date.");
        enterStartDate(this.tmp(0));
        NXGReports.addStep("Enter star date.", LogAs.PASSED, null);
        
        getLogger().info("Enter end date.");
        enterEndDate(this.tmp(10));
        NXGReports.addStep("Enter end date.", LogAs.PASSED, null);
    	
        getLogger().info("Click Continue button.");
        this.clickContinueBtn();
        NXGReports.addStep("Click Continue button.", LogAs.PASSED, null);
        
        getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
        this.clickNoMemberBtn();
        NXGReports.addStep("Click continue button.(I don't need to add any team members to this engagement).", LogAs.PASSED, null);
        
        getLogger().info("Click create to do button.");
        this.clickCreateToDoBtn();
        NXGReports.addStep("Click create to do button.", LogAs.PASSED, null);
    }
    
    
    
    
    
    public void enterEngagementName(String engagementName){
    	this.waitForClickableOfElement(this.eleEngagementNameInput);
    	sendKeyTextBox(eleEngagementNameInput, engagementName);
    	
    }
    
    public void selectEngagementType(String engagementType){
    	clickElement(eleEngagementTypeSelect);
    	this.eleEngagementTypeList.get(0).click();    	
    }
    
    
    public void enterCompanyName(String conpanyName){
    	sendKeyTextBox(this.eleCompanyNameInput,conpanyName);   	    	
    }
    
    public void enterDeadLineDate(String dateLineDate){    	
    	sendKeyTextBox(this.eleReportDeadlineInput,dateLineDate); 
    }
    
    public void enterStartDate(String startDate){    	
    	sendKeyTextBox(this.eleStartDateInput,startDate); 
    }
    
    public void enterEndDate(String endDate){    	
    	sendKeyTextBox(this.eleEndDateInput,endDate); 
    }
    
    public void clickContinueBtn(){
    	clickElement(this.eleContinueBtn);
    }
    
    public void clickNoMemberBtn(){
    	clickElement(this.eleContinueNoMemberBtn);    	
    }
    
    public void clickCreateToDoBtn(){
    	clickElement(this.eleCustomizeCreateBtn);
    }
    
    public String tmp(int num){
    	Calendar date=Calendar.getInstance();
    	date.add(Calendar.DATE, num);
    	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
    	return dt.format(date.getTime());
    }
}
