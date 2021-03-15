package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.ShopListModel;
import utils.RedXWebBaseClass;

import java.util.*;

public class MyShopsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private MyShopsPageObjects myShopsPageObjects;
    private MyShopsPageObjects.AddNewShopPageObjects addNewShopPageObjects;
    private MyShopsPageObjects.EditShopPageObjects editShopPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private ShopListModel shopListModel;
    private Random random;
    private String cookie;
    private int index;

    @BeforeSuite(alwaysRun = true)
    public void redXWebBeforeSuite() throws  Exception
    {
        System.out.println("RedX Web Before Suite");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void myShopsTestsBeforeClass() throws Exception
    {
        System.out.println("My Shops Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        myShopsPageObjects = new MyShopsPageObjects(driver);
        addNewShopPageObjects = myShopsPageObjects.new AddNewShopPageObjects();
        editShopPageObjects = myShopsPageObjects.new EditShopPageObjects();

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        shopListModel = new ShopListModel();

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

//        actionBarObjects.clickModalCloseButton();
        actionBarObjects.clickOnDropDownMyShopButton();

        shopListModel = getRedxApiResponse.shopListGetCall();
        index = myShopsPageObjects.getRandomShop();
    }

    @BeforeMethod(alwaysRun = true)
    public void myShopsPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Name Value",
            priority = 1 )
    public void verifyShopNameValue()
    {
        System.out.println("Verifying Shop Name Value");
        String uiValue = myShopsPageObjects.getShopName(index);
        String apiValue = shopListModel.getBody().getShops().get(index-2).getSHOP_NAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Pickup Location Value",
            priority = 2 )
    public void verifyShopPickupLocationValue()
    {
        System.out.println("Verifying Shop Pickup Location Value");
        String uiValue = myShopsPageObjects.getShopPickupLocation(index);
        String apiValue = shopListModel.getBody().getShops().get(index-2).getPICKUP_ADDRESS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Pickup Phone Value",
            priority = 3 )
    public void verifyShopPickupPhoneValue()
    {
        System.out.println("Verifying Shop Pickup Phone Value");
        String uiValue = myShopsPageObjects.getShopPickupPhone(index);
        String apiValue = shopListModel.getBody().getShops().get(index-2).getPICKUP_PHONE().toString();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Select Shop Functionality",
            priority = 4 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Shop Icon Functionality",
            priority = 5 )
    public void verifyAddNewShopIconFunctionality()
    {
        System.out.println("Verifying Add New Shop Icon Functionality");
        myShopsPageObjects.clickAddNewShopIcon();
        String title = addNewShopPageObjects.getTitle();
        System.out.println("Title : " + title);
        addNewShopPageObjects.clickCloseIcon();
        Assert.assertEquals(title,"Add New Shop");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Shop Error Msg Value",
            priority = 6 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Shop Functionality",
            priority = 7 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Icon Functionality",
            priority = 8 )
    public void verifyEditShopIconFunctionality()
    {
        System.out.println("Verifying Edit Shop Icon Functionality");
        myShopsPageObjects.clickOnEditShopIcon(index);
        String title = editShopPageObjects.getTitle();
        System.out.println("Title : " + title);
        editShopPageObjects.clickCloseIcon();
        Assert.assertEquals(title,"Edit Shop");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Error Msg Values",
            priority = 9 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Functionality",
            priority = 10 )
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

    @AfterClass(alwaysRun = true)
    public void myShopsPageTestsAfterClass()
    {
        System.out.println("My Shops Page Tests After Class");
    }

    @AfterSuite(alwaysRun = true)
    public void myShopsPageTestsAfterSuite()
    {
        System.out.println("My Shops Page Tests After Suite");
        driver.quit();
    }
}
