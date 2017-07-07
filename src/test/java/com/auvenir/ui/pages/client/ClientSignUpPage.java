package com.auvenir.ui.pages.client;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by huy.huynh on 14/06/2017.
 */
public class ClientSignUpPage extends AbstractPage {

    @FindBy(xpath = "//h3[@id='welcome-body']")
    private WebElement titleWelcome;

    @FindBy(id = "welcome-continueBtn")
    private WebElement buttonWelcomeContinue;

    @FindBy(xpath = "//div[@id='onboarding-personal-container']//h3")
    private WebElement titleComponentPersonal;

    @FindBy(xpath = "//div[@id='personal-role-container']//input")
    private WebElement inputPersonalRole;

    @FindBy(xpath = "//div[@id='personal-role-container']//a[1]")
    private WebElement optionFirstOnPersonalRoleList;

    @FindBy(id = "personal-phoneNumber")
    private WebElement inputPersonalPhoneNumber;

    @FindBy(id = "agreement-personal")
    private WebElement checkboxAgreementPersonal;

    @FindBy(id = "personal-coninueBtn")
    private WebElement buttonPersonalContinue;

    @FindBy(xpath = "//div[@id='onboarding-business-container']//h3")
    private WebElement titleComponentBusiness;

    @FindBy(xpath = "//p[@for='business-parentStakeholders']")
    private WebElement titleParentStakeholders;

    @FindBy(id = "business-parentStakeholders")
    private WebElement textAreaParentStakeholders;

    @FindBy(id = "business-industry")
    private WebElement inputIndustry;

    @FindBy(xpath = "//div[@id='business-industry-container']//a")
    private List<WebElement> listOptionIndustry;

    @FindBy(id = "accounting-framework")
    private WebElement inputAccountingFramework;

    @FindBy(xpath = "//div[@id='accounting-framework-container']//a")
    private List<WebElement> listOptionAccountingFramework;

    @FindBy(id = "onboard-business-continue")
    private WebElement buttonBusinessContinue;

    @FindBy(xpath = "//div[@id='onboarding-bank-container']//h3")
    private WebElement titleComponentBank;

    @FindBy(xpath = "//div[@id='onboarding-bank-container']//button[@class='auvbtn light']")
    private WebElement buttonBankSkip;

    @FindBy(xpath = "//div[@id='onboarding-files-container']//p[@class='component-title']")
    private WebElement titleComponentFiles;

    @FindBy(xpath = "//div[@id='onboarding-files-container']//button[contains(@id,'files-skipBtn')]")
    private WebElement buttonFilesSkip;

    @FindBy(xpath = "//div[@id='onboarding-security-container']//p[@class='component-title']")
    private WebElement titleComponentSecurity;

    @FindBy(id = "first-password")
    private WebElement inputCreatePassword;

    @FindBy(id = "second-password")
    private WebElement inputConfirmPassword;

    @FindBy(id = "security-continueBtn")
    private WebElement buttonSecurityContinue;

    @FindBy(xpath = "//div[@id='allClientEngagement']//span[@id='c-header-title']")
    private WebElement inputPersonalPhoneNumber82;

    public ClientSignUpPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void verifyWelcomePageTitle() {
        try {
            switchToOtherTab(1);
            validateElementText(titleWelcome, "Welcome to Auvenir!");
            getLogger().info("Welcome Page loaded.(Status change: Onboarding->Active)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void clickGetStartedButton() {
        try {
            getLogger().info("Start activating client");
            clickElement(buttonWelcomeContinue, "Button Get Started");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpPersonalForm(String phoneNumber) {
        try {
            getLogger().info("Fill Up Personal Form");
            validateElementText(titleComponentPersonal, "Please Confirm your Information");
            clickElement(inputPersonalRole, "Input Personal Role");
            clickElement(optionFirstOnPersonalRoleList, "First Option Personal Role");
            sendKeyTextBox(inputPersonalPhoneNumber, phoneNumber, "Input Personal Phone Number");
            clickElement(checkboxAgreementPersonal, "Checkbox Agreement Personal");
            clickElement(buttonPersonalContinue, "Button Personal Continue");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpBusinessForm(String parentStakeholders) {
        try {
            getLogger().info("Fill Up Business Form");
            validateElementText(titleComponentBusiness, "Please Confirm your Business Information");
            sendKeyTextBox(textAreaParentStakeholders, parentStakeholders, "Text Area Parent Stakeholders");
            scrollToFooter();
            clickElement(inputIndustry, "Input Industry");
            chooseFirstOptionOfInputSelect(listOptionIndustry, "List Option Industry");
            //sometime listoption not close after choose an option, so need to click somewhere to close, avoid it cover others element
            clickElement(titleParentStakeholders);
            clickElement(inputAccountingFramework, "Input Accounting Framework");
            chooseFirstOptionOfInputSelect(listOptionAccountingFramework, "List Option Accounting Framework");
            clickElement(titleParentStakeholders);
            clickElement(buttonBusinessContinue, "Button Business Continue");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpBankForm() {
        try {
            getLogger().info("Fill Up Bank Form");
            validateElementText(titleComponentBank, "Integrate with your Bank");
            clickElement(buttonBankSkip, "Button Bank Skip");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpFileForm() {
        try {
            getLogger().info("Fill Up Bank Form");
            validateElementText(titleComponentFiles, "Integrate With Your File Storage");
            clickElement(buttonFilesSkip, "Button File Skip");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpSecurityForm(String password) {
        try {
            getLogger().info("Fill Up Personal Form");
            validateElementText(titleComponentSecurity, "Create Your Password");
            sendKeyTextBox(inputCreatePassword, password, "Input Create Password");
            sendKeyTextBox(inputConfirmPassword, password, "Input Confirm Password");
            waitSomeSeconds(2);
            clickElement(buttonSecurityContinue, "Button Security Continue");
            waitSomeSeconds(5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
