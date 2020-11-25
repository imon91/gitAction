package services.commerceMethods;

import com.google.gson.Gson;
import coreUtils.CoreConstants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import services.responseModels.commerceModels.*;
import services.serviceUtils.*;
import java.util.*;
import static services.serviceUtils.ApiKeyConstants.FiltersNewKeys.*;


public class GetCommerceApiResponse {

    private ShopUpPostMan shopUpPostMan;
    private final String module;
    private Gson gson;
    private Response response;

    public GetCommerceApiResponse(String module){
        this.module = module;
        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
    }

    public ListOfCollectionsModel getListOfCollectionsData(){
        gson = new Gson();
        if(module.equalsIgnoreCase(CoreConstants.MODULE_MOBILE_WEB_UI ) ||
                module.equalsIgnoreCase(CoreConstants.MODULE_WEB_UI)){
            ListOfCollectionsModel listOfCollections =
                    gson.fromJson(response.getBody().asString(), ListOfCollectionsModel.class);
            System.out.println(listOfCollections.getUser_collections().size());
            return listOfCollections;
        }else {
            ListOfCollectionsModel listOfCollections =
                    gson.fromJson(response.getBody().asString(), ListOfCollectionsModel.class);
            System.out.println("Here : "+listOfCollections.getUser_collections().size());
            return listOfCollections;
        }
    }


    public HashMap<String,HashMap<String,List<String>>> getFiltersDataMap(String searchName) {
        shopUpPostMan = new ShopUpPostMan(module);
        HashMap<String, HashMap<String, List<String>>> filtersMap = new HashMap<>();
        gson = new Gson();
        if (!module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            response = shopUpPostMan.
                    getCall(EndPoints.SEARCH_FOR_USER + "term=" + searchName + "&limit=24&page=1");

            /*------- Category-----*/
            HashMap<String, List<String>> categoryMap = new HashMap<>();

            List<List<String>> categoryLabelsList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.category.label");
            categoryMap.put(KEY_LABEL, categoryLabelsList.get(0));
            List<List<String>> categoryIdList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.category.id");
            categoryMap.put(KEY_ID, categoryIdList.get(0));
            List<List<String>> categoryImageList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.category.image");
            categoryMap.put(KEY_IMAGE, categoryImageList.get(0));
            List<List<String>> categoryQueryList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.category.query");
            categoryMap.put(KEY_QUERY, categoryQueryList.get(0));
            List<List<String>> categorySlugList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.category.slug");
            categoryMap.put(KEY_SLUG, categorySlugList.get(0));

            filtersMap.put(KEY_CATEGORY, categoryMap);

            /*-------Sub-Category-----*/
            filtersMap.put(KEY_SUB_CATEGORY, null);

            /*-------Price-----*/

            HashMap<String, List<String>> priceMap = new HashMap<>();

            List<List<String>> priceAvgPriceList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.price.avg_price");
            priceMap.put(KEY_AVG_PRICE, priceAvgPriceList.get(0));
            List<List<String>> priceIdList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.price.id");
            priceMap.put(KEY_ID, priceIdList.get(0));
            List<List<String>> priceLabelList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.price.label");
            priceMap.put(KEY_LABEL, priceLabelList.get(0));
            List<List<String>> priceQueryList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.price.query");
            priceMap.put(KEY_QUERY, priceQueryList.get(0));

            filtersMap.put(KEY_PRICE, priceMap);


            /*-------Brand-----*/
            filtersMap.put(KEY_BRAND, null);

            /*-------Size-----*/

            filtersMap.put(KEY_SIZE, null);

            /*-------Color-----*/
            filtersMap.put(KEY_COLOR, null);

            /*-------Discount-----*/

            HashMap<String, List<String>> discountMap = new HashMap<>();

            List<List<String>> discountIdList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.discount.id");
            discountMap.put(KEY_ID, discountIdList.get(0));
            List<List<String>> discountLabelList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.discount.label");
            discountMap.put(KEY_LABEL, discountLabelList.get(0));
            List<List<String>> discountQueryList =
                    JsonPath.from(response.getBody().asString()).get("filters_new.discount.query");
            discountMap.put(KEY_QUERY, discountQueryList.get(0));

            filtersMap.put(KEY_DISCOUNT, discountMap);

            /*-------Offers-----*/
            filtersMap.put(KEY_OFFERS, null);

            /*-------Gender-----*/
            filtersMap.put(KEY_GENDER, null);

            return filtersMap;
        }else {
            System.out.println("Filters Data not available for module : "+module);
            return null;
        }
    }



