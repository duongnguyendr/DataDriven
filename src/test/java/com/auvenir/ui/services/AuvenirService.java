package com.auvenir.ui.services;

import com.auvenir.ui.pages.AuvenirPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 24/05/2017.
 */
public class AuvenirService extends AbstractService {
    AuvenirPage auvenirPage;

    public AuvenirService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
    }
}
