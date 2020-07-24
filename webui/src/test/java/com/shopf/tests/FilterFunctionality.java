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
import pageObjects.PLPPageObject;
import utils.MyActions;
import utils.WebBaseClass;

public class FilterFunctionality extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private LatestPageObjects latestPageObjects;
    private PLPPageObject plpPageObject;
    private MyActions myActions;



    @BeforeClass(alwaysRun = true)
    public void filterfunctionBeforeClass() throws Exception {
        System.out.println("FilterFunctionBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        plpPageObject = new PLPPageObject(driver);
    }


    @Test(groups = {"PLP.VerifyFilterFunctionality",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("Search.SearchToObjectNotSelectSuggessions"))
    public void filterFunction() {
        System.out.println("FilterFunction is called");
        plpPageObject.clickOnMenShirt();
        sleep(1000);
//        plpPageObject.clickOnPrice();
//        sleep(1000);
//        plpPageObject.clickOnSizeL();
//        sleep(1000);
    }



    @AfterClass(alwaysRun = true)
    public void filterFunctionAfterClass() {
        System.out.println("filterFunctionalityAfterclass is called");
    }


}
