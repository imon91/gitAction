package com.shopf.tests.pagewise;

import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import pageObjects.logistics.Receive.ReceiveModulePageObjects;
import pageObjects.logistics.Receive.ReceiveSellerParcelPageObjects;
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
    private ReceiveSellerParcelPageObjects receiveSellerParcelPageObjects;
    private ReceiveSellerParcelPageObjects.MotherHubScannedParcelPageObjects motherHubScannedParcelPageObjects;
    private ReceiveSellerParcelPageObjects.CreateParcelPageObjects createParcelPageObjects;
    private GetSapApiResponses getSapApiResponses;
    private AreaHubModel areaHubModel;
    private ShopInfoModel shopInfoModel;
    private ReceiveParcelsListModel receiveParcelsListModel;

    private Map hubDetails,shopDetails,storeDetails;
    private List<String> motherHub = Arrays.asList("Tejgaon Hub (Mother Hub)","Chittagong Hub");
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
        receiveSellerParcelPageObjects = new ReceiveSellerParcelPageObjects(driver);
        returnedModalPageObjects = receiveModulePageObjects.new ReturnedModalPageObjects();
        motherHubScannedParcelPageObjects = receiveSellerParcelPageObjects.new MotherHubScannedParcelPageObjects();
        createParcelPageObjects = receiveSellerParcelPageObjects.new CreateParcelPageObjects();
        getSapApiResponses = new GetSapApiResponses("sap");

        hubDetails = getSapApiResponses.getRandomHub();
        hubId = (int) hubDetails.get("id");
        hubName = (String) hubDetails.get("name");

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

        receiveParcelsListModel = getSapApiResponses.getParcelsReceiveHub(shopId);

        System.out.println("Navigating to Receive Seller Parcels Page");

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickReceiveModule();

        receiveModulePageObjects.enterHubInput(hubName);
        receiveModulePageObjects.viewSellerParcels(shopName,shopId);

        uiIndex = receiveSellerParcelPageObjects.getIndex("unscanned",trackingId);
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
        String[] phone = {"014","88014","+88014"};
        weight = random.nextInt(200000)+1;
        pickupAddress = shopInfoModel.getShops().get(0).getPickupAddress();
        customerName = "Create Parcel " + num;
        customerPhone = phone[random.nextInt(3)] + (random.nextInt(99999999-10000000)+10000000);
        deliveryAddress = "Address,Area,Code";
        areaName = areaHubModel.getAreas().get(area).getAreaName();
        areaId = areaHubModel.getAreas().get(area).getAreaId();
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

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 150)
    public void verifyUnscannedParcelDetailsValue()
    {
        System.out.println("Verifying Unscanned Parcel Details Value");
        String phoneValue = receiveSellerParcelPageObjects.getParcelPhoneValue("unscanned", uiIndex);
        System.out.println("Phone Value : " + phoneValue);
        String customerNameValue = receiveSellerParcelPageObjects.getCustomerNameValue("unscanned", uiIndex);
        System.out.println("Customer Name Value : " + customerNameValue);
        String cashValue = receiveSellerParcelPageObjects.getCashValue("unscanned", uiIndex);
        System.out.println("Cash Value : " + cashValue);
        String addressValue = receiveSellerParcelPageObjects.getAddressValue("unscanned", uiIndex);
        System.out.println("Address Value : " + addressValue);
        String invoiceValue = receiveSellerParcelPageObjects.getInvoiceIdValue("unscanned", uiIndex);
        System.out.println("Invoice Value : " + invoiceValue);
        String createdDateValue = receiveSellerParcelPageObjects.getCreatedDateValue("unscanned", uiIndex);
        System.out.println("Created Date Value : " + createdDateValue);
        String areaValue = receiveSellerParcelPageObjects.getAreaValue("unscanned", uiIndex);
        System.out.println("Area Value : " + areaValue);
        String partnerValue = receiveSellerParcelPageObjects.getPartnerValue("unscanned", uiIndex);
        System.out.println("Partner Value : " + partnerValue);
        String weightValue = receiveSellerParcelPageObjects.getWeightValue("unscanned", uiIndex);
        System.out.println("Weight Value : " + weightValue);
        String hubValue = receiveSellerParcelPageObjects.getHubValue("unscanned", uiIndex);
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
        String uiValue;
        receiveSellerParcelPageObjects.clickPrintButton(uiIndex);
        if(motherHub.contains(hubName)) {
            int parcelCount = Integer.parseInt(motherHubScannedParcelPageObjects.getScannedParcelCountValue(2));
            System.out.println("Parcel Count : " + parcelCount);
            motherHubScannedParcelPageObjects.clickViewParcelsButton(2);
            uiValue = motherHubScannedParcelPageObjects.getTrackingIdValue(1);
            Assert.assertTrue(parcelCount>=1);
        } else
            uiValue = receiveSellerParcelPageObjects.getTrackingIdValue("scanned",1);
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 152)
    public void verifyMoveButtonFunctionality()
    {
        System.out.println("Verifying Move Button Functionality");
        if(motherHub.contains(hubName))
            motherHubScannedParcelPageObjects.clickMoveButton(1);
        else receiveSellerParcelPageObjects.clickMoveButton(1);
        String uiValue = receiveSellerParcelPageObjects.getTrackingIdValue("unscanned", uiIndex);
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 153)
    public void verifyPhoneSearchFunctionality()
    {
        System.out.println("Verifying Phone Search Functionality");
        Boolean isScanned = receiveSellerParcelPageObjects.enterPhoneSearchInput(customerPhone);
        String uiValue;
        if(isScanned) {
            if(motherHub.contains(hubName)) {
                motherHubScannedParcelPageObjects.clickViewParcelsButton(2);
                uiValue = motherHubScannedParcelPageObjects.getParcelPhoneValue(1);
                motherHubScannedParcelPageObjects.clickMoveButton(1);
            } else {
                uiValue = receiveSellerParcelPageObjects.getParcelPhoneValue("scanned", 1);
                receiveSellerParcelPageObjects.clickMoveButton(1); }
        } else {
            int index = receiveSellerParcelPageObjects.getIndex("unscanned",trackingId);
            uiValue = receiveSellerParcelPageObjects.getParcelPhoneValue("unscanned",index);
        }
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,customerPhone);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 154)
    public void verifyInvoiceIdSearchFunctionality()
    {
        System.out.println("Verifying Invoice Id Search Functionality");
        String uiValue;
        if(motherHub.contains(hubName)) {
            receiveSellerParcelPageObjects.enterScanInvoiceNumberInput(String.valueOf(invoiceNumber));
            motherHubScannedParcelPageObjects.clickViewParcelsButton(2);
            uiValue = motherHubScannedParcelPageObjects.getTrackingIdValue(1);
            motherHubScannedParcelPageObjects.clickMoveButton(1);
        } else {
            receiveSellerParcelPageObjects.enterInvoiceIdSearchInput(String.valueOf(invoiceNumber),trackingId);
            uiValue = receiveSellerParcelPageObjects.getTrackingIdValue("scanned",1);
            receiveSellerParcelPageObjects.clickMoveButton(1); }
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
        receiveSellerParcelPageObjects.enterAreaInput("unscanned",uiIndex,areaName);
        String areaValue = receiveSellerParcelPageObjects.getAreaValue("unscanned",uiIndex);
        String hub = getSapApiResponses.getHubName(areaHubModel.getAreas().get(area).getHubId());
        String hubValue = receiveSellerParcelPageObjects.getHubValue("unscanned",uiIndex);
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
        receiveSellerParcelPageObjects.enterWeightInput("unscanned",uiIndex,weight);
        String weightValue = receiveSellerParcelPageObjects.getWeightValue("unscanned",uiIndex);
        System.out.println("Value in Ui : " + weightValue);
        Assert.assertEquals(weightValue,String.valueOf(weight));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 158)
    public void verifyScannedCodeFunctionality()
    {
        System.out.println("Verifying Scanned Code Functionality");
        String uiValue;
        if(motherHub.contains(hubName)) {
            receiveSellerParcelPageObjects.enterScannedParcelIdInput(trackingId);
            int parcelCount = Integer.parseInt(motherHubScannedParcelPageObjects.getScannedParcelCountValue(2));
            System.out.println("Parcel Count : " + parcelCount);
            motherHubScannedParcelPageObjects.clickViewParcelsButton(2);
            uiValue = motherHubScannedParcelPageObjects.getTrackingIdValue(1);
            motherHubScannedParcelPageObjects.clickMoveButton(1);
            Assert.assertTrue(parcelCount>=1);
        } else {
            receiveSellerParcelPageObjects.enterScanCodeInput(trackingId);
            uiValue = receiveSellerParcelPageObjects.getTrackingIdValue("scanned", 1);
            receiveSellerParcelPageObjects.clickMoveButton(1); }
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 159)
    public void verifyReturnedButtonFunctionality()
    {
        System.out.println("Verifying Returned Button Functionality");
        int count1 = Integer.parseInt(receiveSellerParcelPageObjects.getParcelsCount());
        System.out.println("Parcels Count : " + count1);
        receiveSellerParcelPageObjects.clickReturnButton("unscanned",uiIndex);
        returnedModalPageObjects.performReturned();
        int count2 = Integer.parseInt(receiveSellerParcelPageObjects.getParcelsCount());
        System.out.println("Parcels Count After Returned: " + count2);
        Assert.assertEquals(count2,count1-1);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 160)
    public void verifyCreateParcelFunctionality()
    {
        System.out.println("Verifying Create Parcel Functionality");
        String uiValue;
        setDataForCreateSingleParcel();

        createParcelPageObjects.createParcel(storeName,customerName,customerPhone,deliveryAddress,areaName,String.valueOf(weight),String.valueOf(cash),String.valueOf(value),String.valueOf(invoiceNumber));
        if(motherHub.contains(hubName)) {
            motherHubScannedParcelPageObjects.clickViewParcelsButton(2);
            uiValue = motherHubScannedParcelPageObjects.getTrackingIdValue(1);
        } else {
            uiValue = receiveSellerParcelPageObjects.getTrackingIdValue("scanned",1);
        }
        System.out.println("Value in Ui : " + uiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 161)
    public void verifyScannedParcelDetailsValue()
    {
        System.out.println("Verifying Scanned Parcel Details Value");

        String phoneValue,customerNameValue,cashValue,addressValue,areaValue,partnerValue,hubValue;

        if(motherHub.contains(hubName)) {
            phoneValue = motherHubScannedParcelPageObjects.getParcelPhoneValue(1);
            customerNameValue = motherHubScannedParcelPageObjects.getCustomerNameValue(1);
            cashValue = motherHubScannedParcelPageObjects.getCashValue(1);
            addressValue = motherHubScannedParcelPageObjects.getAddressValue(1);
            areaValue = motherHubScannedParcelPageObjects.getAreaValue(1);
            partnerValue = motherHubScannedParcelPageObjects.getPartnerValue(1);
            hubValue = motherHubScannedParcelPageObjects.getHubValue(1);
        } else {
            phoneValue = receiveSellerParcelPageObjects.getParcelPhoneValue("scanned", 1);
            customerNameValue = receiveSellerParcelPageObjects.getCustomerNameValue("scanned", 1);
            cashValue = receiveSellerParcelPageObjects.getCashValue("scanned", 1);
            addressValue = receiveSellerParcelPageObjects.getAddressValue("scanned", 1);
            areaValue = receiveSellerParcelPageObjects.getAreaValue("scanned", 1);
            partnerValue = receiveSellerParcelPageObjects.getPartnerValue("scanned", 1);
            hubValue = receiveSellerParcelPageObjects.getHubValue("scanned", 1); }

        System.out.println("Phone Value : " + phoneValue);
        System.out.println("Customer Name Value : " + customerNameValue);
        System.out.println("Cash Value : " + cashValue);
        System.out.println("Address Value : " + addressValue);
        System.out.println("Area Value : " + areaValue);
        System.out.println("Partner Value : " + partnerValue);
        System.out.println("Hub Value : " + hubValue);

//        Assert.assertEquals(phoneValue,customerPhone,"Customer Phone Mismatch");
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
        String areaValue,hub;

        if(motherHub.contains(hubName)) {
            motherHubScannedParcelPageObjects.enterAreaInput(1,areaName);
            areaValue = motherHubScannedParcelPageObjects.getAreaValue(1);
            parcelHubName = motherHubScannedParcelPageObjects.getHubValue(1);
        } else {
            receiveSellerParcelPageObjects.enterAreaInput("scanned",1,areaName);
            areaValue = receiveSellerParcelPageObjects.getAreaValue("scanned",1);
            parcelHubName = receiveSellerParcelPageObjects.getHubValue("scanned",1);
        }

        hub = getSapApiResponses.getHubName(areaHubModel.getAreas().get(area).getHubId());

        System.out.println("Area Value in UI: " + areaValue);
        System.out.println("Hub Value in UI : " + parcelHubName);

        Assert.assertEquals(areaValue,areaName,"Area Value Mismatch");
        Assert.assertEquals(parcelHubName,hub,"Hub Value Mismatch");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 163)
    public void verifyEditPartnerFunctionalityInScannedSection()
    {
        System.out.println("Verifying Edit Partner Functionality In Scanned Section");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 164)
    public void verifyScannedParcelDetailsAfterReloadPage()
    {
        System.out.println("Verifying Scanned Parcel Details After Reload Page");

        driver.navigate().refresh();

        String phoneValue,customerNameValue,cashValue,addressValue,areaValue,partnerValue,hubValue;

        if(motherHub.contains(hubName)) {
            sleep(2000);
            motherHubScannedParcelPageObjects.clickViewParcelsButton(2);
            phoneValue = motherHubScannedParcelPageObjects.getParcelPhoneValue(1);
            customerNameValue = motherHubScannedParcelPageObjects.getCustomerNameValue(1);
            cashValue = motherHubScannedParcelPageObjects.getCashValue(1);
            addressValue = motherHubScannedParcelPageObjects.getAddressValue(1);
            areaValue = motherHubScannedParcelPageObjects.getAreaValue(1);
            partnerValue = motherHubScannedParcelPageObjects.getPartnerValue(1);
            hubValue = motherHubScannedParcelPageObjects.getHubValue(1);
        } else {
            new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            sleep(2000);
            phoneValue = receiveSellerParcelPageObjects.getParcelPhoneValue("scanned", 1);
            customerNameValue = receiveSellerParcelPageObjects.getCustomerNameValue("scanned", 1);
            cashValue = receiveSellerParcelPageObjects.getCashValue("scanned", 1);
            addressValue = receiveSellerParcelPageObjects.getAddressValue("scanned", 1);
            areaValue = receiveSellerParcelPageObjects.getAreaValue("scanned", 1);
            partnerValue = receiveSellerParcelPageObjects.getPartnerValue("scanned", 1);
            hubValue = receiveSellerParcelPageObjects.getHubValue("scanned", 1); }

        System.out.println("Phone Value : " + phoneValue);
        System.out.println("Customer Name Value : " + customerNameValue);
        System.out.println("Cash Value : " + cashValue);
        System.out.println("Address Value : " + addressValue);
        System.out.println("Area Value : " + areaValue);
        System.out.println("Partner Value : " + partnerValue);
        System.out.println("Hub Value : " + hubValue);

        Assert.assertTrue(customerPhone.contains(phoneValue),"Customer Phone Mismatch");
        Assert.assertEquals(customerNameValue,customerName,"Customer Name Mismatch");
        Assert.assertEquals(Integer.parseInt(cashValue),cash,"Cash Value Mismatch");
        Assert.assertEquals(addressValue,deliveryAddress,"Delivery Address Mismatch");
        Assert.assertEquals(areaValue,areaName,"Area Name Mismatch");
//        Assert.assertEquals(partnerValue,receiveParcelsListModel.getParcels().get(apiIndex).getPartnerName(),"Partner Name Mismatch");
        Assert.assertEquals(hubValue,parcelHubName,"Hub Name Mismatch");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 165)
    public void verifySentToSortingButtonFunctionality()
    {
        System.out.println("Verifying Send To Sorting Button Functionality");
        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
        int count1 = Integer.parseInt(receiveSellerParcelPageObjects.getParcelsCount());
        if(motherHub.contains(hubName))
            motherHubScannedParcelPageObjects.clickSendToSortingButton(2);
        else receiveSellerParcelPageObjects.clickSendToSorting();
        int count2 = Integer.parseInt(receiveSellerParcelPageObjects.getParcelsCount());
        Assert.assertEquals(count2,count1-1);
    }
}
