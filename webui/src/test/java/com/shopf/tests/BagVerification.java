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



    @Test(groups = {"Bag.VerifyBag",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("PDP.ProductOrderThroughPDP"))
    public void bagVerification() throws InterruptedException {
        System.out.println("bagVerification is called");
        bagPageObjects.enterQuantity(2,1);
        sleep(3000);
        bagPageObjects.getMinimumAmountOfProduct(0);
        sleep(2000);
        bagPageObjects.enterDeliveryCharge("60");
        bagPageObjects.saveDeliveryCharge();
        sleep(4000);
        bagPageObjects.clickOnPlaceOrder();
        sleep(2000);
    }



    @AfterClass(alwaysRun = true)
    public void bagVerificationAfterClass() {
        System.out.println("bagVerificationAfterclass is called");
    }



}
