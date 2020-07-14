package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class WarehouseList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.WarehouseListTab warehouseListTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<WareHouseListModel.WareHousesBean> wareHousesBeanList;

    @BeforeClass(alwaysRun = true)
    public void warehouseListBeforeClass() throws Exception {
        System.out.println("Warehouse List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        warehouseListTab = warehousesPageObjects.new WarehouseListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Parameters({"test"})
    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Warehouse List")
    public void verifyWarehouseList(String test) {
        System.out.println("Verify Warehouse List is called");
        int i;
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickWarehouseListTab();
        sleep(1000);
        wareHousesBeanList = getWMSApiResponse.getListOfWarehouses();
        System.out.println(String.valueOf(warehouseListTab.getTotalWarehouses())
                .equalsIgnoreCase(String.valueOf(wareHousesBeanList.size()))
                + "-" + wareHousesBeanList.size());
        for (i = 0; i < wareHousesBeanList.size(); i++) {
            if (i == 0 || i == (wareHousesBeanList.size() - 1) || test.equals("regression")) {
                System.out.println("----------------------------------");
                System.out.println(warehouseListTab.getWarehouseCode(i + 1)
                        .equalsIgnoreCase(wareHousesBeanList.get(i).getCode())
                        + "-" + wareHousesBeanList.get(i).getCode());

                System.out.println(warehouseListTab.getAddress1(i + 1)
                        .equalsIgnoreCase(wareHousesBeanList.get(i).getAddress1())
                        + "-" + wareHousesBeanList.get(i).getAddress1());

                System.out.println(warehouseListTab.getAddress2(i + 1)
                        .equalsIgnoreCase(wareHousesBeanList.get(i).getAddress2())
                        + "-" + wareHousesBeanList.get(i).getAddress2());

                System.out.println(warehouseListTab.getLandmark(i + 1)
                        .equalsIgnoreCase(wareHousesBeanList.get(i).getLand_mark())
                        + "-" + wareHousesBeanList.get(i).getLand_mark());

                System.out.println(warehouseListTab.getCity(i + 1)
                        .equalsIgnoreCase(wareHousesBeanList.get(i).getCity())
                        + "-" + wareHousesBeanList.get(i).getCity());

                System.out.println(warehouseListTab.getState(i + 1)
                        .equalsIgnoreCase(wareHousesBeanList.get(i).getState())
                        + "-" + wareHousesBeanList.get(i).getState());

                System.out.println(warehouseListTab.getCountry(i + 1)
                        .equalsIgnoreCase(wareHousesBeanList.get(i).getCountry())
                        + "-" + wareHousesBeanList.get(i).getCountry());

                System.out.println(warehouseListTab.getZipCode(i + 1)
                        .equalsIgnoreCase(String.valueOf(wareHousesBeanList.get(i).getZipcode()))
                        + "-" + wareHousesBeanList.get(i).getZipcode());

                System.out.println(" ");

            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void WarehouseListAfterClass() {
        System.out.println("Warehouse List After Class is called");
    }

}
