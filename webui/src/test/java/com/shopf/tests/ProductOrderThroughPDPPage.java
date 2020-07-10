package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.PDPPageObject;
import pageObjects.PLPPageObject;
import utils.WebBaseClass;

public class ProductOrderThroughPDPPage extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PLPPageObject plpPageObject;
    private PDPPageObject pdpPageObject;
    private Actions actions;



    @BeforeClass(alwaysRun = true)
    public void orderThroughPDPPageBeforeClass() throws Exception {
        System.out.println("orderThroughPDPPageBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        plpPageObject = new PLPPageObject(driver);
        pdpPageObject = new PDPPageObject(driver);
        actions = new Actions(driver);
    }



    @Test(groups = {"PDP.ProductOrderThroughPDP",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("MyShop.VerifyAddProductToBagThroughCollection"))
    public void verifyOrderThroughPDPPage() {
//        actions.sendKeys(Keys.ESCAPE).build().perform();
//        sleep(2500);
        int index = Integer.parseInt(System.getProperty("index"));
        pdpPageObject.selectSize(++index);
        sleep(500);
        pdpPageObject.clickOnOrderNowButtonPDPPage();
    }



    @AfterClass(alwaysRun = true)
    public void orderThroughPDPPageAfterClass() {
        System.out.println("orderThroughPDPPageAfterclass is called");
    }




}
