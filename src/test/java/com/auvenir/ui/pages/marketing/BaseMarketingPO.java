package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public abstract class BaseMarketingPO extends AbstractPage {

    protected HeaderPage headerPage;
    protected FooterPage footerPage;

    /**
     * Verify page content
     */
    public abstract void verifyContentPage();

    public BaseMarketingPO(Logger logger, WebDriver driver){
        super(driver);
        this.headerPage = new HeaderPage(driver);
        this.footerPage = new FooterPage(driver);
    }

    public HeaderPage getHeaderPage(){ return headerPage; }
    public FooterPage getFooterPage() { return footerPage; }
}
