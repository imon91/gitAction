package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CheckoutPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.PDPPageObjects;
import utils.WebAppBaseClass;

public class Checkout extends WebAppBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homepageobject;
    private PDPPageObjects pdp;
    private CheckoutPageObjects checkoutpageobject;
    TouchAction touch ;



    @BeforeClass(alwaysRun = true)
    public void CheckoutBeforeClass() throws Exception {
        System.out.println("CheckoutBeforeClass is called");
        androidDriver = getBaseDriver();
        homepageobject = new HomePageObjects(androidDriver);
        pdp = new PDPPageObjects(androidDriver);
        checkoutpageobject = new CheckoutPageObjects(androidDriver);
        touch = new TouchAction(androidDriver);
        //homepageobject.navigateToMyShop();
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE},enabled = false)
    public void verifyAddingItemsToMyBag() {
        System.out.println("control came to verify adding items to my shop");
        checkoutpageobject.clickOnContinueShopping();
        homepageobject.navigateToMyShop();
        touch.press(PointOption.point(0,500)).waitAction().moveTo(PointOption.point(0,100)).release().perform();
        androidDriver.findElementByXPath("//div[@class='gridItems___2yFJ9 items___vci1r'][5]").click();
        androidDriver.findElementByXPath("//a[@class='imageLink___3uqgg'][1]").click();
        touch.press(PointOption.point(0,400)).waitAction().moveTo(PointOption.point(0,200)).release().perform();
        androidDriver.findElementByXPath("//div[@class='select-size-radio mrvoonik-select-size-radio size-radio-success text-center'][1]").click();
        pdp.clickOnBuyNow();
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyCheckout() throws Exception {
        System.out.println("control came to verifyCheckout");
        checkoutpageobject.confirmingOrder();
        //touch.press(PointOption.point(0,500)).waitAction().moveTo(PointOption.point(0,200)).release().perform();
        //checkoutpageobject.clickOnPlaceOrder();
    }



    @AfterClass(alwaysRun = true)
    public void CheckoutAfterclass(){
        System.out.println("CheckoutAfterClass is called");
    }


}
