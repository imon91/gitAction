package com.shopf.tests.PurchaseOrders;

import com.google.gson.Gson;
import coreUtils.*;
import dataParcer.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import utils.*;

import java.io.FileNotFoundException;
import java.util.*;

public class CreatePORegression extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private List<VariantDetailsModel> list;
    private Random random;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void creatingPurchaseOrderBeforeClass() throws Exception {
        System.out.println("Creating Purchase Order Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        createPurchaseOrderTab = new PurchaseOrdersPageObjects(driver).new CreatePurchaseOrderTab(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
        random = new Random();
        assertion = new Assertion();
    }

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/CreatePO.csv";
        return CSVParser.getDataForDataProvider(filePath,CreatePOModel.class);

    }

    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dataProvider = "CSVData",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Create Purchase Verification")
    public void createPurchaseOrderVerification(Object body) throws FileNotFoundException {
        System.out.println("Create Purchase Order Verification is Called");
        homePageObject.clickPurchaseOrders();
        Gson gson = new Gson();
        CreatePOModel createPOModel = gson.fromJson(body.toString(),CreatePOModel.class);
        assertion.assertTrue(createPurchaseOrderTab.createPOReg(createPOModel));
        driver.navigate().refresh();
    }

    @AfterClass(alwaysRun = true)
    public void creatingPurchaseOrderAfterClass() {
        System.out.println("Creating Purchase Order After Class is Called");
    }

}
