package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CheckoutPageObjects;
import pageObjects.PDPPageObjects;
import pageObjects.PLPPageObjects;
import utils.MyActions;
import utils.WebAppBaseClass;

public class AddingItems extends WebAppBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private PDPPageObjects pdp;
    private PLPPageObjects plp;
    MyActions myActions = new MyActions();
    TouchAction touch ;


    @BeforeClass(alwaysRun = true)
    public void AddingItemsBeforeClass() throws Exception {
        System.out.println("AddingItemBeforeClass is called");
        androidDriver = getBaseDriver();
        plp = new PLPPageObjects(androidDriver);
        pdp = new PDPPageObjects(androidDriver);
        touch = new TouchAction(androidDriver);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyProductIsClicking() throws Exception {
        System.out.println("control came to verify Product is clicking");
        //androidDriver.findElementByXPath("//li[@class='col-xs-6 col-sm-6'][2]").click();
        String searchTerm = System.getProperty("searchTerm");
        plp.selectValidProduct(searchTerm);
        System.out.println("Valid Product is clicked");
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyProductIsClicking")
    public void AddingItemsToMyShopCollection() throws Exception {
        System.out.println("control came to adding items to myshop collections");
        pdp.clickOnAddToMyShop();
        //touch.press(PointOption.point(0,600)).waitAction().moveTo(PointOption.point(0,200)).release().perform();
        //androidDriver.findElementByXPath("//button[contains(text(),'shirts')][1]").click();
        pdp.additemtoCollection(0);
    }



    @AfterClass(alwaysRun = true)
    public void AddingItemsAfterClass(){
        System.out.println("AddingItemsAfterClass is called");
    }


}
