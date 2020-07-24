package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.LatestPageObjects;
import pageObjects.PDPPageObject;
import pageObjects.PLPPageObject;
import utils.MyActions;
import utils.WebBaseClass;


public class VerifyItemInPDPPage extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private LatestPageObjects latestPageObjects;
    private PLPPageObject plpPageObject;
    private PDPPageObject pdpPageObject;
    private MyActions myActions;



    @BeforeClass(alwaysRun = true)
    public void VerifyItemInPDP_PageBeforeClass() throws Exception {
        System.out.println("VerifyItemInPDP_PageBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        latestPageObjects = new LatestPageObjects(driver);
        plpPageObject = new PLPPageObject(driver);
        pdpPageObject=new PDPPageObject(driver);
    }



    @Test(groups = {"PDP.VerifyItemInPDP",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("PLP.VerifySelectiongValidSizeProduct"))
    public void VerifyItemInPDP_Page() {
        System.out.println("VerifyItemInPDP_Page is called");
        String productNameInPLP = System.getProperty("productNameInPLP");
        String productNameInPDP = pdpPageObject.getProductName();
        if(productNameInPLP.equalsIgnoreCase(productNameInPDP)){
            System.out.println("ProductWasVerified");
        }

    }



    @AfterClass(alwaysRun = true)
    public void VerifyItemInPDP_PageAfterClass() {
        System.out.println("VerifyItemInPDP_PageAfterclass is called");
    }


}
