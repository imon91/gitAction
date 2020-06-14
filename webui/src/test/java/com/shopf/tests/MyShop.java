package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.MyShopPageObjects;
import utils.WebBaseClass;


public class MyShop extends WebBaseClass {

    private WebDriver driver;
    private MyShopPageObjects myShopPageObjects;


    @BeforeClass(alwaysRun = true)
    public void myShopBeforeClass() throws Exception{
        System.out.println("myShopBeforeClass is called");
        driver = getBaseDriver();
    }



    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void someTest(){
        System.out.println("MyShop Is Called");
        MyShopPageObjects myShopPageObjects =new MyShopPageObjects(driver);
        myShopPageObjects.createNewCollection();
    }


    @AfterClass(alwaysRun = true)
    public void myShopAfterClass(){
        System.out.println("myShopAfterClass is called");
    }

}
