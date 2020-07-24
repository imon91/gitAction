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

public class PurchaseOrderDetails extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.EditPurchaseOrder editPurchaseOrder;
    private GetWMSApiResponse getWMSApiResponse;
    private List<PurchaseOrderListModel> purchaseOrderListModels;
    private PurchaseOrderDetailsModel purchaseOrderModel;
    private Random random;
    private int n;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void poStatusBeforeClass() throws Exception {
        System.out.println("PO Status Before Class is called");
        driver = getBaseDriver();
        random = new Random();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        editPurchaseOrder = purchaseOrdersPageObjects.new EditPurchaseOrder(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        purchaseOrderListModels = getWMSApiResponse.getPurchaseOrderList(1,30);
        assertion = new Assertion();
        n = random.nextInt(purchaseOrderListModels.size()) - 1;
    }


    @Test(groups = {CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify PO Status")
    public void verifyPOStatus() {
        System.out.println("Verify PO Status is called");
        int i;
        String poIDJson = String.valueOf(purchaseOrderListModels.get(n).getId());
        System.out.println("Purchase Order Id : " + poIDJson);
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickEditPurchaseOrderTab();
        sleep(1000);
        editPurchaseOrder.poIdInput(poIDJson);
        sleep(1000);
        purchaseOrderModel = getWMSApiResponse.getPurchaseOrderDetails(poIDJson);
        String status = editPurchaseOrder.getPOStatus().substring(8);

        List<PurchaseOrderDetailsModel.PurchaseOrderLineItemsBean> list =
                purchaseOrderModel.getPurchase_order_line_items();

        System.out.println(status);
        assertion.assertTrue(status.equalsIgnoreCase(purchaseOrderModel.getStatus()),
                "Status Do Not Match");

        for(i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).getVariant().getSku_code());
            assertion.assertTrue(list.get(i).getVariant().getSku_code()
                            .equalsIgnoreCase(editPurchaseOrder.getSkuCode(i+1)),
                    "SkuCodes Do Not Match");
            System.out.println(list.get(i).getVariant().getNotes());
            assertion.assertTrue(list.get(i).getVariant().getNotes()
                            .equalsIgnoreCase(editPurchaseOrder.getDescription(i+1)),
                    "Notes Do Not Match");

            System.out.println(list.get(i).getOrdered_quantity());
            assertion.assertTrue(String.valueOf(list.get(i).getOrdered_quantity())
                            .equalsIgnoreCase(editPurchaseOrder.getOrderedQuantity(i+1)),
                    "Ordered Quantities Do Not Match");
        }
    }


    @BeforeClass(alwaysRun = true)
    public void poStatusAfterClass() {
        System.out.println("PO Status After Class is called");
    }


}
