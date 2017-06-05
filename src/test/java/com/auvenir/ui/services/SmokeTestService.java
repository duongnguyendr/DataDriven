package com.auvenir.ui.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by hungcuong1105 on 4/15/2017.
 */
public class SmokeTestService extends AbstractService {

    public SmokeTestService(Logger logger, WebDriver driver) {
        super(logger, driver);
    }
}
