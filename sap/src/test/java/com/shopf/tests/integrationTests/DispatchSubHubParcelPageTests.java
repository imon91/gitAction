package com.shopf.tests.integrationTests;

import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import pageObjects.logistics.Dispatch.*;
import pageObjects.logistics.Receive.*;
import services.responseModels.sapModels.*;
import services.sapMethods.GetSapApiResponses;
import utils.*;

import java.util.*;

public class DispatchSubHubParcelPageTests extends SapBaseClass {

    private WebDriver driver;
    private Random random;

    private DashboardPageObjects dashboardPageObjects;
    private ReceiveModulePageObjects receiveModulePageObjects;
    private ReceiveHubParcelPageObjects receiveHubParcelPageObjects;
    private ReceiveHubParcelPageObjects.BulkModalPageObjects bulkModalPageObjects;
    private DispatchModulePageObjects dispatchModulePageObjects;
    private DispatchModulePageObjects.DispatchSubHubPageObjects dispatchSubHubPageObjects;

    private GetSapApiResponses getSapApiResponses;
    private AreaHubModel areaHubModel;
    private ShopInfoModel shopInfoModel;

    private Map hubDetails,subHubDetails,shopDetails,storeDetails;
    private List<String> motherHub = Arrays.asList("Tejgaon Hub (Mother Hub)","Chittagong Hub");
    private String hubName,subHubName,shopName,storeName,trackingId,parcelHubName;
    private int hubId,subHubId,shopId,storeId,districtId,parcelHubId,uiIndex,apiIndex;
    private int weight,areaId,cash,value,invoiceNumber;
    private String pickupAddress,customerName,customerPhone, deliveryAddress,areaName;

