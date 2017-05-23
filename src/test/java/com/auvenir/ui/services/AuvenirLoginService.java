package com.auvenir.ui.services;

import java.util.concurrent.TimeUnit;

import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.WebService;
import org.openqa.selenium.By;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;


public class AuvenirLoginService extends AbstractRefactorService {

    //Getting the URl by passing Dev Auth ID and Authentication key
    public void setURL(String sEMAILID, String sAUTHID, String sLOGINURL, String sDevAuthID, String sApiKey) throws Exception {
        try {
            WebService http = new WebService(getLogger());
            http.gettingUserID(sEMAILID, sAUTHID, sDevAuthID, sApiKey);
            http.gettingURL(sEMAILID, sLOGINURL, sDevAuthID, sApiKey);
            System.out.println(GenericService.getCongigValue(GenericService.sConfigFile, sLOGINURL));
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load Logged-In Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    //Getting the URL by passing GetTokenURl and CheckTokenURL
    public void loadURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL) {
        getDriver().get(sGetTokenURL + sEmailID);
        String s1 = getDriver().findElement(By.xpath("//pre")).getText();
        String[] parts = s1.split("(\")");
        String token = parts[3];
        getDriver().get(sCheckTokenURL + sEmailID + "&token=" + token);
    }

    //Loading the URL by keeping in config properties
    public void loadURL(String sUrl) {
        try {
            System.out.println(sUrl);
            getDriver().get(sUrl);
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


}
