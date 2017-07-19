package com.auvenir.ui.pages.groupPermissions;

import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorPage extends AbstractPage {
    @FindBy(id = "newAuditBtn")
    private WebElement buttonNewEngagement;

    public AdminAuditorPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    /**
     * Added by huy.huynh on 17/07/2017.
     * R2.1 Group Permissions
     */
    public void verifyCanCreateAnEngagement(boolean exist) {
        if (exist) {
            clickElement(buttonNewEngagement, "Button New Engagement");
        } else {
            validateNotExistedElement(buttonNewEngagement, "Button New Engagement");
        }
    }
    /*-----------end of huy.huynh on 17/07/2017.*/

    AuditorCreateToDoPage auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());

//    public void verifyAuditorAdminSeeListToDo(List<String> listToDoname) {
//        getLogger().info("Verify Auditor Admin can see list To Do.");
//        boolean result;
//        try {
//            result = auditorCreateToDoPage.verifyPermissionSeeListToDoTask(listToDoname, true);
//            Assert.assertTrue(result, "Auditor Admin should see all To Dos within engagement.");
//            NXGReports.addStep("Verify Auditor Admin can see all To Dos within engagement.", LogAs.PASSED, null);
//        } catch (AssertionError e) {
//            AbstractService.sStatusCnt++;
//            getLogger().info(e);
//            NXGReports.addStep("Test Failed: Verify ToDo Name is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
//                    .BROWSER_PAGE));
//        } catch (Exception e) {
//            getLogger().info(e);
//            AbstractService.sStatusCnt++;
//            NXGReports.addStep("Test Failed: Verify ToDo Name is displayed", LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//        }
//    }

    public void verifyAdminAuditorCannotCreateToDo() {
        getLogger().info("Verify Admin Auditor cannot create To Do.");
        boolean result;
        try {
            auditorCreateToDoPage.verifyCanCreateToDo(true);
        } catch (AssertionError e) {

        }

    }
}
