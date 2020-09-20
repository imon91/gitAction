package com.shopf.tests.PurchaseOrders;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import coreUtils.CoreConstants;
import dataParcer.CSVParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import pageObjects.HomePageObject;
import pageObjects.PurchaseOrdersPageObjects;
import services.responseModels.wmsModels.CreateGRNModel;
import services.responseModels.wmsModels.CreatePOModel;
import services.responseModels.wmsModels.VariantDetailsModel;
import utils.WmsBaseClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class CreateGRNRegression extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private PurchaseOrdersPageObjects.CreateGRNTab createGRNTab;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;
    List<String> list;
    private Random random;
    private Gson gson;
    private BufferedReader bufferedReader;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void createGRNBeforeClass() throws Exception {
        System.out.println("Create GRN Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        createPurchaseOrderTab = purchaseOrdersPageObjects.new CreatePurchaseOrderTab(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
        createGRNTab = new PurchaseOrdersPageObjects(driver).new CreateGRNTab(driver);
        random = new Random();
        assertion = new Assertion();
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickCreatePurchaseOrderTab();
        homePageObject.selectWarehouse("Shopup Dhaka");
        list = createPurchaseOrderTab.createPOForGRN();
    }

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/CreateGRN.csv";
        return CSVParser.getDataForDataProvider(filePath, CreateGRNModel.class);

    }

    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dataProvider = "CSVData",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Create GRN Verification")
    public void createGRNVerification(Object body) throws FileNotFoundException {
        System.out.println("Create GRN Verification is called");
        Gson gson = new Gson();
        CreateGRNModel c = gson.fromJson(body.toString(), CreateGRNModel.class);
        purchaseOrdersPageObjects.clickCreateGRNTab();
        createGRNTab.createGRNReg(c,list);
        if(!c.getToastMessage().equals("N/A"))
            assertion.assertTrue(c.getToastMessage().equals(homePageObject.getPopUpMessage()));
        driver.navigate().refresh();
    }

    @AfterClass(alwaysRun = true)
    public void createGRNAfterClass() {
        System.out.println("Create GRN After Class is called");
    }
}
