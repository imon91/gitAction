package com.shopf.wapTests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.WebBaseClass;

public class AddressVerification extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PLPPageObject plpPageObject;
    private AddressPageObject addressPageObject;


    @BeforeClass(alwaysRun = true)
    public void addressVerificationBeforeClass() throws Exception {
        System.out.println("addressVerificationBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        addressPageObject = new AddressPageObject(driver);
    }



    @Test(groups = {"Bag.VerifyAddress",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("Bag.VerifyBag"))
    public void addressVerification() {
        System.out.println("addressVerification is called");
        addressPageObject.clickOnOldAddress();
        sleep(2000);
       addressPageObject.deleteProductCODNotAvailable();
        sleep(4000);
//        addressPageObject.createNewAddress("testing");
        addressPageObject.clickOnProceedToPayment();
        sleep(2500);
    }



    @AfterClass(alwaysRun = true)
    public void addressVerificationAfterClass() {
        System.out.println("addressVerificationAfterclass is called");
    }



}
