package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PurchaseOrdersPageObjects;
import utils.WmsBaseClass;

public class ClosePO extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.EditPurchaseOrder editPurchaseOrder;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;

    @BeforeClass(alwaysRun = true)
    public void closePOBeforeClass() throws Exception{
        System.out.println("Close PO Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
        editPurchaseOrder = new PurchaseOrdersPageObjects(driver).new EditPurchaseOrder(driver);
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials")
    public void closePOVerification(){
        System.out.println("Close PO Verification is called");
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        sleep(2000);
        int i,total = purchaseOrderList.getTotalPurchaseOrders();
        for(i=1;i <= total;i++)
            if(!purchaseOrderList.getStatus(i).equalsIgnoreCase("CLOSED"))
                if(!purchaseOrderList.getStatus(i).equalsIgnoreCase("RECEIVED"))
                    break;
        String poId = purchaseOrderList.getPOID(i);
        purchaseOrdersPageObjects.clickEditPurchaseOrderTab();
        editPurchaseOrder.poIdInput(poId);
        sleep(1000);
        editPurchaseOrder.clickClosePOButton();
        setImplicitWait(3);
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();

    }

    @AfterClass(alwaysRun = true)
    public void closePOAfterClass(){
        System.out.println("Close PO After Class is called");
    }
}
