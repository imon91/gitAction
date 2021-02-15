package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.ParcelsListModel;
import utils.RedXWebBaseClass;

public class ParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private ParcelPageObjects parcelPageObjects;
    private GetRedxApiResponse getRedxApiResponse;
    private ParcelsListModel allParcelsListModel;
    private String cookie;
    private String parcelsListGetCallUrl;

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
    public void parcelPageObjectsBeforeClass() throws Exception
    {
        System.out.println("Parcel Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        parcelPageObjects = new ParcelPageObjects(driver);
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);
        parcelsListGetCallUrl = getRedxApiResponse.allParcelsListGetCallUrl(532439,1,20,0,0);
        allParcelsListModel = getRedxApiResponse.parcelsListModel(parcelsListGetCallUrl);
        actionBarObjects.clickParcelsLink();
    }

    @BeforeMethod(alwaysRun = true)
    public void homePageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify All Pickup Location Filter Functionality",
            priority = 1 )
    public void verifyAllPickupLocationFilterFunctionality()
    {
        String pickupLocation = "Dhanmondi";
        System.out.println("Verifying All Pickup Location Filter Functionality");
        System.out.println("Pickup Location : " + pickupLocation);
        parcelPageObjects.choosePickupLocation(pickupLocation);

        int uiValue = Integer.parseInt(parcelPageObjects.getTotalParcelsCount());
        int apiValue = allParcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        parcelPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Tracking Id Filter Functionality",
            priority = 2 )
    public void verifyTrackingIdFilterFunctionality()
    {
        String trackingId = "21A211TH3K5MG";
        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,trackingId);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        System.out.println("Verifying Tracking Id Filter Functionality");
        System.out.println("Tracking Id : " + trackingId);
        parcelPageObjects.enterTrackingIdFilter(trackingId);

        int uiValue = Integer.parseInt(parcelPageObjects.getTotalParcelsCount());
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        parcelPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Invoice Id Filter Functionality",
            priority = 3 )
    public void verifyShopInvoiceIdFilterFunctionality()
    {
        String invoiceId = "123124";
        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"",invoiceId);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        System.out.println("Verifying Shop Invoice Id Filter Functionality");
        System.out.println("Invoice Id : " + invoiceId);
        parcelPageObjects.enterShopInvoiceIdFilter(invoiceId);
        int uiValue = Integer.parseInt(parcelPageObjects.getTotalParcelsCount());
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        parcelPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Phone Number Filter Functionality",
            priority = 4 )
    public void verifyPhoneNumberFilterFunctionality()
    {
        String phoneNumber = "8801401122188";
        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"","",phoneNumber);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        System.out.println("Verifying Phone Number Filter Functionality");
        System.out.println("Phone Number : " + phoneNumber);
        parcelPageObjects.enterPhoneNumberFilter(phoneNumber);
        int uiValue = Integer.parseInt(parcelPageObjects.getTotalParcelsCount());
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        parcelPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Filter Functionality",
            priority = 5 )
    public void verifyCustomerNameFilterFunctionality()
    {
        String customerName = "Parcel Sanity Test";
        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"","",customerName);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        System.out.println("Verifying Customer Name Filter Functionality");
        parcelPageObjects.enterCustomerNameFilter(customerName);
        int uiValue = Integer.parseInt(parcelPageObjects.getTotalParcelsCount());
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        parcelPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Creation Date Filter Functionality",
            priority = 6 )
    public void verifyCreationDateFilterFunctionality()
    {
        System.out.println("Verifying Creation Date Filter Functionality");
        String filterIndex = "CREATED_AT";
        long since = parcelPageObjects.enterDateFromFilter(01,"Jan",2021);
        long until = parcelPageObjects.enterDateToFilter(01,"Feb",2021);
        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"","","",filterIndex,Long.toString(since),Long.toString(until));
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        parcelPageObjects.chooseDateFilterTypeDropDown(filterIndex);
        int uiValue = Integer.parseInt(parcelPageObjects.getTotalParcelsCount());
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        parcelPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Updated Date Filter Functionality",
            priority = 7 )
    public void verifyUpdatedDateFilterFunctionality()
    {
        System.out.println("Verifying Updated Date Filter Functionality");
        String filterIndex = "UPDATED_AT";
        long since = parcelPageObjects.enterDateFromFilter(01,"Jan",2021);
        long until = parcelPageObjects.enterDateToFilter(01,"Feb",2021);
        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"","","",filterIndex,Long.toString(since),Long.toString(until));
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        parcelPageObjects.chooseDateFilterTypeDropDown(filterIndex);
        int uiValue = Integer.parseInt(parcelPageObjects.getTotalParcelsCount());
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        parcelPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Button Functionality",
            priority = 8 )
    public void verifySearchButtonFunctionality()
    {
        System.out.println("Verifying Search Button Functionality");
        Boolean isEnabled = parcelPageObjects.verifySearchButton();
        Assert.assertEquals(isEnabled,Boolean.FALSE);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Parcel History Functionality",
            priority = 9 )
    public void verifyDownloadParcelHistoryFunctionality()
    {

    }

    @AfterClass(alwaysRun = true)
    public void parcelsPageTestsAfterClass(){
        System.out.println("Parcels Page Tests After Class");
    }

    @AfterSuite(alwaysRun = true)
    public void parcelsPageTestsAfterSuite()
    {
        System.out.println("Parcels Page Tests After Suite");
        driver.quit();
    }
}
