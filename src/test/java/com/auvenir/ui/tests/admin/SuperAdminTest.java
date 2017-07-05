package com.auvenir.ui.tests.admin;

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
 * Created by thuan.duong on 7/5/2017.
 */
public class SuperAdminTest extends AbstractTest {
    AdminService adminService;
    AdminAccountSettingsService adminAccountSettingsService;
    MarketingService marketingService;

    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Admin Home Page")
    public void verifyGUINormalAdminHomePage() {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        String normalAdminId = GenericService.getTestDataFromExcel("SuperAdminTest", "Normal Admin Email", "Valid Value");
        String normalAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Password", "Valid Value");
        String normalAdminFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Name", "Valid Value");
        String normalAdminPhoneNum = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Normal Admin Phone", "Valid Value");
        String clientEmail = GenericService.getTestDataFromExcel("SuperAdminTest", "Client Email", "Valid Value");
        String auditorEmail = GenericService.getTestDataFromExcel("SuperAdminTest", "Auditor Email", "Valid Value");
        String onboardingStatus = "Onboarding";
        String waitListedStatus = "Wait Listed";
        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(normalAdminId, normalAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyAdminSeeAllUser();
            adminService.changeTheStatusUser(clientEmail, onboardingStatus);
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, onboardingStatus);
            adminService.changeTheStatusUser(clientEmail, waitListedStatus);
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, waitListedStatus);
            adminService.changeTheStatusUser(auditorEmail, onboardingStatus);
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, onboardingStatus);
            adminService.changeTheStatusUser(auditorEmail, waitListedStatus);
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail,  waitListedStatus);
            adminService.verifyNormalAdminCannotChangeSttUser();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyPersonalInfoRendered(normalAdminFullName, normalAdminId, normalAdminPhoneNum);
            adminAccountSettingsService.inputFullNameAdminSettingPage(normalAdminFullName + "s");
            adminAccountSettingsService.clickUpdateBTN();
            marketingService.refreshHomePage();
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyPersonalInfoRendered(normalAdminFullName + "s", normalAdminId, normalAdminPhoneNum);
            adminAccountSettingsService.inputFullNameAdminSettingPage(normalAdminFullName);
            adminAccountSettingsService.clickUpdateBTN();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the display of Elements in Admin Home Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the display of Elements in Admin Home Page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
