package com.store.tests;

import coreUtils.CoreConstants;
import dataBase.DataBaseCore;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.weaver.ast.Or;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObejcts.*;
import services.commerceMethods.GetAuthenticationApiResponse;
import services.commerceMethods.GetCommerceApiResponse;
import utils.StoreWapBaseClass;

public class CreateOrder extends StoreWapBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private AuthenticationPageObjects authenticationPageObjects;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;
    private MyOrdersPageObjects myOrdersPageObjects;
    private CreateOrderPageObjects createOrderPageObjects;
    private EditOrdersPageObjects editOrdersPageObject;
    private OrderConfirmationPageObjects orderConfirmationPageObjects;


    public void pageInitializer(){
        authenticationPageObjects = new AuthenticationPageObjects(androidDriver);
        facebookPageObjects = new FacebookPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        myOrdersPageObjects = new MyOrdersPageObjects(androidDriver);
        createOrderPageObjects = new CreateOrderPageObjects(androidDriver);
        editOrdersPageObject =new EditOrdersPageObjects(androidDriver);
        orderConfirmationPageObjects = new OrderConfirmationPageObjects(androidDriver);
    }


    @BeforeClass(alwaysRun = true)
    public void createOrderBeforeClass() throws Exception {
        androidDriver = getBaseDriver();
        System.out.println("createOrderBeforeClass is called");
        pageInitializer();
        String facebookPage = facebookPageObjects.connectRandomFacebookPage(1);
        System.out.println(facebookPage + " is selected");
        facebookPageObjects.clickContinueAfterConnectFacebookPage();
        sleep(3000);
        dashBoardPageObjects.clickMyOrdersButton();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE} )
    public void createNewOrder(){
        System.out.println("createNewOrder is called ");
        myOrdersPageObjects.clickCreateNewOrderButton();
        createOrderPageObjects.enterProductAmount(1,"500");
        createOrderPageObjects.clickNextButton();
        editOrdersPageObject.enterCustomerName("Name");
        editOrdersPageObject.enterDiscount("50");
        editOrdersPageObject.enterDeliveryCharge("40");
        editOrdersPageObject.clickCreateOrderButton();
        sleep(3000);
        String orderID = orderConfirmationPageObjects.getOrderID();
        System.out.println("The OrderID of the new order is,");
        System.out.println(orderID);
    }


    @AfterClass
    public void createOrderAfterClass(){
        System.out.println("createOrderAfterClass is called");
    }



}
