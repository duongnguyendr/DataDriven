package com.auvenir.ui.services;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by hungcuong1105 on 4/15/2017.
 */
public class SmokeTestService extends AbstractService {
    AdminLoginPage adminLoginPage;
    AuvenirPage auvenirPage;

    public SmokeTestService(Logger logger, WebDriver driver) {
        super(logger, driver);
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
    }
}
