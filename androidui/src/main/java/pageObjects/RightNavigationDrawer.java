package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class RightNavigationDrawer {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public RightNavigationDrawer(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }

    // Name TextView
    @AndroidFindBy(id = "com.shopup.reseller:id/name_text_view")
    private AndroidElement userNameTextView;

    // Email TextView
    @AndroidFindBy(id = "com.shopup.reseller:id/email_text_view")
    private AndroidElement emailIdTextView;

    // NavigationItem Home
    @AndroidFindBy(xpath = "android.widget.TextView[@text='Home']")
    private AndroidElement navigationItemHome;

    // NavigationItem MyNotifications
    @AndroidFindBy(xpath = "android.widget.TextView[@text='My Notifications']")
    private AndroidElement navigationItemMyNotifications;

    // NavigationItem My Account
    @AndroidFindBy(xpath = "android.widget.TextView[@text='My Account']")
    private AndroidElement navigationItemMyAccount;

    // NavigationItem My Orders
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='5']")
    private AndroidElement navigationItemMyOrders;

    // NavigationItem My Shop
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='4']")
    private AndroidElement navigationItemMyShop;

    // NavigationItem Change Language
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Language']")
    private AndroidElement navigationItemChangeLanguage;

    // NavigationItem Reseller Policy
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reseller Policy']")
    private AndroidElement navigationItemResellerPolicy;


    // NavigationItem Privacy Policy
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private AndroidElement navigationItemPrivacyPolicy;

    // NavigationItem Help
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Help']")
    private AndroidElement navigationItemHelp;

    // NavigationItem FAQ
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FAQ']")
    private AndroidElement navigationItemFAQ;

    // NavigationItem Privacy Tutorial
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tutorial']")
    private AndroidElement navigationItemTutorial;

    // NavigationItem Contact us
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact us']")
    private AndroidElement navigationItemContactUs;

    // NavigationItem Logout
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='13']")
    private AndroidElement navigationItemLogout;



    /*------------Actions-----------*/


    public String getUserNameText(){
        return myActions.action_getText(userNameTextView);
    }

    public String getUserEmailText(){
        return myActions.action_getText(emailIdTextView);
    }

    public void clickOnItemHome(){
        myActions.action_click(navigationItemHome);
    }

    public void clickOnItemMyNotification(){
        myActions.action_click(navigationItemMyNotifications);
    }

    public void clickOnItemMyAccount(){
        myActions.action_click(navigationItemMyAccount);
    }

    public void clickOnItemMyOrders(){
        myActions.action_click(navigationItemMyOrders);
    }

    public void clickOnItemMyShop(){
        myActions.action_click(navigationItemMyShop);
    }

    public void clickOnItemChangeLanguage(){
        myActions.action_click(navigationItemChangeLanguage);
    }

    public void clickOnItemResellerPolicy(){
        myActions.action_click(navigationItemResellerPolicy);
    }

    public void clickOnItemPrivacyPolicy(){
        myActions.action_click(navigationItemPrivacyPolicy);
    }

    public void clickOnItemHelp(){
        myActions.action_click(navigationItemHelp);
    }

    public void clickOnItemFAQ(){
        myActions.action_click(navigationItemFAQ);
    }

    public void clickOnItemTutorial(){
        myActions.action_click(navigationItemTutorial);
    }

    public void clickOnItemContactUs(){
        myActions.action_click(navigationItemContactUs);
    }

    public void clickOnItemLogout(){
        myActions.action_click(navigationItemLogout);
    }




    /*------------Functions-----------*/


}
