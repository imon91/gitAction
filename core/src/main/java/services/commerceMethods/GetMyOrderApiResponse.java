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
        response= shopUpPostMan.getCall("orders/myorders_v2.json?page="+k+"&per_page=15&list=active");
        MyOrderModel myOrderModel = gson.fromJson(response.getBody().asString(),MyOrderModel.class);
        return myOrderModel;
    }

    public MyOrderDetailsModel getOrderDetailsOfOrderId(String orderId)
    {
        response=shopUpPostMan.getCall("orders/order_details.json?number="+orderId);
        MyOrderDetailsModel myOrderDetailsModel = gson.fromJson(response.getBody().asString(),MyOrderDetailsModel.class);
        return myOrderDetailsModel;
    }

    public MyOrderDetailsNewModel getOrderDetailOfOrder(String orderId){
        response = shopUpPostMan.getCall("orders/order_details.json?number="+orderId);
        MyOrderDetailsNewModel myOrderDetailsNewModel = gson.fromJson(response.getBody().asString(),MyOrderDetailsNewModel.class);
        return myOrderDetailsNewModel;
    }

}
