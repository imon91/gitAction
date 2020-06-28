package pageObjects;

import coreUtils.*;
import utils.MyActions;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;


public class ActionBarObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public ActionBarObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        if(System.getProperty(BuildParameterKeys.KEY_APP).
                equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            this.packageName = CoreConstants.RESELLER_APP_PACKAGE;
        }else if(System.getProperty(BuildParameterKeys.KEY_APP).
                equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            this.packageName = CoreConstants.MOKAM_APP_PACKAGE;
        }else {
            //Default
            this.packageName = CoreConstants.RESELLER_APP_PACKAGE;
        }
    }


    // HamburgerMenu Icon
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.shopup.reseller:id/side_menu_button']")
    private AndroidElement hamburgerMenuIcon;

    // ShopUp Logo
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.shopup.reseller:id/app_icon_container']")
    private AndroidElement shopUpAppIcon;

    // Search Icon
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.shopup.reseller:id/searchButton']")
    private AndroidElement searchImageButton;

    // Bag Icon
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.shopup.reseller:id/cartButton']")
    private AndroidElement bagImageButton;

    // Cart Count
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/actionbar_cart_count']")
    private AndroidElement cartCount;

    // UserProfile Icon
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.shopup.reseller:id/profile']")
    private AndroidElement userProfileImageButton;


    /*--------------Actions-------------------*/

    public void clickOnHamburgerMenuIcon(){
        myActions.action_click(hamburgerMenuIcon);
    }

    public void clickOnShopUpAppIcon(){
        myActions.action_click(shopUpAppIcon);
    }

    public void clickOnSearchImageButton(){
        myActions.action_click(searchImageButton);
    }

    public void clickOnBagImageButton(){
        myActions.action_click(bagImageButton);
    }

    public String getTextFromCartCountHolder(){
        return myActions.action_getText(cartCount);
    }

    public void clickOnUserProfileImageButton(){
        myActions.action_click(userProfileImageButton);
    }

//    public void clickOnImageButton(String value){
//        List<AndroidElement> list = androidDriver.findElements(By.className("android.widget.ImageButton"));
//        System.out.println(list.size());
//        switch (value) {
//            case "HamburgerIcon" : myActions.action_click(list.get(0));break;
//            case "SearchIcon" : myActions.action_click(list.get(1));break;
//            case "BagIcon" : myActions.action_click(list.get(2));break;
//            case "ProfileIcon" : myActions.action_click(list.get(3));break;
//        }
//    }
}
