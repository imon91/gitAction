package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.touch.offset.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;
import static org.testng.Assert.*;


public class MyOrders extends AndroidBaseClass {




    private AndroidDriver<WebElement> androidDriver;
    private MyOrdersPageObjects myOrdersPageObjects;
    private MyOrdersPageObjects.OrderDetails orderDetails;
    private BottomNavigationObjects bottomNavigationObjects;
    private MyActions myActions;
    private Random random;
    private TouchAction touchAction;
    private ActionBarObjects actionBarObjects;
    private String suiteName;
    private MyOrderDetailsPageObject myOrderDetailsPageObject;
    private SoftAssert softAssert;




    @BeforeClass(alwaysRun = true)
    public void myOrdersBeforeClass() throws Exception{
        System.out.println("MyOrdersBeforeClass is called");
        androidDriver = getBaseDriver();
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        bottomNavigationObjects.clickOnBottomBarMyOrdersIcon();
        myOrdersPageObjects = new MyOrdersPageObjects(androidDriver);
        orderDetails = myOrdersPageObjects.new OrderDetails(androidDriver);
        myActions = new MyActions();
        touchAction = new TouchAction(androidDriver);
        sleep(5000);
        myOrdersPageObjects.clickOnCompleteTabItem();
        sleep(1000);
        myOrdersPageObjects.clickOnActiveTabItem();
        softAssert = new SoftAssert();
        myOrderDetailsPageObject = new MyOrderDetailsPageObject(androidDriver);
        // This Block is responsible to get the control from anywhere to MyOrders
        //switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
    }
    @BeforeTest(alwaysRun = true)
    @Parameters("suite")
    public void searchModuleTests(String suiteNameFromXMLFile)
    {
        suiteName = suiteNameFromXMLFile;
    }


    @Test(  groups = {"MyOrders.verifySelectingAnOrderFromMyOrders",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            enabled = false,
            description = "Verify Selecting An Order From MyOrders"  )
    public void verifySelectingAnOrderFromMyOrders() throws Exception{
       ArrayList<WebElement> data =  (ArrayList) orderDetails.getListOfOrderItems();
        System.out.println(data.size());
        for(int i=0;i<data.size();i++){
            System.out.println(data.get(i).getText());
        }
        int randomValue = new Random().nextInt((data.size()));
        System.out.println("Item Clicked is : "+randomValue);
        data.get(randomValue).click();
        //orderDetails.clickOnOrderItemByIndex(new Random().nextInt((data.size())+1));
//        sleep(10000);
//        List<WebElement> dataList =
//                androidDriver.findElements(By.xpath("//button"));
//        System.out.println(dataList.size());
//        dataList.get(0).click();
//        sleep(10000);
//        System.out.println("List of delete buttons are : "+dataList.size());
        switchFromWebToNative();sleep(5000);
        androidDriver.findElement(By.xpath("//android.view.View[@index='23']/android.widget.Image")).click();
        //new MyActions().clickOnHardKeyBack();
        sleep(10000);
        androidDriver.findElement(By.xpath("//android.widget.Spinner[@index='0']")).click();
//        sleep(3000);
//        androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@index='1']")).click();
        sleep(3000);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Cancel Order']")).click();
        //switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        //androidDriver.findElement(By.xpath("//div[@class='deleteActive___SWGaJ']//*[name()='svg']")).click();
        sleep(20000);
//        ArrayList<String> dataNew = new ArrayList();
//        Set<String> setData = androidDriver.getContextHandles();
//        for (String x : setData)
//            dataNew.add(x);
//        System.out.println(dataNew);
//        System.out.println(androidDriver.getCurrentUrl());
        //System.out.println(androidDriver.findElementByXPath("//div[@class='flex___1bJDE middle___1jEMZ']/p[1]").getText());
    }


    @Test(  groups = {"MyOrders.verifyCancellingAnOrderFromMyOrders",
            CoreConstants.GROUP_SANITY},
            description = "Verify Cancelling An Order From MyOrders"  )
    public void verifyCancellingAnOrderFromMyOrders(){
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        sleep(2000);
       touchAction.press(PointOption.point(10,1500)).waitAction().moveTo(PointOption.point(10,500)).release().perform();
        sleep(5500);
        WebElement loadmore = androidDriver.findElement(By.xpath("//div[@class='loadMore___2udG1']/button"));
        myActions.action_click(loadmore);
        sleep(6000);
        //clicking of order id
        orderDetails.clickOnOrderItemByIndex(4);
        sleep(10000);

        //switch to native
        switchFromWebToNative();

        //del button
        androidDriver.findElement(By.xpath("//android.view.View[@index='23']/android.widget.Image")).click();
        sleep(20000);
        //cancel reason icon
        androidDriver.findElement(By.xpath("//android.widget.Spinner[@index='0']")).click();
        sleep(10000);
        //click reasons
        androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@index='1']")).click();
        sleep(1000);
        //click cancel button
        androidDriver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
        sleep(3000);
        //go to home page
        androidDriver.navigate().back();
        actionBarObjects.clickOnShopUpAppIcon();

    }


