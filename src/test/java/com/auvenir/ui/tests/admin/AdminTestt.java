package com.auvenir.ui.tests.admin;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.services.AdminServicee;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Created by huy.huynh on 24/05/2017.
 */
public class AdminTestt extends AbstractTest {
    AdminServicee adminServicee;
    AuvenirPage auvenirPage;

    String adminId;
    String timeStamp;
    String firstEngagementTitleOnWeb;
    Actions actions;

    private void initVariable() {
        adminServicee = new AdminServicee(getLogger(), getDriver());

        adminId = GenericService.getCongigValue(GenericService.sConfigFile, "ADMIN_ID");
        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        actions = new Actions(getDriver());
    }

    private void navigationPreconditions() {
        adminServicee.loginWithUserRole(adminId);
    }

    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Admin Home Page")
    public void verifyAdminHomePage() {
        initVariable();
        navigationPreconditions();

        //adminServicee.verifyHeader();
        adminServicee.verifyBody();

        getLogger().info("Scroll down to see page footer.");
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        adminServicee.verifyFooter();
        adminServicee.viewCredentials();
    }
}
