package com.auvenir.rests.api.services;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.WebService;
import com.auvenir.ui.pages.common.GmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

/*
    This service for API Rest Assert
	Created by: DoaiTran
	Copy from AbstractService => Clear: Initialize browser.
 */
public class AbstractAPIService {
    private Logger logger = Logger.getLogger(AbstractService.class);
    private WebDriver driver;
    public static int sStatusCnt = 0;

    /*
    Refactor to implement parameter on maven: serverDomainName
    Updated by: Doai.Tran on 8/5/2017
     */
    public String baseUrl="ariel.auvenir.com";
    public void setBaseUrl(String serverDomainName){
        baseUrl="http://" + serverDomainName;
        getLogger().info("Url of testing server is: " + baseUrl);
    }
    public String getBaseUrl(){
        setBaseUrl(System.getProperty("serverDomainName"));
        return baseUrl;
    }
    /*
    Refactor to implement parameter on maven: serverDataBase
    Updated by: Doai.Tran on 9/5/2017
     */
    public String dataBaseServer="34.205.90.145";
    public void setDataBase(String serverDataBase){
        dataBaseServer= serverDataBase;
        getLogger().info("DataBase server: " + dataBaseServer);
    }
    public String getDataBase(){
        setDataBase(System.getProperty("serverDataBase"));
        return dataBaseServer;
    }
    public  String database ="serviceFinicity";
    /**
    @param actual The actual value that you want to assert.
    @param expected The expected value that you want to assert.
     */
    public void assertionEquals(String actual, String expected) {
        try {
            logger.info("Verify value of response: " + expected);

            Assert.assertEquals(actual, expected);
            NXGReports.addStep("Verify Value of response: " + expected, LogAs.PASSED, null);


        } catch (AssertionError error) {
            logger.info("Value of element: " + expected + "is not rendered.");
            NXGReports.addStep("Verify Value of response: " + expected, LogAs.FAILED, null);

        }
    }

    @Parameters({"server"})
    @BeforeSuite
    public void setConfig(String server) {
        if (server.equalsIgnoreCase("cadet")) {
            GenericService.sConfigFile = GenericService.sDirPath + "/cadet.properties";
        } else if (server.equalsIgnoreCase("local")) {
            GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
        } else if (server.equalsIgnoreCase("finicity")) {
            GenericService.sConfigFile = GenericService.sDirPath + "/finicity.properties";
        }else
            GenericService.sConfigFile = GenericService.sDirPath + "/ariel.properties";
        }

	public Logger getLogger() {
        return logger;
    }

}
