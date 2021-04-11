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


public class TrackParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private TrackParcelPageObjects trackParcelPageObjects;
    private TrackParcelPageObjects.CustomerDetailsPageObjects customerDetailsPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private TrackParcelModel trackParcelModel;
    private String parcelId;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void trackParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Track Parcel Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        trackParcelPageObjects = new TrackParcelPageObjects(driver);
        customerDetailsPageObjects = trackParcelPageObjects.new CustomerDetailsPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        trackParcelModel = new TrackParcelModel();

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        parcelId = getRedxApiResponse.getRandomParcelId(actionBarObjects.getShopName());
        System.out.println("Tracking ID : " + parcelId);
        actionBarObjects.searchParcels(parcelId);
        trackParcelModel = getRedxApiResponse.trackParcelGetCall(parcelId);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, TrackParcelPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "170")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Tracking Id Value",
            priority = 701 )
    public void verifyTrackingIdValue()
    {
        System.out.println("Verifying Tracking Id Value");
        String uiValue = trackParcelPageObjects.getTrackingId();
        String assertValue = parcelId;
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Assert Value : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @TestRails(caseId = "171")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Track Parcel Functionality",
            priority = 702 )
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

    @TestRails(caseId = "172")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Id Value",
            priority = 703 )
    public void verifyParcelIdValue()
    {
        System.out.println("Verifying Parcel Id Value");
        String uiValue = customerDetailsPageObjects.getParcelIdValue();
        String apiValue = trackParcelModel.getParcel().getTRACKING_ID();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "173")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Customer Address Value",
            priority = 704 )
    public void verifyCustomerAddressValue()
    {
        System.out.println("Verifying Customer Address Value");
        String uiValue = customerDetailsPageObjects.getCustomerAddressValue();
        String apiValue = trackParcelModel.getParcel().getDELIVERY_ADDRESS();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "174")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Customer Phone Value",
            priority = 705 )
    public void verifyCustomerPhoneValue()
    {
        System.out.println("Verifying Customer Phone Value");
        String uiValue = customerDetailsPageObjects.getCustomerPhoneValue();
        String apiValue = trackParcelModel.getParcel().getCUSTOMER_PHONE();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "175")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Value",
            priority = 706 )
    public void verifyCustomerNameValue()
    {
        System.out.println("Verifying Customer Name Value");
        String uiValue = customerDetailsPageObjects.getCustomerNameValue();
        String apiValue = trackParcelModel.getParcel().getCUSTOMER_NAME();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "176")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Area Value",
            priority = 707 )
    public void verifyAreaValue()
    {
        System.out.println("Verifying Area Value");
        String uiValue = customerDetailsPageObjects.getAreaValue();
        String apiValue = trackParcelModel.getParcel().getAREA();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "177")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Weight Value",
            priority = 708 )
    public void verifyWeightValue()
    {
        System.out.println("Verifying Weight Value");
        String uiValue = customerDetailsPageObjects.getWeightValue();
        String apiValue = String.valueOf(trackParcelModel.getParcel().getWEIGHT());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "178")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Price Value",
            priority = 709 )
    public void verifyPriceValue()
    {
        System.out.println("Verifying Price Value");
        String uiValue = customerDetailsPageObjects.getPriceValue();
        String apiValue = String.valueOf(trackParcelModel.getParcel().getCASH());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "179")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Delivery Charge Value",
            priority = 710 )
    public void verifyDeliveryChargeValue()
    {
        System.out.println("Verifying Delivery Charge Value");
        String uiValue = customerDetailsPageObjects.getDeliveryChargeValue();
        String apiValue = String.valueOf(trackParcelModel.getParcel().getSHOPUP_CHARGE());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "180")
    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},
            description = "Verify Cod Charge Value",
            priority = 711 )
    public void verifyCodChargeValue()
    {
        System.out.println("Verifying Cod Charge Value");
        String uiValue = customerDetailsPageObjects.getCodChargeValue();
        String apiValue = String.valueOf(trackParcelModel.getParcel().getSHOPUP_COD_CHARGE());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }
}