package slackBugAutomation;

import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import pageObjects.DispatchModulePageObjects;
import utils.*;

public class DispatchParcelPageTests extends SapBaseClass {

    private WebDriver driver;
    private DashboardPageObjects dashboardPageObjects;
    private DispatchModulePageObjects dispatchModulePageObjects;
    private DispatchModulePageObjects.DispatchAgentPageObjects dispatchAgentPageObjects;

    private String hubName;
    private String agentName;
    private String trackingId;

    @BeforeClass(alwaysRun = true)
    public void dispatchParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Dispatch Parcel Page Tests Before Class");
        driver = getBaseDriver();
        dashboardPageObjects = new DashboardPageObjects(driver);
        dispatchModulePageObjects = new DispatchModulePageObjects(driver);
        dispatchAgentPageObjects = dispatchModulePageObjects.new DispatchAgentPageObjects();

        hubName = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_HUB_NAME);
        agentName = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_AGENT_NAME);
        trackingId = PropertyReader.getValueOfKey(PropertyReader.Keys.DELIVERY_FLOW_TRACKING_ID);

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickDispatchModule();
        dispatchModulePageObjects.enterHubInput(hubName);
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 201)
    public void verifyDispatchAgentParcelsButtonFunctionality()
    {
        System.out.println("Verifying Dispatch Agent Parcels Button Functionality");
        dispatchAgentPageObjects.clickParcelsButton();
        String title = dispatchAgentPageObjects.getTitleValue();
        System.out.println("Title : " + title);
//        Assert.assertTrue(title.contains(""));
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 202)
    public void verifyScanParcelFunctionality()
    {
        dispatchAgentPageObjects.selectAgentOption(agentName);
        dispatchAgentPageObjects.enterScanParcelInput(trackingId);
        int parcels = Integer.parseInt(dispatchAgentPageObjects.getAssignedParcelsValue(agentName));
        Assert.assertTrue(parcels>0);
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 203)
    public void verifyDispatchAgentFunctionality()
    {
        dispatchAgentPageObjects.clickShowParcelsButton(agentName);
        String id = dispatchAgentPageObjects.getTrackingIdValue(1);
        System.out.println("Scanned Parcel : " + id);
        dispatchAgentPageObjects.clickSkipQrScanButton();
        Boolean assertValue = dispatchAgentPageObjects.isScanned(1);
        dispatchAgentPageObjects.clickDispatchAgentButton();
        Assert.assertEquals(id,trackingId);
        Assert.assertTrue(assertValue);
    }

    @AfterClass(alwaysRun = true)
    public void dispatchParcelPageTestsAfterClass()
    {
        System.out.println("Dispatch Parcel Page Tests After Class");
        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickShopUpLogo();
    }
}
