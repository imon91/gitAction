package IssuesAutomation;

import io.restassured.response.*;
import org.testng.annotations.*;
import services.redxMethods.GetRedxApiResponse;
import services.sapMethods.GetSapApiResponses;
import utils.SapBaseClass;

public class MultiplePickupTests extends SapBaseClass {

    private GetRedxApiResponse getRedxApiResponse;
    private GetSapApiResponses getSapApiResponses;

    private String shopName = "RedX Web Sanity Test Shop";
    private String hubName = "Kalabagan Hub";
    private String agentName = "Abdul Alim - kalabagan";
    private String storeName = "Dhanmondi";

    @BeforeClass(alwaysRun = true)
    public void multiplePickupTestsBeforeClass()
    {
        System.out.println("Multiple Pickup Tests Before Class");
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        getSapApiResponses = new GetSapApiResponses("sap");
    }

    @Test
    public void verifyMultiplePickup()
    {
        System.out.println("Verifying Multiple Pickup");
        int agentId = getSapApiResponses.getAgentId(hubName,agentName);
        int shopId = getRedxApiResponse.getShopId(shopName);
        int storeId = getRedxApiResponse.getStoreId(shopName,storeName);
        Response response = getSapApiResponses.pickupAgentPutCall(agentId,shopId,storeId);
//        System.out.println(response.getBody().asString());
    }
}
