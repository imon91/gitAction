package com.shopf.tests.Suppliers;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import utils.*;

public class AddSupplier extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private SuppliersPageObjects suppliersPageObjects;
    private SuppliersPageObjects.AddSupplierTab addSupplierTab;
    private SuppliersPageObjects.SuppliersListTab suppliersListTab;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void addingSupplierBeforeClass() throws Exception {
        System.out.println("Adding Supplier Before Class is Called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        suppliersPageObjects = new SuppliersPageObjects(driver);
        addSupplierTab = suppliersPageObjects.new AddSupplierTab(driver);
        suppliersListTab = suppliersPageObjects.new SuppliersListTab(driver);
        assertion = new Assertion();
    }

    @Test(groups = (CoreConstants.GROUP_SANITY),
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"),
            description = "Adds Supplier")
    public void verifySupplierAddition() {
        System.out.println("Supplier Addition Verification is called");
        homePageObject.clickSuppliers();
        suppliersPageObjects.clickAddSupplierTab();
        addSupplierTab.addNewSupplier();
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        assertion.assertEquals(message,"Supplier Added");
    }

    @AfterClass(alwaysRun = true)
    public void addingSupplierAfterClass() {
        System.out.println("Adding Supplier After Class is Called");
    }
}