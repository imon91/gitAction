package pageObjects;

import org.openqa.selenium.*;
import utils.*;
import io.appium.java_client.android.*;


public class ActionBarObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public ActionBarObjects(AndroidDriver<WebElement> androidDriver){
        switchFromWebToNative();
        this.androidDriver = androidDriver;
        myActions = new MyActions();
       packageName = getAppPackage();
    }

    private WebElement hamburgerMenuIcon;

    private WebElement shopUpIcon;

    private WebElement searchImageButton;

    private WebElement bagImageButton;

    private WebElement cartCounterText;

    private WebElement profileImageButton;


    /*--------------Actions-------------------*/

    public void clickOnHamburgerMenuIcon(){
        hamburgerMenuIcon = xpathSetter("//android.widget.ImageButton[@resource-id='"+packageName+":id/side_menu_button']");
        myActions.action_click(hamburgerMenuIcon);
    }

    public void clickOnShopUpAppIcon(){
        shopUpIcon = idSetter(""+packageName+":id/app_icon_container");
        myActions.action_click(shopUpIcon);
    }

    public void clickOnSearchImageButton(){
        searchImageButton = xpathSetter("//android.widget.ImageButton[@resource-id='"+packageName+":id/searchButton']");
        myActions.action_click(searchImageButton);
    }

    public void clickOnBagImageButton(){
        bagImageButton = xpathSetter("//android.widget.ImageButton[@resource-id='"+packageName+":id/cartButton']");
        myActions.action_click(bagImageButton);
    }

    public String getTextFromCartCountHolder(){
        cartCounterText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/cartCount']");
        return myActions.action_getText(cartCounterText);
    }

    public void clickOnUserProfileImageButton(){
        profileImageButton = xpathSetter("//android.widget.ImageButton[@resource-id='"+packageName+":id/profile']");
        myActions.action_click(profileImageButton);
    }

}
