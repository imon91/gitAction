package com.shopf.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.wmsModels.VariantDetailsModel;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class GRNCreation extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private PurchaseOrdersPageObjects.CreateGRNTab createGRNTab;
    private PurchaseOrdersPageObjects.CreatePurchaseOrderTab createPurchaseOrderTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<VariantDetailsModel> list;
    private Random random;
    private Gson gson;
    private BufferedReader bufferedReader;

    @BeforeClass(alwaysRun = true)
    public void createGRNBeforeClass() throws Exception {
        System.out.println("Create GRN Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        createPurchaseOrderTab = purchaseOrdersPageObjects.new CreatePurchaseOrderTab(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
        createGRNTab = new PurchaseOrdersPageObjects(driver).new CreateGRNTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        random = new Random();
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


    @BeforeMethod(alwaysRun = true)
    public void createGRNBeforeMethod(){
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickCreatePurchaseOrderTab();
        sleep(1000);
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
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        sleep(1000);
        int i, total = purchaseOrderList.getTotalPurchaseOrders();
        for (i = 1; i <= total; i++)
            if (purchaseOrderList.getStatus(i).equalsIgnoreCase("CREATED"))
                break;
        String poId = purchaseOrderList.getPOID(i);
        purchaseOrdersPageObjects.clickCreateGRNTab();
        sleep(1000);
        createGRNTab.poIDEntry(poId);
        sleep(1000);
        createGRNTab.clickGRNButton();
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        sleep(1000);
    }

    @AfterClass(alwaysRun = true)
    public void createGRNAfterClass() {
        System.out.println("Create GRN After Class is called");
    }
}
