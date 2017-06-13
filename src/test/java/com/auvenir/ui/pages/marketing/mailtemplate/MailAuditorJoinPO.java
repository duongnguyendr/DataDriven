package com.auvenir.ui.pages.marketing.mailtemplate;

import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class MailAuditorJoinPO extends BaseMailTemplatePO {

    // Element of title mail
    @FindBy(xpath = "//p[contains(text(),'Hello')]")
    private WebElement eleTitle;

    public WebElement getEleTitle() {
        return eleTitle;
    }

    @FindBy(xpath = "//h2[contains(text(),'Your Auvenir')]")
    private WebElement eleSubjectActiveEmail;

    public WebElement getEleSubjectActiveEmail() {
        return eleSubjectActiveEmail;
    }

    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    private WebElement eleWelcomeActiveEmail;

    public WebElement getEleWelcomeActiveEmail() {
        return eleWelcomeActiveEmail;
    }


    // Element of content mail
    @FindBy(xpath = "//p[contains(text(),'We ')]")
    private WebElement eleContent;

    public WebElement getEleContent() {
        return eleContent;
    }

    @FindBy(xpath = "//p[contains(text(),'Your account')]")
    private WebElement eleInformActive;

    public WebElement getEleInformActive() {
        return eleInformActive;
    }

    @FindBy(xpath = "//p[contains(text(),'your feedback')]")
    private WebElement eleFeedbackInform;
    public WebElement getEleFeedbackInform(){
        return eleFeedbackInform;
    }

    @FindBy(xpath = "//center/a")
    private WebElement eleGetStarted;
    public WebElement getEleGetStarted(){
        return eleGetStarted;
    }

    @FindBy(xpath = "//a[@href='mailto:feedback@auvenir.com%5C%22']")
    private WebElement eleFeedbackLink;
    public WebElement getEleFeedbackLink(){
        return eleFeedbackLink;
    }
    // Element of button Go to Auvenir website
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='http://auvenir.s3corp.com.vn:5000']")
    private WebElement btnGoToSiteAuvenir;

    public WebElement getBtnGoToSiteAuvenir() {
        return btnGoToSiteAuvenir;
    }

    // Element of Twitter link
    @FindBy(xpath = "//a[@href='https://twitter.com/auvenir']")
    private WebElement lnkTwitter;

    public WebElement getLnkTwitter() {
        return lnkTwitter;
    }

    // Element of LinkedIn link
    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/auvenir']")
    private WebElement lnkLinked;

    public WebElement getLnkLinked() {
        return lnkLinked;
    }

    // Element of Facebook link
    @FindBy(xpath = "//a[@href='https://www.facebook.com/auvenir/']")
    private WebElement lnkFacebook;

    public WebElement getLnkFacebook() {
        return lnkFacebook;
    }

    // Element of InfoAuvenir link
    @FindBy(xpath = "//a[@href='mailto:info@auvenir.com']")
    private WebElement lnkInfoAuvenir;

    public WebElement getLnkInfoAuvenir() {
        return lnkInfoAuvenir;
    }

    // Element of footer content mail
    @FindBy(xpath = "//p[contains(text(),'Best Regards,') and contains(.,'Auvenir Customer Success Team')]")
    private WebElement eleSignatureMail;

    public WebElement getEleSignatureMail() {
        return eleSignatureMail;
    }
    public MailAuditorJoinPO(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public MailAuditorJoinPO(Logger logger, WebDriver webDriver) {
        super(logger, webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void verifyPageContent() {
        // Checking Title Email element is displayed
        NXGReports.addStep("Verify title of Email", LogAs.PASSED, null);
        this.validateElememt(eleTitle, "Element of Title of Mail", Element_Type.DISPLAYED);

        // Checking content mail
        NXGReports.addStep("Verify content mail", LogAs.PASSED, null);
        this.validateElememt(eleContent, "Element of content mail", Element_Type.DISPLAYED);
        this.validateElememt(eleContent, "We are excited about your interest in Auvenir, where we are on a mission to make the audit process better for auditors and their clients. We'll make sure to keep you up to date on our progress and will let you know when you can start using the platform.", Element_Type.TEXT_VALUE);

        // Checking link Twitter
        NXGReports.addStep("Verify link Twitter", LogAs.PASSED, null);
        this.validateElememt(lnkTwitter, "Verify Element of Twitter link", Element_Type.DISPLAYED);

        // Checking link LinkedIn
        NXGReports.addStep("Verify link LinkedIn", LogAs.PASSED, null);
        this.validateElememt(lnkLinked, "Verify Element of LinkedIn link", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify link LinkedIn", LogAs.PASSED, null);

        // Checking link Facebook
        NXGReports.addStep("Verify link Facebook", LogAs.PASSED, null);
        this.validateElememt(lnkFacebook, "Verify Element of Facebook link", Element_Type.DISPLAYED);

        // Checking link InfoAuvenir
        NXGReports.addStep("Verify link InfoAuvenir", LogAs.PASSED, null);
        this.validateElememt(lnkInfoAuvenir, "Verify Element of Info Auvenir link", Element_Type.DISPLAYED);

        // Checking Signature footer
        NXGReports.addStep("Verify Signature footer", LogAs.PASSED, null);
        this.validateElememt(eleSignatureMail, "Verify Element of Signature footer", Element_Type.DISPLAYED);
    }
    /*

    Vien.Pham added new

        */
    public void verifyActiveEmailContent() {
        //Checking subject Active Email
        this.validateElememt(getEleSubjectActiveEmail(), "Verify Subject of Active Email", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Subject of Active Email", LogAs.PASSED, null);
        // Checking Content Email is displayed
        this.validateElememt(getEleWelcomeActiveEmail(), "Element of Title of Mail", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Content of Active Email", LogAs.PASSED, null);
        // Checking content mail
        this.validateElememt(getEleInformActive(),"Your account has been validated and is now active. When you are ready to audit smarter, click the button below",Element_Type.DISPLAYED);
        this.validateElememt(getEleFeedbackInform(),"We welcome your feedback, ideas and suggestions to make the audit experience better. Send us an email at feedback@auvenir.com.",Element_Type.DISPLAYED);
        NXGReports.addStep("Verify content mail", LogAs.PASSED, null);
        //Checking Get Started button
        this.validateElememt(getEleGetStarted(),"Get Started",Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Get started", LogAs.PASSED, null);
        //Checking Feedback link
        this.validateElememt(getEleFeedbackLink(),"feedback@auvenir.com",Element_Type.DISPLAYED);
        NXGReports.addStep("Verify feedback link", LogAs.PASSED, null);
        // Checking Signature footer
        this.validateElememt(eleSignatureMail, "Verify Element of Signature footer", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Signature footer", LogAs.PASSED, null);
    }

    protected void isLoaded() throws Error {

        // checking header of Email is displayed
        this.validateElememt(this.getEleHeader(), "Elemnent of Header mail", Element_Type.DISPLAYED);

        // Checking footer of Email is displayed
        this.validateElememt(this.getEleFooter(), "Element of Footer mail", Element_Type.DISPLAYED);

        // Checking content of footer mail
        this.validateElememt(this.getEleContentLogoFooter(), "Audit, Smarter.", Element_Type.TEXT_VALUE);

        // Checking address Auvenir of footer mail
        this.validateElememt(this.getEleAddressMailFooter(), "225 Richmond Street West, Suite 402, Toronto, ON M5V1W2", Element_Type.TEXT_VALUE);

        // Checking "terms of service" link
        this.validateElememt(this.getEleLinkTermsFooter(), "Element terms of service", Element_Type.DISPLAYED);

        // Checking "privacy statament" link
        this.validateElememt(this.getEleLinkPrivacyFooter(), "Element of privacy", Element_Type.DISPLAYED);

        // Checking "un subscribe" link
        this.validateElememt(this.getEleLinkUnSubscribeFooter(), "Element of unsubscribe", Element_Type.DISPLAYED);

    }

    public void clickGetStartedButton() {
        getLogger().info("Click Get Started Button.");
        waitForVisibleElement(eleGetStarted, "Get Started.");
        clickElement(eleGetStarted, "Get Started.");
    }

    public void navigateToConfirmationLink() throws Exception {
        getLogger().info("Navigate to Confirmation Link");
        GmailPage gmailLoginPage = new GmailPage(getLogger(), getDriver());
        Thread.sleep(3000);
        String link = eleGetStarted.getAttribute("href");
        System.out.print("Link: " + link);
        gmailLoginPage.gmailLogout();
        Thread.sleep(2000);
        if (GenericService.sBrowserData.equals("ff.")){
            getLogger().info("Accept alert.");
//            getDriver().switchTo().alert().accept();
        }
        getDriver().get(link);
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitForProgressOverlayIsClosed();
    }
}
