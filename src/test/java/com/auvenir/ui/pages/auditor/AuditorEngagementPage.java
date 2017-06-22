package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
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

import java.text.SimpleDateFormat;
import java.util.*;

//import com.auvenir.ui.pages.marketing.engagement.BaseEngagementPO;

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

    @FindBy(xpath = "//*[@id=\"engagement-sort\"]/i")
    private WebElement eleEngagementName;
    public WebElement getEleEngagementName() { return eleEngagementName; }

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
    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[3]/span")
    private List<WebElement> listEngagementStatusEle;
    @FindBy(xpath = "//*[@id=\"status-sort\"]/i")
    private WebElement engagementStatusHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[4]")
    private List<WebElement> listEngagementAssigneeEle;
    @FindBy(xpath = "//*[@id=\"audit-sort\"]/i")
    private WebElement engagementAssigneeHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[5]/span")
    private List<WebElement> listEngagementCompleteToDosEle;
    @FindBy(xpath = "//*[@id=\"todo-sort\"]/i")
    private WebElement engagementCompleteToDosHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[6]")
    private List<WebElement> listEngagementClientAssigneeEle;
    @FindBy(xpath = "//*[@id=\"client-sort\"]/i")
    private WebElement engagementClientAssigneeHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[7]/span")
    private List<WebElement> listEngagementCompleteDocsEle;
    @FindBy(xpath = "//*[@id=\"docs-sort\"]/i")
    private WebElement engagementCompleteDocsHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[8]")
    private List<WebElement> listEngagementLastActivityEle;
    @FindBy(xpath = "//*[@id=\"activity-sort\"]/i")
    private WebElement engagementLastActivityHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/div")
    private List<WebElement> listEngagementDueDateEle;
    @FindBy(xpath = "//*[@id=\"duedate-sort\"]/i")
    private WebElement engagementDueDateHeader;

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
     * verifyEngagementStatusWhenCheckCompleteToDo - TanPh - 2017/06/21 - Start
     *
     **/
    private static String engagementStatusBefore = "planning";
    private static String engagementToDoBefore = "";


    @FindBy(xpath = "//td[@class='status']/span")
    private List<WebElement> eleEngagementStatusList;

    @FindBy(xpath = "//td[@class='completed-todos']/span[@class='warning']")
    private List<WebElement> eleEngagementToDoList;

    /**
     * verifyEngagementStatusWhenCheckCompleteToDo - TanPh - 2017/06/20 - End
     *
     */

    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - End
     *
     */
    private static final String ENGAGEMENT_STATUS_COMPLETE = "complete";
    private static final String ENGAGEMENT_TODO_COMPLETE = "100";
    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - End
     *
     */


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
        clickElement(contactsLinkEle, "click to contactsLinkEle");
    }

    public void clickNewEnagementButton() {
        waitForVisibleElement(newEngagementButtonEle, "New Engagement Button");
        waitForClickableOfElement(newEngagementButtonEle, "New Engagement Button");
        clickElement(newEngagementButtonEle, "click to newEngagementButtonEle");
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
        companyName = "companyName123";
        sendKeyTextBox(eleSearch, companyName, "search key keyCompany");
        Thread.sleep(smallTimeOut);
    }

    public void verifyCompanyName(String companyName)
    {
        try {
            companyName = "companyName123";
            getLogger().info("companyName = " + companyName);
            boolean isCheckCompany = false;
            if (waitForVisibleOfLocator(By.xpath(companyEleStr))) {
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
            if (waitForVisibleOfLocator(By.xpath(engagementNameStr))) {
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

    public boolean sortColumnListEngagement(List<WebElement> listElements, WebElement sortColumn, boolean isAsc){
        boolean isSortAlphabet = true;
        getLogger().info("isAsc = " + isAsc);
        try{

            if(isAsc) {
                Thread.sleep(smallTimeOut);
                clickElement(sortColumn, "click1 to sortColumn");
            }
            if(!isAsc) {
                Thread.sleep(smallTimeOut);
                clickElement(sortColumn, "click2 to sortColumn");
            }

            String[] expectedArray = new String[listElements.size()];
            for(int i = 0; i < listElements.size(); i++){
                expectedArray[i] = listElements.get(i).getText();
            }

            String[] actualArrays = new String[listElements.size()];
            for(int i = 0; i < listElements.size(); i++){
                actualArrays[i] = listElements.get(i).getText();
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
                    isSortAlphabet = false;
                    break;
                }
            }

        }catch (Exception e){
            isSortAlphabet = false;
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

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listCompanyEle, eleCompany, isAsc);
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
     * Sort Engagement Name by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementName(boolean isAsc) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listEngagementNameEle, eleEngagementName, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort engagement name in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort engagement name in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * Sort Engagement Status by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementStatus(boolean isAsc) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listEngagementStatusEle, engagementStatusHeader, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort engagement status in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort engagement status in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * Sort Engagement Assignee by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementAssignee(boolean isAsc) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listEngagementAssigneeEle, engagementAssigneeHeader, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort engagement audit assignee in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort engagement audit assignee in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * Sort Engagement Completed To Dos by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementCompleteToDos(boolean isAsc) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listEngagementCompleteToDosEle, engagementCompleteToDosHeader, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort engagement completed to dos in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort engagement completed to dos in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * Sort Engagement Client Assignee by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementClientAssignee(boolean isAsc) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listEngagementClientAssigneeEle, engagementClientAssigneeHeader, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort Client Assignee to dos in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort Client Assignee to dos in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * Sort Engagement Completed Docs by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementCompletedDocs(boolean isAsc) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listEngagementClientAssigneeEle, engagementClientAssigneeHeader, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort engagement completed docs in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort engagement completed docs in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * Sort Engagement Last Activity by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementLastActivity(boolean isAsc) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listEngagementLastActivityEle, engagementLastActivityHeader, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort engagement last activity in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort engagement last activity in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * Sort Engagement Due Date by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementDueDate(boolean isAsc) throws InterruptedException {

        Thread.sleep(smallTimeOut);
        boolean isSortAlphabet = sortColumnListEngagement(listEngagementDueDateEle, engagementDueDateHeader, isAsc);
        if(isSortAlphabet)
        {
            NXGReports.addStep("Sort engagement due date in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Sort engagement due date in column by " + (isAsc == true ? "ascending": "descending"), LogAs.FAILED, null );
        }
    }

    /**
     * TODO
     * Filter engagement by 'Audit', 'Compilations', 'Reviews', 'Note To Reader'
     */
    public void filter(){
        clickElement(eleFilter, "click to eleFilter");
    }

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/21 - Start
     *
     **/

    /**
     * Verify engagement overview ToDo does not change when click on close icon popup / cancel button
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementStatusDoesNotChange(boolean isCloseIconClick, String engagementName) {
        int index = findEngagementName(engagementName);
        String strStepSuccess = "Verify engagement status does not change when click on close icon popup";
        String strStepFail = "TestScript Failed: Verify engagement status change when click on close icon popup";
        if(!isCloseIconClick){
            strStepSuccess = "Verify engagement status does not change when click on cancel button";
            strStepFail = "TestScript Failed: Verify engagement status change when click on cancel button";
        }
        try {
            boolean result;
            result = engagementStatusBefore.toLowerCase().equals(eleEngagementStatusList.get(index).getText().trim().toLowerCase());
            org.testng.Assert.assertTrue(result, "Engagement stauts does not change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify engagement status does not change when click on close icon popup / cancel button
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementToDoDoesNotChange(boolean isCloseIconClick, String engagementName) {
        int index = findEngagementName(engagementName);
        String strStepSuccess = "Verify engagement ToDo does not change when click on close icon popup";
        String strStepFail = "TestScript Failed: Verify engagement ToDo change when click on close icon popup";
        if(!isCloseIconClick){
            strStepSuccess = "Verify engagement ToDo does not change when click on cancel button";
            strStepFail = "TestScript Failed: Verify engagement ToDo change when click on cancel button";
        }
        try {
            boolean result;
            result = engagementToDoBefore.toLowerCase().equals(eleEngagementToDoList.get(index).getText().trim().toLowerCase());
            org.testng.Assert.assertTrue(result, "Engagement todo does not change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify engagement status change when click on archive button
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void verifyEngagementStatusChange(String engagementName) {
        int index = findEngagementName(engagementName);
        String strStepSuccess = "Verify engagement status change when click on archive button";
        String strStepFail = "TestScript Failed: Verify engagement status does not change when click on archive button";
        try {
            boolean result;
            result = engagementStatusBefore.toLowerCase().equals(eleEngagementStatusList.get(index).getText().trim().toLowerCase());
            org.testng.Assert.assertFalse(result, "Engagement stauts change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify engagement ToDo change when click on archive button
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void verifyEngagementToDoChange(String engagementName) {
        int index = findEngagementName(engagementName);
        String strStepSuccess = "Verify engagement ToDo change when click on archive button";
        String strStepFail = "TestScript Failed: Verify engagement ToDo does not change when click on archive button";
        try {
            boolean result;
            result = engagementToDoBefore.toLowerCase().equals(eleEngagementToDoList.get(index).getText().trim().toLowerCase());
            org.testng.Assert.assertFalse(result, "Engagement todo change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Get engagement overview status and Todo follow engagement name
     * @param engagementName : engagement need search
     * @throws Exception
     */
    public void getEngagementStatusAndToDoBefor(String engagementName){
        int index = findEngagementName(engagementName);
        if(index != -1){
            engagementStatusBefore = eleEngagementStatusList.get(index).getText().trim();
            engagementToDoBefore = eleEngagementToDoList.get(index).getText().trim();
        }
    }

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/21 - End
     *
     **/

    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - Start
     *
     **/
    /**
     * Verify engagement status complete
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void verifyEngagementStatusIsComplete(String engagementName) {
        int index = findEngagementName(engagementName);
        String strStepSuccess = "Verify engagement status is complete";
        String strStepFail = "TestScript Failed: Verify engagement status is not complete";
        try {
            boolean result;
            result = ENGAGEMENT_STATUS_COMPLETE.equals(eleEngagementStatusList.get(index).getText().trim().toLowerCase());
            org.testng.Assert.assertTrue(result, "Engagement stauts is complete");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     * Verify engagement ToDo complete
     * @author : TanPham
     * @date : 2017/06/21
     */

    public void verifyEngagementToDoIsComplete(String engagementName) {
        int index = findEngagementName(engagementName);
        String strStepSuccess = "Verify engagement ToDo is complete";
        String strStepFail = "TestScript Failed: Verify engagement ToDo is not complete";
        try {
            boolean result;
            String strEngagementToDo =  eleEngagementToDoList.get(index).getText().trim().toLowerCase().split("%")[0];
            result = ENGAGEMENT_TODO_COMPLETE.equals(strEngagementToDo);
            org.testng.Assert.assertTrue(result, "Engagement ToDo is complete");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - End
     *
     **/
}