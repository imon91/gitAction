package com.shopf.tests.pagewise;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import pageObjects.logistics.Pickup.PickupModulePageObjects;
import services.sapMethods.*;
import services.responseModels.sapModels.*;
import utils.*;

import java.util.*;

public class PickupPageTests extends SapBaseClass {

    private WebDriver driver;
    private Random random;

    private DashboardPageObjects dashboardPageObjects;
    private PickupModulePageObjects pickupModulePageObjects;
    private PickupModulePageObjects.CreatePickupPageObjects createPickupPageObjects;
    private PickupModulePageObjects.PickupDetailsPageObjects pickupDetailsPageObjects;
    private PickupModulePageObjects.ActionsPageObjects actionsPageObjects;

    private GetSapApiResponses getSapApiResponses;
    private PickupModel pickupModel;
    private ShopStoreInfoModel shopStoreInfoModel;

    private String shopName = "SAP Sanity Test Shop";
    private String storeName,hubName,agentName;
    private int shopId,storeId,hubId,agentId,store,pickupIndex,parcelCount;
    private Map hubDetails,agentDetails;

    @BeforeClass(alwaysRun = true)
    public void pickupPageTestsBeforeClass() throws Exception
    {
        System.out.println("Pickup Page Tests Before Class");

        driver = getBaseDriver();
        random = new Random();

        dashboardPageObjects = new DashboardPageObjects(driver);
        pickupModulePageObjects = new PickupModulePageObjects(driver);
        createPickupPageObjects = pickupModulePageObjects.new CreatePickupPageObjects();
        pickupDetailsPageObjects = pickupModulePageObjects.new PickupDetailsPageObjects();
        actionsPageObjects = pickupModulePageObjects.new ActionsPageObjects();

        getSapApiResponses = new GetSapApiResponses("sap");

        shopId = getSapApiResponses.getShopId(shopName);
        shopStoreInfoModel = getSapApiResponses.shopStoreInfoGetCall(shopId);

        System.out.println("Navigating to Pickup Page");

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickPickupModule();
        dashboardPageObjects.skipReconcileReminder();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod()
    {System.out.println("\n /****************************************************************************************************/ \n");}

    public void createPickupData() {
        int stores = shopStoreInfoModel.getBody().size();
        store = random.nextInt(stores);
        storeName = shopStoreInfoModel.getBody().get(store).getNAME();
        storeId = shopStoreInfoModel.getBody().get(store).getID();
        parcelCount = random.nextInt(10)+1;
        hubId = getSapApiResponses.getHubId(1, shopStoreInfoModel.getBody().get(store).getAREA_ID());
        hubName = getSapApiResponses.getHubName(hubId);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 51)
    public void verifyHubFilterFunctionality()
    {
        System.out.println("Verifying Hub Filter Functionality");
        hubDetails = getSapApiResponses.getRandomHub();
        hubId = (int) hubDetails.get("id");
        hubName = (String) hubDetails.get("name");
        pickupModulePageObjects.selectHubFilter(hubName);
        pickupModel = getSapApiResponses.pickupGetCall(String.valueOf(hubId),"","");
        int uiValue = pickupModulePageObjects.getPickupPointsValue();
        int apiValue = pickupModel.getShops().size();
        System.out.println("Value in Ui : " + uiValue);
        System.out.println("Value in Api : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 52)
    public void verifyStatusFilterFunctionality()
    {
        System.out.println("Verifying Status Filter Functionality");
        String status = pickupModulePageObjects.selectStatusFilter();
        pickupModel = getSapApiResponses.pickupGetCall(String.valueOf(hubId),"",getSapApiResponses.getApiParameter(status));
        int uiValue = pickupModulePageObjects.getPickupPointsValue();
        int apiValue = pickupModel.getShops().size();
        pickupModulePageObjects.selectStatusFilter("All Statuses");
        System.out.println("Value in Ui : " + uiValue);
        System.out.println("Value in Api : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 53)
    public void verifyAgentFilterFunctionality()
    {
        System.out.println("Verifying Agent Filter Functionality");
        agentDetails = getSapApiResponses.getRandomAgent(hubId);
        try {
            agentId = (int) agentDetails.get("id");
            agentName = (String) agentDetails.get("name");
            pickupModulePageObjects.selectAgentFilter(agentName);
            pickupModel = getSapApiResponses.pickupGetCall(String.valueOf(hubId),String.valueOf(agentId),"");
            int uiValue = pickupModulePageObjects.getPickupPointsValue();
            int apiValue = pickupModel.getShops().size();
            System.out.println("Value in Ui : " + uiValue);
            System.out.println("Value in Api : " + apiValue);
            Assert.assertEquals(uiValue,apiValue);
        } catch (Exception e)
        {
            System.out.println("Exception in Agent Filer : " + e);
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 54)
    public void verifyShopCheckboxFilterFunctionality() {
        System.out.println("Verifying Shop Checkbox Filter Functionality");
        String uiValue1 = pickupModulePageObjects.getShopsFilterValue();
        System.out.println("Shop Filter Value : " + uiValue1);
        pickupModulePageObjects.clickShopsFilter();
        String uiValue2 = pickupModulePageObjects.getShopsFilterValue();
        System.out.println("Current Shop Filter Value : " + uiValue2);
        Assert.assertEquals(uiValue1,"All Pickup Shops:");
        Assert.assertEquals(uiValue2,"Unassigned Agent Shops:");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 55)
    public void verifyCreatePickupButtonFunctionality()
    {
        System.out.println("Verifying Create Pickup Button Functionality");
        pickupModulePageObjects.clickCreatePickupButton();
        String title = createPickupPageObjects.getModalTitle();
        System.out.println("Modal Title : " + title);
        Assert.assertEquals(title,"Create New PickUp");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 56)
    public void verifyCreatePickupFunctionality()
    {
        System.out.println("Verifying Create Pickup Functionality");
        createPickupData();
        createPickupPageObjects.createPickup(shopName,storeName,parcelCount);
        pickupModulePageObjects.selectHubFilter(hubName);
        pickupModel  = getSapApiResponses.pickupGetCall(String.valueOf(hubId),"","");
        pickupIndex = getSapApiResponses.getPickupIndex(shopId,pickupModel);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 57)
    public void verifyShopNameValue() {
        System.out.println("Verifying Shop Name Value");
        String uiValue = pickupDetailsPageObjects.getShopNameValue(1);
        String apiValue = pickupModel.getShops().get(pickupIndex).getSHOP_NAME();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 58)
    public void verifyShopStoreValue() {
        System.out.println("Verifying Shop Store Value");
        String uiValue = pickupDetailsPageObjects.getShopDetailsValue(1,0);
        String apiValue = pickupModel.getShops().get(pickupIndex).getSHOP_STORE_NAME();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 59)
    public void verifyShopStoreIdValue() {
        System.out.println("Verifying Shop Store Id Value");
        String uiValue = pickupDetailsPageObjects.getShopDetailsValue(1,1).substring(10);
        String apiValue = String.valueOf(pickupModel.getShops().get(pickupIndex).getSHOP_STORE_ID());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 60)
    public void verifyPickupPhoneValue() {
        System.out.println("Verifying Pickup Phone Value");
        String uiValue = pickupDetailsPageObjects.getAreaAddressPhoneValue(1,0).substring(13);
        String apiValue = pickupModel.getShops().get(pickupIndex).getPICKUP_PHONE();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 61)
    public void verifyShopPhoneValue() {
        System.out.println("Verifying Shop Phone Value");
        String uiValue = pickupDetailsPageObjects.getAreaAddressPhoneValue(1,1).substring(12);
        String apiValue = pickupModel.getShops().get(pickupIndex).getSHOP_PHONE();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 62)
    public void verifyPickupAreaValue() {
        System.out.println("Verifying Pickup Area Value");
        String uiValue = pickupDetailsPageObjects.getAreaAddressPhoneValue(1,2).substring(6);
        String apiValue = pickupModel.getShops().get(pickupIndex).getAREA_NAME();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 63)
    public void verifyPickupAddressValue() {
        System.out.println("Verifying Pickup Address Value");
        String uiValue = pickupDetailsPageObjects.getAreaAddressPhoneValue(1,3);
        String apiValue = pickupModel.getShops().get(pickupIndex).getPICKUP_ADDRESS();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 64)
    public void verifyAgentNameValue() {
        System.out.println("Verifying Agent Name Value");
        String uiValue = pickupDetailsPageObjects.getAgentNameValue(1);
        String apiValue = pickupModel.getShops().get(pickupIndex).getAGENT_NAME();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue.trim());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 65)
    public void verifyParcelCountValue() {
        System.out.println("Verifying Parcel Count Value");
        String uiValue = pickupDetailsPageObjects.getParcelCountValue(1);
        String apiValue = String.valueOf(pickupModel.getShops().get(pickupIndex).getPARCEL_COUNT());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 66)
    public void verifyParcelPickedUpCountValue() {
        System.out.println("Verifying Parcel Picked Up Count Value");
        String uiValue = pickupDetailsPageObjects.getParcelPickedUpCountValue(1);
        String apiValue = String.valueOf(pickupModel.getShops().get(pickupIndex).getPARCEL_PICKEDUP_COUNT());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        if(uiValue.equalsIgnoreCase(""))
            uiValue="null";
        else uiValue = String.format("%.1f",Double.valueOf(uiValue));
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 67)
    public void verifyScannedParcelCountValue() {
        System.out.println("Verifying Scanned Parcel Count Value");
        String uiValue = pickupDetailsPageObjects.getScannedParcelCountValue(1);
        String apiValue = String.valueOf(pickupModel.getShops().get(pickupIndex).getSCANNED_PARCEL_COUNT());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 68)
    public void verifyUnSannedParcelCountValue() {
        System.out.println("Verifying UnScanned Parcel Count Value");
        String uiValue = pickupDetailsPageObjects.getUnScannedParcelCountValue(1);
        String apiValue = String.valueOf(pickupModel.getShops().get(pickupIndex).getUNSCANNED_PARCEL_COUNT());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 69)
    public void verifyRequestTypeValue() {
        System.out.println("Verifying Request Type Value");
        String uiValue = pickupDetailsPageObjects.getRequestTypeValue(1);
        String apiValue = pickupModel.getShops().get(pickupIndex).getENTRY_SOURCE();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 70)
    public void verifyFailedReasonValue() {
        System.out.println("Verifying Failed Reason Value");
        String uiValue = pickupDetailsPageObjects.getFailedReasonValue(1);
        String apiValue = String.valueOf( pickupModel.getShops().get(pickupIndex).getFAILED_REASON());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        if(uiValue.equalsIgnoreCase(""))
            uiValue="null";
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 71)
    public void verifyRemarksValue() {
        System.out.println("Verifying Remarks Value");
        String uiValue = pickupDetailsPageObjects.getRemarksValue(1);
        String apiValue = String.valueOf(pickupModel.getShops().get(pickupIndex).getREMARKS());
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        if(uiValue.equalsIgnoreCase(""))
            uiValue="null";
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 72)
    public void verifyStatusValue() {
        System.out.println("Verifying Status Value");
        String uiValue = pickupDetailsPageObjects.getStatusValue(1);
        String apiValue = pickupModel.getShops().get(pickupIndex).getSTATUS();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 73)
    public void verifyCreatedAtValue() {
        System.out.println("Verifying Created At Value");
        String uiValue = pickupDetailsPageObjects.getCreatedAtValue(1);
        String apiValue = pickupModel.getShops().get(pickupIndex).getCREATED_AT();
        System.out.println("Ui Value : " + uiValue);
        System.out.println("Api Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 74)
    public void verifySelectAgentFunctionality()
    {
        System.out.println("Verifying Select Agent Functionality");
        agentDetails = getSapApiResponses.getRandomAgent(hubId);
        agentId = (int) agentDetails.get("id");
        agentName = (String) agentDetails.get("name");
        pickupDetailsPageObjects.assignAgent(1,agentName);

        pickupModulePageObjects.selectHubFilter(hubName);
        String uiValue = pickupDetailsPageObjects.getAgentNameValue(1);
        System.out.println("Value in Ui :  " + uiValue);
        Assert.assertEquals(uiValue,agentName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 75)
    public void verifyCancelButtonFunctionality() {
        System.out.println("Verifying Cancel Button Functionality");
        String reason = actionsPageObjects.performCancelPickup(1);
        String status = pickupDetailsPageObjects.getStatusValue(1);
        String remark = pickupDetailsPageObjects.getRemarksValue(1);
        System.out.println("Status : " + status);
        System.out.println("Remark : " + remark);
        Assert.assertEquals(status,"cancelled");
        Assert.assertEquals(remark,reason);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 76)
    public void verifyConfirmButtonFunctionality() {
        System.out.println("Verifying Confirm Button Functionality");
        actionsPageObjects.clickConfirmButton(1);
        String status = pickupDetailsPageObjects.getStatusValue(1);
        System.out.println("Status : " + status);
        Assert.assertEquals(status,"confirmed");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 77)
    public void verifyPickedUpButtonFunctionality() {
        System.out.println("Verifying Picked Up Button Functionality");
        actionsPageObjects.performPickedUp(1,parcelCount);
        String parcelPickedUpCount = pickupDetailsPageObjects.getParcelPickedUpCountValue(1);
        String status = pickupDetailsPageObjects.getStatusValue(1);
        System.out.println("Parcel Picked Up Count : " + parcelPickedUpCount);
        System.out.println("Status : " + status);
        Assert.assertEquals(status,"picked-up");
        Assert.assertEquals(parcelPickedUpCount,String.valueOf(parcelCount));
    }

    @AfterClass(alwaysRun = true)
    public void pickupPageTestsAfterClass()
    {
        System.out.println("Pickup Page Tests After Class");
        dashboardPageObjects.clickShopUpLogo();
        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickLogisticsModule();
    }
}
