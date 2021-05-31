package com.shopf.tests.pagewise;

import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.sapModels.*;
import services.sapMethods.*;
import utils.*;

import java.util.*;

public class ReceiveSellerParcelPageTests extends SapBaseClass {

    private WebDriver driver;
    private Random random;
    private DashboardPageObjects dashboardPageObjects;
    private ReceiveModulePageObjects receiveModulePageObjects;
    private ReceiveModulePageObjects.ReturnedModalPageObjects returnedModalPageObjects;
    private SellerParcelPageObjects sellerParcelPageObjects;
    private SellerParcelPageObjects.CreateParcelPageObjects createParcelPageObjects;
    private GetSapApiResponses getSapApiResponses;
    private AreaHubModel areaHubModel;
    private ShopInfoModel shopInfoModel;
    private ReceiveParcelsListModel receiveParcelsListModel;

    private Map hubDetails,shopDetails,storeDetails;
    private String hubName,shopName,storeName,trackingId,parcelHubName;
    private int hubId,shopId,storeId,districtId,parcelHubId,uiIndex,apiIndex;
    private int weight,areaId,cash,value,invoiceNumber;
    private String pickupAddress,customerName,customerPhone, deliveryAddress,areaName;

    @BeforeClass(alwaysRun = true)
    public void receiveSellerParcelPageTestsBeforeClass() throws Exception {
        System.out.println("Receive Seller Parcel Page Tests Before Class");
        driver = getBaseDriver();
        random = new Random();
        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveModulePageObjects = new ReceiveModulePageObjects(driver);
        sellerParcelPageObjects = new SellerParcelPageObjects(driver);
        returnedModalPageObjects = receiveModulePageObjects.new ReturnedModalPageObjects();
        createParcelPageObjects = sellerParcelPageObjects.new CreateParcelPageObjects();
        getSapApiResponses = new GetSapApiResponses("sap");

        hubDetails = getSapApiResponses.getRandomHub();
        hubId = (int) hubDetails.get("id");
        hubName = (String) hubDetails.get("name");

        shopDetails = getSapApiResponses.getRandomShop();
        shopId = (int) shopDetails.get("id");
        shopName = (String) shopDetails.get("name");

        shopInfoModel = getSapApiResponses.shopInfoGetCall(shopId);

        createSingleParcel();

        receiveParcelsListModel = getSapApiResponses.getParcelsReceiveHub(shopId);

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickReceiveModule();

        receiveModulePageObjects.enterHubInput(hubName);
        receiveModulePageObjects.viewSellerParcels(shopName,shopId);

        uiIndex = sellerParcelPageObjects.getIndex("unscanned",trackingId);
        apiIndex = receiveParcelsListModel.getIndex(receiveParcelsListModel,trackingId);
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
        String[] phone = {"01","8801","+8801"};
        weight = random.nextInt(200000)+1;
        pickupAddress = shopInfoModel.getShops().get(0).getPickupAddress();
        customerName = "Create Parcel " + num;
        customerPhone = phone[random.nextInt(3)] + (random.nextInt(999999999-100000000)+100000000);
        deliveryAddress = "Address,Area,Code";
        areaName = areaHubModel.getAreas().get(area).getAreaName();
        areaId = areaHubModel.getAreas().get(area).getAreaId();
        parcelHubId = areaHubModel.getAreas().get(area).getHubId();
        parcelHubName = getSapApiResponses.getHubName(hubId);
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
        trackingId = createParcelModel.getBody().getTrackingId();
        System.out.println("Tracking Id : " + trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 150)
    public void verifyUnscannedParcelDetailsValue()
    {
        System.out.println("Verifying Unscanned Parcel Details Value");
        String phoneValue = sellerParcelPageObjects.getParcelPhoneValue("unscanned", uiIndex);
        System.out.println("Phone Value : " + phoneValue);
        String customerNameValue = sellerParcelPageObjects.getCustomerNameValue("unscanned", uiIndex);
        System.out.println("Customer Name Value : " + customerNameValue);
        String cashValue = sellerParcelPageObjects.getCashValue("unscanned", uiIndex);
        System.out.println("Cash Value : " + cashValue);
        String addressValue = sellerParcelPageObjects.getAddressValue("unscanned", uiIndex);
        System.out.println("Address Value : " + addressValue);
        String invoiceValue = sellerParcelPageObjects.getInvoiceIdValue("unscanned", uiIndex);
        System.out.println("Invoice Value : " + invoiceValue);
        String createdDateValue = sellerParcelPageObjects.getCreatedDateValue("unscanned", uiIndex);
        System.out.println("Created Date Value : " + createdDateValue);
        String areaValue = sellerParcelPageObjects.getAreaValue("unscanned", uiIndex);
        System.out.println("Area Value : " + areaValue);
        String partnerValue = sellerParcelPageObjects.getPartnerValue("unscanned", uiIndex);
        System.out.println("Partner Value : " + partnerValue);
        String weightValue = sellerParcelPageObjects.getWeightValue("unscanned", uiIndex);
        System.out.println("Weight Value : " + weightValue);
        String hubValue = sellerParcelPageObjects.getHubValue("unscanned", uiIndex);
        System.out.println("Hub Value : " + hubValue);

        Assert.assertEquals(phoneValue,receiveParcelsListModel.getParcels().get(apiIndex).getCustomerPhone(),"Customer Phone Mismatch");
        Assert.assertEquals(customerNameValue,receiveParcelsListModel.getParcels().get(apiIndex).getCustomerName(),"Customer Name Mismatch");
        Assert.assertEquals(Integer.parseInt(cashValue),receiveParcelsListModel.getParcels().get(apiIndex).getCash(),"Cash Value Mismatch");
        Assert.assertEquals(addressValue,receiveParcelsListModel.getParcels().get(apiIndex).getDeliveryAddress(),"Delivery Address Mismatch");
        Assert.assertEquals(invoiceValue,receiveParcelsListModel.getParcels().get(apiIndex).getInvoiceNumber(),"Invoice Number Mismatch");
//        Assert.assertEquals(createdDateValue,receiveParcelsListModel.getParcels().get(apiIndex).getCreatedAt(),"Created Date Mismatch");
        Assert.assertEquals(areaValue,receiveParcelsListModel.getParcels().get(apiIndex).getArea(),"Area Name Mismatch");
//        Assert.assertEquals(partnerValue,receiveParcelsListModel.getParcels().get(apiIndex).getPartnerName(),"Partner Name Mismatch");
        Assert.assertEquals(Integer.parseInt(weightValue),receiveParcelsListModel.getParcels().get(apiIndex).getWeight(),"Weight Value Mismatch");
        Assert.assertEquals(hubValue,receiveParcelsListModel.getParcels().get(apiIndex).getHubName(),"Hub Name Mismatch");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 151)
    public void verifyPrintButtonFunctionality()
    {
        System.out.println("Verifying Print Button Functionality");
        sellerParcelPageObjects.clickPrintButton(uiIndex);
        String uiValue = sellerParcelPageObjects.getTrackingIdValue("scanned",1);
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 152)
    public void verifyMoveButtonFunctionality()
    {
        System.out.println("Verifying Move Button Functionality");
        sellerParcelPageObjects.clickMoveButton(1);
        String uiValue = sellerParcelPageObjects.getTrackingIdValue("unscanned", uiIndex);
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 153)
    public void verifyPhoneSearchFunctionality()
    {
        System.out.println("Verifying Phone Search Functionality");
        Boolean isScanned = sellerParcelPageObjects.enterPhoneSearchInput(customerPhone);
        String uiValue;
        if(isScanned)
        {
            uiValue = sellerParcelPageObjects.getParcelPhoneValue("scanned",1);
            sellerParcelPageObjects.clickMoveButton(1);
        } else {
            int index = sellerParcelPageObjects.getIndex("unscanned",trackingId);
            uiValue = sellerParcelPageObjects.getParcelPhoneValue("unscanned",index);
        }
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,customerPhone);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 154)
    public void verifyInvoiceIdSearchFunctionality()
    {
        System.out.println("Verifying Invoice Id Search Functionality");
        sellerParcelPageObjects.enterInvoiceIdSearchInput(String.valueOf(invoiceNumber),trackingId);
        String uiValue = sellerParcelPageObjects.getTrackingIdValue("scanned",1);
        sellerParcelPageObjects.clickMoveButton(1);
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 155)
    public void verifyEditAreaFunctionalityInUnscannedSection()
    {
        System.out.println("Verifying Edit Area Functionality In Unscanned Section");
        districtId = getSapApiResponses.getRandomDistrict();
        areaHubModel = getSapApiResponses.areaHubListGetCall(districtId);
        int areas = areaHubModel.getAreas().size();
        int area = random.nextInt(areas);
        areaName = areaHubModel.getAreas().get(area).getAreaName();
        sellerParcelPageObjects.enterAreaInput("unscanned",uiIndex,areaName);
        String areaValue = sellerParcelPageObjects.getAreaValue("unscanned",uiIndex);
        String hub = getSapApiResponses.getHubName(areaHubModel.getAreas().get(area).getHubId());
        String hubValue = sellerParcelPageObjects.getHubValue("unscanned",uiIndex);
        System.out.println("Area Value in UI: " + areaValue);
        System.out.println("Hub Value in UI : " + hubValue);
        Assert.assertEquals(areaValue,areaName,"Area Value Mismatch");
        Assert.assertEquals(hubValue,hub,"Hub Value Mismatch");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 156)
    public void verifyEditPartnerFunctionalityInUnscannedSection()
    {
        System.out.println("Verifying Edit Partner Functionality In Unscanned Section");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 157)
    public void verifyEditWeightFunctionalityInUnscannedSection()
    {
        System.out.println("Verifying Edit Weight Functionality In Unscanned Section");
        weight = random.nextInt(200000)+1;
        sellerParcelPageObjects.enterWeightInput("unscanned",uiIndex,weight);
        String weightValue = sellerParcelPageObjects.getWeightValue("unscanned",uiIndex);
        System.out.println("Value in Ui : " + weightValue);
        Assert.assertEquals(weightValue,String.valueOf(weight));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 158)
    public void verifyScannedCodeFunctionality()
    {
        System.out.println("Verifying Scanned Code Functionality");
        sellerParcelPageObjects.enterScanCodeInput(trackingId);
        String uiValue = sellerParcelPageObjects.getTrackingIdValue("scanned",1);
        System.out.println("Value in Ui : " + uiValue);
        sellerParcelPageObjects.clickMoveButton(1);
        Assert.assertEquals(uiValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 159)
    public void verifyReturnedButtonFunctionality()
    {
        System.out.println("Verifying Returned Button Functionality");
        int count1 = Integer.parseInt(sellerParcelPageObjects.getParcelsCount());
        System.out.println("Parcels Count : " + count1);
        sellerParcelPageObjects.clickReturnButton("unscanned",uiIndex);
        returnedModalPageObjects.performReturned();
        int count2 = Integer.parseInt(sellerParcelPageObjects.getParcelsCount());
        System.out.println("Parcels Count After Returned: " + count2);
        Assert.assertEquals(count2,count1-1);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 160)
    public void verifyCreateParcelFunctionality()
    {
        System.out.println("Verifying Create Parcel Functionality");
        setDataForCreateSingleParcel();

        createParcelPageObjects.createParcel(storeName,customerName,customerPhone,deliveryAddress,areaName,String.valueOf(weight),String.valueOf(cash),String.valueOf(value),String.valueOf(invoiceNumber));
        String uiValue = sellerParcelPageObjects.getTrackingIdValue("scanned",1);
        System.out.println("Value in Ui : " + uiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 161)
    public void verifyScannedParcelDetailsValue()
    {
        System.out.println("Verifying Scanned Parcel Details Value");

        String phoneValue = sellerParcelPageObjects.getParcelPhoneValue("scanned", 1);
        System.out.println("Phone Value : " + phoneValue);
        String customerNameValue = sellerParcelPageObjects.getCustomerNameValue("scanned", 1);
        System.out.println("Customer Name Value : " + customerNameValue);
        String cashValue = sellerParcelPageObjects.getCashValue("scanned", 1);
        System.out.println("Cash Value : " + cashValue);
        String addressValue = sellerParcelPageObjects.getAddressValue("scanned", 1);
        System.out.println("Address Value : " + addressValue);
        String areaValue = sellerParcelPageObjects.getAreaValue("scanned", 1);
        System.out.println("Area Value : " + areaValue);
        String partnerValue = sellerParcelPageObjects.getPartnerValue("scanned", 1);
        System.out.println("Partner Value : " + partnerValue);
        String hubValue = sellerParcelPageObjects.getHubValue("scanned", 1);
        System.out.println("Hub Value : " + hubValue);

        Assert.assertEquals(phoneValue,customerPhone,"Customer Phone Mismatch");
        Assert.assertEquals(customerNameValue,customerName,"Customer Name Mismatch");
        Assert.assertEquals(Integer.parseInt(cashValue),cash,"Cash Value Mismatch");
        Assert.assertEquals(addressValue,deliveryAddress,"Delivery Address Mismatch");
        Assert.assertEquals(areaValue,areaName,"Area Name Mismatch");
//        Assert.assertEquals(partnerValue,receiveParcelsListModel.getParcels().get(apiIndex).getPartnerName(),"Partner Name Mismatch");
        Assert.assertEquals(hubValue,parcelHubName,"Hub Name Mismatch");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 162)
    public void verifyEditAreaFunctionalityInScannedSection()
    {
        System.out.println("Verifying Edit Area Functionality In Scanned Section");
        districtId = getSapApiResponses.getRandomDistrict();
        areaHubModel = getSapApiResponses.areaHubListGetCall(districtId);
        int areas = areaHubModel.getAreas().size();
        int area = random.nextInt(areas);
        areaName = areaHubModel.getAreas().get(area).getAreaName();
        sellerParcelPageObjects.enterAreaInput("scanned",1,areaName);
        String areaValue = sellerParcelPageObjects.getAreaValue("scanned",1);
        String hub = getSapApiResponses.getHubName(areaHubModel.getAreas().get(area).getHubId());
        String hubValue = sellerParcelPageObjects.getHubValue("scanned",1);
        System.out.println("Area Value in UI: " + areaValue);
        System.out.println("Hub Value in UI : " + hubValue);
        Assert.assertEquals(areaValue,areaName,"Area Value Mismatch");
//        Assert.assertEquals(hubValue,hub,"Hub Value Mismatch");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 163)
    public void verifyEditPartnerFunctionalityInScannedSection()
    {
        System.out.println("Verifying Edit Partner Functionality In Scanned Section");
    }
}
