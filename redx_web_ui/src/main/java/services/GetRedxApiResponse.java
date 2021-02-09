package services;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import services.serviceUtils.ShopUpPostMan;

public class GetRedxApiResponse {
    private ShopUpPostMan shopUpPostMan;
    private String module;
    private Gson gson;

    public GetRedxApiResponse(String module)
    {
        this.module = module;
//        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
    }

    public OverviewModel overviewGetCall(String cookie,long since,long until)
    {
        String overviewGetCall = "https://apiredx.shopups1.xyz/v1/admin/shop/532439/logistics/dashboard/overview?since=" + since + "&until=" + until;
//        Response getOverviewResponse = shopUpPostMan.getCall(overviewGetCall);
        Response response = RestAssured.given()
                .header("cookie",cookie).when().get(overviewGetCall);
        OverviewModel overviewModel = gson.fromJson(response.getBody().asString(),OverviewModel.class);
        return  overviewModel;
    }

    public OverviewModel overviewGetCall(String cookie,long since,long until,long storeId)
    {
        String overviewGetCall = "https://apiredx.shopups1.xyz/v1/admin/shop/532439/logistics/dashboard/overview?since=" + since + "&until=" + until + "&shopStoreId=" + storeId;
//        Response getOverviewResponse = shopUpPostMan.getCall(overviewGetCall);
        Response response = RestAssured.given()
                .header("cookie",cookie).when().get(overviewGetCall);
        OverviewModel overviewModel = gson.fromJson(response.getBody().asString(),OverviewModel.class);
        return  overviewModel;
    }
}
