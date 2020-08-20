package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObejcts.*;
import sun.misc.ASCIICaseInsensitiveComparator;

import static utils.StoreWapBaseClass.getBaseDriver;
import static utils.StoreWapBaseClass.sleep;


public class QuickOrderFlowTestCases {



    private AndroidDriver<WebElement> androidDriver;
    private AuthenticationPageObjects authenticationPageObjects;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;
    private MyOrdersPageObjects myOrdersPageObjects;
    private CreateOrderPageObjects createOrderPageObjects;
    private EditOrdersPageObjects editOrdersPageObject;
    private OrderConfirmationPageObjects orderConfirmationPageObjects;
    private CustomerDetailsPageObjects customerDetailsPageObjects;
    private DeliveryDetailsPageObjects deliveryDetailsPageObjects;
    private RecordPaymentsPageObjects recordPaymentsPageObjects;


    public void pageInitializer() {
        authenticationPageObjects = new AuthenticationPageObjects(androidDriver);
        facebookPageObjects = new FacebookPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        myOrdersPageObjects = new MyOrdersPageObjects(androidDriver);
        createOrderPageObjects = new CreateOrderPageObjects(androidDriver);
        editOrdersPageObject = new EditOrdersPageObjects(androidDriver);
        orderConfirmationPageObjects = new OrderConfirmationPageObjects(androidDriver);
        customerDetailsPageObjects = new CustomerDetailsPageObjects(androidDriver);
        deliveryDetailsPageObjects = new DeliveryDetailsPageObjects(androidDriver);
        recordPaymentsPageObjects = new RecordPaymentsPageObjects(androidDriver);
    }


