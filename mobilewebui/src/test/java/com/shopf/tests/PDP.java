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
import utils.MyActions;

import static utils.WebAppBaseClass.getBaseDriver;
import static utils.WebAppBaseClass.sleep;

public class PDP {

    private AndroidDriver<WebElement> androidDriver;
    private CheckoutPageObjects checkoutpageobject;
    private HomePageObjects home;
    private PDPPageObjects pdp;
    TouchAction touch;
    MyActions myActions = new MyActions();


    @BeforeClass(alwaysRun = true)
    public void PDPBeforeClass() throws Exception {
        System.out.println("PDPBeforeClass is called");
        androidDriver = getBaseDriver();
        home = new HomePageObjects(androidDriver);
        checkoutpageobject = new CheckoutPageObjects(androidDriver);
        pdp = new PDPPageObjects(androidDriver);
        touch = new TouchAction(androidDriver);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyPDPPage() throws Exception {
        System.out.println("control came to verifyPDPPage");
        home.navigateToMyShop();
        home.searchForObject("Dettol");
        WebElement name = androidDriver.findElementByXPath("//li[@class='col-xs-6 col-sm-6'][1]/div[@class='feedItem___2QWNJ']/div[@class='productNameContainer___M7bIM']");
        String original_selection = myActions.action_getText(name);
        System.out.println(original_selection);
        touch.press(PointOption.point(0,400)).waitAction().moveTo(PointOption.point(0,40)).release().perform();
        androidDriver.findElementByXPath("//li[@class='col-xs-6 col-sm-6'][1]").click();
        WebElement name1 = androidDriver.findElementByXPath("//div[@class='pdp-det-box']/h1");
        String title = myActions.action_getText(name1);
        System.out.println(title + "2");
        if (title.equalsIgnoreCase(original_selection)){
              System.out.println("PDP working properly");
        }
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyPDPPage")
    public void verifyProductOrder(){
        System.out.println("control came to verifyProductOrder");
        touch.press(PointOption.point(0,400)).waitAction().moveTo(PointOption.point(0,100)).release().perform();
        androidDriver.findElementByXPath("//div[@class='select-size-radio mrvoonik-select-size-radio size-radio-success text-center'][1]").click();
        pdp.clickOnBuyNow();
        //touch.press(PointOption.point(0,500)).waitAction().moveTo(PointOption.point(0,200)).release().perform();
        //sleep(2500);
        //checkoutpageobject.clickOnPlaceOrder();
    }



    @AfterClass(alwaysRun = true)
    public void PDPAfterclass(){
        System.out.println("PDPAfterClass is called");
    }


}
