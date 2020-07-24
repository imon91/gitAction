package com.shopf.wapTests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.CreateCollectionBottomSheetObjects;
import utils.WebAppBaseClass;

public class MyShop extends WebAppBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private CreateCollectionBottomSheetObjects collection;



    @BeforeClass(alwaysRun = true)
    public void myShopBeforeClass() throws Exception {
        System.out.println("MyShopBeforeClass is called");
        androidDriver=getBaseDriver();
        collection=new CreateCollectionBottomSheetObjects(androidDriver);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyAddingNewCollection(){
        System.out.println("Control came to verifyAddingNewCollection");
        collection.performAddCollection("shirts");
    }



    @AfterClass(alwaysRun = true)
    public void myShopAfterClass() {
        System.out.println("MyShopAfterClass is called");
    }


}
