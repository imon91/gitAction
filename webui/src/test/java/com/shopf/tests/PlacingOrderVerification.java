package com.shopf.wapTests;

import coreUtils.CoreConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.PLPPageObject;
import pageObjects.PaymentPageObject;
import utils.WebBaseClass;

public class PlacingOrderVerification extends WebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PLPPageObject plpPageObject;
    private PaymentPageObject paymentPageObject;
    private Actions actions;


    @BeforeClass(alwaysRun = true)
    public void orderVerificationBeforeClass() throws Exception {
        System.out.println("orderVerificationBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        paymentPageObject = new PaymentPageObject(driver);
        actions = new Actions(driver);
    }



    @Test(groups = {"OrderSuccessfull.VerifyPlacingOrder",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("Bag.VerifyAddress"))
    public void orderVerification() {
        System.out.println("orderVerification is called");
        sleep(2500);
        paymentPageObject.clickOnCashOnDelivery();
        sleep(3000);
        paymentPageObject.clickOnMakePaymentButton();
        sleep(3000);
        String ordernumberAtOrderSuccessful = paymentPageObject.getOrderNumber();
        System.out.println("OrderIdAtOrderSuccessfullPage:"+ordernumberAtOrderSuccessful);
        sleep(2500);
        paymentPageObject.clickOnStartShopping();
        sleep(2500);
        actions.sendKeys(Keys.ESCAPE).build().perform();
        sleep(2500);
        actionBarObjects.clickOnLoginButton();
        actionBarObjects.dropDownMyOrder();
        sleep(1000);
        String orderNumberAtMyorder = actionBarObjects.getOrderNumberAtMyorder();
        if(orderNumberAtMyorder==ordernumberAtOrderSuccessful)
        {
            System.out.println("Order Id Was Verify Successfully");
            System.out.println("OrderNumber was matched!!");
        }

    }



    @AfterClass(alwaysRun = true)
    public void orderVerificationAfterClass() {
        System.out.println("orderVerificationAfterclass is called");
    }


}

