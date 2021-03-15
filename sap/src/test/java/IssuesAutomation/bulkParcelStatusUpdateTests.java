package IssuesAutomation;

import coreUtils.CoreConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.sapMethods.GetSapApiResponses;
import services.responseModels.sapModels.ReceiveParcelsListModel;
import utils.SapBaseClass;

import java.util.*;

public class bulkParcelStatusUpdateTests extends SapBaseClass {

    private WebDriver driver;
    private Actions actions;
    private SAPPanelPageObject sapPanelPageObject;
    private DashboardPageObjects dashboardPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects receiveFromDeliveryAgentsPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.HoldModulePageObjects holdModulePageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.AreaChangeModulePageObjects areaChangeModulePageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.ReturnedModulePageObjects returnedModulePageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.DeliveredModulePageObjects deliveredModulePageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private GetSapApiResponses getSapApiResponses;
    private ReceiveParcelsListModel receiveParcelsListModel;
    private String cookie;

    private String shopName = "Bulk Parcel Status Update Test Shop";
    private String hubName = "Kalabagan Hub";
    private String agent = "Abdul Alim - kalabagan";
    private int shopId;
    private List<String> invoiceNumbers;
    private List<String> trackingIds;
    private List<Integer> parcelsIds;
    private Map reason;
    private int holdParcels = 0;
    private int areaChangeParcels = 0;
    private int returnedParcels = 0;
    private int deliveredParcels = 0;