    @BeforeClass(alwaysRun = true)
    public void quickOrderFlowTestCasesBeforeClass() throws Exception {
        androidDriver = getBaseDriver();
        System.out.println("quickOrderFlowTestCasesBeforeClass is called");
        pageInitializer();
        String facebookPage = facebookPageObjects.connectRandomFacebookPage(3);
        System.out.println(facebookPage + " is selected");
        facebookPageObjects.clickContinueAfterConnectFacebookPage();
        sleep(3000);
        dashBoardPageObjects.clickMyOrdersButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyMyOrdersPageTitle(){
        System.out.println("verifyMyOrdersPageTitle is called");
        Assert.assertEquals(myOrdersPageObjects.getPageTitleText(), "My Orders");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyMyOrdersPageTitle")
    public void verifyCreateNewOrderButtonFunctionality(){
        System.out.println("verifyCreateNewOrderButtonFunctionality is called");
        myOrdersPageObjects.clickCreateNewOrderButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyCreateNewOrderButtonFunctionality")
    public void verifyCreateNewOrderPageTitle() {
        System.out.println("verifyCreateNewOrderPageTitle is called ");
        Assert.assertEquals(createOrderPageObjects.getPageTitleText(), "Create Order");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyCreateNewOrderPageTitle")
    public void createOrders(){
        System.out.println("createOrders is called");
        createOrderPageObjects.enterValidRandomProductAmount(1);
        createOrderPageObjects.clickAddMoreButton();
        createOrderPageObjects.enterValidRandomProductAmount(2);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "createOrders")
    public void getTotalAmountAndNumberOFItemsInCreateOrderPage(){
        System.out.println("getTotalAmountAndNumberOFItemsInCreateOrderPage is called");
        String totalAmount = createOrderPageObjects.getTotalAmount();
        String numberOFProducts = createOrderPageObjects.getNumberOfProducts();
        System.out.println("Number Of Items : " + numberOFProducts);
        System.out.println("Total : " + totalAmount);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "getTotalAmountAndNumberOFItemsInCreateOrderPage")
    public void verifyNextButtonFunctionality(){
        System.out.println("verifyNextButtonFunctionality is called");
        createOrderPageObjects.clickNextButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyNextButtonFunctionality")
    public void verifyEditOrdersPageTitle(){
        System.out.println("verifyEditOrdersPageTitle is called");
        Assert.assertEquals(editOrdersPageObject.getPageTitleText(), "Edit Orders");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyEditOrdersPageTitle")
    public void fillFieldsInEditOrdersPage(){
        System.out.println("completeFieldsInEditOrdersPage is called");
        editOrdersPageObject.enterValidCustomerName();
        editOrdersPageObject.enterValidDiscount();
        editOrdersPageObject.enterValidDeliveryCharge();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "fillFieldsInEditOrdersPage")
    public void verifyCreateOrderButtonFunctionality() {
        System.out.println("createOrder is called");
        editOrdersPageObject.clickCreateOrderButton();
        sleep(5000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyCreateOrderButtonFunctionality")
    public void getSuccessMessagePopUp(){
        System.out.println("getSuccessMessagePopUp is called");
        Assert.assertEquals(editOrdersPageObject.getSuccessMessage(),"successfully created");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "getSuccessMessagePopUp")
    public void verifyOrderConfirmationPageTitle(){
        System.out.println("verifyOrderConfirmationPageTitle is called");
        Assert.assertEquals(orderConfirmationPageObjects.getPageTitleText(),"Order Confirmation");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyOrderConfirmationPageTitle")
    public void getOrderID(){
        System.out.println("getOrderID is called");
        String orderID = orderConfirmationPageObjects.getOrderID();
        System.out.println("The OrderID of the new order is,");
        System.out.println(orderID);
        sleep(2000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "getOrderID")
    public void verifyEnterCustomerDetailsButtonFunctionality(){
        System.out.println("verifyEnterCustomerDetailsButtonFunctionality is called");
        orderConfirmationPageObjects.clickEnterCustomerDetailsButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyEnterCustomerDetailsButtonFunctionality" )
    public void verifyCustomerDetailsPageTitle(){
        System.out.println("verifyCustomerDetailsPageTitle is called");
        Assert.assertEquals(customerDetailsPageObjects.getTitleName_QuickOrderFlow(),"Customer Details");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyCustomerDetailsPageTitle" )
    public void enterCustomerDetails(){
        System.out.println("enterCustomerDetails is called");
        customerDetailsPageObjects.enterValidMobileNumber();
        customerDetailsPageObjects.enterAddress();
        customerDetailsPageObjects.chooseAreaName(0);
        customerDetailsPageObjects.enterCustomerTags();
        customerDetailsPageObjects.enterCustomerTags();
        customerDetailsPageObjects.chooseRatingForCustomer(0);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "enterCustomerDetails" )
    public void verifySaveButtonFunctionality(){
        System.out.println("verifySaveButtonFunctionality is called");
        customerDetailsPageObjects.clickOnSaveButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifySaveButtonFunctionality" )
    public void getCustomerDetailsSuccessMessagePopUp(){
        System.out.println("getCustomerDetailsSuccessMessagePopUp is called");
        Assert.assertEquals(customerDetailsPageObjects.getSuccessMessage(),"success");
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "getCustomerDetailsSuccessMessagePopUp" )
    public void verifyRecordPaymentsButtonFunctionality(){
        System.out.println("verifyRecordPaymentsButtonFunctionality is called");
        orderConfirmationPageObjects.clickRecordPaymentsButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyRecordPaymentsButtonFunctionality" )
    public void verifyRecordPaymentsPageTitle(){
        System.out.println("verifyRecordPaymentsPageTitle is called");
        Assert.assertEquals(recordPaymentsPageObjects.getPageTitle(),"Payments");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyRecordPaymentsPageTitle" )
    public void getOrderIDInRecordPaymentsPage(){
        System.out.println("getOrderIDInRecordPaymentsPage is called");
        System.out.println(recordPaymentsPageObjects.getOrderID());
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "getOrderIDInRecordPaymentsPage" )
    public void enterAmountForPayment(){
        System.out.println("enterAmountForPayment is called");
        String totalDueAmount = recordPaymentsPageObjects.getDueAmount();
        System.out.println("Due amount : " + totalDueAmount);
        recordPaymentsPageObjects.clickAddButton();
        recordPaymentsPageObjects.clickCashOption();
        recordPaymentsPageObjects.clickConfirmButton();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "enterAmountForPayment" )
    public void verifyPaymentIsMade(){
        System.out.println("verifyPaymentIsMade is called");
        System.out.println("Payments Made : "+ recordPaymentsPageObjects.getTotalPaymentsMade());
        Assert.assertEquals(recordPaymentsPageObjects.getFullyPaidText(),"Fully Paid");
        recordPaymentsPageObjects.clickBackButton();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyPaymentIsMade" )
    public void verifySendOrderForDeliveryButtonFunctionality(){
        System.out.println("verifySendOrderForDeliveryButtonFunctionality is called");
        orderConfirmationPageObjects.clickSendToDeliveryButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifySendOrderForDeliveryButtonFunctionality" )
    public void verifyTitleInDeliveryDetailsPage(){
        System.out.println("verifyTitleInDeliveryDetailsPage is called");
        Assert.assertEquals(deliveryDetailsPageObjects.getPageTitle_QuickOrderFlow(),"Delivery");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyTitleInDeliveryDetailsPage" )
    public void fillFieldsOfDeliveryDetailsPage(){
        System.out.println("fillFieldsOfDeliveryDetailsPage is called");
        deliveryDetailsPageObjects.enterParcelWeight("1");
        deliveryDetailsPageObjects.enterCollectionAmount("0");
        deliveryDetailsPageObjects.selectPreferredDeliveryDay(2);
        deliveryDetailsPageObjects.selectPreferredDeliveryTime(3);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "fillFieldsOfDeliveryDetailsPage" )
    public void verifySendOrdersForDeliveryFunctionality(){
        System.out.println("verifySendOrdersForDeliveryFunctionality is called");
        deliveryDetailsPageObjects.clickSendToDeliveryButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifySendOrdersForDeliveryFunctionality" )
    public void verifySuccessfullySentForDelivery(){
        System.out.println("verifySuccessfullySentForDelivery is called");
        Assert.assertEquals(deliveryDetailsPageObjects.getSuccessfullySentForDeliveryText(),"Successfully Sent for Delivery");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifySuccessfullySentForDelivery" )
    public void getShipmentDetails(){
        System.out.println("getShipmentDetails is called");
        System.out.println("Shipment Details : "+ deliveryDetailsPageObjects.getShipmentDetails());
    }


    @AfterClass
    public void createOrderTestCasesAfterClass() {
        System.out.println("createOrderAfterClass is called");
    }



}
