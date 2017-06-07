package com.auvenir.ui.pages.common;

import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//import org.testng.log4testng.Logger;

public class GmailPage extends AbstractPage {

    //static String gmailWindowHandles;
    public GmailPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    /*@FindBy(xpath = "//a[text()='Sign In']")
    private WebElement eleSignInLink;
    public WebElement getEleSignInLink()
    {
        return eleSignInLink;
    }
        */
    @FindBy(xpath = "//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']/span")
    private WebElement eleProfileIcn;

    public WebElement getEleProfileIcn() {
        return eleProfileIcn;
    }

    @FindBy(xpath = "//a[text()='Sign out']")
    private WebElement eleSignOutBtn;

    public WebElement getEleSignOutBtn() {
        return eleSignOutBtn;
    }

    @FindBy(id = "Email")
    private WebElement eleEmailIDTxtFld;

    public WebElement getEleEmailIDTxtFld() {
        return eleEmailIDTxtFld;
    }

    @FindBy(id = "next")
    private WebElement eleNextBtn;

    public WebElement getEleNextBtn() {
        return eleNextBtn;
    }

    @FindBy(id = "Passwd")
    private WebElement elePasswordTxtFld;

    public WebElement getElePasswordTxtFld() {
        return elePasswordTxtFld;
    }

    @FindBy(id = "signIn")
    private WebElement eleSignInBtn;

    public WebElement getEleSignInBtn() {
        return eleSignInBtn;
    }

    @FindBy(id = "gbqfq")
    private WebElement eleSearchTxtFld;

    public WebElement getEleSearchTxtFld() {
        return eleSearchTxtFld;
    }

    @FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
    private WebElement composeTextFld;

    @FindBy(id = "gbqfb")
    private WebElement eleSearchBtn;

    public WebElement getEleSearchBtn() {
        return eleSearchBtn;
    }

    @FindBy(xpath = "(//span[contains(text(),'to complete your financial audit')])[last()]")
    private WebElement eleInviteMailLnk;

    public WebElement getEleInviteMailLnk() {
        return eleInviteMailLnk;
    }

    @FindBys({@FindBy(xpath = "//span[contains(text(),'to complete your financial audit')]")})
    private List<WebElement> lsEleInviteMailLnk;

    public List<WebElement> getLsEleInviteMailLnk() {
        return lsEleInviteMailLnk;
    }

    @FindBys({@FindBy(xpath = "//b[contains(text(),'Sign in to Auvenir')]")})
    private List<WebElement> lsEleSignInMailLnk;

    public List<WebElement> getLsEleSignInMailLnk() {
        return lsEleSignInMailLnk;
    }
        /*@FindBy(xpath = "(//span[contains(text(),'Sign in to Auvenir!')])[position()=1]")
        private WebElement eleSignInMailLnk;
		public WebElement getEleSignInMailLnk() {
			return eleSignInMailLnk;
		}*/

    @FindBys({@FindBy(xpath = "//span[contains(text(),'Account is Active')]")})
    private List<WebElement> lsEleYourAccActiveLnk;

    public List<WebElement> getLsEleYourAccActiveLnk() {
        return lsEleYourAccActiveLnk;
    }

    @FindBy(xpath = "//b[contains(text(),'Account is Active')]")
    private WebElement eleYourAccActiveLnk;

    public WebElement getEleYourAccActiveLnk() {
        return eleYourAccActiveLnk;
    }

    @FindBy(xpath = "(//a[contains(text(),'Start')])[last()]")
    private WebElement eleStartBtn;

    public WebElement getEleStartBtn() {
        return eleStartBtn;
    }

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement eleSignInLnk;

    public WebElement getEleSignInLnk() {
        return eleSignInLnk;
    }

    @FindBy(xpath = "//a[@id='edit-account-list'][text()='Remove']")
    private WebElement eleRemoveLnk;

    public WebElement getEleRemoveLnk() {
        return eleRemoveLnk;
    }

    @FindBy(xpath = "//a[@id='edit-account-list'][text()='Done']")
    private WebElement eleDoneLnk;

    public WebElement getEleDoneLnk() {
        return eleDoneLnk;
    }

    @FindBy(xpath = "//span[contains(text(),'@gmail.com'])")
    private WebElement eleAccountCloseIcn;

    public WebElement getEleAccountCloseIcn() {
        return eleAccountCloseIcn;
    }

    @FindBy(xpath = "//div[@aria-label='Show trimmed content']/img")
    private WebElement eleShowTrimBtn;

    public WebElement getEleShowTrimBtn() {
        return eleShowTrimBtn;
    }

