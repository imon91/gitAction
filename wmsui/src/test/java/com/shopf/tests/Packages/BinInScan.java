package com.shopf.tests.Packages;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class BinInScan extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PackagesPageObjects packagesPageObjects;
    private PackagesPageObjects.BinInScanTab binInScanTab;
    private PackagesPageObjects.PackageDetailsTab packageDetailsTab;

    @BeforeClass(alwaysRun = true)
    public void binInScanBeforeClass() throws Exception {
        System.out.println("Bin In Scan Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        packagesPageObjects = new PackagesPageObjects(driver);
        binInScanTab = packagesPageObjects.new BinInScanTab(driver);
        packageDetailsTab = packagesPageObjects.new PackageDetailsTab(driver);
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Perform Bin In Scan")
    public void verifyBinInScan() {
        System.out.println("Verify Bin In Scan is called");
        homePageObject.clickPackages();
        packagesPageObjects.clickBinInScanTab();
        binInScanTab.performInScan("W100F2R1C1RA4B71", "135972");
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        packagesPageObjects.clickPackageDetailsTab();
        packageDetailsTab.enterPackageID("135972");
        System.out.println(packageDetailsTab.getCurrentStatus());
    }

    @AfterClass(alwaysRun = true)
    public void binInScanAfterClass() {
        System.out.println("Bin In Scan After Class is called");
    }
}
