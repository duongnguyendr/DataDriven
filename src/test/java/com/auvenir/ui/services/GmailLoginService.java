package com.auvenir.ui.services;

import java.util.concurrent.TimeUnit;

import com.auvenir.utilities.GenericService;
import com.auvenir.ui.pages.common.GmailPage;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class GmailLoginService extends AbstractRefactorService {
    Logger logger = Logger.getLogger(GmailLoginService.class);
    GmailPage gmailLoginPo = null;

    public void gmailLogin() throws Exception {
        try {
            gmailLoginPo = new GmailPage(getLogger(), getDriver());
            getDriver().get(GenericService.getCongigValue(GenericService.sConfigFile, "GMAIL_URL"));
            getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
            if (gmailLoginPo.getEleEmailIDTxtFld().isDisplayed()) {
                gmailLoginPo.getEleEmailIDTxtFld()
                        .sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"));
                gmailLoginPo.getEleNextBtn().click();
            }
            Thread.sleep(5000);
            gmailLoginPo.getElePasswordTxtFld()
                    .sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "CLIENT_PWD"));
            gmailLoginPo.getEleSignInBtn().click();
            Assert.assertTrue(gmailLoginPo.getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
            Thread.sleep(5000);
            gmailLoginPo.getEleSearchTxtFld()
                    .sendKeys(GenericService.getCongigValue(GenericService.sConfigFile, "GMAIL_SEARCHMAIL"));
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
}
