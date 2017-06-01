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
public class CareersPage extends AbstractPage {

    public CareersPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }
    private String marketingHeaderTextCst = "We are growing. Come join our team.";
    private String careersAtAuvenirTextCst = "Careers at Auvenir";
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
        getLogger().info("Verify careers content page");
        boolean checkMarketingHeaderText = false;
        boolean checkCareersAuvenirText = false;
        boolean isCheckCareersContentPage,isCheckCareersContentPage1, isCheckCareersContentPage2, isCheckCareersContentPage3, isCheckCareersContentPage4
        ,isCheckCareersContentPage5  = false;
        isCheckCareersContentPage = waitForVisibleElement(auvenirLogoImage,"auvenirLogoImage");
        isCheckCareersContentPage1 = waitForVisibleElement(marketingHeaderText,"auvenmarketingHeaderTextirLogoImage");
        if(marketingHeaderText.getText().equals(marketingHeaderTextCst))
        {
            checkMarketingHeaderText = true;
        }
        getLogger().info("marketingHeaderText = " + marketingHeaderText.getText());
        isCheckCareersContentPage2 = waitForVisibleElement(careersAtAuvenirText,"careersAtAuvenirText");
        if(careersAtAuvenirText.getText().equals(careersAtAuvenirTextCst))
        {
            checkCareersAuvenirText = true;
        }
        isCheckCareersContentPage3 = waitForVisibleElement(EngineeringText,"EngineeringText");
        isCheckCareersContentPage4 = waitForVisibleElement(ProductText,"ProductText");
        isCheckCareersContentPage5 = waitForVisibleElement(SalesText,"SalesText");
        if(isCheckCareersContentPage & isCheckCareersContentPage1 & isCheckCareersContentPage2 & isCheckCareersContentPage3 & isCheckCareersContentPage4
                & isCheckCareersContentPage5 & checkMarketingHeaderText & checkCareersAuvenirText)
        {
            NXGReports.addStep("Verify careers content page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }
        else
        {
            AbstractService.sStatusCnt ++;
            NXGReports.addStep("Verify careers content page: PASSED", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
