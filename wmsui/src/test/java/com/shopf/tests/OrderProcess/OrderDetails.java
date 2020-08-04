package com.shopf.tests.OrderProcess;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class OrderDetails extends WmsBaseClass{
    private WebDriver driver;
    private HomePageObject homePageObject;
    private OrderProcessPageObjects orderProcessPageObjects;
    private OrderProcessPageObjects.OrderDetailTab orderDetailTab;
    private List<OrderListModel> list;
    private GetWMSApiResponse getWMSApiResponse;
    private Random random;
    private List<OrderDetailsModel.OrderLineItemsBean> orderItems;
    private OrderDetailsModel orderDetailsModel;
    private Assertion assertion;


    @BeforeClass(alwaysRun = true)
    public void orderDetailsBeforeClass() throws Exception{
        System.out.println("Order Details Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        orderProcessPageObjects = new OrderProcessPageObjects(driver);
        orderDetailTab = orderProcessPageObjects.new OrderDetailTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        random = new Random();
        assertion = new Assertion();
    }


    @Test(groups = CoreConstants.GROUP_SANITY,
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Order Details")
    public void verifyOrderDetails(){
        System.out.println("Verify Order Details is called");
        String orderNo;
        int i,j;
        homePageObject.clickOrderProcess();
        orderProcessPageObjects.clickOrderDetailTab();
        list = getWMSApiResponse.getOrderList();
        i = random.nextInt(list.size());
        orderNo = list.get(i).getOrder_number();
        System.out.println("Order Number : " + orderNo);
        orderDetailTab.orderNumberInput(orderNo);
        orderDetailsModel = getWMSApiResponse.getOrderDetails(orderNo);

        System.out.println("-----------*-----*-----*------------");

        System.out.println(orderDetailsModel.getMarket_place().getName());
        assertion.assertTrue(orderDetailsModel.getMarket_place().getName()
                .equalsIgnoreCase(orderDetailTab.getMarketPlace()),
               "Market_places Do Not Match");

        System.out.println(orderDetailsModel.getSeller().getName());
        assertion.assertTrue(orderDetailsModel.getSeller().getName()
                        .equalsIgnoreCase(orderDetailTab.getSeller()),
                "Seller Names Do Not Match");

        System.out.println(orderDetailsModel.getWarehouse().getCode());
        assertion.assertTrue(orderDetailsModel.getWarehouse().getCode()
                .equalsIgnoreCase(orderDetailTab.getBinCode()),
                "BinCodes Do Not Match");

        System.out.println(orderDetailsModel.getOrder_type_name());
        assertion.assertTrue(orderDetailsModel.getOrder_type_name()
                        .equalsIgnoreCase(orderDetailTab.getOrderType()),
                "Order Types Do Not Match");

        System.out.println(orderDetailsModel.getStatus_code());
        assertion.assertTrue(orderDetailsModel.getStatus_code()
                .equalsIgnoreCase(orderDetailTab.getStatus()),
                "Status Do Not Match");

        orderItems = orderDetailsModel.getOrder_line_items();
        for (j=0;j<orderItems.size();j++)
        {
            System.out.println("--------------------------------");

            System.out.println(orderItems.get(j).getVariant().getSku_code());
            assertion.assertTrue(orderItems.get(j).getVariant().getSku_code()
                            .equalsIgnoreCase(orderDetailTab.getSkuCode(j+1)),
                    "SkuCodes Do Not Match");

            System.out.println(orderItems.get(j).getVariant().getNotes());
            assertion.assertTrue(orderItems.get(j).getVariant().getNotes()
                            .equalsIgnoreCase(orderDetailTab.getDescription(j+1)),
                    "Notes Do Not Match");

        }

    }


    @AfterClass(alwaysRun = true)
    public void orderDetailsAfterClass() {
        System.out.println("Order Details After Class is called");
    }
}
