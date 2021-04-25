package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class CreateParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private CreateParcelPageObjects createParcelPageObjects;
    private CreateParcelPageObjects.ShopInfoPageObjects shopInfoPageObjects;
    private CreateParcelPageObjects.ImportFromShopUpPageObjects importFromShopUpPageObjects;
    private CreateParcelPageObjects.DeliveryChargeDetailsPageObjects deliveryChargeDetailsPageObjects;
    private CreateParcelPageObjects.ParcelSuccessPageObjects parcelSuccessPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private String parentWindow;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void createParcelPageObjectsBeforeClass() throws Exception
    {
        System.out.println("Create Parcel Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        createParcelPageObjects = new CreateParcelPageObjects(driver);
        shopInfoPageObjects = createParcelPageObjects.new ShopInfoPageObjects();
        importFromShopUpPageObjects = createParcelPageObjects.new ImportFromShopUpPageObjects();
        deliveryChargeDetailsPageObjects = createParcelPageObjects.new DeliveryChargeDetailsPageObjects();
        parcelSuccessPageObjects = createParcelPageObjects. new ParcelSuccessPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        parentWindow = driver.getWindowHandle();

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickOnCreateParcelButton();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, CreateParcelPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "111")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Name Value",
            priority = 501 )
    public void verifyShopNameValue()
    {
        System.out.println("Verifying Shop Name Value");
        Assert.assertEquals(shopInfoPageObjects.getShopName(),actionBarObjects.getShopName());
    }

    @TestRails(caseId = "112")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Choose Different Shop Functionality",
            priority = 502 )
    public void verifyChooseDifferentShopFunctionality()
    {
        System.out.println("Verifying Choose Different Shop Button Functionality");
        shopInfoPageObjects.clickChooseShopButton();

        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);

        actionBarObjects.clickOnCreateParcelButton();
        setImplicitWait(10000);

        Assert.assertEquals(url,"https://redx.shopups1.xyz/shop-list/");
    }

    @TestRails(caseId = "113")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Location DropDown Functionality",
            priority = 503 )
    public void verifyPickupLocationDropDownFunctionality()
    {
        System.out.println("Verifying Pickup Location DropDown Functionality");

        String location = shopInfoPageObjects.choosePickupLocation();
        String addressUiValue = shopInfoPageObjects.getPickupAddressValue();
        String addressApiValue = getRedxApiResponse.getStoreAddress(shopInfoPageObjects.getShopName(),location);

        System.out.println("Pickup Address In UI : " + addressUiValue);
        System.out.println("Pickup Address In API : " + addressApiValue);

        Assert.assertEquals(addressUiValue,addressApiValue);
    }

    @TestRails(caseId = "114")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Create Bulk Parcel Button Functionality",
            priority = 504 )
    public void verifyCreateBulkParcelButtonFunctionality()
    {
        System.out.println("Verifying Create Bulk Parcel Button Functionality");

        createParcelPageObjects.clickCreateBulkParcelButton();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        actionBarObjects.clickOnCreateParcelButton();
        setImplicitWait(10000);

        Assert.assertEquals(url,"https://redx.shopups1.xyz/parcel-import-bulk/");
    }

    @TestRails(caseId = "115")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Import From ShopUp Button Functionality",
            priority = 505 )
    public void verifyImportFromShopUpButtonFunctionality()
    {
        System.out.println("Verifying Import From ShopUp Button Functionality");

        importFromShopUpPageObjects.clickImportFromShopUpButton();
        String title = importFromShopUpPageObjects.getModalTitle();
        importFromShopUpPageObjects.clickCloseIcon();

        System.out.println("Modal Title : " + title);

        Assert.assertEquals(title,"Select Order From ShopUp");
    }

    @TestRails(caseId = "116")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Cash Collection Value Before Create Parcel",
            priority = 506 )
    public void verifyCashCollectionValueBeforeCreateParcel()
    {
        System.out.println("Verifying Cash Collection Value Before Create Parcel");
        System.out.println("Cash Collection Value : " + deliveryChargeDetailsPageObjects.getCashCollectionValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getCashCollectionValue(),"0");
    }

    @TestRails(caseId = "117")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Delivery Charge Value Before Create Parcel",
            priority = 507 )
    public void verifyDeliveryChargeValueBeforeCreateParcel()
    {
        System.out.println("Verifying Delivery Charge Value Before Create Parcel");
        System.out.println("Delivery Charge Value : " + deliveryChargeDetailsPageObjects.getDeliveryChargeValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getDeliveryChargeValue(),"0");
    }

    @TestRails(caseId = "118")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Discount Amount Value Before Create Parcel",
            priority = 508 )
    public void verifyDiscountAmountValueBeforeCreateParcel()
    {
        System.out.println("Verifying Discount Amount Value Before Create Parcel");
        System.out.println("Discount Amount Value : " + deliveryChargeDetailsPageObjects.getDiscountAmountValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getDiscountAmountValue(),"0");
    }

    @TestRails(caseId = "119")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify COD Charge Value Before Create Parcel",
            priority = 509 )
    public void verifyCodChargeValueBeforeCreateParcel()
    {
        System.out.println("Verifying COD Charge Value Before Create Parcel");
        System.out.println("COD Charge Value : " + deliveryChargeDetailsPageObjects.getCodChargeValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getCodChargeValue(),"0.00");
    }

    @TestRails(caseId = "120")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Total Payment Value Before Create Parcel",
            priority = 510 )
    public void verifyTotalPaymentValueBeforeCreateParcel()
    {
        System.out.println("Verifying Total Payment Value Before Create Parcel");
        System.out.println("Total Payment Value : " + deliveryChargeDetailsPageObjects.getTotalPayableAmountValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getTotalPayableAmountValue(),"0");
    }

    @TestRails(caseId = "121")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Create Regular Parcel With No Inputs",
            priority = 511 )
    public void verifyCreateRegularParcelWithNoInputs()
    {
        System.out.println("Verifying Create Regular Parcel With No Inputs");
        setImplicitWait(10000);
        createParcelPageObjects.clickCreateParcelWithNoInputs("Regular");
    }

