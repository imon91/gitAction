package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class HomePageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public HomePageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
    }

    //HamBurgerMenuIcon
    @FindBy(css = "#header > div.mainHeader___1D0Y8 > div.headerLogoNav___2DIqG > button")
    private WebElement MenuButton;

    //ContactUs
    @FindBy(css = "#navDrawer > div.nav-content > div.top-links > a:nth-child(1)")
    private WebElement ContactUs;

    //ResellerPolicy
    @FindBy(css = "#navDrawer > div.nav-content > div.top-links > a:nth-child(2)")
    private WebElement ResellerPolicy;

    //PrivacyPolicy
    @FindBy(css = "#navDrawer > div.nav-content > div.top-links > a:nth-child(3)")
    private WebElement PrivacyPolicy;

    //closeMenuButton
    @FindBy(css = "#navDrawer > div.nav-header.mrvoonik-nav-header > div > svg")
    private WebElement CloseMenuButton;

    //ShopUp logo
    @FindBy(css = "#headerLogoImg")
    private WebElement ShopUpLogo;

    //searchicon
    @FindBy(css = "#header > div.mainHeader___1D0Y8 > div.customHeaderPdp___1MkCO > button")
    private WebElement SearchButton;

    //Entering the object
    @FindBy(css = "#searchTag")
    private WebElement EnterObjectToSearch;

    //searching for the object
    @FindBy(css = "#header > div.mainHeader___1D0Y8 > div.flex___1bJDE.around___2yVgM.middle___1jEMZ.searchBox___17XJm > button")
    private WebElement SearchTheObject;

    //BagIcon
    @FindBy(css = "#header > div.mainHeader___1D0Y8 > div.customHeaderPdp___1MkCO > a")
    private WebElement BagButton;

    //enterMobileNumber
    @FindBy()
    private WebElement EnterMobileNumber;

    //continue
    @FindBy()
    private WebElement Continue;

    //enterotp
    @FindBy()
    private WebElement EnterOTP;

    //submit
    @FindBy()
    private WebElement Submit;

    //UserProfileIcon
    @FindBy(css = "#header > div.mainHeader___1D0Y8 > div.customHeaderPdp___1MkCO > div")
    private WebElement ProfileButton;

    //NavigateToHome
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(2) > div:nth-child(2) > a:nth-child(1) > p")
    private WebElement HomeButton;

    //NavigateToMyOrders
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(2) > div:nth-child(2) > a:nth-child(2) > p")
    private WebElement MyOrders;

    //NavigateToMyShop
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(2) > div:nth-child(2) > a:nth-child(3) > p")
    private WebElement MyShop;

    //SignOut
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(2) > div:nth-child(5)")
    private WebElement SignOut;

    //changeLanguage
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(2) > div:nth-child(3)")
    private WebElement ChangeLanguage;

    //closeUserProfileIcon
    @FindBy(css = "#header > div:nth-child(3) > div > div > div.close___3yvOX")
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

    private void clickOnSubmitButton(){myActions.action_click(Submit);}

    private void clickOnUserProfile(){myActions.action_click(ProfileButton);}

    private void clickOnHomeButton(){myActions.action_click(HomeButton);}

    private void clickOnMyOrders(){myActions.action_click(MyOrders);}

    private void clickOnMyShop(){myActions.action_click(MyShop);}

    private void clickOnSignOut(){myActions.action_click(SignOut);}

    private void clickOnChangeLanguage(){myActions.action_click(ChangeLanguage);}

    private void clickOnCloseProfileButton(){myActions.action_click(CloseProfileButton);}

    /*-------Functions---------*/

    public void searchForObject(String object){
        clickOnSearchButton();
        enterTheObject(object);
        searchTheObject();
    }

    public void login(String MobileNumber, String OTP){
        clickOnMyBag();
        clickOnEnterMobileNumber(MobileNumber);
        clickOnContinueButton();
        clickOnEnterOTP(OTP);
        clickOnSubmitButton();
    }

    public void changeLanguage(){
        clickOnUserProfile();
        clickOnChangeLanguage();
        clickOnCloseProfileButton();
    }

}