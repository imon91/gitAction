package com.shopf.wapTests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
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
    private Assertion assertion;
    private String test;


    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void warehouseListBeforeClass(String test) throws Exception {
        System.out.println("Warehouse List Before Class is called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        warehouseListTab = warehousesPageObjects.new WarehouseListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }


    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Warehouse List")
    public void verifyWarehouseList() {
        System.out.println("Verify Warehouse List is called");
        int i;
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickWarehouseListTab();
        sleep(1000);
        wareHousesBeanList = getWMSApiResponse.getListOfWarehouses();
        System.out.println("List Size: " + wareHousesBeanList.size());

        for (i = 0; i < wareHousesBeanList.size(); i++) {
            if (i == 0 || i == (wareHousesBeanList.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                System.out.println(wareHousesBeanList.get(i).getCode());
                assertion.assertTrue(warehouseListTab.getWarehouseCode(i + 1)
                                .equalsIgnoreCase(wareHousesBeanList.get(i).getCode()),
                        "WarehouseCodes Do Not Match");

                System.out.println(wareHousesBeanList.get(i).getAddress1());
                assertion.assertTrue(warehouseListTab.getAddress1(i + 1)
                                .equalsIgnoreCase(wareHousesBeanList.get(i).getAddress1()),
                        "Address1 Does Not Match");

                System.out.println(wareHousesBeanList.get(i).getAddress2());
                assertion.assertTrue(warehouseListTab.getAddress2(i + 1)
                                .equalsIgnoreCase(wareHousesBeanList.get(i).getAddress2()),
                        "Address2 Does Not Match");

                System.out.println(wareHousesBeanList.get(i).getLand_mark());
                assertion.assertTrue(warehouseListTab.getLandmark(i + 1)
                                .equalsIgnoreCase(wareHousesBeanList.get(i).getLand_mark()),
                        "Land_marks Do Not Match");

                System.out.println(wareHousesBeanList.get(i).getCity());
                assertion.assertTrue(warehouseListTab.getCity(i + 1)
                                .equalsIgnoreCase(wareHousesBeanList.get(i).getCity()),
                        "Cities Do Not Match");

                System.out.println(wareHousesBeanList.get(i).getState());
                assertion.assertTrue(warehouseListTab.getState(i + 1)
                                .equalsIgnoreCase(wareHousesBeanList.get(i).getState()),
                        "States Do Not Match");

                System.out.println(wareHousesBeanList.get(i).getCountry());
                assertion.assertTrue(warehouseListTab.getCountry(i + 1)
                                .equalsIgnoreCase(wareHousesBeanList.get(i).getCountry()),
                        "Countries Do Not Match");

                System.out.println(wareHousesBeanList.get(i).getZipcode());
                assertion.assertTrue(warehouseListTab.getZipCode(i + 1)
                                .equalsIgnoreCase(String.valueOf(wareHousesBeanList.get(i).getZipcode())),
                        "Zipcodes Do Not Match");
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void WarehouseListAfterClass() {
        System.out.println("Warehouse List After Class is called");
    }

}
