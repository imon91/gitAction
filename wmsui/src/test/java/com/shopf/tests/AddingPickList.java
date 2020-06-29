package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PickOrdersPageObjects;
import utils.WmsBaseClass;

public class AddingPickList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PickOrdersPageObjects pickOrdersPageObjects;
    private PickOrdersPageObjects.DemandLessPickListTab demandLessPickListTab;
    private PickOrdersPageObjects.AllPickListsTab allPickListsTab;

    @BeforeClass(alwaysRun = true)
    public void addingPickListBeforeClass() throws Exception{
        System.out.println("Adding Pick List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        demandLessPickListTab = new PickOrdersPageObjects(driver).new DemandLessPickListTab(driver);
        allPickListsTab = new PickOrdersPageObjects(driver).new AllPickListsTab(driver);
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"))
    public void verifyPickListAddition(){
        System.out.println("Pick List Addition Verification is called");
        homePageObject.clickPickOrders();
        sleep(1000);
        pickOrdersPageObjects.clickDemandLessPickListTab();
        sleep(1000);
        demandLessPickListTab.enterWarehouseDetails();
        demandLessPickListTab.createPickListOrder();
        pickOrdersPageObjects.clickAllPickListsTab();
        String pickListId = allPickListsTab.getPickListID(1);
        System.out.println("The last added Pick List: " + pickListId);
    }

    @AfterClass(alwaysRun = true)
    public void addingPickListAfterClass() throws Exception {
        System.out.println("Adding Pick List After Class is called");
    }
}