    @BeforeSuite(alwaysRun = true)
    public void bulkParcelStatusUpdateTestsBeforeSuite() throws Exception
    {
        System.out.println("Sap Before Suite is called");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getSapBaseUrl());
        setImplicitWait(10000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void bulkParcelStatusUpdateTestsBeforeClass()
    {
        System.out.println("Bulk Parcel Status Update Test Before Class");

        actions = new Actions(driver);
        sapPanelPageObject = new SAPPanelPageObject(driver);
        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveFromDeliveryAgentsPageObjects = new ReceiveFromDeliveryAgentsPageObjects(driver);
        receiveParcelsListModel = new ReceiveParcelsListModel();
        holdModulePageObjects = receiveFromDeliveryAgentsPageObjects.new HoldModulePageObjects();
        areaChangeModulePageObjects = receiveFromDeliveryAgentsPageObjects.new AreaChangeModulePageObjects();
        returnedModulePageObjects = receiveFromDeliveryAgentsPageObjects.new ReturnedModulePageObjects();
        deliveredModulePageObjects = receiveFromDeliveryAgentsPageObjects.new DeliveredModulePageObjects();

        cookie = sapPanelPageObject.performAuthentication("01401122188","6666");
        System.out.println("Cookie : " + cookie);

        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        getSapApiResponses = new GetSapApiResponses("sap");

        invoiceNumbers  = new ArrayList<>();
//        invoiceNumbers = Arrays.asList("123101","123102","123103","123104","123105","123106","123107","123108","123109","123110","123111","123112","123113","123114","123115","123116","123117","123118","123119","123120","123121","123122","123123","123124","123125","123126","123127","123128","123129","123130","123131","123132","123133","123134","123135","123136","123137","123138","123139","123140","123141","123142","123143","123144","123145","123146","123147","123148","123149","123150","123151","123152","123153","123154","123155","123156","123157","123158","123159","123160");
        parcelsIds  = new ArrayList<>();
        trackingIds  = new ArrayList<>();
        reason = new HashMap();

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickRecieveModule();

        sleep(2000);
        actions.sendKeys(Keys.ESCAPE).build().perform();
        sleep(1000);
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    @BeforeMethod(alwaysRun = true)
    public void bulkParcelStatusUpdateTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");

        System.out.println("Bulk Parcel Status Update Test Before Method \n");
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/parcels.csv";
        shopId = getRedxApiResponse.getShopId(shopName);

        invoiceNumbers = getSapApiResponses.uploadFilePostCall(shopId,filePath);
        System.out.println("\n Invoice Numbers : " + invoiceNumbers.toString() + "\n");

        receiveFromDeliveryAgentsPageObjects.chooseHubInput(hubName);

        receiveParcelsListModel = getSapApiResponses.getParcelsReceiveHub(shopId);
        int parcelSize = receiveParcelsListModel.getParcels().size();

        while(parcelSize<invoiceNumbers.size())
        {
            System.out.println("\nWaiting for Loading");
            sleep(3000);
            receiveParcelsListModel = getSapApiResponses.getParcelsReceiveHub(shopId);
            parcelSize = receiveParcelsListModel.getParcels().size();
            System.out.println("Parcel Size : " + parcelSize);
        }

        parcelsIds = getSapApiResponses.getParcelIds(receiveParcelsListModel,invoiceNumbers);
        System.out.println("\n Parcel Ids :" + parcelsIds.toString());
        trackingIds = getSapApiResponses.getTrackingIds(receiveParcelsListModel,invoiceNumbers);
        System.out.println("\n Tracking Ids :" + trackingIds.toString() + "\n");

        getSapApiResponses.receiveParcels(trackingIds);
        getSapApiResponses.assignAgent(trackingIds);
        getSapApiResponses.dispatchParcelsToAgent(trackingIds);

        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 1 )
    public void verifyDeliveryAndHoldStatusUpdate()
    {
        System.out.println("Verifying Delivery And Hold Status Update");

        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        String currentDateTime;
        int i;

        deliveredParcels = trackingIds.size()*90/100;
        holdParcels = trackingIds.size()-deliveredParcels;

        System.out.println("Parcels To Be Delivered : " + deliveredParcels);
        System.out.println("Parcels To Be Hold : " + holdParcels);

        for(i=0;i<deliveredParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("delivered",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","delivery-payment-collected");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        reason = getSapApiResponses.getRandomReason("hold");

        for(i=deliveredParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("hold",trackingIds.get(i),reason);

            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","on-hold");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickCashReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Delivery Current Date Time : " + currentDateTime);
        for(i=0;i<deliveredParcels;i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println("Hold Current Date Time : " + currentDateTime);
        for(i=deliveredParcels;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue);

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 2 )
    public void verifyHoldAndReturnStatusUpdate()
    {
        System.out.println("Verifying Hold And Return Status Update");

        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        String currentDateTime;
        int i;

        holdParcels = trackingIds.size()*90/100;
        returnedParcels = trackingIds.size()-holdParcels;

        System.out.println("Parcels To Be Hold : " + holdParcels);
        System.out.println("Parcels To Be Returned : " + returnedParcels);

        reason = getSapApiResponses.getRandomReason("hold");

        for(i=0;i<holdParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("hold",trackingIds.get(i),reason);

            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","on-hold");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        reason = getSapApiResponses.getRandomReason("return");

        for(i=holdParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("return",trackingIds.get(i),reason);

            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","shopup-returning");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Current Date Time : " + currentDateTime);
        for(i=0;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue);

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 3 )
    public void verifyHoldAndAreaChangeStatusUpdate()
    {
        System.out.println("Verifying Hold And Area Change Status Update");

        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        String currentDateTime;
        int i;

        holdParcels = trackingIds.size()*90/100;
        areaChangeParcels = trackingIds.size()-holdParcels;

        System.out.println("Parcels To Be Hold : " + holdParcels);
        System.out.println("Parcels To Be Area Changed : " + areaChangeParcels);

        reason = getSapApiResponses.getRandomReason("hold");

        for(i=0;i<holdParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("hold",trackingIds.get(i),reason);

            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","on-hold");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        for(i=holdParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("areaChange",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","area-change-received");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Current Date Time : " + currentDateTime);
        for(i=0;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue);

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 4 )
    public void verifyDeliveredAndReturnedStatusUpdate()
    {
        System.out.println("Verifying Delivered And Returned Status Update");
        String currentDateTime;
        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        Map parcel = new HashMap();
        int i;

        deliveredParcels = trackingIds.size()*90/100;
        returnedParcels = trackingIds.size()-deliveredParcels;

        System.out.println("Parcels To Be Delivered : " + deliveredParcels);
        System.out.println("Parcels To Be Returned : " + returnedParcels);

        for(i=0;i<deliveredParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("delivered",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","delivery-payment-collected");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        reason = getSapApiResponses.getRandomReason("return");
        for(i=deliveredParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("return",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","shopup-returning");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickCashReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Delivery Current Date Time : " + currentDateTime);
        for(i=0;i<deliveredParcels;i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println("Returned Current Date Time : " + currentDateTime);
        for(i=deliveredParcels;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue.toString());

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 5 )
    public void verifyDeliveredAndAreaChangeStatusUpdate()
    {
        System.out.println("Verifying Delivered And Area Change Status Update");
        String currentDateTime;
        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        Map parcel = new HashMap();
        int i;

        deliveredParcels = trackingIds.size()*90/100;
        areaChangeParcels = trackingIds.size()-deliveredParcels;

        System.out.println("Parcels To Be Delivered : " + deliveredParcels);
        System.out.println("Parcels To Be Area Changed : " + areaChangeParcels);

        for(i=0;i<deliveredParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("delivered",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","delivery-payment-collected");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        for(i=deliveredParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("areaChange",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","area-change-received");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickCashReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Delivery Current Date Time : " + currentDateTime);
        for(i=0;i<deliveredParcels;i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println("Area Current Date Time : " + currentDateTime);
        for(i=deliveredParcels;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue.toString());

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 6 )
    public void verifyReturnedAndAreaChangeStatusUpdate()
    {
        System.out.println("Verifying Returned And Area Change Status Update");

        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        String currentDateTime;
        int i;

        returnedParcels = trackingIds.size()*90/100;
        areaChangeParcels = trackingIds.size()-returnedParcels;

        System.out.println("Parcels To Be Returned : " + returnedParcels);
        System.out.println("Parcels To Be Area Changed : " + areaChangeParcels);

        reason = getSapApiResponses.getRandomReason("return");

        for(i=0;i<returnedParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("return",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","shopup-returning");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        for(i=returnedParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("areaChange",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","area-change-received");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Current Date Time : " + currentDateTime);
        for(i=0;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue);

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 7 )
    public void verifyHoldAndDeliveryStatusUpdate()
    {
        System.out.println("Verifying Hold And Delivery Status Update");

        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        String currentDateTime;
        int i;

        holdParcels = trackingIds.size()*90/100;
        deliveredParcels = trackingIds.size()-holdParcels;

        System.out.println("Parcels To Be Delivered : " + deliveredParcels);
        System.out.println("Parcels To Be Hold : " + holdParcels);

        reason = getSapApiResponses.getRandomReason("hold");

        for(i=0;i<holdParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("hold",trackingIds.get(i),reason);

            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","on-hold");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }


        for(i=holdParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("delivered",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","delivery-payment-collected");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickCashReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Delivery Current Date Time : " + currentDateTime);
        for(i=holdParcels;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println("Hold Current Date Time : " + currentDateTime);
        for(i=0;i<holdParcels;i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue);

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 8 )
    public void verifyReturnedAndHoldStatusUpdate()
    {
        System.out.println("Verifying Return And Hold Status Update");

        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        String currentDateTime;
        int i;

        returnedParcels = trackingIds.size()*90/100;
        holdParcels = trackingIds.size()-returnedParcels;

        System.out.println("Parcels To Be Hold : " + holdParcels);
        System.out.println("Parcels To Be Returned : " + returnedParcels);

        reason = getSapApiResponses.getRandomReason("return");

        for(i=0;i<returnedParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("return",trackingIds.get(i),reason);

            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","shopup-returning");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        reason = getSapApiResponses.getRandomReason("hold");

        for(i=returnedParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("hold",trackingIds.get(i),reason);

            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","on-hold");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Current Date Time : " + currentDateTime);
        for(i=0;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue);

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 9 )
    public void verifyAreaChangeAndHoldStatusUpdate()
    {
        System.out.println("Verifying Area Change And Hold Status Update");

        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        String currentDateTime;
        int i;

        areaChangeParcels = trackingIds.size()*90/100;
        holdParcels = trackingIds.size()-areaChangeParcels;

        System.out.println("Parcels To Be Hold : " + holdParcels);
        System.out.println("Parcels To Be Area Changed : " + areaChangeParcels);

        for(i=0;i<areaChangeParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("areaChange",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","area-change-received");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        reason = getSapApiResponses.getRandomReason("hold");

        for(i=areaChangeParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("hold",trackingIds.get(i),reason);

            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","on-hold");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Current Date Time : " + currentDateTime);
        for(i=0;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue);

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 10 )
    public void verifyReturnedAndDeliveredStatusUpdate()
    {
        System.out.println("Verifying Returned And Delivered Status Update");
        String currentDateTime;
        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        Map parcel = new HashMap();
        int i;

        returnedParcels = trackingIds.size()*90/100;
        deliveredParcels = trackingIds.size()-returnedParcels;

        System.out.println("Parcels To Be Delivered : " + deliveredParcels);
        System.out.println("Parcels To Be Returned : " + returnedParcels);

        reason = getSapApiResponses.getRandomReason("return");
        for(i=0;i<returnedParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("return",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","shopup-returning");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        for(i=returnedParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("delivered",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","delivery-payment-collected");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickCashReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Delivery Current Date Time : " + currentDateTime);
        for(i=returnedParcels;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println("Returned Current Date Time : " + currentDateTime);
        for(i=0;i<returnedParcels;i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue.toString());

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority =11 )
    public void verifyAreaChangeAndDeliveredStatusUpdate()
    {
        System.out.println("Verifying Area Change And Delivered Status Update");
        String currentDateTime;
        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        Map parcel = new HashMap();
        int i;

        areaChangeParcels = trackingIds.size()*90/100;
        deliveredParcels = trackingIds.size()-areaChangeParcels;

        System.out.println("Parcels To Be Delivered : " + deliveredParcels);
        System.out.println("Parcels To Be Area Changed : " + areaChangeParcels);

        for(i=0;i<areaChangeParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("areaChange",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","area-change-received");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        for(i=areaChangeParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("delivered",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","delivery-payment-collected");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickCashReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Delivery Current Date Time : " + currentDateTime);
        for(i=areaChangeParcels;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println("Area Current Date Time : " + currentDateTime);
        for(i=0;i<areaChangeParcels;i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue.toString());

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION},priority = 12 )
    public void verifyAreaChangeAndReturnedStatusUpdate()
    {
        System.out.println("Verifying Area Change And Returned Status Update");

        List<Map> parcelActionsUiValue = new ArrayList<>();
        List<Map> parcelActionsApiValue = new ArrayList<>();
        String currentDateTime;
        int i;

        returnedParcels = trackingIds.size()*90/100;
        areaChangeParcels = trackingIds.size()-returnedParcels;

        System.out.println("Parcels To Be Returned : " + returnedParcels);
        System.out.println("Parcels To Be Area Changed : " + areaChangeParcels);

        for(i=0;i<areaChangeParcels;i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("areaChange",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","area-change-received");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        reason = getSapApiResponses.getRandomReason("return");

        for(i=areaChangeParcels;i<trackingIds.size();i++)
        {
            Map parcels = new HashMap();
            getSapApiResponses.parcelActionPutCall("return",trackingIds.get(i),reason);
            parcels.put("TRACKING_ID",trackingIds.get(i));
            parcels.put("PARCEL_ID",parcelsIds.get(i));
            parcels.put("CLOSING_STATUS","shopup-returning");
//            parcels.put("CLOSING_TIME",receiveFromDeliveryAgentsPageObjects.getCurrentDateTime());
            parcelActionsUiValue.add(parcels);
        }

        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();

        receiveFromDeliveryAgentsPageObjects.clickParcelReceivedButton();
        receiveFromDeliveryAgentsPageObjects.clickYesButton();

        currentDateTime = receiveFromDeliveryAgentsPageObjects.getCurrentDateTime();
        System.out.println();
        System.out.println("Current Date Time : " + currentDateTime);
        for(i=0;i<trackingIds.size();i++)
            parcelActionsUiValue.get(i).put("CLOSING_TIME",currentDateTime);

        System.out.println();
        sleep(3000);
        parcelActionsApiValue = getSapApiResponses.getReconciliationStatuses(trackingIds);

        System.out.println("Ui Value : " + parcelActionsUiValue.toString());
        System.out.println("Api Value : " + parcelActionsApiValue);

        Assert.assertEquals(parcelActionsUiValue,parcelActionsApiValue);
    }

    @AfterMethod(alwaysRun = true)
    public void bulkParcelStatusUpdateTestsAfterMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");

        System.out.println("Bulk Parcel Status Update Test After Method");
        driver.navigate().back();
    }

    @AfterSuite(alwaysRun = true)
    public void bulkParcelStatusUpdateTestsAfterSuite()
    {
        System.out.println("Bulk Parcel Status Update Test After Suite");
        driver.quit();
    }
}
