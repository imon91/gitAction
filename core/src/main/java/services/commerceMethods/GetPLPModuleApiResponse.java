package services.commerceMethods;

import com.google.gson.Gson;
import coreUtils.CoreConstants;
import io.restassured.response.Response;
import services.responseModels.commerceModels.ProductListingResultsModel;
import services.serviceUtils.*;

import java.util.*;

public class GetPLPModuleApiResponse {

        private ShopUpPostMan shopUpPostMan;
        private String module;
        private Gson gson;
        private Response response;

        public GetPLPModuleApiResponse(String module) {
            this.module = module;
            shopUpPostMan = new ShopUpPostMan(module);
            gson = new Gson();
        }


        public ProductListingResultsModel getProductListingPageResults(String searchName,int k)
        {
            response = shopUpPostMan.getCall(EndPoints.SEARCH_FOR_USER+"term="+searchName+"&page="+k);
            ProductListingResultsModel productListingResultsModel =
                    gson.fromJson(response.getBody().asString(),ProductListingResultsModel.class);
            return productListingResultsModel;
        }




    }


