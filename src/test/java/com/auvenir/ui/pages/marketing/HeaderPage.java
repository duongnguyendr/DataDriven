package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class HeaderPage extends AbstractPage {
    public HeaderPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }
    private LoginModalPO loginPO;
    //private ForgotPassModalPO forgotPassPO;
    //private ResetLinkSentModalPO resetLinkSentPO;

    @FindBy(id = "logo")
    private WebElement eleLogo;
    public WebElement getEleLogo() { return eleLogo; }

    @FindBy(css = "#marketing-header .btn-login")
    private WebElement loginLink;
    public WebElement getLoginLink() { return loginLink; }

    @FindBy(xpath = "//a[text()='Auditor Sign Up' or text()='S’enregistrer comme Auditeur']")
    private WebElement auditorSignUp;
    public WebElement getAuditorSignUp() { return auditorSignUp; }

//    @FindBy(xpath = "//*[@id='marketing-header']/div/div/div[1]/div[2]/button[text()='Logout' or text()='Connectez - Out']")
    @FindBy(xpath = "//div[@class='ui label']")
    private WebElement eleUserName;
    public WebElement getBtnLogout() { return eleUserName; }

    @FindBy(xpath = "//div[@class='menu transition visible']/div[@class='item']")
    private WebElement eleLogout;
    public WebElement getEleLogout() { return eleLogout; }

    @FindBy(css = "#language-flag button")
    private WebElement flagEnglish;
    public WebElement getFlagEnglish() { return flagEnglish; }

    /*public HeaderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);

        loginPO = new LoginModalPO(driver);
        forgotPassPO = new ForgotPassModalPO(driver);
        resetLinkSentPO = new ResetLinkSentModalPO(driver);
    }*/

    /*@Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public LoginModalPO openLoginModal(){
        this.loginLink.click();
        return loginPO;
    }*/

    /**
     * Verify login function
     * @param email
     * @param pass
     */
    public void login(String email, String pass){
        loginLink.click();
        loginPO.login(email, pass);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Assert.assertNotNull(driver.manage().getCookieNamed("token_data").getValue());

        if(IS_ENGLISH_LANGUAGE){
            //Verify Login button is NOT found.
            validateElememt(loginLink, "Login Button", AbstractPage.Element_Type.NOT_EXIST);
            validateElememt(auditorSignUp, "Auditor SignUp", AbstractPage.Element_Type.NOT_EXIST);
            //VERIFY button Logout is displayed
            validateElememt(eleUserName, "Logout button", AbstractPage.Element_Type.DISPLAYED);
        }else{
            //Verify Login button is NOT found.
            validateElememt(loginLink, "Se Connecter", AbstractPage.Element_Type.NOT_EXIST);
            validateElememt(auditorSignUp, "S’enregistrer comme Auditeur", AbstractPage.Element_Type.NOT_EXIST);
            //VERIFY button Logout is displayed
            validateElememt(eleUserName, "Connectez - Out", AbstractPage.Element_Type.DISPLAYED);
        }

    }

    /**
     * Verify logout function
     */
    public void logOut(){
        eleUserName.click();
        waitUtilElementClickable(eleLogout, 20);
        eleLogout.click();

        waitUtilElementClickable(loginLink, 20);
        waitUtilElementClickable(auditorSignUp, 20);

        validateElememt(eleUserName, "Button Logout", Element_Type.NOT_EXIST);

        //Assert.assertNull(driver.manage().getCookieNamed("dta_token"));
    }

    /**
     * Change to French language
     */
    public void changeToFrench(){
        this.getFlagEnglish().click();
        IS_ENGLISH_LANGUAGE = false;
    }

    public LoginModalPO getLoginModalPO(){ return loginPO; }
    //public ForgotPassModalPO getForgotPassModalPO() { return forgotPassPO; }
    //public ResetLinkSentModalPO getResetLinkSentModalPO() { return resetLinkSentPO; }
}
