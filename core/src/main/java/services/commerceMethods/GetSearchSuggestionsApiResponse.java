package services.commerceMethods;

import com.google.gson.Gson;
import io.restassured.response.Response;
import services.responseModels.commerceModels.*;
import services.serviceUtils.ShopUpPostMan;
import java.util.*;



public class GetSearchSuggestionsApiResponse {
    private ShopUpPostMan shopUpPostMan;
    private String module;
    private Gson gson;
    private Response response;


    public GetSearchSuggestionsApiResponse(String module) {
        this.module = module;
        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
    }



    //this list gives the search suggestion list -title,inlineLabel
    public List<SearchSuggestionsModel.ResultsBean.SuggestionsBean> searchSuggestionsList() {
        response = shopUpPostMan.getCall("search_terms/search_suggestions?term=shirt");
        SearchSuggestionsModel searchSuggestionsModel = gson.fromJson(response.getBody().asString(), SearchSuggestionsModel.class);
        return searchSuggestionsModel.getResults().getSuggestions();

    }



    //gives the result of recent product
    public List<SearchRecentProductsModel.ResultsBean> getResultsOfRecentProducts()
    {
        response = shopUpPostMan.getCall("recently-viewed.json?per_page=12");
        SearchRecentProductsModel searchRecentProductsModel = gson.fromJson(response.getBody().asString(),SearchRecentProductsModel.class);
        return searchRecentProductsModel.getResults();
    }







}



