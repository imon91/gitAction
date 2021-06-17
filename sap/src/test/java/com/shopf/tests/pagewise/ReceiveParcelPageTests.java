package com.shopf.tests.pagewise;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import pageObjects.logistics.Receive.ReceiveModulePageObjects;
import services.sapMethods.GetSapApiResponses;
import utils.SapBaseClass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReceiveParcelPageTests extends SapBaseClass {

    private WebDriver driver;
    private DashboardPageObjects dashboardPageObjects;
    private ReceiveModulePageObjects receiveModulePageObjects;
    private GetSapApiResponses getSapApiResponses;

    private Map hubDetails,shopDetails,deliveryAgentDetails,pickupAgentDetails;
    private List<String> motherHub = Arrays.asList("Tejgaon Hub (Mother Hub)","Chittagong Hub");
    private String hubName,parcelHubName,shopName;
    private String deliveryAgentName,pickupAgentName;
    private int hubId,shopId;

    @BeforeClass(alwaysRun = true)
    public void receiveParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Receive Parcel Page Tests Before Class");
        driver = getBaseDriver();
        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveModulePageObjects = new ReceiveModulePageObjects(driver);
        getSapApiResponses = new GetSapApiResponses("sap");

        hubDetails = getSapApiResponses.getRandomHub();
        hubId = (int) hubDetails.get("id");
        hubName = (String) hubDetails.get("name");
        if(motherHub.contains(hubName))
            parcelHubName = (String) getSapApiResponses.getRandomHub(hubId).get("name");
        shopDetails = getSapApiResponses.getRandomShop();
        shopId = (int) shopDetails.get("id");
        shopName = (String) shopDetails.get("name");

        deliveryAgentDetails = getSapApiResponses.getRandomAgent(hubId,"delivery");
        pickupAgentDetails = getSapApiResponses.getRandomAgent(hubId,"pickup");

        System.out.println("Navigating to Receive Parcel Page");

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickReceiveModule();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod()
    {System.out.println("\n /****************************************************************************************************/ \n");}

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 101)
        public void verifyHubFilterFunctionality()
    {
        System.out.println("Verifying Hub Filter Functionality");
        receiveModulePageObjects.enterHubInput(hubName);
        String uiValue = receiveModulePageObjects.getHubFilterValue();
        System.out.println("Value in Ui : " + uiValue);
        Assert.assertEquals(uiValue,hubName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 102)
    public void verifyViewSellerParcelsFunctionality()
    {
        System.out.println("Verifying View Seller Parcels Functionality");
        receiveModulePageObjects.viewSellerParcels(shopName,shopId);
        String title = receiveModulePageObjects.getTitleValue("h3");
        System.out.println("Title : " + title);
        receiveModulePageObjects.clickBackButton();
        Assert.assertTrue(title.contains(shopName.trim()));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 103)
    public void verifyViewHubParcelsFunctionality()
    {
        System.out.println("Verifying View Hub Parcels Functionality");
        if(motherHub.contains(hubName))
            receiveModulePageObjects.enterHubParcelHubInput(parcelHubName);
        receiveModulePageObjects.clickViewHubParcelsButton();
        String title = receiveModulePageObjects.getTitleValue("h3");
        System.out.println("Title : " + title);
//        receiveModulePageObjects.clickBackButton();
        driver.navigate().back();
        if(motherHub.contains(hubName)) {
            Assert.assertTrue(title.contains(parcelHubName));
        } else Assert.assertEquals(title,"Receive - Hub parcels");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 104)
    public void verifyViewMotherHubParcelsFunctionality()
    {
        if(motherHub.contains(hubName)) {
            System.out.println("Verifying View Mother Hub Parcels Functionality");
            receiveModulePageObjects.clickViewMotherHubParcelsButton();
            String title = receiveModulePageObjects.getTitleValue("h3");
            System.out.println("Title : " + title);
//            receiveModulePageObjects.clickBackButton();
            driver.navigate().back();
            switch (hubId) {
                case 7 :
                    Assert.assertEquals(title, "Receive - Hub parcels from " + motherHub.get(0) + " (NEW)");
                    break;
                case 8 :
                    Assert.assertEquals(title, "Receive - Hub parcels from " + motherHub.get(1) + " (NEW)");
            }
        } else System.out.println("Chosen Hub is not Mother Hub");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 105)
    public void verifyViewResellerParcelsFunctionality()
    {
        System.out.println("Verifying View Reseller Parcels Functionality");
        if(motherHub.contains(hubName)) {
            receiveModulePageObjects.clickViewResellerParcelsButton();
            String title = receiveModulePageObjects.getTitleValue();
            System.out.println("Title : " + title);
            receiveModulePageObjects.clickBackButton();
            Assert.assertEquals(title,"Receiving panel - Reseller");
        } else System.out.println("Chosen Hub is not Mother Hub");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 106)
    public void verifyViewDeliveryAgentsParcelsFunctionality()
    {
        System.out.println("Verifying View Delivery Agents Parcels Functionality");
        try {
            deliveryAgentName = (String) deliveryAgentDetails.get("name");
            receiveModulePageObjects.chooseDeliveryAgent(deliveryAgentName);
            String title = receiveModulePageObjects.getTitleValue("h3");
            System.out.println("Title : " + title);
            receiveModulePageObjects.clickBackButton();
            Assert.assertTrue(title.contains(deliveryAgentName.trim()));
        } catch (NullPointerException e) {
            System.out.println("Absence of Agent to perform action");
        }

    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 107)
    public void verifyViewPickUpAgentsParcelsFunctionality()
    {
        System.out.println("Verifying View PickUp Agents Parcels Functionality");
        try{
            pickupAgentName = (String) pickupAgentDetails.get("name");
            receiveModulePageObjects.choosePickupAgent(pickupAgentName);
            String title = receiveModulePageObjects.getTitleValue("h4");
            System.out.println("Title : " + title);
            receiveModulePageObjects.clickBackButton();
            Assert.assertTrue(title.contains(pickupAgentName.trim()));
        } catch (NullPointerException e) {
            System.out.println("Absence of Agent to perform action");
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 108)
    public void verifyMotherHubReturnedParcelsFunctionality()
    {
        System.out.println("Verifying Mother Hub Returned Parcels Functionality");
        receiveModulePageObjects.clickMotherHubReturnedParcelsButton();
        String title = receiveModulePageObjects.getProblematicHubParcelTitleValue();
        System.out.println("Title : " + title);
        receiveModulePageObjects.clickBackButton();
        Assert.assertEquals(title,"Receive Returned Parcels from Main hub");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 109)
    public void verifyMotherHubAreaChangedParcelsFunctionality()
    {
        System.out.println("Verifying Area Changed Parcels Functionality");
        receiveModulePageObjects.clickMotherHubAreaChangedParcelsButton();
        String title = receiveModulePageObjects.getProblematicHubParcelTitleValue();
        System.out.println("Title : " + title);
        receiveModulePageObjects.clickBackButton();
        Assert.assertEquals(title,"Receive Area Changed parcels from Main hub");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 110)
    public void verifyViewProblematicHubReturnedParcelsFunctionality()
    {
        System.out.println("Verifying View Problematic Hub Returned Parcels Functionality");
        if(motherHub.contains(hubName)){
            receiveModulePageObjects.enterProblematicHubParcelHubInput(parcelHubName);
            receiveModulePageObjects.clickViewProblematicHubReturnedParcelsButton();
            String title = receiveModulePageObjects.getProblematicHubParcelTitleValue();
            System.out.println("Title : " + title);
            receiveModulePageObjects.clickBackButton();
            Assert.assertTrue(title.contains(parcelHubName));
        } else System.out.println("Chosen Hub is not Mother Hub");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 111)
    public void verifyViewProblematicHubAreaChangedParcelsFunctionality()
    {
        System.out.println("Verifying View Problematic Hub Area Changed Parcels Functionality");
        if(motherHub.contains(hubName)){
            receiveModulePageObjects.enterProblematicHubParcelHubInput(parcelHubName);
            receiveModulePageObjects.clickViewProblematicHubAreaChangedParcelsButton();
            String title = receiveModulePageObjects.getProblematicHubParcelTitleValue();
            System.out.println("Title : " + title);
            receiveModulePageObjects.clickBackButton();
            Assert.assertTrue(title.contains(parcelHubName));
        } else System.out.println("Chosen Hub is not Mother Hub");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 112)
    public void verifyViewPartnerParcelsFunctionality()
    {
        System.out.println("Verify View Partner Parcels Functionality");
        if(motherHub.contains(hubName)){
            String partner = receiveModulePageObjects.selectPartnerParcelDropDownOption();
            String title = receiveModulePageObjects.getTitleValue();
            System.out.println("Title : " + title);
//        receiveModulePageObjects.clickBackButton();
            driver.navigate().back();
            Assert.assertEquals(title,"Receive parcels from Partners");
        } else System.out.println("Chosen Hub is not Mother Hub");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 113)
    public void verifyViewReversePickupParcelsFunctionality()
    {
        System.out.println("Verifying View Reverse PickUp Parcels Functionality");
        receiveModulePageObjects.enterReversePickupShopInput(shopName,shopId);
        String title = receiveModulePageObjects.getTitleValue("h3");
        System.out.println("Title : " + title);
        receiveModulePageObjects.clickBackButton();
        Assert.assertTrue(title.contains(shopName.trim()));
    }

    @AfterClass(alwaysRun = true)
    public void receiveParcelPageTestsAfterClass()
    {
        System.out.println("Receive Parcel Page Tests After Class");
        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickShopUpLogo();

    }

}
