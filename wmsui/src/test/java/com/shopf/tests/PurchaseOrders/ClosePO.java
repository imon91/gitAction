package com.shopf.tests.PurchaseOrders;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import pageObjects.*;
import utils.*;

public class ClosePO extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.EditPurchaseOrder editPurchaseOrder;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void closePOBeforeClass() throws Exception {
        System.out.println("Close PO Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
        editPurchaseOrder = new PurchaseOrdersPageObjects(driver).new EditPurchaseOrder(driver);
        assertion = new Assertion();
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Close PO Verification")
    public void closePOVerification() {
        System.out.println("Close PO Verification is called");
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        int i, total = purchaseOrderList.getTotalPurchaseOrders();
        for (i = 1; i <= total; i++)
            if (!purchaseOrderList.getStatus(i).equalsIgnoreCase("CLOSED"))
                if (!purchaseOrderList.getStatus(i).equalsIgnoreCase("RECEIVED"))
                    break;
        String poId = purchaseOrderList.getPOID(i);
        purchaseOrdersPageObjects.clickEditPurchaseOrderTab();
        editPurchaseOrder.poIdInput(poId);
        editPurchaseOrder.clickClosePOButton();
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        assertion.assertEquals(message,"Purchase Order is closed");
    }

    @AfterClass(alwaysRun = true)
    public void closePOAfterClass() {
        System.out.println("Close PO After Class is called");
    }
}
