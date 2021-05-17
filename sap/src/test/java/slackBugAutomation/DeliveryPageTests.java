package slackBugAutomation;

import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.Random;

public class DeliveryPageTests extends SapBaseClass {

    private WebDriver driver;
    private Random random;
    private DashboardPageObjects dashboardPageObjects;
    private DeliveryModulePageObjects deliveryModulePageObjects;
    private DeliveryModulePageObjects.ParcelDetails parcelDetails;

    private String searchOption;
    private String trackingId;
    private String totalPayment;
    private String amount;

    @BeforeClass(alwaysRun = true)
    public void receiveProblematicParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Receive Problematic Parcel Page Tests Before Class");
        driver = getBaseDriver();
        random = new Random();
        dashboardPageObjects = new DashboardPageObjects(driver);
        deliveryModulePageObjects = new DeliveryModulePageObjects(driver);
        parcelDetails = deliveryModulePageObjects.new ParcelDetails();

        trackingId = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_TRACKING_ID);

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickDeliveryModule();
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 250)
    public void verifyTrackingIdSearchFunctionality()
    {
        System.out.println("Verifying Tracking Id Search Functionality");
        searchOption = "trackingId";
        deliveryModulePageObjects.performSearch(searchOption,trackingId);
        String trackingIdValue = parcelDetails.getTrackingIdValue(1);
        System.out.println("Tracking Id Value : " + trackingIdValue);
        Assert.assertEquals(trackingIdValue,trackingId);
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG}, priority = 251)
    public void verifyPartialDeliveryFunctionality() throws Exception
    {
        System.out.println("Verifying Partial Delivery Functionality");
        totalPayment = parcelDetails.getTotalPaymentValue(1);
        System.out.println("Total Payment : " + totalPayment);
        amount = String.valueOf(random.nextInt(Integer.parseInt(totalPayment))+1);
        parcelDetails.performPartialDelivery(1,amount);
        PropertyReader.setValue(PropertyReader.Keys.DELIVERY_FLOW_CASH,totalPayment);
        PropertyReader.setValue(PropertyReader.Keys.PARTIAL_DELIVERY_AMOUNT,amount);
    }

    @AfterClass(alwaysRun = true)
    public void deliveryPageTestsAfterClass()
    {
        System.out.println("Delivery Page Tests After Class");
    }
}
