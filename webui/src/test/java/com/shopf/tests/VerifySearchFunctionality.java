package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.LatestPageObjects;
import pageObjects.PDPPageObject;
import utils.WebBaseClass;



public class VerifySearchFunctionality  extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private LatestPageObjects latestPageObjects;
    private PDPPageObject pdpPageObject;



    @BeforeClass(alwaysRun = true)
    public void searchfunctionBeforeClass() throws Exception {
        System.out.println("searchFunctionBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        latestPageObjects = new LatestPageObjects(driver);
        pdpPageObject=new PDPPageObject(driver);
    }



    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"))
    public void verifySearchToObject() {
        System.out.println("VerifySearchToObject is called");
        actionBarObjects.searchToObject("shirt");
        latestPageObjects.totalNumberOFItems();
        sleep(5000);
    }



    @AfterClass(alwaysRun = true)
    public void searchFunctionAfterClass() {
        System.out.println("searchFunctionalityAfterclass is called");
    }


}
