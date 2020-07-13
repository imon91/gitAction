package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.WarehousesPageObjects;
import services.responseModels.wmsModels.WarehouseBinDetails;
import services.wmsMethods.GetWMSApiResponse;
import utils.WmsBaseClass;

import java.util.List;

public class WarehouseBinDetail extends WmsBaseClass {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.WarehouseBinDetailsTab warehouseBinDetailsTab;
    private GetWMSApiResponse getWMSApiResponse;
    WarehouseBinDetails warehouseBinDetails;
    List<WarehouseBinDetails.PackageDetailsBean> packageDetails;

    @BeforeClass(alwaysRun = true)
    public void warehouseBinDetailBeforeClass()throws Exception{
        System.out.println("Warehouse Bin Details Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        warehouseBinDetailsTab = warehousesPageObjects.new WarehouseBinDetailsTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION,CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Warehouse Bin Details")
    public void verifyWarehouseBinDetail(){
        System.out.println("Verify Warehouse Bin Details is called");
        int i;
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickBinDetailsTab();
        sleep(1000);
        warehouseBinDetailsTab.binCodeEntry("W100F2R1C1RA1B31");
        warehouseBinDetails = getWMSApiResponse.getWarehouseBinDetails();
        packageDetails = warehouseBinDetails.getPackage_details();
        System.out.println(packageDetails.size());
        for (i=0;i<packageDetails.size();i++) {
            System.out.println(packageDetails.get(i).getSku_code() + "-" +
                    packageDetails.get(i).getSku_code()
                            .equalsIgnoreCase(warehouseBinDetailsTab.getSkuCode(i + 1)));

            System.out.println(packageDetails.get(i).getPackage_ids() + "-" +
                    packageDetails.get(i).getPackage_ids()
                            .equalsIgnoreCase(warehouseBinDetailsTab.getPackageIds(i + 1)));
        }
    }

    @AfterClass(alwaysRun = true)
    public void warehouseBinDetailAfterClass(){
        System.out.println("Warehouse Bin Details After Class is called");
    }
}
