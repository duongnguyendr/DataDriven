package com.auvenir.ui.pages.mailtemplate;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */
public class NotificationMailTemplatePO extends BaseMailTemplatePO {

    // Element of title mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'Hi')]")
    private WebElement eleTitle;
    public WebElement getEleTitle(){return  eleTitle; }

    // Element of content mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'We')]")
    private WebElement eleContent;
    public WebElement getEleContent(){return  eleContent;}

    // Element of button link to contact
    @FindBy(xpath = "")
    private WebElement btnLinkContact;
    public WebElement getBtnLinkContact(){return btnLinkContact; }

    // Element of button link to Setting Email
    @FindBy(xpath = "")
    private WebElement btnLinkSettingEmail;
    public WebElement getBtnLinkSettingEmail(){ return btnLinkSettingEmail; }

    // Element of support Auvenir link
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='mailto:info@auvenir.com']")
    private WebElement lnkSupportAuvenir;
    public WebElement getLnkSupportAuvenir(){return lnkSupportAuvenir; }

    // Element of footer content mail
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p[contains(text(),'Best Regards,') and contains(.,'Auvenir Customer Success Team')]")
    private WebElement eleSignatureMail;
    public WebElement getEleSignatureMail(){return eleSignatureMail; }



    public NotificationMailTemplatePO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /*@Override
    protected void load() {

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

        // Checking "terms of service" link in footer
        this.validateElememt(this.getEleLinkTermsFooter(),"Element terms of service", Element_Type.DISPLAYED);

        // Checking "privacy statament" link in footer
        this.validateElememt(this.getEleLinkPrivacyFooter(),"Element of privacy", Element_Type.DISPLAYED);

        // Checking "un subscribe" link in footer
        this.validateElememt(this.getEleLinkUnSubscribeFooter(),"Element of unsubscribe", Element_Type.DISPLAYED);
    }

    @Override
    public void verifyPageContent() {
        // Checking Title Email element is displayed
        NXGReports.addStep("Verify title of Email", LogAs.PASSED,  null);
        this.validateElememt(eleTitle, "Element of Title of Mail", Element_Type.DISPLAYED);
        this.validateElememt(eleTitle,"", Element_Type.TEXT_VALUE);

        // Checking content mail
        NXGReports.addStep("Verify content mail", LogAs.PASSED, null);
        this.validateElememt(eleContent,"Element of content mail", Element_Type.DISPLAYED);
        this.validateElememt(eleContent,"", Element_Type.TEXT_VALUE);

        // Checking button link contact
        NXGReports.addStep("Verify button Link Contact", LogAs.PASSED, null);
        this.validateElememt(btnLinkContact,"Element of button Link Contact", Element_Type.DISPLAYED);

        // Checking button link Setting Email
        NXGReports.addStep("Verify button Link Settings Email", LogAs.PASSED, null);
        this.validateElememt(btnLinkSettingEmail,"Element of button Link Settings Email", Element_Type.DISPLAYED);

        // Checking link Feedback Auvenir
        NXGReports.addStep("Verify link Support Auvenir", LogAs.PASSED, null);
        this.validateElememt(lnkSupportAuvenir,"Verify Element of Support Auvenir link", Element_Type.DISPLAYED);

        // Checking Signature footer
        NXGReports.addStep("Verify Signature footer", LogAs.PASSED, null);
        this.validateElememt(eleSignatureMail,"Verify Element of Signature footer", Element_Type.DISPLAYED);
    }

}
