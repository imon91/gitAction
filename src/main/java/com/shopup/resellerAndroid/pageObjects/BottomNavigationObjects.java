package com.shopup.resellerAndroid.pageObjects;

import com.shopup.utils.MyActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BottomNavigationObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public BottomNavigationObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }



    // Bottom-Navigation-Bar HomeIcon
    @AndroidFindBy(id = "com.shopup.reseller:id/homeBottomBar")
    private AndroidElement bottomBarHomeIcon;

    // Bottom-Navigation-Bar MyShopIcon
    @AndroidFindBy(id = "com.shopup.reseller:id/myShopBottomBar")
    private AndroidElement bottomBarMyShopIcon;

    // Bottom-Navigation-Bar MyOrders
    @AndroidFindBy(id = "com.shopup.reseller:id/myOrderBottomBar")
    private AndroidElement bottomBarMyOrdersIcon;

    // Bottom-Navigation-Bar PaymentsIcon
    @AndroidFindBy(id = "com.shopup.reseller:id/myIncomeBottomBar")
    private AndroidElement bottomBarPaymentsIcon;



    public void clickOnBottomBarHomeIcon(){
        myActions.action_click(bottomBarHomeIcon);
    }

    public void clickOnBottomBarMyShopIcon(){
        myActions.action_click(bottomBarMyShopIcon);
    }

    public void clickOnBottomBarMyOrdersIcon(){
        myActions.action_click(bottomBarMyOrdersIcon);
    }

    public void clickOnBottomBarPaymentsIcon(){
        myActions.action_click(bottomBarPaymentsIcon);
    }

}
