package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.dataprovider.groupPermissions.AdminAuditorDataProvider;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.Test;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorTest extends AbstractTest {
    private MarketingService maketingService;

    @Test(priority = 1, enabled = true, description = "To verify admin is able to login", dataProvider = "verifyPermissionCreateAnEngagement",
            dataProviderClass = AdminAuditorDataProvider.class)
    public void verifyPermissionCreateAnEngagement(String auditorId, String auditorPassword) {
        getLogger().info("Verify admin auditor can Create An Engagement.");
        maketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        
    }
}
