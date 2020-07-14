package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
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

    @BeforeClass(alwaysRun = true)
    public void packagesListBeforeClass() throws Exception {
        System.out.println("Packages List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        packagesPageObjects = new PackagesPageObjects(driver);
        packagesListTab = packagesPageObjects.new PackagesListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Parameters({"test"})
    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Packages List")
    public void verifyPackagesList(String test) {
        System.out.println("Verify Packages List is called");
        int i;
        homePageObject.clickPackages();
        packagesPageObjects.clickPackagesListTab();
        sleep(1000);
        packagesListModels = getWMSApiResponse.getPackagesList();
        System.out.println(packagesListModels.size());
        for (i = 0; i < packagesListModels.size(); i++) {
            if (i == 0 || i == (packagesListModels.size() - 1) || test.equals("regression")) {
                System.out.println("----------------------------------");
                System.out.print(packagesListModels.get(i).getSku_code() + "-" +
                        packagesListTab.getSkuCode(i + 1).
                                equalsIgnoreCase(packagesListModels.get(i).getSku_code()) + "  ");

                System.out.print(packagesListModels.get(i).getNotes() + "-" +
                        packagesListTab.getDescription(i + 1).
                                equalsIgnoreCase(packagesListModels.get(i).getNotes()) + "  ");

                System.out.println(packagesListModels.get(i).getStatus() + "-" +
                        packagesListTab.getStatus(i + 1).
                                equalsIgnoreCase(packagesListModels.get(i).getStatus()) + "  ");

                System.out.println(packagesListModels.get(i).getQuantity() + "-" +
                        packagesListTab.getQuantity(i + 1).
                                equalsIgnoreCase(String.valueOf(packagesListModels.get(i).getQuantity())));
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void packagesListAfterClass() {
        System.out.println("Packages List After Class is called");
    }
}
