package services.commerceMethods;

import com.google.gson.Gson;
import io.restassured.response.Response;
import services.responseModels.commerceModels.ProductDescriptionModel;
import services.serviceUtils.EndPoints;
import services.serviceUtils.ShopUpPostMan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetPDPModuleApiResponse {

        private ShopUpPostMan shopUpPostMan;
        private String module;
        private Gson gson;
        private Response response;

        public GetPDPModuleApiResponse(String module){
            this.module = module;
            shopUpPostMan = new ShopUpPostMan(module);
            gson = new Gson();
        }

        public Map<String,Object> getProductDetails_Code_Category_CountOnHand_price(String slug){
            Map<String ,Object> productDetails= new HashMap<>();
            response = shopUpPostMan.getCall(EndPoints.RECOMMENDATIONS+slug+".json");
            ProductDescriptionModel productDescriptionModel =
                    gson.fromJson(response.getBody().asString(),ProductDescriptionModel.class);
            productDetails.put("brand",productDescriptionModel.getBrand());
            productDetails.put("category",productDescriptionModel.getCategory());
            productDetails.put("code",productDescriptionModel.getCode());
            productDetails.put("price",productDescriptionModel.getPrice());
            productDetails.put("size",productDescriptionModel.getSizes().get(0).getName());
            productDetails.put("sizePrice",productDescriptionModel.getSizes().get(0).getPrice());
            return productDetails;
        }



}
