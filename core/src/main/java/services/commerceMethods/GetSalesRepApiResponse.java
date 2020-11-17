package services.commerceMethods;

import com.google.gson.Gson;
import io.restassured.response.Response;
import services.responseModels.commerceModels.*;
import services.serviceUtils.ShopUpPostMan;

import java.util.*;

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

    public List<String> getShopDetails_Backend(){
        response = shopUpPostMan.getCall("profiles/0/edit.json");
        MokamUserProfileModel mokamUserProfileModel = gson.fromJson(response.getBody().asString(),MokamUserProfileModel.class);
        List<String> arrayList = new ArrayList<>();
        arrayList.add(0,mokamUserProfileModel.getShop_name());
        arrayList.add(1,mokamUserProfileModel.getName());
        arrayList.add(2,mokamUserProfileModel.getPhone());
        arrayList.add(3,mokamUserProfileModel.getBusiness_type());
        return arrayList;
    }

    public MokamUserAddressesModel getAddressesModel(){
        response = shopUpPostMan.getCall("user/get_addresses.json");
        MokamUserAddressesModel mokamUserAddressesModel = gson.fromJson(response.getBody().asString(),MokamUserAddressesModel.class);
        return mokamUserAddressesModel;
    }

}
