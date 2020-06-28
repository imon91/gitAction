package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;


public class MyOrders extends AndroidBaseClass {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyOrdersPageObjects myOrdersPageObjects;
    private MyOrdersPageObjects.OrderDetails orderDetails;
    private BottomNavigationObjects bottomNavigationObjects;

    @BeforeClass(alwaysRun = true)
    public void myOrdersBeforeClass() throws Exception{
        System.out.println("MyOrdersBeforeClass is called");
        androidDriver = getBaseDriver();
        setImplicitWait(30);
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        bottomNavigationObjects.clickOnBottomBarMyOrdersIcon();
        myOrdersPageObjects = new MyOrdersPageObjects(androidDriver);
        orderDetails = myOrdersPageObjects.new OrderDetails(androidDriver);
        // This Block is responsible to get the control from anywhere to MyOrders
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
    }


    @Test(  groups = {"MyOrders.verifySelectingAnOrderFromMyOrders",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify Selecting An Order From MyOrders"  )
    public void verifySelectingAnOrderFromMyOrders(){
        orderDetails.clickOnRandomOrderItem();
    }



    @AfterClass(alwaysRun = true)
    public void myOrdersAfterClass(){
        System.out.println("MyOrdersAfterClass is called");
    }

}
