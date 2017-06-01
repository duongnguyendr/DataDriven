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
public class AboutPage extends AbstractPage {

    public AboutPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify page content
     */
    //@Override
    /*public void verifyContentPage() {
        System.out.println("Verify about page content.");
    }

    //@Override
    protected void load() {
        getFooterPage().getEleAbout().click();
    }

    //@Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(getDriver().getTitle(), "About");
    }*/
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement avenirLogo;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[@class='ui center aligned header header-main-text']")
    private WebElement headerText;
    @FindBy(xpath = ".//*[@id='about-league']/h2")
    private WebElement meetTheAuvyLeagueText;
    @FindBy(xpath = ".//img[@src='/static/images/about/img_teammember_01.png']")
    private WebElement alexImage;
    @FindBy(xpath = ".//*[@id='about-league']//h4[contains(text(),'Alex McCooey')]")
    private WebElement alextNameText;
    @FindBy(xpath = ".//*[@id='about-league']/div/div[1]/p")
    private WebElement alextTitleText;
    @FindBy(xpath = ".//*[@id='about-joinUs']/div/h2")
    private WebElement wannaJoinUsText;
    @FindBy(xpath = ".//*[@id='about-joinUs']/div/a")
    private WebElement viewCareerBTN;
    @FindBy(xpath = ".//*[@id='about-highlightPhotos']/h2")
    private WebElement highlightSoFourWeekendText;
    @FindBy(xpath = ".//img[@src='/static/images/about/img-wkphoto_01.png']")
    private WebElement firstImage;
    public void verifyAboutContentPage(){
        waitForVisibleElement(avenirLogo,"avenirLogo");
        validateElementText(headerText,"Auvenir is a Toronto-based technology company that makes the audit process better for auditors and clients. We are proud to be a Deloitte venture.");
        waitForVisibleElement(meetTheAuvyLeagueText,"meetTheAuvyLeagueText");
        waitForVisibleElement(alexImage,"alexImage");
        waitForVisibleElement(alextNameText,"alextNameText");
        waitForVisibleElement(alextTitleText,"alextTitleText");
        waitForVisibleElement(wannaJoinUsText,"wannaJoinUsText");
        waitForVisibleElement(viewCareerBTN,"viewCareerBTN");
        waitForVisibleElement(highlightSoFourWeekendText,"highlightSoFourWeekendText");
        waitForVisibleElement(firstImage,"firstImage");
    }
    public void goToCareersPage(){
        clickElement(viewCareerBTN,"viewCareerBTN");
    }
}