    public void gmailLogout() throws Exception {
        try {
            getEleProfileIcn().click();
            getEleSignOutBtn().click();
        } catch (Exception e) {
            NXGReports.addStep("Failed to logout from gmail", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


    public void gmailLogin(String sUSN, String sPWD) throws InterruptedException {
        try {
            getDriver().get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
            try {
                if (getEleSignInLnk().isDisplayed()) {
                    getEleSignInLnk().click();
                }
            } catch (Exception e) {
            }
            try {
                if (getEleRemoveLnk().isDisplayed()) {
                    getEleRemoveLnk().click();
                    Thread.sleep(2000);
                    getDriver().findElement(By.xpath("//span[text()='" + sUSN + "']")).click();
                    try {
                        if (getEleRemoveLnk().isDisplayed()) {
                            getEleRemoveLnk().click();
                        }
                    } catch (Exception e) {
                    }

                    getEleDoneLnk().click();
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
            }

            try {
                if (getEleEmailIDTxtFld().isDisplayed()) {
                    getEleEmailIDTxtFld().sendKeys(sUSN);
                    getEleNextBtn().click();
                }
            } catch (Exception e) {
            }
            getElePasswordTxtFld().sendKeys(sPWD);
            getEleSignInBtn().click();
            Assert.assertTrue(getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
            NXGReports.addStep("Login to Gmail is successful", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Failed to login to Gmail", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public void inviteEmail() {
        try {

            for (int i = 0; i < lsEleInviteMailLnk.size(); i++) {
                System.out.println(lsEleInviteMailLnk.get(i).getText());
                if (lsEleInviteMailLnk.get(i).getText().contains("to complete your financial audit")) {
                    lsEleInviteMailLnk.get(i).click();
                    try {
                        if (getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed()) {
                            getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
                            Thread.sleep(2000);

                            Robot rb = new Robot();
                            rb.keyPress(KeyEvent.VK_PAGE_DOWN);
                        }
                    } catch (Exception e) {
                    }
                    break;
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    public void signInEmail() {
        try {
            System.out.println(lsEleSignInMailLnk.size());
            for (int i = 0; i < lsEleSignInMailLnk.size(); i++) {
                System.out.println(lsEleSignInMailLnk.get(i).getText());
                if (lsEleSignInMailLnk.get(i).getText().contains("Sign in to Auvenir")) {
                    lsEleSignInMailLnk.get(i).click();
                    try {
                        if (getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed()) {
                            getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
                            Thread.sleep(2000);

                            Robot rb = new Robot();
                            rb.keyPress(KeyEvent.VK_PAGE_DOWN);
                        }
                    } catch (Exception e) {
                    }
                    break;
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    public void accountActiveEmail() {
        try {
            System.out.println(lsEleYourAccActiveLnk.size());
            for (int i = 0; i < lsEleYourAccActiveLnk.size(); i++) {
                System.out.println(lsEleYourAccActiveLnk.get(i).getText());
                if (lsEleYourAccActiveLnk.get(i).getText().contains("Account is Active")) {
                    lsEleYourAccActiveLnk.get(i).click();
                    try {
                        if (getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed()) {
                            getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
                            Thread.sleep(2000);

                            Robot rb = new Robot();
                            rb.keyPress(KeyEvent.VK_PAGE_DOWN);
                        }
                    } catch (Exception e) {
                    }
                    break;
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    public WebElement getComposeTextFld() {
        return composeTextFld;
    }

    //////////////////////////////////////////////////////////
    @FindBy(xpath = "//input[@type='email']")
    private WebElement eleEmail;

    public WebElement getEleEmail() {
        return eleEmail;
    }

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement eleNext;

    public WebElement getEleNext() {
        return eleNext;
    }

    @FindBy(xpath = "//div[@id='password']//input[@type='password']")
    private WebElement elePassword;

    public WebElement getElePassword() {
        return elePassword;
    }

    @FindBy(id = "signIn")
    private WebElement eleSignIn;

    public WebElement getEleSignIn() {
        return eleSignIn;
    }

    @FindBy(xpath = "//div[contains(@class, 'y6')]/span[contains(text(), 'Auvenir')]")
    private WebElement eleEmailAuvenir;

    public WebElement getEleEmailAuvenir() {
        return eleEmailAuvenir;
    }

    public void goGMail() {
        try {
            getDriver().get("https://mail.google.com/mail/u/0/?tab=wm#inbox");
        } catch (Exception e) {
            getLogger().info("Unable to go to Gmail.");
        }
    }

    /**
     * Login gmail
     *
     * @param email
     * @param password
     */
    public void openGmailIndexForgotPassword(String email, String password) throws InterruptedException {
        try {
            //Sending email address
            sendKeyTextBox(eleEmail, email, "eleEmail");
            getLogger().info("Send email: " + email);
            //Clicking on "Next" button
            clickAndHold(eleNext, "eleNext");
            //Sending password
            //Thread.sleep(500);
            //sendKeyTextBox(elePassword,password,"eleEmail");
            elePassword.sendKeys(password);
            getLogger().info("Send password: " + password);
            //Clicking on "Next" button
            Thread.sleep(500);
            clickAndHold(eleNext, "eleNext");
            //eleNext.click();
            getLogger().info("DONE => LOGIN");
        } catch (NoSuchElementException e) {
            getLogger().info("Errors ..... ");
            WebElement elementEmail = getDriver().findElement(By.id("identifierId"));
            elementEmail.sendKeys(email);
            getDriver().findElement(By.xpath("//div[@id='identifierNext']")).click();
            waitUtilElementClickable(getDriver().findElement(By.id("passwordNext")), 60);
            getDriver().findElement(By.cssSelector("#password input")).sendKeys(password);
            getDriver().findElement(By.id("passwordNext")).click();
        }
        //Waiting for email receiver form Auvenir in 30s
        waitUtilElementClickable(eleEmailAuvenir, 30);
        //Open email details
        eleEmailAuvenir.click();
        getLogger().info("Click on mail.");
        try {
            Thread.sleep(500);
            //WebElement showTrimmedContent = getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']"));
            WebElement showTrimmedContent = getDriver().findElement(By.xpath("//a[contains(text(),'Reset Password')]"));
            getLogger().info("Find element reset password link.");
            if (showTrimmedContent.isDisplayed()) {
                showTrimmedContent.click();
                getLogger().info("Click on reset password link.");
            }
        } catch (NoSuchElementException e) {

        }
    }

    public void openGmailIndexRegisterAccount(String email, String password) {
        //Sending email address
        sendKeyTextBox(eleEmail, email, "Email text box");
        //Clicking on "Next" button
        clickElement(eleNext);
        //Sending password
        sendKeyTextBox(elePassword, password, "Password text box");
        //Clicking on "Next" button
        clickElement(eleNext);
        //Open email details
        eleEmailAuvenir.click();
    }

    public void searchGmail(String GMAIL_SEARCHMAIL) {
        clearTextBox(eleSearchTxtFld, "Search Field");
        sendKeyTextBox(eleSearchTxtFld, GMAIL_SEARCHMAIL, "Search Field");
        clickElement(eleSearchBtn, "Search button");
    }

    /**
     * Refactored by huy.huynh on 02/06/2017 - 05/06/2017.
     * New for smoke test
     */
    @FindBy(xpath = "//a[text()='Sign In']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//h1[text()='Sign in']")
    private WebElement titleSignIn;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement buttonNextToPassword;

    @FindBy(xpath = "//div[@role='link']")
    private WebElement titleForgotPassword;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement buttonPasswordNext;

    @FindBy(xpath = "//div/span[text()='Gmail']")
    private WebElement titleGmail;

    @FindBy(xpath = "//input[@id='gbqfq']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@id='gbqfb']")
    private WebElement buttonSearch;

    //@FindBy(xpath = "//div[@class='AO']//div[@class='nH']")
    @FindBy(xpath = "//div[@class='nH']/div[@role='main']//tbody")
    private WebElement rowSentEmail;

    @FindBy(xpath = "//h2[@class='hP']")
    private WebElement titleOfEmail;

    @FindBy(xpath = "//a[text()='Start Your Engagement']")
    private WebElement buttonStartEngagement;

    @FindBy(xpath = "//h3[@id='welcome-body']")
    private WebElement titleWelcome;

    @FindBy(id = "BltHke nH oy8Mbf aE3")
    private WebElement divSearchResultHidden;

    /**
     * Sign in to gmail with given email and password
     *
     * @param email    email to login
     * @param password password of email
     */
    public void signInGmail(String email, String password) {
        try {
            clickElement(buttonSignIn, "Button Sign In");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            sendKeyTextBox(inputEmail, email, "Input Email");
            clickElement(buttonNextToPassword, "Button Next To Password");

            validateElementText(titleForgotPassword, "Forgot password?");
            sendKeyTextBox(inputPassword, password, "Input Password");
            clickElement(buttonPasswordNext, "Button Password Next");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Sign in to gmail with given email and password
     */
    public void filterEmail() {
        try {
            sendKeyTextBox(inputSearch, GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_SEARCHMAIL"), "Search Email");
            clickElement(buttonSearch, "Button Search");
            waitForCssValueChanged(divSearchResultHidden, "Hidden div", "display", "none");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Enter the email(after search) n click 'Start Engagement' button to go to Auvenir site
     */
    public void clickOnboardingInvitationLink() {
        try {
            clickElement(rowSentEmail, "Row Sent Email");
            clickElement(buttonStartEngagement, "Button Start Engagement");
            validateElementText(titleWelcome, "Welcome to Auvenir!");

            /* TODO code for wrong link on invited client email unfixed - still unfixed
            String link = buttonStartEngagement.getAttribute("href");
            link = link.replace(":3083", "");
            GeneralUtilities.loadURL(getDriver(), link);*/

//            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
            getLogger().info("Client invited link loaded.(Status change: Pending->Onboarding)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


	 /*-----------end of huy.huynh on 02/06/2017 - 05/06/2017.*/
}
