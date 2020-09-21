package com.shopf.tests.PickOrders;

import com.google.gson.Gson;
import coreUtils.CoreConstants;
import dataParcer.CSVParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageObjects.HomePageObject;
import pageObjects.PickOrdersPageObjects;
import pageObjects.PurchaseOrdersPageObjects;
import services.responseModels.wmsModels.AddingPickListModel;
import services.responseModels.wmsModels.CreatePOModel;
import services.responseModels.wmsModels.VariantDetailsModel;
import utils.WmsBaseClass;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

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
