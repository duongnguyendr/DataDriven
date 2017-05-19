package com.auvenir.ui.pages.auditor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auvenir.ui.pages.common.AbstractPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Created by cuong.nguyen on 5/8/2017.
 */

public class AuditorNewEngagementPage extends AbstractPage {

    //@FindBy(id = "team-component-header")
    @FindBy(xpath = "//p[@id='team-component-body']/h3[contains(text(),'Create Your Team')]")
    private WebElement teamMemberWizardHeader;
    @FindBy(xpath = "//p[contains(text(),'Create a new To-Do list')]")
    private WebElement createNewTodoListTextEle;

    public AuditorNewEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "engagement-name")
    private WebElement eleEngagementNameInput;

    @FindBy(id = "engagement-type-container")
    private WebElement eleEngagementTypeSelect;

    @FindBy(xpath = "//div[@id='engagement-type-container']//..//..//..//a[@class='ddlText auv-inputDdl-text']")
    private List<WebElement> eleEngagementTypeList;

    @FindBy(id = "engagement-company")
    private WebElement eleCompanyNameInput;

    @FindBy(id = "engagement-deadline")
    private WebElement eleReportDeadlineInput;

    @FindBy(id = "engagement-date-range-start")
    private WebElement eleStartDateInput;

    @FindBy(id = "engagement-date-range-end")
    private WebElement eleEndDateInput;

    @FindBy(id = "m-ce-addBtn")
    private WebElement eleContinueBtn;

    @FindBy(id = "m-ce-cancelBtn")
    private WebElement eleCancelBtn;

    @FindBy(id = "team-continue-btn")
    private WebElement eleContinueNoMemberBtn;

    @FindBy(id = "team-add-btn")
    private WebElement eleAddMemberBtn;

    @FindBy(id = "customize-create-btn")
    private WebElement eleCustomizeCreateBtn;
    @FindBy(xpath = "//h2[contains(text(),'New Engagement')]")
    private WebElement newEngagementHeaderTextEle;

//    @FindBy(xpath = "//p[contains(text(),'need to add any team members to this engagement')]")
//    private WebElement teamContainerDivEle;

    public void verifyNewEngagementPage() {
        getLogger().info("Verify New engagement Page.");
        waitForVisibleElement(newEngagementHeaderTextEle, "New Engagement Header");
    }

    /*
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
    */
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
        clickAndHold(eleReportDeadlineInput,"Deadline date Input");
        enterDeadLineDate(getDate(10));
        clickElement(eleEngagementNameInput,"engagement Name");
        NXGReports.addStep("Enter deadline date.", LogAs.PASSED, null);

        getLogger().info("Enter end date.");
        enterEndDate(getDate(10));
        clickElement(eleEngagementNameInput,"engagement Name");
        NXGReports.addStep("Enter end date.", LogAs.PASSED, null);

        getLogger().info("Enter start date.");
        clickAndHold(eleStartDateInput,"Start Date Input");
        enterStartDate(getDate(0));
        clickElement(eleEngagementNameInput,"engagement Name");
        NXGReports.addStep("Enter star date.", LogAs.PASSED, null);

        getLogger().info("Click Continue button.");
        //WebElement popUpDiv = getDriver().findElement(By.xpath("//*[@id='ce-setup-container']"));
        clickContinueBtn();
        //waitForVisibleElement(teamContainerDivEle,"Member Select Option Div Element");
        NXGReports.addStep("Click Continue button.", LogAs.PASSED, null);

        verifyTeamMemberWizardPage();

        getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
        //waitForJSandJQueryToLoad();
        //waitForCssValueChanged(popUpDiv,"Member Select Option Div Element", "display", "none");
        //Need to wait for Create Your Team form is displayed. Will removed if it had another solution
        Thread.sleep(smallTimeOut);
        clickNoMemberBtn();
        NXGReports.addStep("Click continue button.(I don't need to add any team members to this engagement).", LogAs.PASSED, null);
        waitForVisibleElement(createNewTodoListTextEle, "Create new todo list text");

        clickContinueBtn();
    }

    private void verifyTeamMemberWizardPage() {
        getLogger().info("Verify team member wizard page.");
        waitForVisibleElement(teamMemberWizardHeader, "team member header");
        validateElementText(teamMemberWizardHeader, "Create Your Team");
    }


    public void enterEngagementName(String engagementName) {
        waitForClickableOfElement(eleEngagementNameInput, "EngagementName");
        sendKeyTextBox(eleEngagementNameInput, engagementName, "engagementName");

    }

    public void selectEngagementType(String engagementType) {
        clickElement(eleEngagementTypeSelect, "Select Engagement Type");
        eleEngagementTypeList.get(0).click();
    }
    
    
    public void enterCompanyName(String conpanyName){
    	sendKeyTextBox(eleCompanyNameInput, conpanyName,"Company field");
    }

    public void enterDeadLineDate(String dateLineDate) {
        sendKeyTextBox(eleReportDeadlineInput, dateLineDate, "DateLine");
    }

    public void enterStartDate(String startDate) {
        sendKeyTextBox(eleStartDateInput, startDate, "StartDate");
    }

    public void enterEndDate(String endDate) {
        sendKeyTextBox(eleEndDateInput, endDate, "EndDate");
    }

    public void clickContinueBtn() {
        clickElement(eleContinueBtn, "Continue Button");
    }
    
    public void clickNoMemberBtn() {
        waitForVisibleElement(eleContinueNoMemberBtn, "Continue No Member button");
        clickAndHold(eleContinueNoMemberBtn, "Continue No member button");
    }


    public void clickCreateToDoBtn() {
        clickElement(eleCustomizeCreateBtn, "Customize Create Button");
    }

    public String getDate(int day) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, day);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return simpleDateFormat.format(date.getTime());
    }
}
