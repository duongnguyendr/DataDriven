package com.auvenir.ui.pages.marketing.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import com.google.common.collect.Ordering;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by toan.nguyenp on 4/25/2017.
 */
public class BaseEngagementPO extends AbstractPage {

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

    public BaseEngagementPO(WebDriver driver) {
        super(driver);
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
    public void sortAlphabetOfListElement(List<WebElement> elements, boolean isAsc){
        try{
            String[] actualArrays = new String[elements.size()];
            for(int i = 0; i < elements.size(); i++){
                actualArrays[i] = elements.get(i).getText();
            }

            String[] expectedArray = actualArrays;
            if(isAsc){
                Arrays.sort(expectedArray);
            }else{
                Arrays.sort(expectedArray, Collections.reverseOrder());
            }

            for (int i = 0; i < expectedArray.length; i++) {
                if(!expectedArray[i].equals(actualArrays[i])){
                    NXGReports.addStep("Sort by " + (isAsc == true ? "ascending" : "descending") + " fails at row " + (i + 1), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError("Sort by " + (isAsc == true ? "ascending" : "descending") + " fails at row " + (i + 1));
                }
            }
        }catch (Exception e){
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }
}
