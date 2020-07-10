package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.MyShopPageObjects;
import utils.WebBaseClass;


public class MyShop extends WebBaseClass {

    private WebDriver driver;
    private MyShopPageObjects myShopPageObjects;
    private ActionBarObjects actionBarObjects;

    @BeforeClass(alwaysRun = true)
    public void myShopBeforeClass() throws Exception {
        System.out.println("myShopBeforeClass is called");
        driver = getBaseDriver();
        myShopPageObjects = new MyShopPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
    }


    @Test(groups ={"verify adding new colection",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void verifyAddingNewCollection() {
        System.out.println("VerifyAddingNewCollecton is called");
//        actionBarObjects.clickOnMyshopButton();
//        String collectionName = myShopPageObjects.createNewCollection();
//        System.out.println("The created collection name was:"+collectionName);
    }


    @AfterClass(alwaysRun = true)
    public void myShopAfterClass() {
        System.out.println("myShopAfterClass is called");
    }

}
