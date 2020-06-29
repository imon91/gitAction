package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.MyActions;

import static utils.AndroidBaseClass.*;

import java.util.List;
import java.util.Random;


public class MyShop {



    private AndroidDriver<AndroidElement> androidDriver;
    private BottomNavigationObjects bottomNavigationObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private MyShopPageObjects myShopPageObjects;
    MyActions myActions;



   @BeforeClass(alwaysRun = true)
    public void myShopSetUp() throws Exception{
       System.out.println("MyShopBeforeClass is called");
       androidDriver = getBaseDriver();
       setImplicitWait(30);
       // Make a call to scriptRouter to get control on MyShop
       // getTheControlToMyShop();
       // 1) First get the current page/activity/Context = HomePage
       // 2) HomePages
       // 3) Search for possibilities(RootCoded)
       // Navigated to MyShop

       bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
       actionBarObjects = new ActionBarObjects(androidDriver);
       rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
       myShopPageObjects = new MyShopPageObjects(androidDriver);
       myActions = new MyActions();

       // Get The List Of Collections
       //new ShopUpPostMan(CoreConstants.MODULE_ANDROID_UI).

   }



   @Test(  groups = {"MyShop.verifyAddingNewCollection",
           CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
           enabled = false,
            description = "Verifies Adding New Collection",
            dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials"  )
    public void verifyAddingNewCollection(){
       System.out.println("Current Activity at MyShop is : "+androidDriver.currentActivity());
        Random random = new Random();
        //int decider = random.nextInt(4);
        int decider = 3;
        System.out.println("Decider is : "+decider);
        if(decider!=4){
            bottomNavigationObjects.clickOnBottomBarMyShopIcon();
        }else {
            actionBarObjects.clickOnUserProfileImageButton();
            rightNavigationDrawer.clickOnItemMyShop();
        }
        // Switch To WebView
        Boolean context = switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        if(context){
            String collectionName = myShopPageObjects.createNewCollection();
            System.out.println("New collection created is : "+collectionName);
            /* Verify the Added Collection Part By Calling
            / the Api that gives List of collections for this user*/
            System.out.println("Current URL at MyShop is : "+androidDriver.getCurrentUrl());
            // Here the position is asserted for 1 : Because New collection has to be created always at this position
            Assert.assertEquals(myShopPageObjects.getPositionOfCollectionName(collectionName),1);

        }else {
            System.out.println("Switch Context to Web Failed");
        }
        switchFromWebToNative();
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Creates a collection and verifies the empty collection"  )
    public void verifyEmptyCollection(){
        verifyAddingNewCollection();

    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Cancel Collection Functionality"  )
    public void verifyCancelCollection(){

    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION,
            CoreConstants.GROUP_SANITY},
            description = "Verifies Delete Collection Functionality"  )
    public void verifyDeleteCollection(){
        bottomNavigationObjects.clickOnBottomBarMyShopIcon();
        // Switch To WebView
        Boolean context = switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        if(context){
            String collectionName = myShopPageObjects.deleteCollection(0);
            System.out.println("Deleted collection is "+collectionName);
        }else{
            System.out.println("Switch Context to Web Failed");
        }
        switchFromWebToNative();
    }



    @AfterClass(alwaysRun = true)
    public void myShopAfterClass(){
        System.out.println("MyShopAfterClass is called");
        switchFromWebToNative();
    }



}
