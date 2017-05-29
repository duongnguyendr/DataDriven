package com.auvenir.ui.pages.marketing.engagement;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by toan.nguyenp on 5/8/2017.
 */
public class AdminPortalReviewPO extends BaseEngagementPO {

    @FindBy(id = "")
    private WebElement eleFilter;
    public WebElement getEleFilter() { return eleFilter; }

    @FindBy(id = "")
    private WebElement eleSearch;
    public WebElement getEleSearch() { return  eleSearch; }

    @FindBy(id= "")
    private WebElement titleUser;
    public WebElement getTitleUser() { return titleUser; }

    @FindBy(id = "")
    private WebElement titleType;
    public WebElement getTitleType() { return  titleType; }

    @FindBy(id = "")
    private WebElement titleEmail;
    public WebElement getTitleEmail() { return  titleEmail; }

    @FindBy(id = "")
    private WebElement titleSignUpDate;
    public WebElement getTitleSignUpDate() { return titleSignUpDate; }

    @FindBy(id = "")
    private WebElement eleStatus;
    public WebElement getEleStatus() { return eleStatus; }

    @FindBys(@FindBy(id = ""))
    private List<WebElement> eleCellUsers;
    public List<WebElement> getEleCellUsers() { return eleCellUsers; }

    @FindBys(@FindBy(id = ""))
    private List<WebElement> eleCellTypes;
    public List<WebElement> getEleCellTypes() { return  eleCellTypes; }

    @FindBys(@FindBy(id = ""))
    private List<WebElement> eleCellEmails;
    public List<WebElement> getEleCellEmails() { return eleCellEmails; }

    @FindBys(@FindBy(id = ""))
    private List<WebElement> eleCellSignUpDates;
    public List<WebElement> getCellEleSignUpDates() { return  eleCellSignUpDates; }

    @FindBys(@FindBy(id = ""))
    private List<WebElement> eleCellStatuses;
    public List<WebElement> getEleCellStatuses() { return  eleCellStatuses; }

    public AdminPortalReviewPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    /*@Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }*/

    /**
     * Sort User name by alphabet
     * @param isAsc
     */
    public void sortUser(boolean isAsc){
        NXGReports.addStep("Sort user name in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            titleUser.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sortAlphabetOfListElement(eleCellUsers, isAsc);
    }

    /**
     * Sort user type
     * @param isAsc
     */
    public void sortUserType(boolean isAsc){
        NXGReports.addStep("Sort user type in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        if(!isAsc){
            titleType.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<UserType> lst = new ArrayList<>();
        for (WebElement ele : eleCellTypes){
            UserType status = UserType.valueOf(ele.getText());
            lst.add(status);
        }

        checkSortUserType(lst, isAsc);
    }

    /**
     * Sort email by alphabet
     * @param isAsc
     */
    public void sortEmail(boolean isAsc){
        NXGReports.addStep("Sort email in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        sortAlphabetOfListElement(eleCellEmails, isAsc);
    }

    /**
     * Sort Sign Up Date
     * @param isAsc
     */
    public void sortSignUpDate(boolean isAsc){
        List<Date> dates = new ArrayList<>();
        try {
            for (WebElement ele : eleCellSignUpDates){
                dates.add(sdf.parse(ele.getText()));
            }
        } catch (ParseException e) {
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }

        checkSortDateOfList(dates, isAsc);
    }

    /**
     * Sort User Status
     * @param isAsc
     */
    public void sortStatus(boolean isAsc){
        List<UserStatus> lst = new ArrayList<>();
        for (WebElement ele : eleCellStatuses){
            UserStatus status = UserStatus.valueOf(ele.getText());
            lst.add(status);
        }

        checkSortUserStatus(lst, isAsc);
    }

    /**
     * Search user or email
     * @param keySearch
     */
    public void search(String keySearch){
        eleSearch.sendKeys(keySearch);
        eleSearch.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < this.eleCellUsers.size(); i++){
            WebElement ele = eleCellUsers.get(i);
            if(!ele.getText().toLowerCase().contains(keySearch.toLowerCase()) ||
                    !eleCellEmails.get(i).getText().toLowerCase().contains(keySearch.toLowerCase())){
                NXGReports.addStep("The result data is not match with key search at row " + i + 1, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                throw new AssertionError("The result data is not match with key search at row " + i + 1);
            }
        }
    }

    public void filter(String type){

        switch (type){
            case "LOCKED":
                for (WebElement ele: eleCellStatuses) {
                    if(!ele.getText().equals("Lock")){
                        NXGReports.addStep("Filter user by locked status", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        throw new AssertionError("Filter user by locked status");
                    }
                }
                break;
            case "DEACTIVED":
                for (WebElement ele: eleCellStatuses) {
                    if(!ele.getText().equals("Deactive")){
                        NXGReports.addStep("Filter user by locked status", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        throw new AssertionError("Filter user by locked status");
                    }
                }
                break;
            case "ACTIVED":
                for (WebElement ele: eleCellStatuses) {
                    if(!ele.getText().equals("Active")){
                        NXGReports.addStep("Filter user by locked status", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        throw new AssertionError("Filter user by locked status");
                    }
                }
                break;
            case "PENDING":
                for (WebElement ele: eleCellStatuses) {
                    if(!ele.getText().equals("Pending")){
                        NXGReports.addStep("Filter user by locked status", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        throw new AssertionError("Filter user by locked status");
                    }
                }
                break;
            case "Client":
                for (WebElement ele: eleCellTypes) {
                    if(!ele.getText().equals("Client")){
                        NXGReports.addStep("Filter user by locked status", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        throw new AssertionError("Filter user by locked status");
                    }
                }
                break;
            case "Auditor":
                for (WebElement ele: eleCellTypes) {
                    if(!ele.getText().equals("Auditor")){
                        NXGReports.addStep("Filter user by locked status", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        throw new AssertionError("Filter user by locked status");
                    }
                }
                break;
            default:
                break;
        }
    }
}
