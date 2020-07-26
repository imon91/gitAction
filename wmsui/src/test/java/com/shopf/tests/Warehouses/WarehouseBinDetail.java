package com.shopf.tests.Warehouses;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.io.*;
import java.util.*;

public class WarehouseBinDetail extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.WarehouseBinDetailsTab warehouseBinDetailsTab;
    private GetWMSApiResponse getWMSApiResponse;
    private WarehouseBinDetails warehouseBinDetails;
    private List<WarehouseBinDetails.PackageDetailsBean> packageDetails;
    private Assertion assertion;
    private String test;
    private Scanner s;
    private Random random;


    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void warehouseBinDetailBeforeClass(String test) throws Exception {
        System.out.println("Warehouse Bin Details Before Class is called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        warehouseBinDetailsTab = warehousesPageObjects.new WarehouseBinDetailsTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
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

        int n = random.nextInt(list.size());
        return new Object[][]{
                {"Warehouse Bin Code",list.get(n-1)}
        };
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dataProvider = "warehouseBins",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Warehouse Bin Details")
    public void verifyWarehouseBinDetail(String name, String id) {
        System.out.println("Verify Warehouse Bin Details is called");
        System.out.println(name + " : " + id);
        int i;
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickBinDetailsTab();
        sleep(1000);
        warehouseBinDetailsTab.binCodeEntry(id);
        warehouseBinDetails = getWMSApiResponse.getWarehouseBinDetails(id);
        packageDetails = warehouseBinDetails.getPackage_details();
        System.out.println(packageDetails.size());

        for (i = 0; i < packageDetails.size(); i++) {
            if (i == 0 || i == (packageDetails.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                System.out.println(packageDetails.get(i).getSku_code());
                assertion.assertTrue(packageDetails.get(i).getSku_code()
                                .equalsIgnoreCase(warehouseBinDetailsTab.getSkuCode(i + 1)),
                        "Sku_codes Do Not Match");

                System.out.println(packageDetails.get(i).getPackage_ids());
                assertion.assertTrue(packageDetails.get(i).getPackage_ids()
                                .equalsIgnoreCase(warehouseBinDetailsTab.getPackageIds(i + 1)),
                        "Package_ids Do Not Match");
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void warehouseBinDetailAfterClass() {
        System.out.println("Warehouse Bin Details After Class is called");
    }
}
