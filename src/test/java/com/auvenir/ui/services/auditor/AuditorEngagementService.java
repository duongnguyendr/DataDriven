package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.AuditorNewEngagementPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorEngagementService extends AbstractService {

    AuditorEngagementPage auditorEngagementPage;
    AuditorNewEngagementPage auditorNewEngagementPage;

    /*
     * contructor
     */
    public AuditorEngagementService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        auditorNewEngagementPage = new AuditorNewEngagementPage(getLogger(), getDriver());

    }


    public void verifyAuditorFooter() {

        try {
            auditorEngagementPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorEngagementPage.verifyFooterOfHomepage();
            getLogger().info("verfify term of service link.");
            auditorEngagementPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorEngagementPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorEngagementPage.verifyCookieNotice();
            auditorEngagementPage.scrollPageUp();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void navigateToClientSettingsPage() {

        try {
            getLogger().info("navigate to client Settings page.");
            //auditorEngagementTeamPage.navigateToClientSettingsPage();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyAuditorEngagementPage() {
            getLogger().info("verify Auditor Engagement page.");
            auditorEngagementPage.verifyAuditorEngagementPage();
    }

    public void navigateToContactsTab() {
        try {
            getLogger().info("navigate to Contacts page.");
            auditorEngagementPage.navigateToContactsTab();
            NXGReports.addStep("navigate to Contacts page.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("navigate to Contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void navigateToSettingsPage() {
            getLogger().info("navigate to Auditor Settings page.");
            auditorEngagementPage.navigateToSettingsPage();
    }

    public void clickNewEnagementButton() {
        try {
            getLogger().info("click Add New engagement button.");
            auditorEngagementPage.clickNewEnagementButton();
            NXGReports.addStep("click Add New engagement button.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("click Add New engagement button.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /*public void viewEngagementDetailsPage(String engagementName) {
        try {
            getLogger().info("navigate to Engagement detail page.(Hard code)");
            final String companyName = "Company Auvenir";
            int index = auditorEngagementTeamPage.findEngagementName(engagementName);
            if(index == -1){
                createAndSelectNewEnagement(engagementName, "", companyName);
            }else auditorEngagementTeamPage.viewEngagementDetailsPage(engagementName);
            NXGReports.addStep("navigate to Engagement detail page.(Hard code)", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Engagement detail page.(Hard code)", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }*/

    public void viewEngagementDetailsPage(String engagementName) {
        try {
            getLogger().info("navigate to Engagement detail page.(Hard code)");
            final String companyName = "Company Auvenir";
            int index = auditorEngagementPage.findEngagementName(engagementName);
            if (index == -1) {
                createAndSelectNewEnagement(engagementName, "", companyName);
            } else auditorEngagementPage.viewEngagementDetailsPage(engagementName);
            auditorEngagementPage.waitForProgressOverlayIsClosed();
            NXGReports.addStep("navigate to Engagement detail page.(Hard code)", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("navigate to Engagement detail page.(Hard code)", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void viewEngagementDetailsPage(String engagementName, String deadlineDate, String endDate, String startDate) {
        try {
            getLogger().info("navigate to Engagement detail page.(Hard code)");
            final String companyName = "Company Auvenir";
            int index = auditorEngagementPage.findEngagementName(engagementName);
            if (index == -1) {
                createAndSelectNewEnagement(engagementName, "", companyName, deadlineDate, endDate, startDate);
            } else auditorEngagementPage.viewEngagementDetailsPage(engagementName);
            auditorEngagementPage.waitForProgressOverlayIsClosed();
            NXGReports.addStep("navigate to Engagement detail page.(Hard code)", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("navigate to Engagement detail page.(Hard code)", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void viewEngagementDetailsPage(String engagementTitle, String engagementName) {
        try {
            getLogger().info("navigate to Engagement detail page with name");
            auditorEngagementPage.enterEngagementDetailWithName(engagementTitle, engagementName);
            NXGReports.addStep("navigate to Engagement detail pagewith name", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("navigate to Engagement detail pagewith name", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Create New Engagement with the specific Name and Navigate to new engagement which is just created.
     * <p>
     * <p>
     * #History business changed:
     * R2: navigate after create engagement done:
     * <p>  old: create new engagement -> Submit -> engagement list page
     * <p>  new: create new engagement -> Submit -> this engagement detail page
     *
     * @param engagementName The name of engagement
     * @param engagementType The type of engagement
     * @param company        The company of engagement
     */
    public void createAndSelectNewEnagement(String engagementName, String engagementType, String company) throws Exception {
        getLogger().info("Create And Select New Enagement.");
        auditorEngagementPage.clickNewEnagementButton();
        auditorNewEngagementPage.verifyNewEngagementPage();
        auditorNewEngagementPage.enterDataForNewEngagementPage(engagementName, engagementType, company);
        // R2: Change bussiness rule, need to mark a commment this line.
//        auditorEngagementTeamPage.clickEngagementByPosition(auditorEngagementTeamPage.findEngagementName(engagementName));
    }
    public void clickEngagementMenuLink() throws Exception {
        getLogger().info("Click Engagement Menu Link.");
        auditorNewEngagementPage.clickEngagementMenuLink();
    }

    public void createAndSelectNewEnagement(String engagementName, String engagementType, String company, String deadlineDate, String endDate, String startDate) throws Exception {
        getLogger().info("Create And Select New Enagement.");
        auditorEngagementPage.clickNewEnagementButton();
        auditorNewEngagementPage.verifyNewEngagementPage();
        auditorNewEngagementPage.enterDataForNewEngagementPage(engagementName, engagementType, company, deadlineDate,endDate,startDate);
        // R2: Change bussiness rule, need to mark a commment this line.
//        auditorEngagementTeamPage.clickEngagementByPosition(auditorEngagementTeamPage.findEngagementName(engagementName));
    }


    public void verifyAuditorPageHeaderContent() {
        try {
            getLogger().info("Verify content header auditor engagement page.");
            auditorEngagementPage.auditorPageHeaderContent();
            NXGReports.addStep("verify content header auditor engagement page.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify content header auditor engagement pag.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyUIListEngagement() {
        auditorEngagementPage.verifyUIListEngagementHeader();
        auditorEngagementPage.verifyUIListEngagementBody();
        auditorEngagementPage.verifyUIListEngagementFooter();
    }

    public void sendKeyCompanyName(String companyName) throws InterruptedException {
        auditorEngagementPage.sendKeyCompanyName(companyName);
    }

    public void verifySearchCompanyName(String companyName) throws InterruptedException {
        auditorEngagementPage.verifyCompanyName(companyName);
    }

    public void sendKeyEngagementName(String engagmentName) throws InterruptedException {
        auditorEngagementPage.sendKeyEngagementName(engagmentName);
    }

    public void verifySearchEngagementName(String engagmentName) throws InterruptedException {
        auditorEngagementPage.verifyEngagementName(engagmentName);
    }

    public void verifySortCompanyNameAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortCompanyName(isAsc);
    }

    public void verifySortCompanyNameDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortCompanyName(isAsc);
    }

    public void verifySortEngagementNameAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementName(isAsc);
    }

    public void verifySortEngagementNameDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementName(isAsc);
    }

    public void verifySortEngagementStatusAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementStatus(isAsc);
    }

    public void verifySortEngagementStatusDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementStatus(isAsc);
    }

    public void verifySortEngagementAssigneeAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementAssignee(isAsc);
    }

    public void verifySortEngagementAssigneeDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementAssignee(isAsc);
    }

    public void verifySortEngagementCompleteToDosAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementCompleteToDos(isAsc);
    }

    public void verifySortEngagementCompleteToDosDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementCompleteToDos(isAsc);
    }

    public void verifySortEngagementClientAssigneeAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementClientAssignee(isAsc);
    }

    public void verifySortEngagementClientAssigneeDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementClientAssignee(isAsc);
    }

    public void verifySortEngagementCompleteDocsAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementCompletedDocs(isAsc);
    }

    public void verifySortEngagementCompleteDocsDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementCompletedDocs(isAsc);
    }

    public void verifySortEngagementLastActivityAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementLastActivity(isAsc);
    }

    public void verifySortEngagementLastActivityDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementLastActivity(isAsc);
    }

    public void verifySortEngagementDueDateAscending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementDueDate(isAsc);
    }

    public void verifySortEngagementDueDateDescending(boolean isAsc) throws InterruptedException {
        auditorEngagementPage.sortEngagementDueDate(isAsc);
    }

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/21 - Start
     *
     **/

    /**
     * Verify engagement status does not change when click on close icon popup
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementStatusWhenClickOnCloseIconPopup(String engagementName) {
        auditorEngagementPage.verifyEngagementStatusDoesNotChange(true, engagementName);
    }

    /**
     * Verify engagement ToDo does not change when click on close icon popup
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementToDoWhenClickOnCloseIconPopup(String engagementName) {
        auditorEngagementPage.verifyEngagementToDoDoesNotChange(true, engagementName);
    }

    /**
     * Verify engagement status does not change when click on close icon popup
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementStatusWhenClickOnCancelButtonPopup(String engagementname) {
        auditorEngagementPage.verifyEngagementStatusDoesNotChange(false, engagementname);
    }

    /**
     * Verify engagement ToDo does not change when click on close icon popup
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementToDoWhenClickOnCancelButtonPopup(String engagementname) {
        auditorEngagementPage.verifyEngagementToDoDoesNotChange(false, engagementname);
    }

    /**
     * Verify engagement status change when click on archive button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementStatusWhenClickOnArchiveButtonPopup(String engagementname) {
        auditorEngagementPage.verifyEngagementStatusChange(engagementname);
    }

    /**
     * Verify engagement ToDo change when click on archive button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementToDoWhenClickOnArchiveButtonPopup(String engagementname) {
        auditorEngagementPage.verifyEngagementToDoChange(engagementname);
    }

    /**
     * Get engagement status and ToDo before
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void getEngagementStatusAndToDoBefor(String engagementName) {
        auditorEngagementPage.getEngagementStatusAndToDoBefor(engagementName);
    }
    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/21 - Start
     *
     **/

    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - Start
     *
     **/
    /**
     * Verify engagement status complete
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void verifyEngagementStatusIsComplete(String engagementName) {
        auditorEngagementPage.verifyEngagementStatusIsComplete(engagementName);
    }

    /**
     * Verify engagement ToDo complete
     *
     * @author : TanPham
     * @date : 2017/06/21
     */

    public void verifyEngagementToDoIsComplete(String engagementName) {
        auditorEngagementPage.verifyEngagementToDoIsComplete(engagementName);
    }

    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - End
     **/
    public void verifyEngagementExisted(String engagementName) {
        try {
            int index = auditorEngagementPage.findEngagementName(engagementName);
            if (index != -1) {
                NXGReports.addStep("Verify engagement: " + engagementName + " exists.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Verify engagement: " + engagementName + " exists.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify engagement: " + engagementName + " exists.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}

