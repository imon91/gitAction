package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.LatestPageObjects;
import utils.MyActions;
import utils.WebBaseClass;

public class VerifySortFunctionality extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private LatestPageObjects latestPageObjects;
    private MyActions myActions;



    @BeforeClass(alwaysRun = true)
    public void sortfunctionBeforeClass() throws Exception {
        System.out.println("sortFunctionBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
       latestPageObjects = new LatestPageObjects(driver);
    }



    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void verifySortFunction() {
        System.out.println("VerifySort is called");
        latestPageObjects.clickOnSortByNewOption();
        sleep(1000);
        latestPageObjects.clickOnSortByPersonalizeOption();
        sleep(1000);
        //latestPageObjects.clickOnSortByDiscountOption();
        //sleep(1000);
       // latestPageObjects.clickOnShowThreeButton();
        //sleep(1000);
        //latestPageObjects.clickOnSortByPriceLow();
        //sleep(1000);
        //latestPageObjects.clickOnSortByPriceHigh();
    }



    @AfterClass(alwaysRun = true)
    public void sortFunctionAfterClass() {
        System.out.println("sortFunctionAfterclass is called");
    }


}
