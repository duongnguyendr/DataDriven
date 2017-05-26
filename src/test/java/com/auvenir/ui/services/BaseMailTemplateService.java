package com.auvenir.ui.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class BaseMailTemplateService extends AbstractService {
    public BaseMailTemplateService(Logger logger, WebDriver driver) {
        super(logger, driver);
        //loginPage = new LoginPage(getLogger(),getDriver());
    }
}
