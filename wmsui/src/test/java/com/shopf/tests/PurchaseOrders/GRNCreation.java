package com.shopf.tests.PurchaseOrders;

import com.google.gson.Gson;
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

public class GRNCreation extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private PurchaseOrdersPageObjects.CreateGRNTab createGRNTab;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;
    private List<VariantDetailsModel> list;
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
    }

    @DataProvider(name = "skuCodeData")
    public Object[][] getSkuCodeData() throws FileNotFoundException {
        gson = new Gson();
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/sellerSkuCodes.json";

        bufferedReader = new BufferedReader(new FileReader(filePath));
        list = gson.fromJson(bufferedReader,
                new TypeToken<List<VariantDetailsModel>>(){}.getType());

        int n = random.nextInt(list.size()) + 1;
        return new Object[][]{
                {"Id",list.get(n-1).getSku_code()}
        };
    }


    @BeforeMethod(alwaysRun = true)
    public void createGRNBeforeMethod(){
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickCreatePurchaseOrderTab();
        createPurchaseOrderTab.enterWarehouseDetails();
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dataProvider = "skuCodeData",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Create GRN Verification")
    public void createGRNVerification(String name, String id) {
        System.out.println("Create GRN Verification is called");
        System.out.println(name + " : " + id);
        createPurchaseOrderTab.createPurchaseOrder(id);
        sleep(3000);
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        int i, total = purchaseOrderList.getTotalPurchaseOrders();
        for (i = 1; i <= total; i++)
            if (purchaseOrderList.getStatus(i).equalsIgnoreCase("CREATED"))
                break;
        String poId = purchaseOrderList.getPOID(i);
        purchaseOrdersPageObjects.clickCreateGRNTab();
        createGRNTab.poIDEntry(poId);
        createGRNTab.clickGRNButton();
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        assertion.assertEquals(message,"GRN Created");
    }

    @AfterClass(alwaysRun = true)
    public void createGRNAfterClass() {
        System.out.println("Create GRN After Class is called");
    }
}
