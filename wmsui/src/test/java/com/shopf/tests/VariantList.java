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

public class VariantList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private VariantsPageObjects variantsPageObjects;
    private VariantsPageObjects.VariantListTab variantListTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<VariantDetailsModel> list;
    private String test;
    private Assertion assertion;


    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void VariantListBeforeClass(String test) throws Exception {
        System.out.println("Variant List Before Class is called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        variantsPageObjects = new VariantsPageObjects(driver);
        variantListTab = variantsPageObjects.new VariantListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }


    @Test(groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Variant List")
    public void verifyVariantList() {
        System.out.println("Verify Variant List is called");
        int i, total;
        homePageObject.clickVariants();
        variantsPageObjects.clickVariantListTab();
        sleep(1000);
        list = getWMSApiResponse.getVariantDetails();
        total = variantListTab.getTotalProducts();
        System.out.println("List Size: " + total);

        for (i = 0; i < list.size(); i++) {
            if (i == 0 || i == (list.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                System.out.println(list.get(i).getId());
                assertion.assertTrue(variantListTab.getVariantId(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getId())),
                        "VariantIds Do Not Match");

                System.out.println(list.get(i).getSeller().getName());
                assertion.assertTrue(variantListTab.getSellerName(i + 1)
                                .equalsIgnoreCase(list.get(i).getSeller().getName()),
                        "SellerNames Do Not Match");

                System.out.println(list.get(i).getNotes());
                assertion.assertTrue(variantListTab.getDescription(i + 1)
                                .equalsIgnoreCase(list.get(i).getNotes()),
                        "Notes Do Not Match");

                System.out.println(list.get(i).getSku_code());
                assertion.assertTrue(variantListTab.getVariantId(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getId())),
                        "Sku_codes Do Not Match");

                System.out.println(list.get(i).getCategory().getName());
                assertion.assertTrue(variantListTab.getCategory(i + 1)
                                .equalsIgnoreCase(list.get(i).getCategory().getName()),
                        "Categories Do Not Match");

                System.out.println(list.get(i).getPrice());
                assertion.assertEquals(variantListTab.getPrice(i + 1),
                              (list.get(i).getPrice()),
                        "Prices Do Not Match");

                System.out.println(list.get(i).getReorder_point());
                assertion.assertTrue(variantListTab.getReorderPoint(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getReorder_point())),
                        "ReorderPoints Do Not Match");

                System.out.println(list.get(i).getVariant_market_place_mappings()
                        .get(0).getMarket_place().getName());
                assertion.assertTrue(variantListTab.getMarketPlace(i + 1)
                                .equalsIgnoreCase(list.get(i).getVariant_market_place_mappings()
                                        .get(0).getMarket_place().getName()),
                        "Market_places Do Not Match");

                System.out.println(list.get(i).getVariant_market_place_mappings()
                        .get(0).getUvid());
                assertion.assertTrue(variantListTab.getMPVariantId(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getVariant_market_place_mappings()
                                        .get(0).getUvid())),
                        "MPVariantIds Do Not Match");
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void VariantListAfterClass() {
        System.out.println("Variant List After Class is called");
    }
}
