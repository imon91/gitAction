package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.BottomNavigationObjects;
import pageObjects.MyShopPageObjects;
import pageObjects.RightNavigationDrawer;
import static utils.AndroidBaseClass.*;
import java.util.Random;

public class MyShop {



    private AndroidDriver<AndroidElement> androidDriver;
    private BottomNavigationObjects bottomNavigationObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private MyShopPageObjects myShopPageObjects;



   @BeforeClass(alwaysRun = true)
    public void myShopSetUp() throws Exception{
       System.out.println("MyShopBeforeClass is called");
       androidDriver = getBaseDriver();
       bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
       actionBarObjects = new ActionBarObjects(androidDriver);
       rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
       myShopPageObjects = new MyShopPageObjects(androidDriver);
   }



   @Test(  groups = {CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Adding New Collection",
            dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials"  )
    public void verifyAddingNewCollection(){

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
        }else {
            System.out.println("Switch Context to Web Failed");
        }
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
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Delete Collection Functionality"  )
    public void verifyDeleteCollection(){

    }



    @AfterClass(alwaysRun = true)
    public void updateDriverFromMyShop(){
        System.out.println("MyShopAfterClass is called");
    }



}
