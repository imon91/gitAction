package slackBugAutomation;

import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.Random;

public class ReceiveProblematicParcelPageTests extends SapBaseClass {

    private WebDriver driver;
    private DashboardPageObjects dashboardPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects receiveFromDeliveryAgentsPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.AreaChangeModulePageObjects areaChangeModulePageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.PartialModulePageObjects partialModulePageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.UnScannedSectionPageObjects unScannedSectionPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.ScannedSectionPageObjects scannedSectionPageObjects;

    private Random random;
    private String hubName;
    private String agentName;
    private String trackingId;
    private String cash;
    private String amount;

    @BeforeClass(alwaysRun = true)
    public void receiveProblematicParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Receive Problematic Parcel Page Tests Before Class");
        driver = getBaseDriver();
        random = new Random();
        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveFromDeliveryAgentsPageObjects = new ReceiveFromDeliveryAgentsPageObjects(driver);
        areaChangeModulePageObjects = receiveFromDeliveryAgentsPageObjects.new AreaChangeModulePageObjects();
        partialModulePageObjects = receiveFromDeliveryAgentsPageObjects.new PartialModulePageObjects();
        unScannedSectionPageObjects = receiveFromDeliveryAgentsPageObjects.new UnScannedSectionPageObjects();
        scannedSectionPageObjects = receiveFromDeliveryAgentsPageObjects.new ScannedSectionPageObjects();

        hubName = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_HUB_NAME);
        agentName = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_AGENT_NAME);
        trackingId = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_TRACKING_ID);

//        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickReceiveModule();
        receiveFromDeliveryAgentsPageObjects.chooseHubInput(hubName);
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 301)
    public void verifyChooseAgentFunctionality()
    {
        System.out.println("Verifying Choose Agent Functionality");
        receiveFromDeliveryAgentsPageObjects.chooseAgent(agentName);
        String title = receiveFromDeliveryAgentsPageObjects.getTitleValue();
        System.out.println("Title : " + title);
        Assert.assertTrue(title.contains(agentName));
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 302,enabled = false)
    public void verifyAreaChangeFunctionality()
    {
        System.out.println("Verifying Area Change Functionality");
        areaChangeModulePageObjects.performAreaChange(trackingId,"Kalabagan");
        String status = scannedSectionPageObjects.getStatusValue(1);
        System.out.println("Status : " + status);
        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        Assert.assertEquals(status,"Area Change");
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 303,enabled = false)
    public void verifyPartialDeliveryButtonFunctionality()
    {
        System.out.println("Verifying Partial Delivery Button Functionality");
        cash = receiveFromDeliveryAgentsPageObjects.getCashValue(trackingId);
        System.out.println("Cash : " + cash);
        partialModulePageObjects.clickPartialButton(trackingId);
        String title = partialModulePageObjects.getModalTitleValue();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Partial Amount");

        amount = String.valueOf(random.nextInt(Integer.parseInt(cash)));
        System.out.println("Partial Amount : " + amount);
        partialModulePageObjects.enterAmountInput(amount);
        partialModulePageObjects.clickSaveButton();
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 304)
    public void verifyPartialDeliveryFunctionality() throws Exception
    {
        System.out.println("Verifying Partial Delivery Functionality");
        amount = PropertyReader.getValueOfKey(PropertyReader.Keys.PARTIAL_DELIVERY_AMOUNT);

        String deliveredParcelId = unScannedSectionPageObjects.getTrackingIdValue(1);
        String deliveredParcelCash = unScannedSectionPageObjects.getCashValue(1);
        String returnParcelId = scannedSectionPageObjects.getTrackingIdValue(1);
        String returnParcelCash = scannedSectionPageObjects.getCashValue(1);

        System.out.println("Delivered Parcel Id : " + deliveredParcelId);
        System.out.println("Delivered Parcel Cash : " + deliveredParcelCash);
        System.out.println("Return Parcel Id : " + returnParcelId);
        System.out.println("Return Parcel Cash : " + returnParcelCash);

        receiveFromDeliveryAgentsPageObjects.clickCashReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();

        Assert.assertEquals(deliveredParcelId,trackingId);
        Assert.assertFalse(deliveredParcelId.equals(returnParcelId));
        Assert.assertEquals(deliveredParcelCash,amount);
        Assert.assertEquals(returnParcelCash,"0");
    }

    @AfterClass(alwaysRun = true)
    public void receiveProblematicParcelPageTestsAfterClass()
    {
        System.out.println("Receive Problematic Parcel Page Tests After Class");
        dashboardPageObjects.clickShopUpLogo();
    }
}