//    @TestRails(caseId = "122")
//    @Test(  groups = {CoreConstants.GROUP_SANITY},
//            description = "Verify Create Reverse Parcel With No Inputs",
//            priority = 512 )
    public void verifyCreateReverseParcelWithNoInputs()
    {
        System.out.println("Verifying Create Reverse Parcel With No Inputs");
        setImplicitWait(10000);
        createParcelPageObjects.clickCreateParcelWithNoInputs("Reverse");
    }

    @TestRails(caseId = "123")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Create Regular Parcel Functionality",
            priority = 513 )
    public void verifyCreateRegularParcelFunctionality()
    {
        System.out.println("Verifying Create Regular Parcel Functionality");

        String data[] = createParcelPageObjects.getDataFromCsv("RGWAI");
        System.out.println("Data From CSV : " + Arrays.toString(data));

        int shopId = getRedxApiResponse.getShopId(shopInfoPageObjects.getShopName());

        List<String> deliveryCharges = createParcelPageObjects.createRegularParcel(data);

        System.out.println("Delivery Charges in UI : " + deliveryCharges.toString());

        String areaValue = deliveryCharges.get(0);
        int areaId = getRedxApiResponse.getAreaId(data[6],data[7],areaValue);
        System.out.println("Delivery Charges in API : " + getRedxApiResponse.getDeliveryChargesInfo(shopId,areaId,Integer.parseInt(data[5]),Integer.parseInt(data[10])).toString());

        parcelSuccessPageObjects.clickOkButton();
        Assert.assertEquals(parcelSuccessPageObjects.getAlertMessage(),"Your parcel request has been placed successfully");
        Assert.assertEquals(parcelSuccessPageObjects.getCustomerAddress(),data[3]);
    }

//    @TestRails(caseId = "124")
//    @Test(  groups = {CoreConstants.GROUP_SANITY},
//            description = "Verify Create Reverse Parcel Functionality",
//            priority = 514 )
    public void verifyCreateReverseParcelFunctionality()
    {
        System.out.println("Verifying Create Reverse Parcel Functionality");
        String data[] = createParcelPageObjects.getDataFromCsv("RVWAI");
        System.out.println("Data From CSV : " + Arrays.toString(data));

        actionBarObjects.clickOnCreateParcelButton();
        setImplicitWait(10000);

        int shopId = getRedxApiResponse.getShopId(shopInfoPageObjects.getShopName());

        List<String> deliveryCharges = createParcelPageObjects.createReverseParcel(data);

        System.out.println("Delivery Charges in UI : " + deliveryCharges.toString());

        String areaValue = deliveryCharges.get(0);
        int areaId = getRedxApiResponse.getAreaId(data[5],data[6],areaValue);
        System.out.println("Delivery Charges in API : " + getRedxApiResponse.getDeliveryChargesInfo(shopId,areaId,Integer.parseInt(data[4]),0).toString());
        parcelSuccessPageObjects.clickOkButton();
        Assert.assertEquals(parcelSuccessPageObjects.getAlertMessage(),"Your parcel request has been placed successfully");
        Assert.assertEquals(parcelSuccessPageObjects.getCustomerAddress(),data[2]);
    }

    @TestRails(caseId = "125")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Track Orders Button Functionality",
            priority = 515 )
    public void verifyTrackOrdersButtonFunctionality()
    {
        System.out.println("Verifying Track Orders Button Functionality");
        parcelSuccessPageObjects.clickTrackOrdersButton();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        if(url.contains("track-parcel"))
            driver.navigate().back();
        parcelSuccessPageObjects.clickOkButton();
        Assert.assertTrue(url.contains("track-parcel"));
    }

    @TestRails(caseId = "126")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Print Labels Button Functionality",
            priority = 516 )
    public void verifyPrintLabelsButtonFunctionality()
    {
        System.out.println("Verify Print Labels Button Functionality");
        parcelSuccessPageObjects.clickPrintLabelButton();
        Set<String> handles = driver.getWindowHandles();
        int size = handles.size();
        System.out.println("Handles : " + size);
        for(String tab : handles)
        {
            if(!tab.equals(parentWindow))
            {
                driver.switchTo().window(parentWindow);
            }
        }
        Assert.assertEquals(size,2);
    }

    @TestRails(caseId = "127")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Request New Parcel Button Functionality",
            priority = 517 )
    public void verifyRequestNewParcelButtonFunctionality()
    {
        System.out.println("Verifying Request New Parcel Button Functionality");
        parcelSuccessPageObjects.clickRequestNewParcelButton();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        Assert.assertEquals(url,"https://redx.shopups1.xyz/create-parcel/");
    }
}






