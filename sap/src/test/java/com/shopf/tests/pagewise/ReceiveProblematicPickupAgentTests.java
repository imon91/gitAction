package com.shopf.tests.pagewise;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DashboardPageObjects;
import pageObjects.logistics.Receive.ReceiveDeliveryAgentsParcelPageObjects;
import pageObjects.logistics.Receive.ReceiveModulePageObjects;
import services.responseModels.sapModels.CreateParcelModel;
import services.responseModels.sapModels.ShopInfoModel;
import services.sapMethods.GetSapApiResponses;
import services.responseModels.sapModels.ParcelReasonsModel;
import services.responseModels.sapModels.ReceiveDeliveryAgentsParcelListModel;
import utils.SapBaseClass;

import pageObjects.logistics.Receive.ReceiveProblematicPracelPickupAgentPageObjects;



import java.util.*;

public class ReceiveProblematicPickupAgentTests extends SapBaseClass {
    private WebDriver driver;
    private ReceiveModulePageObjects receiveModulePageObjects;
    private ReceiveProblematicPracelPickupAgentPageObjects receiveProblematicPracelPickupAgentPageObjects;
    private ReceiveProblematicPracelPickupAgentPageObjects.RaiseIssueModalPageObjects raiseIssueModalPageObjects;
    private ReceiveProblematicPracelPickupAgentPageObjects.HoldModalPageObjects holdModalPageObjects;
    private ReceiveProblematicPracelPickupAgentPageObjects.ProlematicModal prolematicModal;
    private GetSapApiResponses getSapApiResponses;
    private Map hubDetails,shopDetails,storeDetails,agentDetails, pickupAgentDetails ;
    private String hubName,shopName,storeName,deliveryAgentName,pickupAgentname,trackingId,agentType = "delivery",pickupAgentType="pickup";
    private int hubId,shopId,storeId,deliveryAgentId,pickupAgentId,uiIndex,apiIndex,parcelsCount=0,count = 7;
    private int weight,areaId,cash,value,invoiceNumber;
    private Boolean isCtAgent=false,isCashZero = false;
    private Random random;
    private List<String> trackingIds = new ArrayList<>();
    private List<String> reasonId = new ArrayList<>();
    private List <String> newTrackingids = new ArrayList<>();
    private List <String> latestTrackingids = new ArrayList<>();
    private ShopInfoModel shopInfoModel;
    private DashboardPageObjects dashboardPageObjects;
    private String pickupAddress,customerName,customerPhone, deliveryAddress,areaName,changeAreaName,changeAreaHubName;

    @BeforeClass(alwaysRun = true)
    public void receiveProblematicParcelTestBeforeClass() throws Exception {
        System.out.println("Receive Delivery Agents Parcel Page Tests Before Class");
        driver = getBaseDriver();
        random = new Random();
        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveModulePageObjects = new ReceiveModulePageObjects(driver);
        receiveProblematicPracelPickupAgentPageObjects= new ReceiveProblematicPracelPickupAgentPageObjects(driver);
        getSapApiResponses = new GetSapApiResponses("sap");
        setDataForPickupAgent();
        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickReceiveModule();
        receiveModulePageObjects.enterHubInput(hubName);
        driver.navigate().refresh();
        receiveModulePageObjects.choosePickupAgent(pickupAgentname);
        holdModalPageObjects =  receiveProblematicPracelPickupAgentPageObjects.new HoldModalPageObjects();
        prolematicModal =  receiveProblematicPracelPickupAgentPageObjects.new ProlematicModal();
        raiseIssueModalPageObjects =  receiveProblematicPracelPickupAgentPageObjects.new RaiseIssueModalPageObjects();
        //receiveProblematicPracelPickupAgentPageObjects.chooseAgent(pickupAgentname);



    }

