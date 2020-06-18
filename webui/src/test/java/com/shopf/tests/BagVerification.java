package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.BagPageObjects;
import pageObjects.PDPPageObject;
import pageObjects.PLPPageObject;
import utils.WebBaseClass;

public class BagVerification extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PLPPageObject plpPageObject;
    private PDPPageObject pdpPageObject;
    private BagPageObjects bagPageObjects;



    @BeforeClass(alwaysRun = true)
    public void bagVerificationBeforeClass() throws Exception {
        System.out.println("bagVerificationBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        plpPageObject = new PLPPageObject(driver);
        pdpPageObject = new PDPPageObject(driver);
        bagPageObjects = new BagPageObjects(driver);
    }



    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void bagVerification() throws InterruptedException {
        System.out.println("bagVerification is called");
        bagPageObjects.enterQuantity(2);
        sleep(2000);
        bagPageObjects.enterCustomPrice("500");
        bagPageObjects.saveCustomPrice();
        sleep(2000);
        bagPageObjects.enterDeliveryCharge("60");
        bagPageObjects.saveDeliveryCharge();
        sleep(2500);
        bagPageObjects.clickOnCouponButton();
        bagPageObjects.enterCouponText("RESELLER_15");
        bagPageObjects.clickOnApplyCoupon();
        sleep(2500);
        bagPageObjects.clickOnPlaceOrder();
        sleep(2000);
    }



    @AfterClass(alwaysRun = true)
    public void bagVerificationAfterClass() {
        System.out.println("bagVerificationAfterclass is called");
    }



}
