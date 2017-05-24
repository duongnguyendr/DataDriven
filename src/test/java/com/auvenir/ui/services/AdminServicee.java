package com.auvenir.ui.services;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 24/05/2017.
 */
public class AdminServicee extends AbstractService {
    AdminLoginPage adminLoginPage;
    AuvenirPage auvenirPage;

    public AdminServicee(Logger logger, WebDriver driver) {
        super(logger, driver);
        adminLoginPage = new AdminLoginPage(logger, driver);
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
    }

    public void verifyHeader() {
        getLogger().info("Verify Admin logged in header.");
        auvenirPage.verifyHeader();
        adminLoginPage.verifyAdminHeaderText();
    }

    public void verifyBody() {
        getLogger().info("Verify Admin logged in body.");
        adminLoginPage.verifyAdminDashBoard();
        adminLoginPage.verifyUserTable();
    }

    public void verifyFooter() {
        getLogger().info("Verify page footer.");
        auvenirPage.verifyFooter();
    }

    public void viewCredentials(){
        adminLoginPage.viewCredentials();
    }
}
