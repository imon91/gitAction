package services.commerceMethods;

import com.google.gson.Gson;
import io.restassured.response.Response;
import services.serviceUtils.ShopUpPostMan;

public class GetAuthenticationApiResponse {


    private ShopUpPostMan shopUpPostMan;
    private String module;
    private Gson gson;
    private Response response;

    public GetAuthenticationApiResponse(String module){
        this.module = module;
        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
    }


    public void performAuthentication(){
        shopUpPostMan.performAuthenticationInShopUpPostman();
    }
}
