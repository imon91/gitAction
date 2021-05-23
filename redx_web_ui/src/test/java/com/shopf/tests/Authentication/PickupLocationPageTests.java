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

public class PickupLocationPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PickupLocationPageObjects pickupLocationPageObjects;
    private PickupLocationPageObjects.AddNewPickupLocationPageObjects addNewPickupLocationPageObjects;
    private PickupLocationPageObjects.EditPickupLocationPageObjects editPickupLocationPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private ShopStoresInfoModel shopStoresInfoModel;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    private String shopName = "Pickup Location Sanity Test Shop";
    private String searchLocation = "Search Test Pickup Location";
    private String otp = "1234";
    private int shopId;
    private int index;

    @BeforeClass(alwaysRun = true)
    public void pickupLocationPageTestsBeforeClass() throws Exception
    {
        System.out.println("Pickup Location Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        pickupLocationPageObjects = new PickupLocationPageObjects(driver);
        addNewPickupLocationPageObjects = pickupLocationPageObjects.new AddNewPickupLocationPageObjects();
        editPickupLocationPageObjects = pickupLocationPageObjects.new EditPickupLocationPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        shopStoresInfoModel = new ShopStoresInfoModel();

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        actionBarObjects.clickOnPickupLocationDropDown();

        shopId = getRedxApiResponse.getShopId(shopName);
        shopStoresInfoModel = getRedxApiResponse.shopStoresInfoGetCall(shopId);

        index = pickupLocationPageObjects.getRandomLocation();
        System.out.println("API Index : " + (index-2));
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, PickupLocationPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "191")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Name Value",
            priority = 901 )
    public void verifyPickupNameValue()
    {
        System.out.println("Verifying Pickup Name Value");
        String uiValue = pickupLocationPageObjects.getPickupName(index);
        String apiValue = shopStoresInfoModel.getBody().get(index-2).getNAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "192")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Address Value",
            priority = 902 )
    public void verifyPickupAddressValue()
    {
        System.out.println("Verifying Pickup Address Value");
        String uiValue = pickupLocationPageObjects.getPickupAddress(index);
        String apiValue = shopStoresInfoModel.getBody().get(index-2).getADDRESS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "193")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Bar Functionality",
            priority = 903 )
    public void verifySearchBarFunctionality()
    {
        System.out.println("Verifying Search Bar Functionality");
        String location;
        pickupLocationPageObjects.enterSearchBar(searchLocation);
        location = pickupLocationPageObjects.getPickupName(2);
        System.out.println("Searched Location : " + location);
        Assert.assertEquals(location,searchLocation);
    }

    @TestRails(caseId = "194")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Location Icon Functionality",
            priority = 904 )
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

    @TestRails(caseId = "195")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Location Error Msg Value",
            priority = 905 )
    public void verifyAddNewLocationErrorMsgValues()
    {
        System.out.println("Verifying Add New Location Error Msg Value");
        String[] data = addNewPickupLocationPageObjects.getDataFromCsv("ANL02");
        addNewPickupLocationPageObjects.addNewLocation(data);
        List<String> errorMsg = addNewPickupLocationPageObjects.getAllErrorMessages();
        System.out.println(errorMsg.toString());
        addNewPickupLocationPageObjects.clickBackButton();
    }

    @TestRails(caseId = "196")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Add New Location Functionality",
            priority = 906 )
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

    @TestRails(caseId = "197")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Icon Functionality",
            priority = 907 )
    public void verifyEditShopIconFunctionality()
    {
        System.out.println("Verifying Edit Shop Icon Functionality");
        pickupLocationPageObjects.clickEditLocationIcon(index);
        String title = editPickupLocationPageObjects.getTitle();
        System.out.println("Title : " + title);
        editPickupLocationPageObjects.clickCloseIcon();
        Assert.assertEquals(title,"Edit pickup location");
    }

    @TestRails(caseId = "198")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Error Msg Values",
            priority = 908 )
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

    @TestRails(caseId = "199")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Confirm Button Functionality",
            priority = 910 )
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

    @TestRails(caseId = "200")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Otp Error Msg Value",
            priority = 911 )
    public void verifyEditShopOtpErrorMsgValue()
    {
        System.out.println("Verifying Edit Shop Otp Error Msg Value");
        editPickupLocationPageObjects.clickOtpInput();
        editPickupLocationPageObjects.clickShopPhone();
        String errorMsg = editPickupLocationPageObjects.getOtpErrorMsg();
        System.out.println("Otp Error Msg : " + errorMsg);
        Assert.assertEquals(errorMsg,"Otp is required");
    }

    @TestRails(caseId = "201")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Shop Functionality",
            priority = 912 )
    public void verifyEditShopFunctionality()
    {
        System.out.println("Verifying Edit Shop Functionality");
        editPickupLocationPageObjects.updateLocation(otp);
        String toastMsg = pickupLocationPageObjects.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);
        Assert.assertEquals(toastMsg,"Pickup updated successfully");
    }
}
