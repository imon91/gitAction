package com.shopf.tests.PickOrders;

import com.google.gson.*;
import coreUtils.*;
import dataParcer.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import utils.*;

import java.io.*;
import java.util.*;

public class PickListActionRegression  extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PickOrdersPageObjects pickOrdersPageObjects;
    private PickOrdersPageObjects.DemandLessPickListTab demandLessPickListTab;
    private PickOrdersPageObjects.AllPickListsTab allPickListsTab;
    private PickOrdersPageObjects.PickListActionTab pickListActionTab;
    private Random random;
    private Assertion assertion;
    private String id;

    @BeforeClass(alwaysRun = true)
    public void pickListActionBeforeClass() throws Exception {
        System.out.println("Pick List Action Before Class");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        demandLessPickListTab = pickOrdersPageObjects.new DemandLessPickListTab(driver);
        allPickListsTab = pickOrdersPageObjects.new AllPickListsTab(driver);
        pickListActionTab = pickOrdersPageObjects.new PickListActionTab(driver);
        random = new Random();
        assertion = new Assertion();
        homePageObject.clickPickOrders();
        homePageObject.selectWarehouse("TestWarehouse");
        pickOrdersPageObjects.clickDemandLessPickListTab();
        demandLessPickListTab.enterWarehouseDetails();
        demandLessPickListTab.createPickListOrder("172910");
        pickOrdersPageObjects.clickAllPickListsTab();
        id = allPickListsTab.outForPickup(1);
    }

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/PickListAction.csv";
        return CSVParser.getDataForDataProvider(filePath, PickListActionModel.class);
    }

    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dataProvider = "CSVData",
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"),
            description = "Verify Pick List Action")
    public void createPurchaseOrderVerification(Object body) throws FileNotFoundException {
        System.out.println("Pick List Action Verification is Called");
        pickOrdersPageObjects.clickPickListActionTab();
        Gson gson = new Gson();
        PickListActionModel pickListActionModel = gson.fromJson(body.toString(),PickListActionModel.class);
        assertion.assertTrue(pickListActionTab.pickListActionReg(pickListActionModel,id));

        driver.navigate().refresh();



    }

    @AfterClass(alwaysRun = true)
    public void pickListActionAfterClass() {
        System.out.println("Pick List Action After Class");
    }
}