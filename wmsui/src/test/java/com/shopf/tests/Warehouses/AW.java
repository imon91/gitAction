package com.shopf.tests.Warehouses;

import com.google.gson.*;
import coreUtils.*;
import dataParcer.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.AddingWarehouseModel;
import utils.*;

public class AW extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.AddWarehouseTab addWarehouseTab;
    private WarehousesPageObjects.WarehouseListTab warehouseListTab;
    private Assertion assertion;
    private String test;

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/AddingWarehouse.csv";
        return CSVParser.getDataForDataProvider(filePath, AddingWarehouseModel.class);

    }

    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void addingWarehouseBeforeClass(String test) throws Exception {
        System.out.println("Adding Warehouse Before Class is Called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        addWarehouseTab = new WarehousesPageObjects(driver).new AddWarehouseTab(driver);
        warehouseListTab = new WarehousesPageObjects(driver).new WarehouseListTab(driver);
        assertion = new Assertion();
    }

    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"),
            dataProvider = "CSVData",
            description = "Adds Warehouse")
    public void verifyWarehouseAddition(Object body) throws Exception {
        System.out.println("Warehouse Addition Verification is called");
        int i;
        homePageObject.clickWarehouses();
        sleep(1000);
        Gson gson = new Gson();
        AddingWarehouseModel addingWarehouseModel = gson.fromJson(body.toString(),AddingWarehouseModel.class);

        String[] allInputDataFromCsv = addingWarehouseModel.getAll();
        String[] allInputData = addWarehouseTab.getAllInputData(addingWarehouseModel.getAll());
        String[] allErrorData = addWarehouseTab.getAllErrorMessageData(addingWarehouseModel.getAll());
        System.out.println(addingWarehouseModel.getTestCaseId()+" - "+addingWarehouseModel.getTestCase());
        for(i=0;i<allInputDataFromCsv.length;i++)
        {
            System.out.print(allInputDataFromCsv[i]);
            System.out.print(" - ");
            System.out.print(allInputData[i]);
            System.out.print(" - ");
            System.out.println(allErrorData[i]);
        }


        addWarehouseTab.addNewWarehouse(allInputData);
        if(addingWarehouseModel.getToastMessage().equals("N/A"))
            for(i=0;i<allErrorData.length;i++)
                if(allErrorData[i].equals("This field is required"))
                    assertion.assertTrue(addWarehouseTab.verifyVisibilityForAllErrorMessages(i));

        else if(addingWarehouseModel.getToastMessage().equals("Code is already present"))
            assertion.assertTrue(homePageObject.getPopUpMessage().equals(addingWarehouseModel.getToastMessage()));

        else if(addingWarehouseModel.getToastMessage().equals("Warehouse Created"))
            assertion.assertTrue(homePageObject.getPopUpMessage().equals(addingWarehouseModel.getToastMessage()));

        else  System.out.println(addingWarehouseModel.getToastMessage());

        driver.navigate().refresh();

    }

    @AfterClass(alwaysRun = true)
    public void addingWarehouseAfterClass() {
        System.out.println("Adding Warehouse After Class is Called");
    }
}

