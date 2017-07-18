package com.auvenir.ui.pages.groupPermissions;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorPage extends AbstractPage {
    @FindBy(id = "newAuditBtn")
    private WebElement buttonNewEngagement;

    public AdminAuditorPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    /**
     * Added by huy.huynh on 17/07/2017.
     * R2.1 Group Permissions
     */
    public void verifyCanCreateAnEngagement(boolean exist){
        if(exist){
            clickElement(buttonNewEngagement,"Button New Engagement");
        } else {
            validateNotExistedElement(buttonNewEngagement,"Button New Engagement");
        }
    }
    /*-----------end of huy.huynh on 17/07/2017.*/
}
