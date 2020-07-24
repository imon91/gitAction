package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.io.*;
import java.util.*;


public class UpdateBinCapacity extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.UpdateBinCapacityTab updateBinCapacityTab;
    private Scanner s;
    private Random random;

    @BeforeClass(alwaysRun = true)
    public void updateBinCapacityBeforeClass() throws Exception {
        System.out.println("Update Bin Capacity Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        updateBinCapacityTab = warehousesPageObjects.new UpdateBinCapacityTab(driver);
        random = new Random();
    }

    @DataProvider(name = "warehouseBins")
    public Object[][] getWarehouseBinData() throws FileNotFoundException {
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/WarehouseBinsSD.txt";

        s = new Scanner(new File(filePath));
        List<String> list = new ArrayList<>();
        while(s.hasNextLine())
            list.add(s.nextLine());

        int n = random.nextInt(list.size());
        return new Object[][]{
                {"Warehouse Bin Code",list.get(n-1)}
        };
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            dataProvider = "warehouseBins",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Update Bin Capacity")
    public void verifyUpdateBinCapacity(String name, String id) {
        System.out.println("Verify Update Bin Capacity is called");
        System.out.println(name + " : " + id);
        int n = 10 + random.nextInt(10);
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickUpdateBinCapacityTab();
        sleep(1000);
        updateBinCapacityTab.updateBinCapacity(id, String.valueOf(n));
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
    }

    @AfterClass(alwaysRun = true)
    public void updateBinCapacityAfterClass() {
        System.out.println("Update Bin Capacity After Class is called");
    }
}
