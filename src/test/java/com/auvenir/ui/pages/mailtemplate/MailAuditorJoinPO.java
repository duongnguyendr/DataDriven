package com.auvenir.ui.pages.mailtemplate;


import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class MailAuditorJoinPO extends BaseMailTemplatePO {

    // Element of title mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'Hello')]")
    private WebElement eleTitle;
    public WebElement getEleTitle(){return  eleTitle; }

    // Element of content mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'We')]")
    private WebElement eleContent;
    public WebElement getEleContent(){return  eleContent;}

    // Element of button Go to Auvenir website
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='http://auvenir.s3corp.com.vn:5000']")
    private WebElement btnGoToSiteAuvenir;
    public WebElement getBtnGoToSiteAuvenir(){return btnGoToSiteAuvenir; }

    // Element of Twitter link
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='https://twitter.com/auvenir']")
    private WebElement lnkTwitter;
    public WebElement getLnkTwitter(){ return lnkTwitter; }

    // Element of LinkedIn link
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='https://www.linkedin.com/company/auvenir']")
    private WebElement lnkLinked;
    public WebElement getLnkLinked(){ return lnkLinked; }

    // Element of Facebook link
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='https://www.facebook.com/auvenir/']")
    private WebElement lnkFacebook;
    public WebElement getLnkFacebook(){ return lnkFacebook; }

    // Element of InfoAuvenir link
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='mailto:info@auvenir.com']")
    private WebElement lnkInfoAuvenir;
    public WebElement getLnkInfoAuvenir(){return lnkInfoAuvenir; }

    // Element of footer content mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'Best Regards,') and contains(.,'Auvenir Customer Success Team')]")
    private WebElement eleSignatureMail;
    public WebElement getEleSignatureMail(){return eleSignatureMail; }


    public MailAuditorJoinPO(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @Override
    public void verifyPageContent() {
        // Checking Title Email element is displayed
        NXGReports.addStep("Verify title of Email", LogAs.PASSED,  null);
        this.validateElememt(eleTitle, "Element of Title of Mail", Element_Type.DISPLAYED);
        this.validateElememt(eleTitle,"Hello Test Auditor,", Element_Type.TEXT_VALUE);

        // Checking content mail
        NXGReports.addStep("Verify content mail", LogAs.PASSED, null);
        this.validateElememt(eleContent,"Element of content mail", Element_Type.DISPLAYED);
        this.validateElememt(eleContent,"We are excited about your interest in Auvenir, where we are on a mission to make the audit process better for auditors and their clients. We'll make sure to keep you up to date on our progress and will let you know when you can start using the platform.", Element_Type.TEXT_VALUE);

        // Checking button Go to Site Auvenir
        NXGReports.addStep("Verify button Go to Site Auvenir", LogAs.PASSED, null);
        this.validateElememt(btnGoToSiteAuvenir,"Element of button Go to Site Auvenir", Element_Type.DISPLAYED);

        // Checking link Twitter
        NXGReports.addStep("Verify link Twitter", LogAs.PASSED, null);
        this.validateElememt(lnkTwitter,"Verify Element of Twitter link", Element_Type.DISPLAYED);

        // Checking link LinkedIn
        NXGReports.addStep("Verify link LinkedIn", LogAs.PASSED, null);
        this.validateElememt(lnkLinked,"Verify Element of LinkedIn link", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify link LinkedIn", LogAs.PASSED, null);

        // Checking link Facebook
        NXGReports.addStep("Verify link Facebook", LogAs.PASSED, null);
        this.validateElememt(lnkFacebook,"Verify Element of Facebook link", Element_Type.DISPLAYED);

        // Checking link InfoAuvenir
        NXGReports.addStep("Verify link InfoAuvenir", LogAs.PASSED, null);
        this.validateElememt(lnkInfoAuvenir,"Verify Element of Info Auvenir link", Element_Type.DISPLAYED);

        // Checking Signature footer
        NXGReports.addStep("Verify Signature footer", LogAs.PASSED, null);
        this.validateElememt(eleSignatureMail,"Verify Element of Signature footer", Element_Type.DISPLAYED);
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


}
