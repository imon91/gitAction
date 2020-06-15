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
    private ActionBarObjects actionBarObjects;
    private MyShopPageObjects myShopPageObjects;



    @BeforeClass(alwaysRun = true)
    public void myShopBeforeClass() throws Exception{
        System.out.println("myShopBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        myShopPageObjects = new MyShopPageObjects(driver);
    }



    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void verifyAddingNewCollection(){
        System.out.println("Verify Adding New Collection Is Called");
        myShopPageObjects.clickOnMyshopOption();
        String collectionName = myShopPageObjects.createNewCollection();
        System.out.println("New Collection added is : " + collectionName);
    }


    @AfterClass(alwaysRun = true)
    public void myShopAfterClass(){
        System.out.println("myShopAfterClass is called");
    }

}
