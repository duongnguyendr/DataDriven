package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.dataprovider.admin.AdminDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminAccountSettingsService;
import com.auvenir.ui.services.admin.AdminService;
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
public class AdminAuditorTest extends AbstractTest{
        AdminService adminService;
        AdminAccountSettingsService adminAccountSettingsService;
        MarketingService marketingService;

        @Test(priority = 1, enabled = true, description = "To Verify Permission Admin Auditor see all to-dos")
        public void verifyPermissionAdminAuditorSeeToDo() {
            adminService = new AdminService(getLogger(), getDriver());
            marketingService = new MarketingService(getLogger(), getDriver());
            adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

            String auditorAdminId = GenericService.addBrowserPrefix("");


            try {
//                marketingService.loginWithUserRolesUsingUsernamePassword(superAdminId, superAdminPwd);
                adminService.verifyHeaderAdminPage();
                adminService.verifyAdminSeeAllUser();
                adminService.verifyOnlyOneSuperAdmin();

                Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
                NXGReports.addStep("Verify the GUI of Super Admin Home Page.", LogAs.PASSED, null);
            } catch (Exception e) {
                NXGReports.addStep("Verify the GUI of Super Admin Home Page: FAILED", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                throw e;
            }
        }
}