    @BeforeClass(alwaysRun = true)
    public void dispatchSubHubParcelPageTestsBeforeClass() throws Exception {
        System.out.println("Dispatch SubHub Parcel Parcel Page Tests Before Class");
        driver = getBaseDriver();
        random = new Random();

        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveModulePageObjects = new ReceiveModulePageObjects(driver);
        receiveHubParcelPageObjects = new ReceiveHubParcelPageObjects(driver);
        bulkModalPageObjects = receiveHubParcelPageObjects.new BulkModalPageObjects();
        dispatchModulePageObjects = new DispatchModulePageObjects(driver);
        dispatchSubHubPageObjects = dispatchModulePageObjects.new DispatchSubHubPageObjects();

        getSapApiResponses = new GetSapApiResponses("sap");

        hubDetails = getSapApiResponses.getRandomHub();
        hubId = 7;//(int) hubDetails.get("id");
        hubName = "Chittagong Hub";//(String) hubDetails.get("name");

        subHubDetails = getSapApiResponses.getRandomHub(hubId);
        subHubId = 102;//(int) subHubDetails.get("id");
        subHubName = "Miresorai Hub";//(String) subHubDetails.get("name");

        while (true) {
            shopDetails = getSapApiResponses.getRandomShop();
            shopId = (int) shopDetails.get("id");
            shopName = (String) shopDetails.get("name");
            if(getSapApiResponses.shopStoreInfoGetCall(shopId).getBody().size()!=0)
                break;
            else System.out.println("No Store available in " + shopName + "(" + shopId + ")");
        }

        shopInfoModel = getSapApiResponses.shopInfoGetCall(shopId);

        createSingleParcel();

        getSapApiResponses.receiveParcels(Collections.singletonList(trackingId),7,3);

        System.out.println("Navigating to Dispatch Module");

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickDispatchModule();

        dispatchModulePageObjects.enterHubInput(hubName);
        dispatchModulePageObjects.enterDispatchToSubHubInput(subHubName);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    public void setDataForCreateSingleParcel()
    {
        districtId = getSapApiResponses.getRandomDistrict();
        areaHubModel = getSapApiResponses.areaHubListGetCall(districtId);
        int num = random.nextInt(1000)+100;
        int areas = areaHubModel.getAreas().size();
        int area = random.nextInt(areas);
        String[] phone = {"014","88014","+88014"};
        weight = random.nextInt(200000)+1;
        pickupAddress = shopInfoModel.getShops().get(0).getPickupAddress();
        customerName = "Create Parcel " + num;
        customerPhone = phone[random.nextInt(3)] + (random.nextInt(99999999-10000000)+10000000);
        deliveryAddress = "Address,Area,Code";
        areaName = "Mirsarai";areaHubModel.getAreas().get(area).getAreaName();
        areaId = 993;//areaHubModel.getAreas().get(area).getAreaId();
        parcelHubId = areaHubModel.getAreas().get(area).getHubId();
        parcelHubName = getSapApiResponses.getHubName(parcelHubId);
        storeDetails = getSapApiResponses.getRandomStore(shopId);
        storeId = (int) storeDetails.get("id");
        storeName = (String) storeDetails.get("name");
        cash = random.nextInt(10000);
        value = random.nextInt(10000);
        invoiceNumber = random.nextInt(1000000)+100000;
    }

    public void createSingleParcel()
    {
        System.out.println("Creating Single Parcel");
        setDataForCreateSingleParcel();
        Map parcel = new HashMap();
        List<Map> parcels = new ArrayList<>();
        parcel.put("SHOP_ID",shopId);
        parcel.put("SHOP_NAME",shopName);
        parcel.put("WEIGHT",weight);
        parcel.put("PICKUP_ADDRESS",pickupAddress);
        parcel.put("CUSTOMER_NAME",customerName);
        parcel.put("CUSTOMER_PHONE",customerPhone);
        parcel.put("DELIVERY_ADDRESS", deliveryAddress);
        parcel.put("AREA",areaName);
        parcel.put("AREA_ID",areaId);
        parcel.put("CASH",cash);
        parcel.put("VALUE",value);
        parcel.put("INVOICE_NUMBER",invoiceNumber);
        parcel.put("SHOP_STORE_ID",storeId);
        parcels.add(parcel);
        Map createParcelBody = new HashMap();
        createParcelBody.put("parcels",parcels);
        CreateParcelModel createParcelModel = getSapApiResponses.createParcelPostCall(shopId,createParcelBody);

        if(createParcelModel.isIsError()==true)
            createSingleParcel();

        trackingId = createParcelModel.getBody().getTrackingId();
        System.out.println("Tracking Id : " + trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 1100,enabled = false)
    public void verifyParcelsCountValue()
    {
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 1100,enabled = false)
    public void verifyParcelsDetailsValue()
    {
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 1100,enabled = false)
    public void verifyEditAreaFunctionality()
    {
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 1100)
    public void verifyDispatchFunctionality()
    {
        System.out.println("Verifying Dispatch Functionality");
        dispatchSubHubPageObjects.enterScannedCodeInput(trackingId);
        dispatchSubHubPageObjects.clickDispatchButton(1);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 1101)
    public void verifyReceiveFunctionality()
    {
        System.out.println("Verifying Receive Functionality");
        String bulkTransferId = getSapApiResponses.getBulkTransferId(trackingId,hubId,subHubId);
        System.out.println("Bulk Transfer Id : " + bulkTransferId);

        dashboardPageObjects.clickReceiveModule();

        receiveModulePageObjects.enterHubInput(subHubName);
        receiveModulePageObjects.enterMotherHubParcelsInput(hubName);

        uiIndex = receiveHubParcelPageObjects.getIndexOf("unscanned",bulkTransferId);
        receiveHubParcelPageObjects.clickViewParcelsButton(uiIndex);
        bulkModalPageObjects.performScanParcel(trackingId);

        sleep(1000);

        uiIndex = receiveHubParcelPageObjects.getIndexOf("scanned",bulkTransferId);
        System.out.println(uiIndex);
        receiveHubParcelPageObjects.clickSendToSortingButton(uiIndex);
    }

    @AfterClass(alwaysRun = true)
    public void dispatchSubHubParcelPageTestsAfterClass() {
        System.out.println("Dispatch Sub Hub Parcel Page Tests After Class");
        dashboardPageObjects.clickShopUpLogo();
    }
}
