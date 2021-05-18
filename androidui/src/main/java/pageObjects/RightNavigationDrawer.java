package pageObjects;

import coreUtils.*;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

public class RightNavigationDrawer extends AndroidBaseClass{

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;

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

    public WebElement getBackButtonElement(){
        return xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/back_button_profile']");
    }

    public WebElement getProfileSaveButtonElement(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_next_on_boarding']");
    }

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

    // NavigationItem Change Language Mokam
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index=4]")
    private WebElement navigationItemChangeLanguageMokam;

    // NavigationItem Change Language Reseller
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index=6]")
    private WebElement navigationItemChangeLanguageReseller;

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

    // NavigationItem Logout for reseller
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='15']")
    private WebElement navigationItemLogoutReseller;

    // NavigationItem Logout Mokam
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='11']")
    private WebElement navigationItemLogoutMokam;

    private WebElement profileEditButton;

    private WebElement profileSaveButton;

    private WebElement profileShopName;

    private WebElement profileOwnerName;

    private WebElement profileBusinessType;



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
        if (System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_RESELLER))
        {
            navigationItemChangeLanguageReseller = xpathSetter("//android.widget.RelativeLayout[@index=6]");
            myActions.action_click(navigationItemChangeLanguageReseller);

        }else if (System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            navigationItemChangeLanguageMokam = xpathSetter("//android.widget.RelativeLayout[@index=4]");
            myActions.action_click(navigationItemChangeLanguageMokam); 
        }
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
        if (System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            myActions.action_click(navigationItemLogoutReseller);
        }else if (System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            myActions.action_click(navigationItemLogoutMokam);
        }
    }

    public void selectEnglish(){
        myActions.action_click(xpathSetter("//android.widget.RadioButton[@text='English']"));
    }
    public void saveLanguage(){
        myActions.action_click(xpathSetter("//android.widget.TextView[@text='SAVE']"));
    }

    public void clickProfileEditButton(){
        profileEditButton = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_edit']");
        myActions.action_click(profileEditButton);}

        public String getEditProfilePageTitle(){
        WebElement pageTitleElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/title_profile_activity']");
        return myActions.action_getText(pageTitleElement);
        }

        public WebElement shopNameEdit()
        {
          profileShopName = idSetter(packageName+":id/add_retailer_edit_shop_name");
          return profileShopName;
        }

    public WebElement ownerNameEdit()
    {
        profileShopName = idSetter(packageName+":id/add_retailer_owner_name");
        return profileShopName;
    }

    public WebElement businessTypeEdit(int index)
    {
        return profileBusinessType = classListSetter("android.widget.CompoundButton").get(index);
    }

    public String getBusinessTypeHeadingText(){
        WebElement element = xpathSetter("//android.view.ViewGroup[@index='2']/android.widget.TextView");
        return myActions.action_getText(element);
    }

    public WebElement getBusinessTypeElement(int index){
        return xpathSetter("//android.view.ViewGroup[@index='2']/android.widget.CompoundButton[@index='"+ index +"']");
    }

        public void clickOnProfileSaveButton()
        {
            profileSaveButton = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_next_on_boarding']");
            myActions.action_click(profileSaveButton);
        }


    /*------------Functions-----------*/


}
