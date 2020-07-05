package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObjects.*;
import utils.AndroidBaseClass;
import utils.MyActions;

import java.util.function.Predicate;

public class Search extends AndroidBaseClass {

    private ActionBarObjects actionBarObjects;
    private SearchPageObjects searchPageObjects;
    private AndroidDriver<AndroidElement> androidDriver;
    MyActions myActions;



    @BeforeClass(alwaysRun = true)
    public void searchBeforeClass() throws Exception{
        System.out.println("SearchBeforeClass is called");
        androidDriver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(androidDriver);
        actionBarObjects.clickOnSearchImageButton();
        searchPageObjects = new SearchPageObjects(androidDriver);
        myActions = new MyActions();
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

    @Test(  groups = {"Search.verifySearchFunctionalityWithoutSelectingSuggestions" ,
            CoreConstants.GROUP_SANITY},
            description = "Verifies click on recently viewed product")
    public void verifyRecentlyViewedProduct()
    {
        System.out.println("verification of recently viewed product was called");
        sleep(5000);
//        AndroidElement recentviewed =  androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']"));
//         myActions.action_click(recentviewed);
//        new WebDriverWait(androidDriver, 5000).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='0']")));
//        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).click();

        AndroidElement product = androidDriver.findElement(By.id("com.shopup.reseller:id/item"));
        AndroidElement productname = androidDriver.findElement(By.id("com.shopup.reseller:id/tvName"));
        String productName = myActions.action_getText(productname);
        myActions.action_click(product);
        sleep(2000);
        AndroidElement popup = androidDriver.findElementById("com.shopup.reseller:id/btnOKTutorial");
        myActions.action_click(popup);
        AndroidElement productnameatpdp = androidDriver.findElementById("com.shopup.reseller:id/product_name");
        String productNameAtPDP = myActions.action_getText(productnameatpdp);

       if(productName.equalsIgnoreCase(productNameAtPDP)){System.out.println("product was verified");}
    }





    @AfterClass(alwaysRun = true)
    public void searchAfterClass(){
        System.out.println("SearchAfterClass is called");
        sleep(3000);
    }


}
