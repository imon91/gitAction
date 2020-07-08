package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidBaseClass;
import utils.MyActions;

public class RightNavigationDrawer extends AndroidBaseClass{

    private final AndroidDriver<WebElement> androidDriver;
    private final MyActions myActions;
    private final String packageName;

    public RightNavigationDrawer(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
    }

    // Name TextView
    private WebElement userNameTextView;

    // Email TextView
    private WebElement emailIdTextView;


    public String getUserName(){
        userNameTextView =
                idSetter(""+packageName+":id/name_text_view");
        return myActions.action_getText(userNameTextView);
    }


    public String getEmailId(){
        emailIdTextView =
                idSetter(""+packageName+":id/email_text_view");
        return myActions.action_getText(emailIdTextView);
    }


    // NavigationItem Home
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement navigationItemHome;

    // NavigationItem MyNotifications
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Notifications']")
    private WebElement navigationItemMyNotifications;

    // NavigationItem My Account
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
    private WebElement navigationItemMyAccount;

    // NavigationItem My Orders
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='5']")
    private WebElement navigationItemMyOrders;

    // NavigationItem My Shop
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='4']")
    private WebElement navigationItemMyShop;

    // NavigationItem Change Language
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Language']")
    private WebElement navigationItemChangeLanguage;

    // NavigationItem Reseller Policy
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reseller Policy']")
    private WebElement navigationItemResellerPolicy;


    // NavigationItem Privacy Policy
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private WebElement navigationItemPrivacyPolicy;

    // NavigationItem Help
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Help']")
    private WebElement navigationItemHelp;

    // NavigationItem FAQ
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FAQ']")
    private WebElement navigationItemFAQ;

    // NavigationItem Privacy Tutorial
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tutorial']")
    private WebElement navigationItemTutorial;

    // NavigationItem Contact us
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact us']")
    private WebElement navigationItemContactUs;

    // NavigationItem Logout
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='13']")
    private WebElement navigationItemLogout;



    /*------------Actions-----------*/


    public String getUserNameText(){
        return myActions.action_getText(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/name_text_view']")));
    }

    public String getUserEmailText(){
        return myActions.action_getText(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/email_text_view']")));
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
