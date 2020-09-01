package com.shopf.tests.Warehouses;

import com.google.gson.*;
import coreUtils.*;
import dataParcer.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.*;
import utils.*;

import java.io.*;
import java.util.*;

public class WarehouseBinDetailRegression extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.WarehouseBinDetailsTab warehouseBinDetailsTab;
    private GetWMSApiResponse getWMSApiResponse;
    private WarehouseBinDetails warehouseBinDetails;
    private List<WarehouseBinDetails.PackageDetailsBean> packageDetails;
    private Assertion assertion;
    private String test;
    private Scanner s;
    private Random random;


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

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/WarehouseBinDetail.csv";
        return CSVParser.getDataForDataProvider(filePath, WarehouseBinDetailRegModel.class);

    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dataProvider = "CSVData",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Warehouse Bin Details")
    public void verifyWarehouseBinDetail(Object body) throws FileNotFoundException {
        System.out.println("Verify Warehouse Bin Details is called");
        Gson gson = new Gson();
        WarehouseBinDetailRegModel wModel = gson.fromJson(body.toString(), WarehouseBinDetailRegModel.class);
        System.out.println(wModel.getTestCaseId());
        int i;
        String[] allInputData = warehouseBinDetailsTab.getAllInputData(wModel.getWarehouseBinCode());
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickBinDetailsTab();
        warehouseBinDetailsTab.binCodeEntry(allInputData);
        switch (wModel.getTestCaseId()) {
            case "VBD_1":
            case "VBD_2":
                assertion.assertTrue(homePageObject.getPopUpMessage().equals(wModel.getToastMessage()));
                break;
            case "VBD_3":
                String binCode = allInputData[0];
                warehouseBinDetails = getWMSApiResponse.getWarehouseBinDetails(binCode);
                packageDetails = warehouseBinDetails.getPackage_details();
                System.out.println(packageDetails.size());

                for (i = 0; i < packageDetails.size(); i++) {
                    {

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
        driver.navigate().refresh();
    }


    @AfterClass(alwaysRun = true)
    public void warehouseBinDetailAfterClass() {
        System.out.println("Warehouse Bin Details After Class is called");
    }
}

