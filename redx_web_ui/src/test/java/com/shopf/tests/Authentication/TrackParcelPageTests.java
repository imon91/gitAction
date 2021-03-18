package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.TrackParcelModel;
import utils.RedXWebBaseClass;

import java.util.List;


public class TrackParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private TrackParcelPageObjects trackParcelPageObjects;
    private TrackParcelPageObjects.CustomerDetailsPageObjects customerDetailsPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private TrackParcelModel trackParcelModel;
    private String cookie;
    private String parcelId;


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
    public void trackParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Track Parcel Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        trackParcelPageObjects = new TrackParcelPageObjects(driver);
        customerDetailsPageObjects = trackParcelPageObjects.new CustomerDetailsPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        trackParcelModel = new TrackParcelModel();

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        parcelId = getRedxApiResponse.getRandomParcelId(actionBarObjects.getShopName());
        System.out.println("Tracking ID : " + parcelId);
        actionBarObjects.searchParcels(parcelId);
        trackParcelModel = getRedxApiResponse.trackParcelGetCall(parcelId);
    }

    @BeforeMethod(alwaysRun = true)
    public void trackParcelPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Tracking Id Value",
            priority = 1 )
    public void verifyTrackingIdValue()
    {
        System.out.println("Verifying Tracking Id Value");
        String uiValue = trackParcelPageObjects.getTrackingId();
        String assertValue = parcelId;
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Assert Value : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Track Parcel Functionality",
            priority = 2 )
    public void verifyTrackParcelFunctionality() {
        System.out.println("Verifying Track Parcel Functionality");
        int elementsUiValue = trackParcelPageObjects.getTrackingElementSize();
        int elementsApiValue = trackParcelModel.getTracking().size();
        System.out.println("Elements Ui Value : " + elementsUiValue);
        System.out.println("Elements Api Value : " + elementsApiValue);
        List<String> dateUiValue = trackParcelPageObjects.getTrackingDateValues();
        List<String> dateApiValue = getRedxApiResponse.getTrackingDateValues(trackParcelModel);
        Assert.assertEquals(elementsUiValue, elementsApiValue);
        Assert.assertEquals(dateUiValue, dateApiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Id Value",
            priority = 3 )
    public void verifyParcelIdValue()
    {
        System.out.println("Verifying Parcel Id Value");
        String uiValue = customerDetailsPageObjects.getParcelIdValue();
        String apiValue = trackParcelModel.getParcel().getTRACKING_ID();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Address Value",
            priority = 4 )
    public void verifyCustomerAddressValue()
    {
        System.out.println("Verifying Customer Address Value");
        String uiValue = customerDetailsPageObjects.getCustomerAddressValue();
        String apiValue = trackParcelModel.getParcel().getDELIVERY_ADDRESS();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Phone Value",
            priority = 5 )
    public void verifyCustomerPhoneValue()
    {
        System.out.println("Verifying Customer Phone Value");
        String uiValue = customerDetailsPageObjects.getCustomerPhoneValue();
        String apiValue = trackParcelModel.getParcel().getCUSTOMER_PHONE();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Value",
            priority = 6 )
    public void verifyCustomerNameValue()
    {
        System.out.println("Verifying Customer Name Value");
        String uiValue = customerDetailsPageObjects.getCustomerNameValue();
        String apiValue = trackParcelModel.getParcel().getCUSTOMER_NAME();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Area Value",
            priority = 7 )
    public void verifyAreaValue()
    {
        System.out.println("Verifying Area Value");
        String uiValue = customerDetailsPageObjects.getAreaValue();
        String apiValue = trackParcelModel.getParcel().getAREA();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Weight Value",
            priority = 8 )
    public void verifyWeightValue()
    {
        System.out.println("Verifying Weight Value");
        String uiValue = customerDetailsPageObjects.getWeightValue();
        String apiValue = String.valueOf(trackParcelModel.getParcel().getWEIGHT());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Price Value",
            priority = 9 )
    public void verifyPriceValue()
    {
        System.out.println("Verifying Price Value");
        String uiValue = customerDetailsPageObjects.getPriceValue();
        String apiValue = String.valueOf(trackParcelModel.getParcel().getCASH());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Delivery Charge Value",
            priority = 10 )
    public void verifyDeliveryChargeValue()
    {
        System.out.println("Verifying Delivery Charge Value");
        String uiValue = customerDetailsPageObjects.getDeliveryChargeValue();
        String apiValue = String.valueOf(trackParcelModel.getParcel().getSHOPUP_CHARGE());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Cod Charge Value",
            priority = 11 )
    public void verifyCodChargeValue()
    {
        System.out.println("Verifying Cod Charge Value");
        String uiValue = customerDetailsPageObjects.getCodChargeValue();
        String apiValue = String.valueOf(trackParcelModel.getParcel().getSHOPUP_COD_CHARGE());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @AfterClass(alwaysRun = true)
    public void trackParcelPageTestsAfterClass()
    {
        System.out.println("Track Parcel Page Tests After Class");

    }

    @AfterSuite(alwaysRun = true)
    public void trackParcelPageTestsAfterSuite()
    {
        System.out.println("Track Parcel Page Tests After Suite");
        driver.quit();
    }
}
