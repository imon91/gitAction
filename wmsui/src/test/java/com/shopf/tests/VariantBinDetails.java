package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class VariantBinDetails extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private VariantsPageObjects variantsPageObjects;
    private VariantsPageObjects.BinsForSkuTab binsForSkuTab;
    private GetWMSApiResponse getWMSApiResponse;
    private VariantsBinDetailsModel variantsBinDetailsModel;
    private List<VariantsBinDetailsModel.BinDetailsBean> list;

    @BeforeClass(alwaysRun = true)
    public void variantBinDetailsBeforeClass() throws Exception {
        System.out.println("Variant Bin Details Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        variantsPageObjects = new VariantsPageObjects(driver);
        binsForSkuTab = variantsPageObjects.new BinsForSkuTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Variant Bin Details List")
    public void verifyVariantBinDetails() {
        System.out.println("Verify Variant Bin Details is called");
        int i, total;
        homePageObject.clickVariants();
        variantsPageObjects.clickBinsForSkuTab();
        sleep(1000);
        binsForSkuTab.checkVariantBins("Shishang", "17123_DSL007_30_KI");
        variantsBinDetailsModel = getWMSApiResponse
                .getVariantBinDetails("17123_DSL007_30_KI", "3");
        total = binsForSkuTab.getTotalBins();
        list = variantsBinDetailsModel.getBin_details();
        System.out.println(total == list.size());
        for (i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getBin_code() + " - " +
                    binsForSkuTab.getBinCode(i + 1)
                            .equalsIgnoreCase(list.get(i).getBin_code()));

            System.out.println(list.get(i).getCount() + " - " +
                    binsForSkuTab.getQuantity(i + 1)
                            .equalsIgnoreCase(String.valueOf(list.get(i).getCount())));

            System.out.println(list.get(i).getPackage_ids() + " - " +
                    binsForSkuTab.getPackageIds(i + 1)
                            .equalsIgnoreCase(list.get(i).getPackage_ids()));
        }
    }

    @AfterClass(alwaysRun = true)
    public void variantBinDetailsAfterClass() {
        System.out.println("Variant Bin Details After Class is called");
    }
}
