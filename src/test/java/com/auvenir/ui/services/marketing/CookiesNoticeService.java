package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.CookieNoticePage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class CookiesNoticeService extends AbstractService {
    CookieNoticePage cookieNoticePage;
    public CookiesNoticeService(Logger logger, WebDriver driver) {
        super(logger, driver);
        cookieNoticePage = new CookieNoticePage(getLogger(), getDriver());
    }
    public void verifyCookiesNoticeContentPage(){
        cookieNoticePage.verifyCookiesNoticeContentPage();
    }
}
