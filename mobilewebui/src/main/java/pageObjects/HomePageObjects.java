package pageObjects;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WebAppBaseClass;

import java.util.List;
import java.util.Random;

public class HomePageObjects extends WebAppBaseClass {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;
    private Random random;
    private String app;

    public HomePageObjects(AndroidDriver<WebElement> androidDriver) throws Exception {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
        random = new Random();
        app = getAppName();
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

    //searchiconforMokam
    @FindBy(xpath = "//button[@class='searchIcon___3vIuT']")
    private WebElement SearchButton;

    //newsearchiconforReseller
    @FindBy(xpath = "//div[@class='search-container']")
    private WebElement newSearchButton;

    //Entering the object
    @FindBy(xpath = "//input[@id='searchTag']")
    private WebElement EnterObjectToSearch;

    //searching for the object Mokam
    @FindBy(xpath = "//button[@class='searchIcon___3fOZ5']/*")
    private WebElement searchTheObject;

    //search for object reseller
    @FindBy(xpath = "//button[@class='other___3TucM']/*")
    private WebElement newSearchTheObject;

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

    public void clickOnShopUpLogo(){myActions.action_click(ShopUpLogo);}

    private void clickOnSearchButton(){
        clickOnShopUpLogo();
        if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            myActions.action_click(SearchButton);
        }else if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            myActions.action_click(newSearchButton);
        }

    }

    private void enterTheObject(String object){myActions.action_sendKeys(EnterObjectToSearch,object);}

    private void searchTheObject(){
        if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            myActions.action_click(searchTheObject);
        }else if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            myActions.action_click(newSearchTheObject);
        }
    }

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
        //clickOnsearchButton();
        enterTheObject(object);
        searchTheObject();
    }

    public void login(String MobileNumber, String OTP){
        clickOnEnterMobileNumber(MobileNumber);
        driver.hideKeyboard();
        clickOnContinueButton();
        //sleep(3500);
        clickOnEnterOTP(OTP);
        driver.hideKeyboard();
        //myActions.swipe(200,20);
        clickOnSubmitButton();
    }

    public void changeLanguage(){
        clickOnUserProfile();
        clickOnChangeLanguage();
        clickOnCloseProfileButton();
    }

    public void navigateToMyShop(){
        clickOnUserProfile();
        clickOnMyShop();
    }

    public void navigateToHome(){
        clickOnUserProfile();
        clickOnHome();
    }

    public void navigateToMyAccount(){
        clickOnUserProfile();
        clickOnMyAccount();
    }

    public void navigateToMyOrder(){
        clickOnUserProfile();
        clickOnMyOrders();
    }

    public void navigateToResellerPolicy(){
        clickOnUserProfile();
        clickOnresellerPolicy();
    }

    public void setNavigateToContactUs(){
        clickOnUserProfile();
        clickOncontactUs();
    }

    public void navigateToFAQ(){
        clickOnUserProfile();
        clickOnFAQ();
    }

    public void SignOut(){
        clickOnUserProfile();
        clickOnSignOut();
        sleep(2000);
    }

    /*--------dynamicfunctions-----------*/

    public String tabContainer(int tabid){
        String tab;
        String tabXpath = "//div[@class='flex___1bJDE middle___1jEMZ']//div";
        List<WebElement> tablist = driver.findElements(By.xpath(tabXpath));
        if(tabid != 0){
            tab = tabXpath+"["+tabid+"]";
        } else {
            int id = random.nextInt(tablist.size());
            tab = tabXpath+"["+ ++id +"]";
        }
        String tabName = tab+"/p";
        WebElement tabelement = driver.findElement(By.xpath(tab));
        WebElement tabnameelement = driver.findElement(By.xpath(tabName));
        String tabselected = myActions.action_getText(tabnameelement);
        myActions.action_click(tabelement);
        return tabselected;
    }

}