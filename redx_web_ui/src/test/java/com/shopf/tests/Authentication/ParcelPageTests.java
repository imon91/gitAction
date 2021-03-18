package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.ParcelsListModel;
import utils.RedXWebBaseClass;

import java.util.Random;
import java.util.Set;

public class ParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
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
    private String cookie;
    private String parentWindow;
    private String parcelsListGetCallUrl;
    private Random random;
    private int index;
    private long shopId = 648299;

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

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        int page = 1 ,limit = 20 ,offset = 0 ,sort=0;

        parcelsListGetCallUrl = getRedxApiResponse.allParcelsListGetCallUrl(shopId,page,limit,offset,sort);
        allParcelsListModel = getRedxApiResponse.parcelsListModel(parcelsListGetCallUrl);
        actionBarObjects.clickParcelsLink();
        index = parcelPageObjects.getRandomParcelIndex();
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Tracking Id Filter Functionality",
            priority = 2 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Invoice Id Filter Functionality",
            priority = 3 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Phone Number Filter Functionality",
            priority = 4 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Filter Functionality",
            priority = 5 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Creation Date Filter Functionality",
            priority = 6 )
    public void verifyCreationDateFilterFunctionality()
    {
        System.out.println("Verifying Creation Date Filter Functionality");
        String filterIndex = "CREATED_AT";
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Updated Date Filter Functionality",
            priority = 7 )
    public void verifyUpdatedDateFilterFunctionality()
    {
        System.out.println("Verifying Updated Date Filter Functionality");
        String filterIndex = "UPDATED_AT";
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Button Functionality",
            priority = 8 )
    public void verifySearchButtonFunctionality()
    {
        System.out.println("Verifying Search Button Functionality");
        Boolean isEnabled = searchByPageObjects.verifySearchButton();
        Assert.assertEquals(isEnabled,Boolean.FALSE);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Parcel History Button Functionality",
            priority = 9 )
    public void verifyDownloadParcelHistoryButtonFunctionality()
    {
        System.out.println("Verifying Download Parcel History Button Functionality");
        downloadParcelHistoryPageObjects.clickDownloadParcelHistory();
        String modalTitle = downloadParcelHistoryPageObjects.getModalTitle();
        System.out.println("Modal Title : " + modalTitle);
        Assert.assertEquals(modalTitle,"Download Parcel History");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Parcel History Cancel Button Functionality",
            priority = 10 )
    public void verifyDownloadParcelHistoryCancelButtonFunctionality()
    {
        System.out.println("Verifying Download Parcel History Cancel Button Functionality");
        downloadParcelHistoryPageObjects.clickCancelButton();
        //Assert
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Parcel History Functionality",
            priority = 11 )
    public void verifyDownloadParcelHistoryFunctionality()
    {
        System.out.println("Verifying Download Parcel History Functionality");
        driver.get("https://redx.shopups1.xyz/parcel-list/");
        setImplicitWait(10000);
        downloadParcelHistoryPageObjects.clickDownloadParcelHistory();
        downloadParcelHistoryPageObjects.downloadParcelHistory(1,"Jan",2021,1,"Feb",2021, random.nextInt(2)+1, random.nextInt(2),random.nextInt(10));
        //Assert
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Select All Parcels Checkbox Functionality",
            priority = 12 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Select Parcel Functionality",
            priority = 13)
    public void verifySelectParcelFunctionality()
    {
        System.out.println("Verifying Select Parcels Checkbox Functionality");
        int selectedParcels[] = parcelsListPageObjects.clickSelectParcelCheckbox();
        System.out.println("Parcels Selected : " + selectedParcels[1]);
        parcelsListPageObjects.clickUnSelectParcelCheckbox(selectedParcels[0]);
        Assert.assertEquals(selectedParcels[1],1);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Print Labels Functionality",
            priority = 14)
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
                driver.switchTo().window(parentWindow);
                parcelsListPageObjects.clickUnSelectParcelCheckbox( selectedParcels[0]);
            }
        }
        Assert.assertEquals(size,2);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Pages Functionality",
            priority = 15)
    public void verifyPaginationPagesFunctionality()
    {
        System.out.println("Verifying Pagination Pages Functionality");
        if(parcelPageObjects.getTotalParcelsCount()>20)
        {
            int page[] = parcelPageObjects.clickPageIcon();
            Assert.assertEquals(page[1],page[0]);
        } else System.out.println("Pagination Not Found");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Next Page Functionality",
            priority = 16)
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Functionality",
            priority = 17)
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Creation Date Value",
            priority = 18)
    public void verifyCreationDateValue()
    {
        System.out.println("Verifying Creation Date Value");
        String uiValue = parcelsListPageObjects.getCreationDateValue(index);
        String assertValue = allParcelsListModel.getBody().getParcels().get(index-1).getCREATED_AT();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pickup Name Value",
            priority = 19)
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Id Functionality",
            priority = 20)
    public void verifyParcelIdFunctionality()
    {
        System.out.println("Verifying Parcel Id Functionality");
        String parcelId = parcelsListPageObjects.getParcelIdButton(index);
        String assertUrl = "https://redx.shopups1.xyz/track-parcel/?trackingId=" + parcelId + "&shopId=" + shopId;
        System.out.println("Parcel Id : " + parcelId);
        parcelsListPageObjects.clickParcelIdButton(index);
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        actionBarObjects.clickParcelsLink();
        Assert.assertEquals(url,assertUrl);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Id Value",
            priority = 21)
    public void verifyParcelIdValue()
    {
        System.out.println("Verifying Parcel Id Value");
        String uiValue = parcelsListPageObjects.getParcelIdButton(index);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getID();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Id Value",
            priority = 22)
    public void verifyInvoiceIdValue()
    {
        System.out.println("Verifying Invoice Id Value");
        String uiValue = parcelsListPageObjects.getInvoiceId(index,2);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getINVOICE_NUMBER();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Shop Value",
            priority = 23)
    public void verifyShopValue()
    {
        System.out.println("Verifying Shop Value");
        String uiValue = parcelsListPageObjects.getShopNameValue(index);
        String assertValue = actionBarObjects.getShopName();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + assertValue);
        Assert.assertEquals(uiValue.toLowerCase(),assertValue.toLowerCase());
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Value",
            priority = 24)
    public void verifyCustomerNameValue()
    {
        System.out.println("Verifying Customer Name Value");
        String uiValue = parcelsListPageObjects.getCustomerDetailsValue(index,1);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getCUSTOMER_NAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Phone Value",
            priority = 25)
    public void verifyCustomerPhoneValue()
    {
        System.out.println("Verifying Customer Phone Value");
        String uiValue = parcelsListPageObjects.getCustomerDetailsValue(index,2);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getCUSTOMER_PHONE();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Address Value",
            priority = 26)
    public void verifyCustomerAddressValue()
    {
        System.out.println("Verifying Customer Address Value");
        String uiValue = parcelsListPageObjects.getCustomerDetailsValue(index,3);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getDELIVERY_ADDRESS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Area Value",
            priority = 27)
    public void verifyCustomerAreaValue()
    {
        System.out.println("Verifying Customer Area Value");
        String uiValue = parcelsListPageObjects.getCustomerDetailsValue(index,4);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getAREA();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Stauts Value",
            priority = 28)
    public void verifyStatusValue()
    {
        System.out.println("Verifying Status Value");
        String uiValue = parcelsListPageObjects.getLowerCaseStatusValue(index);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getSELLER_STATUS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(apiValue.contains(uiValue),true);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Info Cash Value",
            priority = 29)
    public void verifyPaymentInfoCashValue()
    {
        System.out.println("Verifying Payment Info Cash Value");
        String uiValue = parcelsListPageObjects.getPaymentInfoValue(index,1);
        String apiValue = String.valueOf(allParcelsListModel.getBody().getParcels().get(index-1).getCASH());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Info Charge Value",
            priority = 30)
    public void verifyPaymentInfoChargeValue()
    {
        System.out.println("Verifying Payment Info Charge Value");
        String uiValue = parcelsListPageObjects.getPaymentInfoValue(index,2);
        String apiValue = String.valueOf(allParcelsListModel.getBody().getParcels().get(index-1).getSHOPUP_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Status Value",
            priority = 31)
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Promocode Discount Value",
            priority = 32)
    public void verifyPromocodeDiscountValue()
    {
        System.out.println("Verifying Promocode Discount Value");
        String uiValue = parcelsListPageObjects.getPromoCodeDiscountValue(index);
        String apiValue = String.valueOf(allParcelsListModel.getBody().getParcels().get(index-1).getPromoCodeDiscountAmount());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Delivery Type Value",
            priority = 33)
    public void verifyParcelDeliveryTypeValue()
    {
        System.out.println("Verifying Parcel Delivery Type Value");
        String uiValue = parcelsListPageObjects.getParcelDeliveryTypeValue(index,1);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getPARCEL_DELIVERY_TYPE();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Type Value",
            priority = 34)
    public void verifyParcelTypeValue()
    {
        System.out.println("Verifying Parcel Type Value");
        String uiValue = parcelsListPageObjects.getParcelTypeValue(index);
        String apiValue = allParcelsListModel.getBody().getParcels().get(index-1).getPARCEL_TYPE();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Last Updated Value",
            priority = 35)
    public void verifyLastUpdatedValue()
    {
        System.out.println("Verifying Last Updated Value");
        String uiValue = parcelsListPageObjects.getLastUpdatedValue(index);
        String assertValue = allParcelsListModel.getBody().getParcels().get(index-1).getUPDATED_AT();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Status Filter Functionality",
            priority = 36)
    public void verifyStatusFilterFunctionality()
    {
        System.out.println("Verifying Status Filter Functionality");
        String status = parcelPageObjects.getRandomValue("Parcel Status");
        statusFilterPageObjects.filterByStatus(status);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(getRedxApiResponse.parcelsListStatusFilterGetCallUrl(parcelsListGetCallUrl,status));
        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = parcelsListModel.getBody().getCount();
        System.out.println("Parcels with " + status + " status in UI : " + uiValue);
        System.out.println("Parcels with " + status + " status in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Status Filter Reset Functionality",
            priority = 37)
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


    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Status Filter Functionality",
            priority = 38)
    public void verifyPaymentStatusFilterFunctionality()
    {
        System.out.println("Verifying Payment Status Filter Functionality");
        paymentStatusFilterPageObjects.scrollRight();
        String paymentStatus = parcelPageObjects.getRandomValue("Payment Status");
        paymentStatusFilterPageObjects.filterByStatus(paymentStatus);
        ParcelsListModel parcelsListModel = getRedxApiResponse.parcelsListModel(getRedxApiResponse.parcelsListPaymentStatusFilterGetCallUrl(parcelsListGetCallUrl,paymentStatus));;
        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue =parcelsListModel.getBody().getCount();
        System.out.println("Parcels with " + paymentStatus + " status in UI : " + uiValue);
        System.out.println("Parcels with " + paymentStatus + " status in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Status Filter Reset Functionality",
            priority = 39)
    public void verifyPaymentStatusFilterResetFunctionality()
    {
        System.out.println("Verifying Payment Status Filter Reset Functionality");
        paymentStatusFilterPageObjects.scrollRight();
        paymentStatusFilterPageObjects.clickPaymentStatusFilterDropDown();
        paymentStatusFilterPageObjects.clickResetButton();
        int uiValue = parcelPageObjects.getTotalParcelsCount();
        int apiValue = getRedxApiResponse.parcelsListModel(parcelsListGetCallUrl).getBody().getCount();
        System.out.println("Parcels in UI : " + uiValue);
        System.out.println("Parcels in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Edit Button Functionality",
               priority = 40)
       public void verifyEditButtonFunctionality()
       {
           System.out.println("Verifying Edit Button Functionality");
           sleep(10000);
           statusFilterPageObjects.filterByStatus("Pickup Pending");
           if(parcelPageObjects.getTotalParcelsCount()!=0)
           {
               editParcelPageObjects.clickEditButton(parcelPageObjects.getRandomParcelIndex());
               String modalTitle = editParcelPageObjects.getModalTitle();
               System.out.println("Modal Title : " + modalTitle);
               editParcelPageObjects.clickCloseButton();
               Assert.assertEquals(modalTitle,"Edit Parcel");
           } else System.out.println("No Parcels Found to perform Action");
       }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Edit Cancel Button in Edit Functionality",
               priority = 41)
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

      @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Edit Functionality",
               priority = 42)
       public void verifyEditFunctionality()
       {
           System.out.println("Verifying Edit Functionality");
           if(parcelPageObjects.getTotalParcelsCount()!=0)
           {
               int index = parcelPageObjects.getRandomParcelIndex();
               System.out.println("Index : " + index);
               editParcelPageObjects.clickEditButton(index);
               editParcelPageObjects.editParcel("Edit Name Test");
               String toastMsg = editParcelPageObjects.getToastMsg();
               parcelPageObjects.clickResetButton();
               Assert.assertEquals(toastMsg,"Parcel has been edited successfully");
           } else System.out.println("No Parcels Found to perform Action");
       }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Delete Button Functionality",
            priority = 43)
    public void verifyDeleteButtonFunctionality()
    {
        System.out.println("Verifying Delete Button Functionality");
        statusFilterPageObjects.filterByStatus("Pickup Pending");
        if(parcelPageObjects.getTotalParcelsCount()!=0)
        {
            int index = parcelPageObjects.getRandomParcelIndex();
            System.out.println("Index : " + index);
            deleteParcelPageObjects.clickDeleteButton(index);
            Assert.assertEquals(deleteParcelPageObjects.getPopoverMessageTitle(),"Are you sure?");
        } else System.out.println("No Parcels Found to perform Action");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify No Delete Button Functionality",
            priority = 44)
    public void verifyNoDeleteFunctionality()
    {
        System.out.println("Verifying No Delete Button Functionality");
        if(parcelPageObjects.getTotalParcelsCount()!=0)
        {
            deleteParcelPageObjects.clickNoButton();
        } else System.out.println("No Parcels Found to perform Action");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Delete Functionality",
            priority = 45)
    public void verifyDeleteFunctionality()
    {
        System.out.println("Verifying Delete Functionality");
        if(parcelPageObjects.getTotalParcelsCount()!=0)
        {
            int total = parcelPageObjects.getTotalParcelsCount();
            int index = parcelPageObjects.getRandomParcelIndex();
            System.out.println("Parcel Id : " + parcelsListPageObjects.getParcelIdButton(index));
            deleteParcelPageObjects.clickDeleteButton(index);
            deleteParcelPageObjects.clickYesButton();
            parcelPageObjects.clickResetButton();
            statusFilterPageObjects.filterByStatus("Pickup Pending");
            int parcels = parcelPageObjects.getTotalParcelsCount();
            parcelPageObjects.clickResetButton();
            Assert.assertEquals(parcels,total-1);
        } else System.out.println("No Parcels Found to perform Action");
    }

       @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Exchange Button Functionality",
               priority = 46)
       public void verifyExchangeButtonFunctionality()
       {
           System.out.println("Verifying Exchange Button Functionality");
           driver.get("https://redx.shopups1.xyz/parcel-list/");
           statusFilterPageObjects.filterByStatus("Delivered");
           String parcels = exchangeParcelPageObjects.clickExchangeButton();
           if(!parcels.equalsIgnoreCase("No Parcels Found to perform Action"))
           {
               String modalTitle = exchangeParcelPageObjects.getModalTitle();
               System.out.println("Modal Title : " + modalTitle);
               exchangeParcelPageObjects.clickCloseButton();
               Assert.assertEquals(modalTitle,"Exchange Parcel");
           }
           System.out.println(parcels);
       }

       @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Exchange Cancel Button Functionality",
               priority = 47)
       public void verifyExchangeCancelButtonFunctionality()
       {
           System.out.println("Verifying Exchange Cancel Button Functionality");
           String parcels = exchangeParcelPageObjects.clickExchangeButton();
           if(!parcels.equalsIgnoreCase("No Parcels Found to perform Action"))
           {
               exchangeParcelPageObjects.enterAmount("3000");
               exchangeParcelPageObjects.clickCancelButton();
           }
           System.out.println(parcels);
       }

       @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Exchange Functionality",
               priority = 48)
       public void verifyExchangeFunctionality()
       {
           System.out.println("Verifying Exchange Functionality");
           String parcels = exchangeParcelPageObjects.clickExchangeButton();
           if(!parcels.equalsIgnoreCase("No Parcels Found to perform Action"))
           {
               exchangeParcelPageObjects.exchangeParcel("5000");
//               System.out.println("Toast : " + exchangeParcelPageObjects.getToastMsg());
//               Assert.assertEquals(exchangeParcelPageObjects.getToastMsg(),"Exchange parcel created successfully");
           }
           System.out.println(parcels);
       }

       @Test(  groups = {CoreConstants.GROUP_SANITY},
               description = "Verify Raise Issue Button Functionality",
               priority = 49)
       public void verifyRaiseIssueButtonFunctionality()
       {
           System.out.println("Verifying Raise Issue Button Functionality");
           driver.get("https://redx.shopups1.xyz/parcel-list/");
           raiseIssuePageObjects.clickRaiseIssueButton();
           String modalTitle = raiseIssuePageObjects.getModalTitle();
           String assertValue = "Issue creation for " + raiseIssuePageObjects.getParcelId();
           System.out.println("Modal Title : " + modalTitle);
           raiseIssuePageObjects.clickCloseIcon();
           Assert.assertEquals(modalTitle,assertValue);
       }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Raise Issue Back Button Functionality",
            priority = 50)
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Raise Issue Functionality",
            priority = 51)
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



