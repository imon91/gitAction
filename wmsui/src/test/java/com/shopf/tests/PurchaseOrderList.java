package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class PurchaseOrderList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private List<PurchaseOrderListModel> purchaseOrderListModels;
    private GetWMSApiResponse getWMSApiResponse;
    private Assertion assertion;
    String test;


    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void purchaseOrderListBeforeClass(String test) throws Exception {
        System.out.println("Before Purchase Order List Class");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        purchaseOrderList = purchaseOrdersPageObjects.new PurchaseOrderList(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }


    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verifying Purchase Orders List")
    public void verifyPurchaseOrdersList() {
        System.out.println("Verifying Purchase Order Class");
        int i;
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        sleep(1000);
        purchaseOrderListModels = getWMSApiResponse.getPurchaseOrderList(1,30);
        System.out.println("List Size: " + purchaseOrderListModels.size());

        for (i = 0; i < purchaseOrderListModels.size(); i++) {
            if (i == 0 || i == (purchaseOrderListModels.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                System.out.println(purchaseOrderListModels.get(i).getId());
                assertion.assertTrue(purchaseOrderList.getPOID(i + 1)
                                .equalsIgnoreCase(String.valueOf(purchaseOrderListModels.get(i).getId())),
                        "POIDs Do Not Match");

                System.out.println(purchaseOrderListModels.get(i).getPo_type());
                assertion.assertTrue(purchaseOrderList.getPOType(i + 1)
                                .equalsIgnoreCase(purchaseOrderListModels.get(i).getPo_type()),
                        "POTypes Do Not Match");

                System.out.println(purchaseOrderListModels.get(i).getStatus());
                assertion.assertTrue(purchaseOrderList.getStatus(i + 1)
                                .equalsIgnoreCase(purchaseOrderListModels.get(i).getStatus()),
                        "Status Does Not Match");

                System.out.println(purchaseOrderListModels.get(i).getWarehouse().getCode());
                assertion.assertTrue(purchaseOrderList.getWarehouseName(i + 1)
                                .equalsIgnoreCase(purchaseOrderListModels.get(i).getWarehouse().getCode()),
                        "Warehouse Names Do Not Match");

                System.out.println(purchaseOrderListModels
                        .get(i).getSupplier_address().getSupplier().getName());
                assertion.assertTrue(purchaseOrderList.getSupplierName(i + 1)
                                .equalsIgnoreCase(purchaseOrderListModels
                                        .get(i).getSupplier_address().getSupplier().getName()),
                        "Supplier Names Do Not Match");

                List<String> skuCodeList = purchaseOrderList.getSkuCode(i + 1);
                List<String> quantity = purchaseOrderList.getQuantity(i + 1);

                for (int j = 0; j < purchaseOrderListModels.get(i).getPurchase_order_line_items().size(); j++) {
                    System.out.println("----------------------------------");
                    int ordered_quantity = purchaseOrderListModels
                            .get(i).getPurchase_order_line_items().get(j).
                            getOrdered_quantity();
                    String skuCode = purchaseOrderListModels
                            .get(i).getPurchase_order_line_items().get(j).getVariant().
                            getSku_code();

                    System.out.println(skuCode);
                    assertion.assertTrue(skuCodeList.get(j)
                                    .equalsIgnoreCase(skuCode),
                            "skuCodes Do Not Match");

                    System.out.println(ordered_quantity);
                    assertion.assertTrue(quantity.get(j)
                                    .equalsIgnoreCase(String.valueOf(ordered_quantity)),
                            "Ordered Quantities Do Not Match");
                }
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void purchaseOrderListAfterClass() {
        System.out.println("After Purchase Order List Class");
    }
}
