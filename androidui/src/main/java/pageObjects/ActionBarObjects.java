package pageObjects;

import utils.MyActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ActionBarObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public ActionBarObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    // HamburgerMenu Icon
    @AndroidFindBy(id = "com.shopup.reseller:id/side_menu_button")
    private AndroidElement hamburgerMenuIcon;

    // ShopUp Logo
    @AndroidFindBy(id = "com.shopup.reseller:id/app_icon_container")
    private AndroidElement shopUpAppIcon;

    // Search Icon
    @AndroidFindBy(className = "android.widget.ImageButton[1]")
    private AndroidElement searchImageButton;

    // Bag Icon
    @AndroidFindBy(className = "android.widget.ImageButton[2]")
    private AndroidElement bagImageButton;

    // UserProfile Icon
    @AndroidFindBy(className = "android.widget.ImageButton[3]")
    private AndroidElement userProfileImageButton;



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

    public void clickOnUserProfileImageButton(){
        myActions.action_click(userProfileImageButton);
    }
}
