package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import services.commerceMethods.GetMyBagApiResponse;
import utils.AndroidAppConstants;
import utils.AndroidBaseClass;
import utils.MyActions;
import utils.ServiceRequestLayer;

public class OrderSuccessfulPage extends AndroidBaseClass {



    private AndroidDriver<WebElement> androidDriver;
    private OrderSuccessFulPageObjects orderSuccessFulPageObjects;
    private MyActions myActions;
    private String suiteName;
    private SoftAssert softAssert;
    private ActionBarObjects actionBarObjects;
    private MyBagPageObjects myBagPageObjects;
    private CheckoutAddressPageObjects checkoutAddressPageObjects;
    private PaymentModePageObjects paymentModePageObjects;
    private ServiceRequestLayer serviceRequestLayer;
    private GetMyBagApiResponse getMyBagApiResponse;


    @BeforeClass(alwaysRun = true)
    public void orderSuccessfulPageBeforeClass(){
        System.out.println("OrderSuccessfulPage is Called");
        androidDriver = getBaseDriver();
        orderSuccessFulPageObjects = new OrderSuccessFulPageObjects(androidDriver);
        myActions = new MyActions();
        softAssert = new SoftAssert();
        suiteName = "sanity";
        actionBarObjects = new ActionBarObjects(androidDriver);
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        checkoutAddressPageObjects = new CheckoutAddressPageObjects(androidDriver);
        paymentModePageObjects = new PaymentModePageObjects(androidDriver);
        serviceRequestLayer = new ServiceRequestLayer();
        getMyBagApiResponse = serviceRequestLayer.getMyBagControl();
        myBagPageObjects.createItemInMyBag(85777);
        actionBarObjects.clickOnBagImageButton();
        sleep(3000);
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        sleep(3000);
        System.setProperty("order_id",getMyBagApiResponse.getOrderIDfromMyCart());
        myBagPageObjects.clickOnPlaceOrderButton();
        sleep(3000);
        checkoutAddressPageObjects.clickOnProceedToPaymentBottomButton();
        sleep(3000);
        paymentModePageObjects.proceedPaymentWithoutChangeAddressThroughTopButton();
        sleep(3000);
    }


    @Test(groups = {"Order.verifyOrderSuccessfulText",
            CoreConstants.GROUP_REGRESSION,
            CoreConstants.GROUP_SANITY},dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials")
    public void verifyOrderSuccessfulText(){
        String orderSuccessfulText = orderSuccessFulPageObjects.getOrderSuccessfulText(); //Frontend heading
        String expectedOrderSuccessfulText = orderSuccessFulPageObjects.getOrderSuccessfulHeading(); //Backend heading
        Assert.assertTrue(orderSuccessfulText.equalsIgnoreCase(expectedOrderSuccessfulText));
    }


    @Test(groups = {"Order.verifyOrderID",
            CoreConstants.GROUP_REGRESSION,
            CoreConstants.GROUP_SANITY},dependsOnGroups = "Order.verifyOrderSuccessfulText")
    public void verifyOrderID(){
        String orderID = orderSuccessFulPageObjects.getOrderID(); //Frontend orderID
        String expectedOrderID = orderSuccessFulPageObjects.getOrderIDData(); //Backend orderID
        Assert.assertEquals(orderID,expectedOrderID);
    }


    @Test(groups = {"Order.verifyClickHereButton",
            CoreConstants.GROUP_REGRESSION,
            CoreConstants.GROUP_SANITY},enabled = true,dependsOnGroups = "Order.verifyOrderID")
    public void verifyClickHereButton(){
        orderSuccessFulPageObjects.clickOnClickHereButton();
        sleep(3000);
        String windowHandle = androidDriver.getWindowHandle();
        androidDriver.switchTo().window(windowHandle);
        String activity = androidDriver.currentActivity();
        Assert.assertTrue(activity.equalsIgnoreCase(AndroidAppConstants.HOME_ACTIVITY));
        System.out.println("Control goes to HomeActivity");
    }


    @Test(groups = {"Order.verifyMyOrdersButton",
            CoreConstants.GROUP_REGRESSION,
            CoreConstants.GROUP_SANITY},enabled = false,dependsOnGroups = "Order.verifyOrderID")
    public void verifyMyOrdersButton(){
        orderSuccessFulPageObjects.clickOnGoTOMyOrdersButton();
        sleep(3000);
        String windowHandle = androidDriver.getWindowHandle();
        androidDriver.switchTo().window(windowHandle);
        String currentPage = androidDriver.getCurrentUrl();
        System.out.println(currentPage);
        Assert.assertTrue(currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_ORDERS_ACTIVE));
        System.out.println("Control goes to MyOrders");
    }


}
