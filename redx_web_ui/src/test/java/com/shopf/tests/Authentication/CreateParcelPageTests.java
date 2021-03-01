package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import utils.RedXWebBaseClass;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CreateParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private CreateParcelPageObjects createParcelPageObjects;
    private CreateParcelPageObjects.ShopInfoPageObjects shopInfoPageObjects;
    private CreateParcelPageObjects.ImportFromShopUpPageObjects importFromShopUpPageObjects;
    private CreateParcelPageObjects.DeliveryChargeDetailsPageObjects deliveryChargeDetailsPageObjects;
    private CreateParcelPageObjects.ParcelSuccessPageObjects parcelSuccessPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private Random random;
    private String parentWindow;
    private String cookie;

    @BeforeSuite(alwaysRun = true)
    public void redXWebBeforeSuite() throws  Exception
    {
        System.out.println("RedX Web Before Suite");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
        driver.manage().window().maximize();
        parentWindow = driver.getWindowHandle();
    }

    @BeforeClass(alwaysRun = true)
    public void parcelPageObjectsBeforeClass() throws Exception
    {
        System.out.println("Parcel Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        createParcelPageObjects = new CreateParcelPageObjects(driver);
        shopInfoPageObjects = createParcelPageObjects.new ShopInfoPageObjects();
        importFromShopUpPageObjects = createParcelPageObjects.new ImportFromShopUpPageObjects();
        deliveryChargeDetailsPageObjects = createParcelPageObjects.new DeliveryChargeDetailsPageObjects();
        parcelSuccessPageObjects = createParcelPageObjects. new ParcelSuccessPageObjects();

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickOnCreateParcelButton();
    }

    @BeforeMethod(alwaysRun = true)
    public void homePageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Name Value",
            priority = 1 )
    public void verifyShopNameValue()
    {
        System.out.println("Verifying Shop Name Value");
        Assert.assertEquals(shopInfoPageObjects.getShopName(),actionBarObjects.getShopName());
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Choose Different Shop Functionality",
            priority = 2 )
    public void verifyChooseDifferentShopFunctionality()
    {
        System.out.println("Verifying Choose Different Shop Button Functionality");
        shopInfoPageObjects.clickChooseShopButton();

        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);

        driver.get("https://redx.shopups1.xyz/create-parcel/");
        setImplicitWait(10000);

        Assert.assertEquals(url,"https://redx.shopups1.xyz/shop-list/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Location DropDown Functionality",
            priority = 3 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Create Bulk Parcel Button Functionality",
            priority = 4 )
    public void verifyCreateBulkParcelButtonFunctionality()
    {
        System.out.println("Verifying Create Bulk Parcel Button Functionality");

        createParcelPageObjects.clickCreateBulkParcelButton();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        driver.get("https://redx.shopups1.xyz/create-parcel/");
        setImplicitWait(10000);

        Assert.assertEquals(url,"https://redx.shopups1.xyz/parcel-import-bulk/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Import From ShopUp Button Functionality",
            priority = 5 )
    public void verifyImportFromShopUpButtonFunctionality()
    {
        System.out.println("Verifying Import From ShopUp Button Functionality");

        importFromShopUpPageObjects.clickImportFromShopUpButton();
        String title = importFromShopUpPageObjects.getModalTitle();
        importFromShopUpPageObjects.clickCloseIcon();

        System.out.println("Modal Title : " + title);

        Assert.assertEquals(title,"Select Order From ShopUp");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Cash Collection Value Before Create Parcel",
            priority = 6 )
    public void verifyCashCollectionValueBeforeCreateParcel()
    {
        System.out.println("Verifying Cash Collection Value Before Create Parcel");
        System.out.println("Cash Collection Value : " + deliveryChargeDetailsPageObjects.getCashCollectionValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getCashCollectionValue(),"0");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Delivery Charge Value Before Create Parcel",
            priority = 7 )
    public void verifyDeliveryChargeValueBeforeCreateParcel()
    {
        System.out.println("Verifying Delivery Charge Value Before Create Parcel");
        System.out.println("Delivery Charge Value : " + deliveryChargeDetailsPageObjects.getDeliveryChargeValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getDeliveryChargeValue(),"0");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify COD Charge Value Before Create Parcel",
            priority = 8 )
    public void verifyCodChargeValueBeforeCreateParcel()
    {
        System.out.println("Verifying COD Charge Value Before Create Parcel");
        System.out.println("COD Charge Value : " + deliveryChargeDetailsPageObjects.getCodChargeValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getCodChargeValue(),"0.00");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Total Payment Value Before Create Parcel",
            priority = 9 )
    public void verifyTotalPaymentValueBeforeCreateParcel()
    {
        System.out.println("Verifying Total Payment Value Before Create Parcel");
        System.out.println("Total Payment Value : " + deliveryChargeDetailsPageObjects.getTotalPayableAmountValue());
        Assert.assertEquals(deliveryChargeDetailsPageObjects.getTotalPayableAmountValue(),"0");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Create Regular Parcel With No Inputs",
            priority = 10 )
    public void verifyCreateRegularParcelWithNoInputs()
    {
        System.out.println("Verifying Create Regular Parcel With No Inputs");
        driver.get("https://redx.shopups1.xyz/create-parcel/");
        setImplicitWait(10000);
        createParcelPageObjects.clickCreateParcelWithNoInputs("Regular");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Create Reverse Parcel With No Inputs",
            priority = 11 )
    public void verifyCreateReverseParcelWithNoInputs()
    {
        System.out.println("Verifying Create Reverse Parcel With No Inputs");
        driver.get("https://redx.shopups1.xyz/create-parcel/");
        setImplicitWait(10000);
        createParcelPageObjects.clickCreateParcelWithNoInputs("Reverse");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Create Regular Parcel Functionality",
            priority = 12 )
    public void verifyCreateRegularParcelFunctionality()
    {
        System.out.println("Verifying Create Regular Parcel Functionality");
        driver.get("https://redx.shopups1.xyz/create-parcel/");
        setImplicitWait(10000);
        createParcelPageObjects.getDataFromCsv("RGWAI");

        int shopId = getRedxApiResponse.getShopId(shopInfoPageObjects.getShopName());

        String pickupLocation = "random";
        String name = "random";
        String phone = "01401122188";
        String address = "Area, District,Division, Code";
        String invoice = String.valueOf(random.nextInt(999999));
        String parcelWeight = String.valueOf(random.nextInt(1000)+1);
        String division = "Dhaka";
        String district = "Dhaka";
        String area = "random";
        String parcelType = createParcelPageObjects.getRandomValue("Parcel Type");
        String cash = String.valueOf(random.nextInt(3000));
        String sellingPrice = String.valueOf(random.nextInt(5000));
        String instruction = "instructions";

        List<String> deliveryCharges = createParcelPageObjects.createRegularParcel(pickupLocation,name,phone,address,invoice,parcelWeight,division,district,area,parcelType,cash,sellingPrice,"yes",instruction);
        System.out.println("Delivery Charges in UI : " + deliveryCharges.toString());

        String areaValue = deliveryCharges.get(0);
        int areaId = getRedxApiResponse.getAreaId(division,district,areaValue);
        System.out.println("Delivery Charges in API : " + getRedxApiResponse.deliveryChargeGetCall(shopId,areaId,Integer.parseInt(parcelWeight),Integer.parseInt(cash)).getBody().getPricing().toString());

//        xpathSetter("//span[text()='BKash']/..").click();
//        xpathSetter("//button[@type='submit']").click();
//        xpathSetter("//input[@placeholder='Enter OTP']").sendKeys("1234");
//        xpathSetter("//span[text()='Authenticate']/..").click();
//        parcelSuccessPageObjects.clickOkButton();
//        Assert.assertEquals(parcelSuccessPageObjects.getAlertMessage(),"Your parcel request has been placed successfully");
//        Assert.assertEquals(parcelSuccessPageObjects.getCustomerAddress(),address);

    }
/*
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Track Orders Button Functionality",
            priority = 13 )
    public void verifyTrackOrdersButtonFunctionality()
    {
        System.out.println("Verifying Track Orders Button Functionality");
        parcelSuccessPageObjects.clickTrackOrdersButton();
        String url = driver.getCurrentUrl();
        driver.navigate().back();
        parcelSuccessPageObjects.clickOkButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Print Labels Button Functionality",
            priority = 14 )
    public void verifyPrintLabelsButtonFunctionality()
    {
        System.out.println("Verify Print Labels Button Functionality");
        parcelSuccessPageObjects.clickPrintLabelButton();
        sleep(2000);
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Request New Parcel Button Functionality",
            priority = 15 )
    public void verifyRequestNewParcelButtonFunctionality()
    {
        System.out.println("Verifying Request New Parcel Button Functionality");
        parcelSuccessPageObjects.clickRequestNewParcelButton();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        Assert.assertEquals(url,"https://redx.shopups1.xyz/create-parcel/");
    }
*/
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Create Reverse Parcel Functionality",
            priority = 16 )
    public void verifyCreateReverseParcelFunctionality()
    {
        System.out.println("Verifying Create Reverse Parcel Functionality");
        sleep(2000);
        driver.get("https://redx.shopups1.xyz/create-parcel/");
        setImplicitWait(10000);
        int shopId = getRedxApiResponse.getShopId(shopInfoPageObjects.getShopName());
        String name = "random";
        String phone = "01401122188";
        String address = "Area, District,Division, Code";
        String invoice = String.valueOf(random.nextInt(999999));
        String parcelWeight = String.valueOf(random.nextInt(1000)+1);
        String division = "Dhaka";
        String district = "Dhaka";
        String area = "random";
        String pickupStore = "random";
        String parcelType = createParcelPageObjects.getRandomValue("Parcel Type");
        String sellingPrice = String.valueOf(random.nextInt(5000));
        String instruction = "instructions";

        List<String> deliveryCharges = createParcelPageObjects.createReverseParcel(name,phone,address,invoice,parcelWeight,division,district,area,pickupStore,parcelType,sellingPrice,"yes",instruction);
        System.out.println("Delivery Charges in UI : " + deliveryCharges.toString());

        String areaValue = deliveryCharges.get(0);
        int areaId = getRedxApiResponse.getAreaId(division,district,areaValue);
        System.out.println("Delivery Charges in API : " + getRedxApiResponse.deliveryChargeGetCall(shopId,areaId,Integer.parseInt(parcelWeight),0).getBody().getPricing().toString());
//        parcelSuccessPageObjects.clickOkButton();
    }


  @AfterClass(alwaysRun = true)
  public void createParcelsPageTestsAfterClass()
  {
      System.out.println("Create Parcels Page Tests After Class");
  }


    @AfterSuite(alwaysRun = true)
    public void createParcelsPageTestsAfterSuite()
    {
        System.out.println("Create Parcels Page Tests After Suite");
        driver.quit();
    }
}






