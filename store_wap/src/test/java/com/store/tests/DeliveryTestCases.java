package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObejcts.*;

import static utils.StoreWapBaseClass.*;

public class DeliveryTestCases {


    private AndroidDriver<WebElement> androidDriver;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;
    private DeliveryPageObjects deliveryPageObjects;

    public void pageInitializer(){
        facebookPageObjects = new FacebookPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        deliveryPageObjects = new DeliveryPageObjects(androidDriver);
    }

    @BeforeClass(alwaysRun = true)
    public void deliveryTestCasesBeforeClass() throws Exception {
        androidDriver = getBaseDriver();
        System.out.println("deliveryTestCasesBeforeClass is called");
        pageInitializer();
        String facebookPage = facebookPageObjects.connectRandomFacebookPage(2);
        System.out.println(facebookPage + " is selected");
        facebookPageObjects.clickContinueAfterConnectFacebookPage();
        sleep(3000);
        dashBoardPageObjects.clickDeliveryButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyDeliveryPageTitle(){
        System.out.println("verifyDeliveryPageTitle is called");
        Assert.assertEquals(deliveryPageObjects.getPageTitle(), "Delivery");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyDeliveryPageTitle")
    public void sendFirstEligibleOrderToDelivery(){
        System.out.println("sendFirstEligibleOrderToDelivery is called");
        deliveryPageObjects.selectFirstEligibleOrderForSendToDelivery();
        deliveryPageObjects.clickOnSendOrdersForDelivery();
        //Assert.assertEquals(deliveryPageObjects.getOrdersSentToDelivery(),"Orders sent to Delivery");
    }

    @AfterClass(alwaysRun = true)
    public void deliveryTestCasesAfterClass(){
        System.out.println("deliveryTestCasesAfterClass is called");
    }
}
