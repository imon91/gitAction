package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.WarehousesPageObjects;
import utils.WmsBaseClass;

public class AddingWarehouse extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.AddWarehouseTab addWarehouseTab;
    private WarehousesPageObjects.WarehouseListTab warehouseListTab;


    @BeforeClass(alwaysRun = true)
    public void addingWarehouseBeforeClass() throws Exception{
        System.out.println("Adding Warehouse Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        addWarehouseTab = new WarehousesPageObjects(driver).new AddWarehouseTab(driver);
        warehouseListTab = new WarehousesPageObjects(driver).new WarehouseListTab(driver);
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"))
    public void verifyWarehouseAddition(){
        System.out.println("Warehouse Addition Verification is called");
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickAddWarehouseTab();
        sleep(1000);
        String binCode = addWarehouseTab.addNewWarehouse();
        System.out.println("New Warehouse created is: " + binCode);
        warehousesPageObjects.clickWarehouseListTab();
        sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        int totalWarehouses = warehouseListTab.getTotalWarehouses();
        String warehouseCode = warehouseListTab.getWarehouseCode(totalWarehouses);
        System.out.println("The last added Warehouse: "+ warehouseCode);
    }

    @AfterClass(alwaysRun = true)
    public void addingWarehouseAfterClass() {
        System.out.println("Adding Warehouse After Class is Called");
    }
}
