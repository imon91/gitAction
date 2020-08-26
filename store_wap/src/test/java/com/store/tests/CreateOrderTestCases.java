package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObejcts.*;
import utils.StoreWapBaseClass;

public class CreateOrderTestCases extends StoreWapBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private AuthenticationPageObjects authenticationPageObjects;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;
    private MyOrdersPageObjects myOrdersPageObjects;
    private CreateOrderPageObjects createOrderPageObjects;
    private EditOrdersPageObjects editOrdersPageObject;
    private OrderConfirmationPageObjects orderConfirmationPageObjects;


    public void pageInitializer() {
        authenticationPageObjects = new AuthenticationPageObjects(androidDriver);
        facebookPageObjects = new FacebookPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        myOrdersPageObjects = new MyOrdersPageObjects(androidDriver);
        createOrderPageObjects = new CreateOrderPageObjects(androidDriver);
        editOrdersPageObject = new EditOrdersPageObjects(androidDriver);
        orderConfirmationPageObjects = new OrderConfirmationPageObjects(androidDriver);
    }


    @BeforeClass(alwaysRun = true)
    public void createOrderTestCasesBeforeClass() throws Exception {
        androidDriver = getBaseDriver();
        System.out.println("createOrderBeforeClass is called");
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
        createOrderPageObjects.clickAddMoreButton();
        createOrderPageObjects.enterValidRandomProductAmount(3);
        createOrderPageObjects.clickAddMoreButton();
        createOrderPageObjects.enterValidRandomProductAmount(4);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "createOrders")
    public void getTotalAmountAndNumberOFItemsInCreateOrderPageBeforeEditing(){
        System.out.println("getTotalAmountAndNumberOFItemsInCreateOrderPageBeforeEditing is called");
        String totalAmount = createOrderPageObjects.getTotalAmount();
        String numberOFProducts = createOrderPageObjects.getNumberOfProducts();
        System.out.println("Number Of Items : " + numberOFProducts);
        System.out.println("Total : " + totalAmount);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "getTotalAmountAndNumberOFItemsInCreateOrderPageBeforeEditing")
    public void verifyErrorMessagesInCreateOrderPage(){
        System.out.println("verifyErrorMessagesInCreateOrderPage is called");
        //product name field
        System.out.println("enter invalid product name and assert error message");
        createOrderPageObjects.editProductNameWithInvalidName(1);
        Assert.assertEquals(createOrderPageObjects.getErrorMessage(),"Enter a valid product name to continue.");
        createOrderPageObjects.editProductNameWithValidName(1);
        //product quantity field
        System.out.println("enter invalid product quantity and assert error message");
        createOrderPageObjects.editProductQuantityWithInvalidQuantity(1);
        Assert.assertEquals(createOrderPageObjects.getErrorMessage(),"Enter a valid quantity to continue.");
        createOrderPageObjects.editProductQuantityWithValidQuantity(1);
        //product amount field
        System.out.println("enter invalid product price and assert error message");
        createOrderPageObjects.editProductWithInvalidAmount(1);
        Assert.assertEquals(createOrderPageObjects.getErrorMessage(),"Enter a valid price to continue.");
        createOrderPageObjects.editProductAmountWithValidAmount(1);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyErrorMessagesInCreateOrderPage")
    public void editProductDetailsInCreateOrderPage() {
        System.out.println("editProductDetailsInCreateOrderPage is called");
        System.out.println("edit name, quantity, price of first product");
        createOrderPageObjects.editProductNameWithValidName(3);
        createOrderPageObjects.editProductQuantityWithValidQuantity(3);
        createOrderPageObjects.editProductAmountWithValidAmount(3);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "editProductDetailsInCreateOrderPage")
    public void deleteProductInCreateOrderPage(){
        System.out.println("delete the fourth product");
        createOrderPageObjects.deleteProduct(4);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "deleteProductInCreateOrderPage")
    public void getTotalAmountAndNumberOFItemsInCreateOrdersPageAfterEditing(){
        System.out.println("getTotalAmountAndNumberOFItemsInCreateOrdersPageAfterEditing is called");
        String totalAmount = createOrderPageObjects.getTotalAmount();
        String numberOfProducts = createOrderPageObjects.getNumberOfProducts();
        System.out.println("Number Of Items : " + numberOfProducts);
        System.out.println("Total : " + totalAmount);
        createOrderPageObjects.clickNextButton();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "getTotalAmountAndNumberOFItemsInCreateOrdersPageAfterEditing")
    public void verifyEditOrdersPageTitle(){
        System.out.println("verifyEditOrdersPageTitle is called");
        Assert.assertEquals(editOrdersPageObject.getPageTitleText(), "Edit Orders");
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyEditOrdersPageTitle",enabled = false)
    public void verifyErrorMessagesInEditOrdersPage(){
        System.out.println("verifyErrorMessagesInEditOrdersPage is called");
        System.out.println("Enter invalid customer name, discount and delivery charge");
        editOrdersPageObject.clickCreateOrderButton();
        Assert.assertEquals(editOrdersPageObject.getErrorMessage(),"Customer name is required");
        editOrdersPageObject.enterInvalidCustomerName();
        editOrdersPageObject.clickCreateOrderButton();
        Assert.assertEquals(editOrdersPageObject.getErrorMessage(),"Enter a valid Customer Name to continue.");
        editOrdersPageObject.removeCustomerName();
        editOrdersPageObject.enterValidCustomerName();
        //Assert.assertEquals(editOrdersPageObject.getErrorMessage(),"Enter a valid discount to continue.");
        editOrdersPageObject.enterValidDiscount();
        //Assert.assertEquals(editOrdersPageObject.getErrorMessage(),"Enter a valid delivery charges to continue.");
        editOrdersPageObject.enterValidDeliveryCharge();
        //check error message for product fields
        System.out.println("enter invalid product name and assert error message");
        editOrdersPageObject.editProductNameWithInValidName(1);
        Assert.assertEquals(editOrdersPageObject.getErrorMessage(),"Enter a valid product name to continue.");
        editOrdersPageObject.editProductNameWithValidName(1);
        System.out.println("enter invalid product quantity and assert error message");
        editOrdersPageObject.editProductQuantityWithInValidQuantity(1);
        Assert.assertEquals(editOrdersPageObject.getErrorMessage(),"Enter a valid quantity to continue.");
        editOrdersPageObject.editProductQuantityWithValidQuantity(1);
        System.out.println("enter invalid product price and assert error message");
        editOrdersPageObject.editProductAmountWithInValidAmount(1);
        Assert.assertEquals(editOrdersPageObject.getErrorMessage(),"Enter a valid price to continue.");
        editOrdersPageObject.editProductAmountWithValidAmount(1);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyEditOrdersPageTitle")
    public void editProductDetailsInEditOrderPage() {
        System.out.println("editProductDetailsInEditOrderPage is called");
        sleep(4000);
        editOrdersPageObject.enterValidCustomerName();
        editOrdersPageObject.enterValidDiscount();
        editOrdersPageObject.enterValidDeliveryCharge();
        System.out.println("edit name, quantity, price of third product");
        editOrdersPageObject.editProductNameWithValidName(3);
        editOrdersPageObject.editProductQuantityWithValidQuantity(3);
        editOrdersPageObject.editProductAmountWithValidAmount(3);
        System.out.println("Delete the second product");
        editOrdersPageObject.deleteProduct(2);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "editProductDetailsInEditOrderPage")
    public void getTotalAmountAndNumberOFItemsInEditOrdersPage(){
        System.out.println("getTotalAmountAndNumberOFItemsInEditOrdersPage is called");
        String totalAmount = editOrdersPageObject.getTotalAmount();
        String numberOFProducts = editOrdersPageObject.getNumberOfProducts();
        System.out.println("Number Of Items : " + numberOFProducts);
        System.out.println("Total : " + totalAmount);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "getTotalAmountAndNumberOFItemsInEditOrdersPage")
    public void verifyCreateOrderButtonFunctionality() {
        System.out.println("createOrder is called");
        editOrdersPageObject.clickCreateOrderButton();
        sleep(5000);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "verifyCreateOrderButtonFunctionality")
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
        orderConfirmationPageObjects.clickBackButton();
        createOrderPageObjects.clickBackButton();
        myOrdersPageObjects.clickBackButton();
        sleep(2000);
    }


    @AfterClass
    public void createOrderTestCasesAfterClass() {
        System.out.println("createOrderAfterClass is called");
    }


}