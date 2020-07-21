package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;


public class UpdateBinCapacity extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.UpdateBinCapacityTab updateBinCapacityTab;

    @BeforeClass(alwaysRun = true)
    public void updateBinCapacityBeforeClass() throws Exception {
        System.out.println("Update Bin Capacity Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        updateBinCapacityTab = warehousesPageObjects.new UpdateBinCapacityTab(driver);
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Update Bin Capacity")
    public void verifyUpdateBinCapacity() {
        System.out.println("Verify Update Bin Capacity is called");
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickUpdateBinCapacityTab();
        sleep(1000);
        updateBinCapacityTab.updateBinCapacity("W100F2R1C1RA4B71", "20");
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
    }

    @AfterClass(alwaysRun = true)
    public void updateBinCapacityAfterClass() {
        System.out.println("Update Bin Capacity After Class is called");
    }
}
