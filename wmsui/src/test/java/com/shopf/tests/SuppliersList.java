package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class SuppliersList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private SuppliersPageObjects suppliersPageObjects;
    private SuppliersPageObjects.SuppliersListTab suppliersListTab;
    private GetWMSApiResponse getWMSApiResponse;
    private List<SuppliersListModel> suppliersListModels;

    @BeforeClass(alwaysRun = true)
    public void suppliersListBeforeClass() throws Exception {
        System.out.println("Suppliers List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        suppliersPageObjects = new SuppliersPageObjects(driver);
        suppliersListTab = suppliersPageObjects.new SuppliersListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Parameters({"test"})
    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Suppliers List")
    public void verifySuppliersList(String test) {
        System.out.println("Verify Suppliers List is called");
        int i;
        homePageObject.clickSuppliers();
        suppliersPageObjects.clickSuppliersListTab();
        sleep(1000);
        suppliersListModels = getWMSApiResponse.getSuppliersDetails();
        System.out.println(suppliersListModels.size());
        for (i = 0; i < suppliersListModels.size(); i++) {

            if (i == 0 || i == (suppliersListModels.size() - 1) || test.equals("regression")) {
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
    }

    @AfterClass(alwaysRun = true)
    public void suppliersListAfterClass() {
        System.out.println("Suppliers List After Class is called");
    }
}
