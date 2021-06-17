package com.shopf.tests.pagewise;

import coreUtils.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import pageObjects.logistics.Receive.ReceiveDeliveryAgentsParcelPageObjects;
import pageObjects.logistics.Receive.ReceiveModulePageObjects;
import services.responseModels.sapModels.*;
import services.sapMethods.GetSapApiResponses;
import utils.*;

import java.util.*;

public class ReceiveDeliveryAgentsParcelPageTests extends SapBaseClass {

    private WebDriver driver;
    private DashboardPageObjects dashboardPageObjects;
    private ReceiveModulePageObjects receiveModulePageObjects;

    private ReceiveDeliveryAgentsParcelPageObjects receiveDeliveryAgentsParcelPageObjects;
    private ReceiveDeliveryAgentsParcelPageObjects.ParcelDetailsPageObjects parcelDetailsPageObjects;
    private ReceiveDeliveryAgentsParcelPageObjects.HoldModalPageObjects holdModalPageObjects;
    private ReceiveDeliveryAgentsParcelPageObjects.AreaChangeModalPageObjects areaChangeModalPageObjects;
    private ReceiveDeliveryAgentsParcelPageObjects.ReturnedModalPageObjects returnedModalPageObjects;
    private ReceiveDeliveryAgentsParcelPageObjects.DeliveredModalPageObjects deliveredModalPageObjects;
    private ReceiveDeliveryAgentsParcelPageObjects.ExchangeModalPageObjects exchangeModalPageObjects;
    private ReceiveDeliveryAgentsParcelPageObjects.PartialModalPageObjects partialModalPageObjects;
    private ReceiveDeliveryAgentsParcelPageObjects.RaiseIssueModalPageObjects raiseIssueModalPageObjects;

    private GetSapApiResponses getSapApiResponses;
    private ShopInfoModel shopInfoModel;
    private ReceiveDeliveryAgentsParcelListModel receiveDeliveryAgentsParcelListModel;

    private Random random;
    private Map hubDetails,shopDetails,storeDetails,agentDetails;
    private List<String> motherHub = Arrays.asList("Tejgaon Hub (Mother Hub)","Chittagong Hub");
    private List<String> trackingIds = new ArrayList<>();
    private String hubName,shopName,storeName,deliveryAgentName,trackingId,agentType = "delivery";
    private int hubId,shopId,storeId,deliveryAgentId,uiIndex,apiIndex,parcelsCount=0,count = 7;
    private int weight,areaId,cash,value,invoiceNumber;
    private Boolean isCtAgent=false,isCashZero = false;
    private int[] assignedParcels,deliveredParcels,problematicParcels;
    private String pickupAddress,customerName,customerPhone, deliveryAddress,areaName,changeAreaName,changeAreaHubName;

    @BeforeClass(alwaysRun = true)
    public void receiveDeliveryAgentsParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Receive Delivery Agents Parcel Page Tests Before Class");
        driver = getBaseDriver();
        random = new Random();

        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveModulePageObjects = new ReceiveModulePageObjects(driver);
        receiveDeliveryAgentsParcelPageObjects = new ReceiveDeliveryAgentsParcelPageObjects(driver);
        parcelDetailsPageObjects = receiveDeliveryAgentsParcelPageObjects.new ParcelDetailsPageObjects();
        holdModalPageObjects = receiveDeliveryAgentsParcelPageObjects.new HoldModalPageObjects();
        areaChangeModalPageObjects = receiveDeliveryAgentsParcelPageObjects.new AreaChangeModalPageObjects();
        returnedModalPageObjects = receiveDeliveryAgentsParcelPageObjects.new ReturnedModalPageObjects();
        deliveredModalPageObjects = receiveDeliveryAgentsParcelPageObjects.new DeliveredModalPageObjects();
        exchangeModalPageObjects = receiveDeliveryAgentsParcelPageObjects.new ExchangeModalPageObjects();
        partialModalPageObjects = receiveDeliveryAgentsParcelPageObjects.new PartialModalPageObjects();
        raiseIssueModalPageObjects = receiveDeliveryAgentsParcelPageObjects.new RaiseIssueModalPageObjects();

        getSapApiResponses = new GetSapApiResponses("sap");

        setDataForDeliveryAgentTests();

        System.out.println("Navigating to Receive Delivery Agents Page");

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickReceiveModule();
        receiveModulePageObjects.enterHubInput(hubName);
        driver.navigate().refresh();
        receiveModulePageObjects.chooseDeliveryAgent(deliveryAgentName);

