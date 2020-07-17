package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class SellersList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private SuppliersPageObjects suppliersPageObjects;
    private SuppliersPageObjects.SellersListTab sellersListTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<SellersListModel> sellersListModels;
    private Assertion assertion;
    String test;

    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void suppliersListBeforeClass(String test) throws Exception {
        System.out.println("Suppliers List Before Class is called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        suppliersPageObjects = new SuppliersPageObjects(driver);
        sellersListTab = suppliersPageObjects.new SellersListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Seller List")
    public void verifySellersList() {
        int i,j;
        homePageObject.clickSuppliers();
        suppliersPageObjects.clickSellersListTab();
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        sellersListModels = getWMSApiResponse.getSellerDetails();
        System.out.println("List Size: " + sellersListModels.size());

        for (i = 0; i < sellersListModels.size(); i++) {
            if (i == 0 || i == (sellersListModels.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                List<SellersListModel.SellerMarketPlaceMappingsBean> listMPM =
                        sellersListModels.get(i).getSeller_market_place_mappings();
                List<SellersListModel.SellerWarehouseMappingsBean> listWM =
                        sellersListModels.get(i).getSeller_warehouse_mappings();
                SellersListModel.SellerMarketPlaceMappingsBean.MarketPlaceBean marketPlaceBeans =
                        listMPM.get(0).getMarket_place();
                List<String> gst = sellersListTab.getGSTNo(i + 1);
                List<String> warehouse = sellersListTab.getWarehouseCode(i + 1);

                System.out.println(sellersListModels.get(i).getName());
                assertion.assertTrue(sellersListModels.get(i).getName()
                        .equalsIgnoreCase(sellersListTab.getSupplierName(i + 1)),
                        "Supplier Names Do Not Match");

                for(j=0;j<listWM.size();j++){

                    System.out.println("----------------------------------");

                    System.out.println(listWM.get(j).getGst_number());
                    assertion.assertTrue(listWM.get(j).getGst_number()
                                    .equalsIgnoreCase(gst.get(j)),
                            "Gst_numbers Do Not Match");
                    System.out.println(listWM.get(j).getWarehouse().getCode());
                    assertion.assertTrue(listWM.get(j).getWarehouse().getCode()
                                    .equalsIgnoreCase(warehouse.get(j)),
                            "Warehouses Do Not Match");
                }

                System.out.println(marketPlaceBeans.getName());
                assertion.assertTrue(marketPlaceBeans.getName()
                                .equalsIgnoreCase(sellersListTab.getMarketPlace(i + 1)),
                        "Market Places Do Not Match");

                System.out.println(listMPM.get(0).getUser_id());
                assertion.assertTrue(listMPM.get(0).getUser_id()
                                .equalsIgnoreCase(sellersListTab.getUserId(i + 1)),
                        "User Ids Do Not Match");
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void suppliersListAfterClass() {
        System.out.println("Suppliers List After Class is called");
    }
}

