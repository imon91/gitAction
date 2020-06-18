package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
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



    @BeforeClass(alwaysRun = true)
    public void orderThroughPDPPageBeforeClass() throws Exception {
        System.out.println("orderThroughPDPPageBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        plpPageObject = new PLPPageObject(driver);
        pdpPageObject = new PDPPageObject(driver);
    }



    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void verifyOrderThroughPDPPage() {
        pdpPageObject.clickOnSizeL();
        pdpPageObject.clickOnOrderNowButtonPDPPage();
    }



    @AfterClass(alwaysRun = true)
    public void orderThroughPDPPageAfterClass() {
        System.out.println("orderThroughPDPPageAfterclass is called");
    }




}
