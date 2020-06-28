package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.AddressPageObject;
import pageObjects.PLPPageObject;
import pageObjects.PaymentPageObject;
import utils.WebBaseClass;

public class PlacingOrderVerification extends WebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PLPPageObject plpPageObject;
    private PaymentPageObject paymentPageObject;


    @BeforeClass(alwaysRun = true)
    public void orderVerificationBeforeClass() throws Exception {
        System.out.println("orderVerificationBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        paymentPageObject = new PaymentPageObject(driver);
    }



    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void orderVerification() {
        System.out.println("orderVerification is called");
        sleep(2500);
        paymentPageObject.clickOnCashOnDelivery();
        sleep(3000);
        paymentPageObject.clickOnMakePaymentButton();
        sleep(3000);
        String ordernumberAtOrderSuccessful = paymentPageObject.getOrderNumber();
        System.out.println(ordernumberAtOrderSuccessful);
        sleep(2500);
        paymentPageObject.clickOnStartShopping();
        sleep(2500);
        actionBarObjects.clickOnLoginButton();
        actionBarObjects.dropDownMyOrder();
        String orderNumberAtMyorder = actionBarObjects.getOrderNumberAtMyorder();
        Assert.assertEquals(orderNumberAtMyorder,ordernumberAtOrderSuccessful);
        System.out.println("OrderNumber was matched!!");
    }



    @AfterClass(alwaysRun = true)
    public void orderVerificationAfterClass() {
        System.out.println("orderVerificationAfterclass is called");
    }


}

