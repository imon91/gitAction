package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PackagesPageObjects;
import pageObjects.SuppliersPageObjects;
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
    public void suppliersListBeforeClass()throws Exception{
        System.out.println("Suppliers List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        packagesPageObjects = new PackagesPageObjects(driver);
        packagesListTab = packagesPageObjects.new PackagesListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials")
    public void verifySuppliersList(){
        System.out.println("Verify Suppliers List is called");
        int i;
        sleep(1000);
        homePageObject.clickPackages();
        sleep(1000);
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
    public void suppliersListAfterClass(){
        System.out.println("Suppliers List After Class is called");
    }
}