    public void setDataForCreateSingleParcel() {
        parcelsCount++;
        int num = random.nextInt(1000)+100;
        String[] phone = {"014","88014","+88014"};
        weight = random.nextInt(200000)+1;
        customerName = "Create Parcel " + num;
        customerPhone = phone[random.nextInt(3)] + (random.nextInt(99999999-10000000)+10000000);
        deliveryAddress = "Address,Area,Code";
//        if(isCashZero)
//            cash=0;
//        else
         cash = random.nextInt(10000)+1;
//        isCashZero=false;
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

        if(createParcelModel.isIsError()==true)
            createSingleParcel();

        trackingId = createParcelModel.getBody().getTrackingId();
        System.out.println("Tracking Id : " + trackingId);
        return trackingId;

    }

    public void setDataForPickupAgent(){
        Map returnReason = new HashMap();
        while (true){
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
            //System.out.println(deliveryAgentName);


        } catch (Exception e) {
            System.out.println("Absence of Delivery Agent");
            System.out.println(e);
            setDataForPickupAgent();
        }
        shopInfoModel = getSapApiResponses.shopInfoGetCall(shopId);
        pickupAddress = shopInfoModel.getShops().get(0).getPickupAddress();
        for(int i =0; i<13;i++) {


//                isCashZero = random.nextBoolean();
            trackingIds.add(createSingleParcel());

        }

        getSapApiResponses.receiveParcels(trackingIds,hubId,3);
        getSapApiResponses.assignAgent(trackingIds,deliveryAgentId,deliveryAgentName,hubId);
        getSapApiResponses.dispatchParcelsToAgent(trackingIds,deliveryAgentId,hubId);
        String reason = "return";

       //System.out.println(returnReason);

        for (int i = 0; i < trackingIds.size(); i++) {
            System.out.println("trackinh id will be"+trackingIds.get(i) );
            returnReason =getSapApiResponses.getRandomReason(reason);
              System.out.println("Single reason id will be"+returnReason.get("Id"));

            reasonId.add(returnReason.get("Id").toString());
            System.out.println("return reason"+returnReason);
            getSapApiResponses.parcelActionPutCall(reason,trackingIds.get(i),returnReason);




        }
        getSapApiResponses.cashReceive(hubId,trackingIds);
       // getSapApiResponses.assignAgent(trackingIds,deliveryAgentId,deliveryAgentName,hubId);
        //getSapApiResponses.dispatchParcelsToAgent(trackingIds,deliveryAgentId,hubId);


        try {
            pickupAgentDetails = getSapApiResponses.getRandomAgent(hubId,pickupAgentType);
            pickupAgentId = (int)  pickupAgentDetails.get("id");
            pickupAgentname = (String)  pickupAgentDetails.get("name");
            //System.out.println("new pickup agent......."+pickupAgentname);


        } catch (Exception e) {
            System.out.println("Absence of Delivery Agent");
            System.out.println(e);
            setDataForPickupAgent();
        }
        getSapApiResponses.dispatchProblematicPracelAssigntoAgent(trackingIds,pickupAgentId);
        getSapApiResponses.returnProblematicParcelDispatch(hubId,trackingIds,3,pickupAgentId);


    }



    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 500)
    public void verifySearchFuncationalityInAssignedSection(){
        receiveProblematicPracelPickupAgentPageObjects.enterSearchBar(trackingIds.get(1));
        //System.out.println("the whole problem"+trackingIds.get(1));
        int getCount = receiveProblematicPracelPickupAgentPageObjects.getCountAfterSearchInput();
        System.out.println("Number of xpath count after input tracking number in search field : " + getCount);
        Assert.assertEquals(1,getCount);

    }
    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 501)
    public void verifyParcelsCountValue(){

     int totalParcel =  receiveProblematicPracelPickupAgentPageObjects.getNumberOfAssignParcel();
     int getCount = receiveProblematicPracelPickupAgentPageObjects.getCountAfterSearchInput();
     ArrayList<String> trackingids = receiveProblematicPracelPickupAgentPageObjects.getTranckingId();
     //System.out.println("total gtotalParcel  "+trackingids.size());
     Assert.assertEquals(totalParcel,trackingids.size());
    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 502)
    public void verifyParcelDetailsvalueWithAPI(){

        ReceiveDeliveryAgentsParcelListModel model =  getSapApiResponses.pickupAgentProblematicParcelsListGetCall(pickupAgentId,hubId);
        int totalParcelCount = model.getCount();
        for(int i=0;i<totalParcelCount;i++){
           String trackind = model.getParcels().get(i).getTrackingId();
           System.out.println("count form api...." +trackind);
            newTrackingids.add(trackind);

        }
        ArrayList<String> UItrackingids = receiveProblematicPracelPickupAgentPageObjects.getTranckingId();
        System.out.println("total tracking UI id "+UItrackingids.size());
        System.out.println("total tracking api id "+newTrackingids.size());
        int newTrackingidnumber = newTrackingids.size();
        int UItrackingidsnumber = UItrackingids.size();
        //boolean bool = newTrackingids.equals(UItrackingids);
        //System.out.println("Print result"+bool);
        Assert.assertEquals(newTrackingidnumber,UItrackingidsnumber);

    }
    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 503)
    public void verifyHoldFunctionalityInAssignedSection(){

        //div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'unassignedParcels ')][1]//button[contains(text(),'Hold')]
        String section = "unassignedParcels";
        int number =holdModalPageObjects.countHoldNumber();
        System.out.println("before Number will be........."+number);
        List<String> reason= holdModalPageObjects.performHoldParcel(section);
        System.out.println(reason);

        int newNumber =holdModalPageObjects.countHoldNumber();
        System.out.println("after Number will be........."+newNumber);
        Assert.assertEquals(number+1,newNumber);



    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 504)
    public void verifyRetrunedErrorMessageInAssignedSection(){
        String section = "unassignedParcels";
        String popUpText =  receiveProblematicPracelPickupAgentPageObjects.clickReturnButton(section,1);
        receiveProblematicPracelPickupAgentPageObjects.clickModalCloseButton();
        Assert.assertEquals("Permission denied",popUpText);

    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 505)
    public void verifyMarkingProblematicFunctionalityInAssignedSection(){
        String section = "unassignedParcels";
        int number = prolematicModal.countProlematicNumber();
        List<String> reason= prolematicModal.performProblematicParcel(section);
        int newNumber = prolematicModal.countProlematicNumber();
        System.out.println("old number is "+number);
        Assert.assertEquals(number+1,newNumber);
        driver.navigate().refresh();

    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 506)
    public void verifyRaiseIssueFunctionalityInAssignedSection(){
;
        driver.navigate().refresh();

        String section = "unassignedParcels";
        raiseIssueModalPageObjects.performRaiseIssue(section,pickupAgentname);

    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 507)
    public void verifyPrintFuncationalityInAssignedSection(){
        driver.navigate().refresh();
        String section = "unassignedParcels";
        receiveProblematicPracelPickupAgentPageObjects.clickPrintButton(section,1);
        receiveProblematicPracelPickupAgentPageObjects.getPopUpTextClickPrintButton();
        receiveProblematicPracelPickupAgentPageObjects.clickModalCloseButton();

    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 508)
    public void verifyRetrunedErrorMessageInHoldSection(){
        String section = "returnHoldParcels";
        String popUpText =  receiveProblematicPracelPickupAgentPageObjects.clickReturnButton(section,1);
        receiveProblematicPracelPickupAgentPageObjects.clickModalCloseButton();
        Assert.assertEquals("Permission denied",popUpText);

    }
    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 509)
    public void verifyHoldDateChangeFunctionaltiyInHoldSection(){
        String section= "returnHoldParcels";
        String previousDate =holdModalPageObjects.getDateFromHoldSection(section,1);
        holdModalPageObjects.performDateChange(section,1,"21");
        String nextDate =holdModalPageObjects.getDateFromHoldSection(section,1);
        System.out.println("new date"+nextDate);
        Assert.assertNotEquals(previousDate,nextDate);


    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 510)
    public void verifyMarkProblematicFunctionalityInHoldSection(){
        String section= "returnHoldParcels";
        int number = prolematicModal.countProlematicNumber();
        List<String> reason=prolematicModal.performProblematicParcel(section);
        int newNumber = prolematicModal.countProlematicNumber();
        Assert.assertEquals(number+1,newNumber);

    }
    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 511)
    public void verifyRaiseIssueFunctionalityInHoldSection(){
        String unassignedSection = "unassignedParcels";
        List<String> reason= holdModalPageObjects.performHoldParcel(unassignedSection);
        String section= "returnHoldParcels";
        int number =holdModalPageObjects.countHoldNumber();
        raiseIssueModalPageObjects.performRaiseIssue(section,pickupAgentname);
        int newNumber =holdModalPageObjects.countHoldNumber();
        Assert.assertEquals(number-1,newNumber);

    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 512)
    public void verifyRetrunedErrorMessageInProblematicSection(){

        String section= "problematicParcels";
        String popUpText =  receiveProblematicPracelPickupAgentPageObjects.clickReturnButton(section,1);
        receiveProblematicPracelPickupAgentPageObjects.clickModalCloseButton();
        Assert.assertEquals("Permission denied",popUpText);

    }
    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 513)
    public void verifyHoldFunctionalityInProblematicSection(){
        String section = "problematicParcels";
        int number = prolematicModal.countProlematicNumber();
        System.out.println("before Number will be........."+number);
        List<String> reason= holdModalPageObjects.performHoldParcel(section);
        System.out.println(reason);

        int newNumber =prolematicModal.countProlematicNumber();
        System.out.println("after Number will be........."+newNumber);
        Assert.assertEquals(number-1,newNumber);


    }
    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 514)
    public void verifyRaiseIssueFunctionalityInProblematicSection(){
        //verifyMarkingProblematicFunctionalityInAssignedSection();

        String unassignSection = "unassignedParcels";
        List<String> reason= prolematicModal.performProblematicParcel(unassignSection);
        String section = "problematicParcels";
        int number = prolematicModal.countProlematicNumber();
        raiseIssueModalPageObjects.performRaiseIssue(section,pickupAgentname);
        int newNumber =prolematicModal.countProlematicNumber();
        Assert.assertEquals(number-1,newNumber);

    }
   @Test(groups = {CoreConstants.GROUP_SANITY},priority = 515)
    public void verifyMarkingProblematicFunctionalityInReturnedSection(){
        String returnedSection ="returnedParcels";
        String unassignedSection ="unassignedParcels";

        for(int i =0; i<4;i++) {
            String latestId= receiveProblematicPracelPickupAgentPageObjects.getLatestTrackingID(unassignedSection,i+1);
            System.out.println("latest Tracking ids "+latestId);
            latestTrackingids.add(latestId);

        }
        getSapApiResponses.receivedParcelToSeller(latestTrackingids,3,hubId);

        driver.navigate().refresh();
        int number = prolematicModal.countProlematicNumber();
        List<String> reason=prolematicModal.performProblematicParcel(returnedSection);
        int newNumber = prolematicModal.countProlematicNumber();
        Assert.assertEquals(number+1,newNumber);


    }
    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 516)
    public void verifyHoldFunctionalityInReturnedSection(){
        String returnedSection ="returnedParcels";
        int number =holdModalPageObjects.countHoldNumber();
        System.out.println("before Number will be........."+number);
        List<String> reason= holdModalPageObjects.performHoldParcel(returnedSection);
        System.out.println(reason);

        int newNumber =holdModalPageObjects.countHoldNumber();
        System.out.println("after Number will be........."+newNumber);
        Assert.assertEquals(number+1,newNumber);

    }
    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 517)
    public void verifyShoUpReturnedFuncationality(){
        receiveProblematicPracelPickupAgentPageObjects.clickShopUpReturnedButton();
        int number=receiveProblematicPracelPickupAgentPageObjects.countReturnNumber();
        Assert.assertEquals(0,number);


    }





}
