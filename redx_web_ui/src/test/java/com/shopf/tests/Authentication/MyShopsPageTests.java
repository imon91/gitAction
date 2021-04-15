package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.*;
import services.responseModels.redxModels.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class MyShopsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private MyShopsPageObjects myShopsPageObjects;
    private MyShopsPageObjects.AddNewShopPageObjects addNewShopPageObjects;
    private MyShopsPageObjects.EditShopPageObjects editShopPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private ShopListModel shopListModel;
    private int index;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void myShopsTestsBeforeClass() throws Exception
    {
        System.out.println("My Shops Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        myShopsPageObjects = new MyShopsPageObjects(driver);
        addNewShopPageObjects = myShopsPageObjects.new AddNewShopPageObjects();
        editShopPageObjects = myShopsPageObjects.new EditShopPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        shopListModel = new ShopListModel();

        actionBarObjects.clickOnDropDownMyShopButton();

        shopListModel = getRedxApiResponse.shopListGetCall();
        index = myShopsPageObjects.getRandomShop();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, MyShopsPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "181")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Name Value",
            priority = 801 )
    public void verifyShopNameValue()
    {
        System.out.println("Verifying Shop Name Value");
        String uiValue = myShopsPageObjects.getShopName(index);
        String apiValue = shopListModel.getBody().getShops().get(index-2).getSHOP_NAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "182")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Pickup Location Value",
            priority = 802 )
    public void verifyShopPickupLocationValue()
    {
        System.out.println("Verifying Shop Pickup Location Value");
        String uiValue = myShopsPageObjects.getShopPickupLocation(index);
        String apiValue = shopListModel.getBody().getShops().get(index-2).getPICKUP_ADDRESS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "183")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Pickup Phone Value",
            priority = 803 )
    public void verifyShopPickupPhoneValue()
    {
        System.out.println("Verifying Shop Pickup Phone Value");
        String uiValue = myShopsPageObjects.getShopPickupPhone(index);
        String apiValue = shopListModel.getBody().getShops().get(index-2).getPICKUP_PHONE().toString();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "184")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Select Shop Functionality",
            priority = 804 )
    public void verifySelectShopFunctionality()
    {
        System.out.println("Verify Select Shop Functionality");
        myShopsPageObjects.clickShopByName("My Shops Sanity Test");
//        actionBarObjects.clickModalCloseButton();
        actionBarObjects.clickOnDropDownMyShopButton();
        Boolean isSelected = myShopsPageObjects.isShopSelected(80);
        System.out.println("Selected : " + isSelected);
        Assert.assertTrue(isSelected);
    }

    @TestRails(caseId = "185")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Shop Icon Functionality",
            priority = 805 )
    public void verifyAddNewShopIconFunctionality()
    {
        System.out.println("Verifying Add New Shop Icon Functionality");
        myShopsPageObjects.clickAddNewShopIcon();
        String title = addNewShopPageObjects.getTitle();
        System.out.println("Title : " + title);
        addNewShopPageObjects.clickCloseIcon();
        Assert.assertEquals(title,"Add New Shop");
    }

    @TestRails(caseId = "186")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Shop Error Msg Value",
            priority = 806 )
    public void verifyAddNewShopErrorMsgValues()
    {
        System.out.println("Verifying Add New Shop Error Msg Value");
        myShopsPageObjects.clickAddNewShopIcon();
        String[] data = addNewShopPageObjects.getDataFromCsv("ANS02");
        addNewShopPageObjects.addNewShop(data);
        List<String> errorMsg = addNewShopPageObjects.getAllErrorMessages();
        System.out.println(errorMsg.toString());
        addNewShopPageObjects.clickCloseIcon();
    }

    @TestRails(caseId = "187")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Shop Functionality",
            priority = 807 )
    public void verifyAddNewShopFunctionality()
    {
        System.out.println("Verifying Add New Shop Functionality");
        myShopsPageObjects.clickAddNewShopIcon();
        String[] data = addNewShopPageObjects.getDataFromCsv("ANS01");
        addNewShopPageObjects.addNewShop(data);
        addNewShopPageObjects.clickAddShopButton();
        String toastMsg = myShopsPageObjects.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);
        Assert.assertEquals(toastMsg,"Shop Created");
    }

    @TestRails(caseId = "188")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Icon Functionality",
            priority = 808 )
    public void verifyEditShopIconFunctionality()
    {
        System.out.println("Verifying Edit Shop Icon Functionality");
        myShopsPageObjects.clickOnEditShopIcon(index);
        String title = editShopPageObjects.getTitle();
        System.out.println("Title : " + title);
        editShopPageObjects.clickCloseIcon();
        Assert.assertEquals(title,"Edit Shop");
    }

    @TestRails(caseId = "189")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Error Msg Values",
            priority = 809 )
    public void verifyEditShopErrorMsgValues()
    {
        System.out.println("Verifying Edit Shop Error Msg Values");
        myShopsPageObjects.clickOnEditShopIcon(index);
        String[] data = editShopPageObjects.getDataFromCsv("ES02");
        editShopPageObjects.editShop(data);
        List<String> errorMsg = editShopPageObjects.getAllErrorMessages();
        System.out.println(errorMsg.toString());
        editShopPageObjects.clickCloseIcon();
    }

    @TestRails(caseId = "190")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Functionality",
            priority = 810 )
    public void verifyEditShopFunctionality()
    {
        System.out.println("Verifying Edit Shop Functionality");
        myShopsPageObjects.clickRandomEditShopButton();
        String[] data = editShopPageObjects.getDataFromCsv("ES01");
        editShopPageObjects.editShop(data);
        editShopPageObjects.clickEditShopButton();
        String toastMsg = myShopsPageObjects.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);
        Assert.assertEquals(toastMsg,"Shop updated successfully");
    }
}
