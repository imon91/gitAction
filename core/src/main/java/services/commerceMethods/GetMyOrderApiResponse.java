package services.commerceMethods;

import com.google.gson.Gson;
import io.restassured.response.*;
import services.responseModels.commerceModels.*;
import services.serviceUtils.*;

public class GetMyOrderApiResponse {


    private ShopUpPostMan shopUpPostMan;
    private String module;
    private Gson gson;
    private Response response;

    public GetMyOrderApiResponse(String module) {
        this.module = module;
        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
    }

    public MyOrderModel getOrderDetailsInActiveTab(int k)
    {
        response= shopUpPostMan.getCall("orders/myorders_v2.json?page="+k+"&per_page=200&list=active");
        MyOrderModel myOrderModel = gson.fromJson(response.getBody().asString(),MyOrderModel.class);
        return myOrderModel;
    }

}
