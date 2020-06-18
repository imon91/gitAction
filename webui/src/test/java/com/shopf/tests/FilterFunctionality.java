package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.LatestPageObjects;
import pageObjects.PLPPageObject;
import utils.WebBaseClass;

public class FilterFunctionality extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private LatestPageObjects latestPageObjects;
    private PLPPageObject plpPageObject;



    @BeforeClass(alwaysRun = true)
    public void filterfunctionBeforeClass() throws Exception {
        System.out.println("FilterFunctionBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        plpPageObject = new PLPPageObject(driver);
    }


    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void filterFunction() {
        System.out.println("FilterFunction is called");
        plpPageObject.clickOnMenShirt();
        sleep(1000);
        plpPageObject.clickOnPrice();
        sleep(1000);
        plpPageObject.clickOnDiscount();
        sleep(1000);
    }



    @AfterClass(alwaysRun = true)
    public void filterFunctionAfterClass() {
        System.out.println("filterFunctionalityAfterclass is called");
    }


}
