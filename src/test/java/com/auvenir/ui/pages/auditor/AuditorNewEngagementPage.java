package com.auvenir.ui.pages.auditor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auvenir.ui.pages.common.AbstractPage;

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
	private WebElement eleEngagementCompanyInput;
    
    @FindBy(id="engagement-deadline")
	private WebElement eleEngagementDeadlineInput;
    
    
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
    	this.waitForClickableOfElement(this.eleEngagementNameInput);
    	this.eleEngagementNameInput.click();
    	this.eleEngagementNameInput.sendKeys(engagement01);
    	this.eleEngagementTypeSelect.click();
    	this.eleEngagementTypeList.get(0).click();
    	this.eleEngagementNameInput.click();
    	this.eleEngagementCompanyInput.sendKeys(s);
    	Calendar startDate=Calendar.getInstance();
    	Calendar endDate=Calendar.getInstance();
    	endDate.add(Calendar.DATE, 10);
    	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
    	this.eleEngagementDeadlineInput.sendKeys(dt.format(endDate.getTime()));   
    	this.eleStartDateInput.sendKeys(dt.format(startDate.getTime()));
    	
    	this.eleEndDateInput.sendKeys(dt.format(endDate.getTime()));
    	this.eleContinueBtn.click();
    	this.waitForClickableOfElement(this.eleContinueNoMemberBtn);
    	this.eleContinueNoMemberBtn.click();    	
    	this.waitForClickableOfElement(this.eleCustomizeCreateBtn);
    	this.eleCustomizeCreateBtn.click();
    }
}
