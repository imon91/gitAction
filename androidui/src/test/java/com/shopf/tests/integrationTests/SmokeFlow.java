package com.shopf.tests.integrationTests;

import com.shopf.tests.*;
import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import java.util.Random;


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
    private PaymentModePageObjects paymentModePageObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private MyActions myActions;
    private String app;
    private String host;
    private String mokamUser;
    private String plp_view;
    private final String NEW_PLP_VIEW = "New";
    private final String OLD_PLP_VIEW = "Old";
    private ServiceRequestLayer serviceRequestLayer;
    private SalesRepFeature salesRepFeature;
    private SalesRepFeaturePageObject salesRepFeaturePageObject;
    private Random random;


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
        mokamUser = System.getProperty(BuildParameterKeys.KEY_USER);
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
        paymentModePageObjects = new PaymentModePageObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        myActions = new MyActions();
        plp_view = productListingPageObjects.plpView;
        salesRepFeaturePageObject = new SalesRepFeaturePageObject(androidDriver);
        salesRepFeature = new SalesRepFeature();
        paymentModePageObjects = new PaymentModePageObjects(androidDriver);
        myActions = new MyActions();
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        random = new Random();
        setImplicitWait(15);
    }


    @DataProvider(name = "dataForAuthentication")
    public Object[][] dataForAuthentication(){
        String mobileNumber = null;
        String otp = null;
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            mobileNumber = "1877755590";
            otp = "666666";
        }
        else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            mobileNumber = "1877755590";
            otp = "666666";
        } else if(System.getProperty(BuildParameterKeys.KEY_USER).equalsIgnoreCase(CoreConstants.MOKAM_USER))
        {
            mobileNumber = "1877775590";
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
//        salesRepFeaturePageObject.performAuthentication("01877755590","666666");
    }
  
  @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 2)
    public void verifyAddingRetailer()
    {  if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
        try{
            if (mokamUser.equalsIgnoreCase(CoreConstants.MOKAM_USER)) {
        salesRepFeature.salesRepPageBeforeClass();
        salesRepFeature.verifyAddingRetailer();
         sleep(4000);}
        }
        catch (NullPointerException e){
            sleep(500);
        }
    }}
  

     @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 3)
    public void performChangeLanguage(){
            switchFromWebToNative();
            actionBarObjects.clickOnUserProfileImageButton();
            rightNavigationDrawer.clickOnItemChangeLanguage();
            rightNavigationDrawer.selectEnglish();
            rightNavigationDrawer.saveLanguage();
            sleep(5000);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 4)
    public void verifyAddedRetailer()
    {if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
        try {
            if (mokamUser.equalsIgnoreCase(CoreConstants.MOKAM_USER)) {
                salesRepFeature.verifyAddedRetailer();
            }
        }catch (NullPointerException e){
            sleep(500);
        }
    }}

    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 5)
    public void verifyRetailerSwitch()
    {if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
        try {
            if (mokamUser.equalsIgnoreCase(CoreConstants.MOKAM_USER)) {
                salesRepFeature.verifyRetailerSwitch();
                sleep(3000);
            }
        }catch (NullPointerException e){
            sleep(500);
        }
    }}

    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 6)
    public void verifyEditProfile()
    {if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
        try {
        if (mokamUser.equalsIgnoreCase(CoreConstants.MOKAM_USER))
        {
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemMyAccount();
        rightNavigationDrawer.clickProfileEditButton();
        rightNavigationDrawer.shopNameEdit().clear();
        myActions.action_sendKeys(rightNavigationDrawer.shopNameEdit(),"Modified ShopName"+random.nextInt(10));
        rightNavigationDrawer.ownerNameEdit().clear();
        myActions.action_sendKeys(rightNavigationDrawer.ownerNameEdit(),"Modified OwnerName"+random.nextInt(100));
        rightNavigationDrawer.businessTypeEdit(1);
        rightNavigationDrawer.clickOnProfileSaveButton();
        androidDriver.navigate().back();
        }
        }catch (NullPointerException e){
            sleep(500);
        }
        }
    }

    
    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 7,dataProvider = "dataForSearchTerm")
    public void searchToObject(String searchTerm){
        search.searchBeforeClass();
        actionBarObjects.clickOnSearchImageButton();
        search.verifySearchFunctionalityWithoutSelectingSuggestions(searchTerm);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 8)
    public void verifyApplyingSortOnPLP() throws Exception {
            plp.productListingPageBeforeClass();
            plp.verifyApplyingSortOnPLP();
    }
  
    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 9)
    public void verifyApplyingFilterOnPLP() throws Exception
    {
        plp.productListingPageBeforeClass();
        plp.verifyApplyingFilterOnPLP(null,null);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 10)
    public void verifySelectingValidProduct(){
        plp.verifySelectingValidSizeItemOnPlpToPDP();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 11)
    public void verifyPlaceOrderThroughPDP(){
        pdp.productDescriptionPageBeforeClass();
        pdp.verifyPlaceOrderThroughPDP();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 12)
    public void verifyProductIncrementInMyBag() throws Exception {
             myBag.myBagBeforeClass();
            myBag.verifyItemIncrementFunctionalityOnMyBag();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 13)
    public void verifyApplyShippingChargeInMyBag()
    {
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER))
        { myBag.verifyApplyingShippingCharges();}
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 14)
    public void verifyPlaceOrderInMyBag()
    {
        myBag.verifyPlaceOrderInMyBag();
    }
  
    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 15)
    public void verifyDeletingCodDisabledProductInAddress()
    {  //sleep(4000);
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER))
        {
        myBag.deleteProductWithCODDisabled();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 16)
    public void verifySelectAddress() {
        if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            if(mokamUser.equalsIgnoreCase(CoreConstants.MOKAM_USER)){
                // SR
                myBag.verifyProceedToPaymentByCreatingNewAddress();
                sleep(4000);
            }else{
                myBag.verifySelectAddressInMyBag();
            }
        }
        else {
        myBag.verifySelectAddressInMyBag();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 17)
    public void verifyProceedToPaymentInAddress()
    {
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            myBag.verifyCheckoutProceedInMyBag();
        sleep(3000);}
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 18)
    public void verifyCheckoutWithCOD()
    {
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            sleep(3500);
//             myBag.verifyProceedPaymentWithoutChangeAddress();
//             if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
//                 paymentModePageObjects.closeJoinPrimoPage();
//             }
//         }
//         sleep(6000);
    //{       sleep(3500);
            myBag.verifyProceedPaymentWithoutChangeAddress();
            //sleep(2000);
    }
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 19)
    public void verifyOrderIdInOrderSuccessfulPage() {
        orderSuccessFulPageObjects.clickOnClickHereButton();

    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 20)
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


    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 21)
    public void verifyLogout() throws Exception {
        if(host.equalsIgnoreCase("Local")){
            // Do nothing
        }else {
            //sleep(2800);
            logout.logoutBeforeClass();
//            if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
                actionBarObjects.clickOnBackButton();
                sleep(1000);
                actionBarObjects.clickOnBackButton();}
            logout.verifyLogoutFunctionality();
//        }
    }


    @AfterSuite(alwaysRun = true)
    public void smokeTestAfterClass(){
        System.out.println("SmokeTest completed");
        quitBaseDriver();
    }


}