package services.commerceMethods;

import java.util.*;
import com.google.gson.Gson;
import io.restassured.response.Response;
import services.responseModels.commerceModels.*;
import services.serviceUtils.*;



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

        public ProductListingResultsModel getProductResultsWithFilterOnly(String searchTerm,String filterKey, String filterId,int k)
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

    public ProductListingResultsModel getProductResultsWithSortOnly(String searchTerm,String sortIndex,int k)
    {
        String createdSort = "filter_sort[]";
        response = shopUpPostMan.
                getCall(EndPoints.SEARCH_FOR_USER +
                        "term=" + searchTerm +
                        "&page=" + k + "&" + createdSort + "=" + sortIndex);
        ProductListingResultsModel productListingResultsModel =
                gson.fromJson(response.getBody().asString(), ProductListingResultsModel.class);
        return  productListingResultsModel;
    }


    public ProductListingResultsModel getProductResultsWithFilterAndSortApplied(String searchTerm,String filterKey,
                                                                      String filterId,String sortIndex,int k) {

        // Sample : ?page=1&filter_category[]=2160&filter_sort[]=3
        String createdFilter = null;
        String createdSort = "filter_sort[]";
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
                        "&page=" + k + "&" + createdFilter + "=" + filterId + "&" + createdSort + "=" + sortIndex);

        ProductListingResultsModel productListingResultsModel =
                gson.fromJson(response.getBody().asString(), ProductListingResultsModel.class);
        return productListingResultsModel;
    }



    public ProductDescriptionModel getProductDescriptionPageResults(String slug)
    {
        response = shopUpPostMan.getCall(EndPoints.RECOMMENDATIONS+slug+".json");
        return gson.fromJson(response.getBody().asString(), ProductDescriptionModel.class);
    }



    public Map<String,Object> getValidProductWithFilterOnly(String searchTerm,String filterKey, String filterId,int k)
    {   Map<String, Object> productDetailsMap = new HashMap<>();
        ProductListingResultsModel productListingResultsModel = getProductResultsWithFilterOnly(searchTerm,filterKey,filterId,k);

        for (int i = 0; i < productListingResultsModel.getResults().size(); i++) {
            List<ProductListingResultsModel.ResultsBean.SizesBean> productSizes =
                    productListingResultsModel.getResults().get(i).getSizes();
            if (productSizes.size() < 6) {
                for (int j = 0; j < productSizes.size(); j++) {
                    if (productSizes.get(j).getCount_on_hand() > 0 &&
                            productSizes.get(j).getCorrected_count_on_hand() > 0) {
                        // This is a product with valid
                        productDetailsMap.put("ValidProductIndex", i);
                        productDetailsMap.put("ValidProductDetails", productListingResultsModel.getResults().get(i));
                        productDetailsMap.put("ValidSizeIndex", j);
                        productDetailsMap.put("ProductCount", productListingResultsModel.getProducts_count());
                        System.out.println(productListingResultsModel.getResults().get(i));
                        return productDetailsMap;
                    }
                }
            }
        }
        return null;
    }


    public Map<String,Object> getValidProductWithSortOnly(String searchTerm,String sortIndex,int k)
    {   Map<String, Object> productDetailsMap = new HashMap<>();
        String createdSort = "filter_sort[]";
        response = shopUpPostMan.
                getCall(EndPoints.SEARCH_FOR_USER +
                        "term=" + searchTerm +
                        "&page=" + k + "&" + createdSort + "=" + sortIndex);
    ProductListingResultsModel productListingResultsModel=gson.fromJson(response.getBody().asString(), ProductListingResultsModel.class);

        for (int i = 0; i < productListingResultsModel.getResults().size(); i++) {
            List<ProductListingResultsModel.ResultsBean.SizesBean> productSizes =
                    productListingResultsModel.getResults().get(i).getSizes();
            if (productSizes.size() < 6) {
                for (int j = 0; j < productSizes.size(); j++) {
                    if (productSizes.get(j).getCount_on_hand() > 0 &&
                            productSizes.get(j).getCorrected_count_on_hand() > 0) {
                        // This is a product with valid
                        productDetailsMap.put("ValidProductIndex", i);
                        productDetailsMap.put("ValidProductDetails", productListingResultsModel.getResults().get(i));
                        productDetailsMap.put("ValidSizeIndex", j);
                        productDetailsMap.put("ProductCount", productListingResultsModel.getProducts_count());
                        System.out.println(productListingResultsModel.getResults().get(i));
                        return productDetailsMap;
                    }
                }
            }
        }
        return null;
    }

    public List<Integer> getProductCountOnHand(String item){
        //System.out.println("productListingPageObjects.getNumberOFItemsDisplayedInPLPPage()");
        List<Integer> countList= new ArrayList<>();
        response = shopUpPostMan.getCall(EndPoints.SEARCH_FOR_USER+ "term="+item+"&page=1");
        //System.out.println("after get call");
        ProductListingResultsModel productListingResultsModel = gson.fromJson(response.getBody().asString(),ProductListingResultsModel.class);
        //System.out.println(productListingResultsModel.getResults().size());
        for(int i=0;i<productListingResultsModel.getResults().size();i++){
            countList.add(productListingResultsModel.getResults().get(i).getSizes().get(0).getCount_on_hand());
            //System.out.println(productListingResultsModel.getResults().get(i).getSizes().get(0).getCount_on_hand());
        }
        //System.out.println("Count List Is : "+countList);
        return countList;
    }

    public Map<String , List<Object>> getProductID_Quantity_SellerPriceOFItemsInCart(){
            Map<String , List<Object>> productDetails = new HashMap<>();
            List<Object> productID = new ArrayList<>();
            List<Object> price = new ArrayList<>();
            List<Object> quantity = new ArrayList<>();
            response = shopUpPostMan.getCall(EndPoints.SHOPPING_CART+"v3/get_cart_data.json");
            GetCartDataModel getCartDataModel = gson.fromJson(response.getBody().asString(), GetCartDataModel.class);
            for(int i = 0; i< getCartDataModel.getOrder().getLine_items().size(); i++){
                //System.out.println(getCartDataModel.getOrder().getLine_items().size()+"items in cart");
                productID.add( getCartDataModel.getOrder().getLine_items().get(i).getProduct_id());
                price.add(getCartDataModel.getOrder().getLine_items().get(i).getLifting_price());
                quantity.add(getCartDataModel.getOrder().getLine_items().get(i).getQuantity());
            }
            productDetails.put("ProductID",productID);
            productDetails.put("Price", price);
            productDetails.put("Quantity", quantity);
            //System.out.println(productDetails);
            return productDetails;
    }

    public Map<String , List<Object>> getProductDetailsOfItemsInPLPPage(String item){
        Map<String , List<Object>> productDetails = new HashMap<>();
        List<Object> productId = new ArrayList<>();
        List<Object> price = new ArrayList<>();
        List<Object> quantity = new ArrayList<>();
        response = shopUpPostMan.getCall(EndPoints.SEARCH_FOR_USER+ "term="+item+"&page=1");
        ProductListingResultsModel productListingResultsModel = gson.fromJson(response.getBody().asString(),ProductListingResultsModel.class);
        for(int i=0;i<productListingResultsModel.getResults().size();i++){
            productId.add(productListingResultsModel.getResults().get(i).getProduct_id());
            price.add(productListingResultsModel.getResults().get(i).getSizes().get(0).getPrice());
            quantity.add(productListingResultsModel.getResults().get(i).getSizes().get(0).getCount_on_hand());
        }
        productDetails.put("ProductID",productId);
        productDetails.put("Price",price);
        productDetails.put("Quantity",quantity);
        return productDetails;
    }

}


