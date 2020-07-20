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


    //this map gives the search suggestion list -title,inlineLabel
    public Map<String, List<String>> searchSuggestionMap(String suggestionTitle) {

        Map<String, List<String>> titleName1 = new HashMap<>();
        List<String> titlelist = new ArrayList<>();
        response = shopUpPostMan.getCall("search_terms/search_suggestions?term=shirt");
        SearchSuggestionsModel searchSuggestionsModel = gson.fromJson(response.getBody().asString(), SearchSuggestionsModel.class);

        if (suggestionTitle.equalsIgnoreCase("title")) {
            for (int i = 0; i < searchSuggestionsModel.getResults().getSuggestions().size(); i++) {
                String titleName = searchSuggestionsModel.getResults().getSuggestions().get(i).getValue().getTitle();
                titlelist.add(titleName);
            }

            titleName1.put("title", titlelist);
            return titleName1;
        }
         else if((suggestionTitle.equalsIgnoreCase("inLineLabel"))){
            //to get size of "type:category"
            for (int j = 0; j < searchSuggestionsModel.getResults().getSuggestions().size(); j++)
            {
                if (searchSuggestionsModel.getResults().getSuggestions().get(j).getType().equalsIgnoreCase("category"))
                {
                    String titleName = searchSuggestionsModel.getResults().getSuggestions().get(j).getValue().getInline_label();
                    titlelist.add(titleName);
                }
            }
            titleName1.put("inLineLabel", titlelist);
            return titleName1;
        }
         else {
            System.out.println("Please specify correct letter 'title' or 'inLineLabel'");
            return null;
        }

    }




    //give the name of recent product
    public List<String> getNamesOfRecentProducts()
    {
        List<String> productsName = new ArrayList<>();
        response = shopUpPostMan.getCall("recently-viewed.json?per_page=12");
        SearchRecentProductsModel searchRecentProductsModel = gson.fromJson(response.getBody().asString(),SearchRecentProductsModel.class);

        for(int i=0;i<searchRecentProductsModel.getResults().size();i++) {

            String name = searchRecentProductsModel.getResults().get(i).getName();
            productsName.add(name);
        }

        return productsName;
    }




}



