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
public class PrivacyPolicyPage extends AbstractPage {

    public PrivacyPolicyPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    private String privacyPolicyTextContentCst = "Introduction\n" +
            "This Privacy Statement applies to the Auvenir.com website (the “Auvenir Site”) and all related software, mobile applications, documentation, services, products, and content (collectively, and together with the Auvenir Site, “Auvenir”)\n" +
            "When used in this Privacy Statement, “we,” “us,” and “our” refers to Auvenir, a general partnership formed under the laws of Canada. This Privacy Statement explains how we protect visitors’ information gathered via Auvenir. By using Auvenir you are agreeing to the use of your information as described in this Privacy Statement.\n" +
            "Auvenir may contain links to other sites which may not be governed by this privacy statement. We encourage users to review each website’s privacy statement before disclosing any personal information. If you have any questions regarding this Privacy Statement, please contact info@auvenir.com.\n" +
            "Information Collection\n" +
            "To use Auvenir, you must first complete a registration form and provide certain personal information to sign up for an Auvenir account. We only collect personal information that is specifically and voluntarily provided by you. Such information may consist of, but is not limited to, your name, email, phone number, position, organization, and profile photo.\n" +
            "We do not usually seek information relating to your race or ethnic origin, religious beliefs, criminal record, physical or mental health, or sexual orientation. We will, if applicable, obtain your explicit consent to collect and use such information in accordance with applicable laws.\n" +
            "Log Information, Cookies, and Web Beacons\n" +
            "Auvenir may collect standard internet log information including your IP address, browser type and language, access times, and referring website addresses. We may also automatically collect information about you such as your device type, mobile network, and version of the app being used.\n" +
            "Auvenir may use cookies (small text files stored in a user’s browser) to identify users when they connect to Auvenir. If Auvenir uses cookies, a user’s browser must be enabled to allow cookies in order to access Auvenir. Upon successful login, cookies are created and placed on the user’s computer or device. In addition to information related to authentication, information may be stored in the cookies in order to direct a user to the correct site location. To ensure that Auvenir is well managed and to facilitate improved navigation, we or our service providers may also use cookies or Web beacons (electronic images that allow the Website to count visitors who have accessed a particular page and to access certain cookies) to collect aggregate data. Additional information on how we use cookies and other tracking technologies and how you can control these can be found in our cookie notice. By using this Website, you agree that we can place cookies on your computer or device.\n" +
            "Most browsers can be set to inform you when a cookie has been sent to you and provide you with the opportunity to reject that cookie. However, refusing a cookie may, in some cases, preclude you from using, or negatively impact the display or function of, Auvenir or some of its areas or features.\n" +
            "Information Use\n" +
            "This Privacy Statement applies to the Auvenir.com website (the “Auvenir Site”) and all related software, mobile applications, documentation, services, products, and content (collectively, and together with the Auvenir Site, “Auvenir”)\n" +
            "When used in this Privacy Statement, “we,” “us,” and “our” refers to Auvenir, a general partnership formed under the laws of Canada. This Privacy Statement explains how we protect visitors’ information gathered via Auvenir. By using Auvenir you are agreeing to the use of your information as described in this Privacy Statement.\n" +
            "Auvenir may contain links to other sites which may not be governed by this privacy statement. We encourage users to review each website’s privacy statement before disclosing any personal information. If you have any questions regarding this Privacy Statement, please contact info@auvenir.com.\n" +
            "Disclosure of Information to Third Parties\n" +
            "Personal information may be disclosed to other Deloitte Network entities and other third parties in order to respond to your requests or inquiries, as part of a corporate transaction (such as a sale, divestiture, reorganization, merger or acquisition), or where those parties handle information on our behalf. All of these disclosures may involve the transfer of personal information to countries, regions, or areas where other Deloitte Network entities, our service providers, and other third parties are located, and these may not have data protection rules similar to those in effect in your area of residence. As used in this Privacy Statement, the “Deloitte Network” refers to Deloitte Touche Tohmatsu Limited, a UK private company limited by guarantee (“DTTL”), its network of member firms, and their related entities.\n" +
            "Personal information may also be disclosed to law enforcement, regulatory, or other government agencies, or to other third parties, in each case to comply with legal or regulatory obligations or requests.\n" +
            "By using or providing information through Auvenir, you are consenting to the disclosures described above.\n" +
            "Blogs, Forums, Wikis and Other Social Media\n" +
            "Auvenir may host or provide access to various blogs, forums, wikis, and other social media applications or services that allow you to share content with other users (collectively, “Social Media Applications”). Any personal information or other information that you contribute to any Social Media Application can be read, collected, and used by other users of that Social Media Application over whom we have little or no control. Therefore, we are not responsible for any other user’s use, misuse, or misappropriation of any personal information or other information that you contribute to any Social Media Application.\n" +
            "Access to Information\n" +
            "Visitors who choose to register on or with Auvenir may access their user profile, correct, and update their details, or unsubscribe from communications at any time. Visitors who have any problem accessing their profiles, or would like to request a copy of their personal information should contact webmaster services using the contact us link in Auvenir. In all cases we will treat requests to access information or change information in accordance with applicable legal requirements.\n" +
            "Information Security\n" +
            "We have in place reasonable commercial standards of technology and operational security to protect all information provided by visitors via Auvenir from unauthorized access, disclosure, alteration, or destruction.\n" +
            "Changes to Our Privacy Statement\n" +
            "We may modify or amend this Privacy Statement from time to time at our discretion. When we make changes to this Privacy Statement, we will amend the revision date at the top of this page, and such modified or amended Privacy Statement shall be effective as to you and your information as of that revision date. We encourage you to periodically review this Privacy Statement to be informed about how we are protecting your information.\n" +
            "Questions\n" +
            "If you have any questions or concerns regarding your privacy while using Auvenir, please send an email to info@auvenir.com.";
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[contains(text(),'Privacy Policy')]")
    private WebElement privacyHeaderText;
    @FindBy(xpath = ".//*[@id='privacy-page']//h1/div")
    private WebElement auvenirPrivacyPolicyText;
    @FindBy(xpath = ".//*[@id='privacy-page']//div[@class='ui text container privacy-content']")
    private WebElement privacyPolicyTextContent;
    public void verifyPrivacyPolicyContentPage(){
        getLogger().info("Verify privacy policy content page");
        boolean checkPrivacyPolicyTextContent = false;
        boolean checkAuvenirPrivacyText = false;
        boolean checkPrivacyHeaderText = false;
        boolean checkAuvenirLogoImage = false;
        checkAuvenirLogoImage = waitForVisibleElement(auvenirLogoImage,"auvenirImageLogo");
        waitForVisibleElement(privacyHeaderText,"privacyHeaderText");
        if(privacyHeaderText.getText().equals("Privacy Policy"))
        {
            checkPrivacyHeaderText = true;
        }
        waitForVisibleElement(auvenirPrivacyPolicyText,"auvenirPrivacyPolicyText");
        if(auvenirPrivacyPolicyText.getText().equals("Auvenir Privacy Policy"))
        {
            checkAuvenirPrivacyText = true;
        }
        waitForVisibleElement(privacyPolicyTextContent,"privacyPolicyTextContent");
        if(privacyPolicyTextContent.getText().equals(privacyPolicyTextContentCst))
        {
            checkPrivacyPolicyTextContent = true;
        }
        getLogger().info("privacyPolicyTextContent = " + privacyPolicyTextContent.getText());
        if(checkPrivacyPolicyTextContent & checkAuvenirPrivacyText & checkPrivacyHeaderText & checkAuvenirLogoImage)
        {
            NXGReports.addStep("Verify privacy policy content page", LogAs.PASSED, (CaptureScreen) null);
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify privacy policy content page", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
