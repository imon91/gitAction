package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;
import static org.testng.Assert.*;



public class MyOrder extends WebAppBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private BottomNavigationObjects bottomNavigationObjects;
    private MyActions myActions;
    private MyOrderDetailsPageObject myOrderDetailsPageObject;
    private SoftAssert softAssert;


    @BeforeClass(alwaysRun = true)
    public void myOrdersBeforeClass() throws Exception{
        System.out.println("MyOrdersBeforeClass is called");
        androidDriver = getBaseDriver();
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        bottomNavigationObjects.clickOnBottomBarMyOrdersIcon();
        myActions = new MyActions();
        softAssert = new SoftAssert();
        myOrderDetailsPageObject = new MyOrderDetailsPageObject(androidDriver);
    }


    @Test(groups ={ "MyOrder.VerifyDataInOrderDetail",
            CoreConstants.GROUP_REGRESSION},
            description = "Verifying all data In MyOrderDetailPage")
    public void verifyDataOfOrderInOrderDetailPage() {
        System.out.println("MyOrderDetails data Verification was called");

        MyOrderModel myOrderModelResults=myOrderDetailsPageObject.getResultsOfMyOrdersApi(1);

        for(int orderNo=0;orderNo<3;orderNo++) {
            System.out.println("The order details of " + myOrderModelResults.getJson_response().getAllmyorders().get(orderNo).getCustomer_order().getNumber() + "was under Verification");
            myActions.action_click(myOrderDetailsPageObject.listOfOrderIdWeb(myOrderModelResults.getJson_response().getAllmyorders().get(orderNo).getCustomer_order().getNumber()));
            sleep(2000);
            //Order Detail page Api response
            MyOrderDetailsModel myOrderDetailsModel = myOrderDetailsPageObject.getResultsOfMyOrderDetailsApi(myOrderModelResults.getJson_response().getAllmyorders().get(orderNo).getCustomer_order().getNumber());
            //Verification of Product Properties
            for (int productNo=0 ; productNo<myOrderDetailsModel.getCustomer_order().getVendor_orders().get(0).getVendor_packages().get(0).getVendor_order_line_items().size();productNo++)
            {
               List<String> productPropertiesContainerUI = myOrderDetailsPageObject.productPropertiesContainerUI(productNo);
               List<String> productPropertiesContainerApi = new ArrayList<>();
                String productName=myOrderDetailsModel.getCustomer_order().getVendor_orders().get(0).getVendor_packages().get(0).getVendor_order_line_items().get(productNo).getProduct_name();
                System.out.println("product name "+productName);
                String productSize=myOrderDetailsModel.getCustomer_order().getVendor_orders().get(0).getVendor_packages().get(0).getVendor_order_line_items().get(productNo).getSize_str();
                String productQuantity=String.valueOf(myOrderDetailsModel.getCustomer_order().getVendor_orders().get(0).getVendor_packages().get(0).getVendor_order_line_items().get(productNo).getQuantity());
                String productPrice=myOrderDetailsModel.getCustomer_order().getVendor_orders().get(0).getVendor_packages().get(0).getVendor_order_line_items().get(productNo).getFormatted_price().replaceAll("[^0-9]","");
                String productTotalIncome = myOrderDetailsModel.getCustomer_order().getVendor_orders().get(0).getVendor_packages().get(0).getVendor_order_line_items().get(productNo).getItem_total_income();
                productPropertiesContainerApi.add(productName);
                productPropertiesContainerApi.add(productSize);
                productPropertiesContainerApi.add(productQuantity);
                productPropertiesContainerApi.add(productPrice);
                productPropertiesContainerApi.add(productTotalIncome);
                System.out.println(productPropertiesContainerApi);
                System.out.println(productPropertiesContainerUI);
                assertTrue(productPropertiesContainerApi.equals(productPropertiesContainerUI));
            }

            //Verification of Payment Summary
            List<String> paymentSummaryContainerApi = new ArrayList<>();
            List<String> paymentSummaryContainerUI = myOrderDetailsPageObject.paymentContainerWebUI();
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getItem_total()));
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getTotal_shipping()));
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getAdvance_amount_paid()));
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getTotal()));
            if (myOrderDetailsModel.getCustomer_order().getIncome()!=0)
            {
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getIncome()));}
            assertEquals(paymentSummaryContainerUI, paymentSummaryContainerApi);
            System.out.println(paymentSummaryContainerApi);

            //Verification of Customer Detail
            List<String> customerDetailApi = new ArrayList<>();
            customerDetailApi.add(myOrderDetailsModel.getCustomer_order().getShip_address().getFirstname());
            customerDetailApi.add(myOrderDetailsModel.getCustomer_order().getShip_address().getAddress1());
            customerDetailApi.add(myOrderDetailsModel.getCustomer_order().getShip_address().getAddress2());
            customerDetailApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getShip_address().getPhone()));
            //Verification of payment method
            switch (myOrderDetailsModel.getCustomer_order().getPayment_method_id())
            {
                case (1):
                    String paymentMethod = myOrderDetailsPageObject.paymentMethod();
                    assertTrue(paymentMethod.equalsIgnoreCase("PREPAID"));
                    break;
                case (2):
                    String paymentMethod1 = myOrderDetailsPageObject.paymentMethod();
                    assertTrue(paymentMethod1.equalsIgnoreCase("COD"));
            }

            List<String> customerDetailUI = myOrderDetailsPageObject.customerDetailsWebUI();
            assertEquals(customerDetailUI, customerDetailApi);
            System.out.println(customerDetailUI);
            softAssert.assertAll();

            //click back button
            androidDriver.navigate().back();
        }
    }
}
