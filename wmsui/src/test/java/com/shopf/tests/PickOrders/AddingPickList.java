package com.shopf.tests.PickOrders;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import pageObjects.*;
import services.responseModels.wmsModels.VariantDetailsModel;
import utils.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class AddingPickList extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PickOrdersPageObjects pickOrdersPageObjects;
    private PickOrdersPageObjects.DemandLessPickListTab demandLessPickListTab;
    private PickOrdersPageObjects.AllPickListsTab allPickListsTab;
    private Assertion assertion;
    private List<VariantDetailsModel> list;
    private Random random;
    private Gson gson;
    private BufferedReader bufferedReader;

    @BeforeClass(alwaysRun = true)
    public void addingPickListBeforeClass() throws Exception {
        System.out.println("Adding Pick List Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        demandLessPickListTab = new PickOrdersPageObjects(driver).new DemandLessPickListTab(driver);
        allPickListsTab = new PickOrdersPageObjects(driver).new AllPickListsTab(driver);
        assertion = new Assertion();
        random = new Random();
    }

    @DataProvider(name = "skuCodeData")
    public Object[][] getSkuCodeData() throws FileNotFoundException {
        gson = new Gson();
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/sellerSkuCodes.json";

        bufferedReader = new BufferedReader(new FileReader(filePath));
        list = gson.fromJson(bufferedReader,
                new TypeToken<List<VariantDetailsModel>>(){}.getType());

        int n = random.nextInt(list.size()) + 1;
        return new Object[][]{
                {"Id",list.get(n-1).getSku_code()}
        };
    }

    @Test(groups = (CoreConstants.GROUP_SMOKE),
            dataProvider = "skuCodeData",
            dependsOnGroups = ("Login.verifyAuthenticationWithValidCredentials"),
            description = "Adds Pick List")
    public void verifyPickListAddition(String name, String id) {
        System.out.println("Pick List Addition Verification is called");
        System.out.println(name + " : " + id);
        homePageObject.clickPickOrders();
        pickOrdersPageObjects.clickDemandLessPickListTab();
        demandLessPickListTab.enterWarehouseDetails();
        demandLessPickListTab.createPickListOrder(id);
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
        assertion.assertEquals(message,"PickList Created");
        pickOrdersPageObjects.clickAllPickListsTab();
        String pickListId = allPickListsTab.getPickListID(1);
        System.out.println("The last added Pick List: " + pickListId);
    }

    @AfterClass(alwaysRun = true)
    public void addingPickListAfterClass() {
        System.out.println("Adding Pick List After Class is called");
    }
}
