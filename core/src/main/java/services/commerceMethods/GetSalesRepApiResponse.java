package services.commerceMethods;

import com.google.gson.Gson;
import io.restassured.response.Response;
import services.responseModels.commerceModels.MokamRetailerListModel;
import services.responseModels.commerceModels.SearchSuggestionsModel;
import services.serviceUtils.ShopUpPostMan;

public class GetSalesRepApiResponse {
    private ShopUpPostMan shopUpPostMan;
    private String module;
    private Gson gson;
    private Response response;


    public GetSalesRepApiResponse(String module) {
        this.module = module;
        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
    }


    public MokamRetailerListModel salesRepRetailerListApi()
    {
        response = shopUpPostMan.getCall("users/get_retailer_list.json");
        MokamRetailerListModel mokamRetailerListModel = gson.fromJson(response.getBody().asString(), MokamRetailerListModel.class);
        return
                mokamRetailerListModel;

    }
}
