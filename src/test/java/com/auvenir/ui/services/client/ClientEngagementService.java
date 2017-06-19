package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.ClientEngagementPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 15/06/2017.
 */
public class ClientEngagementService extends AbstractService {
    private ClientEngagementPage clientEngagementPage;

    public ClientEngagementService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientEngagementPage = new ClientEngagementPage(getLogger(), getDriver());
    }

    public void verifyNavigatedToClientEngagementPage() {
        clientEngagementPage.verifyNavigatedToClientEngagementPage();
    }
}
