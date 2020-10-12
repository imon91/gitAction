package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class Search extends WebAppBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homepageobject;
    private String app;



    @BeforeClass(alwaysRun = true)
    public void searchBeforeClass() throws Exception {
        System.out.println("SearchBeforeClass is called");
        androidDriver=getBaseDriver();
        homepageobject=new HomePageObjects(androidDriver);
        app = getAppName();
    }



    @DataProvider(name = "getProductName")
    public Object[][] getProductName(){
        String searchTerm = null;
        if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            searchTerm = "Biscuit";
        }else if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            searchTerm = "Shirts";
        }
        return new Object[][]{
                {searchTerm}
        };
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE},
                    dataProvider = "getProductName")
    public void verifySearchingObject(String productName){
        System.out.println("Control come to verifySearchingObject");
        System.setProperty("searchTerm",productName);
        homepageobject.searchForObject(productName);
        String currentPage = androidDriver.getCurrentUrl();
        Assert.assertTrue(currentPage.equalsIgnoreCase(WAPConstants.SEARCH_FOR_TERM+productName));
        System.out.println("Control is in search page");
    }



    @AfterClass(alwaysRun = true)
    public void searchAfterClass(){
        System.out.println("searchAfterClass is called");
    }


}
