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
public class CookieNoticePage extends AbstractPage {

    public CookieNoticePage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[@class='ui text container cookie-banner']")
    private WebElement cookiesNoticeText;
    @FindBy(xpath = ".//*[@id='cookie-page']//h1/div")
    private WebElement auvenirCookieNoticeText;
    @FindBy(xpath = ".//*[@id='cookie-page']//div[@class='ui text container cookie-content']")
    private WebElement ookiesNoticecontentText;
    private String cookiesNoticeTextCst = "Cookie Notice";
    private String auvenirCookieText = "Auvenir Cookie Notice";
    private String auvenirCookiesNoticeTextCst = "Auvenir uses cookies to improve the user experience and ensure that it is functioning effectively.\n" +
            "This Cookie Notice is part of our Privacy Statement. For more information about us, and how we protect visitor information, please see our Privacy Statement.\n" +
            "In order to provide you with a more personalized and responsive service we need to remember and store information about how you use Auvenir. This is done using small text files called cookies. Cookies contain small amounts of information and are downloaded to your computer or other device by a server for Auvenir. Your web browser then sends these cookies back to Auvenir on each subsequent visit so that it can recognize you and remember things like your user preferences. You can find more detailed information about cookies and how they work at http://www.aboutcookies.org/.\n" +
            "Whenever you use Auvenir, information may be collected through the use of cookies and other technologies. By using Auvenir you agree to our use of cookies as described in this Cookie Notice and also to the use of cookies on the other country, regional or practice specific websites contained in deloitte.com that you may visit, as described in their accompanying cookie notices.\n" +
            "What Cookies Do We Use and Why?\n" +
            "Some of the cookies we use are necessary to enable you to move around Auvenir and use its features such as accessing secure areas that may contain content for registered users.\n" +
            "We also use functional cookies to record information about the choices you have made and to allow us to tailor the site to our users; for example, to remember your language or region or that you have already completed a survey. This information is usually anonymized and is not used for any other purpose.\n" +
            "We or our service providers also use analytic services to help us understand how effective our content is, what interests our users have, and to improve how Auvenir works. In addition, we use web beacons or tracking pixels to count visitor numbers and performance cookies to track how many individual users access Auvenir and how often. This information is used for statistical purposes only and it is not our intention to use such information to personally identify any user. However, if you have registered and signed into Auvenir we may combine this information with information from our web analytic services and cookies to analyze how you use Auvenir in more detail.\n" +
            "Auvenir does not use Targeting Cookies to deliver targeted advertising to visitors.\n" +
            "Please contact us at info@auvenir.com if you would like more detailed information on the cookies we use.\n" +
            "How To Control Cookies\n" +
            "By using Auvenir you agree that we can place cookies on your computer or device as explained above. However, you can control and manage cookies in various ways. Please bear in mind that removing or blocking cookies can impact on your user experience and parts of Auvenir may no longer be fully accessible.\n" +
            "Browser Controls\n" +
            "Most browsers will allow you to see what cookies you have and delete them on an individual basis or block cookies from particular or all websites. Be aware that any preference you have set will be lost if you delete all cookies, including your preference to opt-out from cookies as this itself requires an opt-out cookie to have been set. For more information on how to modify your browser settings to block or filter cookies, see http://www.aboutcookies.org/ or http://www.cookiecentral.com/faq/.\n" +
            "Managing Analytics cookies\n" +
            "You can opt-out of having your anonymized browsing activity within websites recorded by analytics cookies. We use the following service providers and you can learn more about their privacy policies and how to opt-out of their cookies by clicking on following links:\n" +
            "Adobe: http://www.adobe.com/privacy/opt-out.html\n" +
            "Google Analytics: http://www.google.com/analytics/learn/privacy.html\n" +
            "Managing Local Shared Objects or Flash Cookies\n" +
            "A local shared object or flash cookie is like most other browser cookies except that it can store additional types of information. These cookies cannot be controlled using the mechanisms listed above. Some parts of Auvenir use these types of cookies to store user preferences for media player functionality and without them some video content may not play properly. These cookies can be controlled manually by visiting the Adobe website.\n" +
            "http://www.macromedia.com/support/documentation/en/flashplayer/help/settings_manager07.html\n" +
            "Social Buttons\n" +
            "We use ‘social buttons’ to enable our users to share or bookmark web pages. These are buttons for third party social media sites and these sites may log information about your activities on the Internet including on Auvenir. Please review the respective terms of service and privacy statement of these sites to understand exactly how they use your information and to find out how to opt-out, or delete, such information.\n" +
            "External Web Services\n" +
            "We sometimes use external web services on Auvenir to display content within the web pages of Auvenir, for example to display images, show videos or run polls. As with the social buttons, we cannot prevent these sites, or external domains, from collecting information on your use of this embedded content.\n" +
            "Email Communications\n" +
            "We may also use tracking technologies to determine whether you have read, clicked on, or forwarded certain email communications we send to you so that we can make our communications more helpful and interesting. If you do not wish us to confirm whether you have opened, clicked on or forwarded our communications, you will need to unsubscribe, as it is not possible for us to send these emails without tracking enabled. Registered subscribers can update their communication preferences at any time by contacting us at info@auvenir.com, or you can unsubscribe following the instructions in the individual email communications you receive from us.\n" +
            "Changes To This Cookie Notice\n" +
            "We may modify or amend this Cookie Notice from time to time at our discretion. When we make changes to this notice, we will amend the revision date at the top of this page, and such modified or amended Cookie Notice shall be effective as to you and your information as of that revision date. We encourage you to periodically review this Cookie Notice to be informed about how we are using cookies.";
    public void verifyCookiesNoticeContentPage(){
        getLogger().info("Verify cookies notice content page");
        String strCookiesNotice = "";
        String strAuvenirCookieNotice = "";
        String strCookieNoticeContent = "";
        boolean checkCookiesNotie = false;
        boolean checkAuvenirCookiesNotice = false;
        boolean checkCookiesNoticecontent = false;
        boolean checkCookiesNoticeContentPage,checkCookiesNoticeContentPage1 = false;
        checkCookiesNoticeContentPage = waitForVisibleElement(auvenirLogoImage,"auvenirLogoImage");
        checkCookiesNoticeContentPage1 = waitForVisibleElement(cookiesNoticeText,"cookiesNoticeText");
        strCookiesNotice = cookiesNoticeText.getText();
        getLogger().info("strCookiesNotice = " + strCookiesNotice);
        if(strCookiesNotice.equals(cookiesNoticeTextCst))
        {
            checkCookiesNotie = true;
        }
        waitForVisibleElement(auvenirCookieNoticeText,"auvenirCookieNoticeText");
        strAuvenirCookieNotice = auvenirCookieNoticeText.getText();
        if(strAuvenirCookieNotice.equals(auvenirCookieText))
        {
            checkAuvenirCookiesNotice = true;
        }
        waitForVisibleElement(ookiesNoticecontentText,"ookiesNoticecontentText");
        strCookieNoticeContent = ookiesNoticecontentText.getText();
        getLogger().info("strCookieNoticeContent = " + strCookieNoticeContent);
        if(strCookieNoticeContent.equals(auvenirCookiesNoticeTextCst))
        {
            checkCookiesNoticecontent = true;
        }
        if(checkCookiesNoticeContentPage & checkCookiesNoticeContentPage1 & checkCookiesNotie & checkAuvenirCookiesNotice & checkCookiesNoticecontent)
        {
            NXGReports.addStep("Verify cookies notice content page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify cookies notice content page", LogAs.FAILED, (CaptureScreen) null);
        }
    }
}
