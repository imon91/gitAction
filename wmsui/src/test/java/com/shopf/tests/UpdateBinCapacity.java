package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.WarehousesPageObjects;
import utils.WmsBaseClass;

public class UpdateBinCapacity extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.UpdateBinCapacityTab updateBinCapacityTab;

    @BeforeClass(alwaysRun = true)
    public void updateBinCapacityBeforeClass() throws Exception{
        System.out.println("Update Bin Capacity Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        updateBinCapacityTab = warehousesPageObjects.new UpdateBinCapacityTab(driver);
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials")
    public void verifyUpdateBinCapacity(){
        System.out.println("verify Update Bin Capacity is called");
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickUpdateBinCapacityTab();
        updateBinCapacityTab.updateBinCapacity("W100F2R1C1RA4B71","20");
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
    }

    @AfterClass(alwaysRun = true)
    public void updateBinCapacityAfterClass() throws Exception {
        System.out.println("Update Bin Capacity After Class is called");
    }
    }
