package pageObjects;

import coreUtils.BuildParameterKeys;
import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import services.commerceMethods.GetSearchSuggestionsApiResponse;
import services.responseModels.commerceModels.ProductListingResultsModel;
import utils.*;
import java.util.*;

public class SearchPageObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private ServiceRequestLayer serviceRequestLayer;
    private GetSearchSuggestionsApiResponse getSearchSuggestionsApiResponse;
    private String app;


    public SearchPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
        serviceRequestLayer = new ServiceRequestLayer();
        getSearchSuggestionsApiResponse = serviceRequestLayer.getControlOverSearchSuggestionsApi();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
    }




    // Back Button
    private WebElement searchBackButton;

    // Search EditText
    private WebElement searchBarEditText;

    // Search Button
    private WebElement searchButton;

    // Search Cancel Button
    private WebElement searchCancelButton;

    // Recent Searches TextView
    private List<WebElement> recentSearchesText;

    // Recent Suggestions RecyclerView
    private WebElement recentSuggestionsRecycler;




    /*--------------Actions-------------------*/

    public void clickOnSearchBackButton(){
        searchBackButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnBack']");
        myActions.action_click(searchBackButton);
    }

    public void enterProductName(String product){
        searchBarEditText = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/etSearch']");
        myActions.action_sendKeys(searchBarEditText,product);
    }

    public void clickOnSearchButton(String product){
        searchButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnSearch']");
        myActions.action_click(searchButton);
        // search_for_users_call to update DynamicData
        try {
            PropertyReader.setValue(PropertyReader.Keys.SEARCH_TERM,product);
            Map<String,Object> responseData = serviceRequestLayer.getControlOverServices()
                    .getProductWithValidSize(product);
            ProductListingResultsModel.ResultsBean resultsModel =
                    (ProductListingResultsModel.ResultsBean)responseData.get("ValidProductDetails");
            System.out.println("PLP VIEW TYPE : "+resultsModel.getPlp_view_type());
            if(resultsModel.getPlp_view_type()==2) {
                PropertyReader.setValue(PropertyReader.Keys.CATEGORY_TYPE, AndroidAppConstants.CATEGORY_TYPE_ESSENTIAL);
                PropertyReader.setValue(PropertyReader.Keys.PLP_VIEW_TYPE, "2");
            }
            else {
                PropertyReader.setValue(PropertyReader.Keys.CATEGORY_TYPE, AndroidAppConstants.CATEGORY_TYPE_NON_ESSENTIAL);
                PropertyReader.setValue(PropertyReader.Keys.PLP_VIEW_TYPE, "1");
            }
        }catch (Exception e){
            System.out.println("Exception At EnterProductName : Adding SEARCH_TERM to DynamicData");
        }
//        try{
//            Map<String,Object> responseData = serviceRequestLayer.getControlOverServices()
//                    .getProductWithValidSize(PropertyReader.getValueOfKey(PropertyReader.Keys.SEARCH_TERM));
////            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_INDEX,
////                    Integer.toString((int)responseData.get("ValidProductIndex")));
//            ProductListingResultsModel.ResultsBean resultsModel =
//                    (ProductListingResultsModel.ResultsBean)responseData.get("ValidProductDetails");
//            if(resultsModel.getPlp_view_type()==2)
//                PropertyReader.setValue(PropertyReader.Keys.CATEGORY_TYPE,AndroidAppConstants.CATEGORY_TYPE_ESSENTIAL);
//            else
//                PropertyReader.setValue(PropertyReader.Keys.CATEGORY_TYPE,AndroidAppConstants.CATEGORY_TYPE_NON_ESSENTIAL);
//            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_NAME,resultsModel.getName());
//            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_SLUG,resultsModel.getSlug());
//            PropertyReader.setValue(PropertyReader.Keys.VALID_SIZE_INDEX,
//                    Integer.toString((int)responseData.get("ValidSizeIndex")));
//        }catch (Exception e){
//            System.out.println("Exception At ClickOnSearchButton : Updating SEARCH_RESULT to DynamicData");
//            System.out.println(e);
//        }
    }

    public void clickOnSearchCancelButton(){
        searchCancelButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/imgClear]");
        myActions.action_click(searchCancelButton);
    }

    public List<WebElement> getListOfRecentSearchesText(){
        recentSearchesText =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/trending']");
        return recentSearchesText;
    }

    public void getSuggestionsRecycler(){
        recentSuggestionsRecycler =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/suggestions_recycler_recent']");
    }


    /*----Functions*/

    public void searchForTheGivenProduct(String productName){
            enterProductName(productName);
            clickOnSearchButton(productName);
    }

    public void enterTheProductNameAndCancel(String productName){
        enterProductName(productName);
        clickOnSearchCancelButton();
    }

    public void enterTheProductNameGoBack(String productName){
        enterProductName(productName);
        clickOnSearchBackButton();
    }
    public List<WebElement> searchSuggestionTitleList()
    {
        List<WebElement> suggestionTitleList = androidDriver.findElements(By.id("com.shopup.reseller:id/text"));
        return suggestionTitleList;
    }

    public List<WebElement> searchSuggestionInLineLabelList()
    {
        List<WebElement> suggestionTitleList = androidDriver.findElements(By.id("com.shopup.reseller:id/inlineLabel"));
        return suggestionTitleList;
    }

    public List<WebElement> searchRecentProductsNameList()
    {
        List<WebElement> nameList = androidDriver.findElements(By.id("com.shopup.reseller:id/tvName"));
        return nameList;
    }

    public String getSearchSuggestion(int suggestionIndex,String title_or_inline) {
        String suggestionText = null;
        System.out.println("the size of list was :"+searchSuggestionTitleList().size());
        if(suggestionIndex>=0&&title_or_inline=="title") {
            suggestionText = myActions.action_getText(searchSuggestionTitleList().get(suggestionIndex));
            return suggestionText;
        }
        else if(suggestionIndex>=0&&title_or_inline=="inLineLabel")
        {
            suggestionText = myActions.action_getText(searchSuggestionInLineLabelList().get(suggestionIndex));
            return suggestionText;
        }
        else {
            System.out.println("Please specify the proper litter 'title'_or_'inLineLabel'");
        return null;
        }

    }

    public String clickOnSearchSuggestion(int suggestionIndex)
    {
        List<WebElement> suggestionTitleList = androidDriver.findElements(By.id("com.shopup.reseller:id/text"));
        String suggestionText = null;
        if(suggestionIndex>=0) {
            suggestionText = myActions.action_getText(suggestionTitleList.get(suggestionIndex));
            myActions.action_click(suggestionTitleList.get(suggestionIndex));
        }
        return suggestionText;
    }


    public String getSuggestionFromApi(int suggestionIndex,String title_0r_inLineLabel)
    {
        Map<String,List<String>> hashMapOfSuggestion = getSearchSuggestionsApiResponse.searchSuggestionMap(title_0r_inLineLabel);
        List<String> titleList = hashMapOfSuggestion.get(title_0r_inLineLabel);
        return titleList.get(suggestionIndex);

    }


    public List<String> getNamesOfRecentProductsFromApiList()
    {
        List<String> namesOfProducts = getSearchSuggestionsApiResponse.getNamesOfRecentProducts();
        return namesOfProducts;

    }

    public boolean scrollToElement(String productName)
    {

        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/recyclerRecentlyViewed\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().text(\""+productName+ "\"))"));
        String text =element.getText();
        return true;
    }






}
