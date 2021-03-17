package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.ShopInfoModel;
import utils.RedXWebBaseClass;

import java.util.*;

public class PickupLocationPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private PickupLocationPageObjects pickupLocationPageObjects;
    private PickupLocationPageObjects.AddNewPickupLocationPageObjects addNewPickupLocationPageObjects;
    private PickupLocationPageObjects.EditPickupLocationPageObjects editPickupLocationPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private ShopInfoModel shopInfoModel;
    private Random random;
    private String cookie;

    private String shopName = "Pickup Location Sanity Test Shop";
    private String searchLocation = "Search Test Pickup Location";
    private String otp = "1234";
    private int shopId;
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
    public void pickupLocationPageTestsBeforeClass() throws Exception
    {
        System.out.println("Pickup Location Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        pickupLocationPageObjects = new PickupLocationPageObjects(driver);
        addNewPickupLocationPageObjects = pickupLocationPageObjects.new AddNewPickupLocationPageObjects();
        editPickupLocationPageObjects = pickupLocationPageObjects.new EditPickupLocationPageObjects();

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        shopInfoModel = new ShopInfoModel();

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        actionBarObjects.clickOnPickupLocationDropDown();

        shopId = getRedxApiResponse.getShopId(shopName);
        shopInfoModel = getRedxApiResponse.shopInfoGetCall(shopId);

        index = pickupLocationPageObjects.getRandomLocation();
        System.out.println("API Index : " + (index-2));
    }

    @BeforeMethod(alwaysRun = true)
    public void pickupLocationPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Name Value",
            priority = 1 )
    public void verifyPickupNameValue()
    {
        System.out.println("Verifying Pickup Name Value");
        String uiValue = pickupLocationPageObjects.getPickupName(index);
        String apiValue = shopInfoModel.getBody().get(index-2).getNAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Address Value",
            priority = 2 )
    public void verifyPickupAddressValue()
    {
        System.out.println("Verifying Pickup Address Value");
        String uiValue = pickupLocationPageObjects.getPickupAddress(index);
        String apiValue = shopInfoModel.getBody().get(index-2).getADDRESS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Bar Functionality",
            priority = 3 )
    public void verifySearchBarFunctionality()
    {
        System.out.println("Verifying Search Bar Functionality");
        String location;
        pickupLocationPageObjects.enterSearchBar(searchLocation);
        location = pickupLocationPageObjects.getPickupName(2);
        System.out.println("Searched Location : " + location);
        Assert.assertEquals(location,searchLocation);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Location Icon Functionality",
            priority = 4 )
    public void verifyAddNewLocationIconFunctionality()
    {
        System.out.println("Verifying Add New Location Icon Functionality");
        driver.navigate().refresh();
        setImplicitWait(10000);
        pickupLocationPageObjects.clickAddNewLocationIcon();
        String title = addNewPickupLocationPageObjects.getTitle();
        System.out.println("Title : " + title);
        addNewPickupLocationPageObjects.clickCloseIcon();
        Assert.assertEquals(title,"Add new pickup location");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Location Error Msg Value",
            priority = 5 )
    public void verifyAddNewLocationErrorMsgValues()
    {
        System.out.println("Verifying Add New Location Error Msg Value");
        String[] data = addNewPickupLocationPageObjects.getDataFromCsv("ANL02");
        addNewPickupLocationPageObjects.addNewLocation(data);
        List<String> errorMsg = addNewPickupLocationPageObjects.getAllErrorMessages();
        System.out.println(errorMsg.toString());
        addNewPickupLocationPageObjects.clickBackButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Location Functionality",
            priority = 6 )
    public void verifyAddNewLocationFunctionality()
    {
        System.out.println("Verifying Add New Location Functionality");
        String[] data = addNewPickupLocationPageObjects.getDataFromCsv("ANL01");
        addNewPickupLocationPageObjects.addNewLocation(data);
        addNewPickupLocationPageObjects.clickConfirmButton();
        String toastMsg = pickupLocationPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Pickup updated successfully");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Icon Functionality",
            priority = 7 )
    public void verifyEditShopIconFunctionality()
    {
        System.out.println("Verifying Edit Shop Icon Functionality");
        pickupLocationPageObjects.clickEditLocationIcon(index);
        String title = editPickupLocationPageObjects.getTitle();
        System.out.println("Title : " + title);
        editPickupLocationPageObjects.clickCloseIcon();
        Assert.assertEquals(title,"Edit pickup location");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Error Msg Values",
            priority = 8 )
    public void verifyEditShopErrorMsgValues()
    {
        System.out.println("Verifying Edit Shop Error Msg Values");
        pickupLocationPageObjects.clickEditLocationIcon(index);
        String[] data = editPickupLocationPageObjects.getDataFromCsv("EL02");
        editPickupLocationPageObjects.editLocation(data);
        List<String> errorMsg = editPickupLocationPageObjects.getAllErrorMessages();
        System.out.println("Error Messages : " + errorMsg.toString());
        editPickupLocationPageObjects.clickCloseIcon();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Confirm Button Functionality",
            priority = 10 )
    public void verifyEditShopConfirmButtonFunctionality()
    {
        System.out.println("Verifying Edit Shop Confirm Button Functionality");
        pickupLocationPageObjects.clickEditLocationIcon(index);
        String[] data = editPickupLocationPageObjects.getDataFromCsv("EL01");
        editPickupLocationPageObjects.editLocation(data);
        editPickupLocationPageObjects.clickConfirmButton();
        String title = editPickupLocationPageObjects.getTitle();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Update pickup location");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Otp Error Msg Value",
            priority = 11 )
    public void verifyEditShopOtpErrorMsgValue()
    {
        System.out.println("Verifying Edit Shop Otp Error Msg Value");
        editPickupLocationPageObjects.clickOtpInput();
        editPickupLocationPageObjects.clickShopPhone();
        String errorMsg = editPickupLocationPageObjects.getOtpErrorMsg();
        System.out.println("Otp Error Msg : " + errorMsg);
        Assert.assertEquals(errorMsg,"Otp is required");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Functionality",
            priority = 12 )
    public void verifyEditShopFunctionality()
    {
        System.out.println("Verifying Edit Shop Functionality");
        editPickupLocationPageObjects.updateLocation(otp);
        String toastMsg = pickupLocationPageObjects.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);
        Assert.assertEquals(toastMsg,"Pickup updated successfully");
    }

    @AfterClass(alwaysRun = true)
    public void myShopsPageTestsAfterClass()
    {
        System.out.println("Pickup Location Page Tests After Class");
    }

    @AfterSuite(alwaysRun = true)
    public void redXWebPageTestsAfterSuite()
    {
        System.out.println("RedX Web After Suite");
        driver.quit();
    }
}
