package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.LatestPageObjects;
import pageObjects.PDPPageObject;
import pageObjects.PLPPageObject;
import utils.WebBaseClass;

public class AddItemToMyshop extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PLPPageObject plpPageObject;
    private PDPPageObject pdpPageObject;



    @BeforeClass(alwaysRun = true)
    public void addToMyshopFunctionBeforeClass() throws Exception {
        System.out.println("addToMyshopFunctionBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        plpPageObject = new PLPPageObject(driver);
        pdpPageObject = new PDPPageObject(driver);
    }



    @Test(groups = {"PDP.VerifyAddToMyShop",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("PDP.VerifyItemInPDP"))
    public void verifyAddToMyshopFunction() {
        System.out.println("VerifyAddToMyshopFunction is called");
//        pdpPageObject.clickOnAddToMyshopButton();
//        String collectionName = pdpPageObject.addToMyshopNewCollection();
//        System.out.println("Product added to collection:"+collectionName);
//        actionBarObjects.clickOnMyshopButton();
//        sleep(3000);
//        pdpPageObject.clickNewlyAddedCollection();
//        sleep(2500);
    }



    @AfterClass(alwaysRun = true)
    public void addToMyshopFunctionAfterClass() {
        System.out.println("addToMyshopFunctionAfterclass is called");
    }


}


