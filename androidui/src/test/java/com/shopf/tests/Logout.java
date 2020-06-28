package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;


public class Logout extends AndroidBaseClass {


    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private ToolBarObjects toolBarObjects;
    private OrderSuccessFulPageObjects orderSuccessFulPageObjects;




    @BeforeClass(alwaysRun = true)
    public void logoutBeforeClass() throws Exception{
        System.out.println("LogoutBeforeClass is called");
        androidDriver = getBaseDriver();
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        orderSuccessFulPageObjects = new OrderSuccessFulPageObjects(androidDriver);
        orderSuccessFulPageObjects.clickOnClickHereButton();
        switchFromWebToNative();
        myActions = new MyActions();
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        toolBarObjects = new ToolBarObjects(androidDriver);
//        toolBarObjects.navigateBack();
//        System.out.println("Going to Press Back Key");
//        //myActions.clickOnHardKeyBack();
//        System.out.println("Going to Press Back Key DONE");
    }


    @Test(  groups = {"Logout.verifyLogoutFunctionality",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify Logout Functionality",
            dependsOnGroups = "MyBag.verifyProceedPaymentWithoutChangeAddress")
    public void verifyLogoutFunctionality(){
        System.out.println("verifyLogoutFunctionality Started");
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
        sleep(1000);
        Assert.assertEquals(androidDriver.currentActivity(),".loginV2.LoginActivityV2");
    }



    @AfterClass(alwaysRun = true)
    public void logoutAfterClass(){
        System.out.println("LogoutAfterClass is called");
    }


}
