package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class POStatus extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.EditPurchaseOrder editPurchaseOrder;
    private GetWMSApiResponse getWMSApiResponse;
    private List<PurchaseOrderListModel> purchaseOrderListModels;
    private Random random;
    private int n, total;


    @BeforeClass(alwaysRun = true)
    public void poStatusBeforeClass() throws Exception {
        System.out.println("PO Status Before Class is called");
        driver = getBaseDriver();
        random = new Random();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        editPurchaseOrder = purchaseOrdersPageObjects.new EditPurchaseOrder(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        purchaseOrderListModels = getWMSApiResponse.getPurchaseOrderList();
        total = purchaseOrderListModels.size();
        System.out.println(total);
        n = random.nextInt(total) - 1;
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify PO Status")
    public void verifyPOStatus() {
        System.out.println("Verify PO Status is called");
        String poIDJson = String.valueOf(purchaseOrderListModels.get(n).getId());
        System.out.println(poIDJson);
        String statusJson = purchaseOrderListModels.get(n).getStatus();
        System.out.println(statusJson);
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickEditPurchaseOrderTab();
        sleep(1000);
        editPurchaseOrder.poIdInput(poIDJson);
        sleep(1000);
        String status = editPurchaseOrder.getPOStatus();
        System.out.println(status.substring(8));
    }

    @BeforeClass(alwaysRun = true)
    public void poStatusAfterClass() {
        System.out.println("PO Status After Class is called");
    }


}
