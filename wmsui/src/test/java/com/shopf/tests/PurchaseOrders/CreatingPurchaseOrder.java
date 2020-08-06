package com.shopf.tests.PurchaseOrders;

import com.google.gson.*;
import com.google.gson.reflect.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import utils.*;

import java.io.*;
import java.util.*;

public class CreatingPurchaseOrder extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private List<VariantDetailsModel> list;
    private Random random;
    private Gson gson;
    private BufferedReader bufferedReader;
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

    @DataProvider(name = "skuCodeData")
    public Object[][] getSkuCodeData() throws FileNotFoundException {
        gson = new Gson();
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/sellerSkuCodes.json";

        bufferedReader = new BufferedReader(new FileReader(filePath));
        list = gson.fromJson(bufferedReader,
                new TypeToken<List<VariantDetailsModel>>(){}.getType());

        int n = random.nextInt(list.size());
        return new Object[][]{
                {"Id",list.get(n-1).getSku_code()}
        };
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dataProvider = "skuCodeData",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Create Purchase Verification")
    public void createPurchaseOrderVerification(String name, String id) {
        System.out.println(name + " : " + id);
        System.out.println("Create Purchase Order Verification is Called");
        homePageObject.clickPurchaseOrders();
        homePageObject.selectWarehouse("Shopup Dhaka");
        createPurchaseOrderTab.enterWarehouseDetails();
        createPurchaseOrderTab.createPurchaseOrder(id);
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        assertion.assertEquals(message,"PO creation success");
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        String poId = purchaseOrderList.getPOID(1);
        System.out.println("The last added PO: " + poId);
    }

    @AfterClass(alwaysRun = true)
    public void creatingPurchaseOrderAfterClass() {
        System.out.println("Creating Purchase Order After Class is Called");
    }

}
