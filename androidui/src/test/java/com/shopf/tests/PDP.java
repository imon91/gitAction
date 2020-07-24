package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;


public class PDP extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private ProductDescriptionPageObjects productDescriptionPageObjects;
    private ProductDescriptionPageObjects.PDPTutorial pdpTutorial;
    private ProductDescriptionPageObjects.BottomSheetHolder bottomSheetHolder;
    private ActionBarObjects actionBarObjects;
    private ProductDescriptionPageObjects.NewProductDescriptionObjects newProductDescriptionObjects;
    private String plp_view;
    private final String NEW_PLP_VIEW = "New";
    private final String OLD_PLP_VIEW = "Old";




    @BeforeClass(alwaysRun = true)
    public void productDescriptionPageBeforeClass(){
        System.out.println("PDPBeforeClass is called");
        androidDriver = getBaseDriver();
        productDescriptionPageObjects = new ProductDescriptionPageObjects(androidDriver);
        pdpTutorial = productDescriptionPageObjects.new PDPTutorial(androidDriver);
        bottomSheetHolder = productDescriptionPageObjects.new BottomSheetHolder(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        newProductDescriptionObjects = productDescriptionPageObjects.new NewProductDescriptionObjects(androidDriver);
        plp_view = new ProductListingPageObjects(androidDriver).plpView;
        if(plp_view.equalsIgnoreCase(OLD_PLP_VIEW)){
            pdpTutorial.clickOnGotItButton();
        }
    }




    @Test(  groups = {"PDP.verifyAddItemToMyShopThroughPDP",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Adding Product to Collection",
            dependsOnGroups = "PLP.verifySelectingValidSizeItemOnPLP"  )
    public void verifyAddItemToMyShopThroughPDP(){
        System.out.println("Current Activity at PDP is : "+androidDriver.currentActivity());
        sleep(1000);
       productDescriptionPageObjects.clickOnAddToMyShopButton();
        sleep(1000);
       productDescriptionPageObjects.selectCollectionToAddProduct();
    }


    @Test(   groups = {"PDP.verifyImageZoomOfProduct",
             CoreConstants.GROUP_SANITY,
             CoreConstants.GROUP_FUNCTIONAL,
             CoreConstants.GROUP_REGRESSION},
             description = "verify Image Zoom Of a Product",
            dependsOnGroups = "PLP.verifySelectingValidSizeItemOnPLP")
    public void verifyImageZoomOfProduct(){
        productDescriptionPageObjects.clickOnImagePageHolder();
        //productDescriptionPageObjects.clickOnImagePageViewer();
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
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            enabled = false,
            description = "Verifies Applying Product To Cart/Bag",
            dependsOnMethods = "verifyImageZoomOfProduct"  )
    public void verifyAddItemToBagThroughPDP(){
        sleep(1000);
//        String bagItemCount = actionBarObjects.getTextFromCartCountHolder();
        productDescriptionPageObjects.clickOnPlaceOrderButton();
        sleep(1000);
        productDescriptionPageObjects.
                selectGivenSizeFromSizeList(Integer.parseInt(System.getProperty("validProductSizeIndex")));
        System.out.println("Current Activity at PDP is : "+androidDriver.currentActivity());
//        Random random = new Random();
//        int count = random.nextInt(10);
//        System.out.println("Count is : "+count);
//        bottomSheetHolder.enterProductQuantity(count);

        //Enter Sale Price
        bottomSheetHolder.enterSalePriceEditText(System.getProperty("minSalePrice"));

        sleep(1000);
        bottomSheetHolder.clickOnAddToBagButton();
//        Assert.assertEquals(
//                Integer.parseInt(actionBarObjects.getTextFromCartCountHolder()),
//                Integer.parseInt(bagItemCount)+1);
        sleep(1000);


    }



    @Test(  groups = {"PDP.verifyPlaceOrderThroughPDP",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Applying Product To Cart/Bag",
            dependsOnMethods = "verifyImageZoomOfProduct"  )
    public void verifyPlaceOrderThroughPDP(){
        if(plp_view.equalsIgnoreCase(NEW_PLP_VIEW)){
            newProductDescriptionObjects.clickOnAddTOCartButton(1);
            newProductDescriptionObjects.clickOnActionGotToCartButton();
        }else {
            sleep(3000);
            productDescriptionPageObjects.clickOnPlaceOrderButton();
            sleep(1000);
            productDescriptionPageObjects.
                    selectGivenSizeFromSizeList(Integer.parseInt(System.getProperty("validProductSizeIndex")));
            sleep(1000);
            //Enter Sale Price
            bottomSheetHolder.enterSalePriceEditText(System.getProperty("minSalePrice"));
            sleep(1000);
            // Click on PlaceOrder
            productDescriptionPageObjects.clickOnPlaceOrderButton();
        }
    }


    @AfterClass(alwaysRun = true)
    public void productDescriptionPageAfterClass(){
        System.out.println("ProductDescriptionPageAfterClass is called");
    }
}
