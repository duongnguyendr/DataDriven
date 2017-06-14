package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.pages.marketing.engagement.AuditorEngagementReviewPO;
import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 5/8/2017.
 */
public class AuditorEngagementReviewTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEditCategoryService auditorEditCategoryService;
    private AuditorEngagementReviewPO auditorEngagementReviewPO =  null;
    String auditorId;
    String timeStamp;
    String firstEngagementTitleOnWeb;

    @Test(priority = 1, description = "Search engagement by company, engagement name")
    public void searchEngagementByCompanyAndNameTest() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());

        try
        {
            String engagementNameUnix = "enga" + GeneralUtilities.randomNumber();
            String companyNameUnix = "comau" + GeneralUtilities.randomNumber();
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User4", "Auditor");
            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createNewEnagement(engagementNameUnix, "engagement type", companyNameUnix);
            auditorEngagementService.verifySearchEngagementName(companyNameUnix, engagementNameUnix);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify to search engagement by company, engagement name.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to search engagement by company, engagement name.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 2, description = "Sort Company name by ascending")
    public void sortAscendingCompanyNameTest(){
        auditorEngagementReviewPO.sortCompanyName(true);
    }

    @Test(priority = 3, description = "Sort Company name by descending")
    public void sortDescendingCompanyNameTest(){
        auditorEngagementReviewPO.sortCompanyName(false);
    }

    @Test(priority = 4, description = "Sort Engagement name by ascending")
    public void sortAscendingEngagementNameTest(){
        auditorEngagementReviewPO.sortEngagementName(true);
    }

    @Test(priority = 5, description = "Sort Engagement Name by descending")
    public void sortDescendingEngagementNameTest(){
        auditorEngagementReviewPO.sortEngagementName(false);
    }

    @Test(priority = 6, description = "Sort Engagement Status by ascending")
    public void sortAscendingEngagementStatusTest(){
        auditorEngagementReviewPO.sortEngagementStatus(true);
    }

    @Test(priority = 7, description = "Sort Engagement Status by descending")
    public void sortDescendingEngagementStatusTest(){
        auditorEngagementReviewPO.sortEngagementStatus(false);
    }

    @Test(priority = 8, description = "Sort Auditor Assignee by ascending")
    public void sortAscendingAuditorAssigneeTest(){
        auditorEngagementReviewPO.sortAuditorAssignee(true);
    }

    @Test(priority = 9, description = "Sort Auditor Assignee by descending")
    public void sortDescendingAuditorAssigneeTest(){
        auditorEngagementReviewPO.sortAuditorAssignee(false);
    }

    @Test(priority = 10, description = "Sort Completed To Docs by ascending")
    public void sortAscendingCompletedToDocsTest(){
        auditorEngagementReviewPO.sortCompletedToDos(true);
    }

    @Test(priority = 11, description = "Sort Completed To Docs by descending")
    public void sortDescendingCompletedToDocsTest(){
        auditorEngagementReviewPO.sortCompletedToDos(false);
    }

    @Test(priority = 12, description = "Sort Cliend Assignee by ascending")
    public void sortAscendingClientAssigneeTest(){
        auditorEngagementReviewPO.sortClientAssignee(true);
    }

    @Test(priority = 13, description = "Sort Cliend Assignee by descending")
    public void sortDescendingAssigneeTest(){
        auditorEngagementReviewPO.sortClientAssignee(false);
    }

    @Test(priority = 14, description = "Sort Completed Docs by ascending")
    public void sortAscendingCompletedDocsTest(){
        auditorEngagementReviewPO.sortClientCompletedDocs(true);
    }

    @Test(priority = 15, description = "Sort Completed Docs by descending")
    public void sortDescendingCompletedDocsTest(){
        auditorEngagementReviewPO.sortClientCompletedDocs(false);
    }

    @Test(priority = 16, description = "Sort Last Activity by ascending")
    public void sortAscendingLastActivityTest(){
        auditorEngagementReviewPO.sortLastActivity(true);
    }

    @Test(priority = 17, description = "Sort Last Activity by descending")
    public void sortDescendingLastActivityTest(){
        auditorEngagementReviewPO.sortLastActivity(false);
    }

    @Test(priority = 18, description = "Sort Due Date by ascending")
    public void sortAscendingDueDateTest(){
        auditorEngagementReviewPO.sortDueDate(true);
    }

    @Test(priority = 19, description = "Sort Due Date by descending")
    public void sortDescendingDueDateTest(){
        auditorEngagementReviewPO.sortDueDate(false);
    }
}
