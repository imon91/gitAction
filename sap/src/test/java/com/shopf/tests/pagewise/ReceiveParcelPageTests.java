package com.shopf.tests.pagewise;

import coreUtils.CoreConstants;
import javafx.util.Pair;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.sapMethods.GetSapApiResponses;
import utils.SapBaseClass;

public class ReceiveParcelPageTests extends SapBaseClass {

    private WebDriver driver;
    private DashboardPageObjects dashboardPageObjects;
    private ReceiveModulePageObjects receiveModulePageObjects;
    private GetSapApiResponses getSapApiResponses;

    private Pair<Integer,String> hubDetails;
    private Pair<Integer,String> shopDetails;
    private Pair<Integer,String> deliveryAgentDetails;
    private Pair<Integer,String> pickupAgentDetails;
    private String motherHub = "Tejgaon Hub (Mother Hub)";
    private String hubName;
    private String parcelHubName;
    private String shopName;
    private String deliveryAgentName;
    private String pickupAgentName;
    private int hubId;
    private int shopId;

    @BeforeClass(alwaysRun = true)
    public void receiveParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Receive Parcel Page Tests Before Class");
        driver = getBaseDriver();
        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveModulePageObjects = new ReceiveModulePageObjects(driver);
        getSapApiResponses = new GetSapApiResponses("sap");

        hubDetails = getSapApiResponses.getRandomHub();
        hubId = hubDetails.getKey();
        hubName = hubDetails.getValue();
        if(hubName.equalsIgnoreCase(motherHub))
            parcelHubName = getSapApiResponses.getRandomHub().getValue();
        shopDetails = getSapApiResponses.getRandomShop();
        shopId = shopDetails.getKey();
        shopName = shopDetails.getValue();

        deliveryAgentDetails = getSapApiResponses.getRandomAgent(hubId,"delivery");
        pickupAgentDetails = getSapApiResponses.getRandomAgent(hubId,"pickup");

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
        Assert.assertTrue(title.contains(shopName));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 103)
    public void verifyViewHubParcelsFunctionality()
    {
        System.out.println("Verifying View Hub Parcels Functionality");
        if(hubName.equalsIgnoreCase(motherHub))
            receiveModulePageObjects.enterHubParcelHubInput(parcelHubName);
        receiveModulePageObjects.clickViewHubParcelsButton();
        String title = receiveModulePageObjects.getTitleValue("h3");
        System.out.println("Title : " + title);
//        receiveModulePageObjects.clickBackButton();
        driver.navigate().back();
        if(hubName.equalsIgnoreCase(motherHub)) {
            Assert.assertTrue(title.contains(parcelHubName));
        } else Assert.assertEquals(title,"Receive - Hub parcels");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 104)
    public void verifyViewMotherHubParcelsFunctionality()
    {
        if(hubName.equalsIgnoreCase(motherHub)) {
            System.out.println("Verifying View Mother Hub Parcels Functionality");
            receiveModulePageObjects.clickViewMotherHubParcelsButton();
            String title = receiveModulePageObjects.getTitleValue("h3");
            System.out.println("Title : " + title);
//            receiveModulePageObjects.clickBackButton();
            driver.navigate().back();
            Assert.assertEquals(title, "Receive - Hub parcels From Chittagong Hub (NEW)");
        } else System.out.println("Chosen Hub is not Mother Hub");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 105)
    public void verifyViewResellerParcelsFunctionality()
    {
        System.out.println("Verifying View Reseller Parcels Functionality");
        if(hubName.equalsIgnoreCase(motherHub)) {
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
            deliveryAgentName = deliveryAgentDetails.getValue();
            receiveModulePageObjects.chooseDeliveryAgent(deliveryAgentName);
            String title = receiveModulePageObjects.getTitleValue("h3");
            System.out.println("Title : " + title);
            receiveModulePageObjects.clickBackButton();
            Assert.assertTrue(title.contains(deliveryAgentName));
        } catch (NullPointerException e) {
            System.out.println("Absence of Agent to perform action");
        }

    }

    @Test(groups = {CoreConstants.GROUP_SANITY},priority = 107)
    public void verifyViewPickUpAgentsParcelsFunctionality()
    {
        System.out.println("Verifying View PickUp Agents Parcels Functionality");
        try{
            pickupAgentName = pickupAgentDetails.getValue();
            receiveModulePageObjects.choosePickupAgent(pickupAgentName);
            String title = receiveModulePageObjects.getTitleValue("h4");
            System.out.println("Title : " + title);
            receiveModulePageObjects.clickBackButton();
            Assert.assertTrue(title.contains(pickupAgentName));
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
        if(hubName.equalsIgnoreCase(motherHub)){
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
        if(hubName.equalsIgnoreCase(motherHub)){
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
        if(hubName.equalsIgnoreCase(motherHub)){
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
        Assert.assertTrue(title.contains(shopName));
    }

    @AfterClass(alwaysRun = true)
    public void receiveParcelPageTestsAfterClass()
    {
        System.out.println("Receive Parcel Page Tests After Class");
        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickShopUpLogo();

    }

}