    @Test(groups ={ "MyOrder.VerifyFilterInMyorder",
            CoreConstants.GROUP_REGRESSION},
    description = "Verifying filter In MyOrderPage",
   dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials")
    public void verifyFilterInMyOrder()
    {
        switchFromWebToNative();
        myOrderDetailsPageObject.applyFilterFunction(5);
    }


    @Test(groups ={ "MyOrder.VerifySortInMyorder",
            CoreConstants.GROUP_REGRESSION},
            description = "Verifying sort In MyOrderPage",
            dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials")
    public void verifySortInMyOrder()
    {
        switchFromWebToNative();
        sleep(2000);
        myOrderDetailsPageObject.clickOnSortButton();
        System.out.println("clicked sort");
        sleep(3000);
        myOrderDetailsPageObject.applySortFunctionality(1);
    }


    @Test(groups ={ "MyOrder.VerifySearchInMyorder",
            CoreConstants.GROUP_REGRESSION},
            description = "Verifying search In MyOrderPage",
            dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials")
    public void verifySearchInMyOrder()
    {
        switchFromWebToNative();
        sleep(2000);
        myOrderDetailsPageObject.searchToOrderId("R4088980146");
        orderDetails.getListOfOrderItems();
        sleep(1000);
        myOrderDetailsPageObject.clickOnOrderById("R4088980146");
        sleep(5000);

        //get id after clicking Orderid
        String orderid = myOrderDetailsPageObject.getOrderIdAfterClickingOnOrder();
        System.out.println(orderid);

        if(orderid.equalsIgnoreCase("R4088980146"))
        {
            System.out.println("MyOrder Sort Functionality was verified");
        }
    }


    @Test(groups ={ "MyOrder.VerifyData",
            CoreConstants.GROUP_REGRESSION},
            description = "Verifying OrderID data In MyOrderPage")
    public void verifyDataInMyOrderActive()
    {

        MyOrderModel myOrderModelResults=myOrderDetailsPageObject.getResultsOfMyOrdersApi(1);
        //Click on Load More button
        for(int numberOfClickOnLoadMore =1;numberOfClickOnLoadMore<3;numberOfClickOnLoadMore++)//just Hard coded to load 3 orderId
        { myOrderDetailsPageObject.clickOnLoadMore();
        sleep(1000);
        }

        //verification Of names for particular OrderId
        for(int j=0; j<5 ;j++)
        {
            String orderIdApi = myOrderModelResults.getJson_response().getAllmyorders().get(j).getCustomer_order().getNumber();
            String nameApi = myOrderModelResults.getJson_response().getAllmyorders().get(j).getCustomer_order().getShip_address().getFirstname();
            myOrderDetailsPageObject.scrollToOrderID(orderIdApi);
            for(int i=0;i<myOrderDetailsPageObject.listOfOrderId().size();i++)
            {
                if(orderIdApi.equalsIgnoreCase(myActions.action_getText(myOrderDetailsPageObject.listOfOrderId().get(i))))
                {
                    String namesUI = myActions.action_getText(myOrderDetailsPageObject.listOfName().get(i));
                    assertTrue(nameApi.equalsIgnoreCase(namesUI));
                    System.out.println(nameApi);
                    System.out.println(namesUI);
                    System.out.println("Data was verified");
                }
            }
            softAssert.assertAll();
        }


    }



    @Test(groups ={ "MyOrder.VerifyDataInOrderDetail",
            CoreConstants.GROUP_REGRESSION},
            description = "Verifying all data In MyOrderDetailPage")
    public void verifyDataOfOrderInOrderDetailPage() {

        MyOrderModel myOrderModelResults=myOrderDetailsPageObject.getResultsOfMyOrdersApi(1);
        sleep(2000);
        for(int orderNo=0;orderNo<3;orderNo++) {
            System.out.println("The order details of " + myOrderModelResults.getJson_response().getAllmyorders().get(orderNo).getCustomer_order().getNumber() + "was under Verification");
            myActions.action_click(myOrderDetailsPageObject.scrollToOrderID(myOrderModelResults.getJson_response().getAllmyorders().get(orderNo).getCustomer_order().getNumber()));
            sleep(2000);
            MyOrderDetailsModel myOrderDetailsModel = myOrderDetailsPageObject.getResultsOfMyOrderDetailsApi(myOrderModelResults.getJson_response().getAllmyorders().get(orderNo).getCustomer_order().getNumber());
            sleep(2500);
            //Verification of orderId
            String orderId = myOrderDetailsPageObject.getOrderIdAfterClickingOnOrder();
            assertTrue(orderId.equalsIgnoreCase(myOrderDetailsModel.getCustomer_order().getNumber()));
            System.out.println("Order ID was verified successfully");

            //Verification of ProductName
            for (int product = 0; product < myOrderDetailsModel.getCustomer_order().getVendor_orders().get(0).getVendor_packages().get(0).getVendor_order_line_items().size(); product++) {
                String productName = myOrderDetailsModel.getCustomer_order().getVendor_orders().get(0).getVendor_packages().get(0).getVendor_order_line_items().get(product).getProduct_name();
                myOrderDetailsPageObject.scrollAtOrderDetailPage(productName);
                sleep(1000);
            }
            System.out.println("product names were verified");
            //Verification of Payment Summary
            List<String> paymentSummaryContainerApi = new ArrayList<>();
            List<String> paymentSummaryContainerUI = myOrderDetailsPageObject.orderPaymentContainer(myOrderDetailsModel.getCustomer_order().getItem_total(), myOrderDetailsModel.getCustomer_order().getTotal_shipping(), myOrderDetailsModel.getCustomer_order().getAdvance_amount_paid(), myOrderDetailsModel.getCustomer_order().getTotal());
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getItem_total()));
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getTotal_shipping()));
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getAdvance_amount_paid()));
            paymentSummaryContainerApi.add(String.valueOf(myOrderDetailsModel.getCustomer_order().getTotal()));
            assertEquals(paymentSummaryContainerUI, paymentSummaryContainerApi);

            //Verification of Customer Detail
            List<String> customerDetailApi = new ArrayList<>();
            customerDetailApi.add(myOrderDetailsModel.getCustomer_order().getShip_address().getFirstname());
            customerDetailApi.add(myOrderDetailsModel.getCustomer_order().getShip_address().getAddress1());
            System.out.println(myOrderDetailsModel.getCustomer_order().getShip_address().getPhone());

            List<String> customerDetailUI = myOrderDetailsPageObject.addressDetailContainer(myOrderDetailsModel.getCustomer_order().getShip_address().getFirstname(), myOrderDetailsModel.getCustomer_order().getShip_address().getAddress1());
            assertEquals(customerDetailUI, customerDetailApi);
            System.out.println(customerDetailUI);
            softAssert.assertAll();
            myActions.action_click(xpathSetter("//android.widget.ImageButton[@content-desc='Navigate up']"));

        }
    }




    @AfterClass(alwaysRun = true)
    public void myOrdersAfterClass(){
        System.out.println("MyOrdersAfterClass is called");
    }



}
