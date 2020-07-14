package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class CreatingPurchaseOrder extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;

    @BeforeClass(alwaysRun = true)
    public void creatingPurchaseOrderBeforeClass() throws Exception {
        System.out.println("Creating Purchase Order Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        createPurchaseOrderTab = new PurchaseOrdersPageObjects(driver).new CreatePurchaseOrderTab(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Create Purchase Verification")
    public void createPurchaseOrderVerification() {
        System.out.println("Create Purchase Order Verification is Called");
        homePageObject.clickPurchaseOrders();
        createPurchaseOrderTab.enterWarehouseDetails();
        createPurchaseOrderTab.createPurchaseOrder();
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        sleep(1000);
        String poId = purchaseOrderList.getPOID(1);
        System.out.println("The last added PO: " + poId);
    }

    @AfterClass(alwaysRun = true)
    public void creatingPurchaseOrderAfterClass() {
        System.out.println("Creating Purchase Order After Class is Called");
    }

}
