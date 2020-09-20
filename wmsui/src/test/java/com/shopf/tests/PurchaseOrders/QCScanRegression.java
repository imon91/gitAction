package com.shopf.tests.PurchaseOrders;

import com.google.gson.Gson;
import coreUtils.CoreConstants;
import dataParcer.CSVParser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.CreateGRNModel;
import services.responseModels.wmsModels.QCScanModel;
import utils.*;

import java.io.*;
import java.util.*;

public class QCScanRegression extends WmsBaseClass {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private PurchaseOrdersPageObjects.QcScanTab qcScanTab;
    private PurchaseOrdersPageObjects.GRNViewTab grnViewTab;
    private Actions actions;
    private Random random;
    private Assertion assertion;
    private String poId1, poId2;
    private String grnId1, grnId2;
    private String spId1,spId2,gpId1,gpId2;


    @BeforeClass(alwaysRun = true)
    public void qcScanBeforeClass() throws Exception {
        System.out.println("QC Scan Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        purchaseOrderList = purchaseOrdersPageObjects.new PurchaseOrderList(driver);
        grnViewTab = purchaseOrdersPageObjects.new GRNViewTab(driver);
        qcScanTab = purchaseOrdersPageObjects.new QcScanTab(driver);
        actions = new Actions(driver);
        random = new Random();
        assertion = new Assertion();

        homePageObject.selectWarehouse("Shopup Dhaka");
        homePageObject.clickPurchaseOrders();
        poId1 = purchaseOrderList.qcScanPO("RECEIVED");
        poId2 = purchaseOrderList.qcScanPO("PARTIALLY_RECEIVED");
        purchaseOrdersPageObjects.clickGRNViewTab();
        grnViewTab.poIDEntry(poId1);
        grnId1 = grnViewTab.getGRNId("1");
        driver.navigate().refresh();
        purchaseOrdersPageObjects.clickGRNViewTab();
        grnViewTab.poIDEntry(poId2);
        grnId2 = grnViewTab.getGRNId("1");
        driver.get("https://uatwms.vnksrvc.com/grns/"+grnId1+"/print_packages");
        spId1 = qcScanTab.getFirstPackage("2");
        spId2 = qcScanTab.getFirstPackage("3");
        driver.get("https://uatwms.vnksrvc.com/grns/"+grnId2+"/print_group_packages");
        gpId1 = qcScanTab.getFirstPackage("2");
        gpId2 = qcScanTab.getFirstPackage("5");
        driver.get("https://uatwms.vnksrvc.com/purchase_orders");
    }

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData(){
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/QCScan.csv";
        return CSVParser.getDataForDataProvider(filePath, QCScanModel.class);
    }

    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            dataProvider = "CSVData",
            description = "Qc Scan Verification")
    public void verifyQCScan(Object body) {
        Gson gson = new Gson();
        QCScanModel q = gson.fromJson(body.toString(), QCScanModel.class);
        purchaseOrdersPageObjects.clickQcScanTab();
        qcScanTab.qcScanner(q,spId1,spId2,gpId1,gpId2);
        if(!q.getToastMessage().equals("N/A"))
            assertion.assertTrue(q.getToastMessage().equalsIgnoreCase(homePageObject.getPopUpMessage()));
        driver.navigate().refresh();
        }
    @AfterClass(alwaysRun = true)
    public void qcScanAfterClass() throws Exception {
        System.out.println("QC Scan After Class is Called");
    }
}

