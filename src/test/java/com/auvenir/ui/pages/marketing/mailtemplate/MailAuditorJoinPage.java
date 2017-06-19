package com.auvenir.ui.pages.marketing.mailtemplate;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class MailAuditorJoinPage extends AbstractPage {

    // Element of title mail
    @FindBy(xpath = "//p[contains(text(),'Hello')]")
    private WebElement eleTitle;

    public WebElement getEleTitle() {
        return eleTitle;
    }

    @FindBy(xpath = "//h2[contains(text(),'Your Auvenir')]")
    private WebElement eleSubjectActiveEmail;

    @FindBy(xpath = "//h2[contains(text(),'Invitation from ')]")
    private WebElement eleSubjectInviteClientEmail;

    public WebElement getEleSubjectInviteClientEmail() {
        return eleSubjectInviteClientEmail;
    }

    @FindBy(xpath = "//p[contains(text(),'Hi')]")
    private WebElement eleContent0InviteClientEmailClient;

    public WebElement getEleContent0InviteClientEmailClient() {
        return eleContent0InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'has invited')]")
    private WebElement eleContent1InviteClientEmailClient;

    public WebElement getEleContent1InviteClientEmailClient() {
        return eleContent1InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'Auvenir is')]")
    private WebElement eleContent2InviteClientEmailClient;

    public WebElement getEleContent2InviteClientEmailClient() {
        return eleContent2InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'Here')]")
    private WebElement eleContent3InviteClientEmailClient;

    public WebElement getEleContent3InviteClientEmailClient() {
        return eleContent3InviteClientEmailClient;
    }


    @FindBy(xpath = "//p[contains(text(),'Secure')]")
    private WebElement eleContent4InviteClientEmailClient;

    public WebElement getEleContent4InviteClientEmailClient() {
        return eleContent4InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'Customized')]")
    private WebElement eleContent5InviteClientEmailClient;

    public WebElement getEleContent5InviteClientEmailClient() {
        return eleContent5InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'Bank')]")
    private WebElement eleContent6InviteClientEmailClient;

    public WebElement getEleContent6InviteClientEmailClient() {
        return eleContent6InviteClientEmailClient;
    }

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

    public WebElement getEleFeedbackInform() {
        return eleFeedbackInform;
    }

    @FindBy(xpath = "//center/a")
    private WebElement eleGetStarted;

    public WebElement getEleGetStarted() {
        return eleGetStarted;
    }

    @FindBy(xpath = "//a[@href='mailto:feedback@auvenir.com%5C%22']")
    private WebElement eleFeedbackLink;

    public WebElement getEleFeedbackLink() {
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

    public MailAuditorJoinPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public MailAuditorJoinPage(Logger logger, WebDriver webDriver) {
        super(logger, webDriver);
        PageFactory.initElements(webDriver, this);
    }

    //@Override
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
        this.validateElememt(getEleSignatureMail(), "Verify Element of Signature footer", Element_Type.DISPLAYED);
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
        this.validateElememt(getEleInformActive(), "Your account has been validated and is now active. When you are ready to audit smarter, click the button below", Element_Type.DISPLAYED);
        this.validateElememt(getEleFeedbackInform(), "We welcome your feedback, ideas and suggestions to make the audit experience better. Send us an email at feedback@auvenir.com.", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify content mail", LogAs.PASSED, null);
        //Checking Get Started button
        this.validateElememt(getEleGetStarted(), "Get Started", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Get started", LogAs.PASSED, null);
        //Checking Feedback link
        this.validateElememt(getEleFeedbackLink(), "feedback@auvenir.com", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify feedback link", LogAs.PASSED, null);
        // Checking Signature footer
        this.validateElememt(eleSignatureMail, "Verify Element of Signature footer", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Signature footer", LogAs.PASSED, null);
    }


    public void verifyAuditorInviteClientEmail() {

        //Checking subject Auditor invite Client
        this.validateElememt(getEleSubjectInviteClientEmail(), "Verify subject of Invite Email", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Subject of Invite Email", LogAs.PASSED, null);
        //Checking content of Invite email
        this.validateElememt(getEleContent0InviteClientEmailClient(), "Verify content 0", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent1InviteClientEmailClient(), "Verify content 1", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent2InviteClientEmailClient(), "Verify content 2", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent3InviteClientEmailClient(), "Verify content 3", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent4InviteClientEmailClient(), "Verify content 4", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent5InviteClientEmailClient(), "Verify content 5", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent6InviteClientEmailClient(), "Verify content 6", Element_Type.DISPLAYED);
        this.validateElememt(getEleFeedbackInform(), "Verify Feedback inform", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Email content ", LogAs.PASSED, null);
        //Checking footer of Invite Email
        this.validateElememt(getEleSignatureMail(), "Verify signature", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Signature footer", LogAs.PASSED, null);
        //Checking getStarted
        this.validateElememt(getEleGetStarted(), "Verify Get started btn", Element_Type.DISPLAYED);
        NXGReports.addStep("Verify Get Started btn", LogAs.PASSED, null);
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
    // Element of header mail
    @FindBy(xpath = "//center/img[contains(@src,'png') and @alt='logo.png']")
    protected WebElement eleHeader;
    public WebElement getEleHeader(){
        return  eleHeader;
    }

    // Element of logo footer mail
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']")
    protected WebElement eleLogoFooter;
    public WebElement getEleFooter(){
        return eleLogoFooter;
    }

    // Element of content Logo Footer mail
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[1]")
    protected WebElement eleContentLogoFooter;
    public WebElement getEleContentLogoFooter(){return eleContentLogoFooter; }

    // Element of Full Address Auvenir
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[2]")
    protected WebElement eleAddressMailFooter;
    public WebElement getEleAddressMailFooter(){ return  eleAddressMailFooter; }

    // Element of "terms of service" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[3]/a[@href='http://auvenir.s3corp.com.vn:5000/terms']")
    protected WebElement eleLinkTermsFooter;
    public WebElement getEleLinkTermsFooter(){ return eleLinkTermsFooter; }

    // Element of "privacy statement" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[3]/a[@href='http://auvenir.s3corp.com.vn:5000/privacy']")
    protected WebElement eleLinkPrivacyFooter;
    public WebElement getEleLinkPrivacyFooter() { return eleLinkPrivacyFooter; }

    // Element of "unsubscribe" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[4]/a[@href='mailto:unsubscribe@auvenir.com?Subject=Unsubscribe']")
    protected WebElement eleLinkUnSubscribeFooter;
    public WebElement getEleLinkUnSubscribeFooter(){ return eleLinkUnSubscribeFooter; }

}
