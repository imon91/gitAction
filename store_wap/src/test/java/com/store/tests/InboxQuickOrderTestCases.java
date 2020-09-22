package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObejcts.*;
import utils.StoreWapBaseClass;

import java.util.ArrayList;


public class InboxQuickOrderTestCases extends StoreWapBaseClass {



    private AndroidDriver<WebElement> androidDriver;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;
    private InboxPageObjects inboxPageObjects;
    private ChatScreenPageObjects chatScreenPageObjects;
    private CreateOrderPageObjects createOrderPageObjects;
    private EditOrdersPageObjects editOrdersPageObjects;
    private CustomerDetailsPageObjects customerDetailsPageObjects;
    private OrderConfirmationPageObjects orderConfirmationPageObjects;
    private OrderDetailsPageObjects orderDetailsPageObjects;
    private EditProductsPageObjects editProductsPageObjects;
    private RecordPaymentsPageObjects recordPaymentsPageObjects;
    private DeliveryDetailsPageObjects deliveryDetailsPageObjects;
    private OnlinePaymentPageObjects onlinePaymentPageObjects;


    public void pageInitializer(){
        facebookPageObjects = new FacebookPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        inboxPageObjects = new InboxPageObjects(androidDriver);
        chatScreenPageObjects = new ChatScreenPageObjects(androidDriver);
        createOrderPageObjects = new CreateOrderPageObjects(androidDriver);
        editOrdersPageObjects = new EditOrdersPageObjects(androidDriver);
        customerDetailsPageObjects = new CustomerDetailsPageObjects(androidDriver);
        orderConfirmationPageObjects = new OrderConfirmationPageObjects(androidDriver);
        orderDetailsPageObjects = new OrderDetailsPageObjects(androidDriver);
        editProductsPageObjects = new EditProductsPageObjects(androidDriver);
        recordPaymentsPageObjects = new RecordPaymentsPageObjects(androidDriver);
        deliveryDetailsPageObjects = new DeliveryDetailsPageObjects(androidDriver);
        onlinePaymentPageObjects = new OnlinePaymentPageObjects(androidDriver);
    }

