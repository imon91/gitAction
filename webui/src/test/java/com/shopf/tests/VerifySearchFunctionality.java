package com.shopf.tests;


import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
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


    @DataProvider(name = "getProductName")
    public Object[][] getProductName() {
        String searchTerm = "shirt";
        return new Object[][]{{searchTerm}};
    }

    @Test(groups = {"Search.SearchToObjectNotSelectSuggessions",
            CoreConstants.GROUP_SMOKE},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "verifySearchToObjectNotSelectingSuggessions",
            dataProvider = "getProductName")
    public void verifySearchToObjectNotSelectSuggessions(String objectName) throws InterruptedException {
        System.out.println("VerifySearchToObject is called");
        System.setProperty("webSearchTerm",objectName);
        sleep(3000);
        actionBarObjects.searchToObject(objectName);
        latestPageObjects.totalNumberOFItems();
        sleep(5000);
    }



    @AfterClass(alwaysRun = true)
    public void searchFunctionAfterClass() {
        System.out.println("searchFunctionalityAfterclass is called");
    }


}


