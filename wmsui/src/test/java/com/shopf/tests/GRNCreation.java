package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class GRNCreation extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private PurchaseOrdersPageObjects.CreateGRNTab createGRNTab;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;

    @BeforeClass(alwaysRun = true)
    public void createGRNBeforeClass() throws Exception {
        System.out.println("Create GRN Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        createPurchaseOrderTab = purchaseOrdersPageObjects.new CreatePurchaseOrderTab(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
        createGRNTab = new PurchaseOrdersPageObjects(driver).new CreateGRNTab(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void createGRNBeforeMethod(){
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickCreatePurchaseOrderTab();
        sleep(1000);
        createPurchaseOrderTab.enterWarehouseDetails();
        createPurchaseOrderTab.createPurchaseOrder();
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Create GRN Verification")
    public void createGRNVerification() {
        System.out.println("Create GRN Verification is called");
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        sleep(1000);
        int i, total = purchaseOrderList.getTotalPurchaseOrders();
        for (i = 1; i <= total; i++)
            if (purchaseOrderList.getStatus(i).equalsIgnoreCase("CREATED"))
                break;
        String poId = purchaseOrderList.getPOID(i);
        purchaseOrdersPageObjects.clickCreateGRNTab();
        sleep(1000);
        createGRNTab.poIDEntry(poId);
        sleep(1000);
        createGRNTab.clickGRNButton();
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        sleep(1000);
    }

    @AfterClass(alwaysRun = true)
    public void createGRNAfterClass() {
        System.out.println("Create GRN After Class is called");
    }
}
