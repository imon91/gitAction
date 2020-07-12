package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.SuppliersPageObjects;
import pageObjects.WarehousesPageObjects;
import services.responseModels.wmsModels.SuppliersListModel;
import services.wmsMethods.GetWMSApiResponse;
import utils.WmsBaseClass;

import java.util.List;

public class SuppliersList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private SuppliersPageObjects suppliersPageObjects;
    private SuppliersPageObjects.SuppliersListTab suppliersListTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<SuppliersListModel> suppliersListModels;

    @BeforeClass(alwaysRun = true)
    public void suppliersListBeforeClass()throws Exception{
        System.out.println("Suppliers List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        suppliersPageObjects = new SuppliersPageObjects(driver);
        suppliersListTab = suppliersPageObjects.new SuppliersListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION,CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Suppliers List")
    public void verifySuppliersList(){
        System.out.println("Verify Suppliers List is called");
        int i;
        homePageObject.clickSuppliers();
        suppliersPageObjects.clickSuppliersListTab();
        sleep(1000);
        suppliersListModels = getWMSApiResponse.getSuppliersDetails();
        System.out.println(suppliersListModels.size());
        for(i=0;i<suppliersListModels.size();i++) {

            System.out.print(suppliersListModels.get(i).getName() + "-" +
                    suppliersListTab.getSupplierName(i + 1)
                            .equalsIgnoreCase(suppliersListModels.get(i).getName()) + " ");

            System.out.print(suppliersListModels.get(i).getEmail() + "-" +
                    suppliersListTab.getSupplierEmail(i + 1)
                            .equalsIgnoreCase(suppliersListModels.get(i).getEmail()) + " ");

            System.out.println(suppliersListModels.get(i).getPhone() + "-" +
                    suppliersListTab.getSupplierPhoneNo(i + 1)
                            .equalsIgnoreCase(suppliersListModels.get(i).getPhone()));


        }
    }

    @AfterClass(alwaysRun = true)
    public void suppliersListAfterClass(){
        System.out.println("Suppliers List After Class is called");
    }
}
