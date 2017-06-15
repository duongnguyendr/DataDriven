package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.pages.marketing.engagement.BaseEngagementPO;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GeneralUtilities;
import com.google.common.collect.Ordering;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AuditorEngagementPage extends AbstractPage {


    AuvenirPage auvenirPage = null;
    AuditorEngagementPage auditorEngagementPage = null;

    public AuditorEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(css = "img[class='header-auvenirLogo']")
    private WebElement eleAuvenirLogoImg;

    public WebElement getEleAuvenirLogoImg() {
        return eleAuvenirLogoImg;
    }

    @FindBy(xpath = "//span[text()='My Engagements']")
    private WebElement eleMyEngmntTxt;

    public WebElement getEleMyEngmntTxt() {
        return eleMyEngmntTxt;
    }

    @FindBy(id = "newAuditBtn")
    private WebElement eleCreateNewBtn;

    public WebElement getEleCreateNewBtn() {
        return eleCreateNewBtn;
    }

    @FindBy(id = "tooltip-createEngagement-mainText")
    private WebElement eleClickhereTipTxt;

    public WebElement getEleClickhereTipTxt() {
        return eleClickhereTipTxt;
    }

    @FindBy(className = "noEngagement-txt")
    private WebElement eleYouDontHaveTxt;

    public WebElement getEleYouDontHaveTxt() {
        return eleYouDontHaveTxt;
    }

    @FindBy(id = "dashboardUsername")
    private WebElement eleAuditorNameDrpDwn;

    public WebElement getEleAuditorNameDrpDwn() {
        return eleAuditorNameDrpDwn;
    }

    @FindBy(xpath = "//a[text()='Settings']")
    private WebElement eleSettingsLnk;

    public WebElement getEleSettingsLnk() {
        return eleSettingsLnk;
    }

    @FindBy(id = "h-ddl-signOut")
    private WebElement eleSignOutLnk;

    public WebElement getEleSignOutLnk() {
        return eleSignOutLnk;
    }

    @FindBy(id = "h-f-inbox-dropdown")
    private WebElement eleChatIcn;

    public WebElement getEleChatIcn() {
        return eleChatIcn;
    }

    @FindBy(xpath = "//div[@class='au-dropdown-trigger notification-trigger']")
    private WebElement eleNotificationIcn;

    public WebElement getEleNotificationIcn() {
        return eleNotificationIcn;
    }

    @FindBy(id = "h-engagementsLink")
    private WebElement eleEngagementLnk;

    public WebElement getEleEngagementLnk() {
        return eleEngagementLnk;
    }

    @FindBy(id = "h-clientListLink")
    private WebElement eleClientsLnk;

    public WebElement getEleClientsLnk() {
        return eleClientsLnk;
    }

    @FindBy(xpath = "//div[contains(@id,'progress-')]")
    private WebElement eleEngagementNameTxt;

    public WebElement getEleEngagementNameTxt() {
        return eleEngagementNameTxt;
    }

    @FindBy(xpath = "//p[contains(@id,'date-')]")
    private WebElement eleEngagementDateTxt;

    public WebElement getEleEngagementDateTxt() {
        return eleEngagementDateTxt;
    }

    @FindBy(xpath = "//img[contains(@id,'w-ei-bgimg-')]")
    private WebElement eleEngagementImg;

    public WebElement getEleEngagementImg() {
        return eleEngagementImg;
    }

    @FindBy(xpath = "//label[text()='Set schedule']")
    private WebElement eleSetScheduleLabel;

    public WebElement getEleSetScheduleLabel() {
        return eleSetScheduleLabel;
    }

    @FindBy(id = "c-header-title")
    private WebElement myEngagementTextEle;

    @FindBy(id = "h-clientListLink")
    private WebElement contactsLinkEle;

    @FindBy(id = "newAuditBtn")
    private WebElement newEngagementButtonEle;

    // Old version
//    @FindBy(xpath = "//div[@id='cpa-main']/div")
    @FindBy(xpath = "//tbody[@id='engagement-tbody']//td/a")
    private List<WebElement> engagementListEle;

    @FindBy(xpath = "//button[contains(text(),'Add New')]")
    private WebElement eleAddNewBtn;

    //    @FindBy(xpath = "//div[@id='cpa-main']//p[@class='e-widget-auditTitle']")
    @FindBy(xpath = "//*[@id='engagement-tbody']/tr//td[8]")
    private List<WebElement> engagementTitleListEle;

    @FindBy(xpath = "//tbody[@id='engagement-tbody']/tr/td/a")
    List<WebElement> newEngagementTitleListEle;

    @FindBy(xpath = "//*[@id='CreateEnagementParent']/../../../..")
    WebElement popUpCreateEngagement;

    @FindBy(xpath = "//*[@id='auditPageNoEngagement']")
    WebElement noEngagementDivEle;

    public WebElement getEleAddNewBtn() {
        return eleAddNewBtn;
    }

    final String viewButtonOnEngagement = ".//div/div/div[2]/div[2]/input";

    @FindBy(id = "newEngagement")
    private WebElement eleNewEngagement;
    public WebElement getEleNewEngagement() { return eleNewEngagement; }

    @FindBy(id = "filter")
    private WebElement eleFilter;
    public WebElement getEleFilter() { return eleFilter; }

    @FindBy(id = "engagement-search")
    private WebElement eleSearch;
    public WebElement getElSearch() { return eleSearch; }

    @FindBy(xpath = "//*[@id=\"company-sort\"]/i")
    private WebElement eleCompany;
    public WebElement getEleCompany() { return  eleCompany; }

    @FindBy(id = "")
    private WebElement eleEngagementName;
    public WebElement getEleEngagementName() { return eleEngagementName; }

    @FindBy(id = "")
    private WebElement eleStatus;
    public WebElement getEleStatus() { return eleStatus; }

    @FindBy(id = "")
    private WebElement eleAuditorAssignee;
    public WebElement getEleAuditorAssignee() { return eleAuditorAssignee; }

    @FindBy(id = "")
    private WebElement eleCompletedToDos;
    public WebElement getEleCompletedToDos(){ return eleCompletedToDos; }

    @FindBy(id = "")
    private WebElement eleClientAssgniee;
    public WebElement getEleClientAssgniee() { return eleClientAssgniee; }

    @FindBy(id = "")
    private WebElement eleCompletedDos;
    public WebElement getEleCompletedDos(){ return  eleCompletedDos; }

    @FindBy(id = "")
    private WebElement eleLastActivity;
    public WebElement getEleLastActivity() { return  eleLastActivity; }

    @FindBy(id = "")
    private WebElement eleDueDate;
    public WebElement getEleDueDate() { return  eleDueDate; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellCompanys;
    public List<WebElement> getEleCellCompanys() { return eleCellCompanys; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellEngagements;
    public List<WebElement> getEleCellEngagements() { return eleCellEngagements; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellStatuses;
    public List<WebElement> getEleCellStatuses() { return  eleCellStatuses; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellAuditorAssignees;
    public List<WebElement> getEleCellAuditorAssignees() { return eleCellAuditorAssignees; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellCompletedToDoses;
    public List<WebElement> getEleCellCompletedToDoses() { return eleCellCompletedToDoses; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellClientAssignees;
    public List<WebElement> getEleCellClientAssignees() { return eleCellClientAssignees; }

    @FindBys(@FindBy(css= ""))
    private List<WebElement> eleCellCompleteDoses;
    public  List<WebElement> getEleCellCompleteDoses() { return eleCellCompleteDoses; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellLastActivities;
    public List<WebElement> getEleCellLastActivities() { return eleCellLastActivities; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellDueDates;
    public List<WebElement> getEleCellDueDates() { return eleCellDueDates; }

    @FindBy(xpath="//*[@id=\"engagement-tbody\"]/tr[1]/td[1]")
    private WebElement companyEle;
    private String companyEleStr = "//*[@id=\"engagement-tbody\"]/tr[1]/td[1]";

    @FindBy(xpath="//*[@id=\"engagement-tbody\"]/tr/td[1]")
    private List<WebElement> listCompanyEle;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr[1]/td[1]/a[1]")
    private WebElement engagementNameEle;
    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td/a")
    private List<WebElement> listEngagementNameEle;
    private String engagementNameStr = "//*[@id=\"engagement-tbody\"]/tr/td/a";

    /**
     * Added by huy.huynh on 08/06/2017.
     * Verify UI Engagement list
     */
    @FindBy(id = "header-blue-logo")
    private WebElement imageLogoHeaderBlue;

    @FindBy(id = "h-engagementsLink")
    private WebElement tabHeaderEngagements;

    @FindBy(id = "h-clientListLink")
    private WebElement tabHeaderContacts;

    @FindBy(id = "dashboardUsername")
    private WebElement dashboardUsername;

    @FindBy(id = "h-ddl-item-settings")
    private WebElement dashboardSettings;

    @FindBy(id = "h-ddl-signOut")
    private WebElement dashboardSignOut;

    @FindBy(xpath = "//div[@id='preview-header-left']/span")
    private WebElement titlePreviewHeader;
    //newAuditBtn
    @FindBy(xpath = "//div[@id='engagement-filters']/span")
    private WebElement selectEngagementFilters;

    @FindBy(xpath = "//div[@type='All']/span")
    private WebElement optionFilterAll;

    @FindBy(xpath = "//div[@type='Type of Engagement']/span")
    private WebElement optionFilterTypeOfEngagement;

    @FindBy(xpath = "//div[@class='menu transition visible']/div")
    private List<WebElement> listOptionTypeOfEngagement;

    @FindBy(xpath = "//div[@class='item'][text()='Financial Audit']")
    private WebElement optionTypeOfEngagementFinancialAudit;

    @FindBy(xpath = "//div[@class='item'][text()='Review']")
    private WebElement optionTypeOfEngagementReview;

    @FindBy(xpath = "//div[@class='item'][text()='Notice to reader / Compilation']")
    private WebElement optionTypeOfEngagementNoticeToReaderCompilation;

    @FindBy(xpath = "//div[@class='item'][text()='Other']")
    private WebElement optionTypeOfEngagementOther;

    @FindBy(id = "engagement-search")
    private WebElement inputEngagementSearch;

    @FindBy(id = "company-sort")
    private WebElement thCompany;

    @FindBy(id = "engagement-sort")
    private WebElement thEngagement;

    @FindBy(id = "status-sort")
    private WebElement thStatus;

    @FindBy(id = "audit-sort")
    private WebElement thAudit;

    @FindBy(id = "todo-sort")
    private WebElement thToDo;

    @FindBy(id = "client-sort")
    private WebElement thClient;

    @FindBy(id = "docs-sort")
    private WebElement thDocs;

    @FindBy(id = "activity-sort")
    private WebElement thActivity;

    @FindBy(id = "duedate-sort")
    private WebElement thDueDate;

    @FindBy(xpath = "//div[@id='preview-footer']//span")
    private WebElement titleCompanyInfo;

    @FindBy(xpath = "//div[@id='preview-footer']//a[@href][1]")
    private WebElement titleTermsOfService;

    @FindBy(xpath = "//div[@id='preview-footer']//a[@href][2]")
    private WebElement titlePrivacyStatement;

    @FindBy(xpath = "//div[@id='preview-footer']//a[@href][3]")
    private WebElement titleCookieNotice;

    protected String dateFormat = "MM/dd/YY";
    protected SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

    public enum EngagementStatus{
        ACTIVE (2), PLANING (5), COMPLETED (4), ARCHIVED (3), ABANDONED (1);

        private final int levelStatus;

        private EngagementStatus(int levelStatus){
            this.levelStatus = levelStatus;
        }
    }

    public enum UserType{
        AUDITOR (1), CLIENT (2);

        private final int levelType;

        private UserType(int levelType){ this.levelType = levelType;}
    }

    public enum UserStatus{
        ACTIVE (1), DEACTIVED (2), LOCKED (3), PENDING (4);

        private final int levelUserStatus;

        private UserStatus(int levelUserStatus){ this.levelUserStatus = levelUserStatus; }
    }

    @FindBy(id = "")
    private WebElement eleTabEngagements;
    public WebElement getEleTabEngagements() { return eleTabEngagements; }

    @FindBy(id = "")
    private WebElement eleTabContacts;
    public WebElement getEleTabContacts() { return  eleTabContacts; }

    public void auditorPageHeaderContent() {
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        GeneralUtilities.toValidate(auditorEngagementPage.getEleAuvenirLogoImg(), "Auvenir Logo", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleEngagementLnk(), "Engagement Link", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleClientsLnk(), "Clients Link", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleAuditorNameDrpDwn(), "Auditor Name Dropdown", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleSettingsLnk(), "Dropdown Settings Link", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleSignOutLnk(), "Dropdown SignOut Link", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleChatIcn(), "Chat Icon", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleNotificationIcn(), "Notification Icon", "Displayed");
    }

    public void verifyAuditorEngagementPage() {
        waitForVisibleElement(myEngagementTextEle, "myEngagementTextEle");
//        validateElementText(myEngagementTextEle, "My Engagements");
        validateElementText(myEngagementTextEle, "All Engagements");

    }

    public void navigateToContactsTab() {
        waitForClickableOfElement(contactsLinkEle, "contactsLinkEle");
        contactsLinkEle.click();

    }

    public void clickNewEnagementButton() {
        waitForVisibleElement(newEngagementButtonEle, "New Engagement Button");
        waitForClickableOfElement(newEngagementButtonEle, "New Engagement Button");
        newEngagementButtonEle.click();
    }

    /**
     * Click on the Engagement with the engagement Name.
     *
     * @param engagementName The Engagement Name which be found on Engagement page.
     */
    public void viewEngagementDetailsPage(String engagementName) throws Exception {
        int index = findEngagementName(engagementName);
        System.out.println("Position: " + index);
//        hoverElement(engagementListEle.get(index), engagementName);
        waitForClickableOfElement(engagementListEle.get(index), engagementName);
        if (index == engagementListEle.size() - 1) {
            scrollToFooter();
        } else
            hoverElement(engagementListEle.get(index + 1), engagementName);
        clickElement(engagementListEle.get(index), engagementName);
    }

    public void enterEngagementDetailWithName(String engagementTitle, String engagementName) throws Exception {
        WebElement webElement = getDriver().findElement(By.xpath("//p[contains(text(),'" + engagementTitle + "')]/ancestor::div[@id='cpa-main']//input"));
        System.out.println("+++++++++++++++++++++++++++++  " + engagementTitle);
        //current we cannot view engagement by name we test with first engagment
        //TODO bug here, fix later
        hoverElement(webElement, engagementName);
        waitForClickableOfElement(webElement, engagementName);
        clickAndHold(webElement, engagementName);
    }

    /*
    Vien.Pham moved createAndSelectNewEnagement Method
     */

    /*
     * Find the index(position) of Engagement in the list Engagement by Engagement Name
     *
     * @param engagementName String Engagement Name
     * @return the number of the position if the WebElement is matched, otherwise return -1.
     */
    public int findEngagementName(String engagementName) {
        getLogger().info("Find Position of Engagement Name");
        String displayValue = noEngagementDivEle.getCssValue("display");
        if(displayValue.equals("block"))
            return -1;
        return findElementByText(engagementListEle, engagementName);
    }

    /**
     * Get the list ID of Engagement on Engagement Page.
     *
     * @return List<String> the list ID of Engagement on Engagement Page.
     */
    public List<String> getListIdOfEngagement() {
        List<String> listIdOfEngagement = new ArrayList<String>();
        if (!listIdOfEngagement.isEmpty()) {
            for (int i = 0; i < engagementTitleListEle.size(); i++) {
                listIdOfEngagement.add(engagementTitleListEle.get(i).getText());
//                listIdOfEngagement.add(engagementTitleListEle.get(i).getAttribute("id"));
            }
        }
        return listIdOfEngagement;
    }

    /**
     * Find the new engagement which is just created.
     *
     * @param listIdOfEngagementBeforeCreate List Engagement ID before creating new one.
     * @param listIdOfEngagementAfterCreate  List Engagement ID after creating new one.
     * @return position of Engagement on Engagement page base on ID.
     */
    public int findNewEngagement(List<String> listIdOfEngagementBeforeCreate, List<String> listIdOfEngagementAfterCreate) {
        listIdOfEngagementAfterCreate.remove(listIdOfEngagementAfterCreate);
        if (!listIdOfEngagementBeforeCreate.isEmpty()) {
            for (int i = 0; i < listIdOfEngagementBeforeCreate.size(); i++) {
                String idOfEngagement = listIdOfEngagementBeforeCreate.get(i);
                for (int j = 0; j < listIdOfEngagementAfterCreate.size(); j++) {
                    if (idOfEngagement.equals(listIdOfEngagementAfterCreate.get(j))) {
                        listIdOfEngagementAfterCreate.remove(j);
                        break;
                    }
                }
            }

        }
        int sizeOflistIdOfEngagementAfterCreate = listIdOfEngagementAfterCreate.size();
        String idOfNewEngegement = listIdOfEngagementAfterCreate.get(sizeOflistIdOfEngagementAfterCreate - 1).toString();
        return findElementByAttribute(engagementTitleListEle, idOfNewEngegement, "id");
    }


    /**
     * Click Engagement on Engagement Page with the position of Engagement
     *
     * @param engagementPosition int the Engagement position which is clicked.
     */
    public void clickEngagementByPosition(int engagementPosition) throws InterruptedException {
        System.out.println("Size: " + engagementListEle.size());
        System.out.println(engagementListEle.get(engagementPosition));
        System.out.println("Position: " + engagementPosition);
//        hoverElement(engagementListEle.get(engagementPosition), "Engagement View Ite");
//        WebElement popUpCreateEngagement = getDriver().findElement(By.xpath("//*[@id='CreateEnagementParent']/../../../.."));
        waitForCssValueChanged(popUpCreateEngagement, "PopUp Create", "display", "none");
//        Thread.sleep(3000);
        waitForClickableOfElement(engagementListEle.get(engagementPosition), "Engagement View Item");
        clickElement(engagementListEle.get(engagementPosition), "Engagement View Item");
//        clickElement(engagementListEle.get(engagementPosition));
//        hoverElement(engagementListEle.get(engagementPosition).findElement(By.xpath(viewButtonOnEngagement)), "Engagement View Item");
//        waitForClickableOfElement(engagementListEle.get(engagementPosition).findElement(By.xpath(viewButtonOnEngagement)), "Engagement View Item");
//        clickAndHold(engagementListEle.get(engagementPosition).findElement(By.xpath(viewButtonOnEngagement)), "Engagement View Item");
    }

    public void clickvisibilityOfElementWait() {
        auditorEngagementPage.getEleCreateNewBtn();
    }

    public void clickClientsLink() {
        waitForClickableOfElement(eleClientsLnk, "Client link");
        clickElement(eleClientsLnk, "Client link");
    }

    public void clickAddNewButton() {
        waitForClickableOfElement(eleAddNewBtn, "Add new button");
        clickElement(eleAddNewBtn, "Add new button");
    }

    public void clickdropDownSetingLink() {
        waitForClickableOfElement(eleSettingsLnk, "Drop down setting");
        clickElement(eleSettingsLnk, "Drop down setting");
    }

    public void clickAuditorNameDropDown() {
        waitForClickableOfElement(eleAuditorNameDrpDwn, "Auditor name drop down");
        clickElement(eleAuditorNameDrpDwn, "Auditor name drop down");
    }



    /**
     * verify UI of List Engagement page - Header
     */
    public void verifyUIListEngagementHeader() {
        try {
            validateAttributeContain(imageLogoHeaderBlue, "src", "images/logos/auvenir/auvenir.svg", "Logo Auvenir Blue");
            validateElementText(tabHeaderEngagements, "Engagements");
            validateElementText(tabHeaderContacts, "Contacts");
            clickElement(dashboardUsername, "Dashboard Username");
            validateElementText(dashboardSettings, "Settings");
            validateElementText(dashboardSignOut, "Sign Out");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  List Engagement Header", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of List Engagement page - Body
     */
    public void verifyUIListEngagementBody() {
        try {
            validateElementText(titlePreviewHeader, "All Engagements");
            validateElementText(newEngagementButtonEle, "New Engagement");

            validateElementText(selectEngagementFilters, "Filters");
            clickElement(selectEngagementFilters, "Select Engagement Filters");
            validateElementText(optionFilterAll, "All");
            validateElementText(optionFilterTypeOfEngagement, "Type of Engagement");

            clickElement(optionFilterTypeOfEngagement, "Select Engagement Filters");
            validateElementsQuantity(listOptionTypeOfEngagement, 4, "List Option Type Of Engagement");
            validateElementText(optionTypeOfEngagementFinancialAudit, "Financial Audit");
            validateElementText(optionTypeOfEngagementReview, "Review");
            validateElementText(optionTypeOfEngagementNoticeToReaderCompilation, "Notice to reader / Compilation");
            validateElementText(optionTypeOfEngagementOther, "Other");
            validatePlaceholder(inputEngagementSearch, "Search...", "Input Engagement Search");
            clickElement(inputEngagementSearch, "Input Engagement Search");

            validateElementText(thCompany, "Company");
            validateElementText(thEngagement, "Engagement Name");
            validateElementText(thStatus, "Status");
            validateElementText(thAudit, "Audit Assignee");
            validateElementText(thToDo, "Completed To-Dos");
            validateElementText(thClient, "Client Assignee");
            validateElementText(thDocs, "Completed Docs");
            validateElementText(thActivity, "Last Activity");
            validateElementText(thDueDate, "Due Date");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  List Engagement Body", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of List Engagement page - Footer
     */
    public void verifyUIListEngagementFooter() {
        try {
            validateElementText(titleCompanyInfo, "© 2017 Auvenir Inc. All rights reserved.");
            validateElementText(titleTermsOfService, "Terms of Service");
            validateAttributeContain(titleTermsOfService, "href", "terms", "Terms Of Service");
            validateElementText(titlePrivacyStatement, "Privacy Statement");
            validateAttributeContain(titlePrivacyStatement, "href", "privacy", "Privacy Statement");
            validateElementText(titleCookieNotice, "Cookie Notice");
            validateAttributeContain(titleCookieNotice, "href", "cookies", "Cookie Notice");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  List Engagement Footer", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }
    /*-----------end of huy.huynh on 08/06/2017.*/

    public void sendKeyCompanyName(String companyName) throws InterruptedException {
        Thread.sleep(smallTimeOut);
        sendKeyTextBox(eleSearch, companyName, "search key keyCompany");
        Thread.sleep(smallTimeOut);
    }

    public void verifyCompanyName(String companyName)
    {
        try {
            getLogger().info("companyName = " + companyName);
            boolean isCheckCompany = false;
            if (waitForVisibleOfLocator(By.xpath(companyEleStr), waitTimeOut)) {
                for (WebElement companyEle : listCompanyEle) {
                    getLogger().info("companyEle.getText() = " + companyEle.getText());
                    Thread.sleep(smallerTimeOut);
                    if (companyEle.getText().equals(companyName)) {
                        isCheckCompany = true;
                        break;
                    }
                }
            }
            if (!isCheckCompany) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Search engagement with company key: " + companyName, LogAs.FAILED, null);
            } else {
                NXGReports.addStep("Search engagement with company key: " + companyName, LogAs.PASSED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Search engagement with company key: " + companyName, LogAs.FAILED, null);
        }
    }

    public void sendKeyEngagementName(String engagementName) throws InterruptedException {
        Thread.sleep(smallTimeOut);
        sendKeyTextBox(eleSearch, engagementName, "search key keyEngagement");
        Thread.sleep(smallTimeOut);
    }

    public void verifyEngagementName(String engagementName)
    {
        try {
            getLogger().info("engagementName = " + engagementName);
            boolean isCheckEngagement = false;
            //Checking for result
            if (waitForVisibleOfLocator(By.xpath(engagementNameStr), waitTimeOut)) {
                for (WebElement engagementNameEle : listEngagementNameEle) {
                    getLogger().info("engagementNameEle.getText() = " + engagementNameEle.getText());
                    Thread.sleep(smallerTimeOut);
                    if (engagementNameEle.getText().equals(engagementName)) {
                        isCheckEngagement = true;
                        break;
                    }
                }
            }
            if (!isCheckEngagement) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Search engagement with engagement name key: " + engagementName, LogAs.FAILED, null);
            } else {
                NXGReports.addStep("Search engagement with engagement name key: " + engagementName, LogAs.PASSED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Search engagement with engagement name key: " + engagementName, LogAs.FAILED, null);
        }
    }

    /**
     * Checking sort by ASC or DESC of User Status list
     * @param userStatuses
     * @param isAsc
     */
    public void checkSortUserStatus(List<UserStatus> userStatuses, boolean isAsc){
        Collections.sort(userStatuses, new Comparator<UserStatus>() {
            @Override
            public int compare(UserStatus o1, UserStatus o2) {
                if(isAsc && o1.levelUserStatus < o2.levelUserStatus){
                    return 1;
                }else if(!isAsc && o1.levelUserStatus > o2.levelUserStatus){
                    return 1;
                }
                return 0;
            }
        });

        if(isAsc){
            boolean isSort = Ordering.natural().isOrdered(userStatuses);
            if(!isSort){
                NXGReports.addStep("Sorting by asc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }else{
            boolean isSort = Ordering.natural().reverse().isOrdered(userStatuses);
            if(!isSort){
                NXGReports.addStep("Sorting by desc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }
    }

    /**
     * Checking sort by ASC or DESC of User Type list
     * @param types
     * @param isAsc
     */
    public void checkSortUserType(List<UserType> types, boolean isAsc){
        Collections.sort(types, new Comparator<UserType>() {
            @Override
            public int compare(UserType o1, UserType o2) {
                if(isAsc && o1.levelType < o2.levelType){
                    return 1;
                }else if(!isAsc && o1.levelType > o2.levelType){
                    return 1;
                }
                return 0;
            }
        });

        if(isAsc){
            boolean isSort = Ordering.natural().isOrdered(types);
            if(!isSort){
                NXGReports.addStep("Sorting by asc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }else{
            boolean isSort = Ordering.natural().reverse().isOrdered(types);
            if(!isSort){
                NXGReports.addStep("Sorting by desc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }
    }

    /**
     * Checking sort by ASC or DESC of Engagement Status list
     * @param statuses
     * @param isAsc
     */
    public void checkSortEngagementStatusOfList(List<EngagementStatus> statuses, boolean isAsc){
        Collections.sort(statuses, new Comparator<EngagementStatus>() {
            @Override
            public int compare(EngagementStatus o1, EngagementStatus o2) {
                if(isAsc && o1.levelStatus < o2.levelStatus){
                    return 1;
                }else if(!isAsc && o1.levelStatus > o2.levelStatus){
                    return 1;
                }
                return 0;
            }
        });

        if(isAsc){
            boolean isSort = Ordering.natural().isOrdered(statuses);
            if(!isSort){
                NXGReports.addStep("Sorting by asc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }else{
            boolean isSort = Ordering.natural().reverse().isOrdered(statuses);
            if(!isSort){
                NXGReports.addStep("Sorting by desc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }
    }

    /**
     * Checking sort by ASC or DESC of date list
     * @param dates
     * @param isAsc
     */
    public void checkSortDateOfList(List<Date> dates, boolean isAsc){
        Collections.sort(dates, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                if(isAsc && o1.before(o2))
                    return  1;
                else if(!isAsc && o1.after(o2))
                    return  1;
                return 0;
            }
        });
        if(isAsc){
            boolean isSort = Ordering.natural().isOrdered(dates);
            if(!isSort){
                NXGReports.addStep("Sorting by asc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }else{
            boolean isSort = Ordering.natural().reverse().isOrdered(dates);
            if(!isSort){
                NXGReports.addStep("Sorting by desc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }
    }

    /**
     * check sort of list number
     * @param lst
     * @param isAsc
     */
    public void checkSortNumberOfList(List<Double> lst, boolean isAsc){
        Collections.sort(lst, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(isAsc && o1 > o2)
                    return 1;
                else if(!isAsc && o1 < o2)
                    return 1;
                return 0;
            }
        });
        if(isAsc){
            boolean isSort = Ordering.natural().isOrdered(lst);
            if(!isSort){
                NXGReports.addStep("Sorting by asc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }else{
            boolean isSort = Ordering.natural().reverse().isOrdered(lst);
            if(!isSort){
                NXGReports.addStep("Sorting by desc is failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                Assert.assertTrue(isSort);
            }
        }
    }

    /**
     * Check sort by alphabet asc or desc of list elements
     * @param elements
     * @param isAsc
     * @return
     */
    public boolean sortAlphabetOfListElement(List<WebElement> elements, boolean isAsc){
        boolean isSortAlphabet = false;
        getLogger().info("isAsc = " + isAsc);
        try{

            String[] expectedArray = new String[elements.size()];
            for(int i = 0; i < elements.size(); i++){
                expectedArray[i] = elements.get(i).getText();
            }

            Thread.sleep(smallTimeOut);
            clickElement(eleCompany, "click1 to eleCompany");
            Thread.sleep(smallTimeOut);
            clickElement(eleCompany, "click2 to eleCompany");

            String[] actualArrays = new String[elements.size()];
            for(int i = 0; i < elements.size(); i++){
                actualArrays[i] = elements.get(i).getText();
            }

            if(isAsc){
                Arrays.sort(expectedArray);
            }else{
                Arrays.sort(expectedArray, Collections.reverseOrder());
            }

            for (int i = 0; i < expectedArray.length; i++) {
                getLogger().info("expectedArray[i] = " + expectedArray[i]);
                getLogger().info("actualArrays[i] = " + actualArrays[i]);
                if(!expectedArray[i].equals(actualArrays[i])){
                    NXGReports.addStep("Sort by " + (isAsc == true ? "ascending" : "descending") + " fails at row " + (i + 1), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError("Sort by " + (isAsc == true ? "ascending" : "descending") + " fails at row " + (i + 1));
                }
            }
            isSortAlphabet = true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return isSortAlphabet;
    }

    public boolean sortCompanyNameAscending(List<WebElement> elements, boolean isAsc){
        boolean isSortAlphabet = false;
        getLogger().info("isAsc = " + isAsc);
        try{

            String[] expectedArray = new String[elements.size()];
            for(int i = 0; i < elements.size(); i++){
                expectedArray[i] = elements.get(i).getText();
            }

            Thread.sleep(smallTimeOut);
            clickElement(eleCompany, "click1 to eleCompany");
            Thread.sleep(smallTimeOut);
            clickElement(eleCompany, "click2 to eleCompany");

            String[] actualArrays = new String[elements.size()];
            for(int i = 0; i < elements.size(); i++){
                actualArrays[i] = elements.get(i).getText();
            }

            if(isAsc){
                Arrays.sort(expectedArray);
            }else{
                Arrays.sort(expectedArray, Collections.reverseOrder());
            }

            for (int i = 0; i < expectedArray.length; i++) {
                getLogger().info("expectedArray[i] = " + expectedArray[i]);
                getLogger().info("actualArrays[i] = " + actualArrays[i]);
                if(!expectedArray[i].equals(actualArrays[i])){
                    NXGReports.addStep("Sort by " + (isAsc == true ? "ascending" : "descending") + " fails at row " + (i + 1), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError("Sort by " + (isAsc == true ? "ascending" : "descending") + " fails at row " + (i + 1));
                }
            }
            isSortAlphabet = true;
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return isSortAlphabet;
    }

    /**
     * Sort Company name by ASC or DESC
     * @param isAsc
     */
    public void sortCompanyName(boolean isAsc) throws InterruptedException {
        if(isAsc){
//            Thread.sleep(smallTimeOut);
//            clickElement(eleCompany, "click1 to eleCompany");
//            Thread.sleep(smallTimeOut);
//            clickElement(eleCompany, "click2 to eleCompany");
            try {
                Thread.sleep(smallTimeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean isSortAlphabet = sortCompanyNameAscending(listCompanyEle, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort company name in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort company name in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * Sort Engagement by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementName(boolean isAsc){
        NXGReports.addStep("Sort engagement name in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );

        if(!isAsc){
            eleEngagementName.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sortAlphabetOfListElement(eleCellEngagements, isAsc);
    }

    /**
     * Sort Status engagement by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementStatus(boolean isAsc){
        NXGReports.addStep("Sort engagement status by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            eleStatus.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<EngagementStatus> lst = new ArrayList<>();
        for (WebElement ele : eleCellStatuses){
            EngagementStatus status = EngagementStatus.valueOf(ele.getText());
            lst.add(status);
        }
        checkSortEngagementStatusOfList(lst, isAsc);

        //check sort type alpha for company columns if there are many the same status
        int start = 0, end = 0;
        for (int i = 0; i < eleCellStatuses.size(); i++) {
            for (int j = i + 1; j < eleCellStatuses.size(); j++){
                if(eleCellStatuses.get(i).getText().equals(eleCellStatuses.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;

                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellCompanys.subList(start, end));
                        sortAlphabetOfListElement(elements, isAsc);
                    }
                }
            }
        }
    }

    /**
     * Sort auditor assignee
     * @param isAsc
     */
    public void sortAuditorAssignee(boolean isAsc){
        NXGReports.addStep("Sort auditor assignee in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            eleAuditorAssignee.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sortAlphabetOfListElement(eleCellCompanys, isAsc);
    }

    /**
     * Sort client assign by ASC or DESC
     * @param isAsc
     */
    public void sortCompletedToDos(boolean isAsc){

        NXGReports.addStep("Sort completed to docs in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            eleCompletedToDos.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<Double> lst = new ArrayList<>();
        for (WebElement ele : eleCellCompletedToDoses){
            double value = Double.parseDouble(ele.getText());
            lst.add(value);
        }

        checkSortNumberOfList(lst, isAsc);

        //check sort type alpha for company columns if there are many the same Completed To Docs
        int start = 0, end = 0;
        for (int i = 0; i < eleCellCompletedToDoses.size(); i++) {
            for (int j = i + 1; j < eleCellCompletedToDoses.size(); j++){
                if(eleCellCompletedToDoses.get(i).getText().equals(eleCellCompletedToDoses.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;
                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellCompanys.subList(start, end));
                        sortAlphabetOfListElement(elements, isAsc);
                    }
                }
            }
        }
    }

    /**
     * Sort client assignee by ASC or DESC
     * @param isAsc
     */
    public void sortClientAssignee(boolean isAsc){
        NXGReports.addStep("Sort client assignee in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            eleClientAssgniee.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sortAlphabetOfListElement(eleCellClientAssignees, isAsc);
    }

    /**
     * Sort client completed docs
     * @param isAsc
     */
    public void sortClientCompletedDocs(boolean isAsc){

        NXGReports.addStep("Sort completed docs in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            eleCompletedDos.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<Double> lst = new ArrayList<>();
        for (WebElement ele : eleCellCompleteDoses){
            double value = Double.parseDouble(ele.getText());
            lst.add(value);
        }

        checkSortNumberOfList(lst, isAsc);

        //check sort type alpha for company columns if there are many the same Completed Docs
        int start = 0, end = 0;
        for (int i = 0; i < eleCellCompleteDoses.size(); i++) {
            for (int j = i + 1; j < eleCellCompleteDoses.size(); j++){
                if(eleCellCompleteDoses.get(i).getText().equals(eleCellCompleteDoses.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;
                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellCompanys.subList(start, end));
                        sortAlphabetOfListElement(elements, isAsc);
                    }
                }
            }
        }
    }

    /**
     * Sort last activity
     * @param isAsc
     */
    public void sortLastActivity(boolean isAsc){

        NXGReports.addStep("Sort last activity in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            eleLastActivity.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<Date> dates = new ArrayList<>();
        try {
            for (WebElement ele : eleCellLastActivities){
                dates.add(sdf.parse(ele.getText()));
            }
        } catch (ParseException e) {
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }

        checkSortDateOfList(dates, isAsc);

        //check sort type alpha for company columns if there are many the same Last Activity
        int start = 0, end = 0;
        for (int i = 0; i < eleCellLastActivities.size(); i++) {
            for (int j = i + 1; j < eleCellLastActivities.size(); j++){
                if(eleCellLastActivities.get(i).getText().equals(eleCellLastActivities.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;
                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellCompanys.subList(start, end));
                        sortAlphabetOfListElement(elements, isAsc);
                    }
                }
            }
        }
    }

    /**
     * Sort due date of an engagement
     * @param isAsc
     */
    public  void sortDueDate(boolean isAsc){

        NXGReports.addStep("Sort due date in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            eleDueDate.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<Date> dates = new ArrayList<>();
        try {
            for (WebElement ele : eleCellDueDates){
                dates.add(sdf.parse(ele.getText()));
            }
        } catch (ParseException e) {
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }

        checkSortDateOfList(dates, isAsc);

        //check sort type alpha for company columns if there are many the same Last Activity
        int start = 0, end = 0;
        for (int i = 0; i < eleCellDueDates.size(); i++) {
            for (int j = i + 1; j < eleCellDueDates.size(); j++){
                if(eleCellDueDates.get(i).getText().equals(eleCellDueDates.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;
                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellCompanys.subList(start, end));
                        sortAlphabetOfListElement(elements, isAsc);
                    }
                }
            }
        }
    }

    /**
     * Search by company name, engagement name, auditor assignee, client assignee
     * @param keySearch
     */
    public void search(String keySearch) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        NXGReports.addStep("Search engagement with key: " + keySearch, LogAs.PASSED, null );
        sendKeyTextBox(eleSearch,keySearch,"search key eleSearch");
        Thread.sleep(smallTimeOut);

        //Checking for result
        for (int i = 0; i < this.eleCellCompanys.size(); i++){
            WebElement ele = eleCellCompanys.get(i);
            if(!ele.getText().toLowerCase().contains(keySearch.toLowerCase()) ||
                    !eleCellEngagements.get(i).getText().toLowerCase().contains(keySearch.toLowerCase()) ||
                    !eleCellAuditorAssignees.get(i).getText().toLowerCase().contains(keySearch.toLowerCase()) ||
                    !eleCellClientAssignees.get(i).getText().toLowerCase().contains(keySearch.toLowerCase())){
                NXGReports.addStep("The result data is not match with key search at row " + i + 1, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                throw new AssertionError("The result data is not match with key search at row " + i + 1);
            }
        }
    }

    /**
     * TODO
     * Filter engagement by 'Audit', 'Compilations', 'Reviews', 'Note To Reader'
     */
    public void filter(){
        this.eleFilter.click();


    }
}