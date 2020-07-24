package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.MyActions;

import java.awt.*;

import static utils.WebAppBaseClass.getBaseDriver;
import static utils.WebAppBaseClass.sleep;

public class Address {

    private AndroidDriver<WebElement> androidDriver;
    private AddressPageObjects addresspageobject;
    private MyOrderPageObjects order;
    private HomePageObjects home;
    private BottomNavigationObjects bottomNavigationObjects;
    private MyActions myActions;



    @BeforeClass(alwaysRun = true)
    public void AddressBeforeClass() throws Exception {
        System.out.println("AddressBeforeClass is called");
        androidDriver = getBaseDriver();
        addresspageobject = new AddressPageObjects(androidDriver);
        order = new MyOrderPageObjects(androidDriver);
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        home = new HomePageObjects(androidDriver);
        myActions = new MyActions();
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyAddress() throws Exception {
        System.out.println("control came to verifyAddress");
        //addresspageobject.placingOrderwithNewAddress("Siva","shop street","F colony","1877755590");
        //addresspageobject.clickOnShowMoreAddressesButton();
        addresspageobject.selectaddress(1);
        //for(int i = a;i<31;i+=4){myActions.swipe(1,0);}
        //sleep(2000);
        //myActions.swipe(1,0);
        //sleep(60000);
        addresspageobject.deleteProductWithCODDisabled();
        addresspageobject.clickOnProceedToPaymentButton();
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyAddress")
    public void verifyMyOrder(){
        System.out.println("control came to my orders");
        sleep(2000);
        addresspageobject.clickOnCashOnDelivery();
        sleep(1000);
        addresspageobject.clickOnMakePayment();
        String orderno = order.getOrderNo();
        System.out.println(orderno);
        sleep(1500);
        order.navigationToHome();
        bottomNavigationObjects.clickOnBottomBarMyOrdersIcon();
        sleep(1500);
        home.navigateToMyOrder();
        //String Orderno = order.getRecentOrderId();
        //System.out.println(Orderno);
        String Orderno = order.orderid(1);
        if(orderno.equalsIgnoreCase(Orderno)){System.out.println("Order placed successfully");}
        sleep(1500);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyMyOrder")
    public void verifySignOut(){
        System.out.println("Control came to verifySignout");
        home.SignOut();
        home.navigateToMyOrder();
        sleep(1000);
    }



    @AfterClass(alwaysRun = true)
    public void AddressAfterclass(){
        System.out.println("AddressAfterClass is called");
    }


}
