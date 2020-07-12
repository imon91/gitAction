package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PackagesPageObjects;
import utils.WmsBaseClass;

public class BinReset extends WmsBaseClass {
        private WebDriver driver;
        private HomePageObject homePageObject;
        private PackagesPageObjects packagesPageObjects;
        private PackagesPageObjects.BinResetTab binResetTab;
        private PackagesPageObjects.PackageDetailsTab packageDetailsTab;

        @BeforeClass(alwaysRun = true)
        public void binResetBeforeClass()throws Exception{
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
        public void verifyBinReset(){
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
        public void binResetAfterClass(){
            System.out.println("Bin Reset After Class is called");
        }
    }
