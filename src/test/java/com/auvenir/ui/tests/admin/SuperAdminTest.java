package com.auvenir.ui.tests.admin;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by thuan.duong on 7/5/2017.
 */
public class SuperAdminTest extends AbstractTest {
    AdminService adminService;
    AdminAccountSettingsService adminAccountSettingsService;
    MarketingService marketingService;

    @Test(priority = 1, enabled = true, description = "To Verify the GUI of Normal Admin Home Page", dataProvider = "verifyGUISuperAdminHomePage", dataProviderClass = AdminDataProvider.class)
    public void verifyGUISuperAdminHomePage(String superAdminId,String superAdminPwd,String superAdminFullName,String superAdminPhoneNum,String normalAdminEmail,
                                            String clientEmail,String auditorEmail,String onboardingStatus,String waitListedStatus,String activeStatus,String inactiveStatus) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        superAdminId = GenericService.addBrowserPrefix(superAdminId);
        normalAdminEmail = GenericService.addBrowserPrefix(normalAdminEmail);
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(superAdminId, superAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyAdminSeeAllUser();
            adminService.verifyOnlyOneSuperAdmin();

            adminService.verifySuperAdminCanChangeSttAllUser();
            adminService.changeTheStatusUser(clientEmail, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, onboardingStatus);
            adminService.changeTheStatusUser(clientEmail, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, waitListedStatus);

            adminService.changeTheStatusUser(auditorEmail, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, onboardingStatus);
            adminService.changeTheStatusUser(auditorEmail, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, waitListedStatus);

            adminService.changeTheStatusUser(normalAdminEmail, inactiveStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(normalAdminEmail,  inactiveStatus);
            adminService.changeTheStatusUser(normalAdminEmail, activeStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(normalAdminEmail,  activeStatus);

            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyPersonalInfoRendered(superAdminFullName, superAdminId, superAdminPhoneNum);
            adminAccountSettingsService.inputFullNameAdminSettingPage(superAdminFullName + "s");
            adminAccountSettingsService.clickUpdateBTN();
            marketingService.refreshHomePage();
            adminService.verifyHeaderAdminPage();

            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyPersonalInfoRendered(superAdminFullName + "s", superAdminId, superAdminPhoneNum);
            adminAccountSettingsService.inputFullNameAdminSettingPage(superAdminFullName);
            adminAccountSettingsService.clickUpdateBTN();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the GUI of Super Admin Home Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the GUI of Super Admin Home Page: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "To Verify the GUI of Normal Admin Home Page", dataProvider = "verifyGUINormalAdminHomePage", dataProviderClass = AdminDataProvider.class)
    public void verifyGUINormalAdminHomePage(String normalAdminId, String normalAdminPwd, String normalAdminFullName, String normalAdminPhoneNum,
                                             String clientEmail, String auditorEmail, String onboardingStatus, String waitListedStatus) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        normalAdminId = GenericService.addBrowserPrefix(normalAdminId);
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(normalAdminId, normalAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyAdminSeeAllUser();
            adminService.verifyOnlyOneSuperAdmin();

            adminService.changeTheStatusUser(clientEmail, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, onboardingStatus);
            adminService.changeTheStatusUser(clientEmail, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, waitListedStatus);
            adminService.changeTheStatusUser(auditorEmail, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, onboardingStatus);
            adminService.changeTheStatusUser(auditorEmail, waitListedStatus);
            marketingService.refreshHomePage();
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
            NXGReports.addStep("Verify the GUI of Normal Admin Home Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the GUI of Normal Admin Home Page: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "To Verify Assign Super Admin Role", dataProvider = "verifyAssignSuperAdminRole", dataProviderClass = AdminDataProvider.class)
    public void verifyAssignSuperAdminRole(String superAdminId, String  superAdminPwd, String normalAdminId, String normalAdminPwd, String normalAdminFullName, String superAdminFullName) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        superAdminId = GenericService.addBrowserPrefix(superAdminId);
        normalAdminId = GenericService.addBrowserPrefix(normalAdminId);

        try {
            marketingService.loginWithUserRolesUsingUsernamePassword(superAdminId, superAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.demoteSuperAdminRole(superAdminId, normalAdminFullName, false);
            adminService.demoteSuperAdminRole(superAdminId, normalAdminFullName, true);
            // Will update if the business change. Future plan: The Super admin will logout after demote user.
            adminService.verifyNormalAdminCannotChangeSttUser();
            marketingService.logout();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(superAdminId, superAdminPwd);
            adminService.verifyUserRoleOfEmail(superAdminId, "ADMIN");

            marketingService.logout();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(normalAdminId, normalAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyUserRoleOfEmail(normalAdminId, "SUPER ADMIN");
            adminService.verifySuperAdminCanChangeSttAllUser();
            adminService.demoteSuperAdminRole(normalAdminId, superAdminFullName, true);
            adminService.verifyNormalAdminCannotChangeSttUser();

            marketingService.logout();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(superAdminId, superAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyUserRoleOfEmail(superAdminId, "SUPER ADMIN");
            adminService.verifySuperAdminCanChangeSttAllUser();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Assign Super Admin Role.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Assign Super Admin Role: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
