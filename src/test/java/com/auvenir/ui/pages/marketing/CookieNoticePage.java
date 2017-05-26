package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class CookieNoticePage extends AbstractPage {

    public CookieNoticePage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify page content
     */
    /*@Override
    public void verifyContentPage() {
        System.out.println("Verify cookies notice page content.");
    }
*/
    /*@Override
    protected void load() {
        getFooterPage().getEleCookieNotice().click();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(webDriver.getTitle(), "Cookie Notice");
    }*/
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[@class='ui text container cookie-banner']")
    private WebElement cookiesNoticeText;
    @FindBy(xpath = ".//*[@id='cookie-page']//h1/div")
    private WebElement auvenirCookieNoticeText;
    @FindBy(xpath = ".//*[@id='cookie-page']//div[@class='ui text container cookie-content']")
    private WebElement ookiesNoticecontentText;
    public void verifyCookiesNoticeContentPage(){
        waitForVisibleElement(auvenirLogoImage,"auvenirLogoImage");
        waitForVisibleElement(cookiesNoticeText,"cookiesNoticeText");
        waitForVisibleElement(auvenirCookieNoticeText,"auvenirCookieNoticeText");
        waitForVisibleElement(ookiesNoticecontentText,"ookiesNoticecontentText");
    }
}
