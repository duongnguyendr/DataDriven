package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GeneralUtilities;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(id = "company")
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
    @FindBy(xpath="//*[@id=\"engagement-tbody\"]/tr/td")
    private List<WebElement> listCompanyEle;
    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr[1]/td[1]/a[1]")
    private WebElement engagementNameEle;
    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td/a")
    private List<WebElement> listEngagementNameEle;

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
        clickAndHold(engagementListEle.get(index), engagementName);
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

    /**
     * Search by company name, engagement name, auditor assignee, client assignee
     * @param keyCompany
     */
    public void searchEngagement(String keyCompany, String keyEngagement) throws InterruptedException {
        getLogger().info("Verify to search engagement by company or engagement");
        try {
            Thread.sleep(smallTimeOut);
            keyCompany = "keyTe45";
            sendKeyTextBox(eleSearch, keyCompany, "search key keyCompany");
            Thread.sleep(smallTimeOut);

            boolean isCheckCompany = false;
            if(waitForVisibleOfLocator(By.xpath(companyEleStr), waitTimeOut))
            {
                for (WebElement companyEle : listCompanyEle) {
                    if (companyEle.getText().equals(keyCompany)) {
                        isCheckCompany = true;
                        break;
                    }
                }
            }
            if (!isCheckCompany) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Search engagement with company key: " + keyCompany, LogAs.FAILED, null);
            } else {
                NXGReports.addStep("Search engagement with company key: " + keyCompany, LogAs.PASSED, null);
            }

            Thread.sleep(smallTimeOut);
            sendKeyTextBox(eleSearch, keyEngagement, "search key keyEngagement");
            Thread.sleep(smallTimeOut);
            boolean isCheckEngagement = false;
            //Checking for result
            if (!listEngagementNameEle.isEmpty()) {
                for (WebElement engagementNameEle : listEngagementNameEle) {
                    if (engagementNameEle.getText().equals(keyEngagement)) {
                        isCheckEngagement = true;
                        break;
                    }
                }
            }
            if (!isCheckEngagement) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Search engagement with engagement name key: " + keyEngagement, LogAs.FAILED, null);
            } else {
                NXGReports.addStep("Search engagement with engagement name key: " + keyEngagement, LogAs.PASSED, null);
            }

            if (isCheckCompany && isCheckEngagement) {
                NXGReports.addStep("Search engagement with company and engagement name key: " + keyCompany + " and " + keyEngagement, LogAs.PASSED, null);
            }
        }
        catch (Exception ex)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Search engagement with company and engagement name key: " + keyCompany, LogAs.FAILED, null);
        }
    }
}