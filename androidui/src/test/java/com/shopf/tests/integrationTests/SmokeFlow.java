package com.shopf.tests.integrationTests;

import com.shopf.tests.*;
import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;



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
    private ServiceRequestLayer serviceRequestLayer;


    @BeforeSuite(alwaysRun = true)
    public void smokeBeforeSuite(){
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication()
                .performAuthentication();
    }


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



    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 1)
    public void performAuthenticationWithValidCredentials() throws Exception {
        authentication.authenticationSetUp();
        authentication.verifyAuthenticationWithValidCredentials("01877755590", "666666");
    }

    
    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 2)
    public void searchToObject(){
        search.searchBeforeClass();
        actionBarObjects.clickOnSearchImageButton();
        search.verifySearchFunctionalityWithoutSelectingSuggestions("Shirt");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},enabled = false,priority = 3)
    public void verifyApplyingSortOnPLP() throws Exception {
        plp.productListingPageBeforeClass();
        plp.verifyApplyingSortOnPLP();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 4)
    public void verifyApplyingFilterOnPLP()
    {
        plp.verifyApplyingFilterOnPLP(null,null);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 5)
    public void verifySelectingValidProduct(){
        plp.verifySelectingValidSizeItemOnPlpToPDP();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 6)
    public void verifyPlaceOrderThroughPDP(){
        pdp.productDescriptionPageBeforeClass();
        pdp.verifyPlaceOrderThroughPDP();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 7)
    public void verifyProductIncrementInMyBag() throws Exception {
             myBag.myBagBeforeClass();
            myBag.verifyItemIncrementFunctionalityOnMyBag();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 8)
    public void verifyApplyShippingChargeInMyBag()
    {
        myBag.verifyApplyingShippingCharges();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 9)
    public void verifyPlaceOrderInMyBag()
    {
        myBag.verifyPlaceOrderInMyBag();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 10)
    public void verifyDeletingCodDisabledProductInAddress()
    {  sleep(4000);
        myBag.deleteProductWithCODDisabled();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 11)
    public void verifySelectAddress()
    {
        myBag.verifySelectAddressInMyBag();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 12)
    public void verifyProceedToPaymentInAddress()
    {
        myBag.verifyCheckoutProceedInMyBag();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 13)
    public void verifyCheckoutWithCOD()
    {       sleep(3500);
            myBag.verifyProceedPaymentWithoutChangeAddress();
            sleep(6000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 14)
    public void verifyOrderIdInOrderSuccessfulPage() {
        orderSuccessFulPageObjects.clickOnClickHereButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 15)
    public void verifyLogout() throws Exception {
        sleep(2800);
        logout.logoutBeforeClass();
        logout.verifyLogoutFunctionality();
    }


    @AfterSuite(alwaysRun = true)
    public void smokeTestAfterClass(){
        System.out.println("SmokeTest completed");
        quitBaseDriver();
    }


}