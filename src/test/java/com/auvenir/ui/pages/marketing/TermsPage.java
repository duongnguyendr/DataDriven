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
public class TermsPage extends AbstractPage {

    public TermsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify page content
     */
    /*@Override
    public void verifyContentPage() {
        System.out.println("Verify terms and condition page content");
    }
*/
    /*@Override
    protected void load() {
        getFooterPage().getEleTerms().click();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(webDriver.getTitle(), "Terms of Service");
    }*/
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[@class='ui center aligned header header-main-text']")
    private WebElement termsHeaderText;
    @FindBy(xpath = ".//*[@id='term']/div[2]/div[1]/p/div")
    private WebElement auvenirTermsOfServiceText;
    @FindBy(xpath = ".//*[@class='terms-detail']/div[1]/p[1]")
    private WebElement termsContentText;
    public void verifyTermsContentPage(){
        waitForVisibleElement(auvenirLogoImage,"auvenirLogoImage");
        waitForVisibleElement(termsHeaderText,"termsHeaderText");
        //waitForVisibleElement(auvenirTermsOfServiceText,"auvenirTermsOfServiceText");
        //waitForVisibleElement(termsContentText,"termsContentText");
    }
}
