package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.testng.annotations.*;
import pageObjects.ToolBarObjects;
import utils.AndroidBaseClass;

public class Checkout extends AndroidBaseClass {


    private AndroidDriver<AndroidElement> androidDriver;
    private ToolBarObjects toolBarObjects;



    @BeforeClass(alwaysRun = true)
    public void productDescriptionPageBeforeClass() throws Exception{
        System.out.println("PDPBeforeClass is called");
        androidDriver = getBaseDriver();
        setImplicitWait(30);
    }




    @Test(  groups = {"PDP.verifyAddItemToMyShopThoughPDP",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Adding Product to Collection",
            dependsOnGroups = "MyBag.verifyProceedPaymentWithoutChangeAddress")
    public void testMethod(){
        sleep(1000);
        toolBarObjects.navigateBack();
    }



}
