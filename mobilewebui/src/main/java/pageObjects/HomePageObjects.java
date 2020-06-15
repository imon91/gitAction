package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import static utils.WebAppBaseClass.sleep;


public class HomePageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public HomePageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
    }

    //HamBurgerMenuIcon
    @FindBy(xpath = "//div/button[@class='navIcon___1s-1K']")
    private WebElement MenuButton;

    //ContactUs
    @FindBy(xpath = "//div/a[@href='/contactus']")
    private WebElement ContactUs;

    //ResellerPolicy
    @FindBy(xpath = "//div/a[@href='/policies']")
    private WebElement ResellerPolicy;

    //PrivacyPolicy
    @FindBy(xpath = "//div/a[@href='/privacy']")
    private WebElement PrivacyPolicy;

    //closeMenuButton
    @FindBy(xpath = "//*[@id=\"close\"]")
    private WebElement CloseMenuButton;

    //ShopUp logo
    @FindBy(xpath = "//a/img[@class = 'mainLogo___10PZp']")
    private WebElement ShopUpLogo;

    //searchicon
    @FindBy(xpath = "//div/button[@class='searchIcon']")
    private WebElement SearchButton;

    //Entering the object
    @FindBy(xpath = "//div[@class='react-autosuggest__container']")
    private WebElement EnterObjectToSearch;

    //searching for the object
    @FindBy(xpath = "//button[@class='searchIcon___3fOZ5']")
    private WebElement SearchTheObject;

    //BagIcon
    @FindBy(xpath = "//a[@class='checkout-bag-icon']")
    private WebElement BagButton;

    //enterMobileNumber
    @FindBy(xpath = "//input[@id='newPhone']")
    private WebElement EnterMobileNumber;

    //continue
    @FindBy(xpath = "//button[@class='normal___3nyjx primary___OLr69 button___3btga ripple___1U_Uk']")
    private WebElement Continue;

    //enterotp
    @FindBy(xpath = "//input[@id='newOtp']")
    private WebElement EnterOTP;

    //resendotp
    @FindBy(xpath = "//button[@class='normal___3nyjx secondary___2pQSN button___3btga ripple___1U_Uk action___2Amzo']")
    private WebElement ResendOTP;

    //escfromotptextbox
    @FindBy(xpath = "//div[@class='cont']")
    private WebElement Login;

    //submit
    @FindBy(xpath = "//button[@class='normal___3nyjx primary___OLr69 button___3btga ripple___1U_Uk']")
    private WebElement Submit;

    //UserProfileIcon
    @FindBy(xpath = "//div[@class='myaccount-icon']")
    private WebElement ProfileButton;

    //NavigateToHome
    @FindBy(xpath = "//p[contains(text(),'Home')]")
    private WebElement NavigateToHome;

    //NavigateToMyOrders
    @FindBy(xpath = "//p[contains(text(),'My Orders')]")
    private WebElement NavigateToMyOrders;

    //NavigateToMyShop
    @FindBy(xpath = "//p[contains(text(),'My Shop')]")
    private WebElement NavigateToMyShop;

    //NavigateToMyAccount
    @FindBy(xpath = "//p[contains(text(),'My Account')]")
    private WebElement NavigateToMyAccount;

    //NavigateToResellerPolicy
    @FindBy(xpath = "//p[contains(text(),'Reseller Policy')]")
    private WebElement NavigateToResellerPolicy;

    //NavigateToFAQ
    @FindBy(xpath = "//p[contains(text(),'FAQ')]")
    private WebElement NavigateToFAQ;

    //NavigateToContactUs
    @FindBy(xpath = "//p[contains(text(),'Contact us')]")
    private WebElement NavigateToContactUs;

    //SignOut
    @FindBy(xpath = "//p[contains(text(),'Sign Out')]")
    private WebElement SignOut;

    //changeLanguage
    @FindBy(xpath = "//span[contains(text(), 'Change Language (BN)')]")
    private WebElement ChangeLanguage;

    //closeUserProfileIcon
    @FindBy(xpath = "//div[@class='close___3yvOX']")
    private WebElement CloseProfileButton;

    /*---------Actions----------*/

    private void clickOnMenuButton(){myActions.action_click(MenuButton);}

    private void clickOnContactUs(){myActions.action_click(ContactUs);}

    private void clickOnResellerPolicy(){myActions.action_click(ResellerPolicy);}

    private void clickOnPrivacyPolicy(){myActions.action_click(PrivacyPolicy);}

    private void clickOnCloseMenuButton(){myActions.action_click(CloseMenuButton);}

    private void clickOnShopUpLogo(){myActions.action_click(ShopUpLogo);}

    private void clickOnSearchButton(){myActions.action_click(SearchButton);}

    private void enterTheObject(String object){myActions.action_sendKeys(EnterObjectToSearch,object);}

    private void searchTheObject(){myActions.action_click(SearchTheObject);}

    private void clickOnMyBag(){myActions.action_click(BagButton);}

    private void clickOnEnterMobileNumber(String MobileNumber){myActions.action_sendKeys(EnterMobileNumber,MobileNumber);}

    private void clickOnContinueButton(){myActions.action_click(Continue);}

    private void clickOnEnterOTP(String OTP){myActions.action_sendKeys(EnterOTP,OTP);}

    private void clickOnResendOTP(){myActions.action_click(ResendOTP);}

    private void clickOnLogin(){myActions.action_click(Login);}

    private void clickOnSubmitButton(){myActions.action_click(Submit);}

    private void clickOnUserProfile(){myActions.action_click(ProfileButton);}

    public void clickOnHome(){myActions.action_click(NavigateToHome);}

    public void clickOnMyOrders(){myActions.action_click(NavigateToMyOrders);}

    public void clickOnMyShop(){myActions.action_click(NavigateToMyShop);}

    public void clickOnMyAccount(){myActions.action_click(NavigateToMyAccount);}

    public void clickOnresellerPolicy(){myActions.action_click(NavigateToResellerPolicy);}

    public void clickOnFAQ(){myActions.action_click(NavigateToFAQ);}

    public void clickOncontactUs(){myActions.action_click(NavigateToContactUs);}

    private void clickOnSignOut(){myActions.action_click(SignOut);}

    public void clickOnChangeLanguage(){myActions.action_click(ChangeLanguage);}

    public void clickOnCloseProfileButton(){myActions.action_click(CloseProfileButton);}

    /*-------Functions---------*/

    public void searchForObject(String object){
        clickOnSearchButton();
        enterTheObject(object);
        searchTheObject();
    }

    public void login(String MobileNumber, String OTP){
        clickOnMyShop();
        sleep(3000);
        clickOnEnterMobileNumber(MobileNumber);
        clickOnContinueButton();
        clickOnEnterOTP(OTP);
        clickOnLogin();
        sleep(3000);
        clickOnSubmitButton();
    }

    public void changeLanguage(){
        clickOnUserProfile();
        clickOnChangeLanguage();
        clickOnCloseProfileButton();
    }

}