package com.shopf.tests.Warehouses;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.AllSellersModel;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class WarehouseBinCreate extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.WarehouseBinsCreateTab warehouseBinsCreateTab;
    private WarehousesPageObjects.WarehouseListTab warehouseListTab;
    private AllSellersModel allSellersModel;
    private GetWMSApiResponse getWMSApiResponse;
    private Assertion assertion;
    private Random random;

    @BeforeClass(alwaysRun = true)
    public void warehouseBinCreateBeforeClass() throws Exception {
        System.out.println("Warehouse Bin Create Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        warehouseBinsCreateTab = new WarehousesPageObjects(driver).new WarehouseBinsCreateTab(driver);
        warehouseListTab = new WarehousesPageObjects(driver).new WarehouseListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        allSellersModel = new AllSellersModel();
        assertion = new Assertion();
        random = new Random();
    }
    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"),
            description = "Warehouse Bin Create")
    public void verifyWarehouseBinCreate() throws Exception {
        System.out.println("Warehouse Bin Create Verification is called");
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickWarehouseListTab();
        int n = warehouseListTab.getTotalWarehouses();
        String wCode = warehouseListTab.getWarehouseCode(n);
        System.out.println(wCode);
        homePageObject.selectWarehouse(wCode);
        warehouseBinsCreateTab.performPickupAgentAssociation();
        assertion.assertTrue(homePageObject.getPopUpMessage().equals("Added Successfully"));
        warehouseBinsCreateTab.performUserAssociation(warehouseBinsCreateTab.getUsersJson());
        assertion.assertTrue(homePageObject.getPopUpMessage().equals("Mapping done successfully"));
        warehouseBinsCreateTab.performSellerAssociation(warehouseBinsCreateTab.getSellersJson());
        assertion.assertTrue(homePageObject.getPopUpMessage().equals("Mapping done successfully"));

        homePageObject.selectWarehouse("TestWarehouse");
        warehouseBinsCreateTab.performUserAssociation("VilaraVnksrvcApiUser");
        assertion.assertTrue(homePageObject.getPopUpMessage().equals("User already mapped"));
        warehouseBinsCreateTab.performSellerAssociation("DFW");
        assertion.assertTrue(homePageObject.getPopUpMessage().equals("Warehouse Warehouse is already present for the seller"));
    }

    @AfterClass(alwaysRun = true)
    public void warehouseBinCreateAfterClass() {
        System.out.println("Warehouse Bin Create After Class is Called");
    }

}