    public List<String> getListOfSortItems(String searchName) {
        if (!module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            response = shopUpPostMan.
                    getCall(EndPoints.SEARCH_FOR_USER + "term=" + searchName + "&limit=24&page=1");
            List<String> sortItems = new ArrayList<>();
            List<Collection<String>> sortItemsList = new ArrayList();
            List<List<LinkedHashMap<String, String>>> sortData =
                    JsonPath.from(response.getBody().asString()).get("sort.sort");
            for (int i = 0; i < sortData.get(0).size(); i++) {
                sortItemsList.add(sortData.get(0).get(i).values());
            }
            for (int j = 0; j < sortItemsList.size(); j++) {
                Collection<String> data = sortItemsList.get(j);
                sortItems.add((String) data.toArray()[0]);
            }
            return sortItems;
        }else {
            return null;
        }
    }


    public Map<String,Object> getProductWithValidSize(String searchName){
        Map<String,Object> productDetailsMap = new HashMap<>();
        for(int k=1;k<10;k++){
            if (!module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
                response = shopUpPostMan.
                        getCall(EndPoints.SEARCH_FOR_USER + "term=" + searchName
                                + "&limit=24&page="+k+"");
                //response.then().log().all();
                ProductListingResultsModel productListingResultsModel =
                        gson.fromJson(response.getBody().asString(),ProductListingResultsModel.class);
                for(int i=0;i<productListingResultsModel.getResults().size();i++) {
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
                                return productDetailsMap;
                            }
                        }
                    }
                }
            }else {
                System.out.println("No products with valid size were available in search : "+k);
            }
        }
        return null;
    }


    public Map<String,Object> getValidProductWithFilterAndSortApplied(String searchTerm,String filterKey,
                                                        String filterId,String sortIndex) {

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
        Map<String, Object> productDetailsMap = new HashMap<>();
        for (int k = 1; k < 10; k++) {
            response = shopUpPostMan.
                    getCall(EndPoints.SEARCH_FOR_USER +
                            "term=" + searchTerm +
                            "&page="+k+"&" + createdFilter + "=" + filterId + "&" + createdSort + "=" + sortIndex);
            //response.then().log().all();
            ProductListingResultsModel productListingResultsModel =
                    gson.fromJson(response.getBody().asString(), ProductListingResultsModel.class);
            for (int i = 0; i < productListingResultsModel.getResults().size(); i++) {
                List<ProductListingResultsModel.ResultsBean.SizesBean> productSizes =
                        productListingResultsModel.getResults().get(i).getSizes();
                if(productSizes.size()<6){
                    for (int j = 0; j < productSizes.size(); j++) {
                        if (productSizes.get(j).getCount_on_hand() > 0 &&
                                productSizes.get(j).getCorrected_count_on_hand() > 0) {
                            // This is a product with valid
                            productDetailsMap.put("ValidProductIndex", i);
                            productDetailsMap.put("ValidProductDetails", productListingResultsModel.getResults().get(i));
                            productDetailsMap.put("ValidSizeIndex", j);
                            System.out.println(productListingResultsModel.getResults().get(i));
                            return productDetailsMap;
                        }
                    }
                }
            }
        }
        return null;
    }



    public void getProductWithInValidSize(){

    }


    public ProductDescriptionModel getProductDescription(String slug){
        if (!module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            response = shopUpPostMan.
                    getCall(EndPoints.RECOMMENDATIONS +slug+".json");
            ProductDescriptionModel productDescriptionModel =
                    gson.fromJson(response.getBody().asString(),ProductDescriptionModel.class);
            return productDescriptionModel;
        }else {
            System.out.println("Product Description is not available for this module : "+module);
            return null;
        }
    }


    public LoggedInUserDataModel getLoggedInUserData(){
        if (!module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            response = shopUpPostMan.
                    getCall(EndPoints.APP_PREFERENCES +EndPoints.LOGGED_IN_USER_DATA_JSON);
            LoggedInUserDataModel loggedInUserDataModel =
                    gson.fromJson(response.getBody().asString(),LoggedInUserDataModel.class);
            return loggedInUserDataModel;
        }else {
            System.out.println("LoggedIn User Details is not available for this module : "+module);
            return null;
        }
    }


    // This methods returns Category,Sub-Category pair as a List<String> respectively.
    public List<String> getValidCategoryPair() {

        response = shopUpPostMan.
                getCall(EndPoints.APP_PREFERENCES +EndPoints.LOGGED_IN_USER_DATA_JSON);
        LoggedInUserDataModel loggedInUserDataModel =
                gson.fromJson(response.getBody().asString(),LoggedInUserDataModel.class);
        //System.out.println(loggedInUserDataModel.getMain_menu().size());
        Map<Integer,String> dataMain = new HashMap<>();
        Map<Integer,String> dataSub = new HashMap<>();
        for(int i=1;i<loggedInUserDataModel.getMain_menu().size();i++){
            try {
                if(loggedInUserDataModel.getMain_menu().get(i)
                        .getIs_low_level().equalsIgnoreCase("true")){
                    dataSub.put(i,loggedInUserDataModel.getMain_menu().get(i).getLabel());
                }
            }catch (Exception e){
                dataMain.put(i,loggedInUserDataModel.getMain_menu().get(i).getLabel());
            }
        }
        Object[] mainDataSet = dataMain.keySet().toArray();
        List mainCategoryIndices = Arrays.asList(mainDataSet);
        Collections.sort(mainCategoryIndices);

        Object[] subDataSet = dataSub.keySet().toArray();
        List subCategoryIndices = Arrays.asList(subDataSet);
        Collections.sort(subCategoryIndices);

//        System.out.println(mainCategoryIndices);
//        System.out.println(subCategoryIndices);
//
//
//        List<LinkedHashMap> mainCategoryIndices =
//                JsonPath.from(response.getBody().asString()).param("is_category","true")
//                        .get("main_menu.findAll { main_menu -> main_menu.is_category == is_category}");
//        List<String> mainCategoryLabels = new ArrayList<>();
//        for(int i=0;i<mainCategoryIndices.size();i++){
//            mainCategoryLabels.add(mainCategoryIndices.get(i).get("label").toString());
//        }

        // Select a Random SubCategory
        int randomSubCategoryIndex = new Random().nextInt(subCategoryIndices.size());
        int actualSubCategory = (int)subCategoryIndices.get(randomSubCategoryIndex);
        // Find the nearest Category
        //System.out.println(actualSubCategory);
        int actualCategory=0;
        for(int i=0;i<mainCategoryIndices.size();i++){
            if(actualSubCategory > (int)mainCategoryIndices.get(i)){
                actualCategory = (int)mainCategoryIndices.get(i);
            }
        }
//        System.out.println("Category is : "+actualCategory+
//                ", subCategory is : "+actualSubCategory);
        List<String> finalData = new ArrayList<>();
        finalData.add(loggedInUserDataModel.getMain_menu().get(actualCategory).getLabel()); // Category
        finalData.add(loggedInUserDataModel.getMain_menu().get(actualSubCategory).getLabel()); // Sub-Category
        return finalData;
    }


    public void getOrderDetails(){
        response = shopUpPostMan.
                getCall(EndPoints.APP_PREFERENCES +EndPoints.LOGGED_IN_USER_DATA_JSON);
        LoggedInUserDataModel loggedInUserDataModel =
                gson.fromJson(response.getBody().asString(),LoggedInUserDataModel.class);
    }


    public List<Integer> getCodNotAvailableItemsFromShoppingCart(){
        List<Integer> codNotAvailableItemIndices = new ArrayList<>();
        response = shopUpPostMan.
                getCall(EndPoints.SHOPPING_CART_JSON);
        ShoppingCartResponseModel shoppingCartResponseModel =
                gson.fromJson(response.getBody().asString(),ShoppingCartResponseModel.class);
//        System.out.println("Shopping Cart Item Size is : "+shoppingCartResponseModel.getCart_items().size());
        for(int i=0;i<shoppingCartResponseModel.getCart_items().size();i++){
            if(!shoppingCartResponseModel.getCart_items().get(i).isCod_availability()){
                codNotAvailableItemIndices.add(i);
            }
        }
        return codNotAvailableItemIndices;
    }

    public String getRandomArea(){
        response = shopUpPostMan.getCall(EndPoints.SHOPPING_CART+EndPoints.LOCALITY_DATA_JSON);
        MokamLocalityListModel mokamLocalityListModel =
                gson.fromJson(response.getBody().asString(),MokamLocalityListModel.class);
        Random random = new Random();
        int randomArea = random.nextInt(mokamLocalityListModel.getResults().size());
        return mokamLocalityListModel.getResults().get(randomArea).getCity();
    }

    public int getIdOfAddress(int index){
        response = shopUpPostMan.getCall("user/get_addresses.json");
        MokamUserAddressesModel mokamUserAddressesModel =
                gson.fromJson(response.getBody().asString(),MokamUserAddressesModel.class);
        return mokamUserAddressesModel.getShipped_addresses().get(index).getId();
    }

    public List<String> getAddressDetails(int addressId){
        List<String> addressDetailsList = new ArrayList<>();
        Map object = new HashMap();
        object.put("address_id",""+addressId);
        response = shopUpPostMan.postCall("shopping_cart/associate_order_address.json",object);
        MokamAssociateAddressModel mokamAssociateAddressModel =
                gson.fromJson(response.getBody().asString(),MokamAssociateAddressModel.class);
        addressDetailsList.add(0,mokamAssociateAddressModel.getOrder_address().getAddress().getFirstname());
        addressDetailsList.add(1,mokamAssociateAddressModel.getOrder_address().getAddress().getAddress1());
        return addressDetailsList;
    }

    public List<Double> getCreditAndDebitValue(){
        List<Double> valueList = new ArrayList<>();
        response = shopUpPostMan.getCall("index.json");
        MokamHomePageModel mokamHomePageModel =
                gson.fromJson(response.getBody().asString(),MokamHomePageModel.class);
        valueList.add(0,mokamHomePageModel.getCollections().get(0).getItems().get(0).getConfig().getTotalCredit());
        valueList.add(1,mokamHomePageModel.getCollections().get(0).getItems().get(0).getConfig().getTotalDebit());
        return valueList;
    }

    public int getBakiAmount(){
        int bakiAmount = 0;
        response = shopUpPostMan.getCall("index.json");
        MokamHomePageModel mokamHomePageModel =
                gson.fromJson(response.getBody().asString(),MokamHomePageModel.class);
        for (int i=0;i<mokamHomePageModel.getCollections().size();i++){
            if (mokamHomePageModel.getCollections().get(i).getTitle().equalsIgnoreCase("Baki")){
                bakiAmount = mokamHomePageModel.getCollections().get(i).getItems().get(0).getConfig().getAvailableCredit();
            }
        }
        return bakiAmount;
    }

    public List<MokamHomePageModel.CollectionsBean> getCollections(){
        response = shopUpPostMan.getCall("index.json");
        MokamHomePageModel mokamHomePageModel =
                gson.fromJson(response.getBody().asString(),MokamHomePageModel.class);
        return mokamHomePageModel.getCollections();
    }



}
