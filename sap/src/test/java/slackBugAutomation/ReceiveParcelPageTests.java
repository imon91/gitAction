package slackBugAutomation;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import pageObjects.logistics.ReceiveModulePageObjects;
import pageObjects.logistics.ReceiveSellerParcelPageObjects;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.CreateParcelModel;
import utils.*;

public class ReceiveParcelPageTests extends SapBaseClass {

    private WebDriver driver;
    private DashboardPageObjects dashboardPageObjects;
    private ReceiveModulePageObjects receiveModulePageObjects;
    private ReceiveSellerParcelPageObjects receiveSellerParcelPageObjects;
    private GetRedxApiResponse getRedxApiResponse;
    private CreateParcelModel createParcelModel;

    private String hubName;
    private String shopName;
    private String trackingId = new String();

    @BeforeClass(alwaysRun = true)
    public void receiveParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Receive Parcel Page Tests Before Class");
        driver = getBaseDriver();
        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveModulePageObjects = new ReceiveModulePageObjects(driver);
        receiveSellerParcelPageObjects = new ReceiveSellerParcelPageObjects(driver);
        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        hubName = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_HUB_NAME);
        shopName = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_SHOP_NAME);

        createParcelModel = getRedxApiResponse.createParcelPostCall(shopName,SapFileUtils.createParcelData);
        trackingId =  createParcelModel.getBody().getTrackingId();

        System.out.println("Tracking ID : " + trackingId);
        PropertyReader.setValue(PropertyReader.Keys.DELIVERY_FLOW_TRACKING_ID,trackingId);

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickReceiveModule();
        receiveModulePageObjects.enterHubInput(hubName);
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 101)
    public void verifySelectSellerParcelShopFunctionality()
    {
        System.out.println("Verifying Select Seller Parcel Shop Functionality");
        receiveModulePageObjects.viewSellerParcels(shopName, getRedxApiResponse.getShopId(shopName));
        String title = receiveSellerParcelPageObjects.getTitleValue();
        System.out.println("Title : " + title);
        Assert.assertTrue(title.contains(shopName));
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 102)
    public void verifyScanCodeFunctionality()
    {
        System.out.println("Verifying Scan Code Functionality");
        receiveSellerParcelPageObjects.enterScanCodeInput(trackingId);
        String scannedId = receiveSellerParcelPageObjects.getTrackingIdValue("scanned",1);
        Assert.assertEquals(scannedId,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 103)
    public void verifySendToSortingFunctionality()
    {
        System.out.println("Verifying Send To Sorting Functionality");
        receiveSellerParcelPageObjects.clickSendToSorting();
        //Assert
    }

    @AfterClass(alwaysRun = true)
    public void receiveParcelPageTestsAfterClass()
    {
        System.out.println("Receive Parcel Page Tests After Class");
        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickShopUpLogo();
    }

}
