package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
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

    @BeforeClass(alwaysRun = true)
    public void suppliersListBeforeClass() throws Exception {
        System.out.println("Suppliers List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        suppliersPageObjects = new SuppliersPageObjects(driver);
        sellersListTab = suppliersPageObjects.new SellersListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Parameters({"test"})
    @Test(groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Seller List")
    public void verifySellersList(String test) {
        int i;
        homePageObject.clickSuppliers();
        suppliersPageObjects.clickSellersListTab();
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        sellersListModels = getWMSApiResponse.getSellerDetails();
        for (i = 0; i < sellersListModels.size(); i++) {
            if (i == 0 || i == (sellersListModels.size() - 1) || test.equals("regression")) {
                System.out.println("----------------------------------");
                System.out.println(sellersListModels.get(i).getName() + " - " +
                        sellersListTab.getSupplierName(i + 1) + " - " +
                        sellersListModels.get(i).getName()
                                .equalsIgnoreCase(sellersListTab.getSupplierName(i + 1)));

                List<SellersListModel.SellerMarketPlaceMappingsBean> listMPM =
                        sellersListModels.get(i).getSeller_market_place_mappings();
                List<SellersListModel.SellerWarehouseMappingsBean> listWM =
                        sellersListModels.get(i).getSeller_warehouse_mappings();
                SellersListModel.SellerMarketPlaceMappingsBean.MarketPlaceBean marketPlaceBeans =
                        listMPM.get(0).getMarket_place();

                System.out.println(marketPlaceBeans.getName() + " - " +
                        sellersListTab.getMarketPlace(i + 1) + " - " +
                        marketPlaceBeans.getName()
                                .equalsIgnoreCase(sellersListTab.getMarketPlace(i + 1)));

                System.out.println(listMPM.get(0).getUser_id() + " - " +
                        sellersListTab.getUserId(i + 1) + " - " +
                        listMPM.get(0).getUser_id()
                                .equalsIgnoreCase(sellersListTab.getUserId(i + 1)));
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void suppliersListAfterClass() {
        System.out.println("Suppliers List After Class is called");
    }
}

