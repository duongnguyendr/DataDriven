package com.auvenir.ui.tests.admin;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminAccountSettingsService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
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

    private String superAdminId, adminId, auditorId, clientId;
    private String superAdminPassword, adminPassword, auditorPassword, clientPassword;

    public enum UserStatus {
        ONBOARDING("Onboarding"),
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        LOCKED("Locked"),
        WAITLISTED("Wait Listed"),
        PENDING("Pending");

        private String value;

        private UserStatus(String value) {
            this.value = value;
        }
    }

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
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, waitListedStatus);
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

    @Test(priority = 4, enabled = true, description = "Verify flow SuperAdmin change status of Admin.", testName = "sa_25, 26, 27")
    public void verifySuperAdminChangeStatusAdmin() {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        superAdminId = GenericService.getTestDataFromExcel("SuperAdminTest", "Super Admin Email", "Valid Value");
        superAdminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Password", "Valid Value");
        adminId = GenericService.getTestDataFromExcel("SuperAdminTest", "Normal Admin Email", "Valid Value");

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(superAdminId, superAdminPassword);
            adminService.scrollToUser(adminId);

            adminService.changeTheStatusUser(auditorId, UserStatus.INACTIVE.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.INACTIVE.value);

            adminService.changeTheStatusUser(auditorId, UserStatus.LOCKED.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.LOCKED.value);

            adminService.changeTheStatusUser(auditorId, UserStatus.ONBOARDING.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.ONBOARDING.value);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify flow SuperAdmin change status of Admin.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify flow SuperAdmin change status of Admin.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify flow SuperAdmin change status of Auditor.", testName = "sa_28, 29, 30, 31")
    public void verifySuperAdminChangeStatusAuditor() {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        superAdminId = GenericService.getTestDataFromExcel("SuperAdminTest", "Super Admin Email", "Valid Value");
        superAdminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Password", "Valid Value");
        auditorId = GenericService.getTestDataFromExcel("SuperAdminTest", "Auditor", "Valid Value");

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(superAdminId, superAdminPassword);
            adminService.scrollToUser(auditorId);

            adminService.changeTheStatusUser(auditorId, UserStatus.INACTIVE.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.INACTIVE.value);

            adminService.changeTheStatusUser(auditorId, UserStatus.LOCKED.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.LOCKED.value);

            adminService.changeTheStatusUser(auditorId, UserStatus.ACTIVE.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.ACTIVE.value);

            adminService.changeTheStatusUser(auditorId, UserStatus.ONBOARDING.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.ONBOARDING.value);

            adminService.changeTheStatusUser(auditorId, UserStatus.WAITLISTED.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.WAITLISTED.value);

            adminService.changeTheStatusUser(auditorId, UserStatus.ONBOARDING.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, UserStatus.ONBOARDING.value);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify flow SuperAdmin change status of Auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify flow SuperAdmin change status of Auditor.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify flow SuperAdmin change status of Client.", testName = "sa_32,33,34,35")
    public void verifySuperAdminChangeStatusClient() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        superAdminId = GenericService.getTestDataFromExcel("SuperAdminTest", "Super Admin Email", "Valid Value");
        superAdminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SuperAdminTest", "Super Admin Password", "Valid Value");
        clientId = GenericService.getTestDataFromExcel("SuperAdminTest", "Client", "Valid Value");

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(superAdminId, superAdminPassword);
            adminService.scrollToUser(clientId);

            System.out.println("clientId = " + clientId);
            adminService.changeTheStatusUser(clientId, UserStatus.INACTIVE.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, UserStatus.INACTIVE.value);

            adminService.changeTheStatusUser(clientId, UserStatus.LOCKED.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, UserStatus.LOCKED.value);

            MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), clientId, "status", UserStatus.ACTIVE.toString());
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, UserStatus.ACTIVE.value);

            adminService.changeTheStatusUser(clientId, UserStatus.ONBOARDING.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, UserStatus.ONBOARDING.value);

            adminService.changeTheStatusUser(clientId, UserStatus.WAITLISTED.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, UserStatus.WAITLISTED.value);

            adminService.changeTheStatusUser(clientId, UserStatus.ONBOARDING.value);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, UserStatus.ONBOARDING.value);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify flow SuperAdmin change status of Client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify flow SuperAdmin change status of Client.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}

