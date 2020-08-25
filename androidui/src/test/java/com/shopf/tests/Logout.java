package com.shopf.tests;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;


public class Logout extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private ToolBarObjects toolBarObjects;
    private OrderSuccessFulPageObjects orderSuccessFulPageObjects;




    @BeforeClass(alwaysRun = true)
    public void logoutBeforeClass() throws Exception{
        System.out.println("LogoutBeforeClass is called");
        androidDriver = getBaseDriver();
        switchFromWebToNative();
        myActions = new MyActions();
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        toolBarObjects = new ToolBarObjects(androidDriver);
        if (System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            myActions.clickOnHardKeyBack();
            myActions.clickOnHardKeyBack();
        }
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
    }



    @AfterClass(alwaysRun = true)
    public void logoutAfterClass(){
        System.out.println("LogoutAfterClass is called");
    }


}
