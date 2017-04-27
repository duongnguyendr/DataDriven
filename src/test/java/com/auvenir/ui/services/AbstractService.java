package com.auvenir.ui.services;

import com.auvenir.utilities.GenericService;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class AbstractService  {
    private WebDriver driver;
    private Logger logger;
    private static final int waitTime = 60;
    public AbstractService(Logger logger,WebDriver driver){
        this.logger = logger;
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);
    }
    public WebDriver getDriver(){
        return driver;
    }
    public Logger getLogger(){
        return logger;
    }

    public void loginWithUserRole(String userId, String getTokenUrl, String checkTokenUrl) {
        getLogger().info("Login with user role: " + userId);
        driver.get(getTokenUrl + userId);
        String s1 = driver.findElement(By.xpath("//pre")).getText();
        String[] parts = s1.split("(\")");
        String token = parts[3];
        GenericService.setCongigValue(GenericService.sConfigFile, "LOGIN_URL", checkTokenUrl+ userId + "&token="+token);
        driver.get(checkTokenUrl + userId + "&token=" + token);
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(waitTime,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(waitTime,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


}
