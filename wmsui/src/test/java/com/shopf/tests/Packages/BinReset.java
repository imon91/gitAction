package com.shopf.tests.Packages;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class BinReset extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PackagesPageObjects packagesPageObjects;
    private PackagesPageObjects.BinResetTab binResetTab;
    private PackagesPageObjects.PackageDetailsTab packageDetailsTab;

    @BeforeClass(alwaysRun = true)
    public void binResetBeforeClass() throws Exception {
        System.out.println("Bin Reset Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        packagesPageObjects = new PackagesPageObjects(driver);
        binResetTab = packagesPageObjects.new BinResetTab(driver);
        packageDetailsTab = packagesPageObjects.new PackageDetailsTab(driver);
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Bin Reset")
    public void verifyBinReset() {
        System.out.println("Verify Bin Reset is called");
        homePageObject.clickPackages();
        packagesPageObjects.clickBinResetTab();
        sleep(1000);
        binResetTab.resetBinPass("135972");
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        packagesPageObjects.clickPackageDetailsTab();
        packageDetailsTab.enterPackageID("135972");
        sleep(2000);
        System.out.println(packageDetailsTab.getCurrentStatus());
    }

    @AfterClass(alwaysRun = true)
    public void binResetAfterClass() {
        System.out.println("Bin Reset After Class is called");
    }
}
