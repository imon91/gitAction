package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;


public class PDP extends AndroidBaseClass {

    private AndroidDriver<AndroidElement> androidDriver;
    private ProductDescriptionPageObjects productDescriptionPageObjects;
    private ProductDescriptionPageObjects.PDPTutorial pdpTutorial;
    private ProductDescriptionPageObjects.BottomSheetHolder bottomSheetHolder;
    private ActionBarObjects actionBarObjects;




    @BeforeClass(alwaysRun = true)
    public void productDescriptionPageBeforeClass() throws Exception{
        System.out.println("PDPBeforeClass is called");
        androidDriver = getBaseDriver();
        productDescriptionPageObjects = new ProductDescriptionPageObjects(androidDriver);
        pdpTutorial = productDescriptionPageObjects.new PDPTutorial(androidDriver);
        bottomSheetHolder = productDescriptionPageObjects.new BottomSheetHolder(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        pdpTutorial.clickOnGotItButton();
    }




    @Test(  groups = {"PDP.verifyAddItemToMyShopThroughPDP",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Adding Product to Collection",
            dependsOnGroups = "PLP.verifySelectingItemOnPLP"  )
    public void verifyAddItemToMyShopThroughPDP(){
//        System.out.println("Current Activity at PDP is : "+androidDriver.currentActivity());
//        sleep(3000);
//       productDescriptionPageObjects.clickOnAdToMyShopButton();
//        sleep(3000);
//       productDescriptionPageObjects.selectCollectionToAddProduct();
    }


    @Test(   groups = {"PDP.verifyImageZoomOfProduct",
             CoreConstants.GROUP_SMOKE,
             CoreConstants.GROUP_FUNCTIONAL,
             CoreConstants.GROUP_REGRESSION},
             description = "verify Image Zoom Of a Product",
             dependsOnMethods = "verifyAddItemToMyShopThroughPDP")
    public void verifyImageZoomOfProduct(){
        productDescriptionPageObjects.clickOnImagePageHolder();
        productDescriptionPageObjects.clickOnImagePageViewer();
        productDescriptionPageObjects.clickOnZoomCancelButton();
    }


    @Test
    public void verifyProductDataInPDP(){
        // Here verify if all the Details of the product are rendered as intended
    }


    @Test
    public void verifyProductDataInBottomSheet(){
        // Here verify if all the Details of the product are rendered as intended
    }


    @Test
    public void verifyProductPriceWithRespectToSelectSize(){

    }



    @Test(  groups = {"PDP.verifyAddItemToBagThroughPDP",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Applying Product To Cart/Bag",
            dependsOnMethods = "verifyImageZoomOfProduct"  )
    public void verifyAddItemToBagThroughPDP(){
        sleep(5000);
//        String bagItemCount = actionBarObjects.getTextFromCartCountHolder();
        productDescriptionPageObjects.clickOnPlaceOrderButton();
        sleep(3000);
        productDescriptionPageObjects.
                selectGivenSizeFromSizeList(Integer.parseInt(System.getProperty("validProductSizeIndex")));
        System.out.println("Current Activity at PDP is : "+androidDriver.currentActivity());
//        Random random = new Random();
//        int count = random.nextInt(10);
//        System.out.println("Count is : "+count);
//        bottomSheetHolder.enterProductQuantity(count);
        sleep(3000);
        bottomSheetHolder.clickOnAddToBagButton();
//        Assert.assertEquals(
//                Integer.parseInt(actionBarObjects.getTextFromCartCountHolder()),
//                Integer.parseInt(bagItemCount)+1);
        sleep(1000);


    }



    @Test(  groups = {"PDP.verifyPlaceOrderThroughPDP",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Applying Product To Cart/Bag",
            dependsOnMethods = "verifyAddItemToBagThroughPDP"  )
    public void verifyPlaceOrderThroughPDP(){
        //sleep(5000);
        /*productDescriptionPageObjects.clickOnPlaceOrderButton();
        //sleep(3000);
        productDescriptionPageObjects.
                selectGivenSizeFromSizeList(Integer.parseInt(System.getProperty("validProductSizeIndex")));
//        Random random = new Random();
//        int count = random.nextInt(10);
//        System.out.println("Count is : "+count);
        // Enter Amount
        sleep(3000);*/
        productDescriptionPageObjects.clickOnPlaceOrderButton();
    }


    @AfterClass(alwaysRun = true,groups = {"PDP.AfterClass"})
    public void productDescriptionPageAfterClass(){
        System.out.println("ProductDescriptionPageAfterClass is called");
    }
}
