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

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class HomePageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private HomePageObjects homePageObjects;
    private ActionBarObjects actionBarObjects;
    private OverviewModel overviewModel;
    private GetRedxApiResponse getRedxApiResponse;
    private String parentWindow;

    private String shopName = "RedX Web Sanity Test Shop";
    private long shopId;
    private long storeId;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void homePageTestsBeforeClass() throws Exception
    {
        System.out.println("Home Page Tests Before Class");

        driver = getBaseDriver();
        homePageObjects = new HomePageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        parentWindow = driver.getWindowHandle();
        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        shopId = getRedxApiResponse.getShopId(shopName);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, HomePageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "23")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Bar Parcel ID Functionality",
            priority = 101 )
    public void verifySearchBarParcelIdFunctionality()
    {
        String parcelId = "21A224WE3K6AU";
        String assertUrl = RedXWebUrlUtils.trackParcelUrl + "?trackingId=" + parcelId + "&shopId=" + shopId;
        System.out.println("Verifying Search Bar Parcel ID Functionality");
        String toastMsg = actionBarObjects.searchParcels(parcelId);
//        System.out.println("Toast Message : " + toastMsg);
//        Assert.assertEquals(toastMsg,"true");
        System.out.println("URL after Search : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),assertUrl);
        switchToDashboard();
    }

    @TestRails(caseId = "24")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Track Parcel Functionality",
            priority = 102 )
    public void verifyTrackParcelFunctionality()
    {
        System.out.println("Verifying Track Parcel Functionality");
        String assertUrl = RedXWebUrlUtils.trackParcelUrl + "?trackingId=&shopId=" + shopId;
        actionBarObjects.clickTrackParcelButton();
        String url = driver.getCurrentUrl();
        System.out.println("Current Url : " + url);
        Assert.assertEquals(url,assertUrl);
    }

    @TestRails(caseId = "26")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Parcels Link Functionality",
            priority = 103 )
    public void verifyParcelsLinkFunctionality()
    {
        System.out.println("Verifying Parcels Link Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickParcelsLink();
        System.out.println("URL after clicking Parcels : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.parcelListUrl);
    }

    @TestRails(caseId = "25")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Dashboard Link Functionality",
            priority = 104 )
    public void verifyDashboardLinkFunctionality()
    {
        System.out.println("Verifying Dashboard Link Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnDashboardLink();
        System.out.println("URL after clicking Dashboard : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.dashboardUrl);
    }

    @TestRails(caseId = "28")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Payments Link Functionality",
            priority = 105 )
    public void verifyPaymentsLinkFunctionality()
    {
        System.out.println("Verifying Payments Link Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickPaymentsLink();
        System.out.println("URL after clicking Payments : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.paymentsUrl);
    }

    @TestRails(caseId = "19")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Logo Functionality",
            priority = 106 )
    public void verifyLogoFunctionality()
    {
        System.out.println("Verifying Logo Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnRedXlogo();
        System.out.println("URL After Clicking Logo : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.dashboardUrl);
    }

    @TestRails(caseId = "27")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Coupon Link Functionality",
            priority = 107 )
    public void verifyCouponLinkFunctionality()
    {
        System.out.println("Verifying Coupon Link Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickCouponLink();
        System.out.println("URL after clicking Coupon : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.couponUrl);
        switchToDashboard();
    }

    @TestRails(caseId = "29")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Create Parcel Functionality",
            priority = 108 )
    public void verifyCreateParcelFunctionality()
    {
        System.out.println("Verifying Create Parcel Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnCreateParcelButton();
        System.out.println("URL after clicking Create Parcel : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.createParcelUrl);
        switchToDashboard();
    }

    @TestRails(caseId = "30")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify My Shops DropDown Functionality",
            priority = 109 )
    public void verifyMyShopsDropDownFunctionality()
    {
        System.out.println("Verifying My Shops DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnDropDownMyShopButton();
            System.out.println("URL after clicking My Shops DropDown : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.shopListUrl);
            switchToDashboard();
        }

        @TestRails(caseId = "31")
        @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
                description = "Verify Pickup Location DropDown Functionality",
                priority = 110 )
        public void verifyPickupLocationDropDownFunctionality()
        {
            System.out.println("Verifying Pickup Location DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnPickupLocationDropDown();
            System.out.println("URL after clicking My Shops DropDown : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.pickupLocationsUrl);
            switchToDashboard();
        }

        @TestRails(caseId = "32")
        @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
                description = "Verify My Payment Details DropDown Functionality",
                priority = 111 )
        public void verifyMyPaymentDetailsDropDownFunctionality()
        {
            System.out.println("Verifying My Payment Details DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnMyPaymentDetailsDropDown();
            System.out.println("URL after clicking My Payment Details DropDown : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.shopPaymentUrl);
            switchToDashboard();
        }

        @TestRails(caseId = "33")
        @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
                description = "Verify Notification Settings DropDown Functionality",
                priority = 112 )
        public void verifyNotificationSettingsDropDownFunctionality()
        {
            System.out.println("Verifying Notification Settings DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnNotificationSettingsDropDown();
            System.out.println("URL after clicking Notification Settings DropDown : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.notificationSettingsUrl);
            switchToDashboard();
        }

        @TestRails(caseId = "34")
        @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
                description = "Verify Coverage Area DropDown Functionality",
                priority = 113 )
        public void verifyCoverageAreaDropDownFunctionality()
        {
            System.out.println("Verifying Coverage Area DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnCoverageAreaDropDown();
            System.out.println("URL after clicking Coverage Area DropDown : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.coverageAreaUrl);
            switchToDashboard();
        }

        @TestRails(caseId = "35")
        @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
                description = "Verify Change Password DropDown Functionality",
                priority = 114 )
        public void verifyChangePasswordDropDownFunctionality()
        {
            System.out.println("Verifying Change Password DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnChangePasswordDropDown();
            System.out.println("URL after clicking Change Password DropDown : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.changePasswordUrl);
            switchToDashboard();
        }

        @TestRails(caseId = "36")
        @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
                description = "Verify Credit History DropDown Functionality",
                priority = 115 )
        public void verifyCreditHistoryDropDownFunctionality()
        {
            System.out.println("Verifying Credit History DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnCreditHistoryDropDown();
            System.out.println("URL after clicking Credit History DropDown : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.creditHistoryUrl);
            switchToDashboard();
        }

        @TestRails(caseId = "37")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Tutorials DropDown Functionality",
                priority = 116 )
        public void verifyTutorialsDropDownFunctionality()
        {
            System.out.println("Verifying Tutorials DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnTutorialsDropDown();

            Set<String> handles = driver.getWindowHandles();
            for(String tab : handles)
            {
                if(!tab.equals(parentWindow))
                    driver.switchTo().window(tab);
            }

            actionBarObjects.waitForLoading();
            String url = driver.getCurrentUrl();
            System.out.println("URL after clicking Tutorials DropDown : " + url);
            driver.close();
            driver.switchTo().window(parentWindow);
            Assert.assertEquals(url,RedXWebUrlUtils.tutorialsUrl);
        }

        @TestRails(caseId = "53")
        @Test(  groups = {CoreConstants.GROUP_SANITY},enabled = false,
                description = "Verify Logout DropDown Functionality",
                priority = 140 )
        public void verifyLogoutDropDownFunctionality()
        {
            System.out.println("Verifying Logout DropDown Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            actionBarObjects.clickOnLogoutDropDown();
            setImplicitWait(1000);
            System.out.println("URL after clicking Logout DropDown : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.baseUrl);
        }

        @TestRails(caseId = "39")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify All PickUp Location Functionality",
                priority = 118 )
        public void verifyAllPickUpLocationFilterFunctionality()
        {
            System.out.println("Verifying All PickUp Location Functionality");
            storeId = getRedxApiResponse.getStoreId(shopName,homePageObjects.choosePickupLocation());
            long since = 1420136999999L;
            long until = new Date().getTime();
            OverviewModel modelPickUp = getRedxApiResponse.overviewGetCall(since,until,shopId,storeId);
            System.out.println("Value in HomePage : " + homePageObjects.getOrdersPlacedValue());
            System.out.println("Total Orders after Pickup Location Filter : " + modelPickUp.getBody().getTotalOrders());
            Assert.assertEquals(homePageObjects.getOrdersPlacedValue(),String.valueOf(modelPickUp.getBody().getTotalOrders()));
        }

        @TestRails(caseId = "40")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Date Filter Functionality",
                priority = 119 )
        public void verifyDateFilterFunctionality()
        {
            System.out.println("Verifying Date Filter Functionality");
            long since = homePageObjects.enterStartDate(1,"Feb",2021);
            long until = homePageObjects.enterEndDate(10,"Mar",2021);
            overviewModel = getRedxApiResponse.overviewGetCall(since,until,shopId,storeId);
            System.out.println("Value in HomePage : " + homePageObjects.getOrdersPlacedValue());
            System.out.println("Total Orders after Date Filter : " + overviewModel.getBody().getTotalOrders());
            Assert.assertEquals(homePageObjects.getOrdersPlacedValue(),String.valueOf(overviewModel.getBody().getTotalOrders()));
        }

        @TestRails(caseId = "38")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify RedX Credit Button Functionality",
                priority = 117 )
        public void verifyRedXCreditButtonFunctionality()
        {
            System.out.println("Verifying RedX Credit Button Functionality");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            homePageObjects.clickRedxCreditButton();
            System.out.println("URL after clicking RedX Credit : " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),RedXWebUrlUtils.creditHistoryUrl);
            switchToDashboard();
        }

        @TestRails(caseId = "42")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify RedX Credit Value",
                priority = 121 )
        public void verifyRedXCreditValue()
        {
            System.out.println("Verifying RedX Credit Value");
            System.out.println("Value in HomePage : " + homePageObjects.getRedxCreditValue());
            System.out.println("Value in API : " + overviewModel.getBody().getAvailableCredits());
            Assert.assertEquals(homePageObjects.getRedxCreditValue(),String.valueOf(overviewModel.getBody().getAvailableCredits()));
        }

        @TestRails(caseId = "43")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Orders Placed Value",
                priority = 122 )
        public void verifyOrdersPlacedValue()
        {
            System.out.println("Verifying Orders Placed Value");
            System.out.println("Value in HomePage : " + homePageObjects.getOrdersPlacedValue());
            System.out.println("Value in API : " + overviewModel.getBody().getTotalOrders());
            Assert.assertEquals(homePageObjects.getOrdersPlacedValue(),String.valueOf(overviewModel.getBody().getTotalOrders()));
        }

        @TestRails(caseId = "44")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Orders Delivered Value",
                priority = 123 )
        public void verifyOrdersDeliveredValue()
        {
            System.out.println("Verifying Orders Delivered Value");
            System.out.println("Value in HomePage : " + homePageObjects.getOrdersDeliveredValue());
            System.out.println("Value in API : " + overviewModel.getBody().getTotalDelivered());
            Assert.assertEquals(homePageObjects.getOrdersDeliveredValue(),String.valueOf(overviewModel.getBody().getTotalDelivered()));
        }

        @TestRails(caseId = "45")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Orders In Transit Value",
                priority = 124 )
        public void verifyOrdersInTransitValue()
        {
            System.out.println("Verifying Orders in Transit Value");
            System.out.println("Value in HomePage : " + homePageObjects.getOrdersInTransitValue());
            System.out.println("Value in API : " + overviewModel.getBody().getTotalInTransit());
            Assert.assertEquals(homePageObjects.getOrdersInTransitValue(),String.valueOf(overviewModel.getBody().getTotalInTransit()));
        }

        @TestRails(caseId = "46")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Orders Returned Value",
                priority = 125 )
        public void verifyOrdersReturnedValue()
        {
            System.out.println("Verifying Orders Returned Value");
            System.out.println("Value in HomePage : " + homePageObjects.getOrdersReturnedValue());
            System.out.println("Value in API : " + overviewModel.getBody().getTotalOrdersReturned());
            Assert.assertEquals(homePageObjects.getOrdersReturnedValue(),String.valueOf(overviewModel.getBody().getTotalOrdersReturned()));
        }

        @TestRails(caseId = "47")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Successful Deliveries Value",
                priority = 126 )
        public void verifySuccessfulDeliveriesValue()
        {
            System.out.println("Verifying Successful Deliveries Value");
            System.out.println("Value in HomePage : " + homePageObjects.getSuccessfulDeliveriesValue());
            System.out.println("Value in API : " + overviewModel.getBody().getSuccessfulDeliveryPercentage());
            Assert.assertEquals(homePageObjects.getSuccessfulDeliveriesValue(),String.valueOf(overviewModel.getBody().getSuccessfulDeliveryPercentage()));
        }

        @TestRails(caseId = "48")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Orders To Be Returned Value",
                priority = 127 )
        public void verifyOrdersToBeReturnedValue()
        {
            System.out.println("Verifying Orders To be Returned Value");
            System.out.println("Value in HomePage : " + homePageObjects.getOrdersToBeReturnedValue());
            System.out.println("Value in API : " + overviewModel.getBody().getTotalOrdersToBeReturned());
            Assert.assertEquals(homePageObjects.getOrdersToBeReturnedValue(),String.valueOf(overviewModel.getBody().getTotalOrdersToBeReturned()));
        }

        @TestRails(caseId = "49")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Total Sales Value Value",
                priority = 128 )
        public void verifyTotalSalesValue()
        {
            System.out.println("Verifying Total Sales Value");
            String totalSales = String.format("%.0f",overviewModel.getBody().getTotalSales());
            System.out.println("Value in HomePage : " + homePageObjects.getTotalSalesValue());
            System.out.println("Value in API : " + totalSales);
            Assert.assertEquals(homePageObjects.getTotalSalesValue(),totalSales);
        }

        @TestRails(caseId = "50")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Total Delivery Fee Paid Value",
                priority = 129 )
        public void verifyTotalDeliveryFeePaidValue()
        {
            System.out.println("Verifying Total Delivery Fee Paid Value");
            String deliveryFeePaid = String.format("%.2f",overviewModel.getBody().getTotalFeesPaid());
            System.out.println("Value in HomePage : " + homePageObjects.getTotalDeliveryFeesPaidValue());
            System.out.println("Value in API : " + deliveryFeePaid);
            Assert.assertEquals(homePageObjects.getTotalDeliveryFeesPaidValue(),deliveryFeePaid);
        }

        @TestRails(caseId = "51")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Total Unpaid Amount Value",
                priority = 130 )
        public void verifyTotalUnpaidAmountValue()
        {
            System.out.println("Verifying Total Unpaid Amount Value");
            String unpaidAmount = String.format("%.2f",overviewModel.getBody().getTotalUnpaidAmount());
            System.out.println("Value in HomePage : " + homePageObjects.getTotalUnPaidAmountValue());
            System.out.println("Value in API : " + unpaidAmount);
            Assert.assertEquals(homePageObjects.getTotalUnPaidAmountValue(),unpaidAmount);
        }

        @TestRails(caseId = "52")
        @Test(  groups = {CoreConstants.GROUP_SANITY},
                description = "Verify Payment Processing Value",
                priority = 131 )
        public void verifyPaymentProcessingValue()
        {
            System.out.println("Verifying Payment Processing Value");
            String paymentProcessingValue = String.format("%.2f",overviewModel.getBody().getTotalPaymentProcessingAmount());
            System.out.println("Value in HomePage : " + homePageObjects.getPaymentProcessingValue());
            System.out.println("Value in API : " + paymentProcessingValue);
            Assert.assertEquals(homePageObjects.getPaymentProcessingValue(),paymentProcessingValue);
        }

    public void switchToDashboard(){
            actionBarObjects.clickOnDashboardLink();
    }
}

