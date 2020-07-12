package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PurchaseOrdersPageObjects;
import utils.WmsBaseClass;

public class CreatingPurchaseOrder extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;

    @BeforeClass(alwaysRun = true)
    public void creatingPurchaseBeforeClass() throws Exception{
        System.out.println("Creating Purchase Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        createPurchaseOrderTab = new PurchaseOrdersPageObjects(driver).new CreatePurchaseOrderTab(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE), dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials")
    public void createPurchaseVerification(){
        System.out.println("Create Purchase Verification is Called");
        homePageObject.clickPurchaseOrders();
        createPurchaseOrderTab.enterWarehouseDetails();
        createPurchaseOrderTab.createPurchaseOrder();
        setImplicitWait(3);
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        sleep(2000);
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        sleep(2000);
        String poId = purchaseOrderList.getPOID(1);
        System.out.println("The last added PO: "+ poId);
    }

    @AfterClass(alwaysRun = true)
    public void creatingPurchaseAfterClass(){
        System.out.println("Creating Purchase After Class is Called");
    }

}