        receiveDeliveryAgentsParcelListModel = getSapApiResponses.deliveryAgentProblematicParcelsListGetCall(deliveryAgentId);

        assignedParcels = receiveDeliveryAgentsParcelPageObjects.getAssignedParcelsValue();
        deliveredParcels = receiveDeliveryAgentsParcelPageObjects.getDeliveredParcelsValue();
        problematicParcels = receiveDeliveryAgentsParcelPageObjects.getProblematicParcelsValue();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    public void setDataForCreateSingleParcel() {
        parcelsCount++;
        int num = random.nextInt(1000)+100;
        String[] phone = {"014","88014","+88014"};
        weight = random.nextInt(200000)+1;
        customerName = "Create Parcel " + num;
        customerPhone = phone[random.nextInt(3)] + (random.nextInt(99999999-10000000)+10000000);
        deliveryAddress = "Address,Area,Code";
        if(isCashZero)
            cash=0;
        else cash = random.nextInt(10000)+1;
        isCashZero=false;
        value = random.nextInt(10000);
        invoiceNumber = random.nextInt(1000000)+100000;
    }

    public String createSingleParcel() {
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

        if (parcelsCount>10){
            System.out.println("Error in Creating Parcel");
            return null;
        }

        if(createParcelModel.isIsError()==true)
            createSingleParcel();

        trackingId = createParcelModel.getBody().getTrackingId();
        System.out.println("Tracking Id : " + trackingId);
        return trackingId;
    }

    public void setDataForDeliveryAgentTests() {
        while (true) {
            shopDetails = getSapApiResponses.getRandomShop();
            shopId = (int) shopDetails.get("id");
            shopName = (String) shopDetails.get("name");
            if(getSapApiResponses.shopStoreInfoGetCall(shopId).getBody().size()!=0)
                break;
            else System.out.println("No Store available in " + shopName + "(" + shopId + ")");
        }
        storeDetails = getSapApiResponses.getRandomStoreWithArea(shopId);
        storeId = (int) storeDetails.get("storeId");
        storeName = (String) storeDetails.get("storeName");
        areaId = (int) storeDetails.get("areaId");
        areaName = (String) storeDetails.get("areaName");

        hubDetails = getSapApiResponses.getHubDetails(areaId);
        hubId = (int) hubDetails.get("id");
        hubName = (String) hubDetails.get("name");

        try {
            agentDetails = getSapApiResponses.getRandomAgent(hubId,agentType);
            deliveryAgentId = (int) agentDetails.get("id");
            deliveryAgentName = (String) agentDetails.get("name");
        } catch (Exception e) {
            System.out.println("Absence of Delivery Agent");
            System.out.println(e);
            setDataForDeliveryAgentTests();
        }

        shopInfoModel = getSapApiResponses.shopInfoGetCall(shopId);
        pickupAddress = shopInfoModel.getShops().get(0).getPickupAddress();

        for(int i =0; i<count;i++) {
            if(i==3)
                isCashZero = random.nextBoolean();
            trackingIds.add(createSingleParcel());
        }

        getSapApiResponses.receiveParcels(trackingIds,1,3);
        getSapApiResponses.assignAgent(trackingIds,deliveryAgentId,deliveryAgentName,hubId);
        getSapApiResponses.dispatchParcelsToAgent(trackingIds,deliveryAgentId,hubId);
    }

