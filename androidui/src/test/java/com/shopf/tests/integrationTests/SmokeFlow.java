package com.shopf.tests.integrationTests;

import com.shopf.tests.*;
import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
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
    private ProductListingPageObjects productListingPageObjects;
    private ActionBarObjects actionBarObjects;
    private String app;
    private String plp_view;
    private final String NEW_PLP_VIEW = "New";
    private final String OLD_PLP_VIEW = "Old";


    @BeforeClass(alwaysRun = true)
    public void smokeTestBeforeClass(){
        System.out.println("Smoke Test Started");
        app = System.getProperty(BuildParameterKeys.KEY_APP);
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
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        plp_view = productListingPageObjects.plpView;
        setImplicitWait(15);
    }


    @DataProvider(name = "dataForSmokeTest")
    public Object[][] dataForSmokeTest(){
        String category = null;
        String subCategory = null;
        String mobileNumber = null;
        String otp = null;
        String searchTerm = null;
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            mobileNumber = "1877755590";
            otp = "666666";
            searchTerm = "Shirts";
            category = "Category";
            subCategory = "Men Shirts";
        }else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            mobileNumber = "1877755590";
            otp = "666666";
            searchTerm = "Dettol";
            category = "Category";
            subCategory = "Household Cleaners";
        }
        return new Object[][]{
                {mobileNumber,otp,searchTerm,category,subCategory}
        };
    }


    @Test( groups = CoreConstants.GROUP_SMOKE,dataProvider = "dataForSmokeTest")
    public void smokeTest(String mobileNumber,String otp
            ,String searchTerm,String filterCategory
            ,String categoryItem) throws Exception {
        authentication.authenticationSetUp();
//        sleep(4000);

        //Step 1 : Login with valid credentials
        authentication.verifyAuthenticationWithValidCredentials(mobileNumber,otp);
//        myShop.myShopSetUp();
//        sleep(6000);

        //Step 2 : Adding a new collection
        //myShop.verifyAddingNewCollection();
        search.searchBeforeClass();

        //Step 3 : Searching for an object from search icon without choosing from suggestions list
        search.verifySearchFunctionalityWithoutSelectingSuggestions(searchTerm);
        plp.productListingPageBeforeClass();

        //Step 4 : Sorting the product list
        plp.verifyApplyingSortOnPLP();

        //Step 5 : Filtering the product list
        plp.verifyApplyingFilterOnPLP(categoryItem,filterCategory);

        //Step 6 : Selecting a product with valid size from the list
        plp.verifySelectingValidSizeItemOnPlpToPDP();

        pdp.productDescriptionPageBeforeClass();

        //Step 7 : Adding a Item to myBag
        //pdp.verifyAddItemToMyShopThroughPDP();

//        Step 8 : Adding the product to myBag by placeOrder
        pdp.verifyPlaceOrderThroughPDP();
        myBag.myBagBeforeClass();
//        sleep(4000);
//
        if(plp_view.equalsIgnoreCase(OLD_PLP_VIEW)){
            //Step 9 : Increasing the product quantity
            myBag.verifyItemIncrementFunctionalityOnMyBag();

            //Step 10 : Applying Shipping Charges
            myBag.verifyApplyingShippingCharges();
        }

//        //Step 11 : Proceeding order
        myBag.verifyPlaceOrderInMyBag();
//
//        //Step 12 : Selecting an address
        myBag.verifySelectAddressInMyBag();
//
//        //Step 13 : Proceed to checkout
        myBag.verifyCheckoutProceedInMyBag();
//
        if(plp_view.equalsIgnoreCase(OLD_PLP_VIEW)){
            //        //Step 14 : Proceed payment
            myBag.verifyProceedPaymentWithoutChangeAddress();
//
        sleep(4000);
        orderSuccessFulPageObjects.clickOnClickHereButton();
//
        actionBarObjects.clickOnShopUpAppIcon();
//
//        //Step 15 : Logging out
        logout.logoutBeforeClass();
        logout.verifyLogoutFunctionality();
        }
    }


    @AfterClass(alwaysRun = true)
    public void smokeTestAfterClass(){
        System.out.println("SmokeTest completed");
        quitBaseDriver();
    }
}
