package pageObjects;

import coreUtils.*;
import org.openqa.selenium.*;
import utils.*;
import io.appium.java_client.android.*;

import java.util.*;


public class ActionBarObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private String app;

    public ActionBarObjects(AndroidDriver<WebElement> androidDriver){
        switchFromWebToNative();
        this.androidDriver = androidDriver;
        myActions = new MyActions();
       packageName = getAppPackage();
       app = System.getProperty(BuildParameterKeys.KEY_APP);
    }

    private WebElement hamburgerMenuIcon;

    private WebElement shopUpIcon;

    private WebElement searchImageButton;

    private WebElement bagImageButton;

    private WebElement cartCounterText;

    private WebElement profileImageButton;

    private WebElement ownerNameSRFeature;

    /*--------------Actions-------------------*/

    public void clickOnHamburgerMenuIcon(){
        hamburgerMenuIcon = xpathSetter("//android.widget.ImageButton[@resource-id='"+packageName+":id/side_menu_button']");
        myActions.action_click(hamburgerMenuIcon);
    }

    public void clickOnShopUpAppIcon(){
        shopUpIcon = idSetter(""+packageName+":id/app_icon_container");
        myActions.action_click(shopUpIcon);
    }

    public WebElement ownerNameTextAtTop()
    { return ownerNameSRFeature = idSetter(packageName+":id/address_name"); }

    public void clickOnSearchImageButton(){
      
       if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            searchImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/searchButton']");
       } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            searchImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/searchButton']");
       }
        myActions.action_click(searchImageButton);
      
    }

    public void clickOnBagImageButton(){
      
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            bagImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/cart_icon']");
        }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            bagImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/cartButton']");
        }
        myActions.action_click(bagImageButton);
      
    }

    public String getTextFromCartCountHolder(){
        cartCounterText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/cartCount']");
        return myActions.action_getText(cartCounterText);
    }

    public void clickOnUserProfileImageButton(){
       if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
           profileImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/profile']");
       }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            profileImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/profile']");
       }
        myActions.action_click(profileImageButton);
    }

    public void clickOnBackButton() {
        WebElement backButton = idSetter(packageName+":id/back_button_feed");
        myActions.action_click(backButton);
    }

    public List<WebElement> getAddressNameAndAddressElement(){
        List<WebElement> addressDetails = new ArrayList<>();
        addressDetails.add(0,idSetter(packageName+":id/address_name"));
        addressDetails.add(1,idSetter(packageName+":id/address_details"));
        return addressDetails;
    }

    public List<WebElement> getActionBarButtonElements(){
        List<WebElement> buttonList = new ArrayList<>();
        buttonList.add(0,idSetter(packageName+":id/side_menu_button")); //leftSideNav button
        buttonList.add(1,idSetter(packageName+":id/searchButton")); //search button
        buttonList.add(2,idSetter(packageName+":id/profile")); //profile button
        buttonList.add(3,idSetter(packageName+":id/cart_icon_container")); //myBag button
        return buttonList;
    }

    public String getNumberOfItemsInCart(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            cartCounterText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/cart_item_count']");
        }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            cartCounterText = xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/cart_item_count']");
        }
        return myActions.action_getText(cartCounterText);
    }

    public void clickOnCartButton(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            bagImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/cart_icon']");
        }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            bagImageButton = xpathSetter("//android.view.ViewGroup[@resource-id='" + packageName + ":id/cart_icon_container']");
        }
        myActions.action_click(bagImageButton);
    }

    public WebElement getProfileButtonElement(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            profileImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/profile']");
        }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            profileImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/profile']");
        }
        return profileImageButton;
    }

    public WebElement getSearchIconElement(){

        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            searchImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/searchButton']");
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            searchImageButton = xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/details_action_search']");
        }
        return searchImageButton;
    }

    public WebElement getCartIconElement(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            bagImageButton = xpathSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/cart_icon']");
        }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            bagImageButton = xpathSetter("//android.view.ViewGroup[@resource-id='" + packageName + ":id/cart_icon_container']");
        }
        return bagImageButton;
    }

}