    public void setDataForAreaChange(String areaName)
    {
        Map hubDetails,areaDetails = getSapApiResponses.getRandomArea();
        changeAreaName = (String) areaDetails.get("areaName");
        if(changeAreaName.equalsIgnoreCase(areaName))
            setDataForAreaChange(areaName);
        hubDetails = getSapApiResponses.getHubDetails((int) areaDetails.get("areaId"));
        changeAreaHubName = (String) hubDetails.get("name");
        System.out.println("Change Area Name : " + changeAreaName);
        System.out.println("Change Area Hub Name : " + changeAreaHubName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 500)
    public void verifyParcelsCountValue()
    {
        System.out.println("Verifying Parcels Count Value");
        int apiValue = receiveDeliveryAgentsParcelListModel.getCount();
        System.out.println("Assigned Parcels : " + Arrays.toString(assignedParcels));
        System.out.println("Delivered Parcels : " + Arrays.toString(deliveredParcels));
        System.out.println("Problematic Parcels : " + Arrays.toString(problematicParcels));
        System.out.println("API Value : " + apiValue);
        Assert.assertEquals(assignedParcels[1]==deliveredParcels[1],problematicParcels[1]==apiValue);
        Assert.assertTrue(apiValue>=count);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 501)
    public void verifySearchFunctionalityInAssignedSection() {
        System.out.println("Verifying Search Functionality In Assigned Section");

        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("unscanned",trackingId);
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("unassigned",1);
        System.out.println("Value in UI : " + uiValue);
        Assert.assertEquals(uiValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 502)
    public void verifyParcelDetailsValue() {
        System.out.println("Verifying Parcel Details Value");

        apiIndex = receiveDeliveryAgentsParcelListModel.getIndex(receiveDeliveryAgentsParcelListModel,trackingId);
        String phoneValue = parcelDetailsPageObjects.getPhoneValue("unassigned",1);
        System.out.println("Phone Value : " + phoneValue);
        String nameValue = parcelDetailsPageObjects.getNameValue("unassigned",1);
        System.out.println("Name Value : " + nameValue);
        String cashValue = parcelDetailsPageObjects.getCashValue("unassigned",1);
        System.out.println("Cash Value : " + cashValue);
        String deliveryTypeValue = parcelDetailsPageObjects.getDeliveryTypeValue("unassigned",1);
        System.out.println("Delivery Type Value : " + deliveryTypeValue);
        String deliveryAttemptsValue = parcelDetailsPageObjects.getDeliveryAttemptsValue("unassigned",1);
        System.out.println("Delivery Attempts Value : " + deliveryAttemptsValue);
        String addressValue = parcelDetailsPageObjects.getAddressValue("unassigned",1);
        System.out.println("Address Value : " + addressValue);

        System.out.println("Customer Name in Api : " + receiveDeliveryAgentsParcelListModel.getParcels().get(apiIndex).getCustomerName());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 503)
    public void verifyHoldFunctionalityInAssignedSection() {
        System.out.println("Verifying Hold Functionality In Assigned Section");

        List<String> holdReason = holdModalPageObjects.performHoldParcel("unassigned",trackingIds.get(0),isCtAgent);
        sleep(1000);
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
        String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
        String reasonUiValue = parcelDetailsPageObjects.getReasonValue("problematic",1);
        System.out.println("Status : " + status);
        System.out.println("Hold Reason : " + holdReason.toString());
        System.out.println("Hold Reason in UI : " + reasonUiValue);
        Assert.assertEquals(uiValue,trackingIds.get(0));
        Assert.assertEquals(status,"Hold");
        Assert.assertTrue(reasonUiValue.contains(holdReason.get(1)));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 504)
    public void verifyAreaChangeErrorMessageInAssignedSection() {
        System.out.println("Verifying Area Change Error Message In Assigned Section");

        areaChangeModalPageObjects.performAreaChange("unassigned",trackingIds.get(1),areaName);
        new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("Alert Message : " + alertMsg);
        driver.switchTo().alert().accept();
        sleep(1000);
        areaChangeModalPageObjects.clickCloseButton();
        Assert.assertEquals(alertMsg,"No new area selected");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 505)
    public void verifyAreaChangeFunctionalityInAssignedSection() {
        System.out.println("Verifying Area Change Functionality In Assigned Section");

        setDataForAreaChange(areaName);
        areaChangeModalPageObjects.performAreaChange("unassigned",trackingIds.get(1),changeAreaName);
        sleep(2000);
        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned",trackingIds.get(1));
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
        String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
        String areaValue = parcelDetailsPageObjects.getAreaValue("problematic",1);
        String hubValue = parcelDetailsPageObjects.getHubValue("problematic",1);
        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned","");
        System.out.println("Status : " + status);
        Assert.assertEquals(uiValue,trackingIds.get(1));
        Assert.assertEquals(status,"Area Change");
        Assert.assertEquals(areaValue,changeAreaName);
        Assert.assertEquals(hubValue,changeAreaHubName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 506)
    public void verifyReturnedFunctionalityInAssignedSection() {
        System.out.println("Verifying Returned Functionality In Assigned Section");

        List<String> returnedReason = returnedModalPageObjects.performReturned("unassigned",trackingIds.get(2),isCtAgent);
        sleep(1000);
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
        String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
        String reasonUiValue = parcelDetailsPageObjects.getReasonValue("problematic",1);
        System.out.println("Status : " + status);
        System.out.println("Returned Reason : " + returnedReason.toString());
        System.out.println("Returned Reason in UI : " + reasonUiValue);
        Assert.assertEquals(uiValue,trackingIds.get(2));
        Assert.assertEquals(status,"Return");
        Assert.assertTrue(reasonUiValue.contains(returnedReason.get(1)));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 507)
    public void verifyDeliveredFunctionalityInAssignedSection() {
        System.out.println("Verifying Delivered Functionality In Assigned Section");
        deliveredModalPageObjects.performDelivered("unassigned",trackingIds.get(3),isCtAgent);
        sleep(2000);
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("delivered",1);
        Assert.assertEquals(uiValue,trackingIds.get(3));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 508)
    public void verifySearchFunctionalityInProblematicSection() {
        System.out.println("Verifying Search Functionality In Problematic Section");
        int index = random.nextInt(3);
        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned",trackingIds.get(index));
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
        System.out.println("Value in UI : " + uiValue);
        Assert.assertEquals(uiValue,trackingIds.get(index));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 509)
    public void verifyExchangeFunctionalityInAssignedSection() {
        System.out.println("Verifying Exchange Functionality In Assigned Section");

        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("unscanned",trackingIds.get(4));
        String nameValue = parcelDetailsPageObjects.getNameValue("unassigned",1);
        String cashValue = parcelDetailsPageObjects.getCashValue("unassigned",1);

        int choice = random.nextInt(2);

        if (choice==0)
            exchangeModalPageObjects.performExchangeWithoutDeliveredParcel("unassigned",1,isCtAgent);
        else exchangeModalPageObjects.performExchangeWithDeliveredParcel("unassigned",1,trackingIds.get(3),isCtAgent);

        uiIndex = parcelDetailsPageObjects.getIndexValue("delivered",trackingIds.get(4));
        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned",nameValue);
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
        String deliveredCashValue = parcelDetailsPageObjects.getCashValue("delivered",uiIndex);
        String returnCashValue = parcelDetailsPageObjects.getCashValue("problematic",1);
        String status = parcelDetailsPageObjects.getStatusValue("problematic",1);

        Assert.assertNotEquals(uiValue,trackingIds.get(4));
        Assert.assertEquals(cashValue,deliveredCashValue);
        Assert.assertEquals(returnCashValue,"0");
        Assert.assertEquals(status,"Return");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 510)
    public void verifyPartialFunctionalityInAssignedSection() {
        System.out.println("Verifying Partial Functionality In Assigned Section");

        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("unscanned",trackingIds.get(5));
        String nameValue = parcelDetailsPageObjects.getNameValue("unassigned",1);
        String cashValue = parcelDetailsPageObjects.getCashValue("unassigned",1);
        String amount = String.valueOf(random.nextInt(Integer.parseInt(cashValue)+1));

        partialModalPageObjects.performPartial("unassigned",1,amount,isCtAgent);

        uiIndex = parcelDetailsPageObjects.getIndexValue("delivered",trackingIds.get(5));
        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned",nameValue);
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
        String deliveredCashValue = parcelDetailsPageObjects.getCashValue("delivered",uiIndex);
        String returnCashValue = parcelDetailsPageObjects.getCashValue("problematic",1);
        String status = parcelDetailsPageObjects.getStatusValue("problematic",1);

        Assert.assertNotEquals(uiValue,trackingIds.get(5));
        Assert.assertEquals(amount,deliveredCashValue);
        Assert.assertEquals(returnCashValue,"0");
        Assert.assertEquals(status,"Return");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 511)
    public void verifyRaiseIssueFunctionalityInAssignedSection() {
        System.out.println("Verifying Raise Issue Functionality In Assigned Section");
        int parcels = receiveDeliveryAgentsParcelPageObjects.getAssignedParcelsValue()[0];
        System.out.println("Assigned Parcels : " + parcels);
        raiseIssueModalPageObjects.performRaiseIssue("unassigned",trackingIds.get(6),deliveryAgentName);
        sleep(1000);
        assignedParcels = receiveDeliveryAgentsParcelPageObjects.getAssignedParcelsValue();
        System.out.println("Assigned Parcels : " + Arrays.toString(assignedParcels));
        Assert.assertEquals(assignedParcels[0],parcels-1);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 512)
    public void verifyHoldFunctionalityInProblematicSection() {
        System.out.println("Verifying Hold Functionality In Problematic Section");

        List<String> holdReason = holdModalPageObjects.performHoldParcel("problematic",trackingIds.get(0),isCtAgent);
        sleep(1000);
        if (isCtAgent) {
            String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
            String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
            String reasonUiValue = parcelDetailsPageObjects.getReasonValue("problematic",1);
            System.out.println("Status : " + status);
            System.out.println("Hold Reason : " + holdReason.toString());
            System.out.println("Hold Reason in UI : " + reasonUiValue);
            Assert.assertEquals(uiValue,trackingIds.get(0));
            Assert.assertEquals(status,"Hold");
            Assert.assertTrue(reasonUiValue.contains(holdReason.get(1)));
        } else {
            System.out.println(receiveDeliveryAgentsParcelPageObjects.getModalMsg());
            Assert.assertEquals(receiveDeliveryAgentsParcelPageObjects.getModalTitle(),"Permission denied");
            receiveDeliveryAgentsParcelPageObjects.clickModalCloseButton();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 513)
    public void verifyAreaChangeErrorMessageInProblematicSection() {
        System.out.println("Verifying Area Change Error Message In Problematic Section");

        areaChangeModalPageObjects.performAreaChange("problematic",trackingIds.get(1),changeAreaName);
        new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("Alert Message : " + alertMsg);
        driver.switchTo().alert().accept();
        sleep(1000);
        areaChangeModalPageObjects.clickCloseButton();
        Assert.assertEquals(alertMsg,"No new area selected");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 514)
    public void verifyAreaChangeFunctionalityInProblematicSection() {
        System.out.println("Verifying Area Change Functionality In Problematic Section");

        setDataForAreaChange(changeAreaName);
        areaChangeModalPageObjects.performAreaChange("problematic",trackingIds.get(1),changeAreaName);
        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned",trackingIds.get(1));
        String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
        String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
        String areaValue = parcelDetailsPageObjects.getAreaValue("problematic",1);
        String hubValue = parcelDetailsPageObjects.getHubValue("problematic",1);
        receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned","");
        System.out.println("Status : " + status);
        Assert.assertEquals(uiValue,trackingIds.get(1));
        Assert.assertEquals(status,"Area Change");
        Assert.assertEquals(areaValue,changeAreaName);
        Assert.assertEquals(hubValue,changeAreaHubName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 515)
    public void verifyReturnedFunctionalityInProblematicSection() {
        System.out.println("Verifying Returned Functionality In Problematic Section");

        List<String> returnedReason = returnedModalPageObjects.performReturned("problematic",trackingIds.get(2),isCtAgent);
        sleep(1000);
        if (isCtAgent) {
            String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
            String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
            String reasonUiValue = parcelDetailsPageObjects.getReasonValue("problematic",1);
            System.out.println("Status : " + status);
            System.out.println("Returned Reason : " + returnedReason.toString());
            System.out.println("Returned Reason in UI : " + reasonUiValue);
            Assert.assertEquals(uiValue,trackingIds.get(2));
            Assert.assertEquals(status,"Return");
            Assert.assertTrue(reasonUiValue.contains(returnedReason.get(1)));
        } else {
            System.out.println(receiveDeliveryAgentsParcelPageObjects.getModalMsg());
            Assert.assertEquals(receiveDeliveryAgentsParcelPageObjects.getModalTitle(),"Permission denied");
            receiveDeliveryAgentsParcelPageObjects.clickModalCloseButton();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 516)
    public void verifyDeliveredFunctionalityInProblematicSection() {
        System.out.println("Verifying Delivered Functionality In Problematic Section");
        deliveredModalPageObjects.performDelivered("problematic",trackingIds.get(0),isCtAgent);
        sleep(1000);
        if (isCtAgent) {
            String uiValue = parcelDetailsPageObjects.getTrackingIdValue("delivered",1);
            Assert.assertEquals(uiValue,trackingIds.get(0));
        } else {
            System.out.println(receiveDeliveryAgentsParcelPageObjects.getModalMsg());
            Assert.assertEquals(receiveDeliveryAgentsParcelPageObjects.getModalTitle(),"Permission denied");
            receiveDeliveryAgentsParcelPageObjects.clickModalCloseButton();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 517)
    public void verifyRaiseIssueFunctionalityInProblematicSection() {
        System.out.println("Verifying Raise Issue Functionality In Problematic Section");
        int parcels = receiveDeliveryAgentsParcelPageObjects.getProblematicParcelsValue()[0];
        System.out.println("Problematic Parcels : " + parcels);
        raiseIssueModalPageObjects.performRaiseIssue("problematic",trackingIds.get(1),deliveryAgentName);
        sleep(1000);
        problematicParcels = receiveDeliveryAgentsParcelPageObjects.getProblematicParcelsValue();
        System.out.println("Assigned Parcels : " + Arrays.toString(problematicParcels));
        Assert.assertEquals(problematicParcels[0],parcels-1);
    }
     @Test(groups = {CoreConstants.GROUP_SANITY},priority = 518)
     public void verifyHoldFunctionalityInDeliveredSection() {
            System.out.println("Verifying Hold Functionality In Delivered Section");

            List<String> holdReason = holdModalPageObjects.performHoldParcel("delivered",trackingIds.get(3),isCtAgent);
            sleep(1000);
            if (isCtAgent) {
                receiveDeliveryAgentsParcelPageObjects.enterSearchBar("problematic",trackingIds.get(3));
                String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
                String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
                String reasonUiValue = parcelDetailsPageObjects.getReasonValue("problematic",1);
                System.out.println("Status : " + status);
                System.out.println("Hold Reason : " + holdReason.toString());
                System.out.println("Hold Reason in UI : " + reasonUiValue);
                Assert.assertEquals(uiValue,trackingIds.get(3));
                Assert.assertEquals(status,"Hold");
                Assert.assertTrue(reasonUiValue.contains(holdReason.get(1)));
            } else {
                System.out.println(receiveDeliveryAgentsParcelPageObjects.getModalMsg());
                Assert.assertEquals(receiveDeliveryAgentsParcelPageObjects.getModalTitle(),"Permission denied");
                receiveDeliveryAgentsParcelPageObjects.clickModalCloseButton();
            }
        }

        @Test(groups = {CoreConstants.GROUP_SANITY},priority = 519)
        public void verifyAreaChangeErrorMessageInDeliveredSection() {
            System.out.println("Verifying Area Change Error Message In Delivered Section");

            areaChangeModalPageObjects.performAreaChange("delivered",trackingIds.get(4),areaName);
            new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
            String alertMsg = driver.switchTo().alert().getText();
            System.out.println("Alert Message : " + alertMsg);
            driver.switchTo().alert().accept();
            sleep(1000);
            areaChangeModalPageObjects.clickCloseButton();
            Assert.assertEquals(alertMsg,"No new area selected");
        }

        @Test(groups = {CoreConstants.GROUP_SANITY},priority = 520)
        public void verifyAreaChangeFunctionalityInDeliveredSection() {
            System.out.println("Verifying Area Change Functionality In Delivered Section");

            setDataForAreaChange(areaName);
            areaChangeModalPageObjects.performAreaChange("delivered",trackingIds.get(4),changeAreaName);
            receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned",trackingIds.get(4));
            String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
            String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
            String areaValue = parcelDetailsPageObjects.getAreaValue("problematic",1);
            String hubValue = parcelDetailsPageObjects.getHubValue("problematic",1);
            System.out.println("Status : " + status);
            Assert.assertEquals(uiValue,trackingIds.get(4));
            Assert.assertEquals(status,"Area Change");
            Assert.assertEquals(areaValue,changeAreaName);
            Assert.assertEquals(hubValue,changeAreaHubName);
        }

        @Test(groups = {CoreConstants.GROUP_SANITY},priority = 521)
        public void verifyReturnedFunctionalityInDeliveredSection() {
            System.out.println("Verifying Returned Functionality In Delivered Section");

            List<String> returnedReason = returnedModalPageObjects.performReturned("delivered",trackingIds.get(5),isCtAgent);
            sleep(1000);
            if (isCtAgent) {
                receiveDeliveryAgentsParcelPageObjects.enterSearchBar("problematic",trackingIds.get(5));
                String uiValue = parcelDetailsPageObjects.getTrackingIdValue("problematic",1);
                String status = parcelDetailsPageObjects.getStatusValue("problematic",1);
                String reasonUiValue = parcelDetailsPageObjects.getReasonValue("problematic",1);
                System.out.println("Status : " + status);
                System.out.println("Returned Reason : " + returnedReason.toString());
                System.out.println("Returned Reason in UI : " + reasonUiValue);
                Assert.assertEquals(uiValue,trackingIds.get(5));
                Assert.assertEquals(status,"Return");
                Assert.assertTrue(reasonUiValue.contains(returnedReason.get(1)));
            } else {
                System.out.println(receiveDeliveryAgentsParcelPageObjects.getModalMsg());
                Assert.assertEquals(receiveDeliveryAgentsParcelPageObjects.getModalTitle(),"Permission denied");
                receiveDeliveryAgentsParcelPageObjects.clickModalCloseButton();
            }
        }

        @Test(groups = {CoreConstants.GROUP_SANITY},priority = 522)
        public void verifyStatusFilterFunctionalityInProblematicSection() {
            System.out.println("Verifying Status Filter Functionality In Problematic Section");
            receiveDeliveryAgentsParcelPageObjects.enterSearchBar("scanned","");
            String status = receiveDeliveryAgentsParcelPageObjects.chooseProblematicStatusDropDownOption();
            String uiValue = parcelDetailsPageObjects.getStatusValue("problematic",1);
            Assert.assertEquals(uiValue,status);
        }

        @Test(groups = {CoreConstants.GROUP_SANITY},priority = 523)
        public void verifyCashReceivedFunctionality() {
            System.out.println("Verifying Cash Received Functionality");
            int parcels = receiveDeliveryAgentsParcelPageObjects.getAssignedParcelsValue()[0];
            System.out.println("Unscanned Parcels : " + parcels);
            if(parcels==0) {
                System.out.println("Cash : " + receiveDeliveryAgentsParcelPageObjects.getCashReceivedValue());
                receiveDeliveryAgentsParcelPageObjects.clickCashReceivedButton();
                sleep(1000);
                int cash = receiveDeliveryAgentsParcelPageObjects.getCashReceivedValue();
                System.out.println("Cash : " + cash);
                Assert.assertEquals(cash,0);
            } else System.out.println("Cannot Receive Cash");
        }

        @Test(groups = {CoreConstants.GROUP_SANITY},priority = 524)
        public void verifyCashReceivedErrorMsgValue() {
            System.out.println("Verifying Cash Received Error Msg Value");
            int parcels = receiveDeliveryAgentsParcelPageObjects.getAssignedParcelsValue()[0];
            System.out.println("Unscanned Parcels : " + parcels);
            if(parcels==0) {
                System.out.println("Cash : " + receiveDeliveryAgentsParcelPageObjects.getCashReceivedValue());
                receiveDeliveryAgentsParcelPageObjects.clickCashReceivedButton();
                new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
                String alertMsg = driver.switchTo().alert().getText();
                System.out.println("Alert Message : " + alertMsg);
                driver.switchTo().alert().accept();
                Assert.assertEquals(alertMsg,"Error on cash received");
            } else System.out.println("Cannot Receive Cash");
        }

        @Test(groups = {CoreConstants.GROUP_SANITY},priority = 525,enabled = false)
        public void verifyParcelReceivedFunctionality() {
            System.out.println("Verifying Parcel Received Functionality In Delivered Section");
            int parcels = receiveDeliveryAgentsParcelPageObjects.getAssignedParcelsValue()[0];
            System.out.println("Unscanned Parcels : " + parcels);
            if(parcels==0) {
                receiveDeliveryAgentsParcelPageObjects.clickParcelReceivedButton();
                sleep(1000);
                assignedParcels = receiveDeliveryAgentsParcelPageObjects.getAssignedParcelsValue();
                deliveredParcels = receiveDeliveryAgentsParcelPageObjects.getDeliveredParcelsValue();
                problematicParcels = receiveDeliveryAgentsParcelPageObjects.getProblematicParcelsValue();
                System.out.println("Assigned Parcels : " + Arrays.toString(assignedParcels));
                System.out.println("Delivered Parcels : " + Arrays.toString(deliveredParcels));
                System.out.println("Problematic Parcels : " + Arrays.toString(problematicParcels));
            } else System.out.println("Cannot Receive Problematic Parcels");
        }

    @AfterClass(alwaysRun = true)
    public void receiveDeliveryAgentParcelPageTestsAfterClass() {
        System.out.println("Receive Delivery Agent Parcel Page Tests After Class");
        dashboardPageObjects.clickShopUpLogo();
    }
}
