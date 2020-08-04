package com.shopf.tests.Packages;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class PackagesList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PackagesPageObjects packagesPageObjects;
    private PackagesPageObjects.PackagesListTab packagesListTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<PackagesListModel> packagesListModels;
    private Assertion assertion;
    private String test;


    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void packagesListBeforeClass(String test) throws Exception {
        System.out.println("Packages List Before Class is called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        packagesPageObjects = new PackagesPageObjects(driver);
        packagesListTab = packagesPageObjects.new PackagesListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }


    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Packages List")
    public void verifyPackagesList() {
        System.out.println("Verify Packages List is called");
        int i;
        homePageObject.clickPackages();
        packagesPageObjects.clickPackagesListTab();
        packagesListModels = getWMSApiResponse.getPackagesList();
        System.out.println(packagesListModels.size());
        for (i = 0; i < packagesListModels.size(); i++) {
            if (i == 0 || i == (packagesListModels.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                System.out.println(packagesListModels.get(i).getSku_code());
                assertion.assertTrue(packagesListTab.getSkuCode(i + 1).
                                equalsIgnoreCase(packagesListModels.get(i).getSku_code()),
                        "Sku_code Do Not Match");

                System.out.println(packagesListModels.get(i).getNotes());
                assertion.assertTrue(packagesListTab.getDescription(i + 1).
                                equalsIgnoreCase(packagesListModels.get(i).getNotes()),
                        "Notes Do Not Match");

                System.out.println(packagesListModels.get(i).getStatus());
                assertion.assertTrue(packagesListTab.getStatus(i + 1).
                                equalsIgnoreCase(packagesListModels.get(i).getStatus()),
                        "Status Do Not Match");

                System.out.println(packagesListModels.get(i).getQuantity());
                assertion.assertEquals(packagesListTab.getQuantity(i + 1),
                                (String.valueOf(packagesListModels.get(i).getQuantity())),
                        "Quantities Do Not Match");
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void packagesListAfterClass() {
        System.out.println("Packages List After Class is called");
    }
}
