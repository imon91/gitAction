package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.WebBaseClass;

public class AddToBagThroughCollection extends WebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PLPPageObject plpPageObject;
    private PDPPageObject pdpPageObject;
    private MyShopPageObjects myShopPageObjects;
    private BagPageObjects bagPageObjects;



    @BeforeClass(alwaysRun = true)
    public void addToBagThroughCollectionBeforeClass() throws Exception {
        System.out.println("addingToBagThroughCollectionFunctionBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        pdpPageObject = new PDPPageObject(driver);
        myShopPageObjects = new MyShopPageObjects(driver);
        bagPageObjects = new BagPageObjects(driver);
    }



    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void addToBagThroughCollection() {
        System.out.println("VerifyAddToBagThroughCollection is called");
        myShopPageObjects.getProductName1();
        pdpPageObject.clickOnSizeL();
        myShopPageObjects.clickOnOrderNow();
        bagPageObjects.clickProduct1();
        sleep(5000);
    }



    @AfterClass(alwaysRun = true)
    public void addToBagCollectionAfterClass() {
        System.out.println("addToBagThroughCollectionAfterclass is called");
    }


}





