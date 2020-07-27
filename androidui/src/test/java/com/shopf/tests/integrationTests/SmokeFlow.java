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
    private MyOrders myOrders;
    private AndroidDriver<WebElement> androidDriver;
    private OrderSuccessFulPageObjects orderSuccessFulPageObjects;
    private ProductListingPageObjects productListingPageObjects;
    private ActionBarObjects actionBarObjects;
    private MyOrdersPageObjects myOrdersPageObjects;
    private MyOrdersPageObjects.OrderDetails orderDetails;
    private String app;
    private String host;
    private String plp_view;
    private final String NEW_PLP_VIEW = "New";
    private final String OLD_PLP_VIEW = "Old";
    private ServiceRequestLayer serviceRequestLayer;


    @BeforeSuite(alwaysRun = true)
    public void smokeBeforeSuite(){
        try{
            PropertyReader.flushDynamicData();
        }catch (Exception e){
            System.out.println("Exception at SmokeBeforeSuite : flushDynamicData");
        }
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication()
                .performAuthentication();
    }


    @BeforeClass(alwaysRun = true)
    public void smokeTestBeforeClass(){
        System.out.println("Smoke Test Started");
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        host = System.getProperty(BuildParameterKeys.KEY_HOST);
        androidDriver = getBaseDriver();
        authentication = new Authentication();
        myBag = new MyBag();
        myShop = new MyShop();
        pdp = new PDP();
        plp = new PLP();
        search = new Search();
        logout = new Logout();
        myOrders = new MyOrders();
        myOrdersPageObjects = new MyOrdersPageObjects(androidDriver);
        orderDetails = myOrdersPageObjects.new OrderDetails(androidDriver);
        orderSuccessFulPageObjects = new OrderSuccessFulPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        plp_view = productListingPageObjects.plpView;
        setImplicitWait(15);
    }


    @DataProvider(name = "dataForAuthentication")
    public Object[][] dataForAuthentication(){
        String mobileNumber = null;
        String otp = null;
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            mobileNumber = "1877755590";
            otp = "666666";
        }else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            mobileNumber = "1877755590";
            otp = "666666";
        }
        return new Object[][]{
                {mobileNumber,otp}
        };
    }


    @DataProvider(name = "dataForSearchTerm")
    public Object[][] dataForSearchTerm(){
        String searchTerm=null;
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            searchTerm = "Watches";
        }else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            searchTerm = "Dettol";
        }
        return new Object[][]{
                {searchTerm}
        };
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 1,dataProvider = "dataForAuthentication")
    public void performAuthenticationWithValidCredentials(String mobileNumber,String otp) throws Exception {
        authentication.authenticationSetUp();
        authentication.verifyAuthenticationWithValidCredentials(mobileNumber,otp);
    }

    
    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 2,dataProvider = "dataForSearchTerm")
    public void searchToObject(String searchTerm){
        search.searchBeforeClass();
        actionBarObjects.clickOnSearchImageButton();
        search.verifySearchFunctionalityWithoutSelectingSuggestions(searchTerm);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 3)
    public void verifyApplyingSortOnPLP() throws Exception {
        if(host.equalsIgnoreCase("Local")){
            plp.productListingPageBeforeClass();
            plp.verifyApplyingSortOnPLP();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 4)
    public void verifyApplyingFilterOnPLP() throws Exception
    {
        plp.productListingPageBeforeClass();
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

    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 14)
    public void verifyOrderIdInOrderSuccessfulPage() {
//        orderSuccessFulPageObjects.clickOnGoTOMyOrdersButton();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 15)
    public void verifyOrderInMyOrders() throws Exception{
//        //Assert That Control is in MyOrdersPage
//        //Identify Order Number
//        myOrders.myOrdersBeforeClass();
//        orderDetails.clickOnOrderItemByIndex(0);
//                //(PropertyReader.getValueOfKey(PropertyReader.Keys.ORDER_NUMBER));
//        // Verify Order
//
//        // Come Back to HomePage
//        for(int i=0;i<2;i++){
//            new MyActions().clickOnHardKeyBack();
//        }
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 16)
    public void verifyLogout() throws Exception {
        if(host.equalsIgnoreCase("Local")){
            // Do nothing
        }else {
            sleep(2800);
            logout.logoutBeforeClass();
            logout.verifyLogoutFunctionality();
        }
    }


    @AfterSuite(alwaysRun = true)
    public void smokeTestAfterClass(){
        System.out.println("SmokeTest completed");
        quitBaseDriver();
    }


}