package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.ToolBarObjects;
import utils.AndroidBaseClass;

public class Checkout extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private ToolBarObjects toolBarObjects;



    @BeforeClass(alwaysRun = true)
    public void productDescriptionPageBeforeClass(){
        System.out.println("PDPBeforeClass is called");
        androidDriver = getBaseDriver();
        toolBarObjects = new ToolBarObjects(androidDriver);
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
