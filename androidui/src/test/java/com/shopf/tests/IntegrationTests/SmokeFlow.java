package com.shopf.tests.IntegrationTests;

import com.shopf.tests.*;
import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import utils.AndroidBaseClass;

public class SmokeFlow extends AndroidBaseClass {

    private Authentication authentication = new Authentication();
    private MyBag myBag = new MyBag();
    private MyShop myShop = new MyShop();
    private PDP pdp = new PDP();
    private PLP plp = new PLP();
    private Search search = new Search();
    private Logout logout = new Logout();
    private AndroidDriver<AndroidElement> androidDriver;


    @BeforeClass
    public void smokeTestBeforeClass() throws Exception {
        androidDriver = getBaseDriver();
        setImplicitWait(10);
    }


    @Test( groups = CoreConstants.GROUP_SMOKE)
    public void smokeTest() throws Exception {
        authentication.authenticationSetUp();
        sleep(4000);

        //Step 1 : Login with valid credentials
        authentication.verifyAuthenticationWithValidCredentials("1877755590","666666");
        myShop.myShopSetUp();
        sleep(6000);

        //Step 2 : Adding a new collection
        //myShop.verifyAddingNewCollection();
        search.searchBeforeClass();

        //Step 3 : Searching for an object from search icon without choosing from suggestions list
        search.verifySearchFunctionalityWithoutSelectingSuggestions("shirts");
        plp.productListingPageBeforeClass();

        //Step 4 : Sorting the product list
        plp.verifyApplyingSortOnPLP();

        //Step 5 : Filtering the product list
        plp.verifyApplyingFilterOnPLP();

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
        logout.logoutBeforeClass();

        //Step 15 : Logging out
        logout.verifyLogoutFunctionality();
    }


    @AfterClass
    public void smokeTestAfterClass(){
        System.out.println("SmokeTest completed");
    }
}
