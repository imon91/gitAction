package slackBugAutomation;

import dataParcer.CSVParser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.CreateParcelModel;
import services.sapMethods.GetSapApiResponses;
import utils.*;

import java.util.*;

public class ExchangeReturnTests extends SapBaseClass {

    private WebDriver driver;
    private DashboardPageObjects dashboardPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects receiveFromDeliveryAgentsPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.ExchangeModalPageObjects exchangeModalPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.UnScannedSectionPageObjects unScannedSectionPageObjects;
    private ReceiveFromDeliveryAgentsPageObjects.ScannedSectionPageObjects scannedSectionPageObjects;
    private GetRedxApiResponse getRedxApiResponse;
    private GetSapApiResponses getSapApiResponses;
    private CreateParcelModel createParcelModel;

    private String shopName = "Slack Bug Test Shop";
    private String hubName = "Kalabagan Hub";
    private String agent = "Abdul Alim - Kalabagan";
    private String trackingId;
    private String customerName;

    @BeforeClass(alwaysRun = true)
    public void exchangeReturnTestsBeforeClass() throws Exception
    {
        System.out.println("Exchange Return Tests Before Class");
        driver = getBaseDriver();
        dashboardPageObjects = new DashboardPageObjects(driver);
        receiveFromDeliveryAgentsPageObjects = new ReceiveFromDeliveryAgentsPageObjects(driver);
        exchangeModalPageObjects = receiveFromDeliveryAgentsPageObjects.new ExchangeModalPageObjects();
        unScannedSectionPageObjects = receiveFromDeliveryAgentsPageObjects.new UnScannedSectionPageObjects();
        scannedSectionPageObjects = receiveFromDeliveryAgentsPageObjects.new ScannedSectionPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        getSapApiResponses = new GetSapApiResponses("sap");
        createParcelModel = new CreateParcelModel();

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickReceiveModule();
    }

    @BeforeMethod(alwaysRun = true)
    public void exchangeReturnTestsBeforeMethod() throws Exception
    {
        System.out.println("Exchange Return Tests Before Method");

        Map createParcelBody = new HashMap();

        List<HashMap<String, Object>> list = CSVParser.getHashListForDataPath(SapFileUtils.createParcelData);

        int num = Integer.parseInt(PropertyReader.getValueOfKey(PropertyReader.Keys.CUSTOMER_NAME)) + 1;
        list.get(0).put("CUSTOMER_NAME",list.get(0).get("CUSTOMER_NAME") + String.valueOf(num));
        customerName = String.valueOf(list.get(0).get("CUSTOMER_NAME"));
        createParcelBody.put("parcels",list);
        PropertyReader.setValue(PropertyReader.Keys.CUSTOMER_NAME,String.valueOf(num));

        createParcelModel = getRedxApiResponse.createParcelPostCall(shopName,createParcelBody);
        trackingId =  createParcelModel.getBody().getTrackingId();

        System.out.println("Tracking ID : " + trackingId);

        getSapApiResponses.receiveParcels(Collections.singletonList(trackingId));
        getSapApiResponses.assignAgent(Collections.singletonList(trackingId));
        getSapApiResponses.dispatchParcelsToAgent(Collections.singletonList(trackingId));

//        receiveFromDeliveryAgentsPageObjects.chooseHubInput(hubName);
        receiveFromDeliveryAgentsPageObjects.chooseAgent(agent);
        receiveFromDeliveryAgentsPageObjects.clickParcelsButton();
    }

    @Test(priority = 21)
    public void verifyExchangeFunctionality()
    {
        System.out.println("Verifying Exchange Functionality");
        String[] name = new String[2];
        String[] trackingIds = new String[3];
        String status;

        receiveFromDeliveryAgentsPageObjects.clickExchangeButton(trackingId);
        exchangeModalPageObjects.clickExchangeWithoutDeliveredInput();
        trackingIds[0]=exchangeModalPageObjects.getTrackingIdValue();
        exchangeModalPageObjects.clickSubmitButton();

        sleep(2000);

        name[0] = unScannedSectionPageObjects.getNameValue(1);
        trackingIds[1] = unScannedSectionPageObjects.getTrackingIdValue(1);

        name[1] = scannedSectionPageObjects.getNameValue(1);
        trackingIds[2] = scannedSectionPageObjects.getTrackingIdValue(1);
        status = scannedSectionPageObjects.getStatusValue(1);

        System.out.println("Names : " + Arrays.toString(name));
        System.out.println("Tracking Ids : " + Arrays.toString(trackingIds));
        System.out.println("Status : " + status);

        Assert.assertTrue(name[0].equals(name[1]),"Names Not Equal");
        Assert.assertFalse(trackingIds[1].equals(trackingIds[2]),"Tracking Ids Are Equal");
        Assert.assertEquals(name[0],customerName,"Names Not Matching");
        Assert.assertEquals(trackingIds[1],trackingIds[0],"Tracking Ids Not Equal");
        Assert.assertEquals(status,"Return","Status Not Matching");
    }
}