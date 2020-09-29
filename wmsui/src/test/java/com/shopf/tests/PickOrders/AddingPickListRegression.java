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

public class AddingPickListRegression extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PickOrdersPageObjects pickOrdersPageObjects;
    private PickOrdersPageObjects.DemandLessPickListTab demandLessPickListTab;
    private PickOrdersPageObjects.AllPickListsTab allPickListsTab;
    private Random random;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void addingPickListBeforeClass() throws Exception {
        System.out.println("Adding Pick List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        demandLessPickListTab = pickOrdersPageObjects.new DemandLessPickListTab(driver);
        allPickListsTab = pickOrdersPageObjects.new AllPickListsTab(driver);
        random = new Random();
        assertion = new Assertion();
    }

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/AddingPickList.csv";
        return CSVParser.getDataForDataProvider(filePath, AddingPickListModel.class);
    }

    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dataProvider = "CSVData",
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"),
            description = "Adds Pick List")
    public void createPurchaseOrderVerification(Object body) throws FileNotFoundException {
        System.out.println("Create Purchase Order Verification is Called");
        homePageObject.clickPickOrders();
        pickOrdersPageObjects.clickDemandLessPickListTab();
        Gson gson = new Gson();
        AddingPickListModel addingPickListModel = gson.fromJson(body.toString(),AddingPickListModel.class);
        demandLessPickListTab.addPickList(addingPickListModel);
        driver.navigate().refresh();
    }

    @AfterClass(alwaysRun = true)
    public void addingPickListAfterClass() {
        System.out.println("Adding Pick List After Class is called");
    }
}
