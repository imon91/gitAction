package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        plpPageObject = new PLPPageObject(driver);
        myShopPageObjects = new MyShopPageObjects(driver);
        bagPageObjects = new BagPageObjects(driver);
    }



    @Test(groups = {"MyShop.VerifyAddProductToBagThroughCollection",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("PDP.VerifyAddToMyShop"))
    public void addToBagThroughCollection() {
        System.out.println("VerifyAddToBagThroughCollection is called");
        //get index
//        int sizeIndex=Integer.parseInt(System.getProperty("index"));
//        //product name
//        String productNameAtCollection =  myShopPageObjects.orderProduct(1,++sizeIndex);
//        sleep(2500);
//        System.out.println("Product Name At Collection : "+productNameAtCollection);
//        //click on product by name
//        int indexOfProduct = bagPageObjects.specialFindingIndexOfShirtByName(productNameAtCollection);
//        System.out.println("The index of product which selected:"+indexOfProduct);
//        sleep(4000);
//        bagPageObjects.viewProduct(indexOfProduct);
//        sleep(2000);
    }



    @AfterClass(alwaysRun = true)
    public void addToBagCollectionAfterClass() {
        System.out.println("addToBagThroughCollectionAfterclass is called");
    }


}





