package services.commerceMethods;

import com.google.gson.*;
import io.restassured.response.*;
import services.responseModels.commerceModels.*;
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

        public ProductListingResultsModel getProductResultsAfterFilter(String searchTerm,String filterKey, String filterId,int k)
        {
            String createdFilter = null;
            switch (filterKey.toLowerCase()) {
                case "category":
                    createdFilter = "filter_category[]";
                    break;
                case "price":
                    createdFilter = "filter_price[]";
                    break;
                case "discount":
                    createdFilter = "filter_discount[]";
                    break;
            }
            response = shopUpPostMan.
                    getCall(EndPoints.SEARCH_FOR_USER +
                            "term=" + searchTerm +
                            "&page=" + k + "&" + createdFilter + "=" + filterId);
            ProductListingResultsModel productListingResultsModel =
                    gson.fromJson(response.getBody().asString(), ProductListingResultsModel.class);
            return  productListingResultsModel;
        }

    public Map<String,Object> getValidProductWithFilterOnly(String searchTerm,String filterKey, String filterId,int k)
    {   Map<String, Object> productDetailsMap = new HashMap<>();
        ProductListingResultsModel productListingResultsModel = getProductResultsAfterFilter(searchTerm,filterKey,filterId,k);

        for (int i = 0; i < productListingResultsModel.getResults().size(); i++) {
            List<ProductListingResultsModel.ResultsBean.SizesBean> productSizes =
                    productListingResultsModel.getResults().get(i).getSizes();
            for (int j = 0; j < productSizes.size(); j++) {
                if (productSizes.get(j).getCount_on_hand() > 0 &&
                        productSizes.get(j).getCorrected_count_on_hand() > 0) {
                    // This is a product with valid
                    productDetailsMap.put("ValidProductIndex", i);
                    productDetailsMap.put("ValidProductDetails", productListingResultsModel.getResults().get(i));
                    productDetailsMap.put("ValidSizeIndex", j);
                    productDetailsMap.put("ProductCount",productListingResultsModel.getProducts_count());
                    System.out.println(productListingResultsModel.getResults().get(i));
                    return productDetailsMap;
                }
            }
        }
        return null;
    }




    }


