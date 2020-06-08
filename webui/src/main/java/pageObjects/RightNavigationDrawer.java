package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class RightNavigationDrawer {

    private WebDriver driver;
    private MyActions myActions;

    public RightNavigationDrawer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    // Name TextView
    @FindBy(id = "com.shopup.reseller:id/name_text_view")
    private WebElement userNameTextView;

    // Email TextView
    @FindBy(id = "com.shopup.reseller:id/email_text_view")
    private WebElement emailIdTextView;

    // NavigationItem Home
    @FindBy(xpath = "android.widget.TextView[@text='Home']")
    private WebElement navigationItemHome;

    // NavigationItem MyNotifications
    @FindBy(xpath = "android.widget.TextView[@text='My Notifications']")
    private WebElement navigationItemMyNotifications;

    // NavigationItem My Account
    @FindBy(xpath = "android.widget.TextView[@text='My Account']")
    private WebElement navigationItemMyAccount;

    // NavigationItem My Orders
    @FindBy(xpath = "android.widget.TextView[@text='My Orders']")
    private WebElement navigationItemMyOrders;

    // NavigationItem My Shop
    @FindBy(xpath = "android.widget.TextView[@text='My Shop']")
    private WebElement navigationItemMyShop;

    // NavigationItem Change Language
    @FindBy(xpath = "android.widget.TextView[@text='Change Language']")
    private WebElement navigationItemChangeLanguage;

    // NavigationItem Reseller Policy
    @FindBy(xpath = "android.widget.TextView[@text='Reseller Policy']")
    private WebElement navigationItemResellerPolicy;


    // NavigationItem Privacy Policy
    @FindBy(xpath = "android.widget.TextView[@text='Privacy Policy']")
    private WebElement navigationItemPrivacyPolicy;

    // NavigationItem Help
    @FindBy(xpath = "android.widget.TextView[@text='Help']")
    private WebElement navigationItemHelp;

    // NavigationItem FAQ
    @FindBy(xpath = "android.widget.TextView[@text='FAQ']")
    private WebElement navigationItemFAQ;

    // NavigationItem Privacy Tutorial
    @FindBy(xpath = "android.widget.TextView[@text='Tutorial']")
    private WebElement navigationItemTutorial;

    // NavigationItem Contact us
    @FindBy(xpath = "android.widget.TextView[@text='Contact us']")
    private WebElement navigationItemContactUs;

    // NavigationItem Logout
    @FindBy(xpath = "android.widget.TextView[@text='Logout']")
    private WebElement navigationItemLogout;



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
