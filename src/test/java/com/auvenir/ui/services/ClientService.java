package com.auvenir.ui.services;

import com.auvenir.ui.pages.client.*;
import com.auvenir.ui.tests.AbstractTest;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class ClientService  extends AbstractService{

    ClientDashboardPage clientDashboardPage;
    ClientSettingsPage clientSettingsPage;
    ClientAccountSettingsPage clientAccountSettingsPage;
    ClientNotificationsSettingsPage clientNotificationsSettingsPage;
    ClientIntegrationsSettingsPage clientIntegrationsSettingsPage;
    ClientDevicesSettingsPage clientDevicesSettingsPage;

    public ClientService(Logger logger, WebDriver driver){

        super(logger,driver);
        clientDashboardPage= new ClientDashboardPage(getLogger(),getDriver());
        clientSettingsPage = new ClientSettingsPage(getLogger(),getDriver());
        clientAccountSettingsPage = new ClientAccountSettingsPage(getLogger(),getDriver());
        clientNotificationsSettingsPage = new ClientNotificationsSettingsPage(getLogger(),getDriver());
        clientIntegrationsSettingsPage = new ClientIntegrationsSettingsPage(getLogger(),getDriver());
        clientDevicesSettingsPage = new ClientDevicesSettingsPage(getLogger(),getDriver());
    }



    public void navigateToClientDashboardPage() {
        getLogger().info("navigate to client dashboard page.");

        clientDashboardPage.clickAuvenirLogo();
    }

    public void navigateToInProgressTab() {
        try {
            getLogger().info("navigate to In Progress tab.");
            clientDashboardPage.navigateToInProgressTab();
            NXGReports.addStep("navigate to In Progress tab", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("navigate to In Progress tab", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }


    }

    public void verifyClientFooter() {

        try {
            getLogger().info("verify footer page.");
            clientDashboardPage.verifyClientFooter();
            getLogger().info("verfify term of service link.");
            clientDashboardPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            //clientDashboardPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            //clientDashboardPage.verifyCookieNotice();
            clientDashboardPage.scrollPageUp();
                    NXGReports.addStep("verify footer page", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("verify footer page", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToCompletedTab() {

        try {
            getLogger().info("navigae to Completed Tab.");
            clientDashboardPage.navigateToCompletedTab();
            NXGReports.addStep("navigate to completed tab", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("navigate to completed Tab", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToClientSettingsPage() {

        try {
            getLogger().info("navigate to client Settings page.");
            clientDashboardPage.navigateToClientSettingsPage();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToAccountTab() {

        try {
            getLogger().info("navigate to Account tab.");
            clientSettingsPage.navigateToAccountTab();
            NXGReports.addStep("navigate to account settings tab.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("navigate to account settings tab.", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void navigateToIntegrationTab() {

        try {
            getLogger().info("Navigate to Integrations tab.");
            clientSettingsPage.navigatToIntegrationTab();
            NXGReports.addStep("navigate to integration tab.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("navigate to integration tab.", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToDevicesTab() {

        try {
            getLogger().info("navigate to Devices tab.");
            clientSettingsPage.navigateToDevicesTab();
            NXGReports.addStep("navigate to Devices tab.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("navigate to Devices tab tab.", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToNotificationsTab() {

        try {
            getLogger().info("navigate to Notification tab.");
            clientSettingsPage.navigateToNotificationsTab();
            NXGReports.addStep("navigate to Notification tab.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("navigate to Notification tab.", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyAccountSettingsPage() {
        try {
            getLogger().info("verifyAccountSettingsPage.");
            clientAccountSettingsPage.verifyAccountSettingsPage();
            NXGReports.addStep("Account Settings page rendered.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("Account Settings page rendered.", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyNotificationsSettingsPage() {
        try {
            getLogger().info("verify notification Settings Page.");
            clientNotificationsSettingsPage.verifyNotificationsSettingsPage();
            NXGReports.addStep("Notification Settings page rendered.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("Notification Settings page rendered.", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyIntegrationsSettingsPage() {
        try {
            getLogger().info("verify integrations Settings Page.");
            clientIntegrationsSettingsPage.verifyIntegrationsSettingsPage();
            NXGReports.addStep("integrations Settings page rendered.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("integrations Settings page rendered.", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyDevicesSettingsPage() {
        try {
            getLogger().info("verify Devices Settings Page.");
            clientDevicesSettingsPage.verifyDevicesSettingsPage();
            NXGReports.addStep("integrations Settings page rendered.", LogAs.PASSED,null);
        }catch (Exception e)
        {
            NXGReports.addStep("integrations Settings page rendered.", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
