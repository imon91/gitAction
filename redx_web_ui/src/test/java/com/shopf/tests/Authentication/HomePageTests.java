package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.GetRedxApiResponse;
import services.OverviewModel;
import utils.RedXWebBaseClass;

import java.util.Date;
import java.util.Set;

public class HomePageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private ActionBarObjects actionBarObjects;
    private OverviewModel overviewModel;
    private GetRedxApiResponse getRedxApiResponse;
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
    public void homePageTestsBeforeClass() throws InterruptedException {
        System.out.println("Home Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        homePageObjects = new HomePageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        getRedxApiResponse = new GetRedxApiResponse("redx");

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Logo Functionality",
            priority = 1 )
    public void verifyLogoFunctionality()
    {
        System.out.println("Verifying Logo Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnRedXlogo();
        System.out.println("URL After Clicking Logo : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/dashboard/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Filter Invoice Button Functionality",
            priority = 2 )
    public void verifySearchFilterInvoiceButtonFunctionality()
    {
        System.out.println("Verifying Search Filter Invoice Button Functionality");
        actionBarObjects.chooseSearchFilter(2);
        System.out.println("Search Filter Value : " + actionBarObjects.getSearchFilterButtonValue());
        Assert.assertEquals(actionBarObjects.getSearchFilterButtonValue(),"Invoice");
//        translate
//        System.out.println("Search Bar Placeholder Value" + actionBarObjects.getSearchBarPlaceholderValue());
//        Assert.assertEquals(actionBarObjects.getSearchFilterButtonValue(),"Enter the invoice number");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Bar Invoice ID Functionality",
            priority = 3 )
    public void verifySearchBarInvoiceIdFunctionality()
    {
        String invoiceNumber = "RedX_Web_Sanity_Invoice_Test";
        String assertUrl = "https://redx.shopups1.xyz/track-parcel/?invoiceId=" + invoiceNumber + "&shopId=532439";
        System.out.println("Verifying Search Bar Invoice ID Functionality");
        String toastMsg = actionBarObjects.searchParcels(invoiceNumber);
//        System.out.println("Toast Message : " + toastMsg);
//        Assert.assertEquals(toastMsg,"true");
        System.out.println("URL after Search : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),assertUrl);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Filter Parcel Button Functionality",
            priority = 4 )
    public void verifySearchFilterParcelButtonFunctionality()
    {
        System.out.println("Verifying Search Filter Parcel Button Functionality");
        actionBarObjects.chooseSearchFilter(1);
        System.out.println("Search Filter Value : " + actionBarObjects.getSearchFilterButtonValue());
        Assert.assertEquals(actionBarObjects.getSearchFilterButtonValue(),"Parcel");
//        translate
//        System.out.println("Search Bar Placeholder Value" + actionBarObjects.getSearchBarPlaceholderValue());
//        Assert.assertEquals(actionBarObjects.getSearchFilterButtonValue(),"Enter the parcel ID");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Bar Parcel ID Functionality",
            priority = 5 )
    public void verifySearchBarParcelIdFunctionality()
    {
        String parcelId = "21A2A2TU3K43X";
        String assertUrl = "https://redx.shopups1.xyz/track-parcel/?trackingId=" + parcelId + "&shopId=532439";
        System.out.println("Verifying Search Bar Parcel ID Functionality");
        String toastMsg = actionBarObjects.searchParcels(parcelId);
//        System.out.println("Toast Message : " + toastMsg);
//        Assert.assertEquals(toastMsg,"true");
        System.out.println("URL after Search : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),assertUrl);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Track Parcel Functionality",
            priority = 6 )
    public void verifyTrackParcelFunctionality()
    {
        System.out.println("Verifying Track Parcel Functionality");
//        actionBarObjects.clickTrackParcelButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Dashboard Link Functionality",
            priority = 7 )
    public void verifyDashboardLinkFunctionality()
    {
        System.out.println("Verifying Dashboard Link Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnDashboardLink();
        System.out.println("URL after clicking Dashboard : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/dashboard/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcels Link Functionality",
            priority = 8 )
    public void verifyParcelsLinkFunctionality()
    {
        System.out.println("Verifying Parcels Link Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickParcelsLink();
        System.out.println("URL after clicking Parcels : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/parcel-list/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Coupon Link Functionality",
            priority = 9 )
    public void verifyCouponLinkFunctionality()
    {
        System.out.println("Verifying Coupon Link Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickCouponLink();
        System.out.println("URL after clicking Coupon : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/coupon/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payments Link Functionality",
            priority = 10 )
    public void verifyPaymentsLinkFunctionality()
    {
        System.out.println("Verifying Payments Link Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickPaymentsLink();
        System.out.println("URL after clicking Payments : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/payments/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Create Parcel Functionality",
            priority = 11 )
    public void verifyCreateParcelFunctionality()
    {
        System.out.println("Verifying Create Parcel Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnCreateParcelButton();
        System.out.println("URL after clicking Create Parcel : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/create-parcel/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify My Shops DropDown Functionality",
            priority = 12 )
    public void verifyMyShopsDropDownFunctionality()
    {
        System.out.println("Verifying My Shops DropDown Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnDropDownMyShopButton();
        System.out.println("URL after clicking My Shops DropDown : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/shop-list/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Location DropDown Functionality",
            priority = 13 )
    public void verifyPickupLocationDropDownFunctionality()
    {
        System.out.println("Verifying Pickup Location DropDown Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnPickupLocationDropDown();
        System.out.println("URL after clicking My Shops DropDown : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/pickup-locations/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify My Payment Details DropDown Functionality",
            priority = 14 )
    public void verifyMyPaymentDetailsDropDownFunctionality()
    {
        System.out.println("Verifying My Payment Details DropDown Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnMyPaymentDetailsDropDown();
        System.out.println("URL after clicking My Payment Details DropDown : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/shop-payment/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Notification Settings DropDown Functionality",
            priority = 15 )
    public void verifyNotificationSettingsDropDownFunctionality()
    {
        System.out.println("Verifying Notification Settings DropDown Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnNotificationSettingsDropDown();
        System.out.println("URL after clicking Notification Settings DropDown : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/notification-settings/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Coverage Area DropDown Functionality",
            priority = 16 )
    public void verifyCoverageAreaDropDownFunctionality()
    {
        System.out.println("Verifying Coverage Area DropDown Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnCoverageAreaDropDown();
        System.out.println("URL after clicking Coverage Area DropDown : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/coverage-area/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Change Password DropDown Functionality",
            priority = 17 )
    public void verifyChangePasswordDropDownFunctionality()
    {
        System.out.println("Verifying Change Password DropDown Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnChangePasswordDropDown();
        System.out.println("URL after clicking Change Password DropDown : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/change-password/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Credit History DropDown Functionality",
            priority = 18 )
    public void verifyCreditHistoryDropDownFunctionality()
    {
        System.out.println("Verifying Credit History DropDown Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnCreditHistoryDropDown();
        System.out.println("URL after clicking Credit History DropDown : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/credit-history/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Tutorials DropDown Functionality",
            priority = 19 )
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

        setImplicitWait(1000);
        String url = driver.getCurrentUrl();
        System.out.println("URL after clicking Tutorials DropDown : " + url);
        driver.switchTo().window(parentWindow);
        Assert.assertEquals(url,"https://www.youtube.com/channel/UCm8-BBWm89zLCqjFQgqJPwQ");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Logout DropDown Functionality",
            priority = 36 )
    public void verifyLogoutDropDownFunctionality()
    {
        System.out.println("Verifying Logout DropDown Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        actionBarObjects.clickOnLogoutDropDown();
        setImplicitWait(1000);
        System.out.println("URL after clicking Logout DropDown : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify All PickUp Location Functionality",
            priority = 21 )
    public void verifyAllPickUpLocationFilterFunctionality()
    {
        System.out.println("Verifying All PickUp Location Functionality");
        homePageObjects.clickOnAllPickupLocation();
        setImplicitWait(1000);
        homePageObjects.choosePickupLocation("Dhanmondi");
        long since = 1420136999999L;
        long until = new Date().getTime();
        long storeId = 15295;
        OverviewModel modelPickUp = getRedxApiResponse.overviewGetCall(cookie,since,until,storeId);
        System.out.println("Value in HomePage : " + homePageObjects.getOrdersPlacedValue());
        System.out.println("Total Orders after Pickup Location Filter : " + modelPickUp.getBody().getTotalOrders());
        Assert.assertEquals(homePageObjects.getOrdersPlacedValue(),String.valueOf(modelPickUp.getBody().getTotalOrders()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Date Functionality",
            priority = 22 )
    public void verifyDateFunctionality()
    {
        System.out.println("Verifying Date Functionality");
        long since = homePageObjects.enterStartDate(1,"Jan",2015);
        long until = homePageObjects.enterEndDate(7,"Feb",2021);
        overviewModel = getRedxApiResponse.overviewGetCall(cookie,since,until,15295);
        System.out.println("Value in HomePage : " + homePageObjects.getOrdersPlacedValue());
        System.out.println("Total Orders after Date Filter : " + overviewModel.getBody().getTotalOrders());
        Assert.assertEquals(homePageObjects.getOrdersPlacedValue(),String.valueOf(overviewModel.getBody().getTotalOrders()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify RedX Credit Functionality",
            priority = 20 )
    public void verifyRedXCreditFunctionality()
    {
        System.out.println("Verifying RedX Credit Functionality");
        System.out.println("Current URL : " + driver.getCurrentUrl());
        homePageObjects.clickRedxCredit();
        System.out.println("URL after clicking RedX Credit : " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://redx.shopups1.xyz/credit-history/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Chat Icon Functionality",
            priority = 23 )
    public void verifyChatIconFunctionality()
    {

        System.out.println("Verifying Chat Icon Functionality");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify RedX Credit Value",
            priority = 24 )
    public void verifyRedXCreditValue()
    {
        System.out.println("Verifying RedX Credit Value");
        System.out.println("Value in HomePage : " + homePageObjects.getRedxCreditValue());
        System.out.println("Value in API : " + overviewModel.getBody().getAvailableCredits());
        Assert.assertEquals(homePageObjects.getRedxCreditValue(),String.valueOf(overviewModel.getBody().getAvailableCredits()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Orders Placed Value",
            priority = 25 )
    public void verifyOrdersPlacedValue()
    {
        System.out.println("Verifying Orders Placed Value");
        System.out.println("Value in HomePage : " + homePageObjects.getOrdersPlacedValue());
        System.out.println("Value in API : " + overviewModel.getBody().getTotalOrders());
        Assert.assertEquals(homePageObjects.getOrdersPlacedValue(),String.valueOf(overviewModel.getBody().getTotalOrders()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Orders Delivered Value",
            priority = 26 )
    public void verifyOrdersDeliveredValue()
    {
        System.out.println("Verifying Orders Delivered Value");
        System.out.println("Value in HomePage : " + homePageObjects.getOrdersDeliveredValue());
        System.out.println("Value in API : " + overviewModel.getBody().getTotalDelivered());
        Assert.assertEquals(homePageObjects.getOrdersDeliveredValue(),String.valueOf(overviewModel.getBody().getTotalDelivered()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Orders In Transit Value",
            priority = 27 )
    public void verifyOrdersInTransitValue()
    {
        System.out.println("Verifying Orders in Transit Value");
        System.out.println("Value in HomePage : " + homePageObjects.getOrdersInTransitValue());
        System.out.println("Value in API : " + overviewModel.getBody().getTotalInTransit());
        Assert.assertEquals(homePageObjects.getOrdersInTransitValue(),String.valueOf(overviewModel.getBody().getTotalInTransit()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Orders Returned Value",
            priority = 28 )
    public void verifyOrdersReturnedValue()
    {
        System.out.println("Verifying Orders Returned Value");
        System.out.println("Value in HomePage : " + homePageObjects.getOrdersReturnedValue());
        System.out.println("Value in API : " + overviewModel.getBody().getTotalOrdersReturned());
        Assert.assertEquals(homePageObjects.getOrdersReturnedValue(),String.valueOf(overviewModel.getBody().getTotalOrdersReturned()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Successful Deliveries Value",
            priority = 29 )
    public void verifySuccessfulDeliveriesValue()
    {
        System.out.println("Verifying Successful Deliveries Value");
        System.out.println("Value in HomePage : " + homePageObjects.getSuccessfulDeliveriesValue());
        System.out.println("Value in API : " + overviewModel.getBody().getSuccessfulDeliveryPercentage());
        Assert.assertEquals(homePageObjects.getSuccessfulDeliveriesValue(),String.valueOf(overviewModel.getBody().getSuccessfulDeliveryPercentage()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Orders To Be Returned Value",
            priority = 30 )
    public void verifyOrdersToBeReturnedValue()
    {
        System.out.println("Verifying Orders To be Returned Value");
        System.out.println("Value in HomePage : " + homePageObjects.getOrdersToBeReturnedValue());
        System.out.println("Value in API : " + overviewModel.getBody().getTotalOrdersToBeReturned());
        Assert.assertEquals(homePageObjects.getOrdersToBeReturnedValue(),String.valueOf(overviewModel.getBody().getTotalOrdersToBeReturned()));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Total Sales Value Value",
            priority = 31 )
    public void verifyTotalSalesValue()
    {
        System.out.println("Verifying Total Sales Value");
        String totalSales = String.format("%.0f",overviewModel.getBody().getTotalSales());
        System.out.println("Value in HomePage : " + homePageObjects.getTotalSalesValue());
        System.out.println("Value in API : " + totalSales);
        Assert.assertEquals(homePageObjects.getTotalSalesValue(),totalSales);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Total Delivery Fee Paid Value",
            priority = 32 )
    public void verifyTotalDeliveryFeePaidValue()
    {
        System.out.println("Verifying Total Delivery Fee Paid Value");
        String deliveryFeePaid = String.format("%.2f",overviewModel.getBody().getTotalFeesPaid());
        System.out.println("Value in HomePage : " + homePageObjects.getTotalDeliveryFeesPaidValue());
        System.out.println("Value in API : " + deliveryFeePaid);
        Assert.assertEquals(homePageObjects.getTotalDeliveryFeesPaidValue(),deliveryFeePaid);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Total Unpaid Amount Value",
            priority = 33 )
    public void verifyTotalUnpaidAmountValue()
    {
        System.out.println("Verifying Total Unpaid Amount Value");
        String unpaidAmount = String.format("%.2f",overviewModel.getBody().getTotalUnpaidAmount());
        System.out.println("Value in HomePage : " + homePageObjects.getTotalUnPaidAmountValue());
        System.out.println("Value in API : " + unpaidAmount);
        Assert.assertEquals(homePageObjects.getTotalUnPaidAmountValue(),unpaidAmount);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Processing Value",
            priority = 34 )
    public void verifyPaymentProcessingValue()
    {
        System.out.println("Verifying Payment Processing Value");
        String paymentProcessingValue = String.format("%.2f",overviewModel.getBody().getTotalPaymentProcessingAmount());
        System.out.println("Value in HomePage : " + homePageObjects.getPaymentProcessingValue());
        System.out.println("Value in API : " + paymentProcessingValue);
        Assert.assertEquals(homePageObjects.getPaymentProcessingValue(),paymentProcessingValue);
    }

    @BeforeMethod(alwaysRun = true)
    public void homePageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @AfterMethod(alwaysRun = true)
    public void homePageTestsAfterMethodClass(){
        setImplicitWait(10000);
        if(driver.getCurrentUrl().equalsIgnoreCase("https://redx.shopups1.xyz/dashboard/"))
            System.out.println("After Method in Dashboard");
        else if(driver.getCurrentUrl().equalsIgnoreCase("https://redx.shopups1.xyz/"))
        {
            System.out.println("After Method in Base URL");
        }
        else {
            System.out.println("After Method Switching to Dashboard");
            driver.get("https://redx.shopups1.xyz/dashboard/");
            sleep(1000);
        }
    }

    @AfterClass(alwaysRun = true)
    public void homePageTestsAfterClass(){
        System.out.println("Home Page Tests After Class");
    }

    @AfterSuite(alwaysRun = true)
    public void redxAfterSuite(){
        System.out.println("RedX Web After Suite is called");
        quitBaseDriver();
    }
}

