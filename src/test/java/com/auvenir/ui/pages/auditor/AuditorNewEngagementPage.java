package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.DatePicker;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */

public class AuditorNewEngagementPage extends AbstractPage {

    //@FindBy(id = "team-component-header")
    @FindBy(id = "team-component-header")
    private WebElement teamMemberWizardHeader;

    @FindBy(id = "customize-component-header")
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

    @FindBy(xpath="//*[@id='h-engagementsLink']")
    private WebElement linkEngagement;

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
        clickAndHold(eleReportDeadlineInput, "Deadline date Input");
        enterDeadLineDate(getDate(10));
        clickElement(eleEngagementNameInput, "engagement Name");
        NXGReports.addStep("Enter deadline date.", LogAs.PASSED, null);

        getLogger().info("Enter end date.");
        enterEndDate(getDate(10));
        clickElement(eleEngagementNameInput, "engagement Name");
        NXGReports.addStep("Enter end date.", LogAs.PASSED, null);

        getLogger().info("Enter start date.");
        clickAndHold(eleStartDateInput, "Start Date Input");
        enterStartDate(getDate(1));
        clickElement(eleEngagementNameInput, "engagement Name");
        NXGReports.addStep("Enter star date.", LogAs.PASSED, null);

        getLogger().info("Click Continue button.");
        clickContinueBtn();
        NXGReports.addStep("Click Continue button.", LogAs.PASSED, null);
        verifyTeamMemberWizardPage();

        getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
        clickNoMemberBtn();
        NXGReports.addStep("Click continue button.(I don't need to add any team members to this engagement).", LogAs.PASSED, null);
        waitForVisibleElement(createNewTodoListTextEle, "Create your To-Do list");
        //old version
//        clickContinueBtn();
        clickCreateToDoBtn();
    }

    public void createNewEngagement(String name, String engagementType, String company) throws Exception {

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
        clickAndHold(eleReportDeadlineInput, "Deadline date Input");
        enterDeadLineDate(getDate(10));
        clickElement(eleEngagementNameInput, "engagement Name");
        NXGReports.addStep("Enter deadline date.", LogAs.PASSED, null);

        getLogger().info("Enter end date.");
        enterEndDate(getDate(10));
        clickElement(eleEngagementNameInput, "engagement Name");
        NXGReports.addStep("Enter end date.", LogAs.PASSED, null);

        getLogger().info("Enter start date.");
        clickAndHold(eleStartDateInput, "Start Date Input");
        enterStartDate(getDate(1));
        clickElement(eleEngagementNameInput, "engagement Name");
        NXGReports.addStep("Enter star date.", LogAs.PASSED, null);

        getLogger().info("Click Continue button.");
        clickContinueBtn();
        getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
        clickNoMemberBtn();
        clickCreateToDoBtn();
        Thread.sleep(smallTimeOut);
        clickElement(linkEngagement, "click to linkEngagement");
    }

    private void verifyTeamMemberWizardPage() {
        getLogger().info("Verify team member wizard page.");
        waitForVisibleElement(teamMemberWizardHeader, "team member header");
        validateElementText(teamMemberWizardHeader, "Create your team");
    }


    public void enterEngagementName(String engagementName) {
        waitForClickableOfElement(eleEngagementNameInput, "EngagementName");
        sendKeyTextBox(eleEngagementNameInput, engagementName, "engagementName");

    }

    public void selectEngagementType(String engagementType) {
        clickElement(eleEngagementTypeSelect, "Select Engagement Type");
        eleEngagementTypeList.get(0).click();
    }


    public void enterCompanyName(String conpanyName) {
        sendKeyTextBox(eleCompanyNameInput, conpanyName, "Company field");
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
        //waitForVisibleElement(eleContinueNoMemberBtn, "Continue No Member button");
//        waitForClickableOfLocator(By.xpath("//*[@id='team-continue-btn']"));
        waitForProgressOverlayIsClosed();
        clickElement(eleContinueNoMemberBtn, "Continue No member button");
    }


    public void clickCreateToDoBtn() {
        clickElement(eleCustomizeCreateBtn, "Customize Create Button");
    }

    /**
     * Added by huy.huynh on 06/06/2017.
     * Verify UI new engagement flow
     */
    @FindBy(className = "ce-headerTitle")
    private WebElement titleHeader;

    @FindBy(id = "link-ce-setuptitle")
    private WebElement tabProgressSetUpName;

    @FindBy(id = "link-ce-setupcircle")
    private WebElement tabProgressSetUpCircle;

    @FindBy(id = "link-ce-setupnum")
    private WebElement tabProgressSetUpNumber;

    @FindBy(id = "link-ce-teamtitle")
    private WebElement tabProgressTeamName;

    @FindBy(id = "link-ce-teamcircle")
    private WebElement tabProgressTeamCircle;

    @FindBy(id = "link-ce-teamnum")
    private WebElement tabProgressTeamNumber;

    @FindBy(id = "link-ce-customizetitle")
    private WebElement tabProgressCustomizeName;

    @FindBy(id = "link-ce-customizecircle")
    private WebElement tabProgressCustomizeCircle;

    @FindBy(id = "link-ce-customizenum")
    private WebElement tabProgressCustomizeNumber;

    @FindBy(xpath = "//h3[@class='m-ce-setup-header']")
    private WebElement titleSetUpHeader;

    @FindBy(xpath = "//p[@for='engagement-name']")
    private WebElement titleEngagementName;
    //eleEngagementNameInput
    @FindBy(xpath = "//p[@for='engagement-type']")
    private WebElement titleEngagementType;

    @FindBy(xpath = "//input[@id='engagement-type']")
    private WebElement inputEngagementType;

    @FindBy(xpath = "//div[@id='engagement-type-container']//a[@class='ddlText auv-inputDdl-text']")
    private List<WebElement> listEngagementTypeContain;

    @FindBy(xpath = "//ul[@class='ddlLink inputDdl inputDdl-after']//a[contains(text(),'Financial Audit')]")
    private WebElement optionFirstEngagementType;

    @FindBy(xpath = "//p[@for='engagement-company']")
    private WebElement titleEngagementCompany;

    @FindBy(xpath = "//input[@id='engagement-company']")
    private WebElement inputEngagementCompany;

    @FindBy(xpath = "//p[@for='engagement-deadline']")
    private WebElement titleEngagementReportDeadline;

    @FindBy(xpath = "//input[@id='engagement-deadline']")
    private WebElement inputEngagementReportDeadline;

    @FindBy(xpath = "//p[@for='engagement-date-range-start']")
    private WebElement titleEngagementDateRange;

    @FindBy(xpath = "//input[@id='engagement-date-range-start']")
    private WebElement inputEngagementDateRangeStart;

    @FindBy(xpath = "//input[@id='engagement-date-range-end']")
    private WebElement inputEngagementDateRangeEnd;

    @FindBy(xpath = "//button[@id='m-ce-addBtn']/following-sibling::button")
    private WebElement buttonEngagementCancel;

    @FindBy(id = "m-ce-addBtn")
    private WebElement buttonEngagementContinue;

    @FindBy(id = "team-component-header")
    private WebElement titleTeamHeader;

    @FindBy(xpath = "//button[@id='team-continue-btn']/preceding-sibling::img")
    private WebElement imageNotAddMember;

    @FindBy(xpath = "//button[@id='team-continue-btn']/preceding-sibling::p")
    private WebElement titleNotAddMember;

    @FindBy(id = "team-continue-btn")
    private WebElement buttonNotAddMember;

    @FindBy(xpath = "//button[@id='team-add-btn']/preceding-sibling::img")
    private WebElement imageAddMember;

    @FindBy(xpath = "//button[@id='team-add-btn']/preceding-sibling::p")
    private WebElement titleAddMember;

    @FindBy(id = "team-add-btn")
    private WebElement buttonAddMember;

    @FindBy(xpath = "//button[@id='customize-rollover-btn']/preceding-sibling::img")
    private WebElement imageRollover;

    @FindBy(xpath = "//button[@id='customize-rollover-btn']/preceding-sibling::p")
    private WebElement titleRollover;

    @FindBy(id = "customize-rollover-btn")
    private WebElement buttonRollover;

    @FindBy(xpath = "//button[@id='customize-create-btn']/preceding-sibling::img")
    private WebElement imageCreateToDoList;

    @FindBy(xpath = "//button[@id='customize-create-btn']/preceding-sibling::p")
    private WebElement titleCreateToDoList;

    @FindBy(id = "customize-create-btn")
    private WebElement buttonCreateToDoList;

    @FindBy(id = "ui-datepicker-div")
    private WebElement widgetDatePicker;

    DatePicker datePicker;

    /**
     * verify UI of New Engagement page - Header SetUp
     */
    public void verifyUINewEngagementHeaderSetUp() {
        try {
            waitUtilTextPresent(titleHeader, 5, "New Engagement");
            validateElementText(titleHeader, "New Engagement");
            validateElementText(tabProgressSetUpName, "SET-UP");
            validateElementText(tabProgressSetUpNumber, "1");
            validateElementText(tabProgressTeamName, "TEAM");
            validateElementText(tabProgressTeamNumber, "2");
            validateElementText(tabProgressCustomizeName, "CUSTOMIZE");
            validateElementText(tabProgressCustomizeNumber, "3");
            validateElementText(titleSetUpHeader, "Set Up Your Engagement");
            validateAttributeElement(tabProgressSetUpCircle, "class", "ce-numberCircle ce-numberCircle-active");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement - Header SetUp ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Body SetUp
     */
    public void verifyUINewEngagementBodySetUp(String name) {
        try {
            validateElementText(titleEngagementName, "Name Your Engagement");
            sendKeyTextBox(eleEngagementNameInput, name, "Engagement Name Input");
            validateElementText(titleEngagementType, "Select Engagement Type");
            clickElement(inputEngagementType, "Engagement Type");
            validateElementsQuantity(listEngagementTypeContain, 4, "List Engagement Type");
            clickElement(optionFirstEngagementType);
            validateElementText(titleEngagementCompany, "Company Name");
            sendKeyTextBox(inputEngagementCompany, "company", "Engagement Name Input");
            validateElementText(titleEngagementReportDeadline, "Set Reporting Deadline");
            validatePlaceholder(inputEngagementReportDeadline, "DD/MM/YYYY", "Engagement Report Deadline");
            clickElement(inputEngagementReportDeadline);
            validateAttributeNotContain(widgetDatePicker, "style", "display: none", "Date Picker");
            datePicker = new DatePicker(getDriver(), widgetDatePicker);
            datePicker.pickADate("26");
            validateElementJSTextContain(inputEngagementReportDeadline, "26", "Engagement Report Deadline");
            validateElementText(titleEngagementDateRange, "Select a Date Range of Bank Statements to be requested from your client.");
            validatePlaceholder(inputEngagementDateRangeStart, "DD/MM/YYYY", "Engagement DateRange Start");
            waitForInvisibleElement(widgetDatePicker, "Date Picker");
            clickElement(inputEngagementDateRangeStart);
            validateAttributeNotContain(widgetDatePicker, "style", "display: none", "Date Picker");
            datePicker = new DatePicker(getDriver(), widgetDatePicker);
            datePicker.pickADate("27");
            validateElementJSTextContain(inputEngagementDateRangeStart, "27", "Engagement Report Deadline");
            validatePlaceholder(inputEngagementDateRangeEnd, "DD/MM/YYYY", "Engagement DateRange End");
            clickElement(inputEngagementDateRangeEnd);
            validateAttributeNotContain(widgetDatePicker, "style", "display: none", "Date Picker");
            datePicker = new DatePicker(getDriver(), widgetDatePicker);
            datePicker.pickADate("28");
            validateElementJSTextContain(inputEngagementDateRangeEnd, "28", "Engagement Report Deadline");

        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Body SetUp ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Footer Setup
     */
    public void verifyUINewEngagementFooterSetup() {
        try {
            validateElementText(buttonEngagementCancel, "Cancel");
            validateElementText(buttonEngagementContinue, "Continue");

            clickElement(buttonEngagementContinue, "Button Engagement Continue");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Footer Setup ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Header Team
     */
    public void verifyUINewEngagementHeaderTeam(String name) {
        try {
            validateElementText(titleHeader, name);
            validateElementText(tabProgressSetUpName, "SET-UP");
            validateElementText(tabProgressTeamName, "TEAM");
            validateElementText(tabProgressTeamNumber, "2");
            validateElementText(tabProgressCustomizeName, "CUSTOMIZE");
            validateElementText(tabProgressCustomizeNumber, "3");
            validateAttributeElement(tabProgressSetUpCircle, "class", "ce-numberCircle ce-numberCircle-active");
            validateAttributeElement(tabProgressSetUpNumber, "class", "ce-number auvicon-checkmark ce-nav-checkmark");
            validateAttributeElement(tabProgressTeamCircle, "class", "ce-numberCircle ce-numberCircle-active");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Header Team", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Body Team
     */
    public void verifyUINewEngagementBodyTeam() {
        try {
            validateAttributeContain(imageNotAddMember, "src", "images/create-engagement/single-man.png", "Image Not Add Member");
            validateElementText(titleNotAddMember, "I don't need to add any team members to this engagement");
            validateElementText(buttonNotAddMember, "Continue");
            validateAttributeContain(imageAddMember, "src", "images/create-engagement/three-men.png", "Image Add Member");
            validateElementText(titleAddMember, "I'd like to add team members to this engagement");
            validateElementText(buttonAddMember, "Add Members");

            clickElement(buttonNotAddMember, "Button Engagement Continue");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Body Team ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Header Customize
     */
    public void verifyUINewEngagementHeaderCustomize(String name) {
        try {
            validateElementText(titleHeader, name);
            validateElementText(tabProgressSetUpName, "SET-UP");
            validateElementText(tabProgressTeamName, "TEAM");
            validateElementText(tabProgressCustomizeName, "CUSTOMIZE");
            validateElementText(tabProgressCustomizeNumber, "3");
            validateAttributeElement(tabProgressSetUpCircle, "class", "ce-numberCircle ce-numberCircle-active");
            validateAttributeElement(tabProgressSetUpNumber, "class", "ce-number auvicon-checkmark ce-nav-checkmark");
            validateAttributeElement(tabProgressTeamCircle, "class", "ce-numberCircle ce-numberCircle-active");
            validateAttributeElement(tabProgressTeamNumber, "class", "ce-number auvicon-checkmark ce-nav-checkmark");
            validateAttributeElement(tabProgressCustomizeCircle, "class", "ce-numberCircle ce-numberCircle-active");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Header Customize ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Body Customize
     */
    public void verifyUINewEngagementBodyCustomize() {
        try {
            validateAttributeContain(imageRollover, "src", "images/create-engagement/file-box-grey.png", "Image Rollover");
            validateElementText(titleRollover, "Rollover a Saved Template");
            validateElementText(buttonRollover, "Rollover");
            validateAttributeContain(imageCreateToDoList, "src", "images/create-engagement/clipboard.png", "Image Create ToDo List");
            validateElementText(titleCreateToDoList, "Create your To-Do list");
            validateElementText(buttonCreateToDoList, "Create");

            clickElement(buttonCreateToDoList, "Button Create ToDo List");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Body Customize ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }
    /*-----------end of huy.huynh on 06/06/2017.*/
}
