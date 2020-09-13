package com.shopf.tests.Suppliers;

import com.google.gson.*;
import coreUtils.*;
import dataParcer.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import utils.*;

public class AddSupplierRegression extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private SuppliersPageObjects suppliersPageObjects;
    private SuppliersPageObjects.AddSupplierTab addSupplierTab;
    private SuppliersPageObjects.SuppliersListTab suppliersListTab;
    private Assertion assertion;

    @DataProvider(name = "CSVData")
    public Object[][] getCSVData() {
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/AddSupplier.csv";
        return CSVParser.getDataForDataProvider(filePath, AddSuppliersModel.class);

    }

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

    @Test(groups = (CoreConstants.GROUP_REGRESSION),
            dataProvider = "CSVData",
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"),
            description = "Adds Supplier")
    public void verifySupplierAddition(Object body) {
        System.out.println("Supplier Addition Verification is called");
        homePageObject.clickSuppliers();
        suppliersPageObjects.clickAddSupplierTab();
        Gson gson = new Gson();
        AddSuppliersModel addSuppliersModel = gson.fromJson(body.toString(),AddSuppliersModel.class);
        System.out.println(addSuppliersModel.getTestCaseId()+" - "+addSuppliersModel.getTestCase());
        String[] allInputData = addSupplierTab.getAllInputData(addSuppliersModel.getAll());
        addSupplierTab.addNewSupplier(allInputData);

        if(addSuppliersModel.getToastMessage().equals("N/A")) {
                assertion.assertTrue(addSupplierTab.testCaseAssert(addSuppliersModel.getTestCaseId()));
        }

        else if(addSuppliersModel.getToastMessage().equals("Supplier creation failed"))
            assertion.assertTrue(homePageObject.getPopUpMessage().equals(addSuppliersModel.getToastMessage()));

        else if(addSuppliersModel.getToastMessage().equals("Supplier Added"))
            assertion.assertTrue(homePageObject.getPopUpMessage().equals(addSuppliersModel.getToastMessage()));

        else  System.out.println(addSuppliersModel.getToastMessage());

        driver.navigate().refresh();

    }

    @AfterClass(alwaysRun = true)
    public void addingSupplierAfterClass() {
        System.out.println("Adding Supplier After Class is Called");
    }
}
