package com.auvenir.ui.pages.marketing.mailtemplate;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class MailAuditorAccessPO extends BaseMailTemplatePO {

    // Element of title mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'Hello')]")
    private WebElement eleTitle;
    public WebElement getEleTitle(){return  eleTitle; }

    // Element of content mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'We')]")
    private WebElement eleContent;
    public WebElement getEleContent(){return  eleContent;}

    // Element of button started Auvenir website
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='http://auvenir.s3corp.com.vn:5000']")
    private WebElement btnStartSiteAuvenir;
    public WebElement getBtnStartSiteAuvenir(){return btnStartSiteAuvenir; }

    // Element of feedback link
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='mailto:info@auvenir.com']")
    private WebElement lnkFeedbackAuvenir;
    public WebElement getLnkFeedbackAuvenir(){return lnkFeedbackAuvenir; }

    // Element of footer content mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'Best Regards,') and contains(.,'Auvenir Customer Success Team')]")
    private WebElement eleSignatureMail;
    public WebElement getEleSignatureMail(){return eleSignatureMail; }


    public MailAuditorAccessPO(Logger logger,WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /*@Override
    protected void load() {
        //
    }

    @Override*/
    protected void isLoaded() throws Error {
        // checking header of Email is displayed
        this.validateElememt(this.getEleHeader(),"Elemnent of Header mail", Element_Type.DISPLAYED);

        // Checking footer of Email is displayed
        this.validateElememt(this.getEleFooter(),"Element of Footer mail", Element_Type.DISPLAYED);

        // Checking content of footer mail
        this.validateElememt(this.getEleContentLogoFooter(),"Audit, Smarter.", Element_Type.TEXT_VALUE);

        // Checking address Auvenir of footer mail
        this.validateElememt(this.getEleAddressMailFooter(),"225 Richmond Street West, Suite 402, Toronto, ON M5V1W2", Element_Type.TEXT_VALUE);

        // Checking "terms of service" link
        this.validateElememt(this.getEleLinkTermsFooter(),"Element terms of service", Element_Type.DISPLAYED);

        // Checking "privacy statament" link
        this.validateElememt(this.getEleLinkPrivacyFooter(),"Element of privacy", Element_Type.DISPLAYED);

        // Checking "un subscribe" link
        this.validateElememt(this.getEleLinkUnSubscribeFooter(),"Element of unsubscribe", Element_Type.DISPLAYED);
    }

    //@Override
    public void verifyPageContent() {

        // Checking Title Email element is displayed
        NXGReports.addStep("Verify title of Email", LogAs.PASSED,  null);
        this.validateElememt(eleTitle, "Element of Title of Mail", Element_Type.DISPLAYED);
        this.validateElememt(eleTitle,"", Element_Type.TEXT_VALUE);

        // Checking content mail
        NXGReports.addStep("Verify content mail", LogAs.PASSED, null);
        this.validateElememt(eleContent,"Element of content mail", Element_Type.DISPLAYED);
        this.validateElememt(eleContent,"", Element_Type.TEXT_VALUE);

        // Checking button Start Site Auvenir
        NXGReports.addStep("Verify button Start Site Auvenir", LogAs.PASSED, null);
        this.validateElememt(btnStartSiteAuvenir,"Element of button Start Site Auvenir", Element_Type.DISPLAYED);

        // Checking link Feedback Auvenir
        NXGReports.addStep("Verify link Feedback Auvenir", LogAs.PASSED, null);
        this.validateElememt(lnkFeedbackAuvenir,"Verify Element of Feedback Auvenir link", Element_Type.DISPLAYED);

        // Checking Signature footer
        NXGReports.addStep("Verify Signature footer", LogAs.PASSED, null);
        this.validateElememt(eleSignatureMail,"Verify Element of Signature footer", Element_Type.DISPLAYED);

    }
}
