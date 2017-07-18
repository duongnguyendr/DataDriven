package com.auvenir.rests.api.services;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

//import org.testng.log4testng.Logger;

/*
    This service for API Rest Assert
	Created by: DoaiTran
	Copy from AbstractService => Clear: Initialize browser.
 */
public class AbstractAPIService {
    private Logger logger = Logger.getLogger(AbstractService.class);
    private WebDriver driver;
    public static int sStatusCnt = 0;
    String localPropertiesDest = GenericService.sDirPath + "/local.properties";
    protected String testData = System.getProperty("user.dir") + "\\" + GenericService.getConfigValue(localPropertiesDest, "DATA_FILE");
    /*
    Refactor to implement parameter on maven: serverDomainName
    Updated by: Doai.Tran on 8/5/2017
     */
    public String baseUrl="ariel.auvenir.com";
    public void setBaseUrl(String serverDomainName){
        baseUrl=serverDomainName;

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
    public void setDataBaseSer(String serverDataBase){
        dataBaseServer= serverDataBase;
        getLogger().info("DataBase server: " + dataBaseServer);
    }
    public String getDataBaseSer(){
        setDataBaseSer(System.getProperty("serverDataBase"));
        return dataBaseServer;
    }
    /*
    Refactor to implement parameter on maven: database
    Updated by: Doai.Tran on 19/5/2017
     */
    public String dataBase ="finicity";
    public void setDataBase(String sDataBase){
        dataBase= sDataBase;
        getLogger().info("DataBase: " + dataBase);
    }
    public String getDataBase(){
        setDataBase(System.getProperty("dataBase"));
        return dataBase;
    }
    /*
    Refactor to implement parameter on maven: port
    Updated by: Doai.Tran on 18/5/2017
     */
    public int port= 27017;
    public void setPort(String portNo){
        port= Integer.parseInt(portNo);
        getLogger().info("Connection Port: " + port);
    }
    public int getPort(){
        setPort(System.getProperty("portNo"));
        return port;
    }
    /*
    Refactor to implement parameter on maven: userNameDB
    Updated by: Doai.Tran on 18/5/2017
     */
    public void setUserName(String userNameDB){
        userName= userNameDB;
        getLogger().info("UserName: " + userName);
    }
    public String getUserName(){
        setUserName(System.getProperty("userNameDB"));
        return userName;
    }
    public  String userName ="auvqadb";
    /*
    Refactor to implement parameter on maven: PasswordDB
    Updated by: Doai.Tran on 18/5/2017
     */
    public void setPassword(String PasswordDB){
        password= PasswordDB;
        getLogger().info("Password: " + password);
    }
    public String getPassword(){
        setPassword(System.getProperty("PasswordDB"));
        return password;
    }
    public  String password ="rE7IrgSfjnSjP9Pr08MQNhcXpezZp3d7SzfWreRVhW1zpU6f4gHnca0CNOLH9wvKewslvb5mfXDd3vsds76UhQ==";
    public void setSSL(String SSL){
        ssl= SSL;
        getLogger().info("SSL: " + ssl);
    }
    public String getSSL(){
        setSSL(System.getProperty("SSL"));
        return ssl;
    }
    public  String ssl ="No";
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

    @Parameters({"browser", "version", "os"})
    @BeforeMethod
    public void setUp(Method method, String browser, String version, String os) {
        getLogger().info("Before Method.");
        getBaseUrl();
        getDataBaseSer();
        getDataBase();
        getPort();
        getUserName();
        getPassword();
        getSSL();
    }
    @BeforeSuite
    public void setConfig() {
        getToEmail();
        getCcEmail();
        GenericService.sToEmail = toEmail;
        GenericService.sCcEmail = ccEmail;
        GenericService.sConfigFile = GenericService.sDirPath + "/local.properties";
        testData = System.getProperty("user.dir") + "\\" + GenericService.getConfigValue(GenericService.sConfigFile, "DATA_FILE");

    }
    private String toEmail = "";
    private String ccEmail = "";
    public String   getToEmail(){
        setToEmail(System.getProperty("toEmail"));
        return toEmail;
    }
    public void setToEmail(String tosEmail){
        toEmail = tosEmail;
        getLogger().info("Email that We will send report: " +tosEmail);
    }
    public String  getCcEmail(){
        setCcEmail(System.getProperty("ccEmail"));
        return ccEmail;
    }
    public void setCcEmail(String tocEmail){
        ccEmail = tocEmail;
        getLogger().info("cc Email that We will send report: " +tocEmail);
    }

	public Logger getLogger() {
        return logger;
    }

}
