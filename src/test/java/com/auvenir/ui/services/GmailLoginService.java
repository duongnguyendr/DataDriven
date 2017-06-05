package com.auvenir.ui.services;

import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

//import org.testng.log4testng.Logger;

public class GmailLoginService extends AbstractService {
    Logger logger = Logger.getLogger(GmailLoginService.class);
    GmailPage gmailLoginPo = null;
    public GmailLoginService(Logger logger, WebDriver driver) {
        super(logger, driver);
        gmailLoginPo = new GmailPage(getLogger(), getDriver());
    }
    public void gmailLogin() throws Exception {
        try {
            gmailLoginPo = new GmailPage(getLogger(), getDriver());
            getDriver().get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
            if (gmailLoginPo.getEleEmailIDTxtFld().isDisplayed()) {
                gmailLoginPo.getEleEmailIDTxtFld()
                        .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"));
                gmailLoginPo.getEleNextBtn().click();
            }
            Thread.sleep(5000);
            gmailLoginPo.getElePasswordTxtFld()
                    .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_PWD"));
            gmailLoginPo.getEleSignInBtn().click();
            Assert.assertTrue(gmailLoginPo.getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
            Thread.sleep(5000);
            gmailLoginPo.getEleSearchTxtFld()
                    .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_SEARCHMAIL"));
            gmailLoginPo.getEleSearchBtn().click();
            Thread.sleep(5000);
            gmailLoginPo.getEleInviteMailLnk().click();
        /*	try{
				gmailLoginPo.getEleShowTrimBtn().click();
			}catch(Exception e)
			{
				
			}*/
            gmailLoginPo.getEleStartBtn().click();
            gmailWindow = getDriver().getWindowHandle();
            for (String winHandle : getDriver().getWindowHandles()) {
                getDriver().switchTo().window(winHandle);
            }
        } catch (AssertionError e) {
            NXGReports.addStep("Page not Loaded", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void gmailLogout() throws Exception {
        Thread.sleep(10000);

        getDriver().close();
        getDriver().switchTo().window(gmailWindow);
        gmailLoginPo.getEleProfileIcn().click();
        gmailLoginPo.getEleSignOutBtn().click();
    }
    //////////////////
    public void openGmailIndexForgotPassword(String email, String password) throws InterruptedException {
        gmailLoginPo.goGMail();
        gmailLoginPo.openGmailIndexForgotPassword(email,password);
    }
}
