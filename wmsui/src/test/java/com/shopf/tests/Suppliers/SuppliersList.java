package com.shopf.tests.Suppliers;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
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
    private String test;
    private Assertion assertion;

    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void suppliersListBeforeClass(String test) throws Exception {
        System.out.println("Suppliers List Before Class is called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        suppliersPageObjects = new SuppliersPageObjects(driver);
        suppliersListTab = suppliersPageObjects.new SuppliersListTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Suppliers List")
    public void verifySuppliersList() {
        System.out.println("Verify Suppliers List is called");
        int i;
        homePageObject.clickSuppliers();
        suppliersPageObjects.clickSuppliersListTab();
        sleep(1000);
        suppliersListModels = getWMSApiResponse.getSuppliersDetails();
        System.out.println("List Size: " + suppliersListModels.size());

        for (i = 0; i < suppliersListModels.size(); i++) {
            if (i == 0 || i == (suppliersListModels.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                System.out.println(suppliersListModels.get(i).getName());
                assertion.assertTrue(suppliersListTab.getSupplierName(i + 1)
                                .equalsIgnoreCase(suppliersListModels.get(i).getName()),
                        "Supplier Names Do Not Match");

                System.out.println(suppliersListModels.get(i).getEmail());
                assertion.assertTrue(suppliersListTab.getSupplierEmail(i + 1)
                                .equalsIgnoreCase(suppliersListModels.get(i).getEmail()),
                        "Emails Do Not Match");

                System.out.println(suppliersListModels.get(i).getPhone());
                assertion.assertTrue(suppliersListTab.getSupplierPhoneNo(i + 1)
                                .equalsIgnoreCase(suppliersListModels.get(i).getPhone()),
                        "PhoneNos Do Not Match");
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void suppliersListAfterClass() {
        System.out.println("Suppliers List After Class is called");
    }
}
