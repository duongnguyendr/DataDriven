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
 * Created by cuong.nguyen on 5/5/2017.
 */
public class ClientEngagementReviewPO extends BaseEngagementPO {

    @FindBy(id = "filter")
    private WebElement eleFilter;
    public WebElement getEleFilter() { return eleFilter; }

    @FindBy(id = "search")
    private WebElement eleSearch;
    public WebElement getElSearch() { return eleSearch; }

    @FindBy(id = "")
    private WebElement eleEngagementName;
    public WebElement getEleEngagementName() { return eleEngagementName; }

    @FindBy(id = "")
    private WebElement eleAuditFirm;
    public WebElement getEleAuditFirm(){ return eleAuditFirm; }

    @FindBy(id = "")
    private WebElement eleStatus;
    public WebElement getEleStatus() { return eleStatus; }

    @FindBy(id = "")
    private WebElement eleAuditorAssignee;
    public WebElement getEleAuditorAssignee() { return eleAuditorAssignee; }

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
    private List<WebElement> eleCellEngagements;
    public List<WebElement> getEleCellEngagements() { return eleCellEngagements; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellAuditFirms;
    public List<WebElement> getEleCellAuditFirms(){ return eleCellAuditFirms; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellStatuses;
    public List<WebElement> getEleCellStatuses() { return  eleCellStatuses; }

    @FindBys(@FindBy(css = ""))
    private List<WebElement> eleCellAuditorAssignees;
    public List<WebElement> getEleCellAuditorAssignees() { return eleCellAuditorAssignees; }

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

    public ClientEngagementReviewPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /*@Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }*/


    /**
     * Sort Engagement by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementName(boolean isAsc){
        NXGReports.addStep("Sort engagement name in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        sortAlphabetOfListElement(eleCellEngagements, isAsc);
    }

    /**
     * Sort Audit Firm
     * @param isAsc
     */
    public void sortAuditFirm(boolean isAsc){
        NXGReports.addStep("Sort Audit Firm in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        sortAlphabetOfListElement(eleCellAuditFirms, isAsc);
    }

    /**
     * Sort Status engagement by ASC or DESC
     * @param isAsc
     */
    public void sortEngagementStatus(boolean isAsc){
        NXGReports.addStep("Sort engagement status by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        List<EngagementStatus> lst = new ArrayList<>();
        for (WebElement ele : eleCellStatuses){
            EngagementStatus status = EngagementStatus.valueOf(ele.getText());
            lst.add(status);
        }
        checkSortEngagementStatusOfList(lst, isAsc);

        //check sort type alpha for Engagement Name columns if there are many the same status
        int start = 0, end = 0;
        for (int i = 0; i < eleCellStatuses.size(); i++) {
            for (int j = i + 1; j < eleCellStatuses.size(); j++){
                if(eleCellStatuses.get(i).getText().equals(eleCellStatuses.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;

                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellEngagements.subList(start, end));
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
        sortAlphabetOfListElement(eleCellAuditorAssignees, isAsc);
    }


    /**
     * Sort client assignee by ASC or DESC
     * @param isAsc
     */
    public void sortClientAssignee(boolean isAsc){
        NXGReports.addStep("Sort client assignee in column by " + (isAsc == true ? "ascending": "descending"), LogAs.PASSED, null );
        sortAlphabetOfListElement(eleCellClientAssignees, isAsc);
    }

    /**
     * Sort client completed docs
     * @param isAsc
     */
    public void sortClientCompletedDocs(boolean isAsc){
        List<Double> lst = new ArrayList<>();
        for (WebElement ele : eleCellCompleteDoses){
            double value = Double.parseDouble(ele.getText());
            lst.add(value);
        }

        checkSortNumberOfList(lst, isAsc);


        //check sort type alpha for Engagement Name columns if there are many the same Completed Docs
        int start = 0, end = 0;
        for (int i = 0; i < eleCellCompleteDoses.size(); i++) {
            for (int j = i + 1; j < eleCellCompleteDoses.size(); j++){
                if(eleCellCompleteDoses.get(i).getText().equals(eleCellCompleteDoses.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;
                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellEngagements.subList(start, end));
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

        //check sort type alpha for Engagement Name columns if there are many the same Last Activity
        int start = 0, end = 0;
        for (int i = 0; i < eleCellLastActivities.size(); i++) {
            for (int j = i + 1; j < eleCellLastActivities.size(); j++){
                if(eleCellLastActivities.get(i).getText().equals(eleCellLastActivities.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;
                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellEngagements.subList(start, end));
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

        //check sort type alpha for Engagement Name columns if there are many the same Last Activity
        int start = 0, end = 0;
        for (int i = 0; i < eleCellDueDates.size(); i++) {
            for (int j = i + 1; j < eleCellDueDates.size(); j++){
                if(eleCellDueDates.get(i).getText().equals(eleCellDueDates.get(j).getText())){
                    start = i;
                    end = j;
                }else{
                    i++;
                    if(start != 0 && end != 0 && start != end){
                        List<WebElement> elements = new ArrayList<WebElement>(eleCellEngagements.subList(start, end));
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
    public void search(String keySearch){
        this.eleSearch.sendKeys(keySearch);

        this.eleSearch.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Checking for result
        for (int i = 0; i < this.eleCellEngagements.size(); i++){
            WebElement ele = eleCellEngagements.get(i);
            if(!ele.getText().toLowerCase().contains(keySearch.toLowerCase()) ||
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
