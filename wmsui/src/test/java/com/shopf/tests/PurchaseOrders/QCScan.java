package com.shopf.tests.PurchaseOrders;

import coreUtils.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import utils.*;

import java.io.*;
import java.util.*;

public class QCScan extends WmsBaseClass{
    private WebDriver driver;
    private HomePageObject homePageObject;
    private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
    private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
    private PurchaseOrdersPageObjects.QcScanTab qcScanTab;
    private Actions actions;
    private PackagesPageObjects packagesPageObjects;
    private PackagesPageObjects.BinInScanTab binInScanTab;
    private Random random;
    private Scanner s;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void qcScanBeforeClass() throws Exception {
        System.out.println("QC Scan Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
        purchaseOrderList = new PurchaseOrdersPageObjects(driver).new PurchaseOrderList(driver);
        qcScanTab = purchaseOrdersPageObjects.new QcScanTab(driver);
        packagesPageObjects = new PackagesPageObjects(driver);
        binInScanTab = packagesPageObjects.new BinInScanTab(driver);
        actions = new Actions(driver);
        random = new Random();
        assertion = new Assertion();
        homePageObject.selectWarehouse("Shopup Dhaka");
    }

    @DataProvider(name = "warehouseBins")
    public Object[][] getWarehouseBinData() throws FileNotFoundException {
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/WarehouseBinsSD.txt";

        s = new Scanner(new File(filePath));
        random = new Random();
        List<String> list = new ArrayList<>();
        while(s.hasNextLine())
            list.add(s.nextLine());

        int n = random.nextInt(list.size())+1;
        return new Object[][]{
                {"Warehouse Bin Code",list.get(n-1)}
        };
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            dataProvider = "warehouseBins",
            description = "Qc Scan Verification")
    public void verifyQCScan(String name, String id){
        homePageObject.clickPurchaseOrders();
        purchaseOrdersPageObjects.clickPurchaseOrderListTab();
        int i, total = purchaseOrderList.getTotalPurchaseOrders();
        for (i = 1; i <= total; i++)
            if (purchaseOrderList.getStatus(i).equalsIgnoreCase("RECEIVED"))
                break;
        String poId = purchaseOrderList.getPOID(i);
        driver.get("https://uatwms.vnksrvc.com/purchase_orders/"+poId+"/print?print_type=barcode");
        actions.sendKeys(Keys.ESCAPE).build().perform();
        String packId = qcScanTab.getFirstPackage();
        System.out.println(packId);
        driver.get("https://uatwms.vnksrvc.com/purchase_orders");
        purchaseOrdersPageObjects.clickQcScanTab();
        qcScanTab.packageIDInput(packId);
        qcScanTab.packageIDScan(packId);
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        homePageObject.clickPackages();
        System.out.println(name + " : " + id);
        packagesPageObjects.clickBinInScanTab();
        binInScanTab.performInScan(id, packId);
        message = homePageObject.getPopUpMessage();
        System.out.println(message);
    }

    @AfterClass(alwaysRun = true)
    public void qcScanAfterClass() throws Exception {
        System.out.println("QC Scan After Class is Called");
    }
}
