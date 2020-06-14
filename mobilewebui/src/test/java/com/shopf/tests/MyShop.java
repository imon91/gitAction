package com.shopf.tests;

import coreUtils.CoreConstants;
import org.testng.annotations.*;
import utils.WebAppBaseClass;

public class MyShop extends WebAppBaseClass {



    @BeforeClass(alwaysRun = true)
    public void myShopBeforeClass() {
        System.out.println("MyShopBeforeClass is called");
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void someTest(){
        System.out.println("Control came to someTest");
    }



    @AfterClass(alwaysRun = true)
    public void myShopAfterClass() {
        System.out.println("MyShopAfterClass is called");
    }


}
