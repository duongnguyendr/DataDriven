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
public class CareersPage extends AbstractPage {

    public CareersPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify page content
     */
    /*@Override
    public void verifyContentPage() {
        System.out.println("Verify careers page content");
    }
*/
    /*@Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }*/
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[@class='row']/div")
    private WebElement marketingHeaderText;
    @FindBy(xpath = ".//*[@id='career']//h1[@class='page-title']")
    private WebElement careersAtAuvenirText;
    @FindBy(xpath = ".//*[@id='career']//div[contains(text(),'Engineering')]")
    private WebElement EngineeringText;
    @FindBy(xpath = ".//*[@id='career']//div[contains(text(),'Product')]")
    private WebElement ProductText;
    @FindBy(xpath = ".//*[@id='career']//div[contains(text(),'Sales')]")
    private WebElement SalesText;
    public void verifyCareersContentPage(){
        waitForVisibleElement(auvenirLogoImage,"auvenirLogoImage");
        waitForVisibleElement(marketingHeaderText,"auvenmarketingHeaderTextirLogoImage");
        waitForVisibleElement(careersAtAuvenirText,"careersAtAuvenirText");
        waitForVisibleElement(EngineeringText,"EngineeringText");
        waitForVisibleElement(ProductText,"ProductText");
        waitForVisibleElement(SalesText,"SalesText");

    }
}
