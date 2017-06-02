package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
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
        getLogger().info("Verify about content page");
        boolean isCheckAboutContentPage,isCheckAboutContentPage1,isCheckAboutContentPage2,isCheckAboutContentPage3,isCheckAboutContentPage4
                ,isCheckAboutContentPage5,isCheckAboutContentPage6,isCheckAboutContentPage7,isCheckAboutContentPage8,isCheckAboutContentPage9 = false;

        isCheckAboutContentPage = waitForVisibleElement(avenirLogo,"avenirLogo");
        isCheckAboutContentPage1 = validateElementText(headerText,"Auvenir is a Toronto-based technology company that makes the audit process better for auditors and clients. We are proud to be a Deloitte venture.");
        isCheckAboutContentPage2 = waitForVisibleElement(meetTheAuvyLeagueText,"meetTheAuvyLeagueText");
        isCheckAboutContentPage3 = waitForVisibleElement(alexImage,"alexImage");
        isCheckAboutContentPage4 = waitForVisibleElement(alextNameText,"alextNameText");
        isCheckAboutContentPage5 = waitForVisibleElement(alextTitleText,"alextTitleText");
        isCheckAboutContentPage6 = waitForVisibleElement(wannaJoinUsText,"wannaJoinUsText");
        isCheckAboutContentPage7 = waitForVisibleElement(viewCareerBTN,"viewCareerBTN");
        isCheckAboutContentPage8 = waitForVisibleElement(highlightSoFourWeekendText,"highlightSoFourWeekendText");
        isCheckAboutContentPage9 = waitForVisibleElement(firstImage,"firstImage");

        if(isCheckAboutContentPage & isCheckAboutContentPage1 & isCheckAboutContentPage2 & isCheckAboutContentPage3 & isCheckAboutContentPage4 & isCheckAboutContentPage5
                & isCheckAboutContentPage6 & isCheckAboutContentPage7 & isCheckAboutContentPage8 & isCheckAboutContentPage9)
        {
            NXGReports.addStep("Verify about content page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify about content page: PASSED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
    public void goToCareersPage(){
        clickElement(viewCareerBTN,"viewCareerBTN");
    }
}
