package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.AndroidBaseClass;

public class Search extends AndroidBaseClass {

    private ActionBarObjects actionBarObjects;
    private SearchPageObjects searchPageObjects;
    private AndroidDriver<AndroidElement> androidDriver;



    @BeforeClass(alwaysRun = true)
    public void searchBeforeClass() throws Exception{
        System.out.println("SearchBeforeClass is called");
        androidDriver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(androidDriver);
        // Click On Search image Button
        actionBarObjects.clickOnSearchImageButton();
        searchPageObjects = new SearchPageObjects(androidDriver);
    }



    @DataProvider(name = "getProductName")
    public Object[][] getProductName(){
        return new Object[][]{
                {"Shirts"}
        };
    }



    @Test(  groups = {"Search.verifySearchFunctionalityWithoutSelectingSuggestions" ,
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Search Functionality Without Selecting Any Suggestions",
            dataProvider = "getProductName"  )
    public void verifySearchFunctionalityWithoutSelectingSuggestions(String productName){
        System.setProperty("androidSearchTerm",productName);
        System.out.println("verifySearchFunctionalityWithoutSelectingSuggestions is called");
        System.out.println("Current Activity at Search is : "+androidDriver.currentActivity());
        searchPageObjects.searchForTheGivenProduct(productName);
        //sleep(5000);
        // Verification Step Pending
        // Call an Api that fetches all the data related to the search
    }



    @AfterClass(alwaysRun = true)
    public void searchAfterClass(){
        System.out.println("SearchAfterClass is called");
        sleep(3000);
    }


}
