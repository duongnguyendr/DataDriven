package com.auvenir.ui.pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractRefactorService;
import com.auvenir.utilities.GeneralUtilities;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class AuvenirPage extends AbstractPage {
    Actions actions = null;

    public AuvenirPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//img[@class='header-auvenirLogo']")
    private WebElement eleAuvenirLogoImg;

    public WebElement getEleAuvenirLogoImg() {
        return eleAuvenirLogoImg;
    }

    @FindBy(xpath = "//img[@id='headerLogo']")
    private WebElement eleAuvenirImg;

    public WebElement getEleAuvenirImg() {
        return eleAuvenirImg;
    }

    @FindBy(id = "dashboardUsername")
    private WebElement eleUserNameTxt;

    public WebElement getEleUserNameTxt() {
        return eleUserNameTxt;
    }

    @FindBy(xpath = "//span[@id='dashboardUsername']//..//i")
    private WebElement eleUserNameDropDownImg;

    public WebElement getEleUserNameDropDownImg() {
        return eleUserNameDropDownImg;
    }

    @FindBy(xpath = "//div[@id='h-f-inbox-dropdown']")
    private WebElement eleInboxImg;

    public WebElement getEleInboxImg() {
        return eleInboxImg;
    }

    @FindBy(xpath = "//div[@class='au-dropdown-trigger notification-trigger']")
    private WebElement eleNotificationImg;

    public WebElement getEleNotificationImg() {
        return eleNotificationImg;
    }


    @FindBy(xpath = "//span[@id='dropdownPicInitials']")
    private WebElement eleInitialsTxt;

    public WebElement getEleInitialsTxt() {
        return eleInitialsTxt;
    }

    @FindBy(xpath = "//span[@id='dropdownUsername'][@class='au-dropdown-username']")
    private WebElement eleUsernameDropDownTxt;

    public WebElement getEleUsernameDropDownTxt() {
        return eleUsernameDropDownTxt;
    }

    @FindBy(xpath = "//a[text()='Settings']")
    private WebElement eleSettingsLnk;

    public WebElement getEleSettingsLnk() {
        return eleSettingsLnk;
    }

    @FindBy(xpath = "//a[text()='Sign Out']")
    private WebElement eleSignOutLnk;

    public WebElement getEleSignOutLnk() {
        return eleSignOutLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Careers')]//span")
    private WebElement eleCareersImg;

    public WebElement getEleCareersImg() {
        return eleCareersImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    private WebElement eleCareersLnk;

    public WebElement getEleCareersLnk() {
        return eleCareersLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Support')]//span")
    private WebElement eleSupportImg;

    public WebElement getEleSupportImg() {
        return eleSupportImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Support')]")
    private WebElement eleSupportLnk;

    public WebElement getEleSupportLnk() {
        return eleSupportLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Toronto, ON, Canada')]//span")
    private WebElement eleLocatorImg;

    public WebElement getEleLocatorImg() {
        return eleLocatorImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Toronto, ON, Canada')]")
    private WebElement eleTorontoCanadaLnk;

    public WebElement getEleTorontoCanadaLnk() {
        return eleTorontoCanadaLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'+1-855-528-8364')]//span")
    private WebElement elePhoneImg;

    public WebElement getElePhoneImg() {
        return elePhoneImg;
    }

    @FindBy(xpath = "//a[contains(text(),'+1-855-528-8364')]")
    private WebElement elePhoneNumberLnk;

    public WebElement getElePhoneNumberLnk() {
        return elePhoneNumberLnk;
    }

    @FindBy(xpath = "//a[@href='https://www.facebook.com/auvenir']")
    private WebElement eleFacebookImg;

    public WebElement getEleFacebookImg() {
        return eleFacebookImg;
    }

    @FindBy(xpath = "//a[@href='https://twitter.com/auvenir']")
    private WebElement eleTwitterImg;

    public WebElement getEleTwitterImg() {
        return eleTwitterImg;
    }

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/10419712']")
    private WebElement eleLinkedinImg;

    public WebElement getEleLinkedinImg() {
        return eleLinkedinImg;
    }

    @FindBy(xpath = "//span[contains(text(),'Auvenir Inc. All rights reserved.')]")
    private WebElement eleAllRightsReservedTxt;

    public WebElement getEleAllRightsReservedTxt() {
        return eleAllRightsReservedTxt;
    }

    @FindBy(xpath = "//div[@class='pull-left']//a[@href='/terms']")
    private WebElement eleTermsOfServiceFtrLnk;

    public WebElement getEleTermsOfServiceFtrLnk() {
        return eleTermsOfServiceFtrLnk;
    }

    @FindBy(xpath = "//div[@class='pull-left']//a[@href='/privacy']")
    private WebElement elePrivacyStatementFtrLnk;

    public WebElement getElePrivacyStatementFtrLnk() {
        return elePrivacyStatementFtrLnk;
    }

    @FindBy(xpath = "//div[@class='pull-left']//a[@href='/cookies']")
    private WebElement eleCookieFtrLnk;

    public WebElement getEleCookieFtrLnk() {
        return eleCookieFtrLnk;
    }

    @FindBy(xpath = "//div[@class='pull-right']//a[@href='/terms']")
    private WebElement eleTermsOfUserFtrLnk;

    public WebElement getEleTermsOfUserFtrLnk() {
        return eleTermsOfUserFtrLnk;
    }

    @FindBy(xpath = "//div[@class='pull-right']//a[@href='/privacy']")
    private WebElement elePrivacyPolicyFtrLnk;

    public WebElement getElePrivacyPolicyFtrLnk() {
        return elePrivacyPolicyFtrLnk;
    }

    @FindBy(xpath = "//div[@class='pull-right']//a[@href='/cookies']")
    private WebElement eleCookieNoticeFtrLnk;

    public WebElement getEleCookieNoticeFtrLnk() {
        return eleCookieNoticeFtrLnk;
    }


    @FindBy(xpath = "//h2[@class='terms-title'][text()=' Terms of Service ']")
    private WebElement eleTOSTitleTxt;

    public WebElement getEleTOSTitleTxt() {
        return eleTOSTitleTxt;
    }

    @FindBy(xpath = "//div[@id='agreement']/h3[text()='Effective: 16th January, 2017']")
    private WebElement eleEffectiveTxt;

    public WebElement getEleEffectiveTxt() {
        return eleEffectiveTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'These Terms of Service')]")
    private WebElement eleTheseTermsTxt;

    public WebElement getEleTheseTermsTxt() {
        return eleTheseTermsTxt;
    }

    @FindBy(xpath = "//a[@href='mailto:info@auvenir.com']")
    private WebElement eleContactInfoLnk;

    public WebElement getEleContactInfoLnk() {
        return eleContactInfoLnk;
    }

    @FindBy(xpath = "//a[text()='deloitte.com/about']")
    private WebElement eleVisitDeloitteLnk;

    public WebElement getEleVisitDeloitteLnk() {
        return eleVisitDeloitteLnk;
    }

    @FindBy(xpath = "//a[@href='/privacy']")
    private WebElement elePrivacyStatementLnk;

    public WebElement getElePrivacyStatementLnk() {
        return elePrivacyStatementLnk;
    }

    @FindBy(xpath = "//a[@href='http://www.aboutcookies.org/']")
    private WebElement eleAboutCookiesLnk;

    public WebElement getEleAboutCookiesLnk() {
        return eleAboutCookiesLnk;
    }

    @FindBy(xpath = "//h2[@class='terms-title'][text()=' Privacy Statement ']")
    private WebElement elePrivacyTitleTxt;

    public WebElement getElePrivacyTitleTxt() {
        return elePrivacyTitleTxt;
    }

    @FindBy(xpath = "//a[@id='english']")
    private WebElement eleEnglishFrenchTxt;

    public WebElement getEleEnglishFrenchTxt() {
        return eleEnglishFrenchTxt;
    }

    @FindBy(xpath = "//div[@id='agreement']/h3[text()='Last revised: January 16th, 2017']")
    private WebElement eleLastRevisedTxt;

    public WebElement getEleLastRevisedTxt() {
        return eleLastRevisedTxt;
    }

    @FindBy(xpath = "//h3[text()='INTRODUCTION']")
    private WebElement eleIntroductionTxt;

    public WebElement getEleIntroductionTxt() {
        return eleIntroductionTxt;
    }

    @FindBy(xpath = "//a[@href='/cookies']")
    private WebElement elePrivacyCookiesLnk;

    public WebElement getElePrivacyCookiesLnk() {
        return elePrivacyCookiesLnk;
    }

    @FindBy(xpath = "//a[@href='/terms']")
    private WebElement elePrivacyTOSLnk;

    public WebElement getElePrivacyTOSLnk() {
        return elePrivacyTOSLnk;
    }

    @FindBy(xpath = "//p[contains(text(),'Auvenir uses cookies to improve')]")
    private WebElement eleAuvenirUsesTxt;

    public WebElement getEleAuvenirUsesTxt() {
        return eleAuvenirUsesTxt;
    }

    @FindBy(xpath = "//h2[@class='terms-title'][text()=' Cookie Notice ']")
    private WebElement eleCookieNoticeTitleTxt;

    public WebElement getEleCookieNoticeTitleTxt() {
        return eleCookieNoticeTitleTxt;
    }

    @FindBy(id = "audLand-loginBtn")
    private WebElement eleAuditorLoginLnk;

    public WebElement getEleAuditorLoginLnk() {
        return eleAuditorLoginLnk;
    }

    @FindBy(id = "aud-loginChevron")
    private WebElement eleAuditorLoginImg;

    public WebElement getEleAuditorLoginImg() {
        return eleAuditorLoginImg;
    }

    @FindBy(xpath = "//h1[contains(text(),'We help you audit ')]")
    private WebElement eleWeHelpYouAuditTxt;

    public WebElement getEleWeHelpYouAuditTxt() {
        return eleWeHelpYouAuditTxt;
    }

    @FindBy(xpath = "//h3[contains(text(),'Join the Waitlist')]")
    private WebElement eleJoinTheWaitlistTxt;

    public WebElement getEleJoinTheWaitlistTxt() {
        return eleJoinTheWaitlistTxt;
    }

    @FindBy(xpath = "//input[@placeholder='Type work email address']")
    private WebElement eleWorkEmailTxt;

    public WebElement getEleWorkEmailTxt() {
        return eleWorkEmailTxt;
    }

    @FindBy(id = "emailField")
    private WebElement eleAuditorEmailAddressTxtFld;

    public WebElement getEleAuditorEmailAddressTxtFld() {
        return eleAuditorEmailAddressTxtFld;
    }

    @FindBy(xpath = "//li[text()='Not a valid email address']")
    private WebElement eleNotValidEmailTxt;

    public WebElement getEleNotValidEmailTxt() {
        return eleNotValidEmailTxt;
    }

    //@FindBy(id="audLandMainBtn")
    @FindBy(xpath = "//button[contains(text(),'Join')]")
    private WebElement eleJoinBtn;

    public WebElement getEleJoinBtn() {
        return eleJoinBtn;
    }

    /*@FindBy(xpath="//p[contains(text(),'Have a')]")
    private WebElement eleHaveAQuestionTxt;
    public WebElement getEleHaveAQuestionTxt(){
        return eleHaveAQuestionTxt;
    }*/
    @FindBy(xpath = "//p[@class='audLand-jb-footTxt']")
    private WebElement eleBySigningUpTxt;

    public WebElement getEleBySigningUpTxt() {
        return eleBySigningUpTxt;
    }
    /*@FindBy(xpath="//p[@class='audLand-jb-footTxt']//a[@href='/termsandconditions']")
    private WebElement eleTermsofUseLnk;
	public WebElement getEleTermsofUseLnk(){
		return eleTermsofUseLnk;
	}
	@FindBy(xpath="//p[@class='audLand-jb-footTxt']//a[@href='/privacypolicy']")
	private WebElement elePrivacyPolicyLnk;
	public WebElement getElePrivacyPolicyLnk(){
		return elePrivacyPolicyLnk;
	}
		
	@FindBy(xpath="//a[contains(text(),'Get in touch!')]")
	private WebElement eleGetInTouchLnk;
	public WebElement getEleGetInTouchLnk(){
		return eleGetInTouchLnk;
	}*/

    @FindBy(xpath = "//img[@src='images/timeClock.svg']")
    private WebElement eleSpendLessTimeClockImg;

    public WebElement getEleSpendLessTimeClockImg() {
        return eleSpendLessTimeClockImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Spend Less Time')]")
    private WebElement eleSpendLessTimeTxt;

    public WebElement getEleSpendLessTimeTxt() {
        return eleSpendLessTimeTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Use sophisticated')]")
    private WebElement eleUseSophisticatedTxt;

    public WebElement getEleUseSophisticatedTxt() {
        return eleUseSophisticatedTxt;
    }

    @FindBy(xpath = "//img[@src='images/graphCut.svg']")
    private WebElement eleDevelopDeeperImg;

    public WebElement getEleDevelopDeeperImg() {
        return eleDevelopDeeperImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Develop Deeper')]")
    private WebElement eleDevelopDeeperTxt;

    public WebElement getEleDevelopDeeperTxt() {
        return eleDevelopDeeperTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Leverage machine')]")
    private WebElement eleLeverageMachineTxt;

    public WebElement getEleLeverageMachineTxt() {
        return eleLeverageMachineTxt;
    }

    @FindBy(xpath = "//img[@src='images/blackLock.svg']")
    private WebElement eleSecurelyManageImg;

    public WebElement getEleSecurelyManageImg() {
        return eleSecurelyManageImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Securely Manage')]")
    private WebElement eleSecurelyManageTxt;

    public WebElement getEleSecurelyManageTxt() {
        return eleSecurelyManageTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Access a cloud')]")
    private WebElement eleAccessACloudTxt;

    public WebElement getEleAccessACloudTxt() {
        return eleAccessACloudTxt;
    }

    @FindBy(xpath = "//img[@src='images/featuresTech.svg']")
    private WebElement elePersonalizedForYouImg;

    public WebElement getElePersonalizedForYouImg() {
        return elePersonalizedForYouImg;
    }

    @FindBy(xpath = "//h2[contains(text(),'Personalized for you')]")
    private WebElement elePersonalizedForYouTxt;

    public WebElement getElePersonalizedForYouTxt() {
        return elePersonalizedForYouTxt;
    }

    @FindBy(xpath = "//li[contains(text(),'Customize Schedules')]")
    private WebElement eleCustomizeSchedulesTxt;

    public WebElement getEleCustomizeSchedulesTxt() {
        return eleCustomizeSchedulesTxt;
    }

    @FindBy(xpath = "//li[contains(text(),'Access and Manage')]")
    private WebElement eleAccessAndManageTxt;

    public WebElement getEleAccessAndManageTxt() {
        return eleAccessAndManageTxt;
    }

    @FindBy(xpath = "//li[contains(text(),'Store All ')]")
    private WebElement eleStoreAllTxt;

    public WebElement getEleStoreAllTxt() {
        return eleStoreAllTxt;
    }

    @FindBy(xpath = "//img[@id='footerLogo'][@src='images/logo.svg']")
    private WebElement eleAuvenirFooterImg;

    public WebElement getEleAuvenirFooterImg() {
        return eleAuvenirFooterImg;
    }

	/*@FindBy(xpath="//a[contains(text(),'Join as a business')]")
	private WebElement eleJoinAsABusinessLnk;
	public WebElement getEleJoinAsABusinessLnk(){
		return eleJoinAsABusinessLnk;
	}
		
	@FindBy(xpath="//a[contains(text(),'Join as an auditor')]")
	private WebElement eleJoinAsAnAuditorLnk;
	public WebElement getEleJoinAsAnAuditorLnk(){
		return eleJoinAsAnAuditorLnk;
	}*/


    @FindBy(id = "intercom-container-body")
    private WebElement eleIntercomLauncherIcn;

    public WebElement getEleIntercomLauncherIcn() {
        return eleIntercomLauncherIcn;
    }


    @FindBy(xpath = "//img[@src='images/illustrations/login.svg']")
    private WebElement eleMailImg;

    public WebElement getEleMailImg() {
        return eleMailImg;
    }

    @FindBy(xpath = "//h2[contains(text(),'Check your')]")
    private WebElement eleCheckYourEmailTxt;

    public WebElement getEleCheckYourEmailTxt() {
        return eleCheckYourEmailTxt;
    }


    @FindBy(xpath = "//h2[contains(text(),'Awaiting approval!')]")
    private WebElement eleAwaitingApprovalTxt;

    public WebElement getEleAwaitingApprovalTxt() {
        return eleAwaitingApprovalTxt;
    }

    @FindBy(xpath = "//h4[contains(text(),'We sent')]")
    private WebElement eleWeSentTxt;

    public WebElement getEleWeSentTxt() {
        return eleWeSentTxt;
    }

    @FindBy(id = "audLandModalDoneBtn")
    private WebElement eleDoneBtn;

    public WebElement getEleDoneBtn() {
        return eleDoneBtn;
    }

    @FindBy(xpath = "//h3[contains(text(),'Welcome! Please check')]")
    private WebElement eleWelcomePleaseCheckTxt;

    public WebElement getEleWelcomePleaseCheckTxt() {
        return eleWelcomePleaseCheckTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'Your email is awaiting verification')]")
    private WebElement eleWaitVerificationTxt;

    public WebElement getEleWaitVerificationTxt() {
        return eleWaitVerificationTxt;
    }

    @FindBy(xpath = "//h3[contains(text(),'Welcome! Please check')]//..//..//button[contains(text(),'×')]")
    private WebElement eleCloseBtn;

    public WebElement getEleCloseBtn() {
        return eleCloseBtn;
    }

    @FindBy(xpath = "//input[@id='audLand-emailField-top']//..//..//span[contains(text(),'Email Address')]")
    private WebElement eleEmailAddressTxt;

    public WebElement getEleEmailAddressTxt() {
        return eleEmailAddressTxt;
    }

    @FindBy(id = "audLand-emailField-top")
    private WebElement eleEmailAddressPopUpTxtFld;

    public WebElement getEleEmailAddressPopUpTxtFld() {
        return eleEmailAddressPopUpTxtFld;
    }

    @FindBy(id = "audLand-dd-loginBtn")
    private WebElement eleGoBtn;

    public WebElement getEleGoBtn() {
        return eleGoBtn;
    }

    public void verifyHeader() {
        actions = new Actions(getDriver());
        GeneralUtilities.toValidate(getEleAuvenirLogoImg(), "Auvenir Logo Image", "Displayed");
        GeneralUtilities.toValidate(getEleUserNameTxt(), "User Name Text", "Displayed");
        actions.moveToElement(getEleUserNameDropDownImg()).release().perform();
        GeneralUtilities.toValidate(getEleUserNameDropDownImg(), "User Name Drop Down Image", "Displayed");
        GeneralUtilities.toValidate(getEleInboxImg(), "Inbox Image", "Displayed");
        GeneralUtilities.toValidate(getEleNotificationImg(), "Notification Image", "Displayed");
        GeneralUtilities.toValidate(getEleInitialsTxt(), "Initials Text", "Displayed");
        GeneralUtilities.toValidate(getEleUsernameDropDownTxt(), "User Name Drop Down Text", "Displayed");
        GeneralUtilities.toValidate(getEleSettingsLnk(), "Settings Link", "Displayed");
        GeneralUtilities.toValidate(getEleSignOutLnk(), "Sign Out Link", "Displayed");
        actions.moveToElement(getEleAuvenirLogoImg()).release().perform();
    }

    public void verifyFooter() {
        try {
            if (getEleCareersImg().isDisplayed()) {
                GeneralUtilities.toValidate(getEleCareersImg(), "Careers Image", "Displayed");
                GeneralUtilities.toValidate(getEleCareersLnk(), "Careers link", "Displayed");
                GeneralUtilities.toValidate(getEleSupportImg(), "Support Image", "Displayed");
                GeneralUtilities.toValidate(getEleSupportLnk(), "Support Link", "Displayed");
                GeneralUtilities.toValidate(getEleLocatorImg(), "Locator Image", "Displayed");
                GeneralUtilities.toValidate(getEleTorontoCanadaLnk(), "Toronto Canada location Link", "Displayed");
                GeneralUtilities.toValidate(getElePhoneImg(), "Phone Image", "Displayed");
                GeneralUtilities.toValidate(getElePhoneNumberLnk(), "Phone number Link", "Displayed");
                GeneralUtilities.toValidate(getEleTermsOfServiceFtrLnk(), "Terms of Service - Link", "Displayed");
                GeneralUtilities.toValidate(getElePrivacyStatementFtrLnk(), "Privacy Statement - Link", "Displayed");
                GeneralUtilities.toValidate(getEleCookieFtrLnk(), "Cookie Notice footer - Link", "Displayed");


                GeneralUtilities.toValidate(getEleFacebookImg(), "Facebook Image", "Displayed");
                GeneralUtilities.toValidate(getEleTwitterImg(), "Twitter Image", "Displayed");
                GeneralUtilities.toValidate(getEleLinkedinImg(), "Linkedin Image", "Displayed");

            }
        } catch (Exception e) {
            GeneralUtilities.toValidate(getEleTermsOfUserFtrLnk(), "Terms of Use footer - Link", "Displayed");
            GeneralUtilities.toValidate(getElePrivacyPolicyFtrLnk(), "Privacy Policy footer - Link", "Displayed");
            GeneralUtilities.toValidate(getEleCookieNoticeFtrLnk(), "Cookie Notice footer - link", "Displayed");

        }

        GeneralUtilities.toValidate(getEleAllRightsReservedTxt(), "All Rights Reserversd - Text", "Displayed");

    }
}
