package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;
import utils.WebAppBaseClass;

public class Search extends WebAppBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homepageobject;



    @BeforeClass(alwaysRun = true)
    public void searchBeforeClass() throws Exception {
        System.out.println("SearchBeforeClass is called");
        androidDriver=getBaseDriver();
        homepageobject=new HomePageObjects(androidDriver);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifySearchingObject(){
        System.out.println("Control come to verifySeearchingObject");
        homepageobject.searchForObject("Shirts");
    }



    @AfterClass(alwaysRun = true)
    public void searchAfterClass(){
        System.out.println("searchAfterClass is called");
    }


}
