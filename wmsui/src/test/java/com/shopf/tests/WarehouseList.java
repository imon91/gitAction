package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.WarehousesPageObjects;
import services.responseModels.wmsModels.WareHouseListModel;
import services.wmsMethods.GetWMSApiResponse;
import utils.WmsBaseClass;

import java.util.List;

public class WarehouseList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.WarehouseListTab warehouseListTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<WareHouseListModel.WareHousesBean> wareHousesBeanList;

    @BeforeClass(alwaysRun = true)
    public void warehouseListBeforeClass()throws Exception{
        System.out.println("Warehouse List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        warehouseListTab = warehousesPageObjects.new WarehouseListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION,CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Warehouse List")
    public void verifyWarehouseList(){
        System.out.println("Verify Warehouse List is called");
        int i;
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickWarehouseListTab();
        sleep(1000);
        wareHousesBeanList = getWMSApiResponse.getListOfWarehouses();
        System.out.println(String.valueOf(warehouseListTab.getTotalWarehouses())
                .equalsIgnoreCase(String.valueOf(wareHousesBeanList.size()))
                +"-"+wareHousesBeanList.size());

        for(i=0;i<wareHousesBeanList.size();i++){
            System.out.println(warehouseListTab.getWarehouseCode(i+1)
                    .equalsIgnoreCase(wareHousesBeanList.get(i).getCode())
                    +"-"+wareHousesBeanList.get(i).getCode());

            System.out.println(warehouseListTab.getAddress1(i+1)
                    .equalsIgnoreCase(wareHousesBeanList.get(i).getAddress1())
                    +"-"+wareHousesBeanList.get(i).getAddress1());

            System.out.println(warehouseListTab.getAddress2(i+1)
                    .equalsIgnoreCase(wareHousesBeanList.get(i).getAddress2())
                    +"-"+wareHousesBeanList.get(i).getAddress2());

            System.out.println(warehouseListTab.getLandmark(i+1)
                    .equalsIgnoreCase(wareHousesBeanList.get(i).getLand_mark())
                    +"-"+wareHousesBeanList.get(i).getLand_mark());

            System.out.println(warehouseListTab.getCity(i+1)
                    .equalsIgnoreCase(wareHousesBeanList.get(i).getCity())
                    +"-"+wareHousesBeanList.get(i).getCity());

            System.out.println(warehouseListTab.getState(i+1)
                    .equalsIgnoreCase(wareHousesBeanList.get(i).getState())
                    +"-"+wareHousesBeanList.get(i).getState());

            System.out.println(warehouseListTab.getCountry(i+1)
                    .equalsIgnoreCase(wareHousesBeanList.get(i).getCountry())
                    +"-"+wareHousesBeanList.get(i).getCountry());

            System.out.println(warehouseListTab.getZipCode(i+1)
                    .equalsIgnoreCase(String.valueOf(wareHousesBeanList.get(i).getZipcode()))
                    +"-"+wareHousesBeanList.get(i).getZipcode());

        }
    }

    @AfterClass(alwaysRun = true)
    public void WarehouseListAfterClass(){
        System.out.println("Warehouse List After Class is called");
    }

}
