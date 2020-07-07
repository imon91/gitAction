package pageObjects;

import org.openqa.selenium.*;
import utils.*;
import io.appium.java_client.android.*;

public class BottomNavigationObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public BottomNavigationObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
        packageName = getAppPackage();
    }



    // Bottom-Navigation-Bar HomeIcon
    private WebElement bottomBarHomeIcon;

    // Bottom-Navigation-Bar MyShopIcon
    private WebElement bottomBarMyShopIcon;

    // Bottom-Navigation-Bar MyOrders
    private WebElement bottomBarMyOrdersIcon;

    // Bottom-Navigation-Bar PaymentsIcon
    private WebElement bottomBarPaymentsIcon;



    /*--------------Actions-------------------*/


    public void clickOnBottomBarHomeIcon(){
        bottomBarHomeIcon = idSetter(""+packageName+":id/homeBottomBar");
        myActions.action_click(bottomBarHomeIcon);
    }

    public void clickOnBottomBarMyShopIcon(){
        bottomBarMyShopIcon = idSetter(""+packageName+":id/myShopBottomBar");
        myActions.action_click(bottomBarMyShopIcon);
    }

    public void clickOnBottomBarMyOrdersIcon(){
        bottomBarMyOrdersIcon = idSetter(""+packageName+":id/myOrderBottomBar");
        myActions.action_click(bottomBarMyOrdersIcon);
    }

    public void clickOnBottomBarPaymentsIcon(){
        bottomBarPaymentsIcon = idSetter(""+packageName+":id/myIncomeBottomBar");
        myActions.action_click(bottomBarPaymentsIcon);
    }

}
