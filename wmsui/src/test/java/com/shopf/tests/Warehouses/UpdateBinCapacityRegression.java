package com.shopf.tests.Warehouses;

import com.google.gson.Gson;
import coreUtils.*;
import dataParcer.CSVParser;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import utils.*;

import java.io.*;
import java.util.*;

public class UpdateBinCapacityRegression extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.UpdateBinCapacityTab updateBinCapacityTab;
    private Scanner s;
    private Random random;
    private Assertion assertion;

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/UpdateBinCapacity.csv";
        return CSVParser.getDataForDataProvider(filePath, UpdateBinCapacityModel.class);

    }

    @BeforeClass(alwaysRun = true)
    public void updateBinCapacityBeforeClass() throws Exception {
        System.out.println("Update Bin Capacity Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        updateBinCapacityTab = warehousesPageObjects.new UpdateBinCapacityTab(driver);
        random = new Random();
        assertion = new Assertion();

    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            dataProvider = "CSVData",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Update Bin Capacity")
    public void verifyUpdateBinCapacity(Object body) throws FileNotFoundException {
        Gson gson = new Gson();
        UpdateBinCapacityModel updateBinCapacityModel = gson.fromJson(body.toString(),UpdateBinCapacityModel.class);
        System.out.println(updateBinCapacityModel.getTestCaseId());
        String[] allInputData = updateBinCapacityTab.getAllInputData(updateBinCapacityModel.getAll());
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickUpdateBinCapacityTab();
        updateBinCapacityTab.updateBinCapacity(allInputData);

        if(updateBinCapacityModel.getToastMessage().equals("N/A")){
            if(updateBinCapacityModel.getTestCaseId().equals("UBC_6") || updateBinCapacityModel.getTestCaseId().equals("UBC_8"))
            assertion.assertTrue(updateBinCapacityTab.verifyVisibilityForErrorMessages2());
            else assertion.assertTrue(updateBinCapacityTab.verifyVisibilityForErrorMessages1());
        }
        else if(updateBinCapacityModel.getToastMessage().equals("Bin capacity updation failed"))
            assertion.assertTrue(homePageObject.getPopUpMessage().equals(updateBinCapacityModel.getToastMessage()));

        else if(updateBinCapacityModel.getToastMessage().equals("Bin Capacity is updated"))
            assertion.assertTrue(homePageObject.getPopUpMessage().equals(updateBinCapacityModel.getToastMessage()));

        else  System.out.println(updateBinCapacityModel.getToastMessage());
        driver.navigate().refresh();
    }

    @AfterClass(alwaysRun = true)
    public void updateBinCapacityAfterClass() {
        System.out.println("Update Bin Capacity After Class is called");
    }
}