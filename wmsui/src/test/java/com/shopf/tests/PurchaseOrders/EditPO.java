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

public class EditPO extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.EditPurchaseOrder editPurchaseOrder;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void closePOBeforeClass() throws Exception {
        System.out.println("Edit PO Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
        editPurchaseOrder = new PurchaseOrdersPageObjects(driver).new EditPurchaseOrder(driver);
        assertion = new Assertion();
    }

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/editPO.csv";
        return CSVParser.getDataForDataProvider(filePath, EditPOModel.class);

    }

    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            dataProvider = "CSVData",
            description = "Close PO Verification")
    public void editPOVerification(Object body) {
        System.out.println("Edit PO Verification is called");
        homePageObject.selectWarehouse("Shopup Dhaka");
        homePageObject.clickPurchaseOrders();
        Gson gson = new Gson();
        EditPOModel editPOModel = gson.fromJson(body.toString(),EditPOModel.class);
        assertion.assertTrue(editPurchaseOrder.editPO(editPOModel));
        driver.navigate().refresh();
    }

    @AfterClass(alwaysRun = true)
    public void closePOAfterClass() {
        System.out.println("Edit PO After Class is called");
    }
}