    @BeforeClass(alwaysRun = true)
    public void inboxQuickOrderFlowTestCasesBeforeClass() throws Exception {
        androidDriver = getBaseDriver();
        System.out.println("InboxQuickOrderFlowTestCasesBeforeClass is called");
        pageInitializer();
        String facebookPage = facebookPageObjects.connectRandomFacebookPage(2);
        System.out.println(facebookPage + " is selected");
        facebookPageObjects.clickContinueAfterConnectFacebookPage();
        sleep(3000);
        dashBoardPageObjects.clickInboxButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyClickingCustomer(){
        System.out.println("verifyClickingCustomer is called");
        String customerName = inboxPageObjects.clickOnCustomer(1);
        Assert.assertEquals(chatScreenPageObjects.getCustomerName(),customerName);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyClickingCustomer")
    public void verifyCreateOrderIconFunctionality(){
        System.out.println("VerifyCreateOrderIconFunctionality is called");
        chatScreenPageObjects.clickOnBottomPanelIcon();
        chatScreenPageObjects.clickOnCreateOrderIcon();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyCreateOrderIconFunctionality")
    public void createProducts(){
        System.out.println("createProducts is called");
        createOrderPageObjects.enterRandomProductAmount_Inbox(1);
        createOrderPageObjects.clickAddMoreButton();
        createOrderPageObjects.enterRandomProductAmount_Inbox(2);
        createOrderPageObjects.clickAddMoreButton();
        createOrderPageObjects.enterRandomProductAmount_Inbox(3);
        createOrderPageObjects.clickAddMoreButton();
        createOrderPageObjects.enterRandomProductAmount_Inbox(4);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "createProducts")
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

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyNextButtonFunctionality")
    public void verifyCreateOrder(){
        System.out.println("verifyCreateOrder is called");
        editOrdersPageObjects.enterValidDiscount();
        editOrdersPageObjects.enterValidDeliveryCharge();
        editOrdersPageObjects.clickCreateOrderButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyCreateOrder")
    public void verifyNextButtonFunctionalityInCustomerDetailsPage(){
        System.out.println("verifyNextButtonFunctionalityInCustomerDetailsPage is called");
        customerDetailsPageObjects.clickOnNextButtonInInbox();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyNextButtonFunctionalityInCustomerDetailsPage")
    public void getOrderID(){
        System.out.println("getOrderID is called");
        String orderID = orderConfirmationPageObjects.getOrderID();
        System.out.println("The OrderID of the new order is," + orderID);
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

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyCustomerDetailsPageTitle")
    public void verifyViewMyOrderButtonFunctionality(){
        System.out.println("verifyViewMyOrderButtonFunctionality is called");
        customerDetailsPageObjects.clickViewMyOrderButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyViewMyOrderButtonFunctionality")
    public void verifyOrderDetailsPageTitle(){
        System.out.println("verifyOrderDetailsPageTitle is called");
        Assert.assertEquals(orderDetailsPageObjects.getPageTitle(),"Order Details");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyOrderDetailsPageTitle")
    public void verifyEditDetailsButton(){
        System.out.println("verifyEditDetailsButton is called");
        orderDetailsPageObjects.clickOnEditDetailsButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyEditDetailsButton")
    public void verifyEditProductsPageTitle(){
        System.out.println("verifyEditProductsPageTitle is called");
        Assert.assertEquals(editProductsPageObjects.getPageTitleText(),"Edit Products");
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyEditProductsPageTitle")
    public void editCustomerName(){
        System.out.println("editCustomerName is called");
        editProductsPageObjects.editCustomerNameWithRandomName();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "editCustomerName")
    public void editProductDetails() throws Exception {
        System.out.println("editProductDetails is called");
        editProductsPageObjects.deleteProduct(4);
        editProductsPageObjects.editProductName("Rice",1);
        editProductsPageObjects.editProductQuantity("5",1);
        editProductsPageObjects.editProductAmount("60",1);
        editProductsPageObjects.editProductName("Sugar",2);
        editProductsPageObjects.editProductQuantity("2",2);
        editProductsPageObjects.editProductAmount("30",2);
        editProductsPageObjects.editProductName("Wheat",3);
        editProductsPageObjects.editProductQuantity("2",3);
        editProductsPageObjects.editProductAmount("40",3);
        editProductsPageObjects.clickOnNextButton();
        sleep(4000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "editProductDetails")
    public void verifyEditTotalCost(){
        System.out.println("verifyEditTotalCost is called");
        orderDetailsPageObjects.clickOnEditTotalCostButton();
        int productValue = orderDetailsPageObjects.getTotalProductValue();
        String totalCost = String.valueOf(productValue - ((int)(productValue*0.2)));
        orderDetailsPageObjects.enterTotalCost(totalCost);
        orderDetailsPageObjects.clickOnSaveTotalCostButton();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyEditTotalCost" )
    public void verifyRecordPaymentsButtonFunctionality(){
        System.out.println("verifyRecordPaymentsButtonFunctionality is called");
        orderDetailsPageObjects.clickOnRecordPaymentsButton();
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

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "getOrderIDInRecordPaymentsPage")
    public void enterPartialAmountForPayment(){
        System.out.println("enterPartialAmountForPayment is called");
        int totalDue = Integer.parseInt(recordPaymentsPageObjects.getDueAmount().replaceAll(",",""));
        String partialAmount = String.valueOf((int)(0.3*totalDue));
        recordPaymentsPageObjects.editPayingAmount(partialAmount);
        System.out.println("Partial amount added :"+ partialAmount);
        recordPaymentsPageObjects.clickAddButton();
        recordPaymentsPageObjects.clickCashOption();
        recordPaymentsPageObjects.clickConfirmButton();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "enterPartialAmountForPayment" )
    public void enterAmountForOnlinePayment(){
        System.out.println("enterAmountForOnlinePayment is called");
        String totalDueAmount = recordPaymentsPageObjects.getDueAmount();
        System.out.println("Due amount : " + totalDueAmount);
        recordPaymentsPageObjects.clickAddButton();
        recordPaymentsPageObjects.clickDebitCardOption();
        recordPaymentsPageObjects.clickConfirmButton();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "enterAmountForOnlinePayment")
    public void onlineCashPayment(){
        System.out.println("onlineCashPayment is called");
        String paymentLink = recordPaymentsPageObjects.copyPaymentLink(1);
        ((JavascriptExecutor)androidDriver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(androidDriver.getWindowHandles());
        androidDriver.switchTo().window(tabs.get(1));
        androidDriver.get(paymentLink);
        sleep(6000);
        onlinePaymentPageObjects.clickPayNowButton();
        sleep(4000);
        ArrayList<String> tabs1 = new ArrayList<String>(androidDriver.getWindowHandles());
        androidDriver.switchTo().window(tabs1.get(2));
        onlinePaymentPageObjects.payWithVisaCard();
        ArrayList<String> tabs2 = new ArrayList<String>(androidDriver.getWindowHandles());
        androidDriver.switchTo().window(tabs2.get(0));
        recordPaymentsPageObjects.clickBackButton();
        sleep(3000);
        orderDetailsPageObjects.clickOnRecordPaymentsButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "onlineCashPayment" )
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
        orderDetailsPageObjects.clickOnSendToDeliveryButton();
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
        androidDriver.hideKeyboard();
        deliveryDetailsPageObjects.enterCollectionAmount("0");
        androidDriver.hideKeyboard();
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

    @AfterClass(alwaysRun = true)
    public void inboxQuickOrderFlowTEstCasesAfterClass(){
        System.out.println("InboxQuickOrderFlowTestCasesAfterClass is called");
    }



}
