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

public class WarehouseBinDetail extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.WarehouseBinDetailsTab warehouseBinDetailsTab;
    private GetWMSApiResponse getWMSApiResponse;
    private WarehouseBinDetails warehouseBinDetails;
    private List<WarehouseBinDetails.PackageDetailsBean> packageDetails;
    private Assertion assertion;
    private String test;


    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void warehouseBinDetailBeforeClass(String test) throws Exception {
        System.out.println("Warehouse Bin Details Before Class is called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        warehouseBinDetailsTab = warehousesPageObjects.new WarehouseBinDetailsTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }


    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Warehouse Bin Details")
    public void verifyWarehouseBinDetail() {
        System.out.println("Verify Warehouse Bin Details is called");
        int i;
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickBinDetailsTab();
        sleep(1000);
        warehouseBinDetailsTab.binCodeEntry("W100F2R1C1RA1B31");
        warehouseBinDetails = getWMSApiResponse.getWarehouseBinDetails();
        packageDetails = warehouseBinDetails.getPackage_details();
        System.out.println(packageDetails.size());

        for (i = 0; i < packageDetails.size(); i++) {
            if (i == 0 || i == (packageDetails.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                System.out.println(packageDetails.get(i).getSku_code());
                assertion.assertTrue(packageDetails.get(i).getSku_code()
                                .equalsIgnoreCase(warehouseBinDetailsTab.getSkuCode(i + 1)),
                        "Sku_codes Do Not Match");

                System.out.println(packageDetails.get(i).getPackage_ids());
                assertion.assertTrue(packageDetails.get(i).getPackage_ids()
                                .equalsIgnoreCase(warehouseBinDetailsTab.getPackageIds(i + 1)),
                        "Package_ids Do Not Match");
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void warehouseBinDetailAfterClass() {
        System.out.println("Warehouse Bin Details After Class is called");
    }
}
