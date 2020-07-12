package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PackagesPageObjects;
import pageObjects.WarehousesPageObjects;
import utils.WmsBaseClass;

public class PackageDetails extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PackagesPageObjects packagesPageObjects;
    private PackagesPageObjects.PackageDetailsTab packageDetailsTab;
    private WarehousesPageObjects warehousesPageObjects;
    private WarehousesPageObjects.WarehouseBinDetailsTab warehouseBinDetailsTab;

    @BeforeClass(alwaysRun = true)
    public void packageDetailsBeforeClass() throws Exception{
        System.out.println("Package Details Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        packagesPageObjects = new PackagesPageObjects(driver);
        packageDetailsTab = new PackagesPageObjects(driver).new PackageDetailsTab(driver);
        warehousesPageObjects = new WarehousesPageObjects(driver);
        warehouseBinDetailsTab = warehousesPageObjects.new WarehouseBinDetailsTab(driver);
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials")
    public void packageDetailsVerification(){
        System.out.println("Package Details Verification is called");
        String pId = "135979";
        homePageObject.clickPackages();
        packagesPageObjects.clickPackageDetailsTab();
        sleep(1000);
        packageDetailsTab.enterPackageID(pId);
        sleep(1000);
        String binCode = packageDetailsTab.getBinCode();
        String code = binCode.substring(binCode.indexOf(':')+2);
        homePageObject.clickWarehouses();
        warehousesPageObjects.clickBinDetailsTab();
        sleep(1000);
        warehouseBinDetailsTab.enterBinCodeBinDetails(code);
        sleep(1000);
        int i, total = warehouseBinDetailsTab.getTotalProducts();
        for (i = 1;i <=total ; i++) {
           String packages = warehouseBinDetailsTab.getPackageIds(i);
           if(packages.contains(pId))
               System.out.println("Found in Row: " + i);
           else continue;

        }
    }

    @AfterClass(alwaysRun = true)
    public void packageDetailsAfterClass() {
        System.out.println("Package Details After Class is called");
    }

}
