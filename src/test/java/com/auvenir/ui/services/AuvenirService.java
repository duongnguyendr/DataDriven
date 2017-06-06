package com.auvenir.ui.services;

import com.auvenir.ui.pages.AuvenirPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Refactored by huy.huynh on 24/05/2017.
 * Restructure only
 */
public class AuvenirService extends AbstractService {
    AuvenirPage auvenirPage;

    public AuvenirService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
    }

    public void clickMessageBoxIcon() {
        auvenirPage.clickMessageBoxIcon();
    }

    public void clickNotiticationIcon() {
        auvenirPage.clickNotiticationIcon();
    }

    public void clickTermsOfServiceLink() {
        auvenirPage.clickTermsOfServiceLink();
    }

    public void verifyTermsOfServicePage() {
        auvenirPage.verifyTermsOfServicePage();
    }

    public void clickPrivacyStatementLink() {
        auvenirPage.clickPrivacyStatementLink();
    }

    public void verifyPrivacyStatementPage() {
        auvenirPage.verifyPrivacyStatementPage();
    }

    public void clickCookieNoticeLink() {
        auvenirPage.clickCookieNoticeLink();
    }

    public void verifyCookieNoticePage() {
        auvenirPage.verifyCookieNoticePage();
    }

    public void verifyPageLoad() {
        auvenirPage.verifyPageLoad();
    }

    public void inputEmailAndJoin(String email){
        auvenirPage.getEleAuditorEmailAddressTxtFld()
                .sendKeys(email);
        getLogger().info("click to regedit auditor user.");
        auvenirPage.getEleJoinBtn().click();
    }

    public void actionWithApprovalDialog(){
        auvenirPage.actionWithApprovalDialog();
    }
}
