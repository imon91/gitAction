package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

import static utils.WebAppBaseClass.getBaseDriver;
import static utils.WebAppBaseClass.sleep;

public class Address {

    private AndroidDriver<WebElement> androidDriver;
    private AddressPageObjects addresspageobject;
    private MyOrderPageObjects order;
    private HomePageObjects home;



    @BeforeClass(alwaysRun = true)
    public void AddressBeforeClass() throws Exception {
        System.out.println("AddressBeforeClass is called");
        androidDriver = getBaseDriver();
        addresspageobject = new AddressPageObjects(androidDriver);
        order = new MyOrderPageObjects(androidDriver);
        home = new HomePageObjects(androidDriver);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyAddress() throws InterruptedException {
        System.out.println("control came to verifyAddress");
        addresspageobject.placingOrderwithNewAddress("Siva","shop street","F colony","1877755590");
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyMyOrder(){
        System.out.println("control came to my orders");
        String orderno = order.getOrderNo();
        System.out.println(orderno);
        sleep(4000);
        order.navigationToHome();
        home.navigateToMyOrder();
        String Orderno = order.getRecentOrderId();
        System.out.println(Orderno);
        if(orderno.equalsIgnoreCase(Orderno)){System.out.println("Order placed successfully");}
        sleep(3000);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifySignOut(){
        System.out.println("Control came to verifySignout");
        home.SignOut();
        home.navigateToMyShop();
        sleep(2000);
    }



    @AfterClass(alwaysRun = true)
    public void AddressAfterclass(){
        System.out.println("AddressAfterClass is called");
    }


}
