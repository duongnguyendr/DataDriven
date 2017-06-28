package com.auvenir.ui.pages;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import htmlreport.com.nxgreport.NXGReports;
import htmlreport.com.nxgreport.logging.LogAs;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//import org.testng.log4testng.Logger;

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

    /**
     * Refactored by huy.huynh on 24/05/2017.
     * Restructure only
     */

    public void verifyHeader() {
        actions = new Actions(getDriver());
        validateDisPlayedElement(getEleAuvenirLogoImg(), "Auvenir Logo Image");
        validateDisPlayedElement(getEleUserNameTxt(), "User Name Text");
        actions.moveToElement(getEleUserNameDropDownImg()).release().perform();
        validateDisPlayedElement(getEleUserNameDropDownImg(), "User Name Drop Down Image");
        validateDisPlayedElement(getEleInboxImg(), "Inbox Image");
        validateDisPlayedElement(getEleNotificationImg(), "Notification Image");
        validateDisPlayedElement(getEleInitialsTxt(), "Initials Text");
        validateDisPlayedElement(getEleUsernameDropDownTxt(), "User Name Drop Down Text");
        validateDisPlayedElement(getEleSettingsLnk(), "Settings Link");
        validateDisPlayedElement(getEleSignOutLnk(), "Sign Out Link");
        actions.moveToElement(getEleAuvenirLogoImg()).release().perform();
    }

    public void verifyFooter() {
        try {
            if (getEleCareersImg().isDisplayed()) {
                validateDisPlayedElement(getEleCareersImg(), "Careers Image");
                validateDisPlayedElement(getEleCareersLnk(), "Careers link");
                validateDisPlayedElement(getEleSupportImg(), "Support Image");
                validateDisPlayedElement(getEleSupportLnk(), "Support Link");
                validateDisPlayedElement(getEleLocatorImg(), "Locator Image");
                validateDisPlayedElement(getEleTorontoCanadaLnk(), "Toronto Canada location Link");
                validateDisPlayedElement(getElePhoneImg(), "Phone Image");
                validateDisPlayedElement(getElePhoneNumberLnk(), "Phone number Link");
                validateDisPlayedElement(getEleTermsOfServiceFtrLnk(), "Terms of Service - Link");
                validateDisPlayedElement(getElePrivacyStatementFtrLnk(), "Privacy Statement - Link");
                validateDisPlayedElement(getEleCookieFtrLnk(), "Cookie Notice footer - Link");

                validateDisPlayedElement(getEleFacebookImg(), "Facebook Image");
                validateDisPlayedElement(getEleTwitterImg(), "Twitter Image");
                validateDisPlayedElement(getEleLinkedinImg(), "Linkedin Image");
            }
        } catch (Exception e) {
            validateDisPlayedElement(getEleTermsOfUserFtrLnk(), "Terms of Use footer - Link");
            validateDisPlayedElement(getElePrivacyPolicyFtrLnk(), "Privacy Policy footer - Link");
            validateDisPlayedElement(getEleCookieNoticeFtrLnk(), "Cookie Notice footer - link");
        }
        validateDisPlayedElement(getEleAllRightsReservedTxt(), "All Rights Reserversd - Text");
    }

    public void verifyBodyLoginPage() {
        validateDisPlayedElement(getEleAuvenirImg(), "Auvenir Header Logo Image");
        validateDisPlayedElement(getEleAuditorLoginLnk(), "Auditor Login Link");
        validateDisPlayedElement(getEleAuditorLoginImg(), "Auditor Login Image");
        validateDisPlayedElement(getEleWeHelpYouAuditTxt(), "We help you audit Text");
        validateDisPlayedElement(getEleJoinTheWaitlistTxt(), "Join the Waitlist Text");
        validateDisPlayedElement(getEleWorkEmailTxt(), "Work Email Text");
        validateDisPlayedElement(getEleAuditorEmailAddressTxtFld(), "Auditor Email Address Text Field");
        validateEnabledElement(getEleJoinBtn(), "Join Button");
        validateDisPlayedElement(getEleBySigningUpTxt(), "By signing up, you agree to our Terms of Use and Privacy Poclicy - Text");
        validateDisPlayedElement(getEleSpendLessTimeClockImg(), "Spend Less Time Clock Image");
        validateDisPlayedElement(getEleSpendLessTimeTxt(), "Spend Less Time Clock Text");
        validateDisPlayedElement(getEleUseSophisticatedTxt(), "Use Sophisticated Text");
        validateDisPlayedElement(getEleDevelopDeeperImg(), "Develop Deeper Image");
        validateDisPlayedElement(getEleDevelopDeeperTxt(), "Develop Deeper Text");
        validateDisPlayedElement(getEleLeverageMachineTxt(), "Leverage Machine Text");
        validateDisPlayedElement(getEleSecurelyManageImg(), "Securely Manage Image");
        validateDisPlayedElement(getEleSecurelyManageTxt(), "Securely Manage Text");
        validateDisPlayedElement(getEleAccessACloudTxt(), "Access a cloud Text");
        validateDisPlayedElement(getElePersonalizedForYouImg(), "Personalized for you Image");
        validateDisPlayedElement(getElePersonalizedForYouTxt(), "Personalized for you Text");
        validateDisPlayedElement(getEleCustomizeSchedulesTxt(), "Customize Schedules Text");
        validateDisPlayedElement(getEleAccessAndManageTxt(), "Access and Manage Text");
        validateDisPlayedElement(getEleStoreAllTxt(), "Store All Text");
        validateDisPlayedElement(getEleAuvenirFooterImg(), "Auvenir Footer Image");
    }

    public void verifyFormLogin() {
        clickElement(getEleAuditorLoginLnk(), "Auditor Login Link");
        validateDisPlayedElement(getEleEmailAddressTxt(), "Email Address Text");
        validateDisPlayedElement(getEleEmailAddressPopUpTxtFld(), "Email Address PopUp Text Field");
        validateEnabledElement(getEleGoBtn(), "Go Button");
    }

    public void verifyLoginWithEmail(String email) {
        sendKeyTextBox(getEleEmailAddressPopUpTxtFld(), email, "Email Address PopUp Text Field");
        clickElement(getEleGoBtn(), "Go Button");
        waitForVisibleElement(getEleWaitVerificationTxt(), "Your email is awaiting verification");
        sendKeyTextBox(getEleAuditorEmailAddressTxtFld(), "auvaudit", "Auditor Email Address Text Field");
        sendKeyTextBox(getEleAuditorEmailAddressTxtFld(), email, "Auditor Email Address Text Field");
        getEleJoinBtn().click();
    }

    public void verifyApprovePopupDisplayed() {
        boolean isPopupDisplayed = false;
        isPopupDisplayed = validateDisPlayedElement(getEleAwaitingApprovalTxt(), "Approve popup");
        if (isPopupDisplayed) {
            NXGReports.addStep("Awaiting approval popup is successfully displayed.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Awaiting approval popup is successfully displayed", LogAs.FAILED, null);
        }
        clickElement(getEleDoneBtn(), "Awaiting Approval popup");
    }

    public void verifyFooterPage() {
        validateDisPlayedElement(getEleTermsOfUserFtrLnk(), "Terms of Service - Link");
        validateDisPlayedElement(getElePrivacyPolicyFtrLnk(), "Privacy Statement - Link");
        validateDisPlayedElement(getEleCookieNoticeFtrLnk(), "Cookie Notice footer - Link");
        validateDisPlayedElement(getEleAllRightsReservedTxt(), "All Rights Reserversd - Text");
    }

    public void clickMessageBoxIcon() {
        visibilityOfElementWait(getEleInboxImg(), "Inbox Icon", 20);
        getEleInboxImg().click();
    }

    public void clickNotiticationIcon() {
        visibilityOfElementWait(getEleNotificationImg(), "Inbox Icon", 20);
        getEleNotificationImg().click();
    }

    public void clickTermsOfServiceLink() {
        getEleTermsOfUserFtrLnk().click();
    }

    public void verifyTermsOfServicePage() {
        validateDisPlayedElement(getEleTOSTitleTxt(), "Terms of Service - Text");
        validateDisPlayedElement(getEleEnglishFrenchTxt(), "English French - Text");
        validateDisPlayedElement(getEleEffectiveTxt(), "Effective: 16th Jan  - Text");
        validateDisPlayedElement(getEleTheseTermsTxt(), "These terms of service  - Text");
        validateDisPlayedElement(getEleContactInfoLnk(), "Contact info@auvenir.com - Link");
        validateDisPlayedElement(getEleVisitDeloitteLnk(), "Visit DEloitte - Link");
        validateDisPlayedElement(getElePrivacyStatementLnk(), "Privacy Statement - Link");
    }

    public void clickPrivacyStatementLink() {
        getElePrivacyPolicyFtrLnk().click();
    }

    public void verifyPrivacyStatementPage() {
        validateDisPlayedElement(getElePrivacyTitleTxt(), "Privacy Statement - Title");
        validateDisPlayedElement(getEleEnglishFrenchTxt(), "English French - Text");
        validateDisPlayedElement(getEleLastRevisedTxt(), "Last Revised - Text");
        validateDisPlayedElement(getEleContactInfoLnk(), "Contact info@auvenir.com - Link");
        validateDisPlayedElement(getElePrivacyTOSLnk(), "Privacy - TOS - Link");
        validateDisPlayedElement(getElePrivacyCookiesLnk(), "Privacy Cookies - Link");
    }

    public void clickCookieNoticeLink() {
        getEleCookieNoticeFtrLnk().click();
    }

    public void verifyCookieNoticePage() {
        validateDisPlayedElement(getEleCookieNoticeTitleTxt(), "Cookie Notice - Title");
        validateDisPlayedElement(getEleEnglishFrenchTxt(), "English French - Text");
        validateDisPlayedElement(getEleLastRevisedTxt(), "Last Revised - Text");
        validateDisPlayedElement(getEleAuvenirUsesTxt(), "Last Revised - Text");
        validateDisPlayedElement(getEleContactInfoLnk(), "Contact info@auvenir.com - Link");
        validateDisPlayedElement(getElePrivacyStatementLnk(), "Privacy Statement - Link");
        validateDisPlayedElement(getEleAboutCookiesLnk(), "About Cookies - Link");
    }
    /*-----------end of huy.huynh on 24/05/2017.*/

    /**
     * TanPham 29/05/2017 - Start
     */

    public void clickOnCareerLink() {
        waitForVisibleElement(eleCareersLnk, "career link");
        hoverElement(eleCareersLnk, "career link");
        clickElement(eleCareersLnk, "carrer link");
    }

    public void verifyAuvenirImage() {
        waitForVisibleElement(eleAuvenirImg, "career link");
    }

    public void clickOnSupportLink() {
        waitForVisibleElement(eleSupportLnk, "support link");
        hoverElement(eleSupportLnk, "support link");
        clickElement(eleSupportLnk, "support link");
    }

    /**
     * TanPham 29/05/2017 - End
     */

    public void verifyWelcomePleaseCheckTxtIsDisplayed() {
        getLogger().info("Verify Welcome Please Check Text is displayed.");
        waitForVisibleElement(eleWelcomePleaseCheckTxt, "Welcome! Please check your email for a login popup is not displayed");
        validateDisPlayedElement(eleWelcomePleaseCheckTxt, "Welcome! Please check your email for a login popup is not displayed");
        validateElementText(eleWelcomePleaseCheckTxt, "Welcome! Please check your email for a login link.");
    }

    /**
     * Refactored by huy.huynh on 30/05/2017.
     * Restructure only
     */

    @FindBy(id = "audLand-modal-loginHeader")
    private WebElement titleApproval;

    /**
     * verify page loaded
     */
    public void verifyPageLoad() {
        validateDisPlayedElement(getEleAuditorEmailAddressTxtFld(), "Join email");
    }

    /**
     * join action
     */
    public void inputEmailAndJoin(String email) {
        getEleAuditorEmailAddressTxtFld()
                .sendKeys(email);
        getLogger().info("click to regedit auditor user.");
        getEleJoinBtn().click();
    }

    /**
     * Check dialog and click done
     */
    public void actionWithApprovalDialog() {
        /*visibilityOfElementWait(getEleAwaitingApprovalTxt(), "Awaiting Approval", 20);
        visibilityOfElementWait(getEleDoneBtn(), "Approval Done Button", 20);*/
        try {
            /*TODO temproryly
            Thread.sleep(2000);
            System.out.println("Value Awaiting: " + getDriver().findElement(By.id("audLand-modal-loginHeader")).getAttribute("value"));
            validateElementText(getDriver().findElement(By.id("audLand-modal-loginHeader")), "Awaiting approval!");*/
            waitForTextValueChanged(titleApproval, "Awaiting approval", "Awaiting approval!");
            getEleDoneBtn().click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*-----------end of huy.huynh on 30/05/2017.*/
}
