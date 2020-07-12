package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PackagesPageObjects;
import services.responseModels.wmsModels.PackagesListModel;
import services.wmsMethods.GetWMSApiResponse;
import utils.WmsBaseClass;

import java.util.List;

public class PackagesList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PackagesPageObjects packagesPageObjects;
    private PackagesPageObjects.PackagesListTab packagesListTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<PackagesListModel> packagesListModels;

    @BeforeClass(alwaysRun = true)
    public void packagesListBeforeClass()throws Exception{
        System.out.println("Packages List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        packagesPageObjects = new PackagesPageObjects(driver);
        packagesListTab = packagesPageObjects.new PackagesListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION,CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Packages List")
    public void verifyPackagesList(){
        System.out.println("Verify Packages List is called");
        int i;
        homePageObject.clickPackages();
        packagesPageObjects.clickPackagesListTab();
        sleep(1000);
        packagesListModels = getWMSApiResponse.getPackagesList();
        System.out.println(packagesListModels.size());
        for(i=0;i<packagesListModels.size();i++) {
            System.out.print(packagesListModels.get(i).getSku_code() + "-" +
                    packagesListTab.getSkuCode(i + 1).
                            equalsIgnoreCase(packagesListModels.get(i).getSku_code())+ "  ");

            System.out.print(packagesListModels.get(i).getNotes() + "-" +
                    packagesListTab.getDescription(i + 1).
                            equalsIgnoreCase(packagesListModels.get(i).getNotes())+ "  ");

            System.out.print(packagesListModels.get(i).getStatus() + "-" +
                    packagesListTab.getStatus(i + 1).
                            equalsIgnoreCase(packagesListModels.get(i).getStatus())+ "  ");

            System.out.println(packagesListModels.get(i).getQuantity() + "-" +
                    packagesListTab.getQuantity(i + 1).
                            equalsIgnoreCase(String.valueOf(packagesListModels.get(i).getQuantity())));
        }
    }

    @AfterClass(alwaysRun = true)
    public void packagesListAfterClass(){
        System.out.println("Packages List After Class is called");
    }
}
