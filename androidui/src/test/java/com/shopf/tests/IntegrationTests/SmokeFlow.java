package com.shopf.tests.integrationTests;

import com.shopf.tests.*;
import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.OrderSuccessFulPageObjects;
import utils.AndroidBaseClass;

public class SmokeFlow extends AndroidBaseClass {

    private Authentication authentication;
    private MyBag myBag;
    private MyShop myShop;
    private PDP pdp;
    private PLP plp;
    private Search search;
    private Logout logout;
    private AndroidDriver<WebElement> androidDriver;
    private OrderSuccessFulPageObjects orderSuccessFulPageObjects;
    private ActionBarObjects actionBarObjects;


    @BeforeClass(alwaysRun = true)
    public void smokeTestBeforeClass(){
        System.out.println("Smoke Test Started");
        androidDriver = getBaseDriver();
        authentication = new Authentication();
        myBag = new MyBag();
        myShop = new MyShop();
        pdp = new PDP();
        plp = new PLP();
        search = new Search();
        logout = new Logout();
        orderSuccessFulPageObjects = new OrderSuccessFulPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        setImplicitWait(30);
    }


    @Test( groups = CoreConstants.GROUP_SMOKE)
    public void smokeTest() throws Exception {
        authentication.authenticationSetUp();
        sleep(4000);

        //Step 1 : Login with valid credentials
        authentication.verifyAuthenticationWithValidCredentials("1877755590","666666");
//        myShop.myShopSetUp();
//        sleep(6000);

        //Step 2 : Adding a new collection
        //myShop.verifyAddingNewCollection();
        search.searchBeforeClass();

        //Step 3 : Searching for an object from search icon without choosing from suggestions list
        search.verifySearchFunctionalityWithoutSelectingSuggestions("shirts");
        plp.productListingPageBeforeClass();

        //Step 4 : Sorting the product list
        //plp.verifyApplyingSortOnPLP();

        //Step 5 : Filtering the product list
        plp.verifyApplyingFilterOnPLP("Category","Men Shirts");

        //Step 6 : Selecting a product with valid size from the list
        plp.verifySelectingValidSizeItemOnPLP();
        pdp.productDescriptionPageBeforeClass();

        //Step 7 : Adding a Item to myBag
        //pdp.verifyAddItemToMyShopThroughPDP();

        //Step 8 : Adding the product to myBag by placeorder
        pdp.verifyPlaceOrderThroughPDP();
        myBag.myBagBeforeClass();
        sleep(4000);

        //Step 9 : Increasing the product quantity
        myBag.verifyItemIncrementFunctionalityOnMyBag();

        //Step 10 : Applying Shipping Charges
        myBag.verifyApplyingShippingCharges();

        //Step 11 : Proceeding order
        myBag.verifyPlaceOrderInMyBag();

        //Step 12 : Selecting an address
        myBag.verifySelectAddressInMyBag();

        //Step 13 : Proceed to checkout
        myBag.verifyCheckoutProceedInMyBag();

        //Step 14 : Proceed payment
        myBag.verifyProceedPaymentWithoutChangeAddress();

        sleep(4000);
        orderSuccessFulPageObjects.clickOnClickHereButton();

        //actionBarObjects.clickOnShopUpAppIcon();

        //Step 15 : Logging out
        logout.logoutBeforeClass();
        logout.verifyLogoutFunctionality();
    }


    @AfterClass(alwaysRun = true)
    public void smokeTestAfterClass(){
        System.out.println("SmokeTest completed");
    }
}
