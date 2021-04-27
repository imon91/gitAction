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

public class ParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private ParcelPageObjects parcelPageObjects;

    private ParcelPageObjects.SearchByPageObjects searchByPageObjects;
    private ParcelPageObjects.ParcelsListPageObjects parcelsListPageObjects;
    private ParcelPageObjects.DownloadParcelHistoryPageObjects downloadParcelHistoryPageObjects;
    private ParcelPageObjects.StatusFilterPageObjects statusFilterPageObjects;
    private ParcelPageObjects.PaymentStatusFilterPageObjects paymentStatusFilterPageObjects;
    private ParcelPageObjects.EditParcelPageObjects editParcelPageObjects;
    private ParcelPageObjects.ExchangeParcelPageObjects exchangeParcelPageObjects;
    private ParcelPageObjects.DeleteParcelPageObjects deleteParcelPageObjects;
    private ParcelPageObjects.RaiseIssuePageObjects raiseIssuePageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private ParcelsListModel allParcelsListModel;
    private String parentWindow;
    private String parcelsListGetCallUrl;
    private Random random;
    private int index;
    private String shopName = "Bulk Issue Test Shop";
    private long shopId ;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void parcelPageObjectsBeforeClass() throws Exception
    {
        System.out.println("Parcel Page Tests Before Class");
        driver = getBaseDriver();

        actionBarObjects = new ActionBarObjects(driver);
        parcelPageObjects = new ParcelPageObjects(driver);

        searchByPageObjects = parcelPageObjects.new SearchByPageObjects();
        parcelsListPageObjects = parcelPageObjects.new ParcelsListPageObjects();
        downloadParcelHistoryPageObjects = parcelPageObjects.new DownloadParcelHistoryPageObjects();
        statusFilterPageObjects = parcelPageObjects.new StatusFilterPageObjects();
        paymentStatusFilterPageObjects = parcelPageObjects.new PaymentStatusFilterPageObjects();
        editParcelPageObjects = parcelPageObjects.new EditParcelPageObjects();
        exchangeParcelPageObjects = parcelPageObjects.new ExchangeParcelPageObjects();
        deleteParcelPageObjects = parcelPageObjects.new DeleteParcelPageObjects();
        raiseIssuePageObjects = parcelPageObjects.new RaiseIssuePageObjects();
        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        parentWindow = driver.getWindowHandle();

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        shopId = getRedxApiResponse.getShopId(shopName);

        int page = 1 ,limit = 20 ,offset = 0 ,sort=0;

        parcelsListGetCallUrl = getRedxApiResponse.allParcelsListGetCallUrl(shopId,page,limit,offset,sort);
        allParcelsListModel = getRedxApiResponse.parcelsListModel(parcelsListGetCallUrl);
        actionBarObjects.clickParcelsLink();
        index = parcelPageObjects.getRandomParcelIndex();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, ParcelPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "54")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify All Pickup Location Filter Functionality",
            priority = 201 )
    public void verifyAllPickupLocationFilterFunctionality()
    {
        System.out.println("Verifying All Pickup Location Filter Functionality");
        String storeId = searchByPageObjects.choosePickupLocation();
        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"","","","","","",storeId);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);

        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        searchByPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "55")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Tracking Id Filter Functionality",
            priority = 202 )
    public void verifyTrackingIdFilterFunctionality()
    {
        String trackingId = "21A224WE3K6AU";
        System.out.println("Verifying Tracking Id Filter Functionality");
        System.out.println("Tracking Id : " + trackingId);

        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,trackingId);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        searchByPageObjects.enterTrackingIdFilter(trackingId);

        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        searchByPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "56")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Invoice Id Filter Functionality",
            priority = 203 )
    public void verifyShopInvoiceIdFilterFunctionality()
    {
        String invoiceId = "123124";
        System.out.println("Verifying Shop Invoice Id Filter Functionality");
        System.out.println("Invoice Id : " + invoiceId);

        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"",invoiceId);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        searchByPageObjects.enterShopInvoiceIdFilter(invoiceId);

        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        searchByPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "57")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Phone Number Filter Functionality",
            priority = 204 )
    public void verifyPhoneNumberFilterFunctionality()
    {
        String phoneNumber = "8801401122177";
        System.out.println("Verifying Phone Number Filter Functionality");
        System.out.println("Phone Number : " + phoneNumber);

        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"","",phoneNumber);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        searchByPageObjects.enterPhoneNumberFilter(phoneNumber);

        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        searchByPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "58")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Filter Functionality",
            priority = 205 )
    public void verifyCustomerNameFilterFunctionality()
    {
        String customerName = "Parcel Sanity Test";
        System.out.println("Verifying Customer Name Filter Functionality");
        System.out.println("Customer Name : " + customerName);

        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"","",customerName);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        searchByPageObjects.enterCustomerNameFilter(customerName);

        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        searchByPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "59")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Date Filter Functionality",
            priority = 206 )
    public void verifyDateFilterFunctionality()
    {
        System.out.println("Verifying Date Filter Functionality");
        String filterIndex = parcelPageObjects.getRandomValue("Filter Index");
        long since = searchByPageObjects.enterDateFromFilter(01,"Jan",2021);
        long until = searchByPageObjects.enterDateToFilter(23,"Feb",2021);

        String url = getRedxApiResponse.parcelsListGetCallUrl(parcelsListGetCallUrl,"","","",filterIndex,Long.toString(since),Long.toString(until));
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(url);
        searchByPageObjects.chooseDateFilterTypeDropDown(filterIndex);

        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels Count in UI : " + uiValue);
        System.out.println("Parcels Count in API : " + apiValue);
        searchByPageObjects.clickClearSearchButton();
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "61")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Button Functionality",
            priority = 208 )
    public void verifySearchButtonFunctionality()
    {
        System.out.println("Verifying Search Button Functionality");
        Boolean isEnabled = searchByPageObjects.verifySearchButton();
        Assert.assertEquals(isEnabled,Boolean.FALSE);
    }

    @TestRails(caseId = "62")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Parcel History Button Functionality",
            priority = 209 )
    public void verifyDownloadParcelHistoryButtonFunctionality()
    {
        System.out.println("Verifying Download Parcel History Button Functionality");
        downloadParcelHistoryPageObjects.clickDownloadParcelHistory();
        String modalTitle = downloadParcelHistoryPageObjects.getModalTitle();
        System.out.println("Modal Title : " + modalTitle);
        Assert.assertEquals(modalTitle,"Download Parcel History");
    }

    @TestRails(caseId = "63")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Parcel History Cancel Button Functionality",
            priority = 210 )
    public void verifyDownloadParcelHistoryCancelButtonFunctionality()
    {
        System.out.println("Verifying Download Parcel History Cancel Button Functionality");
        downloadParcelHistoryPageObjects.clickCancelButton();
        //Assert
    }

    @TestRails(caseId = "64")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Parcel History Functionality",
            priority = 211 )
    public void verifyDownloadParcelHistoryFunctionality()
    {
        System.out.println("Verifying Download Parcel History Functionality");
        driver.navigate().refresh();
        setImplicitWait(10000);
        downloadParcelHistoryPageObjects.clickDownloadParcelHistory();
        downloadParcelHistoryPageObjects.downloadParcelHistory(1,"Jan",2021,1,"Feb",2021, random.nextInt(2)+1, random.nextInt(2),random.nextInt(10));
        //Assert
    }

    @TestRails(caseId = "65")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Select All Parcels Checkbox Functionality",
            priority = 212 )
    public void verifySelectAllParcelsCheckboxFunctionality()
    {
        System.out.println("Verifying Select All Parcels Checkbox Functionality");
        parcelsListPageObjects.clickSelectAllParcelsCheckbox();
        int selectedParcels = parcelsListPageObjects.getSelectedParcels();
        int totalParcels = parcelPageObjects.getTotalParcelsCount();
        parcelsListPageObjects.clickSelectAllParcelsCheckbox();
        System.out.println("Selected Parcels : " + selectedParcels);
        System.out.println("Total Parcels : " + totalParcels);
        if(totalParcels<20)
            Assert.assertEquals(selectedParcels,totalParcels);
        else
            Assert.assertEquals(selectedParcels,20);
    }

    @TestRails(caseId = "66")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Select Parcel Functionality",
            priority = 213)
    public void verifySelectParcelFunctionality()
    {
        System.out.println("Verifying Select Parcels Checkbox Functionality");
        int selectedParcels[] = parcelsListPageObjects.clickSelectParcelCheckbox();
        System.out.println("Parcels Selected : " + selectedParcels[1]);
        parcelsListPageObjects.clickUnSelectParcelCheckbox(selectedParcels[0]);
        Assert.assertEquals(selectedParcels[1],1);
    }

    @TestRails(caseId = "67")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Print Labels Functionality",
            priority = 214)
    public void verifyPrintLabelsFunctionality()
    {
        System.out.println("Verifying Print Labels Functionality");
        int selectedParcels[] = parcelsListPageObjects.clickSelectParcelCheckbox();
        System.out.println("Parcels Selected : " + selectedParcels[1]);
        parcelPageObjects.clickPrintLabelsButton();
        sleep(2000);
        Set<String> handles = driver.getWindowHandles();
        int size = handles.size();
        System.out.println("Handles : " + size);
        for(String tab : handles)
        {
            if(!tab.equals(parentWindow))
            {
                driver.switchTo().window(tab);
                System.out.println(driver.getCurrentUrl());
                driver.close();
                driver.switchTo().window(parentWindow);
                parcelsListPageObjects.clickUnSelectParcelCheckbox( selectedParcels[0]);
            }
        }
        Assert.assertEquals(size,2);
    }

    @TestRails(caseId = "68")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Pages Functionality",
            priority = 215)
    public void verifyPaginationPagesFunctionality()
    {
        System.out.println("Verifying Pagination Pages Functionality");
        if(parcelPageObjects.getTotalParcelsCount()>20)
        {
            int page[] = parcelPageObjects.clickPageIcon();
            Assert.assertEquals(page[1],page[0]);
        } else System.out.println("Pagination Not Found");
    }

    @TestRails(caseId = "69")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Next Page Functionality",
            priority = 216)
    public void verifyPaginationNextPageFunctionality()
    {
        System.out.println("Verifying Pagination Next Page Functionality");
        if(parcelPageObjects.getTotalParcelsCount()>20)
        {
            System.out.println("Active Page : " + parcelPageObjects.getActivePage());
            parcelPageObjects.clickNextPageIcon();
            System.out.println("Current Active Page : " + parcelPageObjects.getActivePage());
            Assert.assertEquals(parcelPageObjects.getActivePage(), 2);
        } else System.out.println("Pagination Not Found");
    }

    @TestRails(caseId = "70")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Functionality",
            priority = 217)
    public void verifyPaginationPreviousPageFunctionality()
    {
        System.out.println("Verifying Pagination Previous Page Functionality");
        if(parcelPageObjects.getTotalParcelsCount()>20)
        {
            System.out.println("Active Page : " + parcelPageObjects.getActivePage());
            parcelPageObjects.clickPreviousPageIcon();
            System.out.println("Current Active Page : " + parcelPageObjects.getActivePage());
            Assert.assertEquals(parcelPageObjects.getActivePage(),1);
        } else System.out.println("Pagination Not Found");
    }

    @TestRails(caseId = "71")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Creation Date Value",
            priority = 218)
    public void verifyCreationDateValue()
    {
        System.out.println("Verifying Creation Date Value");
        String uiValue = parcelsListPageObjects.getCreationDateValue(index);
        String assertValue = allParcelsListModel.getBody().getParcels().get(index-1).getCREATED_AT();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @TestRails(caseId = "72")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Name Value",
            priority = 219)
    public void verifyPickupNameValue()
    {
        System.out.println("Verifying Pickup Name Value");
        String uiValue = parcelsListPageObjects.getPickupNameValue(index);
        String storeId = String.valueOf(parcelPageObjects.getStoreId(uiValue));
        String apiValue = String.valueOf(allParcelsListModel.getBody().getParcels().get(index-1).getSHOP_STORE_ID());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Store Id : " + storeId);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(storeId,apiValue);
    }

    @TestRails(caseId = "73")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Id Functionality",
            priority = 220)
    public void verifyParcelIdFunctionality()
    {
        System.out.println("Verifying Parcel Id Functionality");
        String parcelId = parcelsListPageObjects.getParcelIdValue(index);
        String assertUrl = "https://redx.shopups1.xyz/track-parcel/?trackingId=" + parcelId + "&shopId=" + shopId;
        System.out.println("Parcel Id : " + parcelId);
        parcelsListPageObjects.clickParcelIdButton(index);
        parcelsListPageObjects.waitForLoading();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        actionBarObjects.clickParcelsLink();
        Assert.assertEquals(url,assertUrl);
    }

    @TestRails(caseId = "74")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Id Value",
            priority = 221)
    public void verifyParcelIdValue()
    {
        System.out.println("Verifying Parcel Id Value");
        String uiValue = parcelsListPageObjects.getParcelIdValue(index);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getID();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "75")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Id Value",
            priority = 222)
    public void verifyInvoiceIdValue()
    {
        System.out.println("Verifying Invoice Id Value");
        String uiValue = parcelsListPageObjects.getInvoiceId(index,2);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getINVOICE_NUMBER();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "76")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Value",
            priority = 223)
    public void verifyShopValue()
    {
        System.out.println("Verifying Shop Value");
        String uiValue = parcelsListPageObjects.getShopNameValue(index);
        String assertValue = actionBarObjects.getShopName();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + assertValue);
        Assert.assertEquals(uiValue.toLowerCase(),assertValue.toLowerCase());
    }

    @TestRails(caseId = "77")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Value",
            priority = 224)
    public void verifyCustomerNameValue()
    {
        System.out.println("Verifying Customer Name Value");
        String uiValue = parcelsListPageObjects.getCustomerDetailsValue(index,1);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getCUSTOMER_NAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "78")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Phone Value",
            priority = 225)
    public void verifyCustomerPhoneValue()
    {
        System.out.println("Verifying Customer Phone Value");
        String uiValue = parcelsListPageObjects.getCustomerDetailsValue(index,2);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getCUSTOMER_PHONE();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "79")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Address Value",
            priority = 226)
    public void verifyCustomerAddressValue()
    {
        System.out.println("Verifying Customer Address Value");
        String uiValue = parcelsListPageObjects.getCustomerDetailsValue(index,3);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getDELIVERY_ADDRESS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "80")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Area Value",
            priority = 227)
    public void verifyCustomerAreaValue()
    {
        System.out.println("Verifying Customer Area Value");
        String uiValue = parcelsListPageObjects.getCustomerDetailsValue(index,4);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getAREA();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "81")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Stauts Value",
            priority = 228)
    public void verifyStatusValue()
    {
        System.out.println("Verifying Status Value");
        String uiValue = parcelsListPageObjects.getLowerCaseStatusValue(index);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getSELLER_STATUS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(apiValue.contains(uiValue),true);
    }

    @TestRails(caseId = "82")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Info Cash Value",
            priority = 229)
    public void verifyPaymentInfoCashValue()
    {
        System.out.println("Verifying Payment Info Cash Value");
        String uiValue = parcelsListPageObjects.getPaymentInfoValue(index,1);
        String apiValue = String.valueOf(allParcelsListModel.getBody().getParcels().get(index-1).getCASH());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "83")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Info Charge Value",
            priority = 230)
    public void verifyPaymentInfoChargeValue()
    {
        System.out.println("Verifying Payment Info Charge Value");
        String uiValue = parcelsListPageObjects.getPaymentInfoValue(index,2);
        String apiValue = String.valueOf(allParcelsListModel.getBody().getParcels().get(index-1).getSHOPUP_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "84")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Status Value",
            priority = 231)
    public void verifyPaymentStatusValue()
    {
        System.out.println("Verifying Payment Status Value");
        String uiValue = parcelsListPageObjects.getPaymentStatusValue(index);
        Boolean apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getIS_SETTLED();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        if(apiValue)
            Assert.assertEquals(uiValue,"Settled");
        else Assert.assertEquals(uiValue,"Unsettled");
    }

    @TestRails(caseId = "85")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Promocode Discount Value",
            priority = 232)
    public void verifyPromocodeDiscountValue()
    {
        System.out.println("Verifying Promocode Discount Value");
        String uiValue = parcelsListPageObjects.getPromoCodeDiscountValue(index);
        String apiValue = String.valueOf(allParcelsListModel.getBody().getParcels().get(index-1).getPromoCodeDiscountAmount());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "86")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Delivery Type Value",
            priority = 233)
    public void verifyParcelDeliveryTypeValue()
    {
        System.out.println("Verifying Parcel Delivery Type Value");
        String uiValue = parcelsListPageObjects.getParcelDeliveryTypeValue(index,1);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getPARCEL_DELIVERY_TYPE();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "87")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Type Value",
            priority = 234)
    public void verifyParcelTypeValue()
    {
        System.out.println("Verifying Parcel Type Value");
        String uiValue = parcelsListPageObjects.getParcelTypeValue(index);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getPARCEL_TYPE();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "88")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Last Updated Value",
            priority = 235)
    public void verifyLastUpdatedValue()
    {
        System.out.println("Verifying Last Updated Value");
        String uiValue = parcelsListPageObjects.getLastUpdatedValue(index);
        String assertValue = allParcelsListModel.getBody().getParcels().get(index-1).getUPDATED_AT();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @TestRails(caseId = "89")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Status Filter Functionality",
            priority = 236)
    public void verifyStatusFilterFunctionality()
    {
        System.out.println("Verifying Status Filter Functionality");
        String status = parcelPageObjects.getRandomValue("Parcel Status");
        statusFilterPageObjects.filterByStatus(status,1);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(getRedxApiResponse.parcelsListStatusFilterGetCallUrl(parcelsListGetCallUrl,status));
        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels with " + status + " status in UI : " + uiValue);
        System.out.println("Parcels with " + status + " status in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "90")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Status Filter Reset Functionality",
            priority = 237)
    public void verifyStatusFilterResetFunctionality()
    {
        System.out.println("Verifying Status Filter Reset Functionality");
        statusFilterPageObjects.clickStatusFilterDropDown();
        statusFilterPageObjects.clickResetButton();
        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = getRedxApiResponse.parcelsListModel(parcelsListGetCallUrl).getBody().getCount();
        System.out.println("Parcels in UI : " + uiValue);
        System.out.println("Parcels in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }


    @TestRails(caseId = "91")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Status Filter Functionality",
            priority = 238)
    public void verifyPaymentStatusFilterFunctionality()
    {
        System.out.println("Verifying Payment Status Filter Functionality");
//        paymentStatusFilterPageObjects.scrollRight();
        String paymentStatus = parcelPageObjects.getRandomValue("Payment Status");
        statusFilterPageObjects.filterByStatus(paymentStatus,2);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(getRedxApiResponse.parcelsListPaymentStatusFilterGetCallUrl(parcelsListGetCallUrl,paymentStatus));;
        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue =parcelsListModel.getBody().getCount();
        System.out.println("Parcels with " + paymentStatus + " status in UI : " + uiValue);
        System.out.println("Parcels with " + paymentStatus + " status in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "92")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Status Filter Reset Functionality",
            priority = 239)
    public void verifyPaymentStatusFilterResetFunctionality()
    {
        System.out.println("Verifying Payment Status Filter Reset Functionality");
//        paymentStatusFilterPageObjects.scrollRight();
//        paymentStatusFilterPageObjects.clickPaymentStatusFilterDropDown();
        statusFilterPageObjects.clickStatusFilterDropDown();
        statusFilterPageObjects.clickResetButton();
        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = getRedxApiResponse.parcelsListModel(parcelsListGetCallUrl).getBody().getCount();
        System.out.println("Parcels in UI : " + uiValue);
        System.out.println("Parcels in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "93")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Edit Button Functionality",
               priority = 240)
       public void verifyEditButtonFunctionality()
       {
           System.out.println("Verifying Edit Button Functionality");
           statusFilterPageObjects.filterByStatus("Pickup Pending",1);
           if(parcelPageObjects.getTotalParcelsCount()!=0)
           {
               editParcelPageObjects.clickEditButton(parcelPageObjects.getRandomParcelIndex());
               String modalTitle = editParcelPageObjects.getModalTitle();
               System.out.println("Modal Title : " + modalTitle);
               editParcelPageObjects.clickCloseButton();
               Assert.assertEquals(modalTitle,"Edit Parcel");
           } else System.out.println("No Parcels Found to perform Action");
       }

    @TestRails(caseId = "94")
       @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Edit Cancel Button in Edit Functionality",
               priority = 241)
       public void verifyCancelButtonEditFunctionality()
       {
           System.out.println("Verifying Cancel Button in Edit Functionality");
           if(parcelPageObjects.getTotalParcelsCount()!=0)
           {
               editParcelPageObjects.clickEditButton(parcelPageObjects.getRandomParcelIndex());
               editParcelPageObjects.enterInstructions("Verifying Cancel Button");
               editParcelPageObjects.clickCancelButton();
           } else System.out.println("No Parcels Found to perform Action");

       }

      @TestRails(caseId = "95")
       @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
               description = "Verify Edit Functionality",
               priority = 242)
       public void verifyEditFunctionality()
       {
           System.out.println("Verifying Edit Functionality");
           statusFilterPageObjects.filterByStatus("Pickup Pending",1);
           if(parcelPageObjects.getTotalParcelsCount()!=0)
           {
               int index = parcelPageObjects.getRandomParcelIndex();
               System.out.println("Index : " + index);
               editParcelPageObjects.clickEditButton(index);
               editParcelPageObjects.editParcel("Edit Name Test");
               String toastMsg = editParcelPageObjects.getToastMsg();
               System.out.println("Toast Msg : " + toastMsg);
               parcelPageObjects.clickResetButton();
               if(!toastMsg.equalsIgnoreCase("Failed to edit parcel"))
                   Assert.assertEquals(toastMsg,"Parcel has been edited successfully");
           } else System.out.println("No Parcels Found to perform Action");
       }

    @TestRails(caseId = "96")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Delete Button Functionality",
            priority = 243)
    public void verifyDeleteButtonFunctionality()
    {
        System.out.println("Verifying Delete Button Functionality");
        statusFilterPageObjects.filterByStatus("Pickup Pending",1);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        if(parcelPageObjects.getTotalParcelsCount()!=0)
        {
            int index = parcelPageObjects.getRandomParcelIndex();
            System.out.println("Index : " + index);
            deleteParcelPageObjects.clickDeleteButton(index);
            Assert.assertEquals(deleteParcelPageObjects.getPopoverMessageTitle(),"Are you sure?");
        } else System.out.println("No Parcels Found to perform Action");
    }

    @TestRails(caseId = "98")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify No Delete Button Functionality",
            priority = 244)
    public void verifyNoDeleteFunctionality()
    {
        System.out.println("Verifying No Delete Button Functionality");
        if(parcelPageObjects.getTotalParcelsCount()!=0)
        {
            deleteParcelPageObjects.clickNoButton();
        } else System.out.println("No Parcels Found to perform Action");
    }

    @TestRails(caseId = "99")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Delete Functionality",
            priority = 245)
    public void verifyDeleteFunctionality()
    {
        System.out.println("Verifying Delete Functionality");
        statusFilterPageObjects.filterByStatus("Pickup Pending",1);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        if(parcelPageObjects.getTotalParcelsCount()!=0)
        {
            int total = parcelPageObjects.getTotalParcelsCount();
            int index = parcelPageObjects.getRandomParcelIndex();
            System.out.println("Parcel Id : " + parcelsListPageObjects.getParcelIdValue(index));
            deleteParcelPageObjects.clickDeleteButton(index);
            deleteParcelPageObjects.clickYesButton();
            parcelPageObjects.clickResetButton();
            statusFilterPageObjects.filterByStatus("Pickup Pending",1);
            int parcels = parcelPageObjects.getTotalParcelsCount();
            parcelPageObjects.clickResetButton();
            if(parcels==total)
                System.out.println(deleteParcelPageObjects.getAlertMessage());
            else Assert.assertEquals(parcels,total-1);
        } else System.out.println("No Parcels Found to perform Action");
    }

    @TestRails(caseId = "101")
    @Test(  groups = {CoreConstants.GROUP_SANITY},enabled = false,
               description = "Verify Exchange Button Functionality",
               priority = 246)
       public void verifyExchangeButtonFunctionality()
       {
           System.out.println("Verifying Exchange Button Functionality");
           statusFilterPageObjects.filterByStatus("Delivered",1);
           int cash = exchangeParcelPageObjects.clickExchangeButton();
           if(cash!=(-1))
           {
               String modalTitle = exchangeParcelPageObjects.getModalTitle();
               System.out.println("Modal Title : " + modalTitle);
               exchangeParcelPageObjects.clickCloseButton();
               Assert.assertEquals(modalTitle,"Exchange Parcel");
           }
           System.out.println("No Parcels found to perform Exchange");
       }

       @TestRails(caseId = "102")
       @Test(  groups = {CoreConstants.GROUP_SANITY},enabled = false,
               description = "Verify Exchange Cancel Button Functionality",
               priority = 247)
       public void verifyExchangeCancelButtonFunctionality()
       {
           System.out.println("Verifying Exchange Cancel Button Functionality");
           int cash = exchangeParcelPageObjects.clickExchangeButton();
           if(cash!=(-1))
           {
               exchangeParcelPageObjects.enterAmount(cash);
               exchangeParcelPageObjects.clickCancelButton();
           }
           System.out.println("No Parcels found to perform Exchange");
       }

       @TestRails(caseId = "103")
       @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY,CoreConstants.GROUP_SLACK_BUG},
               description = "Verify Exchange Functionality",
               priority = 248)
       public void verifyExchangeFunctionality()
       {
           System.out.println("Verifying Exchange Functionality");//*
           statusFilterPageObjects.filterByStatus("Delivered",1);
           int cash = exchangeParcelPageObjects.clickExchangeButton();
           List<String> exchangeParcel,returnParcel,deliveryParcel;
           if(cash!=(-1))
           {
               exchangeParcel = exchangeParcelPageObjects.exchangeParcel(cash);
               System.out.println("Exchange Parcel Details : " + exchangeParcel.toString());
               String toastMsg = exchangeParcelPageObjects.getToastMsg();
               System.out.println("Toast : " + toastMsg);
               if(!toastMsg.equalsIgnoreCase("Failed to create excahange parcel"))//Spelling in UI itself
               {
                   Assert.assertEquals(toastMsg,"Exchange parcel created successfully");
                   parcelPageObjects.clickResetButton();
                   returnParcel = getParcelDetails(1);
                   System.out.println("Return Parcel Details : " + returnParcel.toString());
                   deliveryParcel = getParcelDetails(2);
                   System.out.println("Delivery Parcel Details : " + deliveryParcel.toString());
                   System.out.println(exchangeParcel.get(0).equals(returnParcel.get(0).equals(deliveryParcel.get(0))));
                   System.out.println(exchangeParcel.get(1).equals(returnParcel.get(1).equals(deliveryParcel.get(1))));
                   Assert.assertEquals(returnParcel.get(2),"Returning","Return Parcel Status Mismatch");
                   Assert.assertEquals(returnParcel.get(3),"0","Return Parcel Cash Value Mismatch");
                   Assert.assertEquals(deliveryParcel.get(2),"Pickup Pending","Delivery Parcel Status Mismatch");
                   Assert.assertEquals(deliveryParcel.get(3),String.valueOf(cash),"Delivery Parcel Cash Value Mismatch");
               }
           }
           System.out.println("No Parcels found to perform Exchange");//*/
           driver.navigate().refresh();
           parcelPageObjects.waitForLoading();
       }

       public List<String> getParcelDetails(int index)
       {
           List<String> details = new ArrayList<>();
           details.add(parcelsListPageObjects.getParcelIdValue(index));
           details.add(parcelsListPageObjects.getCustomerDetailsValue(index,1));
           details.add(parcelsListPageObjects.getStatusValue(index));
           details.add(parcelsListPageObjects.getPaymentInfoValue(index,1));
           String trackingId = parcelsListPageObjects.getMoreInfoValue(index,2);
           details.add(trackingId.substring(trackingId.length()-13));
           return details;
       }

       @TestRails(caseId = "104")
       @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Raise Issue Button Functionality",
               priority = 249)
       public void verifyRaiseIssueButtonFunctionality()
       {
           System.out.println("Verifying Raise Issue Button Functionality");
           raiseIssuePageObjects.clickRaiseIssueButton();
           String modalTitle = raiseIssuePageObjects.getModalTitle();
           String assertValue = "Issue creation for " + raiseIssuePageObjects.getParcelId();
           System.out.println("Modal Title : " + modalTitle);
           raiseIssuePageObjects.clickCloseIcon();
           Assert.assertEquals(modalTitle,assertValue);
       }

    @TestRails(caseId = "105")
       @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Raise Issue Back Button Functionality",
            priority = 250)
    public void verifyRaiseIssueBackButtonFunctionality()
    {
        System.out.println("Verifying Raise Issue Back Button Functionality");
        raiseIssuePageObjects.clickRaiseIssueButton();
        raiseIssuePageObjects.clickIssueType();
        raiseIssuePageObjects.clickBackButton();
        String title = raiseIssuePageObjects.getTitleWrapper();
        raiseIssuePageObjects.clickCloseIcon();
        Assert.assertEquals(title,"Please select an issue type");
    }

    @TestRails(caseId = "106")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Raise Issue Functionality",
            priority = 251)
    public void verifyRaiseIssueFunctionality()
    {
        System.out.println("Verifying Raise Issue Functionality");
        raiseIssuePageObjects.clickRaiseIssueButton();
        String assertValue = raiseIssuePageObjects.raiseIssue();
        if(assertValue.equalsIgnoreCase("Issue created Successfully"))
            {
                Assert.assertEquals(assertValue,"Issue created Successfully");
                raiseIssuePageObjects.clickCloseButton();
            }
            else raiseIssuePageObjects.clickCloseIcon();
    }

}



