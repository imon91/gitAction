package com.shopf.tests;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.PurchaseOrdersPageObjects;
import utils.WmsBaseClass;

public class CreatingPurchaseOrder extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
}
