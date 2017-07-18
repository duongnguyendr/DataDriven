package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.dataprovider.groupPermissions.AdminAuditorDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.groupPermissions.AdminAuditorService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorTest extends AbstractTest {
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AdminAuditorService adminAuditorService;

    @Test(priority = 1, enabled = true, description = "Verify admin auditor can create an engagement.",
            dataProvider = "verifyPermissionCreateAnEngagement", dataProviderClass = AdminAuditorDataProvider.class)
    public void verifyPermissionCreateAnEngagement(String userId, String userPassword, String possible) {
        getLogger().info("Verify admin auditor can create an engagement.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());

        userId = GenericService.sBrowserData + userId;

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(userId, userPassword);
            auditorEngagementService.verifyAuditorEngagementPage();

//            System.out.println("possible = " + possible);
//            System.out.println("Boolean.getBoolean(possible) = " + Boolean.getBoolean(possible));
//            System.out.println("Boolean.parseBoolean(possible) = " + Boolean.parseBoolean(possible));
//            System.out.println("Boolean.valueOf(possible) = " + Boolean.valueOf(possible));
            adminAuditorService.verifyCanCreateAnEngagement(Boolean.parseBoolean(possible));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin auditor can create an engagement.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin auditor can create an engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }
}
