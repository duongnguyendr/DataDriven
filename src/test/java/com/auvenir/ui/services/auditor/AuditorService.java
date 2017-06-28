package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.EngagementRequestPage;
import com.auvenir.ui.pages.admin.AdminLoginPage;
import com.auvenir.ui.pages.auditor.*;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.WebService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by duong.nguyen on 5/24/2017.
 */
public class AuditorService extends AbstractService {
    AuvenirPage auvenirPage;
    AuditorOnBoardingPage auditorOnBoardingPage;
    AdminLoginPage adminLoginPage;
    AuditorDashboardPage auditorDashboardPage;
    EngagementRequestPage engagementRequestPage;
    EngagementFilesPage engagementFilesPage;
    AuditorEngagementPage auditorEngagementPage;
    AddNewClientPage addNewClientPage;
    AuditorClientPage auditorClientPage;
    AuditorSettingsPage auditorSettingsPage;

    /*
     * Constructor
     */
    public AuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        auditorOnBoardingPage = new AuditorOnBoardingPage(getLogger(), getDriver());
        adminLoginPage = new AdminLoginPage(getLogger(), getDriver());
        auditorDashboardPage = new AuditorDashboardPage(getLogger(), getDriver());
        engagementRequestPage = new EngagementRequestPage(getLogger(), getDriver());
        engagementFilesPage = new EngagementFilesPage(getLogger(), getDriver());
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        addNewClientPage = new AddNewClientPage(getLogger(), getDriver());
        auditorClientPage = new AuditorClientPage(getLogger(), getDriver());
        auditorSettingsPage = new AuditorSettingsPage(getLogger(), getDriver());
    }

    public void setURL(String sEMAILID, String sAUTHID, String sLOGINURL, String sDevAuthID, String sApiKey) throws Exception {
        try {
            WebService http = new WebService(getLogger());
            http.gettingUserID(sEMAILID, sAUTHID, sDevAuthID, sApiKey);
            http.gettingURL(sEMAILID, sLOGINURL, sDevAuthID, sApiKey);
            System.out.println(GenericService.getConfigValue(GenericService.sConfigFile, sLOGINURL));
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load Logged-In Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    //Getting the URL by passing GetTokenURl and CheckTokenURL
    public void navigateToURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL) {
        getDriver().get(sGetTokenURL + sEmailID);
        String s1 = getDriver().findElement(By.xpath("//pre")).getText();
        String[] parts = s1.split("(\")");
        String token = parts[3];
        getDriver().get(sCheckTokenURL + sEmailID + "&token=" + token);
    }

    //Loading the URL by keeping in config properties
    public void navigateToURL(String sUrl) {
        try {
            System.out.println(sUrl);
            getDriver().get(sUrl);
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public void verifyBodyHomePage() {
        auvenirPage.verifyBodyHomePage();
    }

    public void verifyFooterHomePage() {
        auvenirPage.verifyFooterOfHomepage();
    }

    public void verifyEmailLoginForm() {
        auvenirPage.verifyFormLogin();
    }

    public void verifyLoginWithEmail(String email) {
        auvenirPage.verifyLoginWithEmail(email);
        //auvenirPage.verifyApprovePopupDisplayed();
    }

    public void verifyPersonalPage() {
        auditorOnBoardingPage.verifyOnBoardingPersonalInformationPage();
    }

    public void verifyInputPersonalInfomation(String auditorName, String phoneNumber) {
        auditorOnBoardingPage.verifyInputPersonalInfomation(auditorName, phoneNumber);
    }

    public void verifyFirmPage() {
        auditorOnBoardingPage.verifyOnBoardingFirmInfomationPage();
    }

    public void verifyInputFirmInformation(String firmName, String numberEmployee, String phoneNumber,
                                           String address, String unitNumber, String cityName, String provinceState,
                                           String countryName, String zipCode) {
        auditorOnBoardingPage.verifyInputFirmInformationOnboardingPage(firmName, numberEmployee, phoneNumber, address,
                unitNumber, cityName, provinceState, countryName, zipCode);
    }

    public void verifyFooterPage() {
        auvenirPage.verifyFooterPage();
    }

    public void verifyInputAffliateField(String affliateName) {
        auditorOnBoardingPage.verifyInputAffliateField(affliateName);
    }

    public void verifySecurityOnBoardingPage() {
        auditorOnBoardingPage.verifySecurityOnBoardingPage();
    }

    public void verifyAdminLoginPage() {
        try {
            adminLoginPage.verifyAdminLoginPage();
            NXGReports.addStep("Admin Login is able to login correctly", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Admin Login is able to login correctly", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyChangeActiveStatus(String userType, String email, String dateCreated) {
        try {
            adminLoginPage.getEleChangeActiveStatus(userType, email, dateCreated);
            NXGReports.addStep("status of auditor changed to ACTIVE.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("status of auditor changed to ACTIVE.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyheaderPage() {
        auvenirPage.verifyHeader();
    }

    public void verifyDisplayElementInAuditorDashBoardPage() {
        auditorDashboardPage.verifyDisplayElementOnAuditorDashBoardPage();
    }

    public void clickRequestLink() {
        auditorDashboardPage.clickRequestLink();
    }

    public void verifyDisplayElementInEngagementRequestPage() {
        try {
            engagementRequestPage.verifyDisplayElementInRequestPage();
            NXGReports.addStep("verify element on engagement request page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element on engagement request page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDisplayElementInEngagementFilesPage() {
        try {
            engagementFilesPage.verifyDisplayElementInEngagementFilesPage();
            NXGReports.addStep("verify element in engagement files manager page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element in engagement files manager page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickFilesLink() {
        auditorDashboardPage.clickFilesLink();
    }

    public void clickActivityLink() {
        auditorDashboardPage.clickActivityLink();
    }


    public void verifyDisplayElementInEngagementActivityPage() {
        try {
            auditorDashboardPage.verifyDisplayElementInActivityPage();
            NXGReports.addStep("verify element in engagement activity page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element in engagement activity page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickClientsLink() {
        auditorEngagementPage.clickClientsLink();
    }

    public void clickAddNewClientButton() {
        auditorEngagementPage.clickAddNewButton();
    }

    public void verifyDisplayElementInAddNewClientPage() {
        try {
            addNewClientPage.verifyDisplayElementInAddNewClientPage();
            NXGReports.addStep("verify element in add new client page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element in add new client page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void auditorPageHeaderContent() {
        try {
            auditorEngagementPage.auditorPageHeaderContent();
            NXGReports.addStep("verify auditor client page header content.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify auditor client page header content.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDisplayElementInClientPage() {
        try {
            auditorClientPage.verifyDisplayElementInClientPage();
            NXGReports.addStep("verify element in client page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element in client page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickdropDownSetingLink() {
        auditorEngagementPage.clickdropDownSetingLink();
    }

    public void verifyDisplayElementInAuditorAccountSettingPage() {
        try {
            auditorSettingsPage.verifyDisplayElementInAuditorAccountSettingPage();
            NXGReports.addStep("verify element in auditor account setting page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element in auditor setting account page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDisplayElementInDeActivePage() {
        try {
            adminLoginPage.verifyDisplayElementInDeActivePage();
            NXGReports.addStep("verify element in deactive page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element in deactive page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToAuditorAccountSetting() {
        auditorEngagementPage.clickAuditorNameDropDown();
        auditorEngagementPage.clickdropDownSetingLink();
    }

    public void verifyDisplayElementInAuditorNotificationSettingPage() {
        try {
            auditorSettingsPage.verifyDisplayElementInAuditorNotificationSettingPage();
            NXGReports.addStep("verify element in auditor notification setting page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element in auditor notification setting page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDisplayElementInArchivePage() {
        try {
            auditorDashboardPage.verifyDisplayElementInArchivePage();
            NXGReports.addStep("verify element in auditor archive page displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify element in auditor archive page displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Refactored by huy.huynh on 01/06/2017.
     * New for smoke test
     */

    public void verifySecurityOnBoardingPageSimplelize(String password) {
        auditorOnBoardingPage.verifySecurityOnBoardingPageSimplelize(password);
    }

    public void verifyEpilogueOnBoardingPage(String email) {
        auditorOnBoardingPage.verifyEpilogueOnBoardingPage(email);
    }
    /*-----------end of huy.huynh on 01/06/2017.*/
}
