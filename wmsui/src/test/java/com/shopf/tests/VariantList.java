package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class VariantList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private VariantsPageObjects variantsPageObjects;
    private VariantsPageObjects.VariantListTab variantListTab;
    private GetWMSApiResponse getWMSApiResponse;
    List<VariantDetailsModel> list;

    @BeforeClass(alwaysRun = true)
    public void VariantListBeforeClass() throws Exception {
        System.out.println("Variant List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        variantsPageObjects = new VariantsPageObjects(driver);
        variantListTab = variantsPageObjects.new VariantListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Parameters({"test"})
    @Test(groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Variant List")
    public void verifyVariantList(String test) {
        System.out.println("Verify Variant List is called");
        int i, total;
        homePageObject.clickVariants();
        variantsPageObjects.clickVariantListTab();
        sleep(1000);
        list = getWMSApiResponse.getVariantDetails();
        total = variantListTab.getTotalProducts();
        for (i = 0; i < list.size(); i++) {
            if (i == 0 || i == (list.size() - 1) || test.equals("regression")) {
                System.out.println(list.get(i).getId() + " - " +
                        variantListTab.getVariantId(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getId())));

                System.out.println(list.get(i).getSeller().getName() + " - " +
                        variantListTab.getSellerName(i + 1)
                                .equalsIgnoreCase(list.get(i).getSeller().getName()));

                System.out.println(list.get(i).getNotes() + " - " +
                        variantListTab.getDescription(i + 1)
                                .equalsIgnoreCase(list.get(i).getNotes()));

                System.out.println(list.get(i).getSku_code() + " - " +
                        variantListTab.getVariantId(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getId())));

                System.out.println(list.get(i).getCategory().getName() + " - " +
                        variantListTab.getCategory(i + 1)
                                .equalsIgnoreCase(list.get(i).getCategory().getName()));

                System.out.println(list.get(i).getMrp() + " - " +
                        variantListTab.getPrice(i + 1)
                                .equalsIgnoreCase(list.get(i).getMrp()));

                System.out.println(list.get(i).getReorder_point() + " - " +
                        variantListTab.getReorderPoint(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getReorder_point())));

                System.out.println(list.get(i).getVariant_market_place_mappings().get(0).getMarket_place().getName() + " - " +
                        variantListTab.getMarketPlace(i + 1)
                                .equalsIgnoreCase(list.get(i).getVariant_market_place_mappings().get(0).getMarket_place().getName()));

                System.out.println(list.get(i).getVariant_market_place_mappings().get(0).getUvid() + " - " +
                        variantListTab.getMPVariantId(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getVariant_market_place_mappings().get(0).getUvid())));

            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void VariantListAfterClass() {
        System.out.println("Variant List After Class is called");
    }
}
