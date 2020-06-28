package pageObjects;

import org.openqa.selenium.By;
import utils.AndroidBaseClass;
import utils.MyActions;
import io.appium.java_client.android.*;


public class ActionBarObjects extends AndroidBaseClass {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public ActionBarObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
       packageName = getAppPackage();
    }


    /*--------------Actions-------------------*/

    private void clickOnHamburgerMenuIcon(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.ImageButton[@resource-id='"+packageName+":id/side_menu_button']")));
    }

    public void clickOnShopUpAppIcon(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.ImageView[@resource-id='"+packageName+":id/app_icon_container']")));
    }

    public void clickOnSearchImageButton(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.ImageButton[@resource-id='"+packageName+":id/searchButton']")));
    }

    public void clickOnBagImageButton(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.ImageButton[@resource-id='"+packageName+":id/cartButton']")));
    }

    public String getTextFromCartCountHolder(){
        return myActions.action_getText(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/cartCount']")));
    }

    public void clickOnUserProfileImageButton(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.ImageButton[@resource-id='"+packageName+":id/profile']")));
    }

}
