package com.shopf.tests.Warehouses;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import utils.*;

public class AddingWarehouse extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.AddWarehouseTab addWarehouseTab;
    private WarehousesPageObjects.WarehouseListTab warehouseListTab;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void addingWarehouseBeforeClass() throws Exception {
        System.out.println("Adding Warehouse Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        addWarehouseTab = new WarehousesPageObjects(driver).new AddWarehouseTab(driver);
        warehouseListTab = new WarehousesPageObjects(driver).new WarehouseListTab(driver);
        assertion = new Assertion();
    }

    @Test(groups = (CoreConstants.GROUP_SANITY),
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"),
            description = "Adds Warehouse")
    public void verifyWarehouseAddition() throws Exception {
        System.out.println("Warehouse Addition Verification is called");
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickAddWarehouseTab();
        String binCode = addWarehouseTab.addNewWarehouse();
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        assertion.assertEquals(message,"Warehouse Created");
        System.out.println("New Warehouse created is: " + binCode);
        warehousesPageObjects.clickWarehouseListTab();
        int totalWarehouses = warehouseListTab.getTotalWarehouses();
        String warehouseCode = warehouseListTab.getWarehouseCode(totalWarehouses);
        System.out.println("The last added Warehouse: " + warehouseCode);
        homePageObject.selectWarehouse("Shopup Dhaka");
    }

    @AfterClass(alwaysRun = true)
    public void addingWarehouseAfterClass() {
        System.out.println("Adding Warehouse After Class is Called");
    }
}
